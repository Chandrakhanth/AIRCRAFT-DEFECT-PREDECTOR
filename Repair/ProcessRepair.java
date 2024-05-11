package Repair;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.ResultSet;

import java.io.*;
import java.util.*;

import java.text.SimpleDateFormat;
import Aerospace.DB;
/**
 * Servlet implementation class ProcessRepair
 */
@WebServlet("/ProcessRepair")
public class ProcessRepair extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			String qry = "SELECT * FROM pro_cfm56 where Status ='Inspection Completed' OR Status ='fault checked' And action ='Minor' ";
			rs = (ResultSet)DB.getconnection().createStatement().executeQuery(qry);
		while (rs.next()) {
			String 	qry2= "UPDATE pro_cfm56 SET action ='Repair',Status='Done' WHERE mac_id='"+rs.getString(2) +"'And action ='Minor' ";
			io= DB.getconnection().prepareStatement(qry2).executeUpdate();	
		
	}
		String qry22 = "SELECT * FROM pro_cfm56 where Status ='Inspection Completed' OR Status ='fault checked' And action ='Major' ";
	ResultSet	rs14 = (ResultSet)DB.getconnection().createStatement().executeQuery(qry22);
	while (rs14.next()) {
		String 	qry2= "UPDATE pro_cfm56 SET action ='Replace',Status='Done' WHERE mac_id='"+rs14.getString(2) +"' And action ='Major'";
		io= DB.getconnection().prepareStatement(qry2).executeUpdate();	
	
}
		
		if(io>0)
		{
			prw.print("<html><body><script> alert(' Updated For Repair Process Successfully...');</script></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("R_sMAc.jsp");
			rd.include(request, response);	
		}
		else {
			prw.print("<html><body><script> alert('Updated Failed...');</script></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("R_sMAc.jsp");
			rd.include(request, response);	
		}
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
			String qry = "SELECT * FROM pro_hydroforming where Status = 'Inspection Completed' OR Status ='fault checked' And Action='Minor' ";
			rs = (ResultSet)DB.getconnection().createStatement().executeQuery(qry);
		while (rs.next()) {
			String 	qry2= "UPDATE pro_hydroforming SET Action ='Repair',Status='Done' WHERE mac_id='"+rs.getString(1) +"' And Action='Minor'";
			io= DB.getconnection().prepareStatement(qry2).executeUpdate();	
		
	}
		String qry15 = "SELECT * FROM pro_hydroforming where Status = 'Inspection Completed' OR Status ='fault checked' And Action='Major' ";
		ResultSet	rs21 = (ResultSet)DB.getconnection().createStatement().executeQuery(qry15);
	while (rs21.next()) {
		String 	qry2= "UPDATE pro_hydroforming SET Action ='Replace',Status='Done' WHERE mac_id='"+rs21.getString(1) +"' And Action='Major'";
		io= DB.getconnection().prepareStatement(qry2).executeUpdate();	
	
}
		
			prw.print("<html><body><script> alert('Updated For Repair Process Successfully...');</script></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("R_sMAc.jsp");
			rd.include(request, response);	
		
	
		
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
			String qry = "SELECT * FROM fuselage_assembly where  Action='Minor faults'";
			rs = (ResultSet)DB.getconnection().createStatement().executeQuery(qry);
		while (rs.next()) {
			String 	qry2= "UPDATE fuselage_assembly SET Action ='Repair',Status='Done' WHERE Machine_id='"+rs.getString(1) +"' And  Status ='Inspection Completed' OR Status ='fault checked' And Action='Minor faults' ";
			io= DB.getconnection().prepareStatement(qry2).executeUpdate();	
		
	}
		String qry22 = "SELECT * FROM fuselage_assembly where  Action='Major faults'";
		ResultSet	rs22 = (ResultSet)DB.getconnection().createStatement().executeQuery(qry22);
	while (rs22.next()) {
		String 	qry2= "UPDATE fuselage_assembly SET Action ='Replace',Status='Done' WHERE Machine_id='"+rs22.getString(1) +"' And  Status ='Inspection Completed' OR Status ='fault checked' And Action='Major faults' ";
		io= DB.getconnection().prepareStatement(qry2).executeUpdate();	
	
}
		
			prw.print("<html><body><script> alert('Updated For Repair Process Successfully...');</script></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("R_sMAc.jsp");
			rd.include(request, response);	
	
		
		
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
			String qry = "SELECT * FROM landinggear_assembly where Status ='Inspection Completed' OR Status ='fault checked' And Action='Minor'";
			rs = (ResultSet)DB.getconnection().createStatement().executeQuery(qry);
		while (rs.next()) {
			String 	qry2= "UPDATE landinggear_assembly SET Action ='Repair',Status='Done' WHERE Machine_id='"+rs.getString(1) +"'  And Action='Minor' ";
			io= DB.getconnection().prepareStatement(qry2).executeUpdate();	
		
	}
		String qry23 = "SELECT * FROM landinggear_assembly where Status ='Inspection Completed' OR Status ='fault checked' And Action='Major'";
		ResultSet		rs23 = (ResultSet)DB.getconnection().createStatement().executeQuery(qry23);
	while (rs23.next()) {
		String 	qry2= "UPDATE landinggear_assembly SET Action ='Replace',Status='Done' WHERE Machine_id='"+rs23.getString(1) +"'  And Action='Major' ";
		io= DB.getconnection().prepareStatement(qry2).executeUpdate();	
	
}
		if(io>0)
		{
			prw.print("<html><body><script> alert('Updated For Replacement Process Successfully..');</script></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("R_sMAc.jsp");
			rd.include(request, response);	
		}
		else {
			prw.print("<html><body><script> alert('Updated Failed...');</script></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("R_sMAc.jsp");
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
			String qry = "SELECT * FROM crash_test where Status ='Inspection Completed' OR Status ='fault checked' And Action ='Minor'";
			rs = (ResultSet)DB.getconnection().createStatement().executeQuery(qry);
		while (rs.next()) {
			String 	qry2= "UPDATE crash_test SET Action ='Repair',Status='Done' WHERE Machine_Id='"+rs.getString(1) +"' And Action='Minor'";
			io= DB.getconnection().prepareStatement(qry2).executeUpdate();	
		
	}
		String qry24 = "SELECT * FROM crash_test where Status ='Inspection Completed' OR Status ='fault checked' And Action ='Major'";
		ResultSet	rs24 = (ResultSet)DB.getconnection().createStatement().executeQuery(qry24);
	while (rs24.next()) {
		String 	qry2= "UPDATE crash_test SET Action ='Replace',Status='Done' WHERE Machine_Id='"+rs24.getString(1) +"' And Action='Major'";
		io= DB.getconnection().prepareStatement(qry2).executeUpdate();	
	
}
		if(io>0)
		{
			prw.print("<html><body><script> alert('Updated For Replacement Process Successfully...');</script></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("R_sMAc.jsp");
			rd.include(request, response);	
		}
		else {
			prw.print("<html><body><script> alert('Updated Failed...');</script></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("R_sMAc.jsp");
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
			String qry =  "SELECT * FROM windtunnels_test where Status ='fault checked' OR Status ='Inspection Completed' And Action ='Minor'";
			rs = (ResultSet)DB.getconnection().createStatement().executeQuery(qry);
		while (rs.next()) {
			String 	qry2= "UPDATE windtunnels_test SET Action ='Repair',Status='Done' WHERE Machine_Id='"+rs.getString(1) +"' And Status ='fault checked' OR Status ='Inspection Completed' And Action ='Minor'";
			io= DB.getconnection().prepareStatement(qry2).executeUpdate();	
		
	}String qry26 =  "SELECT * FROM windtunnels_test where Status ='fault checked' OR Status ='Inspection Completed' And Action ='Major'";
	ResultSet	rs32 = (ResultSet)DB.getconnection().createStatement().executeQuery(qry26);
while (rs32.next()) {
	String 	qry2= "UPDATE windtunnels_test SET Action ='Replace',Status='Done' WHERE Machine_Id='"+rs32.getString(1) +"' And Status ='fault checked' OR Status ='Inspection Completed' And Action ='Major'";
	io= DB.getconnection().prepareStatement(qry2).executeUpdate();	

}
		prw.print("<html><body><script> alert('Updated For Replacement Process Successfully...');</script></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("R_sMAc.jsp");
			rd.include(request, response);	
		
		}	catch(Exception ec)
		{
			ec.printStackTrace();
		}	
		}
	
	}

}
