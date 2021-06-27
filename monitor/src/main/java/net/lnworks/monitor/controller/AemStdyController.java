package net.lnworks.monitor.controller;

import net.lnworks.monitor.domain.study.*;
import net.lnworks.monitor.domain.summary.AESummaryVO;
import net.lnworks.monitor.role.AERoleLogic;
import net.lnworks.monitor.service.study.AEMntmgService;
import net.lnworks.monitor.service.study.PcnctcAEService;
import net.lnworks.monitor.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/aemonitorapi/")
public class AemStdyController {
    @Autowired
    private AEMntmgService aeMntmgService;

    @Autowired
    private PcnctcAEService pcnctcaeService;

    @PostMapping("/aeFavorite")
    public int goAEInsertFavorite(AEMMntrngVO aemMntrngVO, Principal principal) throws Exception {
        int returnNum = 0;
        aemMntrngVO.setFrstRegisterId(principal.getName());
        aemMntrngVO.setLastUpdusrId(principal.getName());
        returnNum = aeMntmgService.insertFavorites(aemMntrngVO);

        return returnNum;
    }

    @PostMapping("/aeChartInsert")
    public int goAEChartInsert(AEMMntrngVO aemMntrngVO, Principal principal) throws Exception {
        int returnNum = 0;
        aemMntrngVO.setFrstRegisterId(principal.getName());
        aemMntrngVO.setLastUpdusrId(principal.getName());
        returnNum = aeMntmgService.insertAEMSumry(aemMntrngVO);

        if ( aemMntrngVO.getUseYn() != null && !aemMntrngVO.getUseYn().equals("X") ) {
            aeMntmgService.insertAEMMntrng(aemMntrngVO);
        }

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

        if ( aemMntrngVO.getUseYn() != null && aemMntrngVO.getUseYn().equals("Y") ) {
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
                                           @RequestParam (value = "medDraSoc") String medDraSoc,
                                           @RequestParam (value = "searchVal") String searchVal) throws Exception {

        PcnctcAEVO pcnctcAEVOIn = new PcnctcAEVO();
        pcnctcAEVOIn.setCtcaeVer(ctcaeVer);
        pcnctcAEVOIn.setMedDraSoc(medDraSoc);
        pcnctcAEVOIn.setSearchVal(searchVal);

        List<PcnctcAEVO> pcnctcAEVOList = pcnctcaeService.pcnctcaeTwoList(pcnctcAEVOIn);

        return pcnctcAEVOList;
    }

    @GetMapping("/aeTreeList")
    public List<AESummaryVO> goAETreeList(@RequestParam (value = "studyId") String studyId,
                                             @RequestParam (value = "prtcpntId") String prtcpntId,
                                             @RequestParam (value = "viewType") String viewType) throws Exception {
        //AE 트리
        AEMntrngTreeParamVO aeMntrngTreeParamVO = new AEMntrngTreeParamVO();
        AERoleLogic aeRoleLogic = new AERoleLogic();
        List<AESummaryVO> aeSummaryVOList = new ArrayList<>();

        aeMntrngTreeParamVO.setStudyId(studyId);
        aeMntrngTreeParamVO.setPrtcpntId(prtcpntId);
        aeMntrngTreeParamVO.setOnGoingAt("");
        aeMntrngTreeParamVO.setActionAt(viewType);
        List<AEMntrngTreeVO> aeMntrngTreeVOList = aeMntmgService.selectAETree(aeMntrngTreeParamVO);
        for (AEMntrngTreeVO aeTree : aeMntrngTreeVOList) {
            AESummaryVO aeSummaryVO = new AESummaryVO();
            aeSummaryVO.setStudyId(aeTree.getStudyId());
            aeSummaryVO.setPrtcpntId(aeTree.getPrtcpntId());
            aeSummaryVO.setSumrySeq(aeTree.getSumrySeq());
            aeSummaryVO.setAeNumr(aeRoleLogic.aeNum(aeTree.getSumrySeq().toString()));
            aeSummaryVO.setAdNm(aeTree.getAeTremNm());
            aeSummaryVO.setMnAt(aeTree.getMnAt());
            aeSummaryVO.setAcAt(aeTree.getAcAt());
            aeSummaryVO.setStartDt(aeTree.getAeStrtDe());
            if (aeTree.getAcAt().equals("ongoing") ||
                    (aeTree.getAeEndDe() == null || aeTree.getAeEndDe().equals("")) ) {
                aeSummaryVO.setEndDt(aeTree.getAcAt());
            }
            else {
                aeSummaryVO.setEndDt(aeTree.getAeEndDe());
            }

            //증증도 - 가장 놓은 Grade
            List<String> gradeList = new ArrayList<>();
            gradeList.add(aeTree.getAeGrade());
            //Serious (Yes 1회라도 있으면 Yes)
            List<String> seriousList = new ArrayList<>();
            seriousList.add(aeTree.getSaeAt());
            //예측여부 (Yes가 1회라도 있으면 Yes)
            List<String> predictionList = new ArrayList<>();
            predictionList.add(aeTree.getPredictAt());
            //관련조치 (영구중단 > 용량감소 > 일시중단(이건 용량감소로 수집))
            List<String> relationMeasureList = new ArrayList<>();
            relationMeasureList.add(aeTree.getAeActionCode());
            //기타조치 (약물요법, 시술/처치 가 모두 있으면 모두 표시)
            List<String> etcMeasureList = new ArrayList<>();
            etcMeasureList.add(aeTree.getEtcActionCode());
            //결과 (회복됨(휴유증동반) -> 회복됨)
            List<String> aeResultList = new ArrayList<>();
            aeResultList.add(aeTree.getAeRsltCode());

            //Serious내용
            List<String> saeDeathList = new ArrayList<>();
            List<String> saeLifeThrtList = new ArrayList<>();
            List<String> saeHsptlzNeedList = new ArrayList<>();
            List<String> saeCsmalfncList = new ArrayList<>();
            List<String> saeCsdeformList = new ArrayList<>();
            List<String> saeEtcSittnList = new ArrayList<>();
            saeDeathList.add(aeTree.getSaeDeath());
            saeLifeThrtList.add(aeTree.getSaeLifeThrt());
            saeHsptlzNeedList.add(aeTree.getSaeHsptlzNeed());
            saeCsmalfncList.add(aeTree.getSaeCsmalfnc());
            saeCsdeformList.add(aeTree.getSaeCsdeform());
            saeEtcSittnList.add(aeTree.getSaeEtcSittn());

            //관련성 (인과관계 - 임시적용 가장 마지막 데이터)
            List<String> relationList = new ArrayList<>();

            List<AEMMntrngVO> aemMntrngHistoryList = aeTree.getAemMntrngHistoryList();
            for (AEMMntrngVO aeTreeHistory : aemMntrngHistoryList) {
                gradeList.add(aeTreeHistory.getAeGrade());
                seriousList.add(aeTreeHistory.getSaeAt());
                predictionList.add(aeTreeHistory.getPredictAt());
                relationMeasureList.add(aeTreeHistory.getAeActionCode());
                etcMeasureList.add(aeTreeHistory.getEtcActionCode());
                aeResultList.add(aeTreeHistory.getAeRsltCode());
                relationList.add(aeTreeHistory.getCausalityCode());

                saeDeathList.add(aeTreeHistory.getSaeDeath());
                saeLifeThrtList.add(aeTreeHistory.getSaeLifeThrt());
                saeHsptlzNeedList.add(aeTreeHistory.getSaeHsptlzNeed());
                saeCsmalfncList.add(aeTreeHistory.getSaeCsmalfnc());
                saeCsdeformList.add(aeTreeHistory.getSaeCsdeform());
                saeEtcSittnList.add(aeTreeHistory.getSaeEtcSittn());
            }
            aeSummaryVO.setGrade(aeRoleLogic.aeGrade(gradeList));
            aeSummaryVO.setSerious(aeRoleLogic.aeTopYes(seriousList));
            aeSummaryVO.setPrediction(aeRoleLogic.aeTopYes(predictionList));
            aeSummaryVO.setRelationMeasure(aeRoleLogic.aeRelationMeasure(relationMeasureList));
            aeSummaryVO.setEtcMeasure(aeRoleLogic.aeEtcMeasure(etcMeasureList));
            aeSummaryVO.setAeResult(aeRoleLogic.aeResult(aeResultList));
            aeSummaryVO.setRelation(aeRoleLogic.aeTopNotEmpty(relationList));
            aeSummaryVO.setSeriousCont(aeRoleLogic.aeYesDefaultValue(saeDeathList, "사망/")
                            + aeRoleLogic.aeYesDefaultValue(saeLifeThrtList, "치명적이거나 생명을 위협/")
                            + aeRoleLogic.aeYesDefaultValue(saeHsptlzNeedList, "입원을 요하거나 입원 연장/")
                            + aeRoleLogic.aeYesDefaultValue(saeCsmalfncList, "비가역장애/지속적인 불구 발생/")
                            + aeRoleLogic.aeYesDefaultValue(saeCsdeformList, "선천적 기형 또는 이상 초래/")
                            + aeRoleLogic.aeYesDefaultValue(saeEtcSittnList, "기타 의학적으로 중요한 상황/"));
            if ( aeSummaryVO.getSeriousCont() != null && aeSummaryVO.getSeriousCont().length() > 1) {
                aeSummaryVO.setSeriousCont(aeSummaryVO.getSeriousCont().substring(0, aeSummaryVO.getSeriousCont().length() - 1));
            }
            aeSummaryVOList.add(aeSummaryVO);
        }

        return aeSummaryVOList;
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
