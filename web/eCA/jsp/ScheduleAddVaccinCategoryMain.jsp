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
        <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script src='../../eCA/js/ScheduleForVacination.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title><fmt:message key="Common.confirm.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Schedule.label" bundle="${common_labels}"/></title>
	</head>
		<iframe name="ScheduleCatalogDetailFrame" id="ScheduleCatalogDetailFrame"   noresize src="../../eCA/jsp/ScheduleAddVaccinCategory.jsp?<%=request.getQueryString()%>" style="height:10vhvh;width:100vw"></iframe>

			<iframe name='ScheduleCatalogToolbar' id='ScheduleCatalogToolbar'		src='../../eCA/jsp/ScheduleAddVaccinCategoryToolbar.jsp'   frameborder=0 scrolling='no'  noresize style='height:83vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp'   frameborder=0 scrolling='no'  noresize style='height:9vh;width:100vw'></iframe>	
		 

</html>

