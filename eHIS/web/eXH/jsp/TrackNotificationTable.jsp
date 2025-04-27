<!DOCTYPE html>
<%@page import="java.text.DateFormat"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page
	import="java.sql.Connection,java.sql.ResultSetMetaData,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.*,eXH.XHDBAdapter,java.io.*"%>
<%@ page import="java.util.*"%>

<%
	Connection con = null;
	PreparedStatement pst = null;
	PreparedStatement pst1 = null;
	ResultSet rs= null;
	ResultSet rs1 = null;
	ResultSetMetaData rsmd = null;
	String app_id = request.getParameter("app_id");
	String event_type = request.getParameter("event_type");
	String notification_status = request.getParameter("notification_status");
	String specimen_from_date = (String)request.getParameter("specimen_from_date");
	String specimen_to_date = (String)request.getParameter("specimen_to_date");
	Statement stmt = null;
	int columnCount;
	int columnCount1;
	String columnHeader = null;
	int totalRowCount;
	String rowCountingQuery = null;
	String onlyRequiredColumnQuery = null;
	String onlyRequiredColumnCompleteQuery = null;
	int lengthOfString;
	List listColumns = new ArrayList();
	String columnsFromNotify = null;
	
	Date date = new Date();
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	Date fromDate = dateFormat.parse(specimen_from_date);
	Date toDate = dateFormat.parse(specimen_to_date);
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	String fromDateString = formatter.format(fromDate);
	String toDateString = formatter.format(toDate);
	
	Date actualFromDate =  formatter.parse(fromDateString);
	Date actualToDate =  formatter.parse(toDateString);
	
	String actualFromDateString = actualFromDate.toString();
	String actualToDateString = actualToDate.toString();

%>

<head>
<link rel='stylesheet' type='text/css' href='../../eXH/html/xhtab.css'></link>

<title>Track Notification Tabular Content</title>
</head>

