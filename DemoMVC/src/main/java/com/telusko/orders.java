package com.telusko;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class orders {
	int itemId;
	String custId;
	int id;
	int quant;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuant() {
		return quant;
	}
	public void setQuant(int quant) {
		this.quant = quant;
	}
	@RequestMapping("/orders")
	public ModelAndView order(HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, SQLException
	{
		System.out.println("AAAAAAAAAAAAAAAAAAAAa");
		HttpSession session=request.getSession();
		ModelAndView mv=new ModelAndView();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "Rebel@123");
		Statement st=con.createStatement();
		String query="select * from items where id=\""+session.getAttribute("itemId")+"\"";
		ResultSet rs=st.executeQuery(query);
		int val=0;
		while(rs.next())
		{
			System.out.println(rs.getInt("quant"));
			val=rs.getInt("quant");
			break;
		}
//		val=5;
		st.close();
		int ID=(Integer) session.getAttribute("itemId");
		int quan=Integer.parseInt(request.getParameter("quant"));
		System.out.println(quan);
		val=val-quan;
		String updt="update items set quant=? where id=?";
		PreparedStatement st1 = con.prepareStatement(updt);
		st1.setInt(1, val);
		st1.setInt(2, ID);		
		int x=st1.executeUpdate();
		System.out.println(quan);
		st1.close();
		con.close();
		orders order=new orders();
		order.setCustId((String) session.getAttribute("name"));
		order.setItemId(ID);
		order.setQuant(quan);
		Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "Rebel@123");
		String inst="insert into orders set itemId=?,custId=?,quant=?";
		PreparedStatement st2=con1.prepareStatement(inst);
		st2.setInt(1, order.getItemId());
		st2.setString(2, order.getCustId());
		st2.setInt(3, order.getQuant());
		st2.executeUpdate();
		mv.setViewName("order.jsp");
		return mv;
	}
}
