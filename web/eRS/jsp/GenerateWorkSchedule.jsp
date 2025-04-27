<!DOCTYPE html>
<!-- GenerateWorkSchedule.jsp -->
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 			:	
*	Created By		:	Suresh.S
*	Created On		:	16 Nov 2004
--%>
<html>
<head>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
  	<script language="JavaScript" src="../js/RSCommon.js"></script>
	<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<!-- <script language="javascript" src="../js/RSMessages.js"></script> -->
	<script language="javascript" src="../js/GenerateWorkSchedule.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String url ="../../eCommon/jsp/commonToolbar.jsp?";
 	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eRS/jsp/GenerateWorkScheduleFrameset.jsp' frameborder=0 style='height:83vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
</html>

