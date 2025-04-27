<!DOCTYPE html>
<%@page import="java.sql.*,java.util.*,eCA.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<%	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<HEAD>   
<!--<TITLE>Patient Antibodies</TITLE>-->
<title><fmt:message key="eCA.RecordConsumption.label" bundle="${ca_labels}"/></title>
</HEAD>
<iframe src="../../eCA/jsp/TaskListBTRecordConsumption.jsp?<%=request.getQueryString()%>" frameborder=0  marginheight=0 marginwidth=0 SCROLLING="auto" name="recordconsumption" NORESIZE style="height:100vh;width:100vw"></iframe>	
    <iframe src="../../eCommon/jsp/error.jsp" name="messageFrame" id="messageFrame"  scrolling="yes" frameborder="0" noresize style="height:10%;width:100vw"></iframe>

</HTML>

