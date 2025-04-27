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
import webbeans.eCommon.*;
import webbeans.eCommon.MessageManager;
import eCommon.XSSRequestWrapper;
import eCommon.SingleTabHandler.*;

public class ImageForSectionServlet extends javax.servlet.http.HttpServlet
{
	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}


	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
req= new XSSRequestWrapper(req); //MOHE-SCF-0153
res.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
res.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		PrintWriter out = null;

		try
		{
			
			out = res.getWriter();
			String operation = (req.getParameter("mode")).trim();

			if ( operation.equals("insert") )   insert(req, res, out);
			if ( operation.equals("modify"))    modify(req, res, out);
			if ( operation.equals("delete"))    delete(req, res, out);

		}
		catch(Exception e)
		{
			out.println("From the Servlet" + e.toString());
			e.printStackTrace();
		}
	}

public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;
		try
		{
			out = res.getWriter();
			doPost(req, res);		
		}
		catch(Exception e)	
		{	
			out.println("Exception in invoking doPost Method");
			e.printStackTrace();
		}
	}

	private void modify(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		java.util.Properties p;
		String image_ref = req.getParameter("image_ref_desc1")==null?"":req.getParameter("image_ref_desc1");
		String sec_hdg_code =req.getParameter("sec_hdg_code1")==null?"":req.getParameter("sec_hdg_code1");

		String default_yn =req.getParameter("default_yn") == null ? "N" : req.getParameter("default_yn");
		String facilityId ;
		String client_ip_address ;
		HttpSession session;
		session = req.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = req.getRemoteAddr() ;
		client_ip_address = p.getProperty("client_ip_address");
		try
		{
			//image_ref = //req.getParameter("image_ref_desc1")==null?"":req.getParameter("image_ref_desc1");
			//sec_hdg_code =req.getParameter("sec_hdg_code1")==null?"":req.getParameter("sec_hdg_code1");

			//default_yn =req.getParameter("default_yn") == null ? "N" : req.getParameter("default_yn");
			//if(default_yn == null)
				//default_yn =req.getParameter("default_yn1");
			 
			String addedById = p.getProperty( "login_user" ) ;
			//String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			//String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

//			java.sql.Date added_date1 = java.sql.Date.valueOf( addedDate ) ;
//			java.sql.Date modified_date1 = java.sql.Date.valueOf(modifiedDate ) ;

			//java.sql.Date added_date = new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
			//java.sql.Date modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ;

				HashMap tabdata=new HashMap();
	
				tabdata.put("sec_hdg_code",sec_hdg_code);
				tabdata.put("default_yn",default_yn);
				tabdata.put("modified_by_id",modifiedById);
				tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
				tabdata.put("modified_facility_id",modifiedFacilityId);
				tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

				HashMap condflds=new HashMap();
				condflds.put("image_ref",image_ref);
				condflds.put("sec_hdg_code",sec_hdg_code);

			/*Context context =  new InitialContext(  ) ;
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			SingleTabHandlerManagerHome singleTabHandlerManagerHome=(SingleTabHandlerManagerHome)PortableRemoteObject.narrow(homeObject,
  SingleTabHandlerManagerHome.class);

			final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();

			final java.util.Hashtable results = singleTabHandlerManagerRemote.update(p,tabdata,condflds,"ca_section_image_link");*/
			boolean local_ejbs = false;
			String tabname="ca_section_image_link";
		
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
		results.clear();
    		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);

		}
		catch ( Exception e )
		{
			//out.println("Exception!!!!"+e.toString());
			e.printStackTrace();
			//out.println("<h3> Exception raised by Servlet ...So Record Not Modified </h3> Foll: Error Received in modify: "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println( image_ref+" "+sec_hdg_code+" "+default_yn );
		}
	}

	private void insert(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		java.util.Properties p;
		String image_ref = req.getParameter("image_ref");
		String sec_hdg_code = req.getParameter("sec_hdg_code");
		String default_yn = req.getParameter("default_yn");
		String facilityId ;
		String client_ip_address ;
		HttpSession session;
		session = req.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = req.getRemoteAddr() ;
		client_ip_address = p.getProperty("client_ip_address");
		try
		{
			//image_ref = req.getParameter("image_ref");
			//sec_hdg_code = req.getParameter("sec_hdg_code");
			//default_yn = req.getParameter("default_yn");
			if(default_yn == null)
				default_yn = "N";
			else
				default_yn = "Y";
			String addedById = p.getProperty( "login_user" ) ;
			//String addedDate = dateFormat.format( new java.util.Date() ) ;

			String modifiedById = addedById ;
			//String modifiedDate = addedDate ;

			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;

//			java.sql.Date added_date1 = java.sql.Date.valueOf( addedDate ) ;
//			java.sql.Date modified_date1 = java.sql.Date.valueOf(modifiedDate ) ;

			//java.sql.Date added_date = new java.sql.Date(added_date1.parse(added_date1.toLocaleString())-(added_date1.getTimezoneOffset()*60*1000) ) ;
			//java.sql.Date modified_date = new java.sql.Date(modified_date1.parse(modified_date1.toLocaleString())-(modified_date1.getTimezoneOffset()*60*1000) ) ;

				HashMap tabdata=new HashMap();

				tabdata.put("image_ref",image_ref);
				tabdata.put("sec_hdg_code",sec_hdg_code);
				tabdata.put("default_yn",default_yn);
				tabdata.put("added_by_id",addedById);
				tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
				tabdata.put("added_facility_id", facilityId);
				tabdata.put("added_at_ws_no",addedAtWorkstation);
				tabdata.put("modified_by_id",modifiedById);
				tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
				tabdata.put("modified_facility_id",modifiedFacilityId);
				tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

				String dupflds[]={"sec_hdg_code", "image_ref"};

			/*Context context =  new InitialContext(  ) ;
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			SingleTabHandlerManagerHome singleTabHandlerManagerHome=(SingleTabHandlerManagerHome)PortableRemoteObject.narrow(homeObject,  SingleTabHandlerManagerHome.class);
			final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();

			final java.util.Hashtable results = singleTabHandlerManagerRemote.insert(p,tabdata,dupflds,"ca_section_image_link");*/
			
			boolean local_ejbs = false;
			String tabname="ca_section_image_link";
		
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
						results.clear();
			    		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);

					}
					catch ( Exception e )
					{
						//out.println("<h3> Exception raised by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());//common-icn-0181
						e.printStackTrace();
						out.println( "Values sent are : <br>" ) ;
						out.println( image_ref+" "+sec_hdg_code+" "+default_yn );
		}
	}

	private void delete(HttpServletRequest req, HttpServletResponse res, PrintWriter out)
	{
		java.util.Properties p;
		String image_ref;
		String sec_hdg_code;
		String facilityId ;
		String client_ip_address ;
		HttpSession session;
		session = req.getSession(false);
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
		facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = req.getRemoteAddr() ;
		client_ip_address = p.getProperty("client_ip_address");
		try
		{

			image_ref = req.getParameter("image_ref_desc1");
			sec_hdg_code = req.getParameter("sec_hdg_code1");
			
			HashMap condflds=new HashMap();
			condflds.put("image_ref",image_ref);
			condflds.put("sec_hdg_code",sec_hdg_code);
		
			boolean local_ejbs = false;
			String tabname="ca_section_image_link";
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
			Object argArray[] = new Object[3];
			argArray[0] = p;
			argArray[1] = condflds;
			argArray[2] = tabname;
			
			Class [] paramArray = new Class[3];
			paramArray[0] = p.getClass();
			paramArray[1] = condflds.getClass();
			paramArray[2] = tabname.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean modified = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			condflds.clear();
			// If the code is used by some other table (i.e) integrity constraint 
			// or if some error is there, It will return the modified as false.
			
			String error = (String) results.get("error") ;
						String error_value = "0" ;
						if ( modified )
						{
						 error_value = "1" ;
						}
						else
						{
						 error = (String) results.get("error") ;

						}
      		error = (String) results.get("error") ;
			results.clear();
	      	if(modified)
		  	{
      			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8") +"&err_value="+error_value);
      		}
      		else
      		{
				error = "APP-CA0056 This Note Type in use, cannot be deleted...";
				//If any error is there , say integrity constraint error, display the above message and clear the page
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8")+"&err_value=1");
      		}

			}
			catch ( Exception e )
			{
				//out.println("<h3> Exception raise by Servlet ...So Record Not Deleted </h3> Foll: Error Received : "+e.toString());//common-icn-0181
				e.printStackTrace();
			}
	
		}
}
