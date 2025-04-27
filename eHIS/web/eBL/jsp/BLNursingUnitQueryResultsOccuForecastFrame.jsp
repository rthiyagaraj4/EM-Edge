<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>

<%
		String params = request.getQueryString();
//		System.out.println("BLNursingUnitQueryResultsOccuForecastFrame.jsp"+params);
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


		<iframe name='BLNursingUnitQueryResultsOccuForecastHdr' id='BLNursingUnitQueryResultsOccuForecastHdr'	src='../../eBL/jsp/BLNursingUnitQueryResultsOccuForecastHdr.jsp?<%=params%>'  frameborder=0 scrolling='no' noresize style='height:14vh;width:100vw'></iframe>
		<iframe name='BLNursingUnitQueryResultsOccuForecastBody' id='BLNursingUnitQueryResultsOccuForecastBody'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' noresize style='height:85vh;width:100vw'></iframe>
<!--	<iframe name='BLNursingUnitQueryResultsFinSummaryBody' id='BLNursingUnitQueryResultsFinSummaryBody'	src='../../eBL/jsp/BLNursingUnitQueryResultsFinSummaryBody.jsp'  frameborder=0 scrolling='no' noresize></iframe> -->
		<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' noresize style='height:7vh;width:100vw'></iframe>
		
</HTML>

