<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	
*	Created On		:	28 October 2005

--%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle		 =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	//String locale=		=		(String)session.getAttribute("LOCALE");

%>
<html>
<head>
	<script src="../../eCommon/js/common.js" language="JavaScript" ></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCP/js/OutcomeMeasures.js" language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title><fmt:message key="eCP.OutcomeEvaluationMeasures.label" bundle="${cp_labels}"/></title>
</head>
<%
		
		String err_num			=		request.getParameter("err_num");
		String params			=		request.getQueryString() ;
		if(err_num!=null){
		String err_value		=		request.getParameter("err_value");
		String outcome_code		=		request.getParameter("outcome_code");
%>
	<script>reloadmeasure('<%=err_value%>','<%=outcome_code%>');</script>
<%
		}else
		{
			//System.err.println("params in jsp "+params);
	
%>
<iframe name='f_query_header' id='f_query_header' 	src='../../eCP/jsp/OutcomeMeasuresHeader.jsp?<%=params%>' frameborder=0 noresize style='height:50%;width:100vw'></iframe>
	 <iframe name='f_query_detail' id='f_query_detail' src='../../eCP/jsp/OutcomeMeasuresDetail.jsp?<%=params%>' frameborder=0 noresize style='height:100vh;width:100vw'></iframe>
 
<%}%>
<body>
</body>
</html>

