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
import eOP.ConsPatArrival.*;
import eCommon.XSSRequestWrapper;

public class ConsPatArrivalServlet extends javax.servlet.http.HttpServlet {

	PrintWriter out;

	java.util.Properties p;

	String p_encntr_id;

	String facilityId;

	String client_ip_address;

	String room_num = "";

	String room_change = "";

	HttpSession session;

	Connection conn;

	String other_res_type = "";

	String other_res_code = "";

	String queue_num = "";

	String appt_walk_in = "";

	String queue_id = "";

	String locale = "";

	String assign_q_num_by = "";

	String revert_to_check_in = "";
	String qms_interfaced_yn = "N";
	String addedById = "";
	

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req,	HttpServletResponse res) 
		throws javax.servlet.ServletException,IOException {

		req= new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue("jdbc");
		this.facilityId = (String) session.getValue("facility_id");
		this.conn = ConnectionManager.getConnection(req);
		this.client_ip_address = p.getProperty("client_ip_address");
		locale = p.getProperty("LOCALE");
		addedById = p.getProperty("login_user");
		out = res.getWriter();

		try {
			// code changed by Vedesh A D for Edge Conversion
		    out.println("<!DOCTYPE html><head><link rel='stylesheet' type='text/css' href='../eCommon/html/IeStyle.css'></link>");
		    out.println("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='JavaScript'>");
		    out.println("async function callConsPatArrivalHTML() {");
		    
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			modifyPatArrival(req, res);
			
			out.println("}  callConsPatArrivalHTML();</script></body></html>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				ConnectionManager.returnConnection(conn, req);
		}
	}

	private void modifyPatArrival(HttpServletRequest req,HttpServletResponse res) {

		try {
			String session_id = "";
			String customer_id="";
			if (session != null)	{
				session_id=session.getId();
			}
			p_encntr_id = checkNull(req.getParameter("encntrid"));
			room_num = req.getParameter("room_num");
			room_change = checkNull(req.getParameter("room_change"));
			if (room_num == null || room_num.equals("null")
					|| room_num.equals("NoRoom"))
				room_num = "";
			String addedFacilityId = facilityId;
			String addedAtWorkstation = client_ip_address;
			other_res_type = req.getParameter("other_res_type");
			if (other_res_type == null)
				other_res_type = "";
			other_res_code = req.getParameter("other_res_code");
			if (other_res_code == null)
				other_res_code = "";
			queue_num = req.getParameter("queue_num");
			if (queue_num == null || queue_num.equals(""))
				queue_num = "0";
			appt_walk_in = req.getParameter("appt_walk_in");
			if (appt_walk_in == null)
				appt_walk_in = "";
			queue_id = req.getParameter("queue_id");
			if (queue_id == null)
				queue_id = "";
			
			assign_q_num_by = checkNullWithDftValue(req.getParameter("assign_q_num_by"), "S");

			revert_to_check_in = checkNullWithDftValue(req.getParameter("revert_to_check_in"), "N");			
			qms_interfaced_yn = checkNullWithDftValue(req.getParameter("qms_interfaced_yn"), "N");			

			HashMap tabdata = new HashMap();

			tabdata.put("sessionID", session_id);
			
			customer_id=(String)session.getAttribute("CUSTOMER_ID");

			tabdata.put("customerID", customer_id);
			tabdata.put("addedFacilityId", addedFacilityId);
			tabdata.put("p_queue_status", checkNull(req
					.getParameter("queuestatus")));
			tabdata.put("encntr_id", p_encntr_id);
			tabdata.put("p_patient_id",
					checkNull(req.getParameter("patientid")));
			tabdata.put("p_queue_date", checkNull(req
					.getParameter("queue_date")));
			tabdata.put("p_locn_type", checkNull(req.getParameter("locntype")));
			tabdata.put("p_pract_id", checkNull(req.getParameter("practid")));
			tabdata.put("p_locn_code", checkNull(req
					.getParameter("clinic_code")));
			tabdata.put("p_arrive_dt", checkNull(req.getParameter("arrivedt")));
			tabdata.put("revert_to_check_in", revert_to_check_in);
			tabdata.put("room_num", room_num);
			tabdata.put("prev_room", checkNull(req.getParameter("prev_room")));
			tabdata.put("room_change", room_change);
			tabdata.put("addedFacilityId", addedFacilityId);
			tabdata.put("addedAtWorkstation", addedAtWorkstation);
			tabdata.put("VISIT_ADM_TYPE_IND", checkNull(req
					.getParameter("VISIT_ADM_TYPE_IND")));
			tabdata.put("appt_case_yn", checkNull(req
					.getParameter("appt_case_yn")));
			tabdata.put("appt_id", checkNull(req.getParameter("appt_id")));
			/*Below line added for this CRF Bru-HIMS-CRF-133*/
			tabdata.put("curr_locntype", checkNull(req.getParameter("curr_locntype")));
			tabdata.put("curr_locncode", checkNull(req.getParameter("curr_locncode")));
			tabdata.put("isPatientEncMovement", checkNull(req.getParameter("isPatientEncMovement")));
			tabdata.put("Sydate", checkNull(req.getParameter("Sydate")));			
			//End Bru-HIMS-CRF-133

			tabdata.put("other_res_type", other_res_type);
			tabdata.put("other_res_code", other_res_code);
			tabdata.put("appt_walk_in", appt_walk_in);
			tabdata.put("queue_num", queue_num);
			tabdata.put("queue_id", queue_id);
			if(qms_interfaced_yn.equals("Y")){
				assign_q_num_by="M";
			}
			tabdata.put("assign_q_num_by", assign_q_num_by);
			tabdata.put("qms_interfaced_yn", qms_interfaced_yn);
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter(
					"LOCAL_EJBS") != null)
					&& (getServletConfig().getServletContext()
							.getInitParameter("LOCAL_EJBS")
							.equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance()
					.getHome("java:comp/env/ConsPatArrivalManager",
							ConsPatArrivalHome.class, local_ejbs);
			Object busObj = (home.getClass().getMethod("create", null)).invoke(
					home, null);

			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabdata;

			Class[] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();

			java.util.HashMap results = (java.util.HashMap) (busObj.getClass()
					.getMethod("updateConsPatArrival", paramArray)).invoke(
					busObj, argArray);

			(busObj.getClass().getMethod("remove", null)).invoke(busObj, null);

			boolean inserted = (((Boolean) results.get("status"))
					.booleanValue());
			String error = (String) results.get("error");
			//String error_value = "0";

			if (inserted) {

				MessageManager mm = new MessageManager();
				final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_MODIFIED", "SM");
				String msg1 = (String) mesg.get("message");
				out.println("alert('" + msg1 + "');");

				if( !(room_change.equals("")) || (assign_q_num_by.equals("M") && revert_to_check_in.equals("N")) )
				{
					doOnlineReports(req, p_encntr_id, facilityId,locale);					
				}
				//out.println("<script>top.close();</script>");
				out.println("parent.parent.window[2].window[1].window[2].location.reload(); parent.parent.document.getElementById('dialog_tag').close();");
				
			} else {
				if(qms_interfaced_yn.equals("Y")){
					System.err.println("ConsPatArrival rolled back - 206 - cancelQMSQueueNum called");
					cancelQMSQueueNum(queue_num,(String)session.getAttribute("CUSTOMER_ID"),addedById,client_ip_address,facilityId,(String)session.getId(),checkNull(req.getParameter("patientid")),checkNull(req.getParameter("encntrid")),conn);
				}
				//out.println("<html><script>alert(\"" + error + "\")</script>");
				//out.println("<script>top.close();</script></html>");
				out.println("alert(\"" + error + "\");");
				out.println("parent.parent.window[2].window[1].window[2].location.reload(); parent.parent.document.getElementById('dialog_tag').close();");
			}

			argArray = null;
			paramArray = null;
			results.clear();
			tabdata.clear();
		} catch (Exception e) {
			if(qms_interfaced_yn.equals("Y")){
					System.err.println("ConsPatArrival rolled back - 219 - cancelQMSQueueNum called");
					cancelQMSQueueNum(queue_num,(String)session.getAttribute("CUSTOMER_ID"),addedById,client_ip_address,facilityId,(String)session.getId(),checkNull(req.getParameter("patientid")),checkNull(req.getParameter("encntrid")),conn);
				}
			out.println("Exception Raised : " + e);
			e.printStackTrace();
		}

	}

	private void doOnlineReports(HttpServletRequest req, String encounter_id,
			String facility_id,String locale) throws ServletException, IOException,
			SQLException {
		StringBuffer htmlFor = new StringBuffer();
		htmlFor.setLength(0);

		String p_locn_code = checkNull(req.getParameter("clinic_code"));
		String p_locn_type = checkNull(req.getParameter("locntype"));

		String reportParamNames		= "p_encounter_id,p_facility_id";
		String reportParamValues	= "" + encounter_id + "," + facility_id + "";
		String p_patient_id			= checkNull(req.getParameter("patientid"));
		String visit_adm_type		= checkNull(req.getParameter("VISIT_ADM_TYPE_IND"));
		
		String sqlString = " select distinct report_id, sm_get_desc.SM_REPORT(MODULE_ID,report_id,'"+locale+"','1')report_desc, 1 no_of_copies, module_id from op_online_report where OPERATING_FACILITY_ID='"
						+ facility_id
						+ "' and PRINT_AT_CI_YN='Y' and (clinic_code='"
						+ p_locn_code
						+ "' or clinic_code ='*All') and (VISIT_TYPE_CODE='"
						+ visit_adm_type
						+ "' OR VISIT_TYPE_CODE='*A') ";/*Query has been modified by Rameswar on 03-Nov-15 for HSA-CRF-0319*/

		

		/*htmlFor
				.append(" <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link>");
		htmlFor.append("</head><body class='message'>");
		htmlFor.append("<script language = 'JavaScript'>");*/
		htmlFor.append("  var dialogHeight    = '60vh' ;");
		htmlFor.append(" var dialogWidth = '80vw' ;");
		htmlFor.append("var dialogTop = '65';");
		htmlFor.append("  var arguments =   ''; ");
		htmlFor
				.append("  var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?step=1&sqlString="
						+ java.net.URLEncoder.encode(sqlString,"UTF-8")
						+ "&EncounterId="
						+ encounter_id
						+ "&dest_locn_type="
						+ p_locn_type
						+ "&dest_locn_code="
						+ p_locn_code
						+ "&reportParamNames="
						+ reportParamNames
						+ "&reportParamValues="
						+ reportParamValues
						+ "&Patient_ID=" + p_patient_id + "';");

		htmlFor
				.append(" var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;");

		htmlFor
				.append("  retVal            =  await window.showModalDialog(getUrl,arguments,features); ");
		//htmlFor.append(" </script>");
		out.println(htmlFor.toString());
		htmlFor.setLength(0);
	}

	public static String checkNull(String str) {
		return ((str == null || str.equals("null")) ? "" : str);
	}

	public static String checkNullWithDftValue(String str, String dftval) {
		return ((str == null || str.equals("null")) ? dftval : str);
	}

	public static void cancelQMSQueueNum(String queue_num, String siteID,String addedById,String modifiedAtWorkstation,String modifiedFacilityId, String sessionId,String patient_id,String encounterId1,Connection con){
		try{
			java.util.HashMap audit_params=new java.util.HashMap();
			audit_params.put("siteID",siteID);
			audit_params.put("loggedUser",addedById);
			audit_params.put("clientMachine",modifiedAtWorkstation);
			audit_params.put("facilityID",modifiedFacilityId);
			audit_params.put("sessionID",sessionId);
			audit_params.put("patientID",patient_id);
			audit_params.put("encounterID",encounterId1);
			if(!queue_num.equals("0")){
				System.out.println("In QMS - Before sending param to QMSInterface cancelTicket : "+audit_params.toString());
				eOP.QMSInterface.cancelQueueNumber(queue_num,audit_params,con);
			}
		}catch(Exception ex){
			System.out.println("Error during call to QMS");
			ex.printStackTrace();
		}
	}

}
