<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
 <!--Privilege Group
	Start Date/Time : Jun 20th 2007 9:00AM By Anjaneya Prasad-->

<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>



<html>
<head>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script> 
<script language='javascript' src="../../eOR/js/OrCommon.js"></script>
<script language='javascript' src='../../eOR/js/PrivilegeGroup.js'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	function_id = "<%= request.getParameter( "function_id" ) %>"
</script>
</head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	//System.out.println("===params=="+params);
	String source = url + params ;
%>
<frameset rows='9%,*%,8%'>
	<frame name='commontoolbarFrame'	src='<%=source%>' frameborder=0 scrolling='no' noresize>
	<frame name='f_query_add_mod' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize>
	<frame name='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'>
</frameset>
</html>

