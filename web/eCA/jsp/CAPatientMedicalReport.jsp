<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<script language='javascript' src='../js/CAPatMedReport.js'></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	

%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> frameborder=0 scrolling='no'  style='height:7vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod_upper' id='f_query_add_mod_upper' src='../../eCA/jsp/CAPatMedReportSearchCriteria.jsp?<%=params%>' frameborder=0 scrolling = 'no' style='height:16vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod_lower' id='f_query_add_mod_lower' src='../../eCommon/html/blank.html' frameborder=0 style='height:72vh;width:100vw'></iframe>	
	<iframe name='f_PMR_Intermediate' id='f_PMR_Intermediate' src='../../eCommon/html/blank.html' frameborder=0 style='height:5vh;width:100vw'></iframe>	
	<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:8vh;width:100vw'></iframe>
	<iframe name='dummy_frame' id='dummy_frame' frameborder=0 scrolling='no'  style='height:0vh;width:100vw'></iframe>

</html>

