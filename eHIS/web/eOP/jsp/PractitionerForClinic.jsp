<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<%
		request.setCharacterEncoding("UTF-8");

request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		<%
		String function_id=request.getParameter("function_id");

		if(function_id == null) function_id="";
		if(function_id.equals("PRACT_FOR_CLINIC"))
		{
		%>
			<script language='javascript' src='../../eOP/js/PClinic.js'></script>
		<%
		}
		else if(function_id.equals("RESOURCE_FOR_PROC_UNIT"))
		{
		%>
			<script language='javascript' src='../../eOP/js/ResourceForUnit.js'></script>

		<%
		}
		%>

	</head>
		<%
			String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
			String params = request.getQueryString() ;
			String source = url + params ;
		%>

	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html'  frameborder=0 style='height:80vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>

<form>
	<input type=hidden name='function_id' id='function_id' value=<%=function_id%>>
	</form>
</html>

