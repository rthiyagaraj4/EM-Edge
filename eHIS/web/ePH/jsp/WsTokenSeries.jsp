<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	
<% String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
	<!--<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/messages.js"></SCRIPT>-->
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhCommon.js"></SCRIPT>
	<!--<SCRIPT LANGUAGE="javascript" SRC="../js/PhMessages.js"></SCRIPT>-->
	<SCRIPT LANGUAGE="javascript" SRC="../js/WsTokenSeries.js"></SCRIPT>
	  <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<%
	request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String locale			= (String)session.getAttribute("LOCALE");


	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

<iframe name="commontoolbarFrame" id="commontoolbarFrame" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="<%= source %>" style="height:8vh;width:100vw"></iframe><iframe name="f_query_add_mod" id="f_query_add_mod" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../eCommon/html/blank.html" style="height:85vh;width:100vw"></iframe><iframe name="messageFrame" id="messageFrame" SRC="../../eCommon/jsp/MstCodeError.jsp" FRAMEBORDER="0" NORESIZE SCROLLING="auto" style="height:7;width:100vw"></iframe>
</HTML>

