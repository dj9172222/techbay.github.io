package project;
import java.sql.*;

public class connector{
	public static Connection getCon()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/techbay","root","8967");
			return con;
			
		}
		catch(Exception e)
		{
			System.out.print(e);
			return null;
		}
	}
}
