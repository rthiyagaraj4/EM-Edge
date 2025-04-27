<!DOCTYPE html>
<%
/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/// MODULE			:	Medical Records..(MR)
/// Function Name	:	Diagnosis Recoding
/// Developer		:	SRIDHAR R
/// Created On		:	27 JULY 2004
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../js/MedRecRequest.js' language='javascript'>
</script>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String FacilityId=request.getParameter("FacilityId");
		if(FacilityId == null) FacilityId = "";

	String call_function=request.getParameter("call_function");
		if(call_function == null) call_function = "";

	String PatientId=request.getParameter("PatientId");
		if(PatientId == null) PatientId = "";

	String Encounter_Id=request.getParameter("Encounter_Id");
		if(Encounter_Id == null) Encounter_Id = "";
%>

<%	if(call_function.equals("DIAG_RECODE"))
	{	%>
		<title><fmt:message key="eMR.DiagnosisRecoding.label" bundle="${mr_labels}"/></title>
<%	}	%>

<%	if(call_function.equals("VIEW_ENCOUNTER_DTLS"))
	{	%>
		<title><fmt:message key="Common.DiagnosisDetails.label" bundle="${common_labels}"/></title>
<%	}	%>

<%	if(call_function.equals("TRANSMIT_NOTIFY_REP"))
	{	%>
		<title><fmt:message key="eMR.TransmitNotifialbeDiseaseReport.label" bundle="${mr_labels}"/></title>
<%	}	%>
<%	if(call_function.equals("CONF_TRANSMIT_NOTIFY_REP"))
	{	%>
		<title><fmt:message key="eMR.ConfirmTransmitNotifiableReport.label" bundle="${mr_labels}"/></title>
<%	}	%>
 
<% if (call_function.equals("VIEW_ENCOUNTER_DTLS")) 
	{	%>
	<frameset rows='9%,*%,0%,0%'>
		<frame name='patLine' src='../../eCommon/jsp/pline.jsp?Patient_Id=<%=PatientId%>' frameborder='no' scrolling='no' noresize>
		<frame scrolling="auto" name='f_query_add_mod' src='../../eMR/jsp/DiagnosisQueryResult.jsp?jsp_name=DiagnosisQueryResult.jsp&call_function=<%=call_function%>&PatientId=<%=PatientId%>&Encounter_Id=<%=Encounter_Id%>&facility_id=<%=FacilityId%>' noresize frameborder=0>
		<frame scrolling="no" name='content' src='../../eCommon/html/blank.html'  noresize frameborder=0>
		<frame name='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'> </frameset>
<%	}
	else 
	{	
		if(call_function.equals("DIAG_RECODE"))
		{	%>	
				<frameset rows='100%,0%,0%'>
	<%	}
		else
		{	%>
				<frameset rows='50%,50%,0%'>
	<%	}	%>

		<frame scrolling="auto" name='f_query_add_mod' src='../../eMR/jsp/DiagnosisQueryResult.jsp?jsp_name=DiagnosisQueryResult.jsp&call_function=<%=call_function%>&PatientId=<%=PatientId%>&Encounter_Id=<%=Encounter_Id%>&facility_id=<%=FacilityId%>' noresize frameborder=0>
		<frame scrolling="no" name='content' src='../../eCommon/html/blank.html'  noresize frameborder=0>
		<frame name='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto'> </frameset>
<% } %>
</html>
