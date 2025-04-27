<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title>Mothercare Pending Tasks</title>
		<%
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			String queryString = request.getQueryString() == null ? "" : request.getQueryString();
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	</head>
	<iframe name='recMatPendingTasksListFrame' id='recMatPendingTasksListFrame' src='../../eCA/jsp/RecMaternityPendingTasksList.jsp?<%=queryString%>' frameborder="yes" scrolling="no"  style='height:100vh;width:100vw'></iframe>
		<iframe name='recMatPendingTasksToolbarFrame' id='recMatPendingTasksToolbarFrame' src='../../eCA/jsp/RecMaternityPendingTasksToolBar.jsp?<%=queryString%>' frameborder="yes" scrolling="no"  style='height:8%;width:100vw'></iframe>
	
</html>

