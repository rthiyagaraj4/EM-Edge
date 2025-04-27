<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, java.util.*" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String params = request.getQueryString();
%>

<TITLE> 
	<fmt:message key="eBL.BILL_SLMT_DTL.label" bundle="${bl_labels}"/> 
</TITLE>

<HTML>

			<iframe SRC= "../../eBL/jsp/BLBillListDtls.jsp?<%=params%>" name="slmt_hdr" frameborder=0 noresize scrolling='no' style='height:13vh;width:100vw'>	</iframe>		
			<iframe SRC="../../eCommon/html/blank.html"	  name="slmt_dtl" id="slmt_dtl" frameborder=0 noresize scrolling='no' style='height:84vh;width:100vw'>		</iframe>
<!--
			<FRAME SRC= "../../eBL/jsp/BLBillSlmtMain.jsp?<%=params%>" name="slmt_dtl" frameborder=0 noresize scrolling='yes'>			
-->
	
</HTML>

