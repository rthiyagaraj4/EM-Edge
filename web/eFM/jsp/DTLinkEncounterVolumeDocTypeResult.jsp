<!DOCTYPE html>
<%@ page import="java.sql.Connection, java.sql.ResultSet, java.sql.PreparedStatement,  webbeans.eCommon.ConnectionManager, java.util.StringTokenizer" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%

Connection connection			=	null;
PreparedStatement preStatement	=	null;
PreparedStatement pStatement	=	null;
PreparedStatement prStatement	=	null;
ResultSet	resultSet			=	null;
ResultSet	rSet				=	null;
ResultSet	resSet				=	null;

String facilityID 				=	"";
String patient_id 				=	"";
String patient_id_value			=	"";
String file_no	 				=	"";
String file_type 				=	"";
String action_code 				=	"";
String from		 				=	"";
String to		 				=	"";
String file_type_appl_yn		=	"N";
String valid_values				=	"";
String patient_class_code		=	"";
String maintain_doc_or_file		=	"";
String doc_folder_id			=	"";
String appl_to_op				=	"N";
String appl_to_dc				=	"N";
String appl_to_ip				=	"N";
String appl_to_em				=	"N";
String class_value				=	"QRYEVEN";
String patient_period_specific	=	"";
String from_period				=	"";
String to_period				=	"";

int record_count			=	0;
int start					=	0 ;
int end						=	0 ;
int count					=	1 ;
int increment				=	15 ;

StringBuffer sqlBuffer		=	new StringBuffer();
StringBuffer sqlQuery		=	new StringBuffer();
StringBuffer whereBuffer	=	new StringBuffer();

