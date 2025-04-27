<!DOCTYPE html>
<html>
<%@ page contentType=" text/html;charset=UTF-8" %>
<%	request.setCharacterEncoding("UTF-8");	%>

<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	 <frameset rows='*,32%'>
		<frameset cols='1%,*,20%'>
			<frame name='dummyFrame' src="../../eCommon/html/blank.html" frameborder=0>
			<frame name="trmtDentalChartDetails" frameborder="0" scrolling="no" noresize src="../../eOH/jsp/OHDentalChart.jsp?<%=request.getQueryString()%>">
			<frame name='trmtDentalChartView' src="../../eOH/jsp/OHTrmtDentalChartViewDetails.jsp?<%=request.getQueryString()%>" frameborder=0>
		</frameset>
			<frame name='trmtDentalChartDataEntry' src="../../eOH/jsp/DentalTreatment.jsp?<%=request.getQueryString()%>" frameborder=0> 
			<!-- <frame name='trmtDentalChartDataEntry' src="../../eOH/jsp/OHTrmtSendOutAcknowledgeTab.jsp?<%=request.getQueryString()%>" frameborder=0> -->
	</frameset>
</html>
