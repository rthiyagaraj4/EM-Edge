<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>


<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
	-->
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src='../js/BLInterimBill.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%
		String params = request.getQueryString();
//		System.out.println("params:"+params);
	%>

	  <iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='../../eCommon/jsp/commonToolbar.jsp?<%=params%>'  frameborder=0 scrolling='no'  style='height:6vh;width:100vw'></iframe>
	  <iframe SRC="../../eBL/jsp/BLBillInterimFrame.jsp"	  name="interim_main" id="interim_main" frameborder=0 noresize scrolling='auto' style='height:84vh;width:100vw'></iframe>
	  <iframe SRC="../../eCommon/html/blank.html"	  name="messageFrame" id="messageFrame" frameborder=0 noresize scrolling='no' style='height:10vh;width:100vw'></iframe>	
</HTML>

