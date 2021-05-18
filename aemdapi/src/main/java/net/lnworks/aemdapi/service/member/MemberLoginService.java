package net.lnworks.aemdapi.service.member;

import net.lnworks.aemdapi.domain.LoginVO;
import net.lnworks.aemdapi.mapper.member.LoginUser;
import net.lnworks.aemdapi.util.DataListMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberLoginService {
    @Autowired
    LoginUser loginUser;

    public LoginVO getLoginUserIO(LoginVO vo) throws Exception {
        return loginUser.getLoginUser(vo);
    }
    public DataListMap getUserRol(LoginVO vo) throws Exception {
        return loginUser.getUserRol(vo);
    }
    public DataListMap getUserauthority(LoginVO vo) throws Exception {
        return loginUser.getUserauthority(vo);
    }
}
