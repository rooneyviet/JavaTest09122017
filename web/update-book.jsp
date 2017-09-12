<%--
  Created by IntelliJ IDEA.
  User: Viet Quan
  Date: 12/09/2017
  Time: 5:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
<form method="POST" action="UpdateBook">
    <p><input type="text"  hidden name="txtBookId" value="${bookResult.book_id}"></p>
    書籍名前:<br>
    <input type="text" value="${bookResult.book_name}" name="txtName"><br>
    出版社:<br>
    <input type="text" value="${bookResult.book_publisher}" name="txtPublisher"><br>
    ページ：<br><input type="text" value="${bookResult.page}" name="txtPage"><br><br>
    <input type="submit" value="更新">
</form>
<button type="button" name="back" onclick="history.back()">戻る</button>
</body>
</html>
