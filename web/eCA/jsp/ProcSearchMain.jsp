<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String queryString=request.getQueryString();
	String s_scheme_desc=request.getParameter("s_scheme_desc");
	
%>
<title><fmt:message key="Common.search.label" bundle="${common_labels}"/><%=s_scheme_desc%> <fmt:message key="Common.code.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.List.label" bundle="${common_labels}"/>-</title>
<iframe name='group_head' id='group_head' src='../../eCA/jsp/ProcSearch.jsp?<%=queryString%>' noresize  frameborder=no marginheight=0 marginwidth=0 style='height:17%;width:100vw'></iframe><iframe name='code_desc' id='code_desc'    src='../../eCommon/html/blank.html'  noresize  frameborder=no marginheight=0 marginwidth=0 style='height:100vh;width:100vw'></iframe><iframe name='group_head1' id='group_head1' src='../../eCa/jsp/ProcSearchCancel.jsp' noresize  frameborder=no marginheight=0 marginwidth=0 style='height:10%;width:100vw'></iframe>
</html>

