package Repair;

import java.io.FileOutputStream;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.PureJavaCrc32Test.Table;

import Aerospace.staticuse;
 import com.itextpdf.text.pdf.PdfWriter;
 import com.itextpdf.text.Paragraph;
 import com.itextpdf.text.Font;
 import com.itextpdf.text.FontFactory;
 import com.itextpdf.text.Element;
 import com.itextpdf.text.Phrase;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfPCell;
 import com.itextpdf.text.pdf.PdfPTable;
 import com.itextpdf.text.Document;
 import com.itextpdf.text.DocumentException;
/**
 * Servlet implementation class report
 */
@WebServlet("/report")
public class report extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("JAVA PAGE");
		String company_name=request.getParameter("comp_name");
		PrintWriter prw = response.getWriter();	
		String no_faults=request.getParameter("faults");
		String result=request.getParameter("result");
		System.out.println("the machine name====="+company_name);
		System.out.println("no_faults====="+no_faults);
		System.out.println("result====="+result);
		String manifaults="",descrp="",fault="",solution1="",solution2="",solution3="",TYPE="";
		if(company_name.equals("Crash test machines"))
		{
			 TYPE="Testing Line";
			if(result.equals("Replace"))
			{
				descrp="The crash test machine applies the wrong amount of force during the test,the crash test machine vibrates excessively during the test,the crash test machine experiences an electrical fault during the test.";	
				manifaults="The cooling system is not working properly,the electrical system is not working properly,the timing system is not working properly,the components are not properly aligned.";
			 fault="Overheating,Electrical fault,Failure to activate,Improper timing,Excessive vibration,Incorrect force and Noise Issues";
			
			}
			else if(result.equals("Repair"))
			{
				descrp="The crash test machine applies the wrong amount of force during the test.";	
				manifaults="The cooling system is not working properly.";
			 fault="Overheating and Electrical fault";
			 solution1="Lubricate the bearings Fix the bearings if necessary.";
			 solution2="Check the cooling system for damage or malfunction. Repair or replace the cooling system if necessary.";
			 solution3="Align the components. Repair the components if necessary.";
			}
		}
		else if(company_name.equals("Hydroforming Machine"))
		{
			 TYPE="Production Line";
			if(result.equals("Replace"))
			{
				descrp="The crash test machine applies the wrong amount of force during the test,the crash test machine vibrates excessively during the test,the crash test machine experiences an electrical fault during the test.";	
				manifaults="The tooling used in the hydroforming process must be properly designed and manufactured in order to ensure that the final product meets specifications. Improper tooling can lead to a number of problems, including dimensional inaccuracies, surface defects, and premature wear";
			 fault=" leaks found, tighten, damages in hose ,fitting ,Improper tooling and Incorrect pressure and flow rate.";
			}
			else if(result.equals("Repair"))
			{
				descrp="The crash test machine applies the wrong amount of force during the test.";	
				manifaults="Leaks in the hydraulic system can lead to a loss of pressure, which can result in improper forming of the workpiece.";
			  fault=" tighten and damages in hose ";
			  solution1="Have the tooling re-designed or manufactured to meet your specific requirements.";
				 solution2="Inspect the hydraulic system for leaks regularly.";
				 solution3="Make sure that the support system is properly aligned with the die.";
			}
		}
		else if(company_name.equals("Landing Gear"))
		{
			TYPE="Assembly Line";
			if(result.equals("Replace"))
			{
				descrp="The actuator is not able to move the robot arm or joint,The controller is not able to control the robot arm or joint.";	
				manifaults="There are a number of other potential problems that can occur with landing gear,The power cord is damaged or disconnected.";
			   fault=" Actuator failure, Collision,Communication failure ,Controller failure ,damaged wiring, faulty connectors and malfunctioning switches..";
			}
			else if(result.equals("Repair"))
			{
				descrp="The crash test machine applies the wrong amount of force during the test.";	
				manifaults="There are a number of other potential problems that can occur with landing gear,The power cord is damaged or disconnected..";
			  fault=" faulty connectors and malfunctioning switches";
			    solution1="Landing gear doors that do not open or close properly";
				 solution2="Landing gear warning systems that do not work";
				 solution3="Erratic operation of the landing gear";
			}
		}
		else if(company_name.equals("fuselage assembly"))
		{
			TYPE="Production Line";
			TYPE="Assembly Line";
			if(result.equals("Replace"))
			{
				descrp="The actuator is not able to move the robot arm or joint,The controller is not able to control the robot arm or joint.";	
				manifaults="The adhesive being too thin, the bonding pressure being too high, or the bonding temperature being too high.";
			   fault="Adhesive failure,Bleedout,Contamination,Delamination,Porosity and Warpage";
			}
			else if(result.equals("Repair"))
			{
				descrp="The actuator is not able to move the robot arm or joint,The controller is not able to control the robot arm or joint.";	
				manifaults="The bonding surface is not clean. The adhesive is not clean. The tools and materials used are not clean.";
			  fault="Porosity and Warpage";
			  solution1="Use the correct type of adhesive for the application. Follow the manufacturer's instructions for curing the adhesive. Make sure that the bonding surface is clean and free of contaminants";
				 solution2="Clean the bonding surface thoroughly. Use clean tools and materials.";
				 solution3="Repair damaged wiring.";
			}
		}	
		
		else if(company_name.equals("CFM56-7B machine"))
		{
			TYPE="Testing Line";
			if(result.equals("Replace"))
			{
				descrp="A fan blade,compressor blade and turbine blade  has broken off, causing damage to the engine.";	
				manifaults="A turbine blade has broken off, causing damage to the engine.";
			   fault="Fan blade failure,Compressor blade failure,urbine blade failure and High turbine outlet temperature.";
			}
			else if(result.equals("Repair"))
			{
				descrp="There is a leak in the fuel system, causing the engine to run low on fuel.";	
				manifaults="It can be caused by a number of factors, including wear and tear, improper maintenance, or a blockage in the exhaust system.";
			  fault="Fan blade  and failures Compressor blade";
			  solution1="Inspect the compressor for damage..";
				 solution2="Clean the turbine";
				 solution3="Inspect the oil system for leaks.";
			}
		}
		else if(company_name.equals("wind tunnels"))
		{
			TYPE="Testing Line";
			if(result.equals("Replace"))
			{
				descrp="The wind tunnel is contaminated with dirt, dust, or other foreign particles.";	
				manifaults="The wind tunnel was not properly operated or maintained.";
			   fault="Model misalignment,Model instability,Boundary layer separation,Turbulence,Instrumentation errors and Regularly inspect and maintain the wind tunnel";
			}
			else if(result.equals("Repair"))
			{
				descrp="Air is leaking from the wind tunnel.";	
				manifaults="The air intake is not properly filtered.";
				fault="Model misalignment,Model instability,Boundary layer separation,Turbulence,Instrumentation errors and Regularly inspect and maintain the wind tunnel";
			     solution1="Repair the wind tunnel. Replace the wind tunnel if necessary.";
				 solution2="Check the fan for damage or obstructions. Replace the fan if necessary.";
				 solution3="Insulate the fan.";
			}
		}
		System.out.print("descrp"+descrp+"manifaults"+manifaults+"fault="+fault);
		Random random = new Random();
		int randomNumber = random.nextInt(100);
		String name="report"+randomNumber+"";
        System.out.println("file name====Report2"+randomNumber);
		if(result.equals("Repair"))
		{
			Document document = new Document();
		String path=staticuse.PROJ_LOCATION.concat("Reports2//").concat(name).concat(".pdf");
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
			document.open();
		float fntSize, lineSpacing;
		fntSize = 15.0f;
		lineSpacing = 40f;
		Paragraph p1 = new Paragraph(new Phrase(lineSpacing,company_name.concat(" Report"),FontFactory.getFont(FontFactory.COURIER, fntSize)));
		p1.setAlignment(Element.ALIGN_CENTER);
		p1.setAlignment(Element.ALIGN_CENTER);
		p1.setLeading(0,1);
		document.add(p1);
		document.add(Chunk.NEWLINE);;
		PdfPTable table = new PdfPTable(2);
		table.setWidthPercentage(100);
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
		table.getDefaultCell().setFixedHeight(70);
		table.addCell("MACHINE NAME");
		table.addCell(company_name);
		table.addCell("MACHINE TYPE");
		table.addCell(TYPE);
		table.addCell("NO OF FAULTS ");
		table.addCell(no_faults);
		table.addCell("MAJOR FAULTS");
		table.addCell(fault);
		table.addCell("FAULTS Cause");
		table.addCell(manifaults);
		table.addCell("DESCRIPTION");
		table.addCell(descrp);
		
		
		table.addCell("STATUS OF MACHINE");
		table.addCell(result);
		document.add(table); 
		document.close();
		
		HttpSession session =request.getSession();
		session.setAttribute("a", name);
		session.setAttribute("fullpath", path);
		RequestDispatcher rd = request.getRequestDispatcher("Download.jsp");
		rd.include(request, response);	
	
} catch (DocumentException e) {
			
			e.printStackTrace();
		}
		}
		else if(result.equals("Replace")) {
			Document document = new Document();
			String path=staticuse.PROJ_LOCATION.concat("Reports2//").concat(name).concat(".pdf");
			try {
				PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
				document.open();
			float fntSize, lineSpacing;
			fntSize = 15.0f;
			lineSpacing = 40f;
			Paragraph p1 = new Paragraph(new Phrase(lineSpacing,company_name.concat(" Report"),FontFactory.getFont(FontFactory.COURIER, fntSize)));
			p1.setAlignment(Element.ALIGN_CENTER);
			p1.setAlignment(Element.ALIGN_CENTER);
			p1.setLeading(0,1);
			document.add(p1);
			document.add(Chunk.NEWLINE);;
			PdfPTable table = new PdfPTable(2);
			table.setWidthPercentage(100);
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
			table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.getDefaultCell().setFixedHeight(70);
			table.addCell("MACHINE NAME");
			table.addCell(company_name);
			table.addCell("MACHINE TYPE");
			table.addCell(TYPE);
			table.addCell("NO OF FAULTS ");
			table.addCell(no_faults);
			table.addCell("MAJOR FAULTS");
			table.addCell(fault);
			table.addCell("FAULTS Cause");
			table.addCell(manifaults);
			table.addCell("DESCRIPTION");
			table.addCell(descrp);
			
			table.addCell("STATUS OF MACHINE");
			table.addCell(result);
			document.add(table); 
			document.close();
			HttpSession session =request.getSession();
			session.setAttribute("a", name);
			session.setAttribute("fullpath", path);
			RequestDispatcher rd = request.getRequestDispatcher("Download.jsp");
			rd.include(request, response);	
		
	} catch (DocumentException e) {
				
				e.printStackTrace();
			}
				
		}
		
	}

}
