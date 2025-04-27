<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>  
<%
	System.out.println(" - - -  Inside EM_Scanner_Head.jsp  - - - ");

	String appPath = request.getRequestURL().toString();
	String contextPath = request.getContextPath();

	appPath = appPath.substring(0,appPath.indexOf(contextPath)+contextPath.length());

	String facilityId = "", patientid = "", encounterid = "";

	facilityId	= (String)session.getValue("facility_id");
	patientid = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	encounterid = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");

	System.out.println(" - - - patient_id - - - "+patientid+" - - - encounterid - - - "+encounterid);

	//session.getServletContext().getRealPath("/");
%>
<html>
<head>
<title>Scan Documents</title>
</head>
<body>
	<table align="center" border="4" cellpadding="1" cellspacing="1" style="width: 700px;">
		<tr>
			<td>
				<!--<applet code="ScannerApplet.class" codebase="../Scanner/" archive="EMScanner.jar, JTwain.jar" width="400" height="300">-->
				<!--<applet code="ScanImageApplet.class" codebase="../Scanner/" archive="ScanImageDemo.jar, JTwain.jar" width="800" height="600">-->
				<applet code="ScanImageApplet.class" codebase="../Scanner/" archive="ScanPatientDocument.jar, JTwain.jar" width="700" height="400">
				<PARAM name="servletPath" value="<%=appPath%>">
				<PARAM name="facility_id" value="<%=facilityId%>">
				<PARAM name="encounter_id" value="<%=encounterid%>">
				<PARAM name="patient_id" value="<%=patientid%>">
				 Sorry, Your browser does not support Java applet!
				</applet>
			</td>
		</tr>
	</table>	
</body>
</html>
