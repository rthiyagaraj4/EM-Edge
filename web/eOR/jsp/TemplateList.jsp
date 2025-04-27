<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%

%>

<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>



	<script language="JavaScript" src="../js/OrCommon.js"></script>

	<script language="JavaScript" src="../js/Template.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
	<form name="templateOrderListForm" id="templateOrderListForm">
		<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
			<tr>
				<th width="15%">Template Type</th>
				<th width="20%">Title Text</th>
				<th width="20%">Discrete Measure</th>
				<th width="5%">Row Position</th>
				<th width="5%">Column Position</th>
				<th width="15%">Column Span</th>
				<th width="20%">Display Location </th>
			</tr>
			<tr>
				<td>1234567890</td>
				<td>1234567890</td>
				<td>1234567890</td>
				<td>67890</td>
				<td>67890</td>
				<td>67890</td>
				<td>67890</td>
			</tr>
		</table>
	</form>
</body>
</html>

