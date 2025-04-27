<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%	request.setCharacterEncoding("UTF-8");	%>
<script>

</script>
<%
	String param = request.getQueryString();
	System.err.println("====param===ammendBookingsFrame======="+param);
%>
<TITLE>Amend Booking</TITLE>
<iframe name='dateSelectFrame' id='dateSelectFrame' src="../../eOT/jsp/ammendBookings.jsp?<%=param%>" noresize style='height:30vh;width:100vw'></iframe>
	<iframe name='dispSlotsFrame' id='dispSlotsFrame' src="../../eCommon/html/blank.html"  noresize style='height:65vh;width:100vw'></iframe>
	<iframe name='dispRecsFrame' id='dispRecsFrame' src="../../eCommon/html/blank.html"  noresize style='height:5vh;width:100vw'></iframe> <!-- Added against 57524 -->


