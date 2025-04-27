<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 
<html>
<head>

<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String ssPrivUploadCount = request.getParameter("ssPrivUploadCount");
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eXB/js/ssMonDPReport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<html>
<TITLE>SS Privilege Data Validation</TITLE>
<BODY onMouseDown="CodeArrest();" onKeyDown = "lockKey();">
<form name="ssMonDPDataChk" id="ssMonDPDataChk" method='post'>
<table valign='top'>
	<tr>
		<td class='label'>
			Enter the No of Records Received From Social Security Office For Privilege Update:
		</td>		
		<td class='field'>
			<INPUT TYPE="text" ID="userSSPrivCount"/>
		</td>
		<td CLASS="button">
			<INPUT TYPE="button" VALUE='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="validatePrivCount();">
		</td>
	</tr>
</table>
<table valign='top'>
	<tr><td class='label'><FONT COLOR="RED"><B><U>Important Note:		</td></tr>
	<tr><td class='label'><FONT COLOR="RED">
		<FONT COLOR="RED">
		<B><U>If SS privilege of Existing 'SS Patients' is not available in Uploaded DATA FILE then privilege will be changed as 'Cash Payer'</B>
		</FONT>
		</td>
	</tr>	
</table>
<INPUT TYPE="hidden" name="ssPrivUploadCount" id="ssPrivUploadCount" VALUE="<%= ssPrivUploadCount %>">
</form>
</html>

