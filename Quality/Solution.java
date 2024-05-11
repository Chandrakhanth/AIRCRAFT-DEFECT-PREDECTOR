package Quality;

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

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import Aerospace.staticuse;

/**
 * Servlet implementation class Solution
 */
@WebServlet("/Solution")
public class Solution extends HttpServlet {
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
		System.out.print("company_name"+company_name+"no_faults=="+no_faults+"result"+result);
		String TYPE="";
		Random random = new Random();
		int randomNumber = random.nextInt(100);
		
		if(company_name.equals("Crash test machines"))
		{
			 TYPE="Testing Line";
			 String name="",path="";
			if(result.equals("Replace"))
			{
				 name="Crash test"+randomNumber+"";
				String Mechanical_faults="These faults can be caused by wear and tear, improper maintenance, bent parts,corroded connections,Damaged seals,and  damage from a crash.";
				String Hydraulic_faults="These faults can be caused by leaks, low fluid levels, Loss of hydraulic pressure,Inability to apply the correct amount of force or malfunctioning actuators";
				Document document = new Document();
			 path=staticuse.PROJ_LOCATION.concat("FinalReports//").concat(name).concat(".pdf");
				try {
					PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
					document.open();
				float fntSize, lineSpacing;
				fntSize = 15.0f;
				lineSpacing = 40f;
				Paragraph p1 = new Paragraph(new Phrase(lineSpacing,company_name.concat("Quality Control Report"),FontFactory.getFont(FontFactory.COURIER, fntSize)));
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
				table.addCell("MACHINE STATUS");
				table.addCell(result);
				table.addCell("MAjOR CAUSE");
				table.addCell("There are a number of other potential problems that can occur with crash test machines. These problems can be caused by a variety of factors, including operator error, environmental conditions, and bird strikes,The most common cause of crash test machine faults is mechanical faults. This is because the machines are subjected to a lot of wear and tear, especially during crash tests.");
				table.addCell("SYMPTOM OF LEAKS 1");
				table.addCell("If you see fluid leaking from the system, it is a sign that there may be a leak.");
				table.addCell("SYMPTOM OF LEAKS 2");
				table.addCell("You may see oily residue on the system's components.");
				table.addCell("SYMPTOM OF LEAKS 3");
				table.addCell("You may hear noises coming from the system, such as knocking or squealing.");
				table.addCell("WORN PISTON");
				table.addCell("The piston rings are responsible for sealing the combustion chamber and preventing oil from entering the combustion chamber. If the piston rings are worn, oil will leak past the rings and into the combustion chamber");
				
				table.addCell("INSTRUCTION TO BE FOLLOW 1");
				table.addCell("Hydraulic pressure is the force exerted by a fluid. It is measured in pounds per square inch (psi). The normal pressure range for hydraulic systems varies depending on pressure range that should be between 100 and 3000 psi.");
				table.addCell("INSTRUCTION TO BE FOLLOW 2");
				table.addCell("If the hydraulic fluid leaks and comes into contact with a heat source, it can ignite and cause a fire.t is important to inspect hydraulic systems regularly for loose or corroded connections and to repair or replace them as necessary.");
				table.addCell("INSTRUCTION TO BE FOLLOW 3");
				table.addCell("If you notice that your crash testing machine is consuming oil, it is important to have the engine checked by a qualified mechanic as soon as possible. The mechanic will be able to diagnose the cause of the oil consumption and recommend the appropriate repairs.");
				
				document.add(table);
				
				document.close();
				
			
		} catch (DocumentException e) {
					
					e.printStackTrace();
				}
				
			}	
			
			else if(result.equals("Repair"))
			{
			 name="report"+randomNumber+"";
				String Mechanical_faults="These faults can be caused by wear and tear, improper maintenance, bent parts,corroded connections,Damaged seals,and  damage from a crash.";
				String Hydraulic_faults="These faults can be caused by leaks, low fluid levels, Loss of hydraulic pressure,Inability to apply the correct amount of force or malfunctioning actuators";
				Document document = new Document();
				path=staticuse.PROJ_LOCATION.concat("FinalReports//").concat(name).concat(".pdf");
				try {
					PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
					document.open();
				float fntSize, lineSpacing;
				fntSize = 15.0f;
				lineSpacing = 40f;
				Paragraph p1 = new Paragraph(new Phrase(lineSpacing,company_name.concat("Quality Control Report"),FontFactory.getFont(FontFactory.COURIER, fntSize)));
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
				table.addCell("MACHINE STATUS");
				table.addCell(result);
				table.addCell("MAjOR CAUSE");
				table.addCell("There are a number of other potential problems that can occur with  machines. Most common cause of hydroforming machine faults is mechanical faults. This is because the machines are subjected to a lot of wear and tear, especially during crash tests. Other common causes of faults include hydraulic faults, electrical faults, and software faults.");
				table.addCell("LOW HYDRAULIC PRESSURE");
				table.addCell("This is the most common symptom of hydraulic faults");
				table.addCell("LEAKS");
				table.addCell("If you see fluid leaking from the system, it is a sign that there may be a leak.");
				table.addCell("OILY RESIDUE");
				table.addCell("This can lead to contamination of the hydraulic fluid and damage to the system's components.");
				table.addCell("WORN PISTON");
				table.addCell("The piston rings are responsible for sealing the combustion chamber and preventing oil from entering the combustion chamber. If the piston rings are worn, oil will leak past the rings and into the combustion chamber");
				table.addCell("INSTRUCTION TO BE FOLLOW 1");
				table.addCell("Check the hydraulic fluid level regularly and add fluid as needed.");
				table.addCell("INSTRUCTION TO BE FOLLOW 2");
				table.addCell("Inspect the hydraulic lines and hoses for leaks regularly and replace any that are damaged.");
				table.addCell("INSTRUCTION TO BE FOLLOW 3");
				table.addCell("Filter the hydraulic fluid regularly to remove contaminants.");
				table.addCell("INSTRUCTION TO BE FOLLOW 4");
				table.addCell("Purge the hydraulic system regularly to remove air and other contaminants.");
				document.add(table);
				
				document.close();
				
				
			
		} catch (DocumentException e) {
					
					e.printStackTrace();
				}
			}
			HttpSession session =request.getSession();
			session.setAttribute("a", name);
			session.setAttribute("fullpath", path);
			RequestDispatcher rd = request.getRequestDispatcher("Download.jsp");
			rd.include(request, response);	
		
		}
		
