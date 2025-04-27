<!DOCTYPE html>

<%--
	FileName	: ContactReasonQueryResult.jsp
	Version	    : 3	
	Modified On	: 19-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>

<HTML>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<BODY OnMouseDown='CodeArrest()'   class='CONTENT' onKeyDown = 'lockKey()' >

<%
	request.setCharacterEncoding("UTF-8");
	
//Below line added for this CRF ML-MMOH-CRF-0566
  Boolean referralRegister = false;
  Boolean isIncompReqCancelApplicable	= false;
  Boolean isRejectRequestApplicable = false;
  Boolean isRejectReportApplicable = false; //Added by Shaik Mujafar for ML-MMOH-CRF-0714
  Boolean isBarcodeScanningApplicable = false;//Added on 26-MAR-2020 FOR MMS-DM-CRF-0157 BY KAMATCHI S
  Boolean isMarkPatientMLC = false; // Added by lakhsmanan for ML-MMOH-CRF-1955 on 12-07-2023 
  Boolean isPendingForAdmissionAppl=false; //Added by Himanshu Saxena on 12-07-2023  for ML-MMOH-CRF-1972 Starts-->
  Boolean isBiometricRejectionAppl=false; //	<!--Added by Himanshu Saxena on 30-Jun-2023 for AAKH-CRF-0175  US11 Starts-->
//<!--Added by Himanshu Saxena on 30-Jun-2023 for AAKH-CRF-0175 US1 Starts-->
PreparedStatement pstmt_rh=null ;
ResultSet rs_rh=null;
String function_name="";
	//<!--Added by Himanshu Saxena on 30-Jun-2023 for AAKH-CRF-0175 US1 ends-->
	 
  Connection conn = null;
