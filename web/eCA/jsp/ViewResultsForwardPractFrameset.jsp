<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
	<title><fmt:message key="Common.ForwardtoPractitioner.label" bundle="${common_labels}"/></title>
    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='ReviewResultsForwardPractSearch' id='ReviewResultsForwardPractSearch' src='ViewResultsForwardPractSearch.jsp?<%=request.getQueryString()%>' frameborder=0  scrolling=no noresize style='height:11vh;width:99vw'></iframe>
	<iframe name='ReviewResultsForwardPractHeader' id='ReviewResultsForwardPractHeader' src='ViewResultsForwardPractHeader.jsp' frameborder=0 style='height:5vh;width:99vw' ></iframe>
	<iframe name='ReviewResultsForwardPract' id='ReviewResultsForwardPract' src='../../eCommon/html/blank.html' frameborder=0  style='height:70vh;width:99vw;border="none"'></iframe>
	<iframe name='ReviewResultsForwardPractBtn' id='ReviewResultsForwardPractBtn' src='ViewResultsForwardPractToolbar.jsp' frameborder=0 scrolling=no noresize style='height:10vh;width:99vw'></iframe>

</html>

