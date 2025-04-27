<!DOCTYPE html>
  <%-- saved on 27/10/2005 --%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
<head>
<script language="JavaScript" src="../js/ATCClassification.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String url = "../../ePH/jsp/ATCCloseLevel.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

	<iframe name='f_level_descs' id='f_level_descs' src="../../ePH/jsp/ATCViewLevel.jsp?level=&desc=" frameborder=0 scrolling='no' noresize bgcolor="navy" style='height:82vh;width:99vw'></iframe>
	<iframe name='f_close_levels' id='f_close_levels' src="<%=source%>" frameborder=0 scrolling='no' noresize style='height:11vh;width:95vw'></iframe>
	
</head>
</html>

