<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<% request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html>
<frameset rows='12%,0%,*%,5%' border ="0" id='TaskListRightFrameSet'>
		<frame src="../../eCA/jsp/TaskListRightFilter.jsp?<%=request.getQueryString()%>" name='TaskListRightFilterFrame' scrolling = "no" noresize frameborder='0'></frame>
		<frame src="../../eCommon/html/blank.html" name='TaskListRightHeaderFrame' scrolling = "no" noresize  frameborder='0'></frame>
		<frame src="../../eCommon/html/blank.html" name='TaskListRightResultFrame' scrolling = "auto" noresize  frameborder='0'></frame>
		<frame src="../../eCA/jsp/TaskListRightBottom.jsp?<%=request.getQueryString()%>" name='TaskListRightBottomFrame' scrolling = "no" noresize  frameborder='0'></frame>
</frameset>

</html>

