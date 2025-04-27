<!DOCTYPE html>
<html>
<!--
	Developed by 	:	Sridhar R
	Created on 		:	5 JUNE 2004
	Module			:	InpatientManagement (IP)
-->
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,com.ehis.util.*,java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></script>
  	<script src='../js/DischargePatient.js' language='javascript'></script>	
  	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>

<%
	Connection con		= null;
	Statement stmt 		= null;
	ResultSet rset		= null;
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
	String locale					= (String)session.getAttribute("LOCALE");
	String facilityId = (String)session.getValue("facility_id");//Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
	String admission_date_time		= checkForNull(request.getParameter("admission_date_time"));
	String adm_date_display			= DateUtils.convertDate(admission_date_time,"DMYHM","en",locale);
	String admission_short_desc		= checkForNull(request.getParameter("admission_short_desc"));
	String specialty_short_desc		= checkForNull(request.getParameter("specialty_short_desc"));
	String practitioner_name		= checkForNull(request.getParameter("practitioner_name"));
	String nursing_unit_short_desc	= checkForNull(request.getParameter("nursing_unit_short_desc"));
	String service_short_desc		= checkForNull(request.getParameter("service_short_desc"));
	String bed_no					= checkForNull(request.getParameter("bed_no"));
	String room_no					= checkForNull(request.getParameter("room_no"));
	String bed_class_short_desc		= checkForNull(request.getParameter("bed_class_short_desc"));
	String bed_type_desc			= checkForNull(request.getParameter("bed_type_desc"));
	String medteamdesc 				= checkForNull(request.getParameter("medteamdesc"));
	//Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
	//Start
	String encounterID 				= checkForNull(request.getParameter("encounter_id"));
	String patient_class 			= checkForNull(request.getParameter("patient_class"));
	String mr_mds_recorded ="";
	int mds_chk=0;

	
	/*Added By Dharma on Oct 29th 2014 against HSA-CRF-0181 [IN:049541]  Start*/
	String weight_on_admission				= checkForNull(request.getParameter("weight_on_admission"));
	String weight_on_admission_unit			= checkForNull(request.getParameter("weight_on_admission_unit"));
	String weight_on_admission_unit_display	= checkForNull(request.getParameter("weight_on_admission_unit_display"));
	String is_validate_weight_on_admission	= checkForNull(request.getParameter("is_validate_weight_on_admission"));
	String is_value_already_captured		= checkForNull(request.getParameter("is_value_already_captured"));
	String call_function					= checkForNull(request.getParameter("call_function"));
	/*Added By Dharma on Oct 29th 2014 against HSA-CRF-0181 [IN:049541]  End*/

	
	/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
	String height_on_admission				= checkForNull(request.getParameter("height_on_admission"));
	String height_on_admission_unit			= checkForNull(request.getParameter("height_on_admission_unit"));
	String bmi	= checkForNull(request.getParameter("bmi"));
	String is_validate_height_on_admission	= checkForNull(request.getParameter("is_validate_height_on_admission"));
	String is_value_already_captured_height = checkForNull(request.getParameter("is_value_already_captured_height"));
	String enable_height_bmi_pat_cls		= checkForNull(request.getParameter("enable_height_bmi_pat_cls"));
	/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527 END	*/
	con		= ConnectionManager.getConnection(request);
		Boolean isHeightAndBmiEnable	= eCommon.Common.CommonBean.isSiteSpecific(con, "MP", "BMI_REG_PAT_CHNGES_RH101");//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527
	try
		{
		stmt = con.createStatement();
		rset=stmt.executeQuery("select mr_mds_recorded_yn ('"+facilityId+"','"+encounterID+"','"+patient_class+"',null,'DI',null) mr_mds_recorded from dual");
		if(rset.next())
			{
			
			mr_mds_recorded=rset.getString("mr_mds_recorded");
			
			}
		if(rset != null) rset.close(); 
		if(stmt != null) stmt.close();
		}
		catch(Exception e)
			{
			System.out.println("Exception occurred while executing mr_mds_recorded_yn :"+e);
			e.printStackTrace();
			}
		
	try
		{
		String sql_mds="select count(*) as cnt from mr_mds_for_patient_class where MANDATORY_FOR_"+patient_class+"_YN='Y' and  ("+patient_class+"_STAGE='ALL' or "+patient_class+"_STAGE='DI')";
		stmt=con.createStatement();
		rset=stmt.executeQuery(sql_mds);
		if(rset.next())
			{
			mds_chk=rset.getInt("cnt");
			}
		if(stmt!=null) stmt.close();
		if(rset!=null) rset.close();
		}
	catch(Exception e)	
		{
		e.printStackTrace();
		}
	//End	
	try
	{
%>
<body onLoad='' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name='DischargePatient_form_display' id='DischargePatient_form_display'  method="" action="" target="">
		<table cellpadding="3" cellspacing="0" width="100%">
			<tr>
				<td class='COLUMNHEADER' <%if(!isHeightAndBmiEnable){%>colspan = '4'<%}else{%>colspan = '7'<%}%> ><fmt:message key="Common.encounterdetails.label" bundle="${common_labels}"/></td>
			</tr>
			<tr>
				<td width="25%" class=label ><fmt:message key="Common.AdmissionDateTime.label" bundle="${common_labels}"/></td>
				<td  width="30%" class='querydata'><%=adm_date_display%></td>
				<td width="20%" class=label ><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/></td>
				<td  width="25%" class='querydata'><%=admission_short_desc%></td>
			</tr>
			<tr>
				<td class=label ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
				<td  class='querydata'><%=specialty_short_desc%></td>
				<td class=label ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
				<td  class='querydata'><%=practitioner_name%></td>
			</tr>
			<tr>
			<td class=label ><fmt:message key="Common.medicalteam.label" bundle="${common_labels}"/></td>
				<td  class='querydata'><%=medteamdesc%></td>
				<td class=label ></td>
				<td class=label ></td>
			</tr>
			
			<!-- Added by Dharma on Oct 29th against HSA-CRF-0181 [IN:049541] Start -->
			<%if(call_function.equals("PaintDischargePatient.jsp")){%>
			<tr>
			<td class=label ><fmt:message key="eIP.WeightOnAdmission.label" bundle="${ip_labels}"/></td>
				<td  class='querydata'>
					<input type='text' name="weight_on_admission" id="weight_on_admission"  size=15 tabindex='1' <%if(weight_on_admission_unit.equals("G")){%>onKeyPress='return(ChkNumberInput(this,event,0))' onblur="return(ChkNumberInput(this,event,0))" maxlength=5 <%}else{%>onKeyPress='return allowValidNumber(this,event,3,3);' maxlength=7 onblur="allowValidNumber(this,event,3,3);return fillDecimal(this,3,3);"<%} %><%if(isHeightAndBmiEnable){if(enable_height_bmi_pat_cls.equals(patient_class)|| enable_height_bmi_pat_cls.equals("ID")) {%>onfocusout="calculateBmi();"<%}}%>value="<%=weight_on_admission%>" > &nbsp; <%=weight_on_admission_unit_display%><%if(is_validate_weight_on_admission.equals("Y")) {%><img align="center" src="../../eCommon/images/mandatory.gif"><%}%> 
					<input type='hidden' name='is_validate_weight_on_admission' id='is_validate_weight_on_admission' value='<%=is_validate_weight_on_admission%>'/> 
					<input type='hidden' name='weight_on_admission_unit' id='weight_on_admission_unit' value='<%=weight_on_admission_unit%>'/>
					<input type='hidden' name='is_value_already_captured' id='is_value_already_captured' value='<%=is_value_already_captured%>'/>
				</td>
				<!-- Added by Dharma on Oct 29th against HSA-CRF-0181 [IN:049541] End -->
				<!-- Added by KAMATCHI S for ML-MMOH-CRF-1527 ON 23-JUN-2020-->
			<%if(!isHeightAndBmiEnable){%>
				<td class=label ></td>
				<td class=label ></td>
			<%	}
			else {
				if(enable_height_bmi_pat_cls.equals(patient_class)  || enable_height_bmi_pat_cls.equals("ID")){
			%>
			<td class='label' ><fmt:message key="eIP.HeightOnAdmission.label" bundle="${ip_labels}"/> </td>
			<td class='querydata' > <input type='text' name="height_on_admission" id="height_on_admission"      onKeyPress='return allowValidNumber(this,event,3,3);' onblur=" allowValidNumber(this,event,3,3);return fillDecimal(this,3,3); " onfocusout="calculateBmi();" maxlength=7  value="<%=height_on_admission%>" > &nbsp;<%=height_on_admission_unit%> <%if(is_validate_height_on_admission.equals("Y")) {%><img align="center" src="../../eCommon/images/mandatory.gif"><%}%>
			</td>
			
		
			<td class='label' ><fmt:message key="Common.BMI.label" bundle="${common_labels}"/> </td>
			<td class='querydata' ><input type='text' name="bmi" id="bmi"   size=15    maxlength=7  value="<%=bmi%>" readonly ></td>
				
			<%}}%>
			<input type='hidden' name='is_validate_height_on_admission' id='is_validate_height_on_admission' value='<%=is_validate_height_on_admission%>'/> 
			<input type='hidden' name='height_on_admission_unit' id='height_on_admission_unit' value='<%=height_on_admission_unit%>'/>
			<input type='hidden' name='is_value_already_captured_height' id='is_value_already_captured_height' value='<%=is_value_already_captured_height%>'/>
			<input type='hidden' name='enable_height_bmi_pat_cls' id='enable_height_bmi_pat_cls' value='<%=enable_height_bmi_pat_cls%>'/>
			<!-- Added by KAMATCHI S for ML-MMOH-CRF-1527 ON 23-JUN-2020-->	
			</tr>
			<!-- Added by Dharma on Oct 29th against HSA-CRF-0181 [IN:049541] End -->
			<!--Added by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123] Start-->
			<%} else{%>
			
<tr>
<td class='label' ><fmt:message key="eIP.WeightOnAdmission.label" bundle="${ip_labels}"/></td>
<td class='QUERYDATA'><%=weight_on_admission%> <%=weight_on_admission_unit_display%> </td>   
<!-- Added by KAMATCHI S for ML-MMOH-CRF-1527 ON 23-JUN-2020-->
<%	
	if(isHeightAndBmiEnable )
{
	if(enable_height_bmi_pat_cls.equals(patient_class)  || enable_height_bmi_pat_cls.equals("ID"))
	{
%>
<td class='label' "><fmt:message key="eIP.HeightOnAdmission.label" bundle="${ip_labels}"/> </td>
  	  <td class='QUERYDATA' ><%=height_on_admission%> <%=height_on_admission_unit%></td>
			
	<td class='label' "><fmt:message key="Common.BMI.label" bundle="${common_labels}"/> </td>
			<td class='QUERYDATA' ><%=bmi%></td>
 	<%}}else{%>
	<td class=label colspan=2 >&nbsp;</td>
	<%}%>
 <!-- Added by KAMATCHI S for ML-MMOH-CRF-1527 ON 23-JUN-2020-->
</tr>

			<%}%>
			<!--Added by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123] End-->
			<tr>
				<td class='COLUMNHEADER' <%if(!isHeightAndBmiEnable){%>colspan = '4'<%}else{%>colspan = '7'<%}%>><fmt:message key="Common.NursingUnitDetails.label" bundle="${common_labels}"/></td>
			</tr>
			<tr>
				<td class=label ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
				<td  class='querydata'><%=nursing_unit_short_desc%></td>
				<td class=label ><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
				<td  class='querydata'><%=service_short_desc%></td>
			</tr>
			<tr>
				<td class=label ><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>
				<td  class='querydata'><%=bed_no%></td>
				<td class=label ><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/></td>
				<td  class='querydata'><%=room_no%></td>
			</tr>
			<tr>
				<td class=label ><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></td>
				<td  class='querydata'><%=bed_class_short_desc%></td>
				<td class=label ><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/></td>
				<td  class='querydata'><%=bed_type_desc%></td>
			</tr>
			<!--Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013-->
			<!--Start-->
			<input type='hidden' name='mr_mds_recorded' id='mr_mds_recorded' value="<%=mr_mds_recorded%>">
			<input type='hidden' name='mds_chk' id='mds_chk' value="<%=mds_chk%>">
			<%if(mds_chk!=0){%>
			<tr>
				<td  class='label' ><fmt:message key="eMR.MDS.label" bundle="${mr_labels}"/></td>
				<%if(mr_mds_recorded.equals("Y"))
					{%>
				<td  class='QUERYDATA'><font color='RED'><fmt:message key="Common.CriteriaMet.label" bundle="${common_labels}"/></font></td>
				<%}
				else{%>
				<td  class='QUERYDATA'><font color='RED'><fmt:message key="Common.CriteriaNotMet.label" bundle="${common_labels}"/></font>&nbsp;<font color='blue'><a href='javascript:onclick=MDSCompliance(parent.frames[1].document.forms[0].mr_mds_recorded.value)' style='text-decoration:underline'><fmt:message key="Common.Check.label" bundle="${common_labels}"/></a></font></td>
				<script>	</script>
				<%
				
				}%>
				<td  class='label' ></td>
				<td  class='QUERYDATA'></td>
			</tr>
			<%}%>
			<!--End-->
			<tr>
				<td  colspan=4 height="1"></td>
			</tr>
		</table>
	</form>		
</body>
<%		
		if(rset!=null) 	rset.close();
		if(stmt!=null) 	stmt.close();
	}catch(Exception e)
	{
		out.print("Exception "+e);
	}	
	finally   
	{
		ConnectionManager.returnConnection(con,request);
	}
%></html>
<%!
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>

