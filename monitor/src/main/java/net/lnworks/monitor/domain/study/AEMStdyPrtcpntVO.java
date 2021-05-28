package net.lnworks.monitor.domain.study;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AEMStdyPrtcpntVO extends AEMPrtvpntVO {

    /** 연구ID */
    private String studyId;
    /** 연구기관ID */
    private String stdyInstId;
    /** ENRL NO */
    private String enrlNo;
    /** 특이사항 */
    private String partclrMatter;
    /** 확인자ID */
    private String cnfrmrEsntlId;
    /** 첫투여일자 */
    private String mdctnStrtDe;
    /** 임상약종료일자 */
    private String medcinStopDe;
    /** 참여자종료일자 */
    private String prtcpntEndDe;
    /** 참여자종료코드 */
    private String prtcpntEndCode;
    /** 참여자종료이유 */
    private String prtcpntEndResn;
    //	첫방문일
    private String symptmsRegistDe;
    //	작업자명
    private String userNm;
    //	연구명
    private String studyNm;
    //	연구번호
    private String studyNo;

    private String studySttusNm;

    /** 확인자명 */
    private String cnfrmrNm;
    /** 신규증상 */
    private String newSymptms;
    /** 방문예정일 */
    private String visitForecastDe;
    //	종료예정일
    private String endForecastDe;
    //	종료예정일을 위한 TERM일수
    private Integer termDays;
    //	참여자상태
    private String prtcnptState;

    /** 담당자명 */
    private String mntrngDcsnUserNm;
    //	증상등록일자 검색용(김재성)
    private String fromDate;
    private String toDate;
    //	오늘방문예정여부
    private String todayVisitSchdl;
    //	최근방문일자
    private String recntVisit;

    private String crfSubjId;		// CRF대상자ID
    //	20200327 타연구참여여부추가(김재성)
    private String otherStudyCheck;

    private String regDt;   //최근 등록일
}
