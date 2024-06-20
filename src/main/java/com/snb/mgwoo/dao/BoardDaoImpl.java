package com.snb.mgwoo.dao;

import com.snb.mgwoo.domain.BoardDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDaoImpl implements BoardDao {
    @Autowired
    SqlSession session;

    private String namespace = "com.snb.mgwoo.mapper.boardMapper.";

    @Override
    public List<BoardDto> selectAll() throws Exception {
        return session.selectList(namespace + "selectAll");
    }

    @Override
    public BoardDto select(Integer bno) throws Exception {
        return session.selectOne(namespace +"select",bno);
    }

    @Override
    public int insert(BoardDto boardDto) throws Exception {
        return session.insert(namespace + "insert",boardDto);
    }

    @Override
    public int delete(Integer bno) throws Exception {
        return session.delete(namespace + "delete", bno);
    }

    @Override
    public int deleteAll() throws Exception {
        return session.delete(namespace +"deleteAll");
    }

    @Override
    public int update(BoardDto boardDto) throws Exception {
        return session.update(namespace + "update", boardDto);
    }




}
