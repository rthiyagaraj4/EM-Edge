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

public class HlthCareSetgTypRestnsServlet extends javax.servlet.http.HttpServlet	
{
//PrintWriter out;

java.util.Properties p;
String operation ="";
String  ws_no             = "" ;
String uid                  = "";
String facilityId="";
//java.util.Hashtable env	;
//String serviceURL		;
//String client_ip_address ;
//String objectName		;
//java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException	
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)
        throws javax.servlet.ServletException,IOException
	{
		HttpSession session = req.getSession(false);
		this.facilityId = (String)session.getValue("facility_id") ;
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		//this.client_ip_address = p.getProperty("client_ip_address");
		//serviceURL=(String) session.getValue("serviceURL");
		//objectName="/test/SingleTabHandlerManager";

		try 
		{
			//this.out = res.getWriter();
			p                   = ( java.util.Properties ) session.getValue( "jdbc" ) ;
			ws_no                   = req.getRemoteAddr() ;
			uid = p.getProperty( "login_user" ) ;
			operation = req.getParameter("function_name");

			if ( operation.equals("insert") )
				insertHlthCareSetgTypRestns(req, res);
			if ( operation.equals("modify"))
				modifyHlthCareSetgTypRestns(req, res);
		}
		catch (Exception e)	
		{
			e.printStackTrace();
		}
	}

	private void insertHlthCareSetgTypRestns(HttpServletRequest req, HttpServletResponse res)	
	{
		try 
		{
			HashMap tabdata=new HashMap();			
			tabdata.put("from_hcare_setting_type_code",(req.getParameter("from_hcare_setting_type_code")==null?"":req.getParameter("from_hcare_setting_type_code")));	tabdata.put("to_hcare_setting_type_code",(req.getParameter("to_hcare_setting_type_code")==null?"":req.getParameter("to_hcare_setting_type_code")));		tabdata.put("ip_referral_yn",(req.getParameter("ip_referral_yn")==null?"N":req.getParameter("ip_referral_yn")));			tabdata.put("op_referral_yn",(req.getParameter("op_referral_yn")==null?"N":req.getParameter("op_referral_yn")));

			tabdata.put("added_by_id",uid);
			tabdata.put("added_date",new java.sql.Date(System.currentTimeMillis()));
			tabdata.put("added_at_ws_no",ws_no);
			tabdata.put("added_facility_id",facilityId);
			tabdata.put("modified_by_id",uid);
			tabdata.put("modified_date",new java.sql.Date(System.currentTimeMillis()));
			tabdata.put("modified_at_ws_no",ws_no);
			tabdata.put("modified_facility_id",facilityId);
			
			String dupflds[]={"from_hcare_setting_type_code","to_hcare_setting_type_code"};


			//Context context =  new InitialContext(  ) ;
			//Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			//SingleTabHandlerManagerHome singleTabHandlerManagerHome=(SingleTabHandlerManagerHome)PortableRemoteObject.narrow(homeObject,  SingleTabHandlerManagerHome.class);
			//final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();
			//final java.util.Hashtable results = singleTabHandlerManagerRemote.insert(p,tabdata,dupflds,"AM_HCARE_SETTING_TYPE_RSTRN");
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
				String table_name="AM_HCARE_SETTING_TYPE_RSTRN";
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
			
			results.clear();
            
			if ( inserted ) error_value = "1" ;
		    {
		    }
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );
			tabdata.clear();

		    } catch ( Exception e ) {
			e.printStackTrace();
		    }
	
	}

	private void modifyHlthCareSetgTypRestns(HttpServletRequest req, HttpServletResponse res)	
	{
		try 
		{
		    HashMap tabdata=new HashMap();			 tabdata.put("ip_referral_yn",(req.getParameter("ip_referral_yn")==null?"N":req.getParameter("ip_referral_yn")));			tabdata.put("op_referral_yn",(req.getParameter("op_referral_yn")==null?"N":req.getParameter("op_referral_yn")));

		    tabdata.put("modified_by_id",uid);
		    tabdata.put("modified_date",new java.sql.Date(System.currentTimeMillis()));
		    tabdata.put("modified_at_ws_no",ws_no);
		    tabdata.put("modified_facility_id",facilityId);

		    HashMap condflds=new HashMap();			condflds.put("from_hcare_setting_type_code",(req.getParameter("from_hcare_setting_type_code")==null?"":req.getParameter("from_hcare_setting_type_code")));	condflds.put("to_hcare_setting_type_code",(req.getParameter("to_hcare_setting_type_code")==null?"":req.getParameter("to_hcare_setting_type_code")));		

		   //Context context =  new InitialContext(  ) ;
		   //Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
		   // SingleTabHandlerManagerHome singleTabHandlerManagerHome=(SingleTabHandlerManagerHome)PortableRemoteObject.narrow(homeObject,  SingleTabHandlerManagerHome.class);
		   // final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();
		  // final java.util.Hashtable results = singleTabHandlerManagerRemote.update(p,tabdata,condflds,"AM_HCARE_SETTING_TYPE_RSTRN");
           

		   boolean local_ejbs = false;
		
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		

		/*	HashMap hashmap = new HashMap();
				hashmap.put("p",p);
				hashmap.put("tabdata",tabdata);
				hashmap.put("condflds",condflds);
			
				hashmap.put("table_name",table_name);
				
				Object argArray[] = new Object[1];
				argArray[0] =hashmap;
			
			

				Class [] paramArray = new Class[1];
				paramArray[0] =hashmap.getClass();*/
					Object argArray[] = new Object[4];
						String table_name="AM_HCARE_SETTING_TYPE_RSTRN";
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
			     res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode( error ,"UTF-8" ) );
			}
			tabdata.clear();
			condflds.clear();
			results.clear();

		} catch ( Exception e ) {
		    e.printStackTrace();

		}
	    }
}
