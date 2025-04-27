<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--TickSheets.jsp -->
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<script language='javascript' src='../../eOR/js/TickSheets.js'></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!--<script language="JavaScript" src="../js/ORGeneral.js"></script>-->
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%@ page session="false" %>
</head>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	//String params = request.getQueryString() ;
	//String source = url + params ;
%>
<iframe name='f_query_add_mod_header' id='f_query_add_mod_header' src='../../eCommon/html/blank.html' frameborder=0 style='height:10vh;width:100vw'></iframe>
<iframe name='f_query_add_mod_detail' id='f_query_add_mod_detail' src='../../eCommon/html/blank.html' frameborder=0 style='height:90vh;width:100vw'></iframe>
</html>

