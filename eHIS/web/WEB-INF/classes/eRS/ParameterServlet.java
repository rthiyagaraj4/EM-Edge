/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eRS;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import eCommon.Common.*;
import eCommon.SingleTabHandler.*;
import webbeans.eCommon.*;

public class ParameterServlet extends HttpServlet implements SingleThreadModel{

	private ServletConfig config = null;
	PrintWriter out = null;
	HttpSession session = null;
	String facility_id = "";
	Properties p = new Properties();
	String client_ip_address = "";
	boolean inserted= false;
    boolean delete= false;

	String fac_id = "";
	String overlap_shifts_in_workplace_yn= "";
	String work_cycle_basis="";
	String period_for_work_schedule_gen="";
	String max_continuous_work_duration = "";
	String max_continuous_work_duration1 = "";
	String max_continuous_work_duration2 = "";
	String staff_subs_same_grade_yn = "";
	String staff_subs_high_to_low_yn = "";
	String staff_subs_low_to_high_yn = "";
	String attendance_feature_reqd_yn = "";
	String max_durn_to_mark_attendance= "";
	String vald_staff_acc_by_work_sch_yn = "";
	String vald_staff_acc_by_att_yn = "";
	String curr_shift_allocation_yn= "";
	String curr_shift_change_yn="";
	String curr_shift_cancellation_yn="";
	String curr_shift_transfer_yn= "";
	String curr_shift_swap_yn="";
	String curr_shift_overtime_yn="";
	String curr_shift_leave_yn = "";
	String durn_for_allocation_from_sos = "";
	String durn_for_change_from_sos = "";
	String durn_for_transfer_from_sos = "";
	String durn_for_swap_from_sos = "";
	String durn_for_overtime_from_sos= "";
	String durn_for_leave_from_sos= "";
	String durn_for_cancel_from_sos="";

	String max_durn_to_mark_attendance1= "";
	String max_durn_to_mark_attendance2= "";
	String durn_for_allocation_from_sos1 = "";
	String durn_for_change_from_sos1 = "";
	String durn_for_transfer_from_sos1= "";
	String durn_for_swap_from_sos1 = "";
	String durn_for_overtime_from_sos1= "";
	String durn_for_leave_from_sos1= "";
	String durn_for_cancel_from_sos1="";

