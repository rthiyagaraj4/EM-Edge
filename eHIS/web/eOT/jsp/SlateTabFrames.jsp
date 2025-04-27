<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<html>
<title></title><head>
<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	String params	= request.getQueryString();
	String tab_name = request.getParameter("tab_name") ;
	if(tab_name==null) tab_name="SLATE";
	if(tab_name!=null && tab_name.equals("null")) tab_name="SLATE";
	if(tab_name.equals("SLATE")){
%>
<iframe name="f_search" id="f_search"  scrolling="no" noresize src="../../eOT/jsp/SlateSearch.jsp?<%=params%>" style="height:45vh;width:100vw" frameborder='0'></iframe>
<iframe name="f_query_add_mod" id="f_query_add_mod"  scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:70vh;width:100vw" frameborder='0'></iframe>
<%
	}else if(tab_name.equals("WAITLIST")){
%>
<iframe name="f_search" id="f_search"  scrolling="no" noresize src="../../eOT/jsp/SlateWaitlistSearch.jsp?<%=params%>" style="height:10vh;width:100vw" frameborder='0'></iframe>
<iframe name="f_query_add_mod" id="f_query_add_mod"  scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:90vh;width:100vw" frameborder='0'></iframe>
<%
	}else if(tab_name.equals("RESCHEDULE")){
%>
<iframe name="f_search" id="f_search"  scrolling="no" noresize src="../../eOT/jsp/SlateReScheduleSearch.jsp?<%=params%>" style="height:13vh;width:100vw" frameborder='0'></iframe>
<iframe name="f_query_add_mod" id="f_query_add_mod"  scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:87vh;width:100vw" frameborder='0'></iframe>
<%
	} else if(tab_name.equals("TOBERESCHEDULE")){
%>
	<iframe name="f_search" id="f_search"  scrolling="no" noresize src="../../eOT/jsp/RescheduleSearch.jsp?<%=params%>" style="height:18vh;width:100vw" frameborder='0'></iframe>
	<iframe name="qa_query_result" id="qa_query_result"  scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:82vh;width:100vw" frameborder='0'></iframe>
<% }else if(tab_name.equals("BOOKVERIFICATION")){ %>
<!-- MO-CRF-20082  052823 -->
	<iframe name="f_query_add_mod_1" id="f_query_add_mod_1"  scrolling="no" noresize src="../../eOT/jsp/VerificationSearch.jsp?<%=request.getQueryString()%>" style="height:5vh;width:100vw" frameborder='0'></iframe>
	<iframe name="f_query_add_mod" id="f_query_add_mod"  scrolling="no" noresize src="../../eOT/jsp/BookedcasesVerificationSearch.jsp?<%=request.getQueryString()%>" style="height:35vh;width:100vw" frameborder='0'></iframe>
	<iframe name='qa_query_result' id='qa_query_result' noresize src="../../eCommon/html/blank.html" scrolling="no" style='height:50vh;width:100vw' frameborder='0'></iframe>
	<iframe name='qa_query_result_tail' id='qa_query_result_tail' noresize src="../../eCommon/html/blank.html" style='height:10vh;width:100vw' frameborder='0'></iframe>
	<iframe name='messageFrame' id='messageFrame' noresize src='../../eCommon/jsp/error.jsp' noresize scrolling='no' frameborder='0'></iframe>
<% }%>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
</body></html>

