package net.lnworks.aemdapi.service.study;

import net.lnworks.aemdapi.domain.study.AEMPrtcpntSymptmsVO;
import net.lnworks.aemdapi.domain.study.AEMntrngSymptmsParamVO;
import net.lnworks.aemdapi.mapper.study.AEMntmg;
import net.lnworks.aemdapi.util.DataListMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AEMntmgService {
    @Autowired
    AEMntmg aEMntmg;

    public int insertSymptms(AEMPrtcpntSymptmsVO vo) throws Exception {
        return aEMntmg.insertSymptms(vo);
    }

    public int updateSymptms(AEMPrtcpntSymptmsVO vo) throws Exception {
        return aEMntmg.updateSymptms(vo);
    }

    public int deleteSymptms(AEMPrtcpntSymptmsVO vo) throws Exception {
        return aEMntmg.deleteSymptms(vo);
    }

    public AEMPrtcpntSymptmsVO selectSymptms(AEMntrngSymptmsParamVO vo) throws Exception {
        return aEMntmg.selectSymptms(vo);
    }
}