package net.lnworks.monitor.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MenuManageVO {
    private String bgcolor;
    private String bgcolor2;

    /** 메뉴정보 */
    /** 메뉴번호 */
    private   int      menuNo;
    /** 메뉴순서 */
    private   int      menuOrdr;
    /** 메뉴명 */
    private   String   menuNm;
    /** 상위메뉴번호 */
    private   int      upperMenuId;
    /** 메뉴설명 */
    private   String   menuDc;
    /** 관련이미지경로 */
    private   String   relateImagePath;
    /** 관련이미지명 */
    private   String   relateImageNm;
    /** 프로그램파일명 */
    private   String   progrmFileNm;

    /** URL */
    private   String   chkURL;
    /** URL_TYPE */
    private   String   urlType;

    /** 사이트맵 */
    /** 생성자ID **/
    private   String   creatPersonId;

    /** 권한정보설정 */
    /** 권한코드 */
    private   String   authorCode;

    /** 기타VO변수 */
    private   String   tempValue;
    private   int      tempInt;


    /** Login 메뉴관련 VO변수 */
    /** tmp_Id */
    private   String   tmpId;
    /** tmp_Password */
    private   String   tmpPassword;
    /** tmp_Name */
    private   String   tmpName;
    /** tmp_UserSe */
    private   String   tmpUserSe;
    /** tmp_Email */
    private   String   tmpEmail;

    private   String   tmpStdyinstId;

    /** tmp_UniqId */
    private   String   tmpUniqId;
    /** tmp_Cmd */
    private   String   tmpCmd;

    private int upperMenuOrdr;

    private String mode;
    private int cntSubmenu;

    private String menuGroupSe;

    /** 메뉴조회 트리용 */
    private String parent;
    private String level;
    private String isLeaf;
    private String expanded = "false";
    private String loaded = "true";
    private String prgRegdAt;
    private String enbl;
    private String st;
    private String intnetOpenAt;

    private String intnetSysAt = "N";

    private String uid;

    private String rowStatus;	// WebSquare 때문에 추가(20180816)

    /** 연구 및 연구기관 콤보박스용 - 2019.12.16 이영환 추가 */
    private String studyId;
    private String stdyinstId;
}
