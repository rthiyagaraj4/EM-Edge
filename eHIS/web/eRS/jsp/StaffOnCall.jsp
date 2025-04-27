<!DOCTYPE html>
<!--StaffOnCall.jsp
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	
*	Created By		:	Suchilagna Panigrahi
*	Created On		:	12th May 2005
-->
<html>
<%
String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
String params = request.getQueryString();
String source = url + params ;
String title="";
String mode=request.getParameter("p_mode")==null?"":request.getParameter("p_mode");
%>
<head>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<!-- <script language="javascript" src="../../eRS/js/RSMessages.js"></script> -->
<script language="javascript" src="../js/StaffOnCall.js"></script>
<%
if(mode.equals("CA")) 
{
title="Staff On Call";
%>
<title><%=title%></title>
</head>

<%
}
else
{
%>
</head>
<%
}
if(mode.equals("CA")) {%>
<iframe name='commontoolbarFrame'	src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:0vh;width:100vw'></iframe>
<iframe name='f_query_view' src='../../eRS/jsp/StaffOnCallCriteria.jsp?<%= request.getQueryString()%>' frameborder=0 scrolling='no' style='height:12vh;width:100vw'></iframe>
<iframe name='f_query_detail' src='../../eRS/jsp/StaffOnCallResult.jsp' frameborder=0 style='height:26vh;width:100vw'></iframe>
<iframe name='messageFrame'	src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
	<%}else{%>
<iframe name='commontoolbarFrame'	src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
<iframe name='f_query_view' src='../../eRS/jsp/StaffOnCallCriteria.jsp?<%= request.getQueryString()%>' frameborder=0 scrolling='no' style='height:12vh;width:100vw'></iframe>
<iframe name='f_query_detail' src='../../eCommon/html/blank.html' frameborder=0 style='height:71vh;width:100vw'></iframe>
<iframe name='messageFrame'	src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
	<%}%>

</html>
