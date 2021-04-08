package net.lnworks.monitor.domain.study;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AEMMntrngVO extends AEMSumryVO {
    /** AE모니터링 SEQ */
    private Integer mntrngSeq;
    /** 리비전번호 */
    private Integer revisnNo;
    /** 모니터링메모 */
    private String mntrngMemo;
    /** 모니터링등록일자 */
    private String mntrngRegistDe;
    /** 방문예약일자 */
    private String visitResveDe;
    /** 모니터링확정여부 */
    private String mntrngDcsnAt;
    /** 모니터링확정자ID */
    private String mntrngDcsnEsntlId;

    /** 임상약종료일자 */
    private String medcinStopDe;
    /** 조치일자 */
    private String actionDe;
    /** 조치메모 */
    private String actionMemo;
    /** 조치확정여부 */
    private String actionDcsnAt;
    /** 조치확정자ID */
    private String actionDcsnEsntlId;

    /** 모니터링확정자명 */
    private String mntrngDcsnNm;
    /** 모니터링확정자이메일 */
    private String mntrngDcsnEmail;
    /** 모니터링확정자 */
    private String mntrngDcsnUser;

    /** 조치확정자명 */
    private String actionDcsnNm;
    /** 조치확정자이메일 */
    private String actionDcsnEmail;
    /** 조치확정자 */
    private String actionDcsnUser;

    /** 상태 */
    private String status;
    /** 최종리버젼여부 */
    private String maxRevisnAt;

    /** 책임확인자 여부 */
    private String piAt;
    /** 확인자 여부 */
    private String cnfrmrAt;
    /** 중증도 내용 */
    private String gradeDc;

    /** CRF송신URL */
    private String crftrsmUrl;

    /** 프로시져 결과값 */
    private Integer returnVal;

    /** 취소요청여부 */
    private String cancelRequstAt;
}