try {	
	conn = ConnectionManager.getConnection(request);
	//Below line added for this CRF ML-MMOH-CRF-0566
	referralRegister = eCommon.Common.CommonBean.isSiteSpecific(conn, "IP", "RECNL_REFERRAL_REGISTER");
	isIncompReqCancelApplicable =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","AUTO_CANCEL_INCOMPLETE_REQUEST");//Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719
	isRejectRequestApplicable =    eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","REJECT_REQUEST_MRP"); //Added by Shaik Mujafar for ML-MMOH-CRF-0713
	isRejectReportApplicable =    eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","REJECT_REPORT_MRP"); //Added by Shaik Mujafar for ML-MMOH-CRF-0714
	isBarcodeScanningApplicable = eCommon.Common.CommonBean.isSiteSpecific(conn, "AM", "BARCODE_SCANNING_APPLICABLE");//Added on 26-MAR-2020 FOR MMS-DM-CRF-0157 BY KAMATCHI S
	
	isMarkPatientMLC=eCommon.Common.CommonBean.isSiteSpecific(conn,"MP","MARK_PATIENT_MLC"); // Added by lakhsmanan for ML-MMOH-CRF-1955 on 12-07-2023
	isPendingForAdmissionAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "AE", "AE_FOR_ADMISSION_TAB"); //Added by Himanshu Saxena on 12-07-2023  for ML-MMOH-CRF-1972-->
	
	isBiometricRejectionAppl=  eCommon.Common.CommonBean.isSiteSpecific(conn, "AE", "SMART_CARD_INTG"); //	<!--Added by Himanshu Saxena on 30-Jun-2023 for AAKH-CRF-0175  US11 Starts-->
	//<!--Added by Himanshu Saxena on 30-Jun-2023 for AAKH-CRF-0175 US11 Starts-->
   	//isBiometricRejectionAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "AE", "SMART_CARD_INTG");   
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

} catch (Exception e) {
       e.printStackTrace();
}
//End this CRF ML-MMOH-CRF-0566
	

	String whereClause = request.getParameter("whereclause");

	StringBuffer sbQuery = new StringBuffer();
	String from = request.getParameter( "from" ) ;

	String to = request.getParameter( "to" ) ;


	if ( (whereClause == null || whereClause.equals("")) )
	{
	String cd    = request.getParameter("contact_reason_code")==null ?"":request.getParameter("contact_reason_code");
	String desc    = request.getParameter("contact_reason_desc")==null ?"":request.getParameter("contact_reason_desc");
	String enabled    = request.getParameter("nature")==null ?"":request.getParameter("nature");
	String applicable = request.getParameter("applicable") == null?"":request.getParameter("applicable");

	int andCheck = 0;

	if ( !(cd == null || cd.equals("")) )
			{
			cd=cd.toUpperCase();
			sbQuery.append("where upper(contact_reason_code) like upper('"+cd+"%')");
			andCheck = 1;
			}
	
		if ( !(desc == null || desc.equals("")) )
			{
				if ( andCheck == 1 )
				{	
					sbQuery.append("and ");
					sbQuery.append(" upper(contact_reason)  like  upper('"+desc+"%') ");
				}
				else
				{
					sbQuery.setLength(0);
					sbQuery.append("where upper(contact_reason)  like upper('"+desc+"%') ");
					andCheck = 1;
				}
			}
	
		
		if ( !(enabled == null || enabled.equals("")) )
		{
		   if ( enabled.equals("E") )
		        {
			if ( andCheck == 0 )
					{
				sbQuery.setLength(0);
				sbQuery.append("where eff_status='E'");
				andCheck = 1;
					}
			else
				{
				//sbQuery.setLength(0);
				sbQuery.append(" and eff_status='E'");
					}
				}
		   if ( enabled.equals("D") )
			{
			if ( andCheck == 0 )
				{
				sbQuery.setLength(0);
				sbQuery.append(" where  eff_status='D'");
				andCheck = 1;
				}
			else
				{
				sbQuery.append(" and eff_status='D'");
				}
		}
		
	}


		if ( !(applicable == null || applicable.equals("")) )
		{
		   if ( applicable.equals("1") )
		        {
			if ( andCheck == 0 )
					{
				sbQuery.setLength(0);	
				sbQuery.append("where BOOK_APPOINTMENT_YN='Y'");	
					}
			else
					{
				sbQuery.append(" and BOOK_APPOINTMENT_YN='Y'");
					}
			}
		   if ( applicable.equals("2") )
			{
			if ( andCheck == 0 )
				{
				sbQuery.setLength(0);	
				sbQuery.append(" where  TRANSFER_APPOINTMENT_YN='Y'");
				}
			else
				{
				sbQuery.append(" and TRANSFER_APPOINTMENT_YN='Y'");
				}
		}
		
		if ( applicable.equals("3") )
			{
				if ( andCheck == 0 )
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where  CANCEL_APPOINTMENT_YN='Y'");
				}
				else
				{
					sbQuery.append(" and CANCEL_APPOINTMENT_YN='Y'");
				}
			}
			
			if ( applicable.equals("4") )
			{
				if ( andCheck == 0 )
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where  BLOCK_SCHEDULE_YN='Y'");
				}
				else
				{
					sbQuery.append(	" and BLOCK_SCHEDULE_YN='Y'");
				}
			}
			
			if ( applicable.equals("5") )
			{
				if ( andCheck == 0 )
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where  CANCEL_SCHEDULE_YN='Y'");
				}
				else
				{
					sbQuery.append(" and CANCEL_SCHEDULE_YN='Y'");
				}
			}	
			
			if ( applicable.equals("6") )
			{
				if ( andCheck == 0 )
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where  TRANSFER_SCHEDULE_YN='Y'");	
				}
				else{
					sbQuery.append("and TRANSFER_SCHEDULE_YN='Y'");
				}
			}
			
			if ( applicable.equals("7") )
			{
				if ( andCheck == 0 )
				{
						sbQuery.setLength(0);	
						sbQuery.append(" where  LIFT_SCHEDULE_YN='Y'");
				}
				else
				{
					sbQuery.append(" and LIFT_SCHEDULE_YN='Y'");
				}
			}
			if ( applicable.equals("8") )
			{
				if ( andCheck == 0 )
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where  VISIT_REGISTRATION_YN='Y'");
				}
				else
				{
					sbQuery.append(" and VISIT_REGISTRATION_YN='Y'");
				}
			}
			
			if ( applicable.equals("9") )
			{
				if ( andCheck == 0 )
				{
					sbQuery.setLength(0);	
					sbQuery.append(	" where  REVISE_VISIT_YN='Y'");
				}
				else
				{
					sbQuery.append(" and REVISE_VISIT_YN='Y'");
				}
			}

			if(applicable.equals("10"))
			{
				if( andCheck == 0)
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where REASON_FOR_REFERRAL_YN='Y'");
				}
		else
				{
				sbQuery.append(" and REASON_FOR_REFERRAL_YN='Y'");
				}
			}
			if ( applicable.equals("11") )
			{
				if ( andCheck == 0 )
				{
					sbQuery.setLength(0);	
					sbQuery.append(	" where  CANCEL_VISIT_YN='Y'");
				}
				else
				{
					sbQuery.append(	" and CANCEL_VISIT_YN='Y'");
				}
			}
			if ( applicable.equals("12") )
			{
				if ( andCheck == 0 )
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where  cancel_booking_yn='Y'");
				}
				else
				{
					sbQuery.append("and cancel_booking_yn='Y'");
				}
			}
			if ( applicable.equals("13") )
			{
				if ( andCheck == 0 )
				{
					sbQuery.setLength(0);	
					sbQuery.append("where  cancel_admission_yn='Y'");
				}
				else
				{
					sbQuery.append(" and cancel_admission_yn='Y'");
				}
			}
			
			if ( applicable.equals("14") )
			{
				if ( andCheck == 0 )
				{
					sbQuery.setLength(0);	
					sbQuery.append("where  cancel_discharge_advice_yn='Y'");
				}
				else
				{
					sbQuery.append(" and cancel_discharge_advice_yn='Y'");
				}
			}	
			
			if (applicable.equals("15"))
			{
				if( andCheck == 0)
				{
						sbQuery.setLength(0);	
						sbQuery.append(" where REASON_FOR_REVISE_BKG_YN='Y'");
				}
				else
				{
						sbQuery.setLength(0);	
						sbQuery.append(" and REASON_FOR_REVISE_BKG_YN='Y'");
				}
			}
			if (applicable.equals("16"))
			{
				if( andCheck == 0)
				{
						sbQuery.setLength(0);	
						sbQuery.append(" where CANCEL_TRANSFER_YN='Y'");
				}
				else
				{
					//sbQuery.setLength(0);	
					sbQuery.append("and CANCEL_TRANSFER_YN='Y'"); 	
				}
			}
			if (applicable.equals("17"))
			{
				if( andCheck == 0)
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where REGISTER_ATTENDANCE_YN='Y'");
				}
				else
				{
					//sbQuery.setLength(0);	
					sbQuery.append("and REGISTER_ATTENDANCE_YN='Y'");
				}
			}
			if (applicable.equals("18"))
			{
				if( andCheck == 0)
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where REASON_FOR_RECALL_YN='Y'");
				}
				else
				{

					//sbQuery.setLength(0);	
					sbQuery.append( " and REASON_FOR_RECALL_YN='Y'");
				}
			}

