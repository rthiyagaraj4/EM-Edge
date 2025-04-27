<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
?             100            ?           created
15/11/2011	  IN29392		 Menaka V		Incident No:IN29392 - <Clinical Event History>View Graph·
											Select event result and then click View graph
											(Selected event result name contains a special character (?%?) )
											System Display error message in General graph box. >

--------------------------------------------------------------------------------------------------------
-->
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<HTML>
<HEAD>

<title><fmt:message key="eCA.Graph.label" bundle="${ca_labels}"/></title>
<script language="javascript" src="../../eCA/js/ChartRecording.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//eCA.ChartRecordingAddGroupBean chartingBean = (eCA.ChartRecordingAddGroupBean)getObjectFromBean("chartingBean","eCA.ChartRecordingAddGroupBean",session);

	String noOfGroups = request.getParameter("noOfGroups") == null ? "1" : request.getParameter("noOfGroups");	
	String facility_id = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");	
	String encounterId = request.getParameter("encounterId") == null ? "" : request.getParameter("encounterId");	
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String axis_range = request.getParameter("axis_range") == null ? "S" : request.getParameter("axis_range");
	String flowsheetGraph = request.getParameter("flowsheetGraph") == null ? "" : request.getParameter("flowsheetGraph");
	// IN29392 Starts
	String grpDetails = request.getParameter("grpDetails") == null ? "" : request.getParameter("grpDetails");
	grpDetails = java.net.URLDecoder.decode(grpDetails);
	String xAxisDesc = request.getParameter("xAxisDesc") == null ? "" : request.getParameter("xAxisDesc");
	xAxisDesc = java.net.URLDecoder.decode(xAxisDesc);
	String yAxisDesc = request.getParameter("yAxisDesc") == null ? "" : request.getParameter("yAxisDesc");
	yAxisDesc = java.net.URLDecoder.decode(yAxisDesc);
	// IN29392 Ends
	if(noOfGroups.equals("") || noOfGroups.equals("0"))
		noOfGroups = "1";
	else noOfGroups = noOfGroups;
	String numOfchkedBoxes = request.getParameter("numOfchkedBoxes") == null ? "1" : request.getParameter("numOfchkedBoxes");		
%>
<script>
function splitArray()
{
	if('<%=noOfGroups%>' == '1')
	{
		document.getElementById("frmset").rows='*%,0%'
		callGraphDisplay1('1');
	}
	else if('<%=noOfGroups%>' == '2')
	{
		document.getElementById("frmset").rows='50%,50%,0%';
		callGraphDisplay1('1');
		callGraphDisplay1('2');
	}
	else if('<%=noOfGroups%>' == '3')
	{
		document.getElementById("frmset").rows='33%,33%,33%,0%';
		callGraphDisplay1('1');
		callGraphDisplay1('2');
		callGraphDisplay1('3');
	}
	else if('<%=noOfGroups%>' == '4')
	{
		document.getElementById("frmset").rows='25%,25%,25%,25%,0%';
		callGraphDisplay1('1');
		callGraphDisplay1('2');
		callGraphDisplay1('3');
		callGraphDisplay1('4');
	}
}

function callGraphDisplay1(val)
{
	var HTMLVal;
	if('<%=axis_range%>' == 'S')
	{
		HTMLVal		=	"<html><body onKeyDown='lockKey()'><form name='argumentForm' id='argumentForm' "+
						" action='../../eCA/jsp/ChartRecordingSplChtLineGraph.jsp' method='post'>"+
						"<input type='hidden' name='group' id='group' value='"+val+"'>"+
						"<input type='hidden' name='noOfGroups' id='noOfGroups' value='<%=noOfGroups%>'>"+
						"<input type='hidden' name='numOfchkedBoxes' id='numOfchkedBoxes' value='<%=numOfchkedBoxes%>'>"+
						"<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>"+
						"<input type='hidden' name='encounterId' id='encounterId' value='<%=encounterId%>'>"+
						"<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>"+
						"<input type='hidden' name='flowsheetGraph' id='flowsheetGraph' value='<%=flowsheetGraph%>'>"+
						"</form></body></html>";
	}
	else
	{
		HTMLVal		=	"<html><body onKeyDown='lockKey()'><form name='argumentForm' id='argumentForm' "+
						" action='../../eCA/jsp/ChartRecordingMultiAxisGraph.jsp' method='post'>"+
						"<input type='hidden' name='group' id='group' value='"+val+"'>"+
						"<input type='hidden' name='noOfGroups' id='noOfGroups' value='<%=noOfGroups%>'>"+
						"<input type='hidden' name='numOfchkedBoxes' id='numOfchkedBoxes' value='<%=numOfchkedBoxes%>'>"+
						"<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>"+
						"<input type='hidden' name='encounterId' id='encounterId' value='<%=encounterId%>'>"+
						"<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>"+
						"<input type='hidden' name='flowsheetGraph' id='flowsheetGraph' value='<%=flowsheetGraph%>'>"+
						"</form></body></html>";
	}

	eval("self.chart_frame"+val+".document.body.insertAdjacentHTML('afterbegin',HTMLVal)");
	eval("self.chart_frame"+val+".document.argumentForm.submit()");
}

/********************ends here**********/
</script>
<FRAMESET id='frmset' ROWS="*,*,*,*,*" framespacing=0 frameborder=1 onLoad="splitArray();" onUnload="callOnExit('<%=noOfGroups%>')">
	<FRAME SRC="../../eCommon/html/blank.html" NAME="chart_frame1" scrolling=auto  noresize marginheight=0 marginwidth=0 frameborder='0'>
	<FRAME SRC="../../eCommon/html/blank.html" NAME="chart_frame2" scrolling=auto  noresize marginheight=0 marginwidth=0 frameborder='0'>
	<FRAME SRC="../../eCommon/html/blank.html" NAME="chart_frame3" scrolling=auto  noresize marginheight=0 marginwidth=0 frameborder='0'>
	<FRAME SRC="../../eCommon/html/blank.html" NAME="chart_frame4" scrolling=auto  noresize marginheight=0 marginwidth=0 frameborder='0'>
	<FRAME SRC="../../eCommon/html/blank.html" NAME="dummy_frame" scrolling=no  noresize marginheight=0 marginwidth=0 frameborder='0'>
</FRAMESET>
</HTML>


