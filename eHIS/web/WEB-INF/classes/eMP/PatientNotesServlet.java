/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import com.ehis.util.*;

import eCommon.SingleTabHandler.*;

import eCommon.XSSRequestWrapper;

public class PatientNotesServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	String client_ip_address="", patientid="",facilityId="",addedby_notes="",addedby_id="",addedby_date="",addedfacilityId="",locale="",encounter_id1="",visit_date_time="",visit_date_time1="";
	
  


	HttpSession session;
	//java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd HH:mm:ss a" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;	
        locale = p.getProperty("LOCALE");			
		
		try
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			req= new XSSRequestWrapper(req);
			res.addHeader("X-XSS-Protection", "1; mode=block");
			res.addHeader("X-Content-Type-Options", "nosniff");
			this.out = res.getWriter();
			
			String operation = req.getParameter("operation")==null?"":req.getParameter("operation");     
			
			if (operation.equals("insert")) insertRemarks(req);
			


		}
		catch(Exception e)
		{
			//out.println(e.toString());
			e.printStackTrace();
		}
	}





	private synchronized void insertRemarks(HttpServletRequest req)
	{
		try
		{


			
			

			HashMap tabdata=new HashMap();
			long encounter_id=0;
			patientid = req.getParameter("patientid")==null?"":req.getParameter("patientid");
			//encounter_id = req.getParameter("encounter_id")==null?:req.getParameter("encounter_id");
			encounter_id1 = req.getParameter("encounter_id")==null?"":req.getParameter("encounter_id");
			
			if(!encounter_id1.equals("")){
				encounter_id = (Long.valueOf(encounter_id1)).longValue();
			}
			
			visit_date_time = req.getParameter("visit_date_time")==null?"":req.getParameter("visit_date_time");
			addedby_notes = req.getParameter("addedremarks")==null?"":req.getParameter("addedremarks").trim();
			client_ip_address = p.getProperty("client_ip_address");
			addedby_id= p.getProperty("login_user");
			addedfacilityId=facilityId;			
			//String addedDate = dateFormat.format( new java.util.Date() ) ;			
			//String added_date = addedDate ;
			//java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
			java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;			
			java.sql.Date addeddate1 = java.sql.Date.valueOf(addedDate) ;
			
			
			
			if(!visit_date_time.equals("")){
				visit_date_time1=com.ehis.util.DateUtils.convertDate(visit_date_time,"DMYHM",locale,"en");
				StringTokenizer str=new StringTokenizer(visit_date_time1, " ");					
				String date=str.nextToken();
				String time=str.nextToken();
				StringTokenizer str1=new StringTokenizer(date, "/");
				String day=str1.nextToken();
				String month=str1.nextToken();		
				String year=str1.nextToken();
				visit_date_time1=year+"-"+month+"-"+day+" "+time+":00.00";				
			}				
			
			tabdata.put("patient_id",patientid);
			tabdata.put("notes",addedby_notes);
			tabdata.put("added_by_id",addedby_id);
			//tabdata.put("added_date",addedDate);
			tabdata.put("added_date",addeddate1);
			tabdata.put("added_at_ws_no",client_ip_address);
			tabdata.put("added_facility_id",addedfacilityId);
			if(!visit_date_time.equals("")){
				tabdata.put("encounter_id",encounter_id);
				tabdata.put("encounter_date_time",Timestamp.valueOf((visit_date_time1)));
				//tabdata.put("encounter_date_time",visit_date_time);
			}
			
			
			
			
			String condflds[]={"patient_id","added_by_id","added_date"};
			
		   String tableName = "MP_PATIENT_NOTES";
			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = tableName;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = tableName.getClass();

			HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted	= ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			
			String error ="";

			if(inserted)
			{ 

			   error = (String) results.get("error") ;			
			 //  out.println("<script>alert('"+error+"');parent.window.close();</script>");			out.println("<script>parent.frames(2).location.href='../eAE/jsp/AERegAttnError.jsp?err_num=" +java.net.URLEncoder.encode( error, "UTF-8" )+ "<br>'</script>");
			   out.println("<script>alert('"+error+"');</script>");	
			   out.println("<script>parent.PatientNotes.onSuccess('"+patientid+"','"+encounter_id+"','"+visit_date_time+"');</script>");
			}else{
			   error = (String) results.get("error") ;			
			   out.println("<script>alert('"+error+"');</script>");
			}
			/*if(inserted)
			{   
			    
				Hashtable message = MessageManager.getMessage( locale, "RECORD_MODIFIED" ,"SM") ;				
				error = (String) message.get("message") ; 
				System.out.println("error===>"+error);
				out.println("<script>alert('"+error+"');parent.window.close();</script>");
				
				if ( message != null ) message.clear();
			}
			else
			{
				out.println("<script>parent.window.close();</script>");
				
			}*/
		}
		catch ( Exception e )
		{
			//out.println("<h3> Exception raise by Servlet ...So Record Not Inserted </h3> Foll: Error Received : "+e.toString());
			e.printStackTrace();

		}

	}


} 
