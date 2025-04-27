<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*" %>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	System.err.println("source for commontoolbar -->"+source);
	
%>



<script language='javascript' src='../../eSM/js/DefaultOnlinePrint.js'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> frameborder=0 scrolling='no' noresize style='height:9vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eSM/jsp/queryDefaultOnlinePrint.jsp'  frameborder=0 scrolling='auto' style='height:82vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no' style='height:9vh;width:100vw'></iframe>
</html>

