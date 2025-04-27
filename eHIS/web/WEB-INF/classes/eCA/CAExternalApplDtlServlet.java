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
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;

import eCommon.SingleTabHandler.*;

public class CAExternalApplDtlServlet extends javax.servlet.http.HttpServlet
{

	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");	
		PrintWriter out = null;
		
		try
		{
			out = res.getWriter();
			String mode =(req.getParameter("mode")==null)?"":req.getParameter("mode");
			
			if (mode.trim().equalsIgnoreCase("insert") || mode.equals(""))
				insert(req, res, out);

			if (mode.trim().equalsIgnoreCase("modify"))
				modify(req, res, out);
		}
		catch(Exception e){
			out.println(e.toString());
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
	catch(Exception ei)
	{	
			//out.println(ei.toString());//common-icn-0181
			ei.printStackTrace();
	}
}

private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
{
	java.util.Properties p;
	Hashtable hashError = new Hashtable();
	HttpSession session;

	String ext_image_appl_id = "";
	String order_category = "";
	String order_type_code = "";
	String order_catalog_code = "";
	String eff_status = "";
	String ext_facility_id	="";
	String addedById				= "";
	String addedDate				= "";
	String addedAtWorkstation	 	= "";
	String addedFacilityId			= "";
	String modifiedById				= "";
	String modifiedDate				= "";
	String modifiedAtWorkstation	= "";
	String facilityId				= "";
	String client_ip_address		= "";
	String locale					= "";
	String validate_sql				= "";
	String error					= "";
	String error_value				= "";
	String ext_image_appl_name_count = "";

	
	Connection          con = null;
	PreparedStatement pstmt = null;
	
	ResultSet rs			= null;

	int count = 0;
	
	java.sql.Date added_date1   = null;	
	java.sql.Date modified_date1= null;
	
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	session			= req.getSession(false);
	
	p					= (Properties)session.getValue("jdbc") ;
	locale				= (String) p.getProperty("LOCALE");
	facilityId			= (String)session.getValue( "facility_id" ) ;
	client_ip_address	= (String) p.getProperty("client_ip_address");
	modifiedById		= (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ; 
	modifiedDate		= dateFormat.format( new java.util.Date());  

	modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;
	
	try
	{
		addedById			= (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
		addedDate			= dateFormat.format( new java.util.Date() ) ;
		addedFacilityId		= (facilityId == null)?"":facilityId;  
		addedAtWorkstation	= (client_ip_address == null)?"":client_ip_address; 

		added_date1			= java.sql.Date.valueOf( addedDate ) ;
		modified_date1		= java.sql.Date.valueOf(modifiedDate ) ;

		ext_image_appl_id	= req.getParameter("application")==null?"":req.getParameter("application");
		order_category		= req.getParameter("order_category")==null?"":req.getParameter("order_category");
		order_type_code		= req.getParameter("order_type")==null?"":req.getParameter("order_type");
		order_catalog_code	= req.getParameter("order_catalog")==null?"":req.getParameter("order_catalog");
		eff_status			= req.getParameter("eff_status")==null?"N":req.getParameter("eff_status");
		ext_facility_id		= req.getParameter("facility_id")==null?"N":req.getParameter("facility_id");

		con = ConnectionManager.getConnection(req);

		validate_sql = "select ( SELECT EXT_IMAGE_APPL_NAME from CA_EXT_IMAGE_APPL WHERE EXT_IMAGE_APPL_ID=a.EXT_IMAGE_APPL_ID and rownum=1) EXT_IMAGE_APPL_NAME from CA_EXT_APPL_DETAIL a where a.ORDER_CATEGORY=? AND (a.ORDER_TYPE_CODE,a.ORDER_CATALOG_CODE,a.FACILITY_ID) in ( (?,?,?),(?,?,'*A'),(?,'*ALL',?) ,(?,'*ALL','*A'),('*ALL','*ALL',?) ,('*ALL','*ALL','*A'))";

		 pstmt = con.prepareStatement(validate_sql);
		 pstmt.setString(1,order_category);
		 pstmt.setString(2,order_type_code);
		 pstmt.setString(3,order_catalog_code);
		 pstmt.setString(4,ext_facility_id);
		 pstmt.setString(5,order_type_code);
		 pstmt.setString(6,order_catalog_code);
		 pstmt.setString(7,order_type_code);
		 pstmt.setString(8,ext_facility_id);
		 pstmt.setString(9,order_type_code);
		 pstmt.setString(10,ext_facility_id);
		 
		

		 rs = pstmt.executeQuery();	

		 while(rs.next())
		 {
			 ext_image_appl_name_count = rs.getString(1)==null?"":rs.getString(1);
			 count ++;
		 }
		 
		 if(rs != null) rs.close();
		 if(pstmt != null) pstmt.close();
			
		 if(count == 0)
				ext_image_appl_name_count = "";
		 else
			count = 0;
		
		if(ext_image_appl_name_count.equals(""))
		{
			HashMap tabdata = new HashMap(); 		

			tabdata.put("ext_image_appl_id", ext_image_appl_id );
			tabdata.put("order_category", order_category );
			tabdata.put("order_type_code", order_type_code );
			tabdata.put("order_catalog_code", order_catalog_code );
			tabdata.put("eff_status", eff_status );
			tabdata.put("facility_id", ext_facility_id );
		
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
			if(modifiedAtWorkstation == null )
				modifiedAtWorkstation = "";

			tabdata.put("ADDED_BY_ID",addedById);
			tabdata.put("ADDED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
			tabdata.put("MODIFIED_BY_ID",modifiedById);
			tabdata.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );

			String dupflds[] = {"ext_image_appl_id","order_category","order_type_code","order_catalog_code","facility_id"};

			String table_name = "ca_ext_appl_detail";
		
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

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			tabdata.clear();

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			error			 = (String) results.get("error") ;

			error_value = "0" ;
	
			if ( inserted )
				error_value = "1" ;

			results.clear();
		}
		else
		{
			error_value	= "0" ;
			hashError = MessageManager.getMessage(locale, "SEL_COMB_APPL_EXISTS","CA");
			error = (String) hashError.get("message");
		}
	  
		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value="+error_value);

	}
	catch ( Exception e )
	{
		//out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());//common-icn-0181
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) { ConnectionManager.returnConnection(con,req); }
	}
}


private void modify(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
{
	java.util.Properties p;
	HttpSession session;

	String ext_image_appl_id = "";
	String order_category = "";
	String order_type_code = "";
	String order_catalog_code = "";
	String eff_status = "";
	String ext_facility_id	="";

	String addedById				= "";
	String addedDate				= "";
	String addedAtWorkstation	 	= "";
	String addedFacilityId			= "";
	String modifiedById				= "";
	String modifiedDate				= "";
	String modifiedAtWorkstation	= "";
	String facilityId				= "";
	String client_ip_address		= "";
	String error					= "";
	String error_value				= "";


	java.sql.Date added_date1   = null;	
	java.sql.Date modified_date1= null;
	
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	session				= req.getSession(false);
	p					= (Properties)session.getValue("jdbc") ;
	facilityId			= (String)session.getValue( "facility_id" ) ;
	client_ip_address	= (String) p.getProperty("client_ip_address");
	modifiedById		= (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ; 
	modifiedDate		= dateFormat.format( new java.util.Date());  

	modifiedAtWorkstation   = (client_ip_address==null)?"":client_ip_address;
	
	try
	{
		addedById			= (p.getProperty("login_user")==null)?"":p.getProperty("login_user")  ;
		addedDate			= dateFormat.format( new java.util.Date() ) ;
		addedFacilityId		= (facilityId == null)?"":facilityId;  
		addedAtWorkstation	= (client_ip_address == null)?"":client_ip_address; 

		added_date1			= java.sql.Date.valueOf( addedDate ) ;
		modified_date1		= java.sql.Date.valueOf(modifiedDate ) ;

		ext_image_appl_id	= req.getParameter("ext_image_appl_id")==null?"":req.getParameter("ext_image_appl_id");
		order_category		= req.getParameter("order_category_code")==null?"":req.getParameter("order_category_code");
		order_type_code		= req.getParameter("order_type_code")==null?"":req.getParameter("order_type_code");
		order_catalog_code	= req.getParameter("order_catalog")==null?"":req.getParameter("order_catalog");
		eff_status			= req.getParameter("eff_status")==null?"N":req.getParameter("eff_status");
		ext_facility_id		= req.getParameter("facility_id")==null?"":req.getParameter("facility_id");
	
		HashMap tabdata = new HashMap();
		
		tabdata.put("EFF_STATUS",eff_status.trim());
		
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
		if(modifiedAtWorkstation == null )
			modifiedAtWorkstation = "";

		tabdata.put("ADDED_BY_ID",addedById);
		tabdata.put("ADDED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
		tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
		tabdata.put("MODIFIED_BY_ID",modifiedById);
		tabdata.put("MODIFIED_DATE",new  java.sql.Timestamp(System.currentTimeMillis()));
		tabdata.put("MODIFIED_AT_WS_NO",modifiedAtWorkstation );

		HashMap condflds=new HashMap();
		condflds.put("ext_image_appl_id",ext_image_appl_id.trim());
		condflds.put("order_category",order_category.trim());
		condflds.put("order_type_code",order_type_code.trim());
		condflds.put("order_catalog_code",order_catalog_code.trim());
			
		String table_name = "ca_ext_appl_detail";

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

		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		tabdata.clear();
		condflds.clear();

		boolean modified = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		error = (String) results.get("error") ;
		results.clear();
		error_value = "0" ;

		if ( modified )
			 error_value = "1" ;
		
		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
	}
	catch ( Exception e )
	{
		//out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());//common-icn-0181
		e.printStackTrace();
	}
}
}


