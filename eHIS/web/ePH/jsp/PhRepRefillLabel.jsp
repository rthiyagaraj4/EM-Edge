<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	
	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhMessages.js"></script> -->
	<script language="JavaScript" src="../../ePH/js/PhRepPrescription.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhRepRefillLabel.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	<title>Refill Label</title>

	
</head>
<%
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for MMS-ME-SCF-0097 Starts 
request= new XSSRequestWrapper(request); 
response.addHeader("X-XSS-Protection", "1; mode=block"); 
response.addHeader("X-Content-Type-Options", "nosniff"); 
//Added by Himanshu for MMS-ME-SCF-0097 ends

	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	
	
	
%>
<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:10vh;width:100vw"></iframe>
<iframe name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/PhRepRefillLabelCriteria.jsp?" style="height:20vh;width:100vw">
</iframe><iframe name="f_query_results" id="f_query_results" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:60vh;width:100vw"></iframe>
<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style="height:10vh;width:100vw"></iframe>
</html>

