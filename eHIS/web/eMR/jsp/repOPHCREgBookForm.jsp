<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
    Connection con =null;
	String facility_id = (String) session.getValue("facility_id");
    String resp_id=(String) session.getValue("responsibility_id");
	String user_id = (String) session.getValue("login_user");

try {

    con=ConnectionManager.getConnection(request);

%>

<body  OnMouseDown="CodeArrest()" onLoad="FocusFirstElement()"  onKeyDown = 'lockKey()'>
<form name="MROPBKHC" id="MROPBKHC" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR><BR><BR><BR>
<table border="0" width='80%' cellpadding="0" cellspacing="0"  align='center'>
		<tr>
			<td align="center" width="35%">&nbsp;</td>
			<td class="querydata" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td class="querydata" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		</tr>
	    <tr>
			<td align='right' width='30%' class="label"><fmt:message key="Common.RegnDate.label" bundle="${common_labels}"/> &nbsp;</td>
			<td><input type='text' id='birthfrom' name='P_FM_DATE' id='P_FM_DATE' size='10' onBlur='CheckDate(this)' maxLength='10'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('birthfrom');"/>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></td>

			<td><input type='text' id='birthto' name='P_TO_DATE' id='P_TO_DATE' size='10' onBlur='CheckDate(this)' maxLength='10'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('birthto');"/>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></td>
	   </tr>
    <tr>
		<td colspan=3>&nbsp;</td>
	</tr>
   </table>


<input type="hidden" name="p_module_id" id="p_module_id" 		value="MR">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="MROPBKHC">
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=user_id%>">
<input type="hidden" name="P_RESP_ID" id="P_RESP_ID"		value="<%=resp_id%>">
<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
</form>
</body>
</html>
<%
} catch(Exception e) {  /* out.println("in else "+e); */ e.printStackTrace();}
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

