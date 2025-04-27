<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            		?           	created
05/12/2012		IN035950			Nijitha			CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
												more appealing. Keeping the display of information more clear and visible. 
20/01/2012		CHL-CRF [IN035950]	Ramesh G	CHL-CRF [IN035950]										
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<html>
<head>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String P_patient_id = request.getParameter("Patient_Id");
String P_encounter_id = request.getParameter("Encounter_Id");
String P_practitioner_id = request.getParameter("Practitioner_Id");
String P_clinic_code = request.getParameter("Clinic_Code");
String P_locn_type = request.getParameter("Location_Type");
String dob = request.getParameter("dob");

//CHL-CRF Start. [IN035950]
String p_called_from_widget = request.getParameter("p_called_from_widget")==null?"":(String)request.getParameter("p_called_from_widget");
if(p_called_from_widget.equals("CA_HIGH_RISK")){
	%>
	<TITLE>High Risk Conditions</TITLE>
	<%
	}
//CHL-CRF End. [IN035950]
%>
<!-- //CHL-CRF Start.[IN035950]-->
<% if(!"".equals(p_called_from_widget)){%> 
<frameset rows='3%,39%,40%,8%'  framespacing='0' border=0>
<%}else{%>
<frameset rows='3%,43%,44%'  framespacing='0' border=0>
<%}%>
<!--//CHL-CRF End.[IN035950]-->
	<frame name='title'			MARGINWIDTH=0 MARGINHEIGHT=0  FRAMEBORDER=NO noresize src='../../eCA/jsp/PatHighRiskQueryTitle.jsp'  scrolling="no"></frame>
	<frame name ='frame1' MARGINWIDTH=0 MARGINHEIGHT=0 FRAMEBORDER=NO  noresize src='../../eCA/jsp/PatHighRiskQueryResult.jsp?Encounter_Id=<%=P_encounter_id%>&Practitioner_Id=<%=P_practitioner_id%>&Clinic_Code=<%=P_clinic_code%>&Patient_Id=<%=P_patient_id%>&Location_Type=<%=P_locn_type%>&p_called_from_widget=<%=p_called_from_widget%>'  ></frame>
	<frame name ='frame2' MARGINWIDTH=0 MARGINHEIGHT=0 FRAMEBORDER=NO  noresize src='../../eCA/jsp/addModifyPatHighRisk.jsp?Encounter_Id=<%=P_encounter_id%>&Practitioner_Id=<%=P_practitioner_id%>&Clinic_Code=<%=P_clinic_code%>&Patient_Id=<%=P_patient_id%>&Location_Type=<%=P_locn_type%>&dob=<%=dob%>&p_called_from_widget=<%=p_called_from_widget%>'  ></frame>
<!--	<frame name ='tools'		MARGINWIDTH=0 MARGINHEIGHT=0 FRAMEBORDER=NO  noresize src='../../eCA/jsp/PatHighRiskQueryTools.jsp?Encounter_Id=<%=P_encounter_id%>&Practitioner_Id=<%=P_practitioner_id%>&Clinic_Code=<%=P_clinic_code%>&Patient_Id=<%=P_patient_id%>&Location_Type=<%=P_locn_type%>'  ></frame> -->
<% if(!"".equals(p_called_from_widget)){%>
	<frame name='messageFrame'		src='../../eCommon/jsp/error.jsp'   frameborder=0 scrolling='no'  noresize></frame>
<%}%>
</frameset>
</html>
