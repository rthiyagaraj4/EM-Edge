<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="eSS.*" contentType="text/html;charset=UTF-8"%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<title><fmt:message key="eSS.TraySearch.label" bundle="${ss_labels}"/>
		</title>
	</head>
	<iframe name='frameTrayDiscrepancyTrayQueryCriteria' id='frameTrayDiscrepancyTrayQueryCriteria' src='../../eSS/jsp/TrayDiscrepancyTrayQueryCriteria.jsp?<%=request.getQueryString()%>' frameborder=0  scrolling='no' style='height:10vh;width:100vw'></iframe>
	<iframe name='frameTrayDiscrepancyTrayQueryResult' id='frameTrayDiscrepancyTrayQueryResult' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:85vh;width:100vw'></iframe>
</html>

