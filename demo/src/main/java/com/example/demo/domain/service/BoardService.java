package com.example.demo.domain.service;

import com.example.demo.domain.dto.BoardDto;
import com.example.demo.domain.entity.Board;
import com.example.demo.domain.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.time.LocalDateTime;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Transactional(rollbackFor = SQLException.class)
    public boolean addBoard(BoardDto dto){

        Board board = new Board();
        board.setId(dto.getId());
        board.setContents(dto.getContents());
        board.setDate(LocalDateTime.now());
        board.setHits(0L);
        board.setLikeCount(0L);

        board = boardRepository.save(board);
        System.out.println("board : "+board);

        boolean issaved =  boardRepository.existsByNumber(board.getNumber());
        System.out.println("issaved : "+issaved);
        return issaved;
    }

}
