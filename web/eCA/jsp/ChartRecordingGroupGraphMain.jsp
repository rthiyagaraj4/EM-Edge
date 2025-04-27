<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 

	String queryString = request.getQueryString() == null ? "" : request.getQueryString();

	String splChartType = request.getParameter("splChartType") == null ? "" : request.getParameter("splChartType");
	String noOfChkdBoxes = request.getParameter("numOfchkedBoxes") == null ? "" : request.getParameter("numOfchkedBoxes");
	
	//java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	//String locale = (String) p.getProperty("LOCALE");

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
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	</head>
	<!-- <frameset rows="*,4%,0%" onunload="returnNumOfGroups()"> -->
	 <frameset rows="80%,4%,0%">
		<frameset cols="<%=cols%>" frameborder="1"  marginheight=0 marginwidth=0 >
			<frame name="viewsFrame" src="ChartRecordingSplChtViewsMain.jsp?<%=queryString%>" scrolling="auto"  marginheight=0 marginwidth=0 frameborder='0'></frame>
			<frame name="graphDisplayFrame" src="<%=fileNameGraph%>?<%=queryString%>"  marginheight=0 marginwidth=0 frameborder='0'></frame>
		</frameset>
		<frame name="closeGroupFrame" src="../../eCA/jsp/ChartRecordingGroupToolBar.jsp?<%=queryString%>" scrolling="no"  marginheight=0 marginwidth=0 frameborder='0'></frame>
		<FRAME SRC="../../eCommon/html/blank.html" NAME="blank_frame" scrolling=no  marginheight=0 marginwidth=0 frameborder='0'>
	</frameset> 
	<%-- <div style="height: 96vh;">
    <iframe name="viewsFrame" src="ChartRecordingSplChtViewsMain.jsp?<%=queryString%>" style="width: 100%; height: 50vh; border: 0;" scrolling="auto"></iframe>
    <iframe name="graphDisplayFrame" src="<%=fileNameGraph%>?<%=queryString%>" style="width: 100%; height: 50vh; border: 0;" scrolling="auto"></iframe>
	</div>
	<iframe name="closeGroupFrame" src="../../eCA/jsp/ChartRecordingGroupToolBar.jsp?<%=queryString%>" style="width: 100%; height: 4%; border: 0;" scrolling="no"></iframe>
	<iframe src="../../eCommon/html/blank.html" name="blank_frame" style="width: 100%; height: 0%; border: 0;" scrolling="no"></iframe>
		 --%>
</html>
