<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="alLoanIssueGroupList" scope="session" class="java.util.ArrayList"/>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">
 <%
		 	request.setCharacterEncoding("UTF-8");
			String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	</head>
<%
	alLoanIssueGroupList.clear();
	String mod_qry_str   = request.getQueryString();
%>
	<!-- <frameset rows='100,*'>
		<frame name='frameLoanIssueGroupHeader' id='frameLoanIssueGroupHeader'	src="../../eSS/jsp/LoanIssueGroupHeader.jsp?<%=mod_qry_str%>" frameborder=0 scrolling='no'   noresize>
		<frameset cols="40%,*" >
			<frame name='frameLoanIssueGroupDetail' id='frameLoanIssueGroupDetail'	src="../../eSS/jsp/LoanIssueGroupDetail.jsp?<%=mod_qry_str%>"frameborder=0 scrolling='no'   noresize>
			<frameset rows="*">
				
				<frame name='frameLoanIssueGroupList' id='frameLoanIssueGroupList' src="../../eSS/jsp/LoanIssueGroupList.jsp?<%=mod_qry_str%>"	frameborder=0 scrolling='auto' noresize>
			</frameset>
		</frameset> -->
		<frameset rows="150,*">
	<frame name="frameLoanIssueGroupHeader" id="frameLoanIssueGroupHeader" frameborder="0" scrolling="no" noresize src="../../eSS/jsp/LoanIssueGroupHeader.jsp?<%=mod_qry_str%>">
	<frame name="frameLoanIssueGroupList" id="frameLoanIssueGroupList" src="../../eSS/jsp/LoanIssueGroupList.jsp?<%=mod_qry_str%>" frameborder="0" noresize scrolling="auto">
</frameset>

	</frameset>

</html>

