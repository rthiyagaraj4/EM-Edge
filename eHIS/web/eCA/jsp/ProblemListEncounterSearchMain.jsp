<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title><fmt:message key="Common.encounterdetails.label" bundle="${common_labels}"/></title>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String QryStr = request.getQueryString();
%>
</head>
<iframe name='ProblemListEncounterSearchResultFrame' id='ProblemListEncounterSearchResultFrame' src='../../eCA/jsp/ProblemListEncounterSearchResult.jsp?<%=QryStr%>' frameborder=0 scrolling = auto style='height:85vh;width:98vw'></iframe>
<iframe name='ProblemListEncounterSearchActionButtonFrame' id='ProblemListEncounterSearchActionButtonFrame' src='../../eCA/jsp/ProblemListEncounterSearchActionButton.jsp?<%=QryStr%>' frameborder=0 scrolling = no style='height:10vh;width:98vw'></iframe>
</html>

