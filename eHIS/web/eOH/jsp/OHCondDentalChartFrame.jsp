<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%	request.setCharacterEncoding("UTF-8");	%>

<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	//String params = request.getQueryString();
	String loaded_from_main_tab = checkForNull(request.getParameter("loaded_from_main_tab")); 
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!-- <frameset cols='*,20%'>
	<frameset rows='11%,*,27%'>
		<frame name="conditionDentalChartToolHeader" id="conditionDentalChartToolHeader" frameborder="0" scrolling="no" noresize src="../../eOH/jsp/OHDentalChartToolHeader.jsp?<%=request.getQueryString()%>">
		<frame name="conditionDentalChartDetails" id="conditionDentalChartDetails" frameborder="0" scrolling="no" noresize src="../../eOH/jsp/OHDentalChart.jsp?<%=request.getQueryString()%>&treat_Locn_Type=E">
		<frame name='conditionDentalChartDataEntry' id='conditionDentalChartDataEntry' src="../../eOH/jsp/OHCondDentalChartTabSearch.jsp?<%=request.getQueryString()%>" frameborder=0>
	</frameset>
	<frame name='conditionDentalChartView' id='conditionDentalChartView' src="../../eOH/jsp/OHCondDentalChartViewDetails.jsp?<%=request.getQueryString()%>" frameborder=0>
</frameset> -->

	<!-- <frameset rows='4%,0,*,0'>  on 221007-->
	<frameset rows='0,*,0'>  
		<!-- <frame name="conditionDentalChartToolHeader" id="conditionDentalChartToolHeader" frameborder="0" scrolling="no" noresize src="../../eOH/jsp/OHDentalChartToolHeader.jsp?<%=request.getQueryString()%>"> --><!-- // THis frame is included in OH.jsp -->
		
		<!-- <frame name="dummyFrame" id="dummyFrame" frameborder="0" scrolling="no" noresize src="../../eOH/jsp/OHMixedDentAlertFrame.jsp?<%=request.getQueryString()%>"> -->
		<frame name="dummyFrame" id="dummyFrame" frameborder="0" scrolling="no" noresize src="../../eOH/jsp/OHMixedDentAlertFrame.jsp?<%=request.getQueryString()%>&<%=loaded_from_main_tab%>">
		<frame name="conditionDentalChart" id="conditionDentalChart" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html"> 
		
<!-- 		<frame name="constantsFrame" id="constantsFrame" frameborder="0" scrolling="no" noresize src="../../eOH/jsp/Constants.jsp"> -->
	</frameset>
	
</html>

