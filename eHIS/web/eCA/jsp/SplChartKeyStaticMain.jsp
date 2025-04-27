<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head><title>SpecialChartKeyStaticMain</title>

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
	String url = "../../eCA/jsp/SplChartKeyStaticMainDtl.jsp?" ;
	String params = request.getQueryString() ;
	String xAxis_element= request.getParameter("xAxis_element")==null?"*K":request.getParameter("xAxis_element");
	String source = url + params ;
%>

	<iframe name="frameSplChartKeyStaticMainHdr" id="frameSplChartKeyStaticMainHdr" frameborder="0" noresize scrolling='no'src="../../eCA/jsp/SplChartKeyStaticMainHdr.jsp?xAxis_element=<%=xAxis_element%>"  style='height:10vh;width:98vw'></iframe>
	<iframe name="frameSplChartKeyStaticMainDtl" id="frameSplChartKeyStaticMainDtl" frameborder="0" noresize src=<%=source%> style="height:73vh;width:98vw"></iframe>
	<iframe name="frameSplChartKeyStaticMainFtr" id="frameSplChartKeyStaticMainFtr" frameborder="0" noresize src="../../eCA/jsp/SplChartKeyStaticMainFtr.jsp" style="height:15vh;width:98vw"></iframe>

</html>

