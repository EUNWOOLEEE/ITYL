<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>로그인 정보 세션 저장</h1>
    <%
      String userid = request.getParameter("userid");

      if (userid == null) {
          response.sendRedirect("loginForm.html");
          // 이전 기록이 없는 상태에서 새로운 요청 시작됨
      }
      else {
          String password = request.getParameter("password");
          // 세션이 유지되는 동안 일반적으로 id, name, nickname, tel로 설정함
          // 실무에서는 pw를 세션으로 잡지 않음

          // 값은 Object로 형변환되어 들어감
          application.setAttribute("userid", userid);
          application.setAttribute("password", password);

          out.println("안녕하세요>> " + userid + "<br>");
          out.println("<a href='loginInfo.jsp'>세션으로 저장된 로그인 정보 보기</a>");
      }
    %>
<%--    안녕하세요 <%=userid%>--%>
<%--    <br>--%>
<%--    <a href="/session/loginInfo.jsp">정보보기</a>--%>
</body>
</html>
