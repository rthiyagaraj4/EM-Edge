<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<% 	request.setCharacterEncoding("UTF-8");	%>
<%
	String queryString=request.getQueryString();
	String s_scheme_desc=request.getParameter("s_scheme_desc");
%>
<title><fmt:message key="Common.search.label" bundle="${common_labels}"/>  <%=s_scheme_desc%> Code List-</title>
<frameset rows='17%,*'>
<frame name='group_head' id='group_head' src='../../eMR/jsp/MRProcSearch.jsp?<%=queryString%>' noresize  frameborder=no marginheight=0 marginwidth=0 scrolling=no>
<frame name='code_desc' id='code_desc'    src='../../eCommon/html/blank.html'  noresize  frameborder=no marginheight=0 marginwidth=0>
<!-- <frame name='group_head1' id='group_head1' src='../../eCA/jsp/SearchCancel.jsp' noresize  frameborder=no marginheight=0 marginwidth=0> -->
</frameset>
</html>

