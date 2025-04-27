<!DOCTYPE html>

<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Name			:	StaffProfileSetup
*	Purpose 		:	
*	Created By		:	Suresh.S
*	Created On		:	20 Nov 2004

--%>
<html>
<head>
<%@ page session="false" %>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<!-- <script language="javascript" src="../js/RSMessages.js"></script> -->
<script language="javascript" src="../js/StaffProfileSetup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
 	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> frameborder=0 scrolling='no'  style='height:10vh;width:100vw'></iframe><iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eRS/jsp/StaffProfileSetupFrameSet.jsp' frameborder=0 noresize style='height:82vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0  scrolling='auto' style='height:8vh;width:100vw'></iframe>
</html>

