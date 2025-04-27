<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eCA/js/DefaultTranscriberSetup.js'></script>
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
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='DefaultTransSetupHdr' id='DefaultTransSetupHdr'	src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:8vh;width:100vw'></iframe>
		<iframe name='DefaultTransSetupLink' id='DefaultTransSetupLink'	src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:7vh;width:100vw'></iframe>
		<iframe name='DefaultTransSetupList' id='DefaultTransSetupList'	src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:64vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='no' style='height:9vh;width:100vw'></iframe>
</html>

