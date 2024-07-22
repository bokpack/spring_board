package com.snb.mgwoo.controller;

import com.snb.mgwoo.domain.BoardDto;
import com.snb.mgwoo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardService boardService;

    @GetMapping("/write")
    public String write(Model m) {
        m.addAttribute("mode","new");
        return "board";
    }

    @PostMapping("/write")
    public String writePost(@ModelAttribute BoardDto boardDto) {
        try {
            System.out.println("bno: " + boardDto.getBno());
            System.out.println("title: " + boardDto.getTitle());
            System.out.println("content: " + boardDto.getContent());
            System.out.println("writer: " + boardDto.getWriter());
            System.out.println("reg_date: " + boardDto.getReg_date());
            System.out.println("up_date: " + boardDto.getUp_date());

            boardService.write(boardDto); // boardDto에 포함된 데이터를 데이터베이스에 저장
            return "redirect:/board/list"; // 글 등록 후 목록 페이지로 리다이렉트
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/board/write"; // 실패 시 글쓰기 페이지로 리다이렉트
        }
    }


    // 그냥 List 화면
    @GetMapping("/list")
    public String list(Model m) throws Exception {
        m.addAttribute("list", boardService.getList());

        return "list";

    }
    // 내가 짠 C
//    @GetMapping("/write")
//    public String write(BoardDto dto) throws Exception {
//        boardService.insert(dto);
//        return "redirect:/board/list";
//    }

    // 하나의 게시물 보이기
    @GetMapping("/read")
    public String read(Integer bno, Model m) {
        try {
            BoardDto boardDto = boardService.read(bno);
            m.addAttribute("boardDto", boardDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "board";
    }

    //  삭제
    @PostMapping("/delete")
    public String remove(Integer bno, RedirectAttributes rttr) throws Exception {

        boardService.delete(bno);

        rttr.addAttribute("result", "delete success");

        return "redirect:/board/list";
    }

    @GetMapping("/modify")
    public String edit(@RequestParam("bno") int bno, Model m) {
        try {
            BoardDto boardDto = boardService.read(bno); // bno에 해당하는 게시글을 가져옴
            m.addAttribute("boardDto", boardDto);
            m.addAttribute("mode", "modify");
            return "board"; // 수정 페이지로 이동
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/board/list"; // 실패 시 목록 페이지로 리다이렉트
        }
    }

    @PostMapping("/modify")
    public String editPost(@ModelAttribute BoardDto boardDto) {
        try {
            System.out.println("bno: " + boardDto.getBno());
            System.out.println("title: " + boardDto.getTitle());
            System.out.println("content: " + boardDto.getContent());
            System.out.println("writer: " + boardDto.getWriter());
            System.out.println("reg_date: " + boardDto.getReg_date());
            System.out.println("up_date: " + boardDto.getUp_date());

            boardService.modify(boardDto); // boardDto에 포함된 데이터를 데이터베이스에 업데이트
            return "redirect:/board/list"; // 수정 후 목록 페이지로 리다이렉트
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/board/edit?bno=" + boardDto.getBno(); // 실패 시 수정 페이지로 리다이렉트
        }
    }

}
