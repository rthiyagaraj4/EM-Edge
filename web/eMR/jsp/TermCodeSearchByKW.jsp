<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
 <html>

<%
	String queryString=request.getQueryString();
	String term_set_desc = request.getParameter("term_set_desc")==null?"":request.getParameter("term_set_desc");
%>
<title><fmt:message key="Common.search.label" bundle="${common_labels}"/>  <%=term_set_desc%> Code List</title>
	<iframe name='TermCodeSearchByKWMainFrame' id='TermCodeSearchByKWMainFrame'    src='TermCodeSearchByKWMain.jsp?<%=queryString%>'  noresize  frameborder=no marginheight=0 marginwidth=0 style='height:100%;width:100vw'></iframe>
</html>

