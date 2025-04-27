<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%-- Mandatory declarations end --%>
<%
 
    request.setCharacterEncoding("UTF-8");
	//Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to 	the bean to get the connection if using the query bean and not the functional bean 
%>
<html>
<title><fmt:message key="eOR.OrderCatalogs.label" bundle="${or_labels}"/></title>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<iframe name='OrderEntryIPDischargeDetail' id='OrderEntryIPDischargeDetail' src='OrderEntryIPDischarge.jsp?<%=request.getQueryString()%>' frameborder='0' scrolling='auto' noresize  style='height:80vh;width:100vw'></iframe>
	<iframe name='OrderEntryIPDischargeButton' id='OrderEntryIPDischargeButton' src='OrderEntryIPDischargeButton.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='auto' noresize style='height:10vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
</html>

