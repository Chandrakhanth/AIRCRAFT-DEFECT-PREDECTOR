package Admin;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Aerospace.DB;


/**
 * Servlet implementation class Updateuser
 */
@WebServlet("/Updateuser")
public class Updateuser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email =request.getParameter("email1");
		String name =request.getParameter("name1");
		String base =request.getParameter("rs1");
		int i=0;
		PrintWriter prw = response.getWriter();	
		System.out.println("email======"+email);
		System.out.println("name=========="+name);
	if(base.equals("Accept"))
	{
		try {
	String 	qry= "UPDATE users SET status='Accepted' WHERE mail='"+ email +"' And name='"+name+"'";
		i = DB.getconnection().prepareStatement(qry).executeUpdate();
		if(i>0)
		{
			prw.print("<html><body><script> alert('Updated Successfully...');</script></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("A_users.jsp");
			rd.include(request, response);	
		}else
		{
			prw.print("<html><body><script> alert('Updation Failed...');</script></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("A_users.jsp");
			rd.include(request, response);	
		}
		
		}catch(Exception Ex)
		{
			Ex.getStackTrace();
		}
	}
	else if(base.equals("Reject"))
	{
		try {
			String 	qry= "UPDATE users SET status='Rejected' WHERE mail='"+ email +"' And name='"+name+"'";
				i = DB.getconnection().prepareStatement(qry).executeUpdate();
				if(i>0)
				{
					prw.print("<html><body><script> alert('Updated Successfully...');</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("A_users.jsp");
					rd.include(request, response);	
				}else
				{
					prw.print("<html><body><script> alert('Updation Failed...');</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("A_users.jsp");
					rd.include(request, response);	
				}
				
				}catch(Exception Ex)
				{
					Ex.getStackTrace();
				}
	}
	}

}
