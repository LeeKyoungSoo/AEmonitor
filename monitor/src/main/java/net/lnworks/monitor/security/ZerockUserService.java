package net.lnworks.monitor.security;

import lombok.extern.java.Log;
import net.lnworks.monitor.persistence.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Log
public class ZerockUserService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberRepository.findById(username)
                .filter(m -> m != null)
                .map(m -> new ZerockSecurityUser(m)).get();
    }
}
