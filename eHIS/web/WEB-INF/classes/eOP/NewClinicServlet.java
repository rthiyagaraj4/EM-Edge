/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*	
 Developed by    :   Smita Unnikrishnan
 Created on		:   22/05/2004
 Module			:   Out Patient Management
 Function		:   Master function-Clinic-This function is used to do all the master setup available for a particular clinic.
 
 */

package eOP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import javax.ejb.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import eOP.OPClinic.*;

public class NewClinicServlet extends javax.servlet.http.HttpServlet {

	PrintWriter out;

	java.util.Properties p;
	RecordSet associateDiagBean = new RecordSet();

	String callfunc;

	String working_week_1_day[] = new String[7];

	String working_week_2_day[] = new String[7];

	String working_week_3_day[] = new String[7];

	String working_week_4_day[] = new String[7];

	String working_week_5_day[] = new String[7];

	String working_week_appl[] = new String[7];

	String max_walkin_for_day[] = new String[7];

	String working_day[] = new String[7];

	String pract_working_day[] = new String[7];

	String facilityId;

	String client_ip_address;

	String num_appl_yn = "";

	String by_pract_yn = "";

	String by_res_yn = "";

	String by_room_yn = "";

	String other_res_class = "";

	String other_res_type = "";
	String CATEGORY=""; // Added by Ajay for MMS-DM-CRF-0209.4

