package net.lnworks.monitor.mapper.menu;

import net.lnworks.monitor.domain.LoginVO;
import net.lnworks.monitor.domain.MenuManageVO;
import net.lnworks.monitor.util.DataListMap;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MenuConfig {
    List<DataListMap> getLevelOneMenuList(MenuManageVO vo) throws Exception;
    List<DataListMap> getLevelAllMenuList(MenuManageVO vo) throws Exception;
}
