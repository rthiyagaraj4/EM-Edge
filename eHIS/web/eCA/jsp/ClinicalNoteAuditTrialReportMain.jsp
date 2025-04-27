<!DOCTYPE html>
<%
/*							
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History    	Name				Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------

20/10/2020      IN073108    		Nijitha				20/10/2020       Ramesh G       ML-MMOH-CRF-1546
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<script src='../../eCA/js/ClinicalNoteAuditTrialReport.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../jsp/ClinicalNoteAuditTrialReportCriteria.jsp' frameborder=0 scrolling='no' noresize style='height:30vh;width:100vw'></iframe>
	<iframe name='f_query_clntaudittrialresult' id='f_query_clntaudittrialresult' src='../../eCommon/html/blank.html' scrolling="no"  frameborder=0 style='height:52vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:10vh;width:100vw'></iframe>
</html>

