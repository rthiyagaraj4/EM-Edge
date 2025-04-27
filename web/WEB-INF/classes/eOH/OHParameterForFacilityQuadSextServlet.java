/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOH;

import java.lang.reflect.Method;
import java.net.URLEncoder;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.HashMap;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import eCommon.SingleTabHandler.*;



public class OHParameterForFacilityQuadSextServlet extends javax.servlet.http.HttpServlet{
	PrintWriter out;
	HttpSession session;
	java.util.Properties p;
	HashMap results;
	String facility_id="";
	String client_ip_address="";
	String login_user="";
	String locale="";
	String table_name="OH_PARAM_FOR_FACILITY";
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facility_id = (String) session.getValue( "facility_id" ) ;
		login_user = this.p.getProperty( "login_user" ) ;
		locale = this.p.getProperty( "LOCALE" ) ;
		client_ip_address = this.p.getProperty("client_ip_address") ;
		try
		{
			this.out = res.getWriter();
			String operation = req.getParameter("mode");
			//operation = "modify";
			if ( operation.equals("insert") )   insert(req, res);
			if ( operation.equals("modify"))    modify(req, res);
		}
		catch(Exception e)
		{
			out.println(e.toString());
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		doPost(req,res);
	}

	private HashMap populateTabData(HttpServletRequest req, HttpServletResponse res){
		String mode = checkForNull(req.getParameter("mode"));
		mode = "modify";
	   String gigival_recorded=checkForNull(req.getParameter("gigival_recorded"));		
		HashMap tabdata=new HashMap();
		if (gigival_recorded.equals("Q")){
		   if("insert".equals(mode)){
			String tooth_numbering_system=checkForNull(req.getParameter("tooth_numbering_system_hid"));
			String mixed_dentition_from_age_yrs=checkForNull(req.getParameter("mixed_dentition_from_age_yrs_hid"));
			String mixed_dentition_to_age_yrs = checkForNull(req.getParameter("mixed_dentition_to_age_yrs_hid"));
			String mixed_dentition_from_age_days = checkForNull(req.getParameter("mixed_dentition_from_age_days_hid"));
			String mixed_dentition_to_age_days = checkForNull(req.getParameter("mixed_dentition_to_age_days_hid"));
			String deciduous_grace_period_days = checkForNull(req.getParameter("deciduous_grace_period_days_hid"));
			String dflt_mixed_dentition_chart = checkForNull(req.getParameter("dflt_mixed_dentition_chart_hid"));
			String rest_chrt_validity_days = checkForNull(req.getParameter("rest_chrt_validity_days_hid"));
			String peri_chrt_validity_days = checkForNull(req.getParameter("peri_chrt_validity_days_hid"));
			String record_gingival_status_yn = checkForNull(req.getParameter("record_gingival_status_yn_hid"));
			String bl_interface_flag=checkForNull(req.getParameter("bl_interface_flag_hid"));
			//String gigival_recorded=checkForNull(req.getParameter("gigival_recorded"));			
			tabdata.put("facility_id",facility_id);
			tabdata.put("tooth_numbering_system",tooth_numbering_system);
			tabdata.put("mixed_dentition_from_age_yrs",mixed_dentition_from_age_yrs);
			tabdata.put("mixed_dentition_to_age_yrs",mixed_dentition_to_age_yrs);
			tabdata.put("mixed_dentition_from_age_days",mixed_dentition_from_age_days);
			tabdata.put("mixed_dentition_to_age_days",mixed_dentition_to_age_days);
			tabdata.put("deciduous_grace_period_days",deciduous_grace_period_days);
			tabdata.put("dflt_mixed_dentition_chart",dflt_mixed_dentition_chart);
			tabdata.put("rest_chrt_validity_days",rest_chrt_validity_days);
			tabdata.put("peri_chrt_validity_days",peri_chrt_validity_days);
			tabdata.put("record_gingival_status_yn",record_gingival_status_yn);
			tabdata.put("deciduous_grace_period_days",deciduous_grace_period_days );
			tabdata.put("bl_interface_flag",bl_interface_flag );
			if(record_gingival_status_yn.equals("Y")){
				tabdata.put("gingival_recording_by",gigival_recorded );
			}
			else{
				tabdata.put("gingival_recording_by","" );
			}

		    String gs_no_of_tooth_for_Q1 = checkForNull(req.getParameter("gs_no_of_tooth_for_Q1"));
			String gs_no_of_tooth_for_Q2 = checkForNull(req.getParameter("gs_no_of_tooth_for_Q2"));
			String gs_no_of_tooth_for_Q3 = checkForNull(req.getParameter("gs_no_of_tooth_for_Q3"));
			String gs_no_of_tooth_for_Q4 = checkForNull(req.getParameter("gs_no_of_tooth_for_Q4"));
			String gs_dflt_tooth_no_Q1 = checkForNull(req.getParameter("gs_dflt_tooth_no_Q1"));
			String gs_dflt_tooth_no_Q2 = checkForNull(req.getParameter("gs_dflt_tooth_no_Q2"));
			String gs_dflt_tooth_no_Q3 = checkForNull(req.getParameter("gs_dflt_tooth_no_Q3"));
			String gs_dflt_tooth_no_Q4 = checkForNull(req.getParameter("gs_dflt_tooth_no_Q4"));
		   
            //tabdata.put("facility_id",facility_id);
            tabdata.put("gs_no_of_tooth_for_Q1",gs_no_of_tooth_for_Q1);
			tabdata.put("gs_no_of_tooth_for_Q2",gs_no_of_tooth_for_Q2);
			tabdata.put("gs_no_of_tooth_for_Q3",gs_no_of_tooth_for_Q3);
			tabdata.put("gs_no_of_tooth_for_Q4",gs_no_of_tooth_for_Q4);
			tabdata.put("gs_dflt_tooth_no_Q1",gs_dflt_tooth_no_Q1);
			tabdata.put("gs_dflt_tooth_no_Q2",gs_dflt_tooth_no_Q2);
			tabdata.put("gs_dflt_tooth_no_Q3",gs_dflt_tooth_no_Q3);
			tabdata.put("gs_dflt_tooth_no_Q4",gs_dflt_tooth_no_Q4);

			tabdata.put("gs_no_of_tooth_for_S1","");
			tabdata.put("gs_no_of_tooth_for_S2","");
			tabdata.put("gs_no_of_tooth_for_S3","");
			tabdata.put("gs_no_of_tooth_for_S4","");
			tabdata.put("gs_no_of_tooth_for_S5","");
			tabdata.put("gs_no_of_tooth_for_S6","");
			tabdata.put("gs_dflt_tooth_no_S1","");
			tabdata.put("gs_dflt_tooth_no_S2","");
			tabdata.put("gs_dflt_tooth_no_S3","");
			tabdata.put("gs_dflt_tooth_no_S4","");
			tabdata.put("gs_dflt_tooth_no_S5","");
			tabdata.put("gs_dflt_tooth_no_S6","");
		 
            tabdata.put("added_by_id",login_user);
			tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("added_facility_id", facility_id);
			tabdata.put("added_at_ws_no",client_ip_address);
			tabdata.put("modified_by_id",login_user);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",facility_id);
			tabdata.put("modified_at_ws_no",client_ip_address );
         }
	  }
   
     if(gigival_recorded.equals("S")){
		  if("insert".equals(mode)){
		    //String facility_id = checkForNull(req.getParameter("facility_id"));

			String tooth_numbering_system=checkForNull(req.getParameter("tooth_numbering_system_hid"));
			String mixed_dentition_from_age_yrs=checkForNull(req.getParameter("mixed_dentition_from_age_yrs_hid"));
			String mixed_dentition_to_age_yrs = checkForNull(req.getParameter("mixed_dentition_to_age_yrs_hid"));
			String mixed_dentition_from_age_days = checkForNull(req.getParameter("mixed_dentition_from_age_days_hid"));
			String mixed_dentition_to_age_days = checkForNull(req.getParameter("mixed_dentition_to_age_days_hid"));
			String deciduous_grace_period_days = checkForNull(req.getParameter("deciduous_grace_period_days_hid"));
			String dflt_mixed_dentition_chart = checkForNull(req.getParameter("dflt_mixed_dentition_chart_hid"));
			String rest_chrt_validity_days = checkForNull(req.getParameter("rest_chrt_validity_days_hid"));
			String peri_chrt_validity_days = checkForNull(req.getParameter("peri_chrt_validity_days_hid"));
			String record_gingival_status_yn = checkForNull(req.getParameter("record_gingival_status_yn_hid"));
			String bl_interface_flag=checkForNull(req.getParameter("bl_interface_flag_hid"));
			//String gigival_recorded=checkForNull(req.getParameter("gigival_recorded"));			
			tabdata.put("facility_id",facility_id);
			tabdata.put("tooth_numbering_system",tooth_numbering_system);
			tabdata.put("mixed_dentition_from_age_yrs",mixed_dentition_from_age_yrs);
			tabdata.put("mixed_dentition_to_age_yrs",mixed_dentition_to_age_yrs);
			tabdata.put("mixed_dentition_from_age_days",mixed_dentition_from_age_days);
			tabdata.put("mixed_dentition_to_age_days",mixed_dentition_to_age_days);
			tabdata.put("deciduous_grace_period_days",deciduous_grace_period_days);
			tabdata.put("dflt_mixed_dentition_chart",dflt_mixed_dentition_chart);
			tabdata.put("rest_chrt_validity_days",rest_chrt_validity_days);
			tabdata.put("peri_chrt_validity_days",peri_chrt_validity_days);
			tabdata.put("record_gingival_status_yn",record_gingival_status_yn);
			tabdata.put("deciduous_grace_period_days",deciduous_grace_period_days );
			tabdata.put("bl_interface_flag",bl_interface_flag );
			if(record_gingival_status_yn.equals("Y")){
				tabdata.put("gingival_recording_by",gigival_recorded );
			}
			else{
				tabdata.put("gingival_recording_by","" );
			}

		    String gs_no_of_tooth_for_S1 = checkForNull(req.getParameter("gs_no_of_tooth_for_S1"));
			String gs_no_of_tooth_for_S2 = checkForNull(req.getParameter("gs_no_of_tooth_for_S2"));
			String gs_no_of_tooth_for_S3 = checkForNull(req.getParameter("gs_no_of_tooth_for_S3"));
			String gs_no_of_tooth_for_S4 = checkForNull(req.getParameter("gs_no_of_tooth_for_S4"));
			String gs_no_of_tooth_for_S5 = checkForNull(req.getParameter("gs_no_of_tooth_for_S5"));
			String gs_no_of_tooth_for_S6 = checkForNull(req.getParameter("gs_no_of_tooth_for_S6"));
			String gs_dflt_tooth_no_S1 = checkForNull(req.getParameter("gs_dflt_tooth_no_S1"));
			String gs_dflt_tooth_no_S2 = checkForNull(req.getParameter("gs_dflt_tooth_no_S2"));
			String gs_dflt_tooth_no_S3 = checkForNull(req.getParameter("gs_dflt_tooth_no_S3"));
			String gs_dflt_tooth_no_S4 = checkForNull(req.getParameter("gs_dflt_tooth_no_S4"));
			String gs_dflt_tooth_no_S5 = checkForNull(req.getParameter("gs_dflt_tooth_no_S5"));
			String gs_dflt_tooth_no_S6 = checkForNull(req.getParameter("gs_dflt_tooth_no_S6"));

		    //tabdata.put("facility_id",facility_id);
		    tabdata.put("gs_no_of_tooth_for_S1",gs_no_of_tooth_for_S1);
			tabdata.put("gs_no_of_tooth_for_S2",gs_no_of_tooth_for_S2);
			tabdata.put("gs_no_of_tooth_for_S3",gs_no_of_tooth_for_S3);
			tabdata.put("gs_no_of_tooth_for_S4",gs_no_of_tooth_for_S4);
			tabdata.put("gs_no_of_tooth_for_S5",gs_no_of_tooth_for_S5);
			tabdata.put("gs_no_of_tooth_for_S6",gs_no_of_tooth_for_S6);
			tabdata.put("gs_dflt_tooth_no_S1",gs_dflt_tooth_no_S1);
			tabdata.put("gs_dflt_tooth_no_S2",gs_dflt_tooth_no_S2);
			tabdata.put("gs_dflt_tooth_no_S3",gs_dflt_tooth_no_S3);
			tabdata.put("gs_dflt_tooth_no_S4",gs_dflt_tooth_no_S4);
			tabdata.put("gs_dflt_tooth_no_S5",gs_dflt_tooth_no_S5);
			tabdata.put("gs_dflt_tooth_no_S6",gs_dflt_tooth_no_S6);

			tabdata.put("gs_no_of_tooth_for_Q1","");
			tabdata.put("gs_no_of_tooth_for_Q2","");
			tabdata.put("gs_no_of_tooth_for_Q3","");
			tabdata.put("gs_no_of_tooth_for_Q4","");
			tabdata.put("gs_dflt_tooth_no_Q1","");
			tabdata.put("gs_dflt_tooth_no_Q2","");
			tabdata.put("gs_dflt_tooth_no_Q3","");
			tabdata.put("gs_dflt_tooth_no_Q4","");
		 

			tabdata.put("added_by_id",login_user);
			tabdata.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("added_facility_id", facility_id);
			tabdata.put("added_at_ws_no",client_ip_address);
			tabdata.put("modified_by_id",login_user);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",facility_id);
			tabdata.put("modified_at_ws_no",client_ip_address );

		}
	}
   
   if (gigival_recorded.equals("Q")){
		  if("modify".equals(mode)){
		    //String facility_id = checkForNull(req.getParameter("facility_id"));
		    String gs_no_of_tooth_for_Q1 = checkForNull(req.getParameter("gs_no_of_tooth_for_Q1"));
			String gs_no_of_tooth_for_Q2 = checkForNull(req.getParameter("gs_no_of_tooth_for_Q2"));
			String gs_no_of_tooth_for_Q3 = checkForNull(req.getParameter("gs_no_of_tooth_for_Q3"));
			String gs_no_of_tooth_for_Q4 = checkForNull(req.getParameter("gs_no_of_tooth_for_Q4"));
			String gs_dflt_tooth_no_Q1 = checkForNull(req.getParameter("gs_dflt_tooth_no_Q1"));
			String gs_dflt_tooth_no_Q2 = checkForNull(req.getParameter("gs_dflt_tooth_no_Q2"));
			String gs_dflt_tooth_no_Q3 = checkForNull(req.getParameter("gs_dflt_tooth_no_Q3"));
			String gs_dflt_tooth_no_Q4 = checkForNull(req.getParameter("gs_dflt_tooth_no_Q4"));
			String record_gingival_status_yn = checkForNull(req.getParameter("record_gingival_status_yn_hid"));

			if(gs_dflt_tooth_no_Q1.equals("") && record_gingival_status_yn.equals("Y")){
				gs_dflt_tooth_no_Q1 = checkForNull(req.getParameter("gs_dflt_tooth_no_Q1_hid"));
			}

			if(gs_dflt_tooth_no_Q2.equals("")&& record_gingival_status_yn.equals("Y")){
				gs_dflt_tooth_no_Q2 = checkForNull(req.getParameter("gs_dflt_tooth_no_Q2_hid"));
			}

			if(gs_dflt_tooth_no_Q3.equals("")&& record_gingival_status_yn.equals("Y")){
				gs_dflt_tooth_no_Q3 = checkForNull(req.getParameter("gs_dflt_tooth_no_Q3_hid"));
			}

			if(gs_dflt_tooth_no_Q4.equals("")&& record_gingival_status_yn.equals("Y")){
				gs_dflt_tooth_no_Q4 = checkForNull(req.getParameter("gs_dflt_tooth_no_Q4_hid"));
			}
		
            //tabdata.put("facility_id",facility_id);
            tabdata.put("gs_no_of_tooth_for_Q1",gs_no_of_tooth_for_Q1);
			tabdata.put("gs_no_of_tooth_for_Q2",gs_no_of_tooth_for_Q2);
			tabdata.put("gs_no_of_tooth_for_Q3",gs_no_of_tooth_for_Q3);
			tabdata.put("gs_no_of_tooth_for_Q4",gs_no_of_tooth_for_Q4);
			tabdata.put("gs_dflt_tooth_no_Q1",gs_dflt_tooth_no_Q1);
			tabdata.put("gs_dflt_tooth_no_Q2",gs_dflt_tooth_no_Q2);
			tabdata.put("gs_dflt_tooth_no_Q3",gs_dflt_tooth_no_Q3);
			tabdata.put("gs_dflt_tooth_no_Q4",gs_dflt_tooth_no_Q4);
		
			
			tabdata.put("modified_by_id",login_user);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",facility_id);
			tabdata.put("modified_at_ws_no",client_ip_address );
	   }
	}
	
	if (gigival_recorded.equals("S")){
		  if("modify".equals(mode)){
		   // String facility_id = checkForNull(req.getParameter("facility_id"));
			String record_gingival_status_yn = checkForNull(req.getParameter("record_gingival_status_yn_hid"));
		    String gs_no_of_tooth_for_S1 = checkForNull(req.getParameter("gs_no_of_tooth_for_S1"));
			String gs_no_of_tooth_for_S2 = checkForNull(req.getParameter("gs_no_of_tooth_for_S2"));
			String gs_no_of_tooth_for_S3 = checkForNull(req.getParameter("gs_no_of_tooth_for_S3"));
			String gs_no_of_tooth_for_S4 = checkForNull(req.getParameter("gs_no_of_tooth_for_S4"));
			String gs_no_of_tooth_for_S5 = checkForNull(req.getParameter("gs_no_of_tooth_for_S5"));
			String gs_no_of_tooth_for_S6 = checkForNull(req.getParameter("gs_no_of_tooth_for_S6"));
			String gs_dflt_tooth_no_S1 = checkForNull(req.getParameter("gs_dflt_tooth_no_S1"));
			String gs_dflt_tooth_no_S2 = checkForNull(req.getParameter("gs_dflt_tooth_no_S2"));
			String gs_dflt_tooth_no_S3 = checkForNull(req.getParameter("gs_dflt_tooth_no_S3"));
			String gs_dflt_tooth_no_S4 = checkForNull(req.getParameter("gs_dflt_tooth_no_S4"));
			String gs_dflt_tooth_no_S5 = checkForNull(req.getParameter("gs_dflt_tooth_no_S5"));
			String gs_dflt_tooth_no_S6 = checkForNull(req.getParameter("gs_dflt_tooth_no_S6"));
			if(gs_dflt_tooth_no_S1.equals("")&& record_gingival_status_yn.equals("Y")){
				gs_dflt_tooth_no_S1 = checkForNull(req.getParameter("gs_dflt_tooth_no_S1_hid"));
			}

			if(gs_dflt_tooth_no_S2.equals("")&& record_gingival_status_yn.equals("Y")){
				gs_dflt_tooth_no_S2 = checkForNull(req.getParameter("gs_dflt_tooth_no_S2_hid"));
			}

			if(gs_dflt_tooth_no_S3.equals("")&& record_gingival_status_yn.equals("Y")){
				gs_dflt_tooth_no_S3 = checkForNull(req.getParameter("gs_dflt_tooth_no_S3_hid"));
			}

			if(gs_dflt_tooth_no_S4.equals("")&& record_gingival_status_yn.equals("Y")){
				gs_dflt_tooth_no_S4 = checkForNull(req.getParameter("gs_dflt_tooth_no_S4_hid"));
			}

			if(gs_dflt_tooth_no_S5.equals("")&& record_gingival_status_yn.equals("Y")){
				gs_dflt_tooth_no_S5 = checkForNull(req.getParameter("gs_dflt_tooth_no_S5_hid"));
			}

			if(gs_dflt_tooth_no_S6.equals("")&& record_gingival_status_yn.equals("Y")){
				gs_dflt_tooth_no_S6 = checkForNull(req.getParameter("gs_dflt_tooth_no_S6_hid"));
			}


			
			//tabdata.put("facility_id",facility_id);
			tabdata.put("gs_no_of_tooth_for_S1",gs_no_of_tooth_for_S1);
			tabdata.put("gs_no_of_tooth_for_S2",gs_no_of_tooth_for_S2);
			tabdata.put("gs_no_of_tooth_for_S3",gs_no_of_tooth_for_S3);
			tabdata.put("gs_no_of_tooth_for_S4",gs_no_of_tooth_for_S4);
			tabdata.put("gs_no_of_tooth_for_S5",gs_no_of_tooth_for_S5);
			tabdata.put("gs_no_of_tooth_for_S6",gs_no_of_tooth_for_S6);
			tabdata.put("gs_dflt_tooth_no_S1",gs_dflt_tooth_no_S1);
			tabdata.put("gs_dflt_tooth_no_S2",gs_dflt_tooth_no_S2);
			tabdata.put("gs_dflt_tooth_no_S3",gs_dflt_tooth_no_S3);
			tabdata.put("gs_dflt_tooth_no_S4",gs_dflt_tooth_no_S4);
			tabdata.put("gs_dflt_tooth_no_S5",gs_dflt_tooth_no_S5);
			tabdata.put("gs_dflt_tooth_no_S6",gs_dflt_tooth_no_S6);
			
			
			tabdata.put("modified_by_id",login_user);
			tabdata.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
			tabdata.put("modified_facility_id",facility_id);
			tabdata.put("modified_at_ws_no",client_ip_address );
	   }
	
	 }
		return tabdata;
}

