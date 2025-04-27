<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
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
		<frame name='dummyFrame' src="../../eCommon/html/blank.html" frameborder=0 noresize>
		<frame name="conditionDentalChartDetails" frameborder="0" scrolling="no" noresize src="../../eOH/jsp/OHDentalChart.jsp?<%=request.getQueryString()%>&treat_Locn_Type=E">
		<frame name='conditionDentalChartView' src="../../eOH/jsp/OHCondDentalChartViewDetails.jsp?<%=request.getQueryString()%>" frameborder=0 noresize>
	</frameset>
		<frame name='conditionDentalChartDataEntry' src="../../eOH/jsp/OHCondDentalChartTabSearch.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling="auto" noresize> 
		<!-- <frame name='OHTrmtSendOutAcknwoledgeFrame' src="../../eOH/jsp/OHTrmtSendOutAcknwoledgeFrame.jsp?<%=request.getQueryString()%>" frameborder=0> -->
</frameset> 

</html>
<%
%>


