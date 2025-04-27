<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="eXH.XHDBAdapter, eXH.XHQueryRender, webbeans.eCommon.ConnectionManager,eXH.XHUtil,eXH.InterfaceUtil,eXH.QueueManager" %>
<%@ page import="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8"); 
String locale = ((String)session.getAttribute("LOCALE"));
String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>	

<head>
<LINK REL='stylesheet' HREF='../../eCommon/html/<%=sStyle%>'></LINK>
<LINK REL='stylesheet' HREF='../../eXH/html/menu.css' TYPE='text/css'></LINK>

<SCRIPT LANGUAGE='javascript' SRC='../../eCommon/js/common.js'></SCRIPT>
<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonCalendar.js"></SCRIPT>
<SCRIPT SRC="../../eCommon/js/ValidateControl.js" LANGUAGE="javascript"></SCRIPT>
<SCRIPT LANGUAGE="javascript" SRC="../../eXH/js/ManageQueue.js"></SCRIPT>
<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/jquery-3.6.3.js"></SCRIPT>
<SCRIPT LANGUAGE='javascript' SRC='../../eXH/js/menu.js'></SCRIPT>
<SCRIPT LANGUAGE='javascript'>

function funAction(typ)
{
	parent.queueResultFrame.queueDispResult.action_type.value = typ;
	funSubmit();
}

function funSubmit()
{
	parent.queueResultFrame.queueDispResult.action = '../../eXH/jsp/QueueCriteriaResults.jsp';
	parent.queueResultFrame.queueDispResult.target = "queueResultFrame";
	parent.queueResultFrame.queueDispResult.submit();
}

</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY onKeyDown ='lockKey()' onMouseDown='CodeArrest()' onLoad='initFunc()'>
<FORM name="queueDispResult" id="queueDispResult" METHOD="POST">
<%
int recordCount = 0;
boolean boolToggle = true;
boolean boolNext = false; 
boolean boolPrevious = false;
String action_type = null;
String maxRecords = "10";
String strTDClass = "";
String strPrevious = null;
String strNext = null;
Connection dbConn = null;
HashMap resultsQry = null;
ArrayList arrRow = null;
ArrayList<String> arrCol = null;

