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
import eOP.PatCheckout.*;

import eBL.BLReportIdMapper;
import ecis.utils.OnlineReport;
import ecis.utils.OnlineReports;
import eCommon.XSSRequestWrapper;



public class PatCheckoutServlet extends javax.servlet.http.HttpServlet {

	PrintWriter out;
	java.util.Properties p;

		String called_from="";
        String  p_patient_id="";
        String  p_locn_code="";
		String encounter_id="";
        long    p_encounter_id=0;
        String  CertIssued="N";
		String  DECEASED_YN="N";
        String facilityId;
        String client_ip_address;
		String sStyle = "";
        String function_mode="";
		String episode_type="";
        String reg_reff_chkout_yn="";
	    String clo_pat_chkout_yn="";
	     String wname="";
		 String option_id = "";
		 String close_chart_yn = "";
		 String allow_chkout_with_bill_stmt_yn = "";
		 double 	billtotalamt_d			 = 0.0;
		 String billdocnum ="";
	/*String called_from = "";

	String p_patient_id = "";

	String p_locn_code = "";

	String encounter_id = "";

	long p_encounter_id = 0;

	String x_tocomeback = "";

	String x_comebackon = "";

	String x_conclude = "";

	String x_conclude_episode_notes = "";

	String x_conclude_episode_start_date = "";

	String x_conclude_episode_end_date = "";

	String concluded_yn = "";

	String SickLeaveDetails = "";

	String SickLeaveRecordFlag = "";

	String LeaveFrom = "";

	String LeaveTo = "";

	String FitForDuty = "";

	String FitonDuty = "";

	String CertIssued = "N";

	String AuthorizedById = "";

	String remarks = "";

	String DECEASED_YN = "N";

	String mcNo = "";

	String employmentDetails = "";

	String facilityId;

	String client_ip_address;

	String function_mode = "";

	String certificate_type = "";

	String issued_date = "";

	String medical_yn = "";

	String surgical_yn = "";

	String mlc_yn = "";

	String deceased_date_time = "";


	String released_date_time = "";

	String pm_yn = "";

	String high_risk_yn = "N";

	String brought_dead_yn = "";*/
  //  String visit_type_code="";
	 Connection con=null;
	 PreparedStatement pstmt=null;
	 ResultSet rset=null;
	String bl_install_yn="";
	String modified_date_old="";
	String date_check_flag="";
	HashMap tabdata = new HashMap();
	CallableStatement cs = null;
	String user_id="";
	Statement stmt = null;
	//Below Added by Mano against ML-MMOH-CRF-0611
	boolean refReqPat;
	//End of Mano CRF-0611
	//HashMap tabdata = new HashMap();

//	String 1/29/2008 = "";

//	String episode_id = "";

//	String episode_visit_num = "";

