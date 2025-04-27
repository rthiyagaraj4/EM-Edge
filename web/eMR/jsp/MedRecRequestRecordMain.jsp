
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
	request.setCharacterEncoding("UTF-8");
	
	String title = "";
	String params		= request.getQueryString() ;
	String PatientId	= checkForNull(request.getParameter("PatientId"));
	String selitem		= checkForNull(request.getParameter("selitem"));
	String called_from	= checkForNull(request.getParameter("called_from"));
	String finalSelect	= checkForNull(request.getParameter("finalSelect"));
	String from			= checkForNull(request.getParameter("from"));
	String to			= checkForNull(request.getParameter("to"));
	String encounter_id = checkForNull(request.getParameter("encounterId"));
	String overdue_status = checkForNull(request.getParameter("overdue_status"));
	String isAcceptRequestByPractAppl = checkForNull(request.getParameter("isAcceptRequestByPractAppl"));
	//added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316 


	String frfunction = checkForNull(request.getParameter("p_fr_function"));
	if(frfunction.equals("IP"))
		title = "Stay Details";

	String call_function = checkForNull(request.getParameter("call_function"));
	String new_func_id = "";
	String request_id = checkForNull(request.getParameter("request_id"));
	String req_status = checkForNull(request.getParameter("req_status"));
	String request_status_des = checkForNull(request.getParameter("request_status_des")); // added by mujafar for ML-MMOH-CRF-0714
/*
	Medical Report Request				|	MEDICAL_REPORT_REQUEST	|		1
	Status of Medical Report Request	|	MEDICAL_REPORT_STATUS	|		2 
	Forward Medical Report Request		|	FORWARD_MEDICAL_REPORT	|		3 
	Prepare Med Report By Practitioner	|	PREPARE_MEDICAL_REPORT	|		4 
	Receive Medical Report				|	RECEIVE_MEDICAL_REPORT	|		5 
	Deliver Medical Report				|	DELIVER_MEDICAL_REPORT	|		6 
	Revise Medical Report				|	REVISE_MEDICAL_REPORT	|		0 
*/
	if(call_function.equals("APP_FOR_MED_BOARD"))
	{
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ApplicationforMedicalBoard.label","mr_labels");

		new_func_id = "APP_FOR_MED_BOARD";
	}

	if(req_status.equals(""))
	{
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MedicalReportRequest.label","common_labels");
		call_function = "MEDICAL_REPORT_REQUEST"; 
	}
	else if(req_status.equals("1") || req_status.equals("7"))
	{
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.StatusofMedicalReportRequest.label","mr_labels");
		call_function = "MEDICAL_REPORT_STATUS"; 
	}
	else if(req_status.equals("2") )
	{
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ForwardMedicalReportRequest.label","mr_labels");
		call_function = "FORWARD_MEDICAL_REPORT"; 
	}/*Added By Dharma on Nov 30th 2015 against ML-MMOH-CRF-0391 [IN:057157] Start*/
	else if(req_status.equals("9")){
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ForwardToPractitioner.label","mr_labels");
		call_function = "FORWARD_TO_HOD"; 
	}else if(req_status.equals("10")){
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ForwardMedicalReportRequest.label","mr_labels");
		call_function = "REQUEST_RETURNED"; 
	}else if(req_status.equals("11")){
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ForwardToPractitioner.label","mr_labels");
		call_function = "REQUEST_ACCEPTED"; 
	}
	/*Added By Dharma on Nov 30th 2015 against ML-MMOH-CRF-0391 [IN:057157] End*/
	else if(req_status.equals("3") || req_status.equals("0") || req_status.equals("98")) // modified by mujafar for ML-MMOH-CRF-0714
	{
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.PrepareMedicalReport.label","mr_labels");
		call_function = "PREPARE_MEDICAL_REPORT"; 
	}
	else if(isAcceptRequestByPractAppl.equals("true") && req_status.equals("13")  ) //added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316 START
	{
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.AcceptedbyPractitioner.label","mr_labels");
		call_function = "ACCEPTED_BY_PRACTITIONER"; 
	}
		else if(isAcceptRequestByPractAppl.equals("true") && req_status.equals("15")  )
	{
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.RejectedbyPractitionertoHOD.label","mr_labels");
		call_function = "REJECTED_BY_PRACT_TO_HOD"; 
	}
	else if(isAcceptRequestByPractAppl.equals("true") && req_status.equals("14")  )
	{ //added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316 END
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.RejectedbyPractitionertoMRD.label","mr_labels");
		call_function = "REJECTED_BY_PRACT_TO_MRD"; 
	}
	else if(req_status.equals("4"))
	{
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ReceiveMedicalReport.label","mr_labels");
		call_function = "RECEIVE_MEDICAL_REPORT"; 
	}
	else if(req_status.equals("5"))
	{
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DeliverMedicalReport.label","mr_labels");
		call_function = "DELIVER_MEDICAL_REPORT"; 
	}
	else if(req_status.equals("6"))
	{
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.MedicalReportCompleted.label","mr_labels");
		call_function = "MEDICAL_REPORT_COMPLETED"; 
	}
	else if(req_status.equals("8"))
	{
		//title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.MedicalReport.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.MedicalReportCancelled.label","mr_labels");
		call_function = "MEDICAL_REPORT_CANCELLED"; 
	}
	/*Added by Thamizh selvi on 17th July 2017 for ML-MMOH-CRF-0719 Start*/
	else if(req_status.equals("99"))
	{
		//title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.MedicalReport.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Auto.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.MedicalReportAutoCancelled.label","mr_labels");
		call_function = "MEDICAL_REPORT_CANCELLED"; 
	}/*End*/
	else if(call_function.equals("QUERY_DELAY_IN_MRR"))
	{
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DelayOverdueofMedicalReport.label","mr_labels");
		call_function = "QUERY_DELAY_IN_MRR"; 
	}

	if(overdue_status.equals("Y") && !req_status.equals("6"))
	{
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ReviseMedicalReport.label","mr_labels");
		call_function = "REVISE_MEDICAL_REPORT"; 
	}
