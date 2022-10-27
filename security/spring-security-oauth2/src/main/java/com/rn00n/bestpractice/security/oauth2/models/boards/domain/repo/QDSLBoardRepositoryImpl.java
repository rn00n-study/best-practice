package com.rn00n.bestpractice.security.oauth2.models.boards.domain.repo;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.JPQLQuery;
import com.rn00n.bestpractice.security.oauth2.models.boards.domain.Board;
import com.rn00n.bestpractice.security.oauth2.models.boards.domain.QBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class QDSLBoardRepositoryImpl extends QuerydslRepositorySupport implements QDSLBoardRepository {

    public QDSLBoardRepositoryImpl() {
        super(Board.class);
    }

    @Override
    public Page<Board> searchQDSL(String search, Pageable pageable) {
        QBoard board = QBoard.board;

        JPQLQuery<Board> query = from(board)
                .where(board.title.equalsIgnoreCase(search)
                        .or(board.content.equalsIgnoreCase(search))
                );

        JPQLQuery<Board> jpqlQuery = getQuerydsl().applyPagination(pageable, query);
        QueryResults<Board> fetchResults = jpqlQuery.fetchResults();
        return new PageImpl<>(fetchResults.getResults(), pageable, fetchResults.getTotal());
    }

}
