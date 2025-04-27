<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<HEAD>
	<TITLE><fmt:message key="eFM.OutstandingRequestSearchCriteria.label" bundle="${fm_labels}"/></TITLE>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eFM/js/FMIssueFiles.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<%
	request.setCharacterEncoding("UTF-8");
String userSecurity  = request.getParameter("userSecurity")==null?"":request.getParameter("userSecurity");
String access_all  = request.getParameter("access_all")==null?"":request.getParameter("access_all");
%>
<iframe name="dataFrame" id="dataFrame" SRC="FMIssueFileSearchCriteria.jsp?access_all=<%=access_all%>&userSecurity=<%=userSecurity%>" FRAMEBORDER="0" SCROLLING="no" NORESIZE style="height:100vh;width:100vw"></iframe>
	<iframe name="staticFrame" id="staticFrame" SRC="../../eCommon/html/blank.html" FRAMEBORDER="0" SCROLLING="no" NORESIZE style="height:0%;width:100vw"></iframe>

</HTML>

