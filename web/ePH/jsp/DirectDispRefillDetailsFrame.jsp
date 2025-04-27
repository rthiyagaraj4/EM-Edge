<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<title><fmt:message key="ePH.RefillDetails.label" bundle="${ph_labels}"/></title>
</head>

<%
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String params = request.getQueryString() ;
	
%>
<iframe name="refill_detail" id="refill_detail" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/DirectDispRefillDetails.jsp?<%=params%>"" style="height:82vh;width:100vw"></iframe><iframe name="refill_close" id="refill_close" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/DirectDispClose.jsp?called_from=refill" style="height:18vh;width:100vw"></iframe>

</html>


