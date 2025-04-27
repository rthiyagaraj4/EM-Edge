<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" %>
<html>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String queryString=request.getQueryString();
%>
<title>Encounter Details</title>
<iframe name='group_head' id='group_head' src='../../eCA/jsp/CAEncounterDisplay.jsp?<%=queryString%>' noresize  frameborder=no marginheight=0 marginwidth=0 scrolling="auto" style='height:*%;width:100vw'></iframe><iframe name='group_head1' id='group_head1' src='../../eCommon/html/blank.html' noresize  frameborder=no marginheight=0 marginwidth=0 style='height:0%;width:100vw'></iframe>
</html>

