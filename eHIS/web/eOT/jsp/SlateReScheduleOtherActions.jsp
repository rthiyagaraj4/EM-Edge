<!DOCTYPE html>
<%//@page contentType="text/html;charset=" import="java.util.*, eOT.*, eOT.Common.*, eCommon.Common.*" %>
<%@page  import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<html>
<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="Javascript" src="../../eOT/js/SlateReSchedule.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<!-- <script src="../../eCommon/js/messages.js" language="javascript"></script>
	<script src="../../eOT/js/OTMessages.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<%

	java.util.Properties prop = null;
	prop	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String login_user				= prop.getProperty( "login_user" );
	String client_ip_address		= prop.getProperty( "client_ip_address" );
	String facility_id  = (String) session.getValue("facility_id");
	String sql_curr_date="SELECT TO_CHAR(SYSDATE+1,'DD/MM/YYYY') CURRENT_DATE FROM DUAL";
	Connection connection   = null ;
	Statement stmt = null ;
	ResultSet resultSet     = null ;
	String date		= "";
		try{
			connection			= ConnectionManager.getConnection(request);
			stmt				= connection.createStatement() ;
			resultSet			= stmt.executeQuery(sql_curr_date);
			while(resultSet!=null && resultSet.next()){
				date = resultSet.getString("CURRENT_DATE");
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
				if(resultSet!=null) resultSet.close();
				if(stmt!=null) stmt.close();
				if(connection!=null) ConnectionManager.returnConnection(connection,request);
               }catch(Exception es){es.printStackTrace();}
        }
%>

<form name="SlateRescheduleForm" id="SlateRescheduleForm" >
<table cellpadding="3" cellspacing="0" width="100%" align="center" border="0">
	<tr>
		<td class="CAGROUPHEADING" width="25%" nowrap><fmt:message key="eOT.OtherActions.Label" bundle="${ot_labels}"/></td>
	</tr>
</table>
<table cellpadding="3" cellspacing="0" width="100%" align="center" border="0">
	<tr>
		<td class='label' width="25%"><fmt:message key="Common.action.label" bundle="${common_labels}"/></td>
		<td class='fields' width="25%"><select name="action_val" id="action_val" >
			<option value="W" selected><fmt:message key="eOT.WaitlistSelectedPatients.Label" bundle="${ot_labels}"/></option>
			<option value="T"><fmt:message key="eOT.TransferSelectedPatients.Label" bundle="${ot_labels}"/></option>
			</select>
		</td>
	</tr>
	<tr>
		<td class='label' width="25%"><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
		<td  class='fields' width="25%">
			<input type="text" name="reschedule_date" id="reschedule_date" size="10" maxlength=10 value="<%=date%>" disabled>
			<image src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('reschedule_date');">
		</td>
		<td class='fields' width="25%">
		<input type="button" class='button' name="apply" id="apply" value='<fmt:message key="Common.apply.label" bundle="${common_labels}"/>' onclick="applyReschedule();">
		</td>

	</tr>
</table>
		<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
		<input type="hidden" name="login_user" id="login_user" value="<%=login_user%>">
		<input type="hidden" name="client_ip_address" id="client_ip_address" value="<%=client_ip_address%>"> 
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>

