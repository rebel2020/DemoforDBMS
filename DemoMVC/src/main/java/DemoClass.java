import java.sql.*;
public class DemoClass {
	public static void main(String[] args) throws Exception
	{
		String url="jdbc:mysql://localhost:3306/db1";
		String uname="rebel";
		String pass="";
		String query="select * from students";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,uname,pass);
		Statement st= con.createStatement();
		ResultSet rs=st.executeQuery(query);
		String name = rs.getString("name");
		System.out.println(name);
	}
}