/**************ADD******/
			if(applicable.equals("19"))
			{
				if( andCheck == 0)
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where CANCEL_WAIT_LIST_YN='Y'");
				}
				else
				{
					//sbQuery.setLength(0);	
					sbQuery.append( " and CANCEL_WAIT_LIST_YN='Y'");
				}
			}

			if(applicable.equals("20"))
			{
				if( andCheck == 0)
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where MODIFY_WAIT_LIST_YN='Y'");
				}
				else
				{
					//sbQuery.setLength(0);	
					sbQuery.append( " and MODIFY_WAIT_LIST_YN='Y'");
				}
			}

			if(applicable.equals("21"))
			{
				if( andCheck == 0)
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where -FOLLOWUP_OF_REFERRAL_YN='Y'");
				}
				else
				{
					//sbQuery.setLength(0);	
					sbQuery.append( " and -FOLLOWUP_OF_REFERRAL_YN='Y'");
				}
			}

			if(applicable.equals("22"))
			{
				if( andCheck == 0)
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where PATIENT_DEPART_YN='Y'");
				}
				else
				{
					//sbQuery.setLength(0);	
					sbQuery.append( " and PATIENT_DEPART_YN='Y'");
				}
			}
			
			if(applicable.equals("23"))
			{
				if( andCheck == 0)
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where REJECTION_OF_REFERRAL_YN='Y'");
				}
				else
				{
					//sbQuery.setLength(0);	
					sbQuery.append( " and REJECTION_OF_REFERRAL_YN='Y'");
				}
			}

			if(applicable.equals("24"))
			{
				if( andCheck == 0)
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where CANCEL_AE_CHECKOUT_YN='Y'");
				}
				else
				{
					//sbQuery.setLength(0);	
					sbQuery.append( " and CANCEL_AE_CHECKOUT_YN='Y'");
				}
			}

			if(applicable.equals("25"))
			{
				if( andCheck == 0)
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where CANCEL_OP_CHECKOUT_YN='Y'");
				}
				else
				{
					//sbQuery.setLength(0);	
					sbQuery.append( " and CANCEL_OP_CHECKOUT_YN='Y'");
				}
			}

			

			if(applicable.equals("26"))
			{
				if( andCheck == 0)
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where CHANGE_ADMISSION_DTLS_YN='Y'");
				}
				else
				{
					//sbQuery.setLength(0);	
					sbQuery.append( " and CHANGE_ADMISSION_DTLS_YN='Y'");
				}
			}

			if(applicable.equals("27"))
			{
				if( andCheck == 0)
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where REVERT_MO_RELEASE_YN='Y'");
				}
				else
				{
					//sbQuery.setLength(0);	
					sbQuery.append( " and REVERT_MO_RELEASE_YN='Y'");
				}
			}

			if(applicable.equals("28"))
			{
				if( andCheck == 0)
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where REASON_FOR_LATE_DISCH_YN='Y'");
				}
				else
				{
					
					sbQuery.append( " and REASON_FOR_LATE_DISCH_YN='Y'");
				}
			}

			if(applicable.equals("29"))
			{
				if( andCheck == 0)
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where PRACT_OVERRIDE_REASON_YN='Y'");
				}
				else
				{
					
					sbQuery.append( " and PRACT_OVERRIDE_REASON_YN='Y'");
				}
			}

			if(applicable.equals("30"))
			{
				if( andCheck == 0)
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where TRANS_EXCEED_REASON_YN='Y'");
				}
				else
				{
					
					sbQuery.append( " and TRANS_EXCEED_REASON_YN='Y'");
				}
			}
			// Below Condition Added Against Bru-HIMS-CRF-348 [IN:038247] By Saanthaakumar
			if(applicable.equals("31"))
			{
				if( andCheck == 0)
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where CANCEL_EMBALM_YN='Y'");
				}
				else
				{
					sbQuery.append( " and CANCEL_EMBALM_YN='Y'");
				}
			}
			
			/*Below line added for this CRF ML-MMOH-CRF-0566*/
			if(referralRegister && isIncompReqCancelApplicable && isRejectRequestApplicable && isRejectReportApplicable){
			
			        if(applicable.equals("32"))
					{
						if( andCheck == 0)
						{
							sbQuery.setLength(0);	
							sbQuery.append(" where CANCEL_MEDICAL_REQUEST_YN='Y'");
						}
						else
						{
							
							sbQuery.append( " and CANCEL_MEDICAL_REQUEST_YN='Y'");
						}
					}
					if(applicable.equals("33"))
					{
						if( andCheck == 0)
						{
							sbQuery.setLength(0);	
							sbQuery.append(" where REJECT_REF_REASON_YN='Y'");
						}
						else
						{
							
							sbQuery.append( " and REJECT_REF_REASON_YN='Y'");
						}
					}
					if(applicable.equals("34"))
					{
						if( andCheck == 0)
						{
							sbQuery.setLength(0);	
							sbQuery.append(" where CANCEL_REF_REASON_YN='Y'");
						}
						else
						{
							
							sbQuery.append( " and CANCEL_REF_REASON_YN='Y'");
						}
					}
					
					if(applicable.equals("35"))
					{
						if( andCheck == 0)
						{
							sbQuery.setLength(0);	
							sbQuery.append(" where reject_request_mrp_yn='Y' ");
						}
						else
						{
							
							sbQuery.append( " and reject_request_mrp_yn='Y' ");
						}
					}
				
					if(applicable.equals("36"))
					{
						if( andCheck == 0)
						{
							sbQuery.setLength(0);	
							sbQuery.append(" where reject_report_mrp_yn='Y' ");
						}
						else
						{
							
							sbQuery.append( " and reject_report_mrp_yn='Y' ");
						}
					}

					/*Added By Dharma on 11th Mar 2020 against ML-MMOH-CRF-1473 Start*/
					
					if(applicable.equals("37"))
					{
						if( andCheck == 0)
						{
							sbQuery.setLength(0);	
							sbQuery.append(" where rejected_to_mrd_by_pract_yn='Y'");
						}
						else
						{
							
							sbQuery.append( " and rejected_to_mrd_by_pract_yn='Y'");
						}
					}
					if(applicable.equals("38"))
					{
						if( andCheck == 0)
						{
							sbQuery.setLength(0);	
							sbQuery.append(" where return_to_hod_by_pract_yn='Y'");
						}
						else
						{
							
							sbQuery.append( " and return_to_hod_by_pract_yn='Y'");
						}
					}
					/*Added By Dharma on 11th Mar 2020 against ML-MMOH-CRF-1473 End*/
					//Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589
					if(applicable.equals("39"))
					{
						if( andCheck == 0)
						{
							sbQuery.setLength(0);	
							sbQuery.append(" where UNIT_TRANSFER_REASON_YN='Y'");
						}
						else
						{
							
							sbQuery.append( " and UNIT_TRANSFER_REASON_YN='Y'");
						}
					}

					//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
					if(applicable.equals("40"))
					{
						if( andCheck == 0)
						{
							sbQuery.setLength(0);	
							sbQuery.append(" where exclude_yn='Y'");
						}
						else
						{
							
							sbQuery.append( " and exclude_yn='Y'");
						}
					}
			    
			}//Added on 26-MAR-2020 FOR MMS-DM-CRF-0157 BY KAMATCHI S
			else if(isBarcodeScanningApplicable){

				 	if(applicable.equals("32"))
					{
						if( andCheck == 0)
						{
							sbQuery.setLength(0);	
							sbQuery.append(" where UNIT_TRANSFER_REASON_YN='Y'");
						}
						else
						{
							
							sbQuery.append( " and UNIT_TRANSFER_REASON_YN='Y'");
						}
					}
				
				if(applicable.equals("33"))
				{
					if( andCheck == 0)
					{
						
						sbQuery.setLength(0);	
						sbQuery.append(" where BARCODE_SCANNING_YN='Y' ");
					}
					else
					{
						
						sbQuery.append( " and BARCODE_SCANNING_YN ='Y' ");
					}
				}

				//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
				if(applicable.equals("34"))
				{
					if( andCheck == 0)
					{
						sbQuery.setLength(0);	
						sbQuery.append(" where exclude_yn='Y'");
					}
					else
					{
						
						sbQuery.append( " and exclude_yn='Y'");
					}
				}
			}
			else
			{
				//Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589
					if(applicable.equals("32"))
					{
						if( andCheck == 0)
						{
							sbQuery.setLength(0);	
							sbQuery.append(" where UNIT_TRANSFER_REASON_YN='Y'");
						}
						else
						{
							
							sbQuery.append( " and UNIT_TRANSFER_REASON_YN='Y'");
						}
					}

					//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
					if(applicable.equals("33"))
					{
						if( andCheck == 0)
						{
							sbQuery.setLength(0);	
							sbQuery.append(" where exclude_yn='Y'");
						}
						else
						{
							
							sbQuery.append( " and exclude_yn='Y'");
						}
					}
			}
			//End this CRF ML-MMOH-CRF-0566
			/***********END**********/
			/*Added by lakhsmanan for ML-MMOH-CRF-1955 on 12-07-2023 start*/
		if (isMarkPatientMLC) {
			if(applicable.equals("41"))
					{
						if( andCheck == 0)
						{
							sbQuery.setLength(0);	
							sbQuery.append(" where MARK_MLC_YN='Y'");
						}
						else
						{
							
							sbQuery.append( " and MARK_MLC_YN='Y'");
						}
					}
					if(applicable.equals("42"))
					{
						if( andCheck == 0)
						{
							sbQuery.setLength(0);	
							sbQuery.append(" where MARK_NONMLC_YN='Y'");
						}
						else
						{
							
							sbQuery.append( " and MARK_NONMLC_YN='Y'");
						}
					}
		}
		/*Added by lakhsmanan for ML-MMOH-CRF-1955 on 12-07-2023 end */
		
	//<!--Added by Himanshu Saxena on 12-07-2023  for ML-MMOH-CRF-1972 starts--> 
		if(isPendingForAdmissionAppl)
		{
			if(applicable.equals("43"))
					{
						if( andCheck == 0)
						{
							sbQuery.setLength(0);	
							sbQuery.append(" where CANCEL_FOR_ADMISSION_YN='Y'");
						}
						else
						{
							
							sbQuery.append( " and CANCEL_FOR_ADMISSION_YN='Y'");
						}
					}
		}
	//	<!--Added by Himanshu Saxena on 30-Jun-2023 for AAKH-CRF-0175  US11 Starts-->
	if(function_name.equals("01"))
	{
		if(applicable.equals("44"))
		{
			if( andCheck == 0)
			{
				sbQuery.setLength(0);	
				sbQuery.append(" where REASON_BIOMETRIC_REJECTION_YN='Y'");
			}
			else
			{
				
				sbQuery.append( " and REASON_BIOMETRIC_REJECTION_YN='Y'");
			}
		}
		
	}
	//	<!--Added by Himanshu Saxena on 30-Jun-2023 for AAKH-CRF-0175  US11 Ends-->	
	}
	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
	{
			sbQuery.append( " order by ");

		for ( int i=0;i < ord.length;i++ )
	 	{
	 	if ( i == ord.length - 1 )
			sbQuery.append(ord[i]);
		else
				sbQuery.append(ord[i]+",");
		}
	}
	} //end of where clause IF
	else {
			sbQuery.setLength(0);	
			sbQuery.append( whereClause);
	//	sql = whereClause;

	}

	int start = 0 ;
	int end = 0 ;
	int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;
		

