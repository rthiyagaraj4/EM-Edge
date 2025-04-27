<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>

<%
		String params = request.getQueryString();
//		System.err.println("params in BLNursingUnitQueryResultsMainFrame.jsp:"+params);
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
		<script language="javascript" src='../../eBL/js/BLPatientRegnBillingDtls.js'></script>
		<!--<script language='javascript' src='../js/BLCashCounterLogout.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
-->


	        <iframe name='BLNursingUnitQueryResultsMainTabFrame' id='BLNursingUnitQueryResultsMainTabFrame'	src='../../eBL/jsp/BLNursingUnitQueryResultsMainTab.jsp?<%=params%>' frameborder=0 scrolling='no' noresize style='height:12vh;width:100vw'></iframe>
			<iframe name='BLNursingUnitQueryResultsMainBodyFrame' id='BLNursingUnitQueryResultsMainBodyFrame'	src='../../eBL/jsp/BLNursingUnitQueryResults.jsp?<%=params%>'  frameborder=0 scrolling='no' noresize style='height:90vh;width:99vw'></iframe>
			<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' noresize style='height:3vh;width:100vw'></iframe>
		
</HTML>

