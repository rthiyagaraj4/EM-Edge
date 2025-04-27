<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" );
   	String currentdate = dateFormat.format(new java.util.Date()) ;

	SimpleDateFormat monthFormat = new SimpleDateFormat( "MM/yyyy" );
   	String currentmonth = monthFormat.format(new java.util.Date()) ;

	SimpleDateFormat yearFormat = new SimpleDateFormat( "yyyy" );
   	String currentyear = yearFormat.format(new java.util.Date()) ;

    Connection con		= null;
	String p_module_id	= "MR" ;
	String report_id	= "";
	String facility_id	= (String) session.getValue("facility_id");
    String resp_id		= (String) session.getValue("responsibility_id");
	String user_id		= (String) session.getValue("login_user");
	String locale		= (String)session.getAttribute("LOCALE");
	
try 
{
	con = ConnectionManager.getConnection(request);
%>
<html>

<head>

<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/DateUtils.js"></script>
<script src="../../eMR/js/MRReports.js"></script>
<script src="../../eMR/js/DelRecBHTReport.js"></script>

</head>

<body OnMouseDown="CodeArrest();" onLoad="FocusFirstElement();datechange();" onKeyDown = 'lockKey();'>

<form name="DelRecBHTReportForm" id="DelRecBHTReportForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">

<BR><BR><BR><BR>

<table border="0" width='80%' cellpadding="0" cellspacing="0"  align='center'>

<th align='left' colspan='3'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>

<tr>
	<td width="80%" class="Border" align='center'>

	<table width='60%' cellPadding="0" cellSpacing="0"  align='center' >

		<tr>
			<td width='25%'>&nbsp;</td>
			<td width='25%'></td>
			<td colspan ='2'></td>
		</tr>

		<tr>
			<td class="label" width='25%'><fmt:message key="Common.encounter.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
			<td class='fields' width='25%'>
				<input type="text" style="font-weight:bold;" name="encounter_type" id="encounter_type" value="Inpatient" size="10" Disabled><input type="hidden" name="p_encounter_type" id="p_encounter_type" value="Inpatient">
			</td>

			<td class="label" width='25%'><fmt:message key="Common.report.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
			<td class='fields' width='25%' nowrap>
				<select name="p_report_type" id="p_report_type" onchange='onReportTypeChange();'>
					<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
					<option value="W"><fmt:message key="Common.by.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Ward.label" bundle="${common_labels}"/></option>
					<option value="S"><fmt:message key="Common.by.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.speciality.label" bundle="${common_labels}"/></option>
					<option value="H"><fmt:message key="Common.by.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Hospital.label" bundle="${common_labels}"/></option>	
				</select>
				<img src='../../eCommon/images/mandatory.gif' id='mand_rep_type' align='center'></img>
			</td>
		</tr>

		<tr>
			<td class="label" width='25%'>&nbsp;</td>
			<td width='25%'></td>
			<td colspan ='2'></td>
		</tr>

		<tr>
			<td class="label" width='25%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td class="fields" width='25%'>
				<input type='text' id='from_speciality' name='from_speciality' id='from_speciality' size='15' maxLength='15' OnBlur="BeforesearchCodeSpec(fromSpecialty,this)"><input type='button' name='fromSpecialty' id='fromSpecialty' value='?' class='button' onclick="searchCodeSpec(this,from_speciality)"><input type="hidden" name="p_fr_specialty_code" id="p_fr_specialty_code" id='p_fr_specialty_code'>
				<img src='../../eCommon/images/mandatory.gif' id='mand_spec' align='center' style="visibility:hidden"></img>
			</td>
		</tr>

		<tr>
			<td class="label" width='25%'>&nbsp;</td>
			<td width='25%'></td>
			<td colspan ='2'></td>
		</tr>

		<tr>
			<td class="label" width='25%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<td class="fields" width='25%'>
				<input type='text' id='from_locn' name='from_locn' id='from_locn' size='15' maxLength='15' OnBlur="BeforesearchCodeLocn(locn,this)"><input type='button' name='locn' id='locn' value='?' class='button' onclick="searchCodeLocn(this,from_locn)"><input type="hidden" name="p_fm_loc_code" id="p_fm_loc_code" id='p_fm_loc_code'>
				<img src='../../eCommon/images/mandatory.gif' id='mand_locn' align='center' style="visibility:hidden"></img>
			</td>
		</tr>

		<tr>
			<td class="label" width='25%'>&nbsp;</td>
			<td width='25%'></td>
			<td colspan ='2'></td>
		</tr>

		<tr>
			<td class="label" width='25%'><fmt:message key="Common.report.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.by.label" bundle="${common_labels}"/></td>
			<td class="fields" width='25%'>
				<select name="p_report_by" id="p_report_by" onchange='datechange();' disabled>
					<option value="M"><fmt:message key="Common.month.label" bundle="${common_labels}"/></option>
					<option value="Y"><fmt:message key="Common.year.label" bundle="${common_labels}"/></option>
				</select>
			</td>
		</tr>

		<tr>
			<td class="label" width='25%'>&nbsp;</td>
			<td width='25%'></td>
			<td colspan ='2'></td>
		</tr>
                 
        <tr>
			<td class="label" width='25%' id='MY_label'>&nbsp;</td>
			<td width='25%' class="fields" id='MY_frm'>&nbsp;</td>
		</tr>
			
		<tr>
			<td class="label" width='25%'>&nbsp;</td>
			<td width='25%'></td>
			<td colspan ='2'></td>
		</tr>

	</table>
	
	</td>

</tr>

</table>

<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%=p_module_id%>">
<input type="hidden" name="p_report_id" id="p_report_id" 	value="<%=report_id%>">
<input type="hidden" name="p_user_id" id="p_user_id"		value="<%=user_id%>">
<input type="hidden" name="p_resp_id" id="p_resp_id"		value="<%=resp_id%>">
<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>">
<input type="hidden" name="p_current_date" id="p_current_date"	value="<%=currentdate%>">
<input type="hidden" name="p_current_month" id="p_current_month"	value="<%=currentmonth%>">
<input type="hidden" name="p_current_year" id="p_current_year"	value="<%=currentyear%>">

</form>
</body> 
</html>

<%
}catch(Exception e){  
	e.printStackTrace();
}finally{
	ConnectionManager.returnConnection(con,request);
}
%>

<%!
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>

