<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>로그인 입력 화면</h1>
    <form action="loginInfo.jsp" method="get">
        <fieldset>
            <legend>로그인 폼</legend>
          <label>아이디<input name="userId" type="text"></label><br>
          <label>비밀번호<input name="userPwd" type="password"></label><br>
          <input type="submit" value="전송">
        </fieldset>
    </form>
</body>
</html>
