package net.lnworks.monitor.security;

import lombok.Getter;
import lombok.Setter;
import net.lnworks.monitor.domain.Member;
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
    private Member member;

    public ZerockSecurityUser(Member member) {
        super(member.getUid(), "{noop}" + member.getUpw(), makeGrantedAuthority(member.getRoles()));
    }

    private static List<GrantedAuthority> makeGrantedAuthority(List<MemberRole> roles) {
        List<GrantedAuthority> roleList = new ArrayList<>();

        roles.forEach(
                role -> roleList.add(new SimpleGrantedAuthority(ROLE_PREFIX + role.getRoleName())));

        return  roleList;
    }
}
