<!DOCTYPE html>
<%@ page  language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
				|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
				%>
<title>Collection Reports</title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script type="text/javascript" src='../../eBL/js/BLCollectionReports.js' ></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<br>
<form name='frmCollectionReports' id='frmCollectionReports' method='post'>
<table width="80%" align="center">
<tr>
<td class='label'>
<input type="checkbox" name='outPatMed' id='outPatMed' id = 'outPatMed' value="BLRUT007"> &nbsp;&nbsp; Outpatient Medicine and Medical supply Report
</td>
</tr>
<tr>
<td class='label'>
<input type="checkbox" name='detMedicalSupp' id='detMedicalSupp' id = 'detMedicalSupp' value="BLRUT008"> &nbsp;&nbsp; Detail of Medical supply and Medication
</td>
</tr>

<tr>
<td class='label'>
<input type="checkbox" name='summIp' id='summIp' id = 'summIp' value="BLRUT009"> &nbsp;&nbsp; Summary of IP Medication
</td>
</tr>
<tr>
<td class='label'>
<input type="checkbox" name='summFinStmt' id='summFinStmt' id = 'summFinStmt' value="BLRUT010"> &nbsp;&nbsp; Summary Financial Statements of Medical Expenses
</td>
</tr>
<tr>
<td>
&nbsp;
</td>
</tr>
<tr>
<td>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" name='printBtn' id='printBtn' id="printBtn" value = 'Print' onclick="fnSendback()">
&nbsp;&nbsp;&nbsp;
<input type="button" name='cancelBtn' id='cancelBtn' id="cancelBtn" value = 'Cancel' onclick="fnClose()">
</td>
</tr>
</table>
</form>
</body>
</html>

