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
<head>
<%
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
</head>

<%
	String params = request.getQueryString();
	String tab_id=request.getParameter("tab_id");
	params+="&tab_id="+tab_id;
%>
<iframe name="f_query_add_mod" id="f_query_add_mod"  scrolling="no" noresize src="../../eOT/jsp/PendingOrderSearch.jsp?<%=params%>" style="height:28vh;width:99vw;border-left-width: 0px;border-bottom-width: 0px;border-right-width: 0px;border-top-width: 0px;"></iframe>
<iframe name='qa_query_result' id='qa_query_result' src="../../eCommon/html/blank.html"  scrolling='auto' style='height:62vh;width:99vw;border-left-width: 0px;border-bottom-width: 0px;border-right-width: 0px;border-top-width: 0px;'><!-- Scrolling made auto for the SCF - SKR-SCF-0847 [IN:044280]--></iframe>
<iframe name='result_dtl' id='result_dtl' src="../../eCommon/html/blank.html" scrolling='no' noresize style='height:8vh;width:99vw'></iframe> <!-- KDAH-CRF-0283 [IN:050553] -->
 

