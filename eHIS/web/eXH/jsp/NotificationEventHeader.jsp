<!DOCTYPE html>
<%@ page import="java.util.*,com.ehis.util.*"%>
<%@ page import="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=10">
<title>Sample Select Menues</title>
<meta charset="utf-8">
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "")
			? (String) session.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
%>
<link rel="StyleSheet" href="../../eCommon/html/<%=sStyle%>" type="text/css" />
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eXH/js/NotificationEventSetup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
%>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="breakFun()">
	<form name="Notifyform" id="Notifyform" method="post"  target="messageFrame">
		<table cellspacing=0 cellpadding=3 width='98%' align=center>
			<!-- <tr>
				<td width='20%'></td>
				<td width='25%'></td>
				<td width='20%'></td>
				<td width='25%'></td>
				<td width='10%'></td>
			</tr> -->
			<tr>
			
				<td class=label align="left"><fmt:message key="eXH.ApplicationID.Label" bundle="${xh_labels}"/>
					<select class='select' id="appSelectId" name='appSelect' id='appSelect'>
						<option value = ''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						<%
							try{
								con = ConnectionManager.getConnection();
								String query = "select application_id,application_id||' - '||application_name from xh_application  where notifiable_yn = 'Y'";
								stmt = con.createStatement();
								rs = stmt.executeQuery(query);
								
								while(rs.next()){
									%>
									<option value='<%= rs.getString(1) %>'><%= rs.getString(2) %></option>
									<%
								}
							} catch(Exception e){
								System.out.println(e.getMessage());
							} finally {
								if(rs!=null) rs.close();
								if(stmt!=null) stmt.close();
							}
						%>
					</select><img src='../../eCommon/images/mandatory.gif' align='center' id='encType_img'></img></td>
					
			<%-- <td class=label><fmt:message key="eXH.NotificationEventType.Label" bundle="${xh_labels}"/></td>
				<td class=fields>
				 	<select class="select" id="notifyEventId" name="notifyEvent" id="notifyEvent" tabindex=1>
					<option value = ''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					</select><img src='../../eCommon/images/mandatory.gif' align='center' id='encType_img'></img></td>
				<td> --%>
				<td class="label" align="right">
					<input type="button" value="Search"  class="BUTTON" onclick="searchNotificationDetails()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>

