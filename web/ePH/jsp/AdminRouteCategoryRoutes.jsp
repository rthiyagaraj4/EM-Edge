<!DOCTYPE html>
<!-- TerminologyCodeForCaseType.jsp -->
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	ePH
*	Purpose 		:	
*	Created By		:	Abdul Sukkur
*	Created On		:	28 Oct 2009

--%>
<%@page contentType="text/html; charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<html>
<head>
<!-- <script src="../../eCommon/js/MstCodecommon.js" language="javascript"></script> -->
<script language="JavaScript" src="../../ePH/js/AdminRouteCategoryRoutes.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
//This file is saved on 18/10/2005.
	 request.setCharacterEncoding("UTF-8");
//Added  for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added  for MMS-ME-SCF-0097 ends
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
 	String params = request.getQueryString() ;
	String source = url + params ;
	
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../../ePH/jsp/AdminRouteCategoryRoutesFrameSet.jsp' frameborder=0 noresize style='height:83vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
</head>
<body>
</body>
</html>

