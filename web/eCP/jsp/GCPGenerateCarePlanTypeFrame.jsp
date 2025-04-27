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
<html>
<%
 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//This file is saved on 18/10/2005.
String queryStr = request.getQueryString();
%>
<iframe name='GeneratePlanTypeShowBtn' id='GeneratePlanTypeShowBtn' src='../../eCP/jsp/GCPGeneratePlanTypeBtn.jsp' frameborder=0 scrolling=no noresize style='display:none;height:0vh;width:98vw'></iframe> 
	
	<iframe name='GeneratePlanTypeTop' id='GeneratePlanTypeTop' src='../../eCommon/html/blank.html' frameborder=0 scrolling=no noresize style='display:none;height:0vh;width:98vw'></iframe> 
	
	<iframe name='GeneratePlanTypeBottom' id='GeneratePlanTypeBottom' src='../../eCP/jsp/GCPGeneratePlanTypeBtn.jsp?&shw_nothing=Nothing' frameborder=0 scrolling=no noresize style='display:none;height:0vh;width:98vw'></iframe>
	
	<iframe name='GeneratePlanDetail' id='GeneratePlanDetail' src='../../eCP/jsp/GCPGeneratePlanTypeBtn.jsp?&shw_nothing=Nothing' frameborder=0 scrolling=auto noresize style='display:none;height:0px;width:98vw'></iframe>
	
	<iframe name='GeneratePlanTypeBtn' id='GeneratePlanTypeBtn' src='../../eCP/jsp/GCPGeneratePlanTypeBtn.jsp' frameborder=0 scrolling=no noresize style='height:40vh;width:98vw'></iframe>

	<iframe name='GeneratePlanTypeLinks' id='GeneratePlanTypeLinks'	src='../../eCP/jsp/GCPGeneratePlanProfileDiagLegend.jsp?<%=queryStr+"&link=Links"%>'  frameborder=0 scrolling='no' noresize style='display:none;height:0px;width:98vw'></iframe> 
 

</html>

