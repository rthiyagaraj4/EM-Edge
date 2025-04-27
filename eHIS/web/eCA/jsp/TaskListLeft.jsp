<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
22/03/2012    IN29559       DineshT      Record consent criteria in TaskList function
---------------------------------------------------------------------------------------------------------------
--> 

<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<% request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");

String rows ="";
if (patient_id.equals(""))
{
	rows = "50%,37%,20%";
}
else 
{
	rows = "50%,24%,25%"; //rows='35%,30%,35%'
}
%>
<html>
<frameset rows='<%=rows%>' border ="0" id='TaskListLeftFrameSet'>
		<frame src="../../eCA/jsp/TaskListCalendarFrameSet.jsp?<%=request.getQueryString()%>" name='TaskListLeftCalanderFrame' scrolling = "no" noresize frameborder='0'></frame>
		<frame src="../../eCA/jsp/TaskListLeftPatientSearch.jsp?<%=request.getQueryString()%>" name='TaskListLeftPatientSearchFrame' scrolling = "no" noresize  frameborder='0'></frame>
		<frame src="../../eCA/jsp/TaskListLeftStatus.jsp?<%=request.getQueryString()%>" name='TaskListleftStatusFrame' scrolling = "auto" noresize  frameborder='0'></frame><!--IN29559 -->
</frameset>

</html>

