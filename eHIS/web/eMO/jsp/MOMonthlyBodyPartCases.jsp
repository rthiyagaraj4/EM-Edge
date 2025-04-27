<!DOCTYPE html>
<!--Created by Ashwini on 04-Jan-2019 for ML-MMOH-CRF-1094-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>

<head>

	<%
		 String sStyle	=
		 (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		 request.setCharacterEncoding("UTF-8");
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src="../js/MOMonthlyBodyPartCases.js"></script>
	<script src="../../eCommon/js/common.js"></script>
	<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<%

	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../jsp/MOMonthlyBodyPartCasesCriteria.jsp' frameborder=0 scrolling="no" noresize style='height:40%;width:100vw'></iframe>
	<iframe src='../../eCommon/html/blank.html'  frameborder=0  scrolling="no" noresize style='height:100vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 scrolling="auto" noresize style='height:40%;width:100vw'></iframe>


</html>

