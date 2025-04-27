<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.text.*,webbeans.eCommon.*" %>

<html>
<title><fmt:message key="Common.AuditTrail.label" bundle="${common_labels}"/></title>

<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String params = request.getQueryString() ;
%>
<iframe name='frame1' id='frame1' 	src='../../eIP/jsp/ReferralRegAuditTrialResult.jsp?<%=params%>' frameborder=0  scrolling='no' style='height:80vh;width:100vw'></iframe><iframe name='frame1' id='frame1' 	src='../../eIP/jsp/ReferralRegAuditTrialButton.jsp' frameborder=0  scrolling='no' style='height:70%;width:100vw'></iframe>
</html>


