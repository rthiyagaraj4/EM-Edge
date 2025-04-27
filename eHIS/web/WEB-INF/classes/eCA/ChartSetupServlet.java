/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* 
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           created
12/01/2016	  IN057209		prathyusha	Intake And Output Chart Shift Total master set up										
26/06/2020	  IN072777		Durga Natarajan	   	AAKH-CRF-0097.2
--------------------------------------------------------------------------------------------------------------------
*/
 package eCA;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import java.net.*;
import webbeans.eCommon.*;
import eCommon.SingleTabHandler.*;

public class ChartSetupServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws javax.servlet.ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//modifiedDate = dateFormat.format(new java.util.Date());
		PrintWriter out = null;
		try{
			out = response.getWriter();
			String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
			if(mode.equals("insert")) insert(request,response, out);
			if(mode.equals("modify")) update(request, out);
		}
		catch(Exception e){
			out.println("Exception in try of doPost() of ChartSetupServlet.java"+e);
			e.printStackTrace();
		}
	}//end of doPost()

public void doGet(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
	{
		PrintWriter out = null;
		try
		{
			out = res.getWriter();
			doPost(req,res);		
		}
		catch(Exception e)	
		{	
			out.println("Exception in invoking doPost Method");
			e.printStackTrace();
		}
	}
/************************************insert********************************/

private void insert(HttpServletRequest request,HttpServletResponse response, PrintWriter out)
{

	java.util.Properties p;
	HttpSession session;

	String chart_code = "";
	String long_desc = "";
	String short_desc = "";
	String eff_status = "";
	String day_summary_yn = "";
	String day_start_time = "";
	String day_end_time = "";
	String summary_req_yn = "";
	String shift_summary_yn = "";
	String change_at_trans = "";
	String added_by_id = "";
	//String addedDate = "";
	String added_at_ws_no = "";
	String added_facility_id = "";
	String modified_by_id = "";
	//String modifiedDate = "";
	String modified_at_ws_no = "";
	String modified_facility_id = "";
	String client_ip_address = "";
	String error_value = "0";
	String error = "";
	String chart_type = "";
	String past_rec_scope_days = "";
	
	//edited 12/31/2015 start
	String shift_one_start_time="";
	String shift_two_start_time="";
	String shift_three_start_time="";
	String shift_one_end_time="";
	String shift_two_end_time="";
	String shift_three_end_time="";
	String no_of_shifts="";
	String shift_hours="";
	String thirdParty_vitals_appl_YN = "N";//IN072777
	//edited 12/31/2015 end
	HashMap tableChart = new HashMap();
	session = request.getSession(false);
	p = (java.util.Properties)session.getValue("jdbc");
//	String locale = (String) p.getProperty("LOCALE");
	added_facility_id = (String)session.getValue("facility_id");
	client_ip_address = p.getProperty("client_ip_address");
	modified_by_id = (p.getProperty("login_user")==null)?"":p.getProperty("login_user");
	modified_facility_id		= (added_facility_id==null)?"":added_facility_id;
	modified_at_ws_no   = (client_ip_address==null)?"":client_ip_address;
	

	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm");
	try{
		added_by_id = (p.getProperty("login_user")==null)?"":p.getProperty("login_user");
		//addedDate = dateFormat.format(new java.util.Date());
		added_facility_id = (added_facility_id == null)?"":added_facility_id; 
		added_at_ws_no = (client_ip_address == null)?"":client_ip_address; 
//		added_date1	 = java.sql.Date.valueOf(addedDate);
//		modified_date1 = java.sql.Date.valueOf(modifiedDate);

		chart_code = request.getParameter("chart_code")==null?"":request.getParameter("chart_code");  
		long_desc = request.getParameter("long_desc")==null?"":request.getParameter("long_desc");
		short_desc = request.getParameter("short_desc")==null?"":request.getParameter("short_desc");
		eff_status = request.getParameter("enabled")==null?"D":request.getParameter("enabled");
		summary_req_yn = request.getParameter("Summ_required")==null?"N":request.getParameter("Summ_required");
		day_summary_yn = request.getParameter("Summ_required_day")==null?"N":request.getParameter("Summ_required_day");
		day_start_time = request.getParameter("day_summ_from")==null?"":request.getParameter("day_summ_from");
		day_end_time = request.getParameter("day_summ_to")==null?"":request.getParameter("day_summ_to");
		//IN057209 start
		shift_summary_yn = request.getParameter("shift_summary_required")==null?"N":request.getParameter("shift_summary_required");
		no_of_shifts = request.getParameter("no_of_shifts")==null?"N":request.getParameter("no_of_shifts");
		shift_hours = request.getParameter("shift_hours")==null?"N":request.getParameter("shift_hours");
		System.out.println("shift_summary_yn insert"+shift_summary_yn);
		thirdParty_vitals_appl_YN = request.getParameter("thirdParty_vitals_appl_YN")==null?"N":request.getParameter("thirdParty_vitals_appl_YN");//IN072777
		//edited 01/08/2016
		if(day_summary_yn.equalsIgnoreCase("Y")){
			shift_summary_yn = shift_summary_yn;
			System.out.println("shift_summary_yn in if  =====>"+shift_summary_yn+"day_summary_yn"+day_summary_yn);
		}
		else{
			shift_summary_yn = "N";
			System.out.println("shift_summary_yn in else =====>"+shift_summary_yn+"day_summary_yn"+day_summary_yn);
		}
		
		if(shift_summary_yn.equalsIgnoreCase("Y")){
			
			
			
			shift_one_start_time = request.getParameter("shift_one_summ_from")==null?"":request.getParameter("shift_one_summ_from");
			shift_two_start_time = request.getParameter("shift_two_summ_from")==null?"":request.getParameter("shift_two_summ_from");
			shift_three_start_time = request.getParameter("shift_three_summ_from")==null?"":request.getParameter("shift_three_summ_from");
			shift_one_end_time = request.getParameter("shift_one_summ_to")==null?"":request.getParameter("shift_one_summ_to");
			shift_two_end_time = request.getParameter("shift_two_summ_to")==null?"":request.getParameter("shift_two_summ_to");
			shift_three_end_time = request.getParameter("shift_three_summ_to")==null?"":request.getParameter("shift_three_summ_to");
			
			
			System.out.println("shift_one_start_time =====>"+shift_one_start_time);
			System.out.println("shift_two_start_time =====>"+shift_two_start_time);
			System.out.println("shift_three_start_time =====>"+shift_three_start_time);
			System.out.println("shift_one_end_time =====>"+shift_one_end_time);
			System.out.println("shift_two_end_time =====>"+shift_two_end_time);
			System.out.println("shift_three_end_time =====>"+shift_three_end_time);
	
		}
		else{
			
			
			shift_one_start_time = "";
			shift_two_start_time = "";
			shift_three_start_time = "";
			shift_one_end_time = "";
			shift_two_end_time = "";
			shift_three_end_time ="";
			}
		//IN057209 END
		change_at_trans = request.getParameter("change_at_trans")==null?"N":request.getParameter("change_at_trans");	

		chart_type = request.getParameter("chart_type")==null?"":request.getParameter("chart_type");
		past_rec_scope_days = request.getParameter("past_rec_scope_days")==null?"":request.getParameter("past_rec_scope_days");

		java.util.Date dt_time = new java.util.Date();
		java.util.Date dt1_time = new java.util.Date();
		//edited 12/31/2015 start
		java.util.Date dt_time_shift1_start = new java.util.Date();
		java.util.Date dt_time_shift2_start = new java.util.Date();
		java.util.Date dt_time_shift3_start = new java.util.Date();
		java.util.Date dt_time_shift1_end = new java.util.Date();
		java.util.Date dt_time_shift2_end = new java.util.Date();
		java.util.Date dt_time_shift3_end = new java.util.Date();
		//edited 12/31/2015 end
		if(!((day_start_time.equals("")) ||(day_end_time.equals("")))){
			java.util.Date dt = sdf.parse(day_start_time);
			dt_time = new java.sql.Timestamp(dt.getTime());
			java.util.Date dt1 = sdf.parse(day_end_time);
			dt1_time = new java.sql.Timestamp(dt1.getTime());
		}
		//edited 12/31/2015 start
		if(!(shift_one_start_time.equals(""))){
			java.util.Date dt_shift1_start = sdf.parse(shift_one_start_time);
			dt_time_shift1_start = new java.sql.Timestamp(dt_shift1_start.getTime());
		}
		if(!(shift_two_start_time.equals(""))){
			java.util.Date dt_shift2_start = sdf.parse(shift_two_start_time);
			dt_time_shift2_start = new java.sql.Timestamp(dt_shift2_start.getTime());
		}
		if(!(shift_three_start_time.equals(""))){
			java.util.Date dt_shift3_start = sdf.parse(shift_three_start_time);
			dt_time_shift3_start = new java.sql.Timestamp(dt_shift3_start.getTime());
		}
		if(!(shift_one_end_time.equals(""))){
			java.util.Date dt_shift1_end = sdf.parse(shift_one_end_time);
			dt_time_shift1_end = new java.sql.Timestamp(dt_shift1_end.getTime());
		}
		if(!(shift_two_end_time.equals(""))){
			java.util.Date dt_shift2_end = sdf.parse(shift_two_end_time);
			dt_time_shift2_end = new java.sql.Timestamp(dt_shift2_end.getTime());
		}
		if(!(shift_three_end_time.equals(""))){
			java.util.Date dt_shift3_end = sdf.parse(shift_three_end_time);
			dt_time_shift3_end = new java.sql.Timestamp(dt_shift3_end.getTime());
		}
			
		//IN057209 end
		tableChart.put("chart_id",chart_code);
		tableChart.put("long_desc",long_desc);
		tableChart.put("short_desc",short_desc);
		tableChart.put("eff_status",eff_status);
		tableChart.put("DAY_SUMMARY_REQ_YN",day_summary_yn);
		tableChart.put("day_start_time",dt_time);
		tableChart.put("day_end_time",dt1_time);
		tableChart.put("thirdParty_vitals_appl_YN",thirdParty_vitals_appl_YN);//IN072777 
		//IN057209 start
		if(!(shift_one_start_time.equals(""))){
			tableChart.put("shift1_start_time",dt_time_shift1_start);
		}
		else{
			tableChart.put("shift1_start_time","");
		}
		if(!(shift_two_start_time.equals(""))){
			tableChart.put("shift2_start_time",dt_time_shift2_start);
		}
		else{
			tableChart.put("shift2_start_time","");
		}
		if(!(shift_three_start_time.equals(""))){
			tableChart.put("shift3_start_time",dt_time_shift3_start);
		}
		else{
			tableChart.put("shift3_start_time","");
		}
		if(!(shift_one_end_time.equals(""))){
			tableChart.put("shift1_end_time",dt_time_shift1_end);
		}
		else{
			tableChart.put("shift1_end_time","");
		}
		if(!(shift_two_end_time.equals(""))){
			tableChart.put("shift2_end_time",dt_time_shift2_end);
		}
		else{
			tableChart.put("shift2_end_time","");
		}
		if(!(shift_three_end_time.equals(""))){
			tableChart.put("shift3_end_time",dt_time_shift3_end);
		}
		else{
			tableChart.put("shift3_end_time","");
		}
				
		//edited 12/31/2015 end
		tableChart.put("SHIFT_SUMMARY_REQ_YN",shift_summary_yn);
		// edited 01/09/2016 start
		
		tableChart.put("NO_OF_SHIFTS",no_of_shifts);
		//System.out.println("SHIFT1_REQ_YN =====>"+shift_one_summary_yn);
		tableChart.put("SHIFT_DURATION",shift_hours);
		//System.out.println("SHIFT2_REQ_YN =====>"+shift_two_summary_yn);
		//IN057209 end
		tableChart.put("added_by_id",added_by_id);
		tableChart.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
		tableChart.put("added_at_ws_no",added_at_ws_no);
		tableChart.put("added_facility_id",added_facility_id);
		tableChart.put("modified_by_id",modified_by_id);
		tableChart.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
		tableChart.put("modified_at_ws_no",modified_at_ws_no);
		tableChart.put("modified_facility_id",modified_facility_id);
		tableChart.put("summary_req_yn",summary_req_yn);
		//tableChart.put("Define_modifiable_at_trn_yn","Y");
		tableChart.put("CONFIG_TYPE",change_at_trans);
		tableChart.put("SPL_CHART_TYPE",chart_type);
		tableChart.put("past_rec_scope_days",past_rec_scope_days);

		


		String dupfields[] = {"chart_id"};
		
		/*Context context = new InitialContext();
		Object homeobj = context.lookup("java:comp/env/SingleTabHandler");
		SingleTabHandlerManagerHome singletabhandlermanagerhome = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeobj,SingleTabHandlerManagerHome.class);
		final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singletabhandlermanagerhome.create();

		final java.util.Hashtable results = singleTabHandlerManagerRemote.insert(p,tableChart,dupfields,"ca_chart");*/

		boolean local_ejbs = false;
		String tabname="ca_chart";
		
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		Object argArray[] = new Object[4];
		argArray[0] = p;
		argArray[1] = tableChart;
		argArray[2] = dupfields;
		argArray[3] = tabname;

		Class [] paramArray = new Class[4];
		paramArray[0] = p.getClass();
		paramArray[1] = tableChart.getClass();
		paramArray[2] = dupfields.getClass();
		paramArray[3] = tabname.getClass();


		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		
		boolean inserted = (((Boolean)results.get("status")).booleanValue());
		error= (String) results.get("error") ;
		if(inserted){
			error_value = "1";
			}
		results.clear();
		tableChart.clear();
		response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode(error,"UTF-8")+"&err_value="+error_value);
	}//end of try
	catch(Exception e){
		//out.println("<h3> Exception raised by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());//common-icn-0181
		e.printStackTrace();
	}//end of catch
}//end of insert

