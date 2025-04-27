<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------------
Date      	 Edit History     		 Name        		Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------
08/01/2018	   IN064458			Kamalakannan G.			08/01/2018		Ramesh G	  ML-MMOH-CRF-0869(legends frame added)
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<%
String patientid = request.getParameter("patient_id");
String context = (String)request.getParameter("PQ");
if (context==null) context="Y";

String P_access_type = request.getParameter("Access_Type");
//String P_access_data = request.getParameter("Access_Data");
//String P_patient_type = request.getParameter("Patient_Type");

//****added for PH function usage
String P_function_id=request.getParameter("P_function_id")==null?"":request.getParameter("P_function_id");
String P_no_of_items=request.getParameter("P_no_of_items")==null?"0":request.getParameter("P_no_of_items");

String P_option_type=request.getParameter("P_option_type")==null?"":request.getParameter("P_option_type");
String modal_yn=request.getParameter("modal_yn")==null?"N":request.getParameter("modal_yn");
String encounter_id=request.getParameter("encounter_id")==null?"0":request.getParameter("encounter_id");
String called_mod=request.getParameter("called_mod") == null ? "N" : request.getParameter("called_mod");
//out.println("<script>alert('"+encounter_id+"')</script>");

//String frameSet="*%,17%,40%,0%,6%"; 
//String frameSet="26%,35%,*,0%,0%"; // commented for IN064458
//String frameSet="26%,35%,*,0%,0%,5%"; // added for IN064458
String height1 = "23vh";
String height2 = "30vh";
String height3 = "37vh";
String height4 = "0vh";
String height5 = "0vh";
String height6 = "5vh";

if(P_function_id.equals("PH"))
{
	//frameSet="25%,17%,*,6%,0%"; // commented for IN064458
	//frameSet="25%,17%,*,6%,0%,5%";//IN064458
	height1 = "25vh";
	height2 = "20vh";
	height3 = "40vh";
	height4 = "0vh";
	height5 = "5vh";
	height6 = "5vh";
} 
if(called_mod.equals("BL"))
{
	//frameSet="0,17%,*,6%,0%"; // commented for IN064458
	//frameSet="0,17%,*,6%,0%,0%";//IN064458
	height1 = "25vh";
	height2 = "17vh";
	height3 = "75vh";
	height4 = "0vh";
	height5 = "5vh";
	height6 = "5vh";
} 

//****

%>
<html>
<head>
<title><fmt:message key="Common.ProblemList.label" bundle="${common_labels}"/></title>
<script src="../../eCommon/js/common.js" language="javascript"></script>
</head>

		<iframe   src="Problemsframe0.jsp?Patient_Id=<%=patientid%>&Context=<%=context%>&P_function_id=<%=P_function_id%>&P_no_of_items=<%=P_no_of_items%>&P_option_type=<%=P_option_type%>&modal_yn=<%=modal_yn%>&encounter_id=<%=encounter_id%>" name="problemsframe0" id="problemsframe0" marginheight='0'  frameborder=no scrolling='no' style="height:<%=height1%>;width:100vw" ></iframe>
		<iframe  src="Problemsframe1.jsp?Patient_Id=<%=patientid%>&Context=<%=context%>&P_access_type=<%=P_access_type%>&radio_par=A&P_function_id=<%=P_function_id%>&P_no_of_items=<%=P_no_of_items%>&P_option_type=<%=P_option_type%>&modal_yn=<%=modal_yn%>&encounter_id=<%=encounter_id%>" name="problemsframe1" id="problemsframe1"   scrolling=yes frameborder=no align=top noresize="noresize" style="height:<%=height2%>;width:100vw"></iframe>
	
		<iframe src = "ProblemsDetails.jsp?Patient_Id=<%=patientid%>&Context=<%=context%>&modal_yn=<%=modal_yn%>" name='problemsdetails' id='problemsdetails' marginheight='0' marginwidth='0' scrolling=no frameborder=no noresize="noresize" style="height:<%=height3%>;width:100vw"></iframe>
		<iframe src = "ProblemsAssessment.jsp?Patient_Id=<%=patientid%>&Context=<%=context%>&modal_yn=<%=modal_yn%>" name="problemsassessments" id="problemsassessments" marginheight='0' marginwidth='0' frameborder='no' style="height:<%=height4%>;width:100vw"></iframe>
		
		
		<iframe name="problemframeControl" id="problemframeControl" src="PatProblemControl.jsp?modal_yn=<%=modal_yn%>&called_mod=<%=called_mod%>" frameborder=no scrolling='no' style="height:<%=height5%>;width:100vw" ></iframe>
		<!-- <iframe name="problemframeEncounter" src="" frameborder=no scrolling=no></iframe> -->
		
		<iframe name='RecDiagnosisCurrentDiagLegend' id='RecDiagnosisCurrentDiagLegend' framespacing=0 border=0 src='../../eMR/jsp/RecDiagnosisCurrentDiagLegend.jsp' frameborder='no' scrolling='no' noresize style="height:<%=height6%>;width:100vw"></iframe>
		<!-- IN064458 ends -->
	
</html> 
