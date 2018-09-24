<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${status }
<%
if(session.getAttribute("name")==null)
{
//	request.removeAttribute("")
	response.sendRedirect("index.jsp");
}

%> 
<h3>Welcome</h3> ${name }<h3>...You have successfully registered to our site...</h3><br>  
</body>
<form action="logout">
<input type="submit" value="Logout">
</form>
</html>