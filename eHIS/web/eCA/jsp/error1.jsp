<!DOCTYPE html>
<%@ page import="java.io.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 <%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<head>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
</script>
</head>
<BODY CLASS="MESSAGE" onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<p align="left">
<%
	String error=request.getParameter( "err_num" );

	if ( error != null ) 
	{
		String queryString = (String) session.getValue( "queryString" ) ;
		if ( queryString == null ) queryString = "" ;

		if ( error == null ) error = "" ;
		String error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;

		if ( error_value.equals( "1" ) )
			out.println( "<script language='JavaScript'>parent.onSuccess();</script>" ) ;
		else{
			error = error.replace("&lt;", "<").replace("&gt;", ">");
			out.println( error ) ;
		}
	}
%>
</p>
</BODY>

