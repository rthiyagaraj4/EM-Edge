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
import eOP.VisitTypeClinic.*;

public class VisitTypeServlet extends javax.servlet.http.HttpServlet {
	PrintWriter out;

	Connection con = null;

	PreparedStatement pstmt = null;

	ResultSet rs = null;

	java.util.Properties p;

	String locale = "";

	String visit_type_code;

	String facilityId;

	String client_ip_address;

	String service_criteria;

	int maxRecord = 0;

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
			if (operation.equals("insert"))
				insertVisitType(req, res);
			if (operation.equals("modify"))
				modifyVisitType(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void modifyVisitType(HttpServletRequest req, HttpServletResponse res) {

		try {
			service_criteria = req.getParameter("scriteria");
			if (service_criteria == null)
				service_criteria = "";

			if (service_criteria.equals("Not Required"))
				service_criteria = "N";
			if (service_criteria.equals("Required"))
				service_criteria = "R";

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
			tabdata.put("long_desc", checkNull(req.getParameter("long_desc")));
			tabdata
					.put("short_desc",
							checkNull(req.getParameter("short_desc")));
			tabdata.put("eff_status", checkNullWithDftValue(req.getParameter("eff_status"), "D"));
			tabdata.put("rd_appl_yn", checkNullWithDftValue(req.getParameter("rd_appl_yn"), "N"));
			tabdata.put("added_by_id", addedById);
			tabdata.put("modified_by_id", modifiedById);
			tabdata.put("modified_date", modified_date);
			tabdata.put("modified_facility_id", modifiedFacilityId);
			tabdata.put("modified_at_ws_no", modifiedAtWorkstation);
			tabdata.put("added_at_ws_no", addedAtWorkstation);
			tabdata.put("ORDER_CATALOG_CRITERIA", service_criteria);
			tabdata.put("max_appt_duration", checkNull(req
					.getParameter("max_appt_duration")));
			tabdata.put("max_appt_slots", checkNull(req
					.getParameter("max_appt_slots")));
			tabdata.put("Visit_Type_code", checkNull(req
					.getParameter("visit_type_code")));
			tabdata.put("facility_id", addedFacilityId);
			
			tabdata.put("COLOR_INDICATOR", checkNull(req.getParameter("colour_code_id"))); // BRU-HIMS-CRF-177
			
			//<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 (U1) on 17-04-2023 Started -->
			tabdata.put("virtual_consultation", checkNullWithDftValue(req.getParameter("virtual_consultation"), "D"));

			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter(
					"LOCAL_EJBS") != null)
					&& (getServletConfig().getServletContext()
							.getInitParameter("LOCAL_EJBS")
							.equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(
					"java:comp/env/VisitTypeClinic", VisitTypeClinicHome.class,
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
					.getMethod("UpdateVisitType", paramArray)).invoke(busObj,
					argArray);

			(busObj.getClass().getMethod("remove", null)).invoke(busObj, null);
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
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
						+ java.net.URLEncoder.encode(error,"UTF-8"));
			}
			results.clear();
			tabdata.clear();
			argArray = null;
			paramArray = null;
		} catch (Exception e) {
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+ e.toString());
			e.printStackTrace();
		}
	}

	private void insertVisitType(HttpServletRequest req, HttpServletResponse res) {

		try {
			con = ConnectionManager.getConnection(p);
			visit_type_code = req.getParameter("visit_type_code");
			locale = p.getProperty("LOCALE");
			pstmt = con
					.prepareStatement("select count(*) as total from op_visit_type where  facility_id=? and visit_type_code=?");
			pstmt.setString(1, facilityId);
			pstmt.setString(2, visit_type_code);

			rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					maxRecord = rs.getInt("total");
				}
			}

			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {

			if (maxRecord <= 0) {
				try {
					service_criteria = req.getParameter("scriteria");
					if (service_criteria == null)
						service_criteria = "N";
					String addedById = p.getProperty("login_user");
					String addedDate = dateFormat.format(new java.util.Date());
					String modifiedById = addedById;
					String modifiedDate = addedDate;
					String addedFacilityId = facilityId;
					String modifiedFacilityId = addedFacilityId;
					String addedAtWorkstation = client_ip_address;
					String modifiedAtWorkstation = addedAtWorkstation;

					java.sql.Date added_date = java.sql.Date.valueOf(addedDate);
					java.sql.Date modified_date = java.sql.Date
							.valueOf(modifiedDate);

					HashMap tabdata = new HashMap();
					tabdata.put("Visit_Type_code", visit_type_code);
					tabdata.put("facility_id", addedFacilityId);
					tabdata.put("visit_type_ind", checkNull(req
							.getParameter("visit_type_ind")));
					tabdata.put("long_desc", checkNull(req
							.getParameter("long_desc")));
					tabdata.put("short_desc", checkNull(req
							.getParameter("short_desc")));
					tabdata.put("eff_status", checkNullWithDftValue(req
							.getParameter("eff_status"), "D"));
					tabdata.put("max_appt_duration", checkNull(req
							.getParameter("max_appt_duration")));
					tabdata.put("max_appt_slots", checkNull(req
							.getParameter("max_appt_slots")));
					tabdata.put("rd_appl_yn", checkNullWithDftValue(req.getParameter("rd_appl_yn"), "N"));
					tabdata.put("added_by_id", addedById);
					tabdata.put("added_date", added_date);
					tabdata.put("added_facility_id", facilityId);
					tabdata.put("added_at_ws_no", addedAtWorkstation);
					tabdata.put("modified_by_id", modifiedById);
					tabdata.put("modified_date", modified_date);
					tabdata.put("modified_facility_id", modifiedFacilityId);
					tabdata.put("modified_at_ws_no", modifiedAtWorkstation);
					tabdata.put("ORDER_CATALOG_CRITERIA", service_criteria);
					tabdata.put("COLOR_INDICATOR", checkNull(req
							.getParameter("colour_code_id"))); // BRU-HIMS-CRF-177
					
					//<!--added by Himanshu Saxena for ML-MMOH-CRF-1930 (U1) on 17-04-2023 Started -->
					tabdata.put("virtual_consultation", checkNullWithDftValue(req.getParameter("virtual_consultation"), "D"));

					boolean local_ejbs = false;

					if ((getServletConfig().getServletContext()
							.getInitParameter("LOCAL_EJBS") != null)
							&& (getServletConfig().getServletContext()
									.getInitParameter("LOCAL_EJBS")
									.equalsIgnoreCase("TRUE")))
						local_ejbs = true;

					Object home = com.ehis.eslp.ServiceLocator.getInstance()
							.getHome("java:comp/env/VisitTypeClinic",
									VisitTypeClinicHome.class, local_ejbs);
					Object busObj = (home.getClass().getMethod("create", null))
							.invoke(home, null);

					Object argArray[] = new Object[2];
					argArray[0] = p;
					argArray[1] = tabdata;

					Class[] paramArray = new Class[2];
					paramArray[0] = p.getClass();
					paramArray[1] = tabdata.getClass();

					java.util.HashMap results = (java.util.HashMap) (busObj
							.getClass()
							.getMethod("InsertVisitType", paramArray)).invoke(
							busObj, argArray);

					(busObj.getClass().getMethod("remove", null)).invoke(
							busObj, null);

					boolean inserted = (((Boolean) results.get("status"))
							.booleanValue());
					String error = (String) results.get("error");
					String error_value = "0";

					if (inserted) {
						error_value = "1";
						res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
								+ java.net.URLEncoder.encode(error,"UTF-8")
								+ "&err_value=" + error_value);
					} else {
						res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
								+ java.net.URLEncoder.encode(error,"UTF-8"));
					}
					results.clear();
					argArray = null;
					paramArray = null;
					tabdata.clear();

				} catch (Exception e) {
					//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+ e.toString());
					e.printStackTrace();
				}
			} else {
				
				
				java.util.Hashtable message = MessageManager.getMessage(locale,"CODE_ALREADY_EXISTS","Common");
				String msg = (String) message.get("message");
				
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
						+java.net.URLEncoder.encode(msg,"UTF-8"));
				message.clear();
			}
		} catch (Exception e) {

			//out.println("<h3> Exception raise by Visit Type Servlet ...So Record Not Modified </h3> Foll: Error Received : "+ e.toString());
			e.printStackTrace();
		} finally {

			if (con != null)
				ConnectionManager.returnConnection(con, p);

		}

	}

	public static String checkNull(String str) {
		return ((str == null || str.equals("null")) ? "" : str);
	}

	public static String checkNullWithDftValue(String str, String dftval) {
		return ((str == null || str.equals("null")) ? dftval : str);
	}

}
