<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%
	//Connection con =null;   checkstyle unused variable
	String facility_id = (String) session.getAttribute("facility_id");
    String resp_id=(String) session.getAttribute("responsibility_id");
	String user_id = (String) session.getAttribute("login_user");
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


<script>
function callReportid(obj)
	{
		if(obj.value=="D")
		{
            document.forms[0].p_report_id.value="MRDCPROD";

		}
		else if(obj.value=="S")
		{
			document.forms[0].p_report_id.value="MRDCPROS";
		}

	}
</script>
</head>

<body  OnMouseDown="CodeArrest()" onLoad="FocusFirstElement();mychangerepDC207()"  onKeyDown = 'lockKey()'>
<form name="MRBRH207" id="MRBRH207" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR><BR><BR><BR>
<table border="0" width='60%' cellpadding="0" cellspacing="0"  align='center'>

<th align='left' colspan='3'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/> </th>

	<tr>
		<td colspan=3>&nbsp;</td>
	</tr>
	<tr>
		<td align='right' width='20%' class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>&nbsp;</td>
		<td width='25%'  >
			 <SELECT name="report_type" id="report_type" onchange='mychangerepDC207()'>
			  <option value="D"><fmt:message key="Common.daily.label" bundle="${common_labels}"/></option><!--Added by Suji Keerthi for ML-MMOH-CRF-1356 on Jan-22,2020-->
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
			
	</tr>
	<tr>
		<td colspan=3>&nbsp;</td>
	</tr>
	<tr>
		<td align='right' width='35%' class="label"><fmt:message key="Common.ReportBy.label" bundle="${common_labels}"/>&nbsp;</td>
		<td width='25%'>
		<SELECT name="p_type" id="p_type" onchange='callReportid(this)'>
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

<input type="hidden" name="p_module_id" id="p_module_id" 	value="MR">
<input type="hidden" name="p_report_id" id="p_report_id" 	value="MRDCPROD">
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=user_id%>">
<input type="hidden" name="P_RESP_ID" id="P_RESP_ID"		value="<%=resp_id%>">
<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">

</form>
</body>
</html>

