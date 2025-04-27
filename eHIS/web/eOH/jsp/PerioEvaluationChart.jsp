<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%	request.setCharacterEncoding("UTF-8");	%>
<%
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<iframe name="perioChartRecordDetails" id="perioChartRecordDetails" frameborder="0" scrolling="auto" noresize src="../../eOH/jsp/PerioEvalChartRecordDetails.jsp?<%=request.getQueryString()%>"></iframe><iframe name="perioChartDisplay" id="perioChartDisplay" frameborder="0" scrolling="auto" noresize src="../../eOH/jsp/PerioEvalChartDisplay.jsp?<%=request.getQueryString()%>"></iframe>
	
</html>

