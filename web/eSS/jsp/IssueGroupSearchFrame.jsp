<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" import=" java.text.*, java.util.*,java.lang.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<title><fmt:message key="eSS.GroupSearchAndSelect.label" bundle="${ss_labels}"/></title>
<!-- 		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->	
<%
		request.setCharacterEncoding("UTF-8");

		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";  

%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="JavaScript" src="../../eSS/js/SsCommon.js"></script>
		<script language="JavaScript" src="../../eSS/js/IssueGroup.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script> 
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<iframe name='frameIssueGroupSearchCriteria' id='frameIssueGroupSearchCriteria'			src="../../eSS/jsp/IssueGroupSearchCriteria.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:20%;width:100vw'></iframe>
		<iframe name='frameIssueGroupSearchResult' id='frameIssueGroupSearchResult'			src="../../eCommon/html/blank.html?<%=request.getQueryString()%>"					frameborder=0 scrolling='auto'   noresize style='height:100vh;width:100vw'></iframe>
	
</html>
 

