<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");	%>
<html>
<%
	String queryString=request.getQueryString();
%>
<title>
	<fmt:message key="eOT.EncounterLookup.Label" bundle="${ot_labels}"/>
</title>
<iframe name='group_head' id='group_head' src='../../eOT/jsp/OTPatientSearchCriteria.jsp?<%=queryString%>' noresize  marginheight=0 marginwidth=0 style='height:18vh;width:100vw' frameborder='0'></iframe>
<iframe name='f_query_add_mod' id='f_query_add_mod'    src='../../eCommon/html/blank.html'  noresize  scrolling="yes"  marginheight=0 marginwidth=0 style='height:72vh;width:100vw' frameborder='0'></iframe>
<iframe name='group_tail' id='group_tail' src='../../eCommon/jsp/GeneralCancel.jsp' noresize   marginheight=0 marginwidth=0 style='height:10vh;width:100vw' frameborder='0'></iframe>
</html>

