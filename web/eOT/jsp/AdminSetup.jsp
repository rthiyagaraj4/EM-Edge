<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>

<html>
<head>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	//String source = url + params ;
%>
</head>

<iframe src="OTAdminSetupFunctions.jsp?query_string=<%=params%>" name="master_menu" id="master_menu" scrolling='yes' noresize style='height:100vh;width:4vw';border='0'></iframe>
	<iframe src="../../eCommon/html/blank.html" name="master_pages" id="master_pages" style='height:100vh;width:16vw';border='0'></iframe>
</html>

