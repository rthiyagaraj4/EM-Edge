<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
		<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>

  <table border=0 cellspacing=0 width='100%' cellpadding='0' align ='center'>
  <tr>
		<td width="1%" >&nbsp;</td>
		<td width="1%" class='label'><font size=1>&nbsp;&nbsp;<b> &nbsp; </b></font></td>
 
		<td width="1%" style='background-color:#FF0066;'>&nbsp;</td>
		<td width="7%" class='label'><font size=1>&nbsp;&nbsp;<b><fmt:message key="eFM.CancelledBooking.label" bundle="${fm_labels}"/> </b></font></td>

		<td width="1%" style='background-color:#FF66FF'>&nbsp;</td>
		<td width="8%" class='label'><font size=1>&nbsp;&nbsp;<b> <fmt:message key="Common.revisebooking.label" bundle="${common_labels}"/></b></font></td>

		<td width="1%" style='background-color:skyblue;'>&nbsp;</td>

		<!-- <td width="7%" class='label'><font size=1>&nbsp;&nbsp;<b> <fmt:message key="eFM.ConfirmedFiles.label" bundle="${fm_labels}"/></b></font></td> -->

		<td width="7%" class='label'><font size=1>&nbsp;&nbsp;<b> <fmt:message key="eFM.ConfirmPullingList.label" bundle="${fm_labels}"/></b></font></td>

		<td width="1%" style='background-color:lightgreen;'>&nbsp;</td>
		<td width="7%" class='label'><font size=1>&nbsp;&nbsp;<b> <fmt:message key="eFM.FileOutsideMRD.label" bundle="${fm_labels}"/></b></font></td>

	</tr>
 	</table>	
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

