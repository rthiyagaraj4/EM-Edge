<!DOCTYPE html>
<%
 /*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name        		Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------------------
15/05/2018  		IN065254		Kamalakannan G  		15/05/2018 		 Ramesh G 		GHL_CRF_0485
23/05/2018 		IN067697		Kamalakannan G  		21/05/2018 		 Ramesh G 		GHL_CRF_0485/01
---------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%
try
{
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<html>
<head>
	<title>Status Report</title><!-- need to be change with message -->
 	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<iframe scrolling="no" name='nursePlanCriteria' id='nursePlanCriteria' src='../jsp/NursingPlanReportCriteria.jsp?<%=request.getQueryString()%>' noresize  frameborder=0 scrolling='no' noresize style='height:30%;width:100vw'></iframe>
	<iframe name='nursePlanResult' id='nursePlanResult' src='../../eCommon/html/blank.html'  frameborder=0 scrolling='auto'>	
	<iframe scrolling="no" name='printFrame' id='printFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:100vh;width:100vw'></iframe><!--IN067697-->
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize style='height:10%;width:100vw'></iframe>


</html>

<%
}
catch(Exception e)
{
e.printStackTrace();	
}
%>

