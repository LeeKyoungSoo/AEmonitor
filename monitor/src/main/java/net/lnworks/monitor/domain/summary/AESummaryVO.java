package net.lnworks.monitor.domain.summary;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AESummaryVO {

    // 연구ID
    private String studyId;

    // 연구기관ID
    private String stdyInstId;

    //참여자ID
    private String prtcpntId;

    //AE요약SEQ
    private Integer sumrySeq;

     //AE Number - 숫자두자리
    private String aeNumr;

    //AE명
    private String adNm;

    //증증도 - 가장 놓은 Grade
    private String grade;

    //시작일
    private String sDt;

    //종료일(진행중)
    private String edt;

    //Serious (Yes 1회라도 있으면 Yes)
    private String serious;

    //Serious내용
    private String seriousCont;

    //관련성 (아직 미 적용)
    private String relation;

    //예측여부 (Yes가 1회라도 있으면 Yes)
    private String prediction;

    //관련조치 (영구중단 > 용량감소 > 일시중단(이건 용량감소로 수집))
    private String relationMeasure;

    //기타조치 (약물요법, 시술/처치 가 모두 있으면 모두 표시)
    private String etcMeasure;

    //결과 (회복됨(휴유증동반) -> 회복됨)
    private String aeResult;

    //모니터링확정여부
    private String mnAt;

    //ongoing 여부
    private String acAt;
}
