<!DOCTYPE html>

<%@page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<html>
<%
	String queryString=request.getQueryString();
%>
<title>
	<fmt:message key="eOT.EncounterLookup.Label" bundle="${ot_labels}"/>
</title>
<!--line no 17: OTApptRefSearchResults.jsp is changed to OTEncounterPatientSearchResults.jsp  --> 
<iframe name='group_head' id='group_head' src='../../eOT/jsp/OTEncounterPatientSearchCriteria.jsp?<%=queryString%>' noresize   marginheight=0 marginwidth=0 style='height:10vh;width:99vw'></iframe>
<iframe name='f_query_add_mod' id='f_query_add_mod'    src='../../eOT/jsp/OTEncounterPatientSearchResults.jsp?<%=queryString%>'  noresize  scrolling="yes"  marginheight=0 marginwidth=0 style='height:80vh;width:99vw'></iframe>
<iframe name='group_tail' id='group_tail' src='../../eCommon/jsp/GeneralCancel.jsp' noresize  marginheight=0 marginwidth=0 style='height:10vh;width:99vw'></iframe>
</html>

