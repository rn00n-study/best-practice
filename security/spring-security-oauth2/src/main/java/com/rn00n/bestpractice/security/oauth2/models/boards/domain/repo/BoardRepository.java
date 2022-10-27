package com.rn00n.bestpractice.security.oauth2.models.boards.domain.repo;

import com.rn00n.bestpractice.security.oauth2.models.boards.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Serializable>, QDSLBoardRepository {
    @Query(nativeQuery = true, value = ""
            + " SELECT *"
            + " FROM board b"
            + " WHERE b.title like '%:search%'"
    )
    List<Board> searchCustom(String search, Pageable pageable);

    Page<Board> findByTitleContainsOrContentContains(String search, Pageable pageable);
}