	private Object getRemoteObject(){
		boolean local_ejbs = isLocalEJB();
		Object busObj=null;
		try{
			Object home =com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			
			//Get the remote object by invoking create method on the home object using reflection
			busObj =	(home.getClass().getMethod("create",null)).invoke(home,null);
		}catch(Exception e){
				out.println(e.toString());
		}
		return busObj;
	}

	
	private void insert(HttpServletRequest req, HttpServletResponse res){
		//String mode = checkForNull(req.getParameter("mode"));	//Commented Against Common-ICN-0031
		HashMap tabData = populateTabData(req,res);
		String dupflds[]={"facility_id"};
		Object argArray[]  = new Object[4];
		argArray[0] = p;
		argArray[1] = tabData;				   
		argArray[2] = dupflds;
		argArray[3] = table_name;

		//Create a class array, containing the class types of the arguments passed
		Class [] paramArray	   = new Class[4];
		paramArray[0] = p.getClass();
		paramArray[1] = tabData.getClass();
		paramArray[2] = dupflds.getClass();
		paramArray[3] = table_name.getClass();
		
		try{
			Object busObj =	getRemoteObject();
			results =(HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted ){
				 error_value = "1" ;
			}else{
				 error = (String) results.get("error") ;
			}
			error = (String) results.get("error") ;
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value );
		}
		catch ( Exception e ){
			out.println(" Exception raised ...So Record Not insertedFoll: Error Received : "+e.toString());
		}
		finally
		{
			try{
				tabData.clear();	//Common-ICN-0044
		}catch(Exception e){}
		}
		
	}

	private void modify(HttpServletRequest req, HttpServletResponse res){
		//String mode = checkForNull(req.getParameter("mode"));	//Commented Against Common-ICN-0031
		HashMap tabData = populateTabData(req,res);
		HashMap condflds=new HashMap();
		condflds.put("facility_id",facility_id);
		Object argArray[]  = new Object[4];
		argArray[0] = p;
		argArray[1] = tabData;				   
		argArray[2] = condflds;
		argArray[3] = table_name;
		Class [] paramArray	   = new Class[4];
		paramArray[0] = p.getClass();
		paramArray[1] = tabData.getClass();
		paramArray[2] = condflds.getClass();
		paramArray[3] = table_name.getClass();
		try{   
			Object busObj = getRemoteObject();
			results =(HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted ){
				error_value = "1" ;
			}else{
				error = (String) results.get("error") ;
			}
       		error = (String) results.get("error") ;
    		res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error,"UTF-8" ) +"&err_value="+error_value);
		}
		catch ( Exception e ){
			out.println("<h3> Exception raised by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
		}
		finally
		{
			try{
		tabData.clear();	//Common-ICN-0044
		condflds.clear();	//Common-ICN-0044
		}catch(Exception e){}
		}
		
	}


	private String checkForNull(String str){
		return (str!=null && str.intern()!="null")?str:"";
	}

	private String checkForNull(String str,String defaultVal){
		return (!checkForNull(str).equals(""))?str:defaultVal;
	}

	private boolean isLocalEJB(){
		ServletContext servletcontext = getServletConfig().getServletContext();
		if ((servletcontext.getInitParameter("LOCAL_EJBS")!=null) &&(servletcontext.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			return true;
			return false;
	}

}
