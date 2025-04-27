<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%	request.setCharacterEncoding("UTF-8");	%>

<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String gingival_recording_by = request.getParameter("gingival_recording_by");
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
	<!-- <frameset rows='0,*,0'>   -->
		<!-- <frame name="dummyFrame" frameborder="0" scrolling="no" noresize src="../../eOH/jsp/OHMixedDentAlertFrame.jsp?<%=request.getQueryString()%>"> -->
	<!-- 	<frameset rows='19%,*'> -->
		<frameset rows='19%,*'>
		<frame name="perioSummaryTitleFrame" frameborder="0" scrolling="no" noresize src="../../eOH/jsp/PeriodontalSummaryTitle.jsp?<%=request.getQueryString()%>"> 
		<frameset cols='*,60%'>
		<%
			if(gingival_recording_by.equals("Q")){
		%>
				<frame name="perioSummaryFrame" frameborder="0" scrolling="auto" noresize src="../../eOH/jsp/PeriodontalSummary.jsp?<%=request.getQueryString()%>"> 
		<%
			}
		else{
		%>
				<frame name="perioSummaryFrame" frameborder="0" scrolling="auto" noresize src="../../eOH/jsp/PeriodontalSummaryForSextant.jsp?<%=request.getQueryString()%>"> 
		<%
			}
		%>
			<frame name="perioSummaryDetailsFrame" frameborder="0" scrolling="no" noresize src="../../eOH/jsp/PeriodontalSummaryDetailsFrame.jsp?<%=request.getQueryString()%>" > 
		</frameset>
	</frameset>
	
</html>
