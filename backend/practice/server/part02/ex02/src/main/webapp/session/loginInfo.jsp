<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>로그인 정보 보기</h1>
    <%
        String userid = session.getAttribute("userid").toString();
        if (userid == null) {
            response.sendRedirect("loginForm.html");
        }
        else {
            String password = session.getAttribute("password").toString();
            out.println("사용자 아이디값: " + userid + "<br>");
            out.println("사용자 비밀번호값: " + password + "<br>");
        }
    %>
<%--    사용자 id >> <%= userid %> <br>--%>
    <a href="/session/loginForm.html">로그아웃</a>
</body>
</html>
