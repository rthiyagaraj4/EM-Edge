<!DOCTYPE html>
<HTML>
<%@ page import="java.sql.*,webbeans.eCommon.ConnectionManager,java.util.*" %> 
<%@ page contentType="text/html;charset=UTF-8" %>


<HEAD>

<%
request.setCharacterEncoding("UTF-8");
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' href='../../eXH/html/menu.css' type='text/css'></link>

<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eXH/js/ViewDebugInformation.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<BODY onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>

<%
try
{
Connection dbConn = null;
Statement pgmStmt = null;
ResultSet pgmRS = null;
Statement clientStmt = null;
ResultSet clientRS = null;

String queryPGM = "SELECT pgmid FROM sy_pgm_events_ctl ORDER BY pgmid";
String queryClient = "SELECT DISTINCT machineid FROM sy_pgm_events_ctl ORDER BY machineid";

ArrayList pgmList = null;
ArrayList clientList = null;

try
{
	dbConn = ConnectionManager.getConnection();
	pgmStmt = dbConn.createStatement();
	pgmRS = pgmStmt.executeQuery(queryPGM);

	if(pgmRS.next())
	{
		pgmList = new ArrayList();
		pgmList.add(pgmRS.getString("pgmid"));
	}
	while(pgmRS.next())
	{
		pgmList.add(pgmRS.getString("pgmid"));
	}

	clientStmt = dbConn.createStatement();
	clientRS = clientStmt.executeQuery(queryClient);

	if(clientRS.next())
	{
		clientList = new ArrayList();
		clientList.add(clientRS.getString("machineid"));
	}
	while(clientRS.next())
	{
		clientList.add(clientRS.getString("machineid"));
	}
}
catch(Exception exp)
{
	exp.printStackTrace(System.err);
}
finally
{
	try
	{
		if(pgmRS != null) pgmRS.close();
		if(clientRS != null) clientRS.close();
		if(pgmStmt != null) pgmStmt.close();
		if(clientStmt != null) clientStmt.close();
		if(dbConn != null) ConnectionManager.returnConnection(dbConn);
	}
	catch(Exception fexp)
	{
		fexp.printStackTrace(System.err);
	}
}
%>
<FORM name='queryCriteriaForm' id='queryCriteriaForm' target='queryResultsFrame' action='../../eXH/jsp/viewDebugInfo.jsp'>
<TABLE width='100%' cellspacing=0>
<tr>

<td class='label' colspan="1">From</td>
<td class='fields' colspan="1">
	<input type='text' name='fromDate' id='fromDate' id='fromDate' value=''>
	<input type='image' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('fromDate','dd/mm/y');" >
</td>

<td class='label' colspan="1">To</td>
<td class='fields' colspan="1">
	<input type='text' name='toDate' id='toDate' id='toDate' value=''>
	<input type='image' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('toDate','dd/mm/y');" >
</td>

<td>&nbsp;</td><td>&nbsp;</td>

</tr>
<tr>

<td class='label' colspan="1">PGM ID</td>
<td class='fields' colspan="1">
	<select name='pgmID' id='pgmID' id='pgmID' multiple>
		<option value='' selected>All</option>
	<%
		if(pgmList != null)
		{
			for(int i=0;i<pgmList.size();i++)
			{
	%>
		<option value='<%=pgmList.get(i)%>'><%=pgmList.get(i)%></option>
	<%		}
		}
	%>
	</select>
</td>

<td class='label' colspan="1">Client</td>
<td class='fields' colspan="1">
	<select name='clientID' id='clientID' id='clientID' multiple>		
	<%
		if(clientList != null)
		{
			for(int i=0;i<clientList.size();i++)
			{
	%>
		<option value='<%=clientList.get(i)%>' <%=(i==0)?"selected":""%>><%=clientList.get(i)%></option>
	<%		}
		}
	%>
	</select>
</td>

<td class='label' colspan="1">Mode</td>
<td class='fields' colspan="1">
	<select name='mode' id='mode' ID='mode'>		
		<option value='display'>Display Result</option>
		<option value='excel'>Write to Excel</option>
	</select>
</td>

</TR>
<TR ALIGN='right'>
	<TD ALIGN="right" COLSPAN="6">		
		<INPUT TYPE='button' CLASS='BUTTON' VALUE='Search' onClick="refreshFrames();searchRecords();">
	</TD>
</TR>
</TABLE>
</FORM>
<%
}
catch(Exception exp)
{
	exp.printStackTrace(System.err);
}
%>
</BODY>

</HEAD>
</HTML>

