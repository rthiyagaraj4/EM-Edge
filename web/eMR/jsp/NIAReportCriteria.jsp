<!--Created by Ashwini on 03-May-2019 for ML-MMOH-CRF-1292-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% request.setCharacterEncoding("UTF-8"); %>
<%
    Connection con =null;
	String p_module_id	= "MR" ;
	String facility_id	= (String) session.getValue("facility_id");
    String resp_id		= (String) session.getValue("responsibility_id");
	String user_id		= (String) session.getValue("login_user");
	String locale		= (String)session.getAttribute("LOCALE");
	String report_id	= "MRNIAREP";
	SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" );
   	String currentdate = dateFormat.format(new java.util.Date()) ;
	
try 
{
	con=ConnectionManager.getConnection(request);
%>
<html>
<head>

<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/DateUtils.js"></script>
<script src="../../eMR/js/MRReports.js"></script>
<script src="../../eMR/js/NIAReport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<body OnMouseDown="CodeArrest();" onLoad="FocusFirstElement();datechange();" onKeyDown = 'lockKey();'>
<form name="NIAReportForm" id="NIAReportForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR><BR><BR><BR>
<table border="0" width='80%' cellpadding="0" cellspacing="0"  align='center'>

<th align='left' colspan='3'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/> </th>

<tr>
	<td width="100%" class="Border" align='center'>

	<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

		<tr>
			<td align='right' width='30%' class="label">  &nbsp;</td>
			<td width='25%'></td>
			<td colspan ='2'>
		</tr>

		<tr>
			<td align='right' width='30%' class="label"><fmt:message key="Common.Application.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
			<td class='fields'>
				<select name="appl_type" id="appl_type">
					<option value='' >---------<fmt:message key="Common.all.label" bundle="${common_labels}"/>---------</option>
					<option value="N"><fmt:message key="Common.Normal.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.report.label" bundle="${common_labels}"/></option>
					<option value="S"><fmt:message key="Common.specialist.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.report.label" bundle="${common_labels}"/></option>
					<option value="P"><fmt:message key="Common.Postmortem.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.report.label" bundle="${common_labels}"/></option>	
				</select>
			</td>
			<td colspan ='2'>
		</tr>

		<tr>
			<td align='right' width='30%' class="label">  &nbsp;</td>
			<td width='25%'></td>
			<td colspan ='2'>
		</tr>

		<tr>
			<td align='right' width='30%' class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>&nbsp;</td>
			<td width='25%' class="fields">
				<select name="report_type" id="report_type" onchange='datechange()'>
					<option value="M"><fmt:message key="Common.monthly.label" bundle="${common_labels}"/></option>
					<option value="Y"><fmt:message key="Common.Yearly.label" bundle="${common_labels}"/></option>
					<!-- Added By Dharma on 28th Jan 2021 against ML-MMOH-CRF-1593 Start -->
					<option value="6"><fmt:message key="eMR.JanToJune.label" bundle="${mr_labels}"/></option>
					<option value="12"><fmt:message key="eMR.JulyToDesc.label" bundle="${mr_labels}"/></option>
					<!-- Added By Dharma on 28th Jan 2021 against ML-MMOH-CRF-1593 End -->
				</select>
			</td>
			<td colspan ='2'>
		</tr>

		<tr>
			<td align='right' width='30%' class="label">  &nbsp;</td>
			<td width='25%'></td>
			<td colspan ='2'>
		</tr>
	
		<tr id='trFrmTo'>
			<td align="center" width="35%">&nbsp;</td>
			<td class="label" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td class="label" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		</tr>
                 
        <tr>
			<td align='right' id='MY_label'class="label"> &nbsp; </td>
			<td align='left' id='MY_frm'> &nbsp; </td>
			<td align='left' id='MY_to'> &nbsp; </td>
		</tr>
			
		<tr>
			<td align='right' width='30%' class="label">  &nbsp;</td>
			<td width='25%'></td>
			<td colspan ='2'>
		</tr>

	</table>
	
	</td>
</tr>
</table>

<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%=p_module_id%>">
<input type="hidden" name="p_report_id" id="p_report_id" 	value="<%=report_id%>">
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=user_id%>">
<input type="hidden" name="p_resp_id" id="p_resp_id"		value="<%=resp_id%>">
<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>">
<input type='hidden' name='current_date' id='current_date'	value= "<%=currentdate%>">
<input type='hidden' name='p_from_date_cn' id='p_from_date_cn'	value= "">
<input type='hidden' name='p_to_date_cn' id='p_to_date_cn'	value= "">
<input type='hidden' name='p_year_cn' id='p_year_cn'	value= "">
</form>
</body> 
</html>
<%
} catch(Exception e) {  
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
<%!
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

