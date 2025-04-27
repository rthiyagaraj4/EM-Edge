<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
	<title> <fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/> </title>
</head>
<%
String Patient_Id			= request.getParameter("patient_id");
String Encounter_Id			= request.getParameter("episode_id");

String Practitioner_Id	= "";
String relationship_id		=	request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
String Locn_Code			= request.getParameter("location_code");
String Locn_Type			= request.getParameter("locn_type")==null?"":request.getParameter("locn_type");
if(Locn_Type.equals("")) Locn_Type="C";
String function				= request.getParameter("Function");
String context				= request.getParameter("Context");
String logicalseqno			= request.getParameter("Logical_Seq")==null?"":request.getParameter("Logical_Seq");
String patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
String called_from_ip = request.getParameter("IP_YN")==null?"N":request.getParameter("IP_YN");

String age = request.getParameter("Age")==null?"":request.getParameter("Age");
String dob = request.getParameter("Dob")==null?"":request.getParameter("Dob");
String sex = request.getParameter("Sex")==null?"":request.getParameter("Sex");

Practitioner_Id		= request.getParameter("ip_practitioner_id")==null?"":request.getParameter("ip_practitioner_id");	

if(Practitioner_Id.equals("") || Practitioner_Id.equals("null")){
		Practitioner_Id		= (String)session.getValue("ca_practitioner_id");
		
}

%>
	<iframe name='RecDiagnosisEOCResult' id='RecDiagnosisEOCResult' framespacing=0 border=0 src='../../eMR/jsp/RecDiagnosisEOCResult.jsp?Logical_Seq=<%=logicalseqno%>&Function=<%=function%>&Patient_Id=<%=Patient_Id%>&Encounter_Id=<%=Encounter_Id%>&Practitioner_Id=<%=Practitioner_Id%>&Locn_Code=<%=Locn_Code%>&relationship_id=<%=relationship_id%>&Locn_Type=<%=Locn_Type%>&f_authorize_yn=N&P_context=<%=context%>&patient_class=<%=patient_class%>&Age=<%=age%>&Dob=<%=dob%>&Sex=<%=sex%>' scrolling='auto'  noresize style='height:50%;width:100vw'></iframe>
		<iframe name='RecDiagnosisEOCAddModify' id='RecDiagnosisEOCAddModify' framespacing=0 border=0 src='../../eMR/jsp/RecDiagnosisEOCAddModify.jsp?Logical_Seq=<%=logicalseqno%>&Function=<%=function%>&Patient_Id=<%=Patient_Id%>&Encounter_Id=<%=Encounter_Id%>&Practitioner_Id=<%=Practitioner_Id%>&Locn_Code=<%=Locn_Code%>&relationship_id=<%=relationship_id%>&Locn_Type=<%=Locn_Type%>&f_authorize_yn=N&P_context=<%=context%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&Age=<%=age%>&Dob=<%=dob%>&Sex=<%=sex%>' frameborder='no' scrolling='yes' noresize style='height:44%;width:100vw'></iframe>
		<iframe name='RecDiagnosisEOCButtons' id='RecDiagnosisEOCButtons' frameborder='no' framespacing=0 border=0 src='../../eMR/jsp/RecDiagnosisEOCButtons.jsp?Logical_Seq=<%=logicalseqno%>&Function=<%=function%>&Patient_Id=<%=Patient_Id%>&Encounter_Id=<%=Encounter_Id%>&Practitioner_Id=<%=Practitioner_Id%>&Locn_Code=<%=Locn_Code%>&relationship_id=<%=relationship_id%>&Locn_Type=<%=Locn_Type%>&f_authorize_yn=N&P_context=<%=context%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&Age=<%=age%>&Dob=<%=dob%>&Sex=<%=sex%>' scrolling='no' noresize style='height:4%;width:100vw'></iframe>
		
		<iframe name='messageFrame' id='messageFrame' 	 src='../../eCommon/jsp/error.jsp' frameborder='no' noresize border=0 scrolling='auto' style='height:3%;width:100vw'></iframe>
</html>

