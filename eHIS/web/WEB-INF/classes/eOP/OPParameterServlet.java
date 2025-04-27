/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOP;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.util.*;

import eCommon.SingleTabHandler.*;

public class OPParameterServlet extends javax.servlet.http.HttpServlet {
	PrintWriter out;

	java.util.Properties p;

	String BOEpisode;

	String BlInterfaceYN = "";

	String facilityId;

	String client_ip_address;

	String install_yn;
   
	
	HttpSession session;

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(
			"yyyy-MM-dd");
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req,
			HttpServletResponse res) throws javax.servlet.ServletException,
			IOException {
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue("jdbc");
		this.facilityId = (String) session.getValue("facility_id");
		client_ip_address = p.getProperty("client_ip_address");

		try {
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			String operation = req.getParameter("function");
			install_yn = req.getParameter("InstallYN");

						
			if (operation.equals("insert"))
				insertOPParameter(req, res);
			if (operation.equals("modify"))
				modifyOPParameter(req, res);
		} catch (Exception e) {
			out.println(e.toString());
			e.printStackTrace();
		}
	}

	private synchronized void modifyOPParameter(HttpServletRequest req,
			HttpServletResponse res) {
		try {
			BOEpisode = req.getParameter("BOEpisode");

			if (install_yn.equals("Y")) {
				BlInterfaceYN = req.getParameter("bl_interface_yn");

			}
			if (BOEpisode == null || BOEpisode.equals("N")) {

				BOEpisode = "N";
			} else

			if (install_yn.equals("Y")) {
				if (BlInterfaceYN == null)
					BlInterfaceYN = "N";
			}

			String addedById = p.getProperty("login_user");
			String addedDate = dateFormat.format(new java.util.Date());
			String modifiedById = addedById;
			String modifiedDate = addedDate;
			String addedFacilityId = facilityId;
			String modifiedFacilityId = addedFacilityId;
			String addedAtWorkstation = client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation;
					
			java.sql.Date modified_date = java.sql.Date.valueOf(modifiedDate);

			HashMap tabdata = new HashMap();
			tabdata.put("VISIT_REV_CANCEL_DAYS", checkNull(req
			.getParameter("Visit_Control")));
			 
			tabdata.put("VISIT_BACKDATING_ALLOWED_YN", checkNullWithDftValue(req.getParameter("visit_backdating_allowed_yn"),"N"));
			tabdata.put("VISIT_BACKDATE_DAYS",checkNull(req.getParameter("visit_backdate_days")));
			tabdata.put("VISIT_COMPL_DAYS", checkNull(req
					.getParameter("Visit_Completion")));
			tabdata.put("DISP_REQD_FOR_MDS_YN", checkNullWithDftValue(req
					.getParameter("disposition"), "N"));
			tabdata.put("DIAG_REQD_FOR_MDS_YN", checkNullWithDftValue(req
					.getParameter("pdiagnosis"), "N"));
			tabdata.put("NOTES_REQD_FOR_MDS_YN", checkNullWithDftValue(req
					.getParameter("notes"), "N"));
			tabdata.put("BUILD_EPISODE_RULE", "S");
			tabdata.put("BUILD_EPISODE_YN", "Y");
			tabdata.put("EPISODE_CLOSE_DAYS_FU ", checkNull(req
					.getParameter("follow_up")));  
			tabdata.put("ALLOW_WL_INV_WO_APPT_YN", checkNull(req
					.getParameter("wait_list_yn")));  
			tabdata.put("EPISODE_CLOSE_DAYS_WO_FU", checkNull(req
					.getParameter("no_follow_up")));
			tabdata.put("VITAL_SIGNS_BATTERY_ID", checkNull(req
					.getParameter("group")));
			tabdata.put("CI_PERIOD_IN_MIN_FOR_ONTIME", checkNull(req
					.getParameter("OntimeApptStatus")));
			tabdata.put("CI_PERIOD_IN_MIN_FOR_NOSHOW", checkNull(req
					.getParameter("NOShowApptStatus")));
			tabdata.put("DISP_TYPE_FOR_AUTO_VISIT_COMPL", checkNull(req.getParameter("disptype")));
			tabdata.put("DISP_TYPE_FOR_CHECKOUT", checkNull(req.getParameter("DISP_TYPE_FOR_CHECKOUT")));
			tabdata.put("REVOKE_DEATH_DISP_TYPE", checkNull(req.getParameter("DISP_TYPE_FOR_REVOKE_DEATH")));  // added by mujafar  for ML-MMOH-CRF-1427
			
			tabdata.put("OPER_STN_ACCESS_RULE", "U");
			tabdata.put("QUEUE_REFRESH_INTERVAL", checkNull(req
					.getParameter("RefreshInterval")));
			tabdata.put("ALLOW_EMER_REGN_YN", checkNull(req
					.getParameter("emer_pat_yn")));				
			tabdata.put("OVERRIDE_VTYPE_ON_EPSD_YN", checkNullWithDftValue(req
					.getParameter("override_episode_yn"), "N"));
			tabdata.put("modified_by_id", modifiedById);
			tabdata.put("modified_date", modified_date);
			tabdata.put("modified_facility_id", checkNull(modifiedFacilityId));
			tabdata.put("modified_at_ws_no", modifiedAtWorkstation); 		
			tabdata.put("ACCEPT_DISPLAY_INV_NO", checkNullWithDftValue(req
					.getParameter("allow_inv_no"),"A"));
			tabdata.put("ASSIGN_QUEUE_NUM_BY", checkNullWithDftValue(req
					.getParameter("assign_q_num_by"),"S"));
			tabdata.put("OVERRIDE_PRACT_FOR_APPT_YN", checkNullWithDftValue(req
					.getParameter("override_pract_for_appt_yn"),"N"));
			tabdata.put("VALIDATE_NATID_REG_VISIT", checkNullWithDftValue(req
					.getParameter("validate_natid_reg_visit"),"N"));
			tabdata.put("REG_VISIT_FOR_INPAT_YN", checkNullWithDftValue(req
					.getParameter("reg_visit_for_inpat_yn"),"N"));
			tabdata.put("inv_visitregn_mpq_from_ca_yn", checkNullWithDftValue(req.getParameter("inv_visitregn_mpq_from_ca_yn"),"N")); 			
			tabdata.put("inc_arrive_cons_start_pats_yn", checkNullWithDftValue(req.getParameter("inc_arrive_cons_start_pats_yn"),"N")); 			
			tabdata.put("NO_OF_FOLLOW_UP_VISITS_ALLOWED",checkNull(req
					.getParameter("Max_no_visit")));
			tabdata.put("DUR_FOR_FOLLOW_UP_VSTS_IN_DAYS", checkNull(req
					.getParameter("Max_dur_allow"))); 
			tabdata.put("REG_REFERRAL_ON_CHECKOUT_YN", checkNullWithDftValue(req
					.getParameter("registre_reff_yn"),"N"));
			tabdata.put("CLOSE_PAT_CHART_ON_CHECKOUT_YN", checkNullWithDftValue(req
					.getParameter("clo_pat_cha_clo_con_yn"),"N"));
			tabdata.put("USE_TEMPLATE_IN_VIS_REGN_YN", checkNullWithDftValue(req
					.getParameter("ean_vst_dtls_temp_yn"),"N"));
			//Added by Ajay H. for MMS-DM-CRF 0209.4
			tabdata.put("CLINIC_CATAGORY_YN", checkNullWithDftValue(req.getParameter("cliniccatagory"),"N"));
			tabdata.put("CLINIC_CATAGORY_MAND_YN", checkNullWithDftValue(req.getParameter("clinicCatagoryman"),"N"));
			tabdata.put("REFERRAL_REQ_YN", checkNullWithDftValue(req.getParameter("ClinicRefrlReq"),"N"));
			 tabdata.put("visit_type_derv_rule",checkNull(req.getParameter("visit_type_derv_rule"))); 
			 tabdata.put("dflt_rule_id",checkNull(req.getParameter("dfltruleid"))); 
			 tabdata.put("mins1_for_wait_time",checkNull(req.getParameter("minMinutes"))); 
			 tabdata.put("mins2_for_wait_time",checkNull(req.getParameter("maxMinutes"))); 
			 //Maheshwaran K added for the Bru-HIMS-CRF-170(IN030289) as on 06/08/2013
			 //Start
			 tabdata.put("episode_closure_by",checkNull(req.getParameter("episode_closure_by"))); 
			 //End	
			tabdata.put("ACTION_ON_PENDING_BILL",checkNull(req.getParameter("action_on_pending_bill")));
			
			tabdata.put("action_on_pract_schedule",checkNull(req.getParameter("action_on_pract_schedule"))); // Added For JD-CRF-0183 [IN:041353] by Dharma on Nov 14th 2013
			
			tabdata.put("QUEUE_NO_MNDT_YN",checkNull(req.getParameter("mand_queue_no_chk_yn")));//Added by Shanmukh on 29th-JUNE-2018 for ML-MMOH-CRF-1121
			tabdata.put("calc_wait_time_based_on", checkNullWithDftValue(req
					.getParameter("cal_wait_time_based"),"01")); // Added against Bru-HIMS-CRF-179-DD1
					
			if (install_yn.equals("Y")) {
				tabdata.put("BL_INTERFACED_YN",checkNull(BlInterfaceYN));
			}

			HashMap condflds = new HashMap();
			condflds.put("OPERATING_FACILITY_ID",checkNull(facilityId));

			String tabname = "op_param";

			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter(
					"LOCAL_EJBS") != null)
					&& (getServletConfig().getServletContext()
							.getInitParameter("LOCAL_EJBS")
							.equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(
					"java:comp/env/SingleTabHandler",
					SingleTabHandlerManagerHome.class, local_ejbs);
			Object busObj = (home.getClass().getMethod("create", null)).invoke(
					home, null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = tabname;

			Class[] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = tabname.getClass();

			java.util.HashMap results = (java.util.HashMap) (busObj.getClass()
					.getMethod("update", paramArray)).invoke(busObj, argArray);
			boolean inserted = (((Boolean) results.get("status"))
					.booleanValue());

			String error = (String) results.get("error");
			String error_value = "0";
			if (inserted) {
				error_value = "1";
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
						+ java.net.URLEncoder.encode(error,"UTF-8") + "&err_value="
						+ error_value);
			} else {
				error = (String) results.get("error");
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
						+ java.net.URLEncoder.encode(error,"UTF-8"));
			}
			argArray = null;
			paramArray = null;
			tabdata.clear();
			results.clear();
			condflds.clear();
		} catch (Exception e) {
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "
							+ e.toString());
							e.printStackTrace();

		}
	}

	private synchronized void insertOPParameter(HttpServletRequest req,
			HttpServletResponse res) {
		try {
			BOEpisode = req.getParameter("BOEpisode");
			if (install_yn.equals("Y")) {
			BlInterfaceYN = req.getParameter("bl_interface_yn");

			}

			if (BOEpisode == null || BOEpisode.equals("N")
					|| BOEpisode.equals("")) {

				BOEpisode = "N";
			}

			if(install_yn.equals("Y")) {
				if(BlInterfaceYN == null)
					BlInterfaceYN = "N";
			}

			String addedById = p.getProperty("login_user");
			String addedDate = dateFormat.format(new java.util.Date());
			String modifiedById = addedById;
			String modifiedDate = addedDate;
			String addedFacilityId = facilityId;
			String modifiedFacilityId = addedFacilityId;
			String addedAtWorkstation = client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation;

			java.sql.Date added_date = java.sql.Date.valueOf(addedDate);
			java.sql.Date modified_date = java.sql.Date.valueOf(modifiedDate);

			HashMap tabdata = new HashMap();
			tabdata.put("OPERATING_FACILITY_ID", facilityId);
			tabdata.put("VISIT_REV_CANCEL_DAYS", checkNull(req
			.getParameter("Visit_Control")));			
			tabdata.put("VISIT_BACKDATING_ALLOWED_YN", checkNullWithDftValue(req.getParameter("visit_backdating_allowed_yn"),"N"));
			tabdata.put("VISIT_BACKDATE_DAYS",checkNull(req.getParameter("visit_backdate_days")));
			tabdata.put("VISIT_COMPL_DAYS", checkNull(req
					.getParameter("Visit_Completion")));
			tabdata.put("DISP_REQD_FOR_MDS_YN", checkNullWithDftValue(req
					.getParameter("disposition"), "N"));
			tabdata.put("DIAG_REQD_FOR_MDS_YN", checkNullWithDftValue(req
					.getParameter("pdiagnosis"), "N"));
			tabdata.put("NOTES_REQD_FOR_MDS_YN", checkNullWithDftValue(req
					.getParameter("notes"), "N"));
			tabdata.put("BUILD_EPISODE_RULE", "S");
			tabdata.put("BUILD_EPISODE_YN", "Y");
			tabdata.put("EPISODE_CLOSE_DAYS_FU ", checkNull(req
					.getParameter("follow_up")));
			tabdata.put("EPISODE_CLOSE_DAYS_WO_FU", checkNull(req
					.getParameter("no_follow_up")));
			tabdata.put("VITAL_SIGNS_BATTERY_ID", checkNull(req
					.getParameter("group")));	   
			tabdata.put("ALLOW_WL_INV_WO_APPT_YN", checkNull(req
					.getParameter("wait_list_yn")));  
			tabdata.put("CI_PERIOD_IN_MIN_FOR_ONTIME", checkNull(req
					.getParameter("OntimeApptStatus")));
			tabdata.put("CI_PERIOD_IN_MIN_FOR_NOSHOW", checkNull(req
					.getParameter("NOShowApptStatus")));
			tabdata.put("DISP_TYPE_FOR_AUTO_VISIT_COMPL", checkNull(req.getParameter("disptype")));
			tabdata.put("DISP_TYPE_FOR_CHECKOUT", checkNull(req.getParameter("DISP_TYPE_FOR_CHECKOUT")));
			tabdata.put("REVOKE_DEATH_DISP_TYPE", checkNull(req.getParameter("DISP_TYPE_FOR_REVOKE_DEATH"))); // added by mujafar  for ML-MMOH-CRF-1427
			
			tabdata.put("OPER_STN_ACCESS_RULE", "U");
			tabdata.put("QUEUE_REFRESH_INTERVAL", checkNull(req
					.getParameter("RefreshInterval")));
			tabdata.put("ALLOW_EMER_REGN_YN", checkNull(req
					.getParameter("emer_pat_yn")));					
			tabdata.put("OVERRIDE_VTYPE_ON_EPSD_YN", checkNullWithDftValue(req
					.getParameter("override_episode_yn"), "N")); 		
			tabdata.put("ACCEPT_DISPLAY_INV_NO", checkNullWithDftValue(req
					.getParameter("allow_inv_no"),"A"));
			tabdata.put("ASSIGN_QUEUE_NUM_BY", checkNullWithDftValue(req
					.getParameter("assign_q_num_by"),"S"));
			tabdata.put("OVERRIDE_PRACT_FOR_APPT_YN", checkNullWithDftValue(req
					.getParameter("override_pract_for_appt_yn"),"N"));
			tabdata.put("VALIDATE_NATID_REG_VISIT", checkNullWithDftValue(req
					.getParameter("validate_natid_reg_visit"),"N"));
			tabdata.put("REG_VISIT_FOR_INPAT_YN", checkNullWithDftValue(req
					.getParameter("reg_visit_for_inpat_yn"),"N"));
             tabdata.put("inv_visitregn_mpq_from_ca_yn", checkNullWithDftValue(req.getParameter("inv_visitregn_mpq_from_ca_yn"),"N")); 
             tabdata.put("inc_arrive_cons_start_pats_yn", checkNullWithDftValue(req.getParameter("inc_arrive_cons_start_pats_yn"),"N")); 
             tabdata.put("NO_OF_FOLLOW_UP_VISITS_ALLOWED",checkNull (req
					.getParameter("Max_no_visit")));   			
			 tabdata.put("DUR_FOR_FOLLOW_UP_VSTS_IN_DAYS",checkNull(req
					.getParameter("Max_dur_allow"))); 
			tabdata.put("REG_REFERRAL_ON_CHECKOUT_YN", checkNullWithDftValue(req
					.getParameter("registre_reff_yn"),"N"));
			tabdata.put("CLOSE_PAT_CHART_ON_CHECKOUT_YN",checkNullWithDftValue(req
					.getParameter("clo_pat_cha_clo_con_yn"),"N"));				
       		tabdata.put("USE_TEMPLATE_IN_VIS_REGN_YN", checkNullWithDftValue(req.getParameter("ean_vst_dtls_temp_yn"),"N"));   			 
			 tabdata.put("CLINIC_CATAGORY_YN", checkNullWithDftValue(req.getParameter("cliniccatagory"),"N"));
       		tabdata.put("CLINIC_CATAGORY_MAND_YN", checkNullWithDftValue(req.getParameter("clinicCatagoryman"),"N"));				 
       		tabdata.put("REFERRAL_REQ_YN", checkNullWithDftValue(req.getParameter("ClinicRefrlReq"),"N"));				 
			 tabdata.put("visit_type_derv_rule",checkNull(req.getParameter("visit_type_derv_rule"))); 
			 tabdata.put("dflt_rule_id",checkNull(req.getParameter("dfltruleid"))); 
			 tabdata.put("mins1_for_wait_time",checkNull(req.getParameter("minMinutes"))); 
			 tabdata.put("mins2_for_wait_time",checkNull(req.getParameter("maxMinutes"))); 
			 tabdata.put("QUEUE_NO_MNDT_YN",checkNull(req.getParameter("mand_queue_no_chk_yn")));//Added by Shanmukh on 29th-JUNE-2018 for ML-MMOH-CRF-1121
			 tabdata.put("calc_wait_time_based_on", checkNullWithDftValue(req
					.getParameter("cal_wait_time_based"),"01")); // Added against Bru-HIMS-CRF-179-DD1
			if (install_yn.equals("Y")) {
				tabdata.put("BL_INTERFACED_YN", BlInterfaceYN);

			}
			/** Unknown Fields* */
			tabdata.put("REF_REQD_FOR_FI_VISIT_YN", "N");
			tabdata.put("DESC_REQD_FOR_WALKIN_YN", "N");
			tabdata.put("PAT_REGN_VERIFY_FUNC", "N");
			tabdata.put(" PAT_REGN_VERIFY_CHECKIN_YN     ", "N");
			tabdata.put("SRVC_ITEM_INTERFACE_STAGE", "N");
			tabdata.put("BASIC_VISIT_HIST_YN", "N");
			tabdata.put("ADDNL_VISIT_HIST_YN", "N");
			tabdata.put("DISP_VISIT_HIST_YN", "N");
			tabdata.put("CANCEL_VISIT_HIST_YN", "N");
			tabdata.put("CONSULT_VISIT_HIST_YN", "N");

			tabdata.put("added_by_id", addedById);
			tabdata.put("added_date", added_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no", addedAtWorkstation);
			tabdata.put("modified_by_id", modifiedById);
			tabdata.put("modified_date", modified_date);
			tabdata.put("modified_facility_id", modifiedFacilityId);
			tabdata.put("modified_at_ws_no", modifiedAtWorkstation);
			 //Maheshwaran K added for the Bru-HIMS-CRF-170(IN030289) as on 06/08/2013
			 //Start
			 tabdata.put("episode_closure_by",checkNull(req.getParameter("episode_closure_by"))); 
			 //End
			 tabdata.put("ACTION_ON_PENDING_BILL",checkNull(req.getParameter("action_on_pending_bill")));
			 tabdata.put("action_on_pract_schedule",checkNull(req.getParameter("action_on_pract_schedule"))); // Added For JD-CRF-0183 [IN:041353] by Dharma on Nov 14th 2013
			String dupflds[] = new String[0];

			String tabname = "op_param";

			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter(
					"LOCAL_EJBS") != null)
					&& (getServletConfig().getServletContext()
							.getInitParameter("LOCAL_EJBS")
							.equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(
					"java:comp/env/SingleTabHandler",
					SingleTabHandlerManagerHome.class, local_ejbs);
			Object busObj = (home.getClass().getMethod("create", null)).invoke(
					home, null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = tabname;

			Class[] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = tabname.getClass();

			java.util.HashMap results = (java.util.HashMap) (busObj.getClass()
					.getMethod("insert", paramArray)).invoke(busObj, argArray);

			boolean inserted = (((Boolean) results.get("status"))
					.booleanValue());

			String error = (String) results.get("error");
			String error_value = "0";
			if (inserted) {
				error_value = "1";
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
						+ java.net.URLEncoder.encode(error,"UTF-8") + "&err_value="
						+ error_value);
			} else {
				error = (String) results.get("error");
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
						+ java.net.URLEncoder.encode(error,"UTF-8"));
			}
			res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
					+ java.net.URLEncoder.encode(error,"UTF-8"));

			error = (String) results.get("error");
			res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
					+ java.net.URLEncoder.encode(error,"UTF-8"));

			results.clear();
			argArray = null;
			paramArray = null;
			tabdata.clear();

		} catch (Exception e) {
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "
							+ e.toString());
							e.printStackTrace();

		}
	}

	public static String checkNull(String str) {
		return ((str == null || str.equals("null") || str.equals("")) ? ""
				: str);
	}

	public static String checkNullWithDftValue(String str, String dftval) {
		return ((str == null || str.equals("null") || str.equals("")) ? dftval
				: str);
	}

}
