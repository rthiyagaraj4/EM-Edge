<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

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
	String reqId = request.getParameter( "reqId" );

	if ( error != null ) {
		
		String queryString = (String) session.getValue( "IPQueryString" ) ;
		if ( queryString == null ) queryString = "" ;
		

		String error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;

		if ( error_value.equals( "1" ) ){
			out.println( "<script language='JavaScript'>parent.onSuccess('"+reqId+"');</script>" ) ;
		}
		else{
			out.println( error ) ;
			out.println( "<script language='JavaScript'>if(parent.commontoolbarFrame!=null){parent.commontoolbarFrame.location.href='../../eCommon/jsp/MstCodeToolbar.jsp?" + queryString + "';}</script>" ) ;
		}			
	}
%>
</p>
<p id='ehiserror'></p>
</BODY>

