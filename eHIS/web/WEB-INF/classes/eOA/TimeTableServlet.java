/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOA;


import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import eOA.TimeTable.*;

public class TimeTableServlet extends javax.servlet.http.HttpServlet
{
		PrintWriter out;
		java.util.Properties p;
		String p_clinic_code="",p_day_no="",p_practitioner_id="",p_time_table_type="",p_remarks="",p_start_time="",p_end_time="",p_time_per_patient="",p_max_patients_per_day="",p_time_per_slab="",p_max_patients_per_slab="",p_max_first_visits="",b_max_slots_for_first_visit="",p_max_over_bookings="",p_phys_roster_reqd_yn="",p_break_time_intervals="",facilityId="",client_ip_address="" ;
		String final_string="",alcn_basis="",b_max_slots_per_day="",b_max_other_visits="",p_resource_type = "",p_forced_allowed_yn = "",p_no_forced_booking = "",p_no_global_ref = "",location="",operation="",p_break_time_1_from="",p_break_time_1_to="",p_break_time_2_from="",p_break_time_2_to="",p_break_time_3_from="",p_break_time_3_to="",p_break_time_4_from="",p_break_time_4_to="",p_break_time_5_from="",p_break_time_5_to="",strVar="",p_alcn_criteria="";

		String schedule_extend_yn = "N";//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112

		//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
		String ext_all_slots_yn = "N";
		String ext_start_slots = "";
		String ext_mid_slots = "";
		String ext_end_slots = "";

		HttpSession session;
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
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
		    operation = req.getParameter("fmode");
			if(operation==null) operation="";
			if(!operation.equals("COPY")){
				String p_clinic_code1 			=	req.getParameter("location") ;
				StringTokenizer token = new StringTokenizer(p_clinic_code1, "$");
				 p_clinic_code=token.nextToken();
				p_day_no 				=	req.getParameter("b_day") ;
			}
			p_practitioner_id 		=	req.getParameter("practitioner") ;
			if(p_practitioner_id == null || p_practitioner_id.equals("null"))
			p_practitioner_id ="";
			if(p_day_no == null || p_day_no.equals("null"))	
			p_day_no ="";
			p_resource_type = req.getParameter("resourceType");
			if(p_resource_type == null || p_resource_type.equals("null"))
			p_resource_type ="";
            location = req.getParameter("location_type")==null?"":req.getParameter("location_type");

			//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112
			schedule_extend_yn = req.getParameter("schedule_extend_yn")==null?"N":req.getParameter("schedule_extend_yn");

			//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
			ext_all_slots_yn = req.getParameter("ext_all_slots_yn")==null?"N":req.getParameter("ext_all_slots_yn");
			ext_start_slots = req.getParameter("ext_start_slots") ==null?"":req.getParameter("ext_start_slots");
			ext_mid_slots = req.getParameter("ext_mid_slots") ==null?"":req.getParameter("ext_mid_slots");
			ext_end_slots = req.getParameter("ext_end_slots") ==null?"":req.getParameter("ext_end_slots");

