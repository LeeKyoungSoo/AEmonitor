package net.lnworks.monitor.mapper.member;

import net.lnworks.monitor.domain.LoginVO;
import net.lnworks.monitor.util.DataListMap;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginUser {
    LoginVO getLoginUser(LoginVO vo) throws Exception;
    DataListMap getUserInfo(LoginVO vo) throws Exception;
    DataListMap getUserauthority(LoginVO vo) throws Exception;
}
