<!DOCTYPE html>
<!--Grade.jsp
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 			:	
*	Created By		:	Janet George
*	Created On		:	13 Jan 2005-->
<html>
<head>
<%@ page session="false" %>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/RSCommon.js"></script>
<!-- <script language="JavaScript" src="../js/RSMessages.js"></script> -->
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<!-- <script language="javascript" src="../../eCommon/js/messages.js"> </script> -->
<script language="javascript" src="../js/Grade.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>
<%
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
 	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' frameborder=0 style='height:79vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:13vh;width:100vw'></iframe>
</html>

