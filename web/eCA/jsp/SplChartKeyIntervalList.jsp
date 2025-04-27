<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head><title>SpecialChartKeyIntervalList</title>

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
    String dbDisplay = request.getParameter("db_display");
	String url = null;
	if(dbDisplay!=null && dbDisplay.equals("DB"))
	 url = "../../eCA/jsp/SplChartKeyDbList.jsp?" ;	
	else
	 url = "../../eCA/jsp/SplChartKeyIntervalListDtl.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

<iframe name="frameSplChartKeyIntervalListHdr" id="frameSplChartKeyIntervalListHdr" frameborder="0"  noresize src="../../eCA/jsp/SplChartKeyIntervalListHdr.jsp" scrolling='no' style='height:0vh;width:100vw'></iframe>
	<iframe name="frameSplChartKeyIntervalListDtl" id="frameSplChartKeyIntervalListDtl" frameborder="0" noresize src=<%=source%> style="height:90vh;width:100vw"></iframe>

</html>

