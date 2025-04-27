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

public class ResourceTypeForVisitTypeServlet extends HttpServlet {
	PrintWriter out;

	java.util.Properties p;

	String visit_type;

	String facilityId;

	String client_ip_address;

	String sql = "";

	Statement stmt = null;

	ResultSet rs = null;

	Connection con = null;

	String locale = "";

	HttpSession session;

	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat(
			"yyyy-MM-dd");

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException {
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue("jdbc");
		this.facilityId = (String) session.getValue("facility_id");
		client_ip_address = p.getProperty("client_ip_address");
		locale = p.getProperty("LOCALE");

		try {
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			con = ConnectionManager.getConnection(req);
			this.out = res.getWriter();
			String operation = req.getParameter("function_na");

			if (operation.equals("Insert"))
				insertResourceTypeForVT(req, res);
			if (operation.equals("Modify"))
				modifyResourceTypeForVT(req, res);
			if (operation.equals("Delete"))
				deleteResourceTypeForVT(req, res);
		} catch (Exception e) {
			out.println(e.toString());
		} finally {
			if (con != null)
				ConnectionManager.returnConnection(con, req);
		}
	}

	private void deleteResourceTypeForVT(HttpServletRequest req,
			HttpServletResponse res) {

		try {

			int count = 0;
			visit_type = req.getParameter("visit_type_code");
			if (visit_type == null)
				visit_type = "";

			sql = "select count(*) from op_resource_type_for_appt where visit_type_code='"
					+ visit_type + "' and facility_id='" + facilityId + "'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next())
				count = rs.getInt(1);
			if (count > 1) {
				HashMap tabdata = new HashMap();
				tabdata.put("facility_id", facilityId);
				tabdata.put("visit_type_code", visit_type);
				tabdata.put("resource_srl_no", checkNull(req
						.getParameter("rserialno")));

				String table_name = "op_resource_type_for_appt";
				boolean local_ejbs = false;
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
				Object argArray[] = new Object[3];
				argArray[0] = p;
				argArray[1] = tabdata;
				argArray[2] = table_name;
				Class[] paramArray = new Class[3];
				paramArray[0] = p.getClass();
				paramArray[1] = tabdata.getClass();
				paramArray[2] = table_name.getClass();

				java.util.HashMap results = (java.util.HashMap) (busObj
						.getClass().getMethod("delete", paramArray)).invoke(
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
					error = (String) results.get("error");
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
							+ java.net.URLEncoder.encode(error,"UTF-8"));
				}

				argArray = null;
				paramArray = null;
				results.clear();
				tabdata.clear();

			}// if close
			else if (count == 1) {
				MessageManager mm = new MessageManager();
				final java.util.Hashtable mesg = mm.getMessage(locale,
						"ATLEAST_ONE_RES_VISIT", "OP");
				String msg1 = (String) mesg.get("message");
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
						+ java.net.URLEncoder.encode(msg1,"UTF-8"));
			}

			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
		}// End of try
		catch (Exception e) {
			out
					.println("<h3> Exception raise by Servlet ...So Record Not Deleted foll: Error Received : "
							+ e.toString());
		}

	}

	private void modifyResourceTypeForVT(HttpServletRequest req,
			HttpServletResponse res) {
		try {
			boolean flag = true;
			visit_type = req.getParameter("visit_type_code");
			if (visit_type == null)
				visit_type = "";
			String rsno = req.getParameter("rserialno");
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
			tabdata.put("resource_type", checkNull(req
					.getParameter("rsource_type")));
			tabdata.put("resource_criteria", checkNullWithDftValue(req
					.getParameter("required"), "N"));
			tabdata.put("modified_by_id", modifiedById);
			tabdata.put("modified_date", modified_date);
			tabdata.put("modified_at_ws_no", modifiedAtWorkstation);
			tabdata.put("modified_facility_id", modifiedFacilityId);

			HashMap condflds = new HashMap();

			condflds.put("facility_id", facilityId);
			condflds.put("visit_type_code", visit_type);
			condflds.put("resource_srl_no", rsno);

			if (flag) {

				String table_name = "op_resource_type_for_appt";
				boolean local_ejbs = false;

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
				argArray[2] = condflds;
				argArray[3] = table_name;

				Class[] paramArray = new Class[4];
				paramArray[0] = p.getClass();
				paramArray[1] = tabdata.getClass();
				paramArray[2] = condflds.getClass();
				paramArray[3] = table_name.getClass();

				java.util.HashMap results = (java.util.HashMap) (busObj
						.getClass().getMethod("update", paramArray)).invoke(
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
					error = (String) results.get("error");
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
							+ java.net.URLEncoder.encode(error,"UTF-8"));
				}
				argArray = null;
				paramArray = null;
				results.clear();
				tabdata.clear();
				condflds.clear();

			} else {
				MessageManager mm = new MessageManager();
				final java.util.Hashtable mesg = mm.getMessage(locale,
						"RECORD_ALREADY_EXISTS", "Common");
				String msg1 = (String) mesg.get("message");
				out.println("<html><script>alert('" + msg1
						+ "');</script></html>");
				// out.println("<html><script>alert(getMessage(\"RECORD_ALREADY_EXISTS\",\"COMMON\"));</script></html>");
				out
						.println("<html><head><script>self.location.href='../eCommon/jsp/error.jsp?err_num=&err_value=0'</script></head></html>");
			}

		}// End of try
		catch (Exception e) {
			out
					.println("<h3> Exception raise by Servlet ...So Record Not Inserted foll: Error Received : "
							+ e.toString());

		}
	}

	private void insertResourceTypeForVT(HttpServletRequest req,
			HttpServletResponse res) {

		try {
			visit_type = req.getParameter("visittype");
			if (visit_type == null)
				visit_type = "";

			String addedById = p.getProperty("login_user");
			String addedDate = dateFormat.format(new java.util.Date());
			String modifiedById = addedById;
			String modifiedDate = addedDate;
			String addedFacilityId = facilityId;
			String modifiedFacilityId = addedFacilityId;
			String addedAtWorkstation = client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation;
			int RserialNo = 0;
			java.sql.Date added_date = java.sql.Date.valueOf(addedDate);
			java.sql.Date modified_date = java.sql.Date.valueOf(modifiedDate);

			sql = "select max(resource_srl_no) from op_resource_type_for_appt where visit_type_code='"
					+ visit_type + "'";
			int sno = 0;

			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs == null) {
				RserialNo = 10;
			} else {
				if (rs.next()) {
					sno = rs.getInt(1);
				}
				RserialNo = sno + 10;
			}

			HashMap tabdata = new HashMap();
			tabdata.put("facility_id", facilityId);
			tabdata.put("visit_type_code", visit_type);
			tabdata.put("resource_srl_no", new Integer(RserialNo));
			tabdata.put("resource_class", checkNull(req
					.getParameter("resourceclass")));
			tabdata.put("resource_type", checkNull(req
					.getParameter("resourcetype")));
			tabdata.put("resource_criteria", checkNullWithDftValue(req
					.getParameter("required"), "N"));
			tabdata.put("added_by_id", addedById);
			tabdata.put("added_date", added_date);
			tabdata.put("added_at_ws_no", addedAtWorkstation);
			tabdata.put("added_facility_id", addedFacilityId);
			tabdata.put("modified_by_id", modifiedById);
			tabdata.put("modified_date", modified_date);
			tabdata.put("modified_at_ws_no", modifiedAtWorkstation);
			tabdata.put("modified_facility_id", modifiedFacilityId);

			String dupflds[] = { "facility_id", "visit_type_code",
					"resource_class" };

			String table_name = "op_resource_type_for_appt";
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

			argArray = null;
			paramArray = null;
			results.clear();
			tabdata.clear();
			dupflds = null;

			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();

		}// End of try
		catch (Exception e) {
			out
					.println("<h3> Exception raise by Servlet ...So Record Not Inserted foll: Error Received : "
							+ e.toString());
		}
	}

	public static String checkNull(String str) {
		return ((str == null || str.equals("null")) ? "" : str);
	}

	public static String checkNullWithDftValue(String str, String dftval) {
		return ((str == null || str.equals("null")) ? dftval : str);
	}

}
