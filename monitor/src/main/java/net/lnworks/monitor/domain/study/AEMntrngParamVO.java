package net.lnworks.monitor.domain.study;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AEMntrngParamVO {

    /** 연구ID */
    private String studyId;
    /** 연구기관ID */
    private String stdyInstId;
    /** 검색조건 */
    private String searchCnd;
    /** 검색어 */
    private String searchWrd;
    /** 전체여부 */
    private String allAt;
    /** 오늘방문여부 */
    private String todayAt;
    /** 증상등록일자 시작일 */
    private String startDe;
    /** 증상등록일자 종료일 */
    private String endDe;

    /** 사용자고유아이디 */
    private String uniqId;

    /** AE조치용 검색조건 - 참여자조회타입 */
    private String viewType;
}
