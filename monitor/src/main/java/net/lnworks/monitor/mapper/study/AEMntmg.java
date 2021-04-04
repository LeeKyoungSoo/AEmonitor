package net.lnworks.monitor.mapper.study;

import net.lnworks.monitor.domain.study.AEMStdyPrtcpntVO;
import net.lnworks.monitor.domain.study.AEMntrngParamVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AEMntmg {
    List<AEMStdyPrtcpntVO> selectPrtcpntList(AEMntrngParamVO vo) throws Exception;
}
