<!DOCTYPE html>
<%--
	FileName	: ContactReasonQueryCriteria.jsp
	Version	    : 3	
	Modified On	: 19-2-2005
--%>

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></html></head>

<%
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null ;
Boolean isIncompReqCancelApplicable	= false;
Boolean referralRegister = false;
Boolean isRejectRequestApplicable = false;
Boolean isRejectReportApplicable =  false; //Added by Shaik Mujafar for ML-MMOH-CRF-0714
Boolean isBarcodeScanningApplicable = false;//Added on 26-MAR-2020 FOR MMS-DM-CRF-0157 BY KAMATCHI S
Boolean isMarkPatientMLC=false;  // Added by lakshmanan for ML-MMOH-CRF-1955 as on 12-07-2023 
Boolean isPendingForAdmissionAppl=false; //Added by Himanshu Saxena on 12-07-2023  for ML-MMOH-CRF-1972 Starts-->
Boolean isBiometricRejectionAppl=false; //	<!--Added by Himanshu Saxena on 30-Jun-2023 for AAKH-CRF-0175  US11 Starts-->
//<!--Added by Himanshu Saxena on 30-Jun-2023 for AAKH-CRF-0175 US1 Starts-->
PreparedStatement pstmt_rh=null ;
ResultSet rs_rh=null;
String function_name="";
	//<!--Added by Himanshu Saxena on 30-Jun-2023 for AAKH-CRF-0175 US1 ends-->

try {
	//con = (Connection) session.getValue( "connection" );
	con = ConnectionManager.getConnection(request);
	isIncompReqCancelApplicable =  eCommon.Common.CommonBean.isSiteSpecific(con,"MR","AUTO_CANCEL_INCOMPLETE_REQUEST");//Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719
	isRejectRequestApplicable =    eCommon.Common.CommonBean.isSiteSpecific(con,"MR","REJECT_REQUEST_MRP"); //Added by Shaik Mujafar for ML-MMOH-CRF-0713
	isRejectReportApplicable =    eCommon.Common.CommonBean.isSiteSpecific(con,"MR","REJECT_REPORT_MRP"); //Added by Shaik Mujafar for ML-MMOH-CRF-0714
	//Below line added for this CRF ML-MMOH-CRF-0566
	referralRegister = eCommon.Common.CommonBean.isSiteSpecific(con, "IP", "RECNL_REFERRAL_REGISTER");
	isBarcodeScanningApplicable = eCommon.Common.CommonBean.isSiteSpecific(con, "AM", "BARCODE_SCANNING_APPLICABLE");//Added on 26-MAR-2020 FOR MMS-DM-CRF-0157 BY KAMATCHI S
	/*Added by lakhsmanan for ML-MMOH-CRF-1955 on 12-07-2023 start */
	isMarkPatientMLC=eCommon.Common.CommonBean.isSiteSpecific(con,"MP","MARK_PATIENT_MLC");
	isPendingForAdmissionAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "AE_FOR_ADMISSION_TAB"); //Added by Himanshu Saxena on 12-07-2023  for ML-MMOH-CRF-1972-->
	
	//<!--Added by Himanshu Saxena on 30-Jun-2023 for AAKH-CRF-0175 US11 Starts-->
   	//isBiometricRejectionAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "AE", "SMART_CARD_INTG");   
try
{
pstmt_rh = con.prepareStatement("select nvl(VALUE_2,'00') VALUE_2 from sm_function_control a,SM_SITE_PARAM b  where module_id='MP' and FUNCTIONALITY_ID='SMART_CARD_INTG' and a.SITE_ID=B.CUSTOMER_ID");
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
	
	String cancelForAdmission="";
	String markPatientMLCLabel="";
	String reasonforBiometricRejection="";
	if (isMarkPatientMLC){
		markPatientMLCLabel=" ,41,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ReasontoMarkMLC.label","am_labels")+" ,42,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ReasontoMarkNonMLC.label","am_labels");
	}
	/*Added by lakhsmanan for ML-MMOH-CRF-1955 on 12-07-2023 end */

	//Added by Himanshu Saxena on 12-07-2023  for ML-MMOH-CRF-1972 Starts-->
	if (isPendingForAdmissionAppl){
		cancelForAdmission=" ,43,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelForAdmission.label","common_labels");
	}
	//Added by Himanshu Saxena on 12-07-2023  for ML-MMOH-CRF-1972 Starts-->

	//	<!--Added by Himanshu Saxena on 30-Jun-2023 for AAKH-CRF-0175  US11 Starts-->	
	if(function_name.equals("01"))
	{
		reasonforBiometricRejection=" ,44,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ReasonForBiometricRejection.label","am_labels");
	}
	//	<!--Added by Himanshu Saxena on 30-Jun-2023 for AAKH-CRF-0175  US11 Starts-->

ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("Text");  //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonCode.label","common_labels"));	// label
firstItem.add("contact_reason_code"); //name of field
firstItem.add("8");	// SIZE
firstItem.add("8");	//LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");  //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonDescription.label","common_labels"));	// label
secondItem.add("contact_reason_desc"); //name of field
secondItem.add("60");	// SIZE
secondItem.add("60");	//LENGTH

