<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%	request.setCharacterEncoding("UTF-8");	%>
<%
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String called_from_BC_EV_yn = request.getParameter("called_from_BC_EV_yn");
	called_from_BC_EV_yn=called_from_BC_EV_yn==null?"N":called_from_BC_EV_yn;
	called_from_BC_EV_yn=called_from_BC_EV_yn.equals("null")?"N":called_from_BC_EV_yn;
	called_from_BC_EV_yn=called_from_BC_EV_yn.equals("")?"N":called_from_BC_EV_yn;

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<frameset rows='23%,*,20%'>  
		<frame name="perioChartKey" id="perioChartKey" frameborder="0" scrolling="auto" noresize src="../../eOH/jsp/PerioChartKey.jsp?<%=request.getQueryString()%>"> 
		<%
		if(called_from_BC_EV_yn.equals("Y")){
		%>
			<frame name="perioChartRecord" id="perioChartRecord" frameborder="0" scrolling="auto" noresize src="../../eOH/jsp/PerioSummary.jsp?<%=request.getQueryString()%>">
		<%
			}else{
		%>
			<frame name="perioChartRecord" id="perioChartRecord" frameborder="0" scrolling="auto" noresize src="../../eOH/jsp/PerioEvalChartRecord.jsp?<%=request.getQueryString()%>">
		<%
			}
		%>
		
		<frame name="perioChartBaselineActive" id="perioChartBaselineActive" frameborder="0" scrolling="auto" noresize src="../../eOH/jsp/PerioEvalBaselineChart.jsp?<%=request.getQueryString()%>">
		<!-- <frame name="perioChartBaselineClosed" id="perioChartBaselineClosed" frameborder="0" scrolling="auto" noresize src="../../eOH/jsp/PerioChartBaselineClosed.jsp?<%=request.getQueryString()%>">  -->
	</frameset>
	
</html>

