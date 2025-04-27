<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" %>
<html>
<head>
    <%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eMR/js/MajorMedicalEvents.js'></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String patID=request.getParameter("Patient_Id");
%>

<!--<frameset rows='5%,58%,37%'>
<frameset rows='7%,52%,40%'>-->
<iframe name='patLine' id='patLine' src='../../eCommon/jsp/pline.jsp?Patient_Id=<%=patID%>' frameborder='no' scrolling='no' style='height:8vh;width:100vw'></iframe>>
<iframe name='query' id='query' src='../../eMR/jsp/MajorMedicalEventsQueryResult.jsp?Patient_Id=<%=patID%>' frameborder='no' scrolling='auto' style='height:50vh;width:100vw'></iframe>
<iframe name='addmodify' id='addmodify' src='../../eMR/jsp/MajorMedicalEventsAddModify.jsp?Patient_Id=<%=patID%>' frameborder='no' scrolling='no' style='height:40vh;width:100vw'></iframe>
</html>

