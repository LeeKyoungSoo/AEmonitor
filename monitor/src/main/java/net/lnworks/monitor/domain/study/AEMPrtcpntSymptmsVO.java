package net.lnworks.monitor.domain.study;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AEMPrtcpntSymptmsVO {
    /** 연구ID */
    private String studyId;
    /** 참여자ID */
    private String prtcpntId;
    /** 참여자증상Seq */
    private Integer symptmsSeq;
    /** 증상등록유형코드 */
    private String symptmsRegtypeCode;
    /** 증상등록일자 */
    private String symptmsRegistDe;
    /** 증상제목 */
    private String symptmsTitle;
    /** 증상시작일자 */
    private String symptmsStrtDe;
    /** 증상종료일자 */
    private String symptmsEndDe;
    /** 증상내용 */
    private String symptmsCn;
    /** 첨부파일ID */
    private String atchFileId;
    /** 발신통화여부 */
    private String outbndCallAt;
    /** 통화상대 */
    private String callPartner;
    /** 방문유형코드 */
    private String visitTypeCode;
    /** 방문기준SEQ */
    private String visitRuleSeq;
    /** 최초등록일자 */
    private String frstRegistPnttm;
    /** 최초등록자ID */
    private String frstRegisterId;
    /** 최종수정일자 */
    private String lastUpdtPnttm;
    /** 최종수정자ID */
    private String lastUpdusrId;

    /** 증상일자 */
    private String symptmsDe;
    /** 타AE사용여부 */
    private String otherAEUseAt;
    /** 사용여부 */
    private String useAt;
    /** 적성자명 */
    private String registerNm;

    /* 이하 남의 테이블 꺼 */
    private String studyName;
    private String initial;
    private String enrlNo;

    /** 처치단계 */
    private String trmtStep;
    /** 상태 */
    private String status;
    /** 사용된 증상여부 */
    private String useIncludeAt;
    //	appID
    private String pcnAppId;

    private String stdyinstName;

    /** 검색용 파라미터 - 등록기간 */
    private String startDe;
    private String endDe;

    private String symRegTxt;
}
