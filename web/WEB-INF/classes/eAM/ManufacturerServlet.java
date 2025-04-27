/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;
/**
 *		FileName : ManufactureServlet.java
 *		Version	 : 3
 *		Date	 : 15-2-05	
**/

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import eCommon.XSSRequestWrapper;
import eCommon.SingleTabHandler.*;

public class ManufacturerServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	String manufacturer_id="";
	String long_name ="";
	String short_name ="";
	String eff_status="" ;
	
	String  addr_line_1 ="";
	String  addr_line_2 ="";
	String  addr_line_3="";
	String  addr_line_4 ="";
	String  postal_code ="";
	String tel_no  ="";       
	String tlx_no  ="";  
	String fax_no ="";
	String email   ="";
	String website="";
	String country_code="";

	String addtown="";
	String addarea="";
	String addregion="";

	String facilityId ="";
	String client_ip_address="" ;
	String serviceURL="";
	//String objectName="";
	//String effectiveDateFrom="" ;
	//String effectiveDateTo ="";
	
	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;
/***********************************************************************************************************/
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}
/***********************************************************************************************************/
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req= new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		res.setContentType("text/html");
		out = res.getWriter();
		session = req.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		
		facilityId = (String) session.getValue( "facility_id" ) ;
		if(facilityId==null) facilityId="";
		
		client_ip_address = p.getProperty("client_ip_address");
		if(client_ip_address ==null) client_ip_address ="";
		
		serviceURL=(String) session.getValue("serviceURL");
		if(serviceURL==null) serviceURL="";

		try
		{
			String operation = req.getParameter("operation");
			out.println("<script>alert('tsd');</script>");
			if ( operation.equals("insert"))   insertUnitOfMeasure(req, res);
			if ( operation.equals("modify"))   modifyUnitOfMeasure(req, res);
			
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
	}
/***********************************************************************************************************/
	/*public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		try
		{
			this.out = res.getWriter();
			res.setContentType("text/html");
		
		}
		catch(Exception e)	{	}
	}*/

/***********************************************************************************************************/
	private void modifyUnitOfMeasure(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			
			callGetParameter(req);
			
			String addedById = p.getProperty( "login_user" ) ;
			if(addedById==null) addedById="";
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			if(addedDate ==null) addedDate="";
			String modifiedById = addedById ;
			if(modifiedById==null) modifiedById="";
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			
			HashMap tabdata=new HashMap();
				tabdata.put("manufacturer_id", manufacturer_id);
				tabdata.put("long_name",long_name);
				tabdata.put("short_name",short_name);
				tabdata.put("eff_status",eff_status);
				
				tabdata.put("addr_line1", addr_line_1);    
				tabdata.put("addr_line2", addr_line_2);
				tabdata.put("addr_line3", addr_line_3);
				tabdata.put("addr_line4", addr_line_4);

				tabdata.put("RES_TOWN_CODE ", addtown);
				tabdata.put("RES_AREA_CODE ", addarea);
				tabdata.put("REGION_CODE ", addregion);

				tabdata.put("postal_code ", postal_code);
				tabdata.put("tel_no ", tel_no);
				tabdata.put("	tlx_no ", tlx_no);
				tabdata.put("	fax_no", fax_no);
				tabdata.put("email_id", email);
				tabdata.put("website", website);
				tabdata.put("	country_code", country_code);

				tabdata.put("MODIFIED_BY_ID",modifiedById);
				tabdata.put("MODIFIED_DATE",modifiedDate);
				tabdata.put("MODIFIED_AT_WS_NO", modifiedAtWorkstation);
				tabdata.put("MODIFIED_FACILITY_ID", modifiedFacilityId);

			HashMap condflds=new HashMap();
				condflds.put("manufacturer_id",manufacturer_id);

			/*Context context =  new InitialContext();
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			SingleTabHandlerManagerHome singleTabHandlerManagerHome=(SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject,
			SingleTabHandlerManagerHome.class);

			final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();

			final java.util.Hashtable results = singleTabHandlerManagerRemote.update(p,tabdata,condflds,"AM_MANUFACTURER");*/


			//Approach via the ServiceLocator and Reflection
			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
			/*Object argArray[] = new Object[4];
			String table_name="AM_MANUFACTURER";
			HashMap hashmap=new HashMap();
			hashmap.put("p",p);
			hashmap.put("tabdata",tabdata);
			hashmap.put("condflds",condflds);
			hashmap.put("table_name",table_name);

			argArray[0] = hashmap;
						
			Class [] paramArray = new Class[1];
			paramArray[0] = hashmap.getClass();*/


						Object argArray[] = new Object[4];
				//argArray[0] =hashmap;
					String table_name="AM_MANUFACTURER";
				argArray[0] =p;
				argArray[1] =tabdata;
				argArray[2] =condflds;
				argArray[3] =table_name;

				Class [] paramArray = new Class[4];
				//paramArray[0] =hashmap.getClass();
					paramArray[0] =p.getClass();
					paramArray[1] =tabdata.getClass();
					paramArray[2] =condflds.getClass();
					paramArray[3] =table_name.getClass();


			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
						String error_value = "0" ;
						if ( inserted )
						{
						 error_value = "1" ;
						}
						else
						{
						 error = (String) results.get("error") ;
						}

        	error = (String) results.get("error") ;
    		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  )+"&err_value="+error_value );

			tabdata.clear();
			condflds.clear();
			results.clear();
		}
		catch ( Exception e )
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( manufacturer_id + " "+long_name + " "+short_name + " "+ eff_status );
		}
	}
