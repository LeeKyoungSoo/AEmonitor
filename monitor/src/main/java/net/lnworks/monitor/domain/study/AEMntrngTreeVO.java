package net.lnworks.monitor.domain.study;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

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

    private List<AEMMntrngVO> aemMntrngHistoryList;
    private AEMntrngTreeVO aeFavoriteVo;

    private String medDraCode;
    private String aeTremNm;
    private String mnAt;
    private String acAt;
    private String aeGrade;
    private String saeAt;
    private String saeDeath;
    private String saeLifeThrt;
    private String saeHsptlzNeed;
    private String saeCsmalfnc;
    private String saeCsdeform;
    private String saeEtcSittn;
    private String causalityCode;
    private String predictAt;
    private String aeActionCode;
    private String etcActionCode;
    private String aeRsltCode;
    private String regDt;
}