<!DOCTYPE html>

<%@ page import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="alAckDiscrepancyList" scope="session" class="java.util.ArrayList"/><!-- Added for TH-KW-CRF-0026 -->
<html>
	<head>
		<title> </title> 
		<meta name="Author" content="Mahesh">
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="JavaScript" src="../../eSS/js/SsCommon.js"></script>
		<script language="JavaScript" src="../../eSS/js/SSAcknowledgment.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
		<%
		alAckDiscrepancyList.clear();//Added for TH-KW-CRF-0026
		String locale			= (String)session.getAttribute("LOCALE");
		eSS.SSAcknowledgementBean bean = (eSS.SSAcknowledgementBean)getBeanObject( "SSAcknowledgementBean","eSS.SSAcknowledgementBean",request );
		bean.setLanguageId(locale);
		

%>
<iframe name='AcknowledgeHeaderframe' id='AcknowledgeHeaderframe'	src="../../eSS/jsp/SSAcknowledgmentHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:13%;width:100vw'></iframe>
		<iframe name='AcknowledgeDetailframe' id='AcknowledgeDetailframe'	src="../../eCommon/html/blank.html" frameborder=0 scrolling='auto'   noresize style='height:50%;width:100vw'></iframe>
		<iframe name='AcknowledgeListframe' id='AcknowledgeListframe'		src="../../eCommon/html/blank.html" frameborder=0 scrolling='auto' noresize style='height:100vh;width:100vw'></iframe>
	
</html>

