<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language='javascript' src='../js/BLInterimBill.js'></script>
<HTML>
	<HEAD>
	<TITLE>
		<%=request.getParameter("title")%>
		
	</TITLE>
    </HEAD> 
	   <FRAMESET framespacing="0" frameborder="0" ROWS="20%,72%,4%,0%,0%"  align = "center">
			<iFRAME SRC= '../../eBL/jsp/BLBillInterimHdr.jsp' name="search_hdr" id="search_hdr" frameborder=0 noresize scrolling='no' style="height:20vh;width:100vw"></iFRAME>			
			<iFRAME SRC="../../eCommon/html/blank.html"	  name="body_frame" id="body_frame" frameborder=0 noresize scrolling='yes' style="height:72vh;width:100vw"></iFRAME>					
			<iFRAME SRC="../../eCommon/html/blank.html"	  name="" id="" frameborder=0 noresize scrolling='no' style="height:4vh;width:100vw"></iFRAME>
<!--
			<iFRAME SRC="../../eBL/jsp/BLBillInterimBtn.jsp"	  name="" id="" frameborder=0 noresize scrolling='no' style="height:0vh;width:100vw"></iFRAME>
-->
			<iFRAME SRC="../../eCommon/html/blank.html"	  name="dummy_frame" id="dummy_frame" frameborder=0 noresize scrolling='no' style="height:0vh;width:100vw"></iFRAME>
			<iFRAME SRC="../../eCommon/html/blank.html"	  name="dummy_frame" id="dummy_frame" frameborder=0 noresize scrolling='no' style="height:0vh;width:100vw"></iFRAME>
	   </FRAMESET>	
</HTML>

