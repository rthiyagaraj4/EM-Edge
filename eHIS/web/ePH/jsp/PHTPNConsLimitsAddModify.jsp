<!DOCTYPE html>
<%-- saved on 26/10/2005 --%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../js/TPNConsLimits.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String url = "../../ePH/jsp/PHTPNConsLimitsCriteria.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
		<iframe name="SearchCriteriaFrame" id="SearchCriteriaFrame" frameborder="0" scrolling="no" noresize src="<%= source %>" style="height:17vh;width:99vw"></iframe>
		<iframe name="SearchResultsFrame" id="SearchResultsFrame" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html" style="height:78vh;width:99vw"></iframe>
</html>

