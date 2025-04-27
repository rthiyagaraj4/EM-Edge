/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;
 
import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Date;

import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;
import java.util.Properties;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import com.ehis.eslp.ServiceLocator;

import eCommon.SingleTabHandler.SingleTabHandlerManagerHome;


public class PatientInstructionsServlet extends HttpServlet{
	PrintWriter out;	
	Properties p;
	String instruction_id;
	String instruction_desc;	
	String effectiveStatus ;
	String facilityId ;
	String client_ip_address ;
	String new_desc="";
	
	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		session = req.getSession(false);		
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		

		try{
			res.setContentType("text/html");
			this.out = res.getWriter();
			String operation = req.getParameter("function");			

			if ( operation.equals("insert"))    insertPatientInstruction(req, res);
			if ( operation.equals("modify"))   modifyPatientInstruction(req, res);
		}catch(Exception e){
			out.println(e.toString());
		}
	}
	
	private void modifyPatientInstruction(HttpServletRequest req, HttpServletResponse res){
		try{
			new_desc="";
			instruction_id =req.getParameter("instruction_id");
			instruction_desc= req.getParameter("instruction_desc");	
			instruction_desc=instruction_desc.replaceAll("\\n","~");			
			StringTokenizer desc_token= new StringTokenizer(instruction_desc,"~");
			while(desc_token.hasMoreTokens()){
			String next_token=desc_token.nextToken().trim();            
			new_desc=new_desc+next_token+" ";
			}
			new_desc=new_desc.trim(); 
			effectiveStatus = req.getParameter("eff_status");

			if ( effectiveStatus == null )
				effectiveStatus="D";

			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;	
			Date modified_date = Date.valueOf( modifiedDate ) ;     
   
			HashMap tabdata=new HashMap();
			tabdata.put("INSTRUCTION_ID",instruction_id);
			tabdata.put("INSTRUCTION_DESC",new_desc);
			tabdata.put("EFF_STATUS",effectiveStatus);			
			tabdata.put("MODIFIED_BY_ID",modifiedById);
			tabdata.put("MODIFIED_DATE",modified_date);
			tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
			tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
			

			HashMap condflds=new HashMap();
			condflds.put("instruction_id",instruction_id);
		
			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

					Object argArray[] = new Object[4];
				String table_name="am_pat_instructions";
				argArray[0] =p;
				argArray[1] =tabdata;
				argArray[2] =condflds;
				argArray[3] =table_name;

				Class [] paramArray = new Class[4];
					paramArray[0] =p.getClass();
					paramArray[1] =tabdata.getClass();
					paramArray[2] =condflds.getClass();
					paramArray[3] =table_name.getClass();

			
			HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);			
			
			tabdata.clear();
			condflds.clear();

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			results.clear();
			if ( inserted ){
			     error_value = "1" ;
			     res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
			}else{
			     error = (String) results.get("error") ;
			     res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode( error ,"UTF-8"  ) );
			}
	    }catch ( Exception e ){
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( instruction_id+ " "+new_desc + " "+ effectiveStatus );
			e.printStackTrace();
		}
	}

	private void insertPatientInstruction(HttpServletRequest req, HttpServletResponse res)	{
		try
		{		
			new_desc="";
			instruction_id =req.getParameter("instruction_id");
			instruction_desc= req.getParameter("instruction_desc");		
			instruction_desc=instruction_desc.replaceAll("\\n","~");			
			StringTokenizer desc_token= new StringTokenizer(instruction_desc,"~");
			while(desc_token.hasMoreTokens()){
			String next_token=desc_token.nextToken().trim();            
			new_desc=new_desc+next_token+" ";
			}
			new_desc=new_desc.trim();  
			
			effectiveStatus = req.getParameter("eff_status");
			if ( effectiveStatus == null )
				effectiveStatus="D";
			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			//Date added_date = Date.valueOf( addedDate ) ;
			Date modified_date = Date.valueOf( modifiedDate ) ;     		

			HashMap tabdata=new HashMap();
			tabdata.put("INSTRUCTION_ID",instruction_id);
			tabdata.put("INSTRUCTION_DESC",new_desc);
			tabdata.put("EFF_STATUS",effectiveStatus);
			tabdata.put("ADDED_BY_ID",addedById);
			tabdata.put("ADDED_DATE",addedDate);
			tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation );
			tabdata.put("ADDED_FACILITY_ID",addedFacilityId);
			tabdata.put("MODIFIED_BY_ID",modifiedById);
			tabdata.put("MODIFIED_DATE",modified_date);
			tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
			tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);			

			String dupflds[]={"INSTRUCTION_ID"};			
			
			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		
				Object argArray[] = new Object[4];
				
				String table_name="am_pat_instructions";
				argArray[0] =p;
				argArray[1] =tabdata;
				argArray[2] =dupflds;
				argArray[3] =table_name;

				Class [] paramArray = new Class[4];
					paramArray[0] =p.getClass();
					paramArray[1] =tabdata.getClass();
					paramArray[2] =dupflds.getClass();
					paramArray[3] =table_name.getClass();

			
			HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			tabdata.clear();		

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;		
			if ( inserted ){
				 error_value = "1" ;
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );
			}else{
				 error = (String) results.get("error") ;
				

				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8"  ) );
			}
			results.clear();
		}catch ( Exception e ){
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( instruction_id+ " "+new_desc + " "+ effectiveStatus );
			e.printStackTrace();
		}
	}
}
