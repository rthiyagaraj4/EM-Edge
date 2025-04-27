<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
 	<script language="JavaScript" src="../../eCommon/js/common.js"></script> 
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eOR/js/FrequencyScope.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

	String mode			= request.getParameter("mode");
	//String freq_code		= request.getParameter("freq_code");
	String 	function_id= request.getParameter("function_id");
	mode = mode.trim();



%>
		<iframe name='f_frequency_scope_top' id='f_frequency_scope_top' src='FrequencyScopeAddModifyTop.jsp?mode=<%=mode%>&function_id=<%=function_id%>' frameborder=0 scrolling='no' noresize style='height:10vh;width:100vw'></iframe>
			<iframe name='f_frequency_scope_bottom' id='f_frequency_scope_bottom' src='../../eCommon/html/blank.html' frameborder=0  scrolling='no' noresize style='height:86vh;width:100vw'></iframe>
		
</html>									

