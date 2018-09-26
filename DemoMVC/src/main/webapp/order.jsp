<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.sql.*" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "Rebel@123");
Statement st=con.createStatement();
String query="select * from orders where custId=\""+request.getSession().getAttribute("name")+"\"";
ResultSet rs=st.executeQuery(query);
out.println("Here is the list of your orders...<br>");
while(rs.next())
{
	out.println("<div style=\"float:left;width:30%;background-color:red;margin-left:5%;margin-top:5%;\"><h4 style=\"margin-left:10%\">OrderId:"+rs.getInt("orderId")+"</h4><h5 style=\"margin-left:10%\">ItemId:"+rs.getString("itemId")+" has Quantity:"+rs.getInt("quant")+"</h5></div>");
}
%>
<body>

</body>
</html>