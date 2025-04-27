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

import eOP.OPQueuenumbering.*;

public class OPQueuenumberingServlet extends javax.servlet.http.HttpServlet {
	PrintWriter out;

	java.util.Properties p;

	String locntype;

	String locncode;

	String pracid;

	String roomid;

	String walk_in = "";

	String referral = "";

	String appointment = "";

	String room_no1 = "";

	String otherresource = "";

	String facilityId;

	String client_ip_address;

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

		try {
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			String operation = req.getParameter("function");

			if (operation.equals("insert"))
				insertQueuenumbering(req, res);
			if (operation.equals("modify"))
				modifyQueuenumbering(req, res);

		} catch (Exception e) {
			//out.println(e.toString());
			e.printStackTrace();
		}

	}

	private void modifyQueuenumbering(HttpServletRequest req,
			HttpServletResponse res) {
		try {
			locntype = req.getParameter("locn_type");
			locncode = req.getParameter("locn_code");
			pracid = (req.getParameter("practitioner_id") == null) ? "" : req
					.getParameter("practitioner_id");
			roomid = req.getParameter("room_no");
			walk_in = req.getParameter("walk_in") == null ? "" : req
					.getParameter("walk_in");
			referral = req.getParameter("referral") == null ? "" : req
					.getParameter("referral");
			appointment = req.getParameter("appointment") == null ? "" : req
					.getParameter("appointment");
			otherresource = req.getParameter("other_resource") == null ? ""
					: req.getParameter("other_resource");
			room_no1 = req.getParameter("room_no1") == null ? "" : req
					.getParameter("room_no1");

			HashMap tabdata = new HashMap();

			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter(
					"LOCAL_EJBS") != null)
					&& (getServletConfig().getServletContext()
							.getInitParameter("LOCAL_EJBS")
							.equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(
					"java:comp/env/OPQueuenumbering",
					OPQueuenumberingManagerHome.class, local_ejbs);
			Object busObj = (home.getClass().getMethod("create", null)).invoke(
					home, null);

			tabdata.put("facilityId", facilityId);
			tabdata.put("locntype", locntype);
			tabdata.put("locncode", locncode);
			tabdata.put("pracid", pracid);
			tabdata.put("roomid", roomid);
			tabdata.put("AddedfacilityId", facilityId);
			tabdata.put("client_ip_address", client_ip_address);
			tabdata.put("walk_in", walk_in);
			tabdata.put("referral", referral);
			tabdata.put("appointment", appointment);
			tabdata.put("otherresource", otherresource);
			tabdata.put("room_no1", room_no1);

			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabdata;

			Class[] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();

			java.util.HashMap results = (java.util.HashMap) (busObj.getClass()
					.getMethod("updateQueuenumbering", paramArray)).invoke(
					busObj, argArray);

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
			//out.println(e.getMessage());
			//out.println(e.toString());
			e.printStackTrace();
		}

	}

	private void insertQueuenumbering(HttpServletRequest req,
			HttpServletResponse res) {
		try {
			locntype = req.getParameter("locn_type");
			locncode = req.getParameter("locn_code");
			pracid = req.getParameter("practitioner_id");
			roomid = req.getParameter("room_no");

			walk_in = req.getParameter("walk_in") == null ? "" : req
					.getParameter("walk_in");
			referral = req.getParameter("referral") == null ? "" : req
					.getParameter("referral");
			appointment = req.getParameter("appointment") == null ? "" : req
					.getParameter("appointment");
			otherresource = req.getParameter("other_resource") == null ? ""
					: req.getParameter("other_resource");
			room_no1 = req.getParameter("room_no1") == null ? "" : req
					.getParameter("room_no1");

			HashMap tabdata = new HashMap();

			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter(
					"LOCAL_EJBS") != null)
					&& (getServletConfig().getServletContext()
							.getInitParameter("LOCAL_EJBS")
							.equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(
					"java:comp/env/OPQueuenumbering",
					OPQueuenumberingManagerHome.class, local_ejbs);
			Object busObj = (home.getClass().getMethod("create", null)).invoke(
					home, null);

			tabdata.put("facilityId", facilityId);
			tabdata.put("locntype", locntype);
			tabdata.put("locncode", locncode);
			tabdata.put("pracid", pracid);
			tabdata.put("roomid", roomid);

			tabdata.put("locncode", locncode);
			tabdata.put("pracid", pracid);
			tabdata.put("roomid", roomid);

			tabdata.put("walk_in", walk_in);
			tabdata.put("referral", referral);
			tabdata.put("appointment", appointment);
			tabdata.put("otherresource", otherresource);
			tabdata.put("room_no1", room_no1);

			tabdata.put("AddedfacilityId", facilityId);
			tabdata.put("client_ip_address", client_ip_address);

			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabdata;

			Class[] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			java.util.HashMap results = (java.util.HashMap) (busObj.getClass()
					.getMethod("insertQueuenumbering", paramArray)).invoke(
					busObj, argArray);
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

			//out.println(e.getMessage());
			//out.println(e.toString());
			e.printStackTrace();
		}

	}
}
