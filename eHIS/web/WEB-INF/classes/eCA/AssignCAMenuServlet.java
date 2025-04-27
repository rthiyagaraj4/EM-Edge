/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------
Date       Edit History      Name        	Description
-----------------------------------------------------------------------
?             100            ?           	created
21/11/2012	IN035912		Nijitha	   		CHL Hospital suggested that the presentation of the Clinician desktop be 
										    changed and more appealing. Keeping the display of information more clear and visible.
06/08/2013		IN036733	Nijitha			Bru-HIMS-CRF-328										    
-----------------------------------------------------------------------
*/
package eCA;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.SingleTabHandler.*;

public class AssignCAMenuServlet extends javax.servlet.http.HttpServlet
{

	private String getMessage(String locale, String messageId, String moduleId)
	{
		java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg					= (String) message.get("message");

		message.clear();
		return(mesg) ;
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");

		try
		{
			
			out = res.getWriter();
			String mode =(req.getParameter("mode")==null)?"":req.getParameter("mode");
			
			if(mode.trim().equalsIgnoreCase("delete") || mode=="delete")
					delete(req, res, out);
			if (mode.trim().equalsIgnoreCase("insert"))
					insert(req, res, out);
			if(mode.trim().equalsIgnoreCase("modify"))
					modify(req, res, out);
		}
		catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
	}

public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
{
	PrintWriter out = null;
	try
	{
		//req.setCharacterEncoding("UTF-8");
		//res.setContentType("text/html;charset=UTF-8");
		out = res.getWriter();
		doPost(req, res);

	}
	catch(Exception ei)
	{	
			//out.println(ei.toString());//common-icn-0181
			ei.printStackTrace();
	}
}

private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
{
	java.util.Properties p;
	HttpSession session;

	String practitioner_id		=	"";
	String patient_class		=	"";
	String pract_type			=	"";
	String speciality_code		=	"";
	String menu_id				=	"";
	String summaryLegend = "";//IN035912
	String navigationLegend = "";//IN035912
	String facility_id="";//IN036733

	session = req.getSession(false);

	p				= (Properties)session.getValue("jdbc") ;

	try
	{
			patient_class=req.getParameter("patient_class1");
			if(patient_class == null || patient_class == "")
				patient_class="*A";
			
			practitioner_id=req.getParameter("practitioner_id1");
			if(practitioner_id == null || practitioner_id == " ")
				practitioner_id="*ALL";

			speciality_code=req.getParameter("speciality_code2");
			if(speciality_code == null || speciality_code == "" )
				speciality_code="*ALL";
			
			pract_type=req.getParameter("pract_type");
			if(pract_type == null || pract_type == " ")
				pract_type="*A";

			menu_id=req.getParameter("menu_id1");
			if(menu_id  == null )
				menu_id="";
			//IN035912 Starts
			summaryLegend=req.getParameter("legendSummary");
			if(summaryLegend  == null )
				summaryLegend="";
		
			navigationLegend=req.getParameter("legendNavigation");
			if(navigationLegend  == null )
				navigationLegend="";
			//IN035912 Ends
			//IN036733 Starts
			facility_id = req.getParameter("facilityName");
			if(facility_id  == null )
				facility_id="*A";
			//IN036733 Ends
			HashMap tabdata = new HashMap(); 		
			String error ="";
			boolean inserted=false;
			java.util.HashMap results=null;
			if(!"".equals(navigationLegend.trim()) && !"".equals(summaryLegend.trim()))
			{
			tabdata.put("practitioner_id", practitioner_id );
			tabdata.put("patient_class",patient_class);
			tabdata.put("pract_type",pract_type);
			tabdata.put("speciality_code",speciality_code);
			tabdata.put("menu_id",menu_id);
			//IN035912 Starts
			tabdata.put("LEGEND_FOR_SUMMARY",summaryLegend);
			tabdata.put("LEGEND_FOR_NAVIGATION",navigationLegend);
			//IN035912 Ends
			tabdata.put("FACILITY_ID",facility_id);           //IN036733
			//String dupflds[]={"practitioner_id","patient_class","pract_type"};  // "speciality_code"}; //IN036733
			String dupflds[]={"practitioner_id","patient_class","pract_type","FACILITY_ID"};  // "speciality_code"}; //IN036733
			String table_name = "ca_app_custom_menu";


			boolean local_ejbs = false;
			
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = table_name;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = table_name.getClass();


			results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			tabdata.clear();

			 inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			}
			else{
			error = "Summary or Navigation Legend Description Cannot be Empty";
			}

			//String error = (String) results.get("error") ;
			if(null!=results)
			error = (String) results.get("error") +error;
			String error_value = "0" ;
			
			if ( inserted )
				error_value = "1" ;
			if(null!=results)
			results.clear();
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8") +"&err_value="+error_value);

	}//end of try block
	catch ( Exception e )
	{
		//out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());//common-icn-0181
		e.printStackTrace();
									
	}
}//end of insert 



/************************** modify *****************************************/


private void modify(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
{
	java.util.Properties p;
	
	StringBuffer countsql= new StringBuffer();
	int maxrecord=0;

	String practitioner_id="";
	String patient_class="";
	String pract_type="";
	String speciality_code="";
	String menu_id="";
	//IN035912 Starts

	String summaryLegend = "";
	String navigationLegend = "";
	//IN035912 Ends
	HttpSession session;
	session = req.getSession(false);
	p = (Properties)session.getValue("jdbc") ;
	String locale = (String) p.getProperty("LOCALE");
	String facility_id = "";//IN036733
	try
	{
		patient_class="";
		patient_class=req.getParameter("patient_class2");
		if(patient_class == null)
			patient_class="";
	
		practitioner_id="";
		practitioner_id=req.getParameter("practitioner_id1");
		if(practitioner_id == null)
			practitioner_id="";

		speciality_code="";
		speciality_code=req.getParameter("speciality_code2");
		if(speciality_code == null)
			speciality_code="";
	
		pract_type="";
		pract_type=req.getParameter("pract_type1");
		if(pract_type == null)
			pract_type="";

		menu_id="";
		menu_id=req.getParameter("menu_id_hddn");
		if(menu_id  == null)
			menu_id="";
		//IN035912 Starts
		summaryLegend=req.getParameter("legendSummary");
		if(summaryLegend  == null )
			summaryLegend="";
	
		navigationLegend=req.getParameter("legendNavigation");
		if(navigationLegend  == null )
			navigationLegend="";
		//IN035912 Ends
		//IN036733 Starts
		facility_id = req.getParameter("facilityName");//IN036733
		if(facility_id  == null )
			facility_id="*A";
		//IN036733 Ends
//	String		menu_id1="";
//		menu_id1=req.getParameter("menu_id1");
//		if(menu_id1  == null)
//			menu_id1="";

		String	menu_checkUpdate="";
		menu_checkUpdate=req.getParameter("menu_checkUpdate");
		if(menu_checkUpdate  == null)
			menu_checkUpdate="";
		
		HashMap tabdata = new HashMap(); 		

		tabdata.put("practitioner_id", practitioner_id );
		tabdata.put("patient_class",patient_class);
		tabdata.put("pract_type",pract_type);
		tabdata.put("speciality_code",speciality_code);
		tabdata.put("menu_id",menu_id);
//		tabdata.put("locale",locale);
		tabdata.put("LEGEND_FOR_SUMMARY",summaryLegend);//IN035912
		tabdata.put("LEGEND_FOR_NAVIGATION",navigationLegend);//IN035912
		tabdata.put("FACILITY_ID",facility_id);//IN036733

		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rset=null;
	
	try
	{		if(countsql.length() > 0) countsql.delete(0,countsql.length());
			countsql.append("select count(*) as total from ");
			countsql.append("ca_app_custom_menu where practitioner_id=? ");
			countsql.append("and patient_class=? and pract_type=? ");
			countsql.append("and speciality_code=? and menu_id=? ");
			countsql.append("and LEGEND_FOR_SUMMARY=? and LEGEND_FOR_NAVIGATION=? ");//IN035912
			countsql.append("and FACILITY_ID =?");//IN036733
			con=ConnectionManager.getConnection(req);
			stmt = con.prepareStatement(countsql.toString());
			stmt.setString(1,practitioner_id);
			stmt.setString(2,patient_class);
			stmt.setString(3,pract_type);
			stmt.setString(4,speciality_code);
			stmt.setString(5,menu_id);
			//IN035912 Starts
			stmt.setString(6,summaryLegend);
			stmt.setString(7,navigationLegend);
			//IN035912 Ends
			stmt.setString(8,facility_id);//IN036733
			rset = stmt.executeQuery();

			while (rset.next())
			{
				maxrecord = rset.getInt("total");
			}
		if(rset!=null) rset.close();
		if(stmt!=null) stmt.close();
			
	}
	catch(Exception e)
	{
		//out.println("Exception in Count Block "+e.toString());//common-icn-0181
		e.printStackTrace();
	}
	finally
	{		
			if(con!=null) ConnectionManager.returnConnection(con,req);

	}

// redirecting to the error page if the record alredy exists
	/*if(maxrecord > 0)
	{
		String errorMsg = getMessage(locale, "CODE_ALREADY_EXISTS","Common");
		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( errorMsg,"UTF-8")+"&err_value=0");
	}
	else
	{*/


			HashMap condflds=new HashMap();
			condflds.put("practitioner_id",practitioner_id);
			condflds.put("patient_class",patient_class);
			condflds.put("pract_type",pract_type);
			condflds.put("speciality_code",speciality_code);
			condflds.put("menu_id",menu_checkUpdate);
			condflds.put("FACILITY_ID",facility_id);//IN036733
//			condflds.put("locale",locale);

			String table_name = "ca_app_custom_menu";

	
			boolean local_ejbs = false;
			
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = table_name;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = table_name.getClass();
			java.util.HashMap results =null;
			boolean modified=false;
			String error ="";
			if(!"".equals(navigationLegend.trim()) && !"".equals(summaryLegend.trim()))
			{
			 results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			tabdata.clear();
			condflds.clear();

			//boolean modified = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			modified = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			}else
			{
			error = "Summary or Navigation Legend Description Cannot be Empty";
			}
			//String error = (String) results.get("error") ;
			if(null!=results)
			error = (String) results.get("error")+error;
			String error_value = "0" ;
			if ( modified )
			{
				 error_value = "1" ;
			}
			//error = (String) results.get("error") ;
			if(null!=results)
			results.clear();
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);

	//	}
	}//end of try block
	catch ( Exception e )
	{
		e.printStackTrace();
		//out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());//common-icn-0181
		
	}
}//end of modify 

private void delete(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
{
	java.util.Properties p;
	HttpSession session;

	String practitioner_id="";
	String patient_class="";
	String pract_type="";
	String speciality_code="";
	String menu_id="";
	//IN035912 Starts
	
	String summaryLegend = "";
	String navigationLegend = "";
	//IN035912 Ends

	session = req.getSession(false);
	p = (Properties)session.getValue("jdbc") ;

	try
	{
		patient_class=req.getParameter("patient_class2");
		practitioner_id=req.getParameter("practitioner_id1");
		speciality_code=req.getParameter("speciality_code2");
		pract_type=req.getParameter("pract_type1");
		menu_id=req.getParameter("menu_id_hddn");
		
		//IN035912 Starts
		
		summaryLegend=req.getParameter("legendSummary");
		
	
		navigationLegend=req.getParameter("legendNavigation");
		String facility_id = req.getParameter("facilityName");//IN036733
		//IN035912 Ends
		HashMap condflds=new HashMap();
		condflds.put("patient_class",patient_class);
		condflds.put("practitioner_id",practitioner_id); 
		condflds.put("speciality_code",speciality_code);  
		condflds.put("pract_type",pract_type); 
		condflds.put("menu_id",menu_id);
//		condflds.put("locale",locale);
		//IN035912 Starts
		
		condflds.put("LEGEND_FOR_SUMMARY",summaryLegend);
		condflds.put("LEGEND_FOR_NAVIGATION",navigationLegend);
		condflds.put("FACILITY_ID",facility_id);//IN036733
		//IN035912 Ends

		String table_name = "ca_app_custom_menu";
	

			boolean local_ejbs = false;
			
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[3];
			argArray[0] = p;
			argArray[1] = condflds;
			argArray[2] = table_name;

			Class [] paramArray = new Class[3];
			paramArray[0] = p.getClass();
			paramArray[1] = condflds.getClass();
			paramArray[2] = table_name.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			condflds.clear();
			
			boolean deleted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
    
		String error = (String) results.get("error") ;
		String error_value = "0" ;
		if (deleted)
		{
			 error_value = "1" ;
		}
        else
		{
			 error = (String) results.get("error") ;
		}
        error = (String) results.get("error") ;
		results.clear();
        res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
	}//try
	catch (Exception e)
	{
			//out.println("<h3> Exception raised by Servlet ...So Record Not Deleted </h3> Foll: Error Received : "+e.toString());//common-icn-0181
			e.printStackTrace();
	}

}//end of delete

}//end of class
			
				
			
