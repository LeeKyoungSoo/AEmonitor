package net.lnworks.monitor.domain.study;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AEMntrngTreeParamVO {

    /** 연구ID */
    private String studyId;
    /** 연구기관ID */
    private String stdyInstId;
    /** 참여자ID */
    private String prtcpntId;
    /** OnGoing여부 */
    private String onGoingAt;
    /** 담당자확정여부 */
    private String cmpltAt;

    /** AE요약SEQ */
    private Integer sumrySeq;
    /** AE모니터링 SEQ */
    private Integer mntrngSeq;

    /** 조치여부 */
    private String actionAt;

    /** 증상 SEQ */
    private Integer symptmsSeq;

    /** drop 연구ID */
    private String dropStudyId;
    /** drop 참여자ID */
    private String dropPrtcpntId;
    /** drop AE요약SEQ */
    private Integer dropSumrySeq;
    /** drop AE모니터링 SEQ */
    private Integer dropMntrngSeq;

    /** 사용자 고유 아이디 */
    private String uniqId;
}
