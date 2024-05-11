package Main;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Aerospace.DB;


/**
 * Servlet implementation class FileUpload
 */
@WebServlet("/FileUpload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
maxFileSize = 10737418240L,     // 10 GB
maxRequestSize = 10737418240L   // 100 gb
)
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ty=request.getParameter("type1");
		System.out.println("ty========="+ty);
		String csv1 ="D:/snehaworkspace/Aerospace"; //"D:/Project/WorkSpace2/plasma";/
	  	String csvFilePath1 ="",csvFilePath2="";
	  	PrintWriter s = response.getWriter();
		ResultSet rs = null,rs1=null;
		PrintWriter out=response.getWriter();
		if(ty.equals("production"))
		{
			 csvFilePath1 = csv1+"//WebContent//dataset//Hydroforming(pro).csv";
			 csvFilePath2= csv1+"//WebContent//dataset//CFM56machine(pro).csv";
			 try {
			 String qry =  "LOAD DATA INFILE '"+csvFilePath1+"'" +
  	    	       "INTO TABLE pro_hydroforming FIELDS TERMINATED BY ','" +
  	    	       "OPTIONALLY ENCLOSED by '\"'" +"IGNORE 1 LINES";
  	    Connection con=DB.getconnection();
  	    int ps=con.prepareStatement(qry).executeUpdate();
  	  String   qry2 =  "LOAD DATA INFILE '"+csvFilePath2+"'" +
	    	       "INTO TABLE pro_cfm56 FIELDS TERMINATED BY ','" +
	    	       "OPTIONALLY ENCLOSED by '\"'" +"IGNORE 1 LINES";
  	        int ps1=con.prepareStatement(qry2).executeUpdate();
  	        System.out.println("ps1=="+ps1+"ps----------"+ps);
			 }catch(Exception Ex)
			 {
				Ex.printStackTrace(); 
			 }
		}else if(ty.equals("Assembly"))
		{
			 csvFilePath1 = csv1+"//WebContent//dataset//fuselage_assembly.csv";
			 csvFilePath2= csv1+"//WebContent//dataset//landing_Assembly.csv";
			 try {
				 String qry =  "LOAD DATA INFILE '"+csvFilePath1+"'" +
	  	    	       "INTO TABLE fuselage_assembly FIELDS TERMINATED BY ','" +
	  	    	       "OPTIONALLY ENCLOSED by '\"'" +"IGNORE 1 LINES";
	  	    Connection con=DB.getconnection();
	  	    int ps=con.prepareStatement(qry).executeUpdate();
	  	    
	  	    
	  	  String   qry2 =  "LOAD DATA INFILE '"+csvFilePath2+"'" +
		    	       "INTO TABLE landinggear_assembly FIELDS TERMINATED BY ','" +
		    	       "OPTIONALLY ENCLOSED by '\"'" +"IGNORE 1 LINES";
	  	        int ps1=con.prepareStatement(qry2).executeUpdate();
	  	        System.out.println("ps1=="+ps1+"ps----------"+ps);
				 }catch(Exception Ex)
				 {
					Ex.printStackTrace(); 
				 }
		}
		else if(ty.equals("Test"))
		{
			csvFilePath1 = csv1+"//WebContent//dataset//Wind(Test).csv";
			 csvFilePath2= csv1+"//WebContent//dataset//Crash_machines(test).csv";
			 try {
				 String qry =  "LOAD DATA INFILE '"+csvFilePath1+"'" +
	  	    	       "INTO TABLE windtunnels_test FIELDS TERMINATED BY ','" +
	  	    	       "OPTIONALLY ENCLOSED by '\"'" +"IGNORE 1 LINES";
	  	    Connection con=DB.getconnection();
	  	    int ps=con.prepareStatement(qry).executeUpdate();
	  	  String   qry2 =  "LOAD DATA INFILE '"+csvFilePath2+"'" +
		    	       "INTO TABLE crash_test FIELDS TERMINATED BY ','" +
		    	       "OPTIONALLY ENCLOSED by '\"'" +"IGNORE 1 LINES";
	  	        int ps1=con.prepareStatement(qry2).executeUpdate();
	  	        System.out.println("ps1=="+ps1+"ps----------"+ps);
				 }catch(Exception Ex)
				 {
					Ex.printStackTrace(); 
				 } 
			 
		}
		
		out.print("<html><body><script> alert('File Uploaded Successfully...');</script></body></html>");
		RequestDispatcher rd = request.getRequestDispatcher("M_Main.jsp");
		rd.include(request, response);

		
		
	}

}
