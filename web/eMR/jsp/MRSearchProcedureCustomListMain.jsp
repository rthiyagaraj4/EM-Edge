<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
    request.setCharacterEncoding("UTF-8");
	String queryString=request.getQueryString();
%>

	<iframe name='group_head' id='group_head' src='MRSearchProcedureCustomListGroup.jsp?<%=queryString%>' noresize  scrolling=auto  frameborder=no  marginheight=0 marginwidth=0></iframe><iframe name='code_description' id='code_description'    src='../../eCommon/html/blank.html'  noresize  frameborder=no scrolling=no  marginheight=0 marginwidth=0></iframe>

</html>

