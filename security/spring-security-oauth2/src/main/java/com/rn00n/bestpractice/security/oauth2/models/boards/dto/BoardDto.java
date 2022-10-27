package com.rn00n.bestpractice.security.oauth2.models.boards.dto;

import com.rn00n.bestpractice.security.oauth2.models.boards.domain.Board;
import lombok.Builder;
import lombok.Data;

public class BoardDto {

    @Data
    public static class Create {
        private String title;
        private String content;

        public Board toEntity() {
            Board board = new Board();
            board.setTitle(this.title);
            board.setContent(this.content);
            return board;
        }
    }

    @Data
    public static class Search {
        private String search;
    }

    @Data
    @Builder
    public static class Response {
        private Long id;
        private String title;
        private String content;

        public static Response of(Board board) {
            return Response.builder()
                    .id(board.getId())
                    .title(board.getTitle())
                    .content(board.getContent()¬)
                    .build();
        }
    }

}
