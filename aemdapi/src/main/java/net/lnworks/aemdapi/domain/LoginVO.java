package net.lnworks.aemdapi.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
public class LoginVO implements Serializable {

    private static final long serialVersionUID = -4301619185131910930L;

    /** 아이디 */
    private String ptId;
    /** 이름 */
    private String ptNm;
    /** 비밀번호 */
    private String ptPwd;
    /** Rol정보 */
    private List<MemberRole> roleList;
}
