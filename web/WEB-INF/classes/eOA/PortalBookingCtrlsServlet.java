  
package eOA;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import eDS.Common.*;


import eCommon.SingleTabHandler.*;
public class PortalBookingCtrlsServlet extends javax.servlet.http.HttpServlet
{
	PrintWriter out;
	java.util.Properties p;
	String maxBookingPerPatient				= "";
	String maxBookingPerPatientPerDay		= "";
	String advanceBookinglimitsMin			= "";   
	String advanceBookinglimitsMax			= "";   
	String alt_id1_yn						= "";                
	String alt_id2_yn						= "";                
	String alt_id3_yn						= "";                
	String alt_id4_yn						= "";                
	String nat_id_prompt_yn					= "";   
	String booking_reason					= ""; 
	String rescheduling_reason				= ""; 
	String cancelling_reason				= ""; 
	String booking_reason_change_yn			= ""; 
	String rescheduling_reason_change_yn	= ""; 
	String cancelling_reason_change_yn		= ""; 
	String mode								= "";  

	String facilityId						= "";
	String client_ip_address				= "";

											


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
			res.setContentType("application/json");
			String mode = req.getParameter("mode");

			if ( mode.equals("insert") ) insert(req,res);
			if ( mode.equals("modify"))  modify(req,res);


		}
		catch(Exception e)
		{
			out.println(e.toString());
			e.printStackTrace();
		}
	}


	private synchronized void insert(HttpServletRequest req, HttpServletResponse res) {
		JSONObject json						= new JSONObject();
		try
		{
			res.setContentType("application/json");
			
			maxBookingPerPatientPerDay		= req.getParameter("maxBookingPerPatientPerDay");
			advanceBookinglimitsMin			= req.getParameter("advanceBookinglimitsMin");
			advanceBookinglimitsMax			= req.getParameter("advanceBookinglimitsMax");
			alt_id1_yn						= req.getParameter("alt_id1_yn");
			alt_id2_yn						= req.getParameter("alt_id2_yn");
			alt_id3_yn						= req.getParameter("alt_id3_yn");
			alt_id4_yn						= req.getParameter("alt_id4_yn");
			nat_id_prompt_yn				= req.getParameter("nat_id_prompt_yn");

			booking_reason					= req.getParameter("booking_reason");
			rescheduling_reason				= req.getParameter("rescheduling_reason");
			cancelling_reason				= req.getParameter("cancelling_reason");
			booking_reason_change_yn		= req.getParameter("booking_reason_change_yn");
			rescheduling_reason_change_yn	= req.getParameter("rescheduling_reason_change_yn");
			cancelling_reason_change_yn		= req.getParameter("cancelling_reason_change_yn");
			maxBookingPerPatient			= req.getParameter("maxBookingPerPatient");
		
			


			String addedById				= p.getProperty( "login_user" ) ;
			String addedDate				= dateFormat.format( new java.util.Date() ) ;
			String addedFacilityId			= facilityId;
			String modifiedFacilityId		= addedFacilityId ;
			String modifiedById				= addedById ;
			String modifiedDate				= addedDate ;
			String addedAtWorkstation		= client_ip_address;
			String modifiedAtWorkstation	= addedAtWorkstation ;

			java.sql.Date added_date		= java.sql.Date.valueOf( addedDate ) ;
			java.sql.Date modified_date		= java.sql.Date.valueOf( modifiedDate ) ;
			

			HashMap tabdata=new HashMap();
			tabdata.put("MAX_APPT_PATIENT_PER_DAY",maxBookingPerPatientPerDay);
			tabdata.put("ADV_MIN_APPT_LIMITS",advanceBookinglimitsMin);
			tabdata.put("ADV_MAX_APPT_LIMITS",advanceBookinglimitsMax);
			tabdata.put("ALT_ID1_ENABLED_YN",alt_id1_yn);
			tabdata.put("ALT_ID2_ENABLED_YN",alt_id2_yn);
			tabdata.put("ALT_ID3_ENABLED_YN",alt_id3_yn);
			tabdata.put("ALT_ID4_ENABLED_YN",alt_id4_yn);
			tabdata.put("NAT_ID_ENABLED_YN",nat_id_prompt_yn);

			tabdata.put("BOOKING_REASON",booking_reason);
			tabdata.put("RESCHEDULING_REASON",rescheduling_reason);
			tabdata.put("CANCELLING_REASON",cancelling_reason);
			tabdata.put("BOOKING_REASON_CHANGE_YN",booking_reason_change_yn);
			tabdata.put("RESCHEDULING_REASON_CHANGE_YN",rescheduling_reason_change_yn);
			tabdata.put("CANCELLING_REASON_CHANGE_YN",cancelling_reason_change_yn);
			tabdata.put("MAX_APPT_PER_PATIENT",maxBookingPerPatient);


			
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_date",added_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			
			


			String dupflds[] = new String[0];
			String hard_val="OA_PORTAL_BOOKING_CTRLS";

			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = hard_val;


			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = hard_val.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;
			String error_value = "0" ;

			if ( inserted ){
				json.put("success","true");	
				json.put("error","");	

			}else {
				 error = (String) results.get("error") ;
				 json.put("success","fail");	
				 json.put("error",error);	
			}

			results.clear();
			tabdata.clear();
			res.getWriter().write(json.toString());
		}
		catch ( Exception e )
		{
			json.put("error"," Exception raise by Servlet ...So Record Not Inserted: Error Received : "+e.toString());
			try{
				res.setContentType("application/json");
				e.printStackTrace();
				res.getWriter().write(json.toString());

			}catch( Exception e1 ) {

			}

		}

	}

	private synchronized void  modify(HttpServletRequest req,HttpServletResponse res) {
		JSONObject json						= new JSONObject();
		try
		{

			maxBookingPerPatientPerDay		= req.getParameter("maxBookingPerPatientPerDay");
			advanceBookinglimitsMin			= req.getParameter("advanceBookinglimitsMin");
			advanceBookinglimitsMax			= req.getParameter("advanceBookinglimitsMax");
			alt_id1_yn						= req.getParameter("alt_id1_yn");
			alt_id2_yn						= req.getParameter("alt_id2_yn");
			alt_id3_yn						= req.getParameter("alt_id3_yn");
			alt_id4_yn						= req.getParameter("alt_id4_yn");
			nat_id_prompt_yn				= req.getParameter("nat_id_prompt_yn");
			booking_reason					= req.getParameter("booking_reason");
			rescheduling_reason				= req.getParameter("rescheduling_reason");
			cancelling_reason				= req.getParameter("cancelling_reason");
			booking_reason_change_yn		= req.getParameter("booking_reason_change_yn");
			rescheduling_reason_change_yn	= req.getParameter("rescheduling_reason_change_yn");
			cancelling_reason_change_yn		= req.getParameter("cancelling_reason_change_yn");
			maxBookingPerPatient			= req.getParameter("maxBookingPerPatient");
	
			String addedById = p.getProperty( "login_user" ) ;
			String addedDate = dateFormat.format( new java.util.Date() ) ;
			String modifiedById = addedById ;
			String modifiedDate = addedDate ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			java.sql.Date modified_date = java.sql.Date.valueOf( modifiedDate ) ;

			

			HashMap tabdata=new HashMap();
			tabdata.put("MAX_APPT_PATIENT_PER_DAY",maxBookingPerPatientPerDay);
			tabdata.put("ADV_MIN_APPT_LIMITS",advanceBookinglimitsMin);
			tabdata.put("ADV_MAX_APPT_LIMITS",advanceBookinglimitsMax);
			tabdata.put("ALT_ID1_ENABLED_YN",alt_id1_yn);
			tabdata.put("ALT_ID2_ENABLED_YN",alt_id2_yn);
			tabdata.put("ALT_ID3_ENABLED_YN",alt_id3_yn);
			tabdata.put("ALT_ID4_ENABLED_YN",alt_id4_yn);
			tabdata.put("NAT_ID_ENABLED_YN",nat_id_prompt_yn);
			tabdata.put("BOOKING_REASON",booking_reason);
			tabdata.put("RESCHEDULING_REASON",rescheduling_reason);
			tabdata.put("CANCELLING_REASON",cancelling_reason);
			tabdata.put("BOOKING_REASON_CHANGE_YN",booking_reason_change_yn);
			tabdata.put("RESCHEDULING_REASON_CHANGE_YN",rescheduling_reason_change_yn);
			tabdata.put("CANCELLING_REASON_CHANGE_YN",cancelling_reason_change_yn);
			tabdata.put("MAX_APPT_PER_PATIENT",maxBookingPerPatient);
			tabdata.put("added_by_id",addedById);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no",addedAtWorkstation);
			tabdata.put("modified_by_id",modifiedById);
			tabdata.put("modified_date",modified_date);
			tabdata.put("modified_facility_id",modifiedFacilityId);
			tabdata.put("modified_at_ws_no",modifiedAtWorkstation );

			
			HashMap condflds=new HashMap();
			String hard_val="OA_PORTAL_BOOKING_CTRLS";
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = hard_val;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = hard_val.getClass();
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			
			String error = (String) results.get("error") ;
			if ( inserted ){
				json.put("success","true");	
				json.put("error","");	

			}else {
				 error = (String) results.get("error") ;
				 json.put("success","fail");	
				 json.put("error",error);	
			}
			condflds.clear();
			results.clear();
			tabdata.clear();
			res.getWriter().write(json.toString());
		}
		catch ( Exception e )
		{
			json.put("error"," Exception raise by Servlet ...So Record Not Inserted: Error Received : "+e.toString());
			try{
				res.setContentType("application/json");
				e.printStackTrace();
				res.getWriter().write(json.toString());

			}catch( Exception e1 ) {

			}
		}
	}


} 