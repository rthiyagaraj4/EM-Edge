<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%	request.setCharacterEncoding("UTF-8"); 
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends
%>
	<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<% 
if("OT_SLATE".equals(request.getParameter("called_from") )){	%>
	<title><fmt:message key="Common.Reschedule.label" bundle="${common_labels}"/></title>
<%}%>

<iframe name="commontoolbarFrame" id="commontoolbarFrame"  scrolling="no" noresize src="../../eOT/jsp/CalendarTab.jsp?<%=request.getQueryString()%>" frameborder='0' style="height:4vh;width:99vw"></iframe>
<iframe name="f_query_add_mod" id="f_query_add_mod"  scrolling="no" noresize src="../../eOT/jsp/DiarySheduleSearch.jsp?<%=request.getQueryString()%>"  frameborder='0' style="height:23vh;width:99vw"></iframe>

<iframe name='qa_query_result' id='qa_query_result' 		src="../../eCommon/html/blank.html?<%=request.getQueryString()%>"  noresize frameborder='0' style='height:62vh;width:99vw'></iframe>

<iframe name='qa_query_result_tail' id='qa_query_result_tail' src="../../eCommon/html/blank.html"  noresize frameborder='0' style='height:5vh;width:95vw'></iframe>


