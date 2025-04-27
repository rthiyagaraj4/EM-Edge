<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>

<html>
<title><fmt:message key="eOA.Viewaudittrial.label" bundle="${common_labels}"/></title>

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
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String params = request.getQueryString() ;
%>
<iframe name='frame1' id='frame1' 	src='../../eOA/jsp/ViewAuditTrialCriteria.jsp?<%=params%>' frameborder=0  scrolling='no' style='height:4vh;width:100vw'></iframe>
<iframe name='frame2' id='frame2' 	src='../../eOA/jsp/ViewAuditTrial.jsp?<%=params%>' frameborder=0 scrolling='auto' style='height:96vh;width:100vw'></iframe>
</html>


