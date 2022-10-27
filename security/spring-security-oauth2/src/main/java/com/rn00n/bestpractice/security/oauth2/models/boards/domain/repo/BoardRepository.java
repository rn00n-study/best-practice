package com.rn00n.bestpractice.security.oauth2.models.boards.domain.repo;

import com.rn00n.bestpractice.security.oauth2.models.boards.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface BoardRepository extends JpaRepository<Board, Serializable>, QDSLBoardRepository {
}
