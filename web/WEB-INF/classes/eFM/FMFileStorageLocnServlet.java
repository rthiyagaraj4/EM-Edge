/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM;

import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import eCommon.SingleTabHandler.*;

public class FMFileStorageLocnServlet extends HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	HttpSession session;
	Properties p;
	String facilityId;
	String client_ip_address;

	String StLocnCode;		
	String StLocnShortDesc;
	String StLocnLongDesc;
	String MRLocnYN;	
	String PFileAreaYN;	
	String LocnIdentity;
	String ReturnCriteria;
	String NoOfDays;	
	String narrCode	;	
	String StLocnEffStatus;
	String p_holder_name;
	String p_holder_phone_no;
	String duration_type;
	String no_of_dh_to_return_ip;
	String no_of_dh_to_return_op;
	String no_of_dh_to_return_em;
	String no_of_dh_to_return_dc;
	String p_mr_section_code;
	String locale			= "" ;
	
	Connection con = null; //Added HSA-CRF-0306.1
	CallableStatement cstmt = null; //Added HSA-CRF-0306.1
	String errmsg=""; //Added HSA-CRF-0306.1

	boolean inserted		= false;
	
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		this.out = res.getWriter();
		try	
		{
			session 			= req.getSession(true);
			this.p 				= (java.util.Properties) session.getValue("jdbc") ;
			locale = p.getProperty("LOCALE");
			facilityId 			= (String) session.getValue( "facility_id" ) ;
			this.client_ip_address 	= p.getProperty("client_ip_address");

			StLocnCode		= req.getParameter("stglocncode");		
			StLocnShortDesc	= req.getParameter("stgshortdesc");
			StLocnLongDesc	= req.getParameter("stglongdesc"); 
			MRLocnYN		= req.getParameter("mrlocation");	
			PFileAreaYN		= req.getParameter("storagelocation");	
			LocnIdentity	= req.getParameter("locationidentity");
			ReturnCriteria	= req.getParameter("returncriteria");
			NoOfDays		= req.getParameter("noofdays");	
			narrCode		= req.getParameter("narration");	
			StLocnEffStatus	= req.getParameter("effstatus");
			p_holder_name	= req.getParameter("p_holder_name");
			p_holder_phone_no = req.getParameter("p_holder_phone_no");
			p_mr_section_code      = req.getParameter("mr_section_code");
			no_of_dh_to_return_em   = req.getParameter("noofdays_em");
			no_of_dh_to_return_dc   = req.getParameter("noofdays_dc");
			
			if(p_mr_section_code == null || p_mr_section_code.equals("")) 
				p_mr_section_code =  "";

			if(no_of_dh_to_return_em == null)
				no_of_dh_to_return_em = "";

			if(no_of_dh_to_return_dc == null)
				no_of_dh_to_return_dc = "";
			
			if(req.getParameter("duration_type") != null)
				duration_type = req.getParameter("duration_type");
			else
				duration_type = "";

			if(req.getParameter("noofdays_ip") != null)
				no_of_dh_to_return_ip = req.getParameter("noofdays_ip");
			else
				no_of_dh_to_return_ip = "";

			if(req.getParameter("noofdays_op") != null)
				no_of_dh_to_return_op = req.getParameter("noofdays_op");
			else
				no_of_dh_to_return_op = "";
			

			if ( NoOfDays == null )		NoOfDays="";
			if ( narrCode == null )		narrCode="";

			if ( MRLocnYN == null )		MRLocnYN="N";
			if ( PFileAreaYN == null )
			{
				PFileAreaYN="N";
			}
			else if ( PFileAreaYN.equals("Y") )
			{
				//ReturnCriteria = "";  
				 ReturnCriteria = "I";  //Added this CRF HSA-CRF-0306.1  value assigned from Empty to "I"
			}
		
			if ( StLocnEffStatus == null )	StLocnEffStatus="D";

			if (p_holder_name==null)
			{
				p_holder_name="";
			}

			if (p_holder_phone_no==null)
			{
				p_holder_phone_no="";
			}
	
			String operation = req.getParameter("operation");

			if ( operation.equals("insert") )
				createStorageLocation(req, res, locale);
			if ( operation.equals("modify"))
				modifyStorageLocation(req, res, locale);

		}catch(Exception e)
		{
			out.println(e.toString());
		}
	}

	private void  createStorageLocation(HttpServletRequest req, HttpServletResponse res, String locale)
	{
		try
		{
			String addedById			= p.getProperty( "login_user" ) ;		
			String modifiedById			= addedById ;		
			String addedFacilityId		= facilityId;
			String modifiedFacilityId	= addedFacilityId ;
			String addedAtWorkstation	=client_ip_address;
			String modifiedAtWorkstation= addedAtWorkstation ;

			Timestamp  DateTime = new Timestamp(System.currentTimeMillis() );

			HashMap tabdata=new HashMap();
			tabdata.put("FACILITY_ID",facilityId);
			tabdata.put("FS_LOCN_CODE",StLocnCode);
			tabdata.put("LONG_DESC",StLocnLongDesc);
			tabdata.put("SHORT_DESC",StLocnShortDesc);
			tabdata.put("MR_LOCN_YN",MRLocnYN);
			tabdata.put("PERMANENT_FILE_AREA_YN",PFileAreaYN);
			tabdata.put("LOCN_IDENTITY",LocnIdentity);
			tabdata.put("RETURN_CRITERIA",ReturnCriteria);
			tabdata.put("NO_OF_DAYS_TO_RETURN",NoOfDays);
			tabdata.put("NARRATION_CODE",narrCode);
			tabdata.put("HOLDER_NAME",p_holder_name);
			tabdata.put("HOLDER_PHONE_NO",p_holder_phone_no);
			tabdata.put("EFF_STATUS",StLocnEffStatus);
			tabdata.put("MR_SECTION_CODE",p_mr_section_code);
			tabdata.put("ADDED_BY_ID",addedById);
			tabdata.put("ADDED_DATE",DateTime);
			tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
			tabdata.put("ADDED_FACILITY_ID", facilityId);
			tabdata.put("MODIFIED_BY_ID",modifiedById);
			tabdata.put("MODIFIED_DATE",DateTime);
			tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
			tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation);
			tabdata.put("duration_type",duration_type);
			tabdata.put("no_of_dh_to_return_ip",no_of_dh_to_return_ip);
			tabdata.put("no_of_dh_to_return_op",no_of_dh_to_return_op);
			tabdata.put("NO_OF_DH_TO_RETURN_EM",no_of_dh_to_return_em);
			tabdata.put("no_of_dh_to_return_dc",no_of_dh_to_return_dc);
			//tabdata.put("locale",locale);
			
			String dupflds[]={"FACILITY_ID","FS_LOCN_CODE"};
			String table_name ="fm_storage_locn";

			boolean local_ejbs = false;
			if((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
				
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
					
					
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			tabdata.clear();			
			results.clear();
			
		   if ( inserted )
		   {
				error_value= "1";
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
		   }
		   else
		   {
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
		   }
		}catch ( Exception e )
		{
			e.printStackTrace();
			out.println("<h3> Exception raise by Servlet ...So Record Not Inserted </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( StLocnCode+"  "+StLocnShortDesc+"  "+StLocnLongDesc+"  "+MRLocnYN+"  "+PFileAreaYN+"  "+LocnIdentity+"  "+ReturnCriteria+"  "+NoOfDays+"  "+narrCode+"  "+StLocnEffStatus );
		}
	} // End of the insert

	private void  modifyStorageLocation(HttpServletRequest req, HttpServletResponse res, String locale)
	{
		try
		{
			String addedById			= p.getProperty( "login_user" ) ;		
			String modifiedById			= addedById ;	
			String addedFacilityId		= facilityId;
			String modifiedFacilityId	= addedFacilityId ;
			String addedAtWorkstation	=client_ip_address;
			String modifiedAtWorkstation= addedAtWorkstation ;

			Timestamp  DateTime = new Timestamp(System.currentTimeMillis() );

			HashMap tabdata=new HashMap();
			tabdata.put("LONG_DESC",StLocnLongDesc);
			tabdata.put("SHORT_DESC",StLocnShortDesc);
			tabdata.put("MR_LOCN_YN",MRLocnYN);
			tabdata.put("PERMANENT_FILE_AREA_YN",PFileAreaYN);
			tabdata.put("LOCN_IDENTITY",LocnIdentity);
			tabdata.put("RETURN_CRITERIA",ReturnCriteria);
			tabdata.put("HOLDER_NAME",p_holder_name);
			tabdata.put("HOLDER_PHONE_NO",p_holder_phone_no);
			tabdata.put("NO_OF_DAYS_TO_RETURN",NoOfDays);
			tabdata.put("NARRATION_CODE",narrCode);
			tabdata.put("EFF_STATUS",StLocnEffStatus);
			tabdata.put("MR_SECTION_CODE",p_mr_section_code);
			tabdata.put("MODIFIED_BY_ID",modifiedById);
			tabdata.put("MODIFIED_DATE",DateTime);
			tabdata.put("MODIFIED_FACILITY_ID",modifiedFacilityId);
			tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );						
			tabdata.put("duration_type",duration_type);
			tabdata.put("no_of_dh_to_return_ip",no_of_dh_to_return_ip);
			tabdata.put("no_of_dh_to_return_op",no_of_dh_to_return_op);
			tabdata.put("no_of_dh_to_return_em",no_of_dh_to_return_em);
			tabdata.put("no_of_dh_to_return_dc",no_of_dh_to_return_dc);
			//tabdata.put("locale",locale);
			
			HashMap condflds=new HashMap();
			condflds.put("FACILITY_ID",facilityId);
			condflds.put("FS_LOCN_CODE",StLocnCode);
			String table_name ="fm_storage_locn";

			boolean local_ejbs = false;
			if((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
				
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
				
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;
			tabdata.clear();
			condflds.clear();
			results.clear();
			//Added for this CRF HSA-CRF-0306.1
			String isCurrentFsLocation=req.getParameter("isCurrentFsLocation");
			boolean sitespecificbool=Boolean.parseBoolean(isCurrentFsLocation);
			
			
		  if(inserted && sitespecificbool && PFileAreaYN.equals("N")){
		        //con.commit();
			    con= ConnectionManager.getConnection(req);			   
			    cstmt = con.prepareCall("{call sm_day_return_date_proc(?,?,?,?,?,?,?,?)}");				
				cstmt.setString(1, StLocnCode);
				cstmt.setString(2, facilityId);
				cstmt.setString(3, "FS_STORAGE_LOCN");
				cstmt.setString(4, "");				  
				cstmt.setString(5, "");
                cstmt.setString(6, "");
                cstmt.setString(7, ""); 				
				cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
				cstmt.execute();					
				errmsg=cstmt.getString(8); 
				
			   	
			}			
			//End HSA-CRF-0306.1
				
		   if ( inserted )
		   {
				error_value= "1";
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
				con.commit();
		   }
		   else
		   {
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
		   }
		   if(cstmt!=null) cstmt.close(); //Added for checkstyle
		}catch ( Exception e )
		{
			e.printStackTrace();
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( StLocnCode+"  "+StLocnShortDesc+"  "+StLocnLongDesc+"  "+MRLocnYN+"  "+PFileAreaYN+"  "+LocnIdentity+"  "+ReturnCriteria+"  "+NoOfDays+"  "+narrCode+"  "+StLocnEffStatus );
		}finally{
		if(con!=null) ConnectionManager.returnConnection(con,p);
		}
	} // End of the modify
} // End of the Class
