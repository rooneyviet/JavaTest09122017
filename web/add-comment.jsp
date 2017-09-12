<%--
  Created by IntelliJ IDEA.
  User: Viet Quan
  Date: 12/09/2017
  Time: 7:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>コメント送信</title>
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
感想追加:
<form method="POST" action="AddComment">
    感想/コメント:<br>
    <textarea name="txtReview" cols="40" rows="5"></textarea>
    <input type="text" hidden value="${GetbookID}" name="txtBookID"><br>

    <input type="submit" value="送信">
</form>
<button type="button" name="back" onclick="history.back()">戻る</button>
</body>
</html>