          	if ( operation.equals("delete")){
				deleteTimeTable(req);
			}else if (operation.equals("COPY")){
				copyTimeTable(req);
			}else{
				insertTimeTableforAll(req);
			}
		}
		catch(Exception e)
		{
			//out.println("excep :" +e.toString());
			e.printStackTrace();
		}
	}
	private synchronized void deleteTimeTable(HttpServletRequest req)
	{
		try
		{
			String p_clinic_code1 			=	req.getParameter("location") ;
			StringTokenizer token = new StringTokenizer(p_clinic_code1, "$");
			 p_clinic_code=token.nextToken();
			p_day_no 				=	req.getParameter("b_day") ;
			String day_val="";
			String function_mode =req.getParameter("function_mode")==null?"":req.getParameter("function_mode");
			if(function_mode.equals("modify")){ 
				day_val=req.getParameter("day_no_modify") ;
			}else{
				day_val=req.getParameter("b_day") ;
			}
			/*String day_val="";
		if(p_day_no.equals("Monday"))
			{
				day_val="1";
			}else if(p_day_no.equals("Tuesday"))
			{
				day_val="2";
			}else if(p_day_no.equals("Wednesday"))
			{
				day_val="3";
			}else if(p_day_no.equals("Thursday"))
			{
				day_val="4";
			}else if(p_day_no.equals("Friday"))
			{
				day_val="5";
			}else if(p_day_no.equals("Saturday"))
			{
				day_val="6";
			}else if(p_day_no.equals("Sunday"))
			{
				day_val="7";
			}else{
				day_val="*A";
			}*/
		
			String practitioner_id 		=	req.getParameter("practitioner") ;
			if(practitioner_id == null || practitioner_id.equals("null"))
				p_practitioner_id ="";
			else
				p_practitioner_id = practitioner_id;
			
			p_resource_type = req.getParameter("resourceType");
			if(p_resource_type == null || p_resource_type.equals("null")) p_resource_type ="";
			String addedFacilityId=facilityId;
			String addedAtWorkstation=client_ip_address;
			java.util.HashMap passObjects = new java.util.HashMap(); 
			passObjects.put("addedFacilityId",addedFacilityId);
			passObjects.put("p_clinic_code",p_clinic_code);
			passObjects.put("p_day_no",day_val);
			passObjects.put("p_practitioner_id",p_practitioner_id);
			passObjects.put("addedFacilityId",addedFacilityId);
			passObjects.put("addedAtWorkstation",addedAtWorkstation);
			passObjects.put("location",location);
			passObjects.put("p_resource_type",p_resource_type);


				
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/TimeTable",TimeTableHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = passObjects;
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = passObjects.getClass();
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("deleteTimeTable",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			 boolean modified = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			if ( modified )
			{
 				out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+ "\"</script>");
			}
			else
			{
				 error = (String) results.get("error") ;
 				out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+ "\"</script>");
			}
			results.clear();
			passObjects.clear();
		}catch ( Exception e )
		{
		//out.println( "Exception Raised : " + e );
		e.printStackTrace();
		}
	}