	HashMap tabdata = new HashMap();
	ArrayList pat_ins_bean = new ArrayList();
	

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req,
			HttpServletResponse res) throws javax.servlet.ServletException,
			IOException {
		req= new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		HttpSession session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue("jdbc");
		this.facilityId = (String) session.getValue("facility_id");
		client_ip_address = p.getProperty("client_ip_address");
		associateDiagBean = (RecordSet) session.getValue("associateDiagBean");
		try {
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			String operation = req.getParameter("function_name");
			if (operation.equals("insert")) {
				insertOPClinic(req, res);
			}
			if (operation.equals("modify")) {
				modifyOPClinic(req, res);
			}
		} catch (Exception e) {
			out.println(e.toString());
			e.printStackTrace();
		}
	}

	private void modifyOPClinic(HttpServletRequest req, HttpServletResponse res) {

		try {
			callfunc = checkNull(req.getParameter("call_function"));

			for (int i = 1; i <= 7; i++)
				pract_working_day[i - 1] = req.getParameter("pract_working_day"
						+ i);

			for (int i = 1; i <= 7; i++) {
				working_week_appl[i - 1] = (req
						.getParameter("working_weeks_appt" + i) == null) ? "A"
						: req.getParameter("working_weeks_appt" + i);
			}
			for (int i = 1; i <= 7; i++) {
				working_week_1_day[i - 1] = (req
						.getParameter("working_week_1_day_" + i + "1") == null) ? "H"
						: req.getParameter("working_week_1_day_" + i + "1");
			}
			for (int i = 1; i <= 7; i++) {
				working_week_2_day[i - 1] = (req
						.getParameter("working_week_2_day_" + i + "1") == null) ? "H"
						: req.getParameter("working_week_2_day_" + i + "1");
			}
			for (int i = 1; i <= 7; i++) {
				working_week_3_day[i - 1] = (req
						.getParameter("working_week_3_day_" + i + "1") == null) ? "H"
						: req.getParameter("working_week_3_day_" + i + "1");
			}
			for (int i = 1; i <= 7; i++) {
				working_week_4_day[i - 1] = (req
						.getParameter("working_week_4_day_" + i + "1") == null) ? "H"
						: req.getParameter("working_week_4_day_" + i + "1");
			}
			for (int i = 1; i <= 7; i++) {
				working_week_5_day[i - 1] = (req
						.getParameter("working_week_5_day_" + i + "1") == null) ? "H"
						: req.getParameter("working_week_5_day_" + i + "1");
			}
	
			for (int i = 1; i <= 7; i++) {
				if ((working_week_1_day[i - 1].equals("N") || working_week_1_day[i - 1]
						.equals("H"))
						&& (working_week_2_day[i - 1].equals("N") || working_week_2_day[i - 1]
								.equals("H"))
						&& (working_week_3_day[i - 1].equals("N") || working_week_3_day[i - 1]
								.equals("H"))
						&& (working_week_4_day[i - 1].equals("N") || working_week_4_day[i - 1]
								.equals("H"))
						&& (working_week_5_day[i - 1].equals("N") || working_week_5_day[i - 1]
								.equals("H")))
					working_day[i - 1] = "N";
				else
					working_day[i - 1] = "Y";
			}

			for(int i=1; i<=7; i++)	{					
					max_walkin_for_day[i-1] = (req.getParameter("max_walkin_for_day_" + i ) == null) ? ""
							: req.getParameter("max_walkin_for_day_" + i );
			}
			 
			 //int rec_cnt=associateDiagBean.getSize();					 
			 pat_ins_bean= associateDiagBean.getRecordSetHandle();

                /* for(int m=0;m<rec_cnt;m++)
				{
                   
				}*/
				//associateDiagBean.clearAll();

			modifytabdata(req);

			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter(
					"LOCAL_EJBS") != null)
					&& (getServletConfig().getServletContext()
							.getInitParameter("LOCAL_EJBS")
							.equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(
					"java:comp/env/OPClinic", OPClinicManagerHome.class,
					local_ejbs);
			Object busObj = (home.getClass().getMethod("create", null)).invoke(
					home, null);

			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabdata;

			Class[] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();

			java.util.HashMap results = (java.util.HashMap) (busObj.getClass()
					.getMethod("updateOPClinic", paramArray)).invoke(busObj,
					argArray);

			(busObj.getClass().getMethod("remove", null)).invoke(busObj, null);

			String error_value = "0";
			String error = (String) results.get("error");

			boolean inserted = (((Boolean) results.get("status"))
					.booleanValue());
			if (inserted) {
				error_value = "1";
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
						+ java.net.URLEncoder.encode(error,"UTF-8") + "&err_value="
						+ error_value);
						associateDiagBean.clearAll();
			} else {
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
						+ java.net.URLEncoder.encode(error,"UTF-8"));
			}

			argArray = null;
			paramArray = null;
			results.clear();
			tabdata.clear();

		} catch (Exception e) {

			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+ e.toString());
			//out.println("Values sent are : <br>");
			e.printStackTrace();

		}
	}

	public void modifytabdata(HttpServletRequest req) {
		tabdata.clear();
		tabdata.put("popup_desc", checkNull(req.getParameter("popup_desc"))); // added by mujafar for GHL-CRF-0527
		tabdata.put("alert_req_book_appt_yn", checkNull(req.getParameter("alert_req_book_appt_yn")));
		tabdata.put("isAlertApplicableforBookAppt", checkNull(req.getParameter("isAlertApplicableforBookAppt")));
		tabdata.put("callfunc", callfunc);
		tabdata.put("cliniccode", checkNull(req.getParameter("clinic_code")));
		tabdata.put("clinictype", checkNull(req.getParameter("clinic_type")));
		tabdata.put("clinic_type_sub", checkNull(req.getParameter("clinic_type_sub")));//Added by Ashwini on 01-Dec-2021 for ML-BRU-CRF-0628.6
		tabdata.put("longdesc", checkNull(req.getParameter("long_desc")));
		tabdata.put("shortdesc", checkNull(req.getParameter("short_desc")));
		tabdata.put("physical_locn", checkNull(req.getParameter("physical_locn")));
		tabdata.put("effectiveStatus", checkNullWithDftValue(req
				.getParameter("eff_status"), "D"));
		tabdata.put("disp_in_ca_queue_after", checkNull(req
				.getParameter("disp_in_ca_queue_after")));

		for (int i = 1; i <= 7; i++) {
			tabdata.put("working_week_appl_day_" + i, working_week_appl[i - 1]);
			tabdata.put("working_day_" + i, working_day[i - 1]);
		}
		for (int i = 1; i <= 7; i++) {
			tabdata.put("working_week_1_day_" + i, working_week_1_day[i - 1]);
		}
		for (int i = 1; i <= 7; i++) {
			tabdata.put("working_week_2_day_" + i, working_week_2_day[i - 1]);
		}
		for (int i = 1; i <= 7; i++) {
			tabdata.put("working_week_3_day_" + i, working_week_3_day[i - 1]);
		}
		for (int i = 1; i <= 7; i++) {
			tabdata.put("working_week_4_day_" + i, working_week_4_day[i - 1]);
		}
		for (int i = 1; i <= 7; i++) {
			tabdata.put("working_week_5_day_" + i, working_week_5_day[i - 1]);
		}
		for (int i = 1; i <= 7; i++) {
			tabdata.put("max_walkin_for_day_" + i, max_walkin_for_day[i - 1]);
		}


		tabdata.put("allowvisitregn", checkNullWithDftValue(req
				.getParameter("allow_visit_regn_yn1"), "N"));
		tabdata.put("allowapptmt", checkNullWithDftValue(req
				.getParameter("allow_appt_yn1"), "N"));
		tabdata.put("allow_walk_in_yn", checkNullWithDftValue(req
				.getParameter("allow_walk_in_yn1"), "N"));
		tabdata.put("allow_referral_yn", checkNullWithDftValue(req
				.getParameter("allow_referral_yn1"), "N"));
		tabdata.put("allow_non_referral_yn", checkNullWithDftValue(req
				.getParameter("allow_non_referral_yn1"), "N"));
		tabdata.put("agegroup", checkNull(req.getParameter("age_group")));
		tabdata
				.put("levelofcare",
						checkNull(req.getParameter("level_of_care")));
		tabdata.put("speciality", checkNull(req.getParameter("speciality")));
		tabdata.put("vitalsignsbattery", checkNull(req
				.getParameter("vitalsignsb")));
		tabdata.put("department", checkNull(req.getParameter("department")));
		tabdata.put("sectionCode", checkNull(req.getParameter("section")));
		tabdata.put("service", checkNull(req.getParameter("service")));
		tabdata.put("mrsectiontype", checkNull(req
				.getParameter("mr_section_type")));
		tabdata.put("mrsection", checkNull(req.getParameter("mr_section")));
		tabdata.put("mr_location_code", checkNull(req
				.getParameter("mr_location_code")));
		tabdata.put("online_mr_notfn_yn", checkNullWithDftValue(req
				.getParameter("online_mr_notfn_yn1"), "N"));
		tabdata.put("dfltfiletype", checkNull(req
				.getParameter("dflt_file_type")));
		tabdata.put("emvisittype", checkNullWithDftValue(req
				.getParameter("emergency1"), "N"));
		tabdata.put("rtvisittype", checkNullWithDftValue(req
				.getParameter("routine1"), "N"));
		tabdata.put("srvisittype", checkNullWithDftValue(req
				.getParameter("series1"), "N"));

		if (callfunc.equals("Clinic")) {
			tabdata.put("SPECIALIST_CLINIC_YN", checkNull(req
					.getParameter("specialist_clinic_yn")));
			tabdata.put("visit_pract_yn", checkNull(req
					.getParameter("visit_pract_yn")));
		}
		if (callfunc.equals("ProcedureUnit")) {
			tabdata.put("rd_appl_yn", checkNullWithDftValue(req
					.getParameter("rd_appl_yn"),"N"));			
		}
		if (callfunc.equals("ProcedureUnit") || callfunc.equals("DaycareUnit")) {
			tabdata.put("opclass", checkNullWithDftValue(req
					.getParameter("op_class1"), "N"));
			tabdata.put("ipclass", checkNullWithDftValue(req
					.getParameter("ip_class1"), "N"));
			tabdata.put("dcclass", checkNullWithDftValue(req
					.getParameter("dc_class1"), "N"));
			tabdata.put("emclass", checkNullWithDftValue(req
					.getParameter("em_class1"), "N"));
		}
		if (callfunc.equals("DaycareUnit"))
			tabdata.put("primaryresclass", checkNullWithDftValue(req
					.getParameter("primary_res_class"), "R"));
		else
			tabdata.put("primaryresclass", checkNull(req
					.getParameter("primary_res_class")));

		tabdata.put("fivisittype", checkNullWithDftValue(req
				.getParameter("first1"), "N"));
		tabdata.put("fuvisittype", checkNullWithDftValue(req
				.getParameter("followup1"), "N"));
		tabdata.put("csvisittype", checkNullWithDftValue(req
				.getParameter("consult1"), "N"));
		tabdata.put("practtype",
				checkNull(req.getParameter("primary_res_type")));
		tabdata.put("opentoallpract", checkNullWithDftValue(req
				.getParameter("open_to_all_pract_yn1"), "N"));
		tabdata.put("identitychkin", checkNullWithDftValue(req
				.getParameter("ident_at_checkin"), "X"));
		tabdata.put("allow_unassign_queue", checkNullWithDftValue(req
				.getParameter("allow_unassign_queue1"), "N"));
		tabdata.put("rcdvitsgns", checkNullWithDftValue(req
				.getParameter("record_vital_signs_yn1"), "N"));
		tabdata.put("rcdoutcome", checkNullWithDftValue(req
				.getParameter("record_outcome_yn1"), "N"));
		tabdata.put("rcdimmun", checkNullWithDftValue(req
				.getParameter("record_immun_yn1"), "N"));
		tabdata.put("addedFacilityId", facilityId);
		tabdata.put("addedAtWorkstation", client_ip_address);
		tabdata.put("starttime", checkNull(req.getParameter("start_time")));
		tabdata.put("endtime", checkNull(req.getParameter("end_time")));
		tabdata.put("baseslabslot", checkNull(req
				.getParameter("base_slot_slab_time")));

		num_appl_yn = (req.getParameter("num_appl_yn") == null) ? "N" : req
				.getParameter("num_appl_yn");

		by_pract_yn = (req.getParameter("by_pract_yn") == null) ? "N" : req
				.getParameter("by_pract_yn");

		by_room_yn = (req.getParameter("by_room_yn") == null) ? "N" : req
				.getParameter("by_room_yn");

		by_res_yn = (req.getParameter("by_res_yn") == null) ? "N" : req
				.getParameter("by_res_yn");

		other_res_class = (req.getParameter("other_res") == null) ? "" : req
				.getParameter("other_res");

		other_res_type = (req.getParameter("other_type") == null) ? "" : req
				.getParameter("other_type");
		//Added by Ajay for MMS-DM-CRF-0209.4
        CATEGORY=(req.getParameter("CATEGORY") == null) ? "" : req.getParameter("CATEGORY"); 

		tabdata.put("QUEUE_NUM_APPL_YN", num_appl_yn);
		
		//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 02-05-2023 Started-->
			tabdata.put("Queuenomandate_yn", checkNull(req.getParameter("Queuenomandate_yn")));
		//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 02-05-2023 End-->
		
		tabdata.put("QUEUE_NUM_BY_PRACT_YN", by_pract_yn);
		tabdata.put("QUEUE_NUM_BY_ROOM_YN", by_room_yn);
		tabdata.put("QUEUE_NUM_BY_OTHER_RES_YN", by_res_yn);
		tabdata.put("QUEUE_NUM_OTHER_RES_CLASS", other_res_class);
		tabdata.put("QUEUE_NUM_OTHER_RES_TYPE", other_res_type);
		tabdata.put("pat_ins_bean", pat_ins_bean);
		tabdata.put("CALC_WAIT_TIME_BASED_ON", req.getParameter("cal_wait_time_based")); // Added against Bru-HIMS-CRF-179-DD1		
		//changes for Bru-HIMS-CRF 192.1 starts
		tabdata.put("qms_interfaced_yn", checkNullWithDftValue(req.getParameter("qms_interfaced_yn"), "N"));
		//changes for Bru-HIMS-CRF 192.1 ends
		
		tabdata.put("multi_speciality_yn", checkNullWithDftValue(req.getParameter("multi_speciality_yn"), "N"));//Added for the CRF - Bru-HIMs-CRF-198
		tabdata.put("diagnosis_not_mndt", checkNullWithDftValue(req.getParameter("diagnosis_not_mndt"), "N")); //Added by Sangeetha for ML-MMOH-CRF-0547
		tabdata.put("contactno", checkNull(req.getParameter("contact_no")));//Added by Shagar for MO-CRF-20121.1
		tabdata.put("CATEGORY", CATEGORY);//Added by Ajay for MMS-DM-CRF-0209.4
	}

	private void insertOPClinic(HttpServletRequest req, HttpServletResponse res) {
		try {
			callfunc = checkNull(req.getParameter("call_function"));

			try {

				for (int i = 1; i <= 7; i++) {
					working_week_appl[i - 1] = (req
							.getParameter("working_weeks_appt" + i) == null) ? "A"
							: req.getParameter("working_weeks_appt" + i);
				}
				for (int i = 1; i <= 7; i++) {
					working_week_1_day[i - 1] = (req
							.getParameter("working_week_1_day_" + i + "1") == null) ? "H"
							: req.getParameter("working_week_1_day_" + i + "1");
				}
				for (int i = 1; i <= 7; i++) {
					working_week_2_day[i - 1] = (req
							.getParameter("working_week_2_day_" + i + "1") == null) ? "H"
							: req.getParameter("working_week_2_day_" + i + "1");
				}
				for (int i = 1; i <= 7; i++) {
					working_week_3_day[i - 1] = (req
							.getParameter("working_week_3_day_" + i + "1") == null) ? "H"
							: req.getParameter("working_week_3_day_" + i + "1");
				}
				for (int i = 1; i <= 7; i++) {
					working_week_4_day[i - 1] = (req
							.getParameter("working_week_4_day_" + i + "1") == null) ? "H"
							: req.getParameter("working_week_4_day_" + i + "1");
				}
				for (int i = 1; i <= 7; i++) {
					working_week_5_day[i - 1] = (req
							.getParameter("working_week_5_day_" + i + "1") == null) ? "H"
							: req.getParameter("working_week_5_day_" + i + "1");
				}
				for (int i = 1; i <= 7; i++) {
					if ((working_week_1_day[i - 1].equals("N") || working_week_1_day[i - 1]
							.equals("H"))
							&& (working_week_2_day[i - 1].equals("N") || working_week_2_day[i - 1]
									.equals("H"))
							&& (working_week_3_day[i - 1].equals("N") || working_week_3_day[i - 1]
									.equals("H"))
							&& (working_week_4_day[i - 1].equals("N") || working_week_4_day[i - 1]
									.equals("H"))
							&& (working_week_5_day[i - 1].equals("N") || working_week_5_day[i - 1]
									.equals("H")))
						working_day[i - 1] = "N";
					else
						working_day[i - 1] = "Y";
				}
				for(int i=1; i<=7; i++)
				{
					max_walkin_for_day[i-1] = (req.getParameter("max_walkin_for_day_" + i ) == null) ? ""
							: req.getParameter("max_walkin_for_day_" + i );
				}
				 //int rec_cnt=associateDiagBean.getSize();	
				 pat_ins_bean= associateDiagBean.getRecordSetHandle();
                /* for(int m=0;m<rec_cnt;m++)
				{
                    
				}*/
				//associateDiagBean.clearAll();

			} catch (Exception e) {
				e.printStackTrace();
			}

			Inserttabdata(req);

			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter(
					"LOCAL_EJBS") != null)
					&& (getServletConfig().getServletContext()
							.getInitParameter("LOCAL_EJBS")
							.equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(
					"java:comp/env/OPClinic", OPClinicManagerHome.class,
					local_ejbs);
			Object busObj = (home.getClass().getMethod("create", null)).invoke(
					home, null);

			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabdata;

			Class[] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();

			java.util.HashMap results = (java.util.HashMap) (busObj.getClass()
					.getMethod("insertOPClinic", paramArray)).invoke(busObj,
					argArray);

			(busObj.getClass().getMethod("remove", null)).invoke(busObj, null);

			String error_value = "0";
			String error = (String) results.get("error");
			boolean inserted = (((Boolean) results.get("status"))
					.booleanValue());
			if (inserted) {
				error_value = "1";
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
						+ java.net.URLEncoder.encode(error,"UTF-8") + "&err_value="
						+ error_value);
                         associateDiagBean.clearAll();
			} else {
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
						+ java.net.URLEncoder.encode(error,"UTF-8"));
			}
			argArray = null;
			paramArray = null;
			results.clear();
			tabdata.clear();

		} catch (Exception e) {

			//out.println(e.getMessage());
			//out.println(e.toString());
			e.printStackTrace();

		}
	}

	public void Inserttabdata(HttpServletRequest req) {

		tabdata.clear();
		tabdata.put("callfunc", callfunc);
		tabdata.put("cliniccode", checkNull(req.getParameter("clinic_code")));
		tabdata.put("clinictype", checkNull(req.getParameter("clinic_type")));
		tabdata.put("clinic_type_sub", checkNull(req.getParameter("clinic_type_sub")));//Added by Ashwini on 01-Dec-2021 for ML-BRU-CRF-0628.6
		tabdata.put("longdesc", checkNull(req.getParameter("long_desc")));
		tabdata.put("shortdesc", checkNull(req.getParameter("short_desc")));
		tabdata.put("physical_locn", checkNull(req.getParameter("physical_locn")));
		tabdata.put("effectiveStatus", checkNullWithDftValue(req
				.getParameter("eff_status"), "D"));
		tabdata.put("disp_in_ca_queue_after", checkNull(req
				.getParameter("disp_in_ca_queue_after")));
		tabdata.put("popup_desc", checkNull(req.getParameter("popup_desc")));  // added by mujafar for GHL-CRF-0527
		tabdata.put("alert_req_book_appt_yn", checkNull(req.getParameter("alert_req_book_appt_yn")));
		tabdata.put("isAlertApplicableforBookAppt", checkNull(req.getParameter("isAlertApplicableforBookAppt")));

		for (int i = 1; i <= 7; i++) {
			tabdata.put("working_week_appl_day_" + i, working_week_appl[i - 1]);
			tabdata.put("working_day_" + i, working_day[i - 1]);
		}
		for (int i = 1; i <= 7; i++) {
			tabdata.put("working_week_1_day_" + i, working_week_1_day[i - 1]);
		}
		for (int i = 1; i <= 7; i++) {
			tabdata.put("working_week_2_day_" + i, working_week_2_day[i - 1]);
		}
		for (int i = 1; i <= 7; i++) {
			tabdata.put("working_week_3_day_" + i, working_week_3_day[i - 1]);
		}
		for (int i = 1; i <= 7; i++) {
			tabdata.put("working_week_4_day_" + i, working_week_4_day[i - 1]);
		}
		for (int i = 1; i <= 7; i++) {
			tabdata.put("working_week_5_day_" + i, working_week_5_day[i - 1]);
		}
		for (int i = 1; i <= 7; i++) {
			tabdata.put("max_walkin_for_day_" + i, max_walkin_for_day[i - 1]);
		}

		tabdata.put("allowvisitregn", checkNullWithDftValue(req
				.getParameter("allow_visit_regn_yn1"), "N"));
		tabdata.put("allowapptmt", checkNullWithDftValue(req
				.getParameter("allow_appt_yn1"), "N"));
		tabdata.put("allow_walk_in_yn", checkNullWithDftValue(req
				.getParameter("allow_walk_in_yn1"), "N"));
		tabdata.put("allow_referral_yn", checkNullWithDftValue(req
				.getParameter("allow_referral_yn1"), "N"));
		tabdata.put("allow_non_referral_yn", checkNullWithDftValue(req
				.getParameter("allow_non_referral_yn1"), "N"));
		tabdata.put("agegroup", checkNull(req.getParameter("age_group")));
		tabdata
				.put("levelofcare",
						checkNull(req.getParameter("level_of_care")));
		tabdata.put("speciality", checkNull(req.getParameter("speciality")));
		tabdata.put("vitalsignsbattery", checkNull(req
				.getParameter("vitalsignsb")));
		tabdata.put("department", checkNull(req.getParameter("department")));
		tabdata.put("sectionCode", checkNull(req.getParameter("section")));
		tabdata.put("service", checkNull(req.getParameter("service")));
		tabdata.put("mrsectiontype", checkNull(req
				.getParameter("mr_section_type")));
		tabdata.put("mrsection", checkNull(req.getParameter("mr_section")));
		tabdata.put("mr_location_code", checkNull(req
				.getParameter("mr_location_code")));
		tabdata.put("online_mr_notfn_yn", checkNullWithDftValue(req
				.getParameter("online_mr_notfn_yn1"), "N"));
		tabdata.put("dfltfiletype", checkNull(req
				.getParameter("dflt_file_type")));
		tabdata.put("emvisittype", checkNullWithDftValue(req
				.getParameter("emergency1"), "N"));
		tabdata.put("rtvisittype", checkNullWithDftValue(req
				.getParameter("routine1"), "N"));
		tabdata.put("srvisittype", checkNullWithDftValue(req
				.getParameter("series1"), "N"));

		if (callfunc.equals("Clinic")) {
			tabdata.put("SPECIALIST_CLINIC_YN", checkNull(req
					.getParameter("specialist_clinic_yn")));
			tabdata.put("visit_pract_yn", checkNull(req
					.getParameter("visit_pract_yn")));
		}
		if (callfunc.equals("ProcedureUnit")) {
			tabdata.put("rd_appl_yn", checkNullWithDftValue(req
					.getParameter("rd_appl_yn"),"N"));			
		}
		if (callfunc.equals("ProcedureUnit") || callfunc.equals("DaycareUnit")) {
			tabdata.put("opclass", checkNullWithDftValue(req
					.getParameter("op_class1"), "N"));
			tabdata.put("ipclass", checkNullWithDftValue(req
					.getParameter("ip_class1"), "N"));
			tabdata.put("dcclass", checkNullWithDftValue(req
					.getParameter("dc_class1"), "N"));
			tabdata.put("emclass", checkNullWithDftValue(req
					.getParameter("em_class1"), "N"));
		}
		if (callfunc.equals("DaycareUnit"))
			tabdata.put("primaryresclass", checkNullWithDftValue(req
					.getParameter("primary_res_class"), "R"));
		else
			tabdata.put("primaryresclass", checkNull(req
					.getParameter("primary_res_class")));

		tabdata.put("fivisittype", checkNullWithDftValue(req
				.getParameter("first1"), "N"));
		tabdata.put("fuvisittype", checkNullWithDftValue(req
				.getParameter("followup1"), "N"));
		tabdata.put("csvisittype", checkNullWithDftValue(req
				.getParameter("consult1"), "N"));
		tabdata.put("practtype",
				checkNull(req.getParameter("primary_res_type")));
		tabdata.put("opentoallpract", checkNullWithDftValue(req
				.getParameter("open_to_all_pract_yn1"), "N"));
		tabdata.put("identitychkin", checkNullWithDftValue(req
				.getParameter("ident_at_checkin"), "X"));
		tabdata.put("allow_unassign_queue", checkNullWithDftValue(req
				.getParameter("allow_unassign_queue1"), "N"));
		tabdata.put("rcdvitsgns", checkNullWithDftValue(req
				.getParameter("record_vital_signs_yn1"), "N"));
		tabdata.put("rcdoutcome", checkNullWithDftValue(req
				.getParameter("record_outcome_yn1"), "N"));
		tabdata.put("rcdimmun", checkNullWithDftValue(req
				.getParameter("record_immun_yn1"), "N"));
		tabdata.put("addedFacilityId", facilityId);
		tabdata.put("addedAtWorkstation", client_ip_address);
		tabdata.put("starttime", checkNull(req.getParameter("start_time")));
		tabdata.put("endtime", checkNull(req.getParameter("end_time")));
		tabdata.put("baseslabslot", checkNull(req
				.getParameter("base_slot_slab_time")));

		num_appl_yn = (req.getParameter("num_appl_yn") == null) ? "N" : req
				.getParameter("num_appl_yn");

		by_pract_yn = (req.getParameter("by_pract_yn") == null) ? "N" : req
				.getParameter("by_pract_yn");

		by_room_yn = (req.getParameter("by_room_yn") == null) ? "N" : req
				.getParameter("by_room_yn");

		by_res_yn = (req.getParameter("by_res_yn") == null) ? "N" : req
				.getParameter("by_res_yn");

		other_res_class = (req.getParameter("other_res") == null) ? "" : req
				.getParameter("other_res");

		other_res_type = (req.getParameter("other_type") == null) ? "" : req
				.getParameter("other_type");
		//Added by Ajay for MMS-DM-CRF-0209.4
		CATEGORY=(req.getParameter("CATEGORY") == null) ? "" : req.getParameter("CATEGORY");
		tabdata.put("QUEUE_NUM_APPL_YN", num_appl_yn);
		
		//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 02-05-2023 Started-->
		System.err.println("Queuenomandate_ynQueuenomandate_ynQueuenomandate_ynQueuenomandate_yn "+req.getParameter("Queuenomandate_yn"));
		tabdata.put("Queuenomandate_yn", checkNull(req.getParameter("Queuenomandate_yn")));
		//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 02-05-2023 End-->
		
		tabdata.put("QUEUE_NUM_BY_PRACT_YN", by_pract_yn);
		tabdata.put("QUEUE_NUM_BY_ROOM_YN", by_room_yn);
		tabdata.put("QUEUE_NUM_BY_OTHER_RES_YN", by_res_yn);
		tabdata.put("QUEUE_NUM_OTHER_RES_CLASS", other_res_class);
		tabdata.put("QUEUE_NUM_OTHER_RES_TYPE", other_res_type);
        tabdata.put("pat_ins_bean",pat_ins_bean );
		tabdata.put("CALC_WAIT_TIME_BASED_ON", req.getParameter("cal_wait_time_based")); // Added against Bru-HIMS-CRF-179-DD1
		//changes for Bru-HIMS-CRF 192.1 starts
		tabdata.put("qms_interfaced_yn", checkNullWithDftValue(req.getParameter("qms_interfaced_yn"), "N"));
		//changes for Bru-HIMS-CRF 192.1 ends
		tabdata.put("multi_speciality_yn", checkNullWithDftValue(req.getParameter("multi_speciality_yn"), "N"));//Added for the CRF - Bru-HIMS-CRF-0198
		tabdata.put("diagnosis_not_mndt", checkNullWithDftValue(req.getParameter("diagnosis_not_mndt"), "N")); //Added by Sangeetha for ML-MMOH-CRF-0547
		tabdata.put("contactno", checkNull(req.getParameter("contact_no")));//Added by Shagar for MO-CRF-20121.1
		tabdata.put("CATEGORY", CATEGORY); // Added by Ajay for MMS-DM-CRF-0209.4
	}

	public static String checkNull(String str) {
		return ((str == null || str.equals("null")) ? "" : str);
	}
		
	public static String checkNullWithDftValue(String str, String dftval) {
		return ((str == null || str.equals("null")) ? dftval : str);
	}

}
