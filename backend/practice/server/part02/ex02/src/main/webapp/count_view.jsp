<%@ page import="com.apple.eawt.Application" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>방문자수 조회하기 화면</h1>
    현재까지 총 방문자수: <%=application.getAttribute("count")%>
</body>
</html>
