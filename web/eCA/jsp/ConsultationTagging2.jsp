<%
/* 
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
22/04/2024  50627    Twinkle Shah    22/04/2024		Ramesh Goli        ML-MMOH-CRF-2106
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script language='javascript' src='../../eCA/js/ConsultationTagging.js'> </script>		
	<title>Consultation Tagging</title>
</head>
<%
		 
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String visit_id = request.getParameter("visit_id") == null ? "" : request.getParameter("visit_id");
	String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	String option_id = request.getParameter("option_id") == null ? "" : request.getParameter("option_id");
	String firstFrameSrc  = "";
	String secondFrameSrc = "";
	String thirdFrameSrc="";
	
	firstFrameSrc  = "../../eCA/jsp/ConsultationTaggingRecordedResult.jsp?";
	secondFrameSrc = "../../eCA/jsp/ConsultationTaggingAuditTrialBtn.jsp?";
	thirdFrameSrc = "../../eCA/jsp/ConsultationTaggingQuery2.jsp?";

	if("CONSULT_TAGGING".equals(option_id) || "CONSULT_TAGGING1".equals(option_id))
	{
	%>
		<iframe name='plineFrame' id='plineFrame' src='../../eCommon/jsp/pline.jsp?EncounterId=<%=encounter_id%>&Patient_ID=<%=patient_id%>&visit_id=<%=visit_id%>' scrolling='no' frameborder="yes" frameborder='0' style='height:18%;width:100vw'></iframe>
	<iframe name="ConsultationTagResultFrame" id="ConsultationTagResultFrame" frameborder="no" scrolling="auto" noresize src="<%=firstFrameSrc%><%=request.getQueryString()%>" frameborder='0' style="height:43%;width:100vw"></iframe>
	<iframe name="ConsultationTagAuditTRialFrame" id="ConsultationTagAuditTRialFrame" frameborder="no" scrolling="no" noresize src="<%=secondFrameSrc%><%=request.getQueryString()%>" frameborder='0' style="height:7%;width:100vw"></iframe>
	<iframe name="ConsultationTagQuery2Frame" id="ConsultationTagQuery2Frame" frameborder="no" scrolling="auto" noresize src="<%=thirdFrameSrc%><%=request.getQueryString()%>" frameborder='0' style="height:29%;width:100vw"></iframe>
	<%
	}
	%>

</html>

