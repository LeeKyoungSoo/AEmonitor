package net.lnworks.monitor.service.study;

import net.lnworks.monitor.domain.study.AEMStdyPrtcpntVO;
import net.lnworks.monitor.domain.study.AEMntrngParamVO;
import net.lnworks.monitor.mapper.study.AEMntmg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AEMntmgService {
    @Autowired
    AEMntmg aEMntmg;

    public List<AEMStdyPrtcpntVO> selectPrtcpntList(AEMntrngParamVO vo) throws Exception {
        return aEMntmg.selectPrtcpntList(vo);
    }
}

