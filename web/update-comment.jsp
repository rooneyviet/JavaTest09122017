<%--
  Created by IntelliJ IDEA.
  User: Viet Quan
  Date: 12/09/2017
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>コメント更新</title>
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
<form method="POST" action="UpdateComment">
<p>感想　ID<input type="text" disabled name="txtReviewId" value="${commentbookResult.book_review_id}"></p>
    <p>書籍名<input type="text" size="30" disabled value="${commentbookResult.bookId.book_name}"></p>
    感想：<textarea name="txtReview" value="${commentbookResult.review}"　cols="40" rows="5">${commentbookResult.review}</textarea><br>


<input type="submit" name="comment-update" value="更新">
    </form>
<%
    Boolean success_update_comment = (Boolean)request.getAttribute("add_comment_true");
    if(success_update_comment!=null){
        if(success_update_comment){%>
<font color="red"> コメント修正できました。!</font>
<%}
    }
    %>
<button type="button" name="back" onclick="history.back()">戻る</button>
<br>
</body>
</html>
