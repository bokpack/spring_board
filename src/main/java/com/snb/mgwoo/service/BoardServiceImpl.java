package com.snb.mgwoo.service;

import com.snb.mgwoo.dao.BoardDao;
import com.snb.mgwoo.domain.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardDao boardDao;

    @Override
    public BoardDto read(Integer bno) throws Exception {
        BoardDto boardDto =boardDao.select(bno);
        return boardDto;
    }

    @Override
    public int write(BoardDto boardDto) throws Exception {
        return boardDao.insert(boardDto);
    }


    @Override
    public List<BoardDto> getList() throws Exception {
        return boardDao.selectAll();
    }

    @Override
    public int delete(Integer bno) throws Exception {
        return boardDao.delete(bno);
    }

    @Override
    public int modify(BoardDto dto) throws Exception {
        return boardDao.update(dto);
    }


}
