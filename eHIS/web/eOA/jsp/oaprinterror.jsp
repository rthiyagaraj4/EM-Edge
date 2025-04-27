<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="eCommon.XSSRequestWrapper" %>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<head>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language="JavaScript">

</script>

</head>

<BODY CLASS="MESSAGE" onKeyDown = 'lockKey()'>

<p align="left">
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String error=request.getParameter( "err_num" );
	String error1="";

	if ( error != null ) {
		
		error1 = error.substring(error.indexOf("R"),error.length()-25);
		out.println("<script>alert('"+error1+"');</script>" ) ;
}


%>
</p>
</BODY>

