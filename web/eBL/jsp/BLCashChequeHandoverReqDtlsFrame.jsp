<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<%
		String params = request.getQueryString();
		//System.out.println("function_id frame:"+params);
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
		<script language="javascript" src='../../eBL/js/BLCashChequeHandover.js'></script>
		<!--<script language='javascript' src='../js/BLCashCounterLogout.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


-->
		<iframe name='BLCashChequeHandoverCashChqCollFrame' id='BLCashChequeHandoverCashChqCollFrame' src='../../eBL/jsp/BLCashChequeHandoverCashDtls.jsp?<%=params%>' frameborder=0 scrolling='no' noresize style='height:35vh;width:100vw'></iframe>
			<iframe name='BLCashChequeHandoverCashChqCollFrame1' id='BLCashChequeHandoverCashChqCollFrame1' src='../../eBL/jsp/BLCashChequeHandoverChequeDtls.jsp?<%=params%>' frameborder=0 scrolling='auto' noresize style='height:65vh;width:100vw'></iframe>			
		
</HTML>

