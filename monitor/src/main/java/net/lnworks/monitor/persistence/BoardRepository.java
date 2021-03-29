package net.lnworks.monitor.persistence;

import net.lnworks.monitor.domain.Board;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long>, JpaSpecificationExecutor<Board> {
    List<Board> findBoardVoByTitle(String title);

    List<Board> findAll();
}
