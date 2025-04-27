<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<head>
<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
	-->
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		
    %>



	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language='javascript' src='../../eBL/js/BLCashCounterLogin.js'></script>
<!--<frameset rows='42,251,*,0'> -->
<!--<frameset rows='0%,48%,52%,0%,0%'>-->

<iframe name='' id=''		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' noresize style='height:0vh;width:100vw'></iframe>
<iframe name='bl_cashier_login' id='bl_cashier_login' 	src='../../eBL/jsp/BLLogInCashCounterAdv.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize style='height:50vh;width:100vw'></iframe>
<iframe name='bl_cashier_query' id='bl_cashier_query'		src='../../eBL/jsp/BLLogInCashCounterQuery.jsp' frameborder=0 noresize scrolling='yes' noresize style='height:40vh;width:100vw'></iframe>
<iframe name='dummyFrame' id='dummyFrame'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' noresize style='height:0vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' noresize style='height:9vh;width:100vw'></iframe>
<!--</frameset>-->


