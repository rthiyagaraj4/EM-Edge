<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head><title>SpecialChartKeyIntervalMain</title>

<%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../js/SplChartKey.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	String url = "../../eCA/jsp/SplChartKeyIntervalDtl.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

	<iframe name="frameSplChartKeyIntervalDtl" id="frameSplChartKeyIntervalDtl" frameborder="0" noresize src=<%=source%> style="height:29vh;width:98vw"></iframe>
	<iframe name="frameSplChartKeyIntervalList" id="frameSplChartKeyIntervalList" src='../../eCommon/html/blank.html'  noresize frameborder="0" style='height:70vh;width:98vw'></iframe>

</html>

