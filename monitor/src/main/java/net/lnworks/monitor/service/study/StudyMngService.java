package net.lnworks.monitor.service.study;

import net.lnworks.monitor.domain.InstMngVO;
import net.lnworks.monitor.domain.LoginVO;
import net.lnworks.monitor.domain.StudyInfoMngVO;
import net.lnworks.monitor.mapper.study.StudyMng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyMngService {
    @Autowired
    StudyMng studyMng;

    public List<StudyInfoMngVO> selectMainStudyList(LoginVO vo) throws Exception {
        return studyMng.selectMainStudyList(vo);
    }

    public List<InstMngVO> selectMainInstList(StudyInfoMngVO vo) throws Exception {
        return studyMng.selectMainInstList(vo);
    }
}


