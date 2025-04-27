<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<%
	String queryString=request.getQueryString();
	String code_desc=request.getParameter("p_diag_scheme_desc");
%>
<title><fmt:message key="Common.search.label" bundle="${common_labels}"/>  <%=code_desc%> Code List</title>
<frameset rows='100%'>
<!--<frame name='code_desc' id='code_desc'    src='/eCIS/common/html/blank.html'  noresize  frameborder=no marginheight=0 marginwidth=0>-->
<frame name='code_desc' id='code_desc'    src='TermCodeSearch.jsp?<%=queryString%>'  noresize  frameborder=no marginheight=0 marginwidth=0>
</frameset>
</html>

