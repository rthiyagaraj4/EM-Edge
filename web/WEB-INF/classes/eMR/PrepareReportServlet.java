/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
Module		: Medical Records...(MR)
Coded by	: SRIDHAR R
Coded on	: 22 JULY 2004

Servlet Function :- 
CALL_FUNCTION && REQUEST_STATUS
******************************
MEDICAL_REPORT_REQUEST 	-  1
MEDICAL_REPORT_STATUS 	-  2
FORWARD_TO_HOD			-  9 Added By Dharma
REQUEST_RETURNED		-  10 Added By Dharma
REQUEST_ACCEPTED		-  11 Added By Dharma
FORWARD_MEDICAL_REPORT	-  3
PREPARE_MEDICAL_REPORT	-  4
RECEIVE_MEDICAL_REPORT(ACCEPT) 	-  5
RECEIVE_MEDICAL_REPORT(REJECT) 	-  98
DELIVER_MEDICAL_REPORT 	-  6
REVISE_MEDICAL_REPORT 	-  Just update Revise Collect date - Status is maintained same...
Method Name : updateReportValues(req, res);

AUTO_CANCEL_BATCH_PROCESS - 99
Method Name : autoCancelMedReqBatchProcess(req);
*/

package eMR;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import org.json.simple.*; // added by mujafar for ML-MMOH-CRF-0762

import eCommon.SingleTabHandler.*;

import eCommon.XSSRequestWrapper;

