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
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
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
<script language="javascript" src="${path}../eXH/js/NotificationTypeSetup.js"></script>
</HEAD>

<BODY LEFTMARGIN="0" TOPMARGIN="0" onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad="init()">
<FORM ID="notificationTypeInfo" name="notificationTypeInfo" id="notificationTypeInfo" METHOD="post" TARGET="messageFrame" ACTION='${path}../servlet/eXH.NotificationTypeSetupServlet'>

<c:if test="${mode == 'U'}">
	<c:set var="disable" value="DISABLED"/>
</c:if>

<TABLE CELLSPACING="0" CELLPADDING="3" ALIGN="center">
<TR>
	<TD CLASS=label>Type Code</TD>
	<TD CLASS="fields">
		<INPUT TYPE="text" name="typeCode" id="typeCode" ID="typeCode" VALUE="${notificationTypeInfo['typeCode']}" ${disable}>
		<IMG SRC='${path}../eCommon/images/mandatory.gif'>
	</TD>
</TR>
<TR>
	<TD CLASS="label">Short Desc</TD>
	<TD CLASS="fields">
		<INPUT TYPE="text" name="shortDesc" id="shortDesc" ID="shortDesc" VALUE="${notificationTypeInfo['shortDesc']}">
		<IMG SRC='${path}../eCommon/images/mandatory.gif'>
	</TD>
</TR>
<TR>
	<TD CLASS="label">Type Class</TD>
	<TD CLASS="fields"><INPUT TYPE="text" name="typeClass" id="typeClass" ID="typeClass" VALUE="${notificationTypeInfo['typeClass']}"></TD>
</TR>
<TR>
	<TD CLASS="label">Status</TD>
	<TD CLASS="fields">
		<INPUT TYPE="checkbox" name="effStatus" id="effStatus" VALUE="E" ${notificationTypeInfo['effStatus']}>
		<INPUT TYPE="hidden" name="effStatus" id="effStatus" VALUE="D">
	</TD>
</TR>

</TABLE>

<INPUT TYPE='hidden' name='mode' id='mode' ID='mode' VALUE="${mode}">
<INPUT TYPE='hidden' name='requestType' id='requestType' ID='requestType' VALUE="SAVE">
<c:if test="${mode == 'U'}">
<INPUT TYPE='hidden' name="typeCode" id="typeCode" ID="typeCode" VALUE="${notificationTypeInfo['typeCode']}">
</c:if>
</FORM>
</BODY>
</HTML>

