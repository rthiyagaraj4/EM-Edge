<!DOCTYPE html>
<!--MDS For Diagnosis Mandatory-->
<%
/*
--------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
--------------------------------------------------------------------------------------------------------
08/05/2019		IN69021			Ramesh G			?				?				MMS-DM-CRF-0150
--------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<html>
<head>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script> 
<script language='javascript' src="../js/OrCommon.js"></script>
<script language='javascript' src='../js/MDSForDiagnosisMandatory.js'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	session.setAttribute("MstCodeToolbar", source);
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='<%=source%>' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:80vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
</html>

