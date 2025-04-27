<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>

<%
		String params = request.getQueryString();
%>
<HTML>
<HEAD>
</HEAD>
<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
-->
<%
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script language="javascript" src='../../eBL/js/PkgSubs.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		
	<iframe name='PkgSubscriptionHeader' id='PkgSubscriptionHeader'	src='PkgSubscriptionHeader.jsp?<%=params%>'  frameborder=0 scrolling='auto' noresize style='height:10vh;width:100vw'></iframe>
<iframe name='PkgSubscriptionDtls' id='PkgSubscriptionDtls'	src='../../eCommon/html/blank.html'  frameborder=0 scrolling='no' noresize 
style='height:83vh;width:100vw'></iframe>
<iframe name='PkgSubscriptionServiceDtls' id='PkgSubscriptionServiceDtls'	src='../../eCommon/html/blank.html'  frameborder=0 scrolling='no' noresize style='height:0vh;width:100vw'></iframe>		
		<iframe name='dummyFrame' id='dummyFrame'	src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' noresize style='height:0vh;width:100vw'></iframe>
	
</HTML>

