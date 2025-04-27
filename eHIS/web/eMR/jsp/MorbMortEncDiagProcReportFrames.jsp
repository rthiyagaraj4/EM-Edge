<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html> 

<head>
    <%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src="../../eCommon/js/DateUtils.js"></script>
	<script src="../../eMR/js/MRReports.js"></script>
</head>

<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String url = "../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString();
	String source = url + params;
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder='0' scrolling='no' noresize frameborder='0' style='height:42%;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eMR/jsp/MorbMortEncDiagProcReportCriteria.jsp?' frameborder='0' scrolling='no' noresize frameborder='0' style='height:100vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 scrolling='auto' noresize frameborder='0' style='height:50%;width:100vw'></iframe>


</html>

