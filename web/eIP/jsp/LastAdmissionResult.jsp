<!DOCTYPE html>
 <%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,org.json.simple.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
	 <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	</script>
	
	</head>
<%
    request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	Connection con					= null;
	
	Statement  stmt1				= null;
	ResultSet  rset1				= null;
	ResultSet  rs3				= null;
	PreparedStatement pstmt1	= null;
	/*Added by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866 Start*/
	JSONObject ipParamJson			= new JSONObject();
	String dispBedClsChangeAuthYn	= "";
	String patient_class	= "";
	boolean isBedSideReferralApplforAE = false;
	/*End*/
	try
	{
		Boolean enteredByAppl = false;	// Added by shagar for ML-MMOH-CRF-1328
		con		= ConnectionManager.getConnection(request);
		enteredByAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP", "ENTERED_BY");// Added by shagar for ML-MMOH-CRF-1328
		isBedSideReferralApplforAE = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "BED_SIDE_REFERRAL_FOR_AE");
//		String patientId	= checkForNull(request.getParameter("patientId"));
//		String filename		= checkForNull(request.getParameter("Filename"));
		String encounter_id = checkForNull(request.getParameter("encounter_id"));
		String facilityId	= (String)session.getValue("facility_id");
		String facility_id	= checkForNull(request.getParameter("facility_id"), facilityId);

		String classValue	= "";
		StringBuffer sqlQuery	= new StringBuffer();
		
		/*Added by Thamizh selvi on 15th Nov 2017 for ML-MMOH-CRF-0866 Start*/
		ipParamJson				= eIP.IPCommonBean.getIPParam(con, facilityId);
		dispBedClsChangeAuthYn	= (String)ipParamJson.get("dispBedClsChangeAuthYn");
		/*End*/

		//sqlQuery.append("SELECT TO_CHAR(A.trn_date_time,'dd/mm/yyyy hh24:mi') trans_date_time ,a.added_by_id ,A.trn_date_time,decode(A.trn_type,'D', IP_GET_DESC.IP_NURSING_UNIT(a.facility_id, a.fr_nursing_unit_code,'"+locale+"','2'),'L',IP_GET_DESC.IP_NURSING_UNIT(a.facility_id, a.fr_nursing_unit_code,'"+locale+"','2'), IP_GET_DESC.IP_NURSING_UNIT(a.FACILITY_ID, a.to_nursing_unit,'"+locale+"','2')) to_nursing_unit_short_desc,decode(A.trn_type,'D',fr_room_no,to_room_no) to_room_no,decode(A.trn_type,'D',fr_bed_no,to_bed_no) to_bed_no,decode(A.trn_type,'D',AM_GET_DESC.AM_PRACTITIONER(a.fr_practitioner_id,'"+locale+"','1'),'L',AM_GET_DESC.AM_PRACTITIONER(a.fr_practitioner_id,'"+locale+"','1'),AM_GET_DESC.AM_PRACTITIONER(a.to_practitioner_id,'"+locale+"','1')) to_practitioner_long_name,decode(A.trn_type,'D',AM_GET_DESC.AM_SPECIALITY(a.fr_specialty_code,'"+locale+"','2'),'L',AM_GET_DESC.AM_SPECIALITY(a.fr_specialty_code,'"+locale+"','2'),AM_GET_DESC.AM_SPECIALITY(a.to_specialty_code,'"+locale+"','2')) to_specialty_short_desc,DECODE(A.trn_type,'A',CASE WHEN adt_trn_status='8' THEN 'Admission Cancelled' ELSE 'Admitted' END,'T','Transferred','D','Discharged','L','Leave','C','Leave Cancelled','R','Rejoined from Leave') remarks,AM_GET_DESC.AM_CONTACT_REASON(a.cancel_reason_code,'"+locale+"','1') Reason ,a.trn_code,(CASE WHEN a.trn_type = 'A' THEN IP_GET_DESC.IP_ADMISSION_TYPE(a.trn_code,'"+locale+"','2') WHEN a.trn_type = 'T' THEN IP_GET_DESC.IP_TRANSFER_TYPE(a.trn_code,'"+locale+"','2') WHEN a.trn_type = 'D' THEN IP_GET_DESC.IP_DISCHARGE_TYPE(a.trn_code,'"+locale+"','2') END ) trn_desc FROM IP_ADT_TRN A WHERE A.facility_id='"+facility_id+"' AND A.encounter_id='"+encounter_id+"' AND a.srl_no like '%%' UNION SELECT TO_CHAR(a.ADDED_DATE,'dd/mm/yyyy hh24:mi')trans_date_time, a.added_by_id, a.ADDED_DATE trn_date_time, IP_GET_DESC.IP_NURSING_UNIT(B.facility_id, B.to_nursing_unit,'"+locale+"','2') to_nursing_unit_short_desc , B.to_room_no , B.to_bed_no , NULL to_practitioner_long_name ,NULL to_specialty_short_desc , DECODE(A.MOVEMENT_TYPE,'A','Arrived at ','D','Departed to ')|| decode(TO_LOCN_TYPE, 'N', IP_GET_DESC.IP_NURSING_UNIT(a.FACILITY_ID, a.to_locn_code,'"+locale+"','2') , OP_GET_DESC.OP_CLINIC(a.FACILITY_ID, a.to_locn_code,'"+locale+"','1')) remarks, null Reason , NULL trn_code, AM_GET_DESC.AM_CONTACT_REASON(a.MOVEMENT_REASON_CODE,'"+locale+"','1') trn_desc FROM PR_PATIENT_MOVEMENT A, ip_adt_trn B WHERE A.facility_id='"+facility_id+"' AND B.encounter_id='"+encounter_id+"' AND A.srl_no like '%%' AND A.FROM_LOCN_TYPE IS NOT NULL AND A.FACILITY_ID = B.FACILITY_ID AND A.ENCOUNTER_ID = B.ENCOUNTER_ID and b.added_date = (select max(added_date) from ip_adt_trn where FACILITY_ID = B.FACILITY_ID AND ENCOUNTER_ID = B.ENCOUNTER_ID) ORDER BY trn_date_time");

		if(isBedSideReferralApplforAE){
		String sql1="select patient_class from pr_encounter where facility_id=? and encounter_id=? " ;
		pstmt1 = con.prepareStatement(sql1) ;
		pstmt1.setString(1,facility_id);
		pstmt1.setString(2,encounter_id);
			
		rs3 = pstmt1.executeQuery();
		if (rs3!=null && rs3.next()) {
			patient_class=rs3.getString("PATIENT_CLASS");
		}
		}
		if(isBedSideReferralApplforAE && patient_class.equals("EM")){
			sqlQuery.append("SELECT TO_CHAR(a.visit_adm_date_time,'dd/mm/yyyy hh24:mi') trans_date_time, a.clinic_name to_nursing_unit_short_desc, a.assign_bed_num to_bed_no, am_get_desc.am_practitioner (a.attend_practitioner_id, '"+locale+"', '1' ) to_practitioner_long_name, am_get_desc.am_speciality (a.specialty_code, '"+locale+"', '2' ) to_specialty_short_desc FROM pr_encounter_vw a where a.facility_id = '"+facility_id+"' AND a.encounter_id = '"+encounter_id+"'");
		}else{
		sqlQuery.append("SELECT TO_CHAR(A.trn_date_time,'dd/mm/yyyy hh24:mi') trans_date_time ,a.added_by_id,sm_get_desc.SM_APPL_USER(a.added_by_id,'"+locale+"',1) user_name ,(SELECT am_get_desc.am_speciality (primary_speciality_code, '"+locale+"', 2 ) FROM am_practitioner WHERE practitioner_id = (SELECT func_role_id FROM sm_appl_user WHERE appl_user_id = a.added_by_id AND func_role = 'P')) prac_speciality, (SELECT am_get_desc.am_other_staff_type (pract_type, '"+locale+"', 2 ) FROM sm_appl_user_vw WHERE appl_user_id = a.added_by_id AND func_role = 'O') other_staff_type, A.trn_date_time,decode(A.trn_type,'D', IP_GET_DESC.IP_NURSING_UNIT(a.facility_id, a.fr_nursing_unit_code,'"+locale+"','2'),'L',IP_GET_DESC.IP_NURSING_UNIT(a.facility_id, a.fr_nursing_unit_code,'"+locale+"','2'), IP_GET_DESC.IP_NURSING_UNIT(a.FACILITY_ID, a.to_nursing_unit,'"+locale+"','2')) to_nursing_unit_short_desc,DECODE (a.trn_type, 'D', ip_get_desc.ip_bed_class (fr_bed_class_code, '"+locale+"', 2), ip_get_desc.ip_bed_class (to_bed_class_code, '"+locale+"', 2) ) to_bed_class_desc,decode(A.trn_type,'D',fr_room_no,to_room_no) to_room_no,decode(A.trn_type,'D',fr_bed_no,to_bed_no) to_bed_no,decode(A.trn_type,'D',AM_GET_DESC.AM_PRACTITIONER(a.fr_practitioner_id,'"+locale+"','1'),'L',AM_GET_DESC.AM_PRACTITIONER(a.fr_practitioner_id,'"+locale+"','1'),AM_GET_DESC.AM_PRACTITIONER(a.to_practitioner_id,'"+locale+"','1')) to_practitioner_long_name,decode(A.trn_type,'D',AM_GET_DESC.AM_SPECIALITY(a.fr_specialty_code,'"+locale+"','2'),'L',AM_GET_DESC.AM_SPECIALITY(a.fr_specialty_code,'"+locale+"','2'),AM_GET_DESC.AM_SPECIALITY(a.to_specialty_code,'"+locale+"','2')) to_specialty_short_desc,DECODE(A.trn_type,'A',CASE WHEN adt_trn_status='8' THEN 'Admission Cancelled' ELSE 'Admitted' END,'T','Transferred','D','Discharged','L','Leave','C','Leave Cancelled','R','Rejoined from Leave') remarks,AM_GET_DESC.AM_COMPLAINT( B.CHIEF_COMPLAINT , '"+locale+"','1') Reason ,a.trn_code,(CASE WHEN a.trn_type = 'A' THEN IP_GET_DESC.IP_ADMISSION_TYPE(a.trn_code,'"+locale+"','2') WHEN a.trn_type = 'T' THEN IP_GET_DESC.IP_TRANSFER_TYPE(a.trn_code,'"+locale+"','2') WHEN a.trn_type = 'D' THEN IP_GET_DESC.IP_DISCHARGE_TYPE(a.trn_code,'"+locale+"','2') END ) trn_desc FROM IP_ADT_TRN A ,PR_ENCOUNTER B WHERE A.facility_id='"+facility_id+"' AND A.encounter_id='"+encounter_id+"' AND  A.encounter_id= B.encounter_id AND a.srl_no like '%%' and a.facility_id = b.facility_id UNION SELECT TO_CHAR(a.ADDED_DATE,'dd/mm/yyyy hh24:mi')trans_date_time, a.added_by_id,sm_get_desc.sm_appl_user (a.added_by_id, 'en', 1) user_name,(SELECT am_get_desc.am_speciality (primary_speciality_code, '"+locale+"', 2 ) FROM am_practitioner WHERE practitioner_id = (SELECT func_role_id FROM sm_appl_user WHERE appl_user_id = a.added_by_id AND func_role = 'P')) prac_speciality, (SELECT am_get_desc.am_other_staff_type (pract_type, '"+locale+"', 2 ) FROM sm_appl_user_vw WHERE appl_user_id = a.added_by_id AND func_role = 'O') other_staff_type, a.ADDED_DATE trn_date_time, IP_GET_DESC.IP_NURSING_UNIT(B.facility_id, B.to_nursing_unit,'"+locale+"','2') to_nursing_unit_short_desc ,ip_get_desc.ip_bed_class (b.to_bed_class_code, '"+locale+"', 2 ) to_bed_class_desc, B.to_room_no , B.to_bed_no , NULL to_practitioner_long_name ,NULL to_specialty_short_desc , DECODE(A.MOVEMENT_TYPE,'A','Arrived at ','D','Departed to ')|| decode(TO_LOCN_TYPE, 'N', IP_GET_DESC.IP_NURSING_UNIT(a.FACILITY_ID, a.to_locn_code,'"+locale+"','2') , OP_GET_DESC.OP_CLINIC(a.FACILITY_ID, a.to_locn_code,'"+locale+"','1')) remarks, null Reason , NULL trn_code, AM_GET_DESC.AM_CONTACT_REASON(a.MOVEMENT_REASON_CODE,'"+locale+"','1') trn_desc FROM PR_PATIENT_MOVEMENT A, ip_adt_trn B WHERE A.facility_id='"+facility_id+"' AND B.encounter_id='"+encounter_id+"' AND A.srl_no like '%%' AND A.FROM_LOCN_TYPE IS NOT NULL AND A.FACILITY_ID = B.FACILITY_ID AND A.ENCOUNTER_ID = B.ENCOUNTER_ID and  b.added_date = (select max(added_date) from ip_adt_trn where FACILITY_ID = B.FACILITY_ID AND ENCOUNTER_ID = B.ENCOUNTER_ID)");//Modified by Thamizh selvi on 10th Nov 2017 for ML-MMOH-CRF-0866
		// user_name added by mujafar for ML-MMOH-SCF-0886
		
		/*Added by Thamizh selvi on 20th Nov 2017 for ML-MMOH-CRF-0866 Start*/
		if(dispBedClsChangeAuthYn.equals("Y")){
			sqlQuery.append("UNION SELECT TO_CHAR (confirmed_date_time, 'dd/mm/yyyy hh24:mi') trans_date_time, confirmed_by_id added_by_id,sm_get_desc.sm_appl_user (confirmed_by_id, 'en', 1) user_name, (SELECT am_get_desc.am_speciality (primary_speciality_code, '"+locale+"', 2 ) FROM am_practitioner WHERE practitioner_id = (SELECT func_role_id FROM sm_appl_user WHERE appl_user_id = confirmed_by_id AND func_role = 'P')) prac_speciality, (SELECT am_get_desc.am_other_staff_type (pract_type, '"+locale+"', 2 ) FROM sm_appl_user_vw WHERE appl_user_id = confirmed_by_id AND func_role = 'O') other_staff_type, confirmed_date_time trn_date_time, ip_get_desc.ip_nursing_unit (facility_id, to_nursing_unit_code, '"+locale+"', '2' ) to_nursing_unit_short_desc, ip_get_desc.ip_bed_class (to_bed_class_code, '"+locale+"', 2) to_bed_class_desc, to_room_no, to_bed_no, am_get_desc.am_practitioner (to_practitioner_id, '"+locale+"', '1' ) to_practitioner_long_name, am_get_desc.am_speciality (to_specialty_code, '"+locale+"', '2') to_specialty_short_desc, 'Confirmed Class Change' remarks, NULL reason, NULL trn_code, DECODE (bl_charging_req_type, 'P', 'Patient Request', 'H', 'Hospital Request' ) trn_desc FROM ip_confirm_bed_cls WHERE facility_id = '"+facility_id+"' AND encounter_id = '"+encounter_id+"' AND srl_no LIKE '%%' ORDER BY trn_date_time DESC, REMARKS DESC"); // user_name added by mujafar for ML-MMOH-SCF-0886
		}else{
			sqlQuery.append(" ORDER BY trn_date_time desc");
		}/*End*/
		}
		
