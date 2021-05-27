package net.lnworks.aemdapi.mapper.study;

import net.lnworks.aemdapi.domain.study.AEMPrtcpntSymptmsVO;
import net.lnworks.aemdapi.domain.study.AEMntrngSymptmsParamVO;
import net.lnworks.aemdapi.util.DataListMap;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AEMntmg {
    int insertSymptms(AEMPrtcpntSymptmsVO vo) throws Exception;

    int updateSymptms(AEMPrtcpntSymptmsVO vo) throws Exception;

    int deleteSymptms(AEMPrtcpntSymptmsVO vo) throws Exception;

    AEMPrtcpntSymptmsVO selectSymptms(AEMntrngSymptmsParamVO vo) throws Exception;
}