%>
<head>
<%
if(call_function.equals("PREPARE_MEDICAL_REPORT") || call_function.equals("RECEIVE_MEDICAL_REPORT") || call_function.equals("DELIVER_MEDICAL_REPORT") || call_function.equals("REVISE_MEDICAL_REPORT") || 
call_function.equals("QUERY_DELAY_IN_MRR") || call_function.equals("MEDICAL_REPORT_COMPLETED") || call_function.equals("ACCEPTED_BY_PRACTITIONER") || call_function.equals("REJECTED_BY_PRACT_TO_HOD") || call_function.equals("REJECTED_BY_PRACT_TO_MRD") )
{ // added by mujafar for ML-MMOH-CRF-1302 & 1312 & 1315 & 1316	
	%>
	<title><%=title%></title>
	
		<iframe name='pline' id='pline' src="../../eCommon/jsp/pline.jsp?Patient_ID=<%=PatientId%>" frameborder=no scrolling='no' style='height:0vh;width:100vw'></iframe>
		<iframe name='CurEnc' id='CurEnc' src='../jsp/MedicalReportResult.jsp?flag=true&PatientId=<%=PatientId%>&request_id=<%=request_id%>&call_function=<%=call_function%>' noresize  frameborder=no scrolling='auto' style='height:0vh;width:100vw'></iframe>
		<iframe name='DetailFrame' id='DetailFrame'  src='../jsp/MedRecRequestRecordDetail.jsp?LastDet=1&encounter_id=<%=encounter_id%>&patientId=<%=PatientId%>&call_function=<%=call_function%>&finalSelect=<%=finalSelect%>&new_func_id=<%=new_func_id%>&selitem=<%=selitem%>&from=<%=from%>&to=<%=to%>&<%=params%>&req_status=<%=req_status%>' noresize  frameborder=no scrolling='auto'style='height:94vh;width:100vw' ></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=no noresize scrolling='no' style='height:0vh;width:100vw'></iframe>
		<iframe name='RecordButton' id='RecordButton'  src='../jsp/MedicalRequestButtons.jsp?encounter_id=<%=encounter_id%>&patientId=<%=PatientId%>&finalSelect=<%=finalSelect%>&call_function=<%=call_function%>&request_id=<%=request_id%>&called_from=<%=called_from%>&req_status=<%=req_status%>&request_status_des=<%=request_status_des%>' noresize frameborder=no scrolling='no' style='height:4vh;width:99vw'></iframe>
<%
}else if(call_function.equals("MEDICAL_REPORT_STATUS") || call_function.equals("FORWARD_MEDICAL_REPORT") || call_function.equals("MEDICAL_REPORT_CANCELLED"))
{ %>
	     <title><%=title%></title>
	     
		<iframe name='pline' id='pline' 	src="../../eCommon/jsp/pline.jsp?Patient_ID=<%=PatientId%>" frameborder=no scrolling=no style='height:0vh;width:100vw'></iframe>
		<iframe name='CurEnc' id='CurEnc' src='../jsp/MedicalReportResult.jsp?flag=true&PatientId=<%=PatientId%>&request_id=<%=request_id%>&call_function=<%=call_function%>' noresize  frameborder=no scrolling=auto style='height:0vh;width:100vw'></iframe>
		<iframe name='DetailFrame' id='DetailFrame'  src='../jsp/MedRecRequestRecordDetail.jsp?LastDet=1&encounter_id=<%=encounter_id%>&patientId=<%=PatientId%>&finalSelect=<%=finalSelect%>&call_function=<%=call_function%>&new_func_id=<%=new_func_id%>&selitem=<%=selitem%>&from=<%=from%>&to=<%=to%>&<%=params%>&req_status=<%=req_status%>' noresize  frameborder=no scrolling='auto' style='height:94vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=no noresize scrolling='no' style='height:0vh;width:100vw'></iframe>
		<iframe name='StatusButton' id='StatusButton'  src='../jsp/MedicalRequestButtons.jsp?encounter_id=<%=encounter_id%>&patientId=<%=PatientId%>&finalSelect=<%=finalSelect%>&call_function=<%=call_function%>' noresize frameborder=no scrolling='no' style='height:4vh;width:99vw'></iframe>
<%
}else{	//for Medical Report Request
	
	//out.println("<script>alert(\"finalSelect"+finalSelect+"\");</script>");
//out.println("<script>alert(\"params "+params+"\");</script>");
%>
	<title><%=title%></title>
	
		<iframe name='pline' id='pline' src="../../eCommon/jsp/pline.jsp?Patient_ID=<%=PatientId%>" frameborder=no scrolling=no style='height:0vh;width:100vw'></iframe>
		<iframe name='CurEnc' id='CurEnc' src='../jsp/MedRecRequestResult.jsp?criteria=validate&flag=true&<%=params%>&PatientId=<%=PatientId%>&selitem=<%=selitem%>&from=<%=from%>&to=<%=to%>&chkSelect=<%=finalSelect%>' noresize  frameborder=no scrolling='auto' style='height:0vh;width:100vw'></iframe>
 		<iframe name='DetailFrame' id='DetailFrame'  src='../jsp/MedRecRequestRecordDetail.jsp?LastDet=1&encounter_id=<%=encounter_id%>&call_function=<%=call_function%>&patientId=<%=PatientId%>&chkSelect=<%=finalSelect%>&finalSelect=<%=finalSelect%>&new_func_id=<%=new_func_id%>&selitem=<%=selitem%>&from=<%=from%>&to=<%=to%>&<%=params%>&req_status=<%=req_status%>&call_function=<%=call_function%>' noresize  frameborder=no scrolling='auto' style='height:95vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=no noresize scrolling='no' style='height:0vh;width:100vw'></iframe>
		<iframe name='recordFrame' id='recordFrame'  src='../jsp/MedicalRequestButtons.jsp?encounter_id=<%=encounter_id%>&patientId=<%=PatientId%>&finalSelect=<%=finalSelect%>&call_function=<%=call_function%>' noresize frameborder=no scrolling='no' style='height:4vh;width:99vw'></iframe>
<%	} %>
</head>
</html>					

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

