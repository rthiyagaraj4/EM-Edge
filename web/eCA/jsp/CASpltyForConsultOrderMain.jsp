<!DOCTYPE html>

<%@page contentType="text/html; charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<head>
	<title></title>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src='../js/CAConsultation.js'></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<!-- <frameset rows="20%, 80%"> -->
<iframe name="CASpltyForConsultHdr" id="CASpltyForConsultHdr" src="../../eCA/jsp/CASpltyForConsultOrderHdr.jsp?<%=request.getQueryString()%>" noresize scrolling='no' frameborder='0' style='height:25vh;width:100vw'></iframe>
<iframe name="CASpltyForConsultDtl" id="CASpltyForConsultDtl" src="../../eCommon/html/blank.html" noresize scrolling='no'sss frameborder='0' style='height:75vh;width:100vw'></iframe>
<!-- </frameset> -->
</html>

