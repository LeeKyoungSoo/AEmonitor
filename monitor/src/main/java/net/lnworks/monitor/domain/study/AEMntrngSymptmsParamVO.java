package net.lnworks.monitor.domain.study;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AEMntrngSymptmsParamVO {
    /** 사용된 증상여부 */
    private String useIncludeAt;

    /** 연구ID */
    private String studyId;
    /** 참여자ID */
    private String prtcpntId;
    /** 참여자증상Seq */
    private Integer symptmsSeq;
    /** AE요약Seq */
    private Integer sumrySeq;
    /** AE모니터링Seq */
    private Integer mntrngSeq;

    /** 조회 탭 종류 */
    private String viewType;
}
