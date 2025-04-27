<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>

<%
		String params = request.getQueryString();
//		System.err.println("BLNursingUnitQueryResultsSubFrame.jsp:"+params);
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


		<iframe name='BLNursingUnitQueryResultsFinSummaryFrame' id='BLNursingUnitQueryResultsFinSummaryFrame'	src='../../eBL/jsp/BLNursingUnitQueryResultsFinSummaryFrame.jsp?<%=params%>'  frameborder=0 scrolling='no' noresize style='height:98vh;width:50vw'></iframe>
			<iframe name='BLNursingUnitQueryResultsOccuForecastFrame' id='BLNursingUnitQueryResultsOccuForecastFrame'	src='../../eBL/jsp/BLNursingUnitQueryResultsOccuForecastFrame.jsp?<%=params%>'  frameborder=0 scrolling='no' noresize style='height:98vh;width:49vw'></iframe>
		
</HTML>

