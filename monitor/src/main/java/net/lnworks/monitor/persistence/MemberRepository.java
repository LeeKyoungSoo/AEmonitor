package net.lnworks.monitor.persistence;

import net.lnworks.monitor.domain.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MemberRepository extends CrudRepository <Member, String>{
    List<Member> findAll();
}
