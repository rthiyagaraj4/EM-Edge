<!DOCTYPE html>
<%@ page  import="java.sql.*,webbeans.eCommon.*,java.net.*, java.io.*, java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>

	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script language='javascript' src='../js/BLReprintReportReceipt.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%
		String params = request.getQueryString();

	
	%>

	  <iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='../../eCommon/jsp/commonToolbar.jsp?<%=params%>'  frameborder=0 scrolling='no'  style='height:9vh;width:100vw'></iframe>
	  <iframe name="interim_main_report" id="interim_main_report" SRC="../../eBL/jsp/BLReprintReportReceiptFrame.jsp"	   frameborder=0 noresize scrolling='no' style='height:94vh;width:100vw'></iframe>
	  <iframe name="dummyFrame" id="dummyFrame"  src='../../eCommon/html/blank.html'	   frameborder=0 noresize   style='height:0vh;width:100vw'></iframe>
	  <iframe name="messageFrame" id="messageFrame"  src='../../eCommon/jsp/error.jsp'	   frameborder=0 noresize  style='height:0vh;width:100vw'></iframe>	
</HTML>

