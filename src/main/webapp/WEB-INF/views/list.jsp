
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<html>
<head>

    <title>게시판</title>
</head>
<body>
<div>
    <form>
    <table>
        <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="boardDto">
        <tr>
            <td><c:out value="${boardDto.bno}"/></td>
            <td><a class="title-link" href="<c:url value='/board/read?bno=${boardDto.bno}'/>"><c:out value="${boardDto.title}" /></a></td>
            <td><c:out value="${boardDto.writer}"/></td>
            <td><fmt:formatDate pattern="yyyy.MM.dd" value="${boardDto.reg_date}"/></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
    </form>

</div>

</body>

</html>
