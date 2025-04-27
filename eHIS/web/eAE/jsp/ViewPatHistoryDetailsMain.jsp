<!DOCTYPE html>

<%--
/**
  * Created Date		:	18th June 2002
  * Last Modified Date	:	18th June 2002
  *	Purpose				:	Displays the User Interface for AE Patient History.
  **/
--%>
<%@ page contentType="text/html;charset=UTF-8" import ="eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

String encounter_id	=	request.getParameter("EncounterId");
String	facilityId 	= (String) session.getValue( "facility_id" ) ;
%>
<html>
<title><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></title>
<head> 
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<iframe name='ViewPatientLineFrame' id='ViewPatientLineFrame' src='../../eCommon/jsp/pline.jsp?Facility_Id=<%=facilityId%>&EncounterId=<%=encounter_id%>' frameborder=0 scrolling='no' noresize style='height:9vh;width:100vw'></iframe>
	<iframe name='ViewPatHistoryDetailsMainFrame' id='ViewPatHistoryDetailsMainFrame' src='../../eAE/jsp/ViewPatHistoryDetails.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize style='height:91vh;width:100vw'></iframe>

</html>

