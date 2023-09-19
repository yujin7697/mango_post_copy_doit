package com.example.demo.domain.dto;

import com.example.demo.domain.entity.Board;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardDto {
    private Long number;
    private String id;
    private String contents;
    private LocalDateTime date;
    private Long hits;
    private Long likeCount;

    public static BoardDto Of(Board board) {
        BoardDto dto = new BoardDto();
        dto.number = board.getNumber();
        dto.id=board.getId();
        dto.contents = board.getContents();
        dto.date = board.getDate();
        dto.hits = board.getHits();
        dto.likeCount  = board.getLikeCount();
        return dto;
    }
}
