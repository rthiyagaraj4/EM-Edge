<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name        		Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------------------
23/05/2018 		IN067699		Kamalakannan G  		21/05/2018 		 Ramesh G 		GHL_CRF_0485/01
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
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	StringBuffer source = new StringBuffer();
	source.append(params) ;
%>

<iframe scrolling="no" name='TaskReportCriteria' id='TaskReportCriteria' src='../jsp/TaskStatusReportCriteria.jsp?<%=request.getQueryString()%>' noresize  frameborder=0 style='height:30%;width:100vw'></iframe><iframe name='TaskReportResult' id='TaskReportResult' src='../../eCommon/html/blank.html'  frameborder=0>	
	<iframe scrolling="no" name='printFrame' id='printFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:100vh;width:100vw'></iframe><!--IN067699-->
	<iframe scrolling="no" name='task_intermediate' id='task_intermediate' src='../../eCommon/html/blank.html'  frameborder=0 style='height:10%;width:100vw'></iframe>
</html>

<%
}
catch(Exception e)
{
e.printStackTrace();	
}
%>











