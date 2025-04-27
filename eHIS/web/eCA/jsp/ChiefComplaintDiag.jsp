<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	eCA.RecordDiagnosis RecordDiagnosisBean = (eCA.RecordDiagnosis)getObjectFromBean("RecordDiagnosisBean","eCA.RecordDiagnosis",session);
%>

<html>
<head>
<%
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
%>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
RecordDiagnosisBean.clearAllRecord();
%>
</head>
<iframe name="ChiefComplaintDiag" id="ChiefComplaintDiag" src='../../eCA/jsp/ChiefComplaintDiagCriteria.jsp?' frameborder=0 scrolling="no" noresize style='height:7vh;width:99vw'></iframe>
	<iframe name="ChiefComplaintDiagResult" id="ChiefComplaintDiagResult"  src='../../eCommon/html/blank.html' frameborder=0 scrolling="auto" noresize style='height:30vh;width:99vw'></iframe>
	<iframe name="ChiefComplaintDiagSearch" id="ChiefComplaintDiagSearch" src='../../eCommon/html/blank.html' frameborder=0 scrolling="no" noresize style='height:10vh;width:99vw'></iframe>
	<iframe name="ChiefComplaintDiagDetails" id="ChiefComplaintDiagDetails" src='../../eCommon/html/blank.html' frameborder=0 scrolling="auto" noresize style='height:45vh;width:99vw'></iframe>



</html>

