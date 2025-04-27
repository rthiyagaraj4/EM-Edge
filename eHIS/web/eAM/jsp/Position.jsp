<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eAM
*	Purpose 		:	
*	Created By		:	Suchilagna Panigrahi
*	Created On		:	15 Sept 2004
-->

<!-- OtherStaff.jsp-->
<%//@ page import ="java.sql.*" %>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"  %>

<html>
<head>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>

<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language="JavaScript" src="../../eOR/js/OrMessages.js"></script>

<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language="JavaScript" src="../../eAM/js/Position.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
request.setCharacterEncoding("UTF-8");	
//MMS-ME-SCF-0096 vulnerability Issue 
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
//MMS-ME-SCF-0096 vulnerability Issue
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
 	String params = request.getQueryString() ;
	String source = url + params ;
	
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:80vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
</head>
<body onKeyDown = 'lockKey()'>
</body>
</html>

