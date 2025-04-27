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

import eCommon.SingleTabHandler.*;

public class OpOnlinereportsruleServlet extends javax.servlet.http.HttpServlet {
	PrintWriter out;

	java.util.Properties p;

	String reportdesc;

	String facilityId;

	String client_ip_address;

	String module_id;

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
			String operation = req.getParameter("function_name");		
			 
			if (operation.equals("insert"))
				insertOpOnlinereportsrule(req, res);
			if (operation.equals("modify"))
				modifyOpOnlinereportsrule(req, res);
			if (operation.equals("delete"))
				deleteOpOnlinereportsrule(req, res);
		} catch (Exception e) {
			//out.println(e.toString());
			e.printStackTrace();
		}
	}

	private void modifyOpOnlinereportsrule(HttpServletRequest req,
			HttpServletResponse res) {
		try {

			reportdesc = req.getParameter("report");

			StringTokenizer st = new StringTokenizer(reportdesc, "::");
			if (st.countTokens() == 2) {
				reportdesc = st.nextToken();
				module_id = st.nextToken();
			}			

			String addedById = p.getProperty("login_user");
			String addedDate = dateFormat.format(new java.util.Date());
			String modifiedById = addedById;
			String modifiedDate = addedDate;
			String modifiedFacilityId = facilityId;
			String addedAtWorkstation = client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation;
			java.sql.Date modified_date = java.sql.Date.valueOf(modifiedDate);

			HashMap tabdata = new HashMap();
			tabdata.put("modified_by_id", modifiedById);
			tabdata.put("modified_date", modified_date);
			tabdata.put("modified_facility_id", modifiedFacilityId);
			tabdata.put("modified_at_ws_no", modifiedAtWorkstation);
			tabdata.put("print_at_ci_yn", checkNull(req
					.getParameter("print_at_ci_yn")));
			tabdata.put("print_at_pr_yn", checkNull(req
					.getParameter("print_at_pr_yn")));
			tabdata.put("print_at_xt_yn", checkNull(req
					.getParameter("print_at_xt_yn")));
			tabdata.put("print_at_ns_yn", checkNull(req
					.getParameter("print_at_ns_yn")));

			HashMap condflds = new HashMap();
			condflds
					.put("clinic_code", checkNull(req.getParameter("Loc_Code")));
			condflds.put("visit_type_code", checkNull(req
					.getParameter("visitype")));
			condflds.put("report_id", reportdesc);
			condflds.put("module_id", module_id);
			condflds.put("operating_facility_id", facilityId);

			String tabname = "op_online_report";

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
			if (inserted)
				error_value = "1";
			res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
					+ java.net.URLEncoder.encode(error,"UTF-8") + "&err_value="
					+ error_value);

			results.clear();
			argArray = null;
			paramArray = null;
			tabdata.clear();
			condflds.clear();
		} catch (Exception e) {
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+ e.toString());
			e.printStackTrace();
		}
	}

	/* The function insertOpOnlinereportsrule() is used to insert new records in the database table 'op_online_report'; here the EJB singleTabHandlerManager is being called with the new values in an hash table, operating facility id, clinic name, visit type, report id, module id and facility name in an array along with the database table name where the record has to be inserted   ---  Srijagadeesh. */

	private void insertOpOnlinereportsrule(HttpServletRequest req,
			HttpServletResponse res) {
		try {

			
			reportdesc = req.getParameter("report_desc");
/*
			StringTokenizer st = new StringTokenizer(reportdesc, "::");
			if (st.countTokens() == 2) {
				reportdesc = st.nextToken();
				module_id = st.nextToken();
			}	
*/		
			module_id = reportdesc.substring(0,2);
			
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
			tabdata.put("operating_facility_id", facilityId);
			tabdata.put("clinic_code",
					checkNull(req.getParameter("short_desc")));
			tabdata.put("visit_type_code", checkNull(req
					.getParameter("visit_type")));
			tabdata.put("report_id", reportdesc);
			tabdata.put("module_id", module_id);
			tabdata.put("added_by_id", addedById);
			tabdata.put("added_date", added_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no", addedAtWorkstation);
			tabdata.put("modified_by_id", modifiedById);
			tabdata.put("modified_date", modified_date);
			tabdata.put("modified_facility_id", modifiedFacilityId);
			tabdata.put("modified_at_ws_no", modifiedAtWorkstation);
			tabdata.put("print_at_ci_yn", checkNull(req
					.getParameter("print_at_ci_yn")));
			tabdata.put("print_at_pr_yn", checkNull(req
					.getParameter("print_at_pr_yn")));
			tabdata.put("print_at_xt_yn", checkNull(req
					.getParameter("print_at_xt_yn")));
			tabdata.put("print_at_ns_yn", checkNull(req
					.getParameter("print_at_ns_yn")));

			String dupflds[] = { "operating_facility_id", "clinic_code",
					"module_id", "visit_type_code", "report_id" };

			String tabname = "op_online_report";

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
			if (inserted)
				error_value = "1";
			
			
			
			res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
					+ java.net.URLEncoder.encode(error,"UTF-8") + "&err_value="
					+ error_value);

			results.clear();
			argArray = null;
			paramArray = null;
			tabdata.clear();
			dupflds = null;
		} catch (Exception e) {
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+ e.toString());
			e.printStackTrace();

		}
	}

	private void deleteOpOnlinereportsrule(HttpServletRequest req,
			HttpServletResponse res) {
		try {
			reportdesc = req.getParameter("report");
			StringTokenizer st = new StringTokenizer(reportdesc, "::");
			if (st.countTokens() == 2) {
				reportdesc = st.nextToken();
				module_id = st.nextToken();
			}

			HashMap delflds = new HashMap();
			delflds.put("clinic_code", checkNull(req.getParameter("Loc_Code")));
			delflds.put("visit_type_code", checkNull(req
					.getParameter("visitype")));
			delflds.put("report_id", reportdesc);
			delflds.put("module_id", module_id);
			delflds.put("operating_facility_id", facilityId);

			String tabname = "op_online_report";

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

			Object argArray[] = new Object[3];
			argArray[0] = p;
			argArray[1] = delflds;
			argArray[2] = tabname;

			Class[] paramArray = new Class[3];
			paramArray[0] = p.getClass();
			paramArray[1] = delflds.getClass();
			paramArray[2] = tabname.getClass();

			java.util.HashMap results = (java.util.HashMap) (busObj.getClass()
					.getMethod("delete", paramArray)).invoke(busObj, argArray);

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

			results.clear();
			argArray = null;
			paramArray = null;
			delflds.clear();
		} catch (Exception e) {
			//out.println(e.getMessage());
			//out.println(e.toString());
			e.printStackTrace();
		}
	}

	public static String checkNull(String str) {
		return ((str == null || str.equals("null")) ? "" : str);
	}

}
