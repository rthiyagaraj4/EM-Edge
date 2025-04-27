<!DOCTYPE html>
<%
/*
Sr No            Version          Incident             SCF/CRF					Developer Name
1                V201125						MOHE-CRF-0050.3-US-004 		   Palani Narayanan
*/
%>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language='javascript' src='../js/BLItemPriceList.js'></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<%
	String params = request.getQueryString() ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='../../eCommon/jsp/commonToolbar.jsp?<%=params %>'  frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='bl_cashier_report' id='bl_cashier_report' 	src='BLItemPriceList.jsp?<%=params %>' frameborder=0 scrolling='no' noresize style='height:84vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='auto' frameborder=0 noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='dummyFrame' id='dummyFrame'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' noresize style='height:0vh;width:100vw'></iframe>


