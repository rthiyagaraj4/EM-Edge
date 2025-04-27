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
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.SingleTabHandler.*;

import eCommon.XSSRequestWrapper;

public class RequestorServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	Properties p=null;
	String requestorcode="";
	String longdesc="";
	String shortdesc="";
	String indicators="";
	String addrline1="";
	String addrline2="";
	String addrline3="";
	String addrline4="";
	String towncode="";
	String areacode="";
	String regioncode="";
	String postalcode="";
	String countrycode="";
	String contactno="";
	String othercontactno="";
	String emailid="";
	String effstatus="";
	String client_ip_address="";
    String facilityId="";
	HttpSession session;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);
		this.p = (Properties) session.getValue("jdbc") ;
		this.facilityId = (String) session.getValue("facility_id") ;
		client_ip_address = p.getProperty("client_ip_address");

		try
		{			
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			//V220404
			req= new XSSRequestWrapper(req);
			res.addHeader("X-XSS-Protection", "1; mode=block");
			res.addHeader("X-Content-Type-Options", "nosniff");
		//V220404
			this.out = res.getWriter();
			String operation = req.getParameter("function_name");
			if (operation.equals("insert"))	insertrequestor(req, res);
			if (operation.equals("modify"))	modifyrequestor(req, res);
		}
		catch(Exception e)
		{
			//out.println(e.toString());
			
			e.printStackTrace();
		}
	}
	private void insertrequestor(HttpServletRequest req,HttpServletResponse res)
	{
		try
		{
			requestorcode=req.getParameter("requestor_code");
			longdesc=req.getParameter("long_desc");
			shortdesc=req.getParameter("short_desc");
			indicators=req.getParameter("requestor_type");
			addrline1=checkForNull(req.getParameter("r_addr_line1"));
			addrline2=checkForNull(req.getParameter("r_addr_line2"));
			addrline3=checkForNull(req.getParameter("r_addr_line3"));
			addrline4=checkForNull(req.getParameter("r_addr_line4"));
			towncode=checkForNull(req.getParameter("r_town"));
			areacode=checkForNull(req.getParameter("r_area"));
			regioncode=checkForNull(req.getParameter("r_region"));
			postalcode=checkForNull(req.getParameter("r_postal_code"));
			countrycode=checkForNull(req.getParameter("req_country_code"));
			contactno=checkForNull(req.getParameter("requestor_contactno"));
			othercontactno=checkForNull(req.getParameter("requestor_othercontactno"));
			emailid=checkForNull(req.getParameter("requestor_emailid"));
			
			effstatus=req.getParameter("requestor_status");
			if(effstatus==null)
			{
				effstatus="D";
			}

			String addedById = p.getProperty("login_user");
			String modifiedById = addedById;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation;
			Timestamp added_date = new Timestamp(System.currentTimeMillis());
			Timestamp modified_date = new Timestamp(System.currentTimeMillis());

			HashMap tabdata=new HashMap();
			tabdata.put("facility_id",facilityId);
			tabdata.put("requestor_code",requestorcode);
			tabdata.put("long_desc",longdesc);
			tabdata.put("short_desc",shortdesc);
			tabdata.put("INDICATOR",indicators);
			tabdata.put("ADDR_LINE1",addrline1);
			tabdata.put("ADDR_LINE2",addrline2);
			tabdata.put("ADDR_LINE3",addrline3);
			tabdata.put("ADDR_LINE4",addrline4);

			tabdata.put("town_code",towncode);
			tabdata.put("area_code",areacode);
			tabdata.put("region_code",regioncode);
			tabdata.put("postal_code",postalcode);
			tabdata.put("country_code",countrycode);
	
			tabdata.put("CONTACT1_NO",contactno);
			tabdata.put("CONTACT2_NO",othercontactno);
			tabdata.put("email_id",emailid);
			tabdata.put("eff_status",effstatus);
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",added_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			String dupflds[]={"requestor_code","facility_id"};


			String tableName = "MR_REQUESTOR";
			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = tableName;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = tableName.getClass();

			HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted	= ( ((Boolean) results.get( "status" )).booleanValue() ) ;			
		
			String error = (String) results.get("error") ;
			String error_value = "0" ;

			if(inserted)
			{
				error_value = "1" ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value);
			}
			else
		    {
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value );
		    }
			if ( tabdata != null) tabdata.clear();
			if ( results != null) results.clear();
		}catch ( Exception e )
		{
			/* out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( requestorcode+" "+shortdesc + " "+ effstatus ); */
			
			e.printStackTrace();
		}
	}
	
	
	private void modifyrequestor(HttpServletRequest req, HttpServletResponse res)
	{
		Connection con = null;
		try
		{
			con = ConnectionManager.getConnection(req);
			requestorcode=req.getParameter("requestor_code");
			longdesc=req.getParameter("long_desc");
			shortdesc=req.getParameter("short_desc");
			indicators=req.getParameter("requestor_type");
			addrline1=checkForNull(req.getParameter("r_addr_line1"));
			addrline2=checkForNull(req.getParameter("r_addr_line2"));
			addrline3=checkForNull(req.getParameter("r_addr_line3"));
			addrline4=checkForNull(req.getParameter("r_addr_line4"));
			towncode=checkForNull(req.getParameter("r_town"));
			areacode=checkForNull(req.getParameter("r_area"));
			regioncode=checkForNull(req.getParameter("r_region"));
			postalcode=checkForNull(req.getParameter("r_postal_code"));
			countrycode=checkForNull(req.getParameter("req_country_code"));
			contactno=checkForNull(req.getParameter("requestor_contactno"));
			othercontactno=checkForNull(req.getParameter("requestor_othercontactno"));
			emailid=checkForNull(req.getParameter("requestor_emailid"));
			effstatus=req.getParameter("requestor_status");
			if(effstatus==null)
			{
				effstatus="D";
			}

			String addedById = p.getProperty("login_user");
			String modifiedById = addedById;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation;
			Timestamp added_date = new Timestamp(System.currentTimeMillis());
			Timestamp modified_date = new Timestamp(System.currentTimeMillis());
			HashMap tabdata=new HashMap();
			tabdata.put("long_desc",longdesc);
			tabdata.put("short_desc",shortdesc);
			tabdata.put("INDICATOR",indicators);
			tabdata.put("ADDR_LINE1",addrline1);
			tabdata.put("ADDR_LINE2",addrline2);
			tabdata.put("ADDR_LINE3",addrline3);
			tabdata.put("ADDR_LINE4",addrline4);
			tabdata.put("town_code",towncode);
			tabdata.put("area_code",areacode);  
			tabdata.put("region_code",regioncode);
			tabdata.put("postal_code",postalcode);
			tabdata.put("country_code",countrycode);
			tabdata.put("CONTACT1_NO",contactno);
			tabdata.put("CONTACT2_NO",othercontactno);
			tabdata.put("email_id",emailid);
			tabdata.put("eff_status",effstatus);
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",added_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );



			HashMap condflds=new HashMap();
			condflds.put("requestor_code",requestorcode);
			condflds.put("facility_id",facilityId);

			String tableName = "MR_REQUESTOR";
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

			HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = ( ((Boolean) results.get("status")).booleanValue() );
			String error = (String) results.get("error");
			String error_value = "0" ;
			if(inserted)
			{
				error_value = "1" ;
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8" ) + "&err_value=" + error_value);
			}
			if ( tabdata != null) tabdata.clear();
			if ( results != null) results.clear();
			if ( condflds != null) condflds.clear();
		}
		catch ( Exception e )
		{
			/* out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ; */
			e.printStackTrace();
		}
		finally
		{	
			if(con != null )
				ConnectionManager.returnConnection(con,req);
		}
	}

	public static String checkForNull(String inputString)
	{
		return((inputString==null)? "": inputString);
	}
}
