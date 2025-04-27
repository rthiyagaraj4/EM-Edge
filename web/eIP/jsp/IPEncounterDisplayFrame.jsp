<!DOCTYPE html>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	String queryString=request.getQueryString();
	request.setCharacterEncoding("UTF-8");
%>
<title><fmt:message key="Common.encounterdetails.label" bundle="${common_labels}"/></title>
	<iframe name='group_head' id='group_head' src='../../eIP/jsp/IPEncounterDisplay.jsp?<%=queryString%>' noresize  frameborder=no marginheight=0 marginwidth=0 style='height:*%;width:100vw'></iframe><iframe name='group_head1' id='group_head1' src='../../eCommon/html/blank.html' noresize  frameborder=no marginheight=0 marginwidth=0 style='height:0%;width:100vw'></iframe>
</html>

