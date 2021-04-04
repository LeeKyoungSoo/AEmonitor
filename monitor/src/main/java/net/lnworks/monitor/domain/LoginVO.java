package net.lnworks.monitor.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
public class LoginVO implements Serializable {

    private static final long serialVersionUID = -8274004534207618049L;

    /** 아이디 */
    private String id;
    /** 이름 */
    private String name;
    /** 주민등록번호 */
    private String ihidNum;
    /** 이메일주소 */
    private String email;
    /** 비밀번호 */
    private String password;
    /** 비밀번호 힌트 */
    private String passwordHint;
    /** 비밀번호 정답 */
    private String passwordCnsr;
    /** 사용자구분 */
    private String userSe;

    private String stdyinstId;

    /** 고유아이디 */
    private String uniqId;
    /** 로그인 후 이동할 페이지 */
    private String url;
    /** 사용자 IP정보 */
    private String ip;
    /** GPKI인증 DN */
    private String dn;

    /** 핸드폰 정보 */
    private String moblphonNo;
    /** 등록일 */
    private String registPnttm;

    /** 관리자, 부관리자여부 */
    private String adminAt;
    /** 관리자여부 */
    private String roleAdminAt;

    private String stplatinfoAgreAt;
    private String stplatinfoAgrePnttm;

    /** 비밀번호 실패 횟수 */
    private String pswdMonOvr;

    /** 사용자구분 */
    private String membSe;

    /** Session ID **/
    private String sessionId;

    private String sysSiteNm;

    /** 연구ID - 2019.12.16 이영환 추가 */
    private String studyId;

    /** 총담당자여부, 책임연구자여부 - 2020.03.24 이영환 추가 */
    private String studyCiAt;
    private String studyPiAt;
    //	20200324 총담당자 추가
    private String studyGrmAt;

    private List<MemberRole> roleList;
}
