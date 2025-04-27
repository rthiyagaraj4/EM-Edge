<!DOCTYPE html>
<%  
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
08/01/2013		IN035950		Nijitha			CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
												more appealing. Keeping the display of information more clear and visible.   								 
----------------------------------------------------------------------------------------------------------------------------------
Date			Edit History	Name			Rev.Date		Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------
02/01/2017		IN061904		Raja S 												ML-MMOH-CRF-0556												
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<title><fmt:message key="eCA.RecordingClinicalNotes.label" bundle="${ca_labels}"/></title>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<%
		String disp_pat_line_yn=request.getParameter("disp_pat_line_yn");
		String episode_id =request.getParameter("encounter_id");
		String patient_id =request.getParameter("patient_id");
	//	String sameWindow_YN = request.getParameter("sameWindow_YN");
		String called_from_widget		= request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget");//IN035950
				
		if(disp_pat_line_yn==null || disp_pat_line_yn.equals(""))
			disp_pat_line_yn="N";
		if(episode_id==null)			episode_id="";
		if(patient_id==null)			patient_id="";
		//IN061904 starts 
		if("CA_CLINICIAN_WIDGET".equals(called_from_widget)) 
		disp_pat_line_yn="Y";
		//IN061904 Ends
		
		if(disp_pat_line_yn.equals("Y")){
		//String frameSize="6%,89%,5%";
		
		%>

		<%if(episode_id !=null && !episode_id.equals("") && !episode_id.equals("0")){%>
		<iframe name="PatLineFrame" id="PatLineFrame" frameborder="0" scrolling="no" noresize src="../../eCommon/jsp/pline.jsp?Patient_ID=<%=patient_id%>&EncounterId=<%=episode_id%>" style='height:6vh;width:100vw'></iframe>
		<%}else{%>
		<iframe name="PatLineFrame" id="PatLineFrame" frameborder="0" scrolling="no" noresize src="../../eCommon/jsp/pline.jsp?Patient_ID=<%=patient_id%>" style='height:6vh;width:100vw'></iframe>
		<%}%>
		<iframe name="workAreaFrame" id="workAreaFrame" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/RecClinicalNotes.jsp?<%=request.getQueryString()%>" style='height:89vh;width:100vw'></iframe>
		<iframe name="messageFrame" id="messageFrame"  frameborder="0" scrolling="no" noresize src="../../eCommon/jsp/error.jsp" style='height:5vh;width:100vw'></iframe>
	
		//IN035950 Start

	<%}else{
	if("CA_SOCIAL_HISTORY".equals(called_from_widget))
	{%>
		<iframe name="workAreaFrame" id="workAreaFrame" frameborder="0" scrolling="no" noresize style='height:95vh;width:100vw' src="../../eCA/jsp/PatientSocialHistory.jsp?<%=request.getQueryString()%>"></iframe>
		<iframe name="messageFrame" id="messageFrame" frameborder="0" scrolling="no" noresize style='height:5vh;width:100vw' src="../../eCommon/jsp/error.jsp"></iframe>
		<%
	}else{
		//IN035950 Ends
		%>		
		<iframe name="workAreaFrame" id="workAreaFrame"  frameborder="0" scrolling="no" noresize style='height:91vh;width:100vw' src="../../eCA/jsp/RecClinicalNotes.jsp?<%=request.getQueryString()%>"></iframe>
		<iframe name="messageFrame" id="messageFrame" frameborder="0" scrolling="no" noresize style='height:6vh;width:100vw' src="../../eCommon/jsp/error.jsp"></iframe>
	<%}}//IN035950%>
</head>
</html>
<script>
	window.focus();

</script>
