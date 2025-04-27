<!DOCTYPE html>
<!--
	Developed by 	:	Chitra 
	Created on 		:	27/08/2001
	Module			:	ip
-->
<html>
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.text.*,java.util.*, com.ehis.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%

	request.setCharacterEncoding("UTF-8");
	String locale				= (String)session.getAttribute("LOCALE");
	
	Connection con				= null;
	Statement stmt				= null;
	PreparedStatement pstmt		= null;
	ResultSet rset				= null;
	ResultSet rs				= null;
	Statement stmt1				= null;
	ResultSet rset1				= null;
	Statement stmt_opn				= null;//Maheshwaran added for GHL-CRF-0362
	ResultSet rs_opn				= null;//Maheshwaran added for GHL-CRF-0362
	String facilityId			= (String)session.getValue("facility_id");
	String patientid			= checkForNull(request.getParameter("patient_id"));
	String eid					= checkForNull(request.getParameter("encounter_id"));
	long    encounterid			= Long.parseLong(eid);

	session.putValue("encounter_id",eid);
	session.putValue("patientid",patientid);

	String bookingrefno			= checkForNull(request.getParameter("booking_ref_no"));
	String bl_operational	 	= (String)session.getValue("bl_operational");
	StringBuffer sql			= new StringBuffer();


	String bed_block_period_max_str	= checkForNull(request.getParameter("bed_block_period_max_int"));
	int BED_BLOCK_PERIOD_MAX	= 0;
	if(! bed_block_period_max_str.equals(""))
		BED_BLOCK_PERIOD_MAX	= Integer.parseInt(bed_block_period_max_str);

	String change_bed_class_yn	= checkForNull(request.getParameter("change_bed_class_yn"),"N");
	String bl_interfaced_yn		= checkForNull(request.getParameter("bl_interfaced_yn"),"N");
	String max_blk_type			= checkForNull(request.getParameter("bed_block_period_max_type"));

	String deactivate_pseudo_bed_yn		= checkForNull(request.getParameter("deactivate_pseudo_bed_yn"),"N");
	String admissiondate		= "";
	String admissiontype		= "";
	String age					= "";
	String allow_transfer_yn	= "Y";
	String billing_group_desc	= "";
	String billing_group_id		= "";
	String bookingdatetime		= "";
	String frbedclass			= "";
	String frbedclassdesc		= "";
	String frbedno				= "";
	String frbedtype			= "";
	String frbedtypedesc		= "";
	String frbedtypecode		= "";
	String frmeddesc			= "";
	String frmedid				= "";
	String frnursingunitcode	= "";
	String frnursingunitdesc	= "";
	String frpractdesc			= "";
	String frpractitionerid		= "";
	String frroomno				= "";
	String frservicecode		= "";
	String frservicedesc		= "";
	String frspecialitycode		= "";
	String frspecialitydesc		= "";
	String frsubservcode		= "";
	String frsubservdesc		= "";
	String gender				= "";
	String patient_class		= "";
	String priority				= "";
	String tobedtype			= "";
	String tonursingunittype	= "";
	String trntypecode			= "";
	String trntypedesc			= "";
	int frdailycharge			= 0;
	String modified_date_val	= "";
	String admissiondate_converted = "";
	String bookingdatetime_converted = "";
	String allow_emerg_trf_yn	= "";
	String blocking_remarks		= "";
	String pseudo_bed_yn		= "";
	//Maheshwaran added for GHL-CRF-0362
	String p_oper_stn_id = "";
	String sdate ="";
	String oper_stn_bed_class_yn ="";
	String loginUser				= (String)session.getValue("login_user");
	String sdate_converted	= "";
	//End
 try
 {
	con = ConnectionManager.getConnection(request);
	if(max_blk_type.equals("D"))
			BED_BLOCK_PERIOD_MAX= (BED_BLOCK_PERIOD_MAX)*24;
			//Maheshwaran added for GHL-CRF-0362
		StringBuffer operSql = new StringBuffer();
		operSql.append(" SELECT to_char(sysdate,'dd/mm/rrrr hh24:mi') sdate, a.oper_stn_id  OPER_STN_ID, a.BED_CLASS_CHANGE_YN FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginUser+"' AND trunc(sysdate) between b.eff_date_from and  nvl(b.eff_date_to,trunc(sysdate)) ");
		stmt_opn = con.createStatement();
		rs_opn = stmt_opn.executeQuery(operSql.toString());

		if (rs_opn != null && rs_opn.next())
		{
			p_oper_stn_id = rs_opn.getString("oper_stn_id")== null ? "" : rs_opn.getString("oper_stn_id");
			oper_stn_bed_class_yn = rs_opn.getString("BED_CLASS_CHANGE_YN")== null ? "" : rs_opn.getString("BED_CLASS_CHANGE_YN");
			sdate = rs_opn.getString("sdate");
			if(sdate == null) sdate = "";
			if(!(sdate == null || sdate.equals("")))
				sdate_converted = DateUtils.convertDate(sdate,"DMYHM","en",locale);
			if(rs_opn   != null)   rs_opn.close();
			if(stmt_opn   != null)   stmt_opn.close();
		}
		//End
	try
	{		

		sql.append("select" );
		sql.append("  to_char(SYSDATE,'dd/mm/rrrr hh24:mi') SYSTEM_DATE" );
		sql.append("  , to_char(B.ADMISSION_DATE_TIME,'dd/mm/rrrr hh24:mi')ADMISSION_DATE" );
		sql.append("  , to_char(A.TFR_REQ_DATE_TIME,'dd/mm/rrrr hh24:mi') BOOKING_DATE_TIME" );
		sql.append("  , IP_GET_DESC.IP_ADMISSION_TYPE(B.ADMISSION_TYPE,'"+locale+"', '2') ADMISSION_SHORT_DESC" );
		sql.append("  , B.ADMISSION_TYPE" );
		sql.append("  , A.REQ_BED_CLASS_CODE BED_CLASS_CODE" );
		sql.append("  , IP_GET_DESC.IP_BED_CLASS(A.REQ_BED_CLASS_CODE,'"+locale+"', '2') BED_CLASS_SHORT_DESC" );
		sql.append("  , A.REQ_BED_NO BED_NO" );
		sql.append("  , A.REQ_BED_TYPE_CODE BED_TYPE_CODE" );
		sql.append("  , IP_GET_DESC.IP_BED_TYPE(A.REQ_BED_TYPE_CODE,'"+locale+"', '2') BED_TYPE_SHORT_DESC" );
		sql.append("  , A.BLOCKING_REMARKS" );
		sql.append("  , A.BLOCKING_TYPE_CODE" );
		sql.append("  , B.BED_CLASS_CODE FROM_BED_CLASS_CODE" );
		sql.append("  , IP_GET_DESC.IP_BED_CLASS(B.BED_CLASS_CODE,'"+locale+"', '2') FROM_BED_CLASS_SHORT_DESC" );
		/*Friday, February 05, 2010 , 18927 , from bed type showing as to bed type*/
		sql.append("  , B.BED_TYPE_CODE FROM_BED_TYPE_CODE" );
		sql.append("  , IP_GET_DESC.IP_BED_TYPE(B.BED_TYPE_CODE,'"+locale+"', '2') FROM_BED_TYPE_SHORT_DESC" );
		/**/
		sql.append("  , B.BED_NUM FROM_BED_NO" );
		sql.append("  , B.NURSING_UNIT_CODE FROM_NURSING_UNIT_CODE" );
		sql.append("  , IP_GET_DESC.IP_NURSING_UNIT(B.FACILITY_ID, B.NURSING_UNIT_CODE,'"+locale+"', '2') FROM_NURSING_UNIT_SHORT_DESC" );
		sql.append("  , B.ATTEND_PRACTITIONER_ID FROM_PRACTITIONER_ID" );
		sql.append("  , AM_GET_DESC.AM_PRACTITIONER(B.ATTEND_PRACTITIONER_ID,'"+locale+"','1') FROM_PRACTITIONER_NAME" );
		sql.append("  , B.ROOM_NUM FROM_ROOM_NO" );
		sql.append("  , B.SERVICE_CODE FROM_SERVICE_CODE" );
		sql.append("  , AM_GET_DESC.AM_SERVICE(B.SERVICE_CODE,'"+locale+"','2') FROM_SERVICE_SHORT_DESC" );
		sql.append("  , B.SPECIALTY_CODE FROM_SPECIALTY_CODE" );
		sql.append("  , AM_GET_DESC.AM_SPECIALITY(B.SPECIALTY_CODE,'"+locale+"','2') FROM_SPECIALTY_SHORT_DESC" );
		sql.append("  , B.SUBSERVICE_CODE FROM_SUBSERVICE_CODE" );
		sql.append("  , AM_GET_DESC.AM_SUBSERVICE(A.REQ_SERVICE_CODE, A.REQ_SUBSERVICE_CODE,'"+locale+"','2') FROM_SUBSERVICE_SHORT_DESC" );
		sql.append("  , B.TEAM_ID FROM_TEAM_ID" );
		sql.append("  , AM_GET_DESC.AM_MEDICAL_TEAM(B.FACILITY_ID, B.TEAM_ID,'"+locale+"','2') FROM_TEAM_SHORT_DESC" );
		sql.append("  , C.SEX GENDER" );
		sql.append("  , A.INFORMED_DATE_TIME" );
		sql.append("  , A.INFORMED_NAME" );
		sql.append("  , B.NURSING_UNIT_CODE" );
		sql.append("  , IP_GET_DESC.IP_NURSING_UNIT(B.FACILITY_ID, B.NURSING_UNIT_CODE,'"+locale+"','2') NURSING_UNIT_SHORT_DESC" );
		sql.append("  , B.PAT_CURR_LOCN_CODE" );
		sql.append("  , A.REQ_PRACTITIONER_ID" );
		sql.append("  , AM_GET_DESC.AM_PRACTITIONER(A.REQ_PRACTITIONER_ID,'"+locale+"','1') PRACTITIONER_NAME" );
		sql.append("  , A.PREF_DATE_TIME" );
		sql.append("  , A.PRIORITY_CODE" );
		sql.append("  , A.PRIORITY_EXP_DATE" );
		sql.append("  , IP_GET_DESC.IP_TRANSFER_PRIORITY(A.FACILITY_ID, A.PRIORITY_CODE,'"+locale+"','2') PRIORITY_SHORT_DESC" );
		sql.append("  , A.RECORDS_AND_DOCUMENTS1" );
		sql.append("  , A.RECORDS_AND_DOCUMENTS2" );
		sql.append("  , A.RECORDS_AND_DOCUMENTS3" );
		sql.append("  , A.RECORDS_AND_DOCUMENTS4" );
		sql.append("  , A.RECORDS_AND_DOCUMENTS5" );
		sql.append("  , A.REQ_BED_TYPE_CODE_BY_DEFN" );
		sql.append("  , B.ROOM_NUM ROOM_NO" );
		sql.append("  , B.SERVICE_CODE" );
		sql.append("  , AM_GET_DESC.AM_SERVICE(B.SERVICE_CODE,'"+locale+"','2') SERVICE_SHORT_DESC" );
		sql.append("  , B.SPECIALTY_CODE" );
		sql.append("  , AM_GET_DESC.AM_SPECIALITY(B.SPECIALTY_CODE,'"+locale+"','2') SPECIALTY_SHORT_DESC" );
		sql.append("  , SUBSERVICE_CODE" );
		sql.append("  , AM_GET_DESC.AM_SUBSERVICE(B.SERVICE_CODE,B.SUBSERVICE_CODE,'"+locale+"','2') SUBSERVICE_SHORT_DESC" );
		sql.append("  , A.REQ_TEAM_ID TEAM_ID" );
		sql.append("  , AM_GET_DESC.AM_MEDICAL_TEAM(A.FACILITY_ID, A.REQ_TEAM_ID,'"+locale+"','2') TEAM_SHORT_DESC" );
		sql.append("  , A.TFR_REQ_ACCEPTED_YN" );
		sql.append("  , A.TFR_REQ_DATE_TIME" );
		sql.append("  , A.TFR_REQ_REASON" );
		sql.append("  , A.TFR_REQ_REF_NO" );
		sql.append("  , A.TFR_REQ_STATUS" );
		sql.append("  , A.TFR_REQ_STATUS TFR_REQ_STATUS_DESC" );
		sql.append("  , A.TFR_REQ_TYPE" );
		sql.append("  , A.TFR_REQ_TYPE TFR_REQ_TYPE_DESC" );
		sql.append("  , IP_GET_DESC.IP_TRANSFER_TYPE(A.TFR_REQ_REASON,'"+locale+"','2') TRANSFER_TYPE_SHORT_DESC" );
		sql.append("  , to_char (C.DATE_OF_BIRTH, 'dd/mm/rrrr hh24:mi') DATE_OF_BIRTH" );
		sql.append("  , B.PATIENT_CLASS" );
		sql.append("  , NULL DLY_CHARGE " );
		sql.append("  , to_char(a.modified_date,'dd/mm/rrrr hh24:mi') modified_date " );
		//11/15/2008 FS102IPSRRCRF0228V2.0
		sql.append("  , a.blocking_type_code " );
		/*Monday, September 13, 2010 , SRR20056-SCF-5155 [IN:023680]*/
		sql.append("  ,(select pseudo_bed_yn from ip_nursing_unit_bed where  facility_id = b.facility_id and  nursing_unit_code = b.nursing_unit_code and bed_no = b.bed_num) pseudo_bed_yn " );
		//
		sql.append("from" );
		sql.append("  IP_TRANSFER_REQUEST A" );
		sql.append("  , IP_OPEN_ENCOUNTER B" );
		sql.append("  , MP_PATIENT C " );
		sql.append("where A.FACILITY_ID = B.FACILITY_ID " );
		sql.append("  and A.ENCOUNTER_ID = B.ENCOUNTER_ID " );
		sql.append("  and A.ENCOUNTER_ID = '"+encounterid+"' " );
		sql.append("  and A.FACILITY_ID = '"+facilityId+"' " );
		sql.append("  and A.TFR_REQ_STATUS = '0' " );
		sql.append("  and B.PATIENT_ID = C.PATIENT_ID" );
		
		stmt	= con.createStatement();

		rset	= stmt.executeQuery(sql.toString());
		if (rset.next() && rset != null)
		{
			modified_date_val	= checkForNull(rset.getString("modified_date"));  
			admissiondate		= checkForNull(rset.getString("admission_date")); 
			if(!(admissiondate.equals("") || admissiondate == null))
						admissiondate_converted = DateUtils.convertDate(admissiondate,"DMYHM","en",locale); 
		
			admissiontype		= checkForNull(rset.getString("admission_short_desc"));
			frbedtype			= checkForNull(rset.getString("bed_type_code"));
			gender				= checkForNull(rset.getString("gender"));
			priority			= checkForNull(rset.getString("priority_short_desc"));
			trntypecode			= checkForNull(rset.getString("tfr_req_type"));
			trntypedesc			= checkForNull(rset.getString("transfer_type_short_desc"));  
			bookingdatetime		= checkForNull(rset.getString("booking_date_time"));
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
			frpractitionerid		= checkForNull(rset.getString("req_practitioner_id"));
			frdailycharge		= Integer.parseInt(checkForNull(rset.getString("dly_charge"),"0"));
			age					= checkForNull(rset.getString("date_of_birth"));
			patient_class		= checkForNull(rset.getString("patient_class"));
			//11/15/2008 FS102IPSRRCRF0228V2.0
			blocking_remarks    = checkForNull(rset.getString("blocking_type_code"));
			pseudo_bed_yn		= checkForNull(rset.getString("pseudo_bed_yn"),"N");
			//
		}

		if (rset!=null) rset.close();
		if (stmt!=null) stmt.close();

		if (bl_operational.equals("Y"))
		{
			StringBuffer bl_elig = new StringBuffer();
			bl_elig.append("select a.blng_grp_id, a.short_desc from BL_BLNG_GRP a, BL_EPISODE_FIN_DTLS b where a.blng_grp_id = b.blng_grp_id and b.operating_facility_id ='"+facilityId+"' and b.episode_id = '"+encounterid+"'");			
			stmt1 = con.createStatement();

			rset1 = stmt1.executeQuery(bl_elig.toString());
			while (rset1.next())
			{
				billing_group_id = rset1.getString("BLNG_GRP_ID");
				billing_group_desc = rset1.getString("SHORT_DESC");
			}
			if (rset1!=null) rset1.close();
			if (stmt1!=null) stmt1.close();
		}	

		String auto_file_transfer_yn ="";
		int cnt=0;		
		String sqlQuery = "";
		String sqlQuery1 ="";

		sqlQuery = "SELECT auto_file_transfer_yn FROM ip_nursing_unit WHERE facility_id = ? AND nursing_unit_code = ? AND 'Y' = (SELECT install_yn FROM sm_module WHERE module_id = 'FM') AND 'Y' = (Select transfer_file_yn from fm_parameter  where facility_id =?) AND fs_locn_code is not null";

		pstmt = con.prepareStatement(sqlQuery);
		pstmt.setString(1,facilityId);
		pstmt.setString(2,frnursingunitcode);
		pstmt.setString(3,facilityId);
		rs = pstmt.executeQuery();
		if(rs!=null && rs.next())
			auto_file_transfer_yn = rs.getString("auto_file_transfer_yn")==null?"":rs.getString("auto_file_transfer_yn");
		
		if (rs!=null)rs.close();
			if (pstmt!=null)pstmt.close();


	    if(auto_file_transfer_yn.equals("Y")) {			
			sqlQuery1 = " Select count(*) from fm_transit_file where facility_id =? and patient_id =?";			
			pstmt = con.prepareStatement(sqlQuery1);
			pstmt.setString(1,facilityId);
			pstmt.setString(2,patientid);			
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next())
				cnt =rs.getInt(1);					
			if (rs!=null)rs.close();
			if (pstmt!=null)pstmt.close();				
			if(cnt==0)
			 allow_transfer_yn="Y";
			else								
			 allow_transfer_yn="N";
			
			
		}
		
		/*10/20/2008 FS102IPSRRCRF0228V2.0 */
			
			String sql_nu	= " select ALLOW_EMERG_TRF_YN  from IP_NURSING_UNIT where nursing_unit_code='"+frnursingunitcode+"' and facility_id ='"+facilityId+"' ";

			stmt = con.createStatement() ;	
			rset = stmt.executeQuery(sql_nu.toString());
			
			if( rset != null &&  rset.next())
				{
					allow_emerg_trf_yn = checkForNull(rset.getString("allow_emerg_trf_yn"));
				 }
				if(rset!=null) rset.close();		
			
	%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>

	<script src='../js/ConfirmCancelTransfer.js' language="javascript"></script>
	<!--//Maheshwaran added JS for GHL-CRF-0362-->
		<script src="../js/BedBookingTransfer.js" language="javascript"></script>
	<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>
<body onLoad='seDef(); getOnload_tfrDtls();' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<form name="ConfirmCancelTransfer_form" id="ConfirmCancelTransfer_form"  method="post" action="../../servlet/eIP.ConfirmCancelTransferServlet" target=messageFrame>
	<table border=0 width="100%" cellpadding='2' cellspacing=0>
		<tr>
			<td width='25%' class="label" ><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/></td>
			<td  class='querydata' width='25%'><input type="hidden" name="admission_date" id="admission_date" value="<%=admissiondate%>"><%=admissiondate_converted%></td>
			<td class="label" width='25%'><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/></td>
			<td  class='querydata' width='25%'><input type="hidden" name="admission_type" id="admission_type" value="<%=admissiontype%>"><%=admissiontype%></td> 
		</tr>
		<tr>
			<td class="label"  nowrap><fmt:message key="eIP.TransferBookingDate.label" bundle="${ip_labels}"/></td>
			<td class='querydata' ><%=bookingdatetime_converted%><input type="hidden" name="transfer_date" id="transfer_date"  value="<%=bookingdatetime%>"></td>
			<td class="label" ><fmt:message key="eIP.ReasonforTransfer.label" bundle="${ip_labels}"/></td>
			<td class='querydata' ><%=trntypedesc%><input type="hidden" name="transfer_type" id="transfer_type" value="<%=trntypecode%>"></td>
		</tr>
		<tr>
			<!--Added by kishore on 4/23/2004-->
			<td class="label" ><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
			<td class='querydata' ><%=priority%><input type="hidden" name="priority_code" id="priority_code" value="<%=priority%>"></td>
			<td class="label"  nowrap>&nbsp;</td>
			<td class='querydata' ></td>
		</tr>
	</table>
		<jsp:include page="../../eIP/jsp/TransferDetails.jsp" ><jsp:param name="flush" value="true" />
			<jsp:param name ="call_function"  value="confirm_request" />
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
			<jsp:param name ="deact_pseudo_bed"  value="<%=deactivate_pseudo_bed_yn%>" />
		</jsp:include> 
	<table border=0 width="100%" cellpadding=2 cellspacing=0>
		<tr>
			<th colspan=4 class='columnheader'><fmt:message key="eIP.BlockBedDetails.label" bundle="${ip_labels}"/></th>
		</tr>
		<tr>
			<td  class="label" width='25%'><fmt:message key="eIP.BlockBed.label" bundle="${ip_labels}"/></td>
			<td class='fileds' width='25%'><input type='checkbox' name='block_bed' id='block_bed' onClick="enableInform();" ></td>
			<td class="label" width='25%'>&nbsp;</td>
			<td width='25%'>&nbsp;</td>
		</tr>
		<tr>
			<td class='label' ><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
			<td class='fileds' ><input type=text name='bed_block_periond' id='bed_block_periond' value="" disabled id='calid3' maxlength="3" size="3" onBlur = "validSpecialChars(this);CheckNum(this);" onKeyPress="return allowOnlyNumbers(event);"><img src='../../eCommon/images/mandatory.gif' id="img_m" ></img><span class='label'><fmt:message key="Common.hours.label" bundle="${common_labels}"/></span></td>
			<td class="label" ><fmt:message key="Common.override.label" bundle="${common_labels}"/></td>
			<td class='fileds'><input type='checkbox' name='override' id='override' disabled></td>

		</tr>
	</table>

<!--10/20/2008 FS102IPSRRCRF0228V2.0-->
	
		<table width='100%' cellpadding='2' cellspacing='0' BORDER='0'>
	<tr>
		<td colspan=4 width="100%" class="COLUMNHEADER"><fmt:message key="eIP.ReserveBedDetails.label" bundle="${ip_labels}"/></td>
	</tr>
	<TR>
	<TD  class="label" width='25%'><fmt:message key="eIP.ReserveBed.label" bundle="${ip_labels}"/></TD>
	<TD   class="fields" colspan='3'><INPUT TYPE="checkbox" name="reserved_bed_yn" id="reserved_bed_yn" disabled <%if(!allow_emerg_trf_yn.equals("Y") && !blocking_remarks.equals("")){%> checked <%}%>><input type="hidden" name="is_reserved_bed_checked" id="is_reserved_bed_checked"  value="N"></TD>
	</TR>
	
	</table>
	
	<!---->

	<table border=0 width="100%" cellpadding='2' cellspacing=0>
		<tr>	
			<td align='right'><input type="button" class="button" id="confirm_or_cancel" name = "confirm_or_cancel" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.confirm.label","common_labels")%>" onclick="checkValues();submitForm_confmCncl('CONFIRM');"><input type="button" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onclick="const dialogTag = parent.parent.document.getElementById('dialog_tag'); dialogTag.close();"></td>
		</tr>
	</table>	
	<input type="hidden" name="modified_date_val" id="modified_date_val" value="<%=modified_date_val%>">
	<input type="hidden" name="patient_id" id="patient_id" value="<%=patientid%>">
	<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounterid%>">
	<input type="hidden" name="fr_bed_type" id="fr_bed_type" value="<%=frbedtype%>">
	<input type="hidden" name="booking_ref_no" id="booking_ref_no" value="<%=bookingrefno%>">
	<input type="hidden" name="patient_gender" id="patient_gender" value="<%=gender%>">
	<input type="hidden" name="def_max_period" id="def_max_period" value="<%=BED_BLOCK_PERIOD_MAX%>">
	<input type="hidden" name="continue_yn" id="continue_yn" > 
	<input type="hidden" name="pri_target" id="pri_target">
	<input type="hidden" name="priority_value" id="priority_value" value="<%=priority%>" >
	<input type="hidden" name="to_nursing_unit_type" id="to_nursing_unit_type" value="<%=tonursingunittype%>">
	<input type="hidden" name="to_bed_type" id="to_bed_type" value="<%=tobedtype%>">
	<input type="hidden" name="tobedtype" id="tobedtype" value="">
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
	<input type="hidden" name="practid" id="practid" value="" >
	<input type="hidden" name="reason_for_cancelation" id="reason_for_cancelation" value="" >
	<input type="hidden" name="from_daily_rate" id="from_daily_rate" value="0" >
	<input type="hidden" name="BalnkFlag" id="BalnkFlag" value="N" >
	<input type="hidden" name="call_function" id="call_function" value="confirm_request" >
	<input type="hidden" name="bed_change" id="bed_change" value="">
	<input type="hidden" name="blocking_remarks" id="blocking_remarks" value="<%=blocking_remarks%>">
	<input type="hidden" name="pseudo_bed" id="pseudo_bed" value="<%=pseudo_bed_yn%>">
	<input type="hidden" name="deactivate_pseudo_bed" id="deactivate_pseudo_bed" value="<%=deactivate_pseudo_bed_yn%>">
	<!--//Maheshwaran added for GHL-CRF-0362-->
	<input type="hidden" name="p_oper_stn_id" id="p_oper_stn_id" value="<%=p_oper_stn_id%>">
	<input type="hidden" name="change_bed_class_yn" id="change_bed_class_yn" value="<%=oper_stn_bed_class_yn%>">
	<!--End-->
	<%
	if(bl_interfaced_yn.equals("Y"))
	{%>
			<input type="hidden" name="transfer_chargeable_yn" id="transfer_chargeable_yn" value="">
			<input type="hidden" name="transfer_serv_charge" id="transfer_serv_charge" value="">
			<input type="hidden" name="surgery_reqd_yn" id="surgery_reqd_yn" value="">
			<input type="hidden" name="addnl_dep_amt" id="addnl_dep_amt" value="">
<%}
	}catch(Exception e)
	{
		out.print("Exception :"+e);
	}
	finally 
	{
		if(rset	!= null)   rset.close();
		if(stmt1  != null)   stmt1.close();
		if(rset1   != null)   rset1.close();
		if(stmt   != null)   stmt.close();
	}
}
catch(Exception e)
{
	out.println("Exception in tryCatch : "+ e.toString());
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
	 %>
</form>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}
%>

