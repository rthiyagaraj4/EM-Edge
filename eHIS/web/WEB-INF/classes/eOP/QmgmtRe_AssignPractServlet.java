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

import ecis.utils.OnlineReport;
import ecis.utils.OnlineReports;

import eBL.BLReportIdMapper;
import eOP.QmgmtRe_AssignPract.*;
import eCommon.XSSRequestWrapper;


public class QmgmtRe_AssignPractServlet extends javax.servlet.http.HttpServlet {
	PrintWriter out;

	java.util.Properties p;

	Connection conn;

	PreparedStatement pstmt = null;

	ResultSet rset = null;

	String facilityId = "";

	String room_change = "";

	String client_ip_address;

	String asslocncode = "";

	String asslocntype = "";

	String sStyle = "";

	String eid = "";

	String pmode = "";

	String con = "";

	String emsg = "";

	String pract = "";

	String asspractid = "";

	String room_num = "";

	String room_cur = "";

	String other_res_type = "";

	String other_res_code = "";

	String queue_num = "";

	String appt_walk_ind = "";

	String open_to_all_pract_yn = "";

	String module_id = "";

	String queue_id = "";

	String episode_visit_num = "";

	String episode_id = "";
	String qms_interfaced_yn = "N";
	String addedById = "";
	String assign_qnum_by = "";
	String multi_speciality_yn = "N";//Added for the CRF - Bru-HIMS-CRF-0198
	String sec_res_lst = "";//Added for the CRF - Bru-HIMS-CRF-0198
	
	String isPatientEncMovement=""; //this line added for this CRF Bru-HIMS-CRF-133
    String Sydate=""; //this line added for this CRF Bru-HIMS-CRF-133

	HashMap tabdata = new HashMap();

	String locale = "";

	String bl_install_yn = "";
   
