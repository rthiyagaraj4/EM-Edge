<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<% 
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
--------------------------------------------------------------------------------------------------------------
07/05/2014		IN048464		Karthi L			07/05/2014		Ramesh			History added for clinical comments																		
--------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String orderId = request.getParameter("orderId");
String max_seq = request.getParameter("max_seq");
if(max_seq==null) max_seq="";
%>
<title><fmt:message key="Common.ClinicalComments.label" bundle="${common_labels}"/></title>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
 <iframe name='ViewHeaderCommentTop' id='ViewHeaderCommentTop' src='ViewHeaderCommentTop.jsp?orderId=<%=orderId%>&max_seq=<%=max_seq%>' frameborder=0   scrolling=no noresize style='height:12vh;width:97vw'></iframe>
	<iframe name='ViewHeaderCommentDetail' id='ViewHeaderCommentDetail' src='ViewHeaderCommentDetail.jsp?orderId=<%=orderId%>&max_seq=<%=max_seq%>' frameborder=0  scrolling=no  noresize style='height:90vh;width:97vw'></iframe>


