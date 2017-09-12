
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Viet Quan
  Date: 03/08/2017
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>書籍</title>
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
    <thead>
    <tr>
        <th>書籍名</th>
        <th>出版社</th>
        <th>ページ</th>
        <th></th>
        <th></th>
        <th></th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${dsbook}" var="ls">
        <tr>
            <td>${ls.book_name}</td>
            <td>${ls.book_publisher}</td>
            <td>${ls.page}</td>
            <th><a href="UpdateBook?txtBookId=${ls.book_id}">修正</a></th>
            <th><a href="DeleteBook?txtBookId=${ls.book_id}">削除</a></th>
            <th><a href="Comment?txtBookId=${ls.book_id}">感想</a></th>
        </tr>
    </c:forEach>
    </tbody>
</table>

Add New Book:
<form method="POST" action="book">
    書籍名:<br>
    <input type="text" name="txtName"><br>
    出版社:<br>
    <input type="text" name="txtPublisher"><br>
    ページ<br>
    <input type="text" name="txtPage"><br><br>
    <input type="submit" value="Add">
</form>
</body>
</html>
