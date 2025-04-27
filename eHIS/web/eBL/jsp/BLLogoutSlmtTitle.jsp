<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<html>
<head>
<%
		//unused variable, commented on 09/06/05
		//String params = request.getQueryString() ;
%>
<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
	-->
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>


	<iframe name='header_frame' id='header_frame'	src="BLLogoutSlmtHeader.jsp"  frameborder=0 scrolling='no' noresize style='height:2vh;width:100vw'></iframe>
	<iframe name='bl_cashier_logout' id='bl_cashier_logout' 	src='BLCashierLogoutSettlements.jsp' frameborder=0 scrolling='auto' noresize style='height:98vh;width:100vw'></iframe>
<!--<frame name='bl_cashier_logout' id='bl_cashier_logout' 	src='BLLogoutCashCounterMain.jsp' frameborder=0 scrolling='auto' noresize>
	<frame name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize>-->



