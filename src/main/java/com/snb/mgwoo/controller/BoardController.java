package com.snb.mgwoo.controller;

import com.snb.mgwoo.domain.BoardDto;
import com.snb.mgwoo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping("/list")
    public String List(Model m) throws Exception {
        m.addAttribute("list", boardService.getList());
        return "list";
    }
    @PostMapping("/read")
    public String read(Integer bno, Model m) throws Exception {
        try {
            BoardDto boardDto = boardService.read(bno);
            m.addAttribute("boardDto", boardDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "board";

    }
}
