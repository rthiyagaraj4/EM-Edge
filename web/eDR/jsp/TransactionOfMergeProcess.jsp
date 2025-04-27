<!DOCTYPE html>
<!--
	Created on	:	12/02/2002
	Created by	:	NANDA KUMAR R.
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8"  %>

<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>
<head>
<title> <fmt:message key="Common.NewDocument.label" bundle="${common_labels}"/> </title>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eDR/js/TransactionsOfMergeProcess.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String url		= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params	= request.getQueryString() ;
	String source	= url + params ;
%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%>  scrolling=no noresize style='height:8vh;width:100vw' frameborder="0"></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eDR/jsp/TransactionsOfMergeProcessFrameset.jsp'  scrolling='NO' frameborder="0" style='height:85vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='no'  noresize style='height:7vh;width:100vw' frameborder="0"></iframe>
	
</html>

