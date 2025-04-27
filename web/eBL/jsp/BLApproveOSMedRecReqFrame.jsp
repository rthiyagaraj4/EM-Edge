<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language='javascript' src='../js/BLReprintReportReceipt.js'></script>
<HTML>
<HEAD>
	<TITLE>
	<%=request.getParameter("title")%>
	<%
		String includeBanner = request.getParameter("includeBanner");
	%>	
	</TITLE>
	<script>
	function closeWindow(){
		window.close();
	}
	</script>
</HEAD>    
	<iframe SRC= '../../eBL/jsp/BLApproveOSMedRecReqHdr.jsp'  name="search_hdr" id="search_hdr" frameborder=0 noresize scrolling='no'  style='height:20vh;width:100vw'></iframe>
	<iframe SRC=''  name="body_frame" id="body_frame" frameborder=0 noresize scrolling='auto' style='height:70vh;width:100vw'></iframe>
	<iframe name="messageFrame" id="messageFrame" id='messageFrame' src='../../eCommon/jsp/error.jsp'	   frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>	
</HTML>

