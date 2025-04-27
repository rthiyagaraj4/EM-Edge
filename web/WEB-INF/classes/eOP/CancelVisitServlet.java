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
import webbeans.eCommon.*;
import javax.rmi.*;
import eOP.CancelVisit.*;

public class CancelVisitServlet extends javax.servlet.http.HttpServlet {
	PrintWriter out;

	java.util.Properties p;

	String facilityId;

	String client_ip_address;

	String locale = "";

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req,
			HttpServletResponse res) throws javax.servlet.ServletException,
			IOException {

		HttpSession session = req.getSession(false);
		this.facilityId = (String) session.getValue("facility_id");
		this.p = (java.util.Properties) session.getValue("jdbc");
		this.client_ip_address = p.getProperty("client_ip_address");
		locale = p.getProperty("LOCALE");
		try {
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			String operation = req.getParameter("function");

			if (operation.equals("modify"))
				modifyCancelVisit(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void modifyCancelVisit(HttpServletRequest req,
			HttpServletResponse res) {
		try {

			HashMap VisitData = new HashMap();

			VisitData.put("encounter_id", checkNull(req
					.getParameter("encounter_id")));
			VisitData.put("facility_id", facilityId);
			VisitData.put("patient_id", checkNull(req
					.getParameter("patient_id")));
			VisitData.put("appt_case_yn", checkNull(req
					.getParameter("appt_case_yn")));
			VisitData
					.put("module_id", checkNull(req.getParameter("module_id")));
			VisitData.put("episode_type", checkNull(req
					.getParameter("episode_type")));
			VisitData.put("visit_adm_type", checkNull(req
					.getParameter("visit_adm_type")));
			VisitData.put("episode_id", checkNull(req
					.getParameter("episode_id")));
			VisitData.put("assign_care_locn_code", checkNull(req
					.getParameter("assign_care_locn_code")));
			VisitData.put("assign_care_locn_type", checkNull(req
					.getParameter("assign_care_locn_type")));

			VisitData.put("attend_practitioner_id", checkNull(req
					.getParameter("attend_practitioner_id")));
			VisitData.put("service_code", checkNull(req
					.getParameter("service_code")));
			VisitData.put("subservice_code", checkNull(req
					.getParameter("subservice_code")));
			VisitData.put("reason", checkNull(req.getParameter("reason")));
			VisitData.put("bl_interfaced_yn", checkNull(req
					.getParameter("bl_interfaced_yn")));
			VisitData.put("op_episode_visit_num", checkNull(req
					.getParameter("op_episode_visit_num")));
			VisitData.put("visit_type_ind", checkNull(req
					.getParameter("visit_type_ind")));

			VisitData.put("count1", new Integer(Integer.parseInt(req
					.getParameter("count1"))));
			VisitData.put("policy_type_code", checkNull(req
					.getParameter("policy_type_code")));
			VisitData
					.put("cust_code", checkNull(req.getParameter("cust_code")));

			VisitData.put("workstation", checkNull(client_ip_address));

			VisitData.put("referral_id", checkNull(req
					.getParameter("referral_id")));
			VisitData.put("delink_referral", checkNull(req
					.getParameter("delink_referral")));
			VisitData.put("cancel_reason_code", checkNull(req
					.getParameter("cancel_reason_code")));

			//Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
			VisitData.put("other_remarks", checkNull(req
					.getParameter("other_remarks")));

			VisitData.put("appointment_no", checkNull(req
					.getParameter("appointment_no")));
			VisitData.put("arrive_data_time", checkNull(req
					.getParameter("arrive_data_time")));
			VisitData.put("vital_signs_date_time", checkNull(req
					.getParameter("vital_signs_date_time")));
			VisitData.put("multi_speciality_yn", checkNull(req
					.getParameter("multi_speciality_yn")));//Added for the CRF - Bru - HIMS-CRF-0198

			Hashtable BLVisitData = new Hashtable();

			BLVisitData.put("encounter_id", checkNull(req
					.getParameter("encounter_id")));
			BLVisitData.put("facility_id", facilityId);
			BLVisitData.put("patient_id", checkNull(req
					.getParameter("patient_id")));
			BLVisitData.put("appt_case_yn", checkNull(req
					.getParameter("appt_case_yn")));
			BLVisitData.put("module_id", checkNull(req
					.getParameter("module_id")));
			BLVisitData.put("episode_type", checkNull(req
					.getParameter("episode_type")));
			BLVisitData.put("visit_adm_type", checkNull(req
					.getParameter("visit_adm_type")));
			BLVisitData.put("episode_id", checkNull(req
					.getParameter("episode_id")));
			BLVisitData.put("assign_care_locn_code", checkNull(req
					.getParameter("assign_care_locn_code")));
			BLVisitData.put("assign_care_locn_type", checkNull(req
					.getParameter("assign_care_locn_type")));

			BLVisitData.put("attend_practitioner_id", checkNull(req
					.getParameter("attend_practitioner_id")));
			BLVisitData.put("service_code", checkNull(req
					.getParameter("service_code")));
			BLVisitData.put("subservice_code", checkNull(req
					.getParameter("subservice_code")));
			BLVisitData.put("reason", checkNull(req.getParameter("reason")));
			BLVisitData.put("bl_interfaced_yn", checkNull(req
					.getParameter("bl_interfaced_yn")));
			BLVisitData.put("op_episode_visit_num", checkNull(req
					.getParameter("op_episode_visit_num")));
			BLVisitData.put("visit_type_ind", checkNull(req
					.getParameter("visit_type_ind")));
			BLVisitData.put("count1", new Integer(Integer.parseInt(req
					.getParameter("count1"))));
			BLVisitData.put("policy_type_code", checkNull(req
					.getParameter("policy_type_code")));
			BLVisitData.put("cust_code", checkNull(req
					.getParameter("cust_code")));

			BLVisitData.put("workstation", checkNull(client_ip_address));

			BLVisitData.put("referral_id", checkNull(req
					.getParameter("referral_id")));
			BLVisitData.put("delink_referral", checkNull(req
					.getParameter("delink_referral")));
			BLVisitData.put("cancel_reason_code", checkNull(req
					.getParameter("cancel_reason_code")));

			//Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
			BLVisitData.put("other_remarks", checkNull(req
					.getParameter("other_remarks")));

			BLVisitData.put("appointment_no", checkNull(req
					.getParameter("appointment_no")));
			BLVisitData.put("arrive_data_time", checkNull(req
					.getParameter("arrive_data_time")));
			BLVisitData.put("vital_signs_date_time", checkNull(req
					.getParameter("vital_signs_date_time")));

			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter(
					"LOCAL_EJBS") != null)
					&& (getServletConfig().getServletContext()
							.getInitParameter("LOCAL_EJBS")
							.equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home =com.ehis.eslp.ServiceLocator.getInstance()
					.getHome("java:comp/env/CancelVisitManager",
							CancelVisitManagerHome.class, local_ejbs);
			Object busObj = (home.getClass().getMethod("create", null)).invoke(
					home, null);

			Object argArray[] = new Object[3];
			argArray[0] = p;
			argArray[1] = VisitData;
			argArray[2] = BLVisitData;

			Class[] paramArray = new Class[3];
			paramArray[0] = p.getClass();
			paramArray[1] = VisitData.getClass();
			paramArray[2] = BLVisitData.getClass();

			java.util.HashMap results = (java.util.HashMap) (busObj.getClass()
					.getMethod("updateCancelVisit", paramArray)).invoke(busObj,
					argArray);

			(busObj.getClass().getMethod("remove", null)).invoke(busObj, null);

			boolean inserted = (((Boolean) results.get("status"))
					.booleanValue());

			String error = (String) results.get("error");
			String error_value = "0";

			if (inserted) {
				error_value = "1";
				MessageManager mm = new MessageManager();
				final java.util.Hashtable mesg = mm.getMessage(locale,
						"RECORD_MODIFIED", "SM");
				String msg1 = (String) mesg.get("message");
				out.println("<html><script>alert('" + msg1
						+ "');</script></html>");

				//out.println("<html><script>alert(getMessage(\"RECORD_MODIFIED\",\"SM\"));</script></html>");

						out.println("<script language='JavaScript'>parent.onSuccess(); </script>");
			} else {
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num= "
						+ java.net.URLEncoder.encode(error,"UTF-8") + "&err_value="
						+ error_value);
			}

			argArray = null;
			paramArray = null;
			results.clear();
			VisitData.clear();
			BLVisitData.clear();

		} catch (Exception e) {
			out.println(e.getMessage());
			out.println(e.toString());
			e.printStackTrace();
		}
	}

	public static String checkNull(String str) {
		return ((str == null || str.equals("null")) ? "" : str);
	}

}
