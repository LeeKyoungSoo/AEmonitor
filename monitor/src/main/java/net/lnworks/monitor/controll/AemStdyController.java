package net.lnworks.monitor.controll;

import net.lnworks.monitor.domain.study.*;
import net.lnworks.monitor.service.study.AEMntmgService;
import net.lnworks.monitor.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/aemonitorapi/")
public class AemStdyController {
    @Autowired
    private AEMntmgService aeMntmgService;

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
        aeMntrngSymptmsParamVO.setViewType(viewType);
        List<AEMPrtcpntSymptmsVO> aemPrtcpntSymptmsVOList = aeMntmgService.selectSymptmsList(aeMntrngSymptmsParamVO);

        return aemPrtcpntSymptmsVOList;
    }

    @GetMapping("/aemStdyPrtcpnt")
    public List<AEMStdyPrtcpntVO> goAemStdyPrtcpnt(@RequestParam (value = "studyId") String studyId,
                                                   @RequestParam (value = "studyInstId") String studyInstId) throws Exception {
        //참여자목록
        AEMntrngParamVO aeMntrngParamVO = new AEMntrngParamVO();
        aeMntrngParamVO.setAllAt("Y"); //전체검색
        aeMntrngParamVO.setTodayAt("N"); //당일방문예정
        aeMntrngParamVO.setSearchCnd(""); //구분
        aeMntrngParamVO.setSearchWrd(""); //검색어
        aeMntrngParamVO.setStartDe(DateTimeUtil.getNowDate());
        aeMntrngParamVO.setEndDe(DateTimeUtil.getNowDate());
        aeMntrngParamVO.setStudyId(studyId);
        aeMntrngParamVO.setStdyInstId(studyInstId);
        List<AEMStdyPrtcpntVO> aemStdyPrtcpntVOList = aeMntmgService.selectPrtcpntList(aeMntrngParamVO);

        return aemStdyPrtcpntVOList;
    }
}
