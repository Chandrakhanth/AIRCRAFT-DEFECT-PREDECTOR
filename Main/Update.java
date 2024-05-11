package Main;

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
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tablename=request.getParameter("table_name");
		System.out.println("tablename====="+tablename);
		int i=0;
		PrintWriter prw = response.getWriter();	
		
		try {
			if(tablename.equals("pro_cfm56"))
			{
			String 	qry= "UPDATE pro_cfm56 SET Status='Requested' where Status='Pending'";
				i = DB.getconnection().prepareStatement(qry).executeUpdate();
				System.out.println("i======="+i);
				if(i>0)
				{
					prw.print("<html><body><script> alert('Updated Successfully...');</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("M_Main sheet.jsp");
					rd.include(request, response);	
				}
			}
			else if(tablename.equals("pro_hydroforming"))
			{
				String 	qry= "UPDATE pro_hydroforming SET Status='Requested'";
					
					i = DB.getconnection().prepareStatement(qry).executeUpdate();
					if(i>0)
					{
						prw.print("<html><body><script> alert('Request Updated Successfully...');</script></body></html>");
						RequestDispatcher rd = request.getRequestDispatcher("M_Main sheet.jsp");
						rd.include(request, response);	
					}
				}
			else if(tablename.equals("fuselage_assembly"))
			{
				String 	qry= "UPDATE fuselage_assembly SET Status='Requested'";
					i = DB.getconnection().prepareStatement(qry).executeUpdate();
					if(i>0)
					{
						prw.print("<html><body><script> alert(' Request Updated Successfully...');</script></body></html>");
						RequestDispatcher rd = request.getRequestDispatcher("M_Main sheet.jsp");
						rd.include(request, response);	
					}
				}
			else if(tablename.equals("landinggear_assembly"))
			{
				String 	qry= "UPDATE landinggear_assembly SET Status='Requested' ";
					i = DB.getconnection().prepareStatement(qry).executeUpdate();
					if(i>0)
					{
						prw.print("<html><body><script> alert(' Request Updated Successfully...');</script></body></html>");
						RequestDispatcher rd = request.getRequestDispatcher("M_Main sheet.jsp");
						rd.include(request, response);	
					}
				}
			else if(tablename.equals("windtunnels_test"))
			{
				String 	qry= "UPDATE windtunnels_test SET Status='Requested'";
					i = DB.getconnection().prepareStatement(qry).executeUpdate();
					if(i>0)
					{
						prw.print("<html><body><script> alert(' Request Updated Successfully...');</script></body></html>");
						RequestDispatcher rd = request.getRequestDispatcher("M_Main sheet.jsp");
						rd.include(request, response);	
					}
			}
			else if(tablename.equals("crash_test"))
			{
				String 	qry= "UPDATE crash_test SET Status='Requested'";
					i = DB.getconnection().prepareStatement(qry).executeUpdate();
					if(i>0)
					{
						prw.print("<html><body><script> alert(' Request Updated Successfully...');</script></body></html>");
						RequestDispatcher rd = request.getRequestDispatcher("M_Main sheet.jsp");
						rd.include(request, response);	
					}
			}
		}catch(Exception Ex)
				{
					System.out.println(Ex.getMessage());
				}
		}

}
