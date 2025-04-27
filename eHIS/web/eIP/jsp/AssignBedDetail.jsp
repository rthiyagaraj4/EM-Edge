<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import= "webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.ResultSet,java.sql.Statement,com.ehis.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
    <head> 
    <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>

	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script src='../js/AssignBedDetail.js' language='javascript'></script>
	<script src='../js/IPPractitionerComponent.js' language='javascript'></script>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function ChkNullVal(obj, hiddenCode)
{
	if(obj.value == '')
	{
		document.forms[0].nursing_unit_desc.value	= '';
		document.forms[0].nursing_unit.value		= '';
		document.forms[0].nursing_unit_code.value	= '';
		var j=1;
		while(j<document.forms[0].service.length)
		{
			document.forms[0].service.remove(j);
		}
		document.forms[0].Splcode_desc.value		= '';
		document.forms[0].Splcode.value				= '';
		document.forms[0].practid.value				= '';
		document.forms[0].pract_desc.value			= '';
		document.forms[0].team_id.value				= '';
		document.forms[0].to_bed_no.value			= '';
		document.forms[0].to_room_no.value			= '';
	}
}

function dialogClose()
{
	window.close();
}

</script>
</head>

<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String locale			= (String)session.getAttribute("LOCALE");
	
	String chkreadonly				=	"";
	String encounterId				=	checkForNull(request.getParameter("encounterId"));
	String patientId				=	checkForNull(request.getParameter("patientId"));
	String p_oper_stn_id			=	checkForNull(request.getParameter("oper_stn_id"));
	String setup_bl_dtls_in_ip_yn	=	checkForNull(request.getParameter("setup_bl_dtls_in_ip_yn"),"N");
	String pat_check_in_allowed_yn	=	checkForNull(request.getParameter("pat_check_in_allowed_yn"),"N");
	if(pat_check_in_allowed_yn.equals("Y"))		chkreadonly = "disabled";

	String chg_nurs_unit_in_assign_bed_yn		= checkForNull(request.getParameter("chg_nurs_unit_in_assign_bed_yn"),"N");
	String from_adv_bed_mgmt			= checkForNull((String)request.getParameter("from_adv_bed_mgmt"),"N");


	Connection connection			=	null;
	Statement statement				=	null;
	ResultSet resultSet				=	null;

	StringBuffer sqlBuffer			=	new StringBuffer();
	String bl_operational			=	(String)session.getValue("bl_operational");
	String facility_id				=	checkForNull((String)session.getValue("facility_id"));
	String loginUser				=	checkForNull((String)session.getValue("login_user"));
	String admission_date_time		=	"";
	String admission_date_time1		=	"";
	String gender					=	"";
	String room_no					=	"";
	String admission_type_short_desc=	"";
	String practitioner_long_name	=	"";
	String specialty_short_desc		=	"";
	String nursing_unit_short_desc	=	"";
	String nursing_unit_code		=	"";
	String bed_class_code			=	"";
	String bed_type_code			=	"";
	String specialtycode			=	"";
	String practitionerid			=	"";
	String age						=	"";
	String year						=	"";
	String patient_class			=	"";
	String to_pract_team_id			=	""; 
	String medDesc					=	"";
	String medCode					=	"";
	String ot_date_time				=	"";
	String sdate					=	"";
	String bed_alloc_date_time_val  =	"";
	String billing_group_id			=	"";
	String billing_group_desc		=	"";
	String referral_id				=	"";
	String attend_pract_id			=	"";
	String attend_pract_name		=	"";
	String service_code				=	"";
	String bed_type_short_desc      =	"";
	String blocked_bed_no			=	"";
	String modified_date			=	"";
	String disable					=	"";
	String dcunitcode				=	"";
	String patient_gender			=	"";
	String exp_discharge_date_time	=	"";
	String date_of_birth			=	"";
	String admission_date_time_converted		=	"";
	String sdate_converted			=	"";
	String ot_date_time_converted	=	"";
	//Changed for PE By Sudhakar
	String bedcode					=	"";
	String beddesc					=	"";
	String pat_ser_grp_code			=	"";
	
	/*Added By Dharma on Oct 27th 2014 against HSA-CRF-0181 [IN:049541]  Start*/
	String weight_on_admission				= "";
	String weight_on_admission_unit			= "";
	String weight_on_admission_unit_display	= "";
	String weight_on_admn_mandatory			= checkForNull(request.getParameter("weight_on_admn_mandatory"));
	String is_validate_weight_on_admission	= (weight_on_admn_mandatory.equals("A")?"Y":"N");
	int no_of_days							= 0;
	/*Added By Dharma on Oct 27th 2014 against HSA-CRF-0181 [IN:049541]  End*/
	
	/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
	String height_on_admission				= "";
	String height_on_admission_unit			= "";
	String height_on_admn_mandatory			= checkForNull(request.getParameter("height_on_admn_mandatory"));
	String enable_height_bmi_pat_cls		= checkForNull(request.getParameter("enable_height_bmi_pat_cls"));
	String is_validate_height_on_admission	= (height_on_admn_mandatory.equals("A")?"Y":"N");
	String bmi="";
	
	/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527  END*/
	
	
	
	try
	{
		connection	= ConnectionManager.getConnection(request);

		Boolean restrictPseudoBed	= eCommon.Common.CommonBean.isSiteSpecific(connection,"IP","RESTRICT_PSEUDO_BED"); //Added by Sangeetha on  23/05/17 for GDOH-CRF-0151
		Boolean isHeightAndBmiEnable	= eCommon.Common.CommonBean.isSiteSpecific(connection, "MP", "BMI_REG_PAT_CHNGES_RH101");//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527
		//Query Changed for PE By Sudhakar
		//sqlBuffer.append(" select to_char(sysdate,'dd/mm/rrrr hh24:mi') sdate, to_char(a.admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time1,  a.nursing_unit_code, a.patient_id, b.sex, a.bed_class_code,ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2) bed_class_short_desc,a.bed_type_code, ip_get_desc.ip_bed_type (bed_type_code, '"+locale+"', 2) bed_type_short_desc, a.blocked_bed_no, am_get_desc.am_practitioner (a.admit_practitioner_id, '"+locale+"', 1 )admit_practitioner_name, a.admit_practitioner_id, a.service_code, am_get_desc.am_speciality (specialty_code, '"+locale+"', 2 ) specialty_short_desc, ip_get_desc.ip_admission_type(a.admission_type, '"+locale+"', 2) admission_short_desc, ip_get_desc.ip_nursing_unit (facility_id, nursing_unit_code, '"+locale+"', 2 ) nursing_unit_short_desc, a.room_num room_no, a.team_id, a.specialty_code, a.attend_practitioner_id, am_get_desc.am_practitioner (a.attend_practitioner_id, '"+locale+"',1) practitioner_short_name, get_age(b.DATE_OF_BIRTH) age,calculate_age(TO_CHAR(date_of_birth,'dd/mm/yyyy'),1)year, a.referral_id, a.dc_unit_code, a.patient_class, to_char(a.modified_date,'dd/mm/rrrr hh24:mi') modified_date, to_char(b.DATE_OF_BIRTH,'dd/mm/rrrr') date_of_birth, (select to_char(ot_date_time,'dd/mm/rrrr') from IP_ADT_TRN where trn_type = 'A' and facility_id='"+facility_id+"' and encounter_id='"+encounterId+"') ot_date_time, to_char(a.exp_discharge_date_time ,'dd/mm/rrrr hh24:mi')exp_discharge_date_time,b.pat_ser_grp_code from IP_OPEN_ENCOUNTER a, MP_PATIENT b where a.facility_id='"+facility_id+"' and a.encounter_id='"+encounterId+"' and a.patient_id = b.patient_id ");
		//weight_on_admission,weight_on_admission_unit added by Dharma on 27th Oct 2014 against HSA-CRF-0181 [IN:049541] 
		/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
		sqlBuffer.append(" select a.weight_on_admission,a.weight_on_admission_unit, a.height_on_admission, a.bmi,to_char(sysdate,'dd/mm/rrrr hh24:mi') sdate, to_char(a.admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time1,  a.nursing_unit_code, a.patient_id, b.sex, a.bed_class_code,ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2) bed_class_short_desc,a.bed_type_code, ip_get_desc.ip_bed_type (bed_type_code, '"+locale+"', 2) bed_type_short_desc, a.blocked_bed_no, am_get_desc.am_practitioner (a.admit_practitioner_id, '"+locale+"', 1 )admit_practitioner_name, a.admit_practitioner_id, a.service_code, am_get_desc.am_speciality (specialty_code, '"+locale+"', 2 ) specialty_short_desc, ip_get_desc.ip_admission_type(a.admission_type, '"+locale+"', 2) admission_short_desc, ip_get_desc.ip_nursing_unit (facility_id, nursing_unit_code, '"+locale+"', 2 ) nursing_unit_short_desc, a.room_num room_no, a.team_id, a.specialty_code, a.attend_practitioner_id, am_get_desc.am_practitioner (a.attend_practitioner_id, '"+locale+"',1) practitioner_short_name, get_age(b.DATE_OF_BIRTH) age,calculate_age(TO_CHAR(date_of_birth,'dd/mm/yyyy'),1)year, a.referral_id, a.dc_unit_code, a.patient_class, to_char(a.modified_date,'dd/mm/rrrr hh24:mi') modified_date, to_char(b.DATE_OF_BIRTH,'dd/mm/rrrr') date_of_birth, (select to_char(ot_date_time,'dd/mm/rrrr') from IP_ADT_TRN where trn_type = 'A' and facility_id='"+facility_id+"' and encounter_id='"+encounterId+"') ot_date_time, to_char(a.exp_discharge_date_time ,'dd/mm/rrrr hh24:mi')exp_discharge_date_time,b.pat_ser_grp_code, trunc (sysdate) - trunc (b.DATE_OF_BIRTH) no_of_days from IP_OPEN_ENCOUNTER a, MP_PATIENT b where a.facility_id='"+facility_id+"' and a.encounter_id='"+encounterId+"' and a.patient_id = b.patient_id ");
		if (resultSet!=null) resultSet.close();
		if (statement!=null) statement.close();
		statement	= connection.createStatement();
		resultSet		= statement.executeQuery(sqlBuffer.toString());
		
		if((resultSet != null) && (resultSet.next()))
		{
			ot_date_time				=	checkForNull(resultSet.getString("ot_date_time"));
			if(!(ot_date_time.equals("") || ot_date_time == null))
					ot_date_time_converted = DateUtils.convertDate(ot_date_time,"DMY","en",locale);	
			
			sdate						=	checkForNull(resultSet.getString("sdate"));
			if(!(sdate.equals("") || sdate == null))
					sdate_converted = DateUtils.convertDate(sdate,"DMYHM","en",locale); 			
			admission_date_time1		=	checkForNull(resultSet.getString("admission_date_time1"));
			admission_date_time			=	admission_date_time1;
			if(!(admission_date_time.equals("") || admission_date_time == null))
					admission_date_time_converted = DateUtils.convertDate(admission_date_time,"DMYHM","en",locale); 
			gender						=	checkForNull(resultSet.getString("sex"));
			room_no						=	checkForNull(resultSet.getString("room_no"));
			admission_type_short_desc	=	checkForNull(resultSet.getString("admission_short_desc"));
			practitioner_long_name		=	checkForNull(resultSet.getString("admit_practitioner_name"));
			practitionerid				=	checkForNull(resultSet.getString("admit_practitioner_id"));
			specialty_short_desc		=	checkForNull(resultSet.getString("specialty_short_desc"));
			nursing_unit_short_desc		=	checkForNull(resultSet.getString("nursing_unit_short_desc"));
			nursing_unit_code			=	checkForNull(resultSet.getString("nursing_unit_code"));
			service_code				=	checkForNull(resultSet.getString("service_code"));
			bed_class_code				=	checkForNull(resultSet.getString("bed_class_code"));
			beddesc						=	checkForNull(resultSet.getString("bed_class_short_desc"));
			bed_type_code				=	checkForNull(resultSet.getString("bed_type_code"));
			bed_type_short_desc			=	checkForNull(resultSet.getString("bed_type_short_desc"));
			specialtycode				=	checkForNull(resultSet.getString("SPECIALTY_CODE"));
			age							=	checkForNull(resultSet.getString("age"));
			year						=	checkForNull(resultSet.getString("year"));
			referral_id					=	checkForNull(resultSet.getString("referral_id"));
			modified_date				=	checkForNull(resultSet.getString("modified_date"));
			attend_pract_id				=	checkForNull(resultSet.getString("attend_practitioner_id"));
			attend_pract_name			=	checkForNull(resultSet.getString("practitioner_short_name"));
			blocked_bed_no				=	checkForNull(resultSet.getString("blocked_bed_no"));
			to_pract_team_id			=	checkForNull(resultSet.getString("team_id"));
			dcunitcode					=	checkForNull(resultSet.getString("dc_unit_code"));
			patient_class				=	checkForNull(resultSet.getString("patient_class"));
			date_of_birth				=	checkForNull(resultSet.getString("date_of_birth"));
			patient_gender				=	checkForNull(resultSet.getString("sex"));
			exp_discharge_date_time				=	checkForNull(resultSet.getString("exp_discharge_date_time"));
			pat_ser_grp_code			=	checkForNull(resultSet.getString("pat_ser_grp_code"));
			/*Added By Dharma on Oct 27th 2014 against HSA-CRF-0181 [IN:049541]  Start*/
			weight_on_admission			= checkForNull(resultSet.getString("weight_on_admission"));
			weight_on_admission_unit	= checkForNull(resultSet.getString("weight_on_admission_unit"));
			no_of_days					= resultSet.getInt("no_of_days");
			/*Added By Dharma on Oct 27th 2014 against HSA-CRF-0181 [IN:049541]  End*/
			
			/*Added by KAMATCHI S on 23-JUN-2020 fro ML-MMOH-CRF-1527*/
			height_on_admission			= checkForNull(resultSet.getString("height_on_admission"));
			bmi			= checkForNull(resultSet.getString("bmi"));
			/*Added by KAMATCHI S on 23-JUN-2020 fro ML-MMOH-CRF-1527 End*/
			
		}   
		
		/*Added By Dharma on Oct 27th 2014 against HSA-CRF-0181 [IN:049541]  Start*/
		if(weight_on_admission.equals("") && weight_on_admission_unit.equals("")){
			/*String lastchar	="";
			int calculate_age	= 0;
			if (age.length() > 0){
				lastchar		= age.substring(age.length() - 1);
				if (!age.contains("Y"))
					calculate_age	= Integer.parseInt(age.substring(0, age.length()-1));
				
			}
			weight_on_admission_unit	= (lastchar.equals("D")?(calculate_age >30 ? "K":"G"):"K");	*/	
			weight_on_admission_unit	= (no_of_days >30 ? "K":"G");		
		}
			weight_on_admission_unit_display	= (weight_on_admission_unit.equals("G")?"Gram":"Kg");
		/*Added By Dharma on Oct 27th 2014 against HSA-CRF-0181 [IN:049541]  End*/
		
		/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
		if(height_on_admission.equals("") && height_on_admission_unit.equals("")){
			height_on_admission_unit	= ("Cm");
		}
		
		/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527 End*/
		try
		{
			if (sqlBuffer.length() > 0)
				sqlBuffer.delete(0, sqlBuffer.length());
			
			sqlBuffer.append(" select a.short_desc short_desc ,a.team_id, b.practitioner_id from ");
			sqlBuffer.append(" AM_MEDICAL_TEAM_LANG_VW a, AM_PRACT_FOR_TEAM b where a.language_id = '"+locale+"' and A.facility_id = '");
			sqlBuffer.append(facility_id);
			sqlBuffer.append("' and a.facility_id = b.facility_id and a.team_id = b.team_id and a.appl_for_ip_yn = 'Y' and b.practitioner_id = '");
			sqlBuffer.append(practitionerid);
			sqlBuffer.append("' and a.team_id='");
			sqlBuffer.append(to_pract_team_id);
			sqlBuffer.append("' ");
			
			if (statement	!=	null)	statement.close();			
			if (resultSet	!=	null)	resultSet.close();

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sqlBuffer.toString());
			
			if ((resultSet != null) && (resultSet.next()))
			{
				 medCode = checkForNull(resultSet.getString("team_id"));
				 medDesc = checkForNull(resultSet.getString("short_desc"));
			}
		
			if(bl_operational.equals("Y"))
			{
				if (sqlBuffer.length() > 0)
					sqlBuffer.delete(0, sqlBuffer.length());
				
				sqlBuffer.append("select a.blng_grp_id, a.short_desc from BL_BLNG_GRP a, BL_EPISODE_FIN_DTLS b where a.blng_grp_id = b.blng_grp_id and b.operating_facility_id = '");
				sqlBuffer.append(facility_id);
				sqlBuffer.append("' and b.episode_id = '");
				sqlBuffer.append(encounterId);
				sqlBuffer.append("' ");
				if(patient_class.equals("DC"))
					sqlBuffer.append("and episode_type = 'D' ");
				else
					sqlBuffer.append("and episode_type = 'I' ");
				statement = connection.createStatement();
				resultSet = statement.executeQuery(sqlBuffer.toString());
				
				if ((resultSet != null) && (resultSet.next()))
				{
					billing_group_id	= checkForNull(resultSet.getString("BLNG_GRP_ID"));
					billing_group_desc	= checkForNull(resultSet.getString("SHORT_DESC"));
				}
				if (resultSet!=null) resultSet.close();
				if (statement!=null) statement.close();
			}
		}catch(Exception e)
		{
			

			e.printStackTrace();
		} 

	%>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"'>
	<FORM name='assign_bed' id='assign_bed' method=post action='../../servlet/eIP.AssignBedServlet'  target="messageFrame" onLoad='PopulateMedicalTeam();'>
	<table cellspacing=0 cellpadding='3' align='center' width='100%' border='0'>
		<tr><th align="left" style="color: white;" class='columnheader' <%if(!isHeightAndBmiEnable){%>colspan = '4'<%}else{%>colspan = '7'<%}%> ><fmt:message key="Common.AdmissionDetails.label" bundle="${common_labels}"/> </th></tr>
		<TR>
			<TD class='label' width="25%"><fmt:message key="Common.AdmissionDateTime.label" bundle="${common_labels}"/> </TD>
			<TD class='querydata' width="25%"> <%=admission_date_time_converted%> <INPUT TYPE="hidden"  name="admission_date_time" id="admission_date_time" value="<%=admission_date_time%>"></TD>
			<TD class='label' width="25%"><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/></TD>
			<TD class='querydata' width="25%"><%=admission_type_short_desc%> <INPUT TYPE="hidden"  name="admission_type_short_desc" id="admission_type_short_desc" value="<%=admission_type_short_desc%>"></TD>
		</TR>
		<!-- Added by Dharma on Oct 27th against HSA-CRF-0181 [IN:049541] Start -->
		<TR>
			<TD class='label' width="25%"><fmt:message key="eIP.WeightOnAdmission.label" bundle="${ip_labels}"/> </TD>
			<TD class='querydata' width="25%"> <input type='text' name="weight_on_admission" id="weight_on_admission"   size=15  <%if(weight_on_admission_unit.equals("G")){%>onKeyPress='return(ChkNumberInput(this,event,0))' maxlength=5 onblur="return(ChkNumberInput(this,event,0))" <%}else{%>  onKeyPress='return allowValidNumber(this,event,3,3);' onblur=" allowValidNumber(this,event,3,3);return fillDecimal(this,3,3);" maxlength=7 <%} %><%if(isHeightAndBmiEnable){if(enable_height_bmi_pat_cls.equals(patient_class)|| enable_height_bmi_pat_cls.equals("ID")) {%>onfocusout="calculateBmi();"<%}}%> value="<%=weight_on_admission%>" > &nbsp; <%=weight_on_admission_unit_display%><%if(is_validate_weight_on_admission.equals("Y")) {%><img align="center" src="../../eCommon/images/mandatory.gif"><%}%> <input type='hidden' name='is_validate_weight_on_admission' id='is_validate_weight_on_admission' value='<%=is_validate_weight_on_admission%>'/> <input type='hidden' name='weight_on_admission_unit' id='weight_on_admission_unit' value='<%=weight_on_admission_unit%>'/></TD>
			<%if(!isHeightAndBmiEnable){%>
			<TD class='label' width="25%" colspan=2>&nbsp;</TD>
			<%
			}
			else
			{if(enable_height_bmi_pat_cls.equals(patient_class)|| enable_height_bmi_pat_cls.equals("ID")) {%>
			<TD class='label' width="15%"><fmt:message key="eIP.HeightOnAdmission.label" bundle="${ip_labels}"/> </TD>
			<TD class='querydata' width="25%"> <input type='text' name="height_on_admission" id="height_on_admission"onKeyPress='return allowValidNumber(this,event,3,3);' onblur=" allowValidNumber(this,event,3,3);return fillDecimal(this,3,3); " onfocusout="calculateBmi();" maxlength=7  value="<%=height_on_admission%>" > &nbsp;<%=height_on_admission_unit%> <%if(is_validate_height_on_admission.equals("Y")) {%><img align="center" src="../../eCommon/images/mandatory.gif"><%}%>  
			<input type='hidden' name='height_on_admission_unit' id='height_on_admission_unit' value='<%=height_on_admission_unit%>'/></TD>
			
		
			<TD class='label' width="15%"><fmt:message key="Common.BMI.label" bundle="${common_labels}"/> </TD>
			<TD class='querydata' width="25%"> <input type='text' name="bmi" id="bmi"   size=15    maxlength=7  value="<%=bmi%>" readonly ></TD>
			<%}}%>
			<input type='hidden' name='is_validate_height_on_admission' id='is_validate_height_on_admission' value='<%=is_validate_height_on_admission%>'/> 
			<!--Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527-->
		</TR>
		<!-- Added by Dharma on Oct 27th against HSA-CRF-0181 [IN:049541] End -->
		<tr><th align="left" style=" color: white;" class='columnheader' <%if(!isHeightAndBmiEnable){%>colspan = '4'<%}else{%>colspan = '7'<%}%> ><fmt:message key="Common.NursingUnitDetails.label" bundle="${common_labels}"/> </th></tr>
	<%

	if (chg_nurs_unit_in_assign_bed_yn.equals("N") || from_adv_bed_mgmt.equals("Y"))
				disable = "Disabled";
	%>
		<TR>
			<TD class='label' ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></TD>
			<TD class='fields' ><input type='text' name="nursing_unit_desc" id="nursing_unit_desc"  maxlength=15 size=15 tabindex='1' <%=disable%> value="<%=nursing_unit_short_desc%>" onblur="beforeGetNursingUnit(this, '<%=facility_id%>','<%=loginUser%>','<%=p_oper_stn_id%>');" onchange="ChkNullVal(this,document.forms[0].nurs_desc_hid);" ><input type='button' class='BUTTON' name="nursing_unit_lookup" id="nursing_unit_lookup" value='?' <%=disable%> onClick="getNursingUnit(nursing_unit_desc, '<%=facility_id%>','<%=loginUser%>','<%=p_oper_stn_id%>');" tabindex='2'><img align="center" src="../../eCommon/images/mandatory.gif"><input type='hidden' name='to_speciality_code' id='to_speciality_code' value=''></input><INPUT TYPE="hidden" readOnly name="to_pract_team_id" id="to_pract_team_id" value="<%=medCode%>"><input type='hidden' name='nurs_desc_hid' id='nurs_desc_hid' value="<%=nursing_unit_short_desc%>"></td>
			<td class="label" width="20%" ><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
			<td class='fields'><select name="service" id="service" ><option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
			<%
				String sel			= "";
				String serv_code	= "";
				String service_desc	= "";
				StringBuffer sql_service = new StringBuffer();

				sql_service.append(" select service_code, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"','2') service_short_desc from IP_NURS_UNIT_FOR_SERVICE where facility_id = '"+facility_id+"' and nursing_unit_code = '"+nursing_unit_code+"' UNION select service_code, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"','2') service_short_desc from IP_NURSING_UNIT where facility_id = '"+facility_id+"' and nursing_unit_code = '"+nursing_unit_code+"' order by 2 ");

				statement = connection.createStatement();
				resultSet = statement.executeQuery(sql_service.toString());
				if(resultSet!=null )
				{
					while(resultSet.next())
					{
						serv_code  = resultSet.getString("service_code");
						service_desc = resultSet.getString("service_short_desc");
						if (serv_code.equals(service_code))
							sel = "selected";
						else
							sel = "";
						out.println("<option value=\""+serv_code+"\" "+sel+">"+service_desc+" </option> ");
					}
				}
			if (resultSet!=null) resultSet.close();
			if (statement!=null) statement.close();
			%></select><img align="center" src="../../eCommon/images/mandatory.gif">
			</td>
		</tr>
		<tr>
			<TD class='label' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></TD>
			<TD class='fields'><input type=text name='Splcode_desc' id='Splcode_desc' maxlength=15 size=15 width="15" value="<%=specialty_short_desc%>" onFocus="checkForNursing();"  onblur="beforeGetSpecialty(this, '<%=facility_id%>');"><input type=button name='Splcode_lookup' id='Splcode_lookup' value='?' class=button onClick="getSpecialty(Splcode_desc, '<%=facility_id%>');"><img align="center" src="../../eCommon/images/mandatory.gif"><input type=hidden name='Splcode' id='Splcode' width="15" value="<%=specialtycode%>"><INPUT TYPE="hidden" readOnly name="speciality" id="speciality" value="<%=specialty_short_desc%>"><input type=hidden name="spec_desc_hid" id="spec_desc_hid" value="<%=specialty_short_desc%>"></td><td colspan='4'></td>
		</tr>
		<TR>
			<TD class='label' ><fmt:message key="eIP.AdmittingPractitioner.label" bundle="${ip_labels}"/></TD>
			<TD class='querydata' ><%=practitioner_long_name%></TD>
			<TD class='label' width='15%'><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></TD>
			<TD class='fields' ><input type='text' name='pract_desc' id='pract_desc' value="<%=attend_pract_name%>" size='30' maxlength='30' onblur="beforeGetPractitioner(document.forms[0].practid,pract_desc, '<%=facility_id%>');" onFocus="checkForValues();"><input type='hidden' name='practid' id='practid' value="<%=attend_pract_id%>" readonly><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button' onclick = "getPractitionerLocal(document.forms[0].practid,pract_desc, '<%=facility_id%>');"><img align="center" src="../../eCommon/images/mandatory.gif"><input type=hidden name="pract_desc_hid" id="pract_desc_hid" value="<%=attend_pract_name%>"></td>			
		</TR>
		<TR>
			<TD class='label' ><fmt:message key="Common.medicalteam.label" bundle="${common_labels}"/></TD><TD class='fields' ><select name="team_id" id="team_id" onChange="getMedicalTeamHead(this);"><option value='' selected>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
			<%
				String optSelected	=	"";
				if (sqlBuffer.length() > 0)	sqlBuffer.delete(0, sqlBuffer.length());

				sqlBuffer.append(" select team_id, AM_GET_DESC.AM_MEDICAL_TEAM(facility_id,team_id, '"+locale+"','2') team_short_desc from AM_PRACT_FOR_TEAM_VW where facility_id = '");
				sqlBuffer.append(facility_id);
				sqlBuffer.append("' and practitioner_id ='");
				sqlBuffer.append(practitionerid);
				sqlBuffer.append("' and speciality_code = '");
				sqlBuffer.append(specialtycode);
				sqlBuffer.append("' ");
				statement = connection.createStatement();
				resultSet = statement.executeQuery(sqlBuffer.toString());
				if(resultSet!= null)
				{
					while(resultSet.next())
					{				
						medCode = checkForNull(resultSet.getString("team_id"));
						medDesc = checkForNull(resultSet.getString("team_short_desc"));
						if(medCode.equals(to_pract_team_id))
							optSelected="Selected";
						else
							optSelected="";
					%>
						<option value="<%=medCode%>" <%=optSelected%> ><%=medDesc%></option>
					<%						
					}			
				}
				if (resultSet!=null) resultSet.close();
				if (statement!=null) statement.close();
				
					
			/*Added Below Line code for [AK-SCF-0153] by Senthil */
			String language_direction="";
			int count=0;
			statement=connection.createStatement() ;
			//preparedStatement pstmt1 = con.prepareStatement( "select count(*) as total from sm_language where language_direction='R' and eff_status='E'" ) ;
			
		   resultSet = statement.executeQuery("select count(*) as total from sm_language where language_direction='R' and eff_status='E' and LANGUAGE_ID='"+locale+"'" ) ;
				 
			 if ( resultSet != null && resultSet.next() ) 
			 {
			 count = resultSet.getInt("total");
			 }

			if ( count==1 ) 
			{
				 language_direction = "RTL" ;
			}else
			{
				 language_direction = "LTR" ;
			}
			
			if (resultSet!=null) resultSet.close();
			if (statement!=null) statement.close();
			/*Added Above Line code for [AK-SCF-0153] by Senthil */
				
				
				
				
				%>					
			</select><input type="hidden" name="selecTeam" id="selecTeam"></TD>
			<TD class='label' ><fmt:message key="eIP.ProcedureSurgeryDateTime.label" bundle="${ip_labels}"/></TD><TD class='querydata' ><%=ot_date_time_converted%><INPUT TYPE="hidden" readOnly name="ot_date_time" id="ot_date_time" value="<%=ot_date_time%>"></TD>
		</TR>
		<!-- Below line modified for this incident [23474] --->
		<TR>
			<TD class='label' ><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></TD>
			<TD class='fields'><select name='Bedcode' id='Bedcode'  onChange='onBedClassChange();clearBedDetailsOnly();populateDailyRate(this)' <%=chkreadonly%> 
			dir='<%=language_direction%>'><option value='' selected >--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
		<%
			if(pat_check_in_allowed_yn.equals("Y")){%>
					<OPTION VALUE="<%=bed_class_code%>" ><%=beddesc%>
				<%}else{
					try{
						statement = connection.createStatement();
						//Commented and changed for PE By Sudhakar
						//String sql2=" select bed_class_code, short_desc from IP_BED_CLASS_LANG_VW where language_id = '"+locale+"' and eff_status='E' order by short_desc ";
						String sql2="SELECT DISTINCT a.bed_class_code bed_class_code, b.short_desc short_desc FROM IP_NURSING_UNIT_BED a, IP_BED_CLASS_LANG_VW b WHERE a.facility_id = '"+facility_id+"' AND a.eff_status = 'E' AND b.eff_status = 'E' AND a.nursing_unit_code = '"+nursing_unit_code+"' AND a.bed_class_code = b.bed_class_code and b.language_id = '"+locale+"' ORDER BY b.short_desc";
						if (resultSet!=null) resultSet.close();
						resultSet = statement.executeQuery(sql2);
							
							if( resultSet != null )
							{
							  while( resultSet.next() )
							  {
								 bedcode   = resultSet.getString(1) ;
								 beddesc   = resultSet.getString(2) ;
								%>
									<OPTION VALUE="<%=bedcode%>" ><%=beddesc%>
								<%            
								}
							}
						if (resultSet!=null) resultSet.close();
						if (statement!=null) statement.close();

						}catch(Exception e) {
							//out.println(e.toString());
							e.printStackTrace();
						}
				}
			
		%>
		</select><img src='../../eCommon/images/mandatory.gif'align='center'></img>
		<TD class='label' ><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/></TD>
		<TD class='fields' ><select name='Bedtype' id='Bedtype'  onChange='clearBedDetailsOnly();populateDailyRate(this)' <%=chkreadonly%>>
		<%if(!bed_type_short_desc.equals("")){%>
			<script>
				var obj = document.forms[0].Bedtype;
				var length  = obj.length;
				for(i=0;i<length;i++)
					{
					obj.remove(1);
					}
					var opt= document.createElement('Option');
					opt.text="<%=bed_type_short_desc%>"; 
					opt.value="<%=bed_type_code%>";
					opt.selected = true;
					obj.add(opt)
			</script>
			<%}else{%>
			<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
			</option><%}%></select><img align="center" src="../../eCommon/images/mandatory.gif"></td>
		</TR>

		<!-- Modified by Sangeetha on 25/05/17 for GDOH-CRF-0151-->
		<TR>
			<TD class='label' ><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></TD>
			<TD class='fields' ><input type="text" name="to_bed_no" id="to_bed_no" readOnly size=8 maxlength=8 value='<%=blocked_bed_no%>' onBlur="ChangeUpperCase(this);getRoomNo(this);checkForBedNo();check_bed_alcn_val(this);<% if(restrictPseudoBed){ %>chkforVacantNormalBed();<% }%>" onKeyPress='return CheckForSpecChars(event)'><input name="bed_avail_chart" id="bed_avail_chart" type="button" class="button" value="?" <% if(restrictPseudoBed){ %>onblur="chkforVacantNormalBed()" <% }%> onclick="callBedAvailChart();" <%if(from_adv_bed_mgmt.equals("Y")){%>disabled<%}%>><img align="center" src="../../eCommon/images/mandatory.gif"></td>
			<TD class='label'  ><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/></TD>
			<TD class='fields' ><input type="text" name="to_room_no" id="to_room_no" value='<%=room_no%>' size=10 maxlength=10 readonly onBlur="specialChar(this,'Char')"></TD>
	</TR>
	<%
		if(blocked_bed_no.equals("")||blocked_bed_no.equals(null))			
			bed_alloc_date_time_val = sdate_converted;
		else
			bed_alloc_date_time_val = admission_date_time_converted;
	%>
	<tr>	
		<TD class='label' width='15%'><fmt:message key="eIP.BedAllocationDateTime.label" bundle="${ip_labels}"/></TD>
		<TD class='fields' ><!-- <INPUT TYPE="text" name="bed_alloc_date_time" id="bed_alloc_date_time" id="bedallocdate" size="16" maxlength="16" value="<%=bed_alloc_date_time_val%>" onBlur='doDateTimeChk123(this)' onKeyPress='return(ChkNumberInput1(this,event,2))'  disabled >-->
		<INPUT TYPE="text" name="bed_alloc_date_time" id="bed_alloc_date_time" id="bedallocdate" size="16" maxlength="16" value="<%=bed_alloc_date_time_val%>"  onKeyPress='return(ChkNumberInput1(this,event,2))'  disabled ><img src='../../eCommon/images/mandatory.gif' align='center'> </img> </TD>
	<%	
		if(pat_check_in_allowed_yn.equals("Y"))
		{ %>
			<TD class='label' ><fmt:message key="Common.ArrivalDateTime.label" bundle="${common_labels}"/></TD>
			<TD class='fields'> <!--<INPUT TYPE="text" name="arrival_date_time" id="arrival_date_time" id="bedarrvldate" size="16" maxlength="16" value="<%=sdate_converted%>" onBlur='doDateTimeChk123(this)' onKeyPress='return(ChkNumberInput1(this,event,2))' disabled >--><INPUT TYPE="text" name="arrival_date_time" id="arrival_date_time" id="bedarrvldate" size="16" maxlength="16" value="<%=sdate_converted%>"  onKeyPress='return(ChkNumberInput1(this,event,2))' disabled >
			<img src='../../eCommon/images/mandatory.gif' align='center' > </img> </TD>
		<%}else {%>
			<TD class='label'  width='15%' ></TD>
			<TD class='querydata'></TD>
		<%}%>

	</TR>
	<% if(setup_bl_dtls_in_ip_yn.equals("Y")) { %>
		<TR>
			<TD class='label' ><fmt:message key="eIP.DailyRate.label" bundle="${ip_labels}"/></TD>
			<TD colspan='4' class='fields'><INPUT TYPE="text" name="daily_rate" id="daily_rate" readOnly ></TD>
		</TR>
	<% } else { %>
		<TR>
			<TD class='label' colspan='4'><INPUT TYPE="hidden" name="daily_rate" id="daily_rate" readOnly ></TD>
		</TR>
	<% } 
	int opCount=0;
	int ipCount=0;
	int radCount=0;
	String rad_installed_yn="";
	boolean show_appt_btn_yn=false;
	 statement = connection.createStatement();

	resultSet = statement.executeQuery("select count(1) as total from oa_appt where patient_id='"+patientId+"'  and trunc(Appt_date)>=trunc(sysdate) and nvl(appt_status,1)!='A' order by appt_date,appt_slab_from_time");
	if(resultSet!=null && resultSet.next()){
		opCount = resultSet.getInt("total");
	}
	if(statement !=null) statement.close();
	if(resultSet !=null) resultSet.close();


	statement=connection.createStatement();
	resultSet=statement.executeQuery("select nvl(install_yn,'N') as install_yn from sm_module where module_id = 'RD'");
	if(resultSet!=null && resultSet.next())
	{
		rad_installed_yn = resultSet.getString("install_yn");
	}
	

	if (rad_installed_yn == null || rad_installed_yn.equals(""))
	{
		rad_installed_yn="N";
	}

	if(statement !=null) statement.close();
	if(resultSet !=null) resultSet.close();
	if(rad_installed_yn.equals("Y")){

		statement = connection.createStatement();

		resultSet = statement.executeQuery("SELECT count(1) as total FROM RD_APPT where patient_id='"+patientId+"' AND TRUNC (appt_date) >= TRUNC (SYSDATE)");	
		if(resultSet!=null && resultSet.next()){
			radCount = resultSet.getInt("total");
		}


	}

	if(statement !=null) statement.close();
	if(resultSet !=null) resultSet.close();

	statement = connection.createStatement();
		resultSet = statement.executeQuery("select count(1) as total from ip_booking_list where  patient_id='"+patientId+"' and trunc(preferred_date)>=trunc(sysdate) and nvl(booking_status,1)=1");	
		if(resultSet!=null && resultSet.next()){
			ipCount = resultSet.getInt("total");
		}

		if (opCount != 0 || ipCount != 0 || radCount != 0)
		{
			show_appt_btn_yn=true;
		}%>
	</TABLE>
	<table cellspacing='0' cellpadding='3' align='center' width='100%' border='0'>
		<TR >
			<TD class="label" width="25%"></TD>
			<TD class="fields" width="25%"><INPUT TYPE="button" style="visibility:hidden" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientValuables.label","common_labels")%>' class='button' onClick='showValuables()'></TD>
			<TD class="label" width="25%"></TD>
			<TD  class="fields" width="25%"><input type='hidden' name="referral_id" id="referral_id" value="<%=referral_id%>">

			
			<INPUT TYPE="button" name="referral" id="referral" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referraldetails.label","common_labels")%>' class='button' onClick='refDet(document.forms[0].referral_id)'><%if (show_appt_btn_yn == true){%>
			<INPUT TYPE="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.FutureAppointments.label","ip_labels")%>' name="OthAppt" class='button' onClick='showOtherAppointments()'><%}%><INPUT TYPE="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' name="record" class='button' onClick='Apply()'><INPUT class='button' TYPE="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onClick='closeWin()'></TD>
		</TR>
	</TABLE>
	<!--hidden value for bed type code and bed class code has been modified -->
	<input type='hidden' name='patient_class' id='patient_class' value="<%=patient_class%>" >
	<input type='hidden' name='enable_height_bmi_pat_cls' id='enable_height_bmi_pat_cls' value="<%=enable_height_bmi_pat_cls%>" ><!-- Added by KAMATCHI S on 23-JUN-2020 fro ML-MMOH-CRF-1527 -->
	<input type='hidden' name='isHeightAndBmiEnable' id='isHeightAndBmiEnable' value="<%=isHeightAndBmiEnable%>" ><!-- Added by KAMATCHI S on 23-JUN-2020 fro ML-MMOH-CRF-1527 -->
	<input type='hidden' name='room_no' id='room_no' value="<%=room_no%>" >
	<input type='hidden' name='gender' id='gender' value="<%=gender%>" >
	<input type='hidden' name='specialty_code' id='specialty_code' value="<%=specialtycode%>" >
	<input type='hidden' name='practitioner_id' id='practitioner_id' value="<%=practitionerid%>" >
	<input type='hidden' name='age' id='age' value="<%=age%>" >
	<input type='hidden' name='year' id='year' value="<%=year%>" >
	<input type='hidden' name='encounterId' id='encounterId' value="<%=encounterId%>" >
	<input type='hidden' name='p_patient_id' id='p_patient_id' value="<%=patientId%>" >
	<input type='hidden' name='sdate' id='sdate' value="<%=sdate%>">
	<input type='hidden' name='trn_date' id='trn_date' value="<%=admission_date_time1%>">
	<input type='hidden' name='bed_type_code' id='bed_type_code' value="<%=bed_type_code%>">
	<input type='hidden' name='modified_bed_type_code' id='modified_bed_type_code' value="">
	<input type='hidden' name='bed_class_code' id='bed_class_code' value="<%=bed_class_code%>">
	<input type='hidden' name='setup_bl_dtls_in_ip_yn' id='setup_bl_dtls_in_ip_yn' value="<%=setup_bl_dtls_in_ip_yn%>">
	<input type='hidden' name='billing_group_id' id='billing_group_id' value="<%=billing_group_id%>">
	<input type='hidden' name='billing_group_desc' id='billing_group_desc' value="<%=billing_group_desc%>">
	<input type='hidden' name='bl_operational' id='bl_operational' value="<%=bl_operational%>"> 
	<input type='hidden' name='bedtypecode' id='bedtypecode' value="">
	<input type='hidden' name='nursing_unit_code' id='nursing_unit_code' value="<%=nursing_unit_code%>" >
	<input type='hidden' name='from_nursing_unit_code' id='from_nursing_unit_code' value="<%=nursing_unit_code%>" >
	<input type='hidden' name="nursing_unit" id="nursing_unit" width="15" value="<%=nursing_unit_code%>" > 
	<input type='hidden' name='chg_nurs_unit_in_assign_bed_yn' id='chg_nurs_unit_in_assign_bed_yn' value="<%=chg_nurs_unit_in_assign_bed_yn%>">
	<input type='hidden' name='pat_check_in_allowed_yn' id='pat_check_in_allowed_yn' value="<%=pat_check_in_allowed_yn%>">
	<input type="hidden" name="modified_date_val" id="modified_date_val" value="<%=modified_date%>"> 
	<input type="hidden" name="continue_yn" id="continue_yn" > 
	<input type='hidden' name='help_function_id' id='help_function_id' value='ASSIGN_BED'>
	<input type='hidden' name='BalnkFlag' id='BalnkFlag' value='Y'>
	<input type='hidden' name='dcunitcode' id='dcunitcode' value="<%=dcunitcode%>">
	<input type='hidden' name='oper_stn_id' id='oper_stn_id' value='<%=p_oper_stn_id%>'>
	<input type='hidden' name='patient_gender' id='patient_gender' value='<%=patient_gender%>'>
	<input type='hidden' name='exp_discharge_date_time' id='exp_discharge_date_time' value='<%=exp_discharge_date_time%>'>
	<input type='hidden' name='date_of_birth' id='date_of_birth' value='<%=date_of_birth%>'>
	<input type='hidden' name='orig_blocked_bed_no' id='orig_blocked_bed_no' value='<%=blocked_bed_no%>'>
	<input type='hidden' name='sStyle' id='sStyle' value='<%=sStyle%>'>
	<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
	<input type='hidden' name='pat_ser_grp_code' id='pat_ser_grp_code' value='<%=pat_ser_grp_code%>'>
	<!-- Added by Sangeetha on 25/05/17 for GDOH-CRF-0151-->
	<input type='hidden' name='hddfacility' id='hddfacility' value='<%=facility_id%>'>

	<script>
		document.forms[0].Bedcode.value="<%=bed_class_code%>";
		var ref = "<%=referral_id%>";
		if (ref == '')
			document.forms[0].referral.style.visibility = 'hidden';
	
		if("<%=blocked_bed_no%>" != "")
		{
			document.forms[0].to_bed_no.onblur();
		}
	</script>
	</FORM>
		<%
	}catch(Exception e) 
	{
		//out.println(e.toString());
		e.printStackTrace();
	}
    finally
    {
        try
		{
			if (resultSet != null)	resultSet.close();
			if (statement != null)	statement.close();
			ConnectionManager.returnConnection(connection,request);
		}catch(Exception ee) 
		{
			//out.println("Error While Closing the connections :"+ee.toString());
			ee.printStackTrace();
		}
    }
%>
</body>
</html>
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

