<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%

%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<html>
<head>
 
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!-- <script language="JavaScript" src="../js/OrMessages.js"></script> -->
	
<!-- 	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
 -->	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<!-- <script language="JavaScript" src="../js/OrMessages.js"></script> -->
	<script language="JavaScript" src="../js/Template.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%@ page session="false" %>
	<script>function_id = "<%=request.getParameter("function_id")%>";
	</script>
	</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
	<iframe name="commontoolbarFrame" id="commontoolbarFrame" src='<%=source%>' scrolling='no' noresize frameborder='no' style='height:8vh;width:100vw'></iframe>
	<iframe name="f_query_add_mod" id="f_query_add_mod" frameborder='no' scrolling='no' noresize src="../../eCommon/html/blank.html" style='height:80vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder='no' noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
 
</html>

