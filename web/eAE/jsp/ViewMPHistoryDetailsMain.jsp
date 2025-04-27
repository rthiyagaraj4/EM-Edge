<!DOCTYPE html>
<%--
/**
  *	Author				:	Mr.ArunaGiri.S
  * Created Date		:	18th June 2002
  * Last Modified Date	:	18th June 2002
  *	Purpose				:	Displays the User Interface for AE Patient History.
  */
--%>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<title><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/> </title>
     <script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<iframe name='ViewPatHistoryDetailsMainFrame' id='ViewPatHistoryDetailsMainFrame' src='../../eAE/jsp/ViewMPHistoryDetails.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize style='height:100vh;width:100vw'></iframe>

</html>