		else if(company_name.equals("Hydroforming Machine"))
		{
			 TYPE="Production Line";
			 String name="",path="";
			if(result.equals("Replace"))
			{
				name="Hydroforming"+randomNumber+"";
				String Mechanical_faults="These faults can be caused by wear and tear, improper maintenance, bent parts,corroded connections,Damaged seals,and  damage from a crash.";
				String Hydraulic_faults="These faults can be caused by leaks, low fluid levels, Loss of hydraulic pressure,Inability to apply the correct amount of force or malfunctioning actuators";
				Document document = new Document();
			path=staticuse.PROJ_LOCATION.concat("FinalReports//").concat(name).concat(".pdf");
				try {
					PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
					document.open();
				float fntSize, lineSpacing;
				fntSize = 15.0f;
				lineSpacing = 40f;
				Paragraph p1 = new Paragraph(new Phrase(lineSpacing,company_name.concat("Quality Control Report"),FontFactory.getFont(FontFactory.COURIER, fntSize)));
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
				table.addCell("MACHINE STATUS");
				table.addCell(result);
				table.addCell("LEAKS");
				table.addCell("Leaks can occur in the hydraulic system or in the mold. Leaks can cause the machine to lose pressure, which can lead to premature failure of the part being formed.");
				table.addCell("CONTAMINATION");
				table.addCell("Contamination of the hydraulic fluid can also cause problems. Contamination can come from a variety of sources, including dirt, debris, or even water. Contamination can damage the hydraulic system and can also lead to premature failure of the part being formed");
				table.addCell("INCORRECT PRESSURE");
				table.addCell("If the pressure is too high, it can cause the part to form incorrectly or even damage the mold. If the pressure is too low, the part may not form properly or may even deform during the forming process.");
				table.addCell("INCORRECT TEMPERATURE");
				table.addCell("The temperature of the fluid can also affect the forming process. If the temperature is too low, the fluid will not be able to flow properly and the part may not form properly. If the temperature is too high, the fluid can damage the mold or even cause the part to melt.");
				table.addCell("IMPROPER TOOLING");
				table.addCell("The tooling used in the hydroforming process must be properly designed and manufactured. If the tooling is not correct, it can cause the part to form incorrectly or even damage the mold.");
				table.addCell("OIL TEMPERATURE");
				table.addCell("oil temperature handle based on the oil level when the oil level is Full the oil temperature should be 140 to 160,when the oil level is add the oil temperature should be 120 to 140 and when the oil level is low the oil temperature should be 100 to 120 ");
				table.addCell("PRESSURE");
				table.addCell("The pressure is handled based on the oil consumption and oil temperature pressure should be handled between 100 to 600 range");
				table.addCell("CLEANING SYSTEM ");
				table.addCell("Press and surrounding area clean.");	
document.add(table);
				
				document.close();
				
			
		} catch (DocumentException e) {
					
					e.printStackTrace();
				}	
				
			}
			else if(result.equals("Repair"))
			{
				 name="Hydroforming"+randomNumber+"";
				String Mechanical_faults="These faults can be caused by wear and tear, improper maintenance, bent parts,corroded connections,Damaged seals,and  damage from a crash.";
				String Hydraulic_faults="These faults can be caused by leaks, low fluid levels, Loss of hydraulic pressure,Inability to apply the correct amount of force or malfunctioning actuators";
				Document document = new Document();
				path=staticuse.PROJ_LOCATION.concat("FinalReports//").concat(name).concat(".pdf");
				try {
					PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
					document.open();
				float fntSize, lineSpacing;
				fntSize = 15.0f;
				lineSpacing = 40f;
				Paragraph p1 = new Paragraph(new Phrase(lineSpacing,company_name.concat("Quality Control Report"),FontFactory.getFont(FontFactory.COURIER, fntSize)));
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
				table.addCell("MACHINE STATUS");
				table.addCell(result);
				table.addCell("LEAKS");
				table.addCell("Leaks can occur in the hydraulic system or in the mold. Leaks can cause the machine to lose pressure, which can lead to premature failure of the part being formed.");
				table.addCell("CONTAMINATION");
				table.addCell("Contamination of the hydraulic fluid can also cause problems. Contamination can come from a variety of sources, including dirt, debris, or even water. Contamination can damage the hydraulic system and can also lead to premature failure of the part being formed");
				table.addCell("INCORRECT PRESSURE");
				table.addCell("If the pressure is too high, it can cause the part to form incorrectly or even damage the mold. If the pressure is too low, the part may not form properly or may even deform during the forming process.");
				table.addCell("INCORRECT TEMPERATURE");
				table.addCell("The temperature of the fluid can also affect the forming process. If the temperature is too low, the fluid will not be able to flow properly and the part may not form properly. If the temperature is too high, the fluid can damage the mold or even cause the part to melt.");
				table.addCell("IMPROPER TOOLING");
				table.addCell("The tooling used in the hydroforming process must be properly designed and manufactured. If the tooling is not correct, it can cause the part to form incorrectly or even damage the mold.");
				table.addCell("OIL TEMPERATURE");
				table.addCell("oil temperature handle based on the oil level when the oil level is Full the oil temperature should be 140 to 160,when the oil level is add the oil temperature should be 120 to 140 and when the oil level is low the oil temperature should be 100 to 120 ");
				table.addCell("PRESSURE");
				table.addCell("The pressure is handled based on the oil consumption and oil temperature pressure should be handled between 100 to 600 range");
				table.addCell("CLEANING SYSTEM ");
				table.addCell("Press and surrounding area clean.");
				document.add(table);
				
				document.close();
			
		} catch (DocumentException e) {
					
					e.printStackTrace();
				}	
				
			}
			HttpSession session =request.getSession();
			session.setAttribute("a", name);
			session.setAttribute("fullpath", path);
			RequestDispatcher rd = request.getRequestDispatcher("Download.jsp");
			rd.include(request, response);
		}
		else if(company_name.equals("Landing Gear"))
	{
			TYPE="Assembly Line";
			 String name="",path="";
			if(result.equals("Replace"))
			{
			 name="Landing"+randomNumber+"";
					Document document = new Document();
				 path=staticuse.PROJ_LOCATION.concat("FinalReports//").concat(name).concat(".pdf");
				try {
					PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
					document.open();
				float fntSize, lineSpacing;
				fntSize = 15.0f;
				lineSpacing = 40f;
				Paragraph p1 = new Paragraph(new Phrase(lineSpacing,company_name.concat("Quality Control Report"),FontFactory.getFont(FontFactory.COURIER, fntSize)));
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
				table.addCell("MACHINE STATUS");
				table.addCell(result);
				table.addCell("MECHANICAL PROBLEMS");
				table.addCell("These can include wear and tear on components, improper maintenance, or damage from a previous incident");
				table.addCell("ELECTRICAL PROBLEM");
				table.addCell("These can include faulty wiring, connectors, or actuators.");
				table.addCell("HYDRAULIC PROBLEM");
				table.addCell("These can include leaks, low fluid levels, or malfunctioning pumps.");
				table.addCell("FAILURE TO EXTEND");
				table.addCell("This can be caused by a number of factors, such as a hydraulic leak, a faulty actuator, or a jammed gear door.");
				table.addCell("IMPROPER TOOLING");
				table.addCell("The tooling used in the hydroforming process must be properly designed and manufactured. If the tooling is not correct, it can cause the part to form incorrectly or even damage the mold.");
				table.addCell(" COLLAPSE");
				table.addCell("This can be caused by a number of factors, such as a structural failure, a hydraulic leak, or a collision.");
				table.addCell(" BEARING FAULTS");
				table.addCell("Brakes are used to slow down or stop machines. They can fail due to wear and tear, misalignment, or contamination.");
				table.addCell("GEAR FAULTS ");
				table.addCell("Gears are used to transmit power in machines. They can fail due to wear and tear, corrosion, or misalignment.");
				document.add(table);
				
				document.close();
				
			
		} catch (DocumentException e) {
					
					e.printStackTrace();
				}
			}
			else if(result.equals("Repair"))
			{
				 name="Landing"+randomNumber+"";
				Document document = new Document();
				 path=staticuse.PROJ_LOCATION.concat("FinalReports//").concat(name).concat(".pdf");
				try {
					PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
					document.open();
				float fntSize, lineSpacing;
				fntSize = 15.0f;
				lineSpacing = 40f;
				Paragraph p1 = new Paragraph(new Phrase(lineSpacing,company_name.concat("Quality Control Report"),FontFactory.getFont(FontFactory.COURIER, fntSize)));
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
				table.addCell("MACHINE STATUS");
				table.addCell(result);
				table.addCell("LEAKS");
				table.addCell("Leaks can occur in the hydraulic system or in the mold. Leaks can cause the machine to lose pressure, which can lead to premature failure of the part being formed.");
				table.addCell("CONTAMINATION");
				table.addCell("Contamination of the hydraulic fluid can also cause problems. Contamination can come from a variety of sources, including dirt, debris, or even water. Contamination can damage the hydraulic system and can also lead to premature failure of the part being formed");
				table.addCell("INCORRECT PRESSURE");
				table.addCell("If the pressure is too high, it can cause the part to form incorrectly or even damage the mold. If the pressure is too low, the part may not form properly or may even deform during the forming process.");
				table.addCell("INCORRECT TEMPERATURE");
				table.addCell("The temperature of the fluid can also affect the forming process. If the temperature is too low, the fluid will not be able to flow properly and the part may not form properly. If the temperature is too high, the fluid can damage the mold or even cause the part to melt.");
				table.addCell("IMPROPER TOOLING");
				table.addCell("The tooling used in the hydroforming process must be properly designed and manufactured. If the tooling is not correct, it can cause the part to form incorrectly or even damage the mold.");
				table.addCell("OIL TEMPERATURE");
				table.addCell("oil temperature handle based on the oil level when the oil level is Full the oil temperature should be 140 to 160,when the oil level is add the oil temperature should be 120 to 140 and when the oil level is low the oil temperature should be 100 to 120 ");
				table.addCell("PRESSURE");
				table.addCell("The pressure is handled based on the oil consumption and oil temperature pressure should be handled between 100 to 600 range");
				table.addCell("CLEANING SYSTEM ");
				table.addCell("Press and surrounding area clean.");
				document.add(table);
				
				document.close();
			
			
		} catch (DocumentException e) {
					
					e.printStackTrace();
				}			
		}
			HttpSession session =request.getSession();
			session.setAttribute("a", name);
			session.setAttribute("fullpath", path);
			RequestDispatcher rd = request.getRequestDispatcher("Download.jsp");
			rd.include(request, response);
	}
		else if(company_name.equals("fuselage assembly"))
		{
		
			TYPE="Assembly Line";
			 String name="",path="";
			if(result.equals("Replace"))
			{
			 name="fuselage"+randomNumber+"";
				String Mechanical_faults="These faults can be caused by wear and tear, improper maintenance, bent parts,corroded connections,Damaged seals,and  damage from a crash.";
				String Hydraulic_faults="These faults can be caused by leaks, low fluid levels, Loss of hydraulic pressure,Inability to apply the correct amount of force or malfunctioning actuators";
				Document document = new Document();
			 path=staticuse.PROJ_LOCATION.concat("FinalReports//").concat(name).concat(".pdf");
				try {
					PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
					document.open();
				float fntSize, lineSpacing;
				fntSize = 15.0f;
				lineSpacing = 40f;
				Paragraph p1 = new Paragraph(new Phrase(lineSpacing,company_name.concat("Quality Control Report"),FontFactory.getFont(FontFactory.COURIER, fntSize)));
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
				table.addCell("MACHINE STATUS");
				table.addCell(result);
				table.addCell("MECHANICAL PROBEMS");
				table.addCell("These can include wear and tear on components, improper maintenance, or damage from a previous incident.");
				table.addCell("HYDRAULIC PROBLEM");
				table.addCell("These can include leaks, low fluid levels, or malfunctioning pumps.");
				table.addCell("ELECTRICAL PROBLEM");
				table.addCell("These can include faulty wiring, connectors, or actuators.");
				table.addCell("Material faults");
				table.addCell("These can include defects in the raw materials used to assemble the fuselage, or improper handling of the materials during the assembly process.");
				table.addCell("IMPROPER TOOLING");
				table.addCell("The tooling used in the hydroforming process must be properly designed and manufactured. If the tooling is not correct, it can cause the part to form incorrectly or even damage the mold.");
				table.addCell("BONDING_PRESSURE");
				table.addCell("The bonding pressure should be handled based on the bonding type");
				table.addCell("NOISE EXPOSURE");
				table.addCell("The noise exposure should be lesser then 8.5 beacuse it is the normal range.");
				table.addCell("VIBRATION EXPOSURE");
				table.addCell("The noise exposure  should be handled between 0.5 to 2.6");
				table.addCell("CLEANING SYSTEM ");
				table.addCell("Press and surrounding area clean.");
				document.add(table);
				
				document.close();
				
			
		} catch (DocumentException e) {
					
					e.printStackTrace();
				}		
			}
			else if(result.equals("Repair"))
			{
				TYPE="Assembly Line";
				
			
				 name="fuselage"+randomNumber+"";
					String Mechanical_faults="These faults can be caused by wear and tear, improper maintenance, bent parts,corroded connections,Damaged seals,and  damage from a crash.";
					String Hydraulic_faults="These faults can be caused by leaks, low fluid levels, Loss of hydraulic pressure,Inability to apply the correct amount of force or malfunctioning actuators";
					Document document = new Document();
					 path=staticuse.PROJ_LOCATION.concat("FinalReports//").concat(name).concat(".pdf");
					try {
						PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
						document.open();
					float fntSize, lineSpacing;
					fntSize = 15.0f;
					lineSpacing = 40f;
					Paragraph p1 = new Paragraph(new Phrase(lineSpacing,company_name.concat("Quality Control Report"),FontFactory.getFont(FontFactory.COURIER, fntSize)));
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
					table.addCell("MACHINE STATUS");
					table.addCell(result);
					table.addCell("MECHANICAL PROBEMS");
					table.addCell("These can include wear and tear on components, improper maintenance, or damage from a previous incident.");
					table.addCell("HYDRAULIC PROBLEM");
					table.addCell("These can include leaks, low fluid levels, or malfunctioning pumps.");
					table.addCell("ELECTRICAL PROBLEM");
					table.addCell("These can include faulty wiring, connectors, or actuators.");
					table.addCell("Material faults");
					table.addCell("These can include defects in the raw materials used to assemble the fuselage, or improper handling of the materials during the assembly process.");
					table.addCell("IMPROPER TOOLING");
					table.addCell("The tooling used in the hydroforming process must be properly designed and manufactured. If the tooling is not correct, it can cause the part to form incorrectly or even damage the mold.");
					table.addCell("BONDING_PRESSURE");
					table.addCell("The bonding pressure should be handled based on the bonding type");
					table.addCell("NOISE EXPOSURE");
					table.addCell("The noise exposure should be lesser then 8.5 beacuse it is the normal range.");
					table.addCell("VIBRATION EXPOSURE");
					table.addCell("The noise exposure  should be handled between 0.5 to 2.6");
					table.addCell("CLEANING SYSTEM ");
					table.addCell("Press and surrounding area clean.");
					document.add(table);
					
					document.close();
					
				
			} catch (DocumentException e) {
						
						e.printStackTrace();
					}
			}
		
			HttpSession session =request.getSession();
			session.setAttribute("a", name);
			session.setAttribute("fullpath", path);
			RequestDispatcher rd = request.getRequestDispatcher("Download.jsp");
			rd.include(request, response);
		}
		else if(company_name.equals("CFM56-7B machine"))
		{
			TYPE="Testing Line";
			 String name="",path="";
			if(result.equals("Replace"))
			{
				 name="CFM56"+randomNumber+"";
				String Mechanical_faults="These faults can be caused by wear and tear, improper maintenance, bent parts,corroded connections,Damaged seals,and  damage from a crash.";
				String Hydraulic_faults="These faults can be caused by leaks, low fluid levels, Loss of hydraulic pressure,Inability to apply the correct amount of force or malfunctioning actuators";
				Document document = new Document();
				 path=staticuse.PROJ_LOCATION.concat("FinalReports//").concat(name).concat(".pdf");
				try {
					PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
					document.open();
				float fntSize, lineSpacing;
				fntSize = 15.0f;
				lineSpacing = 40f;
				Paragraph p1 = new Paragraph(new Phrase(lineSpacing,company_name.concat("Quality Control Report"),FontFactory.getFont(FontFactory.COURIER, fntSize)));
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
				table.addCell("MACHINE STATUS");
				table.addCell(result);
				table.addCell("MECHANICAL PROBEMS");
				table.addCell("These can include wear and tear on components, improper maintenance, or damage from a previous incident.");
				table.addCell("HYDRAULIC PROBLEM");
				table.addCell("These can include leaks, low fluid levels, or malfunctioning pumps.");
				table.addCell("ELECTRICAL PROBLEM");
				table.addCell("These can include faulty wiring, connectors, or actuators.");
				table.addCell("UNBALANCE ");
				table.addCell("This is the most common cause of blade vibration. It occurs when the weight of the blade is not evenly distributed. This can be caused by manufacturing defects, wear and tear, or damage from a previous incident.");
				table.addCell("EXCESSIVE STRESS");
				table.addCell("This can be caused by high temperatures, high loads, or turbulence. It can cause the blade to deform, which can lead to vibration.");
				table.addCell("Misalignment");
				table.addCell("This can occur when the blade is not properly aligned with the other blades. This can cause the blade to rub against the other blades, which can lead to vibration.");
				table.addCell("VIBRATION OF BLADE");
				table.addCell("This is the most common cause of blade vibration. It occurs when the weight of the blade is not evenly distributed. This can be caused by manufacturing defects, wear and tear, or damage from a previous incident.");
				table.addCell("VIBRATION EXPOSURE");
				table.addCell("The noise exposure  should be handled between 0.5 to 2.6");
				table.addCell("PRESSURE ");
				table.addCell("The pressure should be handled based on the oil consumption of the machine, if the oil consumption is 32 to 35 the normal range of the pressure should between 1.5 to 4.5");
				table.addCell("SPEED OF BLADE");
				table.addCell("The speed of the blade is depend upon the booster value of the machine  the if the booster value is between 20 to 100 it is normal rangebased on the booster value the speed of blade will changed. ");
				document.add(table);
				
				document.close();
				
			
		} catch (DocumentException e) {
					
					e.printStackTrace();
				}	
			}
			else if(result.equals("Repair"))
		{
				
					 name="CFM56"+randomNumber+"";
					String Mechanical_faults="These faults can be caused by wear and tear, improper maintenance, bent parts,corroded connections,Damaged seals,and  damage from a crash.";
					String Hydraulic_faults="These faults can be caused by leaks, low fluid levels, Loss of hydraulic pressure,Inability to apply the correct amount of force or malfunctioning actuators";
					Document document = new Document();
			 path=staticuse.PROJ_LOCATION.concat("FinalReports//").concat(name).concat(".pdf");
					try {
						PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
						document.open();
					float fntSize, lineSpacing;
					fntSize = 15.0f;
					lineSpacing = 40f;
					Paragraph p1 = new Paragraph(new Phrase(lineSpacing,company_name.concat("Quality Control Report"),FontFactory.getFont(FontFactory.COURIER, fntSize)));
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
					table.addCell("MACHINE STATUS");
					table.addCell(result);
					table.addCell("MECHANICAL PROBEMS");
					table.addCell("These can include wear and tear on components, improper maintenance, or damage from a previous incident.");
					table.addCell("HYDRAULIC PROBLEM");
					table.addCell("These can include leaks, low fluid levels, or malfunctioning pumps.");
					table.addCell("ELECTRICAL PROBLEM");
					table.addCell("These can include faulty wiring, connectors, or actuators.");
					table.addCell("UNBALANCE ");
					table.addCell("This is the most common cause of blade vibration. It occurs when the weight of the blade is not evenly distributed. This can be caused by manufacturing defects, wear and tear, or damage from a previous incident.");
					table.addCell("EXCESSIVE STRESS");
					table.addCell("This can be caused by high temperatures, high loads, or turbulence. It can cause the blade to deform, which can lead to vibration.");
					table.addCell("Misalignment");
					table.addCell("This can occur when the blade is not properly aligned with the other blades. This can cause the blade to rub against the other blades, which can lead to vibration.");
					table.addCell("VIBRATION OF BLADE");
					table.addCell("This is the most common cause of blade vibration. It occurs when the weight of the blade is not evenly distributed. This can be caused by manufacturing defects, wear and tear, or damage from a previous incident.");
					table.addCell("VIBRATION EXPOSURE");
					table.addCell("The noise exposure  should be handled between 0.5 to 2.6");
					table.addCell("PRESSURE ");
					table.addCell("The pressure should be handled based on the oil consumption of the machine, if the oil consumption is 32 to 35 the normal range of the pressure should between 1.5 to 4.5");
					table.addCell("SPEED OF BLADE");
					table.addCell("The speed of the blade is depend upon the booster value of the machine  the if the booster value is between 20 to 100 it is normal rangebased on the booster value the speed of blade will changed. ");
					
				document.add(table);
					
					document.close();
					
				
			} catch (DocumentException e) {
						
						e.printStackTrace();
					}	
			
		}
			HttpSession session =request.getSession();
			session.setAttribute("a", name);
			session.setAttribute("fullpath", path);
			System.out.print("PATH==="+path);
			RequestDispatcher rd = request.getRequestDispatcher("Download.jsp");
			rd.include(request, response);	
		}
		else if(company_name.equals("wind tunnels"))
		{
			TYPE="Testing Line";
			 String name="",path="";
			if(result.equals("Replace"))
			{
				
			}
			else if(result.equals("Repair"))
			{
				
			}
		}
		
		}}