Statement stmt=null;
ResultSet rs=null;
int maxRecord = 0;

try{
//conn = ConnectionManager.getConnection(request);


String strsql2="select * from am_contact_reason "+sbQuery.toString();
stmt = conn.createStatement();
 
rs = stmt.executeQuery(strsql2);

	 if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;
	  }

	  while ( i<=end && rs.next()  )
	{
		  if(maxRecord==0)
		{

%>
<p>
<table align='right'>
<tr>
<%
if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/ContactReasonQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/ContactReasonQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
%>
</tr>
</table>
	<br><br>
</p>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th class='columnheader'><fmt:message key="Common.ReasonCode.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.ReasonDescription.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<% }
 	
String classValue = "" ;
       if ( i % 2 == 0 )
       		classValue = "QRYEVEN" ;
       	else
		classValue = "QRYODD" ;


	out.println("<tr><td class='" + classValue + "'>");
	String code = rs.getString("contact_reason_code");
	
	out.println("<a href='../../eAM/jsp/addModifyContactReason.jsp?contact_reason_code="+ code + "' target='f_query_add_mod' >");
	out.println(code+"</a></td><td class='" + classValue + "'>");
	out.println( rs.getString("contact_reason") );
	out.println("</td>");
	
	out.println("<td align='center' class='" + classValue + "'>");
	if ( rs.getString("eff_status").equals("E") )
		out.print("<img src='../../eCommon/images/enabled.gif'></img>");
	else if ( rs.getString("eff_status").equals("D") )
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	i++;
	maxRecord++;

  }//endwhile

  if(maxRecord == 0)
{%>
	<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>
<%}

if ( maxRecord < 14 || (!rs.next()) ) {
%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='hidden';
	</script>
<% 
		} else {%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='visible';
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}

		if(rs!=null)	rs.close();
		if(stmt!=null)	stmt.close();
}catch(Exception e){
		e.toString();
}
	finally   {
	
		ConnectionManager.returnConnection(conn,request);

	}
%>

</td></tr>
</table>
<br>
</BODY>
</HTML>

