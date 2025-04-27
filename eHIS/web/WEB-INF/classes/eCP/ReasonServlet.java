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
 import eCommon.SingleTabHandler.*;
 import eCommon.Common.*;
 import java.net.URLEncoder.*;
 import webbeans.eCommon.*;

 public class ReasonServlet extends HttpServlet  
 {
	//private ServletConfig config=null;
	HttpSession session=null;
	PrintWriter out=null;
	Properties p=new Properties();
	String client_ip_address="";
	String jv_user_id = "";
	String jv_date = "";
	String facility_id="";

	String mode="";

	String jv_reason_code="";
	String jv_reason_desc="";
	String jv_activity_code="";
	String jv_eff_status="";
	
	
	boolean inserted= false;
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	 public void init(ServletConfig config)  throws ServletException
	 {
		super.init(config);																
	 }

    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException	{
		doPost(request,response);
	}

	public void doPost(HttpServletRequest req,HttpServletResponse res)throws javax.servlet.ServletException, IOException
		{
		   this.out=res.getWriter();
		 res.setContentType("text/html;charset=UTF-8");
		 req.setCharacterEncoding("UTF-8");
		 
		 try
		 {
			session=req.getSession(false);
			this.facility_id=(String)session.getAttribute("facility_id");
			this.p = (java.util.Properties)session.getAttribute("jdbc");
			this.client_ip_address=p.getProperty("client_ip_address");
			jv_date = dateFormat.format( new java.util.Date() ) ;
			jv_user_id 	= p.getProperty( "login_user" ) ;

			mode = req.getParameter("mode");
			
			if(mode.equals("1"))	 insertOperation(req, res);
			if(mode.equals("2"))     modifyOperation(req,res);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
 



 public void insertOperation(HttpServletRequest req,HttpServletResponse res)
     throws Exception
	{
				
		try{

		jv_reason_code=req.getParameter("reason_code")==null ? "":req.getParameter("reason_code");
		jv_reason_desc=req.getParameter("reason")==null ? "":req.getParameter("reason");
		jv_activity_code=req.getParameter("activity_code")==null ? "":req.getParameter("activity_code");
		jv_eff_status=(req.getParameter("eff_status")==null || req.getParameter("eff_status")=="")? "D" : req.getParameter("eff_status");

		HashMap tabData=new HashMap();

		tabData.put("reason_code",jv_reason_code);
		tabData.put("reason_desc",jv_reason_desc);
		tabData.put("ACTIVITY_TYPE_CODE",jv_activity_code);
		tabData.put("eff_status",jv_eff_status);
		
		tabData.put("added_by_id", jv_user_id);
        tabData.put("ADDED_DATE", jv_date);
        tabData.put("ADDED_AT_WS_NO",  client_ip_address);
		tabData.put("ADDED_FACILITY_ID",  facility_id);
		tabData.put("MODIFIED_BY_ID", jv_user_id);
        tabData.put("MODIFIED_DATE", jv_date);
		tabData.put("MODIFIED_AT_WS_NO", client_ip_address);
		tabData.put("MODIFIED_FACILITY_ID", facility_id);

		String dupflds[]={"reason_code"};
	   
	try{
				/*InitialContext context = new InitialContext();
				Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
				SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
				final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();

				final java.util.HashMap results = singleTabHandlerManagerRemote.insert(p,tabData,dupflds,"cp_reason");
				*/

				boolean local_ejbs = false;
				ServletContext context = getServletConfig().getServletContext();
				if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				Object argArray[] = new Object[4];
				String table_name="cp_reason";
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
				inserted = (((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
				String error_value = "0" ;

	    		   if ( inserted )
				   {
					    error_value= "1";
		     			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );
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
  } // End of the insertParameter

 
  public void modifyOperation(HttpServletRequest req,HttpServletResponse res)throws Exception{
       try{	
			jv_reason_code=req.getParameter("reason_code")==null ? "":req.getParameter("reason_code");
			jv_reason_desc=req.getParameter("reason")==null ? "":req.getParameter("reason");
			jv_activity_code=req.getParameter("activity_code")==null ? "":req.getParameter("activity_code");
			jv_eff_status=(req.getParameter("eff_status")==null || req.getParameter("eff_status")=="")? "D" : req.getParameter("eff_status");			 

		HashMap tabData=new HashMap();
		tabData.put("reason_code",jv_reason_code);
		tabData.put("reason_desc",jv_reason_desc);
		tabData.put("ACTIVITY_TYPE_CODE",jv_activity_code);
		tabData.put("eff_status",jv_eff_status);
		
		tabData.put("MODIFIED_BY_ID", jv_user_id);
        tabData.put("MODIFIED_DATE", jv_date);
		tabData.put("MODIFIED_AT_WS_NO", client_ip_address);
		tabData.put("MODIFIED_FACILITY_ID", facility_id);		

	
		HashMap condflds=new HashMap();
		condflds.put("reason_code",jv_reason_code);

			try{
				/*InitialContext context = new InitialContext();
				Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
				final SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
				final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();

				final java.util.HashMap results = singleTabHandlerManagerRemote.update(p,tabData,condflds,"cp_reason");*/

				boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[4];
			String table_name="cp_reason";
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
		     			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8"  ) + "&err_value=" + error_value );
	        	   }
		     	   else
		     	   {
					  res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) + "&err_value=" + error_value );
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
  } // End modify
}
