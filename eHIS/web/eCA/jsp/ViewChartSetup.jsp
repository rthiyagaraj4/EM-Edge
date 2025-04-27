<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.ChartMain.label" bundle="${ca_labels}"/></title>
		<script src="../../eCA/js/ViewChartSetup.js" language='javascript'></script> 
		<script src="../../eCommon/js/common.js" language='javascript'></script> 
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
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
	<frameset rows="10%,*,0%,10%">
		<frame name="commontoolbarFrame" src='<%=source%>' frameborder=0 noresize scrolling='no'></frame>
		<frameset rows='8%,*'>
			<frame name='viewChartHeaderFrame' src='../../eCA/jsp/blank.jsp' scrolling='no' frameborder=0 noresize></frame>
			<frame name='viewChartListFrame' src='../../eCA/jsp/blank.jsp' scrolling='auto' frameborder=0 ></frame>
		</frameset>
		<frame name='blankFrame' src='../../eCommon/html/blank.html' scrolling='no' frameborder=0 noresize></frame>
		<frame name='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' scrolling='auto' frameborder=0></frame>		
	</frameset>
</html>
