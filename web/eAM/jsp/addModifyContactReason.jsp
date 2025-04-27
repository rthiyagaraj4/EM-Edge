<!DOCTYPE html>
<%--
	FileName	: addModifyContactReason.jsp
	Version	    : 3	
	Modified On	: 19-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

      <head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
	


      	<!-- Added by sri -->
      	<script>
      	function change() {
      	 if (contactreason_form.eff_status.checked == true)
      	 	contactreason_form.eff_status.value="E";
      	 else
      		contactreason_form.eff_status.value="D";
      	}
      	function changeCase(Obj)
	{
		Obj.value=Obj.value.toUpperCase();
	
	}
	
	function CheckMaxLength(Obj)
	{
		if(Obj.value.length >60){
			alert(getMessage("LENGTH_NOT_EXCEED_60","AM"));
			Obj.focus();
			}

	}
		function CheckMaxLen(Obj)
		{
			if(Obj.value.length >60){
				Obj.focus();
				return false;
				}
	
		}

 
      	</script>
      	<!-- Added by sri ends here -->

      </head>

      <body onLoad='FocusFirstElement()' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>


<%
	request.setCharacterEncoding("UTF-8");
   String code="";
   String reason="";

	String visit_registration_yn	="";
	String cancel_visit_yn			=""; 
	String book_appointment_yn		=""   ;
	String transfer_appointment_yn	="" ;
	String cancel_appointment_yn	="" ;
	String lift_schedule_yn			="" ;
	String block_schedule_yn		="" ;
	String cancel_schedule_yn		="" ;
	String transfer_schedule_yn		="" ;
	String revise_visit_yn		="" ;
	String reason_for_recall_yn="";
	String reason_for_referral_yn ="";
   	String cancel_booking_yn ="";
   	String cancel_admission_yn ="";
   	String cancel_discharge_advice_yn ="";
   	String reason_for_revise_bkg_yn ="";
   	String CANCEL_TRANSFER_YN ="";
	String CHANGE_ADMISSION_DTLS_YN="";
	String CANCEL_DISCHARGE_YN = "";
   	String REGISTER_ATTENDANCE_YN ="";
   	String BARCODE_SCANNING_YN ="";// Added for MMS-DM-CRF-0157 ON 20-MAR-2020 BY KAMATCHI S
   	
   	String REASON_BIOMETRIC_REJECTION_YN="";//Added By Himanshu
   	
   String effstatus="";
   String codeTextAttribute="";
   String otherTextAttribute="";
   String checkBoxAttribute="";
   String eventFunctionForCase="";
   String otherCheckAttribute="";
   String followup_of_referral_yn="";
   String rejection_of_referral_yn="";
   String cancel_wait_list_yn="";
   String patient_depart_yn="";
   String modify_wait_list_yn="";
   String pract_override_reason_yn="";
   String trans_exceed_reason_yn="";
   //added for the CRF - Bru-HIMS-CRF-157
   String late_discharge_reason_yn="";
   String CANCEL_OP_CHECKOUT_YN="";
   String CANCEL_AE_CHECKOUT_YN="";
   String REVERT_MO_RELEASE_YN="";
   String CANCEL_EMBALM_YN="";   // Added Against Bru-HIMS-CRF-348 [IN:038247] By Saanthaakumar
   
   //<!--Added by Himanshu Saxena on 16-Jun-2023 for ML-MMOH-CRF-1972 Starts-->
   String cancel_For_admission_yn="";
   String cancel_For_admission_chk="";
 //<!--Added by Himanshu Saxena on 16-Jun-2023 for ML-MMOH-CRF-1972 ends-->

   String UNIT_TRANSFER_REASON_YN = ""; //Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589
   String external_appl_reason_yn = ""; //Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
   /*Added By Dharma on 10th Mar 2020 against ML-MMOH-CRF-1473 Start*/
   String rejected_to_mrd_by_pract_yn = "";
   String return_to_hod_by_pract_yn	= "";
	/*Added By Dharma on 10th Mar 2020 against ML-MMOH-CRF-1473 End*/
   //String emergency_transfer_yn="";
   //String eventFunctionForDate="";
   boolean newcontactreason=false;
	Connection conn	= null;
   /*Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719 Start*/
   String cancelMedReqYn				= ""; 
   String rejectRequest_mrp = ""; //Added by Shaik Mujafar for ML-MMOH-CRF-0713
   Boolean isIncompReqCancelApplicable	= false;
    Boolean isRejectRequestApplicable	= false; //Added by Shaik Mujafar for ML-MMOH-CRF-0713
   /*End*/
   String rejectReport_mrp = ""; //Added by Shaik Mujafar for ML-MMOH-CRF-0714
   Boolean isRejectReportApplicable = false; //Added by Shaik Mujafar for ML-MMOH-CRF-0714
   Boolean isBarcodeScanningApplicable = false; // Added for MMS-DM-CRF-0157 on 26-MAR-2020 By KAMATCHI S
	/* Added by lakshmanan for ML-MMOH-CRF-1955  start */
		   Boolean isMarkPatientMLC=false; 
		   String mark_mlc_yn="";
		   String mark_nonmlc_yn="";
		   String sqlMLC="";
	/* Added by lakshmanan for ML-MMOH-CRF-1955  end */
   String sql="";
   boolean isPendingForAdmissionAppl=false;
			
 	//<!--Added by Himanshu Saxena on 30-Jun-2023 for AAKH-CRF-0175 US1 Starts-->
 	boolean isBiometricRejectionAppl=false;
 	PreparedStatement pstmt_rh=null ;
 	ResultSet rs_rh=null;
 	String function_name="";
 	//<!--Added by Himanshu Saxena on 30-Jun-2023 for AAKH-CRF-0175 US1 ends-->
 	
   //Below line added for this CRF ML-MMOH-CRF-0566
   Boolean referralRegister = false;
   String reject_referral_reason_yn="";
   String cancel_referral_reason_yn="";
   //End ML-MMOH-CRF-0566
   
