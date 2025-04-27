<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@ page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>
<html>
	<head>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<TITLE>View Pending Orders</TITLE>
	</head>
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	/*String patient_id	= (String)session.getValue("patient_id");
	String encounter_id =	(String)session.getValue("episode_id");
	
	if(patient_id!=null)
		patient_id = patient_id.trim();
	else
		patient_id = "";
	if(encounter_id!=null)
		encounter_id = encounter_id.trim();
	else
		encounter_id = "";*/
		String patient_id	= request.getParameter("patient_id");
	
	String encounter_id	= request.getParameter("encounter_id");	
	String facility_id	= request.getParameter("facility_id");	
	String discharge_ind	= request.getParameter("discharge_ind");
	
	%>
	<iframe name='ViewPendingOrdersList' id='ViewPendingOrdersList' src='ViewPendingOrdersList.jsp?patient_id=<%=patient_id%>&encounter_id=<%=encounter_id%>&facility_id=<%=facility_id%>&discharge_ind=<%=discharge_ind%>' frameborder=0  scrolling='YES'  style='height:90vh;width:100vw'></iframe>
	<iframe name='ViewPendingOrdersButtons' id='ViewPendingOrdersButtons' src='ViewPendingOrdersButtons.jsp?' frameborder=0  scrolling=no  style='height:10vh;width:100vw'></iframe>
</html>

