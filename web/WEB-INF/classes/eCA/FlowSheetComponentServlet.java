/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.util.Date.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;

import eCommon.SingleTabHandler.*;
public class FlowSheetComponentServlet extends javax.servlet.http.HttpServlet
{
	
	
	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		String mode	= "";
		try
		{
			out = res.getWriter();
			mode =(req.getParameter("mode")==null)?"":req.getParameter("mode");
			if (mode.trim().equalsIgnoreCase("insert"))   insert(req, res, out);
			if (mode.trim().equalsIgnoreCase("modify"))   modify(req, res, out);
			
		}
		catch(Exception e)
		{
	
			out.println("Exception="+e.toString());
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
		{
		PrintWriter out = null;
		try
		{
			out = res.getWriter();
			doPost(req,res);		
		}
		catch(Exception e)	
		{	
			out.println("Exception in invoking doPost Method");
			e.printStackTrace();
		}
	}


private void fromChart(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
{
	boolean bUpdStatus = true;
	
	Connection con = null ;
	PreparedStatement pstmt = null ;
	PreparedStatement pstmt1 = null ;
	PreparedStatement stmt=null;
	ResultSet rset=null;
	ResultSet rs = null;
	String sql ="";
	String strSqlCheck ="";
	String strFlowSheetId = "";
	java.util.Properties p;
    String menu_id				= "";
	String facilityId		="";
	String client_ip_address	= "";
	String addedById			= "";
	String addedDate			= "";
	String addedAtWorkstation	= "";
	String addedFacilityId		= "";
	String modifiedById			= "";
	
	String modifiedAtWorkstation= "";
	String hist_rec_type="";
	String discr_msr_id="";
	String insert_chart= "";
	String mode	= "";
	int insert_result=0;


	HttpSession session;
	session = req.getSession(false);
	p = (Properties)session.getValue("jdbc") ;
	facilityId = (String)session.getValue( "facility_id" ) ;
	client_ip_address = p.getProperty("client_ip_address");
	mode =(req.getParameter("mode")==null)?"":req.getParameter("mode");
	modifiedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;           
	modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;    
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	try
	{
		
		if (mode.trim().equalsIgnoreCase("insert")){
			menu_id=req.getParameter("id");			
		}
		else
		{
			menu_id=req.getParameter("menu_id1");
			strFlowSheetId = menu_id.substring(1);
		}
			
		if(menu_id == null)
			menu_id="";

		menu_id = menu_id.toUpperCase();
		
		addedById			= (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
		addedDate			= dateFormat.format( new java.util.Date() ) ;
		addedFacilityId		= (facilityId == null)?"":facilityId;  
		addedAtWorkstation	= (client_ip_address == null)?"":client_ip_address; 
			
		sql="select a.hist_rec_type, b.DISCR_MSR_ID  FROM AM_DISCR_MSR A, CA_CHART_SECTION_COMP B WHERE  B.CHART_ID=? AND A.DISCR_MSR_ID=B.DISCR_MSR_ID order by PANEL_DISP_ORDER_SEQ, DISCR_DISP_ORDER_SEQ ";

		con=ConnectionManager.getConnection(req);

		pstmt = con.prepareStatement(sql);
	
		if (mode.trim().equalsIgnoreCase("insert"))
			pstmt.setString(1,menu_id);
		else
			pstmt.setString(1,strFlowSheetId);

		if (mode.trim().equalsIgnoreCase("insert"))
		{
			if (menu_id != "")
				menu_id="$"+menu_id;
		}

		menu_id = menu_id.toUpperCase();
		
		strSqlCheck = "SELECT COUNT(*)  as total  FROM  ca_flow_sheet_item WHERE FLOW_SHEET_ID = ? AND HIST_REC_TYPE = ? AND EVENT_CODE = ? ";

		insert_chart = "Insert into ca_flow_sheet_item(FLOW_SHEET_ID,HIST_REC_TYPE,EVENT_CODE,EVENT_CODE_TYPE,ORDER_SEQ_NO ,ADDED_BY_ID ,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE ,MODIFIED_FACILITY_ID   ,MODIFIED_AT_WS_NO ) values( ?, ?, ?, ?, ?, ?,sysdate, ?, ?, ?, sysdate, ?, ?)";

		pstmt1=	con.prepareStatement(insert_chart);
		
		int orderSeq=1;

		int maxrecord=0;

		rs=pstmt.executeQuery();
		stmt = con.prepareStatement(strSqlCheck);
		
		while(rs.next())
		{
			hist_rec_type = rs.getString(1);
			discr_msr_id = rs.getString(2);
			
			if(hist_rec_type == null)
				hist_rec_type="PTCR";

			if(discr_msr_id == null)
				discr_msr_id="";

			stmt.setString	(1,	menu_id);	
			stmt.setString	(2,	hist_rec_type);
			stmt.setString	(3,	discr_msr_id);
			rset = stmt.executeQuery();
		
			if (rset.next())
				maxrecord = rset.getInt("total");
			
			if(rset != null ) rset.close();
			stmt.clearParameters();

			if(maxrecord <= 0)
			{
				pstmt1.setString	(1,	menu_id);	
				pstmt1.setString	(2,	hist_rec_type);
				pstmt1.setString	(3,	discr_msr_id);
				pstmt1.setString	(4,	"OR"	);
				pstmt1.setInt	    (5,	orderSeq);
				pstmt1.setString	(6,	addedById);
				pstmt1.setString	(7,	addedFacilityId);
				pstmt1.setString	(8,	addedAtWorkstation);
				pstmt1.setString	(9,	addedById);
				pstmt1.setString	(10,addedFacilityId);
				pstmt1.setString	(11,addedAtWorkstation);
				orderSeq++;
						
				insert_result = pstmt1.executeUpdate();

				if(insert_result>0)	
					bUpdStatus = true;
				else
				{
				   bUpdStatus = false;
				   break;
				}
			}
		}

		if(bUpdStatus)
			con.commit();
		else
			con.rollback();
	}
	catch ( Exception e )
	{
		try
		{
			con.rollback();
			//out.println("<h3> Exception raise by Servlet ...Record Not inserted </h3> Foll: Error Received : "+e.toString());//common-icn-0181
			e.printStackTrace();
		}
		catch (Exception eee)
		{
		}
	}
	finally
	{
		try
		{
			if(rs != null) rs.close();
			if(stmt!=null) stmt.close();
			if(pstmt!=null) pstmt.close();
			if(pstmt1!=null) pstmt1.close();
		}
		catch(Exception e)
		{	}
		
		if(con!=null) ConnectionManager.returnConnection(con,req);
	}
} 

private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
{
	java.util.Properties p;
    String menu_id				= "";
	String short_desc			= "";
	String long_desc            ="";
	String eff_status			= "";
	String facilityId		="";
	String client_ip_address	= "";
	String addedById			= "";
	String addedDate			= "";
	String addedAtWorkstation	= "";
	String addedFacilityId		= "";
	String modifiedById			= "";
	
	String modifiedAtWorkstation= "";
	String type="";
	
	HttpSession session;
	session = req.getSession(false);
	p = (Properties)session.getValue("jdbc") ;
	facilityId = (String)session.getValue( "facility_id" ) ;
	client_ip_address = p.getProperty("client_ip_address");
	modifiedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;           
	modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;    
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
	try
	{
		addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
		addedDate = dateFormat.format( new java.util.Date() ) ;
		
		addedFacilityId		= (facilityId == null)?"":facilityId;  
		addedAtWorkstation	= (client_ip_address == null)?"":client_ip_address; 

		menu_id=req.getParameter("id");
		type =(req.getParameter("flow_type")==null)?"":req.getParameter("flow_type");
		
		if(menu_id == null)	menu_id="";

		if (type.equalsIgnoreCase("C") && menu_id != "")
			menu_id="$"+menu_id;

		menu_id = menu_id.toUpperCase();
		
		short_desc=req.getParameter("short_desc");

		if(short_desc == null)	
			short_desc="";
		
		long_desc=req.getParameter("long_desc");
		
		if(long_desc == null)	
			long_desc="";
		
		eff_status=req.getParameter("eff_status");

		if(eff_status == null)
			eff_status="";

		eff_status 	= (eff_status.equals(""))?"D":eff_status ;
		
        HashMap tabdata = new HashMap(); 	

		tabdata.put("FLOW_SHEET_ID",menu_id);
		tabdata.put("SHORT_DESC",short_desc);
		tabdata.put("LONG_DESC",long_desc);
		tabdata.put("EFF_STATUS",eff_status);
		
		if(addedById == null)
			addedById="";
				
		if(addedDate == null)
			addedDate="";
		
		if(facilityId == null )
			facilityId="";
		
		if(addedFacilityId == null )
			addedFacilityId="";
		
		if(addedAtWorkstation == null)
			addedAtWorkstation="";
		
		if(modifiedById == null)
			modifiedById="";
		
		if(modifiedAtWorkstation == null || modifiedAtWorkstation.equals("null") )
			modifiedAtWorkstation="";
		
		tabdata.put("ADDED_BY_ID",addedById);
		tabdata.put("ADDED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
		tabdata.put("ADDED_FACILITY_ID", addedFacilityId);
		tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
						
		tabdata.put("MODIFIED_BY_ID",modifiedById);
		tabdata.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
		tabdata.put("MODIFIED_FACILITY_ID",addedFacilityId);
		tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
		
		String dupflds[]={"FLOW_SHEET_ID"};
				
			
		boolean local_ejbs = false;
		String tabname="ca_flow_sheet";
		
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		Object argArray[] = new Object[4];
		argArray[0] = p;
		argArray[1] = tabdata;
		argArray[2] = dupflds;
		argArray[3] = tabname;

		Class [] paramArray = new Class[4];
		paramArray[0] = p.getClass();
		paramArray[1] = tabdata.getClass();
		paramArray[2] = dupflds.getClass();
		paramArray[3] = tabname.getClass();

		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		tabdata.clear();

		boolean inserted = ( ((Boolean) results.get("status")).booleanValue() ) ;
		String error = (String) results.get("error") ;
		String error_value = "0" ;
		
		
		if ( inserted )
		{
			error_value = "1" ;
			
			if (type.equalsIgnoreCase("C"))
					fromChart(req,res, out);
		}
		results.clear();
		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
	}
	catch ( Exception e )
	{
			//out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());//common-icn-0181
			e.printStackTrace();
	}

} //insert

private void modify(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
 {
	java.util.Properties p;
    String menu_id				= "";
	String short_desc			= "";
	String long_desc            ="";
	String eff_status			= "";
	String facilityId		="";
	String client_ip_address	= "";
	String addedById			= "";
	String addedDate			= "";
	String addedAtWorkstation	= "";
	String addedFacilityId		= "";
	String modifiedById			= "";
	
	String modifiedAtWorkstation= "";
	
	HttpSession session;
	session = req.getSession(false);
	p = (Properties)session.getValue("jdbc") ;
	facilityId = (String)session.getValue( "facility_id" ) ;
	client_ip_address = p.getProperty("client_ip_address");
	modifiedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;           
	modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;    
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

     try
		{
			addedById = (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
			addedDate = dateFormat.format( new java.util.Date() ) ;
			
			addedFacilityId		= (facilityId == null)?"":facilityId;  
			addedAtWorkstation	= (client_ip_address == null)?"":client_ip_address; 
								                                              
			menu_id=req.getParameter("menu_id1");
			if(menu_id == null)
				menu_id="";

			short_desc=req.getParameter("short_desc1");
			if(short_desc == null)
			short_desc="";
           	long_desc=req.getParameter("long_desc1");
			if(long_desc == null)
			long_desc="";
             eff_status=req.getParameter("eff_status");
			if(eff_status == null)
				eff_status="";
			eff_status 	= (eff_status.equals(""))?"D":eff_status ;
         
		 HashMap tabdata = new HashMap(); 	
        tabdata.put("FLOW_SHEET_ID",menu_id);
		tabdata.put("SHORT_DESC",short_desc);
		tabdata.put("LONG_DESC",long_desc);
		tabdata.put("EFF_STATUS",eff_status); 
		 if(addedDate == null)
					addedDate="";
				
				if(facilityId == null)
					facilityId="";
				
				if(addedFacilityId == null)
					addedFacilityId="";
				
				if(addedAtWorkstation == null)
					addedAtWorkstation="";
				
				if(modifiedById == null  )
					modifiedById="";
				
				if(modifiedAtWorkstation == null)
					modifiedAtWorkstation="";
				
								
				tabdata.put("ADDED_BY_ID",addedById);
				tabdata.put("ADDED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
				tabdata.put("ADDED_FACILITY_ID", addedFacilityId);
				tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
								
				tabdata.put("MODIFIED_BY_ID",modifiedById);
				tabdata.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
				tabdata.put("MODIFIED_FACILITY_ID",addedFacilityId);
				tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );
				
				HashMap condflds=new HashMap();
                condflds.put("FLOW_SHEET_ID",menu_id); 
			
			
			boolean local_ejbs = false;
			String tabname="ca_flow_sheet";
		
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		Object argArray[] = new Object[4];
		argArray[0] = p;
		argArray[1] = tabdata;
		argArray[2] = condflds;
		argArray[3] = tabname;

		Class [] paramArray = new Class[4];
		paramArray[0] = p.getClass();
		paramArray[1] = tabdata.getClass();
		paramArray[2] = condflds.getClass();
		paramArray[3] = tabname.getClass();


		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		tabdata.clear();
		condflds.clear();
			
			
			boolean modified = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			results.clear();
						String error_value = "0" ;
						String menu_chk ="";
						
						if ( modified )
						{
							 error_value = "1" ;
							 menu_chk=menu_id.substring(0,1);
							 if(menu_chk.equalsIgnoreCase("$"))
		    				fromChart(req,res, out);
						}
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);


		}catch ( Exception e )
			{
						//out.println("<h3> Exception raised by Servlet ...So Record Not modified </h3> Foll: Error Received : "+e.toString());//common-icn-0181
						e.printStackTrace();
			}

  } //modify
}
