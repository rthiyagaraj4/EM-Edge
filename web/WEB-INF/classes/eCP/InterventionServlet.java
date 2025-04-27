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

 public class InterventionServlet extends HttpServlet  
 {
	// private ServletConfig config=null;
	 HttpSession session=null;
	 PrintWriter out=null;
	 Properties p=new Properties();
	 String client_ip_address="";
	 
	 String mode="";
	 String facility_id="";
 	 
	 String intervention_code="";
	 String long_desc="";
	 String short_desc="";
	 String eff_status="";
	 String intervention_type="";
	 String dependency="";
	 String durn="";
	 String durn_unit="";
	 String durnBeforeStart="";
	 String durnBeforeStart_unit="";
	 String durnAfterStart="";
	 String durnAfterStart_unit="";
	 String durnAfterEnd="";
	 String durnAfterEnd_unit="";
	 String durnBackDate="";
	 String durnBackDate_unit="";
	 String adhoc_intervention="";
	 String result_type="";
	 String result_measure="";
	 String consent_form_id=""; //IN030473
	 String guidelines="";
	 
	String added_by_id = "";
	
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

			String addeddate = dateFormat.format( new java.util.Date() ) ;
			facility_id = (String) session.getAttribute( "facility_id" ) ;
			added_by_id 	= p.getProperty( "login_user" ) ;
			
		 intervention_code=req.getParameter("intervention_code")==null ? "":req.getParameter("intervention_code");
		 long_desc=req.getParameter("long_desc")==null ? "":req.getParameter("long_desc");
		 short_desc=req.getParameter("short_desc")==null ? "":req.getParameter("short_desc");
		 eff_status=req.getParameter("eff_status")==null ? "D":req.getParameter("eff_status");
		 intervention_type=req.getParameter("intervention_type")==null?"":req.getParameter("intervention_type");
		 dependency=req.getParameter("dependency")==null?"":req.getParameter("dependency");
		 durn=req.getParameter("durn")==null?"":req.getParameter("durn");
		 durn_unit=req.getParameter("durn_unit")==null?"":req.getParameter("durn_unit");
		 durnBeforeStart=req.getParameter("durnBeforeStart")==null?"":req.getParameter("durnBeforeStart");			 
		 durnBeforeStart_unit=req.getParameter("durnBeforeStart_unit")==null?"":req.getParameter("durnBeforeStart_unit");	
		 durnAfterStart=req.getParameter("durnAfterStart")==null?"":req.getParameter("durnAfterStart");	
		 durnAfterStart_unit=req.getParameter("durnAfterStart_unit")==null?"":req.getParameter("durnAfterStart_unit");	
		 durnAfterEnd=req.getParameter("durnAfterEnd")==null?"":req.getParameter("durnAfterEnd");	
		 durnAfterEnd_unit=req.getParameter("durnAfterEnd_unit")==null?"":req.getParameter("durnAfterEnd_unit");	
		 durnBackDate=req.getParameter("durnBackDate")==null?"":req.getParameter("durnBackDate");	
		 durnBackDate_unit=req.getParameter("durnBackDate_unit")==null?"":req.getParameter("durnBackDate_unit");	
		 adhoc_intervention=req.getParameter("adhoc_intervention")==null?"N":req.getParameter("adhoc_intervention");	
		 result_type=req.getParameter("result_type")==null?"":req.getParameter("result_type");	
		 result_measure=req.getParameter("result_id")==null?"":req.getParameter("result_id");	
		 guidelines=req.getParameter("guidelines")==null?"":req.getParameter("guidelines");	
		 consent_form_id=req.getParameter("patient_instructions_id")==null?"":req.getParameter("patient_instructions_id"); //IN030473
		
		HashMap tabData=new HashMap();

		tabData.put("INTERVENTION_CODE",intervention_code);
		tabData.put("LONG_DESC",long_desc);
		tabData.put("SHORT_DESC",short_desc);
		tabData.put("INTERVENTION_TYPE",intervention_type);
		tabData.put("APPL_DEPENDENCY_LEVEL",dependency);
		tabData.put("INTERVENTION_DURN",durn);
		tabData.put("LMT_FOR_TSK_DUE_BF_ST_TM",durnBeforeStart);
		tabData.put("LMT_FOR_TSK_DUE_BF_ST_TM_UNIT",durnBeforeStart_unit);
		tabData.put("LMT_FOR_TSK_ODUE_AF_ST_TM",durnAfterStart);
		tabData.put("LMT_FOR_TSK_ODUE_AF_ST_TM_UNIT",durnAfterStart_unit);
		tabData.put("LMT_FOR_TSK_EXP_AF_END_TM",durnAfterEnd);
		tabData.put("LMT_FOR_TSK_EXP_AF_END_TM_UNIT",durnAfterEnd_unit);
		tabData.put("INTERVENTION_GUIDELINE",guidelines);
		tabData.put("RESULT_TYPE",result_type);
		tabData.put("RESULT_ID",result_measure);
		tabData.put("BKDATE_LMT_FOR_TSK_RESULT",durnBackDate);
		tabData.put("BKDATE_LMT_FOR_TSK_RESULT_UNIT",durnBackDate_unit);
		tabData.put("USE_AS_ADHOC_INTERVENTION_YN",adhoc_intervention);
		tabData.put("EFF_STATUS",eff_status);
		tabData.put("CONSENT_FORM_ID",consent_form_id); //IN030473

		
		tabData.put("ADDED_BY_ID", added_by_id);
        tabData.put("ADDED_DATE", addeddate);
        tabData.put("ADDED_AT_WS_NO",  client_ip_address);
		tabData.put("ADDED_FACILITY_ID",  facility_id);
		tabData.put("MODIFIED_BY_ID", added_by_id);
        tabData.put("MODIFIED_DATE", addeddate);
		tabData.put("MODIFIED_AT_WS_NO", client_ip_address);
		tabData.put("MODIFIED_FACILITY_ID", facility_id);
		tabData.put("INTERVENTION_DURN_UNIT",durn_unit);

		String dupflds[]={"INTERVENTION_CODE"};
	   
	try{
				/*InitialContext context = new InitialContext();
				Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
				SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
				final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();

				final java.util.HashMap results = singleTabHandlerManagerRemote.insert(p,tabData,dupflds,"ca_intervention");*/

			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[4];
			String table_name="ca_intervention";
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
  } // End of the insertParameter

 
  public void modifyOperation(HttpServletRequest req,HttpServletResponse res)throws Exception{
       try{	
			String addeddate = dateFormat.format( new java.util.Date() ) ;
			facility_id = (String) session.getAttribute( "facility_id" ) ;
			added_by_id 	= p.getProperty( "login_user" ) ;
				 
     		HashMap tabData=new HashMap();
 			
 		 intervention_code=req.getParameter("intervention_code")==null ? "":req.getParameter("intervention_code");
		 long_desc=req.getParameter("long_desc")==null ? "":req.getParameter("long_desc");
		 short_desc=req.getParameter("short_desc")==null ? "":req.getParameter("short_desc");
		 eff_status=req.getParameter("eff_status")==null ? "D":req.getParameter("eff_status");
		 intervention_type=req.getParameter("intervention_type1")==null?"":req.getParameter("intervention_type1");
		 dependency=req.getParameter("dependency1")==null?"":req.getParameter("dependency1");

		 durn=req.getParameter("durn")==null?"":req.getParameter("durn");
		 durn_unit=req.getParameter("durn_unit1")==null?"":req.getParameter("durn_unit1");
		 durnBeforeStart=req.getParameter("durnBeforeStart")==null?"":req.getParameter("durnBeforeStart");			 
		 durnBeforeStart_unit=req.getParameter("durnBeforeStart_unit1")==null?"":req.getParameter("durnBeforeStart_unit1");	
		 durnAfterStart=req.getParameter("durnAfterStart")==null?"":req.getParameter("durnAfterStart");	
		 durnAfterStart_unit=req.getParameter("durnAfterStart_unit1")==null?"":req.getParameter("durnAfterStart_unit1");	
		 durnAfterEnd=req.getParameter("durnAfterEnd")==null?"":req.getParameter("durnAfterEnd");	
		 durnAfterEnd_unit=req.getParameter("durnAfterEnd_unit1")==null?"":req.getParameter("durnAfterEnd_unit1");	
		 durnBackDate=req.getParameter("durnBackDate")==null?"":req.getParameter("durnBackDate");	
		 durnBackDate_unit=req.getParameter("durnBackDate_unit1")==null?"":req.getParameter("durnBackDate_unit1");	
		 adhoc_intervention=req.getParameter("adhoc_intervention1")==null?"N":req.getParameter("adhoc_intervention1");	
		 result_type=req.getParameter("result_type1")==null?"":req.getParameter("result_type1");	
		 result_measure=req.getParameter("result_id")==null?"":req.getParameter("result_id");	
		 guidelines=req.getParameter("guidelines")==null?"":req.getParameter("guidelines");	
		 consent_form_id=req.getParameter("patient_instructions_id")==null?"":req.getParameter("patient_instructions_id"); //IN030473

		tabData.put("INTERVENTION_CODE",intervention_code);
		tabData.put("LONG_DESC",long_desc);
		tabData.put("SHORT_DESC",short_desc);
		
		tabData.put("EFF_STATUS",eff_status);
		tabData.put("INTERVENTION_TYPE",intervention_type);
		tabData.put("APPL_DEPENDENCY_LEVEL",dependency);
		tabData.put("INTERVENTION_DURN",durn);
		tabData.put("INTERVENTION_DURN_UNIT",durn_unit);

		tabData.put("LMT_FOR_TSK_DUE_BF_ST_TM",durnBeforeStart);
		tabData.put("LMT_FOR_TSK_DUE_BF_ST_TM_UNIT",durnBeforeStart_unit);
		tabData.put("LMT_FOR_TSK_ODUE_AF_ST_TM",durnAfterStart);
		tabData.put("LMT_FOR_TSK_ODUE_AF_ST_TM_UNIT",durnAfterStart_unit);
		tabData.put("LMT_FOR_TSK_EXP_AF_END_TM",durnAfterEnd);
		tabData.put("LMT_FOR_TSK_EXP_AF_END_TM_UNIT",durnAfterEnd_unit);
		tabData.put("BKDATE_LMT_FOR_TSK_RESULT",durnBackDate);
		tabData.put("BKDATE_LMT_FOR_TSK_RESULT_UNIT",durnBackDate_unit);
		tabData.put("USE_AS_ADHOC_INTERVENTION_YN",adhoc_intervention);
		tabData.put("RESULT_TYPE",result_type);
		tabData.put("RESULT_ID",result_measure);
		tabData.put("INTERVENTION_GUIDELINE",guidelines);
		tabData.put("CONSENT_FORM_ID",consent_form_id); //IN030473
	 
		tabData.put("MODIFIED_BY_ID", added_by_id);
        tabData.put("MODIFIED_DATE", addeddate);
		tabData.put("MODIFIED_AT_WS_NO", client_ip_address);
		tabData.put("MODIFIED_FACILITY_ID", facility_id);		

	
		HashMap condflds=new HashMap();
		condflds.put("intervention_code",intervention_code);

			try{
				/*InitialContext context = new InitialContext();
				Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
				final SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
				final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();

				final java.util.HashMap results = singleTabHandlerManagerRemote.update(p,tabData,condflds,"ca_intervention");*/

			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[4];
			String table_name="ca_intervention";
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
