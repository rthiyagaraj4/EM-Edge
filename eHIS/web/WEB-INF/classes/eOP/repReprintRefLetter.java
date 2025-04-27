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
import java.util.*;

public class repReprintRefLetter extends javax.servlet.http.HttpServlet {

	PrintWriter out;

	HttpSession session;

	String p_report_id;

	String p_module_id;

	String p_facility_id;

	int i = 0;

	String ReportOutput = "";

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req,
			HttpServletResponse res) throws javax.servlet.ServletException,
			IOException {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session = req.getSession(false);

		try {
			this.out = res.getWriter();
			doReportPrinting(req, res);

		} catch (Exception e) {
			out.println(e.toString());
		}
	}

	public void doReportPrinting(HttpServletRequest req, HttpServletResponse res) {
		try {
			p_report_id = req.getParameter("p_report_id");
			p_module_id = req.getParameter("p_module_id");
			p_facility_id = req.getParameter("p_facility_id");
			String ref_id_str = req.getParameter("p_referral_id");

			StringTokenizer st1 = new StringTokenizer(ref_id_str, ",");
			String p_appt_ref_no[] = new String[st1.countTokens()];
			i = st1.countTokens();

			ecis.utils.OnlineReports onlineReports = new ecis.utils.OnlineReports();
			String p_to_locn_code = req.getParameter("p_to_locn_code") != null ? req
					.getParameter("p_to_locn_code")
					: "";
			for (int j = 0; j < i; j++) {
				p_appt_ref_no[j] = st1.nextToken();
				ecis.utils.OnlineReport report1 = new ecis.utils.OnlineReport(
						p_facility_id, p_module_id, p_report_id, "L",
						p_to_locn_code);
				report1.addParameter("p_facility_id", p_facility_id);
				report1.addParameter("p_referral_id", p_appt_ref_no[j]);
				onlineReports.add(report1);
			}
			session.putValue("online_reports", onlineReports);
			ReportOutput = onlineReports.execute(req, res);
			// out.println(ReportOutput);
			res.sendRedirect("../eOA/jsp/oaprinterror.jsp?err_num="
					+ java.net.URLEncoder.encode(ReportOutput,"UTF-8"));

		} catch (Exception e) {
			//out.println("Encountered error while Processing Online Reports "+ e.toString());

			e.printStackTrace();
		}

	} // END OF THE METHOD........

}//end of class

