<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.sql.*, java.util.*, java.text.*" %>
<%-- JSP Page specific attributes end --%>
<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="JavaScript" src="../../eOR/js/OrderEntry1.js"></script>
<script language="JavaScript" src="../../eOR/js/OrderEntryTab.js"></script>

<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String hdg_name			=	request.getParameter("hdg_name");
	if(hdg_name==null)	hdg_name	= "";
%>
<title>
	Reason for Rapid Orders
</title>
</head>
<body style="background-color:#E2E3F0;" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="rapidReason" id="rapidReason">
<table width='100%' border='0' cellspacing='0' cellpadding='0' align=center>
	<tr>
		<td align='left' class='label' width='10%'></td>
	</tr>
	<tr>
		<td align='left' width='90%' class='label'>&nbsp;&nbsp;<textarea name="comments" rows="5" cols="60" onBlur="makeValidString(this)"></textarea></td>
	</tr>
	<tr><td class="label">&nbsp;</td>
	<tr>
	<tr><td class="DATA" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			Do you want to Place an Rapid Order</td></tr>
	<td class='label' align="left">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Press   <b>OK </b>      to Place an Order.. <br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Press   <b>Cancel</b>   to enter/modify Additional Information
		</td>
	</tr>
</table>
<table width='100%' border='0' cellspacing='0' cellpadding='0' align=center>
	<tr>
		<td class="label" align="right"><input type='Button' class='Button' name='Ok' id='Ok' value='    OK    ' onclick='doRapidClose()'>&nbsp;<input type='Button' class='Button' name='Cancel' id='Cancel' value='    Cancel    ' onclick='doRapidCancel()'>
		</td>
	</tr>
</table>
</form>
</body>
</html>

