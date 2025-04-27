<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
 <%
	request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 %>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCA/js/ScheduleForVacination.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title></title>
	</head>
	<iframe name="VaccineAdminTabFrame" id="VaccineAdminTabFrame"   noresize scrolling='no' src="../../eCommon/html/blank.html" style='height:7vh;width:100vw;border:none'></iframe>
				
	<iframe name="VaccinAdminDetailsFrame" id="VaccinAdminDetailsFrame"   noresize scrolling='no' src="../../eCommon/html/blank.html" style='height:74vh;width:100vw'></iframe>

		
</html>

