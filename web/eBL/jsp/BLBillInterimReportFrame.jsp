<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language='javascript' src='../../eBL/js/BLInterimBillReport.js'></script>
<HTML>
	<HEAD>
	<TITLE>
		<%=request.getParameter("title")%>
		
	</TITLE>
    </HEAD> 
	   <iframe SRC= '../../eBL/jsp/BLBillInterimReportHdr.jsp' name="search_hdr" id="search_hdr" frameborder=0 noresize scrolling='no' style='height:20vh;width:100vw'></iframe>
	   <iframe SRC="../../eBL/jsp/BillInterimBedChargeCompute.jsp" 	  name="" id="" frameborder=0 noresize scrolling='no' style='height:4vh;width:100vw'></iframe>
	   <iframe SRC="../../eCommon/html/blank.html"	  name="body_frame" id="body_frame" frameborder=0 noresize scrolling='no' style='height:71vh;width:100vw'></iframe>
	   <iframe SRC="../../eCommon/html/blank.html"	  name="dummy_frame" id="dummy_frame" frameborder=0 noresize scrolling='no' style='height:5vh;width:100vw'></iframe>
	   <iframe name="messageFrame" id="messageFrame"  src='../../eCommon/jsp/error.jsp'	 frameborder=0 noresize scrolling='no' style='height:0vh;width:100vw'></iframe>	
</HTML>