	// String prn_visit_before="";
	// String prn_visit_yn="";
	String locale = "";
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
		this.p = (java.util.Properties) session.getValue("jdbc");
		this.client_ip_address = p.getProperty("client_ip_address");
		this.user_id = (String) session.getValue("login_user");
		function_mode = req.getParameter("function_name");
		if (function_mode == null)
			function_mode = "";
		CertIssued = "N";
		DECEASED_YN = "N";
		locale = p.getProperty("LOCALE");
		try {
			con = ConnectionManager.getConnection(req);
			/* below Added by Mano against ML-MMOH-CRF-0611 */
			refReqPat =eCommon.Common.CommonBean.isSiteSpecific(con, "OP","REF_REQUIRED_PATIENT");
			/* End of Mano ML-MMOH-CRF-0611 */
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
		    out.println("async function callPatCheckoutHTML() { ");
					
			if (function_mode != null && function_mode.equals("print")) {
				printRegPatReferral(res);
			} else if(function_mode.equals("cancelChkout")) {
						updateCancelCheckout(req, res);
				}
				else {
				updatePatCheckout(req, res);

				}
			
			out.println("} callPatCheckoutHTML();</script></body></html>");
		} catch (Exception e) {
			out.println("error in doPost" + e.toString());			
			e.printStackTrace() ;
		}finally{
			if (con != null){
				ConnectionManager.returnConnection(con,req);
			}
		}
	}

	private void updatePatCheckout(HttpServletRequest req,
			HttpServletResponse res) {

		try {
			String module_id = checkNull(req.getParameter("module_id"));   //Added by Mano ML-MMOH-CRF-0611
			
			called_from = req.getParameter("called_from");
			if (called_from == null)
				called_from = "";
			encounter_id = req.getParameter("Encounter").trim();
			p_encounter_id = (Long.valueOf(encounter_id)).longValue();
			p_patient_id = req.getParameter("P_patient_id");
			p_locn_code = req.getParameter("P_locn_code");
			episode_type = req.getParameter("episode_type");
            reg_reff_chkout_yn=req.getParameter("reg_reff_chkout_yn");
			option_id = req.getParameter("option_id")==null?"":req.getParameter("option_id");
			close_chart_yn = req.getParameter("close_pat_chart_on_checkout_yn")==null?"":req.getParameter("close_pat_chart_on_checkout_yn");
            allow_chkout_with_bill_stmt_yn = req.getParameter("allow_chkout_with_bill_stmt_yn")==null?"N":req.getParameter("allow_chkout_with_bill_stmt_yn");
			modified_date_old = req.getParameter("modified_date_old")==null?"":req.getParameter("modified_date_old");
			try{
					pstmt=con.prepareStatement("select case when to_date(?,'dd/mm/yyyy hh24:mi:ss') < modified_date then 'true'  else 'false'  end as flag from pr_encounter where encounter_id=? and facility_id=?");
					pstmt.setString(1,modified_date_old);
					pstmt.setString(2,encounter_id);
					pstmt.setString(3,facilityId);
					rset=pstmt.executeQuery();
					if(rset != null ){
						if(rset.next()){
								date_check_flag=rset.getString("flag")==null?"":rset.getString("flag");
							}
					}
					if(pstmt != null) pstmt.close();
					if(rset != null) rset.close();
			   }catch(Exception e){e.printStackTrace();}			   

			   if(date_check_flag.equals("true")){
				   java.util.Hashtable message = MessageManager.getMessage( locale, "ENC_ALREADY_MODIFIED","MR" ) ;
					String msg = (String) message.get("message");
				   out.println("alert('"+msg+"');parent.window.close();");
				   

			   }else{			  


			
            
			InsertTabdata(req);
            
			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter(
					"LOCAL_EJBS") != null)
					&& (getServletConfig().getServletContext()
							.getInitParameter("LOCAL_EJBS")
							.equalsIgnoreCase("TRUE")))
				local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance()
					.getHome("java:comp/env/PatCheckoutManager",
							PatCheckoutManagerHome.class, local_ejbs);
			Object busObj = (home.getClass().getMethod("create", null)).invoke(
					home, null);
               
			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabdata;
			Class[] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			java.util.HashMap results = (java.util.HashMap) (busObj.getClass()
					.getMethod("updatePatCheckout", paramArray)).invoke(busObj,
					argArray);
			(busObj.getClass().getMethod("remove", null)).invoke(busObj, null);
			boolean inserted = (((Boolean) results.get("status"))
					.booleanValue());
			String error = (String) results.get("error");
           

			String strBLMessage = "0";
			try {
				strBLMessage = (String) results.get("bl_message");

				if ((strBLMessage == null) || strBLMessage.equals(" ")) {
					strBLMessage = "0";
				}
			} catch (Exception exceptionBL) {
				strBLMessage = "0";
			}
			if (inserted) {
				if (bl_install_yn.equals("Y")) {

					String billAlreadyPrinted = "N";
					String billgenlater = (String) results.get("billgenlater");
					String billtotalamt = (String) results.get("billtotalamt");
					if(billgenlater == null) billgenlater="N";
					if(billtotalamt == null || billtotalamt.equals("") || billtotalamt.equals("null")) 				billtotalamt="0";
					billtotalamt_d		 = Double.parseDouble(billtotalamt);
					String billdoctype = (String) results.get("billdoctype");
					billdocnum = (String) results.get("billdocnum");
					if(billdoctype == null) billdoctype="";
					if(billdocnum == null) billdocnum="";
// blng_grp,  slmt_reqd_yn,
					String str_bill_prt_format_YN = (String) results.get("bill_prt_format_YN");	
					if(str_bill_prt_format_YN == null || str_bill_prt_format_YN.equals("")) str_bill_prt_format_YN="N";
					String str_bill_prt_format_vals = (String) results.get("bill_prt_format_vals");	
					if(str_bill_prt_format_vals==null || (("null").equals(str_bill_prt_format_vals))) str_bill_prt_format_vals="";
						
						if(str_bill_prt_format_YN.equals("Y") && !(("").equals(str_bill_prt_format_vals)))
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
							
							//Added By Vijay For MMS-QF-CRF-0208
									String reportId = "BLRBLPRT";

								try {
									/* BLReportIdMapper.getReportId function used in other modules also
									 * eAE - AEManagePatientServlet.java, AERegisterAttnServlet.java
									 * eBL - BLAdhocDiscSubmit.jsp, BLBillSlmtValidation.jsp, BLPatRegValidation.jsp, BLReprintReportHdr.jsp, BLStoreBillSlmtMain.jsp
									 * eMP - PatientRegistrationServlet.java
									 * eOP - PatCheckoutServlet.java, QmgmtRe_AssignPractServlet.java, ReviseVisitServlet.java, VisitRegistrationServlet.java
									 */
									reportId = BLReportIdMapper.getReportId(
											con, locale, reportId, facilityId); //Added facilityId By Subha for MMS-DM-CRF-131.1
									System.out.println("PatCheckoutServlet for Report ID " + reportId);

								} catch (Exception e) {
									e.printStackTrace();
									reportId = "BLRBLPRT";
									System.err
											.println("Exception in PatCheckOutServlet for reportID "
													+ e);
								}

							
							
							/*Added by Rajesh V for ML-MMOH-CRF-0753*/
							PreparedStatement pstmtBill = null;;
							ResultSet rsBill = null;
							Boolean printRequired = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BILL_PRINT_NOT_REQD");
							String bill_print_reqd = "";
							int docNum = 0;
							if(printRequired){
								try{
									pstmtBill = con.prepareStatement("Select blopin.op_visit_bill_print_reqd(?,?,?)  from dual ");
									docNum = Integer.parseInt(billdocnum);
									pstmtBill.setString(1,facilityId);							
									pstmtBill.setString (2,billdoctype);
									pstmtBill.setInt(3,docNum);
									rsBill = pstmtBill.executeQuery();
									 if(rsBill != null && rsBill.next()){
										 bill_print_reqd = rsBill.getString(1);
									   }
									 if("Y".equals(bill_print_reqd)) {
											OnlineReport onlinereportParam = new OnlineReport(facilityId, "BL", reportId);
											onlinereportParam.addParameter("p_facility_id",facilityId);
											onlinereportParam.addParameter("p_pgm_date",pgm_date);
											onlinereportParam.addParameter("p_pgm_id",pgm_id);
											onlinereportParam.addParameter("p_Session_id",session_id);
											OnlineReports onlinereports = new OnlineReports();
											onlinereports.add(onlinereportParam);
											String strResults =  onlinereports.execute(req,res);

											onlinereportParam = null;
											onlinereports = null;	
											billAlreadyPrinted = "Y";
									}
									}
									 catch (Exception e) {
											e.printStackTrace();
										}
										finally{
											pstmtBill = null;
											rsBill = null;
										}
							}
							else{
								OnlineReport onlinereportParam = new OnlineReport(facilityId, "BL", reportId);
								onlinereportParam.addParameter("p_facility_id",facilityId);
								onlinereportParam.addParameter("p_pgm_date",pgm_date);
								onlinereportParam.addParameter("p_pgm_id",pgm_id);
								onlinereportParam.addParameter("p_Session_id",session_id);
								OnlineReports onlinereports = new OnlineReports();
								onlinereports.add(onlinereportParam);
								String strResults =  onlinereports.execute(req,res);

								onlinereportParam = null;
								onlinereports = null;	
							}
							/*Added by Rajesh V for ML-MMOH-CRF-0753*/
							
						}
						catch (Exception e)
						{
							System.err.println("Error while submitting Print Job to Report Server:"+e);
						}
					}
                  
					String BL_USER_CHECK_FOR_CASH_COUNTER = "{call BL_USER_CHECK_FOR_CASH_COUNTER(?,?,?,?,?,?,?)}";
					cs = con.prepareCall(BL_USER_CHECK_FOR_CASH_COUNTER);
					cs.setString(1, facilityId);
					cs.setString(2, episode_type);
					cs.setString(3, user_id);
					cs.setString(4, client_ip_address);
					cs.registerOutParameter(5, java.sql.Types.VARCHAR);
					cs.registerOutParameter(6, java.sql.Types.VARCHAR);
					cs.registerOutParameter(7, java.sql.Types.VARCHAR);
					cs.execute();
					String p_cash_counter_code ="";
					p_cash_counter_code=cs.getString(5);
					if(p_cash_counter_code==null) p_cash_counter_code="";
					

					pstmt=con.prepareStatement("select nvl(chkout_no_bill_for_non_cashier,'N') vbill_not_req_YN from bl_parameters where OPERATING_FACILITY_ID=?");
					pstmt.setString(1,facilityId);
					rset=pstmt.executeQuery();
					String vbill_not_req_YN="";

					if(rset != null && rset.next()){
						vbill_not_req_YN=rset.getString("vbill_not_req_YN")==null?"":rset.getString("vbill_not_req_YN");
							
					}
					
					
					if(pstmt != null) pstmt.close();
					if(rset != null) rset.close();
					if(cs != null) cs.close();
					
					if (p_cash_counter_code.equals("") && vbill_not_req_YN.equals("Y") ) {

					}else{

						if(allow_chkout_with_bill_stmt_yn.equals("N")) {

							String htmlFor1 = "var enter_yn ; var arr = new Array(); var dialogHeight    = '90vh' ;	 var dialogWidth = '90vw' ;	var dialogTop = '100' ;	 var center    = '1'  ;	 var arguments =   ''; var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; center:' + center +'; dialogTop:' + dialogTop +'; status=no;' ; "
							+" var getUrl  = '../../eBL/jsp/BLAdhocDiscFrame.jsp?patient_id="
							+checkNull(req.getParameter("P_patient_id"))
							+"&episode_type="
							+episode_type
							+"&episode_id="
							+checkNull(req.getParameter("episode_id"))
							+"&visit_id="
							+checkNull(req.getParameter("episode_visit_num"))
							+"&encounter_id="
							+checkNull(req.getParameter("Encounter"))
							+"&pract_id="
							+checkNull(req.getParameter("P_practitioner_id"))
							+"&locn_code="
							+p_locn_code
							+"&billgenlater="
							+ billgenlater
							+"&function_id=CHECKOUT_VISIT"
							+"&module_id="
							+checkNull(req.getParameter("module_id"))
							+"&visit_type_code="
							+ checkNull(req.getParameter("visit_type_code"))
							+"&called_frm=OTH_MOD"
							+"';"
							/* below Added by PalaniNarayanan against AMS-CRF-0256 */
							+ " if('"+billgenlater+"' == 'Y') {  var retVal = await window.showModalDialog(getUrl,arguments,features);"
							+" while(retVal == undefined || retVal == 'undefined') {  var retVal = await window.showModalDialog(getUrl,arguments,features);} "
							+"};"
							/* End of PalaniNarayanan AMS-CRF-0256 */
							+"";
							out.println(htmlFor1);
					
							}else if(allow_chkout_with_bill_stmt_yn.equals("Y") && episode_type.equals("E")){
							
							String htmlFor1 = "var enter_yn ; var billdoctype='"+billdoctype+"'; var billdocnum='"+billdocnum+"'; var arr = new Array(); var dialogHeight    = '90vh' ;	 var dialogWidth = '90vw' ;	var dialogTop = '100' ;	 var center    = '1'  ;	 var arguments =   ''; var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; center:' + center +'; dialogTop:' + dialogTop +'; status=no;' ; var getUrl  = '../../eBL/jsp/BLAdhocDiscFrame.jsp?patient_id="
							+checkNull(req.getParameter("P_patient_id"))
							+"&episode_type="
							+episode_type
							+"&episode_id="
							+checkNull(req.getParameter("episode_id"))
							+"&visit_id="
							+checkNull(req.getParameter("episode_visit_num"))
							+"&encounter_id="
							+checkNull(req.getParameter("Encounter"))
							+"&pract_id="
							+checkNull(req.getParameter("P_practitioner_id"))
							+"&locn_code="
							+p_locn_code
							+"&billgenlater="
							+ billgenlater
							+"&function_id=CHECKOUT_VISIT"
							+"&module_id="
							+checkNull(req.getParameter("module_id"))
							+"&visit_type_code="
							+ checkNull(req.getParameter("visit_type_code"))
							//+"&blnggrp="
							//+ billing_group
							+"&called_frm=OTH_MOD"
							+"';"
							+ " if('"+billgenlater+"' == 'Y') {  var retVal = await window.showModalDialog(getUrl,arguments,features);"
							+" while(retVal == undefined || retVal == 'undefined') {  var retVal = await window.showModalDialog(getUrl,arguments,features);} if(retVal != ''){"
							+" arr = retVal.split('|'); billdoctype = arr[0];"
							+" billdocnum  = arr[1]; "
							+" } } "
							+"var getUrl1  = '../../eBL/jsp/BLBillSlmtMain.jsp?billdoctypecode='+billdoctype+'"
							+ "&billdocnum='+billdocnum+'"
							//+ "&blnggrp="
							//+ billing_group
							+"&billgenlater="
							+ billgenlater
							+"&allow_chkout_with_bill_stmt_yn="
							+ allow_chkout_with_bill_stmt_yn
							+"&function_id=CHECKOUT_VISIT"
							+"&episode_type="
							+episode_type
							+"&billAlreadyPrinted="
							+ billAlreadyPrinted
							+"';retVal = await window.showModalDialog(getUrl1,arguments,features);"
							+ " while(retVal == undefined || retVal == 'undefined') {retVal = await window.showModalDialog(getUrl1,arguments,features);}";

							out.println(htmlFor1);

							/*String htmlFor1 = " <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/"
							+ sStyle
							+ "'></link></head><body class='message'><script language = 'JavaScript'>var enter_yn ; var arr = new Array(); var dialogHeight    = '40' ;	 var dialogWidth = '70' ;	var dialogTop = '100' ;	 var center    = '1'  ;	 var arguments =   ''; var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; center:' + center +'; dialogTop:' + dialogTop +'; status=no;' ; "
							+" var getUrl  = '../eBL/jsp/BLCallDiscOrSlmtPage.jsp?patient_id="
							+checkNull(req.getParameter("P_patient_id"))
							+"&module_id="
							+checkNull(req.getParameter("module_id"))
							+"&bill_doc_type_code="
							+billdoctype
							+"&bill_doc_num="
							+billdocnum
							+"&call_disc_function_yn="
							+billgenlater
							+"&encounter_id="
							+checkNull(req.getParameter("Encounter"))
							+"&episode_type="
							+episode_type
							+"&episode_id="
							+checkNull(req.getParameter("episode_id"))
							+"&allow_chkout_with_bill_stmt_yn="
							+checkNull(req.getParameter("allow_chkout_with_bill_stmt_yn"))
							+"&visit_id="
							+checkNull(req.getParameter("episode_visit_num"))
							+"&pract_id="
							+checkNull(req.getParameter("P_practitioner_id"))
							+"&locn_code="
							+p_locn_code
							+"&function_id=CHECKOUT_VISIT"
							+"&visit_type_code="
							+ checkNull(req.getParameter("visit_type_code"))
							+"&called_frm=OTH_MOD"
							+"';"
							+ " var retVal = window.showModalDialog(getUrl,arguments,features);"
							+" while(retVal==undefined || retVal == 'undefined' || retVal == 'N' )	{		retVal = window.showModalDialog(getUrl, arguments, features);	} ;"
							+"</script></body></html>";
							out.println(htmlFor1);*/

						}
					}
				}

				if (!(strBLMessage.equals("0"))) {

					out.println("var blErrMsg='"+strBLMessage+"'; blErrMsg=blErrMsg.replace(/<BR>/g,'\\n');alert(blErrMsg);");
				}

				if (!option_id.equals("CHECK_OUT")) {
					//error = error.substring(0, error.length() - 4);
					out.println("alert(\"" + error
						+ "\");");
				}

				if (CertIssued.equals("Y"))
					doOnlineReports(locale);


				if (!DECEASED_YN.equals("Y")) {

					if(reg_reff_chkout_yn.equals("Y")){
						/* Below Added By Mano against ML-MMOH-CRF-0611 */
						if((refReqPat) && ((module_id.equals("OP")) || (module_id.equals("CA"))))
						{
							MessageManager mm = new MessageManager();
							final java.util.Hashtable mesg = mm.getMessage(locale,
									"REFER_REQ_PAT", "Common");
							String msg1 = (String) mesg.get("message");
							out.println("var confirmref=window.confirm('"
											+ msg1
											+ "'); if(confirmref) { await parent.frames[1].RegisterMoreReferral('"
											+ encounter_id
											+ "','"
											+ p_patient_id 
											+ "');}");
							mesg.clear();
						}
						/* End of CRF-0611 */
						else
						{
					MessageManager mm = new MessageManager();
					final java.util.Hashtable mesg = mm.getMessage(locale,
							"REG_REFERRAL", "Common");
					String msg1 = (String) mesg.get("message");
					out.println("var confirmref=window.confirm('"
									+ msg1
									+ "'); if(confirmref) {await parent.frames[1].RegisterMoreReferral('"
									+ encounter_id
									+ "','"
									+ p_patient_id
									+ "');}");
					mesg.clear();

			}	}}

				if (called_from.equals("CA") && option_id.equals("CHECK_OUT")) {

					wname = p_patient_id+encounter_id;
					out.println("<html><body onKeyDown='lockKey();'><form name='openChartWrapperIntermediateForm' method='post' action='../eCA/jsp/OpenChartWrapperIntermediate.jsp'><input type='hidden' name='patientID' value='"+p_patient_id+"'><input type='hidden' name='episodeID' value='"+encounter_id+"'><input type='hidden' name='child_window' value='Y'><input type='hidden' name='FromPatChart' value=''><input type='hidden' name='FromCloseOrSwitch' value='Close'><input type='hidden' name='windName' value='"+wname+"'></form><script>document.forms[0].submit();</script></body></html>");
					out.println("top.opener.focus();if(top.opener.location.href) {		if(top.opener.location.href.indexOf('error.jsp')!=-1) {				if(top.opener.parent.frames[1].frames[0]!=null)	{					if(top.opener.parent.frames[1].frames[0].document.forms[0].refresh!=null) {						if(top.opener.parent.frames[1].frames[0].document.forms[0].refresh) {							top.opener.parent.frames[1].frames[0].document.forms[0].refresh.click();}}}}}");

				} else if (called_from.equals("CA")) {
					out.println("parent.detail.onSuccessCloseWin('"+p_patient_id+"','"+encounter_id+"');");
				} else {
					//out.println("parent.parent.document.getElementById('dialog_tag').close();");
					out.println("parent.window.close();");
				}
			} else {

				if(error!=null && ! error.equals("null") && !error.equals(""))
				{
					//error = error.substring(0, error.length() - 4);
					if (!option_id.equals("CHECK_OUT")) {
						out.println("alert(\"" + error
								+ "\");");
					} else {
					}
				}

			}
			argArray = null;
			paramArray = null;
			session.removeAttribute("financial_details");
			results.clear();
			tabdata.clear();
		}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(!option_id.equals("CHECK_OUT"))	{
				out				.println("parent.frames[1].document.forms[0].record.disabled=false;");
			}
		}
	}

	public void InsertTabdata(HttpServletRequest req) {

//		tabdata.clear();
        String  x_tocomeback="";
        String  x_comebackon="";
        String  x_conclude="";
        String  x_conclude_episode_notes="";
        String  x_conclude_episode_start_date="";
        String  x_conclude_episode_end_date="";
        String  SickLeaveDetails="";
        String  SickLeaveRecordFlag="";
        String  LeaveFrom="";
        String  LeaveTo="";
        String  FitForDuty="";
        String  FitonDuty="";
		String  concluded_yn="";
		String medical_yn="";
		String surgical_yn="";
		String mlc_yn="";
		String deceased_date_time="";
		String released_date_time="";
		String pm_yn="";
		String x_ae_treatment_area_code="";
		String certificate_type="";
		String issued_date="";
		String high_risk_yn="N";
		String brought_dead_yn="";
		String  mcNo="";
		String  employmentDetails="";
	    String  AuthorizedById="";
        String  remarks="";
		String episode_id="";
		String episode_visit_num="";
		String disposition_date_time="";
		String didYn = ""; //Added by Thamizh selvi on 28th Nov 2017 against ML-MMOH-CRF-0783
		String invokeRecallForAE = ""; //Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657

		/*Added by Thamizh selvi on 16th Mar 2018 against ML-MM0H-CRF-645 Start*/
		String osccType					= checkNull(req.getParameter("osccType"));
		String osccYn					= checkNullWithDftValue(req.getParameter("oscc_yn"),"N");
		String OandGYn					= checkNullWithDftValue(req.getParameter("OandG_yn"),"N");
		String traumaYn					= checkNullWithDftValue(req.getParameter("trauma_yn"),"N");
		String nonEmergYn				= checkNullWithDftValue(req.getParameter("non_emerg_yn"),"N");
		String mechInjCode				= "";
		String mechInjSubCode			= "";
		String isDeathRegisterFormAppl	= checkNullWithDftValue(req.getParameter("isDeathRegisterFormAppl"), "false");
		
		if(!(("").equals(osccType))){
			StringTokenizer osccToken = new StringTokenizer(osccType, ",");
			if(osccToken.hasMoreTokens()){
				mechInjCode		= checkNull(osccToken.nextToken());
				mechInjSubCode	= checkNull(osccToken.nextToken());
			}
		}
		
		tabdata.put("mech_injury_catg_code",mechInjCode);
		tabdata.put("mech_injury_subcatg_code",mechInjSubCode);
		tabdata.put("OandGYn",OandGYn);
		tabdata.put("traumaYn",traumaYn);
		tabdata.put("nonEmergYn",nonEmergYn);
		tabdata.put("osccYn",osccYn);
		/*End*/

/*Getting Data for above Delclared Vairables Starts*/

				//visit_type_code=req.getParameter("visit_type_code")==null?"":req.getParameter("visit_type_code");
		x_ae_treatment_area_code = req.getParameter("ae_treatment_area_code");
		if (x_ae_treatment_area_code == null
				|| x_ae_treatment_area_code.equals("null"))
			x_ae_treatment_area_code = "";
		// prn_visit_yn= req.getParameter("prn_visit_yn") ==
		// null?"N":req.getParameter("prn_visit_yn");
		// prn_visit_before=
		// req.getParameter("prn_visit_before")==null?"":req.getParameter("prn_visit_before");
		SickLeaveRecordFlag = req.getParameter("SickLeaveRecordFlag") == null ? ""
				: req.getParameter("SickLeaveRecordFlag");
		SickLeaveDetails = req.getParameter("SickLeaveDetails") == null ? ""
				: req.getParameter("SickLeaveDetails");
		DECEASED_YN = req.getParameter("DECEASED_YN") == null ? "N" : req
				.getParameter("DECEASED_YN");
		x_conclude = req.getParameter("conclude");
		medical_yn = req.getParameter("medical_yn") == null ? "" : req
				.getParameter("medical_yn");
		surgical_yn = req.getParameter("surgical_yn") == null ? "" : req
				.getParameter("surgical_yn");
		mlc_yn = req.getParameter("mlc_yn") == null ? "" : req
				.getParameter("mlc_yn");
		bl_install_yn=req.getParameter("bl_install_yn")==null?"N":req.getParameter("bl_install_yn");
		deceased_date_time = req.getParameter("deceased_date_time") == null ? ""
				: req.getParameter("deceased_date_time");
          if(!deceased_date_time.equals(""))
           deceased_date_time=com.ehis.util.DateUtils.convertDate(deceased_date_time,"DMYHM",locale, "en");
		released_date_time = req.getParameter("released_date_time") == null ? ""
				: req.getParameter("released_date_time");
		if(!released_date_time.equals(""))
         released_date_time=com.ehis.util.DateUtils.convertDate(released_date_time,"DMYHM",locale, "en");
		pm_yn = req.getParameter("postmortem_yn") == null ? "" : req
				.getParameter("postmortem_yn");

		x_tocomeback = req.getParameter("tocomeback") == null ? "N" : req
					.getParameter("tocomeback");
		
			x_comebackon = req.getParameter("comebackon");
			high_risk_yn = req.getParameter("high_risk_yn") == null ? "" : req
					.getParameter("high_risk_yn");
			brought_dead_yn = req.getParameter("bdead_yn") == null ? "N" : req
					.getParameter("bdead_yn");
			episode_id = req.getParameter("episode_id") == null ? "" : req
					.getParameter("episode_id");
			episode_visit_num = req.getParameter("episode_visit_num") == null ? ""
					: req.getParameter("episode_visit_num");
			disposition_date_time = req.getParameter("disposition_date_time1") == null ? ""
					: req.getParameter("disposition_date_time1");
			didYn = req.getParameter("did_hid") == null ? "N" : req.getParameter("did_hid"); //Added by Thamizh selvi on 28th Nov 2017 against ML-MMOH-CRF-0783
			
		/*Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657*/
		invokeRecallForAE = req.getParameter("invokeRecallForAE") == null ? "N" : req.getParameter("invokeRecallForAE");
		String module_id = checkNull(req.getParameter("module_id"));

		if (x_tocomeback.equals("Y")) {

			if(module_id.equals("AE") && invokeRecallForAE.equals("Y"))
			{
				x_comebackon = req.getParameter("dat_val") == null ? "" : req.getParameter("dat_val");
				if(!x_comebackon.equals(""))
				 x_comebackon=com.ehis.util.DateUtils.convertDate(x_comebackon,"DMYHM",locale, "en");
			}else
			{
			GregorianCalendar cal = new GregorianCalendar();
			String days_unit = req.getParameter("days_unit");
			int totnum = Integer.parseInt(req.getParameter("dat_val"));
			int unit_val = 0;
			if (days_unit.equals("Y"))
				unit_val = Calendar.YEAR;
			if (days_unit.equals("M"))
				unit_val = Calendar.MONTH;
			if (days_unit.equals("D"))
				unit_val = Calendar.DAY_OF_YEAR;
			if (days_unit.equals("W")) {
				totnum = totnum * 7;
				unit_val = Calendar.DAY_OF_YEAR;
			}
			cal.add(unit_val, +totnum);
			x_comebackon = String.valueOf(cal.get(Calendar.DATE)) + "/"
					+ String.valueOf(cal.get(Calendar.MONTH) + 1) + "/"
					+ String.valueOf(cal.get(Calendar.YEAR));
			}
		}
		if (SickLeaveRecordFlag.equals("Y")) {
			StringTokenizer token1 = new StringTokenizer(SickLeaveDetails, "~");
			LeaveFrom = token1.nextToken();
			LeaveTo = token1.nextToken();
			FitForDuty = token1.nextToken();
			CertIssued = token1.nextToken();
			AuthorizedById = token1.nextToken();
			certificate_type = token1.nextToken();
			issued_date = token1.nextToken();
			if (issued_date.equals("||"))
				issued_date = "";
			remarks = token1.nextToken();
			if (remarks.equals("||"))
				remarks = "";
			FitonDuty = token1.nextToken();
			if (FitonDuty.equals("||"))
				FitonDuty = "";
			token1.nextToken();
			mcNo = token1.nextToken();
			if (mcNo.equals("||"))
				mcNo = "";
			employmentDetails = token1.nextToken();
			if (employmentDetails.equals("||"))
				employmentDetails = "";
		}
		if (!(x_conclude == null || x_conclude.equals(""))) {
			StringTokenizer token = new StringTokenizer(x_conclude, "#");
			int counter = token.countTokens();
			String concl_tokens[] = new String[counter];
			int track = 0;
			while (token.hasMoreTokens()) {
				concl_tokens[track] = token.nextToken();
				track++;
			}
			concluded_yn = concl_tokens[0];
			x_conclude_episode_start_date = concl_tokens[2];
			x_conclude_episode_end_date = concl_tokens[3];
			x_conclude_episode_notes = concl_tokens[4];
		}
		//Mahesh added
		//String facility_id="";
			//String encounter_id="";
			
			String visit_status="";
			String patient_id="";
			String assign_care_locn_code="";
			String service_code="";
			String subservice_code="";
			//String visit_adm_date_time="";
			String start_date_time="";
			
			String last_visit_date="";
			String last_visit_fu_reqd_yn="";
			String op_episode_visit_num="";
			String last_visit_num="";
			String end_date_time="";
			String episode_status="";
			String ae_episode_yn="";
			String practitioner_id="";       //added by Sangeetha for MMS-DM-SCF-0303
			String episode_id1="";
			String mode="";
			int episode_serv_cnt =0;
			int last_visit_serv_cnt =0;
			String patient_class=checkNull(req.getParameter("patient_class")); //Mahesh
			String visit_compl_days=checkNull(req.getParameter("visit_compl_days")); //Mahesh
			if(patient_class.equals("EM"))
			mode ="EC";
			if(patient_class.equals("OP"))
			mode = "OC";
			//End
			try{
			
		/*if(bl_install_yn.equalsIgnoreCase("Y"))
			{
		//String sql="select facility_id, encounter_id, visit_status,patient_id,assign_care_locn_code,service_code, subservice_code,visit_adm_date_time start_date_time,visit_adm_date_time last_visit_date, 'n' last_visit_fu_reqd_yn,	op_episode_visit_num  last_visit_num,discharge_date_time  end_date_time,'01' episode_status , decode(patient_class,'op','n','y') ae_episode_yn,episode_id   from pr_encounter a   where facility_id = ?  and trunc(visit_adm_date_time) < trunc(sysdate - ?) and visit_status < '07'   and patient_class = ? and mr_mds_recorded_yn (a.facility_id,a.encounter_id, a.patient_class,null,?,null  ) = 'y' and blopin.visit_auto_close_yn (facility_id, assign_care_locn_code,  visit_adm_type, attend_practitioner_id,  encounter_id) = 'y'";
       // pstmt = con.prepareStatement(sql.toString());
		//pstmt.setString(1,facilityId);
		//pstmt.setString(2,visit_compl_days);
		//pstmt.setString(3,patient_class);
		//pstmt.setString(4,mode);

		//Modified by sangeetha for MMS-DM-SCF-0303 --START--
			String sql ="SELECT QUEUE_STATUS visit_status,service_code, subservice_code,TO_CHAR(QUEUE_DATE,'dd/mm/yyyy hh24:mi:ss') START_DATE_TIME, TO_CHAR(QUEUE_DATE,'dd/mm/yyyy hh24:mi:ss') LAST_VISIT_DATE,'N'LAST_VISIT_FU_REQD_YN,OP_EPISODE_VISIT_NUM  LAST_VISIT_NUM,TO_CHAR(DISCHARGE_DATE_TIME  ,'dd/mm/yyyy hh24:mi:ss') END_DATE_TIME,'01' EPISODE_STATUS,decode(patient_class,'OP','N','Y') AE_EPISODE_YN,PRACTITIONER_ID FROM op_patient_queue WHERE facility_id = ? AND encounter_id = ?";
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1,facilityId);
			pstmt.setString(2,encounter_id);        //--END--
        
		
		rset=pstmt.executeQuery();
		
		if(rset.next())
			{
			
			visit_status=rset.getString("visit_status");
			service_code=rset.getString("service_code");
			subservice_code=rset.getString("subservice_code");
			start_date_time=rset.getString("start_date_time");
			last_visit_date=rset.getString("last_visit_date");
			last_visit_fu_reqd_yn=rset.getString("last_visit_fu_reqd_yn");
			last_visit_num=rset.getString("last_visit_num");
			end_date_time=rset.getString("end_date_time");
			episode_status=rset.getString("episode_status");
			ae_episode_yn=rset.getString("ae_episode_yn");
			practitioner_id=rset.getString("practitioner_id");    //added by sangeetha for MMS-DM-SCF-0303
			
			}
			if(pstmt != null) pstmt.close();
			if(rset != null) rset.close();
					
			}
		else
			{  */
			//String sql="SELECT facility_id,encounter_id,visit_status,PATIENT_ID,ASSIGN_CARE_LOCN_CODE,SERVICE_CODE,SUBSERVICE_CODE,VISIT_ADM_DATE_TIME START_DATE_TIME,VISIT_ADM_DATE_TIME LAST_VISIT_DATE, 'N'LAST_VISIT_FU_REQD_YN,OP_EPISODE_VISIT_NUM  LAST_VISIT_NUM, DISCHARGE_DATE_TIME  END_DATE_TIME,'01' EPISODE_STATUS , decode(patient_class,'OP','N','Y') AE_EPISODE_YN,EPISODE_ID  FROM pr_encounter a  WHERE facility_id = ? AND trunc(visit_adm_date_time) < trunc(SYSDATE - ?)  AND visit_status < '07'  AND patient_class = ? AND mr_mds_recorded_yn (a.facility_id, a.encounter_id, a.patient_class, NULL,?, NULL ) = 'Y'";

        //commented by Sangeetha for MMS-DM-SCF-0303
			//String sql="SELECT facility_id,encounter_id,visit_status,PATIENT_ID,ASSIGN_CARE_LOCN_CODE,SERVICE_CODE,SUBSERVICE_CODE, TO_CHAR(a.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi:ss') START_DATE_TIME, TO_CHAR(a.VISIT_ADM_DATE_TIME ,'dd/mm/yyyy hh24:mi:ss') LAST_VISIT_DATE, 'N'LAST_VISIT_FU_REQD_YN,OP_EPISODE_VISIT_NUM  LAST_VISIT_NUM,TO_CHAR(a. DISCHARGE_DATE_TIME  ,'dd/mm/yyyy hh24:mi:ss') END_DATE_TIME,'01' EPISODE_STATUS , decode(patient_class,'OP','N','Y') AE_EPISODE_YN,EPISODE_ID  FROM pr_encounter a  WHERE facility_id = ? AND trunc(visit_adm_date_time) < trunc(SYSDATE - ?)  AND visit_status < '07'  AND patient_class = ? AND mr_mds_recorded_yn (a.facility_id, a.encounter_id, a.patient_class, NULL,?, NULL ) = 'Y'";

        //Modified by sangeetha for MMS-DM-SCF-0303 --START--
			String sql ="SELECT QUEUE_STATUS visit_status,service_code, subservice_code,TO_CHAR(QUEUE_DATE,'dd/mm/yyyy hh24:mi:ss') START_DATE_TIME, TO_CHAR(QUEUE_DATE,'dd/mm/yyyy hh24:mi:ss') LAST_VISIT_DATE,'N'LAST_VISIT_FU_REQD_YN,OP_EPISODE_VISIT_NUM  LAST_VISIT_NUM,TO_CHAR(DISCHARGE_DATE_TIME  ,'dd/mm/yyyy hh24:mi:ss') END_DATE_TIME,'01' EPISODE_STATUS,decode(patient_class,'OP','N','Y') AE_EPISODE_YN,PRACTITIONER_ID FROM op_patient_queue WHERE facility_id = ? AND encounter_id = ?";
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1,facilityId);
			pstmt.setString(2,encounter_id);        //--END--
			
			rset=pstmt.executeQuery();
			if(rset.next())
				{
				visit_status=rset.getString("visit_status");
				//patient_id=rset.getString("patient_id");
				//assign_care_locn_code=rset.getString("assign_care_locn_code");
				service_code=rset.getString("service_code");
				subservice_code=rset.getString("subservice_code");
				//visit_adm_date_time=rset.getString("visit_adm_date_time");
				start_date_time=rset.getString("start_date_time");
				last_visit_date=rset.getString("last_visit_date");
				last_visit_fu_reqd_yn=rset.getString("last_visit_fu_reqd_yn");
				//op_episode_visit_num=rset.getString("op_episode_visit_num");
				last_visit_num=rset.getString("last_visit_num");
				end_date_time=rset.getString("end_date_time");
				episode_status=rset.getString("episode_status");
				ae_episode_yn=rset.getString("ae_episode_yn");
				practitioner_id=rset.getString("practitioner_id");    //added by sangeetha for MMS-DM-SCF-0303
				
				}
			if(pstmt != null) pstmt.close();
			if(rset != null) rset.close();
			//}	//end of else
					
			String sql1="select count(*) as  v_cnt from op_episode_for_service where PATIENT_ID= ? and operating_facility_id= ? and EPISODE_ID=?";
			pstmt = con.prepareStatement(sql1.toString());
			pstmt.setString(1,p_patient_id);
			pstmt.setString(2,facilityId);
			pstmt.setString(3,episode_id.trim());
			rset=pstmt.executeQuery();
			if(rset.next())
				{
				episode_serv_cnt =rset.getInt("v_cnt");
				
				}
			if(pstmt != null) pstmt.close();
			if(rset != null) rset.close();
			
			String sql2="select count(*) as v_cnt1 from op_last_visit_for_service where service_code= ? and operating_facility_id= ? and patient_id=?";
			pstmt = con.prepareStatement(sql2.toString());
			pstmt.setString(1,service_code);
			pstmt.setString(2,facilityId);
			pstmt.setString(3,p_patient_id);
			rset=pstmt.executeQuery();
			if(rset.next())
				{
				last_visit_serv_cnt =rset.getInt("v_cnt1");
				
				}
			if(pstmt != null) pstmt.close();
			if(rset != null) rset.close();
			tabdata.put("visit_status", visit_status);
			tabdata.put("service_code", service_code );
			tabdata.put("subservice_code", checkNull(subservice_code));
			//tabdata.put("visit_adm_date_time", visit_adm_date_time);
			tabdata.put("start_date_time", checkNull(start_date_time));
			tabdata.put("last_visit_date", checkNull(last_visit_date));
			tabdata.put("last_visit_fu_reqd_yn", checkNull(last_visit_fu_reqd_yn));
			tabdata.put("last_visit_num", last_visit_num);
			tabdata.put("end_date_time", checkNull(end_date_time));
			tabdata.put("episode_status", episode_status);
			tabdata.put("ae_episode_yn", checkNull(ae_episode_yn));
            tabdata.put("practitioner_id", checkNull(practitioner_id));   // added by Sangeetha for MMS-DM-SCF-0303
 			tabdata.put("episode_serv_cnt", episode_serv_cnt);
			tabdata.put("last_visit_serv_cnt", last_visit_serv_cnt);
		}
		catch(Exception e)
			{
			e.printStackTrace();
			}
		//End


		if(bl_install_yn.equalsIgnoreCase("Y")){
			HashMap fin_dtls=(HashMap)session.getAttribute("financial_details");
			if (fin_dtls == null) {
			    // Handle the case where fin_dtls is null
			    tabdata.put("fin_dtls", new HashMap()); // or some other default value
			} else {
			    // fin_dtls is not null, safe to put it in tabdata
			    tabdata.put("fin_dtls", fin_dtls);
			}
			//tabdata.put("fin_dtls",(HashMap)fin_dtls);
			//fin_dtls.clear();
		}
	/*Getting Data for above Delclared Vairables Ends*/


		tabdata.put("facilityId", facilityId);
		tabdata.put("p_patient_id", p_patient_id);
		tabdata.put("p_locn_type", checkNull(req.getParameter("P_locn_type")));
		tabdata.put("p_locn_code", p_locn_code);
		tabdata.put("encounter_id", encounter_id);
		tabdata.put("p_practitioner_id", checkNull(req
				.getParameter("P_practitioner_id")));
		tabdata.put("x_circumstance_of_injury", checkNull(req
				.getParameter("circumstance_of_injury")));
		tabdata.put("x_attending_practitioner", checkNull(req
				.getParameter("attending_practitioner")));
		tabdata.put("x_inv_ordered1", checkNull(req
				.getParameter("inv_ordered1")));
		tabdata.put("x_inv_ordered2", checkNull(req
				.getParameter("inv_ordered2")));
		tabdata.put("x_inv_ordered3", checkNull(req
				.getParameter("inv_ordered3")));
		tabdata.put("x_disposition_date_time", checkNull(req
				.getParameter("disposition_date_time1")));
		tabdata.put("x_disposition_type", checkNull(req
				.getParameter("disposition_type")));
		tabdata.put("x_tocomeback", x_tocomeback);
		tabdata.put("x_comebackon", x_comebackon);
		//Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657
		tabdata.put("invokeRecallForAE", invokeRecallForAE);
		tabdata.put("x_reason", checkNull(req.getParameter("reason")));
		tabdata.put("x_instructionsrecall", checkNull(req
				.getParameter("instructionsrecall")));
		tabdata.put("x_conclude_episode_notes", x_conclude_episode_notes);
		tabdata.put("x_conclude_episode_start_date",
				x_conclude_episode_start_date);
		tabdata.put("x_conclude_episode_end_date", x_conclude_episode_end_date);
		tabdata.put("pract_assigned_yn", checkNull(req
				.getParameter("pract_assigned_yn")));
		tabdata.put("concluded_yn", concluded_yn);
		tabdata.put("medical_yn", medical_yn);
		tabdata.put("surgical_yn", surgical_yn);
		tabdata.put("mlc_yn", mlc_yn);
		tabdata.put("high_risk_yn", high_risk_yn);
		tabdata.put("deceased_date_time", deceased_date_time);
		tabdata.put("released_date_time", released_date_time);
		tabdata.put("pm_yn", pm_yn);
		tabdata.put("brought_dead_yn", brought_dead_yn);
		tabdata.put("didYn", didYn);//Added by Thamizh selvi on 28th Nov 2017 against ML-MMOH-CRF-0783
		tabdata.put("episode_id", episode_id.trim());
		tabdata.put("episode_visit_num", episode_visit_num.trim());

		tabdata.put("client_ip_address", client_ip_address);
		tabdata.put("prn_visit_yn", checkNullWithDftValue(req
				.getParameter("prn_visit_yn"), "N"));
		tabdata.put("prn_visit_before", checkNull(req
				.getParameter("prn_visit_before")));
		tabdata.put("x_module_id", checkNull(req.getParameter("module_id")));
		tabdata.put("x_ae_treatment_area_code", checkNull(req
				.getParameter("ae_treatment_area_code")));
		tabdata
				.put("p_queue_date",
						checkNull(req.getParameter("p_queue_date")));
		tabdata.put("SickLeaveRecordFlag", SickLeaveRecordFlag);
		tabdata.put("LeaveFrom", LeaveFrom);
		tabdata.put("LeaveTo", LeaveTo);
		tabdata.put("FitForDuty", FitForDuty);
		tabdata.put("FitonDuty", FitonDuty);
		tabdata.put("CertIssued", CertIssued);
		tabdata.put("AuthorizedById", AuthorizedById);
		tabdata.put("remarks", remarks);
		tabdata.put("DECEASED_YN", DECEASED_YN);
		tabdata.put("mcNo", mcNo);
		tabdata.put("employmentDetails", employmentDetails);
		tabdata.put("issued_date", issued_date);
		tabdata.put("certificate_type", certificate_type);
		tabdata.put("dispReqd", checkNull(req.getParameter("dispReqd")));
		tabdata.put("diagReqd", checkNull(req.getParameter("diagReqd")));
		tabdata.put("notesReqd", checkNull(req.getParameter("notesReqd")));
		tabdata.put("arrive_date_time", checkNull(req
				.getParameter("arrive_date_time")));
		tabdata.put("vital_signs_date_time", checkNull(req
				.getParameter("vital_signs_date_time")));
		tabdata.put("i_appt_ref_no", checkNull(req
				.getParameter("i_appt_ref_no")));
		tabdata.put("visit_adm_type_ind", checkNull(req
				.getParameter("visit_adm_type_ind")));
		tabdata.put("bl_install_yn",bl_install_yn );
		tabdata.put("pract_type", checkNull(req.getParameter("pract_type")));
		tabdata.put("pract_speciality", checkNull(req
				.getParameter("pract_speciality")));
		tabdata.put("visit_type_code", checkNull(req
				.getParameter("visit_type_code")));
		tabdata.put("multi_speciality_yn", checkNull(req	.getParameter("multi_speciality_yn")));//Added for the CRF - Bru-HIMS-CRF-0198
		/*
			scrum relatted crf-362 added for Bed charges
		*/
		tabdata.put("ae_treatment_area_code", checkNull(req
				.getParameter("ae_treatment_area_code")));
				
		tabdata.put("isPatientEncMovement", checkNull(req.getParameter("isPatientEncMovement"))); //this line added for this CRF Bru-HIMS-CRF-133
        tabdata.put("Sydate", checkNull(req.getParameter("Sydate"))); //this line added for this CRF Bru-HIMS-CRF-133 
		tabdata.put("patient_class", checkNull(req.getParameter("patient_class"))); //Mahesh
		//tabdata.put("visit_compl_days", checkNull(req.getParameter("visit_compl_days"))); //Mahesh
		      
			  
		/*Added by Ajay Hatwate for AAKH-CRF-0179*/
		tabdata.put("isDeathRegisterFormAppl", isDeathRegisterFormAppl);
		tabdata.put("enable_death_reg_form", checkNullWithDftValue(req.getParameter("enable_death_reg_form"), "N")); 
		if(isDeathRegisterFormAppl.equals("true")){
			tabdata.put("death_reg_form_accession_num", checkNull(req.getParameter("death_reg_form_accession_num")));	
		}
	
	}

