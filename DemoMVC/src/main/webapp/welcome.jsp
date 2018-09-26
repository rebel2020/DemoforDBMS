<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.io.OutputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<%@ page import = "javax.servlet.http.HttpServletRequest" %>
<%@ page import="java.io.OutputStream" %>
<%@ page import="models.items" %>
<%@ page import="java.util.Vector" %>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
<h3>Welcome ${name }  ${status }</h3><br>
<div><a href="display.jsp">Link to videos...</a></div>
<%
if(session.getAttribute("name")==null)
{
//	request.removeAttribute("")
	response.sendRedirect("index.jsp");
	return;
}

%>   
<div>
<%
	Vector list=(Vector) request.getAttribute("a");
	System.out.println(request.getAttribute("a"));
	if(list!=null)
	{
		java.util.Iterator<items> itr=  list.iterator();
		while(itr.hasNext())
		{
			items it=itr.next();
			out.println(it.getName());
			int x=it.getId();
			out.println("<a href=detail?id="+x+">"+it.getName()+"("+it.getDiscription()+")</br><br>");
		}
	}
//	HttpSession session =request.getSession();
	session.setAttribute("a", list);
	ModelAndView mv=new ModelAndView();
	mv.addObject("asd","AAA");
//	return mv;
//	request.setAttribute("a", list);
//	out.println(list);
%>
<img alt="" src="${image }">

<h5><a href="index.jsp?param= <%=session.getAttribute("name") %>>" >logout...</a></h5>
</div>
<form action="logout">
<input type="submit" value="Logout">
</form>
</html>