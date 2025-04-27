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
import eBL.BLReportIdMapper;
import eOP.ReviseVisit.*;

import ecis.utils.OnlineReport;
import ecis.utils.OnlineReports;

public class ReviseVisitServlet extends javax.servlet.http.HttpServlet {

	PrintWriter out;

	java.util.Properties p;

	String facilityId = "";

	String client_ip_address;

	String sStyle = "";

	String asn_locn_code = "";

	HttpSession session;

	Connection con = null;

	String appt_id = "";

	String eid = "";

	String asn_care_locn_type = "";

	String assign_care_locn_code1 = "";

	String attend_practitioner_id = "";

	String cur_pract_type = "";

	String currentRoomNumber = "";

	String resclass = "";

	String room_num = "";

	PreparedStatement pstmt = null;

	ResultSet rset = null;

	String other_res_code = "";

	String other_res_type = "";

	String appt_walk_ind = "";

	String queue_date = "";

	String queue_num = "";

	String queue_id = "";

	String visit_type_code = "";

	String emsg = "";

	String open_to_all_pract_yn = "";

	HashMap tabdata = new HashMap();

	Hashtable BLtabdata = new Hashtable();

	String addedAtWorkstation = "";

	String room_change = "";

	String referal_id = "";
	String referral_id_old = "";
	String qms_interfaced_yn = "N";
	String addedById = "";
	
	String Sysdate="";//this line added for this CRF Bru-HIMS-CRF-133
	String queuestatus="";//this line added for this CRF Bru-HIMS-CRF-133
	

	boolean insertable = false;

	String locale = "";	
	
