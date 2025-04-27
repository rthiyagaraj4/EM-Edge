<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html>
  <head>
	<script language='javascript' src='../js/MultiFacilityProcessing.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%@ page session="false" %>
   </head>
     <iframe name='f_query_add_mod_list' id='f_query_add_mod_list'	src='../../eOR/jsp/MultiFacilityProcessingList.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	  <iframe name='f_query_add_mod_result' id='f_query_add_mod_result' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:92vh;width:100vw'></iframe>
</html>

