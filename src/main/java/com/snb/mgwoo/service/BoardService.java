package com.snb.mgwoo.service;

import com.snb.mgwoo.domain.BoardDto;

import java.util.List;

public interface BoardService {
    BoardDto read(Integer bno) throws Exception;

    int write(BoardDto boardDto) throws Exception;

    int delete(Integer bno) throws Exception;

    int modify(BoardDto boardDto) throws Exception;

    List<BoardDto> getList() throws Exception;
}
