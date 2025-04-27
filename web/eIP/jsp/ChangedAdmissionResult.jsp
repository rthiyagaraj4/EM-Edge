<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,com.ehis.util.*,java.text.*" contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'</link>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
		<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
		<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
		<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<%@ page contentType="text/html;charset=UTF-8"%>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
	<%
		Connection con					= null;
		PreparedStatement stmt	= null;
		ResultSet rs						= null;
		String facilityID			=	(String)session.getValue("facility_id");
		String locale				= (String)session.getAttribute("LOCALE");
		//String loginUser			= (String)session.getValue("login_user");
		String encounterID	= request.getParameter("encounter_id");
		String trn_date				= "";
		String visit_adm_type	= "";
		String assign_care_locn_code	= "";
		String bed_class_desc	= "";
		String bed_type_desc	= "";
		String assign_room_num	= "";
		String assign_bed_num		= "";
		String attend_practitioner	= "";
		String service_desc	= "";
		String subservice_desc	= "";
		String specialty_desc	= "";
		String ambulatory_status	= "";
		String chief_complaint	= "";
		String admit_practitioner	= "";
		String modified_by_id			= "";
		String Exp_Discharge_Date_Time			= "";
		String classValue					= "";
//		String encounterID	= (String)session.getValue("encounter_id");
//		String encounterID	= (String)session.getValue("encounter_id");
//		String encounterID	= (String)session.getValue("encounter_id");
//		String encounterID	= (String)session.getValue("encounter_id");
//		String encounterID	= (String)session.getValue("encounter_id");

		StringBuffer Admisin_Dtls_QRY= new  StringBuffer();

		try{
			Boolean enteredByAppl = false;	// Added by shagar for ML-MMOH-CRF-1328
			con = ConnectionManager.getConnection(request);
			enteredByAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP", "ENTERED_BY");// Added by shagar for ML-MMOH-CRF-1328
			//Admisin_Dtls_QRY.append("select to_char(trn_date,'dd/mm/yyyy hh24:mi') trn_date,visit_adm_type_desc,clinic_nursing_unit_name,bed_class_desc,bed_type_desc, assign_room_num, assign_bed_num, practitioner_name,admit_practitioner_name,service_desc,subservice_desc,specialty_desc,to_char(Exp_Discharge_Date_Time,'dd/mm/yyyy hh24:mi')Exp_Discharge_Date_Time, am_get_desc.am_ambulatory_status(ambulatory_status,'"+locale+"',1)ambulatory_status,contact_reason_desc,modified_by_id from pr_encounter_audit_vw where facility_id='"+facilityID+"' and encounter_id='"+encounterID+"' order by  trn_date desc ");
			
			/*Friday, August 20, 2010 , query modified to display descriptions in Thai */
			
			Admisin_Dtls_QRY.append("SELECT   TO_CHAR(a.trn_date, 'dd/mm/yyyy hh24:mi') trn_date,DECODE(a.assign_care_locn_type,'N', ip_get_desc.ip_admission_type(a.visit_adm_type, '"+locale+"', 2),op_get_desc.op_visit_type(a.facility_id,a.visit_adm_type, '"+locale+"', 2) ) visit_adm_type_desc,DECODE(a.assign_care_locn_type,'N', ip_get_desc.ip_nursing_unit(a.facility_id, a.assign_care_locn_code, '"+locale+"', 2),op_get_desc.op_clinic(a.facility_id, a.assign_care_locn_code, '"+locale+"', 2) ) clinic_nursing_unit_name,ip_get_desc.ip_bed_class(a.assign_bed_class_code, '"+locale+"', 1) bed_class_desc,ip_get_desc.ip_bed_type(a.assign_bed_type_code, '"+locale+"', 1) bed_type_desc, a.assign_room_num,a.assign_bed_num,am_get_desc.am_practitioner(a.attend_practitioner_id, '"+locale+"', 1) practitioner_name,am_get_desc.am_practitioner(a.admit_practitioner_id, '"+locale+"', 1) admit_practitioner_name,am_get_desc.am_service(a.service_code, '"+locale+"', 2) service_desc,am_get_desc.am_subservice(a.service_code, a.subservice_code, '"+locale+"', 2) subservice_desc, am_get_desc.am_speciality(a.specialty_code, '"+locale+"', 2) specialty_desc,TO_CHAR(a.exp_discharge_date_time, 'dd/mm/yyyy hh24:mi') exp_discharge_date_time,am_get_desc.am_ambulatory_status(a.ambulatory_status, '"+locale+"', 1) ambulatory_status,am_get_desc.am_contact_reason(a.contact_reason_code, '"+locale+"', 1) contact_reason_desc,a.modified_by_id FROM pr_encounter_audit a WHERE a.facility_id = '"+facilityID+"' AND a.encounter_id = "+encounterID+" ORDER BY a.trn_date DESC ");


	%>
		<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<table cellspacing=0 cellpadding=2 align='center' width='100%' border='1'>
		<tr>
			<td  colspan='16' class='CAGROUPHEADING' nowrap>&nbsp;<fmt:message key="eIP.AdmissionAuditDetails.label" bundle="${ip_labels}"/></td>
		</tr>
		<tr>
		<td class='COLUMNHEADER' nowrap><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' nowrap><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' nowrap><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' nowrap><fmt:message key="Common.subservice.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' nowrap><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' nowrap><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' nowrap><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' nowrap><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' nowrap><fmt:message key="eIP.ExpectesDischargeDate.label" bundle="${ip_labels}"/></td>
<!-- 			<td class='COLUMNHEADER'><fmt:message key="eIP.ProcedureSurgeryDateTime.label" bundle="${ip_labels}"/></td>
 -->	 	<td class='COLUMNHEADER' nowrap><fmt:message key="eIP.AdmittingPractitioner.label" bundle="${ip_labels}"/></td>
			<td class='COLUMNHEADER' nowrap><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' nowrap><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' nowrap><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' nowrap><fmt:message key="Common.ambulatorystatus.label" bundle="${common_labels}"/></td>
			<%// %>
			<%if(enteredByAppl){ // Added by shagar for ML-MMOH-CRF-1328 %>
			<td class='COLUMNHEADER' nowrap><fmt:message key="Common.EnteredBy.label" bundle="${common_labels}"/></td>
            <%}else {%>
			<td class='COLUMNHEADER' nowrap><fmt:message key="Common.whodoneit.label" bundle="${common_labels}"/></td>
			<%}%>
		</tr>
		<%
			int maxRecord=0;
		  if (classValue.equals("") || classValue.equals("QRYODDSMALL"))  
			  classValue = "QRYEVENSMALL";
		  else
			  classValue = "QRYODDSMALL";
			stmt	=con.prepareStatement(Admisin_Dtls_QRY.toString());
			rs	=	stmt.executeQuery();
			while(rs!=null&&rs.next()){
		
		  if (classValue.equals("") || classValue.equals("QRYODDSMALL"))  
			  classValue = "QRYEVENSMALL";
		  else
			  classValue = "QRYODDSMALL";
		  //changes for  Invalid format exception - committed against 40017 - start
//					trn_date						= checkForNull(rs.getString("trn_date"),"&nbsp;") ;            
					trn_date						= checkForNull(rs.getString("trn_date")) ;            
					if(!trn_date.equals(""))
						trn_date				= DateUtils.convertDate(trn_date,"DMYHM","en",locale);
					if(trn_date == "")trn_date="&nbsp;";
					//changes for  Invalid format exception - committed against 40017 - end
					assign_care_locn_code	= checkForNull(rs.getString("clinic_nursing_unit_name"),"&nbsp;") ; 
					service_desc					= checkForNull(rs.getString("service_desc"),"&nbsp;") ;                 
					subservice_desc			= checkForNull(rs.getString("subservice_desc"),"&nbsp;");             
					bed_class_desc			= checkForNull(rs.getString("bed_class_desc"),"&nbsp;");             
					bed_type_desc				= checkForNull(rs.getString("bed_type_desc"),"&nbsp;");             
					assign_room_num			= checkForNull(rs.getString("assign_room_num"),"&nbsp;") ;         
					assign_bed_num			= checkForNull(rs.getString("assign_bed_num"),"&nbsp;");         
					specialty_desc				= checkForNull(rs.getString("specialty_desc"),"&nbsp;");             
					admit_practitioner		= checkForNull(rs.getString("admit_practitioner_name"),"&nbsp;") ;
					attend_practitioner		= checkForNull(rs.getString("practitioner_name"),"&nbsp;") ;     
					Exp_Discharge_Date_Time	= checkForNull(rs.getString("Exp_Discharge_Date_Time"),"") ; //changes for  Invalid format exception - committed against 40017 
					if(!Exp_Discharge_Date_Time.equals(""))
						Exp_Discharge_Date_Time				= DateUtils.convertDate(Exp_Discharge_Date_Time,"DMYHM","en",locale);
					if(Exp_Discharge_Date_Time == "")Exp_Discharge_Date_Time="&nbsp;";
					ambulatory_status		= checkForNull(rs.getString("ambulatory_status"),"&nbsp;");  
					visit_adm_type				= checkForNull(rs.getString("visit_adm_type_desc"),"&nbsp;") ;             
					chief_complaint			= checkForNull(rs.getString("contact_reason_desc"),"&nbsp;") ;             
					modified_by_id			= checkForNull(rs.getString("modified_by_id"),"&nbsp;") ;
			%>
			<tr>
			<td class=<%=classValue%> nowrap><%=trn_date%></td>
			<td class=<%=classValue%> nowrap ><%=assign_care_locn_code%></td>
			<td class=<%=classValue%> nowrap><%=service_desc%></td>
			<td class=<%=classValue%> nowrap><%=subservice_desc%></td>
			<td class=<%=classValue%> nowrap><%=bed_class_desc%></td>
			<td class=<%=classValue%> nowrap><%=bed_type_desc%></td>
			<td class=<%=classValue%> nowrap ><%=assign_bed_num%></td>
			<td class=<%=classValue%> nowrap ><%=assign_room_num%></td>
			<td class=<%=classValue%> nowrap ><%=specialty_desc%></td>
			<td class=<%=classValue%> nowrap ><%=Exp_Discharge_Date_Time%></td>
			<td class=<%=classValue%> nowrap ><%=admit_practitioner%></td>
			<td class=<%=classValue%> nowrap><%=attend_practitioner%></td>
			<td class=<%=classValue%> nowrap ><%=chief_complaint%></td>
			<td class=<%=classValue%> nowrap><%=visit_adm_type%></td>
			<td class=<%=classValue%> nowrap ><%=ambulatory_status%></td>
			<td class=<%=classValue%> nowrap><%=modified_by_id%></td>
		</tr>
		<%
				maxRecord++;
			}
			if(maxRecord == 0){
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
				return;
			}

		%>
	</table>
	</body>
</html>
<%
		}catch(Exception ex){
			out.println("==Exception==@=ChangedAdmisonDtls==>"+ex);
			ex.printStackTrace();
		}finally{
		ConnectionManager.returnConnection(con,request); 

		}
%>
<%!
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

