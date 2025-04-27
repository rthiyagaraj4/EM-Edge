/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import eCA.ApplicationTask.*;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.*;

public class ApplicationTaskServlet extends javax.servlet.http.HttpServlet 
{
	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,
			IOException 
	{
		PrintWriter out = null;

		try 
		{
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
req= new XSSRequestWrapper(req); //MOHE-SCF-0153
res.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
res.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			out = res.getWriter();

			insertApplicationTask(req, res, out);

		} 
		catch (Exception e) 
		{
			out.println("Exception in try of doPost() of ApplicationTaskServlet.java"+ e.toString());
			e.printStackTrace();
		}

	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws javax.servlet.ServletException, IOException 
	{
		PrintWriter out = null;
	
		try 
		{
			out = res.getWriter();
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			String url = "../eCommon/jsp/MstCodeToolbar.jsp?";
			String params = req.getQueryString();
			String source = url + params;
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../eCommon/html/ecis.css'></link> <script src='../eCommon/js/common.js' language='javascript'></script> <script language='javascript' src='../eMP/js/ActiveInactive.js'></script></head><frameset rows='42,*,50'><frame name='commontoolbarFrame'	src='"
							+ source
							+ "' frameborder=0 scrolling='no' noresize><frame name='f_query_add_mod' src='../eCommon/html/blank.html' frameborder=0><frame name='messageFrame' src='../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'></frameset></html> ");


		} 
		catch (Exception e) 
		{
			//out.println("Exception in try of doGet() of ApplicationTaskServlet.java"+ e.toString());comon-icn-0181
			e.printStackTrace();
		}
	}

	private void insertApplicationTask(HttpServletRequest req,
			HttpServletResponse res, PrintWriter out) 
	{
		try 
		{

			java.util.Properties p;
			String facilityId = "";
			String client_ip_address = "";
			HttpSession session = req.getSession(false);
			p = (java.util.Properties) session.getValue("jdbc");
			String locale = p.getProperty("LOCALE"); 
			facilityId = (String) session.getValue("facility_id");
			client_ip_address = p.getProperty("client_ip_address");
			
			if(facilityId == null) facilityId = "";

			String task_status = "";
			//String task_name = "";   //COMMON-ICN-0122
			String task_text = "";
			String taskApplicable = "";
			String message = "";
			String error_value = "";
			String count = "";
			String app_access_rights = "";

			String addedById = p.getProperty("login_user");
			String modifiedById = addedById;
			String addedFacilityId = facilityId;
			String modifiedFacilityId = facilityId;
			String addedAtWorkstation = client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation;

			boolean inserted = false;
			int totCount = 0;
			int k = 0;
			//int s = 0;   //COMMON-ICN-0122

			HashMap tabdata = new HashMap();
			HashMap dupflds = new HashMap();
			HashMap results = new HashMap();
           // ArrayList access_right = new ArrayList();  //COMMON-ICN-0122
			count = req.getParameter("count");
			task_text = req.getParameter("taskText") == null ? "" : req
					.getParameter("taskText");
			taskApplicable = req.getParameter("taskApplicable") == null ? ""
					: req.getParameter("taskApplicable");
			totCount = Integer.parseInt(count);
			for (int ilCount = 0; ilCount < totCount; ilCount++) {
				task_status = req.getParameter("task_status" + ilCount);
				 String as = "app_access_rights" + ilCount; 
				 app_access_rights = req.getParameter(as) == null ? "": (String)req.getParameter(as);
				if (task_status != null) {
					k++;
					tabdata.put("task_status" + k, task_status);
					tabdata.put("app_access_rights" + k, app_access_rights);
				}
			}

			tabdata.put("taskApplicable", taskApplicable);
			tabdata.put("task_text", task_text);
			tabdata.put("count", new Integer(k));
			tabdata.put("added_by_id", addedById);
			tabdata.put("added_date", new java.sql.Timestamp(System
					.currentTimeMillis()));
			tabdata.put("added_facility_id", addedFacilityId);
			tabdata.put("added_at_ws_no", addedAtWorkstation);
			tabdata.put("modified_by_id", modifiedById);
			tabdata.put("modified_date", new java.sql.Timestamp(System
					.currentTimeMillis()));
			tabdata.put("modified_facility_id", modifiedFacilityId);
			tabdata.put("modified_at_ws_no", modifiedAtWorkstation);
			tabdata.put("locale",locale);

			dupflds = new HashMap();
			dupflds.put("module_id", "CA");
			/* added by jupitora on 10/2/2005 start */
			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter(
					"LOCAL_EJBS") != null)
					&& (getServletConfig().getServletContext()
							.getInitParameter("LOCAL_EJBS")
							.equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance()
					.getHome("java:comp/env/ApplicationTask",
							ApplicationTaskHome.class, local_ejbs);
			Object busObj = (home.getClass().getMethod("create", null)).invoke(
					home, null);

			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabdata;

			Class[] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();

			results = (java.util.HashMap) (busObj.getClass().getMethod(
					"insertApplicationTask", paramArray)).invoke(busObj,
					argArray);

			(busObj.getClass().getMethod("remove", null)).invoke(busObj, null);
			argArray = null;
			paramArray = null;
			tabdata.clear();
			dupflds.clear();

			/* added by jupitora on 10/2/2005 end */
			inserted = (((Boolean) results.get("status")).booleanValue());

			message = (String) results.get("message");

			if (message == null || message.equals("")) {
				message = (String) results.get("error");
			}
			results.clear();
			error_value = "0";

			if (inserted)
				error_value = "1";
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="
					+ java.net.URLEncoder.encode(message,"UTF-8") + "&err_value="
					+ error_value);
			//results.clear();
		} catch (Exception e) {
			e.printStackTrace();
			
			//out.println("Exception in try of insertApplicationTask() of ApplicationTaskServlet.java"+ e.toString());//common-icn-0181
		}		
	}
}
