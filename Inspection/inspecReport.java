package Inspection;

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
 * Servlet implementation class inspecReport
 */
@WebServlet("/inspecReport")
public class inspecReport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mach_name=(String)request.getParameter("comp_name");
		System.out.println("mach_name"+mach_name);
		String Type="";
		Random random = new Random();
		int randomNumber = random.nextInt(100);
		String name="";
        System.out.println("file name====Report2"+randomNumber);
		if(mach_name.equals("CFM56-7B machine"))
		{
			Type="Production Line";
			name="CFM56-7Breport"+randomNumber+"";
			Document document = new Document();
			String path=staticuse.PROJ_LOCATION.concat("InspectionReports//").concat(name).concat(".pdf");
			try {
				PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
				document.open();
			float fntSize, lineSpacing;
			fntSize = 15.0f;
			lineSpacing = 40f;
			Paragraph p1 = new Paragraph(new Phrase(lineSpacing,mach_name.concat(" Report"),FontFactory.getFont(FontFactory.COURIER, fntSize)));
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
			table.addCell(mach_name);
			table.addCell("MACHINE TYPE");
			table.addCell(Type);
			table.addCell("NO OF FAULTS ");
			table.addCell("28");
			table.addCell("FREQUENCE");
			table.addCell("The frequence range should be between 100 to 600.");
			table.addCell("TEMPERATURE");
			table.addCell("The Temperature range should handled between 150 to 200.");
			table.addCell("OIL CONSUMPTION");
			table.addCell("The Oil Consumption should be handle between 30 to 35.");
			table.addCell("OIL PRESSURE");
			table.addCell("The pressure is handled based on th oil consumption  and oil level of the machine");
			table.addCell("CREEP RATE");
			table.addCell("The creep rate of a CFM56-7B machine is the rate at which the blades deform under a constant load. It is a measure of the strength and durability of the blades. The creep rate is typically measured in millimeters per second.");
		
			document.add(table); 
			document.close();
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
			HttpSession session =request.getSession();
			session.setAttribute("a", name);
			session.setAttribute("fullpath", path);
			RequestDispatcher rd = request.getRequestDispatcher("Download.jsp");
			rd.include(request, response);
		}
		else if(mach_name.equals("Hydroforming Machine"))
				{
			Type="Production Line";
			Document document = new Document();
			name="Hydroforming-report"+randomNumber+"";
			String path=staticuse.PROJ_LOCATION.concat("InspectionReports//").concat(name).concat(".pdf");
			try {
				PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
				document.open();
			float fntSize, lineSpacing;
			fntSize = 15.0f;
			lineSpacing = 40f;
			Paragraph p1 = new Paragraph(new Phrase(lineSpacing,mach_name.concat(" Report"),FontFactory.getFont(FontFactory.COURIER, fntSize)));
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
			table.addCell(mach_name);
			table.addCell("MACHINE TYPE");
			table.addCell(Type);
			table.addCell("NO OF FAULTS ");
			table.addCell("7");
			table.addCell("Oil_Level");
			table.addCell("if the oil level is below the minimum mark, the machine may not operate properly. The oil may not be able to circulate properly, which can cause the machine to overheat or malfunction, If the oil level is above the maximum mark, the machine may not be able to operate properly. The oil may not be able to circulate properly, which can cause the machine to overheat or malfunction. ");
			table.addCell("OIL TEMPERATURE");
			table.addCell("oil temperature range for a hydroforming machine will vary depending on the machine's make and model. However, the oil temperature should typically be kept between 100 and 200 degrees Fahrenheit.");
			table.addCell("CLEANING SYSTEM");
			table.addCell("Press and surrounding area clean.");
			table.addCell("HYDROFORMING FLOW RATE");
			table.addCell("The flowrate should be handled between the 100 to 200");
			table.addCell("HYDROFORMING FORCE");
			table.addCell("The hydroforming force handled between the range of 10 to 100.");
		
			document.add(table); 
			document.close();
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}HttpSession session =request.getSession();
			session.setAttribute("a", name);
			session.setAttribute("fullpath", path);
			RequestDispatcher rd = request.getRequestDispatcher("Download.jsp");
			rd.include(request, response);
				}
		else if(mach_name.equals("fuselage assembly"))
		{
			Type="Assembly Line";
			name="fuselage-report"+randomNumber+"";
			Document document = new Document();
			String path=staticuse.PROJ_LOCATION.concat("InspectionReports//").concat(name).concat(".pdf");
			try {
				PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
				document.open();
			float fntSize, lineSpacing;
			fntSize = 15.0f;
			lineSpacing = 40f;
			Paragraph p1 = new Paragraph(new Phrase(lineSpacing,mach_name.concat(" Report"),FontFactory.getFont(FontFactory.COURIER, fntSize)));
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
			table.addCell(mach_name);
			table.addCell("MACHINE TYPE");
			table.addCell(Type);
			table.addCell("NO OF FAULTS ");
			table.addCell("27");
			table.addCell("BONDING_PRESSURE");
			table.addCell("The bonding pressure of a fuselage assembly is typically in the range of 100 to 200 psi. However, the specific bonding pressure that is used will depend on the type of adhesive that is being used, the thickness of the components, and the size of the assembly.");
			table.addCell("Noise_exposure");
			table.addCell("The noise exposure range can handled between 1.5  to 8.5");
			table.addCell("CLEANING SYSTEM");
			table.addCell("Press and surrounding area clean.");
			
			table.addCell("Vibration_exposure");
			table.addCell("The vibration exposure can be handled between 2.5 of the range.");
		
			document.add(table); 
			document.close();
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
			HttpSession session =request.getSession();
			session.setAttribute("a", name);
			session.setAttribute("fullpath", path);
			RequestDispatcher rd = request.getRequestDispatcher("Download.jsp");
			rd.include(request, response);
		}
		else if(mach_name.equals("Landing Gear"))
		{
			Type="Assembly Line";
			name="Landing-report"+randomNumber+"";
			Document document = new Document();
			String path=staticuse.PROJ_LOCATION.concat("InspectionReports//").concat(name).concat(".pdf");
			try {
				PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
				document.open();
			float fntSize, lineSpacing;
			fntSize = 15.0f;
			lineSpacing = 40f;
			Paragraph p1 = new Paragraph(new Phrase(lineSpacing,mach_name.concat(" Report"),FontFactory.getFont(FontFactory.COURIER, fntSize)));
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
			table.addCell(mach_name);
			table.addCell("MACHINE TYPE");
			table.addCell(Type);
			table.addCell("NO OF FAULTS ");
			table.addCell("34");
			table.addCell("PRESSURE");
			table.addCell("The Pressure of the machine is depends on the oil level of the machine if the oil level is low the pressure should be lesser then 2.3 , if the oil level is add the pressure should be lesser then 4.1, if the oil level is full the presure should be lesser then 8.2 ");
			table.addCell("FLOW RATE");
			table.addCell("The flow rate should be handled between the 10 to 20 with the range");
			table.addCell("CLEANING SYSTEM");
			table.addCell("Press and surrounding area clean.");
			table.addCell("Vibration_exposure");
			table.addCell("The vibration exposure can be handled between 2.5 of the range.");
		
			document.add(table); 
			document.close();
			}catch(Exception ex)
			{
				ex.printStackTrace();
			}
			HttpSession session =request.getSession();
			session.setAttribute("a", name);
			session.setAttribute("fullpath", path);
			RequestDispatcher rd = request.getRequestDispatcher("Download.jsp");
			rd.include(request, response);
		}
		else if(mach_name.equals("wind tunnels"))
		{
			 Type="Testing Line";
				name="wind-report"+randomNumber+"";
			 Document document = new Document();
				String path=staticuse.PROJ_LOCATION.concat("InspectionReports//").concat(name).concat(".pdf");
				try {
					PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
					document.open();
				float fntSize, lineSpacing;
				fntSize = 15.0f;
				lineSpacing = 40f;
				Paragraph p1 = new Paragraph(new Phrase(lineSpacing,mach_name.concat(" Report"),FontFactory.getFont(FontFactory.COURIER, fntSize)));
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
				table.addCell(mach_name);
				table.addCell("MACHINE TYPE");
				table.addCell(Type);
				table.addCell("NO OF FAULTS ");
				table.addCell("37");
				table.addCell("IC ");
				table.addCell("The Ic range can be handled between the range of 1.5 to 2.5 if the temperature is 120 to 220 , if the ic is 2.5 then the temperature can be 220 to 320, if the ic in the range of 3.5 to 4.5 then the temperature can be 320 to 420.");
				table.addCell("FORCE");
				table.addCell("The flow rate should be handled between the 100 to 300 with the range");
				table.addCell("FLOW RATE");
				table.addCell("The flow rate can vary based on the force of the machine the flow rate  can be handle beteen the 300 of the range is normal.");
				table.addCell("CLEANING SYSTEM");
				table.addCell("Press and surrounding area clean.");
				table.addCell("Wind_speed");
				table.addCell("The Wind speed can be handled between the range of 10 to 1000 with range is normal.");
				table.addCell("Air_temperature");
				table.addCell("The Air temperature can be handled between the range of the - 20 degree to -0 degree is  normal range ");
				table.addCell("Altitude");
				table.addCell("The Altitude should be handled between the range of 10  to 10,000 with in the  range");
				document.add(table); 
				document.close();
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
				HttpSession session =request.getSession();
				session.setAttribute("a", name);
				session.setAttribute("fullpath", path);
				RequestDispatcher rd = request.getRequestDispatcher("Download.jsp");
				rd.include(request, response);
		}
		else if(mach_name.equals("Crash test machines"))
		{
			 Type="Testing Line";
			 name="Crash-report"+randomNumber+"";
			 Document document = new Document();
				String path=staticuse.PROJ_LOCATION.concat("InspectionReports//").concat(name).concat(".pdf");
				try {
					PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
					document.open();
				float fntSize, lineSpacing;
				fntSize = 15.0f;
				lineSpacing = 40f;
				Paragraph p1 = new Paragraph(new Phrase(lineSpacing,mach_name.concat(" Report"),FontFactory.getFont(FontFactory.COURIER, fntSize)));
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
				table.addCell(mach_name);
				table.addCell("MACHINE TYPE");
				table.addCell(Type);
				table.addCell("NO OF FAULTS ");
				table.addCell("37");
				table.addCell("IC ");
				table.addCell("The Ic range can be handled between the range of 1.5 to 2.5 if the temperature is 120 to 220 , if the ic is 2.5 then the temperature can be 220 to 320, if the ic in the range of 3.5 to 4.5 then the temperature can be 320 to 420.");
				table.addCell("FORCE");
				table.addCell("The flow rate should be handled between the 100 to 300 with the range");
				table.addCell("FLOW RATE");
				table.addCell("The flow rate can vary based on the force of the machine the flow rate  can be handle beteen the 300 of the range is normal.");
				table.addCell("CLEANING SYSTEM");
				table.addCell("Press and surrounding area clean.");
				
				document.add(table); 
				document.close();
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
				HttpSession session =request.getSession();
				session.setAttribute("a", name);
				session.setAttribute("fullpath", path);
				RequestDispatcher rd = request.getRequestDispatcher("Download.jsp");
				rd.include(request, response);
		}
		
		
	}

}
