<!DOCTYPE html>
<%@page import="java.text.SimpleDateFormat,java.text.*"%>
<%@ page
	import="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.*,eXH.XHDBAdapter,java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	String locale = ((String) session.getAttribute("LOCALE"));

	// to fetch current date and time (for specimen to date)
	Date specimen_to = new Date();
	SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(
			"dd/MM/yyyy HH:mm");
	String specimen_to_date = simpleDateFormat1.format(specimen_to);

	Date sdf1 = simpleDateFormat1.parse(specimen_to_date);

	// to fetch date and time 24 hours back (for specimen from date)	
	Date specimen_from = new Date(System.currentTimeMillis()
			- (24 * 60 * 60 * 1000));
	SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(
			"dd/MM/yyyy HH:mm");
	String specimen_from_date = simpleDateFormat2.format(specimen_from);

	Date sdf2 = simpleDateFormat1.parse(specimen_from_date);
	
	String ecis_jdbc_user = (String) session.getAttribute("login_user");
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String selected = "selected";
%>

<HEAD>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			? (String) session.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
	sStyle = "IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
	type='text/css'></link>
<link rel='stylesheet' type='text/css' href='../../eXH/html/xhtab.css'></link>
<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eXH/js/Validate.js"></script>
<script language="javascript" src="../../eXH/js/XHAjaxUtil.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="javascript" src="../../eXH/js/trackNotificationTable.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.min.js"></script>
<script language="javascript" src="../../eCA/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {  
	onChangeApplication();
});
</script>
<head>

