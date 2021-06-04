package net.lnworks.monitor.mapper.study;

import net.lnworks.monitor.domain.study.*;
import net.lnworks.monitor.util.DataListMap;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AEMntmg {
    List<AEMPrtcpntSymptmsVO> selectSymptmsList(AEMntrngSymptmsParamVO vo) throws Exception;
    List<AEMStdyPrtcpntVO> selectPrtcpntList(AEMntrngParamVO vo) throws Exception;
    AEMStdyPrtcpntVO selectPrtcpntView(AEMntrngParamVO vo) throws Exception;
    List<AEMntrngTreeVO> selectAETree(AEMntrngTreeParamVO vo) throws Exception;
    List<AEMntrngTreeVO> selectFavoriteTree(AEMntrngTreeParamVO vo) throws Exception;
    AEMPrtcpntSymptmsVO selectSymptms(AEMntrngSymptmsParamVO vo) throws Exception;
    List<DataListMap> fileDetailList(AEMPrtcpntSymptmsVO vo) throws Exception;
    List<DataListMap> getSysSetupFileList() throws Exception;
    AEMMntrngVO selectAEMntrngView(AEMMntrngVO vo) throws Exception;
    int insertSymptms(AEMPrtcpntSymptmsVO vo) throws Exception;
    int updateSymptms(AEMPrtcpntSymptmsVO vo) throws Exception;
    int deleteSymptms(AEMPrtcpntSymptmsVO vo) throws Exception;
    int insertAEMMntrng(AEMMntrngVO vo) throws Exception;
    int insertAEMSumry(AEMMntrngVO vo) throws Exception;
    int updateAEMSumry(AEMMntrngVO vo) throws Exception;
    int insertFavorites(AEMMntrngVO vo) throws Exception;
}