%>
<%
  try{
	conn = ConnectionManager.getConnection(request);
	isIncompReqCancelApplicable =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","AUTO_CANCEL_INCOMPLETE_REQUEST");//Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719
	isRejectRequestApplicable =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","REJECT_REQUEST_MRP"); //Added by Shaik Mujafar for ML-MMOH-CRF-0713
	isRejectReportApplicable =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","REJECT_REPORT_MRP"); //Added by Shaik Mujafar for ML-MMOH-CRF-0714
	//Below line added for this CRF ML-MMOH-CRF-0566
	isBarcodeScanningApplicable = eCommon.Common.CommonBean.isSiteSpecific(conn, "AM", "BARCODE_SCANNING_APPLICABLE");// Added for MMS-DM-CRF-0157 on 26-MAR-2020 By KAMATCHI S
	referralRegister = CommonBean.isSiteSpecific(conn, "IP", "RECNL_REFERRAL_REGISTER");
	 //<!--Added by Himanshu Saxena on 16-Jun-2023 for ML-MMOH-CRF-1972 Starts-->
       isPendingForAdmissionAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "AE", "AE_FOR_ADMISSION_TAB");
        //<!--Added by Himanshu Saxena on 16-Jun-2023 for ML-MMOH-CRF-1972 ends-->	

         //<!--Added by Himanshu Saxena on 30-Jun-2023 for AAKH-CRF-0175 US11 Starts-->
       	//isBiometricRejectionAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "AE", "SMART_CARD_INTG");
        //boolean isBiometricRejectionAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "SMART_CARD_INTG");
	try
	{
	pstmt_rh = conn.prepareStatement("select nvl(VALUE_2,'00') VALUE_2 from sm_function_control a,SM_SITE_PARAM b  where module_id='MP' and FUNCTIONALITY_ID='SMART_CARD_INTG' and a.SITE_ID=B.CUSTOMER_ID");
        rs_rh = pstmt_rh.executeQuery();	
	if(rs_rh!=null && rs_rh.next())
	{
	function_name=rs_rh.getString("VALUE_2");
	}
	}catch(SQLException esql)
	{
		esql.printStackTrace();
	}finally
	{
	 if(pstmt_rh != null)pstmt_rh.close();
	 if(rs_rh != null)rs_rh.close();
	}
	//<!--Added by Himanshu Saxena on  30-Jun-2023 for AAKH-CRF-0175 US1 ends-->
	// Added by lakshmanan for ML-MMOH-CRF-1955 on 01-07-2023 start 
	isMarkPatientMLC=eCommon.Common.CommonBean.isSiteSpecific(conn,"MP","MARK_PATIENT_MLC"); 
	if(isMarkPatientMLC){
		sqlMLC="decode(MARK_MLC_YN,'Y','checked','') MARK_MLC_YN , "+
				"decode(MARK_NONMLC_YN,'Y','checked','') MARK_NONMLC_YN , ";
	}
	// Added by lakshmanan for ML-MMOH-CRF-1955 on 01-07-2023 end 
	code=request.getParameter("contact_reason_code");
	if(code==null){
		code="";
		reason="";
		effstatus="E";
		codeTextAttribute="";
		otherTextAttribute="";
		otherCheckAttribute="";
		checkBoxAttribute="CHECKED";
		newcontactreason=true;
		//eventFunctionForDate="OnBlur='CheckDate(this)'";
		eventFunctionForCase="OnBlur='ChangeUpperCase(this)'";
	}else{
	       Statement stmt=null;
	       ResultSet rset=null;
   

		stmt = conn.createStatement();

		sql =	"select contact_reason_code,contact_reason,"+
				"decode(visit_registration_yn  ,'Y','checked','') visit_registration_yn,"+
				"decode(cancel_visit_yn        ,'Y','checked','') cancel_visit_yn,"+ 		
				"decode(book_appointment_yn    ,'Y','checked','') book_appointment_yn,"+		
				"decode(transfer_appointment_yn,'Y','checked','') transfer_appointment_yn,"+	
				"decode(cancel_appointment_yn  ,'Y','checked','') cancel_appointment_yn,"+	
				"decode(lift_schedule_yn       ,'Y','checked','') lift_schedule_yn,"+	
				"decode(block_schedule_yn      ,'Y','checked','') block_schedule_yn,"+
				"decode(cancel_wait_list_yn      ,'Y','checked','') cancel_wait_list_yn,"+
                "decode(modify_wait_list_yn      ,'Y','checked','') modify_wait_list_yn,"+
				"decode(cancel_schedule_yn     ,'Y','checked','') cancel_schedule_yn,"+	
				"decode(transfer_schedule_yn   ,'Y','checked','') transfer_schedule_yn,"+		
				"decode(revise_visit_yn		   ,'Y','checked','') revise_visit_yn,"+
			   "decode(reason_for_recall_yn		   ,'Y','checked','') reason_for_recall_yn,"+
		         "decode (reason_for_referral_yn,'Y','checked','')reason_for_referral_yn,"+ 
				"decode(cancel_booking_yn      ,'Y','checked','') cancel_booking_yn,"+	
				"decode(cancel_admission_yn   ,'Y','checked','') cancel_admission_yn,"+	
				"decode(cancel_discharge_advice_yn		   ,'Y','checked','') cancel_discharge_advice_yn,"+
				"decode(CANCEL_TRANSFER_YN		   ,'Y','checked','') CANCEL_TRANSFER_YN,"+
				"decode(CHANGE_ADMISSION_DTLS_YN		   ,'Y','checked','') CHANGE_ADMISSION_DTLS_YN,"+

				"decode(REGISTER_ATTENDANCE_YN		   ,'Y','checked','') REGISTER_ATTENDANCE_YN,"+	"decode(reason_for_revise_bkg_yn,'Y','checked','')reason_for_revise_bkg_yn,"+	
				
				
				
		        "decode(FOLLOWUP_OF_REFERRAL_YN ,'Y','checked','') followup_of_referral_yn,"+	"decode(REJECTION_OF_REFERRAL_YN,'Y','checked','')rejection_of_referral_yn,"+	
				"decode(patient_depart_yn,'Y','checked','')patient_depart_yn,"+
				"decode(CANCEL_DISCHARGE_YN		   ,'Y','checked','') CANCEL_DISCHARGE_YN,"+
				"decode(CANCEL_OP_CHECKOUT_YN		   ,'Y','checked','') CANCEL_OP_CHECKOUT_YN,"+
				"decode(CANCEL_AE_CHECKOUT_YN		   ,'Y','checked','') CANCEL_AE_CHECKOUT_YN,"+
				"decode(CANCEL_FOR_ADMISSION_YN		   ,'Y','checked','') CANCEL_FOR_ADMISSION_YN,"+ //<!--Added by Himanshu Saxena on 16-Jun-2023 for ML-MMOH-CRF-1972 -->
				"decode(REVERT_MO_RELEASE_YN		   ,'Y','checked','') REVERT_MO_RELEASE_YN,"+
				"decode(PRACT_OVERRIDE_REASON_YN		   ,'Y','checked','') PRACT_OVERRIDE_REASON_YN,"+
				"decode(REASON_FOR_LATE_DISCH_YN		   ,'Y','checked','') REASON_FOR_LATE_DISCH_YN,"+
				"decode(TRANS_EXCEED_REASON_YN		   ,'Y','checked','') TRANS_EXCEED_REASON_YN,"+
				"decode(CANCEL_EMBALM_YN		   ,'Y','checked','') CANCEL_EMBALM_YN,"+
				"decode(CANCEL_MEDICAL_REQUEST_YN	,'Y','checked','') cancel_medical_request_yn,"+ //Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719
				"decode(reject_request_mrp_yn	,'Y','checked','') reject_request_mrp_yn,"+ //Added by mujafar  for ML-MMOH-CRF-0713
				"decode(reject_report_mrp_yn	,'Y','checked','') reject_report_mrp_yn,"+ //Added by mujafar  for ML-MMOH-CRF-0714
				//Below line Added for this CRF ML-MMOH-CRF-0566
				"decode(REJECT_REF_REASON_YN	,'Y','checked','') reject_ref_reason_yn,"+
				"decode(CANCEL_REF_REASON_YN	,'Y','checked','') cancel_ref_reason_yn,"+
				//End ML-MMOH-CRF-0566	
				"decode(UNIT_TRANSFER_REASON_YN	,'Y','checked','') UNIT_TRANSFER_REASON_YN,"+//Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589
						"decode(BARCODE_SCANNING_YN ,'Y','checked','') BARCODE_SCANNING_YN,"+// Added for MMS-DM-CRF-0157 ON 20-MAR-2020 BY KAMATCHI S 
				"decode(exclude_yn,'Y','checked','') external_appl_reason_yn,"+//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
				/*Added By Dharma on 10th Mar 2020 against ML-MMOH-CRF-1473 Start*/
				"decode(RETURN_TO_HOD_BY_PRACT_YN	,'Y','checked','') RETURN_TO_HOD_BY_PRACT_YN,"+
				"decode(REJECTED_TO_MRD_BY_PRACT_YN	,'Y','checked','') REJECTED_TO_MRD_BY_PRACT_YN,"+
				"decode(REASON_BIOMETRIC_REJECTION_YN ,'Y','checked','') REASON_BIOMETRIC_REJECTION_YN,"+ //Added By Himanshu for AAKH-CRF-0175  US11
				/*Added By Dharma on 10th Mar 2020 against ML-MMOH-CRF-1473 End*/
				/*Added by lakshmanan for ML-MMOH-CRF-1955 on 01-07-2023 start */
				sqlMLC+
				/*Added by lakshmanan for ML-MMOH-CRF-1955 on 01-07-2023 end */
				"eff_status from am_contact_reason where contact_reason_code='"+code+"'";
// Above CANCEL_EMBALM_YN Added Against Bru-HIMS-CRF-348 [IN:038247] By Saanthaakumar
				  
		rset = stmt.executeQuery(sql);


		rset.next();
		code=rset.getString("contact_reason_code");
		reason=rset.getString("contact_reason");
		
		//eventFunctionForDate="OnBlur='CheckDate(this)'";
		
		visit_registration_yn	=rset.getString("visit_registration_yn"	);
		cancel_visit_yn			=rset.getString("cancel_visit_yn");
		book_appointment_yn		=rset.getString("book_appointment_yn"	);
		transfer_appointment_yn	=rset.getString("transfer_appointment_yn");
		cancel_appointment_yn	=rset.getString("cancel_appointment_yn"	);
		lift_schedule_yn		=rset.getString("lift_schedule_yn" );
		block_schedule_yn		=rset.getString("block_schedule_yn"		);
		cancel_schedule_yn		=rset.getString("cancel_schedule_yn"		);
		transfer_schedule_yn	=rset.getString("transfer_schedule_yn"	);
		reason_for_recall_yn	=rset.getString("reason_for_recall_yn");
		patient_depart_yn=rset.getString("patient_depart_yn");
		followup_of_referral_yn			=rset.getString("followup_of_referral_yn");
		rejection_of_referral_yn			=rset.getString("rejection_of_referral_yn");
		revise_visit_yn			=rset.getString("revise_visit_yn"	);
		CANCEL_TRANSFER_YN			=rset.getString("CANCEL_TRANSFER_YN"	);
		CHANGE_ADMISSION_DTLS_YN			=rset.getString("CHANGE_ADMISSION_DTLS_YN"	);

		CANCEL_DISCHARGE_YN		=rset.getString("CANCEL_DISCHARGE_YN"	);
		REGISTER_ATTENDANCE_YN			=rset.getString("REGISTER_ATTENDANCE_YN"	);
		
		
				reason_for_referral_yn    =rset.getString("reason_for_referral_yn" );
		cancel_wait_list_yn=rset.getString("cancel_wait_list_yn");
		modify_wait_list_yn=rset.getString("modify_wait_list_yn");
		CANCEL_OP_CHECKOUT_YN=rset.getString("CANCEL_OP_CHECKOUT_YN");
		CANCEL_AE_CHECKOUT_YN=rset.getString("CANCEL_AE_CHECKOUT_YN");
		
		cancel_For_admission_yn=rset.getString("CANCEL_FOR_ADMISSION_YN");  ////<!--Added by Himanshu Saxena on 16-Jun-2023 for ML-MMOH-CRF-1972-->
		
		REVERT_MO_RELEASE_YN=rset.getString("REVERT_MO_RELEASE_YN");
		CANCEL_EMBALM_YN=rset.getString("CANCEL_EMBALM_YN"); // Added Against Bru-HIMS-CRF-348 [IN:038247] By Saanthaakumar
		
		cancelMedReqYn = rset.getString("cancel_medical_request_yn"); //Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719
		rejectRequest_mrp = rset.getString("reject_request_mrp_yn"); //Added by Mujafar  for ML-MMOH-CRF-0713
		rejectReport_mrp = rset.getString("reject_report_mrp_yn"); //Added by Mujafar  for ML-MMOH-CRF-0714
//out.println("<script>alert('"+modify_wait_list_yn+"');</script>");

        //Below line Added for this CRF ML-MMOH-CRF-0566
		reject_referral_reason_yn = rset.getString("reject_ref_reason_yn");
		cancel_referral_reason_yn = rset.getString("cancel_ref_reason_yn");
	    //End ML-MMOH-CRF-0566
		
		//Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589
		UNIT_TRANSFER_REASON_YN = rset.getString("UNIT_TRANSFER_REASON_YN");
		//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
		external_appl_reason_yn = rset.getString("external_appl_reason_yn");
		// Added for MMS-DM-CRF-0157 ON 20-MAR-2020 BY KAMATCHI S
		BARCODE_SCANNING_YN	=rset.getString("BARCODE_SCANNING_YN");
		/*Added By Dharma on 10th Mar 2020 against ML-MMOH-CRF-1473 Start*/				
		return_to_hod_by_pract_yn = rset.getString("RETURN_TO_HOD_BY_PRACT_YN");
		rejected_to_mrd_by_pract_yn = rset.getString("REJECTED_TO_MRD_BY_PRACT_YN");
		/*Added By Dharma on 10th Mar 2020 against ML-MMOH-CRF-1473 End*/

		//Added By Himanshu for AAKH-CRF-0175 US11
		REASON_BIOMETRIC_REJECTION_YN	=rset.getString("REASON_BIOMETRIC_REJECTION_YN");
		
  cancel_booking_yn=rset.getString("cancel_booking_yn");
	cancel_admission_yn=rset.getString("cancel_admission_yn");
    cancel_discharge_advice_yn=rset.getString("cancel_discharge_advice_yn");
   reason_for_revise_bkg_yn=rset.getString("reason_for_revise_bkg_yn");
   pract_override_reason_yn=rset.getString("pract_override_reason_yn");
   trans_exceed_reason_yn=rset.getString("trans_exceed_reason_yn");
   
   /* Added by lakshmanan for ML-MMOH-CRF-1955 on 01-07-2023 start*/
   if(isMarkPatientMLC) {
   mark_mlc_yn=rset.getString("mark_mlc_yn");
   mark_nonmlc_yn=rset.getString("mark_nonmlc_yn");
   }
   /* Added by lakshmanan for ML-MMOH-CRF-1955 on 01-07-2023 end*/
   
   //emergency_transfer_yn=rset.getString("emergency_transfer_yn");
		//added for the CRF - Bru-HIMS-CRF-157
		late_discharge_reason_yn=rset.getString("REASON_FOR_LATE_DISCH_YN");
		effstatus=rset.getString("eff_status")==null?"":rset.getString("eff_status");
		if(effstatus.equals("D")){
			otherTextAttribute="READONLY";
			otherCheckAttribute="disabled";
			checkBoxAttribute="";
		}else{

			otherTextAttribute="";
			checkBoxAttribute="CHECKED";
		}
			     	if(rset!=null) 	rset.close();
				if(stmt!=null) 	stmt.close();
	    
		codeTextAttribute="READONLY";
		newcontactreason=false;
		eventFunctionForCase="";
	}

}catch(Exception e){out.print("Exception " + e);e.printStackTrace();}
finally{
	ConnectionManager.returnConnection(conn,request);
}
%> 
      	<form name='contactreason_form' id='contactreason_form' action='../../servlet/eAM.ContactReasonServlet' method='post' target='messageFrame'>
      	<div>

        <table border='0' cellpadding='0' cellspacing='0' width='auto' align='center'>
      	      	<tr>
      	        <td width='25%'></td>
      	        <td width='10%' ></td>
      	        <td width='25%'></td>
				<td width='10%'></td>
				<td width='25%'></td>
				<td width='10%' ></td>
				
      	        </tr>
      		<tr>
      		    <td  class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      		    <td class='fields' colspan='2'>&nbsp;<input type='text'   onBlur="makeValidString(this);changeCase(this)" onKeyPress="return CheckForSpecChars(event)"  name='contact_reason_code' id='contact_reason_code' value="<%=code%>" size='8' maxlength='8' <%=codeTextAttribute%> <%=eventFunctionForCase%>>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
      		    <td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
      	      	</tr>
      		<tr>
			<td   class='label'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>

