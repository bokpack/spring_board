list
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>게시판</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        #root {
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f4f4f4;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        .button-container {
            display: flex;
            justify-content: flex-end;
        }
        .button-container button {
            padding: 10px 20px;
            margin-left: 10px;
            background-color: salmon;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .button-container button:hover {
            background-color: #0056b3;
        }
        .button-container button:focus {
            outline: none;
        }
        .title-link {
            color: #007bff;
            text-decoration: none;
        }
        .title-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div id="root">
    <div class="button-container">
        <button type="button" id="writeBtn" onclick="location.href='<c:url value="/board/write"/>'">글쓰기sfsd</button>
    </div>
    <table>
        <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>등록일</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="boardDto">
            <tr>
                <td><c:out value="${boardDto.bno}" /></td>
                <td><a class="title-link" href="<c:url value='/board/read?bno=${boardDto.bno}'/>"><c:out value="${boardDto.title}" /></a></td>
                <td><c:out value="${boardDto.writer}" /></td>
                <td><fmt:formatDate value="${boardDto.reg_date}" pattern="yyyy-MM-dd"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
