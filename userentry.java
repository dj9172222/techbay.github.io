package project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class userentry
 */
@WebServlet("/userentry")
public class userentry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		
		String fullname=request.getParameter("name");
		String emailaddress=request.getParameter("email");
		String loginpassword=request.getParameter("password");
		try{
			Connection con=connector.getCon();
			PreparedStatement ps=con.prepareStatement("insert into user values(?,?,?)");
			ps.setString(1,fullname);
			ps.setString(2,emailaddress);
			ps.setString(3,loginpassword);
			ps.executeUpdate();
		}
		catch(Exception e){
			System.out.println(e);
			
		}
	}

}
