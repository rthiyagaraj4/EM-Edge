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
import eCommon.SingleTabHandler.*;
import com.ehis.eslp.ServiceLocator;

public class OPQSeriesServlet extends javax.servlet.http.HttpServlet {

	String facilityId = "";

	String queue_id = "";

	String queue_desc = "";

	String startqueuenum = "";

	String nextqueuenum = "";

	String resetqueuenum = "";

	String queue_prefix = "";

	String walk_in_yn = "";

	String appt_yn = "";

	String ref_yn = "";

	String enable_yn = "";

	String client_ip_address;

	String modifiedById = "";

	String addedById = "";

	String addedDate = "";

	String modifiedDate = "";

	String addedFacilityId = "";

	String modifiedFacilityId = "";

	String addedAtWorkstation = "";

	String modifiedAtWorkstation = "";

	java.sql.Date added_date;

	java.sql.Date modified_date;

	Connection con = null;

	java.util.Properties p;

	String locale = "";

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req,
			HttpServletResponse res) throws javax.servlet.ServletException,
			IOException {
         req.setCharacterEncoding("UTF-8");
		 res.setContentType("text/html;charset=UTF-8");
		HttpSession session = req.getSession(false);
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(
				"yyyy-MM-dd");
		this.facilityId = (String) session.getValue("facility_id");
		this.p = (java.util.Properties) session.getValue("jdbc");
		this.client_ip_address = p.getProperty("client_ip_address");

		addedById = p.getProperty("login_user");
		modifiedById = addedById;
		addedDate = dateFormat.format(new java.util.Date());
		modifiedDate = addedDate;
		addedFacilityId = facilityId;
		modifiedFacilityId = addedFacilityId;
		addedAtWorkstation = client_ip_address;
		modifiedAtWorkstation = addedAtWorkstation;

		added_date = java.sql.Date.valueOf(addedDate);
		modified_date = java.sql.Date.valueOf(modifiedDate);
		locale = p.getProperty("LOCALE");

		try {

			
			
			String operation = req.getParameter("mode");

			if (operation == null)
				operation = "";

			if (operation.equals("Insert"))
				insertQueueSeries(req, res);
			if (operation.equals("Modify"))
				modifyQueueSeries(req, res);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void insertQueueSeries(HttpServletRequest req,
			HttpServletResponse res) {
		try {
			con = ConnectionManager.getConnection(req);
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			queue_id = req.getParameter("queue_id");
			queue_desc = req.getParameter("short_desc");
			walk_in_yn = req.getParameter("walk_in_yn");
			appt_yn = req.getParameter("appt_yn");
			ref_yn = req.getParameter("ref_yn");

			enable_yn = req.getParameter("enable_yn");
			if (enable_yn == null)
				enable_yn = "E";

			int cnt = 0;
			queue_prefix = req.getParameter("q_prefix").trim();
			startqueuenum = req.getParameter("start_queue_num").trim();
			nextqueuenum = req.getParameter("next_queue_num").trim();
			resetqueuenum = req.getParameter("reset_queue_num").trim();

			if (queue_id == null)
				queue_id = "";
			if (queue_desc == null)
				queue_desc = "";
			if (walk_in_yn == null)
				walk_in_yn = "N";
			if (appt_yn == null)
				appt_yn = "N";
			if (ref_yn == null)
				ref_yn = "N";

			if (queue_prefix == null)
				queue_prefix = "";
			if (startqueuenum == null)
				startqueuenum = "";
			if (nextqueuenum == null)
				nextqueuenum = "";
			if (resetqueuenum == null)
				resetqueuenum = "";

			String sqlcount = "select count(*) count from op_queue_series where queue_prefix='"
					+ queue_prefix + "'";

			pstmt = con.prepareStatement(sqlcount);
			rs = pstmt.executeQuery();

			if (rs != null) {
				if (rs.next()) {
					cnt = rs.getInt(1);
				}
			}
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();

			if (cnt == 0) {

				HashMap tabdata = new HashMap();
				tabdata.put("QUEUE_ID", queue_id);
				tabdata.put("QUEUE_DESCRIPTION", queue_desc);
				tabdata.put("WALK_IN_APPL_YN", walk_in_yn);
				tabdata.put("REFERRAL_APPL_YN", ref_yn);
				tabdata.put("APPT_APPL_YN", appt_yn);
				tabdata.put("QUEUE_PREFIX", new Integer(queue_prefix));
				tabdata.put("START_QUEUE_NUM", new Integer(startqueuenum));
				tabdata.put("NEXT_QUEUE_NUM", new Integer(nextqueuenum));
				tabdata.put("QUEUE_DATE", added_date);
				if (resetqueuenum.equals(""))
					tabdata.put("RESET_QUEUE_NUM", resetqueuenum);
				else
					tabdata.put("RESET_QUEUE_NUM", new Integer(resetqueuenum));

				tabdata.put("ADDED_BY_ID", addedById);
				tabdata.put("ADDED_DATE", added_date);
				tabdata.put("ADDED_AT_WS_NO", addedAtWorkstation);
				tabdata.put("ADDED_FACILITY_ID", addedFacilityId);
				tabdata.put("MODIFIED_BY_ID", modifiedById);
				tabdata.put("MODIFIED_DATE", modified_date);
				tabdata.put("MODIFIED_AT_WS_NO", modifiedAtWorkstation);
				tabdata.put("MODIFIED_FACILITY_ID", modifiedFacilityId);
				tabdata.put("EFF_STATUS", enable_yn);

				String dupflds[] = { "QUEUE_ID" };
				boolean local_ejbs = false;
				String tabname = "op_queue_series";
				if ((getServletConfig().getServletContext().getInitParameter(
						"LOCAL_EJBS") != null)
						&& (getServletConfig().getServletContext()
								.getInitParameter("LOCAL_EJBS")
								.equalsIgnoreCase("TRUE")))
					local_ejbs = true;

				Object home = com.ehis.eslp.ServiceLocator.getInstance()
						.getHome("java:comp/env/SingleTabHandler",
								SingleTabHandlerManagerHome.class, local_ejbs);
				Object busObj = (home.getClass().getMethod("create", null))
						.invoke(home, null);

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

				java.util.HashMap results = (java.util.HashMap) (busObj
						.getClass().getMethod("insert", paramArray)).invoke(
						busObj, argArray);

				(busObj.getClass().getMethod("remove", null)).invoke(busObj,
						null);

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

			} else {
				String error_value = "0";
				MessageManager mm = new MessageManager();
				final java.util.Hashtable mesg = mm.getMessage(locale,
						"QUEUE_PREFIX_EXISTS", "OP");
				String msg1 = (String) mesg.get("message");
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
						+ java.net.URLEncoder.encode(msg1,"UTF-8") + "&err_value="
						+ error_value);
			}

		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			if (con != null)
				ConnectionManager.returnConnection(con, p);
		}

	}

	private void modifyQueueSeries(HttpServletRequest req,
			HttpServletResponse res) {
		try {
			con = ConnectionManager.getConnection(req);
			PreparedStatement pstmt1 = null;
			ResultSet rs1 = null;
			boolean insertable = true;
			int cnt1 = 0;
			String qpref = "";
			queue_id = req.getParameter("queue_id");
			queue_desc = req.getParameter("short_desc");
			walk_in_yn = req.getParameter("walk_in_yn");
			appt_yn = req.getParameter("appt_yn");
			ref_yn = req.getParameter("ref_yn");
			enable_yn = req.getParameter("enable_yn");
			if (enable_yn == null)
				enable_yn = "E";
			queue_prefix = req.getParameter("q_prefix").trim();
			startqueuenum = req.getParameter("start_queue_num").trim();
			nextqueuenum = req.getParameter("next_queue_num").trim();
			resetqueuenum = req.getParameter("reset_queue_num").trim();

			if (queue_prefix == null)
				queue_prefix = "";
			if (startqueuenum == null)
				startqueuenum = "";
			if (nextqueuenum == null)
				nextqueuenum = "";
			if (resetqueuenum == null)
				resetqueuenum = "";
			if (queue_id == null)
				queue_id = "";
			if (queue_desc == null)
				queue_desc = "";
			if (walk_in_yn == null)
				walk_in_yn = "N";
			if (appt_yn == null)
				appt_yn = "N";
			if (ref_yn == null)
				ref_yn = "N";

			HashMap tabdata = new HashMap();

			tabdata.put("QUEUE_DESCRIPTION", queue_desc);
			tabdata.put("WALK_IN_APPL_YN", walk_in_yn);
			tabdata.put("REFERRAL_APPL_YN", ref_yn);
			tabdata.put("APPT_APPL_YN", appt_yn);
			tabdata.put("START_QUEUE_NUM", new Integer(startqueuenum));
			tabdata.put("NEXT_QUEUE_NUM", new Integer(nextqueuenum));
			tabdata.put("QUEUE_DATE", added_date);
			if (resetqueuenum.equals(""))
				tabdata.put("RESET_QUEUE_NUM", resetqueuenum);
			else
				tabdata.put("RESET_QUEUE_NUM", new Integer(resetqueuenum));

			tabdata.put("MODIFIED_BY_ID", modifiedById);
			tabdata.put("MODIFIED_DATE", modified_date);
			tabdata.put("MODIFIED_AT_WS_NO", modifiedAtWorkstation);
			tabdata.put("MODIFIED_FACILITY_ID", modifiedFacilityId);
			tabdata.put("EFF_STATUS", enable_yn);
			tabdata.put("QUEUE_PREFIX", new Integer(queue_prefix));

			HashMap condflds = new HashMap();
			condflds.put("QUEUE_ID", queue_id);

			String sqlc = "select queue_prefix from op_queue_series where queue_id='"
					+ queue_id + "'";

			pstmt1 = con.prepareStatement(sqlc);
			rs1 = pstmt1.executeQuery();

			if (rs1 != null) {
				if (rs1.next()) {
					qpref = rs1.getString(1);
				}
			}

			if (rs1 != null)
				rs1.close();
			if (pstmt1 != null)
				pstmt1.close();

			if (!qpref.equals(queue_prefix)) {
				String sqlcount = "select count(*) count from op_queue_series where queue_prefix='"
						+ queue_prefix + "'";

				pstmt1 = con.prepareStatement(sqlcount);
				rs1 = pstmt1.executeQuery();

				if (rs1 != null) {
					if (rs1.next()) {
						cnt1 = rs1.getInt(1);
					}
				}
				if (rs1 != null)
					rs1.close();
				if (pstmt1 != null)
					pstmt1.close();
				if (cnt1 == 0)
					insertable = true;
				else
					insertable = false;
			}
			if (insertable) {
				boolean flag = false;
				String tabname = "op_queue_series";
				if (getServletConfig().getServletContext().getInitParameter(
						"LOCAL_EJBS") != null
						&& getServletConfig().getServletContext()
								.getInitParameter("LOCAL_EJBS")
								.equalsIgnoreCase("TRUE"))
					flag = true;
				Object obj = ServiceLocator
						.getInstance()
						.getHome(
								"java:comp/env/SingleTabHandler",
								eCommon.SingleTabHandler.SingleTabHandlerManagerHome.class,
								flag);
				Object obj1 = obj.getClass().getMethod("create", null).invoke(
						obj, null);
				Object aobj[] = new Object[4];
				aobj[0] = p;
				aobj[1] = tabdata;
				aobj[2] = condflds;
				aobj[3] = tabname;
				Class aclass[] = new Class[4];
				aclass[0] = p.getClass();
				aclass[1] = tabdata.getClass();
				aclass[2] = condflds.getClass();
				aclass[3] = tabname.getClass();
				HashMap results = (HashMap) obj1.getClass().getMethod("update",
						aclass).invoke(obj1, aobj);
				obj1.getClass().getMethod("remove", null).invoke(obj1, null);
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
			} else {
				MessageManager mm = new MessageManager();
				final java.util.Hashtable mesg = mm.getMessage(locale,
						"QUEUE_PREFIX_EXISTS", "OP");
				String msg1 = (String) mesg.get("message");
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
						+ java.net.URLEncoder.encode(msg1,"UTF-8"));
			}
			tabdata.clear();
			condflds.clear();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				ConnectionManager.returnConnection(con, p);
		}
	}

}