<body>
 
	<div name="tableData" id="tab"
		style="width: 100%; overflow: auto; height: 350px;">

		<table onload="resubmitUser()">
			<tr align="center">
				<td align="center"> 
					<table id="tableDetails" border="1" style="width: 90%; border-style: double;">

						<%
					try {
						con = ConnectionManager.getConnection();
						String fetchSelectedColumnQuery = "Select ELEMENT_ID From XH_APPL_ELEMENT Where APPLICATION_ID = ? And IN_USE_YN = 'Y' Order By To_Number(ELE_POS)";					
						pst = con.prepareStatement(fetchSelectedColumnQuery);
						pst.setString(1, app_id);
						rs = pst.executeQuery();
						columnCount = rs.getMetaData().getColumnCount();
	
			
						while(rs.next()){ 
							for(int i = 1; i<=columnCount; i++){
								onlyRequiredColumnQuery = rs.getString(i);
								listColumns.add(onlyRequiredColumnQuery);
							} 
						}
					

					   String strArr =  listColumns.toString();
					   String s1 = strArr.replace("[", ""); 
					   onlyRequiredColumnCompleteQuery = s1.replace("]", "");
					   
				if(notification_status.equals("Failed")){
					//columnsFromNotify = "LOCATION,SPECIMEN_NO,ENCOUNTER_ID,APPOINTMENT_NO,RELEASED_DATE_TIME,TEST_NAME,NOTIFIED_TO,MOBILE_NO,SUBMISSION_STATUS,DELIVERY_STATUS,SMS_SUBMITTED_ON,LAST_RESUBMIT_DATE,LAST_RESUBMITTED_BY,FAILED_REASON";
					//String actualFailedQuery = "select " + columnsFromNotify + "," + onlyRequiredColumnCompleteQuery + " from XH_NOTIFY_EVENT_MESSAGE_VW where APPLICATION_ID = ? AND MESSAGE_DATE BETWEEN TO_DATE(?, 'DD/MM/YYYY hh24:mi') AND TO_DATE(?, 'DD/MM/YYYY hh24:mi') AND EVENT_TYPE = ? AND (SUBMISSION_STATUS IN ('Not Submitted','Failed') OR DELIVERY_STATUS IN ('Failed'))" ;
					String actualFailedQuery = "select " + onlyRequiredColumnCompleteQuery + " from XH_NOTIFY_EVENT_MESSAGE_VW where APPLICATION_ID = ? AND MESSAGE_DATE BETWEEN TO_DATE(?, 'DD/MM/YYYY hh24:mi') AND TO_DATE(?, 'DD/MM/YYYY hh24:mi') AND EVENT_TYPE = ? AND (SUBMISSION_STATUS IN ('Not Submitted','Failed') OR DELIVERY_STATUS IN ('Failed'))" ;
					pst1 = con.prepareStatement(actualFailedQuery);
					pst1.setString(1, app_id);
					pst1.setString(2, fromDateString);
					pst1.setString(3, toDateString);
					pst1.setString(4, event_type);
					rs1 = pst1.executeQuery();
					
				}
				
				if(notification_status.equals("Success")){
					//columnsFromNotify = "LOCATION,SPECIMEN_NO,ENCOUNTER_ID,APPOINTMENT_NO,RELEASED_DATE_TIME,TEST_NAME,NOTIFIED_TO,MOBILE_NO,SUBMISSION_STATUS,DELIVERY_STATUS,SMS_SUBMITTED_ON,LAST_RESUBMIT_DATE,LAST_RESUBMITTED_BY,FAILED_REASON";
					//String actualSuccessQuery = "select " + columnsFromNotify + "," + onlyRequiredColumnCompleteQuery + " from XH_NOTIFY_EVENT_MESSAGE_VW where APPLICATION_ID = ? AND SUBMISSION_STATUS IN ('Success') AND MESSAGE_DATE BETWEEN TO_DATE(?, 'DD/MM/YYYY hh24:mi') AND TO_DATE(?, 'DD/MM/YYYY hh24:mi') AND EVENT_TYPE = ?";
					String actualSuccessQuery = "select " + onlyRequiredColumnCompleteQuery + " from XH_NOTIFY_EVENT_MESSAGE_VW where APPLICATION_ID = ? AND SUBMISSION_STATUS IN ('Success') AND MESSAGE_DATE BETWEEN TO_DATE(?, 'DD/MM/YYYY hh24:mi') AND TO_DATE(?, 'DD/MM/YYYY hh24:mi') AND EVENT_TYPE = ?";
					pst1 = con.prepareStatement(actualSuccessQuery);
					pst1.setString(1, app_id);
					pst1.setString(2, fromDateString);
					pst1.setString(3, toDateString);
					pst1.setString(4, event_type);
					rs1 = pst1.executeQuery();
				}
				
				// below code is for selecting only the rows that are SUCCESS and DELIVERED
				
				/* if(notification_status.equals("Sent")){
					columnsFromNotify = "LOCATION,SPECIMEN_NO,ENCOUNTER_ID,APPOINTMENT_NO,RELEASED_DATE_TIME,TEST_NAME,NOTIFIED_TO,MOBILE_NO,SUBMISSION_STATUS,DELIVERY_STATUS,SMS_SUBMITTED_ON,LAST_RESUBMIT_DATE,LAST_RESUBMITTED_BY,FAILED_REASON";
					String actualSuccessQuery = "select " + columnsFromNotify + "," + onlyRequiredColumnCompleteQuery + " from XH_NOTIFY_EVENT_MESSAGE_VW where APPLICATION_ID = ? AND SUBMISSION_STATUS IN ('Success') AND DELIVERY_STATUS IN ('Delivered') AND MESSAGE_DATE BETWEEN TO_DATE(?, 'DD/MM/YYYY hh24:mi') AND TO_DATE(?, 'DD/MM/YYYY hh24:mi') AND EVENT_TYPE = ?"; 
					pst1 = con.prepareStatement(actualSuccessQuery);
					pst1.setString(1, app_id);
					pst1.setString(2, fromDateString);
					pst1.setString(3, toDateString);
					pst1.setString(4, event_type);
					rs1 = pst1.executeQuery();
				} */
				
				if(notification_status.equals("All")){
					//columnsFromNotify = "LOCATION,SPECIMEN_NO,ENCOUNTER_ID,APPOINTMENT_NO,RELEASED_DATE_TIME,TEST_NAME,NOTIFIED_TO,MOBILE_NO,SUBMISSION_STATUS,DELIVERY_STATUS,SMS_SUBMITTED_ON,LAST_RESUBMIT_DATE,LAST_RESUBMITTED_BY,FAILED_REASON";
					//String actualAllQuery = "select " + columnsFromNotify + "," + onlyRequiredColumnCompleteQuery + " from XH_NOTIFY_EVENT_MESSAGE_VW where APPLICATION_ID = ? AND SUBMISSION_STATUS IN ('Not Submitted','Failed','Success') AND MESSAGE_DATE BETWEEN TO_DATE(?, 'DD/MM/YYYY hh24:mi') AND TO_DATE(?, 'DD/MM/YYYY hh24:mi') AND EVENT_TYPE = ?";
					String actualAllQuery = "select " + onlyRequiredColumnCompleteQuery + " from XH_NOTIFY_EVENT_MESSAGE_VW where APPLICATION_ID = ? AND SUBMISSION_STATUS IN ('Not Submitted','Failed','Success') AND MESSAGE_DATE BETWEEN TO_DATE(?, 'DD/MM/YYYY hh24:mi') AND TO_DATE(?, 'DD/MM/YYYY hh24:mi') AND EVENT_TYPE = ?";
					pst1 = con.prepareStatement(actualAllQuery);
					pst1.setString(1, app_id);
					pst1.setString(2, fromDateString);
					pst1.setString(3, toDateString);
					pst1.setString(4, event_type);
					rs1 = pst1.executeQuery();
				}
				
				columnCount1 = rs1.getMetaData().getColumnCount();
				boolean tableDataPresent = false;
				
				System.out.println("onlyRequiredColumnCompleteQuery: "+onlyRequiredColumnCompleteQuery);


			%>

						<tr align="center" style="height: 10px;">
						
							<th class=label align="center"
								style="color: white; background-color: #898FBD; font-weight: bold;">Select
									All<input type="checkbox" name="checkAll" id="checkAll" id="checkAll"
								onclick="selectAll(this);" /></th>
							<%
							for(int i = 1; i<=columnCount1; i++){
				%>
							<th class=label align="center"
								style="color: white; background-color: #898FBD; font-weight: bold;"><%= rs1.getMetaData().getColumnName(i) %>
							</th>

							<%
							}
					
				%>
						</tr>


						<%
						while(rs1.next()){ 
							tableDataPresent = true;
							%>
							<input type="hidden" id="isTableDataPresent" value='<%=tableDataPresent %>'/>
							<%if(rs1.getString("MESSAGE_STATUS").equals("E")){%>
								<tr align="center" style="font-size: 8pt;background-color: #FAA4A4;">
							<%}else{%>
								<tr align="center" style="font-size: 8pt;">
							<%}%>
							<td align="center" style="font-size: 8pt;"><input type="checkbox" name="checkAll" id="checkAll" id="checkingBox"/></td>
							<%
						 	
							for(int i = 1; i<=columnCount1; i++){ 
								String tableData = rs1.getString(i);
								if(rs1.wasNull()){
									tableData = " ";
								}
								
							%>

							
							<td align="center" style="font-size: 8pt;">
							
								<%= tableData %>
							
							</td>

							<%	} %>
						</tr>
						<%
					}
						
					%>
					<input type="hidden" id="isTableDataPresent" value='<%=tableDataPresent %>'/>

						<% }
			catch (Exception e1) {
 		System.out.println("TrackNotificationTable.jsp Exc1 : "
 				+ e1.toString());
 		e1.printStackTrace(System.err);
 	} finally {
 		if (rs1 != null)
 			rs1.close();
 		if (pst1 != null)
 			pst1.close();
 		if (rs != null)
 			rs.close();
 		if (pst != null)
 			pst.close();
 	}
 %>

					</table>
				</td>
			</tr>
		</table>
	</div>
	<div>

		<div class="btn">
			<INPUT class=BUTTON type=button value="Export" onclick="exporting();" />
		</div>
	</div>
	
	<input type='hidden' name='app_id' id='app_id' id='app_id' value='<%= app_id%>'>
	<input type='hidden' name='event_type' id='event_type' id='event_type' value='<%= event_type%>'>
	<input type='hidden' name='notification_status' id='notification_status' id='notification_status' value='<%= notification_status%>'>
	<input type='hidden' name='specimen_from_date' id='specimen_from_date' id='specimen_from_date' value='<%= specimen_from_date%>'>
	<input type='hidden' name='specimen_to_date' id='specimen_to_date' id='specimen_to_date' value='<%= specimen_to_date%>'>
	<input type='hidden' name='onlyRequiredColumnCompleteQuery' id='onlyRequiredColumnCompleteQuery' id='onlyRequiredColumnCompleteQuery' value='<%= onlyRequiredColumnCompleteQuery%>'>

</body>
</html>

