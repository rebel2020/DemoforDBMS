<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
if(session.getAttribute("name")==null)
{
//	request.removeAttribute("")
	response.sendRedirect("index.jsp");
}

%>   
</body>
<h3>Welcome ${name }  ${status }</h3><br>
<div><a href="display.jsp">Link to videos...</a></div>
<form action="logout">
<input type="submit" value="Logout">
</form>
</html>