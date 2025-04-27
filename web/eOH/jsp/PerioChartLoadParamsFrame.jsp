<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%	request.setCharacterEncoding("UTF-8");	%>
<%
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String main_tab = request.getParameter("main_tab");
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
	if(main_tab.equalsIgnoreCase("Compare")){
%>
	<iframe name="perioChartRecordFrame" id="perioChartRecordFrame" frameborder="0" scrolling="no" noresize src="../../eOH/jsp/PerioCompareChartResultFrame.jsp?<%=request.getQueryString()%>" style="height:100vh;width:100vw"></iframe>
<%
}else{
%>
	<frameset rows='0%,*'>  
		<frame name="perioLoadParams" id="perioLoadParams" frameborder="0" scrolling="auto" noresize src="../../eOH/jsp/PerioChartInterParams.jsp?<%=request.getQueryString()%>"> 
		<!-- <frame name="perioChartTabRecordFrame" id="perioChartTabRecordFrame" frameborder="0" scrolling="no" noresize src="../../eOH/jsp/PerioChartTabRecordFrame.jsp?<%//=request.getQueryString()%>"> -->
		<frame name="perioChartRecordFrame" id="perioChartRecordFrame" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html">
	</frameset>
<%
	}
%>
</html>