private synchronized void insertTimeTableforAll(HttpServletRequest req)
	{
		try
		{
			int loop_count=1;
			String final_alcn_criteria 		=	req.getParameter("final_alcn_criteria")==null?"":req.getParameter("final_alcn_criteria") ;
			p_time_table_type 		=	req.getParameter("time_table_type")==null?"":req.getParameter("time_table_type") ;
			p_remarks 				=	req.getParameter("remarks")==null?"":req.getParameter("remarks");
			p_start_time 			=	req.getParameter("start_time")==null?"":req.getParameter("start_time") ;
			p_end_time 				=	req.getParameter("end_time")==null?"":req.getParameter("end_time") ;
			p_time_per_patient 		=	req.getParameter("time_per_patient")==null?"":req.getParameter("time_per_patient") ;
			p_max_patients_per_day 	=	req.getParameter("max_patients_per_day")==null?"":req.getParameter("max_patients_per_day") ;
			p_time_per_slab 		=	req.getParameter("time_per_slab")==null?"":req.getParameter("time_per_slab") ;
			p_max_patients_per_slab =	req.getParameter("max_patients_per_slab")==null?"":req.getParameter("max_patients_per_slab") ;		
			p_max_first_visits 		=	req.getParameter("max_first_visit")==null?"0":req.getParameter("max_first_visit") ;			
			p_max_over_bookings		=	req.getParameter("max_over_bookings")==null?"":req.getParameter("max_over_bookings") ;			
			p_phys_roster_reqd_yn 	=	req.getParameter("b_roster_reqd")==null?"":req.getParameter("b_roster_reqd") ;
			p_break_time_intervals  =   req.getParameter("ftotstr")==null?"": req.getParameter("ftotstr");
			
			b_max_slots_for_first_visit=   req.getParameter("b_max_slots_for_first_visit")==null?"":req.getParameter("b_max_slots_for_first_visit");
			
			final_string=   req.getParameter("final_string")==null?"": req.getParameter("final_string");
			
			p_alcn_criteria=   req.getParameter("alcn_criteria")==null?"":req.getParameter("alcn_criteria");
			
			b_max_slots_per_day=   req.getParameter("l_max_pat_per_slot")==null?"0":req.getParameter("l_max_pat_per_slot");

			//if(p_time_table_type.equals("2"))//Added by S.Sathish for IN020308 on Thursday, April 01, 2010
				//b_max_other_visits=p_max_patients_per_day;
			//else			
				b_max_other_visits=   req.getParameter("max_other_visits")==null?"0":req.getParameter("max_other_visits");			
			
			
				
			p_forced_allowed_yn =	req.getParameter("forced_book_YN")==null?"N":req.getParameter("forced_book_YN");
			
			p_no_forced_booking =	req.getParameter("no_of_forced_booking")==null?"0":req.getParameter("no_of_forced_booking");
			
			p_no_global_ref		=	req.getParameter("no_of_global_booking")==null?"0":req.getParameter("no_of_global_booking");
			String max_new_patients		=	req.getParameter("max_new_patients")==null?"0":req.getParameter("max_new_patients");
			String max_old_patients		=	req.getParameter("max_old_patients")==null?"0":req.getParameter("max_old_patients");

			String finalString="";
			int cnt=0;			
			if(!final_alcn_criteria.equals("")){
					StringTokenizer str1=new StringTokenizer(final_alcn_criteria,"|");
					StringTokenizer valToken=null;
					while(str1.hasMoreTokens()){
						cnt++;
						valToken=new StringTokenizer(str1.nextToken(),"$");
						String code=valToken.nextToken();
						String no_of_slots=valToken.nextToken();
						String desc=valToken.nextToken();
						if(code.equals("OTH")){
						}else{
							if(cnt==1){
								finalString=code+"~"+desc+"~"+no_of_slots;
							}else{
								finalString=finalString+"|"+code+"~"+desc+"~"+no_of_slots;
							}
							
						}
						//finalStr
					}
			}


		
			if (final_string==null) final_string ="";
			else
				final_string=finalString+"|*O~0";
			alcn_basis=   req.getParameter("alcn_basis");
			if(alcn_basis ==null) alcn_basis="";
			strVar="";
			loop_count=1;
			p_break_time_1_from="";
			p_break_time_1_to="";
			p_break_time_2_from="";
			p_break_time_2_to="";
			p_break_time_3_from="";
			p_break_time_3_to="";
			p_break_time_4_from="";
			p_break_time_4_to="";
			p_break_time_5_from="";
			p_break_time_5_to="";


			StringTokenizer toks =new StringTokenizer (p_break_time_intervals,",") ;
			
			while (toks.hasMoreTokens())
			{
			strVar = toks.nextToken() ;
			if(loop_count==1){
				p_break_time_1_from = strVar.substring(0,5) ;
				if(p_break_time_1_from==null || p_break_time_1_from.equals("")) p_break_time_1_from="";
				p_break_time_1_to = strVar.substring(5,strVar.length()) ;
				if(p_break_time_1_to==null || p_break_time_1_to.equals("")) p_break_time_1_to="";
			}
			if(loop_count==2){
				p_break_time_2_from = strVar.substring(0,5) ;
				if(p_break_time_2_from==null || p_break_time_2_from.equals("")) p_break_time_2_from="";
				p_break_time_2_to = strVar.substring(5,strVar.length()) ;
				if(p_break_time_2_to==null || p_break_time_2_to.equals("")) p_break_time_2_to="";
			}
			if(loop_count==3){
				p_break_time_3_from = strVar.substring(0,5) ;
				if(p_break_time_3_from==null || p_break_time_3_from.equals("")) p_break_time_3_from="";
				p_break_time_3_to = strVar.substring(5,strVar.length()) ;
				if(p_break_time_3_to==null || p_break_time_3_to.equals("")) p_break_time_3_to="";
			}
			if(loop_count==4){
				p_break_time_4_from = strVar.substring(0,5) ;
				if(p_break_time_4_from==null || p_break_time_4_from.equals("")) p_break_time_4_from="";
				p_break_time_4_to = strVar.substring(5,strVar.length()) ;
				if(p_break_time_4_to==null || p_break_time_4_to.equals("")) p_break_time_4_to="";
			}
			if(loop_count==5){
				p_break_time_5_from = strVar.substring(0,5) ;
				if(p_break_time_5_from==null || p_break_time_5_from.equals("")) p_break_time_5_from="";
				p_break_time_5_to = strVar.substring(5,strVar.length()) ;
				if(p_break_time_5_to==null || p_break_time_5_to.equals("")) p_break_time_5_to="";
			}
			loop_count++;
			}
			
			

			if (p_phys_roster_reqd_yn == null || p_phys_roster_reqd_yn.equals("") || p_phys_roster_reqd_yn.equals("null"))
			{
				p_phys_roster_reqd_yn = "N" ;
			}
			/*if (p_forced_allowed_yn == null || p_forced_allowed_yn.equals("") || p_forced_allowed_yn.equals("null"))
			{
				p_forced_allowed_yn = "N" ;
			}*/
			if(!p_forced_allowed_yn.equals("N")){
				p_forced_allowed_yn="Y";
			}
			// added by sudhakar to get vallues for day_no based insert or modify
			String day_val="";
			String function_mode =req.getParameter("function_mode")==null?"":req.getParameter("function_mode");
			if(function_mode.equals("modify")){ 
				day_val=req.getParameter("day_no_modify") ;
			}else{
				day_val=req.getParameter("b_day") ;
			}
			//p_day_no 				=	req.getParameter("b_day") ;
			
			//System.out.println("day_val @ servlet:"+day_val);
			// Commented by sudhakar as values  for day_no is not going properly
			/*if(p_day_no.equals("1") || p_day_no.equals("Monday"))
			{
				day_val="1";
			}else if(p_day_no.equals("2") || p_day_no.equals("Tuesday"))
			{
				day_val="2";
			}else if(p_day_no.equals("3") || p_day_no.equals("Wednesday"))
			{
				day_val="3";
			}else if(p_day_no.equals("4") || p_day_no.equals("Thursday"))
			{
				day_val="4";
			}else if(p_day_no.equals("5") || p_day_no.equals("Friday"))
			{
				day_val="5";
			}else if(p_day_no.equals("6") || p_day_no.equals("Saturday"))
			{
				day_val="6";
			}else if(p_day_no.equals("7") || p_day_no.equals("Sunday"))
			{
				day_val="7";
			}else{
				day_val="*A";
			}*/
					String addedFacilityId=facilityId;
			String addedAtWorkstation=client_ip_address;
			java.util.HashMap passObjects = new java.util.HashMap(); 
			passObjects.put("addedFacilityId",addedFacilityId);
			passObjects.put("p_clinic_code",p_clinic_code);
			passObjects.put("p_day_no",day_val);
			passObjects.put("p_practitioner_id",p_practitioner_id);
			passObjects.put("p_time_table_type",p_time_table_type);
			passObjects.put("p_remarks",p_remarks);
			passObjects.put("p_start_time",p_start_time);
			passObjects.put("p_end_time",p_end_time);
			passObjects.put("p_time_per_patient",p_time_per_patient);
			passObjects.put("p_max_patients_per_day",p_max_patients_per_day);
			passObjects.put("p_time_per_slab",p_time_per_slab);
			passObjects.put("p_max_patients_per_slab",p_max_patients_per_slab);
			passObjects.put("p_max_first_visits",p_max_first_visits);
			passObjects.put("p_max_over_bookings",p_max_over_bookings);
			passObjects.put("b_max_slots_for_first_visit",b_max_slots_for_first_visit);
			passObjects.put("p_phys_roster_reqd_yn",p_phys_roster_reqd_yn);
			passObjects.put("p_alcn_criteria",p_alcn_criteria);
			passObjects.put("p_break_time_intervals",p_break_time_intervals);
			passObjects.put("b_max_slots_per_day",b_max_slots_per_day);
			passObjects.put("b_max_other_visits",b_max_other_visits);
			passObjects.put("p_resource_type",p_resource_type);
			passObjects.put("p_forced_allowed_yn",p_forced_allowed_yn);
			passObjects.put("p_no_forced_booking",p_no_forced_booking);
			passObjects.put("p_no_global_ref",p_no_global_ref);
			passObjects.put("addedFacilityId",addedFacilityId);
			passObjects.put("addedAtWorkstation",addedAtWorkstation);
			passObjects.put("p_break_time_1_from",p_break_time_1_from);
			passObjects.put("p_break_time_1_to",p_break_time_1_to);
			passObjects.put("p_break_time_2_from",p_break_time_2_from);
			passObjects.put("p_break_time_2_to",p_break_time_2_to);
			passObjects.put("p_break_time_3_from",p_break_time_3_from);
			passObjects.put("p_break_time_3_to",p_break_time_3_to);
			passObjects.put("p_break_time_4_from",p_break_time_4_from);
			passObjects.put("p_break_time_4_to",p_break_time_4_to);
			passObjects.put("p_break_time_5_from",p_break_time_5_from);
			passObjects.put("p_break_time_5_to",p_break_time_5_to);
			passObjects.put("final_string",final_string);
			passObjects.put("alcn_basis",alcn_basis);
			passObjects.put("location",location);
			passObjects.put("operation",operation);			
			passObjects.put("max_new_patients",max_new_patients);			
			passObjects.put("max_old_patients",max_old_patients);		
			passObjects.put("schedule_extend_yn",schedule_extend_yn);//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112

			//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
			passObjects.put("ext_all_slots_yn",ext_all_slots_yn);
			passObjects.put("ext_start_slots",ext_start_slots);
			passObjects.put("ext_mid_slots",ext_mid_slots);
			passObjects.put("ext_end_slots",ext_end_slots);
			
	System.out.println("TimeTableServlet insertTimeTableforAll passObjects :"+passObjects.toString());
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/TimeTable",TimeTableHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = passObjects;
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = passObjects.getClass();
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertTimeTableforAll",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted ) 
			{
				 error_value = "1" ;
				out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+ "&err_value=" + error_value +"\"</script>");
			}else{
				 error = (String) results.get("error") ;
				 error_value = "0" ;
 				out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+ "&err_value=" + error_value +"\"</script>");
			}
			passObjects.clear();
			results.clear();
		}catch ( Exception e ){
			//out.println( "Exception Raised : " + e );
			e.printStackTrace();
		}
	}

	private synchronized void copyTimeTable(HttpServletRequest req)
	{
	System.out.println("copyTimeTable--->");
		try
		{
			int loop_count=1;
			String final_alcn_criteria 		=	req.getParameter("final_alcn_criteria")==null?"":req.getParameter("final_alcn_criteria") ;
			String finalPractList 		=	req.getParameter("finalPractList")==null?"":req.getParameter("finalPractList") ;
			p_time_table_type 		=	req.getParameter("time_table_type")==null?"":req.getParameter("time_table_type") ;
			p_remarks 				=	req.getParameter("remarks")==null?"":req.getParameter("remarks");
			p_start_time 			=	req.getParameter("start_time")==null?"":req.getParameter("start_time") ;
			p_end_time 				=	req.getParameter("end_time")==null?"":req.getParameter("end_time") ;
			p_time_per_patient 		=	req.getParameter("time_per_patient")==null?"":req.getParameter("time_per_patient") ;
			p_max_patients_per_day 	=	req.getParameter("max_patients_per_day")==null?"":req.getParameter("max_patients_per_day") ;
			p_time_per_slab 		=	req.getParameter("time_per_slab")==null?"":req.getParameter("time_per_slab") ;
			p_max_patients_per_slab =	req.getParameter("max_patients_per_slab")==null?"":req.getParameter("max_patients_per_slab") ;		
			p_max_first_visits 		=	req.getParameter("max_first_visit")==null?"0":req.getParameter("max_first_visit") ;			
			p_max_over_bookings		=	req.getParameter("max_over_bookings")==null?"":req.getParameter("max_over_bookings") ;			
			p_phys_roster_reqd_yn 	=	req.getParameter("b_roster_reqd")==null?"":req.getParameter("b_roster_reqd") ;
			p_break_time_intervals  =   req.getParameter("ftotstr")==null?"": req.getParameter("ftotstr");			
			b_max_slots_for_first_visit=   req.getParameter("b_max_slots_for_first_visit")==null?"":req.getParameter("b_max_slots_for_first_visit");
			
			final_string=   req.getParameter("final_string")==null?"": req.getParameter("final_string");			
			p_alcn_criteria=   req.getParameter("alcn_criteria")==null?"":req.getParameter("alcn_criteria");			
			b_max_slots_per_day=   req.getParameter("l_max_pat_per_slot")==null?"0":req.getParameter("l_max_pat_per_slot");				
			b_max_other_visits=   req.getParameter("max_other_visits")==null?"0":req.getParameter("max_other_visits");				
			p_forced_allowed_yn =	req.getParameter("forced_book_YN")==null?"N":req.getParameter("forced_book_YN");			
			p_no_forced_booking =	req.getParameter("no_of_forced_booking")==null?"0":req.getParameter("no_of_forced_booking");			
			p_no_global_ref		=	req.getParameter("no_of_global_booking")==null?"0":req.getParameter("no_of_global_booking");
			String max_new_patients		=	req.getParameter("max_new_patients")==null?"0":req.getParameter("max_new_patients");
			String max_old_patients		=	req.getParameter("max_old_patients")==null?"0":req.getParameter("max_old_patients");

			String finalString="";
			int cnt=0;			
			if(!final_alcn_criteria.equals("")){
					StringTokenizer str1=new StringTokenizer(final_alcn_criteria,"|");
					StringTokenizer valToken=null;
					while(str1.hasMoreTokens()){
						cnt++;
						valToken=new StringTokenizer(str1.nextToken(),"$");
						String code=valToken.nextToken();
						String no_of_slots=valToken.nextToken();
						String desc=valToken.nextToken();
						if(code.equals("OTH")){
						}else{
							if(cnt==1){
								finalString=code+"~"+desc+"~"+no_of_slots;
							}else{
								finalString=finalString+"|"+code+"~"+desc+"~"+no_of_slots;
							}
							
						}
						//finalStr
					}
			}


		
			if (final_string==null) final_string ="";
			else
				final_string=finalString+"|*O~0";
			alcn_basis=   req.getParameter("alcn_basis");
			if(alcn_basis ==null) alcn_basis="";
			strVar="";
			loop_count=1;
			p_break_time_1_from="";
			p_break_time_1_to="";
			p_break_time_2_from="";
			p_break_time_2_to="";
			p_break_time_3_from="";
			p_break_time_3_to="";
			p_break_time_4_from="";
			p_break_time_4_to="";
			p_break_time_5_from="";
			p_break_time_5_to="";


			StringTokenizer toks =new StringTokenizer (p_break_time_intervals,",") ;
			
			while (toks.hasMoreTokens())
			{
			strVar = toks.nextToken() ;
			if(loop_count==1){
				p_break_time_1_from = strVar.substring(0,5) ;
				if(p_break_time_1_from==null || p_break_time_1_from.equals("")) p_break_time_1_from="";
				p_break_time_1_to = strVar.substring(5,strVar.length()) ;
				if(p_break_time_1_to==null || p_break_time_1_to.equals("")) p_break_time_1_to="";
			}
			if(loop_count==2){
				p_break_time_2_from = strVar.substring(0,5) ;
				if(p_break_time_2_from==null || p_break_time_2_from.equals("")) p_break_time_2_from="";
				p_break_time_2_to = strVar.substring(5,strVar.length()) ;
				if(p_break_time_2_to==null || p_break_time_2_to.equals("")) p_break_time_2_to="";
			}
			if(loop_count==3){
				p_break_time_3_from = strVar.substring(0,5) ;
				if(p_break_time_3_from==null || p_break_time_3_from.equals("")) p_break_time_3_from="";
				p_break_time_3_to = strVar.substring(5,strVar.length()) ;
				if(p_break_time_3_to==null || p_break_time_3_to.equals("")) p_break_time_3_to="";
			}
			if(loop_count==4){
				p_break_time_4_from = strVar.substring(0,5) ;
				if(p_break_time_4_from==null || p_break_time_4_from.equals("")) p_break_time_4_from="";
				p_break_time_4_to = strVar.substring(5,strVar.length()) ;
				if(p_break_time_4_to==null || p_break_time_4_to.equals("")) p_break_time_4_to="";
			}
			if(loop_count==5){
				p_break_time_5_from = strVar.substring(0,5) ;
				if(p_break_time_5_from==null || p_break_time_5_from.equals("")) p_break_time_5_from="";
				p_break_time_5_to = strVar.substring(5,strVar.length()) ;
				if(p_break_time_5_to==null || p_break_time_5_to.equals("")) p_break_time_5_to="";
			}
			loop_count++;
			}
			
			

			if (p_phys_roster_reqd_yn == null || p_phys_roster_reqd_yn.equals("") || p_phys_roster_reqd_yn.equals("null"))
			{
				p_phys_roster_reqd_yn = "N" ;
			}
			

			if(!p_forced_allowed_yn.equals("N")){
				p_forced_allowed_yn="Y";
			}
		
			String day_val="";			
			p_clinic_code=req.getParameter("clinic_code") ;
			day_val=req.getParameter("day_no_modify") ;
			String addedFacilityId=facilityId;
			String addedAtWorkstation=client_ip_address;
			java.util.HashMap passObjects = new java.util.HashMap(); 
			passObjects.put("addedFacilityId",addedFacilityId);
			passObjects.put("p_clinic_code",p_clinic_code);
			passObjects.put("p_day_no",day_val);
			passObjects.put("p_practitioner_id",p_practitioner_id);
			passObjects.put("p_time_table_type",p_time_table_type);
			passObjects.put("p_remarks",p_remarks);
			passObjects.put("p_start_time",p_start_time);
			passObjects.put("p_end_time",p_end_time);
			passObjects.put("p_time_per_patient",p_time_per_patient);
			passObjects.put("p_max_patients_per_day",p_max_patients_per_day);
			passObjects.put("p_time_per_slab",p_time_per_slab);
			passObjects.put("p_max_patients_per_slab",p_max_patients_per_slab);
			passObjects.put("p_max_first_visits",p_max_first_visits);
			passObjects.put("p_max_over_bookings",p_max_over_bookings);
			passObjects.put("b_max_slots_for_first_visit",b_max_slots_for_first_visit);
			passObjects.put("p_phys_roster_reqd_yn",p_phys_roster_reqd_yn);
			passObjects.put("p_alcn_criteria",p_alcn_criteria);
			passObjects.put("p_break_time_intervals",p_break_time_intervals);
			passObjects.put("b_max_slots_per_day",b_max_slots_per_day);
			passObjects.put("b_max_other_visits",b_max_other_visits);
			passObjects.put("p_resource_type",p_resource_type);
			passObjects.put("p_forced_allowed_yn",p_forced_allowed_yn);
			passObjects.put("p_no_forced_booking",p_no_forced_booking);
			passObjects.put("p_no_global_ref",p_no_global_ref);
			passObjects.put("addedFacilityId",addedFacilityId);
			passObjects.put("addedAtWorkstation",addedAtWorkstation);
			passObjects.put("p_break_time_1_from",p_break_time_1_from);
			passObjects.put("p_break_time_1_to",p_break_time_1_to);
			passObjects.put("p_break_time_2_from",p_break_time_2_from);
			passObjects.put("p_break_time_2_to",p_break_time_2_to);
			passObjects.put("p_break_time_3_from",p_break_time_3_from);
			passObjects.put("p_break_time_3_to",p_break_time_3_to);
			passObjects.put("p_break_time_4_from",p_break_time_4_from);
			passObjects.put("p_break_time_4_to",p_break_time_4_to);
			passObjects.put("p_break_time_5_from",p_break_time_5_from);
			passObjects.put("p_break_time_5_to",p_break_time_5_to);
			passObjects.put("final_string",final_string);
			passObjects.put("alcn_basis",alcn_basis);
			passObjects.put("location",location);
			passObjects.put("operation",operation);			
			passObjects.put("max_new_patients",max_new_patients);			
			passObjects.put("max_old_patients",max_old_patients);			
			passObjects.put("finalPractList",finalPractList);		
			passObjects.put("schedule_extend_yn",schedule_extend_yn);//Added by Ashwini on 21-Jul-2021 for NMC-JD-CRF-0112

			//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
			passObjects.put("ext_all_slots_yn",ext_all_slots_yn);
			passObjects.put("ext_start_slots",ext_start_slots);
			passObjects.put("ext_mid_slots",ext_mid_slots);
			passObjects.put("ext_end_slots",ext_end_slots);
			
			System.err.println("TimeTableServlet copy passObjects :"+passObjects.toString());
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/TimeTable",TimeTableHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = passObjects;
			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = passObjects.getClass();
			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("copyTimeTable",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			System.err.println("inserted--->"+inserted);
			String error = (String) results.get("error") ;
			String error_value = "0" ;
			if ( inserted ) 
			{
				 error_value = "1" ;
				out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+ "&err_value=" + error_value +"\"</script>");
			}else{
				 error = (String) results.get("error") ;
				 error_value = "0" ;
 				out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+ "&err_value=" + error_value +"\"</script>");
			}
			passObjects.clear();
			results.clear();
		}catch ( Exception e ){
			//out.println( "Exception Raised : " + e );
			e.printStackTrace();
		}
	}
}
