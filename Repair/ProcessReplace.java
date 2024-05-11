package Repair;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.ResultSet;

import Aerospace.DB;

/**
 * Servlet implementation class ProcessReplace
 */
@WebServlet("/ProcessReplace")
public class ProcessReplace extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.out.println("backed end=------------------");
		PrintWriter prw = response.getWriter();	
		String base=request.getParameter("from");
		System.out.println("base==="+base);
	if(base.equals("CFM56-7B"))
	{
		ResultSet rs = null;
		int io=0;
		String sts="";	
		
		int temp=0;
		try {
			String qry = "SELECT * FROM pro_cfm56 where Status ='Inspection Completed' OR Status ='fault checked' And action ='Major' ";
			rs = (ResultSet)DB.getconnection().createStatement().executeQuery(qry);
		while (rs.next()) {
			String 	qry2= "UPDATE pro_cfm56 SET action ='Replace',Status='Done' WHERE mac_id='"+rs.getString(2) +"'And Action='Major'";
			io= DB.getconnection().prepareStatement(qry2).executeUpdate();	
		
	}
		
			prw.print("<html><body><script> alert('Updated Successfully...');</script></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("R_Replace.jsp");
			rd.include(request, response);	
		
		
		
		
		}	catch(Exception ec)
		{
			ec.printStackTrace();
		}
	}
	else if(base.equals("Hydroforming"))
	{
		ResultSet rs = null;
		int io=0;
		String sts="";	
		
		int temp=0;
		try {
			String qry = "SELECT * FROM pro_hydroforming where Status = 'Inspection Completed' OR Status ='fault checked' And Action='Major' ";
			rs = (ResultSet)DB.getconnection().createStatement().executeQuery(qry);
		while (rs.next()) {
			String 	qry2= "UPDATE pro_hydroforming SET Action ='Replace',Status='Done' WHERE mac_id='"+rs.getString(1) +"' And Action='Major'";
			io= DB.getconnection().prepareStatement(qry2).executeUpdate();	
		
	}
		if(io>0)
		{
			prw.print("<html><body><script> alert('Updated Successfully...');</script></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("R_Replace.jsp");
			rd.include(request, response);	
		}
		else {
			prw.print("<html><body><script> alert('Updated Failed...');</script></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("R_Replace.jsp");
			rd.include(request, response);	
		}
		}	catch(Exception ec)
		{
			ec.printStackTrace();
		}	
		
		
		
	}
	
	else if(base.equals("Fuselage"))
	{
		ResultSet rs = null;
		int io=0;
		String sts="";	
		
		int temp=0;
		try {
			String qry = "SELECT * FROM fuselage_assembly where  Action='Major faults' And  Status ='Inspection Completed' OR Status ='fault checked'";
			rs = (ResultSet)DB.getconnection().createStatement().executeQuery(qry);
		while (rs.next()) {
			String 	qry2= "UPDATE fuselage_assembly SET Action ='Replace',Status='Done' WHERE Machine_id='"+rs.getString(1) +"'  And Action='Major faults' ";
			io= DB.getconnection().prepareStatement(qry2).executeUpdate();	
		
	}
		if(io>0)
		{
			prw.print("<html><body><script> alert('Updated Successfully...');</script></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("R_Replace.jsp");
			rd.include(request, response);	
		}
		else {
			prw.print("<html><body><script> alert('Updated Failed...');</script></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("R_Replace.jsp");
			rd.include(request, response);	
		}
		}	catch(Exception ec)
		{
			ec.printStackTrace();
		}	
		}
	else if(base.equals("Landing"))
	{
		ResultSet rs = null;
		int io=0;
		String sts="";	
		
		int temp=0;
		try {
			String qry = "SELECT * FROM landinggear_assembly where Status ='Inspection Completed' OR Status ='fault checked' And Action='Major'";
			rs = (ResultSet)DB.getconnection().createStatement().executeQuery(qry);
		while (rs.next()) {
			String 	qry2= "UPDATE landinggear_assembly SET Action ='Replace',Status='Done' WHERE Machine_id='"+rs.getString(1) +"'  And Action='Major'";
			io= DB.getconnection().prepareStatement(qry2).executeUpdate();	
		
	}
		if(io>0)
		{
			prw.print("<html><body><script> alert('Updated Successfully...');</script></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("R_Replace.jsp");
			rd.include(request, response);	
		}
		else {
			prw.print("<html><body><script> alert('Updated Failed...');</script></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("R_Replace.jsp");
			rd.include(request, response);	
		}
		}	catch(Exception ec)
		{
			ec.printStackTrace();
		}	
		}
	else if(base.equals("Crash"))
	{
		ResultSet rs = null;
		int io=0;
		String sts="";	
		
		int temp=0;
		try {
			String qry = "SELECT * FROM crash_test where Status ='Inspection Completed' OR Status ='fault checked' And Action='Major'";
			rs = (ResultSet)DB.getconnection().createStatement().executeQuery(qry);
		while (rs.next()) {
			String 	qry2= "UPDATE crash_test SET Action ='Replace',Status='Done' WHERE Machine_Id='"+rs.getString(1) +"'  And Action='Major'";
			io= DB.getconnection().prepareStatement(qry2).executeUpdate();	
		
	}
		if(io>0)
		{
			prw.print("<html><body><script> alert('Updated Successfully...');</script></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("R_Replace.jsp");
			rd.include(request, response);	
		}
		else {
			prw.print("<html><body><script> alert('Updated Failed...');</script></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("R_Replace.jsp");
			rd.include(request, response);	
		}
		}	catch(Exception ec)
		{
			ec.printStackTrace();
		}	
		}
	else if(base.equals("Wind"))
	{
		ResultSet rs = null;
		int io=0;
		String sts="";	
		
		int temp=0;
		try {
			String qry =  "SELECT * FROM windtunnels_test where Status ='fault checked' OR Status ='Inspection Completed'  And Action='Major'";
			rs = (ResultSet)DB.getconnection().createStatement().executeQuery(qry);
		while (rs.next()) {
			String 	qry2= "UPDATE windtunnels_test SET Action ='Replace',Status='Done' WHERE Machine_Id='"+rs.getString(1) +"' And Status ='fault checked' OR Status ='Inspection Completed'  And Action='Major'";
			io= DB.getconnection().prepareStatement(qry2).executeUpdate();	
		
	}
	
			prw.print("<html><body><script> alert('Updated Successfully...');</script></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("R_Replace.jsp");
			rd.include(request, response);	
		
			
		
		}	catch(Exception ec)
		{
			ec.printStackTrace();
		}	
		}
	
	}

}
