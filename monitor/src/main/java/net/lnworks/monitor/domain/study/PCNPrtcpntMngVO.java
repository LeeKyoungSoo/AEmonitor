package net.lnworks.monitor.domain.study;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PCNPrtcpntMngVO {
    private String prtcpntId; 		// 참여자ID(PK)
    private String initial; 		//	이니셜
    private String telno;			//	전화번호
    private String birthday;		// 생년월일 조합
    private Integer brthdyYear;		//	생일년도
    private Integer brthdyMonth;	//	생일월
    private Integer brthdyDate; 	//	생일일자
    private String sexdstnCode;		//	성별코드
    private String pcnAppId;		// PCN앱ID
    private String pcnAppPswd;		//	PCN앱비밀번호
    private String lastLoginPnttm;	//	최종로그인시점
    private String frstRegistPnttm;	//	최초등록시점
    private String frstRegisterId;	//	최초등록자ID
    private String lastUpdtPnttm;	//	최종수정시점
    private String lastUpdusrId;	//	최종수정자ID
    private String rowStatus;	// WebSquare row 상태
    private String userId;		// 작업자ID
    private String searchCondition; // 검색조건
    private String searchKeyword; // 검색어
    private Long limit;
    private Long offset;
    //	20200331 프로시저 결과값 추가(김재성)
    private Integer procReturn;
}
