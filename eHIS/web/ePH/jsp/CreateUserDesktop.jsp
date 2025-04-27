<!DOCTYPE html>
 
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	    <script src="../../ePH/js/CreatUserDesktop.js" language="javascript"></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>

</head>
<%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
%>

	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:84vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:8vh;width:100vw'></iframe>

<SCRIPT LANGUAGE="JavaScript">


</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</html>

