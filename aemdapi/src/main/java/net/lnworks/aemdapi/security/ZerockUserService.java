package net.lnworks.aemdapi.security;

import lombok.extern.java.Log;
import net.lnworks.aemdapi.domain.LoginVO;
import net.lnworks.aemdapi.domain.MemberRole;
import net.lnworks.aemdapi.service.member.MemberLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log
public class ZerockUserService implements UserDetailsService {

    @Autowired
    private MemberLoginService memberLoginService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginVO loginVoIn = new LoginVO();
        loginVoIn.setPtId(username);

        LoginVO loginuser = null;
        try {
            loginuser = memberLoginService.getLoginUserIO(loginVoIn);

            MemberRole memberRole = new MemberRole();

            // 각 메뉴에 대한 정책이 없으므로 아래와 같이 처리
         //   memberRole.setRoleName("M");
            List<MemberRole> memberRoleList = new ArrayList<>();
            memberRoleList.add(memberRole);
            loginuser.setRoleList(memberRoleList);

            return new ZerockSecurityUser(loginuser);
        } catch (Exception e) {
            return null;
        }
    }
}