%>

<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<FORM METHOD=POST ACTION="">
	
		<table cellspacing=0 cellpadding=2 align='center' width='100%' border='1'>
		<tr>
			<td  colspan='10' class='CAGROUPHEADING'>&nbsp;<fmt:message key="Common.staydetails.label" bundle="${common_labels}"/></td>
		</tr>
			
		<tr>
			<% if(isBedSideReferralApplforAE){ %>
				<% if(!patient_class.equals("EM")){ %>
				<td class='COLUMNHEADER'><fmt:message key="eIP.Activity.label" bundle="${ip_labels}"/></td>
				<%}%>
			<%}else{%>
				<td class='COLUMNHEADER'><fmt:message key="eIP.Activity.label" bundle="${ip_labels}"/></td>
			<%}%>

			<td class='COLUMNHEADER'><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>

			<% if(isBedSideReferralApplforAE){ %>
				<% if(!patient_class.equals("EM")){ %>
				<td class='COLUMNHEADER'><fmt:message key="eIP.ActivityReason.label" bundle="${ip_labels}"/></td>
				<%}%>
			<%}else{%>
				<td class='COLUMNHEADER'><fmt:message key="eIP.ActivityReason.label" bundle="${ip_labels}"/></td>
			<%}%>

			<% if(isBedSideReferralApplforAE){ %>
				<% if(patient_class.equals("EM")){ %>
				<td class='COLUMNHEADER'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
				<%}else{%>
				<td class='COLUMNHEADER'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
				<%}%>
			<%}else{%>
				<td class='COLUMNHEADER'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
			<%}%>

			<% if(isBedSideReferralApplforAE){ %>
				<% if(!patient_class.equals("EM")){ %>
				<td class='COLUMNHEADER'><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/></td>
				<%}%>
			<%}else{%>
				<td class='COLUMNHEADER'><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/></td>
			<%}%>

			<td class='COLUMNHEADER'><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>
				
			<% if(isBedSideReferralApplforAE){ %>
				<% if(!patient_class.equals("EM")){ %>
				<td class='COLUMNHEADER'><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></td>
				<%}%>
			<%}else{%>
				<td class='COLUMNHEADER'><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></td><!--Added by Thamizh selvi on 10th Nov 2017 for ML-MMOH-CRF-0866-->
			<%}%>

			<td class='COLUMNHEADER'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
	<%//f(!(filename.equals("CurrentEncounterMain")))
	        
	//%>		<!-- below lines commented by venkatesh.s(em_id:4008) on 19/Sep/2011 for the incident SRR20056-SCF-7120-INO26963-->
	<!--<td class='COLUMNHEADER'><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td> -->
	<!--end for the incident SRR20056-SCF-7120-INO26963-->	
	        
			<% if(isBedSideReferralApplforAE){ %>
				<% if(!patient_class.equals("EM")){ %>
				<%if(enteredByAppl){ // Added by shagar for ML-MMOH-CRF-1328 %>
				<td class='COLUMNHEADER'><fmt:message key="Common.EnteredBy.label" bundle="${common_labels}"/>&nbsp;(<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>/<fmt:message key="Common.StaffType.label" bundle="${common_labels}"/>)</td><!--Modified by Thamizh selvi on 10th Nov 2017 for ML-MMOH-CRF-0866-->
				<%}else {%>
				<td class='COLUMNHEADER'><fmt:message key="Common.whodoneit.label" bundle="${common_labels}"/>&nbsp;(<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>/<fmt:message key="Common.StaffType.label" bundle="${common_labels}"/>)</td>
				<%}}%>
			<%}else{%>
					<%if(enteredByAppl){ // Added by shagar for ML-MMOH-CRF-1328 %>
				<td class='COLUMNHEADER'><fmt:message key="Common.EnteredBy.label" bundle="${common_labels}"/>&nbsp;(<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>/<fmt:message key="Common.StaffType.label" bundle="${common_labels}"/>)</td><!--Modified by Thamizh selvi on 10th Nov 2017 for ML-MMOH-CRF-0866-->
				<%}else {%>
				<td class='COLUMNHEADER'><fmt:message key="Common.whodoneit.label" bundle="${common_labels}"/>&nbsp;(<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>/<fmt:message key="Common.StaffType.label" bundle="${common_labels}"/>)</td>
				<%}}%>
		</tr>

		<% 	
		
		stmt1 = con.createStatement();	
		rset1 = stmt1.executeQuery(sqlQuery.toString());		

		while(rset1.next()) 
		{ 
		  String trn_date_time_converted = "";
		  String trn_desc = "";
		  String trn_date_time = "";
		  String to_nursing_unit_short_desc = "";
		  String to_room_no = "";
		  String to_bed_no = "";
		  String to_practitioner_long_name = "";
		  String added_by = "";
		  String to_bed_class_desc = "";
		  String prac_speciality = "";
		  String other_staff_type = "";
		  String to_specialty_short_desc = "";
		  String remarks = "";
		  String reason = "";

		  if(isBedSideReferralApplforAE && patient_class.equals("EM")){
			  trn_date_time				= checkForNull(rset1.getString("trans_date_time"));
			  to_nursing_unit_short_desc	= checkForNull(rset1.getString("to_nursing_unit_short_desc"),"&nbsp;");
			  to_bed_no					= checkForNull(rset1.getString("to_bed_no"),"&nbsp;");
			  to_practitioner_long_name	= checkForNull(rset1.getString("to_practitioner_long_name"),"&nbsp;");
			  to_specialty_short_desc	= checkForNull(rset1.getString("to_specialty_short_desc"),"&nbsp;");
		  }else{
			  trn_desc				= checkForNull(rset1.getString("trn_desc"));
				if(trn_desc.equals("")) trn_desc = "&nbsp;";
			  trn_date_time				= checkForNull(rset1.getString("trans_date_time"));
			  to_nursing_unit_short_desc	= checkForNull(rset1.getString("to_nursing_unit_short_desc"),"&nbsp;");
			  to_room_no					= checkForNull(rset1.getString("to_room_no"),"&nbsp;");
			  to_bed_no					= checkForNull(rset1.getString("to_bed_no"),"&nbsp;");
			  to_practitioner_long_name	= checkForNull(rset1.getString("to_practitioner_long_name"),"&nbsp;");
			  added_by					= checkForNull(rset1.getString("user_name"),"&nbsp;"); // user_name added by mujafar for ML-MMOH-SCF-0886
			  /*Added by Thamizh selvi on 10th Nov 2017 for ML-MMOH-CRF-0866 Start*/
			  to_bed_class_desc			= checkForNull(rset1.getString("to_bed_class_desc"),"&nbsp;");
			  prac_speciality			= checkForNull(rset1.getString("prac_speciality"),"&nbsp;");
			  other_staff_type			= checkForNull(rset1.getString("other_staff_type"),"&nbsp;");
			  if(!prac_speciality.equals("&nbsp;") && other_staff_type.equals("&nbsp;")){
					added_by = added_by + "&nbsp;(" + prac_speciality + ")";
			  }else if(!other_staff_type.equals("&nbsp;") && prac_speciality.equals("&nbsp;")){
					added_by = added_by + "&nbsp;(" + other_staff_type + ")";
			  }/*End*/

			  to_specialty_short_desc	= checkForNull(rset1.getString("to_specialty_short_desc"),"&nbsp;");
			  remarks					= checkForNull(rset1.getString("remarks"),"&nbsp;");
			  reason						= checkForNull(rset1.getString("reason"),"&nbsp;");
		  }

		  if(!(trn_date_time.equals("") || trn_date_time.equals("&nbsp;") || trn_date_time == null))
					trn_date_time_converted = DateUtils.convertDate(trn_date_time,"DMYHM","en",locale); 
	
		  
		  if (classValue.equals("") || classValue.equals("QRYODDSMALL"))  
			  classValue = "QRYEVENSMALL";
		  else
			  classValue = "QRYODDSMALL";

		  if(remarks.equalsIgnoreCase("Admission Cancelled"))
			{
				remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.CancelledAdmission.label","ip_labels");
			}
		else if(remarks.equalsIgnoreCase("Admitted"))
			{
				remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Admitted.label","common_labels");
			}
		else if(remarks.equalsIgnoreCase("Transferred"))
			{
				remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.Transferred.label","ip_labels");
			}
		else if(remarks.equalsIgnoreCase("Discharged"))
			{
				remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.discharged.label","common_labels");
			}
		else if(remarks.equalsIgnoreCase("Leave"))
			{
				remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Leave.label","common_labels");
			}
		else if(remarks.equalsIgnoreCase("Leave Cancelled"))
			{
				remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Leave.label","common_labels")+' '+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
			}
		else if(remarks.equalsIgnoreCase("Rejoined from Leave"))
			{
				remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.RejoinedFromLeave.label","ip_labels");
			}
	   %>
		<tr>
			<% if(isBedSideReferralApplforAE){ %>
				<% if(!patient_class.equals("EM")){ %>
				<td class=<%=classValue%> ><%=remarks%></td>
				<%}%>
			<%}else{%>
				<td class=<%=classValue%> ><%=remarks%></td>
		    <%}%>

			<td class=<%=classValue%> ><%=trn_date_time_converted%></td>
			
			<% if(isBedSideReferralApplforAE){ %>
				<% if(!patient_class.equals("EM")){ %>
				<td class=<%=classValue%> ><%=trn_desc%></td>
				<%}%>
			<%}else{%>
				<td class=<%=classValue%> ><%=trn_desc%></td>
			<%}%>

			<td class=<%=classValue%> ><%=to_nursing_unit_short_desc%></td>

			<% if(isBedSideReferralApplforAE){ %>
				<% if(!patient_class.equals("EM")){ %>
				<td class=<%=classValue%> ><%=to_room_no%></td>
				<%}%>
			<%}else{%>
				<td class=<%=classValue%> ><%=to_room_no%></td>
			<%}%>

			<td class=<%=classValue%> ><%=to_bed_no%></td>

			<% if(isBedSideReferralApplforAE){ %>
				<% if(!patient_class.equals("EM")){ %>
				<td class=<%=classValue%> ><%=to_bed_class_desc%></td>
				<%}%>
			<%}else{%>
				<td class=<%=classValue%> ><%=to_bed_class_desc%></td><!--Added by Thamizh selvi on 10th Nov 2017 for ML-MMOH-CRF-0866-->
			<%}%>

			<td class=<%=classValue%> ><%=to_practitioner_long_name%></td>
			<td class=<%=classValue%> ><%=to_specialty_short_desc%></td>
	     <!--   <td class=<%=classValue%> style = 'word-break:break-all;'><%=reason%></td> -->
		 	
			<% if(isBedSideReferralApplforAE){ %>
				<% if(!patient_class.equals("EM")){ %>
				<td class=<%=classValue%> ><%=added_by%></td>
				<%}%>
			<%}else{%>
				<td class=<%=classValue%> ><%=added_by%></td>
			<%}%>

		</tr>
	<%		}
	if(rset1!=null)	rset1.close();
	if(stmt1!=null) stmt1.close();
	%>
	</table>
</FORM>


<% } catch(Exception e) {out.println(e);e.printStackTrace(); }
finally
{
	try{
		if(rset1!=null)	rset1.close();
		if(stmt1!=null) stmt1.close();
		if(rs3!=null)  rs3.close();
		if(pstmt1 != null)	pstmt1.close();
		ConnectionManager.returnConnection(con,request);
	} catch(Exception ee) {out.println("Error while closing the connections :"+ee.toString()); }
}
%>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals(""))) ? "" : inputString);
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals(""))) ? defaultValue : inputString);
	}
%>

