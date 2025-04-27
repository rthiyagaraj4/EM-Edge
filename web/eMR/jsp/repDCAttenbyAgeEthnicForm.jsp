<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	Connection con =null;
	String facility_id = (String) session.getAttribute("facility_id");
    String resp_id=(String) session.getAttribute("responsibility_id");
	String user_id = (String) session.getAttribute("login_user");
try 
{
    con=ConnectionManager.getConnection(request);
%>
<html>
<head>
   <%String sStyle	=
   (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eMR/js/MRReports.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onLoad="FocusFirstElement();mychangerepDC212()"  onKeyDown = 'lockKey()'>
<form name="MRBRH212" id="MRBRH212" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR><BR><BR><BR>
<table border="0" width='60%' cellpadding="0" cellspacing="0"  align='center'>
<th align='left' colspan='3'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/> </th>
	<tr>
		<td colspan=3>&nbsp;</td>
	</tr>
	<tr>
		<td align='right' width='20%' class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>&nbsp;</td>
		<td width='25%'  >
			 <SELECT name="report_type" id="report_type" onchange='mychangerepDC212()'>
			  <option value="M"><fmt:message key="Common.month.label" bundle="${common_labels}"/></option>
			 <option value="Y"><fmt:message key="Common.year.label" bundle="${common_labels}"/></option>
			 </SELECT>
		</td>
	<td> &nbsp; </td>
	</tr>
	<tr>
		<td colspan=3>&nbsp;</td>
	</tr>
	<tr>
			<td align='right' id='MY1'class="label"> &nbsp; </td>
			<td align='left' id='MY' > &nbsp; </td>
			<td align='left' id='MY3' > &nbsp; </td>
	</tr>
	<tr>
		<td colspan=3>&nbsp;</td>
	</tr>

	<!--Added by Ashwini on 21-Oct-2019 for ML-MMOH-CRF-1357-->
	<tr>
		<td class="label" align="right"><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/></td>

		<td class='fields'><input type="text" name="p_fm_care_code" id="p_fm_care_code" size="4" maxlength="4" ><input type='button' name='nurse' id='nurse' value='?' class='button' onclick='searchNursingUnitCode(this, p_fm_care_code)'>
		</td>
		<td class='fields'><input type="text" name="p_to_care_code" id="p_to_care_code" size="4" maxlength="4"><input type='button' name='nurse' id='nurse' value='?' class='button' onclick='searchNursingUnitCode(this, p_to_care_code)'>
		</td>
	</tr>

	<tr>
		<td colspan=3>&nbsp;</td>
	</tr>

	<tr>
		<td align='right' width='35%' class="label"><fmt:message key="Common.ReportBy.label" bundle="${common_labels}"/>&nbsp;</td>
		<td width='25%'>
		<SELECT name="p_type" id="p_type" >
		<option value="D"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></option>
		<option value="S"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
		</SELECT>
		</td>
		<td >&nbsp; </td>
	</tr>
	<tr>
		<td colspan=3>&nbsp;</td>
	</tr>
</table>
<input type="hidden" name="p_module_id" id="p_module_id" 		value="MR">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="">
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=user_id%>">
<input type="hidden" name="P_RESP_ID" id="P_RESP_ID"		value="<%=resp_id%>">
<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
</form>
</body>
</html>
<%
} catch(Exception e) { /*  out.println("in else "+e); */e.printStackTrace();}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>


