<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
	-->
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language='javascript' src='../js/BLScrollReport.js'></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>

<%
		String params = request.getQueryString() ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='../../eCommon/jsp/commonToolbar.jsp?<%=params %>'  frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
<iframe name='bl_cashier_report' id='bl_cashier_report' 	src='BLScrollReport.jsp?<%=params %>' frameborder=0 scrolling='no' noresize style='height:82vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='auto' frameborder=0 noresize style='height:8vh;width:100vw'></iframe>
<iframe name='dummyFrame' id='dummyFrame'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' noresize style='height:0vh;width:100vw'></iframe>


