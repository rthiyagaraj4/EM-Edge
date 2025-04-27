<!DOCTYPE html>
<!-- Same from (eHIS/OP/jsp')  Revise Visit Function from OP Module -->
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html> 
<head> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");

%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
	
	<title><fmt:message key="eMO.InternalReport.label" bundle="${mo_labels}"/></title>
<script>
function reset()
	{
	if(group_head.document.SearchVisit)
	{
	   group_head.location.href = '../../eMO/jsp/MOInternalReportQueryCriteria.jsp?param=';
	   code_desc.document.location.href='../../eCommon/html/blank.html' ;
	} 
	}
</script>
	<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
       <!--  <frameset rows='5%,35%,26%,34%' frameborder=no  framespacing='0'> -->
		<frameset rows='6%,20%,*,5%' frameborder=no  framespacing='0'>
			<frame name='commontoolbarFrame' src=<%= source %> frameborder=0 scrolling='no' noresize>
			<frame name='group_head'  noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='no' src='../../eMO/jsp/MOInternalReportQueryCriteria.jsp'>
			<frame name='code_desc'   src='../../eCommon/html/blank.html'   noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='auto'>
			 <frame name='messageFrame' src='../../eCommon/jsp/error.jsp'  noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='auto'> -->
		</frameset>
</html>

