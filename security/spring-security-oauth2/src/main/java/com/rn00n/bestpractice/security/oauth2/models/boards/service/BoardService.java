package com.rn00n.bestpractice.security.oauth2.models.boards.service;

import com.rn00n.bestpractice.security.oauth2.models.boards.domain.Board;
import com.rn00n.bestpractice.security.oauth2.models.boards.domain.repo.BoardRepository;
import com.rn00n.bestpractice.security.oauth2.models.boards.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository repository;

    public Board create(BoardDto.Create dto) {
        Board board = dto.toEntity();
        return repository.save(board);
    }

    public Board findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 board id 입니다."));
    }

    public Page<BoardDto.Response> searchQDSL(BoardDto.Search dto, Pageable pageable) {
        List<String> strings1 = List.of("1", "2");
        List<String> strings2 = List.of("3", "4");
        List<String> response = new LinkedList<>();
        response.addAll(strings1);
        response.addAll(strings2);

        Page<Board> boardPage = repository.searchQDSL(dto.getSearch(), pageable);
        return boardPage.map(BoardDto.Response::of);
    }
}
