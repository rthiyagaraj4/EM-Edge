<!DOCTYPE html>
<%-- Added by Rajesh V for MMS-CRF-0125
	This page contains the Add and Remove Buttons --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Button</title>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script language='javascript' src='../../eBL/js/PkgBulkUpdate.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
		$(document).ready(function(){
			$('#lookupBtn').click(function(){
				fnLookUp();
			});
			$('#addBtn').click(function(){
				fnAdd();
			});
			$('#removeBtn').click(function(){
				fnRemove();
			});
		})
	</script>
</head>
<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 	onSelect="codeArrestThruSelect();">
	<table width="100%" align="center">
		<tr>
			<td width='70%'>
			</td>
			<td  width='10%' style="display: none;">
				<input type='button' id='lookupBtn' name='lookupBtn' id='lookupBtn' class='button' value='Lookup'>
			</td>
			<td  width='10%'>
				<input type='button' id='addBtn' name='addBtn' id='addBtn' class='button' value='Add'>
			</td>
			<td  width='10%'>
				<input type='button' id='removeBtn' name='removeBtn' id='removeBtn' class='button' value='Remove'>
			</td>
		</tr>
	</table>
</body>
</html>

