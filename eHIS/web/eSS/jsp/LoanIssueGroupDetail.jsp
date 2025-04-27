<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page  import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*,java.sql.*" contentType="text/html;charset=UTF-8"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="alLoanIssueGroupList" scope="session" class="java.util.ArrayList"/>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">
<%
			request.setCharacterEncoding("UTF-8");
			String locale			= (String)session.getAttribute("LOCALE");
			String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	    <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/LoanIssueGroup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<body>
<%
	LoanIssueGroupListBean bean			=		(LoanIssueGroupListBean)getBeanObject( "LoanIssueGroupListBean",  "eSS.LoanIssueGroupListBean",request );  
	bean.clear();
	String mode								=		request.getParameter( "mode" ) ;
	String function_id						=		request.getParameter( "function_id" ) ;
	
	
	String disabled					=		"";
	String index					=		bean.checkForNull(request.getParameter("index"),"-1");
	
	if(!index.equals("-1")) {
		bean.initialize((HashMap)alLoanIssueGroupList.get(Integer.parseInt(index)));
	}
	else if(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) {	
		disabled					=		"disabled";
	}else{
		disabled="";
	}
%>

	<body onMouseDown="CodeArrest();" >
		<form name="formLoanIssueGroupDetail" id="formLoanIssueGroupDetail" >
		</form>
	</body>
</html>
<%
	putObjectInBean( "LoanIssueGroupListBean",  bean,request);
%>

