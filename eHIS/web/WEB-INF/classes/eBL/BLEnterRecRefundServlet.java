/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.net.*;
import webbeans.eCommon.*;
import eBL.*;
import com.ehis.persist.*;
import eCommon.Common.*;
//Added by muthu on 25-7-12 against 33868 - Receipt Print Starts Here
import ecis.utils.OnlineReport;
import ecis.utils.OnlineReports;
import webbeans.op.CurrencyFormat;
//Added by muthu on 25-7-12 against 33868 - Receipt Print Ends Here
import java.lang.*;
import eIP.*;

public class BLEnterRecRefundServlet extends javax.servlet.http.HttpServlet {

	PrintWriter out;

	java.util.Properties p;

	HttpSession session;

	Connection con;

	PreparedStatement pstmt;

	ResultSet rs;

	HashMap support_data = new HashMap();
	// HashMap sel_serv_panel_data = new HashMap();
	HashMap mult_slmt_vals = new HashMap();
	Hashtable messageHashtable = new Hashtable();
	String msg = "";

	StringBuffer sb = new StringBuffer();

	String facility_id, client_ip_address, user_id;

	String locale;

	String sStyle = "";
	CallableStatement call = null;

	String patient_id = "", visit_id = "", episode_id = "", episode_type = "",
			encounter_id = "";
	String rcpt_rfnd_ind = "", rcpt_nature_code = "", cash_counter_code = "",
			shift_id = "", doc_amt = "", narration = "",
			ip_adm_trf_dep_ind = "", rec_ref_format_ind = "",
			rfnd_dep_in_use_yn = "", pmnt_thru_mail = "",
			ext_acc_facility_id = "", ext_acc_code = "",
			ext_acc_dept_code = "", mult_slmt_yn = "", downtime_entry_yn = "",
			downtime_reason_code = "", downtime_doc_type_code = "",
			downtime_doc_num = "", downtime_doc_date = "", cc_machine_id = "",
			payers_add1 = "", payers_add2 = "", payers_add3 = "",
			payers_tel_num = "", consolidated_receipt_yn = "",
			rcpt_type_code = "", currdate = "";
	String str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd = "N",
			hand_without_counter_chk_out = "N";
	String pkgSeqNo = "";
	// Added the variables for MMS SCF 501.1
	String pkgSequenceNumber = "";
	String pkgSequenceAmount = "";
	// Added by muthu on 25-7-12 against 33868 - Receipt Print
	String rec_print_format_enabled_yn = "";
	String str_rec_prt_format_vals = "";
	String pgm_id = "";
	String session_id = "";
	String pgm_date = "";
	String strerrortext = "";
	// Added by muthu on 25-7-12 against 33868 - Receipt Print

	String str_tot_rec = "";
	int doc_sr_no = 1;
	String str_doc_sr_no = "0", rtn_str_doc_sr_no = "";

