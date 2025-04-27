
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<html>
<title><fmt:message key="eOA.visitallocationdtls.label" bundle="${oa_labels}"/></title>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");	
	String fromfunction = request.getParameter("from")==null?"":request.getParameter("from");
	if(fromfunction.equals("DS")){
%>
	<iframe src="../../eOA/jsp/SetUpDailySchAllocationDetails.jsp?<%=request.getQueryString()%>" name="BlockApptAllocationDetailsFrame" id="BlockApptAllocationDetailsFrame" noresize scrolling='auto' style='height:80vh;width:100vw' frameborder="0"></iframe>
	<iframe src="../../eOA/jsp/SetUpDailySchAllocationDetailsTools.jsp?<%=request.getQueryString()%>" name="BlockApptAllocationDetailsToolsFrame" id="BlockApptAllocationDetailsToolsFrame" noresize scrolling='no' style='height:20vh;width:100vw' frameborder="0"></iframe>
<%}else{%>
	<iframe src="../../eOA/jsp/BlockApptAllocationDetails.jsp?<%=request.getQueryString()%>" name="BlockApptAllocationDetailsFrame" id="BlockApptAllocationDetailsFrame" noresize scrolling='auto' style='height:70vh;width:97vw' frameborder="0"></iframe>
	<iframe src="../../eOA/jsp/BlockApptAllocationDetailsTools.jsp?<%=request.getQueryString()%>" name="BlockApptAllocationDetailsToolsFrame" id="BlockApptAllocationDetailsToolsFrame" noresize scrolling='no' style='height:15vh;width:97vw' frameborder="0"></iframe>
<%
	}
%>
</html>

