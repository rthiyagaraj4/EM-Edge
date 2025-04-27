<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	<%
     String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");
	 String function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");

	%>
    <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eMO/js/MOReleaseDeceased.js'></script>
	<script language='javascript' src='../../eMO/js/MoRegDetailsQuery.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

	<%
	String url="../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString() ;
	String source = url + params ;
	%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src="<%=source%>" frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='f_query_add_m</iframe>od' id='f_query_add_mod' src='../../eMO/jsp/MORegnDtlsQueryCriteria.jsp?callfrom=RevertRelease&function_id=<%=function_id%>' frameborder=0 scrolling='no' style='height:35vh;width:100vw'></iframe>
		<iframe name='MOFrame' id='MOFrame' src='../../eMO/jsp/MOManagePatTabs.jsp' frameborder=0 noresize scrolling='no' style='height:8vh;width:100vw'></iframe>
		<iframe name='result' id='result' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:30vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:8vh;width:100vw'></iframe>
		</iframe><iframe name='dispfr' id='dispfr' src='../../eMO/jsp/MOManageDeceasedColor.jsp' frameborder=0 noresize scrolling='no' style='height:10vh;width:100vw'></iframe>
</html>