/*	public void getData(HttpServletRequest req) {



	}*/

	public void printRegPatReferral(HttpServletResponse res) {
		res.setContentType("text/html");
	}

	private void doOnlineReports(String locale ) throws ServletException, IOException,
			SQLException {
		StringBuffer htmlFor = new StringBuffer();
		htmlFor.setLength(0);
		String sqlString = "";

		if (CertIssued.equals("Y")) {
			sqlString = " select report_id, report_desc, 1 no_of_copies, module_id from sm_report_lang_vw where module_id = 'OP' AND REPORT_ID = 'OPBMEDCR'  and language_id='"+locale+"' order by 2 ";
		}
		String locn_type = "C";
		/*htmlFor
				.append(" <html><head> <link rel='stylesheet' type ='text/css' href='../eCommon/html/IeStyle.css'></link>");
		htmlFor.append("</head><body class='message'>");
		htmlFor.append("<script language = 'JavaScript'>");*/
		htmlFor.append("  var dialogHeight    = '50vh' ;");
		htmlFor.append(" var dialogWidth = '55vw' ;");
		htmlFor.append("var dialogTop = '65';");
		htmlFor.append("  var arguments =   ''; ");
		htmlFor
				.append("  var getUrl        =   '../../eCommon/jsp/InternalReportsPrint.jsp?step=1&sqlString="
						+ java.net.URLEncoder.encode(sqlString,"UTF-8")
						+ "&EncounterId="
						+ p_encounter_id
						+ "&dest_locn_type="
						+ locn_type + "&dest_locn_code=" + p_locn_code + "';");

		htmlFor
				.append(" var features    = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;");
		htmlFor
				.append("  retVal            =   await window.showModalDialog(getUrl,arguments,features); ");
		/*htmlFor.append(" </script>");*/
		out.println(htmlFor.toString());

		htmlFor.setLength(0);
	}

	public static String checkNull(String str) {
		return ((str == null || str.equals("null")) ? "" : str);
	}

	public static String checkNullWithDftValue(String str, String dftval) {
		return ((str == null || str.equals("null")) ? dftval : str);
	}


	private void updateCancelCheckout(HttpServletRequest req,
			HttpServletResponse res) {
		try {

			//String encounter_id = "";
			String reasonCode = "";
			String userId = "";
			String remarks = "";
			String facility_id = "";

			//String p_patient_id = "";
			String p_episode_type = "";
			String p_visit_id = "";
			String p_episode_id = "";

			String bed_no = "";
			String deceased_yn = "";
			String module_id = "";

			String visit_type_ind = "";
			String appt_ref_no = "";
			String pat_cat = "";
			String forced_appt_yn = "";
			String referral_value = "";
			String oacnt = "";
			String multi_speciality_yn = "N";//Added for the CRF - Bru-HIMS-CRF-0198


			facility_id = req.getParameter("facility_id") == null ? "": req.getParameter("facility_id");
			encounter_id = req.getParameter("encounter_id") == null ? "": req.getParameter("encounter_id");
			reasonCode = req.getParameter("reasonCode") == null ? "": req.getParameter("reasonCode");
			userId = req.getParameter("userId") == null ? "": req.getParameter("userId");
			remarks = req.getParameter("remarks") == null ? "": req.getParameter("remarks");

			p_patient_id = req.getParameter("patient_id") == null ? "": req.getParameter("patient_id");
			p_episode_type = req.getParameter("p_episode_type") == null ? "": req.getParameter("p_episode_type");
			p_visit_id = req.getParameter("p_visit_id") == null ? "": req.getParameter("p_visit_id");
			p_episode_id = req.getParameter("p_episode_id") == null ? "": req.getParameter("p_episode_id");
			bl_install_yn = req.getParameter("bl_install_yn") == null ? "": req.getParameter("bl_install_yn");
			bed_no = req.getParameter("bed_no") == null ? "": req.getParameter("bed_no");
			deceased_yn = req.getParameter("deceased_yn") == null ? "": req.getParameter("deceased_yn");			
			module_id = req.getParameter("module_id") == null ? "": req.getParameter("module_id");

			visit_type_ind = req.getParameter("visit_type_ind") == null ? "": req.getParameter("visit_type_ind");
			appt_ref_no = req.getParameter("appt_ref_no") == null ? "": req.getParameter("appt_ref_no");
			pat_cat = req.getParameter("pat_cat") == null ? "": req.getParameter("pat_cat");
			forced_appt_yn = req.getParameter("forced_appt_yn") == null ? "": req.getParameter("forced_appt_yn");
			referral_value = req.getParameter("referral_value") == null ? "": req.getParameter("referral_value");
			oacnt = req.getParameter("oacnt") == null ? "": req.getParameter("oacnt");
			multi_speciality_yn = req.getParameter("multi_speciality_yn") == null ? "N": req.getParameter("multi_speciality_yn");//Added for the CRF - Bru-HIMS-CRF-0198


			tabdata.put("facilityId", facilityId);
			tabdata.put("encounter_id", encounter_id);
			tabdata.put("reasonCode", reasonCode);
			tabdata.put("userId", userId);
			tabdata.put("remarks", remarks);
			tabdata.put("client_ip_address", client_ip_address);

			tabdata.put("p_patient_id", p_patient_id);
			tabdata.put("p_episode_type", p_episode_type);
			tabdata.put("p_visit_id", p_visit_id);
			tabdata.put("p_episode_id", p_episode_id);
			tabdata.put("bl_install_yn", bl_install_yn);

			tabdata.put("bed_no", bed_no);
			tabdata.put("deceased_yn", deceased_yn);
			tabdata.put("module_id", module_id);

			tabdata.put("visit_type_ind", visit_type_ind);
			tabdata.put("appt_ref_no", appt_ref_no);
			tabdata.put("pat_cat", pat_cat);
			tabdata.put("forced_appt_yn", forced_appt_yn);
			tabdata.put("referral_value", referral_value);
			tabdata.put("multi_speciality_yn", multi_speciality_yn);//Added for the CRF - Bru-HIMS-CRF-0198
			tabdata.put("oacnt", oacnt);



			boolean local_ejbs = false;
			if ((getServletConfig().getServletContext().getInitParameter(
					"LOCAL_EJBS") != null)
					&& (getServletConfig().getServletContext()
							.getInitParameter("LOCAL_EJBS")
							.equalsIgnoreCase("TRUE")))
				local_ejbs = true;
			Object home = com.ehis.eslp.ServiceLocator.getInstance()
					.getHome("java:comp/env/PatCheckoutManager",
							PatCheckoutManagerHome.class, local_ejbs);
			Object busObj = (home.getClass().getMethod("create", null)).invoke(
					home, null);

			Object argArray[] = new Object[2];
			argArray[0] = p;
			argArray[1] = tabdata;

			Class[] paramArray = new Class[2];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();

			java.util.HashMap results = (java.util.HashMap) (busObj.getClass()
					.getMethod("updateCancelCheckout", paramArray)).invoke(busObj,
					argArray);
			(busObj.getClass().getMethod("remove", null)).invoke(busObj, null);
			boolean inserted = (((Boolean) results.get("status"))
					.booleanValue());
			String error = (String) results.get("error");

			if (inserted) {
				if (error.lastIndexOf("<br>") >= 0)
					error = error.substring(0, error.lastIndexOf("<br>"));
				out.println("alert(\""
								+ error
								+ "\"); parent.window.returnValue ='success'; parent.window.close();");
			} else {
				out.println("alert(\"" + error
						+ "\");parent.window.close(); ");
			}



			argArray = null;
			paramArray = null;
			//session.removeAttribute("financial_details");
			results.clear();
			tabdata.clear();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			//out.println("<html><head><script></script></head></html>");
		}
	}


}


