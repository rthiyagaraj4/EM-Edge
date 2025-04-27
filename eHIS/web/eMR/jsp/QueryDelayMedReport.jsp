<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<html>
<head>
	<%String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language ='javascript' src='../../eMR/js/PrepareMedReport.js'></script>
	<script language='javascript' src="../js/ReportRequestQuery.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
	String url="../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString() ;	
	String source = url + params ;
	String function_id=request.getParameter("function_id");
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:7vh;width:100vw'></iframe>
	<iframe name='criteriaFrame' id='criteriaFrame' 	src='../jsp/ReportRequestQueryCriteria.jsp?call_function=<%=function_id%>&function_id=<%=function_id%>' frameborder=0 scrolling='no' noresize style='height:35vh;width:100vw'></iframe>
	<iframe name='resultFrame' id='resultFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:50vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no' noresize style='height:8vh;width:100vw'></iframe>


</html>

