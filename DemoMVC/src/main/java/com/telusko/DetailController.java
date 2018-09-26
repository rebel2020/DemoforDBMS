package com.telusko;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import models.items;

@Controller
public class DetailController {

	@RequestMapping("/detail")
	public ModelAndView detail(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, SQLException
	{
		String query="select * from items";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "Rebel@123");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		items item = new items();
		String id=request.getParameter("id");
		while(rs.next())
		{
			if(Integer.parseInt(id)==rs.getInt("id"))
			{
				item.name=rs.getString("name");
				item.id=rs.getInt("id");
				item.discription=rs.getString("discription");
				item.quant=rs.getInt("quant");
				break;
			}
		}
		System.out.println(id);
		ModelAndView mv=new ModelAndView();
		mv.addObject("item",item);
		mv.setViewName("detail.jsp");
		return mv;
	}
}
