package net.lnworks.monitor.persistence;

import net.lnworks.monitor.domain.MemberRole;
import org.springframework.data.repository.CrudRepository;

public interface MemberRoleRepsitory extends CrudRepository<MemberRole, String> {

}
