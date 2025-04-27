<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<title><fmt:message key="eIP.ConfirmSwapBeds.label" bundle="${ip_labels}"/></title>
<%
		Connection con 			= null;
		Statement  stmt			= null;
		PreparedStatement  pstmt= null;
		ResultSet  rs 			= null;
		request.setCharacterEncoding("UTF-8");
		String locale			        = (String)session.getAttribute("LOCALE");
		String Dat						= "";
		String ID						= "";
		String patient_id1				= "";
		String patient_name1			= "";
		String gender1					= "";
		String hid_gender1				= "";
		String date_of_birth1			= "";
		String admission_date_time1		= "";
		String nursing_unit_short_desc1	= "";
		String bed_class_short_desc1	= "";
		String nursing_unit_type1		= "";
		String room_no1					= "";
		String bed_no1					= "";
		String specialty_short_desc1	= "";
		String practitioner_short_name1	= "";
		String practitioner_id1			= "";
		String specialty_code1			= "";
		String nursing_unit_code1		= "";
		String service_code1			= "";
		String bed_type_code1			= "";
		String bed_class_code1			= "";
		String team_id1					= "";
		String patient_id2				= "";
		String patient_name2			= "";
		String gender2					= "";
		String hid_gender2				= "";
		String date_of_birth2			= "";
		String nursing_unit_short_desc2	= "";
		String admission_date_time2		= "";
		String nursing_unit_type2		= "";
		String bed_class_short_desc2	= "";
		String room_no2					= "";
		String bed_no2					= "";
		String specialty_short_desc2	= "";
		String practitioner_short_name2	= "";
		String practitioner_id2			= "";
		String specialty_code2			= "";
		String nursing_unit_code2		= "";
		String service_code2			= "";
		String bed_type_code2			= "";
		String bed_class_code2			= "";
		String team_id2					= "";
		String bed_type_short_desc1		="";
		String bed_type_short_desc2		="";
		String ip_param_bedchange_yn	="";
		String bl_interfaced_yn			= "";
		String transfer_wo_delink_yn			= "";//Added for the CRF HSA-CRF-0035
		String patient_class1			= "";
		String patient_class2			= "";
		String admission_date_time1_converted = "";
		String admission_date_time2_converted = "";
		String year1					= "";
		String year2					= "";
		int mother_status1				= 0;
		int mother_status2				= 0;
	
	try
	{
		con						= ConnectionManager.getConnection(request);
		String encounter_id1	= checkForNull(request.getParameter("encounter_id1"));
		String encounter_id2	= checkForNull(request.getParameter("encounter_id2"));
		String facilityId		= (String)session.getValue("facility_id");
		String bl_operational	= (String)session.getValue("bl_operational");
		StringBuffer operSql1	= new StringBuffer();
		try
		{
			// This query is used for populating first enoucnter id details
			operSql1.append("select to_char(a.admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time, b.sex gender, am_get_desc.am_speciality (a.specialty_code, '"+locale+"', 2) specialty_short_desc, am_get_desc.am_practitioner (a.attend_practitioner_id, '"+locale+"', 1 ) practitioner_short_name, a.encounter_id, a.patient_id, decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, ip_get_desc.ip_nursing_unit (a.facility_id, a.nursing_unit_code, '"+locale+"', 2 ) nursing_unit_short_desc, ip_get_desc.ip_bed_class (a.bed_class_code, '"+locale+"', 2 ) bed_class_short_desc, ip_get_desc.ip_bed_type (a.bed_type_code, '"+locale+"', 2) bed_type_short_desc, a.attend_practitioner_id practitioner_id, a.bed_num bed_no, a.room_num room_no, calculate_age(to_char(b.date_of_birth,'dd/mm/rrrr'),1)  date_of_birth, a.specialty_code, a.nursing_unit_code, a.service_code, a.bed_type_code, a.bed_class_code, 'N' locn_type, a.patient_class ");
			/*Wednesday, June 02, 2010 , modified for PE*/
			operSql1.append(",calculate_age(TO_CHAR(b.date_of_birth,'dd/mm/yyyy'),1)year ");
			operSql1.append(",( select count(*) m_status from ip_nursing_unit_bed ");
			operSql1.append(" where ");
			operSql1.append("  main_bed_no = a.bed_num and occupying_patient_id is not null and facility_id = a.facility_id ");
			operSql1.append(" and nursing_unit_code =a.nursing_unit_code) m_status");
			/**/
			operSql1.append(" from ip_open_encounter a, mp_patient b where  a.facility_id='"+facilityId+"' and a.encounter_id="+encounter_id1+" and a.patient_id = b.patient_id");
			
			// This query is used for populating second enoucnter id details
			StringBuffer operSql2 = new StringBuffer();
			operSql2.append("select to_char(a.admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time, b.sex gender, am_get_desc.am_speciality (a.specialty_code, '"+locale+"', 2) specialty_short_desc, am_get_desc.am_practitioner (a.attend_practitioner_id, '"+locale+"', 1 ) practitioner_short_name, a.encounter_id, a.patient_id, decode('"+locale+"','en',b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, ip_get_desc.ip_nursing_unit (a.facility_id, a.nursing_unit_code, '"+locale+"', 2 ) nursing_unit_short_desc, ip_get_desc.ip_bed_class (a.bed_class_code, '"+locale+"', 2 ) bed_class_short_desc, ip_get_desc.ip_bed_type (a.bed_type_code, '"+locale+"', 2) bed_type_short_desc, a.attend_practitioner_id practitioner_id, a.bed_num bed_no, a.room_num room_no, calculate_age(to_char(b.date_of_birth,'dd/mm/rrrr'),1)  date_of_birth, a.specialty_code, a.nursing_unit_code, a.service_code, a.bed_type_code, a.bed_class_code, 'N' locn_type, a.patient_class");
			/*Wednesday, June 02, 2010 , modified for PE*/
			operSql2.append(",calculate_age(TO_CHAR(b.date_of_birth,'dd/mm/yyyy'),1)year ");
			operSql2.append(",( select count(*) m_status from ip_nursing_unit_bed ");
			operSql2.append(" where ");
			operSql2.append("  main_bed_no = a.bed_num and occupying_patient_id is not null and facility_id = a.facility_id ");
			operSql2.append(" and nursing_unit_code = a.nursing_unit_code) m_status ");
			/**/
			operSql2.append(" from ip_open_encounter a, mp_patient b where  a.facility_id='"+facilityId+"' and a.encounter_id="+encounter_id2+" and a.patient_id = b.patient_id");
			
			stmt = con.createStatement();
			rs	 = stmt.executeQuery(operSql1.toString());
			
		if(rs!=null)
		{
			if(rs.next())
			{
				patient_id1				= checkForNull(rs.getString("patient_id"));
				patient_name1			= checkForNull(rs.getString("patient_name"));
				gender1					= checkForNull(rs.getString("gender"));
				hid_gender1				= checkForNull(rs.getString("gender"));
				date_of_birth1			= checkForNull(rs.getString("date_of_birth"));

				admission_date_time1	= checkForNull(rs.getString("admission_date_time"));
				if(!(admission_date_time1.equals("") || admission_date_time1 == null))
							admission_date_time1_converted = DateUtils.convertDate(admission_date_time1,"DMYHM","en",locale); 			
				nursing_unit_short_desc1= checkForNull(rs.getString("nursing_unit_short_desc"));
				bed_class_short_desc1	= checkForNull(rs.getString("bed_class_short_desc"));
				room_no1				= checkForNull(rs.getString("room_no"));
				bed_no1					= checkForNull(rs.getString("bed_no"));
				specialty_short_desc1	= checkForNull(rs.getString("specialty_short_desc"));
				practitioner_short_name1= checkForNull(rs.getString("practitioner_short_name"));
				practitioner_id1		= checkForNull(rs.getString("practitioner_id"));
				specialty_code1			= checkForNull(rs.getString("specialty_code"));
				nursing_unit_code1		= checkForNull(rs.getString("NURSING_UNIT_CODE"));
				service_code1			= checkForNull(rs.getString("SERVICE_CODE"));
				bed_type_code1			= checkForNull(rs.getString("bed_type_code"));
				bed_type_short_desc1	= checkForNull(rs.getString("bed_type_short_desc"));
				bed_class_code1			= checkForNull(rs.getString("bed_class_code"));
				nursing_unit_type1		= checkForNull(rs.getString("locn_type"));
				patient_class1			= checkForNull(rs.getString("PATIENT_CLASS"));
				mother_status1			= rs.getInt("m_status");
				year1					= checkForNull(rs.getString("year"));
			}
			if(gender1.equals("M"))
				gender1="Male";
			else if (gender1.equals("F"))
				gender1="Female";
			else if (gender1.equals("U"))
				gender1="Unknown";

		if(rs != null) rs.close(); if(stmt != null) stmt.close();
		}
		
		stmt = con.createStatement();
		rs = stmt.executeQuery(operSql2.toString());
	
		if(rs!=null)
		{
			if(rs.next())
			{
				patient_id2				= checkForNull(rs.getString("patient_id"));
				patient_name2			= checkForNull(rs.getString("patient_name"));
				gender2					= checkForNull(rs.getString("gender"));
				hid_gender2				= checkForNull(rs.getString("gender"));
				date_of_birth2			= checkForNull(rs.getString("date_of_birth"));
				admission_date_time2	= checkForNull(rs.getString("admission_date_time"));
				if(!(admission_date_time2.equals("") || admission_date_time2 == null))
							admission_date_time2_converted = DateUtils.convertDate(admission_date_time2,"DMYHM","en",locale); 			
				bed_class_short_desc2	= checkForNull(rs.getString("bed_class_short_desc"));
				room_no2				= checkForNull(rs.getString("room_no"));
				bed_no2					= checkForNull(rs.getString("bed_no"));
				specialty_short_desc2	= checkForNull(rs.getString("specialty_short_desc"));
				nursing_unit_short_desc2= checkForNull(rs.getString("nursing_unit_short_desc"));
				practitioner_short_name2= checkForNull(rs.getString("practitioner_short_name"));
				practitioner_id2		= checkForNull(rs.getString("practitioner_id"));
				specialty_code2			= checkForNull(rs.getString("specialty_code"));
				nursing_unit_code2		= checkForNull(rs.getString("NURSING_UNIT_CODE"));
				service_code2			= checkForNull(rs.getString("SERVICE_CODE"));
				bed_type_code2			= checkForNull(rs.getString("bed_type_code"));
				bed_type_short_desc2	= checkForNull(rs.getString("bed_type_short_desc"));
				bed_class_code2			= checkForNull(rs.getString("bed_class_code"));
				nursing_unit_type2		= checkForNull(rs.getString("locn_type"));
				patient_class2			= checkForNull(rs.getString("PATIENT_CLASS"));
				mother_status2			= rs.getInt("m_status");
				year2					= checkForNull(rs.getString("year"));
			}
			if(gender2.equals("M"))
				gender2="Male";
			else if (gender2.equals("F"))
				gender2="Female";
			else if (gender2.equals("U"))
				gender2="Unknown";

			if(rs != null) rs.close(); if(stmt != null) stmt.close();
		}
		/****Coding Start Here for Bed Class reqest validation. By kishore on 11/19/2004****/
		//get BedClass Change parameter value from IP_PARAMETER
		stmt = con.createStatement();
		rs	 = stmt.executeQuery("select change_bed_class_yn,nvl(bl_interfaced_yn,'N') bl_interfaced_yn,transfer_wo_delink_yn from IP_PARAM where facility_id='"+facilityId+"'");
		while(rs != null && rs.next())
		{
			ip_param_bedchange_yn=checkForNull(rs.getString("change_bed_class_yn"));
			bl_interfaced_yn	 =checkForNull(rs.getString("bl_interfaced_yn"));
			transfer_wo_delink_yn	 =checkForNull(rs.getString("transfer_wo_delink_yn"),"N");//Added for the CRF - HSA-CRF-0035
		}
		
		if(rs != null) rs.close(); if(stmt != null) stmt.close();
		/****Coding Ended Here for Bed Class reqest validation. By kishore on 11/19/2004****/  
		/*15876 10/30/2009*/
		/*Wednesday, June 02, 2010 , commented for PE & merged in main query
		if(operSql1.length()>0) operSql1.delete(0,operSql1.length());
		operSql1.append(" select count(*) m_status from ip_nursing_unit_bed ");
		operSql1.append(" where ");
		operSql1.append("  main_bed_no = '"+bed_no1+"' and occupying_patient_id is not null and facility_id = '"+facilityId+"' ");
		operSql1.append(" and nursing_unit_code = '"+nursing_unit_code1+"' ");

		if(operSql2.length()>0) operSql2.delete(0,operSql2.length());
		operSql2.append(" select count(*) m_status from ip_nursing_unit_bed ");
		operSql2.append(" where ");
		operSql2.append("  main_bed_no = '"+bed_no2+"' and occupying_patient_id is not null and facility_id = '"+facilityId+"' ");
		operSql2.append(" and nursing_unit_code = '"+nursing_unit_code2+"' ");
		
		
		stmt = con.createStatement();
		rs = stmt.executeQuery(operSql1.toString());
	
		if(rs!=null)
		{
			if(rs.next())
			{
				mother_status1 = rs.getInt("m_status");
			}
			if(rs != null) rs.close(); if(stmt != null) stmt.close();
		}
		

		stmt = con.createStatement();
		rs = stmt.executeQuery(operSql2.toString());
	
		if(rs!=null)
		{
			if(rs.next())
			{
				mother_status2 = rs.getInt("m_status");
			}
			if(rs != null) rs.close(); if(stmt != null) stmt.close();
		}
		*/
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
%>	

<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>

	<script src='../../eIP/js/IPQueryCommon.js' language='javascript'></script>
	<script src='../../eIP/js/SwapPatientBeds.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 
 </head>
<body onLoad= 'FocusFirstElement();checkbabyLink();' onSelect="codeArrestThruSelect()" onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<form name='SwapPatientBedDetails_Form' id='SwapPatientBedDetails_Form' >
	
<table cellspacing=0 cellpadding='4%' width='100%' border='0'>
<BR>
<tr class='label'><td colspan=8>&nbsp;</td></tr>
<tr> 
	<td  class='label' >&nbsp;</td>
<td class='columnheader' ><fmt:message key="Common.patient.label" bundle="${common_labels}"/>I</td>
	<td  class='label' >|</td>
<td  class='columnheader'  ><fmt:message key="Common.patient.label" bundle="${common_labels}"/>II</td>
</tr>
<tr>
	<td  width='20%' class='label' nowrap ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	<td  width='27%' class='querydata'><b><%=patient_id1%></b></td>
	<td width='2%' class='label'>&nbsp;</td>
	
	<td  width='27%' class='querydata'><b><%=patient_id2%></b></td>
</tr>
<tr>
	<td  class='label' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
	<td  class='querydata' wrap><b><%=patient_name1%></b></td>
	<td  class='label'>|</td>
	<td  class='querydata' wrap><b><%=patient_name2%></b></td>
</tr>
<tr>
	<td  class='label' nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
	<td  class='querydata'><b><%=gender1%></b></td>
	<td  class='label' >|</td>
	<td  class='querydata'><b><%=gender2%></b></td>
</tr>
<tr>
	<td  class='label' nowrap><fmt:message key="Common.age.label" bundle="${common_labels}"/></td>
	<td  class='querydata'><b><%=date_of_birth1%> <fmt:message key="Common.year.label" bundle="${common_labels}"/></b></td>
	<td  class='label'>|</td>
	<td  class='querydata'><b><%=date_of_birth2%><fmt:message key="Common.year.label" bundle="${common_labels}"/></b></td>
</tr>
		<tr  class='label'><td colspan=4>&nbsp;</td></tr>

<tr>
	<td  class='label'  nowrap><fmt:message key="Common.AdmissionDateTime.label" bundle="${common_labels}"/></td>
	<td  class='querydata'><b><%=admission_date_time1_converted%></b></td>
	<td  class='label'>|</td>
	<td  class='querydata'><b><%=admission_date_time2_converted%></b></td>
</tr>
<tr>
	<td  class='label' nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
	<td  class='querydata'><b><%=encounter_id1%></b></td>
	<td  class='label' >|</td>
	<td  class='querydata'><b><%=encounter_id2%></b></td>
</tr>
		<tr  class='label'><td colspan=4>&nbsp;</td></tr>

<tr>
	<td  class='label' nowrap><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
	<td  class='querydata'><b><%=nursing_unit_short_desc1%></b></td>
	<td  class='label' >|</td>
	<td  class='querydata'><b><%=nursing_unit_short_desc2%></b></td>
</tr>
<tr>
	<td  class='label'  nowrap><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></td>
	<td  class='querydata'><b><%=bed_class_short_desc1%></td>
	<td  class='label'>|</td>
	<td  class='querydata'><b><%=bed_class_short_desc2%></b></td>
</tr>
<tr>
	<td  class='label'  nowrap><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/></td>
	<td  class='querydata'><b><%=bed_type_short_desc1%></td>
	<td  class='label' >|</td>
	<td  class='querydata'><b><%=bed_type_short_desc2%></b></td>
</tr>
<tr>
	<td  class='label'  nowrap><fmt:message key="Common.roomno.label" bundle="${common_labels}"/></td>
	<td  class='querydata'><b><%=room_no1%></b></td>
	<td  class='label' >|</td>
	<td  class='querydata'><b><%=room_no2%></b></td>
</tr>
<tr>
	<td  class='label'  nowrap><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>
    <td  class='querydata'><b><%=bed_no1%></b></td>
	<td  class='label' >|</td>
	<td  class='querydata'><b><%=bed_no2%></b></td>
</tr>
	<tr  class='label'><td colspan=4>&nbsp;</td></tr>

<tr>
	<td  class='label' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
	<td class='querydata'><b><%=specialty_short_desc1%></b></td>
	<td  class='label' >|</td>
	<td  class='querydata'><b><%=specialty_short_desc2%></b></td>
</tr>
<tr>
	<td  class='label' nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td> 
<td  class='querydata'><b><%=practitioner_short_name1%></b></td>
	<td  class='label'>|</td>
	<td  class='querydata'><b><%=practitioner_short_name2%></b></td>
</tr>
<tr  class='label'><td colspan=4>&nbsp;</td></tr>
<tr>
	
	<td  class='label' width='16%' nowrap><fmt:message key="eIP.ReasonForSwap.label" bundle="${ip_labels}"/></td>
<td class='fields' width='24%'>	
<select name="swap_contact_reason" id="swap_contact_reason" ><option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
<%
		if(operSql1.length()>0) operSql1.delete(0,operSql1.length());
		//operSql1.append(" select  TRANSFER_TYPE_CODE,SHORT_DESC from ip_transfer_type_lang_vw where language_id='"+locale+"' and eff_status='E' order by SHORT_DESC");
		operSql1.append(" select  TRANSFER_TYPE_CODE,ip_get_desc.ip_transfer_type(transfer_type_code,'"+locale+"',2)SHORT_DESC from ip_transfer_type where eff_status='E' order by SHORT_DESC");
			pstmt	= con.prepareStatement(operSql1.toString());
			rs		= pstmt.executeQuery();
			
			while(rs!=null && rs.next())
			{
				ID	= rs.getString("TRANSFER_TYPE_CODE");
				Dat	= rs.getString("SHORT_DESC");
				out.print("<option value=\""+ID+"\">"+Dat+"");
			}
			if(rs != null) rs.close(); if(pstmt!= null) pstmt.close();
			
			
%>
			</select><img align="center" src="../../eCommon/images/mandatory.gif">	
		</td>
<td class='label' width='2%'>&nbsp;</td>

<!-- Modified SwapAbort name for ML-MMOH-SCF-2465 by Ajay Hatwate -->
<td class='fields' nowrap width='24%'><input type='button' onClick="formSubmit()" class='button' name='Swap' id='Swap' value ='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ConfirmSwap.label","ip_labels")%>' >
<input type='button' class='button' name='SwapAbort' id='SwapAbort' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AbortSwap.label","ip_labels")%>' onClick='parent.parent.document.getElementById("dialog_tag").close();' ></td>
</tr>

<!--	hidden values for both patient1 and patient 2 -->

<input type='hidden' name='encounter_id1' id='encounter_id1' value="<%=encounter_id1%>" >
<input type='hidden' name='patient_id1' id='patient_id1' value="<%=patient_id1%>" >
<input type='hidden' name='practitioner_id1' id='practitioner_id1' value="<%=practitioner_id1%>" >
<input type='hidden' name='specialty_code1' id='specialty_code1' value="<%=specialty_code1%>" >
<input type='hidden' name='nursing_unit_code1' id='nursing_unit_code1' value="<%=nursing_unit_code1%>" >
<input type='hidden' name='room_no1' id='room_no1' value="<%=room_no1%>" >
<input type='hidden' name='bed_no1' id='bed_no1' value="<%=bed_no1%>" >
<input type='hidden' name='service_code1' id='service_code1' value="<%=service_code1%>" >
<input type='hidden' name='bed_type_code1' id='bed_type_code1' value="<%=bed_type_code1%>" >
<input type='hidden' name='bed_class_code1' id='bed_class_code1' value="<%=bed_class_code1%>" >
<input type='hidden' name='nursing_unit_type1' id='nursing_unit_type1' value="<%=nursing_unit_type1%>" >
<input type='hidden' name='team_id1' id='team_id1' value="<%=team_id1%>" >
<input type='hidden' name='encounter_id2' id='encounter_id2' value="<%=encounter_id2%>" >
<input type='hidden' name='patient_id2' id='patient_id2' value="<%=patient_id2%>" >
<input type='hidden' name='practitioner_id2' id='practitioner_id2' value="<%=practitioner_id2%>" >
<input type='hidden' name='specialty_code2' id='specialty_code2' value="<%=specialty_code2%>" >
<input type='hidden' name='nursing_unit_code2' id='nursing_unit_code2' value="<%=nursing_unit_code2%>" >
<input type='hidden' name='room_no2' id='room_no2' value="<%=room_no2%>" >
<input type='hidden' name='bed_no2' id='bed_no2' value="<%=bed_no2%>" >
<input type='hidden' name='service_code2' id='service_code2' value="<%=service_code2%>" >
<input type='hidden' name='bed_type_code2' id='bed_type_code2' value="<%=bed_type_code2%>" >
<input type='hidden' name='bed_class_code2' id='bed_class_code2' value="<%=bed_class_code2%>" >
<input type='hidden' name='nursing_unit_type2' id='nursing_unit_type2' value="<%=nursing_unit_type2%>" >
<input type='hidden' name='team_id2' id='team_id2' value="<%=team_id2%>" >
<input type='hidden' name='patient_class1' id='patient_class1' value="<%=patient_class1%>" >
<input type='hidden' name='patient_class2' id='patient_class2' value="<%=patient_class2%>" >
<input type='hidden' name='bl_operational' id='bl_operational' value="<%=bl_operational%>" >
<input type='hidden' name='bl_interfaced_yn' id='bl_interfaced_yn' value="<%=bl_interfaced_yn%>" >

<input type='hidden' name='hid_gender1' id='hid_gender1' value="<%=hid_gender1%>" >
<input type='hidden' name='hid_gender2' id='hid_gender2' value="<%=hid_gender2%>" >

<input type='hidden' name='admission_date_time1' id='admission_date_time1' value="<%=admission_date_time1%>" >
<input type='hidden' name='admission_date_time2' id='admission_date_time2' value="<%=admission_date_time2%>" >

<input type='hidden' name='ip_param_bedchange_yn' id='ip_param_bedchange_yn' value="<%=ip_param_bedchange_yn%>" >
<input type='hidden' name='swap_contact_reasonHidden' id='swap_contact_reasonHidden' value="document.forms[0].swap_contact_reason.value" >
<input type="hidden" name="mother_status1" id="mother_status1" value="<%=mother_status1%>"> 
<input type="hidden" name="mother_status2" id="mother_status2" value="<%=mother_status2%>"> 
<input type="hidden" name="mother_bed_status1" id="mother_bed_status1" value=""> 
<input type="hidden" name="mother_bed_status2" id="mother_bed_status2" value=""> 
<input type="hidden" name="year1" id="year1" value="<%=year1%>"> 
<input type="hidden" name="year2" id="year2" value="<%=year2%>"> 
<input type="hidden" name="transfer_wo_delink_yn" id="transfer_wo_delink_yn" value="<%=transfer_wo_delink_yn%>"> <!-- Added for the CRF - HSA-CRF-0035 -->

</table>
</form>
</body>

<%	}catch(Exception e)	
	{
		//out.println(e);
		e.printStackTrace();
	}
	finally
	{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();

		if(con!= null)ConnectionManager.returnConnection(con,request);
	}

%>

</html>

<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

