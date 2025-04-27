<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.ChartMain.label" bundle="${ca_labels}"/></title>
		<script src="../../eCA/js/ChartSetup.js" language='javascript'></script> 
		<script src="../../eCommon/js/common.js" language='javascript'></script> 
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?";
	String param = request.getQueryString();
	String source = url+param;
	%>
	<iframe name="commontoolbarFrame" id="commontoolbarFrame" src='<%=source%>' frameborder=0 noresize scrolling='no' style='height:7vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCA/jsp/blank.jsp' scrolling='auto' frameborder=0 style='height:83vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' scrolling='auto' frameborder=0 style='height:9vh;width:100vw'></iframe>
		<iframe name='blankFrameSummYN' id='blankFrameSummYN' src='../../eCA/jsp/ChartSetupIntermediateSummYN.jsp' scrolling='auto' frameborder=0 style='height:0vh;width:100vw'></iframe>
		<iframe name='blankFrameUpdateCopmTab' id='blankFrameUpdateCopmTab' src='../../eCA/jsp/ChartSetupIntermediateUpdateCompTab.jsp' scrolling='auto' frameborder=0 style='height:0vh;width:100vw'></iframe>
	
</html>

