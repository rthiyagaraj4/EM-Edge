<!DOCTYPE html>
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
String encounter_id=request.getParameter("encounter_id")==null?"N":request.getParameter("encounter_id");
//out.println("<script>alert('"+P_function_id+"')</script>");

String frameSet="23%,37%,*,0%,8%";
if(P_function_id.equals("PH"))
{
	frameSet="23%,37%,*,8%,0%";
}
//****

%>
<html>
<head>
<title>Problem List</title>
</head>
<!-- 	<frameset rows='56%,*' framespacing=0 border=0> -->
	<frameset rows=<%=frameSet%> framespacing=0>
		<frame   src="problemsframe0.jsp?Patient_Id=<%=patientid%>&Context=<%=context%>&P_function_id=<%=P_function_id%>&P_no_of_items=<%=P_no_of_items%>&P_option_type=<%=P_option_type%>&modal_yn=<%=modal_yn%>&encounter_id=<%=encounter_id%>" name="problemsframe0" marginheight='0'  frameborder=no scrolling=no >
		<frame  src="problemsframe1.jsp?Patient_Id=<%=patientid%>&Context=<%=context%>&P_access_type=<%=P_access_type%>&radio_par=A&P_function_id=<%=P_function_id%>&P_no_of_items=<%=P_no_of_items%>&P_option_type=<%=P_option_type%>&modal_yn=<%=modal_yn%>" name="problemsframe1"   scrolling=yes frameborder=no>
		<frameset cols="60%,*" border="1" framespacing=2>
	
		<frame src = "ProblemsDetails.jsp?Patient_Id=<%=patientid%>&Context=<%=context%>&modal_yn=<%=modal_yn%>" name="problemsdetails" marginheight='0' marginwidth='0' scrolling=no frameborder=no >
		<frame src = "ProblemsAssessment.jsp?Patient_Id=<%=patientid%>&Context=<%=context%>&modal_yn=<%=modal_yn%>" name="problemsassessments" marginheight='0' marginwidth='0' frameborder=no>
		</frameset>
		<frame name="problemframeControl" src="PatProblemControl.jsp?modal_yn=<%=modal_yn%>" frameborder=no scrolling=no>
		<frame name="problemframeEncounter" src="" frameborder=no scrolling=yes>
	</frameset>

</html> 
