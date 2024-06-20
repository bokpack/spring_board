package com.snb.mgwoo.dao;

import com.snb.mgwoo.domain.BoardDto;

import java.util.List;

public interface BoardDao {
    List<BoardDto> selectAll() throws Exception;

    BoardDto select(Integer bno) throws Exception;

    int insert(BoardDto boardDto) throws Exception;

    int delete(Integer bno) throws Exception;

    int deleteAll() throws Exception;

    int update(BoardDto boardDto) throws Exception;
}
