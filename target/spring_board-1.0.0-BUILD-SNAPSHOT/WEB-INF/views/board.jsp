board
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <title>게시물 ${mode == "new" ? "글쓰기" : "읽기"}</title>
</head>
<body>
<form action="<c:url value='${mode == "new" ? "/board/write" : "/board/modify"}'/>" id="form" method="post">
    <input type="hidden" name="bno" value="${boardDto.bno}">
    <input type="text" name="writer" value="${boardDto.writer}" ${mode == "new" ? '' : 'readonly="readonly"'} placeholder="이름">
    <input type="text" name="title" value="${boardDto.title}" ${mode == "new" ? '' : 'readonly="readonly"'} placeholder="제목">

    <textarea name="content" cols="30" rows="10" ${mode == "new" ? '' : 'readonly="readonly"'}>${boardDto.content}</textarea>
    <button type="button" id="writeBtn" class="btn" ${mode == "new" ? '' : 'style="display:none;"'}>등록</button>
    <button type="button" id="modifyBtn" class="btn" ${mode == "new" ? 'style="display:none;"' : ''}>수정</button>
    <button type="button" id="completeBtn" class="btn" style="display:none;">완료</button>
    <button type="button" id="removeBtn" class="btn">삭제</button>
    <button type="button" id="listBtn" class="btn">목록</button>
    <div id="editStatus" style="display:none;">수정중</div>
</form>

<script>
    document.addEventListener("DOMContentLoaded", function() {
        document.getElementById('listBtn').addEventListener('click', function() {
            window.location.href = '<c:url value="/board/list"/>';
        });

        document.getElementById('removeBtn').addEventListener('click', function() {
            if (!confirm("정말로 삭제하시겠습니까?")) return;

            let form = document.getElementById('form');
            <%--form.action = '<c:url value="/board/delete"/>';--%>
            form.method = 'post';
            form.submit();
        });

        document.getElementById('writeBtn').addEventListener('click', function() {
            if (!confirm("글을 등록하시겠습니까?")) return;

            let form = document.getElementById('form');
            form.action = '<c:url value="/board/write"/>';
            form.method = 'post';
            form.submit();
        });

        document.getElementById('modifyBtn').addEventListener('click', function() {
            // 폼의 readonly 속성 해제
            let title = document.querySelector('input[name="title"]');
            let content = document.querySelector('textarea[name="content"]');

            title.removeAttribute('readonly');
            content.removeAttribute('readonly');

            // 수정중 상태 표시
            document.getElementById('editStatus').style.display = 'block';

            // 수정 버튼을 완료 버튼으로 변경
            document.getElementById('modifyBtn').style.display = 'none';
            document.getElementById('completeBtn').style.display = 'inline-block';
        });

        document.getElementById('completeBtn').addEventListener('click', function() {
            if (!confirm("글 수정을 완료하시겠습니까?")) return;

            let form = document.getElementById('form');
            <%--form.action = '<c:url value="/board/modify"/>';--%>
            form.method = 'post';
            form.submit();
        });
    });
</script>
</body>
</html>