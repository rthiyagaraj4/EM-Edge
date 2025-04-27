<!DOCTYPE html>
<HTML>	     
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eXH/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String locale = ((String)session.getAttribute("LOCALE"));
%>
<HEAD>				    
<%	
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 					   
<link rel='StyleSheet' href='../eCommon/html/<%=sStyle%>'></link> 
<link rel='stylesheet' type ='text/css' href='../eCommon/html/Tabs.css'></link>	
<script language="javascript" src="../eCommon/js/common.js" ></script>								 
<script language="javascript" src="../eCommon/js/jquery-3.6.3.js" ></script>
<Script Language="JavaScript" src="../eCommon/js/CommonLookup.js"></Script>
<script Language="JavaScript" src="../eCommon/js/ValidateControl.js" ></script>
<SCRIPT LANGUAGE="javascript" SRC="../eXH/js/NotificationSettings.js"></SCRIPT>
<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY LEFTMARGIN="0" TOPMARGIN="0" onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<FORM ID="searchCriteria" name="searchCriteria" id="searchCriteria">

<TABLE CELLSPACING="0" CELLPADDING="3" WIDTH="100%" ALIGN="center">
<TR>
	<TD CLASS="label">Message Type</TD>
	<TD CLASS="fields">
		<SELECT ID="messageType" name="messageType" id="messageType" onChange="messageTypeChange()">
		<c:forEach var="messageType" items="${messageTypes}">
			<OPTION VALUE="${messageType.key}">${messageType.value}</OPTION>
		</c:forEach>
		</SELECT>
	</TD>
	<TD CLASS="label">Event Type</TD>
	<TD CLASS="fields">
		<SELECT ID="eventType" name="eventType" id="eventType" onChange="eventTypeChange()">
		<c:forEach var="eventType" items="${eventTypes}">
			<OPTION VALUE="${eventType.key}">${eventType.value}</OPTION>
		</c:forEach>
		</SELECT>
	</TD>
</TR>
</TABLE>
<INPUT TYPE='hidden' name='requestType' id='requestType' ID='requestType' VALUE="CRITERIA_CHANGE">
</FORM>
</BODY>
</HTML>

