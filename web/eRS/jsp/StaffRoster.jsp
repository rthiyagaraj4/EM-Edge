<!DOCTYPE html>
<!--StaffProfile.jsp
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 			:	
*	Created By		:	Karabi S
*	Created On		:	2nd Dec 2004-->
<%@ page language="java" contentType="text/html;charset=UTF-8"  import ="java.util.*, java.sql.*,eCommon.Common.*,webbeans.eCommon.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String title="";
String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
String params = request.getQueryString();
String source = url + params ;
String mode=request.getParameter("p_mode")==null?"":request.getParameter("p_mode");
%>
<html>
<head>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/RSCommon.js"></script>
<!-- <script language="JavaScript" src="../js/RSMessages.js"></script>
<script language="javascript" src="../../eCommon/js/messages.js"> </script -->
<script language="javascript" src="../js/StaffRoster.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
if(mode.equals("CA")) 
{
title="My Roster";
%>
<title><%=title%></title>
</head>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:91vh;width:100vw'></iframe>
<iframe name='f_query_view' id='f_query_view' src='../../eRS/jsp/StaffRosterDisplay.jsp?<%=request.getQueryString()%>' frameborder=0 style='height:9vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:48%;width:100vw'></iframe>
<%
}
else
{
%>
</head>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
<iframe name='f_query_view' id='f_query_view' src='../../eRS/jsp/StaffRosterDisplay.jsp?<%=request.getQueryString()%>' frameborder=0 style='height:83vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
<%
}
%>
</html>

