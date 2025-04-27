<!DOCTYPE html>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="eIPAD.chartsummary.allergies.healthobject.Allergy"%>
<%@ page import="eIPAD.chartsummary.allergies.response.AllergyResponse"%>
<%@ page import="eIPAD.chartsummary.allergies.request.AllergyRequest"%>
<%@ page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@ page import="eIPAD.chartsummary.allergies.bc.AllergyBC"%>
<%
String responseText = "false";
String allergenCode = "";
String eventType = "";
String eventTypeInd = "";
PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
AllergyRequest allergyRequest = new AllergyRequest();
AllergyResponse allergyResponse;
if(patientContext!=null){
	allergyRequest.setPatientContext(patientContext);
}
if(request.getParameter("EC") != null && !request.getParameter("EC").equals(""))
{
	eventType = request.getParameter("EC");
	
}
if(request.getParameter("EI") != null && !request.getParameter("EI").equals(""))
{
	eventTypeInd = request.getParameter("EI");
}
if(request.getParameter("AC") != null && !request.getParameter("AC").equals(""))
{
	allergenCode = request.getParameter("AC");
}
allergyRequest.setEventTypeCode(eventType);
allergyRequest.setEventTypeInd(eventTypeInd);
allergyRequest.setAllergenCode(allergenCode);

AllergyBC allergyBC = new AllergyBC();
allergyResponse = allergyBC.getAllergyDetails(allergyRequest);

if(allergyResponse != null && allergyResponse.getAllergyDetails() != null && allergyResponse.getAllergyDetails().size() > 0)
{
	responseText = "true";
	%>
	<%=responseText%>
	<%
}
else
{
	%><%=responseText%><%
}

%>
