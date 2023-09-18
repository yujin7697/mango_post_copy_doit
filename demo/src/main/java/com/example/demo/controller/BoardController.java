package com.example.demo.controller;

import com.example.demo.domain.entity.Board;
import com.example.demo.domain.repository.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
public class BoardController {
    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/list")
    public List<Board> list(){
        System.out.println("GET /list");

        return boardRepository.findAll();
    }

}
