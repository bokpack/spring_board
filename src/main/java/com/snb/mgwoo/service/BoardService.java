package com.snb.mgwoo.service;

import com.snb.mgwoo.domain.BoardDto;

import java.util.List;

public interface BoardService {
    BoardDto read(Integer bno) throws Exception;

    int write(BoardDto boardDto) throws Exception;

    int remove(Integer bno) throws Exception;

    int update(BoardDto boardDto) throws Exception;

    List<BoardDto> getList() throws Exception;
}
