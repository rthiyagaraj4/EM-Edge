<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="${sessionScope.LOCALE}" />
<c:url var="PatientBanner" value="/eOT/jsp/OTPatLineFrame.jsp" />
<c:url var="ObjectCollector" value="/eOT/jsp/NursingObjectCollect.jsp" />
<c:url var="Tabs" value="/eOT/jsp/SurgeryHistoryTabs.jsp" />
<c:url var="Blank" value="/eCommon/html/blank.html" />
<c:url var="Message" value="/eCommon/jsp/error.jsp" />
<!--variable declarations -->
<c:set var="sep" value="${'?'}" /> 
<c:set var="qrystring" value="${pageContext.request.queryString}" />
<c:set var="called_from" value="${param['called_from']}" />

<c:choose>  
	 <c:when test="${called_from=='OT_SLATE'}" >   
		 <title><fmt:message key="eOT.ViewCheckList.Label" bundle="${ot_labels}"/></title>
		 <FRAMESET rows="4%,*,50" border="0">
	  </c:when> 
	  <c:otherwise> 
		<title><fmt:message key="eOT.SurgeryHistory.Label" bundle="${ot_labels}"/></title>
		<FRAMESET rows="12%,10%,*,50" border="0">
		<frame name="OtPatientLineFrame" id='OtPatientLineFrame' frameborder="0" scrolling="no" noresize src='<c:out value="${PatientBanner}${sep}${qrystring}" />'>
	   </c:otherwise> 
</c:choose>
<FRAMESET rows ="0%,6%">
	<FRAME NAME='ObjectCollect' id='ObjectCollect'  SRC='<c:out value="${ObjectCollector}${sep}${qrystring}" />'  scrolling='no' noresize='no'>
	<FRAME NAME='tab_frame'  id='tab_frame'   SRC='<c:out value="${Tabs}${sep}${qrystring}" />'  scrolling='no' noresize></FRAME>
</FRAMESET>
	<FRAME NAME='RecordFrame'  id='RecordFrame'  SRC='<c:out value="${Blank}${sep}${qrystring}" />'  scrolling='no' noresize></FRAME>
	<FRAME name="messageFrame" id='messageFrame' SRC='<c:out value="${Message}${sep}${qrystring}" />' frameborder="0" noresize scrolling="no">
</FRAMESET>


	
