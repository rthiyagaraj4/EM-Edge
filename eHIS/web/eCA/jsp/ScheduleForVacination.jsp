<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
 <%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

 %>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script src='../../eCA/js/ScheduleForVacination.js' language='javascript'></script>
		<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<title><fmt:message key="eCA.VaccinationSchedule.label" bundle="${ca_labels}"/></title>
	</head>

					

				<iframe name="ExistScheduleTreeFrame" id="ExistScheduleTreeFrame"  frameborder="0" noresize scrolling='auto' src="../../eCA/jsp/ScheduleExistingVaccinations.jsp?<%=request.getQueryString()%>" style="height:47vh;width:13vw"></iframe>				
				<iframe name="ExistScheduleDetailFrame" id="ExistScheduleDetailFrame"  frameborder="0" noresize src="../../eCommon/html/blank.html" scrolling='no' style="height:47vh;width:86vw"></iframe>
	
			<iframe name='VaccinationFrame'	id='VaccinationFrame'	src='../../eCA/jsp/ScheduleVaccinDetailsMain.jsp'   frameborder=0 scrolling='no'  noresize style="height:63vh;width:100vw"></iframe>
					


</html>
