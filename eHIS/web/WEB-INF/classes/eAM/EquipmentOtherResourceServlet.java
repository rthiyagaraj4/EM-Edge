/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAM;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;

import eCommon.SingleTabHandler.*;

public class EquipmentOtherResourceServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;

	java.util.Properties p;
	String client_ip_address ;

	String facId;
	String resource_class;
	String resource_type;
	String resource_id;
	String rd_appl_yn;
	String long_desc;
	String short_desc;
	String eff_status;
	String bldng;
	String flor;
	String person_name;
	String telephone_no;
	String resource_narration;
	String facilityId;

	HttpSession session;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		client_ip_address = p.getProperty("client_ip_address");

		try
		{
			res.setContentType("text/html");
			this.out = res.getWriter();
			String operation = req.getParameter("function");

			if ( operation.equals("insert") ) insertEqpOthResource(req, res);
			if ( operation.equals("modify"))  modifyEqpOthResource(req, res);
	
		}catch(Exception e)
		{
			out.println(e.toString());
		}
	}

	/*public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
	
	}*/

	/* The function modifyEqpOthResource() is used to update the records in the database table am_resource; this function is calling the EJB singleTabHandlerManagerRemote() in update mode with the modified values which are in hashtable, conditional fields which are in another hash table, these db columns are primary keys in the table, and the database table where the values to be modified.  ---  Srijagadeesh, 6-8-2004. */

	private void modifyEqpOthResource(HttpServletRequest req, HttpServletResponse res)
	{

		try
		{
			facId = req.getParameter("facId");
			resource_class = req.getParameter("resource_class");
			if(resource_class.equals("Equipment")) resource_class="E";
			  else resource_class="O";
			resource_type = req.getParameter("resource_type1");
		
			resource_id = req.getParameter("resource_id");
			rd_appl_yn = req.getParameter("rd_appl_yn");
	
			if(rd_appl_yn==null) rd_appl_yn="N";
		
			long_desc = req.getParameter("long_desc");
			short_desc = req.getParameter("short_desc");
			eff_status = req.getParameter("eff_status");
			if(eff_status==null) eff_status="D";

			bldng = req.getParameter("bldng");
			if(bldng==null) bldng="";
			flor = req.getParameter("flor");
			if(flor==null) flor="";
			person_name = req.getParameter("person_name");
			telephone_no = req.getParameter("telephone_no");
			resource_narration = req.getParameter("resource_narration");

			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			//java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;

		
			HashMap tabdata=new HashMap();

			tabdata.put("facility_id",facId);
			tabdata.put("resource_class",resource_class);
			tabdata.put("resource_type",resource_type);
			tabdata.put("resource_id",resource_id);
			tabdata.put("rd_appl_yn",rd_appl_yn);
			tabdata.put("long_desc",long_desc);
			tabdata.put("short_desc",short_desc);
			tabdata.put("eff_status",eff_status);
			tabdata.put("bldng_code",bldng);
			tabdata.put("floor_code",flor);
			tabdata.put("contact_person",person_name);
			tabdata.put("contact_tel_no",telephone_no);
			tabdata.put("resource_narration",resource_narration);

			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			HashMap condflds=new HashMap();

			condflds.put("facility_id",facId);
			condflds.put("resource_id",resource_id);

		/*	java.util.HashMap env = (java.util.HashMap)session.getValue("env");
			env.put( Context.URL_PKG_PREFIXES, "oracle.aurora.jndi" ) ;*/

			/*InitialContext context = new InitialContext();
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
			SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();
			java.util.Hashtable results = singleTabHandlerManagerRemote.update(p,tabdata,condflds,"am_resource");*/

			 boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);



		/*	HashMap hashmap = new HashMap();
				hashmap.put("p",p);
				hashmap.put("tabdata",tabdata);
				hashmap.put("condflds",condflds);
					String table_name="am_resource";
				hashmap.put("table_name",table_name);
				
				Object argArray[] = new Object[1];
				argArray[0] =hashmap;
			
			

				Class [] paramArray = new Class[1];
				paramArray[0] =hashmap.getClass();*/


				
						Object argArray[] = new Object[4];
						String table_name="am_resource";
				//argArray[0] =hashmap;
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
            condflds.clear();
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted )
			{
				 error_value = "1" ;
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );
			}
			else
			{
				 error = (String) results.get("error") ;
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error ,"UTF-8" ) );
			}
			tabdata.clear();
			results.clear();
			
		}catch(Exception e)
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println(facId+"|"+resource_class+"|"+resource_type+"|"+resource_id+"|"+long_desc+"|"+short_desc+"|"+eff_status+"|"+bldng+"|"+flor+"|"+person_name+"|"+telephone_no+"|"+resource_narration+"<br>");
			e.printStackTrace();
		}
	
	}

	/* The function insertEqpOthResource() is used to insert records in the database table am_resource; this function is calling the EJB singleTabHandlerManagerRemote() in insert mode with the values which are in hashtable,facility id,resource class,resource type,resource id,long description,short description,building code,floor code,contact person name,contact person phone number,effective status, resource narration and the database table where the values to be inserted.  ---  Srijagadeesh, 6-8-2004. */
	
	private void insertEqpOthResource(HttpServletRequest req, HttpServletResponse res)
	{

		try
		{
			facId = req.getParameter("facId");
			resource_class = req.getParameter("resource_class");
			resource_type = req.getParameter("resource_type");
			
			resource_id = req.getParameter("resource_id");
			rd_appl_yn = req.getParameter("rd_appl_yn");
			if(rd_appl_yn==null) rd_appl_yn="N";
			long_desc = req.getParameter("long_desc");
			short_desc = req.getParameter("short_desc");
			eff_status = req.getParameter("eff_status");
			if(eff_status==null) eff_status="D";
			bldng = req.getParameter("bldng");
			if(bldng==null) bldng="";
			flor = req.getParameter("flor");
			if(flor==null) flor="";
			person_name = req.getParameter("person_name");
			telephone_no = req.getParameter("telephone_no");
			resource_narration = req.getParameter("resource_narration");

			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			java.sql.Date added_date = java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;

			HashMap tabdata=new HashMap();

			tabdata.put("facility_id",facId);
			tabdata.put("resource_class",resource_class);
			tabdata.put("resource_type",resource_type);
			tabdata.put("resource_id",resource_id);
			tabdata.put("rd_appl_yn",rd_appl_yn);
			tabdata.put("long_desc",long_desc);
			tabdata.put("short_desc",short_desc);
			tabdata.put("eff_status",eff_status);
			tabdata.put("bldng_code",bldng);
			tabdata.put("floor_code",flor);
			tabdata.put("contact_person",person_name);
			tabdata.put("contact_tel_no",telephone_no);
			tabdata.put("resource_narration",resource_narration);

			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",added_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);

			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			String dupflds[]={"facility_id","resource_id"};

			/*InitialContext context = new InitialContext();
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
			SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();

			java.util.Hashtable results = singleTabHandlerManagerRemote.insert(p,tabdata,dupflds,"am_resource");*/

						 boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);


				/*HashMap hashmap = new HashMap();
				hashmap.put("p",p);
				hashmap.put("tabdata",tabdata);
				hashmap.put("dupflds",dupflds);
				
				hashmap.put("table_name",table_name);
				
				Object argArray[] = new Object[1];
				argArray[0] =hashmap;
			
			

				Class [] paramArray = new Class[1];
				paramArray[0] =hashmap.getClass();*/

					Object argArray[] = new Object[4];
					String table_name="am_resource";
				//argArray[0] =hashmap;
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
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8" ) + "&err_value=" + error_value );
				 
			}
			else
			{
				 error = (String) results.get("error") ;
				 res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8"  ) );
				
			}
			tabdata.clear();
			results.clear();
		}
		catch(Exception e)
		{
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
			out.println( "Values sent are : <br>" ) ;
			out.println(facId+"|"+resource_class+"|"+resource_type+"|"+resource_id+"|"+long_desc+"|"+short_desc+"|"+eff_status+"|"+bldng+"|"+flor+"|"+person_name+"|"+telephone_no+"|"+resource_narration+"<br>");
			e.printStackTrace();
		}

	}
}
