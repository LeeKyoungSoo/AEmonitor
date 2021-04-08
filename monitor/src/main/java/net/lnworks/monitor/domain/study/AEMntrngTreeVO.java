package net.lnworks.monitor.domain.study;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AEMntrngTreeVO {

    /**
     * 연구ID
     */
    private String studyId;
    /**
     * 연구기관ID
     */
    private String stdyInstId;
    /**
     * 참여자ID
     */
    private String prtcpntId;
    /**
     * AE요약SEQ
     */
    private Integer sumrySeq;
    /**
     * AE모니터링 SEQ
     */
    private Integer mntrngSeq;
    /**
     * 증상 SEQ
     */
    private Integer symptmsSeq;
    /**
     * AE모니터링 표기내용
     */
    private String treeItem;

    /**
     * leaf 여부
     */
    private String isLeaf;
    /**
     * 레벨
     */
    private String level;
    /**
     * tree용 key값
     */
    private String treeKey;

    /**
     * AE모니터링 tree Drag&Drop 처리용 모니터링확정여부
     */
    private String mntrngDcsnAt;
    /**
     * 증상 선택 시 종류 구분용 코드
     */
    private String code;
}