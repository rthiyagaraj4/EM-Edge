<!DOCTYPE html>
<!--
	Developed by 	:	R.Nanda Kumar
	Modified by 	:	Parimala K.V
	Created on 	:	22/12/2000
	Module		:	Out Patient Management
	Function	:	This file is used for calling the Query Result page of the
				Patient Queue. Arguments are passed while calling which is
				inturn fetched in variables for dynamically executing Sql
				statements.
-->

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,eCommon.XSSRequestWrapper" %>

<HTML>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	 request.setCharacterEncoding("UTF-8"); 
	 request= new XSSRequestWrapper(request);
	 response.addHeader("X-XSS-Protection", "1; mode=block");
	 response.addHeader("X-Content-Type-Options", "nosniff");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eOP/js/ManageSPatQueue.js'></script>
	<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onLoad="initQueue()" onKeyDown = 'lockKey();'>
</body>
</HTML>

