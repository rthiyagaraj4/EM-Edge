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

public class InterventionParamServlet extends HttpServlet
{
	// private ServletConfig config=null;
	 HttpSession session=null;
	 PrintWriter out=null;
	 Properties p=new Properties();
	 String client_ip_address="";
	
	String facility_id="";
	String added_by_id = "";
	boolean inserted= false;

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	 public  void init(ServletConfig config)  throws ServletException
	 {
		super.init(config);																
	 }

    public  void doPost(HttpServletRequest req,HttpServletResponse res)throws javax.servlet.ServletException, IOException
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
			  modifyOperation(req,res);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

 public void modifyOperation(HttpServletRequest req,HttpServletResponse res)throws Exception{
       try{	
			
			String addeddate = dateFormat.format( new java.util.Date() ) ;
			facility_id = (String) session.getAttribute( "facility_id" ) ;
			added_by_id 	= p.getProperty( "login_user" ) ;
			
				
            String accessTaskYN="Y";   
			String beforeStartTimeText = req.getParameter("before_start_time_text")==null ? "" :req.getParameter("before_start_time_text");
			String beforeStartTimeSelect = req.getParameter("duration_start_time")==null ? "" :req.getParameter("duration_start_time");
			String afterStartTimeText = req.getParameter("after_start_time_text")==null ? "" :req.getParameter("after_start_time_text");
			String afterStartTimeSelect = req.getParameter("duration_after_time")==null ? "" :req.getParameter("duration_after_time");
			String endTimeText = req.getParameter("end_time")==null ? "" :req.getParameter("end_time");
			String endTimeSelect = req.getParameter("end_time_select")==null ? "" :req.getParameter("end_time_select");
			String backDateText = req.getParameter("Backdate_limit")==null ? "" :req.getParameter("Backdate_limit");
			String backDateSelect = req.getParameter("backdate")==null ? "" :req.getParameter("backdate");
     		HashMap tabData=new HashMap();
		
		tabData.put("TASK_LIST_ACCESS_BY_PIN_YN",accessTaskYN);
		tabData.put("LMT_FOR_TSK_DUE_BF_ST_TM",beforeStartTimeText);
		tabData.put("LMT_FOR_TSK_DUE_BF_ST_TM_UNIT",beforeStartTimeSelect);
		tabData.put("LMT_FOR_TSK_ODUE_AF_ST_TM",afterStartTimeText);
		tabData.put("LMT_FOR_TSK_ODUE_AF_ST_TM_UNIT",afterStartTimeSelect);
		tabData.put("LMT_FOR_TSK_EXP_AF_END_TM",endTimeText);
		tabData.put("LMT_FOR_TSK_EXP_AF_END_TM_UNIT",endTimeSelect);
		tabData.put("BKDATE_LMT_FOR_TSK_RESULT",backDateText);
		tabData.put("BKDATE_LMT_FOR_TSK_RESULT_UNIT",backDateSelect);
		tabData.put("MODIFIED_BY_ID", added_by_id);
        tabData.put("MODIFIED_DATE", addeddate);
		tabData.put("MODIFIED_AT_WS_NO", client_ip_address);
		tabData.put("MODIFIED_FACILITY_ID", facility_id);		

		HashMap condflds=new HashMap();
		condflds.put("MODULE_ID","CP");

			try{
				/*InitialContext context = new InitialContext();
				Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
				final SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
				final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();
				final java.util.HashMap results = singleTabHandlerManagerRemote.update(p,tabData,condflds,"ca_intervention_param");*/

			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[4];
			String table_name="ca_intervention_param";
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
		     			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
	        	   }
		     	   else
		     	   {
					  res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
		     	   }
		     }catch(Exception e)
                {
	              out.println("From Servlet--Calling EJB:"+e);
                  e.printStackTrace();
				  String error = "Error ";
				  String error_value = "0" ;
			      res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
	            }
	  }catch ( Exception e )
      {
		e.printStackTrace();
		out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }
  } // End modify


}
