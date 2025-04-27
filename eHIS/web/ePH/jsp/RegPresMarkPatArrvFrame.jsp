<!DOCTYPE html>
<!-- 
Developed by	: Janet
Module/Function : Mark Patient Arrival (Transaction)
-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
	<head>
	<%
    String flag		     = request.getParameter("flag");
	String pagetitle = "";
	if(flag.equals("1")){
		pagetitle = "Mark Patient Arrival/ Undelivered Drugs";
	}
	if(flag.equals("2")){
		pagetitle = "Mark Patient Arrival";
	}
	if(flag.equals("3")){
		pagetitle = " Undelivered Drugs";
	}
	%>
		<title><%=pagetitle%></title>
<%
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhMessages.js"></script>
		<script language="JavaScript" src="../../ePH/js/RegPrescriptions.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	
	<iframe name='frameRegPresMarkPatArrvQryCriteria' id='frameRegPresMarkPatArrvQryCriteria'				src="../../ePH/jsp/RegPresMarkPatArrvQryCriteria.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize style='height:15vh;width:100vw'></iframe>

		<iframe name='frameRegPresMarkPatArrvHeader' id='frameRegPresMarkPatArrvHeader'			src="../../ePH/jsp/RegPresMarkPatArrvHeader.jsp?<%=request.getQueryString()%>"					frameborder=0 scrolling='no'   noresize style='height:5vh;width:100vw'></iframe>

		<iframe name='frameRegPresMarkPatArrvQryResult' id='frameRegPresMarkPatArrvQryResult'			src="../../eCommon/html/blank.html?<%=request.getQueryString()%>"					frameborder=0 scrolling='auto'   noresize style='height:72vh;width:100vw'></iframe>

		<iframe name='frameRegPresMarkPatArrvFooter' id='frameRegPresMarkPatArrvFooter'			src="../../ePH/jsp/RegPresMarkPatArrvFooter.jsp?<%=request.getQueryString()%>"					frameborder=0 scrolling='no'   noresize style='height:5vh;width:100vw'></iframe>
	
</html>

