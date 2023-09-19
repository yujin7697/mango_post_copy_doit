package com.example.demo.controller;

import com.example.demo.domain.dto.BoardDto;
import com.example.demo.domain.dto.UserDto;
import com.example.demo.domain.entity.Board;
import com.example.demo.domain.repository.BoardRepository;
import com.example.demo.domain.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
public class BoardController {
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public List<Board> list(Model model){
        log.info("GET /list");

        List<Board> list = boardRepository.findAll();
        model.addAttribute("board", list);

        return list;
    }

    @GetMapping("/post")
    public void post_get(){
        log.info("GET /post");
    }

    @PostMapping("/post")
    public String post_post(@Valid BoardDto dto, BindingResult bindingResult, Model model) {
        log.info("POST /post");

        if (bindingResult.hasErrors()) {
            return "post_form"; // 유효성 검사 에러 시 다시 폼으로 돌아갑니다.
        }

        boolean isadd = boardService.addBoard(dto);
        if(isadd) {
            return "redirect:/list";
        }
        return "redirect:/post";
    }


}
