<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date			Edit History	Name			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
06/07/2018	IN067246		Raja S				06/07/2018	Ramesh G			GHL-CRF-0516 
-------------------------------------------------------------------------------------------------------------------------------
-->
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");
%>
<html>
<%@page import="eOR.*, java.util.*" contentType="text/html; charset=UTF-8" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="beanQueryObj" scope="page" class="eOR.OrderEntryQueryBean"/>
<%-- Mandatory declarations end --%>
<head>
<% String p_order_category = request.getParameter("p_order_category"); 
int total_size = Integer.parseInt(request.getParameter("total_size")); 

%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
</head>
<body>
<table border="0" cellspacing=0 cellpadding="3" id="tab">
	<tr>
<%
	if(total_size > 3 && p_order_category.equals("CS")){
%>
		<td id="OrderSet" class="CASECONDSELECTHORZ" nowrap>Order Set</td>
		<td id="Individual_Catalog"  class="CAFIRSTSELECTHORZ"  nowrap>Individual Catalog</td>
<%  }else if(total_size==3 && p_order_category.equals("CS")){ %>
		<td id="OrderSet" class="CASECONDSELECTHORZ" nowrap>Order Set</td>
<%  }else if(!p_order_category.equals("CS")){ %>
		<td id="Individual_Catalog"  class="CAFIRSTSELECTHORZ"  nowrap>Individual Catalog</td>
<%} %>		
	</tr>
</table>

</body>
</html>
