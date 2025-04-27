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
import eOP.OPPractitionerClinic.*;

public class PractitionerClinicServlet extends javax.servlet.http.HttpServlet {
	PrintWriter out;

	String callfunc;

	String facilityId;

	String client_ip_address;

	java.util.Properties p;

	String working_week_Appl_day[] = new String[7];

	String working_day[] = new String[7];

	String working_week_1_day[] = new String[7];

	String working_week_2_day[] = new String[7];

	String working_week_3_day[] = new String[7];

	String working_week_4_day[] = new String[7];

	String working_week_5_day[] = new String[7];

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req,
			HttpServletResponse res) throws javax.servlet.ServletException,
			IOException {
		HttpSession session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue("jdbc");
		this.facilityId = (String) session.getValue("facility_id");
		client_ip_address = p.getProperty("client_ip_address");
		try {
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			String operation = req.getParameter("function");
			if (operation.equals("insert"))
				insertClinic(req, res);
			if (operation.equals("modify"))
				modifyClinic(req, res);
			if (operation.equals("insertByPract"))
				insertByPract(req,res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//Added by Ajay Hatwate for ML-MMOH-CRF-2121
	private void insertByPract(HttpServletRequest req, HttpServletResponse res) {
		try {
			HttpSession session = req.getSession(false);
			HashMap tabdata = new HashMap();
			HashMap<String, String> map = (HashMap<String, String>)(session.getAttribute("ResForLocnByPract")==null ? new HashMap<String, String>() : session.getAttribute("ResForLocnByPract"));
			
			String a_codes = "";
			String c_codes = "";
			callfunc = req.getParameter("called_from");
			
			String start = (req.getParameter("start")==null)? "0" : req.getParameter("start");
			String end = (req.getParameter("end")==null)?"0":req.getParameter("end");
			String delete_id = "";
			String isOnApply				=   (req.getParameter("isOnApply")    ==null)	? "N" : req.getParameter("isOnApply");
			
			isOnApply = isOnApply.trim();
			tabdata.put("callfunction", callfunc);
			tabdata.put("pract_id", checkNull(req.getParameter("pract_id")));
			tabdata.put("clinic_type", checkNull(req.getParameter("clinic_type")));
			
			tabdata.put("addedFacilityId", facilityId);
			tabdata.put("addedAtWorkstation", client_ip_address);
			
			boolean local_ejbs = false;
			boolean first_time_delete = true;
			int insertCount = 0;
			if(map != null){ // Added for ML-MMOH-SCF-3045 
			int pageval=Integer.parseInt(map.get("page"));
			// Added for ML-MMOH-SCF-3045 start
			String oper = checkNull(map.get("oper"));
			String cntOFPract = checkNull(map.get("cntOFPract"));
			if (oper != "" && oper.equals("create") && cntOFPract != "" && cntOFPract.equals("0")) {
				pageval=Integer.parseInt(map.get("prevPageno"));
			}
			// Added for ML-MMOH-SCF-3045 start
				for(int i = 1; i <= pageval; i++){
					if(i == 1){
						a_codes = map.get("a_clinic_id"+i); 
						c_codes = map.get("c_clinic_id"+i);  
					}else{
						a_codes = a_codes+","+map.get("a_clinic_id"+i); 
						c_codes = c_codes+","+map.get("c_clinic_id"+i); 
					}
				}
			}
			String a_codes_arr [] = a_codes.split(",");
			if(!c_codes.equals("")){ // Modified for ML-MMOH-SCF-3045
			String c_codes_arr [] = c_codes.split(",");
			
			for(int i = 0; i < c_codes_arr.length; i++){
				tabdata.put(("select_yn"+insertCount),c_codes_arr[i]); // Modified for ML-MMOH-SCF-3045
				insertCount++; // Modified for ML-MMOH-SCF-3045
			}
			}
			for(int i = 0; i < a_codes_arr.length; i++){
				if(i==0){
					a_codes = "'"+a_codes_arr[i]+"'";
				}else{
					a_codes =a_codes + ",'"+a_codes_arr[i]+"'";
				}
			}
			
			tabdata.put("total_count", ""+insertCount); // Modified for ML-MMOH-SCF-3045
			
			tabdata.put("delete_id",a_codes);			
			
			if ((getServletConfig().getServletContext().getInitParameter(
					"LOCAL_EJBS") != null)
					&& (getServletConfig().getServletContext()
							.getInitParameter("LOCAL_EJBS")
							.equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(
					"java:comp/env/OPPractitionerClinic",
					PractitionerClinicManagerHome.class, local_ejbs);
			Object busObj = (home.getClass().getMethod("create", null)).invoke(
					home, null);

			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabdata;

			Class[] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();

			java.util.HashMap results = (java.util.HashMap) (busObj.getClass()
					.getMethod("insertClinic", paramArray)).invoke(busObj,
					argArray);
			(busObj.getClass().getMethod("remove", null)).invoke(busObj, null);
			boolean inserted = (((Boolean) results.get("status"))
					.booleanValue());
			String error = (String) results.get("error");
			String error_value = "0";

			if (inserted) {
				if(isOnApply.equals("Y")){
					out.println("<script>parent.frames[1].frames[1].res_locn_by_pract_result.reloadNextPage();</script>");					
				}else{
					error_value = "1";
					res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
							+ java.net.URLEncoder.encode(error,"UTF-8") + "&err_value="
							+ error_value);
				}
			} else {
				error = (String) results.get("error");
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
						+ java.net.URLEncoder.encode(error,"UTF-8"));
			}

			results.clear();
			tabdata.clear();
			argArray = null;
			paramArray = null;
			session.removeAttribute("ResForLocnByPract");
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	private void modifyClinic(HttpServletRequest req, HttpServletResponse res) {
		try {

			HashMap tabdata = new HashMap();
			callfunc = req.getParameter("call_function");
			tabdata.put("callfunction", callfunc);
			if (callfunc.equals("Pract_for_clinic")) {
				tabdata.put("clinic", checkNull(req.getParameter("clinic")));
				tabdata.put("practitioner", checkNull(req
						.getParameter("practitioner")));

			} else if (callfunc.equals("Resource_unit")) {
				tabdata.put("unittype",
						checkNull(req.getParameter("unit_type")));
				tabdata.put("resunit", checkNull(req.getParameter("res_unit")));
				tabdata.put("resclass",
						checkNull(req.getParameter("res_class")));
				tabdata.put("restype", checkNull(req.getParameter("res_type")));
				tabdata.put("resname", checkNull(req.getParameter("res_id")));
			}

			tabdata.put("effstatus", checkNullWithDftValue(req
					.getParameter("active"), "D"));

			for (int i = 1; i <= 7; i++) {
				working_week_Appl_day[i - 1] = (req
						.getParameter("pract_week_appl_day_" + i) == null) ? ""
						: req.getParameter("pract_week_appl_day_" + i);

				tabdata.put("working_week_appl_day_" + i,
						working_week_Appl_day[i - 1]);
			}

			for (int i = 1; i <= 7; i++) {
				working_week_1_day[i - 1] = (req
						.getParameter("pract_working_week_1_day_" + i + "1") == null) ? "H"
						: req.getParameter("pract_working_week_1_day_" + i
								+ "1");

				tabdata.put("working_week_1_day_" + i,
						working_week_1_day[i - 1]);

			}
			for (int i = 1; i <= 7; i++) {
				working_week_2_day[i - 1] = (req
						.getParameter("pract_working_week_2_day_" + i + "1") == null) ? "H"
						: req.getParameter("pract_working_week_2_day_" + i
								+ "1");

				tabdata.put("working_week_2_day_" + i,
						working_week_2_day[i - 1]);
			}
			for (int i = 1; i <= 7; i++) {
				working_week_3_day[i - 1] = (req
						.getParameter("pract_working_week_3_day_" + i + "1") == null) ? "H"
						: req.getParameter("pract_working_week_3_day_" + i
								+ "1");

				tabdata.put("working_week_3_day_" + i,
						working_week_3_day[i - 1]);
			}
			for (int i = 1; i <= 7; i++) {
				working_week_4_day[i - 1] = (req
						.getParameter("pract_working_week_4_day_" + i + "1") == null) ? "H"
						: req.getParameter("pract_working_week_4_day_" + i
								+ "1");

				tabdata.put("working_week_4_day_" + i,
						working_week_4_day[i - 1]);
			}
			for (int i = 1; i <= 7; i++) {
				working_week_5_day[i - 1] = (req
						.getParameter("pract_working_week_5_day_" + i + "1") == null) ? "H"
						: req.getParameter("pract_working_week_5_day_" + i
								+ "1");

				tabdata.put("working_week_5_day_" + i,
						working_week_5_day[i - 1]);
			}

			for (int i = 1; i <= 7; i++) {
				if ((working_week_1_day[i - 1].equals("N") || working_week_1_day[i - 1]
						.equals("H"))
						&& (working_week_2_day[i - 1].equals("N") || working_week_2_day[i - 1]
								.equals("H"))
						&& (working_week_3_day[i - 1].equals("N") || working_week_3_day[i - 1]
								.equals("H"))
						&& (working_week_4_day[i - 1].equals("N") || working_week_4_day[i - 1]
								.equals("H"))
						&& (working_week_5_day[i - 1].equals("N") || working_week_5_day[i - 1]
								.equals("H"))) {
					working_day[i - 1] = "N";
				} else {
					working_day[i - 1] = "Y";
				}
				tabdata.put("working_day_" + i, working_day[i - 1]);
			}

			tabdata.put("emergency", checkNullWithDftValue(req
					.getParameter("emergency1"), "N"));
			tabdata.put("first", checkNullWithDftValue(req
					.getParameter("first1"), "N"));
			tabdata.put("follow", checkNullWithDftValue(req
					.getParameter("follow1"), "N"));
			tabdata.put("routine", checkNullWithDftValue(req
					.getParameter("routine1"), "N"));
			tabdata.put("series", checkNullWithDftValue(req
					.getParameter("series1"), "N"));
			tabdata.put("consult", checkNullWithDftValue(req
					.getParameter("consult1"), "N"));

			tabdata.put("modifiedFacilityId", facilityId);
			tabdata.put("modifiedAtWorkstation", client_ip_address);
			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter(
					"LOCAL_EJBS") != null)
					&& (getServletConfig().getServletContext()
							.getInitParameter("LOCAL_EJBS")
							.equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(
					"java:comp/env/OPPractitionerClinic",
					PractitionerClinicManagerHome.class, local_ejbs);
			Object busObj = (home.getClass().getMethod("create", null)).invoke(
					home, null);

			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabdata;

			Class[] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();

			java.util.HashMap results = (java.util.HashMap) (busObj.getClass()
					.getMethod("updateClinic", paramArray)).invoke(busObj,
					argArray);

			(busObj.getClass().getMethod("remove", null)).invoke(busObj, null);
			boolean inserted = (((Boolean) results.get("status"))
					.booleanValue());
			String error = (String) results.get("error");
			String error_value = "0";
			if (inserted)
				error_value = "1";
			res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
					+ java.net.URLEncoder.encode(error,"UTF-8") + "&err_value="
					+ error_value);

			results.clear();
			argArray = null;
			paramArray = null;
			tabdata.clear();

		} catch (Exception e) {
			//out.println("<h3> Exception raise by Servlet ...So Record Not Modified </h3> Foll: Error Received : "+ e.toString());
			e.printStackTrace();
		}
	}

	private void insertClinic(HttpServletRequest req, HttpServletResponse res) {
		try {

			HashMap tabdata = new HashMap();
			callfunc = req.getParameter("call_function");
			tabdata.put("callfunction", callfunc);

			if (callfunc.equals("Pract_for_clinic")) {
				tabdata.put("clinic", checkNull(req.getParameter("clinic")));
				tabdata.put("practitioner", checkNull(req
						.getParameter("practitioner")));

			} else if (callfunc.equals("Resource_unit")) {

				tabdata.put("unittype",
						checkNull(req.getParameter("unit_type")));
				tabdata.put("resunit", checkNull(req.getParameter("res_unit")));
				tabdata.put("resclass",
						checkNull(req.getParameter("res_class")));
				tabdata.put("restype", checkNull(req.getParameter("res_type")));
				tabdata.put("resname", checkNull(req.getParameter("res_id")));

			}

			tabdata.put("effstatus", checkNullWithDftValue(req
					.getParameter("active"), "D"));

			for (int i = 1; i <= 7; i++) {
				working_week_Appl_day[i - 1] = (req
						.getParameter("pract_week_appl_day_" + i) == null) ? ""
						: req.getParameter("pract_week_appl_day_" + i);

				tabdata.put("WORKING_WEEK_APPL_DAY_" + i,
						working_week_Appl_day[i - 1]);
			}

			for (int i = 1; i <= 7; i++) {
				working_week_1_day[i - 1] = (req
						.getParameter("pract_working_week_1_day_" + i + "1") == null) ? "H"
						: req.getParameter("pract_working_week_1_day_" + i
								+ "1");

				tabdata.put("WORKING_WEEK_1_DAY_" + i,
						working_week_1_day[i - 1]);
			}
			for (int i = 1; i <= 7; i++) {
				working_week_2_day[i - 1] = (req
						.getParameter("pract_working_week_2_day_" + i + "1") == null) ? "H"
						: req.getParameter("pract_working_week_2_day_" + i
								+ "1");

				tabdata.put("WORKING_WEEK_2_DAY_" + i,
						working_week_2_day[i - 1]);
			}
			for (int i = 1; i <= 7; i++) {
				working_week_3_day[i - 1] = (req
						.getParameter("pract_working_week_3_day_" + i + "1") == null) ? "H"
						: req.getParameter("pract_working_week_3_day_" + i
								+ "1");

				tabdata.put("WORKING_WEEK_3_DAY_" + i,
						working_week_3_day[i - 1]);
			}

			for (int i = 1; i <= 7; i++) {
				working_week_4_day[i - 1] = (req
						.getParameter("pract_working_week_4_day_" + i + "1") == null) ? "H"
						: req.getParameter("pract_working_week_4_day_" + i
								+ "1");

				tabdata.put("WORKING_WEEK_4_DAY_" + i,
						working_week_4_day[i - 1]);
			}
			for (int i = 1; i <= 7; i++) {
				working_week_5_day[i - 1] = (req
						.getParameter("pract_working_week_5_day_" + i + "1") == null) ? "H"
						: req.getParameter("pract_working_week_5_day_" + i
								+ "1");

				tabdata.put("WORKING_WEEK_5_DAY_" + i,
						working_week_5_day[i - 1]);
			}

			for (int i = 1; i <= 7; i++) {

				if ((working_week_1_day[i - 1].equals("N") || working_week_1_day[i - 1]
						.equals("H"))
						&& (working_week_2_day[i - 1].equals("N") || working_week_2_day[i - 1]
								.equals("H"))
						&& (working_week_3_day[i - 1].equals("N") || working_week_3_day[i - 1]
								.equals("H"))
						&& (working_week_4_day[i - 1].equals("N") || working_week_4_day[i - 1]
								.equals("H"))
						&& (working_week_5_day[i - 1].equals("N") || working_week_5_day[i - 1]
								.equals("H"))) {
					working_day[i - 1] = "N";
				} else {
					working_day[i - 1] = "Y";
				}

				tabdata.put("working_day_" + i, working_day[i - 1]);
			}

			tabdata.put("emergency", checkNullWithDftValue(req
					.getParameter("emergency1"), "N"));
			tabdata.put("first", checkNullWithDftValue(req
					.getParameter("first1"), "N"));
			tabdata.put("follow", checkNullWithDftValue(req
					.getParameter("follow1"), "N"));
			tabdata.put("routine", checkNullWithDftValue(req
					.getParameter("routine1"), "N"));
			tabdata.put("series", checkNullWithDftValue(req
					.getParameter("series1"), "N"));
			tabdata.put("consult", checkNullWithDftValue(req
					.getParameter("consult1"), "N"));

			tabdata.put("addedFacilityId", facilityId);
			tabdata.put("addedAtWorkstation", client_ip_address);
			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter(
					"LOCAL_EJBS") != null)
					&& (getServletConfig().getServletContext()
							.getInitParameter("LOCAL_EJBS")
							.equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(
					"java:comp/env/OPPractitionerClinic",
					PractitionerClinicManagerHome.class, local_ejbs);
			Object busObj = (home.getClass().getMethod("create", null)).invoke(
					home, null);

			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabdata;

			Class[] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();

			java.util.HashMap results = (java.util.HashMap) (busObj.getClass()
					.getMethod("insertClinic", paramArray)).invoke(busObj,
					argArray);
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
				error = (String) results.get("error");
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
						+ java.net.URLEncoder.encode(error,"UTF-8"));
			}

			results.clear();
			tabdata.clear();
			argArray = null;
			paramArray = null;

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static String checkNull(String str) {
		return ((str == null || str.equals("null")) ? "" : str);
	}

	public static String checkNullWithDftValue(String str, String dftval) {
		return ((str == null || str.equals("null")) ? dftval : str);
	}
}
