/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/***** Last Modified Date 9/22/2005 12:26 PM *******/
package eMP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.SingleTabHandler.*;

public class MRecordsSectionServlet extends javax.servlet.http.HttpServlet	{

PrintWriter out;

java.util.Properties p;
String mrfacilityid;
String mrSectionCode;
String longName ;
String shortName ;
String sectionType;
String prefixRequired;

long NextSerialNo;
long MaxSerialNo;
String oldMrnNo;
String effectiveDateFrom ;
String effectiveDateTo ;
String effectiveStatus ;
String facilityId ;
String client_ip_address ;

public void init(ServletConfig config) throws ServletException	{
	   super.init(config);
}

public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
{
	req.setCharacterEncoding("UTF-8");
	res.setContentType("text/html;charset=UTF-8");	
	HttpSession session = req.getSession(false);
	this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
	this.facilityId = (String) session.getValue( "facility_id" ) ;
	client_ip_address = p.getProperty("client_ip_address");

  	try {
		this.out = res.getWriter();
		String operation = req.getParameter("function");

        if ( operation.equals("insert") )
		    insertMRSection(req, res);

	    if ( operation.equals("modify"))
		    modifyMRSection(req, res);

	}
	catch (Exception e)	{
		out.println(e.toString());
	}
}

private void modifyMRSection(HttpServletRequest req, HttpServletResponse res)	
{
	try 
	{
		mrSectionCode = req.getParameter("section_code");
	      longName = req.getParameter("long_name");
	      shortName = req.getParameter("short_name");
	      sectionType = req.getParameter("section_type");
		  
	      prefixRequired = req.getParameter("prefix_req")==null ? "N" : req.getParameter("prefix_req");
	      NextSerialNo = Long.parseLong( req.getParameter("next_srl") );
		  MaxSerialNo = Long.parseLong( req.getParameter("max_srl") );
	      oldMrnNo = req.getParameter("old_mrn")==null ? "N" : req.getParameter("old_mrn");
	     
	      effectiveStatus = req.getParameter("eff_status")==null ? "D" : req.getParameter("eff_status");

	String addedById = p.getProperty( "login_user" ) ;
	String modifiedById = addedById ;

	String modifiedFacilityId = facilityId ;
	String addedAtWorkstation=client_ip_address;
	String modifiedAtWorkstation = addedAtWorkstation ;


			HashMap tabdata=new HashMap();
			tabdata.put("mr_section_code",mrSectionCode);
			tabdata.put("long_name",longName);
			tabdata.put("short_name",shortName);
			tabdata.put("mr_section_type",sectionType);
			tabdata.put("prefix_reqd_yn",prefixRequired);
			tabdata.put("next_srl_no",new Long(NextSerialNo));
			tabdata.put("max_srl_no",new Long(MaxSerialNo));
			tabdata.put("prompt_for_old_file_no_yn",oldMrnNo);
		
			tabdata.put("eff_status",effectiveStatus);

			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
           

			HashMap condflds=new HashMap();
			condflds.put("mr_section_code",mrSectionCode);

			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = "MR_SECTION";

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass(); ;
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = String.class;
			
			java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;			

         String error = (String) results.get("error") ;
		 String error_value = "0" ;
			tabdata.clear();
			condflds.clear();
			results.clear();
		if ( inserted ) error_value = "1" ;
    	 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );

		}
		catch ( Exception e ) {
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			//out.println( "Values sent are : <br>" ) ;
			//out.println( mrSectionCode + " "+longName + " "+shortName +" "+ effectiveDateFrom+" "+ effectiveDateTo + " "+ effectiveStatus );
			e.printStackTrace(); // Added by lakshmanan for security issue ID 169542731 on 14-08-2023
		}
	}


private void insertMRSection(HttpServletRequest req, HttpServletResponse res)	{
	Connection con = null;
	ResultSet rs = null ;
	PreparedStatement pstmt=null;
try {
	      mrfacilityid = req.getParameter("facility");
		  mrSectionCode = req.getParameter("section_code");
	      longName = req.getParameter("long_name");
	      shortName = req.getParameter("short_name");
	      sectionType = req.getParameter("section_type");
		
	      prefixRequired = req.getParameter("prefix_req")==null ? "N" : req.getParameter("prefix_req");
	      NextSerialNo = Long.parseLong( req.getParameter("next_srl") );
		  MaxSerialNo = Long.parseLong( req.getParameter("max_srl") );
	      oldMrnNo = req.getParameter("old_mrn")==null ? "N" : req.getParameter("old_mrn");
	     
	      effectiveStatus = req.getParameter("eff_status")==null ? "D" : req.getParameter("eff_status");
	     String addedById = p.getProperty( "login_user" ) ;

	String modifiedById = addedById ;

	String addedFacilityId=facilityId;
	String modifiedFacilityId = facilityId ;
	String addedAtWorkstation=client_ip_address;
	String modifiedAtWorkstation = addedAtWorkstation ;


	HashMap tabdata=new HashMap();
	
	
	String error_value="";
	
		if(prefixRequired.equals("N"))
		{
			long max_srl_no=0;			
			con = ConnectionManager.getConnection(req);
			pstmt=con.prepareStatement("Select max(max_srl_no) from mr_section where facility_id = ? and prefix_reqd_yn='N'" );
			pstmt.setString(1,facilityId);
			rs = pstmt.executeQuery() ;
			if (rs.next())
				max_srl_no=rs.getLong(1);
			if (NextSerialNo <= max_srl_no)
			{				
				
				error_value="0";
				MessageManager mm = new MessageManager();
				final java.util.Hashtable message = mm.getMessage( con,"OVERLAP_NOT_ALLOWED" ) ;
				String msg =  (String) message.get("message");
				message.clear();
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( msg , "UTF-8") + "&err_value=" + error_value );
			}
			if (rs!=null) rs.close();
			if (pstmt!=null) pstmt.close();
		}
		
		if (error_value.equals(""))
		{
			tabdata.put("facility_id",mrfacilityid);
			tabdata.put("mr_section_code",mrSectionCode);
			tabdata.put("long_name",longName);
			tabdata.put("short_name",shortName);
			tabdata.put("mr_section_type",sectionType);
			tabdata.put("prefix_reqd_yn",prefixRequired);
			tabdata.put("next_srl_no",new Long(NextSerialNo));
			tabdata.put("max_srl_no",new Long(MaxSerialNo));
			tabdata.put("prompt_for_old_file_no_yn",oldMrnNo);
			
			tabdata.put("eff_status",effectiveStatus);
			
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("added_facility_id", addedFacilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);	
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			String dupflds[]={"facility_id","mr_section_code"};

			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = "MR_SECTION";

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass(); ;
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = String.class;
			
			java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			error_value = "0" ;

			tabdata.clear();
			results.clear();

			if (rs!=null) rs.close();
			if (pstmt!=null) pstmt.close();

			if ( inserted ) error_value = "1" ;
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );
		}
		tabdata.clear();
	}
	catch ( Exception e ) {
		//out.println(e.getMessage());
		//out.println(e.toString());
		e.printStackTrace(); // Added by lakshmanan for security issue ID 169518268 on 14-08-2023
	}	
	finally
	{
		if(con != null) ConnectionManager.returnConnection(con,req);
	}
}
boolean isLocalEJB(){
		ServletContext context = getServletConfig().getServletContext();
		if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				return true;
		else
				return false;
	}
}
