package net.lnworks.monitor.mapper.study;

import net.lnworks.monitor.domain.study.PcnctcAEVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PcnctcAE {
    List<PcnctcAEVO> pcnctcaeOneList(PcnctcAEVO vo) throws Exception;
    List<PcnctcAEVO> pcnctcaeTwoList(PcnctcAEVO vo) throws Exception;
    PcnctcAEVO pcnctcaeThreeList(PcnctcAEVO vo) throws Exception;
}
