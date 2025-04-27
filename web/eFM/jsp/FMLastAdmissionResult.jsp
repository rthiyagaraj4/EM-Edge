<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle			= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	Connection con				= null;
	PreparedStatement stmt1	= null;
	ResultSet rset1				= null;
	PreparedStatement pstmt	= null;
	ResultSet rs					= null;
	String facilityId				= (String)session.getValue("facility_id");
	try
	{
				
		con						= ConnectionManager.getConnection(request);
		String patientId		= checkForNull(request.getParameter("patientId"));
		String filename			= checkForNull(request.getParameter("Filename"));
		String Patient_Class	= checkForNull(request.getParameter("Patient_Class"));
		String encounter_id		= checkForNull(request.getParameter("encounter_id"));
		String fileNo		= checkForNull(request.getParameter("fileNo"));
		//String facility_id		= checkForNull(request.getParameter("facility_id"));
		String classValue		= "";
		String referral_id		= "";
		String referral_details	= "";
		String discharge_date_time	= "";
		String admission_date_time	= "";

		
		String sql	= "";
		String sql2 = "";
		if (!Patient_Class.equals("IP"))
		{
		sql = "SELECT  a.Facility_Id  , a.Episode_Id , a.Encounter_Id   ,sm_Get_desc.SM_FACILITY_PARAM(a.FACILITY_ID,'"+localeName+"',1) Facility_Name ,TO_CHAR(A.Visit_Adm_Date_Time,'dd/mm/yyyy hh24:mi') Visit_Adm_Date_Time ,IP_GET_DESC.IP_ADMISSION_TYPE(A.VISIT_ADM_TYPE,'"+localeName+"','2') Admission_Type_Short_desc , A.Attend_Practitioner_Id   ,AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,'"+localeName+"','1') Practitioner_Name , A.Specialty_Code ,AM_GET_DESC.AM_SPECIALITY(A.specialty_code,'"+localeName+"','2') Specialty_Short_desc    , a.Patient_Type  , NULL Patient_Type_Short_desc , a.Service_Code  , AM_GET_DESC.AM_SERVICE(A.service_code,'"+localeName+"','2') Service_Short_desc  ,TO_CHAR(a.Discharge_Date_Time,'dd/mm/yyyy hh24:mi') Discharge_Date_Time FROM  pr_Encounter a WHERE a.Facility_id = '"+facilityId+"' AND a.Encounter_Id = "+encounter_id+"   AND a.Patient_Id= '"+patientId+"' ";
		}
		else 
		{
			sql = "SELECT   Facility_Id   ,sm_Get_desc.SM_FACILITY_PARAM(FACILITY_ID,'"+localeName+"',1) Facility_Name  , Encounter_Id , TO_CHAR(Admission_Date_Time,'dd/mm/yyyy hh24:mi') Admission_Date_Time  , TO_CHAR(Discharge_Date_Time,'dd/mm/yyyy hh24:mi') Discharge_Date_Time   ,AM_GET_DESC.AM_PRACTITIONER(ATTEND_PRACTITIONER_ID,'"+localeName+"','1') Practitioner_Name , AM_GET_DESC.AM_SPECIALITY(specialty_code,'"+localeName+"','2') Specialty_Short_desc , IP_GET_DESC.IP_ADMISSION_TYPE(ADMISSION_TYPE,'"+localeName+"','2') Admission_Type_Short_desc , NULL Patient_Type_Short_desc  , Referral_Id FROM IP_PATIENT_LAST_ENCOUNTER  WHERE Facility_id = '"+facilityId+"'  AND Encounter_Id = ? AND Patient_Id = ?";
		}

		PreparedStatement stmt		= con.prepareStatement(sql);
		ResultSet rset		=null;	
		stmt.setString(1,encounter_id);
		stmt.setString(2,patientId);
		
		if(rset!=null)	rset.close();
		rset = stmt.executeQuery();

		while(rset.next())
		{
			String facility_name=rset.getString("facility_name");
			if(facility_name == null || facility_name.equals("null")) facility_name="&nbsp;";
		
			discharge_date_time=rset.getString("discharge_date_time");
			if(discharge_date_time == null || discharge_date_time.equals("null")) discharge_date_time="&nbsp;";

			if(Patient_Class.equals("IP"))
				admission_date_time=rset.getString("admission_date_time");
			else
				admission_date_time=rset.getString("visit_adm_date_time");

			if(admission_date_time == null || admission_date_time.equals("null")) admission_date_time="&nbsp;";

			String practitioner_name=rset.getString("practitioner_name");
			if( practitioner_name == null || practitioner_name.equals("null")) practitioner_name="&nbsp;";
			
			String specialty_short_desc=rset.getString("specialty_short_desc");
			if(specialty_short_desc == null || specialty_short_desc.equals("null")) specialty_short_desc="&nbsp;";
		
			String encounter_id1= rset.getString("encounter_id");
			if( encounter_id1 == null) encounter_id1="&nbsp;";

			String admission_type_short_desc=rset.getString("admission_type_short_desc");
			if( admission_type_short_desc == null) admission_type_short_desc="&nbsp;";

			String patient_type_short_desc=rset.getString("patient_type_short_desc");
			if( patient_type_short_desc == null) patient_type_short_desc="&nbsp;";
			if(Patient_Class.equals("IP"))
			{
				referral_id = rset.getString("referral_id");
				if (referral_id==null) referral_id = "";
			}
			String service_short_desc = "";
			String episode_id = "";
			if(!Patient_Class.equals("IP"))
			{
				service_short_desc = rset.getString("service_short_desc");
				if (service_short_desc==null) service_short_desc = "&nbsp;";
				
				episode_id = rset.getString("episode_id");
				if (episode_id==null) episode_id = "&nbsp;";
			}
	%>

<body onKeyDown='lockKey()'>
<FORM METHOD=POST ACTION="">
<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
	<tr>
		<td  colspan='6' class='CAGROUPHEADING'><fmt:message key="Common.encounterdetails.label" bundle="${common_labels}"/></td>
	</tr>
	<tr>
		<td class='label' width="12%"  ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
		<td class='querydata' width="35%"  ><%=facility_name%></td>
		<td class='label' width="12%"  ><fmt:message key="common.encounterdatetime.label" bundle="${ommon_labels}"/></td>
		<td class='querydata' width="15%" ><%=admission_date_time%></td>
		<td class='label' width="12%"  ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td class='querydata' width="15%" ><%=encounter_id1%></td>
	</tr>
	<tr><td colspan=6>&nbsp;</td></tr>
	<tr>
		<td class='label'  ><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/></td>
		<td class='querydata'  ><%=admission_type_short_desc%></td>
		<td class='label'  ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
		<td class='querydata'  ><%=specialty_short_desc%></td>
		<td class='label'  ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
		<td class='querydata'  ><%=practitioner_name%></td>
	</tr>
	<tr><td colspan=6>&nbsp;</td></tr>
	<tr>
		<td class='label'  ><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
		<td class='querydata'  ><%=service_short_desc%></td>
		<td class='label'  ><fmt:message key="Common.episodeid.label" bundle="${common_labels}"/></td>
		<td class='querydata'  ><%=episode_id%></td>
		<td class='label'  ><fmt:message key="Common.dischargedatetime.label" bundle="${common_labels}"/></td>
		<td class='querydata'  ><%=discharge_date_time%></td>
	</tr>
	<%	if(!Patient_Class.equals("IP"))
		{	%>

	<%	}	%>
			<%	if (!referral_id.equals("")) 
				{
					sql = "select get_referral_detail_line( ? ,'FROM') from dual";
					stmt = con.prepareStatement(sql);					
					stmt.setString(1,referral_id);
					rset = stmt.executeQuery();	
					while (rset.next())
					{
						referral_details = rset.getString(1);
						if(referral_details==null) referral_details = "";
					}
					if(rset!=null)	rset.close();

					%>
					<tr>
						<td  colspan='6' class='CAGROUPHEADING'><fmt:message key="Common.referraldetails.label" bundle="${common_labels}"/></td>
					</tr>
					<tr>
						<td class='label' colspan='6'><%=referral_details%></td>
					</tr>
			<%	}	%>

		   </table>
		<% } 
		if(stmt!=null) stmt.close();
		if(rset!=null) rset.close();

		sql2="select encounter_id,file_no,doc_details,doc_date from FM_ENCOUNTER_DOC_TYPE_LINK where facility_id=? and file_no=?";
		

		pstmt = con.prepareStatement(sql2);	
		pstmt.setString(1,facilityId);
		pstmt.setString(2,fileNo);
		rs = pstmt.executeQuery();

		if(rs != null)
			{
				while(rs.next()) 
				{
					String doc_details=	 rs.getString("doc_details")==null?"":rs.getString("doc_details");
					String doc_date=	 rs.getString("doc_date")==null?"":rs.getString("doc_date");
%>
		<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
		<tr>
		<td  colspan='6' class='CAGROUPHEADING'><fmt:message key="Common.documentdetails.label" bundle="${common_labels}"/></td>
		</tr>
		<tr>
		<td class='label' width="15%" ><fmt:message key="Common.documentdetails.label" bundle="${common_labels}"/></td>
		<td class='querydata'  ><%=doc_details%></td>
		</tr>
		<tr><td colspan=2>&nbsp;</td></tr>
		<tr>
		<td class='label' width="15%" ><fmt:message key="Common.DocumentDate.label" bundle="${common_labels}"/></td>
		<td class='querydata'  ><%=doc_date%></td>
		</tr>
		</table>
						<%
				}
			}

		if(Patient_Class.equals("IP"))
		{	
		String sql1 = "SELECT TO_CHAR(trn_Date_Time,'dd/mm/yyyy hh24:mi') Trans_Date_Time  , trn_Date_Time  , Decode(trn_Type,'D',IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID, fr_nursing_unit_code,'"+localeName+"','1'), 'L',IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID, fr_nursing_unit_code,'"+localeName+"','2'), IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID, to_nursing_unit,'"+localeName+"','2')) To_nurSing_Unit_Short_desc   , Decode(trn_Type,'D',fr_Room_No, To_Room_No) To_Room_No			   , Decode(trn_Type,'D',fr_Bed_No, To_Bed_No) To_Bed_No  ,Decode(trn_Type,'D',AM_GET_DESC.AM_PRACTITIONER(fr_practitioner_id,'"+localeName+"','1'), 'L',AM_GET_DESC.AM_PRACTITIONER(fr_practitioner_id,'"+localeName+"','1'), AM_GET_DESC.AM_PRACTITIONER(to_practitioner_id,'"+localeName+"','1')) To_Practitioner_Long_Name  ,Decode(trn_Type,'D',AM_GET_DESC.AM_SPECIALITY(fr_specialty_code,'"+localeName+"','2'), 'L',AM_GET_DESC.AM_SPECIALITY(fr_specialty_code,'"+localeName+"','2'), AM_GET_DESC.AM_SPECIALITY(to_specialty_code,'"+localeName+"','2')) To_Specialty_Short_desc		     , trn_Type remarks  , Adt_trn_Status  ,AM_GET_DESC.AM_CONTACT_REASON(cancel_reason_code,'"+localeName+"','2') Reason FROM		         IP_ADT_TRN WHERE facility_id= '"+facilityId+"'   AND encounter_id= "+encounter_id+" ORDER BY     trn_date_time  , srl_no";

		stmt1 = con.prepareStatement(sql1);	
		stmt1.setString(1,facilityId);
		stmt1.setString(2,encounter_id);
		rset1 = stmt1.executeQuery();
		%><!-- Dont display the following table if called from is other than IP -->
		
		<table cellspacing=0 cellpadding=0 align='center' width='100%' border='1'>
			<tr>
				<td colspan='8' class='CAGROUPHEADING'><fmt:message key="Common.staydetails.label" bundle="${common_labels}"/></td>
			</tr>
				
			<tr>
				<td class='COLUMNHEADER'><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER'><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER'><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
				<%
				if(!(filename.equals("CurrentEncounterMain")))
				{	%>
					<td class='COLUMNHEADER'><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
			<%	}	%>
			</tr>
		<%	
			if(rset1 != null)
			{
				while(rset1.next()) 
				{ 
					String trn_date_time=	 rset1.getString("trans_date_time")==null?"":rset1.getString("trans_date_time");

					String to_nursing_unit_short_desc=rset1.getString("to_nursing_unit_short_desc")==null?"&nbsp;":rset1.getString("to_nursing_unit_short_desc");
					String to_room_no=rset1.getString("to_room_no")==null?"&nbsp;":rset1.getString("to_room_no");
					String to_bed_no=rset1.getString("to_bed_no")==null?"&nbsp;":rset1.getString("to_bed_no");
					String to_practitioner_long_name=rset1.getString("to_practitioner_long_name")==null?"&nbsp;":rset1.getString("to_practitioner_long_name");
					String to_specialty_short_desc=rset1.getString("to_specialty_short_desc")==null?"&nbsp;":rset1.getString("to_specialty_short_desc");

					String Adt_trn_Status = checkForNull(rset1.getString("Adt_trn_Status"));
					String remarks = checkForNull(rset1.getString("remarks"));

					if(!remarks.equals(""))
					{
						switch(remarks.charAt(0))
						{
							case 'A' : if(Adt_trn_Status.equals("8"))
										{
											remarks = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelledAdmission.label","common_labels");
										}
										else
										{
											remarks = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Admitted.label","common_labels");
										}
										break;
							case 'T' : remarks = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Transferred.label","common_labels"); break;

							case 'D' : remarks = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.discharged.label","common_labels"); break;

							case 'L' : remarks = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Leave.label","common_labels"); break;

							case 'C' : remarks =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Leave.label","common_labels") + " " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels"); break;

							case 'R' : remarks = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RejoinedFromLeave.label","common_labels"); break;

							default : remarks = "&nbsp;";
					
						}
					}
					String reason =rset1.getString("reason")==null?"&nbsp;":rset1.getString("reason");
					
					if (classValue.equals("") || classValue.equals("QRYODD"))  
						classValue = "QRYEVEN";
					else
						classValue = "QRYODD";
					%>
					<tr>
					<td class=<%=classValue%> nowrap>	<%=trn_date_time%> </td>
					<td class=<%=classValue%>>	<%= to_nursing_unit_short_desc%> </td>
					<td class=<%=classValue%>>	 <%= to_room_no%> </td>
					<td class=<%=classValue%>>	<%= to_bed_no%> </td>
					<td class=<%=classValue%>>	 <%=to_practitioner_long_name%> </td>
					<td class=<%=classValue%>>	 <%=to_specialty_short_desc%></td>
					<td class=<%=classValue%>>	<%= remarks%> </td>
					<%
					if(!(filename.equals("CurrentEncounterMain")))
					{		%>
						<td class=<%=classValue%>>	<%= reason%> </td>
				<%	}
					%>
					</tr>
		<%		}
			}			
			if(pstmt!=null) pstmt.close();
			if(rset1!=null)	rset1.close();
			if(stmt1!=null) stmt1.close();
			if(rset!=null)	rset.close();
			if(stmt!=null) stmt.close();
		%>
		</table>
	<% } %>
	</FORM>
	</body>
	</html>

<%	}catch(Exception e) 
	{
		out.println("ERR ---------- "+e.toString()); 
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

