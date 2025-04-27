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
import javax.ejb.*;

import eCommon.SingleTabHandler.*;

public class ConcludeEpisodeServlet extends javax.servlet.http.HttpServlet {
	PrintWriter out;

	java.util.Properties p;

	String facilityId;

	String client_ip_address;

	HttpSession session;

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
			closeEpisode(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void closeEpisode(HttpServletRequest req) {
		try {
			String addedById = p.getProperty("login_user");
			String modifiedById = addedById;
			String addedFacilityId = facilityId;
			String modifiedFacilityId = addedFacilityId;
			String addedAtWorkstation = client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation;
            String locale=p.getProperty("LOCALE");			
			Timestamp modified_date = new Timestamp(System.currentTimeMillis());

            String end_date=req.getParameter("end_date")==null?"":req.getParameter("end_date");
			if(!end_date.equals(""))
			{
				end_date=com.ehis.util.DateUtils.convertDate(end_date,"DMYHM",locale,"en");

				StringTokenizer str=new StringTokenizer(end_date, " ");		
			
				String date=str.nextToken();
				String time=str.nextToken();
				StringTokenizer str1=new StringTokenizer(date, "/");
				String day=str1.nextToken();
				String month=str1.nextToken();		
				String year=str1.nextToken();
				end_date=year+"-"+month+"-"+day+" "+time+":00.00";
			}	

			HashMap tabdata = new HashMap();
			tabdata.put("EPISODE_STATUS", "08");
			tabdata.put("END_DATE_TIME", Timestamp.valueOf((end_date)) );
			tabdata.put("EPISODE_NOTES", checkNull(req
					.getParameter("conclude_episode_notes")));
			tabdata.put("MODIFIED_BY_ID", modifiedById);
			tabdata.put("MODIFIED_DATE", modified_date);
			tabdata.put("MODIFIED_FACILITY_ID", modifiedFacilityId);
			tabdata.put("MODIFIED_AT_WS_NO", modifiedAtWorkstation);

			HashMap condflds = new HashMap();
			condflds.put("PATIENT_ID",
					checkNull(req.getParameter("patient_id")));
			condflds.put("OPERATING_FACILITY_ID", facilityId);
			condflds.put("EPISODE_ID",
					checkNull(req.getParameter("episode_id")));

			String table_name = "OP_EPISODE_FOR_SERVICE";
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
			argArray[3] = table_name;

			Class[] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = table_name.getClass();

			java.util.HashMap results = (java.util.HashMap) (busObj.getClass()
					.getMethod("update", paramArray)).invoke(busObj, argArray);
			(busObj.getClass().getMethod("remove", null)).invoke(busObj, null);
			boolean inserted = (((Boolean) results.get("status"))
					.booleanValue());

			String error = (String) results.get("error");
			if (inserted) {
				if (error.lastIndexOf("<br>") >= 0)
					error = error.substring(0, error.lastIndexOf("<br>"));
				out.println("<script> alert(\""
								+ error
								+ "\"); parent.window.returnValue='success'; parent.parent.document.getElementById('dialog_tag').close();  </script>");
			} else {
				out.println("<script> alert(\"" + error
						+ "\"); parent.parent.document.getElementById('dialog_tag').close(); </script>");
			}
			argArray = null;
			paramArray = null;
			results.clear();
			tabdata.clear();
			condflds.clear();

		} catch (Exception e) {
			out
					.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "
							+ e.toString());
							e.printStackTrace();
		}
	}

	public static String checkNull(String str) {
		return ((str == null || str.equals("null")) ? "" : str);
	}
}
