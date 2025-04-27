/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOP;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import webbeans.eCommon.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;

import eOP.ArrivedDepart.*;

public class ArrivedDepartedServlet extends javax.servlet.http.HttpServlet {
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
		try {

			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			HttpSession session = req.getSession(false);
			this.p = (java.util.Properties) session.getValue("jdbc");
			this.facilityId = (String) session.getValue("facility_id");
			this.client_ip_address = p.getProperty("client_ip_address");
			this.out = res.getWriter();
			String operationval = checkNull(req.getParameter("func_val"));
			locale = p.getProperty("LOCALE");

			if (operationval.equals("Arrived")) {
				UpdateArrived(req);
			} else if (operationval.equals("Depart")) {
				UpdateDeparted(req);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void UpdateArrived(HttpServletRequest req) {
		try {

			String addedFacilityId = facilityId;
			String addedAtWorkstation = client_ip_address;

			HashMap tabdata = new HashMap();
			tabdata.put("addedFacilityId", addedFacilityId);
			tabdata.put("patientid", checkNull(req.getParameter("pat_id")));
			tabdata
					.put("patientclass",
							checkNull(req.getParameter("enc_type")));
			tabdata
					.put("p_encounter_id",
							checkNull(req.getParameter("enc_id")));
			tabdata.put("encounterdatetime", checkNull(req
					.getParameter("enc_dt_time")));
			tabdata.put("pat_trn_time", checkNull(req
					.getParameter("pat_trn_time")));
			tabdata.put("locntype", checkNull(req.getParameter("locn_type")));
			tabdata.put("locncode", checkNull(req.getParameter("locn_code")));
			tabdata.put("userlocncode", checkNull(req
					.getParameter("user_locn_code")));
			tabdata.put("userlocntype", checkNull(req
					.getParameter("user_locn_type")));
			tabdata.put("addedFacilityId", addedFacilityId);
			tabdata.put("addedAtWorkstation", addedAtWorkstation);

			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter(
					"LOCAL_EJBS") != null)
					&& (getServletConfig().getServletContext()
							.getInitParameter("LOCAL_EJBS")
							.equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(
					"java:comp/env/ArrivedDepartedManager",
					ArrivedDepartedManagerHome.class, local_ejbs);
			Object busObj = (home.getClass().getMethod("create", null)).invoke(
					home, null);

			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabdata;

			Class[] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();

			java.util.HashMap results = (java.util.HashMap) (busObj.getClass()
					.getMethod("updateArrivedpat", paramArray)).invoke(busObj,
					argArray);

			(busObj.getClass().getMethod("remove", null)).invoke(busObj, null);
			boolean inserted = (((Boolean) results.get("status"))
					.booleanValue());
			if (inserted) {
				MessageManager mm = new MessageManager();
				final java.util.Hashtable mesg = mm.getMessage(locale,
						"RECORD_MODIFIED", "SM");
				String msg1 = (String) mesg.get("message");
				out.println("<html><script>alert('" + msg1
						+ "');</script></html>");
				// out.println("<html><script>alert(getMessage(\"RECORD_MODIFIED\",\"SM\"));</script></html>");
				out.println("<script>top.close();</script>");
			}

			argArray = null;
			paramArray = null;
			results.clear();
			tabdata.clear();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void UpdateDeparted(HttpServletRequest req) {
		try {

			String addedFacilityId = facilityId;
			String addedAtWorkstation = client_ip_address;
			HashMap tabdata = new HashMap();
			tabdata.put("addedFacilityId", addedFacilityId);
			tabdata.put("patientid", checkNull(req.getParameter("pat_id")));
			tabdata
					.put("patientclass",
							checkNull(req.getParameter("enc_type")));
			tabdata
					.put("p_encounter_id",
							checkNull(req.getParameter("enc_id")));
			tabdata.put("encounterdatetime", checkNull(req
					.getParameter("enc_dt_time")));
			tabdata.put("pat_trn_time", checkNull(req
					.getParameter("pat_trn_time")));
			tabdata.put("locntype", checkNull(req
					.getParameter("location_type1")));
			tabdata.put("locncode", checkNull(req
					.getParameter("location_code1")));
			tabdata.put("userlocncode", checkNull(req
					.getParameter("user_locn_code")));
			tabdata.put("userlocntype", checkNull(req
					.getParameter("user_locn_type")));
			tabdata.put("move_reason", checkNull(req
					.getParameter("move_reason")));
			tabdata.put("addedFacilityId", addedFacilityId);
			tabdata.put("addedAtWorkstation", addedAtWorkstation);

			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter(
					"LOCAL_EJBS") != null)
					&& (getServletConfig().getServletContext()
							.getInitParameter("LOCAL_EJBS")
							.equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(
					"java:comp/env/ArrivedDepartedManager",
					ArrivedDepartedManagerHome.class, local_ejbs);
			Object busObj = (home.getClass().getMethod("create", null)).invoke(
					home, null);

			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabdata;

			Class[] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();

			java.util.HashMap results = (java.util.HashMap) (busObj.getClass()
					.getMethod("updateDepartedpat", paramArray)).invoke(busObj,
					argArray);

			(busObj.getClass().getMethod("remove", null)).invoke(busObj, null);

			boolean inserted = (((Boolean) results.get("status"))
					.booleanValue());
			if (inserted) {
				MessageManager mm = new MessageManager();
				final java.util.Hashtable mesg = mm.getMessage(locale,
						"RECORD_MODIFIED", "SM");
				String msg1 = (String) mesg.get("message");
				out.println("<html><script>alert('" + msg1
						+ "');</script></html>");
				// out.println("<html><script>alert(getMessage(\"RECORD_MODIFIED\",\"SM\"));</script></html>");
				out.println("<script>parent.parent.document.getElementById('dialog_tag').close();</script>");
			}
			argArray = null;
			paramArray = null;
			results.clear();
			tabdata.clear();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String checkNull(String str) {
		return ((str == null || str.equals("null")) ? "" : str);
	}

}
