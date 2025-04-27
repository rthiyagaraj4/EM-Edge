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
import java.text.*;
import webbeans.eCommon.*;

public class BatchProcessServlet extends javax.servlet.http.HttpServlet {

	PrintWriter out;

	java.util.Properties p;

	String facility_id = "";

	String service_code = "";

	PreparedStatement pstmt = null;

	CallableStatement cs = null;

	ResultSet rs;

	String error = "";

	String client_ip_address;

	String user_id = "";

	String module_id = "";

	String error_value = "0";

	String locale = "";

	Connection con = null;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req,
			HttpServletResponse res) throws javax.servlet.ServletException,
			IOException {
		HttpSession session = req.getSession(true);
		this.p = (java.util.Properties) session.getValue("jdbc");
		this.facility_id = (String) session.getValue("facility_id");
		client_ip_address = p.getProperty("client_ip_address");
		user_id = p.getProperty("login_user");
		locale = p.getProperty("LOCALE");
		try {

			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			con = ConnectionManager.getConnection(req);
			if (con.getAutoCommit() == true)
				con.setAutoCommit(false);
			this.p = (java.util.Properties) session.getValue("jdbc");
			this.out = res.getWriter();
			modify(req, res);
		} catch (Exception e) {
			//out.println(e.toString());
			e.printStackTrace();
		}
	}

	private void modify(HttpServletRequest req, HttpServletResponse res) {
		try {

			service_code = req.getParameter("service_code");
			module_id = req.getParameter("module_id");
			if (service_code == null || service_code.equals("null"))
				service_code = "";
 
			cs = con.prepareCall("{ call AutoCompleteVisits(?,?,?,?) }");
			cs.setString(1, facility_id);
			cs.setString(2, module_id);
			cs.setString(3, user_id);
			cs.setString(4, client_ip_address);
			cs.execute();

			if (cs != null)
				cs.close();
			if(!service_code.equals("")){
				cs = con.prepareCall("{ call AutoCloseEpisodes(?,?) }");
				cs.setString(1, facility_id);
				cs.setString(2, service_code);

				cs.execute();
				if (cs != null)
					cs.close();
			}
 
			con.commit();
			error_value = "1";

			MessageManager mm = new MessageManager();
				final java.util.Hashtable mesg = mm.getMessage(locale,
						"RECORD_MODIFIED", "SM");
				error = (String) mesg.get("message");
                
			/*pstmt = con
					.prepareStatement("select get_error_message('RECORD_MODIFIED') from dual");
			rs = pstmt.executeQuery();
			if (rs.next())
				error = rs.getString(1);*/

			res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
					+ java.net.URLEncoder.encode(error,"UTF-8") + "&err_value=1");

			if (pstmt != null)
				pstmt.close();
		} catch (Exception e) {
			try {
				e.printStackTrace();
				//out.println(e.toString());
				con.rollback();
				con.setAutoCommit(true);

				error_value = "0";
				error = "Batch Process Transaction Failed...." + e.toString();
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
						+ java.net.URLEncoder.encode(error,"UTF-8") + "&err_value="
						+ error_value);
			} catch (Exception ec) {
				ec.printStackTrace();
			}
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
			}

			if (con != null)
				ConnectionManager.returnConnection(con, req);
		}
	}// E.O.Method
}