try
{
	connection				=	ConnectionManager.getConnection(request);	
	
	facilityID 				=	checkForNull((String) session.getValue("facility_id"));
	patient_id 				=	checkForNull(request.getParameter("patient_id"));
	file_no 				=	checkForNull(request.getParameter("file_no"));
	file_type 				=	checkForNull(request.getParameter("file_type"));
	action_code				=	checkForNull(request.getParameter("action_code"));
	file_type_appl_yn		=	checkForNull(request.getParameter("file_type_appl_yn"));
	from					=	checkForNull(request.getParameter("from"));
	to						=	checkForNull(request.getParameter("to"));	
	valid_values			=	checkForNull(request.getParameter("valid_values"));
	maintain_doc_or_file	=	checkForNull(request.getParameter("maintain_doc_or_file"));
	patient_period_specific	=	checkForNull(request.getParameter("patient_period_specific"));
	doc_folder_id			=	checkForNull(request.getParameter("doc_folder_id"));
	from_period				=	checkForNull(request.getParameter("from_period"));
	to_period				=	checkForNull(request.getParameter("to_period"));
	
	if (maintain_doc_or_file.equals("F"))
		increment	=15;
	else if (maintain_doc_or_file.equals("D") && patient_period_specific.equals("D"))
		increment	=	17;
	else if (maintain_doc_or_file.equals("D") && patient_period_specific.equals("P"))
		increment	=	16;

	if (from.equals(""))
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if (to.equals(""))
		end = increment ;
	else
		end = Integer.parseInt( to ) ;

	if (maintain_doc_or_file.equals("F"))
	{
		if (!file_type.equals(""))
		{
			if (preStatement != null)	preStatement = null;
			if (resultSet != null)	resultSet = null;

			preStatement	=	connection.prepareStatement("SELECT appl_to_op, appl_to_ip, appl_to_em, appl_to_dc FROM mr_file_type where facility_id = ? AND file_type_code = ? ");
			
			preStatement.setString(1, facilityID);
			preStatement.setString(2, file_type);

			resultSet		=	preStatement.executeQuery();
			
			if ((resultSet != null) && (resultSet.next()))
			{
				appl_to_op	=	checkForNull(resultSet.getString("appl_to_op"));	
				appl_to_ip	=	checkForNull(resultSet.getString("appl_to_ip"));	
				appl_to_em	=	checkForNull(resultSet.getString("appl_to_em"));	
				appl_to_dc	=	checkForNull(resultSet.getString("appl_to_dc"));	
			}

		if ((appl_to_ip.equals("Y"))&&(appl_to_op.equals("Y"))&&(appl_to_em.equals("Y"))&&(appl_to_dc.equals("Y")))
			patient_class_code	="";
		else{
			patient_class_code="('";
		if (appl_to_ip.equals("Y"))
			patient_class_code	=	patient_class_code+"IP";	
		if (appl_to_op.equals("Y")&& patient_class_code!="('")
			patient_class_code	=	patient_class_code+"','OP";	
		else if (appl_to_op.equals("Y"))
			patient_class_code	=	patient_class_code+"OP";	
		if (appl_to_em.equals("Y")&& patient_class_code!="('")
			patient_class_code	=	patient_class_code+"','EM";	
		else if (appl_to_em.equals("Y"))
			patient_class_code	=	patient_class_code+"EM";	
		if (appl_to_dc.equals("Y")&& patient_class_code!="('")
			patient_class_code	=	patient_class_code+"','DC";	
		else if (appl_to_dc.equals("Y"))
			patient_class_code	=	patient_class_code+"DC";	
		patient_class_code	=	patient_class_code+"')";
		}	
		}

		if ((!file_type.equals("")) && (file_no.equals("")))
		{
			if(resultSet!=null)	resultSet.close();
		if(preStatement!=null)  preStatement.close();

			preStatement	=	connection.prepareStatement("SELECT file_no FROM mr_pat_file_index where facility_id = ? AND file_type_code = ? AND patient_id = ?");
			
			preStatement.setString(1, facilityID);
			preStatement.setString(2, file_type);
			preStatement.setString(3, patient_id);

			resultSet		=	preStatement.executeQuery();
			if ((resultSet != null) && (resultSet.next()))
				file_no		=	checkForNull(resultSet.getString("file_no"));	
		}


		if (action_code.equals("L"))
		{
			if ((sqlBuffer != null) && (sqlBuffer.length() > 0))
				sqlBuffer.delete(0, sqlBuffer.length());

			//sqlBuffer.append("SELECT   b.short_desc encounter_type, e.encounter_id, TO_CHAR (e.encounter_date_time, 'dd/mm/rrrr hh24:mi' ) encounter_date_time, c.practitioner_name, d.short_desc specialty, Decode(a.PATIENT_CLASS, 'IP', (select short_desc from ip_nursing_unit where facility_id = a.facility_id and nursing_unit_code = a.assign_care_locn_code), (select short_desc from Op_Clinic where  facility_id = a.facility_id and clinic_code = a.assign_care_locn_code)) location, a.assign_care_locn_code, a.patient_class patient_class_code, e.volume_no  FROM pr_encounter a, am_patient_class b, am_practitioner c, am_speciality d, fm_encounter_volume_link e ");
			sqlBuffer.append("SELECT   b.Short_desc Encounter_Type,");
			sqlBuffer.append("          e.Encounter_Id,");
			sqlBuffer.append("          To_char(e.Encounter_Date_Time,'dd/mm/rrrr hh24:mi') encounter_date_time,");
			sqlBuffer.append("          c.Practitioner_Name,");
			sqlBuffer.append("          d.Short_desc Specialty,");
			sqlBuffer.append("          DECODE(a.Patient_Class,'IP',(SELECT long_desc");
			sqlBuffer.append("                                       FROM   ");
			sqlBuffer.append("                                        ip_nurSing_Unit_lang_vw");
			sqlBuffer.append("                                       WHERE  Facility_Id = a.Facility_Id");
			sqlBuffer.append("                                              AND nurSing_Unit_Code = a.Assign_Care_Locn_Code");
			sqlBuffer.append("                                              AND Language_Id = '"+localeName+"'),");
			sqlBuffer.append("                                 (SELECT long_desc");
			sqlBuffer.append("                                  FROM   ");
			sqlBuffer.append("                                   op_Clinic_lang_vw");
			sqlBuffer.append("                                  WHERE  Facility_Id = a.Facility_Id");
			sqlBuffer.append("                                         AND Clinic_Code = a.Assign_Care_Locn_Code");
			sqlBuffer.append("                                         AND Language_Id = '"+localeName+"')) Location,");
			sqlBuffer.append("          a.Assign_Care_Locn_Code,");
			sqlBuffer.append("          a.Patient_Class Patient_Class_Code,");
			sqlBuffer.append("          e.Volume_No");
			sqlBuffer.append(" FROM     ");
			sqlBuffer.append("   pr_Encounter a,");
			sqlBuffer.append("   Am_Patient_Class_lang_vw b,");
			sqlBuffer.append("   Am_Practitioner_lang_vw c,");
			sqlBuffer.append("   Am_SpecialIty_lang_vw d,");
			sqlBuffer.append("   fm_Encounter_Volume_Link e");

			if ((whereBuffer != null) && (whereBuffer.length() > 0))
				whereBuffer.delete(0, whereBuffer.length());
			    
			whereBuffer.append(" WHERE    a.Encounter_Id = e.Encounter_Id (+) ");
			whereBuffer.append("          AND a.Facility_Id = e.Facility_Id");
			whereBuffer.append("          AND a.Patient_Class = b.Patient_Class");
			whereBuffer.append("          AND a.Attend_Practitioner_Id = c.Practitioner_Id (+) ");
			whereBuffer.append("          AND a.Specialty_Code = d.SpecialIty_Code");
			whereBuffer.append("          AND b.language_id='"+localeName+"'");
			whereBuffer.append("          AND b.language_id = c.language_id");
			whereBuffer.append("          AND c.language_id = d.language_id");
			whereBuffer.append("          AND a.Facility_Id = '"+facilityID+"'");
			whereBuffer.append("          AND a.Patient_Id = '"+patient_id+"' ");
			
			if (!patient_class_code.equals(""))
			{
				whereBuffer.append(" AND a.patient_class in ");
				whereBuffer.append(patient_class_code);
			}

			
			sqlBuffer.append(whereBuffer.toString());
			sqlBuffer.append(" ORDER BY to_date(encounter_date_time, 'dd/mm/rrrr hh24:mi'), encounter_type, a.encounter_id");

			if ((sqlQuery != null) && (sqlQuery.length() > 0))
				sqlQuery.delete(0, sqlQuery.length());
			sqlQuery.append("SELECT count(*) record_count FROM pr_encounter a, Am_Patient_Class_lang_vw b , Am_Practitioner_lang_vw c, Am_SpecialIty_lang_vw d, fm_encounter_volume_link e ");
			sqlQuery.append(whereBuffer.toString());
		}
		else if (action_code.equals("D"))
		{
			if ((sqlBuffer != null) && (sqlBuffer.length() > 0))
				sqlBuffer.delete(0, sqlBuffer.length());

			//sqlBuffer.append("SELECT b.short_desc encounter_type, a.encounter_id, to_char(a.encounter_date_time, 'dd/mm/rrrr hh24:mi') encounter_date_time, d.practitioner_name, e.short_desc specialty, c.assign_care_locn_code, Decode(c.PATIENT_CLASS, 'IP', (select short_desc from ip_nursing_unit where facility_id = c.facility_id and nursing_unit_code = c.assign_care_locn_code), (select short_desc from Op_Clinic where 		 facility_id = c.facility_id and clinic_code = c.assign_care_locn_code)) location,c.patient_class patient_class_code , a.volume_no , a.doc_type_code, f.doc_type_name, f.doc_no FROM fm_encounter_doc_type_link a, am_patient_class b, pr_encounter c, am_practitioner d, am_speciality e, fm_doc_type f ");
			sqlBuffer.append("SELECT   b.Short_desc Encounter_Type,");
			sqlBuffer.append("          a.Encounter_Id,");
			sqlBuffer.append("          To_char(a.Encounter_Date_Time,'dd/mm/rrrr hh24:mi') Encounter_Date_Time,");
			sqlBuffer.append("          d.Practitioner_Name,");
			sqlBuffer.append("          e.Short_desc Specialty,");
			sqlBuffer.append("          c.Assign_Care_Locn_Code,");
			sqlBuffer.append("          DECODE(c.Patient_Class,'IP',(SELECT long_desc");
			sqlBuffer.append("                                       FROM   ");
			sqlBuffer.append("                                        ip_nurSing_Unit_lang_vw");
			sqlBuffer.append("                                       WHERE  Facility_Id = c.Facility_Id");
			sqlBuffer.append("                                              AND nurSing_Unit_Code = c.Assign_Care_Locn_Code");
			sqlBuffer.append("                                              AND Language_Id = '"+localeName+"'),");
			sqlBuffer.append("                                 (SELECT long_desc");
			sqlBuffer.append("                                  FROM   ");
			sqlBuffer.append("                                   op_Clinic_lang_vw");
			sqlBuffer.append("                                  WHERE  Facility_Id = c.Facility_Id");
			sqlBuffer.append("                                         AND Clinic_Code = c.Assign_Care_Locn_Code");
			sqlBuffer.append("                                         AND Language_Id = '+localeName+')) Location,");
			sqlBuffer.append("          c.Patient_Class Patient_Class_Code,");
			sqlBuffer.append("          a.Volume_No,");
			sqlBuffer.append("          a.Doc_Type_Code,");
			sqlBuffer.append("          f.Doc_Type_Name,");
			sqlBuffer.append("          f.Doc_No");
			sqlBuffer.append(" FROM     ");
			sqlBuffer.append("   fm_Encounter_Doc_Type_Link a,");
			sqlBuffer.append("   Am_Patient_Class_lang_vw b,");
			sqlBuffer.append("   pr_Encounter c,");
			sqlBuffer.append("   Am_Practitioner_lang_vw d,");
			sqlBuffer.append("   Am_SpecialIty_lang_vw e,");
			sqlBuffer.append("   fm_Doc_Type_lang_vw f");

			if ((whereBuffer != null) && (whereBuffer.length() > 0))
				whereBuffer.delete(0, whereBuffer.length());
			whereBuffer.append(" WHERE    a.Patient_Class = b.Patient_Class");
			whereBuffer.append("          AND a.Patient_Id = c.Patient_Id");
			whereBuffer.append("          AND a.Encounter_Id = c.Encounter_Id");
			whereBuffer.append("          AND a.Facility_Id = c.Facility_Id");
			whereBuffer.append("          AND c.Attend_Practitioner_Id = d.Practitioner_Id (+) ");
			whereBuffer.append("          AND c.Specialty_Code = e.SpecialIty_Code");
			whereBuffer.append("          AND a.Doc_Type_Code = f.Doc_Type_Code");
			whereBuffer.append("		   AND a.facility_id = '");
			whereBuffer.append(facilityID);
			whereBuffer.append("' AND a.patient_id = '");
			whereBuffer.append(patient_id);
			whereBuffer.append("' ");

			if (!file_no.equals(""))
			{
				whereBuffer.append(" AND a.file_no = '");
				whereBuffer.append(file_no);
				whereBuffer.append("' ");
			}
			
			if (!file_type.equals(""))
			{
				whereBuffer.append(" AND a.file_type_code = '");
				whereBuffer.append(file_type);
				whereBuffer.append("' ");
			}
			whereBuffer.append("          AND b.Language_Id = '"+localeName+"'");
			whereBuffer.append("          AND b.Language_Id = d.Language_Id");
			whereBuffer.append("          AND d.Language_Id = e.Language_Id");
			whereBuffer.append("          AND e.Language_Id = f.Language_Id");
			sqlBuffer.append(whereBuffer.toString());
			sqlBuffer.append(" ORDER BY a.encounter_date_time, a.encounter_id");

			if ((sqlQuery != null) && (sqlQuery.length() > 0))
				sqlQuery.delete(0, sqlQuery.length());
			sqlQuery.append("SELECT count(*) record_count FROM fm_encounter_doc_type_link a, Am_Patient_Class_lang_vw b  , pr_encounter c, Am_Practitioner_lang_vw d, Am_SpecialIty_lang_vw e , fm_doc_type f ");
			sqlQuery.append(whereBuffer.toString());
		}
	}
	else if (maintain_doc_or_file.equals("D"))
	{
		if ((sqlBuffer != null) && (sqlBuffer.length() > 0))
			sqlBuffer.delete(0, sqlBuffer.length());

		sqlBuffer.append("SELECT b.short_desc encounter_type, a.encounter_id, to_char(a.visit_adm_date_time, 'dd/mm/rrrr hh24:mi') encounter_date_time, c.practitioner_name, d.short_desc specialty, a.assign_care_locn_code, Decode(a.PATIENT_CLASS, 'IP', (select long_desc from ip_nursing_unit where facility_id = a.facility_id and nursing_unit_code = a.assign_care_locn_code), (select long_desc from Op_Clinic where facility_id = a.facility_id and clinic_code = a.assign_care_locn_code)) location, a.patient_class patient_class_code, a.patient_id, decode('"+localeName+"', 'en', e.patient_name, nvl(e.patient_name_loc_lang, e.patient_name)) patient_name ");
		sqlBuffer.append(" FROM pr_encounter a, Am_Patient_Class_lang_vw b , Am_Practitioner_lang_vw c, Am_SpecialIty_lang_vw d, mp_patient e ");

		if ((whereBuffer != null) && (whereBuffer.length() > 0))
			whereBuffer.delete(0, whereBuffer.length());
		whereBuffer.append("WHERE e.patient_id = a.patient_id AND a.patient_class = b.patient_class AND a.attend_practitioner_id = c.practitioner_id (+) AND a.specialty_code = d.speciality_code AND a.facility_id = '");
		whereBuffer.append(facilityID);
		whereBuffer.append("' ");
		if (!patient_id.equals(""))
		{
			whereBuffer.append(" AND a.patient_id = '");
			whereBuffer.append(patient_id);
			whereBuffer.append("' ");
		}
		if (patient_period_specific.equals("D"))
		{
			whereBuffer.append(" AND TRUNC (visit_adm_date_time) BETWEEN TO_DATE ('");
			whereBuffer.append(from_period);
			whereBuffer.append("', 'dd/mm/rrrr' ) AND TO_DATE ('");
			whereBuffer.append(to_period);
			whereBuffer.append("', 'dd/mm/rrrr' )");
		}

		if (!patient_class_code.equals(""))
		{
			whereBuffer.append(" AND a.patient_class in ");
			whereBuffer.append(patient_class_code);
		}		
		sqlBuffer.append(whereBuffer.toString());
		sqlBuffer.append(" ORDER BY to_date(encounter_date_time, 'dd/mm/rrrr hh24:mi'), encounter_type, a.encounter_id");

		if ((sqlQuery != null) && (sqlQuery.length() > 0))
			sqlQuery.delete(0, sqlQuery.length());
		sqlQuery.append("SELECT count(*) record_count FROM pr_encounter a, Am_Patient_Class_lang_vw b , Am_Practitioner_lang_vw c, Am_SpecialIty_lang_vw d, mp_patient e ");
		sqlQuery.append(whereBuffer.toString());
	}
	

%>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMLinkEncounterVolume.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	if(resultSet!=null)	resultSet.close();
		if(preStatement!=null)  preStatement.close();
	//preStatement	=	connection.prepareStatement(sqlQuery.toString());
	//resultSet		=	preStatement.executeQuery();
	//if ((resultSet != null) && (resultSet.next()))
	//	record_count	=	resultSet.getInt("record_count");
	if(resultSet!=null)	resultSet.close();
		if(preStatement!=null)  preStatement.close();
	/* if (record_count==0)
	{*/
	%>
		<script>
		/*	alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
			parent.criteria_frame.document.forms[0].search.disabled = false;
			parent.criteria_frame.document.location.reload();
			parent.tab_frame.document.location.href="../../eCommon/html/blank.html";
			parent.result_frame.document.location.href="../../eCommon/html/blank.html";
			parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp";*/
		</script>
	<%
/*	}
	else
	{*/
%>
<body onMouseDown = "CodeArrest();" onLoad="FocusFirstElement();" onKeyDown = 'lockKey();'> 
<form name='DTLinkEncounterResultForm' id='DTLinkEncounterResultForm' action='DTLinkEncounterVolumeDocTypeResult.jsp' method='POST'>
<table width="100%" cellpadding="0" cellspacing="0" border="0">
<%
if (maintain_doc_or_file.equals("D")&& !patient_id.equals(""))
{
%>
	<tr><td colspan="6">
	<jsp:include page="../../eCommon/jsp/pline.jsp" ><jsp:param name="flush" value="true" />
		<jsp:param name="Patient_ID" value="<%=patient_id%>" />
	</jsp:include>
	</td></tr>
	<%
	}
%>	
</table>
<%
	//if ((!(start <= 1)) || (!( (start+increment) > record_count )))
//	{
		%>
		<table align='right'><tr>
		<%
		if ( !(start <= 1) )
		{
		%>
		<td align ='right' id='prev'>	<a href='javascript:submitPrevNext(<%=start-increment%>, <%=end-increment%>)'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a></td>
		<%
		}
				
		//if ( !( (start+increment) > record_count ) )
	//	{
		%>
			<td align ='right' id='nextid' style='visibility:hidden'><a href='javascript:submitPrevNext(<%=(start+increment)%>, <%=end+increment%>)'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a></td>
		<%
	//	}
		%>
		</tr></table></p>
		<br><br>				
		<%
	//}
%>
<table width="100%" cellpadding="0" cellspacing="0" border="1">
<%
	if (action_code.equals("L"))
	{
%>
<tr>
<%
	if (maintain_doc_or_file.equals("D") && patient_id.equals(""))
	{
%>	
	<td width="15%" class='columnheader'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	<td width="15%" class='columnheader'><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
<%
	}
%>
	<td width="15%" class='columnheader'><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></td>
	<td width="15%" class='columnheader'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
	<td width="15%" class='columnheader'><fmt:message key="Common.encounterdatetime.label" bundle="${common_labels}"/></td>
	<td width="20%" class='columnheader'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
	<td width="15%" class='columnheader'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
	<td width="15%" class='columnheader'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
	<%
	if (!maintain_doc_or_file.equals("D"))
	{
	%>
		<td width="5%" class='columnheader'><fmt:message key="eFM.VolumeNo.label" bundle="${fm_labels}"/></td>
	<%
	}
	%>
</tr>
<%
	}
	else if (action_code.equals("D"))
	{
%>
<tr>
	<td width="15%" class='columnheader'><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></td>
	<td width="15%" class='columnheader'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
	<td width="15%" class='columnheader'><fmt:message key="Common.encounterdatetime.label" bundle="${common_labels}"/></td>
	<td width="5%" class='columnheader'><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></td>
	<td width="5%" class='columnheader'><fmt:message key="Common.documentno.label" bundle="${common_labels}"/></td>
	<td width="18%" class='columnheader'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
	<td width="15%" class='columnheader'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
	<td width="12%" class='columnheader'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
	<td width="5%" class='columnheader'><fmt:message key="eFM.VolumeNo.label" bundle="${fm_labels}"/></td>
	<td width="5%" nowrap class='columnheader'><fmt:message key="eFM.De-Link.label" bundle="${fm_labels}"/></td>
</tr>
<%	
	}

	if (preStatement != null)  preStatement = null;
	if (resultSet != null)  resultSet = null;

	String encounter_type_value			=	"&nbsp;";
	String encounter_id_value			=	"&nbsp;";
	String encounter_date_time_value	=	"&nbsp;";
	String practitioner					=	"&nbsp;";
	String specialty					=	"&nbsp;";
	String location						=	"&nbsp;";	
//	String assign_care_locn_code		=	"";
	String patient_class				=	"";
	String check_attribute				=	"";
	
	StringBuffer deLinkBuffer			=	new StringBuffer();
	
	preStatement	=	connection.prepareStatement(sqlBuffer.toString());
	resultSet		=	preStatement.executeQuery();
	int local_count=0;
	if (resultSet != null)
	{
		session.removeAttribute("documentArrList");
		if ( start != 1 )
			for( int j=1; j<start; count++,j++ )
				resultSet.next() ;	
		
		StringTokenizer stringToken		= null;
		
		while (resultSet.next() && count<=end)
		{
			encounter_type_value		= checkForNull(resultSet.getString("encounter_type"));
			encounter_id_value			= checkForNull(resultSet.getString("encounter_id"));
			encounter_date_time_value	= checkForNull(resultSet.getString("encounter_date_time"));
			if(!encounter_date_time_value.equals(""))
			{
				encounter_date_time_value=DateUtils.convertDate(encounter_date_time_value,"DMYHM","en",localeName);
			}


			practitioner				= checkForNull(resultSet.getString("practitioner_name"), "&nbsp;");
			specialty					= checkForNull(resultSet.getString("specialty"));			
	//		assign_care_locn_code		= checkForNull(resultSet.getString("assign_care_locn_code"));
			patient_class				= checkForNull(resultSet.getString("patient_class_code"));
			location				= checkForNull(resultSet.getString("location"));			
			

			if(class_value.equals("QRYEVEN"))
				class_value = "QRYODD";
			else
				class_value = "QRYEVEN";
			stringToken	=	new StringTokenizer(valid_values, ",");
		%>
			<tr>
		<%
			if (maintain_doc_or_file.equals("D")&& patient_id.equals(""))
			{
				patient_id_value	=	checkForNull(resultSet.getString("patient_id"));
		%>
			<td class="<%=class_value%>" nowrap><%=patient_id_value%><input type='Hidden' name='patient_id<%=count%>' id='patient_id<%=count%>' value="<%=patient_id_value%>"></td>
			<td class="<%=class_value%>" nowrap><%=checkForNull(resultSet.getString("patient_name"))%></td>
		<%
			}
		%>
			<td class="<%=class_value%>" nowrap><%=encounter_type_value%></td>
		<%
			if ((action_code.equals("L")) && (maintain_doc_or_file.equals("D")))
			{
		%>
			<td class="<%=class_value%>" nowrap><a href="javascript:getDocuments(<%=encounter_id_value%>, '',<%=count%>)"><%=encounter_id_value%></a></td>
		<%
			}
			else if ((action_code.equals("L")) && (maintain_doc_or_file.equals("F")))
			{
		%>
			<td class="<%=class_value%>" nowrap><a href="javascript:getDocuments(<%=encounter_id_value%>, <%=resultSet.getInt("volume_no")%>,<%=count%>)"><%=encounter_id_value%></a></td>
		<%
			}
			else if ((action_code.equals("D")) && (maintain_doc_or_file.equals("F")))
			{
				check_attribute	=	"";
				if (deLinkBuffer.length()>0)
					deLinkBuffer.delete(0, deLinkBuffer.length());
				deLinkBuffer.append(checkForNull(resultSet.getString("encounter_id")));
				deLinkBuffer.append("$$");
				deLinkBuffer.append(checkForNull(resultSet.getString("doc_type_code")));
				while(stringToken.hasMoreTokens())
				{
					if ((deLinkBuffer.toString()).equals(stringToken.nextToken()))
					{
						check_attribute	=	"Checked";
						break;
					}
				}
		%>
			<td class="<%=class_value%>" nowrap><%=encounter_id_value%></td>
		<%
			}
		%>
			<td class="<%=class_value%>" nowrap><%=encounter_date_time_value%><input type="hidden" name="encounter_date<%=count%>" id="encounter_date<%=count%>" value="<%=encounter_date_time_value%>"></td>
		<%
			if ((action_code.equals("D")) && (maintain_doc_or_file.equals("F")))
			{
		%>
			<td class="<%=class_value%>" nowrap><%=resultSet.getString("doc_type_name")%></td>
			<td class="<%=class_value%>" nowrap><%=resultSet.getString("doc_no")%></td>
		<%
			}
		%>
			<td class="<%=class_value%>" nowrap><%=practitioner%></td>
			<td class="<%=class_value%>" nowrap><%=specialty%></td>
			<td class="<%=class_value%>" nowrap><%=location%></td>
			<%
			if (maintain_doc_or_file.equals("F"))
			{
			%>
			<td class="<%=class_value%>" align="CENTER"><%=resultSet.getInt("volume_no")%></td>
		<%
			}
			if (action_code.equals("D"))
			{
		%>
			<td class="<%=class_value%>" nowrap align="CENTER"><input type="checkbox" name="delink<%=count%>" id="delink<%=count%>" onClick="getRelatedRecords(this)" value="<%=deLinkBuffer.toString()%>" <%=check_attribute%>></td>
		<%
			}
		%>
			</tr>
		<%
			count++;
			local_count++;
		}
	}
if(local_count<increment){
	%>
<SCRIPT>
	document.getElementById("nextid").style.visibility='hidden';
</SCRIPT>
<%} else {%>
<SCRIPT>
	document.getElementById("nextid").style.visibility='visible';
</SCRIPT>
	<%}
	
if(local_count==0){	%>
<script>
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
			parent.criteria_frame.document.forms[0].search.disabled = false;
			/*parent.criteria_frame.document.location.reload();
			parent.tab_frame.document.location.href="../../eCommon/html/blank.html";
			parent.result_frame.document.location.href="../../eCommon/html/blank.html";
			parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp";*/
		</script>
<%}%>

</table>
	<input type="Hidden" name="from" id="from" value="<%=from%>">
	<input type="Hidden" name="to" id="to" value="<%=to%>">
	<input type="Hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
	<input type="Hidden" name="file_no" id="file_no" value="<%=file_no%>">
	<input type="Hidden" name="file_type" id="file_type" value="<%=file_type%>">
	<input type="Hidden" name="patient_class" id="patient_class" value="<%=patient_class%>">
	<input type="Hidden" name="action_code" id="action_code" value="<%=action_code%>">
	<input type="Hidden" name="record_count" id="record_count" value="<%=record_count%>">
	<input type="Hidden" name="file_type_appl_yn" id="file_type_appl_yn" value="<%=file_type_appl_yn%>">
	<input type="Hidden" name="valid_values" id="valid_values" value="<%=valid_values%>">
	<input type="Hidden" name="from_period" id="from_period" value="<%=from_period%>">
	<input type="Hidden" name="to_period" id="to_period" value="<%=to_period%>">
	<script>
	var patient_id = "<%=patient_id%>";
	if("<%=action_code%>"=="L")
	parent.tab_frame.document.location.href="../../eFM/jsp/DTLinkEncounterVolumeDocTabs.jsp";
	else if("<%=action_code%>"=="D")
	parent.tab_frame.document.location.href="../../eCommon/jsp/pline.jsp?Patient_ID="+patient_id;
	
	parent.criteria_frame.document.forms[0].search.disabled = false;
	if("<%=maintain_doc_or_file%>"!="D")
	{
		parent.criteria_frame.document.forms[0].action_code.disabled = true;
		parent.criteria_frame.document.forms[0].patient_id.disabled = true;
		parent.criteria_frame.document.forms[0].pat_search.disabled = true;
	}
	else parent.criteria_frame.document.forms[0].doc_folder_id.disabled = true;
	parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp";
	</script>
<%
	//}
	if(resultSet!=null)	resultSet.close();
	if(rSet!=null)	rSet.close();
	if(resSet!=null)	resSet.close();
	if(preStatement!=null) preStatement.close();
	if(pStatement!=null) pStatement.close();
	if(prStatement!=null) prStatement.close();
}
catch(Exception e)
{
	out.println("<script>alert(\"Exception : "+e.toString()+"\");</script>");
	out.println("Exception : " + e.toString());
	e.printStackTrace();
}
finally
{	

	ConnectionManager.returnConnection(connection,request);
}
%>
	<input type="Hidden" name="encounter_date_time" id="encounter_date_time" value=""> 
	<input type="Hidden" name="encounter_id" id="encounter_id" value=""> 
	<input type="Hidden" name="volume_no" id="volume_no" value=""> 
	<input type="Hidden" name="doc_folder_id" id="doc_folder_id" value="<%=doc_folder_id%>"> 
	<input type="Hidden" name="maintain_doc_or_file" id="maintain_doc_or_file" value="<%=maintain_doc_or_file%>"> 
	<input type="Hidden" name="patient_period_specific" id="patient_period_specific" value="<%=patient_period_specific%>"> 
</form>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

