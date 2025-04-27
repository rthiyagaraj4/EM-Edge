<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eXH.XHUtil,java.sql.Statement,java.sql.ResultSet,java.sql.Connection,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter" %>
<%
	String jobWhatStr = (String)request.getAttribute("jobWhatStr");
	String jobSearchQry = "SELECT job, to_char(last_date,'dd/mm/yyyy HH24:MI:SS') last_date, to_char(next_date,'dd/mm/yyyy HH24:MI:SS') next_date, what, DECODE(NVL(failures,0),0,'Submitted','Failed') prev_status, this_date FROM dba_jobs WHERE what LIKE '"+jobWhatStr+"%'";

	Connection dbConn	= null;
	Statement statement	= null;	
	ResultSet jobRS		= null;
	int tempCount = 0;

	try
	{
		if(dbConn == null) dbConn = ConnectionManager.getConnection();
		statement = dbConn.createStatement();
		jobRS = statement.executeQuery(jobSearchQry);

		while(jobRS.next())
		{
%> 
		<table width='100%'>
<%		if(tempCount == 0) { %>
			<META HTTP-EQUIV="REFRESH" CONTENT="10">
			<tr>
				<td colspan="4" align="right">
					<a href="#" onClick="reloadPage()"><FONT class="HYPERLINK"><fmt:message key="Common.Refresh.label" bundle="${common_labels}"/></FONT></a>
				</td>
			</tr>
			<tr>
				<td class='COLUMNHEADER'><fmt:message key="Common.Process.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER'><fmt:message key="Common.LastExecution.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER'><fmt:message key="Common.NextExecution.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
			</tr>
<%
	tempCount++;
}%>
			<tr>
				<td><%= XHDBAdapter.checkNull(jobRS.getString("job")) %>-<%= XHDBAdapter.checkNull(jobRS.getString("what")) %></td>
				<td><%= XHDBAdapter.checkNull(jobRS.getString("last_date")) %></td>
				<td><%= XHDBAdapter.checkNull(jobRS.getString("next_date")) %></td>
				<td><%= (jobRS.getString("this_date") == null || jobRS.getString("this_date").equals(""))?jobRS.getString("prev_status"):"Running" %></td>
			</tr>
		</table>
<%
		}
	}
	catch(Exception exp)
	{
		System.out.println("(dispJobs:jobSearchQry) "+jobSearchQry);
		exp.printStackTrace(System.err);
	}
	finally
	{
		try
		{
			if(jobRS != null) jobRS.close();
			if(statement != null) statement.close();
			if(dbConn != null) ConnectionManager.returnConnection(dbConn);
		}
		catch(Exception fexp)
		{
			fexp.printStackTrace(System.err);
		}
	}
%>
