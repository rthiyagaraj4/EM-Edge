<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<title><fmt:message key="Common.medical.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Event.label" bundle="${common_labels}"/></title>
 <%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCA/js/MedicalEvents.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<iframe name='MedicalEventsResultFrame' id='MedicalEventsResultFrame' src='../../eCA/jsp/MedicalEventsQueryResult.jsp?<%=request.getQueryString()%>' frameborder=0 noresize scrolling="yes" style='height:46vh;width:100vw'></iframe><iframe name='MedicalEventsDtlFrame' id='MedicalEventsDtlFrame' src='../../eCA/jsp/MedicalEventsDetail.jsp?<%=request.getQueryString()%>' frameborder=0 noresize scrolling="no" style='height:65vh;width:100vw'></iframe>
</head>
</html>

