<!DOCTYPE html>
 <%@ page contentType="text/html;charset=UTF-8" import=" java.text.*, java.util.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title> </title>
<!-- 		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->	<%
		request.setCharacterEncoding("UTF-8");
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../eST/js/StMessages.js"></script> -->
		<script language="JavaScript" src="../../eST/js/ChangeExpiryFlag.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<iframe name='frameChangeExpiryFlagHeader' id='frameChangeExpiryFlagHeader'				src="../../eST/jsp/ChangeExpiryFlagHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:24vh;width:100vw'></iframe>
		<iframe name='frameChangeExpiryFlagTabs' id='frameChangeExpiryFlagTabs' src="../../eCommon/html/blank.html?<%=request.getQueryString()%>"					frameborder=0 scrolling='no'   noresize style='height:5vh;width:100vw'></iframe>
		<iframe name='frameChangeExpiryFlagDetail' id='frameChangeExpiryFlagDetail'			src="../../eCommon/html/blank.html?<%=request.getQueryString()%>"					frameborder=0 scrolling='auto'   noresize style='height:70vh;width:100vw'></iframe>
	
</html>