/***********************************************************************************************************/
private void insertUnitOfMeasure(HttpServletRequest req, HttpServletResponse res)
{
		try
		{
			
			callGetParameter(req);
			
			String addedById = p.getProperty( "login_user" ) ;
			if(addedById==null) addedById="";
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			if(addedDate ==null) addedDate="";

			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			if(modifiedById==null) modifiedById="";
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

			HashMap tabdata=new HashMap();
	
				tabdata.put("manufacturer_id", manufacturer_id);
				tabdata.put("long_name",long_name);
				tabdata.put("short_name",short_name);
				tabdata.put("eff_status",eff_status);
				
				tabdata.put(" addr_line1", addr_line_1);    
				tabdata.put(" addr_line2", addr_line_2);
				tabdata.put(" addr_line3", addr_line_3);
				tabdata.put(" addr_line4", addr_line_4);
				
				tabdata.put("RES_TOWN_CODE ", addtown);
				tabdata.put("RES_AREA_CODE ", addarea);
				tabdata.put("REGION_CODE ", addregion);

				tabdata.put("postal_code ", postal_code);
				tabdata.put("tel_no ", tel_no);
				tabdata.put("	tlx_no ", tlx_no);
				tabdata.put("	fax_no", fax_no);
				tabdata.put("email_id  ", email);
				tabdata.put("website", website);
				tabdata.put("	country_code", country_code);

				tabdata.put("ADDED_BY_ID",addedById);
				tabdata.put("ADDED_DATE",addedDate);
				tabdata.put("ADDED_AT_WS_NO",addedAtWorkstation);
				tabdata.put("ADDED_FACILITY_ID",addedFacilityId);
				tabdata.put("MODIFIED_BY_ID",modifiedById);
				tabdata.put("MODIFIED_DATE",modifiedDate);
				tabdata.put("MODIFIED_AT_WS_NO", modifiedAtWorkstation);
				tabdata.put("MODIFIED_FACILITY_ID", modifiedFacilityId);

			String dupflds[]={"manufacturer_id"};

			/*Context context =  new InitialContext(  ) ;
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			SingleTabHandlerManagerHome singleTabHandlerManagerHome=(SingleTabHandlerManagerHome)PortableRemoteObject.narrow(homeObject,  SingleTabHandlerManagerHome.class);
			final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();

			final java.util.Hashtable results = singleTabHandlerManagerRemote.insert(p,tabdata,dupflds,"AM_MANUFACTURER");*/

			//Approach via the ServiceLocator and Reflection
			boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
			/*Object argArray[] = new Object[4];
			String table_name="AM_MANUFACTURER";
			HashMap hashmap=new HashMap();
			hashmap.put("p",p);
			hashmap.put("tabdata",tabdata);
			hashmap.put("dupflds",dupflds);
			hashmap.put("table_name",table_name);

			argArray[0] = hashmap;
						
			Class [] paramArray = new Class[1];
			paramArray[0] = hashmap.getClass();*/


				Object argArray[] = new Object[4];
				//argArray[0] =hashmap;
				String table_name="AM_MANUFACTURER";
				argArray[0] =p;
				argArray[1] =tabdata;
				argArray[2] =dupflds;
				argArray[3] =table_name;

				Class [] paramArray = new Class[4];
				//paramArray[0] =hashmap.getClass();
					paramArray[0] =p.getClass();
					paramArray[1] =tabdata.getClass();
					paramArray[2] =dupflds.getClass();
					paramArray[3] =table_name.getClass();


			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

						String error = (String) results.get("error") ;
									String error_value = "0" ;
									if ( inserted )
									{
									 error_value = "1" ;
									}
									else
									{
									 error = (String) results.get("error") ;
									}

			        	error = (String) results.get("error") ;
			    		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  )+"&err_value="+error_value );

						tabdata.clear();
			            results.clear();
					}
					catch ( Exception e )
					{
						out.println("<h3> Exception raise by Servlet ...So Record Not Inserted </h3> Foll: Error Received : "+e.toString());
						out.println( "Values sent are : <br>" ) ;
						out.println( manufacturer_id+ " "+long_name + " "+short_name +" "+ eff_status );
		}
	}

