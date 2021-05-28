package net.lnworks.aemdapi.mapper.member;

import net.lnworks.aemdapi.domain.LoginVO;
import net.lnworks.aemdapi.util.DataListMap;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginUser {
    LoginVO getLoginUser(LoginVO vo) throws Exception;
    DataListMap getUserRol(LoginVO vo) throws Exception;
    int insLoginUser(LoginVO vo) throws Exception;
}
