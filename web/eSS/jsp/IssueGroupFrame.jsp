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
<jsp:useBean id="alIssueGroupList" scope="session" class="java.util.ArrayList"/>
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
		
	alIssueGroupList.clear();
	String mod_qry_str   = request.getQueryString();
	 

%>
	<!-- <frameset rows='100,*'>
		<frame name='frameIssueGroupHeader' id='frameIssueGroupHeader'	src="../../eSS/jsp/IssueGroupHeader.jsp?<%=mod_qry_str%>" frameborder=0 scrolling='no'   noresize>
		<frameset cols="40%,*" >
			<frame name='frameIssueGroupDetail' id='frameIssueGroupDetail'	src="../../eSS/jsp/IssueGroupDetail.jsp?<%=mod_qry_str%>"frameborder=0 scrolling='no'   noresize>
			<frameset rows="*">
				
				<frame name='frameIssueGroupList' id='frameIssueGroupList' src="../../eSS/jsp/IssueGroupList.jsp?<%=mod_qry_str%>"	frameborder=0 scrolling='auto' noresize>
			</frameset>
		</frameset>

	</frameset> -->

<%-- <frameset rows="150,*">
	<frame name="frameIssueGroupHeader" id="frameIssueGroupHeader" frameborder="0" scrolling="no" noresize src="../../eSS/jsp/IssueGroupHeader.jsp?<%=mod_qry_str%>">
	<frame name="frameIssueGroupList" id="frameIssueGroupList" src="../../eSS/jsp/IssueGroupList.jsp?<%=mod_qry_str%>" frameborder="0" noresize scrolling="auto">
</frameset>
 --%>


 <iframe name="frameIssueGroupHeader" id="frameIssueGroupHeader" frameborder="0" scrolling="no" src="../../eSS/jsp/IssueGroupHeader.jsp?<%=mod_qry_str%>" style="width: 100vw; height: 20vh;"></iframe>
<iframe name="frameIssueGroupList" id="frameIssueGroupList" src="../../eSS/jsp/IssueGroupList.jsp?<%=mod_qry_str%>" frameborder="0" scrolling="auto" style="width: 100vw; height: 72vh;"></iframe>



</html>

