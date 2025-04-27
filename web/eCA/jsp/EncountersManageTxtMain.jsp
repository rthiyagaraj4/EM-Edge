<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           created
20/06/2012	  IN033489		Menaka V	Report header blank in clinical event history.										
--------------------------------------------------------------------------------------------------------------------
-->
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<title> <fmt:message key="eCA.ManageSelectedEvents.label" bundle="${ca_labels}"/></title>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
%>
<%
    String patientid = request.getParameter("patient_id") == null? "" : request.getParameter("patient_id");
    String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	//String fac_id = request.getParameter("fac_id") == null ? "" : request.getParameter("fac_id");//IN033489
	//String enctr_id = request.getParameter("enctr_id") == null ? "" : request.getParameter("enctr_id");//IN033489
	
	eCA.PatientBannerGroupLine manageEmailBean = null;
	manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patientid+encounter_id,"eCA.PatientBannerGroupLine",session);

	ArrayList keyList2 = manageEmailBean.returnList2();
	if(keyList2.size() == 0)
	{
		out.println("<script>alert(getMessage(\"EVENTS_TO_MANAGE\",\"CA\"));window.returnValue='N';window.close();</script>");		
	}
%>
<iframe src="../../eCA/jsp/EncountersManageTxtDetails.jsp?patient_id=<%=patientid%>&encounter_id=<%=encounter_id%>" name="manageTxtDtlsFrame" scrolling="auto" frameborder="0" noresize style="height:90vh;width:99vw"></iframe>
	<iframe src="../../eCA/jsp/EncountersManageTxtButtons.jsp" name="manageTxtBtnsFrame" id="manageTxtBtnsFrame" scrolling="no" frameborder="0" noresize style="height:6vh;width:99vw"></iframe>
	<iframe src="../../eCommon/html/blank.html" name="interFrame" id="interFrame" scrolling="no" frameborder="0" noresize style="height:3vh;width:99vw"></iframe>


	