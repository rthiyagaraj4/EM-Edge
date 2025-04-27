<% 
/*
-------------------------------------------------------------------------------------------------------------------------------
	Date		Edit History	   Name				Rev.Date   		Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------
05/11/2024	    70709         Gunasekar R        06/11/2024    Ashwini Ragupathi    ML-MMOH-CRF-1759            
---------------------------------------------------------------------------------------------------------------------------------
*/   
%>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
 <%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
    <title><fmt:message key="eCA.ViewPatientListbyLocation.label" bundle="${ca_labels}"/></title>
	</head>
<%  String locationType=request.getParameter("locationType")==null?"":request.getParameter("locationType"); 
%>
		<iframe name='MenstPatCriteriaFr' id='MenstPatCriteriaFr'		src='../../eCA/jsp/MenstrualHistPatListCriteria.jsp?locationType=<%=locationType%>'   frameborder=0 scrolling='no'  noresize frameborder='0' style='height:28%;width:100vw'></iframe>
			<iframe name='MenstPatResultFr' id='MenstPatResultFr'		src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize frameborder='0' style='height:100vh;width:100vw'></iframe>
		<iframe name='colorRefframe' id='colorRefframe' src='../../eCA/jsp/CAMenstPatColorReference.jsp' frameborder=1 noresize marginheight=0 marginwidth=0  class='normal' frameborder='0' style='height:7%;width:100vw'></iframe>
		 
</html>

