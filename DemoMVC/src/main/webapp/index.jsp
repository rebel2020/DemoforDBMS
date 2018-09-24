<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<body>
<h2>Hello World!</h2><br>
${status }
<form action="login">
<h1>Enter the cridentials...</h1><br>
Enter username:  <input type="text" name="uname"><br>
Enter password:  <input type="password" name="pass"><br>
<input type="submit" value="Login">
</form>
<form action="register">
<input value="Register" type="submit">
</form>
</body>
</html>
