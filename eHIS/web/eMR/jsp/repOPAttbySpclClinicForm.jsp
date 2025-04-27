<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<%
    Connection con =null;

	String facility_id = (String) session.getValue("facility_id");
    String resp_id=(String) session.getValue("responsibility_id");
	String user_id = (String) session.getValue("login_user");

try {

    con=ConnectionManager.getConnection(request);

%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>

<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
	<script src="../../eMR/js/MRReports.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onLoad="mychangerepOPAtt()"  onKeyDown = 'lockKey()'>
<form name="MROPCSAT" id="MROPCSAT" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR><BR><BR><BR>
<table border="0" width='60%' cellpadding="0" cellspacing="0"  align='center'>
	<th align='left' colspan='3'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/> </th>
	<tr>
		<td colspan=3>&nbsp;</td>
	</tr>
	 <tr>
					<td align='right' width='35%' class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>&nbsp;</td>
					<td width='25%'>
						 <SELECT name="p_type" id="p_type" onchange='mychangerepOPAtt()'>
						 <option value="D"><fmt:message key="Common.daily.label" bundle="${common_labels}"/></option>
                         <option value="M"><fmt:message key="Common.monthly.label" bundle="${common_labels}"/></option>
						 <option value="Y"><fmt:message key="Common.Yearly.label" bundle="${common_labels}"/></option>
						 </SELECT>
					</td>
						 <td >&nbsp; </td>
				</tr>
						 <td colspan ='3'> 

				
			
    
				<tr>
					<td align='right' width='35%' class="label">&nbsp;</td>
					<td width='25%'  ></td>
					<td >&nbsp;</td>
				
				</tr>
				
				<td colspan ='3'></td>
				<tr>
			<td align="center" width="35%">&nbsp;</td>
			<td class="querydata" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td class="querydata" width="40%">&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
           </tr>
			
				<tr>
						<td align='right' id='MY1'class="label">&nbsp;</td>
						<td align='left' id='MY' > &nbsp; </td> 
					   <!-- <td align='right' id='MY2'class="label">&nbsp;</td> -->
						<td align='left' id='MY3' > &nbsp; </td>
				</tr>
				<tr>
					<td align='right' width='35%' class="label"> &nbsp;</td>
					<td width='25%'  ></td>
					<td>&nbsp;</td>
					
				</tr>
			

		 <tr>
					<td align='right' width='35%' class="label"><fmt:message key="Common.ReportBy.label" bundle="${common_labels}"/>&nbsp;</td>
					<td width='25%'>
						 <SELECT name="p_report_by" id="p_report_by" >
						 <option value="D"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></option>
                         <option value="S"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
						 </SELECT>
					</td>
						 <td >&nbsp; </td>
				</tr>

<tr>
					<td align='right' width='35%' class="label"> &nbsp;</td>
					<td width='25%'  ></td>
					<td>&nbsp;</td>
					
				</tr>
</table>
<input type="hidden" name="p_module_id" id="p_module_id" 		value="MR">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="MROPCSAT">
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=user_id%>">
<input type="hidden" name="P_RESP_ID" id="P_RESP_ID"		value="<%=resp_id%>">
<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
</form>
</body>
</html>
<%
} catch(Exception e) {  /* out.println("in else "+e); */e.printStackTrace();}
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

