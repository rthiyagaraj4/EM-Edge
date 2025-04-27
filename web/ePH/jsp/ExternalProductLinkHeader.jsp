<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>


<HTML>
<head>
	<%
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	</head>
<!--<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()"  >-->
<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String display	= request.getParameter( "DisplayType" ) ;
%>
<table width="100%" border="0">
<tr><th align="left" width="98%" style="font-size:8pt"><%=display%></th><th align="right" style="font-size:8pt"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th></tr>
</table>
</form>
</BODY>
</HTML>
