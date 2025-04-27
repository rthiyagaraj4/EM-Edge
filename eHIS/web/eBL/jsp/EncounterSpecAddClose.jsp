<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="javascript" src="../../eBL/js/EncounterSpecAddTable.js"></script>
<script language="javascript" src="../../eBL/js/EncounterSpecPolicyDefnSrch.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<form>
<table width='95%'>
<tr>
<td width='75%'></td>
<td align='right' width='6%'>
<input type='button' class="BUTTON" value='Lookup' onClick='fnShowPolicyDetailReport();'>
</td>
<td align='right' width='9%'>
<input type='button' class='BUTTON' value='Add' onclick='addRowNewAddClose()'></td>
<td align='right' width='5%'>
<input type='button' class='BUTTON' value='Remove' onclick='removeRowNewAddClose()'></td>
<td align='left' width='11%'> <input type='button' class='BUTTON' value='Close' onclick='saveAddClose()'></td>
</tr>
</table>
</form>
</body>
</html>

