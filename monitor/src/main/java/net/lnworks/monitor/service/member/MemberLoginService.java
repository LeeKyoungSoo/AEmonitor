package net.lnworks.monitor.service.member;

import net.lnworks.monitor.domain.LoginVO;
import net.lnworks.monitor.mapper.member.LoginUser;
import net.lnworks.monitor.util.DataListMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberLoginService {
    @Autowired
    LoginUser loginUser;

    public LoginVO getLoginUserIO(LoginVO vo) throws Exception {
        return loginUser.getLoginUser(vo);
    }
    public DataListMap getUserInfo(LoginVO vo) throws Exception {
        return loginUser.getUserInfo(vo);
    }
    public DataListMap getUserauthority(LoginVO vo) throws Exception {
        return loginUser.getUserauthority(vo);
    }
}
