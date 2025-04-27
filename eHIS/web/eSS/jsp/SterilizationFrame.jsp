<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eSS/js/SterilizationCost.js"></script>
	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
	<script language="JavaScript" src="../../eCommon/js/CommonLookUp.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<iframe name="SterilizationHeader" id="SterilizationHeader" frameborder="0" scrolling="no" noresize src="../../eSS/jsp/SterilizationHeader.jsp?<%=request.getQueryString()%>" style="height:10vh;width:100vw"></iframe>
<iframe name="SterilizationCostAddModify" id="SterilizationCostAddModify" frameborder="0" scrolling="no" noresize  src='../../eCommon/html/blank.html'  style='height:85vh;width:100vw'></iframe>
</html>