<title>Track Notification</title>
</head>
<style>
.container .btn {
	position: absolute;
	bottom: 5px;
	right: 0px;
}
</style>
<body onload="load();">
	<form id="trackNotification" name="trackNotification" id="trackNotification">
		<div class="container">
			<div>
				<TABLE cellSpacing=0 cellPadding=0 width="100%">
					<TBODY>
						<TR class=COMMONTOOLBARFUNCTION>
							<TD class=COMMONTOOLBARFUNCTION>Track Notification</TD>
						</TR>
						<TR>
							<TD bgcolor="#E2E3F0"><INPUT onclick="myReset();" class=BUTTON type=reset value=Reset>
								<INPUT
									onclick=parent.parent.parent.frames[1].expand(this);menuHide()
									class=BUTTON type=button value=Menu>
							</TD>
						</TR>
					</TBODY>
				</TABLE>

				

			</div>
			
			<table style="width: 100%;">
				<tr>
					<td>

						<table style="width: 90%;">
							<tr style="height: 40px;">
								<td class=label>Application ID</td>
                                
								<td class=label>
									<%try {
										con = ConnectionManager.getConnection();
										String qry = "select application_id, application_name from xh_application where notifiable_yn = 'Y'";
										stmt = con.createStatement();
										rs = stmt.executeQuery(qry);%> 
										<select class='select' id='app_id' name='app_id' id='app_id' style="width: 200px;" onchange="onChangeApplication()">
										<%-- <option value="">--Select--</option> --%>
										<%while (rs.next()) {%>
											<option value='<%=rs.getString(1)%>'><%=rs.getString(1)%> - <%=rs.getString(2)%></option>
										<%}
									} catch (Exception e1) {
										System.out.println("TrackNotificationSetupAdminMain.jsp Exc1 : " + e1.toString());
										e1.printStackTrace(System.err);
									} finally {
										if (rs != null)
											rs.close();
										if (stmt != null)
											stmt.close();
									}%>
									</select>
								</td>
								
								<td class=label>Event Type</td>
								<td class=label>
								
									<select class="select" id="event_type" name="event_type" id="event_type" tabindex=1 >
										<%-- <option value = ''>--Select--</option> --%>
									</select>
								</td>
								
								<td class=label>Notification Type</td>
								<td><select name="notification_type" id="notification_type" id="notification_type"
									value="SMS" style="width: 200px;">
										<option value="">SMS</option>

								</select></td>

							</tr>
							<tr style="height: 40px;">

								<td class=label>Refresh interval</td>
								<td class=label>
									<%try {
				con = ConnectionManager.getConnection();
				String qry = "select NVL(Notification_Refresh_Interval,'') Notification_Refresh_Interval from xh_param";
				stmt = con.createStatement();
				rs = stmt.executeQuery(qry);%> <select class='select'
									name='ref_interval' id='ref_interval' id='ref_interval' style="width: 200px;">
										<!-- <option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option> -->
										<%while (rs.next()) {%>

										<option value='<%=rs.getString(1)%>'><%=rs.getString(1)%>
											mins
										</option>
										<%}%>
										<%} catch (Exception e1) {
				System.out
						.println("TrackNotificationSetupAdminMain.jsp Exc1 : "
								+ e1.toString());
				e1.printStackTrace(System.err);
			} finally {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			}%>
								
								</td>
								<td class=label>Last Refresh Date & Time</td>
								<td class=label>
									<%try {
				con = ConnectionManager.getConnection();
				String qry = "select Last_Notify_Refresh_Date_Time from xh_param";
				stmt = con.createStatement();
				rs = stmt.executeQuery(qry);
				while (rs.next()) {
					String last_ref_date_time = rs.getString(1);
					if (rs.wasNull()) {
						last_ref_date_time = " ";
					}%> <input class='select' name='last_ref_date_time' id='last_ref_date_time'
									id='last_ref_date_time' type=text
									value='<%=last_ref_date_time%>' disabled="disabled"
									style="width: 200px;"> <%}
			} catch (Exception e1) {
				System.out
						.println("TrackNotificationSetupAdminMain.jsp Exc1 : "
								+ e1.toString());
				e1.printStackTrace(System.err);
			} finally {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			}%>

								</td>
								<td class=label>Next Refresh Date & Time</td>
								<td class=label>
									<%try {
				con = ConnectionManager.getConnection();
				String qry = "select Next_Notify_Refresh_Date_Time from xh_param";
				stmt = con.createStatement();
				rs = stmt.executeQuery(qry);
				while (rs.next()) {
					String next_ref_date_time = rs.getString(1);
					if (rs.wasNull()) {
						next_ref_date_time = " ";
					}%> <input class='select' id='next_ref_date_time'
									name='next_ref_date_time' id='next_ref_date_time' type=text
									value='<%=next_ref_date_time%>' disabled="disabled"
									style="width: 200px;"> <%}
			} catch (Exception e1) {
				System.out
						.println("TrackNotificationSetupAdminMain.jsp Exc1 : "
								+ e1.toString());
				e1.printStackTrace(System.err);
			} finally {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			}%>
								</td>

							</tr>

							<tr style="height: 40px;">
								<td class=label>Notification Status</td>
								<td class=label><select class="select"
									name=notification_status id=notification_status
									style="width: 200px;">
										<option value='Failed' selected="selected">Failed</option>
										<option value='Success'>Success</option>
										<!-- <option value='Sent'>Sent</option> -->
										<option value='All'>All</option>

								</select></td>

								<td class=label>Notification From</td>

								<td class='fields'>
								 <input type="text" name="specimen_from_date" id="specimen_from_date"
           value="<%=specimen_from_date%>" size="16" maxlength="16"
           onClick="checkDateRange('specimen_from_date', 'specimen_to_date');">
    <input type="image" name="showcalndr" id="showcalndr"
           src="../../eCommon/images/CommonCalendar.gif"
           onClick="event.preventDefault(); showCalendar('specimen_from_date', null, 'hh:mm'); return false;">
								<td class=label>Notification To</td>

								<td class="fields"> <input type="text" name="specimen_to_date" id="specimen_to_date"
           value="<%=specimen_to_date%>" size="16" maxlength="16"
           onClick="checkDateRange('specimen_from_date', 'specimen_to_date');">
    <input type="image" name="showcalndr" id="showcalndr"
           src="../../eCommon/images/CommonCalendar.gif"
           onClick="event.preventDefault(); showCalendar('specimen_to_date', null, 'hh:mm'); return false;">
							</tr>
							<tr>
							
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>


								<td align="right"><INPUT class=BUTTON type=button
									id="resubmitButton" value="Re-Submit" onclick="resubmit();"> <INPUT class=BUTTON type=button
									value="Search"
									onclick="checkDateRange();"></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			
			<%try {
				con = ConnectionManager.getConnection();
				String qry = "SELECT ALLOW_NOTIFICATION_YN FROM XH_AUTHORIZED_USER WHERE LOGIN_NAME = " + "'" + ecis_jdbc_user + "'";
				stmt = con.createStatement();
				rs = stmt.executeQuery(qry);
				while(rs.next()){%> 

					<input type="hidden" id="allowedUserOrNot" name="allowedUserOrNot" id="allowedUserOrNot" value="<%= rs.getString(1) %>" >

										<%}
			}		 catch (Exception e1) {
				System.out
						.println("TrackNotificationSetupAdminMain.jsp Exc1 : "
								+ e1.toString());
				e1.printStackTrace(System.err);
			} finally {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			}%>
			
			
			
			<hr style="border: 1px solid #BED2DC;" />

			<div id="tabledata"></div>
			<div id="resubmitteddata"></div>

		</div>
	</form>
</body>

</html>

