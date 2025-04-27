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
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<iframe name="f_query_add_mod" id="f_query_add_mod"  scrolling="no" noresize src="../../eOT/jsp/WaitListSearch.jsp?<%=request.getQueryString()%>" frameborder='0' style="height:35vh;width:99vw"></iframe>
<iframe name='qa_query_result' id='qa_query_result' 		src="../../eCommon/html/blank.html"  frameborder='0' style='height:56vh;width:100vw'></iframe>
<iframe name='qa_query_result_tail' id='qa_query_result_tail' src="../../eCommon/html/blank.html" scrolling='no' frameborder='0' style='height:8vh;width:100vw'></iframe>

