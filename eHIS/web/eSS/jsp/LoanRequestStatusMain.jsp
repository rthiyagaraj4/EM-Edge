<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/* 
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Create History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
11/02/2014	       		BRU-HIMS-CRF-225.1	    Sakti Sankar	   11/02/2014	    Sakti Sankar			 Newly Created
--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>

<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,java.lang.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
	<head>
	
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language='javascript' src='../../eCommon/js/common.js' ></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
		String url				=		"../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params			=		request.getQueryString() ;
		String source			=		url + params ;
%>
<iframe name='qryCriteriaRequestStatus' id='qryCriteriaRequestStatus' src="../../eSS/jsp/LoanRequestStatusQueryCriteria.jsp?<%=source%>" frameborder=0  scrolling='no' style='height:28%;width:100vw'></iframe><iframe name='qryResultRequestStatus' id='qryResultRequestStatus' src="../../eCommon/html/blank.html" frameborder=0 noresize scrolling='no' style='height:100vh;width:100vw'></iframe>
</html>

