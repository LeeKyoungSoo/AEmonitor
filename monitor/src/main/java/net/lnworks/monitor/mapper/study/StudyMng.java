package net.lnworks.monitor.mapper.study;

import net.lnworks.monitor.domain.InstMngVO;
import net.lnworks.monitor.domain.LoginVO;
import net.lnworks.monitor.domain.StudyInfoMngVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudyMng {
    List<StudyInfoMngVO> selectMainStudyList(LoginVO vo) throws Exception;
    List<InstMngVO> selectMainInstList(StudyInfoMngVO vo) throws Exception;
}