<td  class='fields' colspan='2'>&nbsp;<textarea rows=2   name='contact_reason'  <%=otherTextAttribute%> cols=30 onKeypress="return CheckMaxLen(this)" onBlur="makeValidString(this);CheckMaxLength(this)"><%=reason%></textarea>&nbsp <img src='../../eCommon/images/mandatory.gif' align='center'></img>
		</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
      		</tr>
      		

      		<tr>
      		     <td  class='label'><!--width='40%'--><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
      		     <td   class='fields' colspan='2'>&nbsp;<input type='checkbox' name='eff_status' id='eff_status' value="<%=effstatus%>" <%=checkBoxAttribute%> onClick="change()">
      		     <td>&nbsp;</td>
				 <td>&nbsp;</td>
				 <td>&nbsp;</td>
				 <td>&nbsp;</td>
				 <td>&nbsp;</td>
      		     </td>
      		</tr>
      		
      	        <tr>
      	        <td class='CAHIGHERLEVELCOLOR' colspan='20'><font size='2'><b><fmt:message key="Common.ApplicableTo.label" bundle="${common_labels}"/></font></td>
      	        </tr>
		<tr>
		<td  align='left' class ='CAGROUPHEADING' colspan='20'><fmt:message key="eAM.AppointmentScheduling.label" bundle="${am_labels}"/></font></td>
		</tr>
      		<tr>
				<td class='label'><fmt:message key="Common.bookappointment.label" bundle="${common_labels}"/></td>
				<td class='fields'>&nbsp;<input type='checkbox' value="Y" name="book_appointment_yn1" id="book_appointment_yn1" <%=book_appointment_yn%> <%=otherCheckAttribute%>></td>
				<td class='label'><fmt:message key="Common.TransferAppointment.label" bundle="${common_labels}"/></td>
				<td class='fields'>&nbsp;<input type='checkbox' value="Y" name="transfer_appointment_yn1" id="transfer_appointment_yn1" <%=transfer_appointment_yn%> <%=otherCheckAttribute%>></td>
      	    
				<td class='label'><fmt:message key="Common.CancelAppointment.label" bundle="${common_labels}"/></td>
				<td class='fields'>&nbsp;<input type='checkbox' value="Y" name="cancel_appointment_yn1" id="cancel_appointment_yn1" <%=cancel_appointment_yn%> <%=otherCheckAttribute%>></td>
				<td class='label'><fmt:message key="Common.override.label" bundle="${common_labels}"/>&nbsp<fmt:message key="Common.Appointment.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.rule.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type='checkbox' value="Y" name="pract_override_reason_yn" id="pract_override_reason_yn" <%=pract_override_reason_yn%> <%=otherCheckAttribute%>></td>
				
				</tr>
				<tr>
				<td  class='label'><fmt:message key="eAM.BlockSchedule.label" bundle="${am_labels}"/></td>
				<td class='fields'>&nbsp;<input type='checkbox' value="Y" name="block_schedule_yn1" id="block_schedule_yn1" <%=block_schedule_yn%> <%=otherCheckAttribute%>></td>
      	   
				<td  class='label'><fmt:message key="eAM.LiftBlockonSchedule.label" bundle="${am_labels}"/></td>
				<td class='fields'>&nbsp;<input type='checkbox' value="Y" name="lift_schedule_yn1" id="lift_schedule_yn1" <%=lift_schedule_yn%> <%=otherCheckAttribute%>></td>
				<td  class='label'><fmt:message key="Common.CancelSchedule.label" bundle="${common_labels}"/></td>
				<td class='fields'>&nbsp;<input type='checkbox' value="Y" name="cancel_schedule_yn1" id="cancel_schedule_yn1" <%=cancel_schedule_yn%> <%=otherCheckAttribute%>></td>
      	   		<td class='label' nowrap><fmt:message key="Common.TransOverrideReason.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type='checkbox' value="Y" name="trans_exceed_reason_yn" id="trans_exceed_reason_yn" <%=trans_exceed_reason_yn%> <%=otherCheckAttribute%>></td>
      	   		</tr>

      		<tr>
				<td class='label'><fmt:message key="Common.TransferSchedule.label" bundle="${common_labels}"/></td>
				<td class='fields'>&nbsp;<input type='checkbox' value="Y" name="transfer_schedule_yn1" id="transfer_schedule_yn1" <%=transfer_schedule_yn%> <%=otherCheckAttribute%>></td>
				<td class='label'><fmt:message key="Common.CancelWaitList.label" bundle="${common_labels}"/> </td>
				<td class='fields'>&nbsp;<input type='checkbox' value="Y" name="cancel_wait_list_yn" id="cancel_wait_list_yn" <%=cancel_wait_list_yn%> <%=otherCheckAttribute%>></td>
				<!-- <td align='right' class='label'>&nbsp;</td>
				<td align='left'>&nbsp;</td> -->
      	    
				<td class='label'><fmt:message key="Common.CreateModifyWaitlist.label" bundle="${common_labels}"/></td>
				<td class='fields'>&nbsp;<input type='checkbox' value="Y" name="modify_wait_list_yn1" id="modify_wait_list_yn1" <%=modify_wait_list_yn%> <%=otherCheckAttribute%>></td>
				
				<!--Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1-->
				<td class='label'><fmt:message key="eAM.ExternalAppl.label" bundle="${am_labels}"/></td>
				<td class='fields'><input type='checkbox' value="Y" name="external_appl_reason_yn" id="external_appl_reason_yn" <%=external_appl_reason_yn%> <%=otherCheckAttribute%>></td>
			</tr>
		
		 
