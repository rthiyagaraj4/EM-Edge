<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,com.ehis.util.*,java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<HTML>
<HEAD>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src="../js/DischargeAdvice.js" language="JavaScript"></Script>
<TITLE> <fmt:message key="Common.DischargeAdvice.label" bundle="${common_labels}"/> </TITLE>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function LoadRecordButton(reload_yn)
	{
		/* //Added by Kamatchi S for ML-MMOH-SCF-1643
		if(parent.frames[1].document.forms[0].weight_on_admission)
			//parent.frames[1].document.forms[0].weight_on_admission.value=parent.frames[2].document.forms[0].weight_on_admission_load.value;
			parent.frames[1].document.forms[0].weight_on_admission.value=parent.f_query_add_mod.document.getElementById("weight_on_admission_load").value;
		if(parent.frames[1].document.forms[0].height_on_admission)
			//parent.frames[1].document.forms[0].height_on_admission.value=parent.frames[2].document.forms[0].height_on_admission_load.value;
			parent.frames[1].document.forms[0].height_on_admission.value=parent.f_query_add_mod.document.getElementById("height_on_admission_load").value;
		if(parent.frames[1].document.forms[0].bmi)
			//parent.frames[1].document.forms[0].bmi.value=parent.frames[2].document.forms[0].bmi_load.value;
			parent.frames[1].document.forms[0].bmi.value=parent.f_query_add_mod.document.document.getElementById("bmi_load").value; */
		if(reload_yn=='Y')
		{
			parent.frames[3].document.location.href=parent.frames[3].document.location.href;
		}
	}
	</script>
