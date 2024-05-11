package Aerospace;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.ResultSet;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String role=request.getParameter("var");
		String useremail = request.getParameter("email");
		String userpassword = request.getParameter("password");
		PrintWriter prw = response.getWriter();	
		ResultSet rs = null,RS1=null;
		System.out.println("useremail======"+useremail);
		System.out.println("userpassword======"+userpassword);
		System.out.println("role");
		if(role.equals("admin"))
		{
		if((userpassword.equals("Admin@123"))&&(useremail.equals("Admin@gmail.com")))
		{
			prw.print("<html><body><script> alert('Login Successfully...');</script></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("A_admin.jsp");
			rd.include(request, response);
		}
		else {
			prw.print("<html><body><script> alert('Login Failed...');</script></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);
		}
		}
		else if(!role.equals("Admin"))
		{
			try {
			String qry = "SELECT * FROM users where role='"+role+"'";
			rs = (ResultSet) DB.getconnection().createStatement().executeQuery(qry);
			while(rs.next())
			{
			if((userpassword .equals(rs.getString(3)))&&(useremail.equals(rs.getString(2)))&&(rs.getString(6).equals("Accepted")) )
			{
				if(role.equals("Quality Control"))
				{
					prw.print("<html><body><script> alert('Login Successfully...');</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("Q_qualitycontrol.jsp");
					rd.include(request, response);
				}
				else if(role.equals("Enhancement"))
				{
					prw.print("<html><body><script> alert('Login Successfully...');</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("R_repair.jsp");
					rd.include(request, response);
				}
				else if(role.equals("Inspection"))
				{
					prw.print("<html><body><script> alert('Login Successfully...');</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("I_inspection.jsp");
					rd.include(request, response);
				}
				else if(role.equals("Maintenance"))
				{
					prw.print("<html><body><script> alert('Login Successfully...');</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("M_Main.jsp");
					rd.include(request, response);
				}
			}
			else 
			{
				prw.print("<html><body><script> alert('Login Failed...');</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.include(request, response);
			}
			}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}

}