public class PrepareReportServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
    PrintWriter out;
    java.util.Properties p;

    String client_ip_address ;
	String facilityId;
 	String sStyle="";
	String locale="";
	/*Added by Thamizh selvi on 17th July 2017 for ML-MMOH-CRF-0719 Start*/
	String isIncompReqCancelApplicable="";
	String call_function ="";
	/*End*/
	
	//Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708
	String isChckLstApplicable="";

	HttpSession session;

    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException
    {
		
		session = req.getSession(false);
        this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
        this.facilityId = (String) session.getValue( "facility_id" ) ;
        client_ip_address = p.getProperty("client_ip_address");
		locale = p.getProperty("LOCALE");	
		sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
        try
        {
           	req.setCharacterEncoding("UTF-8");
			res.setContentType("text/html;charset=UTF-8");
			req= new XSSRequestWrapper(req);
			res.addHeader("X-XSS-Protection", "1; mode=block");
			res.addHeader("X-Content-Type-Options", "nosniff");
			this.out = res.getWriter();
			out.println("<!DOCTYPE html><head><link rel='stylesheet' type='text/css' href='../eCommon/html/"+sStyle+"'></link><script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='JavaScript'> async function callPatientRegistrationServletHtml (){ ");			

			/*Added by Thamizh selvi on 17th July 2017 for ML-MMOH-CRF-0719 Start*/
			isIncompReqCancelApplicable	= checkForNull(req.getParameter("isIncompReqCancelApplicable"));
			call_function =  checkForNull(req.getParameter("call_function"));
			if(call_function.equals("AUTO_CANCEL_BATCH_PROCESS")){
				autoCancelMedReqBatchProcess(req);
			}/*End*/
			/*Added by Thamizh selvi on 22nd Jan 2019 against ML-MMOH-CRF-1233 Start*/
			else if(call_function.equals("MODIFICATION_REQUEST")){
				modifyDeliveredMedReport(req);
			}/*End*/
			else
				updateReportValues(req);

			//Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708
			isChckLstApplicable	= checkForNull(req.getParameter("isChckLstApplicable"));
			out.println("} callPatientRegistrationServletHtml ();</script></body></html>");
        }
        catch(Exception e)
        {
           // out.println(e.toString());
			e.printStackTrace();
        }
    }

	private void updateReportValues(HttpServletRequest req)
	{
		String cons_letter = "";
		String appl_status = "";
		Connection con =null;

		try
		{
			con = ConnectionManager.getConnection(req);
			String request_status ="";
			String prepare_date = "";
			JSONArray checklistArray		= new JSONArray(); // added by mujafar for ML-MMOH-CRF-0762 start
			String chk_list_code0 = "",chk_list_code1 = "",chk_list_code2 = "",chk_list_code3 = "",chk_list_code4 = "",chk_list_code5 = "",chk_list_code6 = "",chk_list_code7 = "",chk_list_code8 = "",chk_list_code9 = "",chk_list_code10 = "",chk_list_code11 = "",chk_list_code12 = "",chk_list_code13 = "",chk_list_code14 = "",chk_list_code15 = "",chk_list_code16 = "",chk_list_code17 = "",chk_list_code18 = "",chk_list_code19 = "",chk_list_code20 = "",chk_list_code21 = "",chk_list_code22 = "",chk_list_code23 = "",chk_list_code24 = "";//Modified By kamatchi S ML-MMOH-CRF-1464
			String chk_list_code_status0="",chk_list_code_status1="",chk_list_code_status2="",chk_list_code_status3="",chk_list_code_status4="",chk_list_code_status5="",chk_list_code_status6="",chk_list_code_status7="",chk_list_code_status8="",chk_list_code_status9="",chk_list_code_status10="",chk_list_code_status11="",chk_list_code_status12="",chk_list_code_status13="",chk_list_code_status14="",chk_list_code_status15="",chk_list_code_status16="",chk_list_code_status17="",chk_list_code_status18="",chk_list_code_status19="",chk_list_code_status20="",chk_list_code_status21="",chk_list_code_status22="",chk_list_code_status23="",chk_list_code_status24="";//Modified By kamatchi S ML-MMOH-CRF-1464
			PreparedStatement	pstmt	= null;
			ResultSet			rset	= null;
			StringBuffer sbSql = new StringBuffer(); // added by mujafar for ML-MMOH-CRF-0762 end
			
			//String call_function =  checkForNull(req.getParameter("call_function"));
			String fwd_practitioner_id	= checkForNull(req.getParameter("fwd_practitioner_id"));/*Added By Dharma on Dec 8th 2015 against ML-MMOH-CRF-0391 [IN:057157]*/	
			
			//Maheshwaran K modified this condition for ML-MMOH-CRF-0391
			/*else if(call_function.equals("FORWARD_MEDICAL_REPORT"))
				request_status = "3";*/

			Boolean MRBOBABAL = eCommon.Common.CommonBean.isSiteSpecific(con, "MR","BORANG_BAYARAN_BALIK"); /*Added by Rameswar on  18-07-2016 for ML-MMOH-CRF-0458*/ 	
			Boolean MRACKLTR = eCommon.Common.CommonBean.isSiteSpecific(con, "MR","ACKNOWLEDGMENT_LETTER"); /*Added by Rameswar on  18-07-2016 for ML-MMOH-CRF-0441*/ 	
			Boolean isMedicalReportDurationAppl =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","HOLIDAY_DURATION"); /*Added by Mujfar on  22-08-2017 for ML-MMOH-CRF-0704*/
			
			//Below line added for this CRF ML-MMOH-CRF-0712
			Boolean isMedicalReportRequest = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","CANCEL_MEDICAL_REQUEST");
            String medRequestChkbox	= checkForNull(req.getParameter("medRequestChkbox"));
			Boolean isRejectRequestApplicable =    eCommon.Common.CommonBean.isSiteSpecific(con,"MR","REJECT_REQUEST_MRP"); // Added by mujafar for ML-MMOH-CRF-0713
            //End this CRF ML-MMOH-CRF-0712	
			Boolean isAcceptRequestByPractAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","ACCEPT_REJECT_BY_PRACT_APPL");
			// added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
			Boolean MRPELAPE = eCommon.Common.CommonBean.isSiteSpecific(con, "MR","SIGN_OF_MED_RECORDS"); /*Added by Ashwini on 12-Oct-2017 for ML-MMOH-CRF-0720*/ 
			
			/*Added by Ashwini on 16-Aug-2018 for ML-MMOH-CRF-0722*/
			Boolean MRRDUBLP = eCommon.Common.CommonBean.isSiteSpecific(con, "MR","REFUND_LETTER"); 
			String charges_appl	= checkForNull(req.getParameter("charges_appllicable"));
			String cancel_med_rep_reason = checkForNull(req.getParameter("cancel_medical_rep_reason"));
	
			String classification_appl_yn = checkForNull(req.getParameter("classification_appl_yn")); // added by mujafar for ML-MMOH-CRF-0762 start
			String req_type	= checkForNull(req.getParameter("req_type"));
			String Requestor_Code=checkForNull(req.getParameter("Requestor_Code"));
			int count = 0; // added by mujafar for ML-MMOH-CRF-0762 end
			String tot_amt_to_chk	= checkForNull(req.getParameter("tot_amount"));
			int tot_amount	= 0;
			String reportId	= "";
			if(!tot_amt_to_chk.equals("")){
				tot_amount	= Integer.parseInt(req.getParameter("tot_amount")) ;
				if(tot_amount > 40){
					reportId	= "MRBOBBDO";
				}else{
					reportId	= "MRBOBBDO1";
				}
			}
			
			if(call_function.equals("MEDICAL_REPORT_REQUEST"))
				request_status = "1";
			else if(call_function.equals("MEDICAL_REPORT_STATUS"))
				request_status = "2";
			else if(call_function.equals("FORWARD_MEDICAL_REPORT") || call_function.equals("REJECTED_BY_PRACT_TO_MRD") || call_function.equals("REQUEST_RETURNED")) // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
				request_status = "9";	
			else if(call_function.equals("REQUEST_ACCEPTED")){
				if(!fwd_practitioner_id.equals("")){
						request_status = "3";
					}else{
						request_status = "11";
					}
			}
			else if(call_function.equals("PREPARE_MEDICAL_REPORT"))
				request_status = "4";
			else if(call_function.equals("RECEIVE_MEDICAL_REPORT"))
				request_status = "5";
			else if(call_function.equals("DELIVER_MEDICAL_REPORT"))
				request_status = "6";
//			else if(call_function.equals("REVISE_MEDICAL_REPORT"))
//				request_status = "7";

			String called_from = "";	
			String patientId    =  req.getParameter("patientId");
			String request_id   =  req.getParameter("request_id");

			String remarks	= checkForNull(req.getParameter("remarks"));
			String addedById = p.getProperty( "login_user" ) ;
			String modifiedById = addedById ;
			String addedFacilityId=facilityId;
			String modifiedFacilityId = addedFacilityId ;
			String addedAtWorkstation=client_ip_address;
			String modifiedAtWorkstation = addedAtWorkstation ;
			Timestamp modified_date = new Timestamp(System.currentTimeMillis() );

			HashMap tabdata=new HashMap();
						

			if(call_function.equals("MEDICAL_REPORT_STATUS"))
			{
				appl_status	= checkForNull(req.getParameter("appl_status"));
				cons_letter	= checkForNull(req.getParameter("cons_letter"));

				if(appl_status.equals("2")) // Complete
					request_status = "2";
				else if(appl_status.equals("1")) // InComplete
					//request_status = "1";
					request_status = "7";
				else if(appl_status.equals("3")) // Cancelled
					request_status = "8";

				String reqd_docs		= checkForNull(req.getParameter("reqd_docs"));
				System.out.println("line >>>>>>230");
				System.out.println(req.getParameter("reqd_docs"));
				String board_type		= checkForNull(req.getParameter("board_type"));
				String appl_comp_date  = "";
				/*below if-else added by Mujfar on  22-08-2017 for ML-MMOH-CRF-0704 start */
				if(isMedicalReportDurationAppl)
				{
					if(appl_status.equals("2"))
					{
						 appl_comp_date   = checkForNull(req.getParameter("appl_comp_dat"));
						
					}
					else
					{
						 appl_comp_date   = checkForNull(req.getParameter("sysdate"));
						 
					}
				}
				else
				{
				 appl_comp_date   = checkForNull(req.getParameter("sysdate"));
				 
				}
				/*  ML-MMOH-CRF-0704 end */
				String req_pract_id		= checkForNull(req.getParameter("practitioner_id"));
				
				/*Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719 Start*/
				String cancelReason		= checkForNull(req.getParameter("cancel_reason"));
				/*End*/
				
				//Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708
				String application_mode		= checkForNull(req.getParameter("application_mode"));
				String collection_mode		= checkForNull(req.getParameter("collection_mode"));
				String notification_mode	= checkForNull(req.getParameter("notification_mode"));
				/*ML-MMOH-CRF-0708 End*/
				/*Added By Dharma on 2nd Dec 2019 against ML-MMOH-CRF-1454 Start*/
				String dept_spl		= checkForNull(req.getParameter("Splcode"));
				tabdata.put("SPECIALTY_CODE",dept_spl);
				/*Added By Dharma on 2nd Dec 2019 against ML-MMOH-CRF-1454 End*/
				
				StringTokenizer appl_comp_date_toks = new StringTokenizer (appl_comp_date," ") ;
				StringTokenizer appl_comp_date_toks1 = new StringTokenizer (appl_comp_date_toks.nextToken(), "/" ) ;

				String appl_comp_Arr[] =new String[3] ;
				for( int q=0;q<3;q++ )
					appl_comp_Arr[q] = appl_comp_date_toks1.nextToken() ;

				StringBuffer sb_appl_comp_date = new StringBuffer();
				sb_appl_comp_date.append(appl_comp_Arr[2] +"-");
				sb_appl_comp_date.append(appl_comp_Arr[1]+"-");
				sb_appl_comp_date.append(appl_comp_Arr[0]+" ");
				sb_appl_comp_date.append(appl_comp_date_toks.nextToken()+":00");
				appl_comp_date = sb_appl_comp_date.toString();

				//appl_comp_date = appl_comp_Arr[2] +"-"+appl_comp_Arr[1]+"-"+ appl_comp_Arr[0]+" "+appl_comp_date_toks.nextToken()+":00"   ;
				Timestamp appCompDate= Timestamp.valueOf(appl_comp_date);
				
				if(!appl_comp_date.equals("") && appl_status.equals("2"))
				{
					tabdata.put("APPL_COMPLETION_DATE",appCompDate);
				}
				
				/*Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719 Start*/
				if(isIncompReqCancelApplicable.equals("true")){
					if( appl_status.equals("3") ){
						tabdata.put("CANCELLED_DATE",appCompDate);
						tabdata.put("CANCELLED_BY",addedById);
						tabdata.put("CANCEL_REASON_CODE",cancelReason);
					}
				}
				if( appl_status.equals("1") ){
					tabdata.put("STATUS_INCOMPLETE_DATE",appCompDate);
					//Commented By Dharma on 18th Dec 2019 against ML-MMOH-CRF-1454
					/*if(classification_appl_yn.equals("true"))
					{

						try
						{					
							if(rset != null) rset.close();
							if(pstmt != null) pstmt.close();

							if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());

							sbSql.append(" update MR_CHECK_LIST_HDR set MODIFIED_DATE=sysdate where REQUEST_ID=? and PATIENT_ID=? and FACILITY_ID=? ");
							if (pstmt != null)  pstmt = null;
							pstmt = con.prepareStatement( sbSql.toString() );	

							pstmt.setString(1,request_id);
							pstmt.setString(2,patientId);
							pstmt.setString(3,facilityId);

							pstmt.executeUpdate();
							pstmt.close();
							con.commit();

						
						}
						catch(Exception e1)
						{
							e1.printStackTrace();
							
						}
					}*/
				}
				/*End*/
				
				/*Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708*/
				if(isChckLstApplicable.equals("true")){
						if( appl_status.equals("2") ){
							tabdata.put("APPLICATION_MODE",application_mode);
							tabdata.put("COLLECTION_MODE",collection_mode);
							tabdata.put("NOTIFICATION_MODE",notification_mode);
						}
				}
				/*ML-MMOH-CRF-0708 End*/
				

				String collect_date    =  checkForNull(req.getParameter("collect_date"));

				collect_date = DateUtils.convertDate(collect_date,"DMYHM",locale,"en");
				
				if(!collect_date.equals(""))
				{
					StringTokenizer collecttoks = new StringTokenizer (collect_date," ") ;
					StringTokenizer collecttok1 = new StringTokenizer (collecttoks.nextToken(), "/" ) ;
					String collectArr[] =new String[3] ;
					for( int q=0;q<3;q++ )
							collectArr[q] = collecttok1.nextToken() ;
					StringBuffer sb_collect_date = new StringBuffer();
					sb_collect_date.append(collectArr[2] +"-");
					sb_collect_date.append(collectArr[1]+"-");
					sb_collect_date.append(collectArr[0]+" ");
					sb_collect_date.append(collecttoks.nextToken()+":00");
					collect_date = sb_collect_date.toString();
				
					//collect_date = collectArr[2] +"-"+collectArr[1]+"-"+ collectArr[0]+" "+collecttoks.nextToken()+":00"   ;
					Timestamp collectTimestamp= Timestamp.valueOf(collect_date);

					tabdata.put("COLLECT_DATE",collectTimestamp);
				}		

					tabdata.put("APPL_STATUS",appl_status);
					tabdata.put("CONSENT_LETTER_APPL",cons_letter);
					tabdata.put("REQUIRED_DOCS",reqd_docs);
					tabdata.put("MED_BOARD_TYPE_CODE",board_type);
					tabdata.put("REQUEST_STATUS",request_status);
					tabdata.put("REQUESTING_PRACT_ID",req_pract_id);

					String charges_appllicable	= checkForNull(req.getParameter("charges_appllicable"));
						if(charges_appllicable.equals("")) charges_appllicable = "N";

					String additional_charges	= checkForNull(req.getParameter("additional_charges"));
						if(additional_charges.equals("")) additional_charges = "N";

					tabdata.put("CHARGES_APPL_YN",charges_appllicable);
					tabdata.put("ADDL_CHARGES_YN",additional_charges);
					tabdata.put("AMOUNT",checkForNull(req.getParameter("amount")));
					tabdata.put("RECEIPT_NO",checkForNull(req.getParameter("recp_no")));
					tabdata.put("ADDL_AMOUNT",checkForNull(req.getParameter("add_amount")));
					tabdata.put("ADDL_RECEIPT_NO",checkForNull(req.getParameter("add_recp_no")));

					/*Added By Dharma on Nov 20th 2015 against ML-MMOH-CRF-0391 [IN:057157] Start*/	
					if(appl_status.equals("2") || appl_status.equals("1")) {
					if(classification_appl_yn.equals("true"))
					{ // added by mujafar for ML-MMOH-CRF-0762 start
						checklistArray =  MRCommonBean.getChecklistValues(con,req_type,Requestor_Code);
						count =  checklistArray.size();
						//String[] checklistcodearray= new String[count]; //Commented for checkstyle

					

						String ret_val1 = checkForNull(req.getParameter("ret_val1"));	
						if(ret_val1.equals("")) ret_val1 = "N";
						String retVal1[]= ret_val1.split("~");
						
					
						Map<String, String> tableData = new HashMap<String, String>();
						
						for(int i = 0 ; i < checklistArray.size() ; i++)
						{
						JSONObject json	= (JSONObject)checklistArray.get(i);

						String chk_list_code = (String) json.get("chk_list_code");
						tableData.put("chk_list_code"+i,chk_list_code);
						tableData.put("chk_list_code_status"+i,retVal1[i]);
						

						

						}
						
							chk_list_code0 = checkForNull((String)tableData.get("chk_list_code0"));
							chk_list_code1 = checkForNull((String)tableData.get("chk_list_code1"));
							chk_list_code2 = checkForNull((String)tableData.get("chk_list_code2"));
							chk_list_code3 = checkForNull((String)tableData.get("chk_list_code3"));
							chk_list_code4 = checkForNull((String)tableData.get("chk_list_code4"));
							chk_list_code5 = checkForNull((String)tableData.get("chk_list_code5"));
							chk_list_code6 = checkForNull((String)tableData.get("chk_list_code6"));
							chk_list_code7 = checkForNull((String)tableData.get("chk_list_code7"));
							chk_list_code8 = checkForNull((String)tableData.get("chk_list_code8"));
							chk_list_code9 = checkForNull((String)tableData.get("chk_list_code9"));
							//Modified By kamatchi S ML-MMOH-CRF-1464
							chk_list_code10 = checkForNull((String)tableData.get("chk_list_code10"));
							chk_list_code11 = checkForNull((String)tableData.get("chk_list_code11"));
							chk_list_code12 = checkForNull((String)tableData.get("chk_list_code12"));
							chk_list_code13 = checkForNull((String)tableData.get("chk_list_code13"));
							chk_list_code14 = checkForNull((String)tableData.get("chk_list_code14"));
							chk_list_code15 = checkForNull((String)tableData.get("chk_list_code15"));
							chk_list_code16 = checkForNull((String)tableData.get("chk_list_code16"));
							chk_list_code17 = checkForNull((String)tableData.get("chk_list_code17"));
							chk_list_code18 = checkForNull((String)tableData.get("chk_list_code18"));
							chk_list_code19 = checkForNull((String)tableData.get("chk_list_code19"));
							chk_list_code20 = checkForNull((String)tableData.get("chk_list_code20"));
							chk_list_code21 = checkForNull((String)tableData.get("chk_list_code21"));
							chk_list_code22 = checkForNull((String)tableData.get("chk_list_code22"));
							chk_list_code23 = checkForNull((String)tableData.get("chk_list_code23"));
							chk_list_code24 = checkForNull((String)tableData.get("chk_list_code24"));
							//Modified By kamatchi S ML-MMOH-CRF-1464
							chk_list_code_status0 = checkForNull((String)tableData.get("chk_list_code_status0"));
							chk_list_code_status1 = checkForNull((String)tableData.get("chk_list_code_status1"));
							chk_list_code_status2 = checkForNull((String)tableData.get("chk_list_code_status2"));
							chk_list_code_status3 = checkForNull((String)tableData.get("chk_list_code_status3"));
							chk_list_code_status4 = checkForNull((String)tableData.get("chk_list_code_status4"));
							chk_list_code_status5 = checkForNull((String)tableData.get("chk_list_code_status5"));
							chk_list_code_status6 = checkForNull((String)tableData.get("chk_list_code_status6"));
							chk_list_code_status7 = checkForNull((String)tableData.get("chk_list_code_status7"));
							chk_list_code_status8 = checkForNull((String)tableData.get("chk_list_code_status8"));
							chk_list_code_status9 = checkForNull((String)tableData.get("chk_list_code_status9"));
							//Modified By kamatchi S ML-MMOH-CRF-1464 START
							chk_list_code_status10 = checkForNull((String)tableData.get("chk_list_code_status10"));
							chk_list_code_status11 = checkForNull((String)tableData.get("chk_list_code_status11"));
							chk_list_code_status12 = checkForNull((String)tableData.get("chk_list_code_status12"));
							chk_list_code_status13 = checkForNull((String)tableData.get("chk_list_code_status13"));
							chk_list_code_status14 = checkForNull((String)tableData.get("chk_list_code_status14"));
							chk_list_code_status15 = checkForNull((String)tableData.get("chk_list_code_status15"));
							chk_list_code_status16 = checkForNull((String)tableData.get("chk_list_code_status16"));
							chk_list_code_status17 = checkForNull((String)tableData.get("chk_list_code_status17"));
							chk_list_code_status18 = checkForNull((String)tableData.get("chk_list_code_status18"));
							chk_list_code_status19 = checkForNull((String)tableData.get("chk_list_code_status19"));
							chk_list_code_status20 = checkForNull((String)tableData.get("chk_list_code_status20"));
							chk_list_code_status21 = checkForNull((String)tableData.get("chk_list_code_status21"));
							chk_list_code_status22 = checkForNull((String)tableData.get("chk_list_code_status22"));
							chk_list_code_status23 = checkForNull((String)tableData.get("chk_list_code_status23"));
							chk_list_code_status24 = checkForNull((String)tableData.get("chk_list_code_status24"));
							//Modified By kamatchi S ML-MMOH-CRF-1464 END
						
					
						
						
						try{
					int count1=0;
					if(rset != null) rset.close();
					if(pstmt != null) pstmt.close();
					
					if(sbSql.length() > 0) sbSql.delete(0,sbSql.length());
					
					sbSql.append(" update MR_CHECK_LIST_HDR set CHECK_LIST1_CODE=?,CHECK_LIST2_CODE=?,CHECK_LIST3_CODE=?,CHECK_LIST4_CODE=?,CHECK_LIST5_CODE=?,CHECK_LIST6_CODE=?,CHECK_LIST7_CODE=?,CHECK_LIST8_CODE=?,CHECK_LIST9_CODE=?,CHECK_LIST10_CODE=?,CHECK_LIST1_STATUS=?,CHECK_LIST2_STATUS=?,CHECK_LIST3_STATUS=?,CHECK_LIST4_STATUS=?,CHECK_LIST5_STATUS=?,CHECK_LIST6_STATUS=?,CHECK_LIST7_STATUS=?,CHECK_LIST8_STATUS=?,CHECK_LIST9_STATUS=?,CHECK_LIST10_STATUS=?,MODIFIED_FACILITY_ID=?,MODIFIED_BY_ID=?,MODIFIED_AT_WS_NO=?,MODIFIED_DATE=sysdate,CHECK_LIST11_CODE=?,CHECK_LIST12_CODE=?,CHECK_LIST13_CODE=?,CHECK_LIST14_CODE=?,CHECK_LIST15_CODE=?,CHECK_LIST16_CODE=?,CHECK_LIST17_CODE=?,CHECK_LIST18_CODE=?,CHECK_LIST19_CODE=?,CHECK_LIST20_CODE=?,CHECK_LIST21_CODE=?,CHECK_LIST22_CODE=?,CHECK_LIST23_CODE=?,CHECK_LIST24_CODE=?,CHECK_LIST25_CODE=?,CHECK_LIST11_STATUS=?,CHECK_LIST12_STATUS=?,CHECK_LIST13_STATUS=?,CHECK_LIST14_STATUS=?,CHECK_LIST15_STATUS=?,CHECK_LIST16_STATUS=?,CHECK_LIST17_STATUS=?,CHECK_LIST18_STATUS=?,CHECK_LIST19_STATUS=?,CHECK_LIST20_STATUS=?,CHECK_LIST21_STATUS=?,CHECK_LIST22_STATUS=?,CHECK_LIST23_STATUS=?,CHECK_LIST24_STATUS=?,CHECK_LIST25_STATUS=? where REQUEST_ID=? and PATIENT_ID=? and FACILITY_ID=? ");//Modified By kamatchi S ML-MMOH-CRF-1464
					
			
				if (pstmt != null)  pstmt = null;
				pstmt = con.prepareStatement( sbSql.toString() );	
				pstmt.setString(1,chk_list_code0);
				pstmt.setString(2,chk_list_code1);
				pstmt.setString(3,chk_list_code2);
				pstmt.setString(4,chk_list_code3);
				pstmt.setString(5,chk_list_code4);
				pstmt.setString(6,chk_list_code5);
				pstmt.setString(7,chk_list_code6);
				pstmt.setString(8,chk_list_code7);
				pstmt.setString(9,chk_list_code8);
				pstmt.setString(10,chk_list_code9);
				
				
				pstmt.setString(11,chk_list_code_status0);
				pstmt.setString(12,chk_list_code_status1);
				pstmt.setString(13,chk_list_code_status2);
				pstmt.setString(14,chk_list_code_status3);
				pstmt.setString(15,chk_list_code_status4);
				pstmt.setString(16,chk_list_code_status5);
				pstmt.setString(17,chk_list_code_status6);
				pstmt.setString(18,chk_list_code_status7);
				pstmt.setString(19,chk_list_code_status8);
				pstmt.setString(20,chk_list_code_status9);
				
				pstmt.setString(21,modifiedFacilityId);
				pstmt.setString(22,modifiedById);
				pstmt.setString(23,modifiedAtWorkstation);
				
				//Modified By kamatchi S ML-MMOH-CRF-1464 START
				pstmt.setString(24,chk_list_code10);
				pstmt.setString(25,chk_list_code11);
				pstmt.setString(26,chk_list_code12);
				pstmt.setString(27,chk_list_code13);
				pstmt.setString(28,chk_list_code14);
				pstmt.setString(29,chk_list_code15);
				pstmt.setString(30,chk_list_code16);
				pstmt.setString(31,chk_list_code17);
				pstmt.setString(32,chk_list_code18);
				pstmt.setString(33,chk_list_code19);
				pstmt.setString(34,chk_list_code20);
				pstmt.setString(35,chk_list_code21);
				pstmt.setString(36,chk_list_code22);
				pstmt.setString(37,chk_list_code23);
				pstmt.setString(38,chk_list_code24);
				
				pstmt.setString(39,chk_list_code_status10);
				pstmt.setString(40,chk_list_code_status11);
				pstmt.setString(41,chk_list_code_status12);
				pstmt.setString(42,chk_list_code_status13);
				pstmt.setString(43,chk_list_code_status14);
				pstmt.setString(44,chk_list_code_status15);
				pstmt.setString(45,chk_list_code_status16);
				pstmt.setString(46,chk_list_code_status17);
				pstmt.setString(47,chk_list_code_status18);
				pstmt.setString(48,chk_list_code_status19);
				pstmt.setString(49,chk_list_code_status20);
				pstmt.setString(50,chk_list_code_status21);
				pstmt.setString(51,chk_list_code_status22);
				pstmt.setString(52,chk_list_code_status23);
				pstmt.setString(53,chk_list_code_status24);
				//Modified By kamatchi S ML-MMOH-CRF-1464 END
				
				pstmt.setString(54,request_id);
				pstmt.setString(55,patientId);
				pstmt.setString(56,facilityId);
				count1	= pstmt.executeUpdate();
				
				pstmt.close();
				con.commit();
			
					
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
					
				}
				
				
						
					} // added by mujafar for ML-MMOH-CRF-0762 end
					if(appl_status.equals("2")){
					String ret_val	= checkForNull(req.getParameter("ret_val"));
					if(ret_val.equals("")) ret_val = "N"; 
						String retVal[]= ret_val.split("~");
						tabdata.put("CHKLST_CONSENT_FR_PAT",retVal[0]);
						tabdata.put("CHKLST_IDENT_DOC",retVal[1]);
						tabdata.put("CHKLST_MARITAL_CERT",retVal[2]);
						tabdata.put("CHKLST_STAT_DEC",retVal[3]);
						tabdata.put("CHKLST_CONSENT_FR_EMBSY",retVal[4]);
						tabdata.put("CHKLST_PAYMENT",retVal[5]);  
					}
					}
					/*Added By Dharma on Nov 2oth 2015 against ML-MMOH-CRF-0391 [IN:057157] End*/	


					String recp_date    =  checkForNull(req.getParameter("recp_dat"));
							
					recp_date = DateUtils.convertDate(recp_date,"DMYHM",locale,"en");

					if(!recp_date.equals(""))
					{
						StringTokenizer recp_toks1 = new StringTokenizer (recp_date," ") ;
						StringTokenizer recp_toks2 = new StringTokenizer (recp_toks1.nextToken(), "/" ) ;
						String recptArr[] =new String[3] ;
						for( int m=0; m<3; m++ )
								recptArr[m] = recp_toks2.nextToken() ;
						StringBuffer sb_recp_date = new StringBuffer();
						sb_recp_date.append(recptArr[2] +"-");
						sb_recp_date.append(recptArr[1]+"-");
						sb_recp_date.append(recptArr[0]+" ");
						sb_recp_date.append(recp_toks1.nextToken()+":00");
						recp_date = sb_recp_date.toString();
						//	recp_date = recptArr[2] +"-"+recptArr[1]+"-"+ recptArr[0]+" "+recp_toks1.nextToken()+":00"   ;
						Timestamp recp_Timestamp= Timestamp.valueOf(recp_date);
						tabdata.put("RECEIPT_DATE",recp_Timestamp);
					}		
					String add_recp_date    =  checkForNull(req.getParameter("add_recp_dat"));
					
					add_recp_date = DateUtils.convertDate(add_recp_date,"DMYHM",locale,"en");
										
					if(!add_recp_date.equals(""))
					{
						StringTokenizer add_recp_toks1 = new StringTokenizer (add_recp_date," ") ;
						StringTokenizer add_recp_toks2 = new StringTokenizer (add_recp_toks1.nextToken(), "/" ) ;
						String addl_recptArr[] =new String[3] ;
						for( int n=0; n<3; n++ )
								addl_recptArr[n] = add_recp_toks2.nextToken() ;
						StringBuffer sb_add_recp_date = new StringBuffer();
						sb_add_recp_date.append(addl_recptArr[2] +"-");
						sb_add_recp_date.append(addl_recptArr[1]+"-");
						sb_add_recp_date.append(addl_recptArr[0]+" ");
						sb_add_recp_date.append(add_recp_toks1.nextToken()+":00");
						add_recp_date = sb_add_recp_date.toString();
						
						//add_recp_date = addl_recptArr[2] +"-"+addl_recptArr[1]+"-"+ addl_recptArr[0]+" "+add_recp_toks1.nextToken()+":00"   ;
						Timestamp recp_Timestamp= Timestamp.valueOf(add_recp_date);

						tabdata.put("ADDL_RECEIPT_DATE",recp_Timestamp);
					}		
			}
			else if(call_function.equals("FORWARD_MEDICAL_REPORT") || call_function.equals("REJECTED_BY_PRACT_TO_MRD") || call_function.equals("REQUEST_RETURNED")) // modified by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
			{
				
				
				String rep_type			= checkForNull(req.getParameter("rep_type"));
				String dept_spl			= checkForNull(req.getParameter("Splcode"));

				//String forwarded_pract_id = checkForNull(req.getParameter("fwd_practitioner_id"));//Commented by Dharma on Dec 1st 2015 against  ML-MMOH-CRF-0391 [IN:057157]
				
				//tabdata.put("FORWARDED_PRACT_ID",forwarded_pract_id);//Commented by Dharma on Dec 1st 2015 against  ML-MMOH-CRF-0391 [IN:057157]
				//Maheshwaran K added for ML-MMOH-CRF-0391
				//String reqd_docs = checkForNull(req.getParameter("reqd_docs"));
				String fwd_hod_id = checkForNull(req.getParameter("fwd_hod_id"));
				String inform_hod_practitioner_id = checkForNull(req.getParameter("inform_hod_practitioner_id"));
				String medical_team_val = checkForNull(req.getParameter("medical_team_val"));  //added by mujafar for ML-MMOH-CRF-0716
				String medical_team_val1 = checkForNull(req.getParameter("medical_team_val1")); //added by mujafar for ML-MMOH-CRF-0716
				
				
				String forwarded_hod_cord_date = checkForNull(req.getParameter("forwarded_hod_cord_date"));
				
				if(!forwarded_hod_cord_date.equals(""))
				{
						StringTokenizer appl_sub_dt_toks = new StringTokenizer (forwarded_hod_cord_date," ") ;
						StringTokenizer appl_sub_dt_toks1 = new StringTokenizer (appl_sub_dt_toks.nextToken(), "/" ) ;
						String appl_sub_Arr[] =new String[3] ;
						for( int q=0;q<3;q++ )
						appl_sub_Arr[q] = appl_sub_dt_toks1.nextToken() ;
						StringBuffer sb_appl_sub_dt = new StringBuffer();
						sb_appl_sub_dt.append(appl_sub_Arr[2] +"-");
						sb_appl_sub_dt.append(appl_sub_Arr[1]+"-");
						sb_appl_sub_dt.append(appl_sub_Arr[0]+" ");
						sb_appl_sub_dt.append(appl_sub_dt_toks.nextToken()+":00");
						forwarded_hod_cord_date = sb_appl_sub_dt.toString();
						Timestamp forwarded_hod_cord_date1 = Timestamp.valueOf(forwarded_hod_cord_date);

					   tabdata.put("FORWARDED_HOD_CORD_DATE",forwarded_hod_cord_date1);
				  }
				
			//	tabdata.put("REQUESTED_DOCS",reqd_docs);
				tabdata.put("FORWARDED_HOD_CORD_ID",fwd_hod_id);
				tabdata.put("INFORM_HOD_CORD_ID",inform_hod_practitioner_id);
				
				tabdata.put("FORWARDED_MEDICAL_TEAM",medical_team_val); //added by mujafar for ML-MMOH-CRF-0716
				tabdata.put("INFORM_MEDICAL_TEAM",medical_team_val1); //added by mujafar for ML-MMOH-CRF-0716
				
				//tabdata.put("FORWARDED_HOD_CORD_DATE",forwarded_hod_cord_date);
				//ML-MMOH-CRF-0391 End

				String appl_sub_dt    =  checkForNull(req.getParameter("appl_sub_dt"));
							
				if(!appl_sub_dt.equals(""))
				{
					StringTokenizer appl_sub_dt_toks = new StringTokenizer (appl_sub_dt," ") ;
					StringTokenizer appl_sub_dt_toks1 = new StringTokenizer (appl_sub_dt_toks.nextToken(), "/" ) ;

					String appl_sub_Arr[] =new String[3] ;
					for( int q=0;q<3;q++ )
							appl_sub_Arr[q] = appl_sub_dt_toks1.nextToken() ;

					StringBuffer sb_appl_sub_dt = new StringBuffer();
					sb_appl_sub_dt.append(appl_sub_Arr[2] +"-");
					sb_appl_sub_dt.append(appl_sub_Arr[1]+"-");
					sb_appl_sub_dt.append(appl_sub_Arr[0]+" ");
					sb_appl_sub_dt.append(appl_sub_dt_toks.nextToken()+":00");
					appl_sub_dt = sb_appl_sub_dt.toString();
					
					//appl_sub_dt = appl_sub_Arr[2] +"-"+appl_sub_Arr[1]+"-"+ appl_sub_Arr[0]+" "+appl_sub_dt_toks.nextToken()+":00"   ;
					Timestamp appFwdDate = Timestamp.valueOf(appl_sub_dt);

					tabdata.put("APPL_SUBMITTED_DATE",appFwdDate);
					
				}		

				
				
			//Below line added for this CRF ML-MMOH-CRF-0712
						
			if(isMedicalReportRequest && (call_function.equals("FORWARD_MEDICAL_REPORT") || call_function.equals("REJECTED_BY_PRACT_TO_MRD")) && medRequestChkbox.equals("Y")){ // modified by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
                request_status="8";			
				String cancel_medical_rep_reason = checkForNull(req.getParameter("cancel_medical_rep_reason"));
				String appl_comp_date1   = checkForNull(req.getParameter("sysdate"));
				StringTokenizer appl_comp_date_toks = new StringTokenizer (appl_comp_date1," ") ;
				StringTokenizer appl_comp_date_toks1 = new StringTokenizer (appl_comp_date_toks.nextToken(), "/" ) ;

				String appl_comp_Arr[] =new String[3] ;
				for( int q=0;q<3;q++ )
					appl_comp_Arr[q] = appl_comp_date_toks1.nextToken() ;

				StringBuffer sb_appl_comp_date = new StringBuffer();
				sb_appl_comp_date.append(appl_comp_Arr[2] +"-");
				sb_appl_comp_date.append(appl_comp_Arr[1]+"-");
				sb_appl_comp_date.append(appl_comp_Arr[0]+" ");
				sb_appl_comp_date.append(appl_comp_date_toks.nextToken()+":00");
				appl_comp_date1 = sb_appl_comp_date.toString();				
				Timestamp appCompDate= Timestamp.valueOf(appl_comp_date1);
				tabdata.put("CANCELLED_DATE",appCompDate);
				tabdata.put("CANCELLED_BY",addedById);
				tabdata.put("CANCEL_REASON_CODE",cancel_medical_rep_reason);
                tabdata.put("REQUEST_STATUS",request_status); 				
			}else{			
			    tabdata.put("REQUEST_STATUS",request_status);
			}
			//End this CRF ML-MMOH-CRF-0712				
				
				tabdata.put("REPORT_TYPE_CODE",rep_type);
				tabdata.put("SPECIALTY_CODE",dept_spl);
			}
			/*Added By Dharma on Dec 1st 2015 against ML-MMOH-CRF-0391 [IN:057157] Start*/
			else if(call_function.equals("FORWARD_TO_HOD") || call_function.equals("REJECTED_BY_PRACT_TO_HOD")  ){
				String status				= checkForNull(req.getParameter("status"));
				String ack_hod_co_ord_id	= checkForNull(req.getParameter("ack_hod_co_ord_id"));
				String ack_medical_team = checkForNull(req.getParameter("medical_team_val_ack"));  //added by mujafar for ML-MMOH-CRF-0716
				String inform_to_pract_id	= checkForNull(req.getParameter("inform_to_pract_id"));
				String accpt_rejct_date	= checkForNull(req.getParameter("accpt_rejct_date"));
				if(isRejectRequestApplicable && status.equals("R") && medRequestChkbox.equals("N"))
				{ // added by mujafar for ML-MMOH-CRF-0713
				String accpt_rejct_date1=checkForNull(req.getParameter("accpt_rejct_date1"));
				accpt_rejct_date = accpt_rejct_date1;
				
				}
				
				accpt_rejct_date			= DateUtils.convertDate(accpt_rejct_date,"DMYHM",locale,"en");
				//To Convert accept reject date into TimeStamp Format
				
				StringTokenizer accpt_rejct_date_toks = new StringTokenizer (accpt_rejct_date," ") ;
				StringTokenizer accpt_rejct_date_toks1 = new StringTokenizer (accpt_rejct_date_toks.nextToken(), "/" ) ;
				String accpt_rejct_date_arr[] =new String[3] ;
				for( int p=0;p<3;p++ )
						accpt_rejct_date_arr[p] = accpt_rejct_date_toks1.nextToken() ;
				StringBuffer sb_accpt_rejct_date = new StringBuffer();
				sb_accpt_rejct_date.append(accpt_rejct_date_arr[2] +"-");
				sb_accpt_rejct_date.append(accpt_rejct_date_arr[1]+"-");
				sb_accpt_rejct_date.append(accpt_rejct_date_arr[0]+" ");
				sb_accpt_rejct_date.append(accpt_rejct_date_toks.nextToken()+":00");
				accpt_rejct_date = sb_accpt_rejct_date.toString();
				Timestamp accpt_rejct_date_Timestamp= Timestamp.valueOf(accpt_rejct_date);
				
				if(isRejectRequestApplicable && status.equals("R") && medRequestChkbox.equals("N"))
				{  // added by mujafar for ML-MMOH-CRF-0713
				
				String reject_medical_rep_reason=checkForNull(req.getParameter("reject_medical_rep_reason"));
				
				tabdata.put("reason_rejection",reject_medical_rep_reason);
				tabdata.put("accpt_rejct_date",accpt_rejct_date_Timestamp);
				tabdata.put("rejected_by",modifiedById);
				
				}
				
				
				if(isAcceptRequestByPractAppl)
				{ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
				String pract_assign_date = checkForNull(req.getParameter("pract_assign_date"));
				String remarks_hod = checkForNull(req.getParameter("remarks_hod"));
				
				
				  
				  pract_assign_date = DateUtils.convertDate(pract_assign_date,"DMYHM",locale,"en");
				
				if(!pract_assign_date.equals(""))
				{
					StringTokenizer collecttoks = new StringTokenizer (pract_assign_date," ") ;
					StringTokenizer collecttok1 = new StringTokenizer (collecttoks.nextToken(), "/" ) ;
					String collectArr[] =new String[3] ;
					for( int q=0;q<3;q++ )
							collectArr[q] = collecttok1.nextToken() ;
					StringBuffer sb_collect_date = new StringBuffer();
					sb_collect_date.append(collectArr[2] +"-");
					sb_collect_date.append(collectArr[1]+"-");
					sb_collect_date.append(collectArr[0]+" ");
					sb_collect_date.append(collecttoks.nextToken()+":00");
					pract_assign_date = sb_collect_date.toString();
				
				
					Timestamp collectTimestamp= Timestamp.valueOf(pract_assign_date);
					tabdata.put("pract_assign_date",collectTimestamp);
					
				}		
					tabdata.put("remarks_hod",remarks_hod);	
					tabdata.put("remarks_pract","");	//Added By Dharma on 25th Mar 2020 against ML-MMOH-CRF-1473
					
				}
				
				
				
			//Below line added for this CRF ML-MMOH-CRF-0712
			if(isMedicalReportRequest && call_function.equals("FORWARD_TO_HOD") && medRequestChkbox.equals("Y")){					
				String cancel_medical_rep_reason = checkForNull(req.getParameter("cancel_medical_rep_reason"));
				
				
				tabdata.put("CANCELLED_DATE",accpt_rejct_date_Timestamp);
				tabdata.put("CANCELLED_BY",addedById);
				tabdata.put("CANCEL_REASON_CODE",cancel_medical_rep_reason);					
			}
		   //End this CRF ML-MMOH-CRF-0712	 
			
				if(status.equals("A") ||status.equals("S")){ // modified by mujafar for ML-MMOH-CRF-0718
					if(!fwd_practitioner_id.equals("")){
						request_status = "3";
						tabdata.put("FORWARDED_PRACT_ID",fwd_practitioner_id);
					}else{
						request_status = "11";
					}
					
					
					if(isAcceptRequestByPractAppl)
					{ // added by mujafar for ML-MMOH-CRF-1279 
						
						String inform_hod_practitioner_id = checkForNull(req.getParameter("inform_hod_practitioner_id2"));
						String medical_team_val = checkForNull(req.getParameter("medical_team_val2")); 
						
					
						
						tabdata.put("INFORM_HOD_CORD_ID",inform_hod_practitioner_id);
						tabdata.put("INFORM_MEDICAL_TEAM",medical_team_val);
						
						
					}
					
					tabdata.put("ACK_HOD_CORD_ID",ack_hod_co_ord_id); 
					tabdata.put("ack_medical_team",ack_medical_team); //added by mujafar for ML-MMOH-CRF-0716
					tabdata.put("INFORM_TO_PRACT_ID",inform_to_pract_id);
					tabdata.put("accpt_rejct_date",accpt_rejct_date_Timestamp);
				}else if(status.equals("R")) {
					request_status = "10";
					String strEmpty="";
					
					
					if(isAcceptRequestByPractAppl)
					{ // added by mujafar for ML-MMOH-CRF-1279
						tabdata.put("INFORM_HOD_CORD_ID",strEmpty);
						tabdata.put("INFORM_MEDICAL_TEAM",strEmpty);
					}
					
					
					
					tabdata.put("FORWARDED_HOD_CORD_ID",strEmpty);
					tabdata.put("INFORM_HOD_CORD_ID",strEmpty);
					tabdata.put("ACK_HOD_CORD_ID",strEmpty);
					tabdata.put("INFORM_TO_PRACT_ID",strEmpty);
					tabdata.put("FORWARDED_HOD_CORD_DATE",strEmpty);
				}
				
				/*Below line added for this CRF ML-MMOH-RF-0712*/
				if(isMedicalReportRequest && call_function.equals("FORWARD_TO_HOD") && medRequestChkbox.equals("Y") ){	
				    request_status="8";
				    tabdata.put("REQUEST_STATUS",request_status);
				}else{
				    tabdata.put("REQUEST_STATUS",request_status);
				}
				//End this CRF ML-MMOH-CRF-0712
				
				
			} else if(call_function.equals("REQUEST_ACCEPTED")){
				
				String ack_medical_team = checkForNull(req.getParameter("medical_team_val_ack_1"));   //added by mujafar for ML-MMOH-CRF-0716
			
				tabdata.put("ack_medical_team",ack_medical_team);  //added by mujafar for ML-MMOH-CRF-0716
				tabdata.put("FORWARDED_PRACT_ID",fwd_practitioner_id);
				tabdata.put("REQUEST_STATUS",request_status);
				
				if(isAcceptRequestByPractAppl)
				{ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
				String pract_assign_date = checkForNull(req.getParameter("pract_assign_date"));
				String remarks_hod = checkForNull(req.getParameter("remarks_hod"));
				  pract_assign_date = DateUtils.convertDate(pract_assign_date,"DMYHM",locale,"en");
				  
				  
				  
				  
				 
						
				String inform_hod_practitioner_id = checkForNull(req.getParameter("inform_hod_practitioner_id2"));
				String medical_team_val = checkForNull(req.getParameter("medical_team_val2")); 
				
			
				
				
				tabdata.put("INFORM_HOD_CORD_ID",inform_hod_practitioner_id);
				tabdata.put("INFORM_MEDICAL_TEAM",medical_team_val);
						
				
				  
				  
				  
				  
				
				if(!pract_assign_date.equals(""))
				{
					StringTokenizer collecttoks = new StringTokenizer (pract_assign_date," ") ;
					StringTokenizer collecttok1 = new StringTokenizer (collecttoks.nextToken(), "/" ) ;
					String collectArr[] =new String[3] ;
					for( int q=0;q<3;q++ )
							collectArr[q] = collecttok1.nextToken() ;
					StringBuffer sb_collect_date = new StringBuffer();
					sb_collect_date.append(collectArr[2] +"-");
					sb_collect_date.append(collectArr[1]+"-");
					sb_collect_date.append(collectArr[0]+" ");
					sb_collect_date.append(collecttoks.nextToken()+":00");
					pract_assign_date = sb_collect_date.toString();
					Timestamp collectTimestamp= Timestamp.valueOf(pract_assign_date);
					tabdata.put("pract_assign_date",collectTimestamp);
					
				}	
					tabdata.put("remarks_hod",remarks_hod);	
					
					
				}
				
				
				
				
				
				
				
				
			}
			/*Added By Dharma on Dec 1st 2015 against ML-MMOH-CRF-0391 [IN:057157] End*/
			else if(call_function.equals("PREPARE_MEDICAL_REPORT") || call_function.equals("ACCEPTED_BY_PRACTITIONER")  || call_function.equals("PREPARE_MEDICAL_BOARD"))
			{ // modified by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
				
				
				
				
				called_from = checkForNull(req.getParameter("called_from"));
				String accession_num = checkForNull(req.getParameter("accession_num"));

				prepare_date =  checkForNull(req.getParameter("prepare_date"));
			
				prepare_date = DateUtils.convertDate(prepare_date,"DMYHM",locale,"en");
				
				String medical_team_val = checkForNull(req.getParameter("medical_team_val"));  //added by mujafar for ML-MMOH-CRF-0716
				tabdata.put("FORWARDED_MEDICAL_TEAM",medical_team_val); //added by mujafar for ML-MMOH-CRF-0716
				
				// below if else code added by mujafar for ML-MMOH-CRF-0963
				if(isMedicalReportRequest && call_function.equals("PREPARE_MEDICAL_REPORT") && called_from.equals("CA") &&  medRequestChkbox.equals("Y") )
				{
					 request_status="8";			
				String cancel_medical_rep_reason = checkForNull(req.getParameter("cancel_medical_rep_reason"));
				String appl_comp_date1   = checkForNull(req.getParameter("sysdate"));
				StringTokenizer appl_comp_date_toks = new StringTokenizer (appl_comp_date1," ") ;
				StringTokenizer appl_comp_date_toks1 = new StringTokenizer (appl_comp_date_toks.nextToken(), "/" ) ;

				String appl_comp_Arr[] =new String[3] ;
				for( int q=0;q<3;q++ )
					appl_comp_Arr[q] = appl_comp_date_toks1.nextToken() ;

				StringBuffer sb_appl_comp_date = new StringBuffer();
				sb_appl_comp_date.append(appl_comp_Arr[2] +"-");
				sb_appl_comp_date.append(appl_comp_Arr[1]+"-");
				sb_appl_comp_date.append(appl_comp_Arr[0]+" ");
				sb_appl_comp_date.append(appl_comp_date_toks.nextToken()+":00");
				appl_comp_date1 = sb_appl_comp_date.toString();				
				Timestamp appCompDate= Timestamp.valueOf(appl_comp_date1);
				tabdata.put("CANCELLED_DATE",appCompDate);
				tabdata.put("CANCELLED_BY",addedById);
				tabdata.put("CANCEL_REASON_CODE",cancel_medical_rep_reason);
                tabdata.put("REQUEST_STATUS",request_status); 
				
				}
				

				else if(called_from.equals("CA") && prepare_date.equals("")&& !isAcceptRequestByPractAppl) // modified by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
				{ 
					tabdata.put("ACCESSION_NUM",accession_num);
				}
				else
				{   
			         
					String prepare_pract_id = checkForNull(req.getParameter("prep_practitioner_id"));
					tabdata.put("PREPARE_PRACT_ID",prepare_pract_id);
					//Maheshwaran K added for ML-MMOH-CRF-0391
					if(!isAcceptRequestByPractAppl)
					{ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
					String req_pract_id		= checkForNull(req.getParameter("practitioner_id"));
					tabdata.put("REQUESTING_PRACT_ID",req_pract_id);
					}
					String fwd_hod_id = checkForNull(req.getParameter("fwd_hod_id"));
					tabdata.put("FORWARDED_HOD_CORD_ID",fwd_hod_id);
					//End
					tabdata.put("FORWARDED_PRACT_ID",checkForNull(req.getParameter("fwd_practitioner_id"))); //Added By Dharma on Jan 18th 2016 against ML-MMOH-CRF-0390 [IN:057155]


					//To Convert Prepare date into TimeStamp Format
					
					if(!prepare_date.equals(""))
					{ // modified by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
					StringTokenizer preparetoks = new StringTokenizer (prepare_date," ") ;
					StringTokenizer preparetok1 = new StringTokenizer (preparetoks.nextToken(), "/" ) ;
					String prepareArr[] =new String[3] ;
					for( int p=0;p<3;p++ )
							prepareArr[p] = preparetok1.nextToken() ;
					StringBuffer sb_prepare_date = new StringBuffer();
					sb_prepare_date.append(prepareArr[2] +"-");
					sb_prepare_date.append(prepareArr[1]+"-");
					sb_prepare_date.append(prepareArr[0]+" ");
					sb_prepare_date.append(preparetoks.nextToken()+":00");
					prepare_date = sb_prepare_date.toString();
					
					//prepare_date = prepareArr[2] +"-"+prepareArr[1]+"-"+ prepareArr[0]+" "+preparetoks.nextToken()+":00"   ;
					Timestamp prepareTimestamp= Timestamp.valueOf(prepare_date);
					tabdata.put("PREPARED_DATE",prepareTimestamp);
					}
					else
					{ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
						tabdata.put("PREPARED_DATE",prepare_date);
					}
					
					
					
					if(isAcceptRequestByPractAppl){ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
						
						String prac_status = checkForNull(req.getParameter("prac_status"));
						String temp_pract = checkForNull(req.getParameter("temp_pract"));
						String acc_rej_ret_date = checkForNull(req.getParameter("acc_rej_ret_date"));
						String remarks_pract = checkForNull(req.getParameter("remarks_pract"));
						
					
						
						
						
						StringTokenizer preparetoks = new StringTokenizer (acc_rej_ret_date," ") ;
					StringTokenizer preparetok1 = new StringTokenizer (preparetoks.nextToken(), "/" ) ;
					String prepareArr[] =new String[3] ;
					for( int p=0;p<3;p++ )
							prepareArr[p] = preparetok1.nextToken() ;
					StringBuffer sb_prepare_date = new StringBuffer();
					sb_prepare_date.append(prepareArr[2] +"-");
					sb_prepare_date.append(prepareArr[1]+"-");
					sb_prepare_date.append(prepareArr[0]+" ");
					sb_prepare_date.append(preparetoks.nextToken()+":00");
					acc_rej_ret_date = sb_prepare_date.toString();
					
					//prepare_date = prepareArr[2] +"-"+prepareArr[1]+"-"+ prepareArr[0]+" "+preparetoks.nextToken()+":00"   ;
					Timestamp accrejTimestamp= Timestamp.valueOf(acc_rej_ret_date);
						
						
						
						
						if(prac_status.equals("AP"))
						{
							if(temp_pract.equals("SAVEASDRAFT"))
							{
								request_status="13";	
							}
							else
							{
								request_status = "4";
							}
						}
						else if(prac_status.equals("RM"))
						{
								
							request_status="14";
							String reject_medical_rep_reason_1=checkForNull(req.getParameter("reject_medical_rep_reason_1"));
							tabdata.put("PRACT_REASON_REJECTION",reject_medical_rep_reason_1);
											
							String strEmpty="";
							tabdata.put("forwarded_hod_cord_date",strEmpty);
							tabdata.put("FORWARDED_HOD_CORD_ID",strEmpty);
							tabdata.put("INFORM_HOD_CORD_ID",strEmpty);
							tabdata.put("FORWARDED_MEDICAL_TEAM",strEmpty);
							tabdata.put("INFORM_MEDICAL_TEAM",strEmpty);
							tabdata.put("CANCELLED_DATE",strEmpty);
							tabdata.put("CANCELLED_BY",strEmpty);
							tabdata.put("CANCEL_REASON_CODE",strEmpty);
							
							tabdata.put("ack_medical_team",strEmpty);
							tabdata.put("ACK_HOD_CORD_ID",strEmpty);
							tabdata.put("INFORM_TO_PRACT_ID",strEmpty);
							
							tabdata.put("pract_assign_date",strEmpty);
							
							tabdata.put("reason_rejection",strEmpty);
							tabdata.put("accpt_rejct_date",strEmpty);
							tabdata.put("rejected_by",strEmpty);
							tabdata.put("remarks_hod",strEmpty);//Added By Dharma on 25th Mar 2020 against ML-MMOH-CRF-1473	

							
								
						}
						else
						{
							request_status="15";
							String reject_medical_rep_reason_1=checkForNull(req.getParameter("reject_medical_rep_reason_1"));
							tabdata.put("PRACT_REASON_REJECTION",reject_medical_rep_reason_1);
							
							String strEmpty="";
						
						
							tabdata.put("ack_medical_team",strEmpty);
							tabdata.put("ACK_HOD_CORD_ID",strEmpty);
							tabdata.put("INFORM_TO_PRACT_ID",strEmpty);
							
							tabdata.put("pract_assign_date",strEmpty);
							
							
							
							
							tabdata.put("CANCELLED_DATE",strEmpty);
							tabdata.put("CANCELLED_BY",strEmpty);
							tabdata.put("CANCEL_REASON_CODE",strEmpty);
							tabdata.put("reason_rejection",strEmpty);
							tabdata.put("accpt_rejct_date",strEmpty);
							tabdata.put("rejected_by",strEmpty);
							tabdata.put("remarks_hod",strEmpty);//Added By Dharma on 25th Mar 2020 against ML-MMOH-CRF-1473							
						}
						
					tabdata.put("PRACT_ACC_REJ_RET_DATE",accrejTimestamp);	
					tabdata.put("remarks_pract",remarks_pract);	
						
						
						
					} // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316 end
					
				
					
					tabdata.put("REQUEST_STATUS",request_status);		
					tabdata.put("ACCESSION_NUM",accession_num);
				}
			}
			else if(call_function.equals("RECEIVE_MEDICAL_REPORT"))
			{
				//To Convert Receive date into TimeStamp Format
				String status	= checkForNull(req.getParameter("status")); // added by mujafar for ML-MMOH-CRF-0714
				
				String receive_date ="";
				
				if(status.equals("R")) // added by mujafar for ML-MMOH-CRF-0714
				receive_date =  checkForNull(req.getParameter("accpt_rejct_date1"));
				else
				receive_date =  checkForNull(req.getParameter("receive_date"));
				
				
				receive_date = DateUtils.convertDate(receive_date,"DMYHM",locale,"en");
								
				StringTokenizer receivetoks = new StringTokenizer (receive_date," ") ;
				StringTokenizer receivetok1 = new StringTokenizer (receivetoks.nextToken(), "/" ) ;
				String receiveArr[] =new String[3] ;
				for( int q=0;q<3;q++ )
						receiveArr[q] = receivetok1.nextToken() ;
				StringBuffer sb_receive_date = new StringBuffer();
				sb_receive_date.append(receiveArr[2] +"-");
				sb_receive_date.append(receiveArr[1]+"-");
				sb_receive_date.append(receiveArr[0]+" ");
				sb_receive_date.append(receivetoks.nextToken()+":00");
				receive_date = sb_receive_date.toString();
				
				//receive_date = receiveArr[2] +"-"+receiveArr[1]+"-"+ receiveArr[0]+" "+receivetoks.nextToken()+":00"   ;
				Timestamp receiveTimestamp= Timestamp.valueOf(receive_date);
				if(status.equals("A") || status.equals("") )
				{
				tabdata.put("RECEIVED_DATE",receiveTimestamp);
				tabdata.put("REQUEST_STATUS",request_status);
				//Maheshwaran k added for ML-MMOH-CRF-0391
				String fwd_hod_id = checkForNull(req.getParameter("fwd_hod_id"));
				tabdata.put("FORWARDED_HOD_CORD_ID",fwd_hod_id);
				}
				else
				if(status.equals("R"))
				{ 	
				String reject_medical_rep_reason_1=checkForNull(req.getParameter("reject_medical_rep_reason_1"));
				request_status = "98";
				tabdata.put("mrp_reason_rejection",reject_medical_rep_reason_1);
				tabdata.put("RECEIVED_DATE",receiveTimestamp);
				tabdata.put("mrp_rejected_by",modifiedById);
				tabdata.put("REQUEST_STATUS",request_status);	
				}
			}
			else if(call_function.equals("DELIVER_MEDICAL_REPORT"))
			{
				String del_addr_line1		= "";
				String del_addr_line2		= "";
				String del_addr_line3		= "";
				String del_addr_line4		= "";
				String del_res_town_code	= "";
				String del_res_area_code	= "";
				String del_region_code		= "";
				String del_postal_code		= "";
				String del_country_code		= "";

				// To Convert Delivered date into TimeStamp Format
				String delivered_date =  checkForNull(req.getParameter("delivered_date"));
				if(!delivered_date.equals("")){
				delivered_date = DateUtils.convertDate(delivered_date,"DMYHM",locale,"en");
				
				StringTokenizer delivertoks = new StringTokenizer (delivered_date," ") ;
				StringTokenizer delivertok1 = new StringTokenizer (delivertoks.nextToken(), "/" ) ;
				String deliverArr[] =new String[3] ;
				for( int r=0;r<3;r++ )
				deliverArr[r] = delivertok1.nextToken() ;
				StringBuffer sb_delivered_date = new StringBuffer();
				sb_delivered_date.append(deliverArr[2] +"-");
				sb_delivered_date.append(deliverArr[1]+"-");
				sb_delivered_date.append(deliverArr[0]+" ");
				sb_delivered_date.append(delivertoks.nextToken()+":00");
				delivered_date = sb_delivered_date.toString();

				
				//delivered_date = deliverArr[2] +"-"+deliverArr[1]+"-"+ deliverArr[0]+" "+delivertoks.nextToken()+":00"   ;
				Timestamp deliverTimestamp= Timestamp.valueOf(delivered_date);

				tabdata.put("DELIVERED_DATE",deliverTimestamp);
				}
				tabdata.put("REQUEST_STATUS",request_status);

				String Despatch_mode = checkForNull(req.getParameter("Despatch_mode"));
				if(Despatch_mode.equals("O"))
				{
					del_addr_line1		= checkForNull(req.getParameter("other_del_addr_line1"));
					del_addr_line2		= checkForNull(req.getParameter("other_del_addr_line2"));	
					del_addr_line3		= checkForNull(req.getParameter("other_del_addr_line3"));	
					del_addr_line4		= checkForNull(req.getParameter("other_del_addr_line4"));	
					del_res_town_code	= checkForNull(req.getParameter("other_del_res_town_code"));	
					del_res_area_code	= checkForNull(req.getParameter("other_del_res_area_code"));	
					del_region_code		= checkForNull(req.getParameter("other_del_region_code"));	
					del_postal_code		= checkForNull(req.getParameter("other_del_postal_code"));
					del_country_code	= checkForNull(req.getParameter("other_del_country_code"));
				}
				else if(Despatch_mode.equals("P"))
				{
					del_addr_line1		= checkForNull(req.getParameter("personal_del_addr_line1"));
					del_addr_line2		= checkForNull(req.getParameter("personal_del_addr_line2"));	
					del_addr_line3		= checkForNull(req.getParameter("personal_del_addr_line3"));	
					del_addr_line4		= checkForNull(req.getParameter("personal_del_addr_line4"));	
					del_res_town_code	= checkForNull(req.getParameter("personal_del_res_town_code"));	
					del_res_area_code	= checkForNull(req.getParameter("personal_del_res_area_code"));	
					del_region_code		= checkForNull(req.getParameter("personal_del_region_code"));	
					del_postal_code		= checkForNull(req.getParameter("personal_del_postal_code"));
					del_country_code	= checkForNull(req.getParameter("personal_del_country_code"));
				}
				/*for delivery address...*/
/*
				String del_addr_line1		= checkForNull(req.getParameter("del_addr_line1"));
				String del_addr_line2		= checkForNull(req.getParameter("del_addr_line2"));	
				String del_addr_line3		= checkForNull(req.getParameter("del_addr_line3"));	
				String del_addr_line4		= checkForNull(req.getParameter("del_addr_line4"));	
				String del_res_town_code	= checkForNull(req.getParameter("del_res_town_code"));	
				String del_res_area_code	= checkForNull(req.getParameter("del_res_area_code"));	
				String del_region_code		= checkForNull(req.getParameter("del_region_code"));	
				String del_postal_code		= checkForNull(req.getParameter("del_postal_code"));
				String del_country_code		= checkForNull(req.getParameter("del_country_code"));
*/
				String file_no= checkForNull(req.getParameter("file_no"));
				String report_taken= checkForNull(req.getParameter("report_taken"));
				String del_nric_no= checkForNull(req.getParameter("del_nric_no"));
				String del_oth_alt_type= checkForNull(req.getParameter("del_oth_alt_type"));
				String del_oth_alt_id= checkForNull(req.getParameter("del_oth_alt_id"));

				// To Convert posted date into TimeStamp Format
				String posted_date= checkForNull(req.getParameter("posted_date"));
				
				posted_date = DateUtils.convertDate(posted_date,"DMYHM",locale,"en");
				
				if(!posted_date.equals(""))
				{
					StringTokenizer postedtoks = new StringTokenizer (posted_date," ") ;
					StringTokenizer postedtok1 = new StringTokenizer (postedtoks.nextToken(), "/" ) ;
					String postedArr[] =new String[3] ;
					for( int r=0;r<3;r++ )
					postedArr[r] = postedtok1.nextToken() ;
					StringBuffer sb_posted_date = new StringBuffer();
					sb_posted_date.append(postedArr[2] +"-");
					sb_posted_date.append(postedArr[1]+"-");
					sb_posted_date.append(postedArr[0]+" ");
					sb_posted_date.append(postedtoks.nextToken()+":00");
					posted_date = sb_posted_date.toString();
					//posted_date = postedArr[2] +"-"+postedArr[1]+"-"+ postedArr[0]+" "+postedtoks.nextToken()+":00"   ;
					Timestamp postedTimestamp= Timestamp.valueOf(posted_date);
					tabdata.put("POSTED_DATE",postedTimestamp);
				}
				
				/*Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708*/
			//Commented By Dharma on Apr 13th 2020 against ML-MMOH-CRF-1314 
			/*	String applic_mode			= checkForNull(req.getParameter("applic_mode"));
				String collectn_mode		= checkForNull(req.getParameter("collectn_mode"));
				String notific_mode			= checkForNull(req.getParameter("notific_mode"));

				if(isChckLstApplicable.equals("true")){
						tabdata.put("APPLICATION_MODE",applic_mode);
						tabdata.put("COLLECTION_MODE",collectn_mode);
						tabdata.put("NOTIFICATION_MODE",notific_mode);
				}*/
				/*ML-MMOH-CRF-0708 End*/

				tabdata.put("POSTED_ADDR_LINE1",del_addr_line1);
				tabdata.put("POSTED_ADDR_LINE2",del_addr_line2);	
				tabdata.put("POSTED_ADDR_LINE3",del_addr_line3);	
				tabdata.put("POSTED_ADDR_LINE4",del_addr_line4);	
				tabdata.put("POSTED_TOWN_CODE",del_res_town_code);	
				tabdata.put("POSTED_AREA_CODE",del_res_area_code);	
				tabdata.put("POSTED_REGION_CODE",del_region_code);	
				tabdata.put("POSTED_POSTAL_CODE",del_postal_code);
				tabdata.put("POSTED_COUNTRY_CODE",del_country_code);
				tabdata.put("DISPATCH_MODE",Despatch_mode);
				tabdata.put("SEC_FILE_NO",file_no);
				tabdata.put("REPORT_TAKEN_BY",report_taken);
				tabdata.put("RTB_NATIONAL_ID_NO",del_nric_no);
				tabdata.put("RTB_ALT_ID_TYPE",del_oth_alt_type);
				tabdata.put("RTB_ALT_ID__NO",del_oth_alt_id);
				tabdata.put("DELIVERY_REMARKS",checkForNull(req.getParameter("delivery_remarks")));//Added By Dharma on Apr 15th 2020 against ML-MMOH-CRF-1314
			}
				
				// Common Insertions...for all Functions
				tabdata.put("REMARKS",remarks);
				tabdata.put("modified_by_id",modifiedById);
				tabdata.put("modified_date",modified_date);
				tabdata.put("modified_facility_id",modifiedFacilityId);
				tabdata.put("modified_at_ws_no",modifiedAtWorkstation );
			
			HashMap condflds=new HashMap();
			condflds.put("FACILITY_ID",facilityId);
			condflds.put("PATIENT_ID",patientId);
			condflds.put("REQUEST_ID",request_id);
			
			String tableName = "MR_REPORT_REQUEST_HDR";
			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = tableName;

			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = tableName.getClass();

			HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
			String error = (String) results.get("error") ;
				
			if(inserted)
			{
				java.util.Hashtable message = MessageManager.getMessage(locale, "RECORD_MODIFIED","SM" ) ;
				error = (String) message.get("message") ;
				if ( message != null ) message.clear();
			}
			else
			{
				error = (String) results.get("error") ;
				error = "Errors Encountered..";
			}
			//error= error.substring(0,error.indexOf("<br>")) ;



			if(called_from.equals("CA") && prepare_date.equals("") && !isAcceptRequestByPractAppl)
			{ // modified by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
				// alert is not fired..
				// below if else block added by mujafar for ML-MMOH-CRF-0963
				if(isMedicalReportRequest && medRequestChkbox.equals("Y") )
				{
					out.println("alert(\""+error+"\");");
					/*Added by Ashwini on 16-Aug-2018 for ML-MMOH-CRF-0722*/
					if(call_function.equals("PREPARE_MEDICAL_REPORT") && !cancel_med_rep_reason.equals("") && charges_appl.equals("Y") && MRRDUBLP) 
					{ 
						doOnlineReports(patientId, request_id, cons_letter, appl_status,call_function, charges_appl, cancel_med_rep_reason, reportId, con);
					}
					
					/*End ML-MMOH-CRF-0722*/
					out.println("parent.window.close();");
				}
				else
				{
				out.println("parent.window.close();");
				}
			}
			else
			{
				out.println("alert(\""+error+"\");");
				/*Modified by Ashwini on 16-Aug-2018 for ML-MMOH-CRF-0722*/
				if(call_function.equals("MEDICAL_REPORT_STATUS"))
				{
					// Report cslled only if Application Status is Complete...
					if( appl_status.equals("2") && !request_id.equals("") ) 
					{
						doOnlineReports(patientId, request_id, cons_letter, appl_status,call_function, charges_appl, cancel_med_rep_reason, reportId, con);
					}else if( appl_status.equals("1") && !request_id.equals("") && MRACKLTR) 
					{ 
						doOnlineReports(patientId, request_id, cons_letter, appl_status,call_function, charges_appl, cancel_med_rep_reason, reportId, con);
					}/*Added by Rameswar on  18-07-2016 for ML-MMOH-CRF-0441*/
					else if( appl_status.equals("3") && charges_appl.equals("Y") && MRRDUBLP) 
					{ 
						doOnlineReports(patientId, request_id, cons_letter, appl_status,call_function, charges_appl, cancel_med_rep_reason, reportId, con);
					}
				}/*Added by Rameswar on  20-05-2016 for ML-MMOH-CRF-0458*/
				else if(call_function.equals("PREPARE_MEDICAL_REPORT")||call_function.equals("RECEIVE_MEDICAL_REPORT"))
				{ // MRBOBABAL is Borang Bayaran Balik Online Report and it is specific to WCH
					
					if(!request_id.equals("") && (MRACKLTR || MRBOBABAL || MRPELAPE))  // modified by mujafar for ML-MMOH-CRF-1219
					{   
					doOnlineReports(patientId, request_id, cons_letter, appl_status,call_function, charges_appl, cancel_med_rep_reason, reportId, con);
					} /*Added by Rameswar on  20-05-2016 for ML-MMOH-CRF-0458*/
				}
				//Added by Ashwini on 12-Oct-2017 for ML-MMOH-CRF-0720
				else if(call_function.equals("DELIVER_MEDICAL_REPORT"))
				{ 	
					if(!request_id.equals("") && (MRACKLTR || MRBOBABAL || MRPELAPE)) 
					{   
						doOnlineReports(patientId, request_id, cons_letter, appl_status,call_function, charges_appl, cancel_med_rep_reason, reportId, con);
					} 
				}
				else if(MRRDUBLP && !cancel_med_rep_reason.equals("") && charges_appl.equals("Y") && (call_function.equals("FORWARD_MEDICAL_REPORT") || call_function.equals("FORWARD_TO_HOD") || call_function.equals("REJECTED_BY_PRACT_TO_MRD") ))
				{  // modified by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316	
					doOnlineReports(patientId, request_id, cons_letter, appl_status,call_function, charges_appl, cancel_med_rep_reason, reportId, con);
				}
				/*End ML-MMOH-CRF-0722*/
				out.println("const dialogTag = top.document.getElementById('dialog_tag');dialogTag.close();");
			}
			if ( tabdata != null) tabdata.clear();
			if ( results != null) results.clear();
			if ( condflds != null) condflds.clear();
		}catch(Exception e)
		{
			e.printStackTrace();
			//out.print(e);
		}
		finally
		{
			ConnectionManager.returnConnection(con,req);
		}
	}
	
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}

	///Added by Sridhar R on FEB 1 2005 for online reports from MEDICAL_REPORT_STATUS Function...
	/*function parameter is added by Rameswar on  20-05-2016 for ML-MMOH-CRF-0458*/
	private void doOnlineReports(String patient_Id, String request_ID, String consent_letter, String application_status,String call_function, String charges_appl, String cancel_med_rep_reason, String reportId, Connection con) throws ServletException, IOException, SQLException
	{
		String facilityId	= (String) session.getValue( "facility_id" ) ;
		String sqlString		= "";		
		String reportParamNames	= "";
		String reportParamValues= "";
		
		Boolean MRRDUBLP = eCommon.Common.CommonBean.isSiteSpecific(con, "MR","REFUND_LETTER"); //Added by Ashwini on 16-Aug-2018 for ML-MMOH-CRF-0722

		try
		{

//			if(application_status.equals("2") ) // Application is Complete
//			if(application_status.equals("1") ) // Application is InComplete
//			if(consent_letter.equals("0")) // if Consent letter is Available
			/*Added by Rameswar on  20-05-2016 for ML-MMOH-CRF-0458*/
			if(call_function.equals("PREPARE_MEDICAL_REPORT")){
				/*Added by Ashwini on 16-Aug-2018 for ML-MMOH-CRF-0722*/
				if( !cancel_med_rep_reason.equals("") && charges_appl.equals("Y") && MRRDUBLP){ 
					sqlString = " SELECT report_id, report_desc, 1 no_of_copies, module_id FROM sm_report WHERE  module_id = 'MR' AND report_id in ('MRBOBABAL','MRRDUBLP') ";
				}else if(charges_appl.equals("Y")){
					//sqlString = " SELECT report_id, report_desc, 1 no_of_copies, module_id FROM sm_report WHERE  module_id = 'MR' AND report_id in ('MRBOBABAL','MRBOBBDO') ";
					sqlString = " SELECT report_id, report_desc, 1 no_of_copies, module_id FROM sm_report WHERE  module_id = 'MR' AND report_id in ('MRBOBABAL') ";
					if(!reportId.equals("")){
						sqlString = " SELECT report_id, report_desc, 1 no_of_copies, module_id FROM sm_report WHERE  module_id = 'MR' AND report_id in ('MRBOBABAL','"+reportId+"') ";
					}
				}else{
					sqlString = " SELECT report_id, report_desc, 1 no_of_copies, module_id FROM sm_report WHERE  module_id = 'MR' AND report_id in ('MRBOBABAL') ";
				}
			} /*Added by Rameswar on  20-05-2016 for ML-MMOH-CRF-0458*/
			else if (call_function.equals("RECEIVE_MEDICAL_REPORT")){
				/*Added by Rameswar on  18-07-2016 for ML-MMOH-CRF-0441*/
				 
				//sqlString = " SELECT report_id, report_desc, 1 no_of_copies, module_id FROM sm_report WHERE  module_id = 'MR' AND report_id in ('MRBOBABAL','MRACKLTR') "; // commented by mujafar for ML-MMOH-CRF-1219
				
				sqlString = " SELECT report_id, report_desc, 1 no_of_copies, module_id FROM sm_report WHERE  module_id = 'MR' AND report_id in ('MRBOBABAL','MRPELAPE') "; // modified by mujafar for ML-MMOH-CRF-1219
				
				
				
			}
			/*Added by Ashwini on 12-Oct-2017 for ML-MMOH-CRF-0720*/
			else if (call_function.equals("DELIVER_MEDICAL_REPORT")){
				 
				sqlString = " SELECT report_id, report_desc, 1 no_of_copies, module_id FROM sm_report WHERE  module_id = 'MR' AND report_id in ('MRBOBABAL','MRACKLTR','MRPELAPE') ";
			}
			/*Added by Ashwini on 16-Aug-2018 for ML-MMOH-CRF-0722*/
			else if (MRRDUBLP && application_status.equals("3") && charges_appl.equals("Y") && call_function.equals("MEDICAL_REPORT_STATUS"))
			{
				sqlString = " SELECT report_id, report_desc, 1 no_of_copies, module_id FROM sm_report WHERE  module_id = 'MR' AND report_id in ('MRRDUBLP') ";
			}
			else if(MRRDUBLP && !cancel_med_rep_reason.equals("") && charges_appl.equals("Y") && (call_function.equals("FORWARD_MEDICAL_REPORT") || call_function.equals("FORWARD_TO_HOD") || call_function.equals("REJECTED_BY_PRACT_TO_MRD") ))
			{ // modified by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316
				sqlString = " SELECT report_id, report_desc, 1 no_of_copies, module_id FROM sm_report WHERE  module_id = 'MR' AND report_id in ('MRRDUBLP') ";
			}
			/*End ML-MMOH-CRF-0722*/

			else if( application_status.equals("2") )
			{
				if(consent_letter.equals("0"))
				{
					/*
					MRBMRAPP - Application form for Medical Report
					MRBMRCFR - Consent Form for Medical Report
					MRRSDLTR - Report Collection Letter
					*/
					  
					sqlString = " SELECT report_id, report_desc, 1 no_of_copies, module_id FROM sm_report WHERE  module_id = 'MR' AND report_id in ('MRBMRAPP','MRBMRCFR','MRRSDLTR','MRMEREQF','MRMERELF','MRACKLTR') ";
				}
				else
				{
					/*
					MRBMRAPP - Application form for Medical Report
					MRRSDLTR - Report Collection Letter
					*/ 
					sqlString = " SELECT report_id, report_desc, 1 no_of_copies, module_id FROM sm_report WHERE  module_id = 'MR' AND report_id in ('MRBMRAPP','MRRSDLTR','MRMEREQF','MRMERELF','MRACKLTR') ";
				}
			}
			else if( application_status.equals("1") )
			{/*Added by Rameswar on  18-07-2016 for ML-MMOH-CRF-0441*/
				/*	Incomplete Status
					MRACKLTR -Acknowledgement Letter 
					*/ 
					sqlString = " SELECT report_id, report_desc, 1 no_of_copies, module_id FROM sm_report WHERE  module_id = 'MR' AND report_id in ('MRACKLTR') ";
				}

			reportParamNames = "p_patient_id,p_request_id,p_facility_id,p_req_id";
			reportParamValues = ""+patient_Id+","+request_ID+","+facilityId+","+request_ID+"";
			StringBuffer htmlFor = new StringBuffer();
			htmlFor.append(" var dialogHeight	= '50vh';");
			htmlFor.append("  var dialogWidth	= '55vw';");
			htmlFor.append("  var dialogTop		= '5';");
			htmlFor.append("  var arguments		=	'';");
			// modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
			htmlFor.append("  var getUrl		=	'../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id="+call_function+"&step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"&Patient_ID="+patient_Id+"';");
			htmlFor.append("var features = 'dialogHeight:'+dialogHeight+'; dialogWidth:'+dialogWidth+'; status=no;' ;");
			htmlFor.append("retVal = await top.window.showModalDialog(getUrl,arguments,features); parent.window.close();");
			out.println(htmlFor.toString());
		}catch ( Exception e )
		{
			//out.println("Encountered error while Processing Online Reports "+e.toString());
			e.printStackTrace();
		}
	}
	/*Added by Thamizh selvi on 17th July 2017 for ML-MMOH-CRF-0719 Start*/
	private void autoCancelMedReqBatchProcess(HttpServletRequest req){
		
		Connection con			= null;
		PreparedStatement pstmt	= null;
		try{
			con = ConnectionManager.getConnection(req);
			
			String modifiedById				= p.getProperty( "login_user" ) ;
			String modifiedAtWorkstation	= client_ip_address ;
			String cutOffDate				= checkForNull(req.getParameter("p_cut_of_date"));
			String error					= "";
			int result						= 0;

			String updateSql = " UPDATE mr_report_request_hdr SET request_status = '99', appl_status = '3', CANCELLED_BY = '"+modifiedById+"', CANCELLED_DATE = sysdate, modified_by_id='"+modifiedById+"', modified_date = sysdate, modified_at_ws_no='"+modifiedAtWorkstation+"', modified_facility_id='"+facilityId+"' where facility_id='"+facilityId+"' and trunc(status_incomplete_date) < to_date('"+cutOffDate+"','dd/mm/yyyy') and request_status = '7' ";

			pstmt	= con.prepareStatement(updateSql);
			result	= pstmt.executeUpdate();

			if(result > 0){
				con.commit();
				Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
				error = (String)message.get("message");
			}else{
				Hashtable message = MessageManager.getMessage(locale, "NO_RECORD_FOUND","COMMON");
				String error1 = (String)message.get("message");
				error = error1.replace("...."," for update");
			}
			out.println("alert('"+error+"');");
			out.println("parent.onLocalSuccess();");
			if(pstmt!=null)pstmt.close();
				
		}catch (Exception e)
		{
			//out.println("Error in autoCancelMedReqBatchProcess method in PrepareReportServlet: "+ e.toString());
			e.printStackTrace();
			try
			{
				con.rollback();
			}catch(Exception e1){}
		}
		finally{
			ConnectionManager.returnConnection(con,req);
		}
	}/*End*/

	/*Added by Thamizh selvi on 22nd Jan 2018 for ML-MMOH-CRF-1233 Start*/
	private void modifyDeliveredMedReport(HttpServletRequest req){
		
		Connection con			= null;
		PreparedStatement pstmt	= null;
		try{
			con = ConnectionManager.getConnection(req);
			
			String modifiedById				= p.getProperty( "login_user" ) ;
			String modifiedAtWorkstation	= client_ip_address ;
			String requestId				= checkForNull(req.getParameter("requestId"));
			String patientId				= checkForNull(req.getParameter("patientId"));
			String facilityId				= checkForNull(req.getParameter("facilityId"));
			String deliveredDate			= checkForNull(req.getParameter("deliveredDate"));
			String collectionMode			= checkForNull(req.getParameter("collectionMode"));
			String collectDate				= checkForNull(req.getParameter("collectDate"));
			String preparedPract			= checkForNull(req.getParameter("preparedPract"));
			String preparedDate				= checkForNull(req.getParameter("preparedDate"));
			String modifyReason				= checkForNull(req.getParameter("modifyReason"));
			String revisedCollectDate		= checkForNull(req.getParameter("revisedCollectDate"));
			String error					= "";
			int insResult					= 0;
			int updResult					= 0;
			Boolean inserted				= false;
			
			String insertAuditSql = "INSERT INTO MR_REPORT_MODIFIED_AUDIT (FACILITY_ID, PATIENT_ID, REQUEST_ID, MODIFICATION_REMARKS, PREPARED_DATE, COLLECT_DATE, DELIVERED_DATE, PREPARE_PRACT_ID, COLLECTION_MODE, REVISED_COLLECT_DATE, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID ) VALUES (?, ?, ?, ?, TO_DATE(?,'dd/mm/yyyy hh24:mi:ss'), TO_DATE(?,'dd/mm/yyyy hh24:mi:ss'), TO_DATE(?,'dd/mm/yyyy hh24:mi:ss'), ?, ?, TO_DATE(?,'dd/mm/yyyy hh24:mi:ss'), ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ? )";
			
			pstmt = con.prepareStatement(insertAuditSql);

			pstmt.setString(1, facilityId);
			pstmt.setString(2, patientId);
			pstmt.setString(3, requestId);
			pstmt.setString(4, modifyReason.replaceAll("'","`"));
			pstmt.setString(5, preparedDate);
			pstmt.setString(6, collectDate);
			pstmt.setString(7, deliveredDate);
			pstmt.setString(8, preparedPract);
			pstmt.setString(9, collectionMode);
			pstmt.setString(10, revisedCollectDate);
			pstmt.setString(11, modifiedById);
			pstmt.setString(12, modifiedAtWorkstation);
			pstmt.setString(13, facilityId);
			pstmt.setString(14, modifiedById);
			pstmt.setString(15, modifiedAtWorkstation);
			pstmt.setString(16, facilityId);
			insResult = pstmt.executeUpdate();

			if(pstmt !=null) pstmt.close();
			if(insResult > 0){

				//String updateSql = " UPDATE mr_report_request_hdr SET request_status = '98', delivered_date= '', MODIFICATION_REMARKS='"+modifyReason.replaceAll("'","`")+"', modified_by_id='"+modifiedById+"', modified_date = sysdate, modified_at_ws_no='"+modifiedAtWorkstation+"', modified_facility_id='"+facilityId+"' where facility_id='"+facilityId+"' and request_id ='"+requestId+"' and request_status = '6' ";
				String updateSql = " UPDATE mr_report_request_hdr SET request_status = '98', delivered_date= '', MODIFICATION_REMARKS='"+modifyReason.replaceAll("'","`")+"', modified_by_id='"+modifiedById+"', modified_date = sysdate, modified_at_ws_no='"+modifiedAtWorkstation+"', modified_facility_id='"+facilityId+"',mrp_rejected_by = '"+modifiedById+"',received_date = sysdate where facility_id='"+facilityId+"' and request_id ='"+requestId+"' and request_status = '6' ";

				pstmt	= con.prepareStatement(updateSql);
				updResult	= pstmt.executeUpdate();

				if(updResult > 0){
					con.commit();
					Hashtable message = MessageManager.getMessage(locale, "RECORD_INSERTED","SM");
					error = (String)message.get("message");
					inserted = true;
				}else{
					Hashtable message = MessageManager.getMessage(locale, "NO_RECORD_FOUND","COMMON");
					String error1 = (String)message.get("message");
					error = error1.replace("...."," for update");
				}
				
			}else{
				Hashtable message = MessageManager.getMessage(locale, "NO_RECORD_FOUND","COMMON");
				String error1 = (String)message.get("message");
				error = error1.replace("...."," for update");
			}
			out.println("alert('"+error+"');parent.window.returnValue= \""+inserted+"\" ;");
			out.println("parent.window.close();");
			if(pstmt!=null)pstmt.close();
	
		}catch (Exception e)
		{
			//out.println("Error in modifyDeliveredMedReport method in PrepareReportServlet: "+ e.toString());
			e.printStackTrace();
			try
			{
				con.rollback();
			}catch(Exception e1){}
		}
		finally{
			ConnectionManager.returnConnection(con,req);
		}
	}/*End*/
}
