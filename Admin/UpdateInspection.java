package Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Aerospace.DB;

/**
 * Servlet implementation class UpdateInspection
 */
@WebServlet("/UpdateInspection")
public class UpdateInspection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String base =request.getParameter("rs1");
		String mac_name =request.getParameter("comp_name");
		System.out.println("base===="+base);
		System.out.println("mac_name===="+mac_name);
		PrintWriter prw = response.getWriter();
		int i=0;
		if(mac_name.equals("CFM56-7B machine"))
		{
			if(base.equals("Accept"))
			{ 
				String 	qry= "UPDATE pro_cfm56 SET Status='Inspection Completed' where Status='Accepted' OR Status ='fault checked' ";
				try {
					i = DB.getconnection().prepareStatement(qry).executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(base.equals("Reject"))
			{ 
				String 	qry= "UPDATE pro_cfm56 SET Status='Inspection Failed' where Status='Accepted'  OR Status ='fault checked'";
				try {
					i = DB.getconnection().prepareStatement(qry).executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else if(mac_name.equals("Hydroforming Machine"))
		{
			if(base.equals("Accept"))
			{ 
				String 	qry= "UPDATE pro_hydroforming SET Status='Inspection Completed' where Status='Accepted'  OR Status ='fault checked'";
				try {
					i = DB.getconnection().prepareStatement(qry).executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(base.equals("Reject"))
			{ 
				String 	qry= "UPDATE pro_hydroforming SET Status='Inspection Failed' where Status='Accepted'  OR Status ='fault checked'";
				try {
					i = DB.getconnection().prepareStatement(qry).executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else if(mac_name.equals("fuselage assembly"))
		{
			if(base.equals("Accept"))
			{ 
				String 	qry= "UPDATE fuselage_assembly SET Status='Inspection Completed' where Status='Accepted'  OR Status ='fault checked'";
				try {
					i = DB.getconnection().prepareStatement(qry).executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(base.equals("Reject"))
			{ 
				String 	qry= "UPDATE fuselage_assembly SET Status='Inspection Failed' where Status='Accepted'  OR Status ='fault checked'";
				try {
					i = DB.getconnection().prepareStatement(qry).executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else if(mac_name.equals("Landing Gear"))
		{
			if(base.equals("Accept"))
			{ 
				String 	qry= "UPDATE landinggear_assembly SET Status='Inspection Completed' where Status='Accepted'  OR Status ='fault checked'";
				try {
					i = DB.getconnection().prepareStatement(qry).executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(base.equals("Reject"))
			{ 
				String 	qry= "UPDATE landinggear_assembly SET Status='Inspection Failed' where Status='Accepted'  OR Status ='fault checked'";
				try {
					i = DB.getconnection().prepareStatement(qry).executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else if(mac_name.equals("Crash test machines"))
		{
			if(base.equals("Accept"))
			{ 
				String 	qry= "UPDATE crash_test SET Status='Inspection Completed' where Status='Accepted'  OR Status ='fault checked'";
				try {
					i = DB.getconnection().prepareStatement(qry).executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(base.equals("Reject"))
			{ 
				String 	qry= "UPDATE crash_test SET Status='Inspection Failed' where Status='Accepted'  OR Status ='fault checked'";
				try {
					i = DB.getconnection().prepareStatement(qry).executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else if(mac_name.equals("wind tunnels"))
		{
			if(base.equals("Accept"))
			{ 
				String 	qry= "UPDATE windtunnels_test SET Status='Inspection Completed' where Status='Accepted'  OR Status ='fault checked'";
				try {
					i = DB.getconnection().prepareStatement(qry).executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(base.equals("Reject"))
			{ 
				String 	qry= "UPDATE windtunnels_test SET Status='Inspection Failed' where Status='Accepted'  OR Status ='fault checked'";
				try {
					i = DB.getconnection().prepareStatement(qry).executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if(i>0)
		{
			prw.print("<html><body><script> alert('Updated Successfully ...');</script></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("A_inspecport.jsp");
			rd.include(request, response);	
		}
		else
		{
			prw.print("<html><body><script> alert('Updated Failed ...');</script></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("A_inspecport.jsp");
			rd.include(request, response);	
		}
	}

}

