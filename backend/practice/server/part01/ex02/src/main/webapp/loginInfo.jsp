<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>로그인 입력 파라미터 출력</h1>
    <%
        String userId = request.getParameter("userId");
        String userPwd = request.getParameter("userPwd");
    %>
    아이디값: <%= userId%><br>
    비밀번호: <%= userPwd%><br>
</body>
</html>
