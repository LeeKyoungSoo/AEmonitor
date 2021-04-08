package net.lnworks.monitor.service.study;

import net.lnworks.monitor.domain.study.*;
import net.lnworks.monitor.mapper.study.AEMntmg;
import net.lnworks.monitor.util.DataListMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AEMntmgService {
    @Autowired
    AEMntmg aEMntmg;

    public List<AEMPrtcpntSymptmsVO> selectSymptmsList(AEMntrngSymptmsParamVO vo) throws Exception {
        return aEMntmg.selectSymptmsList(vo);
    }

    public List<AEMStdyPrtcpntVO> selectPrtcpntList(AEMntrngParamVO vo) throws Exception {
        return aEMntmg.selectPrtcpntList(vo);
    }

    public List<AEMntrngTreeVO> selectAETree(AEMntrngTreeParamVO vo) throws Exception {
        return aEMntmg.selectAETree(vo);
    }

    public AEMPrtcpntSymptmsVO selectSymptms(AEMntrngSymptmsParamVO vo) throws Exception {
        return aEMntmg.selectSymptms(vo);
    }

    public List<DataListMap> fileDetailList(AEMPrtcpntSymptmsVO vo) throws Exception {
        return aEMntmg.fileDetailList(vo);
    }

    public List<DataListMap> getSysSetupFileList() throws Exception {
        return aEMntmg.getSysSetupFileList();
    }

    public AEMMntrngVO selectAEMntrngView(AEMMntrngVO vo) throws Exception {
        return aEMntmg.selectAEMntrngView(vo);
    }
}