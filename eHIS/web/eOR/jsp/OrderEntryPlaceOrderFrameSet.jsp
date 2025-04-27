<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head><title><fmt:message key="eOR.PlaceOrderFrameSet.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	
</head>
<%			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

	String order_category = request.getParameter("order_category");
	if(!order_category.equals("PH")) { 
%>	
	<iframe name="criteriaMainFrame" id="criteriaMainFrame" src= "../../eOR/jsp/OrderEntryPlaceOrderHeader.jsp?<%=request.getQueryString()%>" framespacing="0"  frameborder="0" scrolling="no"  style="height:20vh;width:98vw"></iframe>
		<iframe name="legendsFrame" id="legendsFrame" src= "../../eCommon/html/blank.html" frameborder=0  style="height:8vh;width:101vw"></iframe>
		<iframe name="placeOrderDetailFrame" id="placeOrderDetailFrame" src= "../../eCommon/html/blank.html" framespacing="0"  frameborder="0"  scrolling="yes" style="height:47vh;width:100vw"></iframe>
		<iframe name="criteriaDetailFrame" id="criteriaDetailFrame" src= "../../eOR/jsp/OrderEntryButtons.jsp?<%=request.getQueryString()%>" framespacing="0"  frameborder="0"  scrolling="no" style="height:27vh;width:100vw"></iframe>
	
<% 	} %>
<script>
  // Function to synchronize scroll
  function syncScroll() {
    const placeOrderFrame = document.getElementById('placeOrderDetailFrame');
    const legendsFrame = document.getElementById('legendsFrame');

    placeOrderFrame.contentWindow.document.addEventListener('scroll', () => {
      legendsFrame.contentWindow.scrollTo(0, placeOrderFrame.contentWindow.document.documentElement.scrollTop);
    });
  }

  // Ensure the function is called after the frames are loaded
  window.onload = syncScroll;
</script>


</html>		


