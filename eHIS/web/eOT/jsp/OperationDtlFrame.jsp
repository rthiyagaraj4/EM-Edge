<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request); 
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>

<!--<frame name='message_search_frame' id='message_search_frame' src='../../eOT/jsp/OperationProcedureDtl.jsp?<%=request.getQueryString()%>'  noresize>-->
<iframe name='message_search_frame' id='message_search_frame' src='../../eOT/jsp/OperationProcedureDtl.jsp?<%=request.getQueryString()%>'  nowrap scrolling='no' style="height:54vh;width:100vw"></iframe>
<iframe name='staticdetailframe' id='staticdetailframe' src='../../eOT/jsp/OperationStaticDtl.jsp?<%=request.getQueryString()%>'  scrolling='auto' nowrap style="height:45vh;width:100vw"></iframe>


