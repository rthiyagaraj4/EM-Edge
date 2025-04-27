<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
  <script language="JavaScript" src="../../eOR/js/ViewOrder.js"></script>
  <script language="javascript" src="../../eCommon/js/common.js"></script>
  <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
 <script>function_id = "<%=request.getParameter("function_id")%>";</script>
 <title><fmt:message key="eOR.ViewAuditTrail.label" bundle="${or_labels}"/></title>
</head>
<%
//	String mode	   = (String)request.getParameter( "mode" ) ;
//	String function_id = (String)request.getParameter( "function_id" ) ;
	 
%>
<!--<iframe name='menuFrame' id='menuFrame' src="ViewOrderHistoryTree.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no' style='height:10vh;width:97vw'></iframe>
<iframe name="ViewOrderHistoryResult" id="ViewOrderHistoryResult"  src="../../eCommon/html/blank.html" frameborder=0 scrolling='no' style='height:39vh;width:97vw'></iframe>-->
<div style="display: flex; justify-content: flex-start;">
    

    <iframe name='menuFrame' id='menuFrame' 
        src="ViewOrderHistoryTree.jsp?<%=request.getQueryString()%>" 
        frameborder=0 scrolling='no' 
        style='height:29vh;width:25vw;'></iframe>
		<iframe name='ViewOrderHistoryResult' id='ViewOrderHistoryResult' 
        src="../../eCommon/html/blank.html" 
        frameborder=0 scrolling='auto' 
        style='height:55vh;width:81vw;'></iframe>
</div>

</html>

