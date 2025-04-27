<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script type='text/javascript' src='../../eOT/js/Booking.js'></script>
<script language="Javascript" src="../../eOT/js/WaitList.js"></script>
	<script type="text/javascript" src="../../eOT/js/OTCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String url = "../../eOT/jsp/OTCommonToolBar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String calledFrom = request.getParameter("calledFrom") == null ? "" : request.getParameter("calledFrom"); //IN052054
%>
<script>
</script>
<form name="OTSlateForm" id="OTSlateForm">
	<input type='hidden' name='params' id='params' value='<%=params%>'>
	<input type='hidden' name='qury' id='qury' value='<%=source%>'>
	<input type='hidden' name='Slate_Booking_Verification' id='Slate_Booking_Verification' value='SLATE_VER_TAB'>
</form>

<%
	//IN052054 start
	if(calledFrom != null && calledFrom.equalsIgnoreCase("CA"))
	{
%>
		<frameset>
			<frame name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../eOT/jsp/SlateFrames.jsp?<%=params%>"  frameborder='0'>
		</frameset>
<%
	}
	else
	{
	//IN052054 end
%>
<frameset rows='42,*'>
<frame name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%= source %>"  frameborder='0'>
			<frame name="f_query_add_mod" id="f_query_add_mod" frameborder="0" scrolling="no" noresize src="../../eOT/jsp/SlateFrames.jsp?<%=params%>"  frameborder='0'>
</frameset>
<%
	} //IN052054
%>


</html>

