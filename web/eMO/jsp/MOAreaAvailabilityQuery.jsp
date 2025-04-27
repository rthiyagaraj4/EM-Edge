<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
		<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");

%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script language='javascript' src='../../eMO/js/MOAreaAvailabilityQuery.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		<title><fmt:message key="eMO.LocationAvailability.label" bundle="${mo_labels}"/></title>
		
</head>
<%
		String url="../../eCommon/jsp/commonToolbar.jsp?";
		String params = request.getQueryString() ;
		String source = url + params ;
		String param=request.getParameter("param");
		if(param == null) param="";
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='criteria' id='criteria' src='../jsp/MOAreaAvailabilityQueryCriteria.jsp' frameborder=0 scrolling='no' style='height:12vh;width:100vw'></iframe>
		<iframe name='result' id='result' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:71vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
</html>

