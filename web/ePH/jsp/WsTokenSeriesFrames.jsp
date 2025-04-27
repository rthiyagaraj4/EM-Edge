<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	
<% 
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
	<!--<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/messages.js"></SCRIPT>-->
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhCommon.js"></SCRIPT>
	<!--<SCRIPT LANGUAGE="javascript" SRC="../js/PhMessages.js"></SCRIPT>-->
	<SCRIPT LANGUAGE="javascript" SRC="../js/WsTokenSeries.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<%
	String url = "../../ePH/jsp/WsTokenSeriesAddModify.jsp?" ;
	String function_id	= request.getParameter("function_id") ;
	String mode			= request.getParameter("mode") ;
	String source		= url+"function_id="+function_id+"&mode="+mode;
%>


<iframe name="ws_ts_header" id="ws_ts_header" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="<%= source %>" style="height:15vh;width:100vw"></iframe><iframe name="ws_ts_button" id="ws_ts_button" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../eCommon/html/blank.html" style="height:0vh;width:100vw"></iframe><iframe name="ws_ts_detail" id="ws_ts_detail" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../eCommon/html/blank.html" style="height:85vh;width:100vw"></iframe>
</HTML>

