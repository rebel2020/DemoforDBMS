<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
<div style="color: red;">  ${status } </div>
<h1>Please enter the details...</h1><br>
<form action="register1">
name:      <input name="name" type="text"><br>
username:  <input name="username" type="text"><br>
password:  <input name="password" type="password"><br>
city:      <input name="city" type="text"><br>
address:   <input name="address" type="text"><br>
<input type="submit" Value="Register">
</form>
</body>
</html>