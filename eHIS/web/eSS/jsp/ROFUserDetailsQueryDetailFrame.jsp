<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="java.util.*, eSS.Common.*, eSS.*,java.util.*,java.sql.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<title><fmt:message key="eSS.SterilizationRequestUserDetail.label" bundle="${ss_labels}"/></title>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>	
		<script language="javascript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
	<%
		String params = request.getQueryString() ;
	%>
<iframe name="ROFDetailsDetailForDoc" id="ROFDetailsDetailForDoc" src="../../eSS/jsp/ROFUserDetailsQueryDetailForDoc.jsp?<%=params%>" frameborder=0 scrolling='no'   noresize style='height:79vh;width:99vw'></iframe>
		<iframe name="frameClose" id="frameClose" src="../../eSS/jsp/ROFDetailsQueryDetailClose.jsp" frameborder=0 scrolling='no'   noresize style='height:20vh;width:99vw'></iframe>

</html>

