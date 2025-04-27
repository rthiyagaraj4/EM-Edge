<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    		Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
12/05/2024  50627    Twinkle Shah    12/05/2024		Ramesh Goli        ML-MMOH-CRF-2106
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='javascript' src='../js/CAConsultationTagReport.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
</head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> frameborder=0 scrolling='no' noresize frameborder='0' style='height:42%;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../jsp/CAConsultationTagReportMain.jsp' frameborder=0 frameborder='0' style='height:100vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' frameborder='0' style='height:50%;width:100vw'></iframe>
</html>

