package com.snb.mgwoo.domain;

import java.util.Date;

public class BoardDto {
    private Integer bno;
    private String title;
    private String content;
    private String writer;
    private Date reg_date;
    private Date up_date;

    public BoardDto () {} ;
    public BoardDto(Integer bno, String title, String content, String writer, Date reg_date, Date up_date) {
        this.bno = bno;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.reg_date = reg_date;
        this.up_date = up_date;
    }

    public Integer getBno() {
        return bno;
    }

    public void setBno(Integer bno) {
        this.bno = bno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    public Date getUp_date() {
        return up_date;
    }

    public void setUp_date(Date up_date) {
        this.up_date = up_date;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "bno=" + bno +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", reg_date=" + reg_date +
                ", up_date=" + up_date +
                '}';
    }
}
