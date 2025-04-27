<!DOCTYPE html>
<%@ page contentType=" text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="${sessionScope.LOCALE}" />
<c:url var="CommonPatientLine" value="/eOT/jsp/CommonPatLine.jsp" />
<c:url var="OTPatientLine" value="/eOT/jsp/OTpatLine.jsp" />
<c:set var="qrystring" value="${pageContext.request.queryString}" />
<c:set var="facility_id" value="${sessionScope.facility_id}" />
<c:set var="sep" value="${'?'}" /> 

<iframe name='CommonPatientLineFrame' id='CommonPatientLineFrame' src='<c:out value="${CommonPatientLine}${sep}${qrystring}" />'   scrolling="no" frameborder='0' noresize style="height:50vh;width:100vw"></iframe>
<iframe name='OTPatientLineFrame' id='OTPatientLineFrame' SRC='<c:out value="${OTPatientLine}${sep}${qrystring}" />'  scrolling='NO' noresize frameborder='0' style="height:25vh;width:100vw">	</iframe>


