<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");

	String queryString = request.getQueryString() == null ? "" : request.getQueryString();
	String splChartType = request.getParameter("splChartType") == null ? "" : request.getParameter("splChartType");
	String noOfChkdBoxes = request.getParameter("numOfchkedBoxes") == null ? "" : request.getParameter("numOfchkedBoxes");
	
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

	String cols = "18%,*";
	String fileNameGraph = "../../eCA/jsp/ChartRecordingGraphFrameMain.jsp";

	if((!splChartType.equals("GR") && noOfChkdBoxes.equals("1")) || (!splChartType.equals("GR") && noOfChkdBoxes.equals("1"))) //if the chart is not a special chart and only one event is selected
	{
		fileNameGraph = "../../eCA/jsp/ChartRecordingGraphFrameMain.jsp";
		cols = "0%,*";
	}
	else
	{
		cols = "18%,*";
	}
	
%>
<html>
	<head>
		<title><fmt:message key="eCA.Graphs.label" bundle="${ca_labels}"/></title>
		<script language='javascript' src='../../eCA/js/ChartRecording.js'></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
	</head>
	<frameset rows="*,3%" onunload="returnNumOfGroups()">
		<frameset cols="<%=cols%>" frameborder="1">
			<frame name="viewsFrame" src="ChartRecordingSplChtViewsMain.jsp?<%=queryString%>" scrolling="auto"></frame>
			<frame name="graphDisplayFrame" src="<%=fileNameGraph%>?<%=queryString%>"></frame>
		</frameset>
		<frame name="closeGroupFrame" src="../../eCA/jsp/ChartRecordingGroupToolBar.jsp?<%=queryString%>" scrolling="no"></frame>
	</frameset>
</html>
