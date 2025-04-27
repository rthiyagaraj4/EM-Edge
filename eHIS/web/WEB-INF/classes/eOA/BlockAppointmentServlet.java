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
import com.ehis.util.*;
import webbeans.eCommon.*;
import eOA.BlockAppointment.* ;

public class BlockAppointmentServlet extends javax.servlet.http.HttpServlet{
	PrintWriter out;
	java.util.Properties p;
	String facilityId;
	String client_ip_address ;
	String location ;
	String practitioner;
	String block_date;
	String block_from_time;
	String block_to_time;
	String reason_for_block;
	String reason_for_block1;
	String time_per_patient;
	String finalvalues;
	String insertdetail;
	String first_visits_value;
	String other_visits_value;
	String resource="";
	String locn_type="";
	String locale="";
	String Slot_fully_blocked="";
	String time_table_type="";
	String max_patients_per_slab="";
	String final_count="";
	String remarks_for_block=""; //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114

	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}
	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res)throws javax.servlet.ServletException,IOException{
		HttpSession session = req.getSession(false);
		this.facilityId = (String)session.getValue("facility_id") ;
		locale=(String)session.getAttribute("LOCALE");
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.client_ip_address = p.getProperty("client_ip_address");
		try {
			this.out = res.getWriter();
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			String operation = req.getParameter("function_name");
			if(operation.equals("insert"))
				insertBlockAppointment(req,res);
			if(operation.equals("delete"))
				deleteBlockAppointment(req,res);

		}catch (Exception e){
		//	out.println(e.toString());
		 e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
		}
	}


