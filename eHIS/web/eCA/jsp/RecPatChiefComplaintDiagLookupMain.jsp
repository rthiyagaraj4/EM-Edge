<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<title><fmt:message key="eCA.ChiefComplaint.label" bundle="${ca_labels}"/></title>
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
	<iframe name="RecPatChiefComplaintDiagLookupCriteriaFrame" id="RecPatChiefComplaintDiagLookupCriteriaFrame" src='../../eCA/jsp/RecPatChiefComplaintDiagLookupCriteria.jsp?<%=qrystr%>' frameborder=0 scrolling="no" noresize style='height:25vh;width:98vw'></iframe>
	<iframe name="RecPatChiefComplaintDiagLookupResultFrame" id="RecPatChiefComplaintDiagLookupResultFrame" src='../../eCA/jsp/blank.jsp?<%=qrystr%>' frameborder=0 scrolling="auto" noresize style='height:55vh;width:98vw'></iframe>
	<iframe name="RecPatChiefComplaintDiagLookupActionbuttonFrame" id="RecPatChiefComplaintDiagLookupActionbuttonFrame" src='../../eCA/jsp/RecPatChiefComplaintDiagLookupActionbutton.jsp?<%=qrystr%>' frameborder=0 scrolling="no" noresize style='height:8vh;width:98vw'></iframe>

</html>

