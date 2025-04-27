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
	String queryString=request.getQueryString();
%>
<html>
<head>
</head>
<!--<frameset rows ="18%,4%,73%, 5%" frameborder=0 id="main_frame">-->
	<iframe name='multiPatientOrdersResultingMainHdr' id='multiPatientOrdersResultingMainHdr' src="../../eOR/jsp/ORMultiPatientOrdersResultingMainHdr.jsp?<%=queryString%>" frameborder='0' noresize scrolling='YES' id="main_hdr"  style='height:18vh;width:100vw'>
	</iframe>
	<iframe name='multiPatientOrdersResultingMainHdrButtons' id='multiPatientOrdersResultingMainHdrButtons' src="../../eOR/jsp/ORMultiPatientOrdersResultingMainHdrButtons.jsp?" frameborder='0' noresize scrolling='NO' style='height:5vh;width:100vw'>
	</iframe>
	<!--<FRAMESET COLS="50%,*" frameborder='1'>-->
	<IFRAME name='multiPatientOrdersResultingMainResultData'   id='multiPatientOrdersResultingMainResultData' SRC="../../eCommon/html/blank.html" FRAMEBORDER="0" scrolling='auto'  style='height:60vh;width:49vw'></IFRAME>
		<IFRAME name='multiPatientOrdersResultingMainResultValues' id='multiPatientOrdersResultingMainResultValues' SRC="../../eCommon/html/blank.html" FRAMEBORDER="0" scrolling='YES' noresize  style='height:50vh;width:48vw'></IFRAME>
	<!--</FRAMESET>-->

	<iframe name="multiPatientOrdersResultingMainButtons" id="multiPatientOrdersResultingMainButtons" src="../../eCommon/html/blank.html"frameborder='0' noresize scrolling="NO"  style='height:5vh;width:100vw'>
	</iframe>
<!--</frameset>-->
</html>
