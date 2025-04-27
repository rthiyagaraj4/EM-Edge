/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//This file is saved on 18/10/2005.

package eCP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
//import javax.naming.*;
//import javax.rmi.*;
import eCommon.Common.*;
import eCommon.SingleTabHandler.*;
import webbeans.eCommon.*;

public class OutcomeServlet extends HttpServlet 
{
	//private ServletConfig config = null;
	PrintWriter out = null;
	HttpSession session = null;
	String facility_id = "";
	Properties p = new Properties();
	String client_ip_address = "";
	
	boolean inserted= false;

	String outcome_type="";
	String outcome_code="";
	String short_desc="";
	String long_desc="";
	String eff_status="";
	String added_by_id = "";
	
		
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;	

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{

			res.setContentType("text/html;charset=UTF-8");
			req.setCharacterEncoding("UTF-8");
			this.out = res.getWriter();
		try	{
			
			session = req.getSession(false);
			this.facility_id = (String) session.getAttribute( "facility_id" ) ;
			this.p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
			this.client_ip_address = p.getProperty("client_ip_address");

		
		outcome_code=req.getParameter("outcome_code")==null ? "":req.getParameter("outcome_code");
		long_desc=req.getParameter("long_desc")==null ? "":req.getParameter("long_desc");
		short_desc=req.getParameter("short_desc")==null ? "":req.getParameter("short_desc");
		outcome_type=req.getParameter("outcome_type")==null ? "":req.getParameter("outcome_type");
		eff_status=req.getParameter("eff_status")==null ? "D":req.getParameter("eff_status");

			String operation = req.getParameter("operation_type");
			if ( operation.equals("insert")) insertOperation(res);
			if ( operation.equals("modify")) modifyOperation(req, res);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void insertOperation(HttpServletResponse res)
     throws Exception
	{
				
		try{

			String addeddate = dateFormat.format( new java.util.Date() ) ;
			facility_id = (String) session.getAttribute( "facility_id" ) ;
			added_by_id 	= p.getProperty( "login_user" ) ;

			

			
		HashMap tabData=new HashMap();

		tabData.put("outcome_code",outcome_code);
		tabData.put("long_desc",long_desc);
		tabData.put("short_desc",short_desc);
		tabData.put("outcome_type",outcome_type);
		tabData.put("eff_status",eff_status);
		tabData.put("ADDED_BY_ID", added_by_id);
        tabData.put("ADDED_DATE", addeddate);
        tabData.put("ADDED_AT_WS_NO",  client_ip_address);
		tabData.put("ADDED_FACILITY_ID",  facility_id);
		tabData.put("MODIFIED_BY_ID", added_by_id);
        tabData.put("MODIFIED_DATE", addeddate);
		tabData.put("MODIFIED_AT_WS_NO", client_ip_address);
		tabData.put("MODIFIED_FACILITY_ID", facility_id);

		String dupflds[]={"outcome_code"};

try{
				/*InitialContext context = new InitialContext();
				Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
				final SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
				final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();

				final java.util.HashMap results = singleTabHandlerManagerRemote.insert(p,tabData,dupflds,"cp_outcome");*/


				boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[4];
			String table_name="cp_outcome";
			argArray[0] =p;
			argArray[1] =tabData;
			argArray[2] =dupflds;
			argArray[3] =table_name;

			Class [] paramArray = new Class[4];
			paramArray[0] =p.getClass();
			paramArray[1] =tabData.getClass();
			paramArray[2] =dupflds.getClass();
			paramArray[3] =table_name.getClass();
			
			HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);



				inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
				String error_value = "0" ;

	    		   if ( inserted )
				   {
					    error_value= "1";
		     			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8" ) + "&err_value=" + error_value );
	        	   }
		     	   else
		     	   {
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );
		     	   }
		     }catch(Exception e)
                {
	              out.println("From Servlet--Calling EJB:"+e);
                  e.printStackTrace();
				  String error = "Error ";
				  String error_value = "0" ;
			      res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );
	            }
	  }catch ( Exception e )
      {
		e.printStackTrace();
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }

  } // End of the insertParameter

	//End of Insert

	public void modifyOperation(HttpServletRequest req,HttpServletResponse res)
		throws Exception
	{

		try{
		String addeddate = dateFormat.format( new java.util.Date() ) ;
		facility_id = (String) session.getAttribute( "facility_id" ); 
		added_by_id 	= p.getProperty( "login_user" ) ;

			
		outcome_type=req.getParameter("outcome_type1")==null ? "":req.getParameter("outcome_type1");
			
		HashMap tabData=new HashMap();

		tabData.put("long_desc",long_desc);
		tabData.put("short_desc",short_desc);
		tabData.put("outcome_type",outcome_type);
		tabData.put("eff_status",eff_status);
		tabData.put("MODIFIED_BY_ID", added_by_id);
        tabData.put("MODIFIED_DATE", addeddate);
		tabData.put("MODIFIED_AT_WS_NO", client_ip_address);
		tabData.put("MODIFIED_FACILITY_ID", facility_id);

		HashMap condflds=new HashMap();
		condflds.put("outcome_code",outcome_code);
		
		try{
			
			/*InitialContext context = new InitialContext();
			Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
			final SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
			final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();

			final java.util.HashMap results = singleTabHandlerManagerRemote.update(p,tabData,condflds,"cp_outcome");*/

			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[4];
			String table_name="cp_outcome";
			argArray[0] =p;
			argArray[1] =tabData;
			argArray[2] =condflds;
			argArray[3] =table_name;

			Class [] paramArray = new Class[4];
			paramArray[0] =p.getClass();
			paramArray[1] =tabData.getClass();
			paramArray[2] =condflds.getClass();
			paramArray[3] =table_name.getClass();
			
			HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

				String error = (String) results.get("error") ;
				String error_value = "0" ;

	    		   if ( inserted )
				   {
					    error_value= "1";
		     			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8" ) + "&err_value=" + error_value );
	        	   }
		     	   else
		     	   {
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ,"UTF-8" ) + "&err_value=" + error_value );
		     	   }
				   
		     }catch(Exception e)
                {
	              out.println("From Servlet--Calling EJB:"+e);
                  e.printStackTrace();
				  String error = "Error ";
				  String error_value = "0" ;
			      res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );
	            }
	  }catch ( Exception e )
      {
		e.printStackTrace();
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }
  } // End of the modifyParameter
		

}
