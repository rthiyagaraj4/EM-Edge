<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eXH/jsp/CommonInclude.jsp"%>
<HEAD> 
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
sStyle = "IeStyle.css";
%>

<c:if test="${param.mode == 'I'}">
	<c:set var="path" value="../"/>
</c:if>

<link rel='StyleSheet' href='${path}../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="javascript" src="${path}../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="${path}../eXH/js/Validate.js" ></script>
<script language="javascript" src="${path}../eCommon/js/common.js" ></script>
<script Language="JavaScript" src="${path}../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="${path}../eCommon/js/jquery-3.6.3.js"></script>
<script language="javascript" src="${path}../eXH/js/NotificationRecipient.js"></script>
</HEAD>

<BODY LEFTMARGIN="0" TOPMARGIN="0" onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad="init()">
<FORM ID="recipientInfo" name="recipientInfo" id="recipientInfo" METHOD="post" TARGET="messageFrame" ACTION='${path}../servlet/eXH.NotificationRecipientServlet'>

<c:if test="${mode == 'U'}">
	<c:set var="disable" value="DISABLED"/>
</c:if>

<TABLE CELLSPACING="0" CELLPADDING="3" ALIGN="center">
<TR>
	<TD CLASS=label>Recipient ID</TD>
	<TD CLASS="fields">
		<INPUT TYPE="text" name="recipientID" id="recipientID" ID="recipientID" VALUE="${recipientInfo['recipientID']}" ${disable}>
		<IMG SRC='${path}../eCommon/images/mandatory.gif'>
	</TD>
</TR>
<TR>
	<TD CLASS="label">Short Desc</TD>
	<TD CLASS="fields">
		<INPUT TYPE="text" name="shortDesc" id="shortDesc" ID="shortDesc" VALUE="${recipientInfo['shortDesc']}">
		<IMG SRC='${path}../eCommon/images/mandatory.gif'>
	</TD>
</TR>
<TR>
	<TD CLASS="label">Long Desc</TD>
	<TD CLASS="fields"><INPUT TYPE="text" name="longDesc" id="longDesc" ID="longDesc" VALUE="${recipientInfo['longDesc']}"></TD>
</TR>
<TR>
	<TD CLASS="label">Communication Mode</TD>
	<TD CLASS="fields"><INPUT TYPE="text" name="communicationMode" id="communicationMode" ID="communicationMode" VALUE="${recipientInfo['communicationMode']}"></TD>
</TR>
<TR>
	<TD CLASS="label">Contact Type</TD>
	<TD CLASS="fields"><INPUT TYPE="text" name="contactTypeCode" id="contactTypeCode" ID="contactTypeCode" VALUE="${recipientInfo['contactTypeCode']}"></TD>
</TR>
<TR>
	<TD CLASS="label">Country Code</TD>
	<TD CLASS="fields"><INPUT TYPE="text" name="countryCode" id="countryCode" ID="countryCode" VALUE="${recipientInfo['countryCode']}"></TD>
</TR>
<TR>
	<TD CLASS="label">Mail IDs</TD>
	<TD CLASS="fields"><INPUT TYPE="text" name="toMailIDs" id="toMailIDs" ID="toMailIDs" VALUE="${recipientInfo['toMailIDs']}"></TD>
</TR>
<TR>
	<TD CLASS="label">CC Mail IDs</TD>
	<TD CLASS="fields"><INPUT TYPE="text" name="ccMailIDs" id="ccMailIDs" ID="ccMailIDs" VALUE="${recipientInfo['ccMainIDs']}"></TD>
</TR>
<TR>
	<TD CLASS="label">BCC Mail IDs</TD>
	<TD CLASS="fields"><INPUT TYPE="text" name="bccMailIDs" id="bccMailIDs" ID="bccMailIDs" VALUE="${recipientInfo['bccMailIDs']}"></TD>
</TR>
<TR>
	<TD CLASS="label">Phone Nos</TD>
	<TD CLASS="fields"><INPUT TYPE="text" name="toPhoneNos" id="toPhoneNos" ID="toPhoneNos" VALUE="${recipientInfo['toPhoneNos']}"></TD>
</TR>
<TR>
	<TD CLASS="label">Alternate Phone Nos</TD>
	<TD CLASS="fields"><INPUT TYPE="text" name="toAltPhoneNos" id="toAltPhoneNos" ID="toAltPhoneNos" VALUE="${recipientInfo['toAltPhoneNos']}"></TD>
</TR>
<TR>
	<TD CLASS="label">Alternate Mobile Nos</TD>
	<TD CLASS="fields"><INPUT TYPE="text" name="toAltMobileNos" id="toAltMobileNos" ID="toAltMobileNos" VALUE="${recipientInfo['toAltMobileNos']}"></TD>
</TR>
<TR>
	<TD CLASS="label">Mobile Nos</TD>
	<TD CLASS="fields"><INPUT TYPE="text" name="toMobileNos" id="toMobileNos" ID="toMobileNos" VALUE="${recipientInfo['toMobileNos']}"></TD>
</TR>
</TABLE>

<INPUT TYPE='hidden' name='mode' id='mode' ID='mode' VALUE="${mode}">
<INPUT TYPE='hidden' name='requestType' id='requestType' ID='requestType' VALUE="SAVE">
<c:if test="${mode == 'U'}">
<INPUT TYPE='hidden' name="recipientID" id="recipientID" ID="recipientID" VALUE="${recipientInfo['recipientID']}">
</c:if>
</FORM>
</BODY>
</HTML>

