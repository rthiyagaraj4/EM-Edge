<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- 
	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Jerome
*	Created On		:	19/01/2005
* --%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%
 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html>
<head>
</head>
<!-- //This file is saved on 18/10/2005.-->
<iframe name='GeneratePlanProfileDiagnosis' id='GeneratePlanProfileDiagnosis'	src='../../eCP/jsp/GCPGeneratePlanProfileDiagnosis.jsp?<%=request.getQueryString()%>'  frameborder=0 scrolling='auto' noresize style='height:52vh;width:98vw'></iframe>
	<iframe name='GeneratePlanProfileType' id='GeneratePlanProfileType' src="../../eCP/jsp/GCPGeneratePlanProfileType.jsp?<%=request.getQueryString()%>"  frameborder=0 scrolling='auto' noresize style='height:40vh;width:98vw'></iframe>


</html>

