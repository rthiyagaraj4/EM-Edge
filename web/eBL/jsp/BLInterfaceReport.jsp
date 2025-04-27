<!DOCTYPE html>
<!-- JSP Created Against AAKH-CRF-0113.3 -->

<%@ page  import="java.sql.*,webbeans.eCommon.*,java.net.*, java.io.*, java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<%
	String sStyle = "IeStyle.css";	
	String paramString = request.getQueryString();	
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script language='javascript' src='../js/BLReprintReport.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<iframe name="interim_main_report" id="interim_main_report" SRC="../../eBL/jsp/BillMaintananceInterface.jsp?<%=request.getQueryString()%>" frameborder=0 noresize scrolling='yes' style='height:100vh;width:100vw'></iframe>
	<iframe name="dummyFrame" id="dummyFrame"  src='../../eCommon/html/blank.html'	   frameborder=0 noresize   style='height:0vh;width:100vw'></iframe>	
</HTML>
<!--JSP Created Against AAKH-CRF-0113.3-->

