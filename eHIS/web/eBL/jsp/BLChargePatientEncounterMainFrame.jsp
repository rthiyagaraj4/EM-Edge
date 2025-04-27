<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet" %>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>
<html>  
<head>
    <title>Charge Patient</title>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	
<%
	String FacilityId = request.getParameter("FacilityId");
	String call_from  = request.getParameter("call_from");
	String Encounter_Id	= request.getParameter("Encounter_Id");
	String patient_id	= request.getParameter("patient_id");
	FacilityId="HS";
	call_from="IP";
	Encounter_Id="101044860001";
	patient_id=	"DU00002195";
	System.out.println("BLChargePatientEncounterMainFrame.jsp1");		
%>
	</head>
	<iframe name='pline' id='pline' 		frameborder='0'	src="../../eBL/jsp/pline.jsp?EncounterId=<%=Encounter_Id%>&Facility_Id=<%=FacilityId%>"  scrolling='no' noresize style='height:7vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' frameborder='0'	src='../../eBL/jsp/BLChargePatientEncounterFrame.jsp' scrolling='no' noresize style='height:87vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'		frameborder='0' src='../../eCommon/jsp/error.jsp'  scrolling='no' noresize style='height:6vh;width:100vw'></iframe>
	
	</html>     

