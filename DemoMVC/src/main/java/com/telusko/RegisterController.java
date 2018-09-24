package com.telusko;
import java.sql.*;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {
	@RequestMapping("/register")
	public void register(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		response.sendRedirect("registerform.jsp");
	}
	@RequestMapping("/register1")
	public ModelAndView register1(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException
	{
		String name=request.getParameter("name");
		String uname=request.getParameter("username");
		String pass=request.getParameter("password");
		String add=request.getParameter("address");
		String isTaken="select * from users where username='"+ uname+"'";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "Rebel@123");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(isTaken);
		if((rs.next()))
		{
			ModelAndView mv=new ModelAndView();
			mv.setViewName("registerform.jsp");
			mv.addObject("status","Username already exists...<br>");
			st.close();
			con.close();
			return mv;
		}
		else
		{
			String registerQuery="insert into users set name='"+name+"',username='"+uname+"',password='"+pass+"',address='"+add+"'";
			Statement st1=con.createStatement();
			int res=st1.executeUpdate(registerQuery);
			HttpSession session=request.getSession();
			session.setAttribute("name",uname);
			ModelAndView mv=new ModelAndView();
			mv.setViewName("welcome.jsp");
			mv.addObject("status",", you've successfully registered...<br>");
			return mv;
		}
	}
	@RequestMapping("/logout")
	public void logout(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		HttpSession session=request.getSession();
		session.removeAttribute("name");
		session.invalidate();
		response.sendRedirect("index.jsp");
	}
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, SQLException
	{
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "Rebel@123");
		Statement st=con.createStatement();
		String query="select * from users where username='"+uname+"' and password='"+pass+"'";
		ResultSet rs=st.executeQuery(query);
		if(!rs.next())
		{
			ModelAndView mv=new ModelAndView();
			mv.setViewName("index.jsp");
			mv.addObject("status","Please enter the correct cridentials...<br>");
			return mv;
		}
		else
		{
			ModelAndView mv=new ModelAndView();
			mv.setViewName("welcome.jsp");
			mv.addObject("status",", You're in...<br>");
			HttpSession session=request.getSession();
			session.setAttribute("name", uname);
			return mv;
		}
	}
}