<tr>
		<td  align='left' class ='CAGROUPHEADING' colspan='20'><fmt:message key="eAM.ReferralManagement.label" bundle="${am_labels}"/></font></td>
		</tr> 
			<tr>
				<td class='label'><fmt:message key="Common.referral.label" bundle="${common_labels}"/> </td>
				<td class='fields'>&nbsp;<input type='checkbox' value="Y"
				name="reason_for_referral_yn1" id="reason_for_referral_yn1" 	<%=reason_for_referral_yn%>
				<%=otherCheckAttribute%> ></td>
	          	<td  class='label'><fmt:message key="eAM.RejectionofReferral.label" bundle="${am_labels}"/></td>
				<td class='fields'>&nbsp;<input type='checkbox' value="Y" name="rejection_of_referral_yn" id="rejection_of_referral_yn" <%=rejection_of_referral_yn%> <%=otherCheckAttribute%>></td>
      	    
			<!--Below line modified for this CRF ML-MMOH-CRF-0566 -->
      		
				<td  class='label'><fmt:message key="eAM.FollowupofReferral.label" bundle="${am_labels}"/></td>
				<td class='fields'>&nbsp;<input type='checkbox' value="Y" name="followup_of_referral_yn" id="followup_of_referral_yn" <%=followup_of_referral_yn%> <%=otherCheckAttribute%>></td>
				<td  class='label'><%if(referralRegister){%><fmt:message key="Common.ReasonforRejection.label" bundle="${common_labels}"/><%}else{%>&nbsp;<%}%></td>
				<td class='fields'><%if(referralRegister){%><input type='checkbox' value="Y" name="reject_referral_reason_yn" id="reject_referral_reason_yn" <%=reject_referral_reason_yn%> <%=otherCheckAttribute%>><%}%></td>
				</tr><tr></tr>
				<tr>
      	     
			 <%if(referralRegister){%>
			
				<td class='label'><fmt:message key="Common.ReasonforCancel.label" bundle="${common_labels}"/></td>
				<td class='fields'>&nbsp;<input type='checkbox' value="Y" name="cancel_referral_reason_yn" id="cancel_referral_reason_yn" <%=cancel_referral_reason_yn%> <%=otherCheckAttribute%>></td>
	          	<td  class='label'>&nbsp;</td>
				<td class='fields'>&nbsp;</td>
      	    </tr>
              <%}%>			 
			 <!--End this CRF ML-MMOH-CRF-0566-->
		<tr>
		<td  align='left' class ='CAGROUPHEADING' colspan='20'><fmt:message key="eAM.PatientMovementTracking.label" bundle="${am_labels}"/></font></td>
		</tr>
			<tr>
				<td  class='label'><fmt:message key="eAM.ReasonforDepart.label" bundle="${am_labels}"/> </td>
				<td class='fields'>&nbsp;<input type='checkbox' value="Y"
				name="patient_depart_yn1" id="patient_depart_yn1" 	<%=patient_depart_yn%>
				<%=otherCheckAttribute%> ></td>
	          	<td  class='label'></td>
				<td &nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
      	    </tr>
      		




		<tr>
		<td  align='left' class ='CAGROUPHEADING' colspan='20'><fmt:message key="eAM.OutpatientManagement.label" bundle="${am_labels}"/></font></td>
		</tr>
			<tr>
				<td  class='label'><fmt:message key="Common.RegisterVisit.label" bundle="${common_labels}"/></td>
				<td class='fields'>&nbsp;<input type='checkbox' value="Y" name="visit_registration_yn1" id="visit_registration_yn1" <%=visit_registration_yn%> <%=otherCheckAttribute%>></td>
				<td class='label'><fmt:message key="eAM.CancelVisit.label" bundle="${am_labels}"/></td>
				<td class='fields'>&nbsp;<input type='checkbox' value="Y" name="cancel_visit_yn1" id="cancel_visit_yn1" <%=cancel_visit_yn%> <%=otherCheckAttribute%>></td>
 
				<td  class='label'><fmt:message key="Common.ReviseVisit.label" bundle="${common_labels}"/></td>
				<td class='fields'>&nbsp;<input type='checkbox' value="Y" name="revise_visit_yn1" id="revise_visit_yn1" <%=revise_visit_yn%> <%=otherCheckAttribute%>></td>

				<td class='label'><fmt:message key="eAM.ReasonforRecall.label" bundle="${am_labels}"/></td>
				<td class='fields'><input type='checkbox' value="Y" name="reason_for_recall_yn1" id="reason_for_recall_yn1" <%= reason_for_recall_yn%> <%=otherCheckAttribute%>></td>
			 
			 </tr><tr></tr>
      		<tr>
			
				<td class='label'><fmt:message key="Common.CancelCheckout.label" bundle="${common_labels}"/></td>
				<td class='fields'>&nbsp;<input type='checkbox' value="Y" name="CANCEL_OP_CHECKOUT_YN" id="CANCEL_OP_CHECKOUT_YN" <%= CANCEL_OP_CHECKOUT_YN%> <%=otherCheckAttribute%>></td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				
			</tr>
    		
			 
		
		<tr>
		<td  align='left' class ='CAGROUPHEADING' colspan='20'><fmt:message key="eAM.InpatientManagement.label" bundle="${am_labels}"/></font></td>
		</tr>

      		<tr>
				<td class='label'><fmt:message key="Common.CancelBooking.label" bundle="${common_labels}"/></td>
				<td class='fields'>&nbsp;<input type='checkbox' value="Y" name="cancel_booking_yn1" id="cancel_booking_yn1" <%=cancel_booking_yn%> <%=otherCheckAttribute%>></td>
				<td  class='label'><fmt:message key="Common.CancelAdmission.label" bundle="${common_labels}"/></td>
				<td class='fields'>&nbsp;<input type='checkbox' value="Y" name="cancel_admission_yn1" id="cancel_admission_yn1" <%=cancel_admission_yn%> <%=otherCheckAttribute%>></td>
				<td  class='label'><fmt:message key="Common.CancelDischargeAdvice.label" bundle="${common_labels}"/></td>
				<td  class='fields'>&nbsp;<input type='checkbox' value="Y" name="cancel_discharge_advice_yn1" id="cancel_discharge_advice_yn1" <%=cancel_discharge_advice_yn%> <%=otherCheckAttribute%>></td>
				<td  class='label'><fmt:message key="eAM.ChangeAdmDtls.label" bundle="${am_labels}"/></td>
				<td  class='fields'><input type='checkbox' value="Y" name="CHANGE_ADMISSION_DTLS_YN" id="CHANGE_ADMISSION_DTLS_YN" <%=CHANGE_ADMISSION_DTLS_YN%>
				<%=otherCheckAttribute%>></td>
				
				</tr> 
				<tr>
				<td  class='label'><fmt:message key="Common.revisebooking.label" bundle="${common_labels}"/> </td>
				<td class='fields'> &nbsp;<input type='checkbox' value="Y"
				name="reason_for_revise_bkg_yn1" id="reason_for_revise_bkg_yn1"
				<%=reason_for_revise_bkg_yn%>
				<%=otherCheckAttribute%>></td>
		  
		
				<td  class='label'><fmt:message key="Common.CancelTransfer.label" bundle="${common_labels}"/></td>
				<td  class='fields'>&nbsp;<input type='checkbox' value="Y" name="cancel_transfer_yn" id="cancel_transfer_yn" <%=CANCEL_TRANSFER_YN%>
				<%=otherCheckAttribute%>></td>
	            <td class='label'><fmt:message key="Common.CancelDischarge.label" bundle="${common_labels}"/></td>
	            <td class='fields'>&nbsp;<input type='checkbox' value="Y" name="cancel_discharge_yn" id="cancel_discharge_yn" <%=CANCEL_DISCHARGE_YN%>
				<%=otherCheckAttribute%>></td>
				<td  class='label'><fmt:message key="eAM.LateDischarge.label" bundle="${am_labels}"/></td>
				<td  class='fields'><input type='checkbox' value="Y" name="late_discharge_reason_yn" id="late_discharge_reason_yn" <%=late_discharge_reason_yn%>
					<%=otherCheckAttribute%>></td>
			
				
				</tr> 
      	    <tr>
		<td  align='left' class ='CAGROUPHEADING' colspan='20'><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></font></td>
		</tr>
		<tr>
				<td  class='label'><fmt:message key="Common.RegisterAttendance.label" bundle="${common_labels}"/></td>
				<td class='fields'>&nbsp;<input type='checkbox' value="Y" name="REGISTER_ATTENDANCE_YN" id="REGISTER_ATTENDANCE_YN" <%=REGISTER_ATTENDANCE_YN%>
				<%=otherCheckAttribute%>></td>
	            <td class='label'><fmt:message key="Common.CancelCheckout.label" bundle="${common_labels}"/></td>
				<td class='fields'>&nbsp;<input type='checkbox' value="Y" name="CANCEL_AE_CHECKOUT_YN" id="CANCEL_AE_CHECKOUT_YN" <%= CANCEL_AE_CHECKOUT_YN%> <%=otherCheckAttribute%>></td>
      	     <!--Added by Himanshu Saxena on 16-Jun-2023 for ML-MMOH-CRF-1972 Starts-->
		<%if(isPendingForAdmissionAppl){%>
      	    <td class='label'><fmt:message key="Common.CancelForAdmission.label" bundle="${common_labels}"/></td>
			<td class='fields'>&nbsp;<input type='checkbox' value="Y" name="cancel_For_admission_yn" id="cancel_For_admission_yn" <%= cancel_For_admission_yn%> <%= otherCheckAttribute%>></td>
      	  <% } %>
      	    <!--Added by Himanshu Saxena on 16-Jun-2023 for ML-MMOH-CRF-1972 ends-->
      	    <td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
      	    </tr>
			<tr>
			<td  align='left' class ='CAGROUPHEADING' colspan='20'><fmt:message key="eMO.MortuaryManagement.label" bundle="${mo_labels}"/></font></td>
			</tr>
			<tr>
				<td  class='label'><fmt:message key="eMO.RevertReleasedBodyPart.label" bundle="${mo_labels}"/></td>
				<td class='fields'>&nbsp;<input type='checkbox' value="Y" name="REVERT_MO_RELEASE_YN" id="REVERT_MO_RELEASE_YN" <%=REVERT_MO_RELEASE_YN%>
				<%=otherCheckAttribute%>></td>	
				<!-- New TD Added Against Bru-HIMS-CRF-348 [IN:038247] By Saanthaakumar -->
				<td  class='label'><fmt:message key="eMO.CancelEmbalm.label" bundle="${mo_labels}"/></td>
				<td class='fields'>&nbsp;<input type='checkbox' value="Y" name="CANCEL_EMBALM_YN" id="CANCEL_EMBALM_YN" <%=CANCEL_EMBALM_YN%>
				<%=otherCheckAttribute%>></td>
				<td>&nbsp;</td>	
				<td>&nbsp;</td>	
				<td>&nbsp;</td>	
				<td>&nbsp;</td>		
                
				
      	    </tr>
			<!--Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719 Start-->
			<% if(isIncompReqCancelApplicable){ %>
				<tr>
					<td  align='left' class ='CAGROUPHEADING' colspan='20'><fmt:message key="eMR.MedicalReport.label" bundle="${mr_labels}"/></font></td>
				</tr>
				<tr>
					<td  class='label'><fmt:message key="Common.cancel.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Request.label" bundle="${common_labels}"/></td>
					<td class='fields'>&nbsp;<input type='checkbox' value="Y" name="cancel_med_request_yn" id="cancel_med_request_yn" <%=cancelMedReqYn%>
					<%=otherCheckAttribute%>></td>	
				<!--</tr>-->
			<% if(isRejectRequestApplicable){ %>
			
			
					<td  class='label'><fmt:message key="Common.Reject.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Request.label" bundle="${common_labels}"/></td>
					<td class='fields'>&nbsp;<input type='checkbox' value="Y" name="rejectRequest_mrp_yn" id="rejectRequest_mrp_yn" <%=rejectRequest_mrp%>
					<%=otherCheckAttribute%>></td>	
		
			
			<% } %>
			
			
			<% if(isRejectReportApplicable){ // added by mujafar for ML-MMOH-CRF-0714 %>
			
			<td  class='label'><fmt:message key="Common.Reject.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.report.label" bundle="${common_labels}"/></td>
					<td class='fields'>&nbsp;<input type='checkbox' value="Y" name="rejectReport_mrp_yn" id="rejectReport_mrp_yn" <%=rejectReport_mrp%>
					<%=otherCheckAttribute%>></td>
			</tr>
			<% } %>
			<!-- Added By Dharma on 10th Mar 2020 against ML-MMOH-CRF-1473 Start -->
			<tr>
			<td  class='label'><fmt:message key="eMR.RejectedbyPractitionertoMRD.label" bundle="${mr_labels}"/></td>
			<td  class='fields'>&nbsp;<input type='checkbox' value="Y" name="rejected_to_mrd_by_pract_yn" id="rejected_to_mrd_by_pract_yn" <%=rejected_to_mrd_by_pract_yn%>
					<%=otherCheckAttribute%>></td>
			<td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
			
<td  class='label'><fmt:message key="eMR.RejectedbyPractitionertoHOD.label" bundle="${mr_labels}"/></td>
			<td  class='fields'>&nbsp;<input type='checkbox' value="Y" name="return_to_hod_by_pract_yn" id="return_to_hod_by_pract_yn" <%=return_to_hod_by_pract_yn%>
					<%=otherCheckAttribute%>></td>
			
			<td  class='label'></td>
			<td  class='fields'></td>
			<!-- Added By Dharma on 10th Mar 2020 against ML-MMOH-CRF-1473 End -->
			</tr>
			<% } %>
			
			<!--End-->
			
			<!--Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589-->
			<tr>
			<td  align='left' class ='CAGROUPHEADING' colspan='20'><fmt:message key="eBT.Blood.label" bundle="${bt_labels}"/>&nbsp;<fmt:message key="Common.Transfer.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eBL.Service.label" bundle="${bl_labels}"/></font></td>
			</tr>
			<tr>
				<td  class='label'><fmt:message key="Common.Unit.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Transfer.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
				<td class='fields'>&nbsp;<input type='checkbox' value="Y" name="UNIT_TRANSFER_REASON_YN" id="UNIT_TRANSFER_REASON_YN" <%=UNIT_TRANSFER_REASON_YN%>
				<%=otherCheckAttribute%>></td>	
				<td>&nbsp;</td>	
				<td>&nbsp;</td>	
				<td>&nbsp;</td>	
				<td>&nbsp;</td>	
				<td>&nbsp;</td>
				<td>&nbsp;</td>	
      	    </tr>
			<!--End ML-MMOH-CRF-0589-->
            <% if(isBarcodeScanningApplicable){ // Added for MMS-DM-CRF-0157 on 26-MAR-2020 By KAMATCHI S %>
			<tr>
			<td  align='left' class ='CAGROUPHEADING' colspan='20'><fmt:message key="Common.Barcode.label" bundle="${common_labels}"/></font></td>
			</tr>
			<tr>
				<td  class='label'><fmt:message key="Common.Barcode.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Scanning.label" bundle="${common_labels}"/>&nbsp;</td>
				<td class='fields'>&nbsp;<input type='checkbox' value="Y" name="BARCODE_SCANNING_YN" id="BARCODE_SCANNING_YN" <%=BARCODE_SCANNING_YN%>
				<%=otherCheckAttribute%>></td>	
      	    </tr>
      	    	<% } %>
      	    <!-- Added by lakshmanan for ML-MMOH-CRF-1955 on 01-07-2023 start -->
      	    <% 
      	    if(isMarkPatientMLC || function_name.equals("01")) // function_name added by Himanshu
      	    { %>
      	    <tr>
			<td  align='left' class ='CAGROUPHEADING' colspan='20'><fmt:message key="eAM.MasterPatientIndex.label" bundle="${am_labels}"/></font></td>
			</tr>
			<tr>
			<%if(isMarkPatientMLC){%>
				<td  class='label'><fmt:message key="eAM.ReasontoMarkMLC.label" bundle="${am_labels}"/>&nbsp;</td>
				<td class='fields'>&nbsp;<input type='checkbox' value="Y" name="mark_mlc_yn" id="mark_mlc_yn" <%=mark_mlc_yn %>
				<%=otherCheckAttribute%>></td>
				<td  class='label'><fmt:message key="eAM.ReasontoMarkNonMLC.label" bundle="${am_labels}"/>&nbsp;</td>
				<td class='fields'>&nbsp;<input type='checkbox' value="Y" name="mark_nonmlc_yn" id="mark_nonmlc_yn" <%=mark_nonmlc_yn %>
				<%=otherCheckAttribute%>></td>	
				<%}%>
			<!--Added by Himanshu Saxena on 30-Jun-2023 for AAKH-CRF-0175  US11 Starts-->
      	  	 <%if(function_name.equals("01")){%>
				<td class='label'><fmt:message key="eAM.ReasonForBiometricRejection.label" bundle="${common_labels}"/>&nbsp;</td>
			<td class='fields'>&nbsp;<input type='checkbox' value="Y" name="REASON_BIOMETRIC_REJECTION_YN" id="REASON_BIOMETRIC_REJECTION_YN" <%=REASON_BIOMETRIC_REJECTION_YN%> <%= otherCheckAttribute%>></td>
      	   	<%}%>
      	    <!--Added by Himanshu Saxena on 30-Jun-2023 for AAKH-CRF-0175 Ends-->
      	    	<td>&nbsp;</td>	
				<td>&nbsp;</td>	
				<td>&nbsp;</td>	
				<td>&nbsp;</td>	
      	    </tr>	
			<% } %>
			<!-- Added by lakshmanan for ML-MMOH-CRF-1955 on 01-07-2023 end  -->
      	</table>
      	</div>
    <%  if(newcontactreason){%>

      	<input type='hidden' name='function' id='function' value='insert'>
      	<input type='hidden' name='function_name' id='function_name' value='insert'>

      <%}else{%>

      	<input type='hidden' name='function' id='function' value='modify'>
      	<input type='hidden' name='function_name' id='function_name' value='modify'>
     <%}%>


		<input type='hidden' name="visit_registration_yn" id="visit_registration_yn"	 value="">
		<input type='hidden' name="cancel_visit_yn" id="cancel_visit_yn"			 value="">
		<input type='hidden' name="book_appointment_yn" id="book_appointment_yn"	 	 value="">
		<input type='hidden' name="transfer_appointment_yn" id="transfer_appointment_yn"	 value="">
		<input type='hidden' name="cancel_appointment_yn" id="cancel_appointment_yn"	 value="">
		<input type='hidden' name="lift_schedule_yn" id="lift_schedule_yn"		 value="">
		<input type='hidden' name="block_schedule_yn" id="block_schedule_yn"		 value="">
		<input type='hidden' name="cancel_schedule_yn" id="cancel_schedule_yn"		 value="">
		<input type='hidden' name="cancel_wait_list_yn " id="cancel_wait_list_yn "		 value="">
		<input type='hidden' name="transfer_schedule_yn" id="transfer_schedule_yn"	 value="">
		<input type='hidden' name="revise_visit_yn" id="revise_visit_yn"			 value="">
		<input type='hidden' name="reason_for_recall_yn" id="reason_for_recall_yn"			 value="">
		<input type='hidden'name="reason_for_referral_yn" id="reason_for_referral_yn"  	 value="">
		<input type='hidden'name="modify_wait_list_yn" id="modify_wait_list_yn"  	 value="">
		
		<input type='hidden'name="patient_depart_yn" id="modify_wait_list_yn"   	 value="">

		<input type='hidden' name="followup_of_referral_yn1" id="followup_of_referral_yn1"  	 value="">
		<input type='hidden' name="rejection_of_referral_yn1" id="rejection_of_referral_yn1"  	 value="">
		
		
		<input type='hidden' name="cancel_booking_yn" id="cancel_booking_yn"		 value="">
		<input type='hidden' name="cancel_admission_yn" id="cancel_admission_yn"	 	 value="">
		<!-- <input type='hidden' name="cancel_transfer_yn" id="cancel_transfer_yn"	 	 value=""> -->

	
		<input type='hidden' name="cancel_discharge_advice_yn" id="cancel_discharge_advice_yn" value="">
		<input type='hidden' name ="reason_for_revise_bkg_yn"  id ="reason_for_revise_bkg_yn" value="">
		
		<input type='hidden' name ="isIncompReqCancelApplicable" id ="isIncompReqCancelApplicable" value="<%=isIncompReqCancelApplicable%>"><!--Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719-->
	<input type='hidden' name ="isRejectRequestApplicable" id ="isRejectRequestApplicable" value="<%=isRejectRequestApplicable%>"><!--Added by Mujafar for ML-MMOH-CRF-0713-->
	<input type='hidden' name ="isRejectReportApplicable"  id ="isRejectReportApplicable"  value="<%=isRejectReportApplicable%>"><!--Added by Mujafar for ML-MMOH-CRF-0714-->
	<input type='hidden' name ="isBarcodeScanningApplicable" id ="isBarcodeScanningApplicable" value="<%=isBarcodeScanningApplicable%>"><!--Added for MMS-DM-CRF-0157 on 26-MAR-2020 By KAMATCHI S -->
	<input type='hidden' name ="isPendingForAdmissionAppl" id ="isPendingForAdmissionAppl" value="<%=isPendingForAdmissionAppl%>"> <!--Added by Himanshu Saxena on 16-Jun-2023 for ML-MMOH-CRF-1972 Starts-->
	<input type='hidden' name ="isBiometricRejectionAppl" id ="isBiometricRejectionAppl" value="<%=isBiometricRejectionAppl%>"> <!--Added by Himanshu Saxena on 30-Jun-2023 for AAKH-CRF-0175 Ends-->
	<input type='hidden' name ="function_name_biometric_rej" id ="function_name_biometric_rej" value="<%=function_name%>"><!--Added by Himanshu Saxena on 30-Jun-2023 for AAKH-CRF-0175 Ends-->
	<!--Below line added for this CRF ML-MMOH-CRF-0566-->
		<input type='hidden' name="referralRegister" id="referralRegister" value="<%=referralRegister%>">
		<!--End this CRF ML-MMOH-CRF-0566-->
	<!-- Added by lakshmanan For ML-MMOH-CRF-1955 on 01-07-2023 -->
	<input type='hidden' name ="isMarkPatientMLC"  id ="isMarkPatientMLC"  value="<%=isMarkPatientMLC%>">
      	</form>
      	</body>
      	</html>

