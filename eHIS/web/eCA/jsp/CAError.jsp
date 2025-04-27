<!DOCTYPE html>
<%
/*
-----------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date	Rev.Name	Description
-----------------------------------------------------------------------
20/12/2023   54677    Krishna Pranay   21/12/2023  Ramesh Goli    CA-Common-Record Clinical Note
-----------------------------------------------------------------------

*/
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.io.*,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
//request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097//54677
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>

<head>

<script language="JavaScript">
function onSuccess()
{
	top.content.workAreaFrame.location.reload();
	//top.content.secondframe.thirdframe.location.reload();
}
</script>

</head>

<BODY OnMouseDown="CodeArrest()" onKeyDown="lockKey()" CLASS="MESSAGE">
<FORM>
<p align="left">
<%
	String error=request.getParameter( "err_num" );
	//String home_required_yn=request.getParameter("home_required_yn");
	if ( error != null ) 
	{
//		InputStreamReader reader = new InputStreamReader( new ByteArrayInputStream( error.getBytes()), "UTF-8" ) ;
//		error = (new BufferedReader(reader)).readLine() ;
		if ( error == null ) error = "" ;
		out.println( error ) ;

		String error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;

		if ( error_value.equals( "1" ) )
			out.println( "<script language='JavaScript'>onSuccess();</script>" ) ;
	}

%>
</p>
</FORM>
</BODY>

