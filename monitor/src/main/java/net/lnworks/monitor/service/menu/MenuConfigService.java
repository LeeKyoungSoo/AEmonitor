package net.lnworks.monitor.service.menu;

import net.lnworks.monitor.domain.MenuManageVO;
import net.lnworks.monitor.mapper.menu.MenuConfig;
import net.lnworks.monitor.util.DataListMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuConfigService {
    @Autowired
    MenuConfig menuConfig;

    public List<DataListMap> getLevelOneMenuList(MenuManageVO vo) throws Exception {
        return menuConfig.getLevelOneMenuList(vo);
    }

    public List<DataListMap> getLevelAllMenuList(MenuManageVO vo) throws Exception {
        return menuConfig.getLevelAllMenuList(vo);
    }
}


