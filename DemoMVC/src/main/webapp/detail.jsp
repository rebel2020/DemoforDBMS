<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.Vector" %>
<%@ page import="models.items" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
items item=(items)request.getAttribute("item");
%>
<div style="background-color: red;folat:left;width: 30%;">
<h4 style="margin-left: 10%"><%out.println(item.getName()); %> </h4>
<h5 style="margin-left: 10%">Items remaining:<%out.println(item.getQuant()); %></h5>
<form action="orders">
<input name="quant" type="number" min="1" max=<%out.println("\""+item.getQuant()+"\""); %> value="1" required>
<input type="submit" value="Buy this item">
</form>
<%//System.out.println("AAAAAAAA");%>
<%session.setAttribute("itemId", item.getId()); %>
</div>
<%//out.println(((items)request.getAttribute("item")).getQuant());%>
</body>
</html>