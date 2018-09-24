<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="False"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>
<%
if(session.getAttribute("name")==null)
	response.sendRedirect("index.jsp");
%>
<div>Here are our videos...</div>
<a href="https://www.youtube.com/watch?v=4AhqahtZKYs&start_radio=1&list=RD4AhqahtZKYs">Vid1</a>
</body>
</html>