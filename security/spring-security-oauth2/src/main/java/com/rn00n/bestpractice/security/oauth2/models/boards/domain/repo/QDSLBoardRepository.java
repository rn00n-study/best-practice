package com.rn00n.bestpractice.security.oauth2.models.boards.domain.repo;

import com.rn00n.bestpractice.security.oauth2.models.boards.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QDSLBoardRepository {
    Page<Board> searchQDSL(String search, Pageable pageable);
}
