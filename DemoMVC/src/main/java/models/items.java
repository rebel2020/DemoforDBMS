
package models;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument.Iterator;

import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.tools.javac.util.List;



public class items extends HttpServlet {
	public String name;
	public String discription;
	public int id;
	public int quant;
	public int getQuant()
	{
		return this.quant;
	}
	public String getName()
	{
		return this.name;
	}
	public int getId()
	{
		return this.id;
	}
	public String getDiscription()
	{
		return this.discription;
	}
	@RequestMapping("/items")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
//		response.sendRedirect("welcome.jsp");
		try {
			String query = "select * from items";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "Rebel@123");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			String s="";
			int i=5;
//			ArrayList<items> V = new ArrayList<items>();
			Vector<items> V =new Vector<items>();
//			List<items> list = new ArrayList<items>();
			while(rs.next())
			{
				items itm=new items();
				itm.name=rs.getString("name");
				itm.id=rs.getInt("id");
				itm.discription=rs.getString("discription");
				itm.quant=rs.getInt("quant");
				V.add(itm);
//				byte[] img = rs.getBytes("image");
//				response.setContentType("image/jpg");
//				OutputStream os=response.getOutputStream();
//				os.write(img);
//				os.flush();
//				os.close();
//				s+="<img src=\""+"file:///home/rebel/Database/img1.jpg"+"\">image</img><h5>"+rs.getString("name")+"  "+rs.getString("discription")+"</h5><br>";
			}
			java.util.Iterator<items> itr=  V.iterator();
//			while(((java.util.Iterator<items>) itr).hasNext())
//			while(itr.hasNext())
//			{
//				System.out.println(itr.next().name+"AAAAAA");
//			}
			request.setAttribute("a", V);
			RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
			rd.forward(request, response);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
