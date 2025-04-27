<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String header_values = request.getParameter("header_values");
String result_format = request.getParameter("result_format");
%>
<html>
<head>
</head>
<!--<frameset rows ="17%,5%,73%, 5%" frameborder='0' id="main_frame">-->

	<iframe name='multiPatientOrdersResultingHdr' id='multiPatientOrdersResultingHdr' src="../../eOR/jsp/ORMultiPatientOrdersResultingHdr.jsp?header_values=<%=header_values%>&result_format=<%=result_format%>" frameborder='0' noresize scrolling='no' style='height:18vh;width:100vw'>
	</iframe>

	<iframe name="multiPatientOrdersResultingHdrDtl" id="multiPatientOrdersResultingHdrDtl" src="../../eCommon/html/blank.html"  noresize frameborder='0' scrolling='NO' style='height:5vh;width:100vw'>
	</iframe>

	<iframe name="multiPatientOrdersResultingHdrResult"  id="multiPatientOrdersResultingHdrResult" src="../../eCommon/html/blank.html"frameborder='0' noresize
	scrolling="YES"  style='height:71vh;width:100vw'></iframe>

	<iframe name="multiPatientOrdersResultingHdrButtons"  id="multiPatientOrdersResultingHdrButtons" src="../../eCommon/html/blank.html"frameborder='0' noresize
	scrolling="NO"  style='height:22vh;width:100vw'></iframe>
	
<!--</frameset>-->
</html>