private void insertBlockAppointment(HttpServletRequest req, HttpServletResponse res)	{
	try {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");


		location = req.getParameter("clinic");
		practitioner = req.getParameter("practitioner");
		block_date =req.getParameter("block_date");
		block_from_time=req.getParameter("block_from_time");
		block_to_time=req.getParameter("block_to_time");

		block_date=DateUtils.convertDate(block_date,"DMY",locale,"en");

		reason_for_block =req.getParameter("reason_for_block");
		reason_for_block1 =req.getParameter("reason_for_block1");
		time_per_patient=req.getParameter("time_per_patient");

		resource =req.getParameter("resourceType");
		locn_type = req.getParameter("location1");

		Slot_fully_blocked = req.getParameter("Slot_fully_blocked");
		time_table_type=req.getParameter("time_table_type")==null?"":req.getParameter("time_table_type");

		finalvalues = req.getParameter("final_values")==null?"":req.getParameter("final_values");
		insertdetail = req.getParameter("insert_detail")==null?"":req.getParameter("insert_detail");
		first_visits_value = req.getParameter("first_visits_value")==null?"0":req.getParameter("first_visits_value");
		other_visits_value = req.getParameter("other_visits_value")==null?"0":req.getParameter("other_visits_value");
		max_patients_per_slab = req.getParameter("max_patients_per_slab")==null?"0":req.getParameter("max_patients_per_slab");
		final_count = req.getParameter("final_count")==null?"0":req.getParameter("final_count");

		remarks_for_block = req.getParameter("other_remarks")==null?"":req.getParameter("other_remarks"); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114





			java.util.HashMap passObjects = new java.util.HashMap();
			passObjects.put("location",location);
			passObjects.put("practitioner",practitioner);
			passObjects.put("block_date",block_date);
			passObjects.put("block_from_time",block_from_time);
			passObjects.put("block_to_time",block_to_time);
			passObjects.put("reason_for_block",reason_for_block);
			passObjects.put("reason_for_block1",reason_for_block1);
			passObjects.put("time_per_patient",time_per_patient);

			passObjects.put("facilityId",facilityId);
			passObjects.put("client_ip_address",client_ip_address);
			passObjects.put("finalvalues",finalvalues);
			passObjects.put("insertdetail",insertdetail);
			passObjects.put("first_visits_value",first_visits_value);
			passObjects.put("other_visits_value",other_visits_value);
			passObjects.put("locn_type",locn_type);
			passObjects.put("resource",resource);
			passObjects.put("Slot_fully_blocked",Slot_fully_blocked);
			passObjects.put("time_table_type",time_table_type);
			passObjects.put("max_patients_per_slab",max_patients_per_slab);
			passObjects.put("final_count",final_count);
			passObjects.put("remarks_for_block",remarks_for_block); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114



			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/BlockAppointment",BlockAppointmentManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = passObjects;


			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = passObjects.getClass();

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertBlockAppointment",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		String error = (String) results.get("error") ;
		String error_value = "0" ;
		if ( inserted )
		{
			error_value = "1" ;

				out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+ "&err_value=" + error_value +"\"</script>");

		}
		else
		{
			error = (String) results.get("error") ;
			out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" ) +"\"</script>");

		}
		passObjects.clear();
		results.clear();

	} catch ( Exception e ) {
		e.printStackTrace();
		//out.println(e.getMessage());
		//out.println(e.toString());
		}
	}


	private void deleteBlockAppointment(HttpServletRequest req, HttpServletResponse res)
	{
		try {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");

		String clinic_code =req.getParameter("clinic_code");
		String srl_no = req.getParameter("srl_no");
		String pract_id = req.getParameter("pract_id");
		String from_time=req.getParameter("from_time");
		String to_time =req.getParameter("to_time");
		String date=req.getParameter("date");
		String resource =req.getParameter("resourceType");
		String locn_type = req.getParameter("location1");
		String alcncriteria = req.getParameter("alcn_criteria")==null?"":req.getParameter("alcn_criteria");
		first_visits_value = req.getParameter("first_visits_blocked")==null?"0":req.getParameter("first_visits_blocked");
		other_visits_value = req.getParameter("other_visits_blocked")==null?"0":req.getParameter("other_visits_blocked");
		time_table_type=req.getParameter("time_table_type")==null?"":req.getParameter("time_table_type");
		date=DateUtils.convertDate(date,"DMY",locale,"en");
		reason_for_block =req.getParameter("reason_for_block");
		reason_for_block1 =req.getParameter("reason_for_block1");
		practitioner = req.getParameter("practitioner");
		remarks_for_block = req.getParameter("other_remarks")==null?"":req.getParameter("other_remarks"); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114


			java.util.HashMap passObjects = new java.util.HashMap();

			passObjects.put("clinic_code",clinic_code);
			passObjects.put("pract_id",pract_id);
			passObjects.put("date",date);
			passObjects.put("from_time",from_time);
			passObjects.put("to_time",to_time);
			passObjects.put("facilityId",facilityId);
			passObjects.put("srl_no",srl_no);
			passObjects.put("client_ip_address",client_ip_address);
			passObjects.put("alcncriteria",alcncriteria);
			passObjects.put("first_visits_value",first_visits_value);
			passObjects.put("other_visits_value",other_visits_value);
			passObjects.put("locn_type",locn_type);
			passObjects.put("resource",resource);
			passObjects.put("time_table_type",time_table_type);
			passObjects.put("reason_for_block",reason_for_block);
			passObjects.put("reason_for_block1",reason_for_block1);
			passObjects.put("practitioner",practitioner);
			passObjects.put("remarks_for_block",remarks_for_block); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114



			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/BlockAppointment",BlockAppointmentManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = passObjects;

			Class [] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = passObjects.getClass();


		java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("deleteBlockAppointment",paramArray)).invoke(busObj,argArray);

		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
		String error = (String) results.get("error") ;
		String error_value = "" ;

				if ( inserted )
				{
					error_value = "1" ;
				out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+ "&err_value=" + error_value +"\"</script>");

				}
				else
				{
					error = (String) results.get("error") ;
					out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" ) +"\"</script>");

				}

				error_value = "1" ;
				out.println("<script>location.href =\"../eCommon/jsp/error.jsp?err_num=" +java.net.URLEncoder.encode( error,"UTF-8" )+ "&err_value=" + error_value +"\"</script>");
				passObjects.clear();
				results.clear();

				} catch ( Exception e ) {
					//out.println(e.getMessage());
					//out.println(e.toString());
					 e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
					}
	}

}

