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

import eCommon.SingleTabHandler.*;

public class OpParamFcyServlet extends javax.servlet.http.HttpServlet {
	PrintWriter out;

	java.util.Properties p;

	String facility;

	String buildepisoderule;

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
				insertOpParamFcy(req, res);
			if (operation.equals("modify"))
				modifyOpParamFcy(req, res);
		} catch (Exception e) {
			out.println(e.toString());
		}
	}

	private void modifyOpParamFcy(HttpServletRequest req,
			HttpServletResponse res) {
		try {
			facility = req.getParameter("operating_facility_id");
			buildepisoderule = "S";
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
			tabdata.put("build_episode_rule", buildepisoderule);
			tabdata.put("episode_close_days_fu", checkNull(req
					.getParameter("episode_close_days_fu")));
			tabdata.put("episode_close_days_wo_fu", checkNull(req
					.getParameter("episode_close_days_wo_fu")));
			//Maheshwaran K added for the Bru-HIMS-CRF-170(IN030289) as on 02/09/2013
			//Start
			tabdata.put("consecutive_no_shows", checkNull(req.getParameter("consecutive_no_shows")));
			tabdata.put("no_of_visits_months", checkNull(req.getParameter("no_of_visits_months")));
			tabdata.put("no_of_future_appts_months", checkNull(req.getParameter("no_of_future_appts_months")));
			tabdata.put("no_of_no_show_months", checkNull(req.getParameter("consecutive_no_shows_months")));
			//End			
			tabdata.put("modified_by_id", modifiedById);
			tabdata.put("modified_date", modified_date);
			tabdata.put("modified_facility_id", modifiedFacilityId);
			tabdata.put("modified_at_ws_no", modifiedAtWorkstation);

			HashMap condflds = new HashMap();
			condflds.put("operating_facility_id", facility);
			condflds.put("service_code", checkNull(req
					.getParameter("service_code")));

			String tabname = "op_param_for_facility_service";

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
						+ error_value + sb.toString());
			} else {
				error = (String) results.get("error");
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
						+ java.net.URLEncoder.encode(error,"UTF-8"));
			}
			results.clear();
			argArray = null;
			paramArray = null;
			tabdata.clear();
			condflds.clear();

		} catch (Exception e) {
			e.printStackTrace();
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+ e.toString());
		}
	}

	private void insertOpParamFcy(HttpServletRequest req,
			HttpServletResponse res) {
		try {
			facility = req.getParameter("operating_facility_id");
			buildepisoderule = "S";
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
			tabdata.put("operating_facility_id", facility);
			tabdata.put("service_code", checkNull(req
					.getParameter("service_code")));
			tabdata.put("build_episode_rule", buildepisoderule);
			tabdata.put("episode_close_days_fu", checkNull(req
					.getParameter("episode_close_days_fu")));
			tabdata.put("episode_close_days_wo_fu ", checkNull(req
					.getParameter("episode_close_days_wo_fu")));
			//Maheshwaran K added for the Bru-HIMS-CRF-170(IN030289) as on 02/09/2013
			//Start
			tabdata.put("consecutive_no_shows", checkNull(req.getParameter("consecutive_no_shows")));
			tabdata.put("no_of_visits_months", checkNull(req.getParameter("no_of_visits_months")));
			tabdata.put("no_of_future_appts_months", checkNull(req.getParameter("no_of_future_appts_months")));
			tabdata.put("no_of_no_show_months", checkNull(req.getParameter("consecutive_no_shows_months")));
			//End				
			tabdata.put("added_by_id", addedById);
			tabdata.put("added_date", added_date);
			tabdata.put("added_facility_id", facilityId);
			tabdata.put("added_at_ws_no", addedAtWorkstation);
			tabdata.put("modified_by_id", modifiedById);
			tabdata.put("modified_date", modified_date);
			tabdata.put("modified_facility_id", modifiedFacilityId);
			tabdata.put("modified_at_ws_no", modifiedAtWorkstation);

			String dupflds[] = { "operating_facility_id", "service_code" };
			String tabname = "op_param_for_facility_service";

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

			results.clear();
			argArray = null;
			paramArray = null;
			tabdata.clear();

		} catch (Exception e) {
			e.printStackTrace();
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+ e.toString());
		}
	}

	public static String checkNull(String str) {
		return ((str == null || str.equals("null")) ? "" : str);
	}

}
