<%--
  Created by IntelliJ IDEA.
  User: shini
  Date: 2024-06-10
  Time: 오후 5:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>게시물</title>
</head>
<body>
<h1>게시물읽기</h1>
<form action="<c:url value="board/write"/>" id="form" method="post">
    <input type="hidden" name="bno" value="${boardDto.bno}"  >
    <input type="text" name="title" value="${boardDto.title}" readonly placeholder="제목">
    <input type="text" name="writer" value="${boardDto.writer}" readonly placeholder="작성자">
    <textarea  name="content" value="${boardDto.content}" readonly placeholder="내용"></textarea>

</form>
<button type="button" id="writeBtn" class="btn">글쓰기</button>
<button type="button" id="listBtn" class="btn">목록</button>
<script>
document.getElementById('listBtn').addEventListener('click',function (){
window.location.href = '<c:url value="/board/list"/>'
    })

    document.getElementById('writeBtn').addEventListener('click', function (){
    // if(!confirm("글을 등록하시겠습니까?")) return;

    let form = document.getElementById('form');
    form.action = '<c:url value="/board/write"/>';
    form.method = 'post';
    form.submit();
    })

    </script>
</body>

</html>
