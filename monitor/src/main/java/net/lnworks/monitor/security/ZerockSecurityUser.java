package net.lnworks.monitor.security;

import lombok.Getter;
import lombok.Setter;
import net.lnworks.monitor.domain.LoginVO;
import net.lnworks.monitor.domain.MemberRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ZerockSecurityUser extends User {
    private static final String ROLE_PREFIX = "ROLE_";

    public ZerockSecurityUser(LoginVO vo) {
        super(vo.getId(), vo.getPassword(), makeGrantedAuthority(vo.getRoleList()));
    }

    private static List<GrantedAuthority> makeGrantedAuthority(List<MemberRole> roles) {
        List<GrantedAuthority> roleList = new ArrayList<>();

        roles.forEach(
                role -> roleList.add(new SimpleGrantedAuthority(ROLE_PREFIX + role.getRoleName())));

        return  roleList;
    }
}
