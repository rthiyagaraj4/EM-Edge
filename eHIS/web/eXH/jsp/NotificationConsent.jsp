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
<script language="javascript" src="${path}../eXH/js/NotificationConsent.js"></script>
<script src='${path}../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</HEAD>

<BODY LEFTMARGIN="0" TOPMARGIN="0" onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad="init()">
<FORM ID="notificationConsentInfo" name="notificationConsentInfo" id="notificationConsentInfo" METHOD="post" TARGET="messageFrame" ACTION='${path}../servlet/eXH.NotificationConsentServlet'>

<c:if test="${mode == 'U'}">
	<c:set var="disable" value="DISABLED"/>
</c:if>

<TABLE CELLSPACING="0" CELLPADDING="3" ALIGN="center">
<TR>
	<TD CLASS=label>Recipient Type</TD>
	<TD CLASS="fields">
		<SELECT name="recipientType" id="recipientType" ID="recipientType">
		<% System.out.println("type " + request.getAttribute("recipientTypes")); %>
		<c:forEach var="recipientType" items="${recipientTypes}">
			<OPTION VALUE="${recipientType.key}" ${recipientType.key == notificationConsentInfo['recipientType'] ? 'SELECTED' : ''}>${recipientType.value}</OPTION>
		</c:forEach>
		</SELECT>
	</TD>
	<TD CLASS="label">Patient ID</TD>
	<TD CLASS="fields">
		<INPUT TYPE="text" ID="patientID" name="patientID" id="patientID" onBlur="if(this.value != '') searchFiltergroupType(); else Filter_group_desc_id.value = '' ">	     
		<INPUT CLASS="button" TYPE="button"  name='patientSearch' id='patientSearch' VALUE='?' onClick="searchFiltergroupType();"> <IMG SRC='../../eCommon/images/mandatory.gif'>
	</TD>
	<TD CLASS="label">Status</TD>
	<TD CLASS="fields">
		<INPUT TYPE="checkbox" name="effStatus" id="effStatus" VALUE="E" ${notificationConsentInfo['status']}>
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

