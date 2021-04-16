package net.lnworks.monitor.domain.study;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AEMSumryVO {
    /** 연구ID */
    private String studyId;
    /** 참여자ID */
    private String prtcpntId;
    /** AE요약SEQ */
    private Integer sumrySeq;
    /** AE번호 */
    private Integer aeNo;
    /** MedDRA Code */
    private String medDraCode;
    /** AE용어(명)CTCAE */
    private String aeTermCtcae;
    /** AE용어(명)미정의 */
    private String aeTermOther;
    /** AE중증도 */
    private String aeGrade;
    /** AE시작일자 */
    private String aeStrtDe;
    /** AE종료일자 */
    private String aeEndDe;
    /** SAE여부 */
    private String saeAt;
    /** 인과관계코드 */
    private String causalityCode;
    /** 예측여부 */
    private String predictAt;
    /** 관련조치코드 */
    private String aeActionCode;
    /** 기타조치코드 */
    private String etcActionCode;
    /** AE결과코드 */
    private String aeRsltCode;
    /** 최초등록시점 */
    private String frstRegistPnttm;
    /** 최초등록자ID */
    private String frstRegisterId;
    /** 최종수정시점 */
    private String lastUpdtPnttm;
    /** 최종수정자ID */
    private String lastUpdusrId;

    /** 사용자고유아이디 */
    private String uniqId;

    /** SAE 사망 */
    private String saeDeath;
    /** SAE 생명위협 */
    private String saeLifeThrt;
    /** SAE 입원필요 */
    private String saeHsptlzNeed;
    /** SAE 중대기능저하초래 */
    private String saeCsmalfnc;
    /** SAE 기형초래 */
    private String saeCsdeform;
    /** SAE 기타중요상황 */
    private String saeEtcSittn;

    /** 결과코드 */
    private String resultCode;

    private String useYn;
}
