<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Viet Quan
  Date: 12/09/2017
  Time: 6:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>コメントリスト</title>
    <style>
        html, body {
            height: 100%;
        }

        html {
            display: table;
            margin: auto;
        }

        body {
            display: table-cell;
            vertical-align: middle;
        }
    </style>
</head>
<body>
<table border="1">
    書籍名　${NameBook}

    <thead>
    <tr>
        <th>ID</th>
        <th>コメント</th>
        <th></th>
        <th></th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${dsComment}" var="LComment">
        <tr>
            <td>${LComment.book_review_id}</td>
            <td>${LComment.review}</td>
            <th><a href="UpdateComment?txtCommentId=${LComment.book_review_id}">修正</a></th>
            <th><a href="DeleteComment?txtCommentId=${LComment.book_review_id}">削除</a></th>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="AddComment?txtBookId=${bookIDGet}">追加</a>
</form>
<button type="button" name="back" onclick="history.back()">戻る</button>

</body>
</html>