/**********************************************************************************************/
private void callGetParameter(HttpServletRequest req)
		{
			
			
			manufacturer_id = req.getParameter("manufacturer_id");
			if(manufacturer_id==null) manufacturer_id="";
			
			long_name = req.getParameter("long_name");
			if(long_name==null) long_name="";
			
			short_name = req.getParameter("short_name");
			if(short_name==null) short_name="";
			
			eff_status = req.getParameter("eff_status");
			if ( eff_status == null )	eff_status="D";
			
			addr_line_1 = req.getParameter("add_ln1");
			if(addr_line_1 ==null) addr_line_1="";
			
			addr_line_2 = req.getParameter("add_ln2");
			if(addr_line_2 ==null) addr_line_2="";
			
			addr_line_3 = req.getParameter("add_ln3");
			if(addr_line_3 ==null) addr_line_3="";
			
			addr_line_4 = req.getParameter("add_ln4");
			if(addr_line_4 ==null) addr_line_4="";
			

			addtown=req.getParameter("m_town");
			if(addtown ==null) addtown="";

			addarea=req.getParameter("m_area");
			if(addarea ==null) addarea="";

			addregion=req.getParameter("m_region");
			if(addregion ==null) addregion="";

			postal_code=req.getParameter("m_postal_code");
			if ( postal_code == null )	postal_code="";

						
			//postal_code = req.getParameter("postal_code");
			//if(postal_code ==null) postal_code="";

			tel_no = req.getParameter("tel_no");
			if(tel_no ==null) tel_no="";

			tlx_no = req.getParameter("tlx_no");
			if(tlx_no ==null) tlx_no="";
			
			fax_no = req.getParameter("fax_no");
			if(fax_no ==null) fax_no="";
			
			email = req.getParameter("email");
			if(email ==null) email="";
	
			website = req.getParameter("website");
			if(website ==null) website="";

			 country_code = req.getParameter("country_code");
			if(country_code ==null) country_code="";
		
	}
}
