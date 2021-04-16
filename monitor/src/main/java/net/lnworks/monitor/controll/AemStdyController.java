package net.lnworks.monitor.controll;

import net.lnworks.monitor.domain.study.*;
import net.lnworks.monitor.service.study.AEMntmgService;
import net.lnworks.monitor.service.study.PcnctcAEService;
import net.lnworks.monitor.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/aemonitorapi/")
public class AemStdyController {
    @Autowired
    private AEMntmgService aeMntmgService;

    @Autowired
    private PcnctcAEService pcnctcaeService;

    @PostMapping("/aeChartInsert")
    public int goAEChartInsert(AEMMntrngVO aemMntrngVO, Principal principal) throws Exception {
        int returnNum = 0;
        aemMntrngVO.setFrstRegisterId(principal.getName());
        aemMntrngVO.setLastUpdusrId(principal.getName());
        returnNum = aeMntmgService.insertAEMSumry(aemMntrngVO);

        return returnNum;
    }

    @PostMapping("/aeChartUpdate")
    public int goAEChartUpdate(AEMMntrngVO aemMntrngVO, Principal principal) throws Exception {
        int returnNum = 0;
        aemMntrngVO.setFrstRegisterId(principal.getName());
        aemMntrngVO.setLastUpdusrId(principal.getName());
        returnNum = aeMntmgService.updateAEMSumry(aemMntrngVO);

        if (aemMntrngVO.getMntrngDcsnAt() != null && aemMntrngVO.getMntrngDcsnAt().equals("Y")) {
            aemMntrngVO.setMntrngDcsnEsntlId(principal.getName());
        }

        if (aemMntrngVO.getActionDcsnAt() != null && aemMntrngVO.getActionDcsnAt().equals("Y")) {
            aemMntrngVO.setActionDcsnEsntlId(principal.getName());
        }

        if (aemMntrngVO.getActionDcsnAt() != null && !aemMntrngVO.getUseYn().equals("N") ) {
            aeMntmgService.insertAEMMntrng(aemMntrngVO);
        }

        return returnNum;
    }

    @PostMapping("/symptmsInsert")
    public int goSymptmsInsert(AEMPrtcpntSymptmsVO aemPrtcpntSymptmsVO, Principal principal) throws Exception {
        int returnNum = 0;
        aemPrtcpntSymptmsVO.setFrstRegisterId(principal.getName());
        aemPrtcpntSymptmsVO.setLastUpdusrId(principal.getName());
        returnNum = aeMntmgService.insertSymptms(aemPrtcpntSymptmsVO);

        return returnNum;
    }

    @PostMapping("/symptmsDelete")
    public int goSymptmsDelete(AEMPrtcpntSymptmsVO aemPrtcpntSymptmsVO) throws Exception {
        int returnNum = 0;
        returnNum = aeMntmgService.deleteSymptms(aemPrtcpntSymptmsVO);
        return returnNum;
    }

    @PostMapping("/symptmsUpdate")
    public int goSymptmsUpdate(AEMPrtcpntSymptmsVO aemPrtcpntSymptmsVO, Principal principal) throws Exception {
        int returnNum = 0;
        aemPrtcpntSymptmsVO.setLastUpdusrId(principal.getName());
        returnNum = aeMntmgService.updateSymptms(aemPrtcpntSymptmsVO);

        return returnNum;
    }

    @GetMapping("/pcnctcaeGrade")
    public PcnctcAEVO goPcnctcaeGrade(@RequestParam (value = "ctcaeVer") String ctcaeVer,
                                      @RequestParam (value = "medDraCode") String medDraCode) throws Exception {

        PcnctcAEVO pcnctcAEVOIn = new PcnctcAEVO();
        pcnctcAEVOIn.setCtcaeVer(ctcaeVer);
        pcnctcAEVOIn.setMedDraCode(medDraCode);

        PcnctcAEVO pcnctcAEVO = pcnctcaeService.pcnctcaeThreeList(pcnctcAEVOIn);

        return pcnctcAEVO;
    }