	String bl_install_yn = "", bl_interface_yn="";

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public synchronized void doPost(HttpServletRequest req,
			HttpServletResponse res) throws javax.servlet.ServletException,
			IOException {
		out = null;
		p = null;
		facilityId = "";
		session = req.getSession(false);
		this.facilityId = (String) session.getValue("facility_id");
		this.p = (java.util.Properties) session.getValue("jdbc");
		this.client_ip_address = p.getProperty("client_ip_address");
		locale = p.getProperty("LOCALE");
		addedById = p.getProperty("login_user");

		try {
			req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			this.out = res.getWriter();
			sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
					|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
					.getAttribute("PREFERRED_STYLE")
					: "IeStyle.css";

			con = ConnectionManager.getConnection(req);
			out.println("<!DOCTYPE html><head><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link><script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='JavaScript'> async function callReviseVisitServletHtml (){ ");
			insertReviseVisit(req, res);
			out.println("} callReviseVisitServletHtml ();</script></body></html>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				ConnectionManager.returnConnection(con, req);
		}

	}

	private void insertReviseVisit(HttpServletRequest req,
			HttpServletResponse res) {
		try {
			getData(req);
			insertable = visittypecheck(facilityId, asn_locn_code,
					visit_type_code, attend_practitioner_id,
					open_to_all_pract_yn);

			if (insertable) {
				String practWorkingYN = "N";
				String roomWorkingYN = "N";
				if (appt_id.equals("")) {
					if (!attend_practitioner_id.equals("")) {
						HashMap practWorkingHash = ifPractitionerWorkingYN(
								facilityId, asn_locn_code,
								attend_practitioner_id, con);
						practWorkingYN = (String) practWorkingHash
								.get("practWorkingYN");

						practWorkingHash.clear();
					}
				}
				if (practWorkingYN == null)
					practWorkingYN = "N";
				if (practWorkingYN.equals("Y")
						|| attend_practitioner_id.equals("")
						|| !appt_id.equals("")) {
					if (appt_id.equals("")) {
						if (!room_num.equals("")) {
							HashMap practWorkingHash = ifPractitionerWorkingYN(
									facilityId, asn_locn_code, room_num, con);
							roomWorkingYN = (String) practWorkingHash
									.get("practWorkingYN");
							practWorkingHash.clear();
						}
					}
					if (roomWorkingYN == null)
						roomWorkingYN = "N";
					if (roomWorkingYN.equals("Y") || room_num.equals("")
							|| !appt_id.equals("")) {
						InsertTabdata(req);
						
						// For Billing
						InsertBLData(req);

						String entitlement_check_yn = checkNull(req.getParameter("entitlement_by_pat_cat_yn"));
						String status = "0";

						/*

						pstmt = con.prepareStatement("select ENTITLEMENT_BY_PAT_CAT_YN  from mp_param");
						rset = pstmt.executeQuery();
						if (rset != null) {
							if (rset.next()) {
								entitlement_check_yn = rset.getString(1);
								if (entitlement_check_yn == null)
									entitlement_check_yn = "N";
							}
						}
						if (rset != null)
							rset.close();
						if (pstmt != null)
							pstmt.close();

						*/

						if (entitlement_check_yn.equals("Y")) {
							try {
								String visit_date = checkNull(req
										.getParameter("visit_adm_date_time"));

								pstmt = con
										.prepareStatement("select MP_ENTITLEMENT_VALIDATION(?,to_char(to_date(?,'dd/mm/yyyy'),'dd/mm/yyyy'),?,?,?,'OP',?,'') from dual");
								pstmt.setString(1, checkNull(req
										.getParameter("patient_id")));
								pstmt.setString(2, visit_date.substring(0, 10));
								pstmt.setString(3, facilityId);
								pstmt.setString(4, asn_care_locn_type);
								pstmt.setString(5, asn_locn_code);
								pstmt.setString(6, checkNull(req
										.getParameter("cur_specialty_code")));
								rset = pstmt.executeQuery();
								if (rset != null) {
									if (rset.next()) {
										status = rset.getString(1);
										if (status == null)
											status = "";
									}
								}
								if (pstmt != null)
									pstmt.close();
								if (rset != null)
									rset.close();

							} catch (Exception e) {
								e.printStackTrace();
							}
						}

						if (status.equals("0")) {
							boolean local_ejbs = false;

							if ((getServletConfig().getServletContext()
									.getInitParameter("LOCAL_EJBS") != null)
									&& (getServletConfig().getServletContext()
											.getInitParameter("LOCAL_EJBS")
											.equalsIgnoreCase("TRUE")))
								local_ejbs = true;

							Object home = com.ehis.eslp.ServiceLocator
									.getInstance().getHome(
											"java:comp/env/ReviseVisit",
											ReviseVisitHome.class, local_ejbs);
							Object busObj = (home.getClass().getMethod(
									"create", null)).invoke(home, null);

							Object argArray[] = new Object[3];
							argArray[0] = p;
							argArray[1] = tabdata;
							argArray[2] = BLtabdata;

							Class[] paramArray = new Class[3];
							paramArray[0] = p.getClass();
							paramArray[1] = tabdata.getClass();
							paramArray[2] = BLtabdata.getClass();

							java.util.HashMap results = (java.util.HashMap) (busObj
									.getClass().getMethod("insertReviseVisit",
									paramArray)).invoke(busObj, argArray);

							(busObj.getClass().getMethod("remove", null))
									.invoke(busObj, null);
							boolean inserted = (((Boolean) results
									.get("status")).booleanValue());
							String error = (String) results.get("error");
							//int Inderr = error.indexOf("<br>");
							int firstInderr = error.indexOf("<br>");

							if (firstInderr != -1) {
								firstInderr = firstInderr+4;
							}

							int lastInterr = error.indexOf("<br>",firstInderr);

							if (lastInterr != -1) {
								error = error.substring(firstInderr, lastInterr);
							}

							/*
							if (Inderr != -1) {
								error = error.substring(0, Inderr);
							}
							*/

							if (error == null)
								error = "";
							String strBLMessage = "0";
							try {
								strBLMessage = (String) results
										.get("bl_message");
								if ((strBLMessage == null)
										|| (strBLMessage.equals(" "))) {
									strBLMessage = "0";
								}
							} catch (Exception exceptionBL) {
								strBLMessage = "0";
							}
							if (inserted) {
								if (bl_install_yn.equals("Y")) {
							
										String billgenlater = (String) results.get("billgenlater");

										String billtotalamt = (String) results.get("billtotalamt");
										if(billgenlater == null) billgenlater="N";
										if(billtotalamt == null) billtotalamt="N";	

										String str_bill_prt_format_YN = (String) results.get("bill_prt_format_YN");	
										if(str_bill_prt_format_YN == null || str_bill_prt_format_YN.equals("")) str_bill_prt_format_YN="N";
										System.err.println("bill_prt_format_YN in Revise:"+str_bill_prt_format_YN);

										if(str_bill_prt_format_YN.equals("Y"))
										{
											try
											{
												String pgm_id = (String) results.get("pgm_id");	
												if(pgm_id == null) pgm_id="";
												System.err.println("pgm_id:"+pgm_id);
												String session_id = (String) results.get("session_id");	
												if(session_id == null) session_id="";
												System.err.println("session_id:"+session_id);
												String pgm_date = (String) results.get("pgm_date");	
												if(pgm_date == null) pgm_date="";
												System.err.println("pgm_date:"+pgm_date);
												String mpi_id_rep = (String) results.get("mpi_id_rep");	
												if(mpi_id_rep == null) mpi_id_rep="";
												System.err.println("mpi_id_rep:"+mpi_id_rep);
												
												String reportId="BLRBLPRT"; 
												
												try{
													/* BLReportIdMapper.getReportId function used in other modules also
													 * eAE - AEManagePatientServlet.java, AERegisterAttnServlet.java
													 * eBL - BLAdhocDiscSubmit.jsp, BLBillSlmtValidation.jsp, BLPatRegValidation.jsp, BLReprintReportHdr.jsp, BLStoreBillSlmtMain.jsp
													 * eMP - PatientRegistrationServlet.java
													 * eOP - PatCheckoutServlet.java, QmgmtRe_AssignPractServlet.java, ReviseVisitServlet.java, VisitRegistrationServlet.java
													 */
													reportId=BLReportIdMapper.getReportId(con, locale,reportId, facilityId); //Added facilityId By Subha for MMS-DM-CRF-131.1
													System.out.println("ReviseVisitServlet for Report ID "+reportId);
													
												}catch(Exception e)
												{
													e.printStackTrace();
													reportId="BLRBLPRT";
													System.err.println("Exception in ReViseVisitServlet for reportID "+e);
												}
												
												
												OnlineReport onlinereportParam = new OnlineReport(facilityId, "BL", reportId);
												onlinereportParam.addParameter("p_facility_id",facilityId);
												onlinereportParam.addParameter("p_pgm_date",pgm_date);
												onlinereportParam.addParameter("p_pgm_id",pgm_id);
												onlinereportParam.addParameter("p_Session_id",session_id);
												System.err.println("Online Report onlinereportParam:"+onlinereportParam);
												OnlineReports onlinereports = new OnlineReports();
												onlinereports.add(onlinereportParam);
												System.err.println("Online Report Added:"+onlinereports);
												String strResults =  onlinereports.execute(req,res);
												System.err.println("Online Report Executed");
												System.err.println("strResults:"+strResults);

												onlinereportParam = null;
												onlinereports = null;								
											}
											catch (Exception e)
											{
												System.err.println("Error while submitting Print Job to Report Server:"+e);
											}
										}

										String htmlFor1 = "var enter_yn ; var arr = new Array(); var dialogHeight    = '90vh' ;	 var dialogWidth = '90vw' ;	var dialogTop = '10' ;	 var center    = '1'  ;	 var arguments =   ''; var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; center:' + center +'; dialogTop:' + dialogTop +'; status=no;' ; var getUrl  = '../../eBL/jsp/BLAdhocDiscFrame.jsp?patient_id="+checkNull(req.getParameter("patient_id"))+"&episode_type=O&episode_id="+checkNull(req.getParameter("last_episode_no"))+"&visit_id="+checkNull(req.getParameter("last_visit_no"))	+"&encounter_id="+checkNull(req.getParameter("l_encounter_id"))+"&pract_id="+checkNull(req.getParameter("asn_pract_id"))+"&locn_code="+asn_locn_code+"&billgenlater="+ billgenlater+"&function_id=REVISE_VISIT&module_id=OP&visit_type_code="+ visit_type_code+"&called_frm=OTH_MOD'; if('"+billgenlater+"' == 'Y') {  var retVal = await window.showModalDialog(getUrl,arguments,features);}";

										/*
										String htmlFor1 = " <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/"
															+ sStyle
															+ "'></link></head><body class='message'><script language = 'JavaScript'>var enter_yn ; var arr = new Array(); var dialogHeight    = '40' ;	 var dialogWidth = '70' ;	var dialogTop = '100' ;	 var center    = '1'  ;	 var arguments =   ''; var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; center:' + center +'; dialogTop:' + dialogTop +'; status=no;' ; "
															+" var getUrl  = '../eBL/jsp/BLAdhocDiscFrame.jsp?patient_id="
															+checkNull(req.getParameter("patient_id"))
															+"&episode_type=O"
															+"&episode_id="
															+checkNull(req.getParameter("last_episode_no"))
															+"&visit_id="
															+checkNull(req.getParameter("last_visit_no"))
															+"&encounter_id="
															+checkNull(req.getParameter("l_encounter_id"))
															+"&pract_id="
															+checkNull(req.getParameter("asn_pract_id"))
															+"&locn_code="
															+asn_locn_code
															+"&billgenlater="
															+ billgenlater
															+"&function_id=REVISE_VISIT"
															+"&module_id=OP"
															+"&visit_type_code="
															+ visit_type_code
															//+"&blnggrp="
															//+ billing_group
															+"&called_frm=OTH_MOD"
															+"';"
															+ " if('"+billgenlater+"' == 'Y') {  var retVal = window.showModalDialog(getUrl,arguments,features);"
															+"};"
															+"</script></body></html>";
										*/

										out.println(htmlFor1);
									}
								if (!(strBLMessage.equals("0"))) {

									out.println("var blErrMsg='"+strBLMessage+"'; blErrMsg=blErrMsg.replace(/<BR>/g,'\\n'); alert(blErrMsg);");							
								}
								MessageManager mm = new MessageManager();
								final java.util.Hashtable mesg = mm.getMessage(
										locale, "RECORD_MODIFIED", "SM");
								String msg1 = (String) mesg.get("message");
								out.println("alert('" + msg1
										+ "');");
								// out.println("<html><script>alert(getMessage(\"RECORD_MODIFIED\"));</script></html>");
								if (!room_change.equals("")) {
									doOnlineReports(req, eid, facilityId,
											asn_locn_code, asn_care_locn_type,
											sStyle,locale);
								}
								out.println("parent.onSuccess();");

							} else {
								if(qms_interfaced_yn.equals("Y")){
									System.out.println("Revise Visit rolled back - 407 - cancelQMSQueueNum called");
									cancelQMSQueueNum(queue_num,(String)session.getAttribute("CUSTOMER_ID"),addedById,client_ip_address,facilityId,(String)session.getId(),checkNull(req.getParameter("patient_id")),checkNull(req.getParameter("l_encounter_id")),con);
								}
								res
										.sendRedirect("../eCommon/jsp/error.jsp?err_num="
												+ java.net.URLEncoder
														.encode(error,"UTF-8")
												+ "&err_value=0");
							}
							
							 session.removeAttribute("financial_details");
							
							argArray = null;
							paramArray = null;
							results.clear();
							tabdata.clear();
							BLtabdata.clear();
						} else if (status.equals("1")) {
							java.util.Hashtable message = MessageManager
									.getMessage(locale, "PAT_CAT_EXP", "MP");
							String msg = ((String) message.get("message"));

							res
									.sendRedirect("../eCommon/jsp/error.jsp?err_num="
											+ java.net.URLEncoder.encode(msg,"UTF-8"));

						} else if (status.equals("2")) {
							java.util.Hashtable message = MessageManager
									.getMessage(locale, "LOC_NOT_ENTITLED",
											"MP");
							String msg = ((String) message.get("message"));

							res
									.sendRedirect("../eCommon/jsp/error.jsp?err_num="
											+ java.net.URLEncoder.encode(msg,"UTF-8"));

						} else if (status.equals("3")) {
							java.util.Hashtable message = MessageManager
									.getMessage(locale, "SPL_NOT_ENTITLED",
											"MP");
							String msg = ((String) message.get("message"));

							res
									.sendRedirect("../eCommon/jsp/error.jsp?err_num="
											+ java.net.URLEncoder.encode(msg,"UTF-8"));

						} else if (status.equals("4")) {
							java.util.Hashtable message = MessageManager
									.getMessage(locale, "BDCL_NOT_ENTITLED",
											"MP");
							String msg = ((String) message.get("message"));
							res
									.sendRedirect("../eCommon/jsp/error.jsp?err_num="
											+ java.net.URLEncoder.encode(msg,"UTF-8"));

						}
					} else {
						MessageManager mm = new MessageManager();
						final java.util.Hashtable mesg = mm.getMessage(locale,
								"ROOM_WORKING_YN", "OP");
						String msg1 = (String) mesg.get("message");
						res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
								+ java.net.URLEncoder.encode(msg1,"UTF-8"));
					}
				} else {

					if (resclass.equals("P")) {
						MessageManager mm = new MessageManager();
						final java.util.Hashtable mesg = mm.getMessage(locale,
								"PRACT_WORKING_YN", "OP");
						String msg1 = (String) mesg.get("message");
						res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
								+ java.net.URLEncoder.encode(msg1,"UTF-8"));
					} else {
						MessageManager mm = new MessageManager();
						final java.util.Hashtable mesg = mm.getMessage(locale,
								"RESOURCE_NOT_WORK", "Common");
						String msg1 = (String) mesg.get("message");
						res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
								+ java.net.URLEncoder.encode(msg1,"UTF-8"));
					}
				}

			} else {
				if(qms_interfaced_yn.equals("Y")){
					System.out.println("Revise Visit rolled back - 492 cancelQMSQueueNum called");
					cancelQMSQueueNum(queue_num,(String)session.getAttribute("CUSTOMER_ID"),addedById,client_ip_address,facilityId,(String)session.getId(),checkNull(req.getParameter("patient_id")),checkNull(req.getParameter("l_encounter_id")),con);
				}
				res.sendRedirect("../eCommon/jsp/error.jsp?err_num="
						+ java.net.URLEncoder.encode(emsg,"UTF-8"));
			}
		} catch (Exception e) {
			out.println(e.toString());
			e.printStackTrace();
			if(qms_interfaced_yn.equals("Y")){
				System.out.println("Revise Visit rolled back - 502 - cancelQMSQueueNum called");
				cancelQMSQueueNum(queue_num,(String)session.getAttribute("CUSTOMER_ID"),addedById,client_ip_address,facilityId,(String)session.getId(),checkNull(req.getParameter("patient_id")),checkNull(req.getParameter("l_encounter_id")),con);
			}
		}

	}

	public boolean visittypecheck(String fid, String loc_code,
			String vtype_code, String attd_practitioner_id,
			String op_to_all_pract_yn) {

		try {

			
			int cnt = 0;
			int cnt1 = 0;
			String sql1 = "";
			String sql = "select count(*) from OP_VISIT_TYPE_FOR_CLINIC where facility_id='"+ fid+ "' and clinic_code='"+ loc_code+ "' and visit_type_code='" + vtype_code + "'";
			
			pstmt = con.prepareStatement(sql);
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
				// emsg="APP-9999 Visit Type is not applicable to this clinic";
			}

			if (insertable) {
				if (op_to_all_pract_yn.equals("N")) {

				   /*below condtion Added for this SCF ML-BRU-SCF-0732 [IN:038527]*/
				   if(!attd_practitioner_id.equals("*ALL") && !attd_practitioner_id.equals("")){
					sql1 = "select count(*) from op_visit_type a, OP_PRACT_FOR_CLINIC b where a.FACILITY_ID='"+ fid	+ "' and a.visit_type_code = '"+ vtype_code+ "' and a.facility_id=b.facility_id and b.CLINIC_CODE = '"+ loc_code+ "' and b.PRACTITIONER_ID=nvl('" + attd_practitioner_id+ "',b.PRACTITIONER_ID) and decode(a.visit_type_ind,'F',b.fi_visit_type_appl_yn, 'L',b.fu_visit_type_appl_yn,'R',b.rt_visit_type_appl_yn,'E',b.em_visit_type_appl_yn,  'S',b.sr_visit_type_appl_yn,'C',b.cs_visit_type_appl_yn)='Y' ";

					pstmt = con.prepareStatement(sql1);
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
                }else{ /*below condtion Added for this SCF ML-BRU-SCF-0732 [IN:038527]*/
				   cnt1 = cnt;
				 }

				} else {
					/*
					sql1 = "select count(*) from OP_VISIT_TYPE_FOR_CLINIC where facility_id='"
							+ fid
							+ "' and clinic_code='"
							+ loc_code
							+ "' and visit_type_code='" + vtype_code + "' ";
					*/
					cnt1 = cnt;

				}

				/*
				pstmt = con.prepareStatement(sql1);
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
					// emsg="APP-9999 Visit Type is not applicable to this
					// practitioner.";
				}
			}

		} catch (Exception e) {
			insertable = false;
			e.printStackTrace();

		}
		return insertable;
	}

	public void getData(HttpServletRequest req) {
		appt_id = req.getParameter("q_appt_ref_no");
		eid = req.getParameter("l_encounter_id");
		asn_care_locn_type = req.getParameter("asn_care_locn_type");
		assign_care_locn_code1 = req.getParameter("asn_locn_code");
		
		if (assign_care_locn_code1 != null) {
			asn_locn_code = assign_care_locn_code1.substring(0,
					assign_care_locn_code1.indexOf("|"));
		}
		
		attend_practitioner_id = req.getParameter("asn_pract_id");

	

		cur_pract_type = req.getParameter("cur_pract_type") == null ? "SS"
				: req.getParameter("cur_pract_type");
		currentRoomNumber = req.getParameter("room_cur");
		if (currentRoomNumber == null || currentRoomNumber.equals("null")
				|| currentRoomNumber.equals("NoRoom"))
			currentRoomNumber = "";
		resclass = req.getParameter("resclass");
		room_num = req.getParameter("room_num");
		if (room_num == null || room_num.equals("null")
				|| room_num.equals("NoRoom"))
			room_num = "";
		room_change = checkNull(req.getParameter("room_change"));
		other_res_code = req.getParameter("other_res_code") == null ? "" : req
				.getParameter("other_res_code");
		referal_id = req.getParameter("referal_id1") == null ? "" : req
				.getParameter("referal_id1");
		referral_id_old = req.getParameter("referral_id_old") == null ? "" : req
				.getParameter("referral_id_old");
		
		other_res_type = req.getParameter("other_res_type") == null ? "" : req
				.getParameter("other_res_type");
		appt_walk_ind = req.getParameter("appt_walk_ind") == null ? "" : req
				.getParameter("appt_walk_ind");
		queue_date = req.getParameter("queue_date") == null ? "" : req
				.getParameter("queue_date");
		queue_num = req.getParameter("queue_num").trim();
		if (queue_num == null)
			queue_num = "";
		queue_id = req.getParameter("queue_id").trim();
		if (queue_id == null)
			queue_id = "";
		visit_type_code = req.getParameter("cur_visit_type_code") == null ? ""
				: req.getParameter("cur_visit_type_code");
		addedAtWorkstation = client_ip_address;
		open_to_all_pract_yn = req.getParameter("open_to_all") == null ? ""
				: req.getParameter("open_to_all");
		if (open_to_all_pract_yn == null)
			open_to_all_pract_yn = "";
		qms_interfaced_yn=req.getParameter("qms_interfaced_yn")==null?"N":req.getParameter("qms_interfaced_yn");
		
		Sysdate = req.getParameter("Sysdate") == null ? "" : req.getParameter("Sysdate"); //this line added for this Bru-CRF-133
		queuestatus = req.getParameter("status") == null ? "" : req.getParameter("status"); //this line added for this Bru-CRF-133 
	}

	public void InsertTabdata(HttpServletRequest req) {
		tabdata.clear();
		tabdata.put("patient_id", checkNull(req.getParameter("patient_id")));		
		tabdata.put("visit_adm_type", checkNull(req
				.getParameter("visit_adm_type")));
		tabdata.put("appt_ref_no", (appt_id == null ? "" : appt_id));
		tabdata
				.put("queue_status",
						checkNull(req.getParameter("queue_status")));
		tabdata.put("visit_case", checkNull(req.getParameter("visit_case")));
		tabdata.put("l_encounter_id", (eid == null ? "" : eid));
		tabdata.put("cur_locn_code", checkNull(req
				.getParameter("cur_locn_code")));
		tabdata.put("cur_locn_desc", checkNull(req
				.getParameter("cur_locn_desc")));
		tabdata.put("cur_locn_type", checkNull(req
				.getParameter("cur_locn_type")));
		tabdata.put("cur_locn_type_desc", checkNull(req
				.getParameter("cur_locn_type_desc")));
		tabdata.put("asn_care_locn_text", checkNull(req
				.getParameter("asn_care_locn_text")));
		tabdata.put("asn_care_locn_type", (asn_care_locn_type == null ? ""
				: asn_care_locn_type));
		tabdata.put("room_num", (room_num == null ? "" : room_num));
		tabdata.put("cur_visit_type_code", visit_type_code);
		tabdata.put("cur_visit_desc", checkNull(req
				.getParameter("cur_visit_desc")));
		tabdata.put("asn_visit_type_desc", checkNull(req
				.getParameter("asn_visit_type_desc")));
		tabdata.put("asn_visit_type_code", visit_type_code);
		tabdata.put("cur_visit_type_ind", checkNull(req
				.getParameter("cur_visit_type_ind")));
		tabdata.put("cur_service_code", checkNull(req
				.getParameter("cur_service_code")));
		tabdata.put("cur_service_desc", checkNull(req
				.getParameter("cur_service_desc")));
		tabdata.put("cur_subservice_code", checkNull(req
				.getParameter("cur_subservice_code")));
		tabdata.put("cur_practitioner_id", checkNull(req
				.getParameter("cur_practitioner_id")));
		tabdata.put("cur_team_id", checkNull(req.getParameter("cur_team_id")));
		tabdata.put("cur_pract_name", checkNull(req
				.getParameter("cur_pract_name")));
		tabdata.put("cur_pract_type", (cur_pract_type == null ? "*"
				: cur_pract_type));
		tabdata
				.put("asn_pract_id",
						checkNull(req.getParameter("asn_pract_id")));
		tabdata.put("last_episode_no", checkNull(req
				.getParameter("last_episode_no")));
		tabdata.put("last_visit_no", checkNull(req
				.getParameter("last_visit_no")));
		tabdata.put("p_practitioner_name", checkNull(req
				.getParameter("p_practitioner_name")));
		tabdata.put("asn_pract_type", checkNull(req
				.getParameter("asn_pract_type")));
		tabdata.put("visit_adm_type_ind", checkNull(req
				.getParameter("visit_adm_type_ind")));
		tabdata.put("asn_locn_code", (assign_care_locn_code1 == null ? ""
				: assign_care_locn_code1));
		tabdata.put("attend_practitioner_id",
				(attend_practitioner_id == null ? "" : attend_practitioner_id));
		tabdata.put("other_res_type", other_res_type);
		tabdata.put("other_res_code", other_res_code);
		tabdata.put("referal_id", referal_id);
		tabdata.put("referral_id_old", referral_id_old);
		tabdata.put("appt_walk_ind", appt_walk_ind);
		tabdata.put("queue_date", queue_date);
		tabdata.put("queue_num", queue_num);
		tabdata.put("queue_id", queue_id);
		tabdata.put("ambulatory_status", checkNull(req
				.getParameter("ambulatory_status")));
		tabdata.put("h_visit_type_ind", checkNull(req
				.getParameter("h_visit_type_ind")));
		tabdata.put("revise_reason_code", checkNull(req
				.getParameter("revise_reason_code")));
		tabdata.put("Description", checkNull(req.getParameter("Description")));
		/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
		tabdata.put("other_remarks", checkNull(req.getParameter("other_remarks"))); 
		tabdata.put("contact_reason_code", checkNull(req.getParameter("contact_reason_code"))); 
		tabdata.put("other_reason_remarks", checkNull(req.getParameter("other_reason_remarks"))); 
		/*End ML-MMOH-CRF-1114*/
		tabdata.put("new_episode_yn", checkNull(req
				.getParameter("new_episode_yn")));
		tabdata.put("unlinkapptcaseyn", checkNull(req
				.getParameter("unlinkapptcaseyn")));
		tabdata.put("episodeReqd", checkNull(req.getParameter("episodeReqd")));
		tabdata.put("bl_interface_yn", checkNullWithDftValue(req
				.getParameter("bl_interface_yn"), "N"));
		tabdata.put("bl_install_yn", checkNullWithDftValue(req
				.getParameter("bl_install_yn"), "N"));		//Added by Manivel
		tabdata.put("visit_adm_date_time", checkNull(req
				.getParameter("visit_adm_date_time")));
		tabdata.put("process_flag", checkNullWithDftValue(req
				.getParameter("process_flag"), "N"));
		tabdata
				.put("arrival_code",
						checkNull(req.getParameter("arrival_code")));
		tabdata.put("escort_name", checkNull(req.getParameter("escort_name")));
		tabdata.put("escort_add_ln1", checkNull(req
				.getParameter("escort_add_ln1")));
		tabdata.put("escort_add_ln2", checkNull(req
				.getParameter("escort_add_ln2")));
		tabdata.put("escort_add_ln3", checkNull(req
				.getParameter("escort_add_ln3")));
		tabdata.put("escort_add_ln4", checkNull(req
				.getParameter("escort_add_ln4")));
		tabdata.put("escort_add_postal_code", checkNull(req
				.getParameter("escort_add_postal_code")));
		tabdata.put("escort_tel_num", checkNull(req
				.getParameter("escort_tel_num")));
		tabdata.put("escort_mv_reg_no", checkNull(req
				.getParameter("escort_mv_reg_no")));
		tabdata.put("encounter_type", checkNull(req
				.getParameter("encounter_type")));
		tabdata.put("emergency_details", checkNull(req
				.getParameter("emergency_details")));
		tabdata.put("client_ip_address", (addedAtWorkstation == null ? ""
				: addedAtWorkstation));		
		tabdata.put("facilityId", facilityId);
		tabdata.put("assignedServiceCode", checkNull(req
				.getParameter("service")));
		tabdata.put("assignedSubServiceCode", checkNull(req
				.getParameter("subService")));
		tabdata.put("currentRoomNumber", (currentRoomNumber == null ? ""
				: currentRoomNumber));
		tabdata.put("chg_flag", checkNull(req.getParameter("chg_flag")));

		tabdata.put("arrive_date_time", checkNull(req
				.getParameter("arrive_date_time")));
		tabdata.put("vital_signs_date_time", checkNull(req
				.getParameter("vital_signs_date_time")));
		tabdata.put("cur_specialty_code", checkNull(req
				.getParameter("cur_specialty_code")));
		tabdata.put("ident_at_checkin", checkNull(req
				.getParameter("ident_at_checkin")));
		String assign_q_num_by=checkNullWithDftValue(req.getParameter("assign_q_num_by"),"S");
		if(qms_interfaced_yn.equals("Y")){
			assign_q_num_by="M";
		}
		tabdata.put("assign_q_num_by", assign_q_num_by);
		
		tabdata.put("customerID", (String)session.getAttribute("CUSTOMER_ID"));
		tabdata.put("sessionID", (String)session.getId());
		tabdata.put("qms_interfaced_yn",qms_interfaced_yn );
		
		tabdata.put("Sysdate", checkNull(req.getParameter("Sysdate"))); //this line added for this CRF Bru-HIMS-CRF-133
		
		tabdata.put("queuestatus", checkNull(req.getParameter("status"))); //this line added for this CRF Bru-HIMS-CRF-133 
		

	}

	public void InsertBLData(HttpServletRequest req) {
		bl_interface_yn=checkNullWithDftValue(req
				.getParameter("bl_interface_yn"), "N");
		bl_install_yn=checkNullWithDftValue(req
				.getParameter("bl_install_yn"), "N"); // manivel
		BLtabdata.clear();
		BLtabdata.put("patient_id", checkNull(req.getParameter("patient_id")));
		BLtabdata.put("visit_adm_type", checkNull(req
				.getParameter("visit_adm_type")));
		BLtabdata.put("appt_ref_no", (appt_id == null ? "" : appt_id));
		BLtabdata.put("queue_status", checkNull(req
				.getParameter("queue_status")));
		BLtabdata.put("visit_case", checkNull(req.getParameter("visit_case")));
		BLtabdata.put("l_encounter_id", (eid == null ? "" : eid));
		BLtabdata.put("cur_locn_code", checkNull(req
				.getParameter("cur_locn_code")));
		BLtabdata.put("cur_locn_desc", checkNull(req
				.getParameter("cur_locn_desc")));
		BLtabdata.put("cur_locn_type", checkNull(req
				.getParameter("cur_locn_type")));
		BLtabdata.put("cur_locn_type_desc", checkNull(req
				.getParameter("cur_locn_type_desc")));
		BLtabdata.put("asn_care_locn_text", checkNull(req
				.getParameter("asn_care_locn_text")));
		BLtabdata.put("asn_care_locn_type", (asn_care_locn_type == null ? ""
				: asn_care_locn_type));
		BLtabdata.put("room_num", (room_num == null ? "" : room_num));
		BLtabdata.put("cur_visit_type_code", checkNull(req
				.getParameter("cur_visit_type_code")));
		BLtabdata.put("cur_visit_desc", checkNull(req
				.getParameter("cur_visit_desc")));
		BLtabdata.put("asn_visit_type_desc", checkNull(req
				.getParameter("asn_visit_type_desc")));
		BLtabdata.put("asn_visit_type_code", checkNull(req
				.getParameter("asn_visit_type_code")));
		BLtabdata.put("cur_visit_type_ind", checkNull(req
				.getParameter("cur_visit_type_ind")));
		BLtabdata.put("cur_service_code", checkNull(req
				.getParameter("cur_service_code")));
		BLtabdata.put("cur_service_desc", checkNull(req
				.getParameter("cur_service_desc")));
		BLtabdata.put("cur_subservice_code", checkNull(req
				.getParameter("cur_subservice_code")));
		BLtabdata.put("cur_practitioner_id", checkNull(req
				.getParameter("cur_practitioner_id")));
		BLtabdata.put("other_res_type", other_res_type);
		BLtabdata.put("other_res_code", other_res_code);
		BLtabdata.put("appt_walk_ind", appt_walk_ind);
		BLtabdata
				.put("cur_team_id", checkNull(req.getParameter("cur_team_id")));
		BLtabdata.put("cur_pract_name", checkNull(req
				.getParameter("cur_pract_name")));
		BLtabdata.put("cur_pract_type", (cur_pract_type == null ? "*"
				: cur_pract_type));
		BLtabdata.put("asn_pract_id", checkNull(req
				.getParameter("asn_pract_id")));
		BLtabdata.put("last_episode_no", checkNull(req
				.getParameter("last_episode_no")));
		BLtabdata.put("last_visit_no", checkNull(req
				.getParameter("last_visit_no")));
		BLtabdata.put("p_practitioner_name", checkNull(req
				.getParameter("p_practitioner_name")));
		BLtabdata.put("asn_pract_type", checkNull(req
				.getParameter("asn_pract_type")));
		BLtabdata.put("visit_adm_type_ind", checkNull(req
				.getParameter("visit_adm_type_ind")));
		BLtabdata.put("asn_locn_code", (assign_care_locn_code1 == null ? ""
				: assign_care_locn_code1));
		BLtabdata.put("attend_practitioner_id",
				(attend_practitioner_id == null ? "" : attend_practitioner_id));

		BLtabdata.put("ambulatory_status", checkNull(req
				.getParameter("ambulatory_status")));
		BLtabdata.put("h_visit_type_ind", checkNull(req
				.getParameter("h_visit_type_ind")));
		BLtabdata.put("revise_reason_code", checkNull(req
				.getParameter("revise_reason_code")));
		BLtabdata
				.put("Description", checkNull(req.getParameter("Description")));
		
		/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
		BLtabdata.put("other_remarks", checkNull(req.getParameter("other_remarks"))); 
		BLtabdata.put("contact_reason_code", checkNull(req.getParameter("contact_reason_code"))); 
		BLtabdata.put("other_reason_remarks", checkNull(req.getParameter("other_reason_remarks"))); 
		/*End ML-MMOH-CRF-1114*/

		BLtabdata.put("new_episode_yn", checkNull(req
				.getParameter("new_episode_yn")));
		BLtabdata.put("unlinkapptcaseyn", checkNull(req
				.getParameter("unlinkapptcaseyn")));
		BLtabdata
				.put("episodeReqd", checkNull(req.getParameter("episodeReqd")));
		BLtabdata.put("bl_interface_yn",bl_interface_yn );
		BLtabdata.put("bl_install_yn",bl_install_yn );
		BLtabdata.put("visit_adm_date_time", checkNull(req
				.getParameter("visit_adm_date_time")));
		BLtabdata.put("process_flag", checkNullWithDftValue(req
				.getParameter("process_flag"), "N"));
		BLtabdata.put("arrival_code", checkNull(req
				.getParameter("arrival_code")));
		BLtabdata
				.put("escort_name", checkNull(req.getParameter("escort_name")));
		BLtabdata.put("escort_add_ln1", checkNull(req
				.getParameter("escort_add_ln1")));
		BLtabdata.put("escort_add_ln2", checkNull(req
				.getParameter("escort_add_ln2")));
		BLtabdata.put("escort_add_ln3", checkNull(req
				.getParameter("escort_add_ln3")));
		BLtabdata.put("escort_add_ln4", checkNull(req
				.getParameter("escort_add_ln4")));
		BLtabdata.put("escort_add_postal_code", checkNull(req
				.getParameter("escort_add_postal_code")));
		BLtabdata.put("escort_tel_num", checkNull(req
				.getParameter("escort_tel_num")));
		BLtabdata.put("escort_mv_reg_no", checkNull(req
				.getParameter("escort_mv_reg_no")));
		BLtabdata.put("encounter_type", checkNull(req
				.getParameter("encounter_type")));
		BLtabdata.put("emergency_details", checkNull(req
				.getParameter("emergency_details")));
		BLtabdata.put("client_ip_address", (addedAtWorkstation == null ? ""
				: addedAtWorkstation));		

		if(bl_interface_yn.equalsIgnoreCase("Y")){

			HashMap fin_dtls=(HashMap)session.getAttribute("financial_details"); 
			BLtabdata.put("fin_dtls",(HashMap)fin_dtls);
        }
		


		BLtabdata.put("billing_class", checkNull(req
				.getParameter("billing_class")));		
		BLtabdata.put("facilityId", facilityId);
		BLtabdata.put("assignedServiceCode", checkNull(req
				.getParameter("service")));
		BLtabdata.put("assignedSubServiceCode", checkNull(req
				.getParameter("subService")));
		BLtabdata.put("currentRoomNumber", (currentRoomNumber == null ? ""
				: currentRoomNumber));
		BLtabdata.put("chg_flag", checkNull(req.getParameter("chg_flag")));

		BLtabdata.put("arrive_date_time", checkNull(req
				.getParameter("arrive_date_time")));
		BLtabdata.put("vital_signs_date_time", checkNull(req
				.getParameter("vital_signs_date_time")));
		BLtabdata.put("cur_specialty_code", checkNull(req
				.getParameter("cur_specialty_code")));
		BLtabdata.put("ident_at_checkin", checkNull(req
				.getParameter("ident_at_checkin")));
	}

	/*
	 * This function is used for Online Report generaiton.
	 */
	private void doOnlineReports(HttpServletRequest req, String encounter_id,
			String facility_id, String p_locn_code, String p_locn_type,
			String sStylerep,String locale) throws ServletException, IOException,
			SQLException {
		StringBuffer htmlFor = new StringBuffer();
		String visit_adm_type = checkNull(req.getParameter("visit_adm_type_ind"));
		htmlFor.setLength(0);

		String sqlString = "Select distinct report_id, sm_get_desc.SM_REPORT(MODULE_ID,report_id,'"+locale+"','1')report_desc, 1 no_of_copies, module_id from						op_online_report where OPERATING_FACILITY_ID='"
						+ facility_id
						+ "' and PRINT_AT_CI_YN='Y' and (clinic_code='"
						+ p_locn_code
						+ "' or clinic_code ='*All') and (VISIT_TYPE_CODE='"
						+ visit_adm_type
						+ "' OR VISIT_TYPE_CODE='*A') ";/*sm_report_lang_vw is changed to OP_online_report by Rameswar on 03-Nov-15 for HSA-CRF-0319*/

		String reportParamNames = "p_encounter_id,p_facility_id";
		String reportParamValues = "" + encounter_id + "," + facility_id + "";
		String p_patient_id = req.getParameter("patient_id");
		if (p_patient_id == null)
			p_patient_id = "";

		
		htmlFor.append("var dialogHeight    = '55vh' ;");
		htmlFor.append("var dialogWidth = '50vw' ;");
		htmlFor.append("var dialogTop = '65';");
		htmlFor.append("var arguments =   ''; ");
		htmlFor.append("var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?step=1&sqlString="
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

		htmlFor.append(" var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;");
		htmlFor.append("  retVal            =  await  window.showModalDialog(getUrl,arguments,features); ");
		
		out.println(htmlFor.toString());

		htmlFor.setLength(0);
	}

	public HashMap ifPractitionerWorkingYN(String facid,
			String assign_care_locn_code, String attnd_pract_id, Connection conn)
			throws Exception {
		if(attnd_pract_id.equals("*ALL")) attnd_pract_id="";	//this line added for this incident  [IN:038527]
		String fileCreateSql = "{call GET_WORKING_DAY_YN(?,?,?,sysdate,?,?)}";
		String practWorkingYN = "N";
		HashMap hashFILE_NO_EXISTS = new HashMap();
		CallableStatement fileCreateCS = conn.prepareCall(fileCreateSql);
		fileCreateCS.setString(1, facid);
		fileCreateCS.setString(2, assign_care_locn_code);
		fileCreateCS.setString(3, attnd_pract_id);
		fileCreateCS.registerOutParameter(4, java.sql.Types.VARCHAR);
		fileCreateCS.registerOutParameter(5, java.sql.Types.VARCHAR);
		try {
			fileCreateCS.execute();
			practWorkingYN = fileCreateCS.getString(4);
			if (practWorkingYN == null)
				practWorkingYN = "N";
			hashFILE_NO_EXISTS.put("practWorkingYN", practWorkingYN);
			String P_ERR_MSG = fileCreateCS.getString(5);
			if (P_ERR_MSG == null)
				P_ERR_MSG = "";
			hashFILE_NO_EXISTS.put("P_ERR_MSG", P_ERR_MSG);
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			fileCreateCS.close();
		}
		return hashFILE_NO_EXISTS;
	}//end of File_No_ExistsCall

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
				System.out.println("Before sending param to QMSInterface cancelTicket from ReviseVisit : "+audit_params.toString());
				eOP.QMSInterface.cancelQueueNumber(queue_num,audit_params,con);
			}
		}catch(Exception ex){
			System.out.println("Error during call to QMS");
			ex.printStackTrace();
		}
	}

}//E.O.insertReviseVisit

