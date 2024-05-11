package Inspection;


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
 * Servlet implementation class updatelabel
 */
@WebServlet("/updatelabel")
public class updatelabel extends HttpServlet {
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
		String sts="";
		if(base.equals("CFM56-7B"))
		{
			
			ResultSet rs = null; 
			String temp1="",id="" ,oilc="",pre="";
			int temp=0,oc=0;
			String BV1="",STR1="";
			float pres=0.0f;
			int i=0;
			int k = 1,BV=0,STR=0;
			try {
				String qry="SELECT * FROM pro_cfm56 where Status!='Pending' And Status!='Requested' And Status !='fault checked'";
				rs=(ResultSet) DB.getconnection().createStatement().executeQuery(qry);
				while (rs.next()) 
				{
					sts=rs.getString(14);
					id=rs.getString(2);
					temp1=rs.getString(10);
					oilc=rs.getString(6);
					pre=rs.getString(8);
					oc=Integer.parseInt(oilc);
					pres=Float.parseFloat(pre);
					temp=Integer.parseInt(temp1);
					BV1=rs.getString(16).trim();
					STR1=rs.getString(11).trim();
					BV=Integer.parseInt(BV1);
					STR=Integer.parseInt(STR1);
					System.out.println("mac_id=="+rs.getString(2)+"==temp===="+temp+"pres===="+pres+"oc==="+oc);
					if(temp>200)
					{
						if((pres<1.8)&&(oc<=35))
						{
							temp=150;
							String 	qry2= "UPDATE pro_cfm56 SET temperature ='"+temp+"',Status='fault checked' WHERE mac_id='"+ id +"'";
							i = DB.getconnection().prepareStatement(qry2).executeUpdate();	
							
						}else if((pres>=1.8)&&(oc<=35))
						{
							temp=200;
							String 	qry2= "UPDATE pro_cfm56 SET temperature ='"+temp+"',Status='fault checked' WHERE mac_id='"+ id +"'";
							i = DB.getconnection().prepareStatement(qry2).executeUpdate();	
						}
					
							
					}
						if(STR<=150)
						{
							STR1="200";	
							String 	qry2= "UPDATE pro_cfm56 SET Status='fault checked',stress='"+STR1+"',bv1='"+BV1+"' WHERE mac_id='"+ id +"'";
							i = DB.getconnection().prepareStatement(qry2).executeUpdate();	
						}
						if(BV<=25)
						{
							BV1="40";
							String 	qry2= "UPDATE pro_cfm56 SET Status='fault checked',stress='"+STR1+"',bv1='"+BV1+"' WHERE mac_id='"+ id +"'";
							i = DB.getconnection().prepareStatement(qry2).executeUpdate();	
						}
				}
			if(i>0)
			{
				prw.print("<html><body><script> alert('Updated Successfully...');</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("I_prolabel.jsp");
				rd.include(request, response);	
			}else if(sts.equals("fault checked")) {
				prw.print("<html><body><script> alert('Fault Is Already Processed...');</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("I_prolabel.jsp");
				rd.include(request, response);	
			}
			}
			catch(Exception Ex)
			{
				Ex.printStackTrace();
			}
		}
		else if(base.equals("Hydroforming"))
		{
			
			ResultSet rs = null;
			
			String oiltem1="",olev="",pressure="",fr="",force="",id="";
			try {
				String qry = "SELECT * FROM pro_hydroforming  where Status!='Pending' And Status!='Requested' And Status !='fault checked'";
				rs = (ResultSet)DB.getconnection().createStatement().executeQuery(qry);
				int k = 1,oiltem=0,pre=0,fr1=0,force1=0,i=0;;
				
				while (rs.next()) {
					sts=rs.getString("Status");
					id=rs.getString(1);
					oiltem1=rs.getString(4);
					olev=rs.getString(3);
					pressure=rs.getString(5);
					fr=rs.getString(11).trim();
					force=rs.getString(12).trim();
					fr1=Integer.parseInt(fr);
					force1=Integer.parseInt(force);
					oiltem=Integer.parseInt(oiltem1);
					pre=Integer.parseInt(pressure);
System.out.println("mac id=="+rs.getString(1)+"oiltemp1=="+oiltem+"olev===="+olev+"pressure=="+pre+"fr1=="+fr1+"force1=="+force1);

if(((fr1<100)||(fr1>300))) 
{
	fr="200";
	String 	qry2= "UPDATE pro_hydroforming SET hc_Flowrate ='"+fr+"',Status='fault checked' WHERE mac_id='"+ id +"'";
 i = DB.getconnection().prepareStatement(qry2).executeUpdate();		
}
if(((force1<1)||(force1>100)))
{
	force="70";
	String 	qry2= "UPDATE pro_hydroforming SET hc_Force ='"+force+"',Status='fault checked' WHERE mac_id='"+ id +"'";
	 i = DB.getconnection().prepareStatement(qry2).executeUpdate();			
}
if(((oiltem <=140) || (oiltem>=160) && (olev.equals("Full")) && (pre <400)|| (pre>600) ) )
{
	oiltem1="450";
	pressure="500";
	String 	qry2= "UPDATE pro_hydroforming SET Oil_Temperature ='"+oiltem1+"',Pressure='"+pressure+"',Status='fault checked' WHERE mac_id='"+ id +"'";
 i = DB.getconnection().prepareStatement(qry2).executeUpdate();			
}
if(((oiltem <=100) || (oiltem>=120) && (olev.equals("Low")) && (pre <=100)|| (pre>=200)))		
{
	oiltem1="115";
	pressure="112";
	String 	qry2= "UPDATE pro_hydroforming SET Oil_Temperature ='"+oiltem1+"',Pressure='"+pressure+"',Status='fault checked' WHERE mac_id='"+ id +"' ";
	 i = DB.getconnection().prepareStatement(qry2).executeUpdate();			
}
if(((oiltem <=120) || (oiltem>=140) && (olev.equals("Add")) &&(pre <=200)|| (pre>=400)))
{
	oiltem1="335";
	pressure="298";
	String 	qry2= "UPDATE pro_hydroforming SET Oil_Temperature ='"+oiltem1+"',Pressure='"+pressure+"',Status='fault checked' WHERE mac_id='"+ id +"'";
	 i = DB.getconnection().prepareStatement(qry2).executeUpdate();	
}

}
				if(i>0)
				{
					prw.print("<html><body><script> alert('Updated Successfully...');</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("I_prolabel.jsp");
					rd.include(request, response);	
				}else if(sts.equals("fault checked")) {
					prw.print("<html><body><script> alert('Fault Is Already Processed...');</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("I_prolabel.jsp");
					rd.include(request, response);		
				}
			}catch(Exception Ex1)
				{
					Ex1.printStackTrace();
				}
		}
		////fuselage fault update/////////////////////////////////
		else if(base.equals("Fuselage"))
		{
			ResultSet rs = null;
			
			String Sts="",BP1="",CT1="",BT="",vib1="",nois="",id="";
			try {
				String qry = "SELECT * FROM fuselage_assembly   where Status!='Pending' And Status!='Requested' And Status !='fault checked'";
				rs = (ResultSet)DB.getconnection().createStatement().executeQuery(qry);
				int k = 1,BP=0,CT=0,cc=0,noise1=0,i=0;
				float vib=0.0f;
				while (rs.next()) {
					sts=rs.getString(4);
					id=rs.getString(1);
					BT=rs.getString(9).trim();	
					BP1=rs.getString(10);	
					CT1=rs.getString(11).trim();
					vib1=rs.getString(13).trim();
					nois=rs.getString(12).trim();
					noise1=Integer.parseInt(nois);
					vib=Float.parseFloat(vib1);
					System.out.println("BT==="+BT+"BP=="+BP1+"CT=="+CT1+"noise1=="+noise1+"vib==="+vib);
					BP=Integer.parseInt(BP1);
					System.out.println("BP==="+BP);
					cc=Integer.parseInt(CT1);
					System.out.println("cc==="+cc);
					CT=cc;
					System.out.println("BT==="+BT+"BP=="+BP+"CT=="+CT);
					if(noise1>85)
					{
						nois="67";
						String 	qry2= "UPDATE fuselage_assembly SET Noise_exposure ='"+nois+"',Status='fault checked' WHERE Machine_id='"+ id +"'";
						 i = DB.getconnection().prepareStatement(qry2).executeUpdate();	
					}
					if(vib>2.5)
					{
						vib1="1.5";
						String 	qry2= "UPDATE fuselage_assembly SET Vibration_exposure ='"+vib1+"',Status='fault checked' WHERE Machine_id='"+ id +"'";
						 i = DB.getconnection().prepareStatement(qry2).executeUpdate();	
					}
					if(((BT.equals("Epoxy resin"))&&((BP<=200)||(BP>=250))&&((CT<=150)||(CT>=180))))
					{
						BP1="245";
						CT1="160";
						String 	qry2= "UPDATE fuselage_assembly SET BONDING_PRESSURE ='"+BP1+"',C_T='"+CT1+"',Status='fault checked' WHERE Machine_id='"+ id +"'";
						 i = DB.getconnection().prepareStatement(qry2).executeUpdate();	
					}
					if((BT.equals("Polyurethane resin"))&&((BP<=250)||(BP>=300))&&((CT <=180)||(CT >=200)))
					{
						BP1="285";
						CT1="197";
						String 	qry2= "UPDATE fuselage_assembly SET BONDING_PRESSURE ='"+BP1+"',C_T='"+CT1+"',Status='fault checked' WHERE Machine_id='"+ id +"'";
						i = DB.getconnection().prepareStatement(qry2).executeUpdate();		
					}
					if((BT.equals("Cyanoacrylate adhesive"))&&((BP<120)||(BP>=150))&&((CT<=80)||(CT>=100)))
					{
						BP1="125";
						CT1="90";
						String 	qry2= "UPDATE fuselage_assembly SET BONDING_PRESSURE ='"+BP1+"',C_T='"+CT1+"',Status='fault checked' WHERE Machine_id='"+ id +"'";
					 i = DB.getconnection().prepareStatement(qry2).executeUpdate();		
					}
				}
				if(i>0)
				{
					prw.print("<html><body><script> alert('Updated Successfully...');</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("I_prolabel.jsp");
					rd.include(request, response);	
				}else if(sts.equals("fault checked")) {
					prw.print("<html><body><script> alert('Fault Is Already Processed...');</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("I_prolabel.jsp");
					rd.include(request, response);		
				}
			}catch(Exception sx)
			{
					sx.printStackTrace();
			}
		}
		////fix fault of Landing ..........................................//////////
		else if(base.equals("Landing"))
		{
			ResultSet rs = null;
		
			String Sts="",rf1="",fr="",pres="";
			int ffr1=0,pre=0,i=0;;
			try {
				String qry = "SELECT * FROM landinggear_assembly where Status!='Pending' And Status!='Requested' And Status !='fault checked' ";
				rs = (ResultSet)DB.getconnection().createStatement().executeQuery(qry);
				int k = 1;
				float rf=0.0f;
				String id;
				while (rs.next()) {
					sts=rs.getString(11);
					id=rs.getString(1);
					Sts=rs.getString(7);
					rf1=rs.getString(6);
					pres=rs.getString(12).trim();
					fr=rs.getString(13).trim();
					ffr1=Integer.parseInt(fr);
					pre=Integer.parseInt(pres);
					rf=Float.parseFloat(rf1);
					System.out.println(rf);
					System.out.println(ffr1+pre);
					if((pre<=700)) {
						pres="900";
			String 	qry2= "UPDATE landinggear_assembly SET Pressure ='"+pres+"',Status='fault checked' WHERE Machine_id='"+ id +"'";
	         	i = DB.getconnection().prepareStatement(qry2).executeUpdate();	
					}
					if((ffr1<10)||(ffr1>20))
					{
						fr="18";
						String 	qry2= "UPDATE landinggear_assembly SET Flow_rate ='"+fr+"',Status='fault checked' WHERE Machine_id='"+ id +"'";
						i = DB.getconnection().prepareStatement(qry2).executeUpdate();		
					}
					if((Sts.equals("Low"))&&(rf>=2.3))
					{
						rf1="2.1";
						String 	qry2= "UPDATE landinggear_assembly SET RF ='"+rf1+"',Status='fault checked' WHERE Machine_id='"+ id +"'";
					 i = DB.getconnection().prepareStatement(qry2).executeUpdate();	
					}
					if((Sts.equals("Add"))&&(rf<=2.3)||(rf>=4.1))
					{
						rf1="3.5";
						String 	qry2= "UPDATE landinggear_assembly SET RF ='"+rf1+"',Status='fault checked' WHERE Machine_id='"+ id +"'";
						 i = DB.getconnection().prepareStatement(qry2).executeUpdate();	
					}
					if ((Sts.equals("Full"))&&(rf<4.1)||(rf>=8.9))
					{
						rf1="5.9";
						String 	qry2= "UPDATE landinggear_assembly SET RF ='"+rf1+"',Status='fault checked' WHERE Machine_id='"+ id +"'";
					 i = DB.getconnection().prepareStatement(qry2).executeUpdate();	
					}
				}
				if(i>0)
				{
					prw.print("<html><body><script> alert('Updated Successfully...');</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("I_prolabel.jsp");
					rd.include(request, response);	
				}else if(sts.equals("fault checked")) {
				prw.print("<html><body><script> alert('Fault Is Already Processed...');</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("I_prolabel.jsp");
					rd.include(request, response);	
				}
				else
				{
					prw.print("<html><body><script> alert('Updation failed ...');</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("I_prolabel.jsp");
					rd.include(request, response);
				}
			}catch(Exception poi)
			{
					poi.printStackTrace();
			}
			
		}
		/// Crash fault fix////////////
		else if(base.equals("Crash"))
		{
			ResultSet rs = null;
			
			String ct="",ff="",fr="",pres="",id="";
			int ffr1=0,pre=0;
		float ct1=0;
			try {
				String qry = "SELECT * FROM crash_test where Status!='Pending' And Status!='Requested' And Status !='fault checked'";
				rs = (ResultSet)DB.getconnection().createStatement().executeQuery(qry);
				int k = 1,ff1;
				int i=0;
				while (rs.next()) {
					sts=rs.getString(9);
					id=rs.getString(1);
					ct=rs.getString(4);
					ff=rs.getString(3);
					ct1=Float.parseFloat(ct);
					ff1=Integer.parseInt(ff);
					pres=rs.getString(11).trim();
					fr=rs.getString(12).trim();
					ffr1=Integer.parseInt(fr);
					pre=Integer.parseInt(pres);
					System.out.println("ct1"+ct1+"ff1"+ff1);
					
			if( (((ct1 <=0.5)||(ct1>=2.5))&&((ff1<=100)||(ff1>=200))))	
			{
				ct="1.8";
				ff="150";
				String 	qry2= "UPDATE crash_test SET cooling_tem ='"+ct+"',ff='"+ff+"',Status='fault checked' WHERE Machine_id='"+ id +"'";
			 i = DB.getconnection().prepareStatement(qry2).executeUpdate();	
			}
			if(((ct1 <=2.5)||(ct1>=4.5))&&((ff1<=200)||(ff1>=400)))	
			{
				ct="3.8";
				ff="250";
				String 	qry2= "UPDATE crash_test SET cooling_tem ='"+ct+"',ff='"+ff+"',Status='fault checked' WHERE Machine_id='"+ id +"'";
			 i = DB.getconnection().prepareStatement(qry2).executeUpdate();	
			}
			if((((ct1 <=4.5)||(ct1>=8.5))&&((ff1<=400)||(ff1>=600))))	
			{
				ct="6.8";
				ff="550";
				String 	qry2= "UPDATE crash_test SET cooling_tem ='"+ct+"',ff='"+ff+"',Status='fault checked' WHERE Machine_id='"+ id +"'";
			 i = DB.getconnection().prepareStatement(qry2).executeUpdate();		
			}
			if((pre<=700))
			{
				pres="850";
				
				String 	qry2= "UPDATE crash_test SET Pressure ='"+pres+"',Status='fault checked' WHERE Machine_id='"+ id +"'";
				 i = DB.getconnection().prepareStatement(qry2).executeUpdate();	
			}
			if((ffr1<10)||(ffr1>20))
			{
				fr="18";
				String 	qry2= "UPDATE crash_test SET Flow_rate ='"+fr+"',Status='fault checked' WHERE Machine_id='"+ id +"'";
				i = DB.getconnection().prepareStatement(qry2).executeUpdate();		
			}
			
			
		}
				if(i>0)
				{
					prw.print("<html><body><script> alert('Updated Successfully...');</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("I_prolabel.jsp");
					rd.include(request, response);	
				}else if(sts.equals("fault checked")) {
				prw.print("<html><body><script> alert('Fault Is Already Processed...');</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("I_prolabel.jsp");
					rd.include(request, response);	
				}
				else
				{
					prw.print("<html><body><script> alert('Updation failed ...');</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("I_prolabel.jsp");
					rd.include(request, response);
				}
			}catch(Exception ec)
			{
				ec.printStackTrace();
			}}
		//fix issues of wind tunnel
		else if(base.equals("Wind")){
			
			ResultSet rs = null;
			
			String tem="",ic="",WS="",AT="",AL="",id="";
			int ws1=0,at=0,al=0,i=0;
			try {
				String qry = "SELECT * FROM windtunnels_test where Status!='Pending' And Status!='Requested' And Status !='fault checked'";
				rs =(ResultSet) DB.getconnection().createStatement().executeQuery(qry);
				int k = 1,temp1=0;
				float ic1=0.0f;
				while (rs.next()) {
					sts=rs.getString(4);
					id=rs.getString(1);
					tem=rs.getString(4);
					ic=rs.getString(3);
					ic1=Float.parseFloat(ic);
					temp1=Integer.parseInt(tem);
					WS=rs.getString(11).trim();
					AT=rs.getString(12).trim();
					AL=rs.getString(13).trim();
					ws1=Integer.parseInt(WS);
					at=Integer.parseInt(AT);
					al=Integer.parseInt(AL);
					System.out.println("ic1=="+ic1+"temp1=="+temp1);
			if((ic1>=1.5) || (ic1<=2.5) &&(temp1<=120) && (temp1>=220))
			{
				tem="170";	
				String 	qry2= "UPDATE windtunnels_test SET temperature ='"+tem+"',Status='fault checked' WHERE Machine_id='"+ id +"'";
				 i = DB.getconnection().prepareStatement(qry2).executeUpdate();	
				
			}
			if((ic1>=2.5)||(ic1<=3.5) &&(temp1<=220)&&(temp1>=320))
			{
				tem="270";	
				String 	qry2= "UPDATE windtunnels_test SET temperature ='"+tem+"',Status='fault checked' WHERE Machine_id='"+ id +"'";
				 i = DB.getconnection().prepareStatement(qry2).executeUpdate();	
					
			}
			if((ic1>=3.5) ||(ic1<=4.5) &&(temp1<=320) &&(temp1>=420))
			{
				tem="370";	
				String 	qry2= "UPDATE windtunnels_test SET temperature ='"+tem+"',Status='fault checked' WHERE Machine_id='"+ id +"'";
				 i = DB.getconnection().prepareStatement(qry2).executeUpdate();		
			}
			if((ic1>=4.5) ||(ic1<=5.5) &&(temp1<=420) &&(temp1>=520))
			{
				tem="470";	
				String 	qry2= "UPDATE windtunnels_test SET temperature ='"+tem+"',Status='fault checked' WHERE Machine_id='"+ id +"'";
				 i = DB.getconnection().prepareStatement(qry2).executeUpdate();		
			}
			if(((ws1<0)||(ws1>10000)))
			{
				WS="8751";
				String 	qry2= "UPDATE windtunnels_test SET Wind_speed ='"+WS+"',Status='fault checked' WHERE Machine_id='"+ id +"'";
				 i = DB.getconnection().prepareStatement(qry2).executeUpdate();	
			}
			if((at>0))
			{
				AT="-13";
				String 	qry2= "UPDATE windtunnels_test SET Air_temperature ='"+AT+"',Status='fault checked' WHERE Machine_id='"+ id +"'";
				 i = DB.getconnection().prepareStatement(qry2).executeUpdate();	
			}
			if(at<=-20)
			{
				AT="-13";
				String 	qry2= "UPDATE windtunnels_test SET Air_temperature ='"+AT+"',Status='fault checked' WHERE Machine_id='"+ id +"'";
				 i = DB.getconnection().prepareStatement(qry2).executeUpdate();	
			}
			if((al<10)||(al>100))
			{
				AL="76"	;
				String 	qry2= "UPDATE windtunnels_test SET Altitude ='"+AL+"',Status='fault checked' WHERE Machine_id='"+ id +"'";
				 i = DB.getconnection().prepareStatement(qry2).executeUpdate();	
			}
				}
				if(i>0)
				{
					prw.print("<html><body><script> alert('Updated Successfully...');</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("I_prolabel.jsp");
					rd.include(request, response);	
				}else if(sts.equals("fault checked")) {
				prw.print("<html><body><script> alert('Fault Is Already Processed...');</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("I_prolabel.jsp");
					rd.include(request, response);	
				}
				else
				{
					prw.print("<html><body><script> alert('Updation failed ...');</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("I_prolabel.jsp");
					rd.include(request, response);
				}
			}catch(Exception x)
			{
				x.printStackTrace();
			}
				
				
		}
		
	}

}
