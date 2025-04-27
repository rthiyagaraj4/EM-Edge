<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page  import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="alTrayDiscrepancyList" scope="session" class="java.util.ArrayList"/>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
	<script language='javascript' src='../../eCommon/js/common.js' ></script>
</head>
<%
	alTrayDiscrepancyList.clear();
%>

	<frameset rows='50,*'>
		<frame name='frameTrayDiscrepancyHeader'				src="../../eSS/jsp/TrayDiscrepancyHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize>
		<frameset cols="51%,*" >
			<frame name='frameTrayDiscrepancyDetail'			src="../../eSS/jsp/TrayDiscrepancyDetail.jsp?<%=request.getQueryString()%>"					frameborder=0 scrolling='no'   noresize>
				<frame name='frameTrayDiscrepancyList'			src="../../eSS/jsp/TrayDiscrepancyList.jsp?<%=request.getQueryString()%>"					frameborder=0 scrolling='auto' noresize>
			</frameset>
	</frameset>
</html>
