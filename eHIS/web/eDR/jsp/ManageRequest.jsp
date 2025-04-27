<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8"  %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
	<Script language="JavaScript" src="../../eDR/js/ManageRequest.js" ></Script>
	<Script language="JavaScript" src="../../eCommon/js/common.js" ></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	
%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> scrolling='no' noresize style='height:8vh;width:100vw' frameborder='0'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eDR/jsp/ManageRequestFrameSet.jsp'  style='height:83vh;width:100vw' frameborder='0'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp'  noresize scrolling='auto' style='height:9vh;width:100vw;border:none' frameborder='0'></iframe>
</html>

