<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import= "java.sql.*, java.util.*,webbeans.eCommon.*" %>
<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String oper = request.getParameter("oper");
%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script src="../../eCommon/js/common.js" language="javascript"></script>
		<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
		<script language='javascript' src='../../eOP/js/ResourceForLocnByPract.js'></script>
	</head>
	<iframe name='res_locn_by_pract_crit' id='res_locn_by_pract_crit' src='../jsp/ResourceForLocnByPractCrit.jsp?oper=<%=oper%>'  frameborder=0 frameborder='0' style='height:20vh;width:100vw'></iframe><iframe name='res_locn_by_pract_result' id='res_locn_by_pract_result'	src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' frameborder='0' style='height:80vh;width:100vw'></iframe>
</html>

