/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import com.ehis.util.*;
import java.net.*;
import webbeans.eCommon.*;
import eCommon.SingleTabHandler.*;


public class MaintainDeathRegisterServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	java.util.Properties p;
	String added_by_id = "";
	String added_at_ws_no = "";
	String added_facility_id = "";
	String facilityId1 ;
	String client_ip_address = "";
	String locale			 = "";
	HttpSession session;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId1 = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		try
		{
			this.out = res.getWriter();
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			maintainDeathAddModify(req,res);

		}
		catch(Exception e)	
		{
			//out.println(e.toString());	
			e.printStackTrace();
		}
	}
	
	
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{			
		
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId1 = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");
		try
		{			
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			maintainDeathAddModify(req,res);
		}
		catch(Exception e)
		{
			//out.println(e.toString());
			e.printStackTrace();
		}
	}
	
	private void maintainDeathAddModify(HttpServletRequest req, HttpServletResponse res)
	{		
		try
		{
//			ArrayList insertData = new ArrayList() ;
			String error_value="0";
			String error="";
			
           	added_by_id 	= p.getProperty( "login_user" ) ;
			locale			= p.getProperty("LOCALE");
			added_at_ws_no	= client_ip_address;
			added_facility_id= facilityId1;

			String encounter_id       = checkForNull(req.getParameter("encounter_id"));
			String deceased_date_time = checkForNull(req.getParameter("deceased_date_time"));
			String remarks			  = checkForNull(req.getParameter("remarks"));
			String pract_id			  = checkForNull(req.getParameter("auth_pract_id"));
		
			deceased_date_time	      = DateUtils.convertDate(deceased_date_time,"DMYHM",locale,"en"); 	
	
			
			
			HashMap updateValues1 = new HashMap();
			HashMap updateValues2 = new HashMap();


			updateValues1.put("ADDED_AT_WS_NO",client_ip_address);
			updateValues1.put("MODIFIED_DATE",new java.sql.Timestamp(System.currentTimeMillis()));
			updateValues1.put("ADDED_BY_ID",added_by_id);
			updateValues1.put("ADDED_DATE",new java.sql.Timestamp(System.currentTimeMillis()));
			updateValues1.put("ADDED_FACILITY_ID",added_facility_id);
			updateValues1.put("MODIFIED_AT_WS_NO",client_ip_address);
			updateValues1.put("MODIFIED_BY_ID",added_by_id);
			updateValues1.put("MODIFIED_FACILITY_ID",added_facility_id);
			updateValues1.put("DECEASED_DATE_TIME",setDateValue(deceased_date_time));  

			HashMap condflds=new HashMap();
			condflds.put("ENCOUNTER_ID",encounter_id);
			condflds.put("FACILITY_ID",facilityId1);
			
			String tabname = "PR_ENCOUNTER";

			try
			{
					boolean local_ejbs = false;
					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
	

					Object argArray[] = new Object[4];
					argArray[0] = p;
					argArray[1] = updateValues1;
					argArray[2] = condflds;
					argArray[3] = tabname;
						
					Class [] paramArray = new Class[4];
					paramArray[0] = p.getClass();
					paramArray[1] = updateValues1.getClass();
					paramArray[2] = condflds.getClass();
					paramArray[3] = tabname.getClass();

					
					java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
						boolean updated = (((Boolean)results.get("status")).booleanValue());
						error = (String) results.get("error") ;

						if ( updated )
						{
							try
							{
								
								updateValues2.put("ADDED_AT_WS_NO",client_ip_address);
								updateValues2.put("MODIFIED_DATE",new java.sql.Timestamp(System.currentTimeMillis()));
								updateValues2.put("ADDED_BY_ID",added_by_id);
								updateValues2.put("ADDED_DATE",new java.sql.Timestamp(System.currentTimeMillis()));
								updateValues2.put("ADDED_FACILITY_ID",added_facility_id);
								updateValues2.put("MODIFIED_AT_WS_NO",client_ip_address);
								updateValues2.put("MODIFIED_BY_ID",added_by_id);
								updateValues2.put("MODIFIED_FACILITY_ID",added_facility_id);
								updateValues2.put("REMARKS",remarks);  
								updateValues2.put("AUTH_PRACTITIONER_ID",pract_id);  
								


								tabname = "MR_DEATH_REGISTER_HDR";

								argArray[1] = updateValues2;
								argArray[3] = tabname;

								paramArray[1] = updateValues2.getClass();
								paramArray[3] = tabname.getClass();


								results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
								updated = (((Boolean)results.get("status")).booleanValue());
								error = (String) results.get("error") ;
								
								if ( updated )
								{
									error_value= "1";
								}
								else
								{
									error_value= "0";
								}								
							}
							catch (Exception exp)
							{
								exp.printStackTrace();
								error = "Error ";
								error_value = "0" ;
								res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
							}
								
						}
						else
						{
								error_value= "0";
						}
			}
			 catch(Exception exp)
			 {
						
						exp.printStackTrace();
						error = "Error ";
						error_value = "0" ;
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			 }

			//res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			out.println("<script>alert(\" " +  error + "\");parent.window.close();</script>");
			if (updateValues1 != null) updateValues1.clear();	
			if (updateValues2 != null) updateValues2.clear();	
			if (condflds != null )  condflds.clear();
		} 
		catch ( Exception e ) 
		{
			/* out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ; */
			e.printStackTrace();
		}
	}

	public String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}
		public String checkForNull(String inputString, String Defaultstr)
	{
		return((inputString == null) ? Defaultstr : inputString);
	}

	private static Timestamp setDateValue(String input1)
	{
		Timestamp receiveTimestamp	= new Timestamp(System.currentTimeMillis());
		StringTokenizer receivetoks = new StringTokenizer(input1," ") ;
		StringTokenizer receivetok1 = new StringTokenizer(receivetoks.nextToken(), "/" ) ;
		String receiveArr[] =new String[3] ;
		for( int q=0;q<3;q++ )
		{
			receiveArr[q] = receivetok1.nextToken() ;
		}
		String time24 = receivetoks.nextToken();
		if(time24.equals("")||(time24==null)) time24="00:00";
		input1 = receiveArr[2]+"-"+receiveArr[1]+"-"+ receiveArr[0]+" "+time24+":00";
		receiveTimestamp= Timestamp.valueOf(input1);
		return (receiveTimestamp);		
	}


}
