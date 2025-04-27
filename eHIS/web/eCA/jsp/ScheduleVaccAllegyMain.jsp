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
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../js/ScheduleForVacination.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title></title>
	</head>
				
			<iframe name="AllergyResultFrame" id="AllergyResultFrame"   noresize scrolling='auto' src="../../eCA/jsp/ScheduleVaccAllegyResult.jsp?<%=request.getQueryString()%>" style="height:99vh;width:30vw"></iframe>
				
				<iframe name="AllergyAddModify" id="AllergyAddModify"   noresize scrolling='auto' src="../../eCA/jsp/ScheduleVaccAllegyAddModify.jsp?<%=request.getQueryString()%>&mode_new1=all_rec" style="height:99vh;width:68vw"></iframe> 

						
		<input type='hidden' value='<%=request.getQueryString()%>' name='query_string'>
</html>

