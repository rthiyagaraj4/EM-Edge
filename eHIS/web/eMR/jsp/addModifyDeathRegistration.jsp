<!DOCTYPE html>
<!--
	Developed by 	:	Kumar
	Created on 	:	29/11/2001
	Module		:	mr
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>

<%@ page contentType="text/html;charset=UTF-8" import= "java.util.*,java.sql.*,java.text.*,com.ehis.util.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	String facilityId		= (String)session.getValue("facility_id");
	String locale           = (String)session.getAttribute("LOCALE"); 

%>
	<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eIP/js/dchk.js' language='javascript'></script> 
		<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
		<script src='../../eMR/js/CreatePatientFile.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<script>

//This function is to limit the no of character entry into text box/ text area.
function checkMaxRemarksLimit(obj,maxSize) 
{
	if(obj.value.length >= maxSize)
	{
		alert(getMessage("REMARKS_NOT_EXCEED_200_CH",'SM'));
		obj.focus();
	}
}
</script>
	<%
		request.setCharacterEncoding("UTF-8");
		Connection con	= null;
		try{
		con=ConnectionManager.getConnection(request);
		Statement stmt	= null;
		ResultSet rset		= null;		
		String curdate					= "";
		String finalize_yn				= "";
		String visit_adm_date_time		= "";
		String vis_adm_dat_tim_display	= "";
		String death_date_time			= "";
		String death_date_time_display	= "";
		String actual_death_date_time	= "";
		String admission_short_desc		= ""; 
		String practitioner_name		= "";
		String practitioner_id			= "";
		String patient_id				= "";
		String gender					= "";
		String death_by_pregnancy_yn	= "";
		String autopsy_yn				= "";
		String medical_legal_case_yn	= "";
		String remarks					= "";

		String specialty_code			= "";
		String disabledfield			= "";
		String deathChkProp				= "";
		String autopsyChkProp			= "";
		String medicalChkProp			= "";
		
		String sql = "";
		StringBuffer sqlBuff= new StringBuffer();
		String d = "";
		String eid = request.getParameter("encounter_id");
		String call_from = request.getParameter("call_from");
		if (eid==null) eid="0";
		if (call_from==null) call_from="";
		long encounterid = Long.parseLong(eid);
			/*sqlBuff.append(" select patient_id, practitioner_id, ");
			sqlBuff.append("to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') visit_adm_date_time, ");
			sqlBuff.append("admission_short_desc, to_char(death_date_time,'dd/mm/yyyy hh24:mi') Death_date_time,");
			sqlBuff.append("to_char(discharge_date_time,'dd/mm/yyyy hh24:mi') discharge_date_time, ");
			sqlBuff.append(" practitioner_name FROM  MR_DEATH_REGISTER_HDR_VW where facility_id = '"+facilityId+"' and encounter_id = "+encounterid+" ");
			*/

			/*sqlBuff.append(" select a.patient_id, a.practitioner_id, ");
			sqlBuff.append("to_char(a.visit_adm_date_time,'dd/mm/yyyy hh24:mi') visit_adm_date_time, ");
			sqlBuff.append("ip_get_desc.IP_ADMISSION_TYPE(b.ASSIGN_CARE_LOCN_TYPE,'"+locale+"','2')admission_short_desc,to_char(a.death_date_time,'dd/mm/yyyy hh24:mi') Death_date_time,");
			sqlBuff.append("to_char(a.discharge_date_time,'dd/mm/yyyy hh24:mi') discharge_date_time, ");
			sqlBuff.append("am_get_desc.AM_PRACTITIONER(a.practitioner_id,'"+locale+"','1') practitioner_name from  MR_DEATH_REGISTER_HDR_VW a, PR_ENCOUNTER b where a.facility_id = '"+facilityId+"' and a.facility_id = b.facility_id and a.encounter_id = '"+encounterid+"' and a.encounter_id = b.encounter_id ");
			*/


			sqlBuff.append("select patient_id, practitioner_id,");
			sqlBuff.append("to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') visit_adm_date_time, ");
			sqlBuff.append("DECODE(ASSIGN_CARE_LOCN_TYPE,'C',OP_GET_DESC.OP_VISIT_TYPE(FACILITY_ID,VISIT_ADM_TYPE,'"+locale+"','2'),'N',IP_GET_DESC.IP_ADMISSION_TYPE(VISIT_ADM_TYPE,'"+locale+"','2')) ADMISSION_SHORT_DESC,to_char(death_date_time,'dd/mm/yyyy hh24:mi') death_date_time,");
			sqlBuff.append("to_char(discharge_date_time,'dd/mm/yyyy hh24:mi') discharge_date_time,");
			sqlBuff.append("am_get_desc.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1') practitioner_name from  MR_DEATH_REGISTER_HDR_VW where facility_id = '"+facilityId+"' and encounter_id = '"+encounterid+"'");



			if(rset!=null) 	rset.close();
			if(stmt!=null) 	stmt.close();
			stmt = con.createStatement();
			rset	 =	 stmt.executeQuery(sqlBuff.toString());
			if(rset != null && rset.next())
			{
				visit_adm_date_time	= rset.getString("visit_adm_date_time") == null ? "" : rset.getString("visit_adm_date_time"); 
				vis_adm_dat_tim_display = DateUtils.convertDate(visit_adm_date_time,"DMYHM","en",locale);
				
				death_date_time	= rset.getString("death_date_time") == null ? "" : rset.getString("death_date_time"); 
				death_date_time_display = DateUtils.convertDate(death_date_time,"DMYHM","en",locale);
				
				actual_death_date_time	= rset.getString("discharge_date_time") == null ? "" : rset.getString("discharge_date_time"); 
				admission_short_desc = rset.getString("admission_short_desc") == null ? "" : rset.getString("admission_short_desc"); 
				patient_id = rset.getString("patient_id") == null ? "" : rset.getString("patient_id");
				practitioner_id	= rset.getString("practitioner_id") == null ? "" : rset.getString("practitioner_id");
				practitioner_name = rset.getString("practitioner_name") == null ?"" : rset.getString("practitioner_name");
			}
			if(rset!=null) 	rset.close();
			if(stmt!=null) 	stmt.close();
			stmt = con.createStatement();
			//Added on 19/05/2003
			sql = "select sex gender from mp_patient where PATIENT_ID = '"+patient_id+"'";
			rset	 =	 stmt.executeQuery(sql);
			if(rset != null && rset.next())
			{
				gender = rset.getString("gender");
			}
			if(gender.equals("M"))
			{
				disabledfield = "disabled";
			}
			if(rset!=null) 	rset.close();
			if(stmt!=null) 	stmt.close();
			stmt = con.createStatement();
			//End of addition on 19/03/2003
			sql = "select auth_practitioner_id, death_by_pregnancy_yn, autopsy_yn, medical_legal_case_yn, remarks, finalize_yn from mr_death_register_hdr where facility_id = '"+facilityId+"' and encounter_id = "+encounterid;

			rset	 =	 stmt.executeQuery(sql);

			
			if(rset != null && rset.next())
			{
				practitioner_id	= rset.getString("auth_practitioner_id") == null ? "" : 				
								  rset.getString("auth_practitioner_id"); 
				remarks = rset.getString("remarks") == null ? "" : 
						  rset.getString("remarks");
				death_by_pregnancy_yn = rset.getString("death_by_pregnancy_yn");
				medical_legal_case_yn = rset.getString("medical_legal_case_yn") == null ? "" : rset.getString("medical_legal_case_yn");
				finalize_yn	= rset.getString("finalize_yn") == null ? "" : rset.getString("finalize_yn");
				if (death_by_pregnancy_yn.equals("Y"))
					deathChkProp = "checked";	
				autopsy_yn = rset.getString("autopsy_yn");
				if (autopsy_yn.equals("Y")) 
					autopsyChkProp = "checked";
				if (medical_legal_case_yn.equals("Y")) 
					medicalChkProp = "checked";
			}

			if(rset!=null) 	rset.close();
			if(stmt!=null) 	stmt.close();			

			java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
			java.util.Date dt=new java.util.Date();
			d = dateFormat.format( dt ) ;
			d=d + " "+String.valueOf(dt.getHours())+":"+String.valueOf(dt.getMinutes());
			curdate = d;
			d=actual_death_date_time;
	%>

<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
	<form name='DeathRegister_form' id='DeathRegister_form'  method="post" target="Dummy_frame">
	<%	if(call_from.equals("MAINTAIN_DEATH_REGISTER"))
		{	%>
			<jsp:include page="../../eCommon/jsp/pline.jsp" ><jsp:param name="flush" value="true" />
				<jsp:param name='Facility_Id' value='<%=facilityId%>'/>
				<jsp:param name='EncounterId' value='<%=eid%>'/>
			</jsp:include>
	<%	}	%>
		<table cellpadding=3 cellspacing=0 width="100%">
			<tr><td colspan=4 class="COLUMNHEADER"><fmt:message key="eMR.DeathRegistrationDetails.label" bundle="${mr_labels}"/></td></tr>	
			<tr>
				<td width="25%" class=label ><fmt:message key="Common.AdmissionDateTime.label" bundle="${common_labels}"/></td>
				<td width="25%" class='querydata'><%=vis_adm_dat_tim_display%><input type="hidden"  name="admission_date_time" id="admission_date_time" value="<%=visit_adm_date_time%>"></td>
				<td width="25%" class=label ><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/></td>
				<td width="25%" class='querydata'><%=admission_short_desc%><input type="hidden"  name="admission_short_desc" id="admission_short_desc" value="<%=admission_short_desc%>"></td>
			</tr>

			<tr>
				<td class=label ><fmt:message key="Common.deathdatetime.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type="text"  name="death_date_time" id="death_date_time" value="<%=death_date_time_display%>" size=16 maxlength=16 readonly></td>
				<td class=label ><fmt:message key="Common.AuthorizingPractitioner.label" bundle="${common_labels}"/></td>
				<%
					try
					{
						Statement stmt1=con.createStatement();
						String sql1="Select specialty_code from PR_ENCOUNTER where facility_id = '"+facilityId+"' and encounter_id= "+encounterid+" ";
						ResultSet rs=stmt1.executeQuery(sql1);
						if (rs.next())
						{
							specialty_code =rs.getString(1);
						}
						if(rs!=null) rs.close();
						if(stmt1!=null) stmt1.close();
					}catch(Exception e){/* out.println(e); */e.printStackTrace();}
				%>
				<td class='fields'><input type='text' name=practid_desc maxLength=30 size=30  value="<%=practitioner_name%>" onblur='getPractIDblur(document.forms[0].practid_desc, document.forms[0].practid);'><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button' onClick='getPractID(document.forms[0].practid_desc, document.forms[0].practid);'></td>
			</tr>
			<tr>
				<td class=label ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
				<td  class='fields' colspan=3><textarea rows=2  cols=70 size=200 name="remarks" onBlur="checkMaxRemarksLimit(this,200);return makeValidString(this);"><%=remarks%></textarea></td>
			</tr>
			<tr><td class=label colspan=4>&nbsp;</td></tr>
		</table>

		<input type="hidden" name="facilityId" id="facilityId" value="<%=facilityId%>">
		<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
		<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounterid%>">
        <input type="hidden" name="specialty_code" id="specialty_code" value="<%=specialty_code%>">
		<input type="hidden" name="practid" id="practid" value="<%=practitioner_id%>">
		<input type="hidden" name="gender" id="gender" value="<%=gender%>">
		<input type="hidden" name="sysdatetime" id="sysdatetime" value="<%=curdate%>"> 
		<input type="hidden" name="finalize_yn" id="finalize_yn" value="<%=finalize_yn%>">
		<input type="hidden" name="actualdeathdatetime" id="actualdeathdatetime" value="<%=actual_death_date_time%>"> 
		<input type="hidden" name="AdmDatetime" id="AdmDatetime" value="<%=visit_adm_date_time%>"> 
		</form>
	</body>
</html>
<%
}
catch(Exception e) {
//out.println(e);
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