/************************************Modify***********************************/
private void update(HttpServletRequest request, PrintWriter out){
	
	java.util.Properties p;
	HttpSession session;

	String chart_code = "";
	String long_desc = "";
	String short_desc = "";
	String eff_status = "";
	String day_summary_yn = "";
	String day_start_time = "";
	String day_end_time = "";
	String summary_req_yn = "";
	String shift_summary_yn = "";
	String change_at_trans = "";
	String added_by_id = "";
	//String addedDate = "";
	String added_at_ws_no = "";
	String added_facility_id = "";
	String modified_by_id = "";
	//String modifiedDate = "";
	String modified_at_ws_no = "";
	String modified_facility_id = "";
	String client_ip_address = "";
	String error_value = "0";
	String error = "";
	String chart_type = "";
	String past_rec_scope_days = "";

	//edited 12/31/2015 start
		String shift_one_start_time="";
		String shift_two_start_time="";
		String shift_three_start_time="";
		String shift_one_end_time="";
		String shift_two_end_time="";
		String shift_three_end_time="";
		//edited 12/31/2015 end
		//edited 01/08/2016
		String shift_hours="";
		String no_of_shifts="";
		String thirdParty_vitals_appl_YN = "N";//IN072777
		//edited 01/08/2016
	HashMap tableChart = new HashMap();
	session = request.getSession(false);
	p = (java.util.Properties)session.getValue("jdbc");
//	String locale = (String) p.getProperty("LOCALE");
	added_facility_id = (String)session.getValue("facility_id");
	client_ip_address = p.getProperty("client_ip_address");
	modified_by_id = (p.getProperty("login_user")==null)?"":p.getProperty("login_user");
	modified_facility_id		= (added_facility_id==null)?"":added_facility_id;
	modified_at_ws_no   = (client_ip_address==null)?"":client_ip_address;
	

	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm");
	try{
		added_by_id = (p.getProperty("login_user")==null)?"":p.getProperty("login_user");
		//addedDate = dateFormat.format(new java.util.Date());
		added_facility_id = (added_facility_id == null)?"":added_facility_id; 
		added_at_ws_no = (client_ip_address == null)?"":client_ip_address; 
//		added_date1	 = java.sql.Date.valueOf(addedDate);
//		modified_date1 = java.sql.Date.valueOf(modifiedDate);

		chart_code = request.getParameter("chart_code")==null?"":request.getParameter("chart_code");  
		long_desc = request.getParameter("long_desc")==null?"":request.getParameter("long_desc");
		short_desc = request.getParameter("short_desc")==null?"":request.getParameter("short_desc");
		eff_status = request.getParameter("enabled")==null?"D":request.getParameter("enabled");
		summary_req_yn = request.getParameter("Summ_required")==null?"N":request.getParameter("Summ_required");

		day_summary_yn = request.getParameter("Summ_required_day")==null?"N":request.getParameter("Summ_required_day");
		day_start_time = request.getParameter("day_summ_from")==null?"":request.getParameter("day_summ_from");
		day_end_time = request.getParameter("day_summ_to")==null?"":request.getParameter("day_summ_to");
		shift_summary_yn = request.getParameter("shift_summary_required")==null?"N":request.getParameter("shift_summary_required");
		System.out.println("shift_summary_yn update"+shift_summary_yn);
		no_of_shifts = request.getParameter("no_of_shifts")==null?"N":request.getParameter("no_of_shifts");
		shift_hours = request.getParameter("shift_hours")==null?"N":request.getParameter("shift_hours");
		thirdParty_vitals_appl_YN = request.getParameter("thirdParty_vitals_appl_YN")==null?"N":request.getParameter("thirdParty_vitals_appl_YN");//IN072777
				if(day_summary_yn.equalsIgnoreCase("Y")){
					shift_summary_yn = shift_summary_yn;
					System.out.println("shift_summary_yn in if  =====>"+shift_summary_yn+"day_summary_yn"+day_summary_yn);
				}
				else{
					shift_summary_yn = "N";
					System.out.println("shift_summary_yn in else =====>"+shift_summary_yn+"day_summary_yn"+day_summary_yn);
				}
				
				if(shift_summary_yn.equalsIgnoreCase("Y")){
					
				
					
					shift_one_start_time = request.getParameter("shift_one_summ_from")==null?"":request.getParameter("shift_one_summ_from");
					shift_two_start_time = request.getParameter("shift_two_summ_from")==null?"":request.getParameter("shift_two_summ_from");
					shift_three_start_time = request.getParameter("shift_three_summ_from")==null?"":request.getParameter("shift_three_summ_from");
					shift_one_end_time = request.getParameter("shift_one_summ_to")==null?"":request.getParameter("shift_one_summ_to");
					shift_two_end_time = request.getParameter("shift_two_summ_to")==null?"":request.getParameter("shift_two_summ_to");
					shift_three_end_time = request.getParameter("shift_three_summ_to")==null?"":request.getParameter("shift_three_summ_to");
					
					
					System.out.println("shift_one_start_time =====>"+shift_one_start_time);
					System.out.println("shift_two_start_time =====>"+shift_two_start_time);
					System.out.println("shift_three_start_time =====>"+shift_three_start_time);
					System.out.println("shift_one_end_time =====>"+shift_one_end_time);
					System.out.println("shift_two_end_time =====>"+shift_two_end_time);
					System.out.println("shift_three_end_time =====>"+shift_three_end_time);
					
				}
				else{
					
					
					shift_one_start_time = "";
					shift_two_start_time = "";
					shift_three_start_time = "";
					shift_one_end_time = "";
					shift_two_end_time = "";
					shift_three_end_time ="";
					
					
					System.out.println("shift_one_start_time =====>"+shift_one_start_time);
					System.out.println("shift_two_start_time =====>"+shift_two_start_time);
					System.out.println("shift_three_start_time =====>"+shift_three_start_time);
					System.out.println("shift_one_end_time =====>"+shift_one_end_time);
					System.out.println("shift_two_end_time =====>"+shift_two_end_time);
					System.out.println("shift_three_end_time =====>"+shift_three_end_time);
				}

				
				//edited 01/08/2016
		change_at_trans = request.getParameter("change_at_trans")==null?"N":request.getParameter("change_at_trans");	

		chart_type = request.getParameter("chart_type")==null?"":request.getParameter("chart_type");
		past_rec_scope_days = request.getParameter("past_rec_scope_days")==null?"":request.getParameter("past_rec_scope_days");

		java.util.Date dt_time = new java.util.Date();
		java.util.Date dt1_time = new java.util.Date();

		//edited 12/31/2015 start
				java.util.Date dt_time_shift1_start = new java.util.Date();
				java.util.Date dt_time_shift2_start = new java.util.Date();
				java.util.Date dt_time_shift3_start = new java.util.Date();
				java.util.Date dt_time_shift1_end = new java.util.Date();
				java.util.Date dt_time_shift2_end = new java.util.Date();
				java.util.Date dt_time_shift3_end = new java.util.Date();
				//edited 12/31/2015 end
		if(!((day_start_time.equals("")) ||(day_end_time.equals("")))){

			java.util.Date dt = sdf.parse(day_start_time);
			dt_time = new java.sql.Timestamp(dt.getTime());
			java.util.Date dt1 = sdf.parse(day_end_time);
			dt1_time = new java.sql.Timestamp(dt1.getTime());
		}
		//edited 12/31/2015 start
		if(!(shift_one_start_time.equals(""))){
			java.util.Date dt_shift1_start = sdf.parse(shift_one_start_time);
			dt_time_shift1_start = new java.sql.Timestamp(dt_shift1_start.getTime());
		}
		if(!(shift_two_start_time.equals(""))){
			java.util.Date dt_shift2_start = sdf.parse(shift_two_start_time);
			dt_time_shift2_start = new java.sql.Timestamp(dt_shift2_start.getTime());
		}
		if(!(shift_three_start_time.equals(""))){
			java.util.Date dt_shift3_start = sdf.parse(shift_three_start_time);
			dt_time_shift3_start = new java.sql.Timestamp(dt_shift3_start.getTime());
		}
		if(!(shift_one_end_time.equals(""))){
			java.util.Date dt_shift1_end = sdf.parse(shift_one_end_time);
			dt_time_shift1_end = new java.sql.Timestamp(dt_shift1_end.getTime());
		}
		if(!(shift_two_end_time.equals(""))){
			java.util.Date dt_shift2_end = sdf.parse(shift_two_end_time);
			dt_time_shift2_end = new java.sql.Timestamp(dt_shift2_end.getTime());
		}
		if(!(shift_three_end_time.equals(""))){
			java.util.Date dt_shift3_end = sdf.parse(shift_three_end_time);
			dt_time_shift3_end = new java.sql.Timestamp(dt_shift3_end.getTime());
		}
				
				//edited 12/31/2015 end
		
		tableChart.put("chart_id",chart_code);
		tableChart.put("long_desc",long_desc);
		tableChart.put("short_desc",short_desc);
		tableChart.put("eff_status",eff_status);
		tableChart.put("DAY_SUMMARY_REQ_YN",day_summary_yn);
		tableChart.put("day_start_time",dt_time);
		tableChart.put("day_end_time",dt1_time);
		tableChart.put("SHIFT_SUMMARY_REQ_YN",shift_summary_yn);
		tableChart.put("added_by_id",added_by_id);
		tableChart.put("added_date",new  java.sql.Timestamp(System.currentTimeMillis()));
		tableChart.put("added_at_ws_no",added_at_ws_no);
		tableChart.put("added_facility_id",added_facility_id);
		tableChart.put("modified_by_id",modified_by_id);
		tableChart.put("modified_date",new  java.sql.Timestamp(System.currentTimeMillis()));
		tableChart.put("modified_at_ws_no",modified_at_ws_no);
		tableChart.put("modified_facility_id",modified_facility_id);
		tableChart.put("summary_req_yn",summary_req_yn);
		//tableChart.put("Define_modifiable_at_trn_yn","Y");
		tableChart.put("CONFIG_TYPE",change_at_trans);
		tableChart.put("SPL_CHART_TYPE",chart_type);
		tableChart.put("past_rec_scope_days",past_rec_scope_days);
		tableChart.put("thirdParty_vitals_appl_YN",thirdParty_vitals_appl_YN);//IN072777
		// edited 12/31/2015 start
		
				//SHIFT1_START_TIME,SHIFT2_START_TIME,SHIFT3_START_TIME,SHIFT1_END_TIME,SHIFT2_END_TIME,SHIFT3_END_TIME
		if(!(shift_one_start_time.equals(""))){
			tableChart.put("shift1_start_time",dt_time_shift1_start);
		}
		else{
			tableChart.put("shift1_start_time","");
		}
		System.out.println("shift1_start_time =====>"+dt_time_shift1_start);
		if(!(shift_two_start_time.equals(""))){
			tableChart.put("shift2_start_time",dt_time_shift2_start);
		}
		else{
			tableChart.put("shift2_start_time","");
		}
		System.out.println("shift2_start_time =====>"+dt_time_shift2_start);
		if(!(shift_three_start_time.equals(""))){
			tableChart.put("shift3_start_time",dt_time_shift3_start);
		}
		else{
			tableChart.put("shift3_start_time","");
		}
		System.out.println("shift3_start_time =====>"+dt_time_shift3_start);
		if(!(shift_one_end_time.equals(""))){
			tableChart.put("shift1_end_time",dt_time_shift1_end);
		}
		else{
			tableChart.put("shift1_end_time","");
		}
		System.out.println("shift1_end_time =====>"+dt_time_shift1_end);
		if(!(shift_two_end_time.equals(""))){
			tableChart.put("shift2_end_time",dt_time_shift2_end);
		}
		else{
			tableChart.put("shift2_end_time","");
		}
		System.out.println("shift2_end_time =====>"+dt_time_shift2_end);
		if(!(shift_three_end_time.equals(""))){
			tableChart.put("shift3_end_time",dt_time_shift3_end);
		}
		else{
			tableChart.put("shift3_end_time","");
		}
		System.out.println("shift3_end_time =====>"+dt_time_shift3_end);
				
				//edited 12/31/2015 end
             //edited 01/09/2016 start
		
				tableChart.put("NO_OF_SHIFTS",no_of_shifts);
				//System.out.println("SHIFT1_REQ_YN =====>"+shift_one_summary_yn);
				tableChart.put("SHIFT_DURATION",shift_hours);
				//System.out.println("SHIFT2_REQ_YN =====>"+shift_two_summary_yn);
			    
			    //edited 01/08/2016 end



		HashMap tableUpdate = new HashMap();
		tableUpdate.put("chart_id",chart_code);


		/*Context context = new InitialContext();
		Object homeobj = context.lookup("java:comp/env/SingleTabHandler");
		SingleTabHandlerManagerHome singletabhandlermanagerhome = (SingleTabHandlerManagerHome) PortableRemoteObject.narrow(homeobj,SingleTabHandlerManagerHome.class);
		final SingleTabHandlerManagerRemote singleTabHandlerManagerRemote = singletabhandlermanagerhome.create();
		
		final java.util.Hashtable results = singleTabHandlerManagerRemote.update(p,tableChart,tableUpdate,"ca_chart");*/
		
		boolean local_ejbs = false;
		String tabname="ca_chart";
		
		if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		Object argArray[] = new Object[4];
		argArray[0] = p;
		argArray[1] = tableChart;
		argArray[2] = tableUpdate;
		argArray[3] = tabname;

		Class [] paramArray = new Class[4];
		paramArray[0] = p.getClass();
		paramArray[1] = tableChart.getClass();
		paramArray[2] = tableUpdate.getClass();
		paramArray[3] = tabname.getClass();


		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		tableUpdate.clear();
		tableChart.clear();

		boolean modified = (((Boolean) results.get("status")).booleanValue());

		error = (String) results.get("error") ;
		if (modified){
			error_value = "1" ;
//			error= getMessage(locale,"RECORD_INSERTED","CA");
			}
			results.clear();
			
			out.println("<script>parent.f_query_add_mod.document.AddModifyChartSetupForm.Summ_required_day.disabled = true;parent.f_query_add_mod.document.AddModifyChartSetupForm.Summ_required.disabled = true;parent.f_query_add_mod.document.AddModifyChartSetupForm.change_at_trans.disabled = true;</script>");
			out.println("<script>parent.messageFrame.location.href='../eCommon/jsp/MstCodeError.jsp?err_num="+error+"&err_value="+error_value+"'</script>");
	}//end of try
	catch(Exception e){
		//out.println("<h3> Exception raised by Servlet ...So Record Not inserted </h3> Foll: Error Received : "+e.toString());//common-icn-0181
		e.printStackTrace();
	}
}//end of update


}//end of class


