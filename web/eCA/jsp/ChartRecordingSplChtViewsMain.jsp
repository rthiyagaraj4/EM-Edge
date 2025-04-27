<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

		//java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		//String locale = (String) p.getProperty("LOCALE");

		String queryString = request.getQueryString() == null ? "" : request.getQueryString();

		//out.println("<script>alert('"+queryString+"');</script>");
		
		String flowsheetGraph = request.getParameter("flowsheetGraph") == null ? "" : request.getParameter("flowsheetGraph");
		String splChartType = request.getParameter("splChartType") == null ? "" : request.getParameter("splChartType");
		String numOfchkedBoxes = request.getParameter("numOfchkedBoxes") == null ? "0" : request.getParameter("numOfchkedBoxes");
		String calledFrom = request.getParameter("calledFrom") == null ? "" : request.getParameter("calledFrom");
		String fileName = "" , rows1 = "*,40%";

		if(calledFrom.equals("RecMat") || flowsheetGraph.equals("Y"))
		{
			fileName = "../../eCommon/html/blank.html";
			rows1 = "*,0%";
		}
		else
		{
			fileName = "../../eCA/jsp/ChartRecordingStdChtUserInput.jsp";
			rows1 = "*,40%";
		}

		String rows = "50%,50%";

		if(!splChartType.equals("GR"))
		{
			rows = "*,0%";
		}
		else if(splChartType.equals("GR"))
		{
			if(numOfchkedBoxes.equals("0") || numOfchkedBoxes.equals(""))
			{
				rows = "0%,*";
			}
			else
				rows = "*,0%";
		}

%>

<html>
	<head>
		<title><fmt:message key="eCA.GroupingEvents.label" bundle="${ca_labels}"/></title>
		<script language='javascript' src='../../eCA/js/ChartRecording.js'></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>

	<frameset rows='<%=rows%>' id='viewsFrmId' frameborder='1' marginheight=0 marginwidth=0>

		<frameset rows='<%=rows1%>' frameborder='0' id='stdGroup' marginheight=0 marginwidth=0>
			<frame name='splChtStandardViewFrame' src='../../eCA/jsp/ChartRecordingGroupsFrame.jsp?<%=queryString%>' scrolling='auto' noresize marginheight=0 marginwidth=0 frameborder='0'></frame>
			<frame name='stdChtCustomViewFrame' src='<%=fileName%>?<%=queryString%>' scrolling=NO frameborder='0' noresize marginheight=0 marginwidth=0></frame> 
		</frameset>
		<frameset rows='*,40%' frameborder='0' id='splGroup' marginheight=0 marginwidth=0>
			<frame name='splChtSpecialViewFrame' src='../../eCA/jsp/ChartRecordingSplChtLinks.jsp?<%=queryString%>' scrolling='auto' allowtransparency=true style='background:#E2E3F0;' noresize frameborder='0' marginheight=0 marginwidth=0></frame>
			<frame name='splChtCustomViewFrame' src='../../eCA/jsp/ChartRecordingSplChtUserInput.jsp?<%=queryString%>' scrolling='auto' allowtransparency=true style='background:#E2E3F0;' noresize frameborder='0' marginheight=0 marginwidth=0></frame> 
		</frameset>

	</frameset>
</html>