</HEAD>
<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
	String locale				= (String)session.getAttribute("LOCALE");
	String facilityId = (String)session.getValue("facility_id");//Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
	String encounterID			= checkForNull(request.getParameter("EncounterId"));
	String admissiondatetime	= checkForNull(request.getParameter("admissiondatetime"));
	String adm_date_display		= DateUtils.convertDate(admissiondatetime,"DMYHM","en",locale);
	String admissiontypedesc	= checkForNull(request.getParameter("admissiontypedesc"));
	String specialtyshortdesc	= checkForNull(request.getParameter("specialtyshortdesc"));
	String practitionername		= checkForNull(request.getParameter("practitionername"));
	String nursingunitshortdesc = checkForNull(request.getParameter("nursingunitshortdesc"));
	String serviceshortdesc		= checkForNull(request.getParameter("serviceshortdesc"));
	String bedno				= checkForNull(request.getParameter("bedno"));
	String roomno				= checkForNull(request.getParameter("roomno"));
	String bedclassshortdesc	= checkForNull(request.getParameter("bedclassshortdesc"));
	String bed_type_desc		= checkForNull(request.getParameter("bed_type_desc"));
	String reload_yn		= checkForNull(request.getParameter("reload_yn"));
	String query_string		    = request.getQueryString();
	//Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
	//Start
	String mr_mds_recorded =checkForNull(request.getParameter("mr_mds_recorded"));
	String patient_class 			= checkForNull(request.getParameter("patient_class"));
	
	/*Added By Dharma on Oct 29th 2014 against HSA-CRF-0181 [IN:049541]  Start*/
	String weight_on_admission				= checkForNull(request.getParameter("weight_on_admission"));
	String weight_on_admission_unit			= checkForNull(request.getParameter("weight_on_admission_unit"));
	String weight_on_admission_unit_display	= checkForNull(request.getParameter("weight_on_admission_unit_display"));
	String is_validate_weight_on_admission	= checkForNull(request.getParameter("is_validate_weight_on_admission"));
	String is_value_already_captured		= checkForNull(request.getParameter("is_value_already_captured"));
	/*Added By Dharma on Oct 29th 2014 against HSA-CRF-0181 [IN:049541]  End*/
	
	/*Added by KAMATCHI S on 23-JUN-2020 foR ML-MMOH-CRF-1527*/
	String height_on_admission				= checkForNull(request.getParameter("height_on_admission"));
	String height_on_admission_unit			= checkForNull(request.getParameter("height_on_admission_unit"));
	String height_on_admn_mandatory         = checkForNull(request.getParameter("height_on_admn_mandatory"));
	String enable_height_bmi_pat_cls		= checkForNull(request.getParameter("enable_height_bmi_pat_cls"));
	String is_validate_height_on_admission  = checkForNull(request.getParameter("is_validate_height_on_admission"));
	String is_value_already_captured_height = checkForNull(request.getParameter("is_value_already_captured_height"));
	String bmi= checkForNull(request.getParameter("bmi"));
	/*Added by KAMATCHI S on 23-JUN-2020 fOR ML-MMOH-CRF-1527 END */
	int mds_chk=0;
	Connection con		= null;
	Statement stmt 		= null;
	ResultSet rset		= null;
	con		= ConnectionManager.getConnection(request);
	Boolean isHeightAndBmiEnable	= eCommon.Common.CommonBean.isSiteSpecific(con, "MP", "BMI_REG_PAT_CHNGES_RH101");//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527
	
	try
		{
		stmt = con.createStatement();
		rset=stmt.executeQuery("select mr_mds_recorded_yn ('"+facilityId+"','"+encounterID+"','"+patient_class+"',null,'DA',null) mr_mds_recorded from dual");
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
		String sql_mds="select count(*) as cnt from mr_mds_for_patient_class where MANDATORY_FOR_"+patient_class+"_YN='Y' and  ("+patient_class+"_STAGE='ALL' or "+patient_class+"_STAGE='DA')";
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
	finally
		{
		try
		{
		if(stmt!=null) stmt.close();
		if(rset!=null) rset.close();
		ConnectionManager.returnConnection(con,request);
		}
		catch(Exception e){}
		}	
	//End	
%>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="LoadRecordButton('<%=reload_yn%>');">
	<form name='Display_Form' id='Display_Form' action='' method='' target=''>
		<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
			<tr><td <%if(!isHeightAndBmiEnable){%>colspan = '4'<%}else{%>colspan = '7'<%}%> class='COLUMNHEADER'><fmt:message key="Common.encounterdetails.label" bundle="${common_labels}"/></td></tr>
			<tr><!-- 17956 Thursday, January 07, 2010 -->
				<td width='25%'  class='label' width='10%'><fmt:message key="Common.AdmissionDateTime.label" bundle="${common_labels}"/></td>
				<td width='25%'  class='QUERYDATA'   ><%=adm_date_display%></td>
				<td width='25%'  class='label' width='10%'><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/></td>
				<td width='25%'  class='QUERYDATA'   ><%=admissiontypedesc%></td>
			</tr>
			<tr>
				<td  class='label' ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
				<td  class='QUERYDATA'   ><%=encounterID%></td>
				<td ></td>
				<td ></td>
			</tr>
			<tr>
				<td  class='label' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
				<td  class='QUERYDATA' ><%=specialtyshortdesc%></td>
				<td  class='label' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
				<td  class='QUERYDATA'   ><%=practitionername%></td>
			</tr>
			<!-- Added by Dharma on Oct 29th against HSA-CRF-0181 [IN:049541] Start -->
			<tr>
				<td  class='label' ><fmt:message key="eIP.WeightOnAdmission.label" bundle="${ip_labels}"/></td>
				<td  class='QUERYDATA'   >
					<input type='text' name="weight_on_admission" id="weight_on_admission"  size=15 tabindex='1' <%if(weight_on_admission_unit.equals("G")){%>onKeyPress='return(ChkNumberInput(this,event,0));' onblur="return(ChkNumberInput(this,event,0));" maxlength=5 <%}else{%>onKeyPress='return allowValidNumber(this,event,3,3);' onblur=" allowValidNumber(this,event,3,3);return fillDecimal(this,3,3);" maxlength=7<%} %> 
					<%if(isHeightAndBmiEnable){if(enable_height_bmi_pat_cls.equals(patient_class)|| enable_height_bmi_pat_cls.equals("ID")) {%>onfocusout="calculateBmi();"<%}}%> value="<%=weight_on_admission%>" > &nbsp; <%=weight_on_admission_unit_display%><%if(is_validate_weight_on_admission.equals("Y")) {%><img align="center" src="../../eCommon/images/mandatory.gif"><%}%> 
					<input type='hidden' name='is_validate_weight_on_admission' id='is_validate_weight_on_admission' value='<%=is_validate_weight_on_admission%>'/> 
					<input type='hidden' name='weight_on_admission_unit' id='weight_on_admission_unit' value='<%=weight_on_admission_unit%>'/> 
					<input type='hidden' name='is_value_already_captured' id='is_value_already_captured' value='<%=is_value_already_captured%>'/>
					</td>
				<!-- Added by Dharma on Oct 29th against HSA-CRF-0181 [IN:049541] End -->
				<!-- Added by KAMATCHI S for ML-MMOH-CRF-1527 ON 23-JUN-2020-->
				<%
					if(isHeightAndBmiEnable){
						
					if(enable_height_bmi_pat_cls.equals(patient_class)|| enable_height_bmi_pat_cls.equals("ID")) 
					{
						
				%>
				<td class='label' ><fmt:message key="eIP.HeightOnAdmission.label" bundle="${ip_labels}"/> </td>
				<td class='QUERYDATA' > 
				<input type='text' name="height_on_admission" id="height_on_admission"      
				onKeyPress='return allowValidNumber(this,event,3,3);' onblur=" allowValidNumber(this,event,3,3);return fillDecimal(this,3,3);" onfocusout="calculateBmi();" maxlength=7  value="<%=height_on_admission%>" > &nbsp;<%=height_on_admission_unit%> <%if(is_validate_height_on_admission.equals("Y")) {%><img align="center" src="../../eCommon/images/mandatory.gif"><%}%> 
				</td>
		
		
				<td class='label' ><fmt:message key="Common.BMI.label" bundle="${common_labels}"/> </td>
				<td class='QUERYDATA' > <input type='text' id="bmi" name="bmi" id="bmi"   size=15   maxlength=7  value="<%=bmi%>" readonly ></td>
			
				<%}}else{%>
				<td  class='label' >&nbsp;</td>
				<td  class='QUERYDATA'   >&nbsp;</td>
				<%}%>
				</tr>
				<!-- Added by Dharma on Oct 29th against HSA-CRF-0181 [IN:049541] End -->
				<input type='hidden' name='is_validate_height_on_admission' id='is_validate_height_on_admission' value='<%=is_validate_height_on_admission%>'/> 
				<input type='hidden' name='height_on_admission_unit' id='height_on_admission_unit' value='<%=height_on_admission_unit%>'/>
				<input type='hidden' name='enable_height_bmi_pat_cls' id='enable_height_bmi_pat_cls' value='<%=enable_height_bmi_pat_cls%>'/>
				<input type='hidden' name='is_value_already_captured_height' id='is_value_already_captured_height' value='<%=is_value_already_captured_height%>'/>
				<!-- Added by KAMATCHI S for ML-MMOH-CRF-1527 ON 23-JUN-2020-->
			
				<td <%if(!isHeightAndBmiEnable){%>colspan = '4'<%}else{%>colspan = '7'<%}%> class='COLUMNHEADER' ><fmt:message key="Common.NursingUnitDetails.label" bundle="${common_labels}"/></td>
				<tr>
				<td  class='label' ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
				<td  class='QUERYDATA'   ><%=nursingunitshortdesc%></td>
				<td  class='label' ><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
				<td  class='QUERYDATA'   ><%=serviceshortdesc%></td>
			</tr>
			<tr>
				<td  class='label' ><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>
				<td  class='QUERYDATA'   ><%=bedno%></td>
				<td  class='label' ><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/></td>
				<td  class='QUERYDATA'   ><%=roomno%></td>
			</tr>
			<tr>
				<td  class='label' ><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></td>
				<td  class='QUERYDATA'   ><%=bedclassshortdesc%></td>
				<td  class='label' ><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/></td>
				<td  class='QUERYDATA'   ><%=bed_type_desc%></td>
			</tr>
			<!--Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013-->
			<!--Start-->
			<%if(mds_chk!=0){%>
			<tr>
				<td  class='label' ><fmt:message key="eMR.MDS.label" bundle="${mr_labels}"/></td>
				<%if(mr_mds_recorded.equals("Y"))
					{%>
				<td  class='QUERYDATA'><font color='RED'><fmt:message key="Common.CriteriaMet.label" bundle="${common_labels}"/></font></td>
				<%}
				else{%>
				<td  class='QUERYDATA'><font color='RED'><fmt:message key="Common.CriteriaNotMet.label" bundle="${common_labels}"/></font>&nbsp;<font color='blue'><a href='javascript:onclick=MDSCompliance(parent.frames[1].document.forms[0].mr_mds_recorded.value)' style='text-decoration:underline'><fmt:message key="Common.Check.label" bundle="${common_labels}"/></a></font></td>
				<%}%>
				<td  class='label' ></td>
				<td  class='QUERYDATA'></td>
			</tr>
			<%}%>
			<!--End-->
		</table>
<div  id='readOnlyDiv'  style="visibility:hidden;z-index:3;position:absolute;top:0px;width:100vw;height:600px;background-color:#CCCCCC;filter:alpha(opacity=80);" >
</div>
		<input type='hidden' name='query_string' id='query_string' value='<%=query_string%>' >
		<input type='hidden' name='mds_chk' id='mds_chk' value="<%=mds_chk%>">
		<input type='hidden' name='mr_mds_recorded' id='mr_mds_recorded' value="<%=mr_mds_recorded%>"><!--Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013-->
	</form>
</BODY>
</HTML>

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

