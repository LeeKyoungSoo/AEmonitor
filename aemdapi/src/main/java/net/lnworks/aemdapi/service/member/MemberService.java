package net.lnworks.aemdapi.service.member;

import net.lnworks.aemdapi.domain.LoginVO;
import net.lnworks.aemdapi.mapper.member.LoginUser;
import net.lnworks.aemdapi.util.DataListMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collection;

@Service
public class MemberService implements UserDetailsService {
    @Autowired
    LoginUser loginUser;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public LoginVO getLoginUser(LoginVO vo) throws Exception {
        return loginUser.getLoginUser(vo);
    }
    public DataListMap getUserRol(LoginVO vo) throws Exception {
        return loginUser.getUserRol(vo);
    }
    public int insLoginUser(LoginVO vo) throws Exception {
        vo.setPtPwd(passwordEncoder.encode(vo.getPtPwd()));
        return loginUser.insLoginUser(vo);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginVO vo = new LoginVO();
        vo.setPtId(username);

        try {
            LoginVO user = this.getLoginUser(vo);
            if ( user != null ) {
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                String password = request.getParameter("password");

                if ( password.equals(user.getPtPwd())) {
                    user.setPtPwd(passwordEncoder.encode(user.getPtPwd()));
                    return new org.springframework.security.core.userdetails.User(user.getPtId(), user.getPtPwd(), getAuthorities());
                }
                else {
                    throw new BadCredentialsException("Please check your login PASSWORD");
                }
            }
            else {
                throw new BadCredentialsException("Please check your login ID(username)");
            }
        } catch(UsernameNotFoundException e) {
            e.printStackTrace();
            throw new UsernameNotFoundException(e.getMessage());
        } catch(
        BadCredentialsException e) {
            e.printStackTrace();
            throw new BadCredentialsException(e.getMessage());
        } catch(Exception e) {
            e.printStackTrace();
            //throw new RuntimeException(e.getMessage());
            throw new UsernameNotFoundException(e.getMessage());
        }
    }

    private Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }
}