    @GetMapping("/pcnctcaeList")
    public List<PcnctcAEVO> goPcnctcaeList(@RequestParam (value = "ctcaeVer") String ctcaeVer,
                                           @RequestParam (value = "medDraSoc") String medDraSoc) throws Exception {

        PcnctcAEVO pcnctcAEVOIn = new PcnctcAEVO();
        pcnctcAEVOIn.setCtcaeVer(ctcaeVer);
        pcnctcAEVOIn.setMedDraSoc(medDraSoc);

        List<PcnctcAEVO> pcnctcAEVOList = pcnctcaeService.pcnctcaeTwoList(pcnctcAEVOIn);

        return pcnctcAEVOList;
    }

    @GetMapping("/aeTreeList")
    public List<AEMntrngTreeVO> goAETreeList(@RequestParam (value = "studyId") String studyId,
                                             @RequestParam (value = "prtcpntId") String prtcpntId,
                                             @RequestParam (value = "viewType") String viewType) throws Exception {
        //AE 트리
        AEMntrngTreeParamVO aeMntrngTreeParamVO = new AEMntrngTreeParamVO();

        aeMntrngTreeParamVO.setStudyId(studyId);
        aeMntrngTreeParamVO.setPrtcpntId(prtcpntId);
        aeMntrngTreeParamVO.setOnGoingAt("");
        aeMntrngTreeParamVO.setActionAt(viewType);
        List<AEMntrngTreeVO> aeMntrngTreeVOList = aeMntmgService.selectAETree(aeMntrngTreeParamVO);

        return aeMntrngTreeVOList;
    }

    @GetMapping("/symptmsList")
    public List<AEMPrtcpntSymptmsVO> goSymptmsList(@RequestParam (value = "studyId") String studyId,
                                                   @RequestParam (value = "prtcpntId") String prtcpntId,
                                                   @RequestParam (value = "viewType") String viewType) throws Exception {
        //참여자 증상 목록
        AEMntrngSymptmsParamVO aeMntrngSymptmsParamVO = new AEMntrngSymptmsParamVO();
        aeMntrngSymptmsParamVO.setStudyId(studyId);
        aeMntrngSymptmsParamVO.setPrtcpntId(prtcpntId);
        List<String> viewTypeList =  Arrays.asList(viewType.split(","));

        aeMntrngSymptmsParamVO.setViewTypeList(viewTypeList);
        List<AEMPrtcpntSymptmsVO> aemPrtcpntSymptmsVOList = aeMntmgService.selectSymptmsList(aeMntrngSymptmsParamVO);

        return aemPrtcpntSymptmsVOList;
    }

    @GetMapping("/aemStdyPrtcpnt")
    public List<AEMStdyPrtcpntVO> goAemStdyPrtcpnt(@RequestParam (value = "studyId") String studyId,
                                                   @RequestParam (value = "studyInstId") String studyInstId,
                                                   @RequestParam (value = "setAllAt") String setAllAt,
                                                   @RequestParam (value = "setTodayAt") String setTodayAt,
                                                   @RequestParam (value = "setStartDe") String setStartDe,
                                                   @RequestParam (value = "setEndDe") String setEndDe) throws Exception {
        if (setAllAt == null || setAllAt.equals("")) {
            setAllAt = "N";
        }

        if (setTodayAt == null || setTodayAt.equals("")) {
            setTodayAt = "N";
        }

        if (setStartDe == null || setStartDe.equals("")) {
            setStartDe = DateTimeUtil.getNowDate();
        }

        if (setEndDe == null || setEndDe.equals("")) {
            setEndDe = DateTimeUtil.getNowDate();
        }

        //참여자목록
        AEMntrngParamVO aeMntrngParamVO = new AEMntrngParamVO();
        aeMntrngParamVO.setAllAt(setAllAt); //전체검색
        aeMntrngParamVO.setTodayAt(setTodayAt); //당일방문예정
        aeMntrngParamVO.setSearchCnd(""); //구분
        aeMntrngParamVO.setSearchWrd(""); //검색어
        aeMntrngParamVO.setStartDe(setStartDe.replaceAll("-", ""));
        aeMntrngParamVO.setEndDe(setEndDe.replaceAll("-", ""));
        aeMntrngParamVO.setStudyId(studyId);
        aeMntrngParamVO.setStdyInstId(studyInstId);
        List<AEMStdyPrtcpntVO> aemStdyPrtcpntVOList = aeMntmgService.selectPrtcpntList(aeMntrngParamVO);

        return aemStdyPrtcpntVOList;
    }
}
