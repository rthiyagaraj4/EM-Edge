<!DOCTYPE html>
<HTML>
<%@ page import= "java.util.*" %>
<%@ page import="java.sql.Connection,com.ehis.util.DateUtils,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 																	    
request.setCharacterEncoding("UTF-8");
String locale = ((String)session.getAttribute("LOCALE"));
String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
session.putValue("PatientSearch","true" );

String app_id = request.getParameter("app_id");
String event_type = request.getParameter("event_type");
String notification_status = request.getParameter("notification_status");
String specimen_from_date = (String)request.getParameter("specimen_from_date");
String specimen_to_date = (String)request.getParameter("specimen_to_date");
String onlyRequiredColumnCompleteQuery = (String)request.getParameter("onlyRequiredColumnCompleteQuery");

%>	

<HEAD>																								  
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="javascript" src="../../eXH/js/XHAjaxUtil.js"></script>
<script type="text/javascript" src="../../eXH/js/trackNotificationTable.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title>Report Option</title>
</HEAD>
<body>
<form id="ExportReportFormId" name="ExportReportForm" id="ExportReportForm" method="post">
	<table style="width: 100%;">
		<tr>
			<td>

				<table style="width: 80%;">
					<tr>
						<td class=label>Report Option</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td class=label><select id="reportOption">
								<option value="View">View</option>
								<option value="Print">Print</option>
								<option value="Save">Save</option></td>

					</tr>
					<tr>
						<td class=label>File Format</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td class=label><select id="fileFormat" name="fileType" id="fileType">
								<%--<option value="PDF">PDF</option>--%>
								<option value="SpreadSheet">SpreadSheet</option></td>

					</tr>
					<tr></tr>
					<tr></tr>
					<tr></tr>
					<tr></tr>
					<tr></tr>
					<tr></tr>

				</table> <br /> <br /> <br /> <br /> <br />
				<table>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
							<td class=label align="center"><button
								onclick="exportingTrackNotification()">OK</button>
							<button onclick="closeExportReport()">Cancel</button></td>
					</tr>
							</center>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<iframe id = "dummyFrame" style = "display:none"> </iframe>
	
	<input type='hidden' name='app_id' id='app_id' id='app_id' value='<%= app_id%>'>
	<input type='hidden' name='event_type' id='event_type' id='event_type' value='<%= event_type%>'>
	<input type='hidden' name='notification_status' id='notification_status' id='notification_status' value='<%= notification_status%>'>
	<input type='hidden' name='specimen_from_date' id='specimen_from_date' id='specimen_from_date' value='<%= specimen_from_date%>'>
	<input type='hidden' name='specimen_to_date' id='specimen_to_date' id='specimen_to_date' value='<%= specimen_to_date%>'>
	<input type='hidden' name='onlyRequiredColumnCompleteQuery' id='onlyRequiredColumnCompleteQuery' id='onlyRequiredColumnCompleteQuery' value='<%= onlyRequiredColumnCompleteQuery%>'>
</form>
</body>
</html>

