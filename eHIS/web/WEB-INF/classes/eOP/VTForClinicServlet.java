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
import javax.naming.*;
import javax.rmi.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.SingleTabHandler.*;

public class VTForClinicServlet extends javax.servlet.http.HttpServlet {
	PrintWriter out;

	java.util.Properties p;

	String clinic;

	String visittype;


	String visit_type_ind;

	String facilityId;

	String client_ip_address;

	HttpSession session;

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(
			"yyyy-MM-dd");

	StringBuffer sb = new StringBuffer();

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

			if (operation.equals("insert"))
				insertVTForClinic(req, res);
			if (operation.equals("modify"))
				modifyVTForClinic(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void modifyVTForClinic(HttpServletRequest req,
			HttpServletResponse res) {
		try {

			clinic = req.getParameter("clinic");
			visittype = req.getParameter("visittype");

			String addedById = p.getProperty("login_user");
			String addedDate = dateFormat.format(new java.util.Date());
			String modifiedById = addedById;
			String modifiedDate = addedDate;
			String addedFacilityId = facilityId;
			String modifiedFacilityId = addedFacilityId;
			String addedAtWorkstation = client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation;

			java.sql.Date modified_date = java.sql.Date.valueOf(modifiedDate);

			String max_appt_duration = checkNull(req
					.getParameter("max_appt_duration"));
			String max_appt_slots = checkNull(req
					.getParameter("max_appt_slots"));

			HashMap tabdata = new HashMap();

			if (!max_appt_duration.equals(""))
				tabdata
						.put("max_appt_duration",
								new Integer(max_appt_duration));
			else
				tabdata.put("max_appt_duration", "");
			if (!max_appt_slots.equals(""))
				tabdata.put("max_appt_slots", new Integer(max_appt_slots));
			else
				tabdata.put("max_appt_slots", "");

			tabdata.put("vital_signs_battery_id", checkNull(req
					.getParameter("vitalsignsb")));
			tabdata.put("eff_status", checkNullWithDftValue(req
					.getParameter("active"), "D"));
			tabdata.put("modified_by_id", modifiedById);
			tabdata.put("modified_date", modified_date);
			tabdata.put("modified_facility_id", modifiedFacilityId);
			tabdata.put("modified_at_ws_no", modifiedAtWorkstation);

			HashMap condflds = new HashMap();

			condflds.put("facility_id", facilityId);
			condflds.put("clinic_code", clinic);
			condflds.put("visit_type_code", visittype);

			String table_name = "op_visit_type_for_clinic";
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
			argArray[3] = table_name;
			Class[] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = table_name.getClass();
			java.util.HashMap results = (java.util.HashMap) (busObj.getClass()
					.getMethod("update", paramArray)).invoke(busObj, argArray);
			(busObj.getClass().getMethod("remove", null)).invoke(busObj, null);

			boolean inserted = (((Boolean) results.get("status"))
					.booleanValue());
			String error = "";
			String error_value = "0";

			if (inserted) {
				error = (String) results.get("error");
				error_value = "1";
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
						+ java.net.URLEncoder.encode(error,"UTF-8") + "&err_value="
						+ error_value + sb.toString());
			} else {
				error = (String) results.get("error");
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
						+ java.net.URLEncoder.encode(error,"UTF-8"));
			}
			argArray = null;
			paramArray = null;
			results.clear();
			tabdata.clear();
			condflds.clear();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void insertVTForClinic(HttpServletRequest req,
			HttpServletResponse res) {
		Connection con = null;
		try {
			con = ConnectionManager.getConnection(p);
			String procfunction = req.getParameter("pfunction");
			clinic = checkNull(req.getParameter("clinic"));
			visittype = req.getParameter("visittype1");
			visit_type_ind = req.getParameter("indicator");

			if (visit_type_ind == null)
				visit_type_ind = "";

			if (visittype == null)
				visittype = "";

			String max_appt_duration = checkNull(req
					.getParameter("max_appt_duration"));
			String max_appt_slots = checkNull(req
					.getParameter("max_appt_slots"));

			String addedById = p.getProperty("login_user");
			String addedDate = dateFormat.format(new java.util.Date());
			String modifiedById = addedById;
			String modifiedDate = addedDate;
			String addedFacilityId = facilityId;
			String modifiedFacilityId = addedFacilityId;
			String addedAtWorkstation = client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation;
			String care_location_ind = "";
			String careind = "";
			java.sql.Date added_date = java.sql.Date.valueOf(addedDate);
			java.sql.Date modified_date = java.sql.Date.valueOf(modifiedDate);

			try {
				String rsql = "select care_locn_type_ind from op_clinic where clinic_code='"
						+ clinic + "' and facility_id='" + facilityId + "'";
				Statement stmt = con.createStatement();
				ResultSet rset = stmt.executeQuery(rsql);
				if (rset.next())
					careind = rset.getString(1);

				if (rset != null)
					rset.close();
				if (stmt != null)
					stmt.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

			if (procfunction.equals("visit_type_for_proc_unit"))
				care_location_ind = careind;
			else
				care_location_ind = "C";

			HashMap tabdata = new HashMap();
			tabdata.put("facility_id", facilityId);
			tabdata.put("clinic_code", clinic);
			tabdata.put("visit_type_ind", visit_type_ind);
			tabdata.put("visit_type_code", visittype);
			tabdata.put("vital_signs_battery_id", checkNull(req
					.getParameter("vitalsignsb")));
			tabdata.put("care_locn_type_ind", care_location_ind);

			if (!max_appt_duration.equals(""))
				tabdata
						.put("max_appt_duration",
								new Integer(max_appt_duration));
			if (!max_appt_slots.equals(""))
				tabdata.put("max_appt_slots", new Integer(max_appt_slots));
			tabdata.put("eff_status", checkNullWithDftValue(req
					.getParameter("active"), "D"));
			tabdata.put("added_by_id", addedById);
			tabdata.put("added_date", added_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no", addedAtWorkstation);
			tabdata.put("modified_by_id", modifiedById);
			tabdata.put("modified_date", modified_date);
			tabdata.put("modified_facility_id", modifiedFacilityId);
			tabdata.put("modified_at_ws_no", modifiedAtWorkstation);
			String dupflds[] = { "facility_id", "clinic_code",
					"visit_type_code" };

			String table_name = "op_visit_type_for_clinic";
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
			argArray[3] = table_name;

			Class[] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = table_name.getClass();

			java.util.HashMap results = (java.util.HashMap) (busObj.getClass()
					.getMethod("insert", paramArray)).invoke(busObj, argArray);
			(busObj.getClass().getMethod("remove", null)).invoke(busObj, null);

			boolean inserted = (((Boolean) results.get("status"))
					.booleanValue());
			String error = "";
			String error_value = "0";

			if (inserted) {
				error = (String) results.get("error");
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
			results.clear();
			tabdata.clear();
			dupflds = null;

		} catch (Exception e) {
			e.printStackTrace();

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
