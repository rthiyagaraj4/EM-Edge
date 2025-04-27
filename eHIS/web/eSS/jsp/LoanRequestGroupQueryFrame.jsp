<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import=" eSS.*,eSS.Common.*,java.util.*" contentType="text/html;charset=UTF-8"%>  
<html>
	<head>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eSS/js/LoanRequestGroup.js'></script>
		<script language='javascript' src='../../eSS/js/SsCommon.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		request.setCharacterEncoding("UTF-8");
		String url				=		 "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params			=		request.getQueryString() ;
		String source			=		url + params ;
	%>
	<iframe name='frameLoanRequestGroupQueryCriteria' id='frameLoanRequestGroupQueryCriteria' src="../../eSS/jsp/LoanRequestGroupQueryCriteria.jsp?<%=source%>" frameborder=0  scrolling='no' style='height:95%;width:100vw'></iframe><iframe name='frameLoanRequestGroupQueryResult' id='frameLoanRequestGroupQueryResult' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:100vh;width:100vw'></iframe>
</html>


