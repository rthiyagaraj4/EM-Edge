<!DOCTYPE html>
<HTML>

<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
request.setCharacterEncoding("UTF-8");
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<HEAD> 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
</HEAD>

<%

Connection dbConn = null;
Statement stmt = null;
ResultSet rs = null;

String applicationID = XHDBAdapter.checkNull(request.getParameter("applicationID"));
String protocolMode	 = XHDBAdapter.checkNull(request.getParameter("protocolMode"));
String facilityID = XHDBAdapter.checkNull(request.getParameter("facilityID"));
String sub_module = XHDBAdapter.checkNull(request.getParameter("sub_module"));
String msgID = XHDBAdapter.checkNull(request.getParameter("msgID"));
String srlNo = XHDBAdapter.checkNull(request.getParameter("srlNo"));
String protocol_link_id = XHDBAdapter.checkNull(request.getParameter("protocol_link_id"));
String purge_status = XHDBAdapter.checkNull(request.getParameter("purge_status"));
String messageText = "";
String errMsg = "";
String statusTxt = "";
String sqlQuery = "";
String inboundAckMsg = "";
String eventTableName = "XH_EVENT";

try
{	
	if(purge_status != null && !(purge_status.trim()).equalsIgnoreCase(""))
	{		
		purge_status = "_" + purge_status;

		if(purge_status.equalsIgnoreCase("_PURGE")) eventTableName = sub_module + purge_status + "_events";
		else eventTableName = sub_module+purge_status + "_event";
	}
	else
	{
		eventTableName = sub_module + "_event";
	}
	if(protocolMode.equalsIgnoreCase("I"))
	{
		sqlQuery = "SELECT inbound_message_text,err_msg,message_ack_text FROM "+sub_module+purge_status+"_inbound_message "+
						" WHERE application_id='"+applicationID+"'"+
						" AND facility_id='"+facilityID+"'"+
						" AND message_id='"+msgID+"'"+
						" AND srl_no='"+srlNo+"'";
	}
	else
	{
		sqlQuery = "SELECT X.message_text message_text,X.status_text status_text,Y.err_msg err_msg FROM "+sub_module+purge_status+"_application_message X,"+eventTableName+" Y "+
						"WHERE X.application_id='"+applicationID+"'"+
						" AND X.application_id=Y.application_id"+
						" AND X.facility_id='"+facilityID+"'"+
						" AND X.facility_id=Y.facility_id"+
						" AND X.message_id='"+msgID+"'"+
						" AND X.message_id=Y.message_id";
	}

	//System.out.println("(EventsException:Query) "+sqlQuery);

	dbConn = ConnectionManager.getConnection();
	stmt = dbConn.createStatement();
	rs = stmt.executeQuery(sqlQuery);

	if(rs.next())
	{
		if(protocolMode.equalsIgnoreCase("I"))
		{
			messageText = rs.getString("inbound_message_text");
			inboundAckMsg = rs.getString("message_ack_text");
			errMsg = rs.getString("err_msg");			
		}
		else
		{
			messageText = rs.getString("message_text");
			errMsg = rs.getString("err_msg");
			statusTxt = rs.getString("status_text");
		}
	}

}
catch(Exception exp)
{
	exp.printStackTrace();
}
finally
{
	try
	{
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(dbConn != null) ConnectionManager.returnConnection(dbConn);
	}
	catch(Exception exp)
	{
		exp.printStackTrace(System.err);
	}
}

%>

<script language="javascript" src="../../eCommon/js/CommonCalendar.js" ></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eXH/js/ViewServerProcessErrors.js'></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>




<BODY onMouseDown="CodeArrest()" onKeyDown='lockKey()'>

<table cellspacing=0 cellpadding=3 width="100%">
<tr><td class='COLUMNHEADER' colspan="8"></td></tr>
<tr><td colspan="8">&nbsp;</td></tr>
<tr align="center">

<td class=label><fmt:message key="Common.Application.label" bundle="${common_labels}"/>: <B><%=applicationID%></B></td>
<td class=label><fmt:message key="Common.facility.label" bundle="${common_labels}"/>: <B><%=facilityID%></B></td>
<%if(protocolMode.equalsIgnoreCase("I")){%>
<td class=label><fmt:message key="Common.Message.label" bundle="${common_labels}"/>/SNo: <B><%=msgID%>/<%=srlNo%></B></td>
<%}else{%>
<td class=label><fmt:message key="Common.Message.label" bundle="${common_labels}"/>: <B><%=msgID%></B></td>
<%}%>
<td class=label>Gateway ID: <B><%=protocol_link_id%></B></td>
</tr>
<tr><td colspan="8" class='COLUMNHEADER'></td></tr>
<tr><td colspan="8">&nbsp;</td></tr>
</table>

<table cellspacing=0 cellpadding=3 width="100%" align="center">

<tr>
	<td class=label><fmt:message key="Common.Message.label" bundle="${common_labels}"/></td>
</tr>

<tr>
	<td class='fields'><TEXTAREA NAME="" ROWS="8" COLS="130"><%= XHDBAdapter.checkNull(messageText) %></TEXTAREA></td>
</tr>

<% if(protocolMode.equalsIgnoreCase("I")){ %>
<tr>
	<td class=label>Acknowledgement</td>
</tr>
<tr>
	<td class='fields'><TEXTAREA NAME="" ROWS="2" COLS="130"><%= XHDBAdapter.checkNull(inboundAckMsg) %></TEXTAREA></td>
</tr>
<%}%>
<% if(protocolMode.equalsIgnoreCase("O")){ %>
<tr>
	<td class=label>Negative Acknowledgement</td>
</tr>
<tr>
	<td class='fields' width="80%"><TEXTAREA NAME="" ROWS="2" COLS="130"><%= XHDBAdapter.checkNull(statusTxt) %></TEXTAREA></td>
</tr>
<%}%>

<tr>
	<td class=label><fmt:message key="eXH.Exceptions.Label" bundle="${xh_labels}"/></td>
</tr>
<tr>
	<td class='fields'><TEXTAREA NAME="" ROWS="2" COLS="130"><%= XHDBAdapter.checkNull(errMsg) %></TEXTAREA></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr><td class='COLUMNHEADER'></td></tr>

</table>

</BODY>
</HTML>