finAr.add(secondItem);//add to ArrayList obj finAr

ArrayList fourthItem=new ArrayList();

fourthItem.add("List");  //Type of item
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Applicable.label","common_labels"));  // label
fourthItem.add("applicable");   //name of field
if(isIncompReqCancelApplicable && referralRegister && isRejectRequestApplicable && isRejectReportApplicable){  // modified by  mujafar for ML-MMOH-CRF-0714
	fourthItem.add("0,-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---,1,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bookappointment.label","common_labels")+",2,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TransferAppointment.label","common_labels")+",3,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelAppointment.label","common_labels")+",4,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.BlockSchedule.label","am_labels")+",5,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelSchedule.label","common_labels")+",6,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TransferSchedule.label","common_labels")+",7,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.LiftBlockonSchedule.label","am_labels")+",8, "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RegisterVisit.label","common_labels")+",9,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReviseVisit.label","common_labels")+",10,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels")+",11,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.CancelVisit.label","am_labels")+",12,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelBooking.label","common_labels")+",13,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelAdmission.label","common_labels")+",14,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelDischargeAdvice.label","common_labels")+",15,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.revisebooking.label","common_labels")+",16,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelTransfer.label","common_labels")+",17,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RegisterAttendance.label","common_labels")+",18,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ReasonforRecall.label","am_labels")+",19,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelWaitList.label","common_labels")+",20,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ModifyWaitList.label","common_labels")+",21,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.FollowupofReferral.label","am_labels")+",22,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ReasonforDepart.label","am_labels")+",23,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.RejectionofReferral.label","am_labels")+",24,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelAECheckout.label","common_labels")+",25,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelOPCheckout.label","common_labels")+",26,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ChangeAdmDtls.label","am_labels")+",27,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.RevertReleasedBodyPart.label","mo_labels")+",28,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.LateDischarge.label","am_labels")+",29,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.override.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Appointment.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.rule.label","common_labels")+" "+",30,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TransOverrideReason.label","common_labels")+" "+",31,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.CancelEmbalm.label","mo_labels")+" "+",32,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Request.label","common_labels")+" "+",33,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonforRejection.label","common_labels")+" "+",34,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonforCancel.label","common_labels")+",35,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reject.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Request.label","common_labels")+",36,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reject.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.report.label","common_labels")+",37,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.RejectedbyPractitionertoMRD.label","mr_labels")+",38,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.RejectedbyPractitionertoHOD.label","mr_labels")+" ,39,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unit.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Transfer.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reason.label","common_labels")+" ,40,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ExternalAppl.label","am_labels")+markPatientMLCLabel+"  "+cancelForAdmission+" "+reasonforBiometricRejection); //Modified by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589 and this markPatientMLCLabel string added by lakhsmanan for ML-MMOH-CRF-1955 on 12-07-2023
}
else if(isBarcodeScanningApplicable)//Added on 26-MAR-2020 FOR MMS-DM-CRF-0157 BY KAMATCHI S
{
	fourthItem.add("0,-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---,1,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bookappointment.label","common_labels")+",2,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TransferAppointment.label","common_labels")+",3,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelAppointment.label","common_labels")+",4,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.BlockSchedule.label","am_labels")+",5,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelSchedule.label","common_labels")+",6,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TransferSchedule.label","common_labels")+",7,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.LiftBlockonSchedule.label","am_labels")+",8, "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RegisterVisit.label","common_labels")+",9,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReviseVisit.label","common_labels")+",10,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels")+",11,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.CancelVisit.label","am_labels")+",12,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelBooking.label","common_labels")+",13,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelAdmission.label","common_labels")+",14,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelDischargeAdvice.label","common_labels")+",15,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.revisebooking.label","common_labels")+",16,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelTransfer.label","common_labels")+",17,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RegisterAttendance.label","common_labels")+",18,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ReasonforRecall.label","am_labels")+",19,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelWaitList.label","common_labels")+",20,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ModifyWaitList.label","common_labels")+",21,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.FollowupofReferral.label","am_labels")+",22,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ReasonforDepart.label","am_labels")+",23,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.RejectionofReferral.label","am_labels")+",24,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelAECheckout.label","common_labels")+",25,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelOPCheckout.label","common_labels")+",26,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ChangeAdmDtls.label","am_labels")+",27,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.RevertReleasedBodyPart.label","mo_labels")+",28,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.LateDischarge.label","am_labels")+",29,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.override.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Appointment.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.rule.label","common_labels")+" "+",30,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TransOverrideReason.label","common_labels")+" "+",31,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.CancelEmbalm.label","mo_labels")+" "+",32,"
			+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unit.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Transfer.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reason.label","common_labels")
			+",33,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Barcode.label","common_labels")
			+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Scanning.label","common_labels")+" ,34,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ExternalAppl.label","am_labels")+markPatientMLCLabel+" "+cancelForAdmission+" "+reasonforBiometricRejection);
			 //  this markPatientMLCLabel string  added by lakhsmanan for ML-MMOH-CRF-1955 on 12-07-2023
}
else{
	fourthItem.add("0,-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---,1,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bookappointment.label","common_labels")+",2,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TransferAppointment.label","common_labels")+",3,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelAppointment.label","common_labels")+",4,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.BlockSchedule.label","am_labels")+",5,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelSchedule.label","common_labels")+",6,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TransferSchedule.label","common_labels")+",7,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.LiftBlockonSchedule.label","am_labels")+",8, "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RegisterVisit.label","common_labels")+",9,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReviseVisit.label","common_labels")+",10,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels")+",11,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.CancelVisit.label","am_labels")+",12,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelBooking.label","common_labels")+",13,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelAdmission.label","common_labels")+",14,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelDischargeAdvice.label","common_labels")+",15,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.revisebooking.label","common_labels")+",16,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelTransfer.label","common_labels")+",17,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RegisterAttendance.label","common_labels")+",18,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ReasonforRecall.label","am_labels")+",19,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelWaitList.label","common_labels")+",20,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ModifyWaitList.label","common_labels")+",21,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.FollowupofReferral.label","am_labels")+",22,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ReasonforDepart.label","am_labels")+",23,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.RejectionofReferral.label","am_labels")+",24,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelAECheckout.label","common_labels")+",25,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelOPCheckout.label","common_labels")+",26,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ChangeAdmDtls.label","am_labels")+",27,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.RevertReleasedBodyPart.label","mo_labels")+",28,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.LateDischarge.label","am_labels")+",29,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.override.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Appointment.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.rule.label","common_labels")+" "+",30,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TransOverrideReason.label","common_labels")+" "+",31,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.CancelEmbalm.label","mo_labels")+
	",32,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unit.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Transfer.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reason.label","common_labels")+" ,33,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.ExternalAppl.label","am_labels")+markPatientMLCLabel+" "+cancelForAdmission+" "+reasonforBiometricRejection);//static values that need to be displayed as option.Send it along with the value that is inserted. //Modified by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589 and  this markPatientMLCLabel string  added by lakhsmanan for ML-MMOH-CRF-1955 on 12-07-2023
}
// CancelEmbalm Added Against Bru-HIMS-CRF-348 [IN:038247] By Saanthaakumar.
fourthItem.add("10");	//LENGTH


finAr.add(fourthItem); //add to ArrayList obj finAr
ArrayList thirdItem=new ArrayList();

thirdItem.add("List");  //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
thirdItem.add("nature");   //name of field
thirdItem.add("B, " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
thirdItem.add("4");	//LENGTH


finAr.add(thirdItem); //add to ArrayList obj finAr

String orderByCols[] = new String[2];
String orderByColVals[] = new String[2];


orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonCode.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonDescription.label","common_labels");


orderByColVals[0] = "Contact_reason_code";
orderByColVals[1] = "Contact_reason";




strbuff = qrypg.getQueryPage(con,finAr,"Find complaint","../../eAM/jsp/ContactReasonQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
firstItem.clear();
secondItem.clear();
thirdItem.clear();
fourthItem.clear();
finAr.clear();
} catch (Exception e) {
  e.printStackTrace();
}
//Below Added for checkstyle
finally{
ConnectionManager.returnConnection(con,request);
}
//Ended for checkstyle
%>
