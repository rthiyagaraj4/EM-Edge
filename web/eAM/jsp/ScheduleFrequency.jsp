<!DOCTYPE html>

<%
/*
*
*	Application		:	eAM
*   File Name       :	ScheduleFrequency.jsp
*	
*
*	Created On		:	21-02-2005
*/
%>	

<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eOR
*	Purpose 		:	
*	Created By		:	
*	Created On		:	08 Nov 2002

--%>
<html>
<head>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" session="false" %>
<script language="JavaScript" src="../../eAM/js/ScheduleFrquency.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language="JavaScript" src="../../eOR/js/OrMessages.js"></script>
<script>function_id = "<%=request.getParameter("function_id")%>";</script>
</head>
<%
    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
 	String params = request.getQueryString() ;
	String source = url + params ;

%>
	<iframe name='commontoolbarFrame'	src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe> 
	<iframe name='f_query_add_mod' src='../../eCommon/html/blank.html' frameborder=0  scrolling='auto' style='height:80vh;width:100vw'></iframe> 
	<iframe name='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe> 
</html>
