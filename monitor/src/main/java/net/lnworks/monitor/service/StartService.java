package net.lnworks.monitor.service;

import net.lnworks.monitor.domain.StartVo;
import net.lnworks.monitor.mapper.StartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StartService {
    @Autowired
    StartMapper mapper;

    public List<StartVo> getStartList() throws Exception {
        return mapper.getStart();
    }
}

