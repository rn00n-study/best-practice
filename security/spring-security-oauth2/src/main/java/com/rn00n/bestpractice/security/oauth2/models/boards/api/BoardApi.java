package com.rn00n.bestpractice.security.oauth2.models.boards.api;

import com.rn00n.bestpractice.security.oauth2.models.boards.domain.Board;
import com.rn00n.bestpractice.security.oauth2.models.boards.dto.BoardDto;
import com.rn00n.bestpractice.security.oauth2.models.boards.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardApi {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody BoardDto.Create dto) {
        Board response = boardService.create(dto);
        return ResponseEntity.created(URI.create("/api/boards/" + response.getId()))
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        Board response = boardService.findById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<?> search(BoardDto.Search dto, @PageableDefault(size = 5) Pageable pageable) {
        Page<BoardDto.Response> responsePage = boardService.searchQDSL(dto, pageable);
        return ResponseEntity.ok(responsePage);
    }

}
