package net.lnworks.monitor.controll;

import lombok.extern.java.Log;
import net.lnworks.monitor.domain.InstMngVO;
import net.lnworks.monitor.domain.LoginVO;
import net.lnworks.monitor.domain.MenuManageVO;
import net.lnworks.monitor.domain.StudyInfoMngVO;
import net.lnworks.monitor.domain.study.*;
import net.lnworks.monitor.service.member.MemberLoginService;
import net.lnworks.monitor.service.menu.MenuConfigService;
import net.lnworks.monitor.service.study.AEMntmgService;
import net.lnworks.monitor.service.study.StudyMngService;
import net.lnworks.monitor.util.DataListMap;
import net.lnworks.monitor.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;


@Controller
@Log
@RequestMapping("/aemonitor/")
public class StartController {
    private static final String TAG_USER = "USERINFO";

    @Autowired
    private MemberLoginService memberLoginService;

    @Autowired
    private MenuConfigService menuConfigService;

    @Autowired
    private StudyMngService studyMngService;

    @Autowired
    private AEMntmgService aeMntmgService;

    @Value("${Globals.IntnetSys}")
    private String intnetSys;

    @RequestMapping(value = "/aeChartView")
    public ModelAndView goAEChartView(@RequestParam (value = "studyId") String studyId,
                                      @RequestParam (value = "prtcpntId") String prtcpntId,
                                      @RequestParam (value = "sumrySeq") int sumrySeq,
                                      @RequestParam (value = "mntrngSeq") int mntrngSeq) throws Exception {

        ModelAndView mav = new ModelAndView();
        AEMMntrngVO inAemMntrngVO = new AEMMntrngVO();
        inAemMntrngVO.setStudyId(studyId);
        inAemMntrngVO.setPrtcpntId(prtcpntId);
        inAemMntrngVO.setSumrySeq(sumrySeq);
        inAemMntrngVO.setMntrngSeq(mntrngSeq);

        AEMMntrngVO  OutAemMntrngVO =  aeMntmgService.selectAEMntrngView(inAemMntrngVO);

        mav.addObject("aemMntrngVO", OutAemMntrngVO);
        mav.setViewName("content/study/aeChartUI.html");

        return mav;
    }

    @RequestMapping(value = "/symptms")
    public ModelAndView goSymptms(@RequestParam (value = "studyId") String studyId,
                                  @RequestParam (value = "prtcpntId") String prtcpntId,
                                  @RequestParam (value = "symptmsSeq") int symptmsSeq) throws Exception {

        ModelAndView mav = new ModelAndView();

        //참여자 증상 목록
        AEMntrngSymptmsParamVO aeMntrngSymptmsParamVO = new AEMntrngSymptmsParamVO();

        aeMntrngSymptmsParamVO.setStudyId(studyId);
        aeMntrngSymptmsParamVO.setPrtcpntId(prtcpntId);
        aeMntrngSymptmsParamVO.setSymptmsSeq(symptmsSeq);
        AEMPrtcpntSymptmsVO aemPrtcpntSymptmsVO = aeMntmgService.selectSymptms(aeMntrngSymptmsParamVO);

        if ( aemPrtcpntSymptmsVO != null ) {
            if ( aemPrtcpntSymptmsVO.getSymptmsRegtypeCode().equals("110") ||
                    aemPrtcpntSymptmsVO.getSymptmsRegtypeCode().equals("120") ||
                    aemPrtcpntSymptmsVO.getSymptmsRegtypeCode().equals("130") ){
                List<DataListMap> fileDetailList = aeMntmgService.fileDetailList(aemPrtcpntSymptmsVO);

                mav.addObject("fileDetailList", fileDetailList);

                List<DataListMap> filepathMap = aeMntmgService.getSysSetupFileList();
                if ( filepathMap.size() > 0 ) {
                    for (DataListMap filepath : filepathMap) {
                       if ( filepath.get("setupitemCode").toString().equals("FILE_UPLOAD_DIR")) {
                           mav.addObject("filepath", filepath.get("setupitemVal").toString());
                           break;
                       }
                    }
                }
            }
        }

        mav.addObject("aemPrtcpntSymptmsVO", aemPrtcpntSymptmsVO);
        mav.setViewName("content/study/aemPrtcpntSymptmsVO.html");

        return mav;
    }

    @RequestMapping(value = "/examlist")
    public ModelAndView goExamlist(HttpServletRequest request, Principal principal) throws Exception {
        ModelAndView mav = new ModelAndView();

        //사용자의 uniqId를 이용하여 처리 (AS-IS는 userId와 사용이 혼제되어 있음)
        log.info(TAG_USER + " : " +  principal.getName());
        LoginVO userVo = new LoginVO();
        userVo.setUniqId(principal.getName());

        //사용자정보
        DataListMap userInfoMap = memberLoginService.getUserInfo(userVo);
        DataListMap userAuthorityMap = memberLoginService.getUserauthority(userVo);
        //userVo.setUniqId(userInfoMap.get("esntlId").toString());

        //메뉴정보
        MenuManageVO menuManageVO = new MenuManageVO();
        menuManageVO.setTmpUniqId(userInfoMap.get("esntlId").toString());
        menuManageVO.setMode("admin");
        menuManageVO.setIntnetSysAt(intnetSys);
        List<DataListMap> menuOneDepthMap = menuConfigService.getLevelOneMenuList(menuManageVO);
        List<DataListMap> menuAllDepthMap = menuConfigService.getLevelAllMenuList(menuManageVO);

        //연구정보
        List<StudyInfoMngVO> studyInfoList =  studyMngService.selectMainStudyList(userVo);
        List<InstMngVO> studyInstInfoList = null;
        List<AEMStdyPrtcpntVO> aemStdyPrtcpntVOList = null;
        if ( studyInfoList != null && studyInfoList.size() > 0 ) {
            studyInstInfoList = studyMngService.selectMainInstList(studyInfoList.get(0));
            if ( studyInstInfoList != null && studyInstInfoList.size() > 0 ) {
                AEMntrngParamVO aeMntrngParamVO = new AEMntrngParamVO();
                aeMntrngParamVO.setAllAt("Y"); //전체검색
                aeMntrngParamVO.setTodayAt("N"); //당일방문예정
                aeMntrngParamVO.setSearchCnd(""); //구분
                aeMntrngParamVO.setSearchWrd(""); //검색어
                aeMntrngParamVO.setStartDe(DateTimeUtil.getNowDate());
                aeMntrngParamVO.setEndDe(DateTimeUtil.getNowDate());
                aeMntrngParamVO.setStudyId(studyInstInfoList.get(0).getStudyId());
                aeMntrngParamVO.setStdyInstId(studyInstInfoList.get(0).getStdyInstId());
                aemStdyPrtcpntVOList = aeMntmgService.selectPrtcpntList(aeMntrngParamVO);
            }
        }

        mav.addObject("userinfo", userInfoMap);
        mav.addObject("menuTitle", "AE모니터링");
        mav.addObject("userAuthority", userAuthorityMap);
        mav.addObject("menuOneDepth", menuOneDepthMap);
        mav.addObject("menuAllDepth", menuAllDepthMap);
        mav.addObject("studyInfoList", studyInfoList);
        mav.addObject("studyInstInfoList", studyInstInfoList);
        mav.addObject("aemStdyPrtcpntVOList", aemStdyPrtcpntVOList);

        mav.setViewName("content/main.html");

        return mav;
    }
}

