<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% request.setCharacterEncoding("UTF-8");  %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
</head>

<BODY CLASS="MESSAGE" onMouseDown='CodeArrest()' onKeyDown='lockKey()'>

<p align="left">
<%
	String error=request.getParameter( "err_num" );

	if ( error != null ) 
	{
%>	
	<script>
			var error = '<%=error%>';				
			alert(error);		
	</script>
<%		


		String queryString = (String) session.getValue( "queryString" ) ;
		if ( queryString == null ) queryString = "" ;
		out.println( "<script language='JavaScript'>parent.commontoolbarFrame.location.href='../../eCommon/jsp/commonToolbar.jsp?" + queryString + "';</script>" ) ;

		String error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;	
		if ( error_value.equals( "1" ) )
			out.println( "<script language='JavaScript'>parent.onSuccess();</script>" ) ;
	}

%>
</p>
</BODY>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

