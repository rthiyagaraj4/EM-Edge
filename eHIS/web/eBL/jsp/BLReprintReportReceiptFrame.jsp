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
	function refresh(){
		search_hdr.document.location.href = '../../eBL/jsp/BLReprintReportReceiptHdr.jsp'
		body_frame.document.location.href = "../../eCommon/html/blank.html";
		dummy_frame.document.location.href = '../../eCommon/html/blank.html';
		selectedFrame.document.location.href = '../../eBL/jsp/BLReprintReceiptSelected.jsp';
		buttonFrame.document.location.href = '../../eBL/jsp/BLReprintReceiptBtn.jsp';
		messageFrame.document.location.href = '../../eCommon/jsp/error.jsp';
	}

	function closeWindow(){
		//window.close();
		 const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    dialogTag.close();
	}
	</script>
    </HEAD> 
    
    	<iframe SRC= '../../eBL/jsp/BLReprintReportReceiptHdr.jsp' name="search_hdr" id="search_hdr" frameborder=0 noresize scrolling='no'  style='height:31vh;width:100vw'></iframe>
		<iframe SRC=''  name="body_frame" id="body_frame" frameborder=0 noresize  style='height:32vh;width:100vw'></iframe>
		<iframe SRC="../../eBL/jsp/BLReprintReceiptSelected.jsp"	scrolling='auto'  name="selectedFrame" id="selectedFrame" frameborder=0 noresize  
		style="height:15vh;width:100vw"></iframe>
		<IFRAME NAME="dummy_frame" ID="dummy_frame"  src='../../eCommon/html/blank.html'	 frameborder=0 noresize scrolling='no' style="height:3vh;width:100vw"></IFRAME>
		<iframe SRC="../../eBL/jsp/BLReprintReceiptBtn.jsp"	  name="buttonFrame" id="buttonFrame" frameborder=0 noresize  style="height:5vh;width:100vw"></iframe>
		<iframe name="messageFrame" id="messageFrame" id='messageFrame' src='../../eCommon/jsp/error.jsp'	   frameborder=0 noresize scrolling='auto' style='height:6vh;width:100vw'></iframe>	
</HTML>

