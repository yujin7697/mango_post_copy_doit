package com.example.demo.domain.dto;

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
}
