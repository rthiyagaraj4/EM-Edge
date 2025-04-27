<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,java.lang.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<%
			request.setCharacterEncoding("UTF-8");
			String sStyle		 =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="JavaScript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
	<%
		String url				=			"../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params			=			request.getQueryString() ;
		String source			=			url + params ;
	%>
	<iframe name='qryCriteriaTrayDtl' id='qryCriteriaTrayDtl'	src="../../eSS/jsp/TrayDtlsQueryCriteria.jsp?<%=source%>" frameborder=0  scrolling='no' style='height:20vh;width:100vw'></iframe>
	<iframe name='qryResultTrayDtl' id='qryResultTrayDtl'		src='../../eSS/jsp/TrayDtlsQueryResult.jsp' frameborder=0 noresize scrolling='no' style='height:80vh;width:100vw'></iframe>
</html>