try
{
	Properties prop = (Properties)session.getValue("jdbc");
	String loginID = prop.getProperty("login_user");	
	String patientID = request.getParameter("patientID");
	String encounterID = request.getParameter("encounterID");
	String facilityID = request.getParameter("facilityID");
	String serviceNo = request.getParameter("serviceNo");
	action_type = XHDBAdapter.checkNull(request.getParameter("action_type"));	
	String ticketNo = XHDBAdapter.checkNull(request.getParameter("ticketNo"));
	String qry = "SELECT patient_id, encounter_id,facility_id, queue_num, loc_status, room_no, practitioner_id, service_no FROM xq_queue_simulate_trans";
	String[] tempColNames = {"patient_id", "facility_id", "queue_num", "encounter_id", "service_no"};
	String[] tempColVal = {patientID, facilityID, ticketNo, encounterID, serviceNo};
	String whrClause = InterfaceUtil.buildWhrClause(tempColNames,tempColVal);
	qry += whrClause;

	dbConn = ConnectionManager.getConnection(request);

	request.setAttribute(XHQueryRender.strQueryId, "MANAGE_PATIENT_QUEUE");
	request.setAttribute("query", qry);
	request.setAttribute(XHQueryRender.col,8);
	request.setAttribute(XHQueryRender.maxRec, maxRecords);

	resultsQry = XHQueryRender.getResults(request, session, dbConn);
	arrRow = (ArrayList)resultsQry.get("qry_result");	
	recordCount = arrRow.size();

	boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
	strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");

	if (boolPrevious == true)
	{
		strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	}
	else
	{
		strPrevious = " ";
	}
	if (boolNext== true)
	{
		strNext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
	}
	else
	{
		strNext  = " ";
	}
 	
	if(arrRow.size() == 0)
	{
%>	

<script>	
	alert(getMessage('XH1021','XH'));	
</script>

<%
	}
	else
	{
%>

<table cellspacing="0" cellpadding="3" width="100%" align="center">
<TR>
	<%
		int countRec = 0;
		PreparedStatement roomNoPSTMT = null;
		ResultSet roomNoRS = null;
		String roomNoQry = "SELECT DISTINCT room_no,room_no desc1 FROM xq_queue_simulate_trans";
		roomNoPSTMT = dbConn.prepareStatement(roomNoQry,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		roomNoRS = roomNoPSTMT.executeQuery();
	%>
	<TD CLASS="label">Counter</TD>
	<TD CLASS="fields">
		<SELECT name="roomNo" id="roomNo" ID="roomNo" style="width: 150px">
			<OPTION VALUE=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</OPTION>
	<%
	try
	{
		if(roomNoRS != null)
		{
			roomNoRS.last();
			countRec = roomNoRS.getRow();
			roomNoRS.beforeFirst();
		}
		if(countRec == 1)
		{
			roomNoRS.next();
	%>
			<OPTION VALUE='<%=roomNoRS.getString(1)%>' SELECTED><%=roomNoRS.getString(2)%></OPTION>
	<%
		}
		else if(countRec >= 1)
		{
			while(roomNoRS != null && roomNoRS.next())
			{
	%>
			<OPTION VALUE='<%=roomNoRS.getString(1)%>'><%=roomNoRS.getString(2)%></OPTION>
	<%
			}
		}
	}
	catch(Exception exp)
	{
		exp.printStackTrace(System.err);
	}
	finally
	{
		if(roomNoRS != null) roomNoRS.close();
		if(roomNoPSTMT != null) roomNoPSTMT.close();
	}
	%>
		</SELECT>&nbsp;
		<INPUT TYPE="button" onClick="callNext()" VALUE="Call Next Patient">
	</TD>
</TR>
<TR>
	<td align="right" class="CAGROUP">&nbsp;</td>
	<td align="right" class="CAGROUP"> 
		<A class='label' style='cursor:pointer' onClick="funAction('P')"><%= strPrevious %></A>
		<A class='label' onClick="funAction('N')" style='cursor:pointer'><%= strNext %></A>
	</td>
</tr>
</table>

<TABLE id="table1" cellspacing=0 cellpadding=3 border=1 width="100%">	
	<tr>
		<td class='COLUMNHEADER'>
			PatientID
		</td>
		<td class='COLUMNHEADER'>
			Counter
		</td>
		<td class='COLUMNHEADER'>
			Service
		</td>
		<td class='COLUMNHEADER'>
			Queue No
		</td>
		<td class='COLUMNHEADER'>
			PractitionerID
		</td>
	</tr>
<%
		for (int j = 0; j < arrRow.size(); j++)
		{
			arrCol = (ArrayList<String>)arrRow.get(j);
			if (boolToggle == true)
			{
				strTDClass = "class='QRYEVEN'";
				boolToggle =  false;
			}
			else
			{
				strTDClass = "class='QRYODD'";
				boolToggle =  true;
			}
%>
	<tr>
		<td <%=strTDClass%> onMouseOver="this.style.cursor='hand'" onMouseDown="buildMenu('<%= XHDBAdapter.checkNull(arrCol.get(0)) %>',
																						'<%= XHDBAdapter.checkNull(arrCol.get(1)) %>',
																						'<%= XHDBAdapter.checkNull(arrCol.get(2)) %>',
																						'<%= XHDBAdapter.checkNull(arrCol.get(3)) %>',
																						'<%= XHDBAdapter.checkNull(arrCol.get(4)) %>',
																						'<%= XHDBAdapter.checkNull(arrCol.get(5)) %>',
																						'<%= XHDBAdapter.checkNull(arrCol.get(6)) %>',
																						'<%= XHDBAdapter.checkNull(arrCol.get(7)) %>');">
			<%=XHDBAdapter.checkNull(arrCol.get(0))%>&nbsp;
		</td>
		<td <%=strTDClass%>>			
			<%=XHDBAdapter.checkNull(arrCol.get(5))%>&nbsp;
		</td>
		<td <%=strTDClass%>>
			<%=XHDBAdapter.checkNull(arrCol.get(7))%>&nbsp;
		</td>
		<td <%=strTDClass%>>
			<%=XHDBAdapter.checkNull(arrCol.get(3))%>&nbsp;
		</td>
		<td <%=strTDClass%>>
			<%=XHDBAdapter.checkNull(arrCol.get(6))%>&nbsp;
		</td>
	</tr>
	
<%
		}
%>
</TABLE>	
	<%
	}	
	if(arrRow != null) arrRow.clear();
	if(resultsQry != null) resultsQry.clear();
}
catch(Exception e1)
{	
	e1.printStackTrace(System.err);	
}
finally
{
	ConnectionManager.returnConnection(dbConn);
}
%>
<INPUT TYPE='hidden' name='action_type' id='action_type' VALUE='<%= action_type %>'>
<INPUT TYPE='hidden' name="siteID" id="siteID" ID="siteID" VALUE='<%= QueueManager.BRUNEI_SITE_ID %>'>
<INPUT TYPE='hidden' name='facilityID' id='facilityID' ID="facilityID" VALUE='<%= (String)session.getAttribute("facility_id") %>'>
</FORM>
</HTML>

