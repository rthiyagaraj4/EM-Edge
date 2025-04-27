<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.Statement,java.sql.ResultSet"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	
	Connection con			= null;
	Statement stmt			= null;	
	ResultSet rset				= null;	
	ResultSet rset_practid	= null;
	Statement stmt1			= null;
	ResultSet rset1			= null;
	Statement stmt_bl		= null;
	ResultSet rs_bl				= null;
	String facilityId			= (String)session.getValue("facility_id");
	String bl_operational		= (String)session.getValue("bl_operational");
	StringBuffer strBuffer	= new StringBuffer();

try
{
		String bl_interfaced_yn= checkForNull(request.getParameter("bl_interfaced_yn"),"N");
		con = ConnectionManager.getConnection(request);
		String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>

	<script src='../js/ConfirmCancelTransfer.js' language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onload="getOnload_tfrDtls();setdefault()" onMouseDown="CodeArrest()" onKeyDown="lockKey()" >

<%
	String patientid		= checkForNull(request.getParameter("patient_id"));
	String eid				= checkForNull(request.getParameter("encounter_id"));
	long    encounterid	= Long.parseLong(eid);
	session.putValue("encounter_id",eid);
	session.putValue("patientid",patientid);
	String bookingrefno	= checkForNull(request.getParameter("booking_ref_no"));
	String fromfunction	= checkForNull(request.getParameter("fromFunction"));
	String admissiondate			= "";
	String admissiontype			= "";
	String trntypecode			= "";
	String trntypedesc			= "";
	String frpractitionerid		= "";
	String frpractdesc			= "";
	String frnursingunitcode	 	= "";
	String frbedtype				= "";
	String tonursingunittype	= "";
	String tobedtype				= "";
	String bookingdatetime		= "";
	String gender					= "";
	String allow_transfer_yn 	= "Y";
	String billing_group_id		= "";
	String billing_group_desc	= "";
	String age						= "";
	String priority					= "";
	String default_priority		= "";
	String max_priority			= "";
	String sysDate					= "";
	String frbedno					= ""; 
	String frspecialitycode		= ""; 
	String frspecialitydesc		= "";
	String frbedclass				= ""; 
	String frbedclassdesc		= ""; 
	String frbedtypecode		= "";
	String frnursingunitdesc		= ""; 
	String frroomno				= ""; 
	String frbedtypedesc			= ""; 
	String frservicecode			= ""; 
	String frservicedesc			= ""; 
	String frsubservcode			= ""; 
	String frsubservdesc			= ""; 
	String frmeddesc				= ""; 
	String frmedid					= "";
	String patient_class			= "";
	String change_bed_class_yn	= "N";
	String admissiondate_converted	= "";
	String bookingdatetime_converted = "";
	int		frdailycharge			= 0;
	try
	{		
		stmt1	= con.createStatement();
		//fromfunction="RequestDetail";
		strBuffer.append("select" );
		strBuffer.append("  to_char(SYSDATE,'dd/mm/rrrr hh24:mi') SYSTEM_DATE" );
		strBuffer.append("  , to_char(B.ADMISSION_DATE_TIME,'dd/mm/rrrr hh24:mi')ADMISSION_DATE" );
		strBuffer.append("  , to_char(A.TFR_REQ_DATE_TIME,'dd/mm/rrrr hh24:mi') BOOKING_DATE_TIME" );
		strBuffer.append("  , IP_GET_DESC.IP_ADMISSION_TYPE(B.ADMISSION_TYPE,'"+locale+"', '2') ADMISSION_SHORT_DESC" );
		strBuffer.append("  , B.ADMISSION_TYPE" );
		strBuffer.append("  , A.REQ_BED_CLASS_CODE BED_CLASS_CODE" );
		strBuffer.append("  , IP_GET_DESC.IP_BED_CLASS(A.REQ_BED_CLASS_CODE,'"+locale+"', '2') BED_CLASS_SHORT_DESC" );
		strBuffer.append("  , A.REQ_BED_NO BED_NO" );
		strBuffer.append("  , A.REQ_BED_TYPE_CODE BED_TYPE_CODE" );
		strBuffer.append("  , IP_GET_DESC.IP_BED_TYPE(A.REQ_BED_TYPE_CODE,'"+locale+"', '2') BED_TYPE_SHORT_DESC" );
		strBuffer.append("  , A.BLOCKING_REMARKS" );
		strBuffer.append("  , A.BLOCKING_TYPE_CODE" );
		strBuffer.append("  , B.BED_CLASS_CODE FROM_BED_CLASS_CODE" );
		strBuffer.append("  , IP_GET_DESC.IP_BED_CLASS(B.BED_CLASS_CODE,'"+locale+"', '2') FROM_BED_CLASS_SHORT_DESC" );
		/*Friday, February 05, 2010 , 18927 , from bed type showing as to bed type*/
		strBuffer.append("  , B.BED_TYPE_CODE FROM_BED_TYPE_CODE" );
		strBuffer.append("  , IP_GET_DESC.IP_BED_TYPE(B.BED_TYPE_CODE,'"+locale+"', '2') FROM_BED_TYPE_SHORT_DESC" );
		/**/
		strBuffer.append("  , B.BED_NUM FROM_BED_NO" );
		strBuffer.append("  , B.NURSING_UNIT_CODE FROM_NURSING_UNIT_CODE" );
		strBuffer.append("  , IP_GET_DESC.IP_NURSING_UNIT(B.FACILITY_ID, B.NURSING_UNIT_CODE,'"+locale+"', '2') FROM_NURSING_UNIT_SHORT_DESC" );
		strBuffer.append("  , B.ATTEND_PRACTITIONER_ID FROM_PRACTITIONER_ID" );
		strBuffer.append("  , AM_GET_DESC.AM_PRACTITIONER(B.ATTEND_PRACTITIONER_ID,'"+locale+"','1') FROM_PRACTITIONER_NAME" );
		strBuffer.append("  , B.ROOM_NUM FROM_ROOM_NO" );
		strBuffer.append("  , B.SERVICE_CODE FROM_SERVICE_CODE" );
		strBuffer.append("  , AM_GET_DESC.AM_SERVICE(B.SERVICE_CODE,'"+locale+"','2') FROM_SERVICE_SHORT_DESC" );
		strBuffer.append("  , B.SPECIALTY_CODE FROM_SPECIALTY_CODE" );
		strBuffer.append("  , AM_GET_DESC.AM_SPECIALITY(B.SPECIALTY_CODE,'"+locale+"','2') FROM_SPECIALTY_SHORT_DESC" );
		strBuffer.append("  , B.SUBSERVICE_CODE FROM_SUBSERVICE_CODE" );
		strBuffer.append("  , AM_GET_DESC.AM_SUBSERVICE(A.REQ_SERVICE_CODE, A.REQ_SUBSERVICE_CODE,'"+locale+"','2') FROM_SUBSERVICE_SHORT_DESC" );
		strBuffer.append("  , B.TEAM_ID FROM_TEAM_ID" );
		strBuffer.append("  , AM_GET_DESC.AM_MEDICAL_TEAM(B.FACILITY_ID, B.TEAM_ID,'"+locale+"','2') FROM_TEAM_SHORT_DESC" );
		strBuffer.append("  , C.SEX GENDER" );
		strBuffer.append("  , A.INFORMED_DATE_TIME" );
		strBuffer.append("  , A.INFORMED_NAME" );
		strBuffer.append("  , B.NURSING_UNIT_CODE" );
		strBuffer.append("  , IP_GET_DESC.IP_NURSING_UNIT(B.FACILITY_ID, B.NURSING_UNIT_CODE,'"+locale+"','2') NURSING_UNIT_SHORT_DESC" );
		strBuffer.append("  , B.PAT_CURR_LOCN_CODE" );
		strBuffer.append("  , A.REQ_PRACTITIONER_ID" );
		strBuffer.append("  , AM_GET_DESC.AM_PRACTITIONER(A.REQ_PRACTITIONER_ID,'"+locale+"','1') PRACTITIONER_NAME" );
		strBuffer.append("  , A.PREF_DATE_TIME" );
		strBuffer.append("  , A.PRIORITY_CODE" );
		strBuffer.append("  , A.PRIORITY_EXP_DATE" );
		strBuffer.append("  , IP_GET_DESC.IP_TRANSFER_PRIORITY(A.FACILITY_ID, A.PRIORITY_CODE,'"+locale+"','2') PRIORITY_SHORT_DESC" );
		strBuffer.append("  , A.RECORDS_AND_DOCUMENTS1" );
		strBuffer.append("  , A.RECORDS_AND_DOCUMENTS2" );
		strBuffer.append("  , A.RECORDS_AND_DOCUMENTS3" );
		strBuffer.append("  , A.RECORDS_AND_DOCUMENTS4" );
		strBuffer.append("  , A.RECORDS_AND_DOCUMENTS5" );
		strBuffer.append("  , A.REQ_BED_TYPE_CODE_BY_DEFN" );
		strBuffer.append("  , B.ROOM_NUM ROOM_NO" );
		strBuffer.append("  , B.SERVICE_CODE" );
		strBuffer.append("  , AM_GET_DESC.AM_SERVICE(B.SERVICE_CODE,'"+locale+"','2') SERVICE_SHORT_DESC" );
		strBuffer.append("  , B.SPECIALTY_CODE" );
		strBuffer.append("  , AM_GET_DESC.AM_SPECIALITY(B.SPECIALTY_CODE,'"+locale+"','2') SPECIALTY_SHORT_DESC" );
		strBuffer.append("  , SUBSERVICE_CODE" );
		strBuffer.append("  , AM_GET_DESC.AM_SUBSERVICE(B.SERVICE_CODE,B.SUBSERVICE_CODE,'"+locale+"','2') SUBSERVICE_SHORT_DESC" );
		strBuffer.append("  , A.REQ_TEAM_ID TEAM_ID" );
		strBuffer.append("  , AM_GET_DESC.AM_MEDICAL_TEAM(A.FACILITY_ID, A.REQ_TEAM_ID,'"+locale+"','2') TEAM_SHORT_DESC" );
		strBuffer.append("  , A.TFR_REQ_ACCEPTED_YN" );
		strBuffer.append("  , A.TFR_REQ_DATE_TIME" );
		strBuffer.append("  , A.TFR_REQ_REASON" );
		strBuffer.append("  , A.TFR_REQ_REF_NO" );
		strBuffer.append("  , A.TFR_REQ_STATUS" );
		strBuffer.append("  , A.TFR_REQ_STATUS TFR_REQ_STATUS_DESC" );
		strBuffer.append("  , A.TFR_REQ_TYPE" );
		strBuffer.append("  , A.TFR_REQ_TYPE TFR_REQ_TYPE_DESC" );
		strBuffer.append("  , IP_GET_DESC.IP_TRANSFER_TYPE(A.TFR_REQ_REASON,'"+locale+"','2')TRANSFER_TYPE_SHORT_DESC " );
		strBuffer.append("from" );
		strBuffer.append("  IP_TRANSFER_REQUEST A" );
		strBuffer.append("  , IP_OPEN_ENCOUNTER B" );
		strBuffer.append("  , MP_PATIENT C " );
		strBuffer.append("where A.FACILITY_ID = B.FACILITY_ID " );
		strBuffer.append("  and A.ENCOUNTER_ID = B.ENCOUNTER_ID " );
		strBuffer.append("  and A.ENCOUNTER_ID = '"+encounterid+"' " );
		strBuffer.append("  and A.FACILITY_ID = '"+facilityId+"' " );
		strBuffer.append("  and B.PATIENT_ID = C.PATIENT_ID" );

	if (fromfunction.equals("RequestDetail"))
	{
		strBuffer.append("  and A.TFR_REQ_STATUS = '1' " );
	}
	else
	{
		strBuffer.append("  and A.TFR_REQ_STATUS = '0' " );
	}

		if (rset!=null) rset.close();
		if (stmt!=null) stmt.close();
		stmt	= con.createStatement();
		rset	= stmt.executeQuery(strBuffer.toString());
		if(rset.next() && rset != null)
		{
			sysDate				 = rset.getString("system_date");
			admissiondate		= checkForNull(rset.getString("admission_date"));  
			if(!(admissiondate.equals("") || admissiondate == null))
					admissiondate_converted = DateUtils.convertDate(admissiondate,"DMYHM","en",locale); 
	
			admissiontype		= checkForNull(rset.getString("admission_short_desc"));
			frbedtype			= checkForNull(rset.getString("bed_type_code"));
			gender				= checkForNull(rset.getString("gender"));
			priority				= checkForNull(rset.getString("priority_short_desc"));
			trntypecode		= checkForNull(rset.getString("tfr_req_type"));
			trntypedesc		= checkForNull(rset.getString("transfer_type_short_desc"));  
			bookingdatetime	= checkForNull(rset.getString("booking_date_time"));
			if(!(bookingdatetime.equals("") || bookingdatetime == null))
						bookingdatetime_converted = DateUtils.convertDate(bookingdatetime,"DMYHM","en",locale); 
		
			frnursingunitcode	= checkForNull(rset.getString("from_nursing_unit_code")); 
			frbedno				= checkForNull(rset.getString("from_bed_no"));
			frpractdesc			= checkForNull(rset.getString("from_practitioner_name"));
			frspecialitycode	= checkForNull(rset.getString("from_specialty_code"));   
			frspecialitydesc	= checkForNull(rset.getString("from_specialty_short_desc"));
			frbedclass			= checkForNull(rset.getString("from_bed_class_code"));  
			frbedclassdesc		= checkForNull(rset.getString("from_bed_class_short_desc")); 
			frnursingunitdesc	= checkForNull(rset.getString("from_nursing_unit_short_desc")); 
			frroomno				= checkForNull(rset.getString("from_room_no"));
			//frbedtypedesc		= checkForNull(rset.getString("bed_type_short_desc"));
			/*Friday, February 05, 2010 , 18927 , from bed type showing as to bed type*/
			frbedtypecode		= checkForNull(rset.getString("from_bed_type_code"));
			frbedtypedesc		= checkForNull(rset.getString("from_bed_type_short_desc")); 
			/**/
			frservicecode		= checkForNull(rset.getString("from_service_code"));
			frservicedesc		= checkForNull(rset.getString("from_service_short_desc"));
			frsubservcode		= checkForNull(rset.getString("from_subservice_code"));
			frsubservdesc		= checkForNull(rset.getString("from_subservice_short_desc"));
			frmeddesc			= checkForNull(rset.getString("from_team_short_desc"));
			frmedid				= checkForNull(rset.getString("from_team_id"));
		}

		if (rset!=null)rset.close();
		if (stmt!=null)stmt.close();

		if(bl_operational.equals("Y"))
		{
			strBuffer.delete(0,strBuffer.length());
			strBuffer.append("select a. BLNG_GRP_ID, a.SHORT_DESC from bl_blng_grp a,  BL_EPISODE_FIN_DTLS b where a.BLNG_GRP_ID = b.BLNG_GRP_ID and b.OPERATING_FACILITY_ID ='"+facilityId+"' and b.EPISODE_ID = '"+encounterid+"'");
			rset1 = stmt1.executeQuery(strBuffer.toString());
			if (rset1 != null)
			{
				while(rset1.next())
				{
					billing_group_id = rset1.getString("BLNG_GRP_ID");
					billing_group_desc = rset1.getString("SHORT_DESC");
				}
			}
		}
		if (rset1!=null) rset1.close();



%>

<!--Added by kishore on 4/26/2004-->
<form name="ConfirmCancelTransfer_form" id="ConfirmCancelTransfer_form"  method="post" action="../../servlet/eIP.ConfirmCancelTransferServlet" target=_top>
<table border='0' width="100%" cellpadding=2 cellspacing=0>
	<tr>
		<td  class="label"  width='25%'><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/>&nbsp;</td>
		 <td  class='querydata' width='25%'><input type="hidden" name="admission_date" id="admission_date" value="<%=admissiondate%>" ><%=admissiondate_converted%></td>
		<td  class="label" width='25%'><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/>&nbsp;</td>
		<td  class='querydata' width='25%'><input type="hidden" name="admission_type" id="admission_type" value="<%=admissiontype%>" ><%=admissiontype%></td> 
	</tr>
	<tr>
		<td class="label"  nowrap><fmt:message key="eIP.TransferBookingDate.label" bundle="${ip_labels}"/>&nbsp;</td>
		<td class='querydata' ><%=bookingdatetime_converted%><input type="hidden" name="transfer_date" id="transfer_date"  value="<%=bookingdatetime%>"></td>
		<!--Changed Lable name from Tranfer type to Reason for Transfer by kishore on 4/23/2004-->
		<td class="label" ><fmt:message key="eIP.ReasonforTransfer.label" bundle="${ip_labels}"/>&nbsp;</td>
		<td class='querydata' ><%=trntypedesc%><input type="hidden" name="transfer_type" id="transfer_type" value="<%=trntypecode%>"></td>
	</tr>
	<tr>
		<td class="label" ><fmt:message key="Common.priority.label" bundle="${common_labels}"/>&nbsp;</td>
		<td class='querydata' ><%=priority%><input type="hidden" name="priority_code" id="priority_code" value="<%=priority%>"></td>		
		<td class="label"  nowrap>&nbsp;</td>
		<td class='querydata'  ></td>
	</tr>
</table>
<%if (fromfunction.equals("RequestDetail"))
{	%>
	<jsp:include page="../../eIP/jsp/TransferDetails.jsp" ><jsp:param name="flush" value="true" />
		<jsp:param name="call_function" value="confirm_details"/>
		
		<jsp:param name ="admissiondate"  value="<%=admissiondate%>" />
		<jsp:param name ="frnursingunitcode"  value="<%=frnursingunitcode%>" />
		<jsp:param name ="frbedno"  value="<%=frbedno%>" />
		<jsp:param name ="frpractitionerid"  value="<%=frpractitionerid%>" />
		<jsp:param name ="frpractdesc"  value="<%=frpractdesc%>" />
		<jsp:param name ="frspecialitycode"  value="<%=frspecialitycode%>" />
		<jsp:param name ="frspecialitydesc"  value="<%=frspecialitydesc%>" />
		<jsp:param name ="frbedclass"  value="<%=frbedclass%>" />
		<jsp:param name ="frbedclassdesc"  value="<%=frbedclassdesc%>" />
		<jsp:param name ="frnursingunitdesc"  value="<%=frnursingunitdesc%>" />
		<jsp:param name ="frroomno"  value="<%=frroomno%>" />
		<jsp:param name ="frbedtype"  value="<%=frbedtypecode%>" />
		<jsp:param name ="frbedtypedesc"  value="<%=frbedtypedesc%>" />
		<jsp:param name ="frdailycharge"  value="<%=frdailycharge%>" />
		<jsp:param name ="age"  value="<%=age%>" />
		<jsp:param name ="gender"  value="<%=gender%>" />
		<jsp:param name ="frservicecode"  value="<%=frservicecode%>" />
		<jsp:param name ="frservicedesc"  value="<%=frservicedesc%>" />
		<jsp:param name ="frsubservcode"  value="<%=frsubservcode%>" />
		<jsp:param name ="frsubservdesc"  value="<%=frsubservdesc%>" />
		<jsp:param name ="patient_class"  value="<%=patient_class%>" />
		<jsp:param name ="frmeddesc"  value="<%=frmeddesc%>" />
		<jsp:param name ="frmedid"  value="<%=frmedid%>" />
		<jsp:param name ="ch_bed_class_param"  value="<%=change_bed_class_yn%>" />
	</jsp:include>
<%}
else
{%>
	<jsp:include page="../../eIP/jsp/TransferDetails.jsp" ><jsp:param name="flush" value="true" />
		<jsp:param name="call_function" value="cancel_request"/>
		<jsp:param name ="admissiondate"  value="<%=admissiondate%>" />
		<jsp:param name ="frnursingunitcode"  value="<%=frnursingunitcode%>" />
		<jsp:param name ="frbedno"  value="<%=frbedno%>" />
		<jsp:param name ="frpractitionerid"  value="<%=frpractitionerid%>" />
		<jsp:param name ="frpractdesc"  value="<%=frpractdesc%>" />
		<jsp:param name ="frspecialitycode"  value="<%=frspecialitycode%>" />
		<jsp:param name ="frspecialitydesc"  value="<%=frspecialitydesc%>" />
		<jsp:param name ="frbedclass"  value="<%=frbedclass%>" />
		<jsp:param name ="frbedclassdesc"  value="<%=frbedclassdesc%>" />
		<jsp:param name ="frnursingunitdesc"  value="<%=frnursingunitdesc%>" />
		<jsp:param name ="frroomno"  value="<%=frroomno%>" />
		<jsp:param name ="frbedtype"  value="<%=frbedtype%>" />
		<jsp:param name ="frbedtypedesc"  value="<%=frbedtypedesc%>" />
		<jsp:param name ="frdailycharge"  value="<%=frdailycharge%>" />
		<jsp:param name ="age"  value="<%=age%>" />
		<jsp:param name ="gender"  value="<%=gender%>" />
		<jsp:param name ="frservicecode"  value="<%=frservicecode%>" />
		<jsp:param name ="frservicedesc"  value="<%=frservicedesc%>" />
		<jsp:param name ="frsubservcode"  value="<%=frsubservcode%>" />
		<jsp:param name ="frsubservdesc"  value="<%=frsubservdesc%>" />
		<jsp:param name ="patient_class"  value="<%=patient_class%>" />
		<jsp:param name ="frmeddesc"  value="<%=frmeddesc%>" />
		<jsp:param name ="frmedid"  value="<%=frmedid%>" />
		<jsp:param name ="ch_bed_class_param"  value="<%=change_bed_class_yn%>" />
	</jsp:include>
<%	}	%>
	<table border=0 width="100%" cellpadding=2 cellspacing=0>
	<%
	if (!fromfunction.equals("RequestDetail"))
	{
	%>
	<tr>
		<td colspan=4 class='columnheader'><fmt:message key="Common.CancellationDetails.label" bundle="${common_labels}"/></td>
	</tr>
	<tr>
		<td class="label" width='25%'><fmt:message key="Common.ReasonforCancellation.label" bundle="${common_labels}"/>&nbsp;</td>
		<td class='querydata' colspan=3>
		<select name='reason_for_cancel' id='reason_for_cancel'><option value='' selected >-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----<%
			String contact_reason="";
			String contact_reason_code="";
			try
			{
				stmt = con.createStatement();
				rset = stmt.executeQuery("select contact_reason_code, contact_reason from am_contact_reason_lang_vw where language_id='"+locale+"' and eff_status = 'E' and cancel_transfer_yn = 'Y' order by 2");
				   
				if( rset != null )
				{
				  while( rset.next() )
				  {
					 contact_reason   = rset.getString("contact_reason") ;
					 contact_reason_code   = rset.getString("contact_reason_code") ;
					%>
						<OPTION VALUE="<%=contact_reason_code %>" ><%=contact_reason%>
					<%           
				 }
			 }
			if (stmt!=null) stmt.close();
			if (rset!=null) rset.close();
		}
		catch(Exception e) 
		{
			out.println(e.toString());
		}
	%>
	</select> 
	<img align="center" src="../../eCommon/images/mandatory.gif">
	<input type="hidden" name="reason_for_cancelation" id="reason_for_cancelation" value="<%=contact_reason_code%>" >
	<input type="hidden" name="reason_for_cancelation" id="reason_for_cancelation" value="">
	</td>
</tr>
<tr>
	<td class="label" width='25%'><fmt:message key="Common.AuthorizingPractitioner.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
	<td nowrap  colspan='2'><input type='hidden' name='authorized_practid' id='authorized_practid' value="<%=frpractitionerid%>" readonly><input type='text' name='pract_descn' id='pract_descn' value="<%=frpractdesc%>" size='40' maxlength='30' onblur="BeforeGetPractitioner(document.forms[0].practid1,pract_descn, '<%=facilityId%>');"><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button'  onClick="checkPractTxtVal(document.forms[0].practid1,document.forms[0].pract_descn,'<%=facilityId%>');" >
	<img align="center" src="../../eCommon/images/mandatory.gif">		
	<input type=hidden name="pract_desc_hid" id="pract_desc_hid" value="<%=frpractdesc%>"></td>
	<td  class='querydata' width='25%'><input type="hidden" name="pract_id" id="pract_id" value=""></td>
</tr>
<%
}
%>	
</table>	

<input type="hidden" name="patient_id" id="patient_id" value="<%=patientid%>">
<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounterid%>">
<input type="hidden" name="fr_bed_type" id="fr_bed_type" value="<%=frbedtype%>">
<input type="hidden" name="booking_ref_no" id="booking_ref_no" value="<%=bookingrefno%>">
<input type="hidden" name="patient_gender" id="patient_gender" value="<%=gender%>">
<input type="hidden" name="age" id="age" value="<%=age%>" >
<input type="hidden" name="continue_yn" id="continue_yn" > 
<input type="hidden" name="pri_target" id="pri_target">
<input type="hidden" name="priority_value" id="priority_value" value="<%=priority%>" >
<input type="hidden" name="to_nursing_unit_type" id="to_nursing_unit_type" value="<%=tonursingunittype%>">
<input type="hidden" name="to_bed_type" id="to_bed_type" value="<%=tobedtype%>">
<input type="hidden" name="bl_interfaced_yn" id="bl_interfaced_yn" value="<%=bl_interfaced_yn%>">
<input type="hidden" name="allow_transfer_yn" id="allow_transfer_yn" value="<%=allow_transfer_yn%>">
<input type="hidden" name="fr_daily_rate" id="fr_daily_rate" value="0">
<input type="hidden" name="to_daily_rate" id="to_daily_rate" value="0">
<input type="hidden" name="bill_type_code" id="bill_type_code" value="">
<input type="hidden" name="blng_class_code" id="blng_class_code" value="">
<input type="hidden" name="blng_serv_code" id="blng_serv_code" value="">
<input type='hidden' name='modified_bed_type_code' id='modified_bed_type_code' value="">
<input type='hidden' name='billing_group_id' id='billing_group_id' value="<%=billing_group_id%>">
<input type='hidden' name='billing_group_desc' id='billing_group_desc' value="<%=billing_group_desc%>">
<input type='hidden' name='bl_operational' id='bl_operational' value="<%=bl_operational%>">	
<input type='hidden' name='patient_class' id='patient_class' value="<%=patient_class%>">	
<%
if(bl_interfaced_yn.equals("Y"))
{
%>
	<!-- START MODIFICATION BY ARUN -->
		<!-- MOD#02 Introduced the following hidden item corresponding to the commented billing -->
			<input type="hidden" name="transfer_chargeable_yn" id="transfer_chargeable_yn" value="">
			<input type="hidden" name="transfer_serv_charge" id="transfer_serv_charge" value="">
			<input type="hidden" name="surgery_reqd_yn" id="surgery_reqd_yn" value="">
			<input type="hidden" name="addnl_dep_amt" id="addnl_dep_amt" value="">
	<!-- END MODIFICATION BY ARUN -->
<%
}
%>	

<%if (!fromfunction.equals("Q"))
	{
		String widthValue = "width = '14%'";
		if (fromfunction.equals("RequestDetail"))
			widthValue = "width = '4%'";
		%>
		<table border=0 width='100%' cellpadding=2 cellspacing=0 align="right">
		<tr>
		<td align=right>
		<%if (!fromfunction.equals("RequestDetail"))
			{%>		
			<input type="button" class="button" name = "confirm_or_cancel" id = "confirm_or_cancel" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onclick='OffsetDate("<%=sysDate%>", "<%=max_priority%>", "<%=default_priority%>"); checkForMandatory();'><%}%><input type="button" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onclick="const dialogTag = parent.parent.document.getElementById('dialog_tag'); dialogTag.close();">
	</tr>
	</table>
<%}
}catch(Exception e)
	{
		out.print("Exception :"+e);
	}
}
catch(Exception e){out.println("Exception in tryCatch : "+ e.toString());}
finally 
{
	try
	{
		if(rset	!= null)rset.close();
		if(rs_bl!= null)rs_bl.close();
		if(stmt1!= null)stmt1.close();
		if(rset1 != null)rset1.close();
		if(stmt != null) stmt.close();
		if(stmt_bl != null)stmt_bl.close();
		if(rset_practid != null)rset_practid.close();
	}
	catch(Exception e)
	{
		out.println("Exception in tryCatch : "+ e.toString());
	}
	ConnectionManager.returnConnection(con,request);
}
%>
</form>	 
</body>
</html>

<%!	
	// Added by Sridhar R on Mar 11 2005.. for handling null values ..
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}
%>

