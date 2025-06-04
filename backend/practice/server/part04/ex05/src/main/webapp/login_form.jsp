<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <fieldset>
        <legend>로그인 폼</legend>
        <form action="/login" method="get">
            <li>
                <label for="userid">아이디</label>
                <input type="text" id="userid" name="userid">
            </li>
            <li>
                <label for="userpw">비밀번호</label>
                <input type="password" id="userpw" name="userpw">
            </li>
            <li>
                <input type="submit" value="전송">
            </li>
        </form>
    </fieldset>
</body>
</html>
