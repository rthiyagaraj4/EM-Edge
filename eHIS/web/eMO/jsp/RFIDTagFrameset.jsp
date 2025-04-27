<!DOCTYPE html>
<%@ page import= "java.net.*,webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<%
	
try {
	request.setCharacterEncoding("UTF-8");	
	String RFID_Tag_No = request.getParameter("RFID_No");
	String patient_id = request.getParameter("patient_id");
%>
	<title><fmt:message key="eMO.RFIDTagDetails.label" bundle="${mo_labels}"/></title>
	
	<iframe name='processBar' id='processBar' frameborder=0 noresize scrolling='no' style='height:5vh;width:99vw'></iframe>
	<iframe name='criteria0' id='criteria0' src='../../eMO/jsp/RFIDTagCriteria.jsp?RFID_Tag_No=<%=RFID_Tag_No%>&patient_id=<%=patient_id%>' frameborder=0 scrolling='no' frameborder=0 style='height:17vh;width:99vw'></iframe>
	<iframe name='result' id='result' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' style='height:78vh;width:100vw'></iframe>
	<!-- <iframe name='dummy_frame' id='dummy_frame' src='../../eCommon/jsp/error.jsp&err_num=' frameborder=0 scrolling='auto' style='height:0vh;width:100vw'></iframe>-->
</html>
<%
	} catch (Exception e) {
		out.println("Exception in File MOBayAvailabilityChart.jsp"
				+ e.toString());
		e.printStackTrace();
	} 
%>

