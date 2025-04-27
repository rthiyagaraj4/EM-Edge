<!DOCTYPE html>
<!--
*	Copyright � iSoft Solutions (P) Ltd.
*	Created By		:	Anjanyeya Reddy M 
	

*	Created On		:	18 Dec 2008
-->


<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>

<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>


<script language="JavaScript" src="../../eMR/js/RecodePrivilegeSetup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<%
	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
 	String params = request.getQueryString() ;
	String source = url + params ;
	
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:10vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:80vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='NO' style='height:25%;width:100vw'></iframe>
</head>
<body onKeyDown='lockKey()'>
</body>
</html>