	String durn_for_allocation_from_sos2 = "";
	String durn_for_change_from_sos2 = "";
	String durn_for_transfer_from_sos2 = "";
	String durn_for_swap_from_sos2 = "";
	String durn_for_overtime_from_sos2= "";
	String durn_for_leave_from_sos2= "";
	String durn_for_cancel_from_sos2="";
	String added_by_id = "";
	
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "yyyy-MM-dd" ) ;	
	
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{

			req.setCharacterEncoding("UTF-8");
		    res.setContentType("text/html;charset=UTF-8"); 

			this.out = res.getWriter();
			try{
					session = req.getSession(false);
					this.facility_id = (String) session.getAttribute( "facility_id" ) ;
					this.p = (java.util.Properties) session.getAttribute( "jdbc" ) ;
					this.client_ip_address = p.getProperty("client_ip_address");

					fac_id = req.getParameter("facility_id")==null ? "":req.getParameter("facility_id");

					overlap_shifts_in_workplace_yn = req.getParameter("overlap_shifts_in_workplace_yn")==null ? "N":req.getParameter("overlap_shifts_in_workplace_yn");
					work_cycle_basis = req.getParameter("work_cycle_basis")==null ? "":req.getParameter("work_cycle_basis");
					period_for_work_schedule_gen=req.getParameter("period_for_work_schedule_gen")==null ? "":req.getParameter("period_for_work_schedule_gen");
					max_continuous_work_duration1 = req.getParameter("max_continuous_work_duration1")==null ? "00":req.getParameter("max_continuous_work_duration1");
					max_continuous_work_duration2 = req.getParameter("max_continuous_work_duration2")==null ? "00":req.getParameter("max_continuous_work_duration2");
					staff_subs_same_grade_yn = req.getParameter("staff_subs_same_grade_yn")==null ? "N":req.getParameter("staff_subs_same_grade_yn");
					staff_subs_high_to_low_yn = req.getParameter("staff_subs_high_to_low_yn")==null ? "N":req.getParameter("staff_subs_high_to_low_yn");
					staff_subs_low_to_high_yn = req.getParameter("staff_subs_low_to_high_yn")==null ? "N":req.getParameter("staff_subs_low_to_high_yn");
					attendance_feature_reqd_yn = req.getParameter("attendance_feature_reqd_yn")==null ? "N":req.getParameter("attendance_feature_reqd_yn");
					max_durn_to_mark_attendance1 = req.getParameter("max_durn_to_mark_attendance1")==null ? "N":req.getParameter("max_durn_to_mark_attendance1");
					max_durn_to_mark_attendance2 = req.getParameter("max_durn_to_mark_attendance2")==null ? "N":req.getParameter("max_durn_to_mark_attendance2");
					vald_staff_acc_by_work_sch_yn = req.getParameter("vald_staff_acc_by_work_sch_yn")==null ? "N":req.getParameter("vald_staff_acc_by_work_sch_yn");
					vald_staff_acc_by_att_yn = req.getParameter("vald_staff_acc_by_att_yn")==null ? "N":req.getParameter("vald_staff_acc_by_att_yn");
					curr_shift_allocation_yn = req.getParameter("curr_shift_allocation_yn")==null ? "N":req.getParameter("curr_shift_allocation_yn");
					curr_shift_change_yn = req.getParameter("curr_shift_change_yn")==null ? "N":req.getParameter("curr_shift_change_yn");
					curr_shift_cancellation_yn = req.getParameter("curr_shift_cancellation_yn")==null ? "N":req.getParameter("curr_shift_cancellation_yn");
					curr_shift_transfer_yn = req.getParameter("curr_shift_transfer_yn")==null ? "N":req.getParameter("curr_shift_transfer_yn");
					curr_shift_swap_yn = req.getParameter("curr_shift_swap_yn")==null ? "N":req.getParameter("curr_shift_swap_yn");
					curr_shift_overtime_yn = req.getParameter("curr_shift_overtime_yn")==null ? "N":req.getParameter("curr_shift_overtime_yn");
					curr_shift_leave_yn = req.getParameter("curr_shift_leave_yn")==null ? "N":req.getParameter("curr_shift_leave_yn");

					if(curr_shift_allocation_yn.equals("Y")){
						durn_for_allocation_from_sos1 = req.getParameter("durn_for_allocation_from_sos1")==null ? "00":req.getParameter("durn_for_allocation_from_sos1");
						durn_for_allocation_from_sos2 = req.getParameter("durn_for_allocation_from_sos2")==null ? "":req.getParameter("durn_for_allocation_from_sos2");
					}else{
						durn_for_allocation_from_sos1="";
						durn_for_allocation_from_sos2="";
					}

					if(curr_shift_change_yn.equals("Y")){
						durn_for_change_from_sos1 = req.getParameter("durn_for_change_from_sos1")==null ? "00":req.getParameter("durn_for_change_from_sos1");
						durn_for_change_from_sos2 = req.getParameter("durn_for_change_from_sos2")==null ? "":req.getParameter("durn_for_change_from_sos2");
					}else{
						durn_for_change_from_sos1="";
						durn_for_change_from_sos2="";
					}

					if(curr_shift_transfer_yn.equals("Y")){
						durn_for_transfer_from_sos1 = req.getParameter("durn_for_transfer_from_sos1")==null ? "00":req.getParameter("durn_for_transfer_from_sos1");
						durn_for_transfer_from_sos2 = req.getParameter("durn_for_transfer_from_sos2")==null ? "":req.getParameter("durn_for_transfer_from_sos2");
					}else{
						durn_for_transfer_from_sos1="";
						durn_for_transfer_from_sos2="";
					}

					if(curr_shift_swap_yn.equals("Y")){
						durn_for_swap_from_sos1 = req.getParameter("durn_for_swap_from_sos1")==null ? "00":req.getParameter("durn_for_swap_from_sos1");
						durn_for_swap_from_sos2 = req.getParameter("durn_for_swap_from_sos2")==null ? "":req.getParameter("durn_for_swap_from_sos2");
					}else{
						durn_for_swap_from_sos1="";
						durn_for_swap_from_sos2="";
					}

					if(curr_shift_overtime_yn.equals("Y")){
						durn_for_overtime_from_sos1 = req.getParameter("durn_for_overtime_from_sos1")==null ? "00":req.getParameter("durn_for_overtime_from_sos1");
						durn_for_overtime_from_sos2 = req.getParameter("durn_for_overtime_from_sos2")==null ? "":req.getParameter("durn_for_overtime_from_sos2");
					}else{
						durn_for_overtime_from_sos1="";
						durn_for_overtime_from_sos2="";
					}

					if(curr_shift_leave_yn.equals("Y")){
						durn_for_leave_from_sos1 = req.getParameter("durn_for_leave_from_sos1")==null ? "00":req.getParameter("durn_for_leave_from_sos1");
						durn_for_leave_from_sos2 = req.getParameter("durn_for_leave_from_sos2")==null ? "":req.getParameter("durn_for_leave_from_sos2");
					}else{
						durn_for_leave_from_sos1="";
						durn_for_leave_from_sos2="";
					}

					if(curr_shift_cancellation_yn.equals("Y")){
						durn_for_cancel_from_sos1 = req.getParameter("durn_for_cancel_from_sos1")==null ? "00":req.getParameter("durn_for_cancel_from_sos1");
						durn_for_cancel_from_sos2 = req.getParameter("durn_for_cancel_from_sos2")==null ? "":req.getParameter("durn_for_cancel_from_sos2");
					}else{
						durn_for_cancel_from_sos1="";
						durn_for_cancel_from_sos2="";
					}
	
					if(!max_continuous_work_duration2.equals(""))
						max_continuous_work_duration=max_continuous_work_duration1+":"+max_continuous_work_duration2;
					else
						max_continuous_work_duration="";

					if(!max_durn_to_mark_attendance2.equals(""))
						max_durn_to_mark_attendance=max_durn_to_mark_attendance1+":"+max_durn_to_mark_attendance2;
					else
						max_durn_to_mark_attendance="";

					if(!durn_for_allocation_from_sos2.equals(""))
						durn_for_allocation_from_sos=durn_for_allocation_from_sos1+":"+durn_for_allocation_from_sos2;
					else
						durn_for_allocation_from_sos="";

					if(!durn_for_change_from_sos2.equals(""))
						durn_for_change_from_sos=durn_for_change_from_sos1+":"+durn_for_change_from_sos2;
					else
						durn_for_change_from_sos2="";

					if(!durn_for_transfer_from_sos2.equals(""))
						durn_for_transfer_from_sos = durn_for_transfer_from_sos1+":"+durn_for_transfer_from_sos2;
					else
						durn_for_transfer_from_sos="";

					if(!durn_for_swap_from_sos2.equals(""))
						durn_for_swap_from_sos = durn_for_swap_from_sos1+":"+durn_for_swap_from_sos2;
					else
						durn_for_swap_from_sos="";

					if(!durn_for_overtime_from_sos2.equals(""))
						durn_for_overtime_from_sos= durn_for_overtime_from_sos1+":"+durn_for_overtime_from_sos2;
					else
						durn_for_overtime_from_sos="";

					if(!durn_for_leave_from_sos2.equals(""))
						durn_for_leave_from_sos= durn_for_leave_from_sos1+":"+durn_for_leave_from_sos2;
					else
						durn_for_leave_from_sos="";

					if(!durn_for_cancel_from_sos2.equals(""))
						durn_for_cancel_from_sos=durn_for_cancel_from_sos1+":"+durn_for_cancel_from_sos2;
					else
						durn_for_cancel_from_sos="";
					
					String operation = req.getParameter("operation_type");
				if ( operation.equals("insert")) 
						insertOperation(res);
					if ( operation.equals("modify")) 
						modifyOperation(res);
					if ( operation.equals("Delete")) 
						deleteOperation(res);
			}catch(Exception e){
				e.printStackTrace();
			}
	}

	public void insertOperation(HttpServletResponse res) throws Exception{
				
		try{
			HashMap tabdata=new HashMap();	
			String addeddate = dateFormat.format( new java.util.Date() ) ;
			facility_id = (String) session.getAttribute( "facility_id" ) ;
			added_by_id 	= p.getProperty( "login_user" ) ;

			tabdata.put("facility_id",fac_id);
			tabdata.put("overlap_shifts_in_workplace_yn",overlap_shifts_in_workplace_yn);
			tabdata.put("work_cycle_basis",work_cycle_basis);
			tabdata.put("period_for_work_schedule_gen",period_for_work_schedule_gen);
			tabdata.put("max_continuous_work_duration",max_continuous_work_duration);
			tabdata.put("staff_subs_same_grade_yn",staff_subs_same_grade_yn);
			tabdata.put("staff_subs_high_to_low_yn",staff_subs_high_to_low_yn);
			tabdata.put("staff_subs_low_to_high_yn",staff_subs_low_to_high_yn);
			tabdata.put("attendance_feature_reqd_yn",attendance_feature_reqd_yn);
			tabdata.put("max_durn_to_mark_attendance",max_durn_to_mark_attendance);
			tabdata.put("vald_staff_acc_by_work_sch_yn",vald_staff_acc_by_work_sch_yn);
			tabdata.put("vald_staff_acc_by_att_yn",vald_staff_acc_by_att_yn);
			tabdata.put("curr_shift_allocation_yn",curr_shift_allocation_yn);
			tabdata.put("curr_shift_change_yn",curr_shift_change_yn);
			tabdata.put("curr_shift_cancellation_yn",curr_shift_cancellation_yn);
			tabdata.put("curr_shift_transfer_yn",curr_shift_transfer_yn);
			tabdata.put("curr_shift_swap_yn",curr_shift_swap_yn);
			tabdata.put("curr_shift_overtime_yn",curr_shift_overtime_yn);
			tabdata.put("curr_shift_leave_yn",curr_shift_leave_yn);
			tabdata.put("durn_for_allocation_from_sos",durn_for_allocation_from_sos);
			tabdata.put("durn_for_change_from_sos",durn_for_change_from_sos);
			tabdata.put("durn_for_transfer_from_sos",durn_for_transfer_from_sos);
			tabdata.put("durn_for_swap_from_sos",durn_for_swap_from_sos);
			tabdata.put("durn_for_overtime_from_sos",durn_for_overtime_from_sos);
			tabdata.put("durn_for_leave_from_sos",durn_for_leave_from_sos);
			tabdata.put("durn_for_cancel_from_sos",durn_for_cancel_from_sos);
			tabdata.put("ADDED_BY_ID", added_by_id);
			tabdata.put("ADDED_DATE", addeddate);
			tabdata.put("ADDED_AT_WS_NO",  client_ip_address);
			tabdata.put("ADDED_FACILITY_ID",  facility_id);
			tabdata.put("MODIFIED_BY_ID", added_by_id);
			tabdata.put("MODIFIED_DATE", addeddate);
			tabdata.put("MODIFIED_AT_WS_NO", client_ip_address);
			tabdata.put("MODIFIED_FACILITY_ID", facility_id);
			String dupflds[]={"facility_id"};		
			try{
				/*InitialContext context = new InitialContext();
				Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
				final SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
				final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();

				final java.util.HashMap results = singleTabHandlerManagerRemote.insert(p,tabdata,dupflds,"rs_parameter");
				*/
				boolean local_ejbs = false;
				ServletContext context = getServletConfig().getServletContext();
				if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				Object argArray[] = new Object[4];
				String table_name="rs_parameter";
				argArray[0] =p;
				argArray[1] =tabdata;
				argArray[2] =dupflds;
				argArray[3] =table_name;

				Class [] paramArray = new Class[4];
				paramArray[0] =p.getClass();
				paramArray[1] =tabdata.getClass();
				paramArray[2] =dupflds.getClass();
				paramArray[3] =table_name.getClass();
				
				HashMap results = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
				String error_value = "0" ;

	    		   if ( inserted ){
					    error_value= "1";
		     			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
	        	   }
		     	   else{
						res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
		     	   }
		     }catch(Exception e){
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

	public void modifyOperation(HttpServletResponse res)	throws Exception{

		try{

			HashMap tabdata=new HashMap();
			String addeddate = dateFormat.format( new java.util.Date() ) ;
			facility_id = (String) session.getAttribute( "facility_id" ); 
			added_by_id 	= p.getProperty( "login_user" ) ;
		
			tabdata.put("overlap_shifts_in_workplace_yn",overlap_shifts_in_workplace_yn);
			tabdata.put("work_cycle_basis",work_cycle_basis);
			tabdata.put("period_for_work_schedule_gen",period_for_work_schedule_gen);
			tabdata.put("max_continuous_work_duration",max_continuous_work_duration);
			tabdata.put("staff_subs_same_grade_yn",staff_subs_same_grade_yn);
			tabdata.put("staff_subs_high_to_low_yn",staff_subs_high_to_low_yn);
			tabdata.put("staff_subs_low_to_high_yn",staff_subs_low_to_high_yn);
			tabdata.put("attendance_feature_reqd_yn",attendance_feature_reqd_yn);
			tabdata.put("max_durn_to_mark_attendance",max_durn_to_mark_attendance);
			tabdata.put("vald_staff_acc_by_work_sch_yn",vald_staff_acc_by_work_sch_yn);
			tabdata.put("vald_staff_acc_by_att_yn",vald_staff_acc_by_att_yn);
			tabdata.put("curr_shift_allocation_yn",curr_shift_allocation_yn);
			tabdata.put("curr_shift_change_yn",curr_shift_change_yn);
			tabdata.put("curr_shift_cancellation_yn",curr_shift_cancellation_yn);
		//	tabdata.put("curr_shift_absence_yn",curr_shift_absence_yn);
		//	tabdata.put("curr_shift_partial_att_yn",curr_shift_partial_att_yn);
			tabdata.put("curr_shift_transfer_yn",curr_shift_transfer_yn);
			tabdata.put("curr_shift_swap_yn",curr_shift_swap_yn);
			tabdata.put("curr_shift_overtime_yn",curr_shift_overtime_yn);
			tabdata.put("curr_shift_leave_yn",curr_shift_leave_yn);
			tabdata.put("durn_for_allocation_from_sos",durn_for_allocation_from_sos);
			tabdata.put("durn_for_change_from_sos",durn_for_change_from_sos);
			tabdata.put("durn_for_transfer_from_sos",durn_for_transfer_from_sos);
			tabdata.put("durn_for_swap_from_sos",durn_for_swap_from_sos);
			tabdata.put("durn_for_overtime_from_sos",durn_for_overtime_from_sos);
		//	tabdata.put("durn_for_partial_att_from_sos",durn_for_partial_att_from_sos);
			//tabdata.put("durn_for_absence_from_sos",durn_for_absence_from_sos);
			tabdata.put("durn_for_leave_from_sos",durn_for_leave_from_sos);
			tabdata.put("durn_for_cancel_from_sos",durn_for_cancel_from_sos);
			tabdata.put("MODIFIED_BY_ID", added_by_id);
			tabdata.put("MODIFIED_DATE", addeddate);
			tabdata.put("MODIFIED_AT_WS_NO", client_ip_address);
			tabdata.put("MODIFIED_FACILITY_ID", facility_id);				

			HashMap condflds=new HashMap();
			condflds.put("facility_id",fac_id);	
			try{
			
				/*InitialContext context = new InitialContext();
				Object homeObject = context.lookup("java:comp/env/SingleTabHandler");
				final SingleTabHandlerManagerHome singleTabHandlerManagerHome  = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeObject ,SingleTabHandlerManagerHome.class);
				final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singleTabHandlerManagerHome.create();

				final java.util.HashMap results = singleTabHandlerManagerRemote.update(p,tabdata,condflds,"rs_parameter");
				*/
				boolean local_ejbs = false;
				ServletContext context = getServletConfig().getServletContext();
				if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
				local_ejbs = true;
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
				Object argArray[] = new Object[4];
				String table_name="rs_parameter";
				argArray[0] =p;
				argArray[1] =tabdata;
				argArray[2] =condflds;
				argArray[3] =table_name;

				Class [] paramArray = new Class[4];
				paramArray[0] =p.getClass();
				paramArray[1] =tabdata.getClass();
				paramArray[2] =condflds.getClass();
				paramArray[3] =table_name.getClass();
				
				HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
				String error = (String) results.get("error") ;
				String error_value = "0" ;
				if ( inserted ){
					error_value= "1";
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
				}else{
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
				}					   
		     }catch(Exception e){
					e.printStackTrace();
					String error = "Error ";
					String error_value = "0" ;
					res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
			}
	  }catch ( Exception e ){
			e.printStackTrace();
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+e.toString());
      }
  } // End of the modifyParameter

	private void deleteOperation(HttpServletResponse res){

		facility_id=(String)session.getAttribute("facility_id"); 
		added_by_id 	= p.getProperty( "login_user" ) ;

        try{
			HashMap hashtable = new HashMap();
	        hashtable.put("facility_id",fac_id);
			/*InitialContext initialcontext = new InitialContext();
			Object obj = initialcontext.lookup("java:comp/env/SingleTabHandler");
			final SingleTabHandlerManagerHome singletabhandlermanagerhome = (SingleTabHandlerManagerHome)PortableRemoteObject.narrow(obj, eCommon.SingleTabHandler.SingleTabHandlerManagerHome.class);
			final SingleTabHandlerManagerRemote singletabhandlermanagerremote = singletabhandlermanagerhome.create();
			final java.util.HashMap results = singletabhandlermanagerremote.delete(p, hashtable, "rs_parameter");
			*/
			boolean local_ejbs = false;
			ServletContext context = getServletConfig().getServletContext();
			if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) 
			local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[3];
			String table_name="rs_parameter";
			argArray[0] =p;
			argArray[1] =hashtable;
			argArray[2] =table_name;

			Class [] paramArray = new Class[3];
			paramArray[0] =p.getClass();
			paramArray[1] =hashtable.getClass();
			paramArray[2] =table_name.getClass();
			
			HashMap results = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			delete = ((Boolean)results.get("status")).booleanValue();
			String error = (String)results.get("error");
			String error_value = "0";
			if(delete){
				error_value = "1";
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );
			}else{
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error ) + "&err_value=" + error_value );                }
		}

        catch(Exception exception){
            out.println("<h3> Exception raise by Servlet ...So Record Not Deleted foll: Error Received : " + exception.toString());
            out.println("Values sent are : <br>");
        }
    }
}
