<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

				
	</head>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con			= null;
	PreparedStatement stmt1	= null;
	ResultSet rset1			= null;

	String facilityId = request.getParameter("facilityId")==null?"":request.getParameter("facilityId");
	if(facilityId.equals(""))
	facilityId		= (String)session.getValue("facility_id");

	String locale			= (String)session.getAttribute("LOCALE");

	String admission_date_time_display = "";
	String discharge_date_time_display = "";
	try
	{
		con						= ConnectionManager.getConnection(request);
		String patientId		= checkForNull(request.getParameter("patientId"));
		String filename			= checkForNull(request.getParameter("Filename"));
		String Patient_Class	= checkForNull(request.getParameter("Patient_Class"));
		String encounter_id		= checkForNull(request.getParameter("encounter_id"));
		String classValue		= "";
		String referral_id		= "";
		String referral_details	= "";
		String discharge_date_time	= "";
		String admission_date_time	= "";
		String sql = "";

		//sql = " Select facility_name, to_char(discharge_date_time,'dd/mm/yyyy hh24:mi') discharge_date_time, to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') visit_adm_date_time, visit_type_desc, practitioner_name, specialty_desc, encounter_id, referral_id, service_desc, episode_id from PR_ENCOUNTER_VW where encounter_id = ? and patient_id = ? and facility_id = ? ";

		
		//sql = "select sm_get_desc.sm_facility_param(facility_id,'"+locale+"','1') facility_name , to_char(discharge_date_time,'dd/mm/yyyy hh24:mi') discharge_date_time, to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') visit_adm_date_time, visit_type_desc, AM_GET_DESC.AM_PRACTITIONER(attend_practitioner_id,'"+locale+"','1') practitioner_name, AM_GET_DESC.AM_SPECIALITY(specialty_code,'"+locale+"','2')specialty_desc, encounter_id, referral_id, AM_GET_DESC.AM_SERVICE(service_code,'"+locale+"','2') service_desc, episode_id from PR_ENCOUNTER_VW where encounter_id = ? and patient_id = ? and facility_id = ?";


		sql = "select sm_get_desc.sm_facility_param(facility_id,'"+locale+"','1') facility_name ,    to_char(discharge_date_time,'dd/mm/yyyy hh24:mi') discharge_date_time, to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') visit_adm_date_time, DECODE(ASSIGN_CARE_LOCN_TYPE, 'N', IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID,ASSIGN_CARE_LOCN_CODE,'"+locale+"','2'), OP_GET_DESC.op_visit_type(facility_id,visit_adm_type,'"+locale+"','2')) visit_type_desc,AM_GET_DESC.AM_PRACTITIONER(attend_practitioner_id,'"+locale+"','1') practitioner_name, AM_GET_DESC.AM_SPECIALITY(specialty_code,'"+locale+"','2') specialty_desc,encounter_id, referral_id, AM_GET_DESC.AM_SERVICE(service_code,'"+locale+"','2') service_desc, episode_id from PR_ENCOUNTER_VW where  encounter_id = ? and patient_id = ? and facility_id = ?";	



		PreparedStatement stmt		= con.prepareStatement(sql);
		ResultSet rset		=null;	
		stmt.setString(1,encounter_id);
		stmt.setString(2,patientId);
		stmt.setString(3,facilityId);
		rset = stmt.executeQuery();

		while(rset.next())
		{
			String facility_name=rset.getString("FACILITY_NAME");
			if(facility_name == null || facility_name.equals("null")) facility_name="";
		
			discharge_date_time=rset.getString("DISCHARGE_DATE_TIME");
			if(discharge_date_time == null || discharge_date_time.equals("null"))
			{
				discharge_date_time="";
				discharge_date_time_display = "";
			}
			else
				discharge_date_time_display = DateUtils.convertDate(discharge_date_time,"DMYHM","en",locale);


			admission_date_time=rset.getString("VISIT_ADM_DATE_TIME");
			if(admission_date_time == null || admission_date_time.equals("null"))
			{
				admission_date_time="";
				admission_date_time_display = "";
			}
			else
				admission_date_time_display = DateUtils.convertDate(admission_date_time,"DMYHM","en",locale);

			String practitioner_name=rset.getString("PRACTITIONER_NAME");
			if( practitioner_name == null || practitioner_name.equals("null"))
				practitioner_name="";
			
			String specialty_short_desc=rset.getString("SPECIALTY_DESC");
			if(specialty_short_desc == null || specialty_short_desc.equals("null"))
				specialty_short_desc="";
		
			String encounter_id1= rset.getString("ENCOUNTER_ID");
			if( encounter_id1 == null) encounter_id1="";

			String admission_type_short_desc = rset.getString("VISIT_TYPE_DESC");
			if( admission_type_short_desc == null) admission_type_short_desc="";

			if(Patient_Class.equals("IP"))
			{
				referral_id = rset.getString("REFERRAL_ID");
				if (referral_id==null) referral_id = "";
			}
			String service_short_desc = "";
			String episode_id = "";
			if(!Patient_Class.equals("IP"))
			{
				service_short_desc = rset.getString("SERVICE_DESC");
				if (service_short_desc==null) service_short_desc = "";
				
				episode_id = rset.getString("EPISODE_ID");
				if (episode_id==null) episode_id = "";
			}
	%>
<body onKeyDown='lockKey()'>
<FORM METHOD=POST ACTION="">
<table cellspacing=0 cellpadding=4 align='center' width='100%' border='0'>
	<tr>
		<td  colspan='4' class='CAGROUPHEADING'><fmt:message key="Common.encounterdetails.label" bundle="${common_labels}"/></td>
	</tr>
	<tr>
		<td class='label' width="25%"  ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
		<td class='querydata' width="30%"  ><%=facility_name%></td>
		<td class='label'  width="25%"  >&nbsp;</td>
		<td class='label'  width="25%"  >&nbsp;</td>
	</tr>
	<tr>
		<td class='label' ><fmt:message key="Common.encounterdatetime.label" bundle="${common_labels}"/></td>
		<td class='querydata'><%=admission_date_time_display%></td>
		<td class='label'><fmt:message key="Common.dischargedatetime.label" bundle="${common_labels}"/></td>
		<td class='querydata' ><%=discharge_date_time_display%></td>
	</tr>
	<tr>
		<td class='label' ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td class='querydata' ><%=encounter_id1%></td>
		<td class='label' ><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/></td>
		<td class='querydata' ><%=admission_type_short_desc%></td>
	</tr>
	<tr>
		<td class='label' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
		<td class='querydata' ><%=specialty_short_desc%></td>
		<td class='label' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
		<td class='querydata' ><%=practitioner_name%></td>
	</tr>
	<tr>
		<td class='label' ><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
		<td class='querydata' ><%=service_short_desc%></td>
		<td class='label' ><fmt:message key="Common.episodeid.label" bundle="${common_labels}"/></td>
		<td class='querydata' ><%=episode_id%></td>
	</tr>
		<%	

			if(!referral_id.equals("")) 
			{
				sql = "select get_referral_detail_line( ? ,'FROM','"+locale+"') from dual";
				stmt = con.prepareStatement(sql);					
				stmt.setString(1,referral_id);
				rset = stmt.executeQuery();	
				while (rset.next())
				{
					referral_details = rset.getString(1);
					if(referral_details==null) referral_details = "";
				}

				%>
				<tr>
					<td  colspan='4' class='CAGROUPHEADING'><fmt:message key="Common.referraldetails.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td class='label' colspan='4'><%=referral_details%></td>
				</tr>
		<%	}	%>
				</table>
<%		} 
		if(stmt!=null) stmt.close();
		if(rset!=null) rset.close();

		if(Patient_Class.equals("IP") || Patient_Class.equals("DC"))
		{
			//String sql1 = "select to_char(A.trn_date_time,'dd/mm/yyyy hh24:mi') trans_date_time, A.trn_date_time,decode(A.trn_type,'D',B.short_desc,'L',B.short_desc, C.short_desc) to_nursing_unit_short_desc,decode(A.trn_type,'D',fr_room_no,to_room_no) to_room_no,decode(A.trn_type,'D',fr_bed_no,to_bed_no) to_bed_no,decode(A.trn_type,'D',D.practitioner_name,'L',D.practitioner_name,E.practitioner_name) to_practitioner_long_name,decode(A.trn_type,'D',F.short_desc,'L',F.short_desc,G.short_desc) to_specialty_short_desc,DECODE(A.trn_type,'A',CASE WHEN adt_trn_status='8' THEN 'Admission Cancelled' ELSE 'Admitted' END,'T','Transfered','D','Discharged','L','Leave','C','Leave Cancelled','R','Rejoined from Leave')  remarks, h.contact_reason Reason from IP_ADT_TRN A, IP_NURSING_UNIT B, IP_NURSING_UNIT C, AM_PRACTITIONER D, AM_PRACTITIONER E, AM_SPECIALITY F, AM_SPECIALITY G, AM_CONTACT_REASON H where A.facility_id= ? and A.encounter_id= ? and A.facility_id = B.facility_id (+) and A.fr_nursing_unit_code = B.nursing_unit_code (+) and A.facility_id = C.facility_id (+) and A.to_nursing_unit = C.nursing_unit_code (+) and A.fr_practitioner_id = D.PRACTITIONER_ID (+) and A.to_practitioner_id = E.PRACTITIONER_ID (+)  and A.fr_specialty_code = F.speciality_code (+) and A.to_specialty_code = G.speciality_code (+) and a.cancel_reason_code = h.contact_reason_code (+) order by A.trn_date_time ,A.srl_no";

			//String sql1 = "select to_char(A.trn_date_time,'dd/mm/yyyy hh24:mi') trans_date_time, A.trn_date_time,decode(A.trn_type,'D',IP_GET_DESC.IP_NURSING_UNIT(B.FACILITY_ID,B.NURSING_UNIT_CODE,'"+locale+"','2'),'L',IP_GET_DESC.IP_NURSING_UNIT(B.FACILITY_ID,B.NURSING_UNIT_CODE,'"+locale+"','2'), IP_GET_DESC.IP_NURSING_UNIT(C.FACILITY_ID,C.NURSING_UNIT_CODE,'"+locale+"','2')) to_nursing_unit_short_desc, decode(A.trn_type,'D',fr_room_no,to_room_no) to_room_no,decode(A.trn_type,'D',fr_bed_no,to_bed_no) to_bed_no, decode(A.trn_type,'D',AM_GET_DESC.AM_PRACTITIONER(D.PRACTITIONER_ID,'"+locale+"','1'),'L',AM_GET_DESC.AM_PRACTITIONER(D.PRACTITIONER_ID,'"+locale+"','1'),AM_GET_DESC.AM_PRACTITIONER(E.PRACTITIONER_ID,'"+locale+"','1')) to_practitioner_long_name, decode(A.trn_type,'D',AM_GET_DESC.AM_SPECIALITY(F.SPECIALITY_CODE,'"+locale+"','2'),'L',AM_GET_DESC.AM_SPECIALITY(F.SPECIALITY_CODE,'"+locale+"','2'),AM_GET_DESC.AM_SPECIALITY(G.SPECIALITY_CODE,'"+locale+"','2')) to_specialty_short_desc, DECODE(A.trn_type,'A',CASE WHEN adt_trn_status='8' THEN 'Admission Cancelled' ELSE 'Admitted' END,'T','Transfered','D','Discharged','L','Leave','C','Leave Cancelled','R','Rejoined from Leave')  remarks, AM_GET_DESC.AM_CONTACT_REASON(h.CONTACT_REASON_CODE,'"+locale+"','1') Reason from IP_ADT_TRN A, IP_NURSING_UNIT B, IP_NURSING_UNIT C, AM_PRACTITIONER D, AM_PRACTITIONER E, AM_SPECIALITY F, AM_SPECIALITY G, AM_CONTACT_REASON H where A.facility_id= ? and A.encounter_id= ? and A.facility_id = B.facility_id (+) and A.fr_nursing_unit_code = B.nursing_unit_code (+) and A.facility_id = C.facility_id (+) and A.to_nursing_unit = C.nursing_unit_code (+) and A.fr_practitioner_id = D.PRACTITIONER_ID (+) and A.to_practitioner_id = E.PRACTITIONER_ID (+)  and A.fr_specialty_code = F.speciality_code (+) and A.to_specialty_code = G.speciality_code (+) and a.cancel_reason_code = h.contact_reason_code (+) order by A.trn_date_time ,A.srl_no";


			String sql1 = "select to_char(A.trn_date_time,'dd/mm/yyyy hh24:mi') trans_date_time, A.trn_date_time,decode(A.trn_type,'D',IP_GET_DESC.IP_NURSING_UNIT(A.FACILITY_ID,A.fr_nursing_unit_code,'"+locale+"','2'),'L',IP_GET_DESC.IP_NURSING_UNIT(A.FACILITY_ID,A.fr_nursing_unit_code,'"+locale+"','2'), IP_GET_DESC.IP_NURSING_UNIT(A.FACILITY_ID,A.to_nursing_unit,'"+locale+"','2')) to_nursing_unit_short_desc, DECODE (A.trn_type, 'D', ip_get_desc.ip_bed_class (A.fr_bed_class_code, '"+locale+"', 2), ip_get_desc.ip_bed_class (A.to_bed_class_code, '"+locale+"', 2) ) bed_class_short_desc,  DECODE (A.trn_type, 'D', ip_get_desc.IP_BED_TYPE (A.FR_BED_TYPE_CODE, '"+locale+"', 2), ip_get_desc.IP_BED_TYPE (A.TO_BED_TYPE_CODE, '"+locale+"', 2) ) bed_type_short_desc, decode(A.trn_type,'D',fr_room_no,to_room_no) to_room_no,decode(A.trn_type,'D',fr_bed_no,to_bed_no) to_bed_no,			decode(A.trn_type,'D',AM_GET_DESC.AM_PRACTITIONER(A.fr_practitioner_id,'"+locale+"','1'),'L',				AM_GET_DESC.AM_PRACTITIONER(A.fr_practitioner_id,'"+locale+"','1'),					AM_GET_DESC.AM_PRACTITIONER(A.to_practitioner_id,'"+locale+"','1')) to_practitioner_long_name,						decode(A.trn_type,'D',AM_GET_DESC.AM_SPECIALITY(A.fr_specialty_code,'"+locale+"','2'),'L',							AM_GET_DESC.AM_SPECIALITY(A.fr_specialty_code,'"+locale+"','2'),		AM_GET_DESC.AM_SPECIALITY(A.to_specialty_code,'"+locale+"','2')) to_specialty_short_desc,			DECODE(A.trn_type,'A',CASE WHEN adt_trn_status='8' THEN 'Admission Cancelled' ELSE 'Admitted' END,'T','Transfered','D','Discharged','L','Leave','C','Leave Cancelled','R','Rejoined from Leave')  remarks,			AM_GET_DESC.AM_CONTACT_REASON(a.cancel_reason_code,'"+locale+"','1') Reason from IP_ADT_TRN A where A.facility_id= ? and A.encounter_id= ? order by A.trn_date_time ,A.srl_no";//Modified above query on 31st July 2018 against ML-MMOH-SCF-1058 


			
			stmt1 = con.prepareStatement(sql1);
			stmt1.setString(1,facilityId);
			stmt1.setString(2,encounter_id);
			rset1 = stmt1.executeQuery();

			%><!-- Dont display the following table if called from is other than IP -->

			<table cellspacing=0 cellpadding=0 align='center' width='100%' border='1'>
				<tr>
					<td  colspan='10' class='CAGROUPHEADING'><fmt:message key="Common.staydetails.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<th><fmt:message key="Common.date.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.roomno.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></th>
					 <!--below added by Mano on 19-April-2018 aganist ML-MMOH-CRF-0972-->
					<th><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
					<%
					if(!(filename.equals("CurrentEncounterMain")))
					{	%>
						<th><fmt:message key="Common.reason.label" bundle="${common_labels}"/></th>
				<%	}	%>
				</tr>
			<%	
				if(rset1 != null)
				{
					while(rset1.next()) 
					{ 
						//String trn_date_time=	 rset1.getString("trans_date_time")==null?"":rset1.getString("trans_date_time");
						String trn_date_time=rset1.getString("trans_date_time");
						String trn_date_time_display = "";
						if(trn_date_time == null || trn_date_time.equals("null"))
						{
							trn_date_time="";
							trn_date_time_display = "";
						}
						else
							trn_date_time_display = DateUtils.convertDate(trn_date_time,"DMYHM","en",locale);

						String to_nursing_unit_short_desc=rset1.getString("to_nursing_unit_short_desc")==null?"":rset1.getString("to_nursing_unit_short_desc");
						String to_room_no=rset1.getString("to_room_no")==null?"":rset1.getString("to_room_no");
						String to_bed_no=rset1.getString("to_bed_no")==null?"":rset1.getString("to_bed_no");
						String bed_type_short_desc=rset1.getString("bed_type_short_desc")==null?"":rset1.getString("bed_type_short_desc");
					
						String bed_class_short_desc=rset1.getString("bed_class_short_desc")==null?"":rset1.getString("bed_class_short_desc");
					
						String to_practitioner_long_name=rset1.getString("to_practitioner_long_name")==null?"":rset1.getString("to_practitioner_long_name");
						String to_specialty_short_desc=rset1.getString("to_specialty_short_desc")==null?"":rset1.getString("to_specialty_short_desc");
						String remarks =rset1.getString("remarks")==null?"":rset1.getString("remarks");
						String reason =rset1.getString("reason")==null?"":rset1.getString("reason");
						
						if(remarks.equalsIgnoreCase("Admission Cancelled"))
						{
							remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.CancelledAdmission.label","ip_labels");
						}
						else if(remarks.equalsIgnoreCase("Admitted"))
						{
							remarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Admitted.label","common_labels");
						}
						else if(remarks.equalsIgnoreCase("Transfered"))
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

						if (classValue.equals("") || classValue.equals("QRYODD"))  
							classValue = "QRYEVEN";
						else
							classValue = "QRYODD";
						%>
						<tr>
							<td class=<%=classValue%> nowrap><%=trn_date_time_display%></td>
							<td class=<%=classValue%>><%=to_nursing_unit_short_desc%></td>
							<td class=<%=classValue%>><%=to_room_no%></td>
							<td class=<%=classValue%>><%=to_bed_no%></td>
							<td class=<%=classValue%>><%=bed_type_short_desc%></td>
							<td class=<%=classValue%>><%=bed_class_short_desc%></td>
							<td class=<%=classValue%>><%=to_practitioner_long_name%></td>
							<td class=<%=classValue%>><%=to_specialty_short_desc%></td>
							<td class=<%=classValue%>><%=remarks%></td>
					<%	if(!(filename.equals("CurrentEncounterMain")))
						{	%>
							<td class=<%=classValue%> ><%=reason%></td>
					<%	}	%>
						</tr>
			<%		}
				}			
				
				if(rset1!=null)	rset1.close();
				if(stmt1!=null) stmt1.close();
				if(rset!=null)	rset.close();
				if(stmt!=null) stmt.close();
			%>
			</table>
	<%	}	%>
	</FORM>
	</body>
	</html>

<%	}catch(Exception e) 
	{
		//out.println("ERR ---------- "+e.toString()); 
		e.printStackTrace();
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

