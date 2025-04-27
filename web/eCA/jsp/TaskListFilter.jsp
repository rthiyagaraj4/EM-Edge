<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<% request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html>

<title>Filter Window</title>
<frameset rows='*%,15%' border ="0" id='TaskListFilterFrameSet'>
		<frame src="../../eCA/jsp/TaskListFilterOptionsSet.jsp?<%=request.getQueryString()%>" name='TaskListFilterSet' scrolling = "no" noresize frameborder='0'></frame>
		<frame src="../../eCA/jsp/TaskListFilterOptionsRecord.jsp?<%=request.getQueryString()%>" name='TaskListFilterBottom' scrolling = "no" noresize  frameborder='0'></frame>
</frameset>
</html>