	HttpSession session=null;
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req,
			HttpServletResponse res) throws javax.servlet.ServletException,
			IOException {
		req= new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
        session = req.getSession(false);
		this.facilityId = (String) session.getValue("facility_id");
		this.conn = ConnectionManager.getConnection(req);
		this.p = (java.util.Properties) session.getValue("jdbc");
		this.client_ip_address = p.getProperty("client_ip_address");
		this.addedById = p.getProperty("login_user");
		locale = p.getProperty("LOCALE");
		try {
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
					|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
					.getAttribute("PREFERRED_STYLE")
					: "IeStyle.css";
					
			// code changed by Vedesh A D for Edge Conversion
		    out.println("<!DOCTYPE html><head><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link>");
		    out.println("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='JavaScript'>");
		    out.println("async function callQmgmtRe_AssignPractHTML() { ");

			updatePrEncounter(req, res);
			
			out.println("} callQmgmtRe_AssignPractHTML();</script></body></html>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				ConnectionManager.returnConnection(conn, req);
		}
	}

	private void updatePrEncounter(HttpServletRequest req,
			HttpServletResponse res) {
		try {

			getParams(req);
			InsertTabdata(req);
			boolean insertable = false;
			try {
				String assvisittypecode = checkNull(req
						.getParameter("curvisittypecode"));
				int cnt = 0;
				int cnt1 = 0;
				String sql1 = "";
				String sql = "select count(*) from OP_VISIT_TYPE_FOR_CLINIC where facility_id='"
						+ facilityId
						+ "' and clinic_code='"
						+ asslocncode
						+ "' and visit_type_code='" + assvisittypecode + "'";

				pstmt = conn.prepareStatement(sql);
				rset = pstmt.executeQuery();
				if (rset != null) {
					if (rset.next()) {
						cnt = rset.getInt(1);
					}
				}

				if (rset != null)
					rset.close();
				if (pstmt != null)
					pstmt.close();
				if (cnt != 0) {
					insertable = true;
					emsg = "";
				} else {
					insertable = false;
					MessageManager mm = new MessageManager();
					final java.util.Hashtable mesg = mm.getMessage(locale,
					"VISIT_NOT_APPLICABLE", "OP");
					emsg = (String) mesg.get("message");
					//emsg = "Visit Type is not applicable to this clinic";
				}
				if (insertable) {
					if (open_to_all_pract_yn.equals("N")) {
						sql1 = "select count(*) from op_visit_type a, OP_PRACT_FOR_CLINIC b where a.FACILITY_ID='"
								+ facilityId
								+ "' and a.visit_type_code='"
								+ assvisittypecode
								+ "' and a.facility_id=b.facility_id and b.CLINIC_CODE='"
								+ asslocncode
								+ "' and b.PRACTITIONER_ID='"
								+ asspractid
								+ "' and decode(a.visit_type_ind,'F',b.fi_visit_type_appl_yn,        'L',b.fu_visit_type_appl_yn,'R',b.rt_visit_type_appl_yn,'E',b.em_visit_type_appl_yn,  'S',b.sr_visit_type_appl_yn,'C',b.cs_visit_type_appl_yn)='Y' ";

						pstmt = conn.prepareStatement(sql1);
						rset = pstmt.executeQuery();
						if (rset != null) {
							if (rset.next()) {
								cnt1 = rset.getInt(1);
							}
						}
						if (rset != null)
							rset.close();
						if (pstmt != null)
							pstmt.close();

					} else {

						/*
						sql1 = "select count(*) from OP_VISIT_TYPE_FOR_CLINIC where facility_id='"
								+ facilityId
								+ "' and clinic_code='"
								+ asslocncode
								+ "' and visit_type_code='"
								+ assvisittypecode + "' ";
						*/
						cnt1 = cnt;
					}
					
					/*
					pstmt = conn.prepareStatement(sql1);
					rset = pstmt.executeQuery();
					if (rset != null) {
						if (rset.next()) {
							cnt1 = rset.getInt(1);
						}
					}
					if (rset != null)
						rset.close();
					if (pstmt != null)
						pstmt.close();
					*/

					if (cnt1 != 0) {
						insertable = true;
						emsg = "";
					} else {
						insertable = false;
						MessageManager mm = new MessageManager();
						final java.util.Hashtable mesg = mm.getMessage(locale,
								"VISIT_TYPE_NOT_APPL_PRACT", "Common");
						emsg = (String) mesg.get("message");

						//emsg = "Visit Type is not applicable to this practitioner.";
					}
				}
			} catch (Exception e) {
				insertable = false;
				
			}
			if (insertable) {

				boolean local_ejbs = false;
				if ((getServletConfig().getServletContext().getInitParameter(
						"LOCAL_EJBS") != null)
						&& (getServletConfig().getServletContext()
								.getInitParameter("LOCAL_EJBS")
								.equalsIgnoreCase("TRUE")))
					local_ejbs = true;
				Object home = com.ehis.eslp.ServiceLocator.getInstance()
						.getHome("java:comp/env/QmgmtRe_AssignPractManager",
								QmgmtRe_AssignPractHome.class, local_ejbs);
				Object busObj = (home.getClass().getMethod("create", null))
						.invoke(home, null);
				Object argArray[] = new Object[2];
				argArray[0] = p;
				argArray[1] = tabdata;
				
				Class[] paramArray = new Class[2];
				paramArray[0] = p.getClass();
				paramArray[1] = tabdata.getClass();

				java.util.HashMap results = (java.util.HashMap) (busObj
						.getClass().getMethod("updatePrEncounter", paramArray))
						.invoke(busObj, argArray);
				(busObj.getClass().getMethod("remove", null)).invoke(busObj,
						null);
				boolean inserted = (((Boolean) results.get("status"))
						.booleanValue());
				String error = (String) results.get("error");
				String strBLMessage = "0";
				try {
					strBLMessage = (String) results.get("bl_message");
					if ((strBLMessage == null) || (strBLMessage.equals(" "))) {
						strBLMessage = "0";
					}
				} catch (Exception exceptionBL) {
					strBLMessage = "0";
				}
				if (inserted) {
					if (bl_install_yn.equals("Y")) {
							
							String billgenlater = (String) results
									.get("billgenlater");

							String billtotalamt = (String) results
									.get("billtotalamt");

							if(billgenlater == null) billgenlater="N";
							if(billtotalamt == null) billtotalamt="N";

							String str_bill_prt_format_YN = (String) results.get("bill_prt_format_YN");	
							if(str_bill_prt_format_YN == null || str_bill_prt_format_YN.equals("")) str_bill_prt_format_YN="N";

							if(str_bill_prt_format_YN.equals("Y"))
							{
								try
								{
									String pgm_id = (String) results.get("pgm_id");	
									if(pgm_id == null) pgm_id="";
									String session_id = (String) results.get("session_id");	
									if(session_id == null) session_id="";
									String pgm_date = (String) results.get("pgm_date");	
									if(pgm_date == null) pgm_date="";
									String mpi_id_rep = (String) results.get("mpi_id_rep");	
									if(mpi_id_rep == null) mpi_id_rep="";
									
									String reportId="BLRBLPRT";
									
									
									try{
										/* BLReportIdMapper.getReportId function used in other modules also
										 * eAE - AEManagePatientServlet.java, AERegisterAttnServlet.java
										 * eBL - BLAdhocDiscSubmit.jsp, BLBillSlmtValidation.jsp, BLPatRegValidation.jsp, BLReprintReportHdr.jsp, BLStoreBillSlmtMain.jsp
										 * eMP - PatientRegistrationServlet.java
										 * eOP - PatCheckoutServlet.java, QmgmtRe_AssignPractServlet.java, ReviseVisitServlet.java, VisitRegistrationServlet.java
										 */
										reportId=BLReportIdMapper.getReportId(conn, locale,reportId, facilityId); //Added facilityId By Subha for MMS-DM-CRF-131.1
										System.out.println("QmgmtRe_AssignPractServlet for Report ID "+reportId);
										
									}catch(Exception e)
									{
										e.printStackTrace();
										reportId="BLRBLPRT";
										System.err.println("Exception in QmgmtRe_AssignPract Servlet for reportID "+e);
									}
									
									
									
									OnlineReport onlinereportParam = new OnlineReport(facilityId, "BL", reportId);
									onlinereportParam.addParameter("p_facility_id",facilityId);
									onlinereportParam.addParameter("p_pgm_date",pgm_date);
									onlinereportParam.addParameter("p_pgm_id",pgm_id);
									onlinereportParam.addParameter("p_Session_id",session_id);
									OnlineReports onlinereports = new OnlineReports();
									onlinereports.add(onlinereportParam);
									onlinereports.execute(req,res); //added for check Style by  munisekhar
									//String strResults =  onlinereports.execute(req,res); // commented for check Style by munisekhar

									onlinereportParam = null;
									onlinereports = null;								
								}
								catch (Exception e)
								{
									System.err.println("Error while submitting Print Job to Report Server:"+e);
								}
							}

							String htmlFor1 = "var enter_yn ; var arr = new Array(); var dialogHeight    = '90vh' ;	 var dialogWidth = '95vw' ;	var dialogTop = '100' ;	 var center    = '1'  ;	 var arguments =   ''; var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; center:' + center +'; dialogTop:' + dialogTop +'; status=no;' ; "
												+" var getUrl  = '../../eBL/jsp/BLAdhocDiscFrame.jsp?patient_id="
												+checkNull(req.getParameter("patientid"))
												+"&episode_type=O"
												+"&episode_id="
												+episode_id
												+"&visit_id="
												+episode_visit_num
												+"&encounter_id="
												+checkNull(req.getParameter("encounterid"))
												+"&pract_id="
												+asspractid
												+"&locn_code="
												+asslocncode
												+"&billgenlater="
												+ billgenlater
												+"&function_id=ASSIGN_PRACTITIONER"
												+"&module_id=OP"
												+"&visit_type_code="
												+ checkNull(req.getParameter("curvisittypecode"))
//												+"&blnggrp="
//												+ billing_group
												+"&called_frm=OTH_MOD"
												+"';"
												+ " if('"+billgenlater+"' == 'Y') {  var retVal = await window.showModalDialog(getUrl,arguments,features);"
												+"};"
												+"";

							out.println(htmlFor1);
						}

					if (!(strBLMessage.equals("0"))) {						
						out.println("var blErrMsg='"+strBLMessage+"'; blErrMsg=blErrMsg.replace(/<BR>/g,'\\n');alert(blErrMsg);");
					}

					if (room_change != null) {
						if (!(room_change.equals(""))) {

							MessageManager mm = new MessageManager();
							final java.util.Hashtable mesg = mm.getMessage(
									locale, "RECORD_MODIFIED", "SM");
							String msg1 = (String) mesg.get("message");
							out.println("alert('" + msg1
									+ "');parent.parent.document.getElementById('dialog-body').contentWindow.returnValue ='"
									+ asspractid + "';");
							// out.println("<html><script>alert(getMessage(\"RECORD_MODIFIED\"));parent.window.returnValue='"+asspractid+"';</script></html>");
							doOnlineReports(req, eid, facilityId, asslocncode,
									asslocntype, sStyle,locale);
							out.println("<script>top.window.document.getElementById('dialog_tag').close();</script>");
						} else {
							if (module_id.equals("CA")) {
								out
										.println("parent.parent.document.getElementById('dialog-body').contentWindow.returnValue = '"
												+ asspractid
												+ "'; parent.parent.document.getElementById('dialog_tag').close();");
							} else {
								MessageManager mm = new MessageManager();
								final java.util.Hashtable mesg = mm.getMessage(
										locale, "RECORD_MODIFIED", "SM");
								String msg1 = (String) mesg.get("message");
								out
										.println("alert('"
												+ msg1
												+ "');parent.parent.document.getElementById('dialog-body').contentWindow.returnValue ='"
												+ asspractid
												+ "'; parent.parent.document.getElementById('dialog_tag').close();");
								// out.println("<html><script>alert(getMessage(\"RECORD_MODIFIED\"));parent.window.returnValue='"+asspractid+"';
								// parent.window.close();</script></html>");
							}
						}
					}
					if (error.lastIndexOf("<br>") >= 0)
						error = error.substring(0, error.lastIndexOf("<br>"));					
				} else {
					if(qms_interfaced_yn.equals("Y")){
						System.out.println("QmgmtRe_AssignPract rolled back - cancelQMSQueueNum called");
						cancelQMSQueueNum(queue_num,(String)session.getAttribute("CUSTOMER_ID"),addedById,client_ip_address,facilityId,(String)session.getId(),checkNull(req.getParameter("patientid")),checkNull(req.getParameter("encounterid")),conn);
					}	
					error = (String) results.get("error");
					out.println("alert(\"" + error
							+ "\"); parent.parent.document.getElementById('dialog_tag').close();");
				}
				argArray = null;
				paramArray = null;
				session.removeAttribute("financial_details");
				results.clear();
				tabdata.clear();
			} else {
				if(qms_interfaced_yn.equals("Y")){
					System.out.println("QmgmtRe_AssignPract rolled back - cancelQMSQueueNum called");
					cancelQMSQueueNum(queue_num,(String)session.getAttribute("CUSTOMER_ID"),addedById,client_ip_address,facilityId,(String)session.getId(),checkNull(req.getParameter("patientid")),checkNull(req.getParameter("encounterid")),conn);
				}
				out.println("alert(\"" + emsg
						+ "\"); parent.parent.document.getElementById('dialog_tag').close();");
			}
		} catch (Exception e) {
			out.println(e.getMessage());
			e.printStackTrace();
			if(qms_interfaced_yn.equals("Y")){
				System.out.println("QmgmtRe_AssignPract rolled back - cancelQMSQueueNum called");
				cancelQMSQueueNum(queue_num,(String)session.getAttribute("CUSTOMER_ID"),addedById,client_ip_address,facilityId,(String)session.getId(),checkNull(req.getParameter("patientid")),checkNull(req.getParameter("encounterid")),conn);
			}
		}
	}

	public void getParams(HttpServletRequest req) {
		eid = req.getParameter("encounterid");
		pmode = req.getParameter("pmode");
		con = req.getParameter("LAssign1");
		emsg = "";
		if (con != null) {
			StringTokenizer st = new StringTokenizer(con, "|");
			
			if (pmode.equals("R")) {
				while (st.hasMoreTokens()) {
					asslocncode = st.nextToken();
					st.nextToken();
					asslocntype = st.nextToken();
					st.nextToken();
					st.nextToken();
					st.nextToken();
				}
			} else {
				while (st.hasMoreTokens()) {
					asslocncode = st.nextToken();
					st.nextToken();
					asslocntype = st.nextToken();
					st.nextToken();
					st.nextToken();
					st.nextToken();
					
				}
			}
		}
		pract = req.getParameter("pract_id");
		asspractid = "";
		if (pract != null) {
			StringTokenizer st1 = new StringTokenizer(pract, "|");
			if (st1.hasMoreTokens()) {
				asspractid = st1.nextToken();
			}
		}
		room_num = req.getParameter("room_num");
		if (room_num == null || room_num.equals("NoRoom"))
			room_num = "";
		room_change = req.getParameter("room_change") == null ? "" : req
				.getParameter("room_change");
		room_cur = req.getParameter("room_cur");
		if (room_cur == null || room_cur.equals("NoRoom"))
			room_cur = "";
		other_res_type = req.getParameter("other_res_type") == null ? "" : req
				.getParameter("other_res_type");
		other_res_code = req.getParameter("other_res_code") == null ? "" : req
				.getParameter("other_res_code");
		queue_num = req.getParameter("queue_num");
		if (queue_num == null || queue_num.equals(""))
			queue_num = "0";

		appt_walk_ind = req.getParameter("appt_walk_ind") == null ? "" : req
				.getParameter("appt_walk_ind");
		open_to_all_pract_yn = req.getParameter("open_to_all_pract_yn") == null ? ""
				: req.getParameter("open_to_all_pract_yn");
		module_id = req.getParameter("module_id") == null ? "" : req
				.getParameter("module_id");
		queue_id = req.getParameter("queue_id") == null ? "" : req
				.getParameter("queue_id");
		episode_id = req.getParameter("episode_id") == null ? "" : req
				.getParameter("episode_id");
		episode_visit_num = req.getParameter("episode_visit_num") == null ? ""
				: req.getParameter("episode_visit_num");
		qms_interfaced_yn=req.getParameter("qms_interfaced_yn")==null?"N":req.getParameter("qms_interfaced_yn");
		assign_qnum_by=req.getParameter("assign_q_num_by")==null?"":req.getParameter("assign_q_num_by");//modified for the SCF - ML-BRU-SCF-0799 on 16/4/2013
		if(qms_interfaced_yn.equals("Y")){
			assign_qnum_by="M";
		}
		multi_speciality_yn=req.getParameter("multi_speciality_yn")==null?"N":req.getParameter("multi_speciality_yn");//Added for the CRF - Bru-HIMS-CRF - 0198
		sec_res_lst=req.getParameter("sec_res_lst")==null?"":req.getParameter("sec_res_lst");//Added for the crf - Bru-HIMS-CRF-0198
		
	}

	public void InsertTabdata(HttpServletRequest req) {
		tabdata.put("facilityId", facilityId);
		tabdata.put("patientid", checkNull(req.getParameter("patientid")));
		tabdata.put("locntype", checkNull(req.getParameter("locntype")));
		tabdata.put("locncode", checkNull(req.getParameter("locncode")));
		tabdata.put("encounterid", checkNull(req.getParameter("encounterid")));
		tabdata.put("practid", checkNull(req.getParameter("practid")));
		tabdata.put("pmode", pmode);
		tabdata.put("curlocncode", checkNull(req.getParameter("curlocncode")));
		tabdata.put("curlocntype", checkNull(req.getParameter("curlocntype")));
		tabdata.put("asslocncode", asslocncode);
		tabdata.put("asslocntype", asslocntype);
		tabdata.put("curpractid", checkNull(req.getParameter("curpractid")));
		tabdata
				.put("curpracttype",
						checkNull(req.getParameter("curpracttype")));
		tabdata.put("asspractid", asspractid);
		tabdata.put("curvisittypecode", checkNull(req
				.getParameter("curvisittypecode")));
		tabdata.put("assvisittypecode", checkNull(req
				.getParameter("curvisittypecode")));
		tabdata.put("cur_vis_type_ind", checkNull(req.getParameter("cur_vis_type_ind")));
		tabdata.put("qms_interfaced_yn", qms_interfaced_yn);
		
		tabdata.put("assign_q_num_by", assign_qnum_by);
		tabdata.put("visitcase", checkNull(req.getParameter("visitcase")));
		tabdata.put("unlinkapptcaseyn", checkNull(req
				.getParameter("unlinkapptcaseyn")));
		tabdata
				.put("p_queue_date",
						checkNull(req.getParameter("p_queue_date")));
		tabdata.put("p_team_id", checkNull(req.getParameter("team_id")));
		tabdata.put("room_num", room_num);
		tabdata.put("room_cur", room_cur);
		tabdata.put("room_change", room_change);
		tabdata.put("chg_flag", checkNull(req.getParameter("chg_flag")));
		tabdata.put("service_code", checkNull(req
				.getParameter("service_code_h")));
		tabdata.put("subservice_code", checkNull(req
				.getParameter("sub_service_code_h")));
		tabdata.put("client_ip_address", client_ip_address);
		tabdata.put("facilityId", facilityId);
		bl_install_yn=req.getParameter("bl_install_yn")==null?"N":req.getParameter("bl_install_yn");
		tabdata.put("bl_install_yn",bl_install_yn );
		tabdata.put("appt_id", checkNull(req.getParameter("appt_id")));
		tabdata.put("VITAL_SIGNS_DATE_TIME", checkNull(req
				.getParameter("VITAL_SIGNS_DATE_TIME")));
		tabdata.put("ARRIVE_DATE_TIME", checkNull(req
				.getParameter("ARRIVE_DATE_TIME")));
		tabdata.put("IDENT_AT_CHECKIN", checkNull(req
				.getParameter("IDENT_AT_CHECKIN")));
		tabdata.put("customerID",(String)session.getAttribute("CUSTOMER_ID"));
		tabdata.put("sessionID",session.getId());
		
		tabdata.put("other_res_type", other_res_type);
		tabdata.put("other_res_code", other_res_code);
		tabdata.put("queue_num", queue_num);
		tabdata.put("appt_walk_ind", appt_walk_ind);
		tabdata.put("queue_id", queue_id);
		tabdata.put("episode_id", episode_id);
		tabdata.put("episode_visit_num", episode_visit_num);
		tabdata.put("multi_speciality_yn", multi_speciality_yn);
		tabdata.put("sec_res_lst", sec_res_lst);
		
		if(bl_install_yn.equalsIgnoreCase("Y")){
		HashMap fin_dtls=(HashMap)session.getAttribute("financial_details");		
		tabdata.put("fin_dtls",(HashMap)fin_dtls);
		}	
		
		tabdata.put("isPatientEncMovement", checkNull(req.getParameter("isPatientEncMovement"))); //this line added for this CRF Bru-HIMS-CRF-133
		tabdata.put("Sydate", checkNull(req.getParameter("Sydate"))); //this line added for this CRF Bru-HIMS-CRF-133
        tabdata.put("queuestatus", checkNull(req.getParameter("p_queue_status"))); //this line added for this CRF Bru-HIMS-CRF-133    
	}

	private void doOnlineReports(HttpServletRequest req, String encounter_id,
			String facility_id, String p_locn_code, String p_locn_type,
			String sStylerep,String locale) throws ServletException, IOException,
			SQLException {
		StringBuffer htmlFor = new StringBuffer();
		String visit_adm_type = checkNull(req.getParameter("curvisittypecode"));
		htmlFor.setLength(0);

		String sqlString = " Select distinct report_id, sm_get_desc.SM_REPORT(MODULE_ID,report_id,'"+locale+"','1')report_desc, 1 no_of_copies, module_id from op_online_report where OPERATING_FACILITY_ID='"
						+ facility_id
						+ "' and PRINT_AT_CI_YN='Y' and (clinic_code='"
						+ p_locn_code
						+ "' or clinic_code ='*All') and (VISIT_TYPE_CODE='"
						+ visit_adm_type
						+ "' OR VISIT_TYPE_CODE='*A') ";/*Above Query is modified  by Rameswar on 03-Nov-15 for HSA-CRF-0319*/

		String reportParamNames = "p_encounter_id,p_facility_id";
		String reportParamValues = "" + encounter_id + "," + facility_id + "";
		String p_patient_id = req.getParameter("patientid");
		if (p_patient_id == null)
			p_patient_id = "";

		/*htmlFor
				.append(" <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/"
						+ sStylerep + "'></link>");
		htmlFor.append("</head><body class='message'>");
		htmlFor.append("<script language = 'JavaScript'>");*/
		htmlFor.append("  var dialogHeight    = '50vh' ;");
		htmlFor.append(" var dialogWidth = '55vw' ;");
		htmlFor.append("var dialogTop = '65';");
		htmlFor.append("  var arguments =   ''; ");
		// modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
		htmlFor
				.append("  var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=ASSIGN_PRACTITIONER&step=1&sqlString="
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
		/*htmlFor.append(" </script>");*/
		out.println(htmlFor.toString());
		htmlFor.setLength(0);

	}

	public static String checkNull(String str) {
		return ((str == null || str.equals("null")) ? "" : str);
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
				System.out.println("Before sending param to QMSInterface from QmgmtRe_AssignPractServlet: "+audit_params.toString());
				eOP.QMSInterface.cancelQueueNumber(queue_num,audit_params,con);
			}
		}catch(Exception ex){
			System.out.println("Error during call to QMS");
			ex.printStackTrace();
		}
	}
}
