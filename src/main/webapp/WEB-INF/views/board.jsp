<%--
  Created by IntelliJ IDEA.
  User: shini
  Date: 2024-06-10
  Time: 오후 5:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시물읽기</title>
</head>
<body>
<h1>게시물읽기</h1>
<form>
    <input type="text" name="bno" value="${boardDto.bno}">
    <input type="text" name="title" value="${boardDto.title}">
    <input type="text" name="writer" value="${boardDto.writer}">
    <input type="text" name="content" value="${boardDto.content}">

</form>

</body>
</html>
