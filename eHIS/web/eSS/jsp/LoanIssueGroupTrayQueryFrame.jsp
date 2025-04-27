<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eSS.*"contentType="text/html;charset=UTF-8"%>  
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
	<head>
<%
			request.setCharacterEncoding("UTF-8");
			String sStyle		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 %>
	   <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	   	<script language="javascript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title><fmt:message key="eSS.TraySearch.label" bundle="${ss_labels}"/>		</title>
	</head>
<iframe name='frameLoanIssueGroupTrayQueryCriteria' id='frameLoanIssueGroupTrayQueryCriteria' src="../../eSS/jsp/LoanIssueGroupTrayQueryCriteria.jsp?<%=request.getQueryString()%>" frameborder=0  scrolling='no' style='height:75%;width:100vw'></iframe><iframe name='frameLoanIssueGroupTrayQueryResult' id='frameLoanIssueGroupTrayQueryResult' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:100vh;width:100vw'></iframe>
</html>

