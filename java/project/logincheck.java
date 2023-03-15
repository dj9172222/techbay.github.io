package project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class logincheck
 */
@WebServlet("/logincheck")
public class logincheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String emailaddress=request.getParameter("emailaddress");
		String loginpassword=request.getParameter("loginpassword");
		
			int z=0;
			try
			{
				Connection con=connector.getCon();
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from user where email='"+email+"' and password='"+password+"'" );
				while(rs.next())
				{
					z=1;
					HttpSession session=request.getSession();
					session.setAttribute("email", email);
					response.sendRedirect("home.jsp");
				}
				if(z==0)
				{
					response.sendRedirect("login.jsp?msg=notexist");
				}
			}
			catch(Exception e)
			{
				System.out.print(e);
				response.sendRedirect("login.jsp?msg=invalid");
			}
		}
		
		// TODO Auto-generated method stub
	}

}
