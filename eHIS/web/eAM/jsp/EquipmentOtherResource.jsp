<!DOCTYPE html>
<%--
	FileName	: EquipmentOtherResource.jsp
	Version	    : 3	
	Modified On	: 17-2-2005
--%>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eAM/js/EquipmentOtherResource.js'></script>
			<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


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

	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' 		src='../../eCommon/html/blank.html' frameborder=0 style='height:80vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>

</html>

