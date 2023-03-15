package project;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class contactus
 */
@WebServlet("/contactus")
public class contactus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=session.getAttribute("name").toString();
		String subject=request.getParameter("email");
		String body=request.getParameter("message");

		try
		{
			Connection con=connector.getCon();
			PreparedStatement ps=con.prepareStatement("insert into message(email,subject,body) values(?,?,?)");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, message);
			ps.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		

		// TODO Auto-generated method stub
	}

}
