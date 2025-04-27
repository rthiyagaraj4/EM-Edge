<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<% 	request.setCharacterEncoding("UTF-8");	%>
<title><%=request.getParameter("s_scheme_desc")%></title>
</head>
<%
	String queryString=request.getQueryString();	
%>
<iframe name='group_head' id='group_head' src='MRSearchProcedureTabs.jsp?<%=queryString%>' noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='no' style='height:5%;width:100vw'></iframe><iframe name='group_head' id='group_head' src='MRSearchProcedureCustomListMain.jsp?<%=queryString%>' noresize  scrolling=no  frameborder=no  marginheight=0 marginwidth=0 style='height:100vh;width:100vw'></iframe><iframe name='group_head' id='group_head' src='SearchCancel.jsp' noresize  frameborder=no marginheight=0 marginwidth=0 style='height:10%;width:100vw'></iframe>
</html>

