package net.lnworks.monitor.mapper;

import net.lnworks.monitor.domain.StartVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StartMapper {
    List<StartVo> getStart() throws Exception;

}

