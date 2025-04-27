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
        <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title></title>
	</head>
	<iframe name='VaccineResTitle' id='VaccineResTitle'		src='../../eCA/jsp/ScheduleVaccinResultTitle.jsp?<%=request.getQueryString()%>'   frameborder=0 scrolling='no'  noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='VaccineResult' id='VaccineResult'	frameborder="0"	src='../../eCA/jsp/ScheduleVaccinResult.jsp?<%=request.getQueryString()%>'   frameborder=0 scrolling='auto'  noresize style='height:72vh;width:100vw'></iframe>
	<iframe name='VaccineColourPanel' id='VaccineColourPanel' 		src='../../eCA/jsp/ScheduleVaccinColorRef.jsp'   frameborder=0 scrolling='no'  noresize style='height:10vh;width:100vw'></iframe>
					
		

</html>

