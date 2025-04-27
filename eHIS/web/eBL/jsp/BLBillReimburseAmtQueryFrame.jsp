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
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<!--<script language="javascript" src='../../eBL/js/BLPatientRegnBillingDtls.js'></script>-->
		<!--<script language='javascript' src='../js/BLCashCounterLogout.js'></script>-->


<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			<iframe name='search_frame' id='search_frame'	src='BLViewPatEncounterPatSearch.jsp?<%=params%>'  frameborder=0 scrolling='no' noresize style='height:32vh;width:100vw'></iframe>
			<iframe name='' id='' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:60vh;width:100vw'></iframe>
			<iframe name='dummyFrame' id='dummyFrame'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' noresize style='height:0vh;width:100vw'></iframe>
		
</HTML>

