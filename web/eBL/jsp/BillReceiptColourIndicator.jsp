<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Color Indicator Status</title>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css"; 
			
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<style>
	.billApproved{
		width: 50px;
		height: 12.5px;
		background: #52BD15;
	}
	.onHold{
		width: 50px;
		height: 12.5px;
		background: #5EF7ED;
	}
	.pending{
		width: 50px;
		height: 12.5px;
		background: #F2FA52;
	}
	.sent{
		width: 50px;
		height: 12.5px;
		background: #0C1EE8;
	}
	.rejected{
		width: 50px;
		height: 12.5px;
		background: #9F9FA1;
	}
	.clarification{
		width: 50px;
		height: 12.5px;
		background: #FC9DFC;
	}
</style>
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script>
$(document).ready(function(){
	$('#back').click(function(){
		window.close();
	});
});
</script>
</head>
<body>
	<br/>
	<table style="width: 90%;" align="center">
		<tr>
			<td style="width: 20%;">
				<span class='billApproved'>&nbsp;</span>
			<td style="width: 80%;" class='LABEL'>
				Approved
			</td>
		</tr>
		<tr>
			<td style="width: 20%;">
				<span class='onHold'>&nbsp;</span>
			<td style="width: 80%;" class='LABEL'>
				On Hold
			</td>
		</tr>
		<tr>
			<td style="width: 20%;">
				<span class='pending'>&nbsp;</span>
			<td style="width: 80%;" class='LABEL'>
				Pending
			</td>
		</tr>
		<tr>
			<td style="width: 20%;">
				<span class='sent'>&nbsp;</span>
			<td style="width: 80%;" class='LABEL'>
				Sent
			</td>
		</tr>
		<tr>
			<td style="width: 20%;">
				<span class='rejected'>&nbsp;</span>
			<td style="width: 80%;" class='LABEL'>
				Rejected
			</td>
		</tr>
		<tr>
			<td style="width: 20%;">
				<span class='clarification'>&nbsp;</span>
			<td style="width: 80%;" class='LABEL'>
				Clarification
			</td>
		</tr>
		<tr>
			<td colspan='2' align="right">
				<input type='button' name='back' id='back' id='back' value='Back'>
			</td>
		</tr>
	</table>
</body>
</html>

