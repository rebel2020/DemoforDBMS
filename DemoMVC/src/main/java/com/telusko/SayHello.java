package com.telusko;
import java.sql.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class SayHello {
	@RequestMapping("/hello")
	public static ModelAndView main(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		String url="jdbc:mysql://localhost:3306/db1";
		String uname="root";
//		uname=request.getParameter("t1");
		String pass="Rebel@123";
//		pass=request.getParameter("t2");
		String sname=request.getParameter("t1");
		int id=Integer.parseInt(request.getParameter("t2"));
		String insertQuery="insert into students set name='"+sname+"',id="+id;
		String deleteQuery="delete from students";
		String query="select * from students";
		ModelAndView mv=new ModelAndView();
		mv.setViewName("sayhello.jsp");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,uname,pass);
		Statement st= con.createStatement();
		int res=st.executeUpdate(insertQuery);
		ResultSet rs=st.executeQuery(query);
		String name = "";
		while(rs.next())
		{
			name +=rs.getInt("id")+ " : " + rs.getString("name") +"<br>";
		}
		mv.addObject("rs",name);
		mv.addObject("it",res+" Row/s affected... ");
		st.close();
		con.close();
		return mv;
	}
	
}
