<!DOCTYPE html>

<!--
Developed by    : Bhavani Shankar.
Module/Function : Swab Count 
start date		: 30/04/2005
-->
<%@ page contentType=" text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<html>
<title><fmt:message key="eOT.SwabCount.Label" bundle="${ot_labels}"/></title>
<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="${sessionScope.LOCALE}" />
<c:set var="prefix" value="${'/eCommon/html/'}" /> 
<c:set var="style" value="${prefix}${sessionScope.PREFERRED_STYLE}" /> 
<c:url var="ToolBar" value="/eCommon/jsp/commonToolbar.jsp" />
<c:url var="PatientBanner" value="/eOT/jsp/OTPatLineFrame.jsp" />
<c:url var="SwabHeader" value="/eOT/jsp/SwabCountPatientHeader.jsp" />
<c:url var="SwabButton" value="/eOT/jsp/SwabCountAddSerialNumberButtons.jsp" />
<c:url var="Tabs" value="/eOT/jsp/SwabCountTabs.jsp" />
<c:url var="Blank" value="/eCommon/html/blank.html" />
<c:set var="sep" value="${'?'}" /> 
<c:set var="qrystring" value="${pageContext.request.queryString}" />
<c:set var="called_from" value="${param['called_from']}" />
<c:set var="message_frame" value="../../eCommon/jsp/error.jsp" />

<head>
<link rel='StyleSheet' type='text/css'  href='<c:url value="${style}" />' />
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eOT/js/VerifyCheckList.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
	
	<c:choose>  
		<c:when test="${'OT_SLATE' eq called_from}" >   
		  <iframe name="OtPatientLineFrame" id="OtPatientLineFrame"  scrolling="no" noresize src='<c:out value="${PatientBanner}${sep}${qrystring}" />' style='height:10vh;width:100vw'></iframe>
		  </c:when> 
		<c:otherwise> 
		  
		 </c:otherwise> 
	</c:choose>
	<iframe name="f_header" id="f_header"  scrolling="no" noresize src='<c:out value="${SwabHeader}${sep}${qrystring}" />'  frameborder='0' style='height:13vh;width:100vw'></iframe>
	<iframe name="f_serial_number_frame" id="f_serial_number_frame"  scrolling="no" noresize src='<c:out value="${SwabButton}${sep}${qrystring}" />' frameborder='0' style='height:5vh;width:100vw'></iframe>
	<iframe name="f_tab_frames" id="f_tab_frames"  scrolling="no" noresize src='<c:out value="${Tabs}${sep}${qrystring}" />'  frameborder='0' style='height:4vh;width:100vw'></iframe>
	<iframe name="f_tab_detail_frames" id="f_tab_detail_frames"  scrolling="no" noresize src='<c:out value="${Blank}${sep}${qrystring}" />' frameborder='0' style='height:61vh;width:100vw'></iframe>
	<iframe name="messageFrame" id="messageFrame" src='<c:out value="${message_frame}${sep}${qrystring}" />' noresize scrolling="auto" frameborder='0' style='height:7vh;width:100vw'></iframe>
</html>

