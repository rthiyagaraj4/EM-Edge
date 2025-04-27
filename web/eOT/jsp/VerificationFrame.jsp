
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
<frameset  id='booking_verification' name='booking_verification' rows='5%,42%,12%,16%'>
<frame name="f_query_add_mod_1" id="f_query_add_mod_1" frameborder="0" scrolling="no" noresize src="../../eOT/jsp/VerificationSearch.jsp?<%=request.getQueryString()%>">
<frame name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../eOT/jsp/BookedcasesVerificationSearch.jsp?<%=request.getQueryString()%>">
<frame name='qa_query_result' id='qa_query_result' noresize src="../../eCommon/html/blank.html" frameborder=0 scrolling="yes">
<frame name='qa_query_result_tail' id='qa_query_result_tail'  noresize src="../../eCommon/html/blank.html" frameborder=0>
</frameset>
