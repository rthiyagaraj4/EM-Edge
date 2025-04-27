<!DOCTYPE html>
<% 
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
27/07/2017		IN061891	Raja S		27/07/2017		Ramesh G		ML-MMOH-CRF-0543
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>

<head>
<meta HTTP-EQUIV="content-type" CONTENT="text/html; charset=UTF-8">
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language="JavaScript">
</script>

</head>

<BODY CLASS="MESSAGE" onKeyDown = 'lockKey()'>

<p align="left">
<%
	request.setCharacterEncoding("UTF-8");	
	String error=request.getParameter( "err_num" );

	if ( error != null ) {
		String error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;

		if ( error_value.equals( "1" ) )
			out.println( "<script language='JavaScript'>parent.workAreaFrame.PatSearchCriteriaFr.location.reload();</script>" ) ;
	}
%>
</p>
<p id='ehiserror'></p>
</BODY>

