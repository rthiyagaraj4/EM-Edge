<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<% request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html>
<iframe src="../../eCA/jsp/PatTaskListCriteria.jsp?<%=request.getQueryString()%>" name='patTaskListCriteriaFrame' scrolling = "no" noresize frameborder='0' style='height:36%;width:100vw'></iframe>
		<iframe src="../../eCommon/html/blank.html" name='patTaskListPrevNextFrame' id='patTaskListPrevNextFrame' scrolling = "no" noresize  frameborder='0' style='height:0%;width:100vw'></iframe>
		<iframe src="../../eCommon/html/blank.html" name='patTaskListResultFrame1' id='patTaskListResultFrame1' scrolling = "auto" noresize  frameborder='0' style='height:0%;width:100vw'></iframe>
		<iframe src="../../eCommon/html/blank.html" name='patTaskListResultFrame' id='patTaskListResultFrame' scrolling = "auto" noresize  frameborder='0' style='height:100vh;width:100vw'></iframe>
	 <iframe src="../../eCommon/html/blank.html" name='patTaskListStatusFrame' id='patTaskListStatusFrame' scrolling = "no" noresize  frameborder='0' style='height:0%;width:100vw'></iframe>
	 <iframe src="PatTaskListStatus.jsp" scrolling = "no"  name='blankFrame' id='blankFrame' style='height:5%;width:100vw'></iframe>
	

</html>

