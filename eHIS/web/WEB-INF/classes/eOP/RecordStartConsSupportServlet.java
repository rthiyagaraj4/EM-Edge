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
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.text.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import eOP.StartCons.*;
import eOP.QmgmtRe_AssignPract.*;
import eCommon.XSSRequestWrapper;

public class RecordStartConsSupportServlet extends
		javax.servlet.http.HttpServlet {
	StringBuffer sb = new StringBuffer("");

	PrintWriter out;

	java.util.Properties p;

	String facilityId;

	String client_ip_address;

	String p_queue_date;
	String locale;

	HttpSession session;

	String from = "";

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req,
			HttpServletResponse res) throws javax.servlet.ServletException,
			IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		req= new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue("jdbc");
		this.facilityId = (String) session.getValue("facility_id");
		client_ip_address = p.getProperty("client_ip_address");
		locale = p.getProperty("LOCALE");//Added by Thamizh selvi on 17th Oct 2017 for ML-MMOH-CRF-0623

		try {
			this.out = res.getWriter();
			String operation = req.getParameter("function");
			if (operation.equals("update"))
				updateRecordStartCons(req, res);
			else
				assignPractitioner(req, res);
		} catch (Exception e) {
			out.println("Exception in doPost:" + e.toString());
		}
	}

	public void updateRecordStartCons(HttpServletRequest req,
			HttpServletResponse res) throws javax.servlet.ServletException,
			IOException {
		try {
			HashMap tabdata = new HashMap();

			tabdata.put("facilityId", facilityId);
			tabdata.put("encounterid", checkNull(req
					.getParameter("encounterid")));
			tabdata.put("client_ip_address", client_ip_address);
			
			tabdata.put("patientid",checkNull(req.getParameter("patientid"))); //this line added for this CRF Bru-HIMS-CRF-133
			tabdata.put("p_queue_date", checkNull(req.getParameter("queue_date"))); //this line added for this CRF Bru-HIMS-CRF-133
			tabdata.put("isPatientEncMovement", checkNull(req.getParameter("isPatientEncMovement"))); //this line added for this CRF Bru-HIMS-CRF-133
            tabdata.put("Sydate", checkNull(req.getParameter("Sydate"))); //this line added for this CRF Bru-HIMS-CRF-133
			
			/*Added by Thamizh selvi on 20th Oct 2017 for ML-MMOH-CRF-0623 Start*/
			String moduleId				= checkNull(req.getParameter("moduleId"));
			String insertBackDatedConsY	= checkNullWithDftValue(req.getParameter("insertBackDatedConsY"), "N");
			String allowBackdateConsYn	= checkNullWithDftValue(req.getParameter("allowBackdateConsYn"), "N");
			String startConsDateTime	= checkNull(req.getParameter("start_cons_date_time"));
			if(!startConsDateTime.equals(""))
				 startConsDateTime=com.ehis.util.DateUtils.convertDate(startConsDateTime,"DMYHM",locale, "en");
			tabdata.put("allowBackdateConsYn", allowBackdateConsYn);
			tabdata.put("moduleId", moduleId);
			tabdata.put("insertBackDatedConsY", insertBackDatedConsY);
			tabdata.put("start_cons_date_time", startConsDateTime);
			/*End*/
			
			/*
			tabdata.put("patientid", checkNull(req.getParameter("patientid")));				
			tabdata.put("qstatus", checkNull(req.getParameter("qstatus")));
			tabdata.put("locncode", checkNull(req.getParameter("locncode")));
			tabdata.put("locntype", checkNull(req.getParameter("locntype")));
			tabdata.put("practitionerid", checkNull(req
					.getParameter("practitionerid")));
			tabdata.put("qshift", checkNull(req.getParameter("qshift")));
			tabdata.put("visittype", checkNull(req.getParameter("visittype")));
			tabdata.put("consdate",
					checkNull(req.getParameter("ConsStartTime")));
			tabdata.put("p_queue_date", checkNull(req
					.getParameter("queue_date")));
			tabdata.put("facilityId", facilityId);
			*/			

			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter(
					"LOCAL_EJBS") != null)
					&& (getServletConfig().getServletContext()
							.getInitParameter("LOCAL_EJBS")
							.equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance()
					.getHome("java:comp/env/StartCons", StartConsHome.class,
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
					.getMethod("updateRecordStartCons", paramArray)).invoke(
					busObj, argArray);

			(busObj.getClass().getMethod("remove", null)).invoke(busObj, null);

			boolean inserted = (((Boolean) results.get("status"))
					.booleanValue());

			sb.append("function value " + inserted);
			String error = (String) results.get("error");
			error = (String) results.get("error");
			
			res.sendRedirect("../eOP/jsp/StartConserror.jsp?err_num="
					+ java.net.URLEncoder.encode(error,"UTF-8") +"&moduleId="+moduleId);

			argArray = null;
			paramArray = null;
			results.clear();
			tabdata.clear();

		} catch (Exception e) {
			out.println(e.getMessage() + sb);
			out.println(e.toString() + sb);
		}
	}

	public void assignPractitioner(HttpServletRequest req,
			HttpServletResponse res) throws javax.servlet.ServletException,
			IOException {

		String sql = "";
		Connection con = null;
		String locn_code = "";
		String locn_type = "";
		String visit_type = "";
		try {
			String encounter_id = req.getParameter("encounter_id");
			String practitioner_id = req.getParameter("practitioner_id");
			p_queue_date = req.getParameter("queue_date");
			String bl_install_yn = req.getParameter("bl_install_yn");
			con = ConnectionManager.getConnection(req);

			sql = " select assign_care_locn_code, assign_care_locn_type, attend_practitioner_id, visit_adm_type,appt_case_yn,visit_status from pr_encounter where facility_id = '"
					+ facilityId + "' and encounter_id = " + encounter_id;

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs != null) {
				if (rs.next()) {
					if (rs.getString("attend_Practitioner_id") == null) {
						locn_code = rs.getString("assign_care_locn_code");
						locn_type = rs.getString("assign_care_locn_type");
						visit_type = rs.getString("visit_adm_type");

						sql = " select pract_type from am_practitioner where practitioner_id = '"
								+ practitioner_id + "' ";
						if (rs != null)
							rs.close();
						rs = stmt.executeQuery(sql);
						if (rs != null) {
							if (rs.next()) {
								String practid = "";
								String mode = "A";
								String curpractid = "";
								String curpracttype = "";
								String visitcase = "W";
								String unlinkapptcaseyn = "N";
								String p_team_id = "";
								String room_num = "";
								String room_cur = "";
								String room_change = "";
								String chg_flag = "";
								String service_code = "";
								String subservice_code = "";

								HashMap tabdata = new HashMap();
								tabdata.put("facilityId", facilityId);
								tabdata.put("patient_id", checkNull(req
										.getParameter("patient_id")));
								tabdata.put("locn_type", locn_type);
								tabdata.put("locn_code", locn_code);
								tabdata.put("encounterId", encounter_id);
								tabdata.put("practid", practid);
								tabdata.put("mode", mode);
								tabdata.put("locn_code", locn_code);
								tabdata.put("locn_type", locn_type);
								tabdata.put("asslocn_code", locn_code);
								tabdata.put("asslocn_type", locn_type);
								tabdata.put("curpractid", curpractid);
								tabdata.put("curpracttype", curpracttype);
								tabdata.put("practitioner_id", practitioner_id);
								tabdata.put("visit_type", visit_type);
								tabdata.put("assvisit_type", visit_type);
								tabdata.put("visitcase", visitcase);
								tabdata.put("unlinkapptcaseyn",
										unlinkapptcaseyn);
								tabdata.put("p_queue_date", p_queue_date);
								tabdata.put("p_team_id", p_team_id);
								tabdata.put("room_num", room_num);
								tabdata.put("room_cur", room_cur);
								tabdata.put("room_change", room_change);
								tabdata.put("chg_flag", chg_flag);
								tabdata.put("service_code", service_code);
								tabdata.put("subservice_code", subservice_code);
								tabdata.put("client_ip_address",
										client_ip_address);
								tabdata.put("facilityId", facilityId);
								tabdata.put("bl_install_yn", bl_install_yn);

								boolean local_ejbs = false;

								if ((getServletConfig().getServletContext()
										.getInitParameter("LOCAL_EJBS") != null)
										&& (getServletConfig()
												.getServletContext()
												.getInitParameter("LOCAL_EJBS")
												.equalsIgnoreCase("TRUE")))
									local_ejbs = true;

								Object home =com.ehis.eslp.ServiceLocator
										.getInstance()
										.getHome(
												"java:comp/env/QmgmtRe_AssignPractManager",
												QmgmtRe_AssignPractHome.class,
												local_ejbs);
								Object busObj = (home.getClass().getMethod(
										"create", null)).invoke(home, null);

								Object argArray[] = new Object[2];
								argArray[0] = p;
								argArray[1] = tabdata;

								Class[] paramArray = new Class[30];
								paramArray[0] = p.getClass();
								paramArray[1] = tabdata.getClass();

								java.util.HashMap results = (java.util.HashMap) (busObj
										.getClass().getMethod(
										"updatePrEncounter", paramArray))
										.invoke(busObj, argArray);
								(busObj.getClass().getMethod("remove", null))
										.invoke(busObj, null);

								boolean inserted = (((Boolean) results
										.get("status")).booleanValue());
								sb.append("function value " + inserted);
								if (inserted) {
									if (from.equals("CA"))
										out
												.println("<script>parent.window.close();</script>");
									else {
										StringBuffer HTMLVal = new StringBuffer();
										HTMLVal.setLength(0);

										HTMLVal
												.append("<HTML><HEAD><link rel='stylesheet' type='text/css' href='../eCommon/html/IeStyle'></link></HEAD><BODY CLASS='MESSAGE'>");
										HTMLVal
												.append("<form name='form1' method='post' action='../eOP/jsp/SupportConsPatQQueryResult.jsp'>");
										HTMLVal
												.append("<input name='Encounter_Id' type='hidden' value= '"
														+ encounter_id + "'>");
										HTMLVal
												.append("<input name='mode' type='hidden' value= 'status'>");
										HTMLVal.append("</form></BODY></HTML>");
										HTMLVal
												.append("<script>document.form1.submit()</script>");
										out.print(HTMLVal.toString());
										HTMLVal.setLength(0);
									}

									argArray = null;
									paramArray = null;
									results.clear();
									tabdata.clear();
								}
							}
						}
					}
				}
			}
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();

		} catch (Exception e) {
			out
					.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "
							+ e.toString());
			out.println("Values sent are : <br>" + sql);
		} finally {
			if (con != null)
				ConnectionManager.returnConnection(con, req);
		}
	}

	public static String checkNull(String str) {
		return ((str == null || str.equals("null")) ? "" : str);
	}

	public static String checkNullWithDftValue(String str, String dftval) {
		return ((str == null || str.equals("null")) ? dftval : str);
	}

}
