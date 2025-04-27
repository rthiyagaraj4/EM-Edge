<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<!-- Modified by Archana on 3/25/2010 at 1:50 PM for IN020265.
Title has beed changed from 'Diagnosis For Current Chief Complaint' to 'Suggested Diagnosis For Current Chief Complaint'-->
<title> <fmt:message key="eCA.SuggestedDiagnosisForCurrentChiefComplaint.label" bundle="${ca_labels}"/></title>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String qrystr = request.getQueryString();
%>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<iframe name="RecPatChiefComplaintViewAllDiagResultframe" id="RecPatChiefComplaintViewAllDiagResultframe" src='../../eCA/jsp/RecPatChiefComplaintViewAllDiagResult.jsp?<%=qrystr%>' frameborder=0 scrolling="auto" noresize style='height:70vh;width:98vw'></iframe>
	<iframe name="RecPatChiefComplaintViewAllDiagActionButtonFrame" id="RecPatChiefComplaintViewAllDiagActionButtonFrame" src='../../eCA/jsp/RecPatChiefComplaintViewAllDiagActionButton.jsp?<%=qrystr%>' frameborder=0 scrolling="no" noresize style='height:10vh;width:98vw'></iframe>

</html>

