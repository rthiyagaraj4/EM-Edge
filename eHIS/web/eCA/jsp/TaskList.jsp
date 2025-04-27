<!DOCTYPE html>
<%/*
------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      	Name        	Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
30/07/2019	IN070610		Dinesh T		30/07/2019		Ramesh G		TBMC-CRF-0011.1				
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,java.util.*,eCA.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
eCA.PatTaskListRepository patTask = (eCA.PatTaskListRepository)getObjectFromBean("patTask","eCA.PatTaskListRepository",session);
String backfrom=request.getParameter("backfrom")==null?"":request.getParameter("backfrom");
//IN070610, starts
ArrayList<String> funcIds = new ArrayList<String>();
funcIds.add("UPLOAD_TR_CATEGORY_ORDERS");
funcIds.trimToSize();
patTask.adapter.setSiteSpecific(funcIds, "OR");
//IN070610, ends
if(!backfrom.equals("ResultEntry"))
{
	patTask.clearHashValues();
}
String facility_id = (String)session.getValue("facility_id");
String clinician_id		= (String) session.getValue("ca_practitioner_id");//IN067210
patTask.getTaskApplicability(facility_id, clinician_id); 
%>
<html>
<frameset cols='200,*,' border ="0" id='TaskListFrameSet'>
		<frame src="../../eCA/jsp/TaskListLeft.jsp?<%=request.getQueryString()%>" name='TaskListLeftFrame' scrolling = "no" noresize frameborder='0'></frame>
		<frame src="../../eCA/jsp/TaskListRight.jsp?<%=request.getQueryString()%>" name='TaskListRightFrame' scrolling = "no" noresize  frameborder='0'></frame>
</frameset>
</html>
<%putObjectInBean("patTask",patTask,session);%>