	int totalRecords = 0;
	String deposit="";

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req,
			HttpServletResponse res) throws javax.servlet.ServletException,
			IOException {
		session = req.getSession(false);
		this.p = (java.util.Properties) session.getValue("jdbc");

		this.facility_id = (String) session.getValue("facility_id");
		if (facility_id == null)
			facility_id = "";

		user_id = (String) session.getValue("login_user");
		if (user_id == null)
			user_id = "";

		client_ip_address = p.getProperty("client_ip_address");
		if (client_ip_address == null)
			client_ip_address = "";

		sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
				|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
				.getAttribute("PREFERRED_STYLE") : "IeStyle.css";

		// String attributes[] = session.getValueNames();
		locale = p.getProperty("LOCALE");
		str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd = req
				.getParameter("str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd");
		if (str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd == null)
			str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd = "";

		hand_without_counter_chk_out = req
				.getParameter("hand_without_counter_chk_out");
		if (hand_without_counter_chk_out == null)
			hand_without_counter_chk_out = "";
		try {
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			insertServiceRequest(req, res);

		} catch (Exception e) {
			System.out.println("Exception in doPost=" + e.toString());
			e.printStackTrace();
			out.println(e.toString());
		}
		/*
		 * finally { if (con != null) ConnectionManager.returnConnection(con,
		 * req); }
		 */
	}

	private void insertServiceRequest(HttpServletRequest req,
			HttpServletResponse res) throws SQLException {
		try {
			// if (con == null) con = ConnectionManager.getConnection(req);
			// con.setAutoCommit(false);

			java.util.Locale loc = new java.util.Locale(locale);
			java.util.ResourceBundle bl_labels = java.util.ResourceBundle
					.getBundle("eBL.resources.Labels", loc);
			String gen_receipt = (String) bl_labels
					.getString("eBL.DOC_GEN.label");
			// System.out.println("Main 1");
			getData(req);
			// System.out.println("Main 2");
			InsertSupportdata();
			// System.out.println("Main 3");

			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter(
					"LOCAL_EJBS") != null)
					&& (getServletConfig().getServletContext()
							.getInitParameter("LOCAL_EJBS")
							.equalsIgnoreCase("TRUE")))
				local_ejbs = true;
			// System.out.println("ejb call 1");

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(
					"java:comp/env/EnterReceiptRefund",
					eBL.EnterReceiptRefund.EnterReceiptRefundHome.class,
					local_ejbs);
			// System.out.println("ejb call 2");

			Object busObj = (home.getClass().getMethod("create", null)).invoke(
					home, null);
			// System.out.println("ejb call 3");

			Object argArray[] = new Object[3];

			// System.out.println("ejb call 4");

			argArray[0] = p;
			argArray[1] = support_data;
			argArray[2] = mult_slmt_vals;

			// System.out.println("ejb call 5");
			Class[] paramArray = new Class[3];

			paramArray[0] = p.getClass();
			paramArray[1] = support_data.getClass();
			paramArray[2] = mult_slmt_vals.getClass();
			// System.out.println("ejb call 6");

			java.util.HashMap results = (java.util.HashMap) (busObj.getClass()
					.getMethod("insert", paramArray)).invoke(busObj, argArray);

			(busObj.getClass().getMethod("remove", null)).invoke(busObj, null);

			boolean inserted = (((Boolean) results.get("status"))
					.booleanValue());

			String error = (String) results.get("error");

			String message = (String) results.get("message");

			String message1 = (String) results.get("message1");

			String gen_doc_type = (String) results.get("gen_doc_type");
			String gen_doc_num = (String) results.get("gen_doc_num");

			String sys_error = (String) results.get("sys_error");
			String final_msg_doc_type_code = (String) results
					.get("final_msg_doc_type_code");
			// Added by muthu on 25-7-12 against 33868 - Receipt Print
			String gen_prt_format = (String) results.get("gen_prt_format");
			System.out.println("gen_prt_format in Servlet ==> "
					+ gen_prt_format);

			str_rec_prt_format_vals = (String) results
					.get("str_rec_prt_format_vals");
			System.out.println("str_rec_prt_format_vals in Servlet ==> "
					+ str_rec_prt_format_vals);

			rec_print_format_enabled_yn = (String) results
					.get("rec_print_format_enabled_yn");
			System.out.println("rec_print_format_enabled_yn in Servlet ==> "
					+ rec_print_format_enabled_yn);
			// Added by muthu on 25-7-12 against 33868 - Receipt Print

			// System.out.println("inserted:"+inserted);
			// System.out.println("error:"+error);
			// System.out.println("sys_error:"+sys_error);
			// System.out.println("message:"+message);
			// System.out.println("gen_doc_type:"+gen_doc_type);
			// System.out.println("gen_doc_num:"+gen_doc_num);
			// System.out.println("final_msg_doc_type_code:"+final_msg_doc_type_code);

			if (inserted) {
				out.println("<script>parent.frames[4].document.forms[0].doc_type_code.value='"
						+ gen_doc_type + "';</script>");
				out.println("<script>parent.frames[4].document.forms[0].doc_type_no.value='"
						+ gen_doc_num + "';</script>");
				out.println("<script>parent.frames[4].document.forms[0].doc_date.value='"
						+ currdate + "';</script>");
				out.println("<script>parent.frames[4].document.forms[0].cash_ctr.value='"
						+ cash_counter_code + "';</script>");
				out.println("<script>parent.frames[4].document.forms[0].shift.value='"
						+ shift_id + "';</script>");

				if (!message1.equals("")) {
					messageHashtable = MessageManager.getMessage(locale,
							message1, "BL");
					msg = (String) messageHashtable.get("message");

					if (message1.equals("BL7340")) {
						out.println("<script>alert('" + msg + "')</script>");
					}
				}				
				
				//Added By Santhosh for PMG2023-MOHE-CRF-0001
				try {
					con = ConnectionManager.getConnection(req);
					boolean isDepositAmountAppl = false;
					isDepositAmountAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"IP","GET_DEPOSIT_AMOUNT");
					if(isDepositAmountAppl){
						deposit = eIP.IPCommonBean.getDepositAmt(con,facility_id,episode_type,Integer.parseInt(encounter_id));
						session.setAttribute("deposit_err",deposit);
					}
				} catch(Exception e) {
					e.printStackTrace();
					System.err.println("Exception on eIP.IPCommonBean.getDepositAmt=============="+e.toString());
				} finally {
					if(con != null)  ConnectionManager.returnConnection(con,req);
				}
				//End

				// out.println("<script>var msg=getMessage('BL9323','BL')</script>");
				String final_message = gen_receipt + " "
						+ final_msg_doc_type_code;
				// String
				// final_mssage=gen_receipt+" "+gen_doc_type+"/"+gen_doc_num;
				out.println("<script>alert('" + final_message + "')</script>");

				// out.println("<script>window.close();</script>");
				//out.println("<script>window.parent.returnValue='Y';window.close();</script>");
				out.println("<script>parent.parent.document.getElementById('dialog-body').contentWindow.returnValue = 'Y';parent.parent.document.getElementById('dialog_tag').close();</script>");
				// con.commit();

				// Added by muthu on 25-7-12 against 33868 - Receipt Print
				// Starts Here
				System.out.println("rec_print_format_enabled_yn  "
						+ rec_print_format_enabled_yn
						+ "str_rec_prt_format_vals " + str_rec_prt_format_vals);
				if (rec_print_format_enabled_yn.equals("Y")
						&& !str_rec_prt_format_vals.equals("")
						&& strerrortext.equals("")) {
					try {
						StringTokenizer st1 = new StringTokenizer(
								str_rec_prt_format_vals, "/");

						while (st1.hasMoreTokens()) {
							System.out.println("248 Entering "); // muthu
							pgm_id = st1.nextToken();
							System.out.println("248 pgm_id in Slmt:" + pgm_id);
							session_id = st1.nextToken();
							System.out.println("248 session_id in Slmt:"
									+ session_id);
							pgm_date = st1.nextToken();
							System.out.println("248 pgm_date in Slmt:"
									+ pgm_date);
						}
						System.out.println("248 locale in SlmtValidation "
								+ locale);
						OnlineReport onlinereportParam = null;
						if (locale.equals("ar")) {

							Connection conn=null;
							
							
							String reportId = "BLRECPRTAKAR";
							try {
								conn=ConnectionManager.getConnection();
								System.out.println("rep "+reportId);
								reportId = BLReportIdMapper.getReportIdForReceipt(conn,locale,reportId, facility_id); //Added facility_id by subha for MMS-DM-CRF-131.1
								System.out.println("BLEnterRecRefundServlet for Report ID" + reportId);
							/*	if(reportId.equals("BLRECPRT_ALMOAR"))
								{
									pgm_id="BLRECPRT_ALMOAR";
								}*/
								
								/*if ("BLRECPRT".equals(reportId)) {
									reportId = "BLRECPRTAKAR";
								}*/

							} catch (Exception e) {
								e.printStackTrace();
								// reportId="BLRECPRTAKAR";
								System.err
										.println("Exception in BLEnterRecRefundServlet for reportID "
												+ e);
							}
							finally{
								if(conn!=null)
								{
									try{
										conn.close();
									}
									catch(Exception e)
									{
										System.err.println("Exception in returning connection "+e);
									}
								}
							}
							System.out.println("Inside If condition 248");
							onlinereportParam = new OnlineReport(facility_id,
									"BL", reportId);
							System.out.println("Inside If condition 248 "
									+ onlinereportParam);
						} else {
							System.out.println("Else If condition 248 ");
							onlinereportParam = new OnlineReport(facility_id,
									"BL", "BLRECPRT");
							System.out.println("Else If condition  248 "
									+ onlinereportParam);
						}

						onlinereportParam.addParameter("p_facility_id",
								facility_id);
						System.out.println("facility_id in Slmt 248:"
								+ facility_id);

						onlinereportParam.addParameter("p_pgm_date", pgm_date);
						System.out.println("pgm_date in Slmt 248:" + pgm_date);

						onlinereportParam.addParameter("p_pgm_id", pgm_id);
						System.out.println("pgm_id in Slmt 248:" + pgm_id);

						onlinereportParam.addParameter("p_Session_id",
								session_id);
						System.out.println("session_id in Slmt 248:"
								+ session_id);

						System.out
								.println("Online Report onlinereportParam in Slmt 248:"
										+ onlinereportParam);
						OnlineReports onlinereports = new OnlineReports();
						onlinereports.add(onlinereportParam);
						System.out.println("Online Report Added in Slmt 248:"
								+ onlinereports);
						String strResults = onlinereports.execute(req, res);
						System.out
								.println("Online Report Executed in Slmt 248");
						System.out.println("strResults 248 :" + strResults);

						onlinereportParam = null;
						onlinereports = null;
					} catch (Exception e) {
						System.err
								.println("Error while submitting Print Job to Report Server Servlet:"
										+ e);
					}
				}
				// Added by muthu on 25-7-12 against 33868 - Receipt Print Ends
				// Here
			} else {
				if (!sys_error.equals("")) {

					out.println("<script>parent.frames[5].location.href='../eCommon/jsp/error.jsp?err_num="
							+ java.net.URLEncoder.encode(sys_error.toString(),
									"UTF-8") + "<br>'</script>");
				} else if (!message.equals("")) {

					messageHashtable = MessageManager.getMessage(locale,
							message, "BL");
					msg = (String) messageHashtable.get("message");

					if (message.equals("BL7340")) {
						out.println("<script>alert('" + msg + "')</script>");
					} else {
						out.println("<script>parent.frames[5].location.href='../eCommon/jsp/error.jsp?err_num="
								+ java.net.URLEncoder.encode(msg, "UTF-8")
								+ "<br>'</script>");
					}

					// out.println("<script>var sys_message_id=getMessage('<%=message%>','BL');parent.frames(5).location.href='../eCommon/jsp/error.jsp?err_num='+encodeURIComponent(sys_message_id)+' <br>'</script>");
				} else if (!error.equals("")) {
					out.println("<script>parent.frames[5].location.href='../eCommon/jsp/error.jsp?m="
							+ java.net.URLEncoder.encode(error, "UTF-8")
							+ "<br>'</script>");
				}
				// con.rollback();
			}
		} catch (Exception e) {
			// con.rollback();
			out.println("<script>parent.frames[5].location.href='../eCommon/jsp/error.jsp?err_num="
					+ e.toString() + "<br>'</script>");
			System.out.println("exception in main=" + e.toString());
			e.printStackTrace();
			// out.println("<h3> Exception raise by Servlet ...So Record Not inserted </h3> Foll: Error Received : "
			// + e.toString() + sb.toString()); commented by ram and added above
			// line error.jsp
			out.println("Values sent are : <br>");
		}
		/*
		 * finally { System.out.println("finally"); if (con != null)
		 * ConnectionManager.returnConnection(con, req); }
		 */

	}

	public void getData(HttpServletRequest req) {
		// System.out.println("getData 1");

		patient_id = req.getParameter("patient_id");
		if (patient_id == null)
			patient_id = "";

		visit_id = req.getParameter("visit_id");
		if (visit_id == null)
			visit_id = "";

		episode_id = req.getParameter("episode_id");
		if (episode_id == null)
			episode_id = "";

		episode_type = req.getParameter("episode_type");
		if (episode_type == null)
			episode_type = "";

		encounter_id = req.getParameter("encounter_id");
		if (encounter_id == null)
			encounter_id = "";

		rcpt_rfnd_ind = req.getParameter("rcpt_rfnd_ind");
		if (rcpt_rfnd_ind == null)
			rcpt_rfnd_ind = "";

		rcpt_nature_code = req.getParameter("rcpt_nature_code");
		if (rcpt_nature_code == null)
			rcpt_nature_code = "";

		cash_counter_code = req.getParameter("cash_counter_code");
		if (cash_counter_code == null)
			cash_counter_code = "";

		shift_id = req.getParameter("shift_id");
		if (shift_id == null)
			shift_id = "";

		doc_amt = req.getParameter("doc_amt");
		if (doc_amt == null)
			doc_amt = "";

		narration = req.getParameter("narration");
		if (narration == null)
			narration = "";

		ip_adm_trf_dep_ind = req.getParameter("ip_adm_trf_dep_ind");
		if (ip_adm_trf_dep_ind == null)
			ip_adm_trf_dep_ind = "";

		rec_ref_format_ind = req.getParameter("rec_ref_format_ind");
		if (rec_ref_format_ind == null)
			rec_ref_format_ind = "";

		rfnd_dep_in_use_yn = req.getParameter("rfnd_dep_in_use_yn");
		if (rfnd_dep_in_use_yn == null)
			rfnd_dep_in_use_yn = "";

		pmnt_thru_mail = req.getParameter("pmnt_thru_mail");
		if (pmnt_thru_mail == null)
			pmnt_thru_mail = "";

		ext_acc_facility_id = req.getParameter("ext_acc_facility_id");
		if (ext_acc_facility_id == null)
			ext_acc_facility_id = "";

		ext_acc_code = req.getParameter("ext_acc_code");
		if (ext_acc_code == null)
			ext_acc_code = "";

		ext_acc_dept_code = req.getParameter("ext_acc_dept_code");
		if (ext_acc_dept_code == null)
			ext_acc_dept_code = "";

		mult_slmt_yn = req.getParameter("mult_slmt_yn");
		if (mult_slmt_yn == null)
			mult_slmt_yn = "";

		downtime_entry_yn = req.getParameter("downtime_entry_yn");
		if (downtime_entry_yn == null)
			downtime_entry_yn = "";

		downtime_reason_code = req.getParameter("downtime_reason_code");
		if (downtime_reason_code == null)
			downtime_reason_code = "";

		downtime_doc_type_code = req.getParameter("downtime_doc_type_code");
		if (downtime_doc_type_code == null)
			downtime_doc_type_code = "";

		downtime_doc_num = req.getParameter("downtime_doc_num");
		if (downtime_doc_num == null)
			downtime_doc_num = "";

		downtime_doc_date = req.getParameter("downtime_doc_date");
		if (downtime_doc_date == null)
			downtime_doc_date = "";

		cc_machine_id = req.getParameter("cc_machine_id");
		if (cc_machine_id == null)
			cc_machine_id = "";

		payers_add1 = req.getParameter("payers_add1");
		if (payers_add1 == null)
			payers_add1 = "";

		payers_add2 = req.getParameter("payers_add2");
		if (payers_add2 == null)
			payers_add2 = "";

		payers_add3 = req.getParameter("payers_add3");
		if (payers_add3 == null)
			payers_add3 = "";

		payers_tel_num = req.getParameter("payers_tel_num");
		if (payers_tel_num == null)
			payers_tel_num = "";

		consolidated_receipt_yn = req.getParameter("consolidated_receipt_yn");
		if (consolidated_receipt_yn == null)
			consolidated_receipt_yn = "";

		rcpt_type_code = req.getParameter("rcpt_type_code");
		if (rcpt_type_code == null)
			rcpt_type_code = "";

		currdate = req.getParameter("currdate");
		if (currdate == null)
			currdate = "";
		/***************** added for packge biling ********************/
		pkgSeqNo = req.getParameter("pkgSeqNo");
		if (pkgSeqNo == null)
			pkgSeqNo = "";
		/****************************** END ****************************/
		pkgSequenceNumber = req.getParameter("pkgSequenceNumber");
		if (pkgSequenceNumber == null)
			pkgSequenceNumber = "";
		pkgSequenceAmount = req.getParameter("pkgSequenceAmount");
		if (pkgSequenceAmount == null)
			pkgSequenceAmount = "";
		// System.out.println("getData 4");
		str_tot_rec = req.getParameter("total_records");
		if (str_tot_rec == null)
			str_tot_rec = "0";
		totalRecords = Integer.parseInt(str_tot_rec);
		// System.out.println("totalRecords servlet" +totalRecords);

		GetStlmtDtlsVals(totalRecords, req);

	}

	public void InsertSupportdata() {
		support_data.clear();
		support_data.put("facility_id", facility_id);
		support_data.put("locale", locale);
		support_data.put("patient_id", patient_id);
		support_data.put("visit_id", visit_id);
		support_data.put("episode_id", episode_id);
		support_data.put("episode_type", episode_type);
		support_data.put("encounter_id", encounter_id);
		support_data.put("rcpt_rfnd_ind", rcpt_rfnd_ind);
		support_data.put("rcpt_nature_code", rcpt_nature_code);
		support_data.put("cash_counter_code", cash_counter_code);
		support_data.put("shift_id", shift_id);
		support_data.put("doc_amt", doc_amt);
		support_data.put("narration", narration);
		support_data.put("ip_adm_trf_dep_ind", ip_adm_trf_dep_ind);
		support_data.put("rec_ref_format_ind", rec_ref_format_ind);
		support_data.put("rfnd_dep_in_use_yn", rfnd_dep_in_use_yn);
		support_data.put("pmnt_thru_mail", pmnt_thru_mail);
		support_data.put("ext_acc_facility_id", ext_acc_facility_id);
		support_data.put("ext_acc_code", ext_acc_code);
		support_data.put("ext_acc_dept_code", ext_acc_dept_code);
		support_data.put("mult_slmt_yn", mult_slmt_yn);
		support_data.put("downtime_entry_yn", downtime_entry_yn);
		support_data.put("downtime_reason_code", downtime_reason_code);
		support_data.put("downtime_doc_type_code", downtime_doc_type_code);
		support_data.put("downtime_doc_num", downtime_doc_num);
		support_data.put("downtime_doc_date", downtime_doc_date);
		support_data.put("cc_machine_id", cc_machine_id);
		support_data.put("payers_add1", payers_add1);
		support_data.put("payers_add2", payers_add2);
		support_data.put("payers_add3", payers_add3);
		support_data.put("payers_tel_num", payers_tel_num);
		support_data.put("consolidated_receipt_yn", consolidated_receipt_yn);
		support_data.put("user_id", user_id);
		support_data.put("client_ip_address", client_ip_address);
		support_data.put("rcpt_type_code", rcpt_type_code);
		support_data.put("currdate", currdate);
		support_data.put("str_tot_rec", str_tot_rec);
		support_data.put("str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd",
				str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd);
		support_data.put("hand_without_counter_chk_out",
				hand_without_counter_chk_out);
		/********************* added pkgSeqNo IN TAB DATA for package billing ********************************************/
		support_data.put("pkgSeqNo", pkgSeqNo);
		support_data.put("pkgSequenceNumber", pkgSequenceNumber);
		support_data.put("pkgSequenceAmount", pkgSequenceAmount);
		// System.out.println("support_data kdfdklfksl;"+support_data);

	}

	public void GetStlmtDtlsVals(int totalRecords, HttpServletRequest req) {
		// HashMap hm = new HashMap();
		mult_slmt_vals.clear();
		// System.out.println("mult_slmt_vals 1"+mult_slmt_vals);
		int doc_sr_no = 1;

		if (str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd.equals("Y")) {
			String str_doc_sr_no = "0";
			ArrayList rtn_str_slmt_doc_amt = new ArrayList();
			ArrayList rtn_str_slmt_type_code = new ArrayList();
			ArrayList rtn_str_slmt_doc_ref_desc = new ArrayList();
			ArrayList rtn_str_slmt_doc_ref_date = new ArrayList();
			ArrayList rtn_str_slmt_doc_remarks = new ArrayList();
			ArrayList rtn_str_app_ref_no = new ArrayList();
			ArrayList rtn_str_cash_slmt_flag = new ArrayList();
			ArrayList rtn_str_cc_batch_no = new ArrayList();
			ArrayList rtn_str_cc_sale_draft_no = new ArrayList();
			ArrayList rtn_str_cc_swipped_yn = new ArrayList();
			ArrayList rtn_str_bank_code = new ArrayList();
			ArrayList rtn_str_bank_branch = new ArrayList();
			ArrayList rtn_str_cash_amt_given = new ArrayList();
			ArrayList rtn_str_cash_amt_return = new ArrayList();
			ArrayList rtn_str_payer_name = new ArrayList();
			ArrayList rtn_str_rcpt_rfnd_id_no = new ArrayList();
			ArrayList rtn_str_nominee_name = new ArrayList();
			ArrayList rtn_str_doc_sr_no = new ArrayList();

			for (int i = 0; i < totalRecords; i++) {

				String str_slmt_doc_amt = req.getParameter("billslmtamt" + i);
				if (str_slmt_doc_amt == null)
					str_slmt_doc_amt = "";

				rtn_str_slmt_doc_amt.add(str_slmt_doc_amt + "|");

				// System.out.println("rtn_str_slmt_doc_amt mult:"+rtn_str_slmt_doc_amt);

				String str_slmt_type_code = req.getParameter("slmttype" + i);
				if (str_slmt_type_code == null)
					str_slmt_type_code = "";
				String str_cash_slmt_flag = str_slmt_type_code;
				str_slmt_type_code = str_slmt_type_code.substring(0, 2);
				// System.out.println("str_slmt_type_code 11:"+str_slmt_type_code);

				// System.out.println("str_cash_slmt_flag 11:"+str_cash_slmt_flag);

				str_cash_slmt_flag = str_cash_slmt_flag.substring(2, 3);
				// System.out.println("str_cash_slmt_flag 12:"+str_cash_slmt_flag);

				rtn_str_slmt_type_code.add(str_slmt_type_code + "|");

				// System.out.println("rtn_str_slmt_type_code 12:"+rtn_str_slmt_type_code);

				// System.out.println("rtn_str_slmt_type_code 11:"+rtn_str_slmt_type_code);

				String str_slmt_doc_ref_desc = req.getParameter("instref" + i);
				if (str_slmt_doc_ref_desc == null)
					str_slmt_doc_ref_desc = "";

				rtn_str_slmt_doc_ref_desc.add(str_slmt_doc_ref_desc + "|");
				// System.out.println("rtn_str_slmt_doc_ref_desc mult:"+rtn_str_slmt_doc_ref_desc);

				String str_slmt_doc_ref_date = req.getParameter("instdate" + i);
				if (str_slmt_doc_ref_date == null)
					str_slmt_doc_ref_date = "";

				rtn_str_slmt_doc_ref_date.add(str_slmt_doc_ref_date + "|");

				// System.out.println("rtn_str_slmt_doc_ref_date mult:"+rtn_str_slmt_doc_ref_date);

				String str_slmt_doc_remarks = req
						.getParameter("str_slmt_doc_remarks" + i);
				if (str_slmt_doc_remarks == null)
					str_slmt_doc_remarks = "";

				rtn_str_slmt_doc_remarks.add(str_slmt_doc_remarks + "|");

				// System.out.println("rtn_str_slmt_doc_remarks mult:"+rtn_str_slmt_doc_remarks);

				String str_app_ref_no = req.getParameter("apprrefno" + i);
				if (str_app_ref_no == null)
					str_app_ref_no = "";

				rtn_str_app_ref_no.add(str_app_ref_no + "|");

				// System.out.println("rtn_str_app_ref_no mult:"+rtn_str_app_ref_no);

				/*
				 * String str_cash_slmt_flag =
				 * req.getParameter("str_cash_slmt_flag"+i);
				 * if(str_cash_slmt_flag == null) str_cash_slmt_flag="";
				 * str_cash_slmt_flag="A";
				 */

				rtn_str_cash_slmt_flag.add(str_cash_slmt_flag + "|");
				// System.out.println("rtn_str_cash_slmt_flag mult:"+rtn_str_cash_slmt_flag);

				String str_cc_batch_no = req.getParameter("batchno" + i);
				if (str_cc_batch_no == null)
					str_cc_batch_no = "";

				rtn_str_cc_batch_no.add(str_cc_batch_no + "|");

				// System.out.println("rtn_str_cc_batch_no mult:"+rtn_str_cc_batch_no);

				String str_cc_sale_draft_no = req.getParameter("saledraftno"
						+ i);
				if (str_cc_sale_draft_no == null)
					str_cc_sale_draft_no = "";

				rtn_str_cc_sale_draft_no.add(str_cc_sale_draft_no + "|");

				// System.out.println("rtn_str_cc_sale_draft_no mult:"+rtn_str_cc_sale_draft_no);

				String str_cc_swipped_yn = req.getParameter("str_cc_swipped_yn"
						+ i);
				if (str_cc_swipped_yn == null)
					str_cc_swipped_yn = "";

				rtn_str_cc_swipped_yn.add(str_cc_swipped_yn + "|");

				// System.out.println("rtn_str_cc_swipped_yn mult:"+rtn_str_cc_swipped_yn);

				String str_bank_code = req.getParameter("instremarkcode" + i);
				if (str_bank_code == null)
					str_bank_code = "";

				rtn_str_bank_code.add(str_bank_code + "|");

				// System.out.println("rtn_str_bank_code mult:"+rtn_str_bank_code);

				String str_bank_branch = req.getParameter("instbranch" + i);
				if (str_bank_branch == null)
					str_bank_branch = "";

				rtn_str_bank_branch.add(str_bank_branch + "|");
				// System.out.println("rtn_str_bank_branch mult:"+rtn_str_bank_branch);

				String str_cash_amt_given = req.getParameter("cash_given" + i);
				if (str_cash_amt_given == null)
					str_cash_amt_given = "";

				// System.out.println("str_cash_amt_given: "+str_cash_amt_given);

				rtn_str_cash_amt_given.add(str_cash_amt_given + "|");

				// System.out.println("rtn_str_cash_amt_given: "+rtn_str_cash_amt_given);

				String str_cash_amt_return = req
						.getParameter("cash_return" + i);
				if (str_cash_amt_return == null)
					str_cash_amt_return = "";

				rtn_str_cash_amt_return.add(str_cash_amt_return + "|");
				// System.out.println("rtn_str_cash_amt_return mult:"+rtn_str_cash_amt_return);

				String str_payer_name = req.getParameter("payername" + i);
				if (str_payer_name == null)
					str_payer_name = "";
				rtn_str_payer_name.add(str_payer_name + "|");

				// System.out.println("rtn_str_payer_name mult:"+rtn_str_payer_name);

				String str_rcpt_rfnd_id_no = req.getParameter("recrefidno" + i);
				if (str_rcpt_rfnd_id_no == null)
					str_rcpt_rfnd_id_no = "";

				rtn_str_rcpt_rfnd_id_no.add(str_rcpt_rfnd_id_no + "|");

				// System.out.println("rtn_str_rcpt_rfnd_id_no mult:"+rtn_str_rcpt_rfnd_id_no);

				String str_nominee_name = req.getParameter("str_nominee_name"
						+ i);
				if (str_nominee_name == null)
					str_nominee_name = "";

				rtn_str_nominee_name.add(str_nominee_name + "|");

				// System.out.println("rtn_str_nominee_name mult:"+rtn_str_nominee_name);

				str_doc_sr_no = String.valueOf(doc_sr_no);
				rtn_str_doc_sr_no.add(str_doc_sr_no + "|");
				// System.out.println("str_doc_sr_no temp"+rtn_str_doc_sr_no);

				doc_sr_no = 1;

				mult_slmt_vals
						.put("rtn_str_slmt_doc_amt", rtn_str_slmt_doc_amt);
				mult_slmt_vals.put("rtn_str_slmt_type_code",
						rtn_str_slmt_type_code);
				mult_slmt_vals.put("rtn_str_slmt_doc_ref_desc",
						rtn_str_slmt_doc_ref_desc);
				mult_slmt_vals.put("rtn_str_slmt_doc_ref_date",
						rtn_str_slmt_doc_ref_date);
				mult_slmt_vals.put("rtn_str_slmt_doc_remarks",
						rtn_str_slmt_doc_remarks);
				mult_slmt_vals.put("rtn_str_app_ref_no", rtn_str_app_ref_no);
				mult_slmt_vals.put("rtn_str_cash_slmt_flag",
						rtn_str_cash_slmt_flag);
				mult_slmt_vals.put("rtn_str_cc_batch_no", rtn_str_cc_batch_no);
				mult_slmt_vals.put("rtn_str_cc_sale_draft_no",
						rtn_str_cc_sale_draft_no);
				mult_slmt_vals.put("rtn_str_cc_swipped_yn",
						rtn_str_cc_swipped_yn);
				mult_slmt_vals.put("rtn_str_bank_code", rtn_str_bank_code);
				mult_slmt_vals.put("rtn_str_bank_branch", rtn_str_bank_branch);
				mult_slmt_vals.put("rtn_str_cash_amt_given",
						rtn_str_cash_amt_given);
				mult_slmt_vals.put("rtn_str_cash_amt_return",
						rtn_str_cash_amt_return);
				mult_slmt_vals.put("rtn_str_payer_name", rtn_str_payer_name);
				mult_slmt_vals.put("rtn_str_rcpt_rfnd_id_no",
						rtn_str_rcpt_rfnd_id_no);
				mult_slmt_vals
						.put("rtn_str_nominee_name", rtn_str_nominee_name);
				mult_slmt_vals.put("rtn_str_doc_sr_no", rtn_str_doc_sr_no);

			}// end of for loop
		}// end of if loop
		else {
			String rtn_str_slmt_doc_amt = "", rtn_str_slmt_type_code = "", rtn_str_slmt_doc_ref_desc = "", rtn_str_slmt_doc_ref_date = "", rtn_str_slmt_doc_remarks = "", rtn_str_app_ref_no = "", rtn_str_cash_slmt_flag = "", rtn_str_cc_batch_no = "", rtn_str_cc_sale_draft_no = "", rtn_str_cc_swipped_yn = "", rtn_str_bank_code = "", rtn_str_bank_branch = "", rtn_str_cash_amt_given = "", rtn_str_cash_amt_return = "", rtn_str_payer_name = "", rtn_str_rcpt_rfnd_id_no = "", rtn_str_nominee_name = "";
			String str_doc_sr_no = "0", rtn_str_doc_sr_no = "";

			for (int i = 0; i < totalRecords; i++) {

				String str_slmt_doc_amt = req.getParameter("billslmtamt" + i);
				if (str_slmt_doc_amt == null)
					str_slmt_doc_amt = "";

				rtn_str_slmt_doc_amt = rtn_str_slmt_doc_amt + str_slmt_doc_amt
						+ "|";

				String str_slmt_type_code = req.getParameter("slmttype" + i);
				if (str_slmt_type_code == null)
					str_slmt_type_code = "";

				String str_cash_slmt_flag = str_slmt_type_code;
				str_slmt_type_code = str_slmt_type_code.substring(0, 2);
				// System.out.println("str_slmt_type_code 11:"+str_slmt_type_code);

				// rtn_str_slmt_type_code=
				// rtn_str_slmt_doc_amt+str_slmt_type_code+"|";
				str_cash_slmt_flag = str_cash_slmt_flag.substring(2, 3);
				// System.out.println("str_cash_slmt_flag 12:"+str_cash_slmt_flag);
				rtn_str_slmt_type_code = rtn_str_slmt_type_code
						+ str_slmt_type_code + "|";
				// System.out.println("rtn_str_slmt_type_code 12:"+rtn_str_slmt_type_code);
				// System.out.println("rtn_str_slmt_type_code 11:"+rtn_str_slmt_type_code);

				String str_slmt_doc_ref_desc = req.getParameter("instref" + i);
				if (str_slmt_doc_ref_desc == null)
					str_slmt_doc_ref_desc = "";

				// System.out.println(" str_slmt_doc_ref_desc from servlet"+str_slmt_doc_ref_desc);

				rtn_str_slmt_doc_ref_desc = rtn_str_slmt_doc_ref_desc
						+ str_slmt_doc_ref_desc + "|";

				String str_slmt_doc_ref_date = req.getParameter("instdate" + i);
				if (str_slmt_doc_ref_date == null)
					str_slmt_doc_ref_date = "";

				// System.out.println(" str_slmt_doc_ref_date from servlet"+str_slmt_doc_ref_date);

				rtn_str_slmt_doc_ref_date = rtn_str_slmt_doc_ref_date
						+ str_slmt_doc_ref_date + "|";

				String str_slmt_doc_remarks = req
						.getParameter("str_slmt_doc_remarks" + i);
				if (str_slmt_doc_remarks == null)
					str_slmt_doc_remarks = "";

				rtn_str_slmt_doc_remarks = rtn_str_slmt_doc_remarks
						+ str_slmt_doc_remarks + "|";

				String str_app_ref_no = req.getParameter("apprrefno" + i);
				if (str_app_ref_no == null)
					str_app_ref_no = "";

				rtn_str_app_ref_no = rtn_str_app_ref_no + str_app_ref_no + "|";

				/*
				 * String str_cash_slmt_flag =
				 * req.getParameter("str_cash_slmt_flag"+i);
				 * if(str_cash_slmt_flag == null) str_cash_slmt_flag="";
				 */

				rtn_str_cash_slmt_flag = rtn_str_cash_slmt_flag
						+ str_cash_slmt_flag + "|";

				String str_cc_batch_no = req.getParameter("batchno" + i);
				if (str_cc_batch_no == null)
					str_cc_batch_no = "";

				rtn_str_cc_batch_no = rtn_str_cc_batch_no + str_cc_batch_no
						+ "|";

				String str_cc_sale_draft_no = req.getParameter("saledraftno"
						+ i);
				if (str_cc_sale_draft_no == null)
					str_cc_sale_draft_no = "";

				rtn_str_cc_sale_draft_no = rtn_str_cc_sale_draft_no
						+ str_cc_sale_draft_no + "|";

				String str_cc_swipped_yn = req.getParameter("str_cc_swipped_yn"
						+ i);
				if (str_cc_swipped_yn == null)
					str_cc_swipped_yn = "";

				rtn_str_cc_swipped_yn = rtn_str_cc_swipped_yn
						+ str_cc_swipped_yn + "|";

				String str_bank_code = req.getParameter("instremarkcode" + i);
				if (str_bank_code == null)
					str_bank_code = "";

				rtn_str_bank_code = rtn_str_bank_code + str_bank_code + "|";

				String str_bank_branch = req.getParameter("instbranch" + i);
				if (str_bank_branch == null)
					str_bank_branch = "";

				rtn_str_bank_branch = rtn_str_bank_branch + str_bank_branch
						+ "|";

				String str_cash_amt_given = req.getParameter("cash_given" + i);
				if (str_cash_amt_given == null)
					str_cash_amt_given = "";

				rtn_str_cash_amt_given = rtn_str_cash_amt_given
						+ str_cash_amt_given + "|";

				String str_cash_amt_return = req
						.getParameter("cash_return" + i);
				if (str_cash_amt_return == null)
					str_cash_amt_return = "";

				rtn_str_cash_amt_return = rtn_str_cash_amt_return
						+ str_cash_amt_return + "|";

				String str_payer_name = req.getParameter("payername" + i);
				if (str_payer_name == null)
					str_payer_name = "";
				rtn_str_payer_name = rtn_str_payer_name + str_payer_name + "|";

				String str_rcpt_rfnd_id_no = req.getParameter("recrefidno" + i);
				if (str_rcpt_rfnd_id_no == null)
					str_rcpt_rfnd_id_no = "";

				rtn_str_rcpt_rfnd_id_no = rtn_str_rcpt_rfnd_id_no
						+ str_rcpt_rfnd_id_no + "|";

				String str_nominee_name = req.getParameter("str_nominee_name"
						+ i);
				if (str_nominee_name == null)
					str_nominee_name = "";

				rtn_str_nominee_name = rtn_str_nominee_name + str_nominee_name
						+ "|";

				str_doc_sr_no = String.valueOf(doc_sr_no);
				rtn_str_doc_sr_no = rtn_str_doc_sr_no + str_doc_sr_no + "|";
				// System.out.println("str_doc_sr_no temp"+rtn_str_doc_sr_no);

				doc_sr_no++;

				mult_slmt_vals
						.put("rtn_str_slmt_doc_amt", rtn_str_slmt_doc_amt);
				mult_slmt_vals.put("rtn_str_slmt_type_code",
						rtn_str_slmt_type_code);
				mult_slmt_vals.put("rtn_str_slmt_doc_ref_desc",
						rtn_str_slmt_doc_ref_desc);
				mult_slmt_vals.put("rtn_str_slmt_doc_ref_date",
						rtn_str_slmt_doc_ref_date);
				mult_slmt_vals.put("rtn_str_slmt_doc_remarks",
						rtn_str_slmt_doc_remarks);
				mult_slmt_vals.put("rtn_str_app_ref_no", rtn_str_app_ref_no);
				mult_slmt_vals.put("rtn_str_cash_slmt_flag",
						rtn_str_cash_slmt_flag);
				mult_slmt_vals.put("rtn_str_cc_batch_no", rtn_str_cc_batch_no);
				mult_slmt_vals.put("rtn_str_cc_sale_draft_no",
						rtn_str_cc_sale_draft_no);
				mult_slmt_vals.put("rtn_str_cc_swipped_yn",
						rtn_str_cc_swipped_yn);
				mult_slmt_vals.put("rtn_str_bank_code", rtn_str_bank_code);
				mult_slmt_vals.put("rtn_str_bank_branch", rtn_str_bank_branch);
				mult_slmt_vals.put("rtn_str_cash_amt_given",
						rtn_str_cash_amt_given);
				mult_slmt_vals.put("rtn_str_cash_amt_return",
						rtn_str_cash_amt_return);
				mult_slmt_vals.put("rtn_str_payer_name", rtn_str_payer_name);
				mult_slmt_vals.put("rtn_str_rcpt_rfnd_id_no",
						rtn_str_rcpt_rfnd_id_no);
				mult_slmt_vals
						.put("rtn_str_nominee_name", rtn_str_nominee_name);
				mult_slmt_vals.put("rtn_str_doc_sr_no", rtn_str_doc_sr_no);
			}
		}
		// System.out.println("mult_slmt_vals 2"+mult_slmt_vals);

	}
}
