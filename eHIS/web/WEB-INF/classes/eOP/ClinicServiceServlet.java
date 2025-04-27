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
import webbeans.eCommon.*;
import javax.ejb.*;
import eOP.OPClinicService.*;

public class ClinicServiceServlet extends javax.servlet.http.HttpServlet
		implements SingleThreadModel {
	PrintWriter out;

	java.util.Properties p;

	String facilityId;

	String client_ip_address;

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
			ServiceAddModify(req, res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletResponse res)
			throws javax.servlet.ServletException, IOException {
		try {
			this.out = res.getWriter();
			out
					.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link><script language='javascript' src='/eCIS/op/js/ClinicService.js'></script></head><frameset rows='60,*,50'><frame name='commontoolbarFrame' src='../eCommon/jsp/commonToolbar.jsp?function_name=Rooms For Nursing Unit' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void ServiceAddModify(HttpServletRequest req,
			HttpServletResponse res) {
		Connection con = null;
		try {
			con = ConnectionManager.getConnection(req);
			HashMap tabdata = new HashMap();
			RecordSet ClinicService = null;
			RecordSet ClinicDeptService = null;
			String checkedOnes = "";
			String checkedDeptOnes = "";
			String from = "", to = "";
			String locale = "";
			String recordCount = req.getParameter("recordCount");
			int oldcount = Integer.parseInt(recordCount);

			locale = p.getProperty("LOCALE");
			tabdata.put("clinic_code", checkNull(req
					.getParameter("clinic_code")));
			tabdata.put("dept_code", checkNull(req.getParameter("dept_code")));
			tabdata.put("clinic_type", checkNull(req
					.getParameter("clinic_type")));
			tabdata.put("care_ind", checkNull(req
					.getParameter("care_indicator")));

			from = (req.getParameter("from") == null) ? "0" : req
					.getParameter("from");
			to = (req.getParameter("to") == null) ? "0" : req
					.getParameter("to");

			ClinicService = (webbeans.eCommon.RecordSet) session
					.getAttribute("ClinicService");
			ClinicDeptService = (webbeans.eCommon.RecordSet) session
					.getAttribute("ClinicDeptService");
			if (from != null && to != null) {
				from = from.trim();
				to = to.trim();

				for (int i = (Integer.parseInt(from)); i <= (Integer
						.parseInt(to)); i++) {
					if (req.getParameter(("chk" + i)) != null) {
						checkedOnes = req.getParameter(("chk" + i));
						checkedDeptOnes = req.getParameter("deptCode" + (i));
						if (!(ClinicService.containsObject(checkedOnes))) {
							ClinicService.putObject(checkedOnes);
							ClinicDeptService.putObject(checkedDeptOnes);
						}
					}
				}
			}
			for (int i = 0; i < ClinicService.getSize(); i++) {
				tabdata.put(("chk" + i), (String) ClinicService.getObject(i));
				tabdata.put(("dept" + i), (String) ClinicDeptService
						.getObject(i));
			}

			String slCount = "" + ClinicService.getSize();
			String addedById = p.getProperty("login_user");
			String addedDate = dateFormat.format(new java.util.Date());
			String modifiedById = addedById;
			String modifiedFacilityId = facilityId;
			String addedAtWorkstation = client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation;
			java.sql.Date added_date1 = java.sql.Date.valueOf(addedDate);
			java.sql.Date added_date = new java.sql.Date(added_date1
					.parse(added_date1.toLocaleString())
					- (added_date1.getTimezoneOffset() * 60 * 1000));

			tabdata.put("facilityId", facilityId);
			tabdata.put("added_date", added_date);
			tabdata.put("modified_by_id", modifiedById);
			tabdata.put("modified_date", new java.sql.Timestamp(System
					.currentTimeMillis()));
			tabdata.put("modified_facility_id", modifiedFacilityId);
			tabdata.put("modified_at_ws_no", modifiedAtWorkstation);
			tabdata.put("totCount", new Integer(slCount));

			int size = ClinicService.getSize();
			if (size == 0 && oldcount == 0) {
				java.util.Hashtable message = MessageManager.getMessage(locale,
						"ATLEAST_ONE_SERVICE", "OP");
				String error = (String) message.get("message");
				String error_value = "0";
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
						+ java.net.URLEncoder.encode(error,"UTF-8") + "&err_value="
						+ error_value);
				message.clear();
			} else {

				boolean local_ejbs = false;
				if ((getServletConfig().getServletContext().getInitParameter(
						"LOCAL_EJBS") != null)
						&& (getServletConfig().getServletContext()
								.getInitParameter("LOCAL_EJBS")
								.equalsIgnoreCase("TRUE")))
					local_ejbs = true;

				Object home = com.ehis.eslp.ServiceLocator.getInstance()
						.getHome("java:comp/env/OPClinicService",
								OPClinicServiceManagerHome.class, local_ejbs);
				Object busObj = (home.getClass().getMethod("create", null))
						.invoke(home, null);

				Object argArray[] = new Object[2];
				argArray[0] = p;
				argArray[1] = tabdata;

				Class[] paramArray = new Class[2];
				paramArray[0] = p.getClass();
				paramArray[1] = tabdata.getClass();

				java.util.HashMap results = (java.util.HashMap) (busObj
						.getClass().getMethod("ServiceAddModify", paramArray))
						.invoke(busObj, argArray);

				(busObj.getClass().getMethod("remove", null)).invoke(busObj,
						null);

				boolean inserted = (((Boolean) results.get("status"))
						.booleanValue());
				String error = (String) results.get("error");
				
				String error_value = "0";
				inserted = true;
				if (inserted)
					error_value = "1";
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
						+ java.net.URLEncoder.encode(error,"UTF-8") + "&err_value="
						+ error_value);

				argArray = null;
				paramArray = null;
				tabdata.clear();
				results.clear();
			}
		} catch (Exception e) {
			out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "
							+ e.toString());
			out.println("Values sent are : <br>");
		} finally {
			if (con != null)
				ConnectionManager.returnConnection(con, req);
		}
	}//E.O.Method

	public static String checkNull(String str) {
		return ((str == null || str.equals("null")) ? "" : str);
	}

}
