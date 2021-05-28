package net.lnworks.monitor.service.study;

import net.lnworks.monitor.domain.study.PcnctcAEVO;
import net.lnworks.monitor.mapper.study.PcnctcAE;
import net.lnworks.monitor.util.DataListMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PcnctcAEService {
    @Autowired
    PcnctcAE pcnctcae;

    public List<PcnctcAEVO> pcnctcaeOneList(PcnctcAEVO vo) throws Exception {
        return pcnctcae.pcnctcaeOneList(vo);
    }

    public List<PcnctcAEVO> pcnctcaeTwoList(PcnctcAEVO vo) throws Exception {
        return pcnctcae.pcnctcaeTwoList(vo);
    }

    public PcnctcAEVO pcnctcaeThreeList(PcnctcAEVO vo) throws Exception {
        return pcnctcae.pcnctcaeThreeList(vo);
    }
}
