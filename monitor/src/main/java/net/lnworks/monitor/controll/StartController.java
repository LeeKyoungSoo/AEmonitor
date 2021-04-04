package net.lnworks.monitor.controll;

import lombok.extern.java.Log;
import net.lnworks.monitor.domain.InstMngVO;
import net.lnworks.monitor.domain.LoginVO;
import net.lnworks.monitor.domain.MenuManageVO;
import net.lnworks.monitor.domain.StudyInfoMngVO;
import net.lnworks.monitor.domain.study.AEMStdyPrtcpntVO;
import net.lnworks.monitor.domain.study.AEMntrngParamVO;
import net.lnworks.monitor.service.member.MemberLoginService;
import net.lnworks.monitor.service.menu.MenuConfigService;
import net.lnworks.monitor.service.study.AEMntmgService;
import net.lnworks.monitor.service.study.StudyMngService;
import net.lnworks.monitor.util.DataListMap;
import net.lnworks.monitor.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping(value = "/examlist")
    public ModelAndView goHome(HttpServletRequest request, Principal principal) throws Exception {
        ModelAndView mav = new ModelAndView();

        log.info(TAG_USER + " : " +  principal.getName());
        LoginVO userVo = new LoginVO();
        userVo.setId(principal.getName());

        //사용자정보
        DataListMap userInfoMap = memberLoginService.getUserInfo(userVo);
        DataListMap userAuthorityMap = memberLoginService.getUserauthority(userVo);
        userVo.setUniqId(userInfoMap.get("esntlId").toString());

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

