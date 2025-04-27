<%@ page import="java.sql.*, webbeans.eBL.*, webbeans.eCommon.*, webbeans.op.CurrencyFormat, java.io.*, java.util.*, eBL.Common.*,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<html>
<head>
	
	<%
// karthik added code on 5-25-2013 INCLUDE_POLICY_DETAILS_CRF

		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!-- 
<frameset rows='0%,78%,22%,0%' border=0>
	<FRAME SRC="../../eCommon/html/blank.html" frameborder=0 name='DummyFrame' scrolling='no' noresize> 
	<frame name="AddModifypatFinDetailsInsBodyFrame" src="../../eBL/jsp/AddModifyPatFinDetailsInsBody.jsp?<%=request.getQueryString()%>" frameborder=0 noresize scrolling="no" > 
	<FRAME SRC="../../eCommon/html/blank.html" frameborder=0 name="AddModifypatFinDetailsInsButtonFrame" scrolling="no" noresize> 
	<FRAME SRC="../../eCommon/html/blank.html" frameborder=0 name="InsValidationFrame" scrolling="no" noresize> 
	<FRAME SRC="../../eCommon/html/blank.html" frameborder=0 name="DummyFrame" scrolling="no" noresize> 
</frameset>
-->
		<iframe SRC="../../eCommon/html/blank.html" frameborder=0 name="DummyFrame" id="DummyFrame" scrolling="no" noresize style='height:0vh;width:100vw'></iframe>
		<iframe name="AddModifypatFinDetailsInsBodyFrame" id="AddModifypatFinDetailsInsBodyFrame" src="../../eBL/jsp/AddModifyPatFinDetailsInsBody.jsp?<%=request.getQueryString()%>" frameborder=0 noresize scrolling="auto" style='height:85vh;width:100vw'></iframe>
		<iframe SRC="../../eCommon/html/blank.html" frameborder=0 name="AddModifypatFinDetailsInsButtonFrame" id="AddModifypatFinDetailsInsButtonFrame" scrolling="no" noresize style='height:15vh;width:100vw'></iframe>
		<iframe SRC="../../eCommon/html/blank.html" frameborder=0 name="InsValidationFrame" id="InsValidationFrame" scrolling="no" noresize style='height:0vh;width:100vw'></iframe>
		<iframe SRC="../../eCommon/html/blank.html" frameborder=0 name="DummyFrame" id="DummyFrame" scrolling="no" noresize style='height:0vh;width:100vw'></iframe>
</head>
<input type='hidden' name='Case' id='Case' value='4'>
</html>

