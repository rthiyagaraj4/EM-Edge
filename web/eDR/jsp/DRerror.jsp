<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  import="eDR.*"%>

<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
    <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<head></head>
<BODY onKeyDown='lockKey();'>
<p align="left">
<%
	String error	= request.getParameter("err_num");
	
	if(error != null)
	{
		%>
		<script>
			alert('<%=error%>');
		</script>
		<%
		String queryString = (String) session.getValue( "queryString");
		if ( queryString == null ) queryString = "" ;
		
		String error_value = request.getParameter( "err_value" ) == null ? "0" : request.getParameter( "err_value" ) ;
		
		if(error_value.equals("1"))
			out.println( "<script language='JavaScript'>if(top.document.getElementById('dialog-body') != null) {top.document.getElementById('dialog-body').contentWindow.onSuccess();}else{parent.parent.frames[2].onSuccess();}</script>" ) ;
	}
	%>
	</p>
</BODY>

