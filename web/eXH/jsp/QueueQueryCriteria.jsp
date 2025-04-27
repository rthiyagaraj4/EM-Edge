<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.util.*,eXH.XHDBAdapter,eXH.QueueManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<HEAD>						  
<% 
	request.setCharacterEncoding("UTF-8");	
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";	
	Connection dbConn = null;
%>
 
<LINK REL='StyleSheet' HREF='../../eCommon/html/<%=sStyle%>'></LINK> 

<SCRIPT LANGUAGE='javascript' SRC='../../eCommon/js/common.js'></SCRIPT>
<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonCalendar.js"></SCRIPT>
<SCRIPT SRC="../../eCommon/js/ValidateControl.js" LANGUAGE="javascript"></SCRIPT>
<SCRIPT LANGUAGE="javascript" SRC="../../eXH/js/ManageQueue.js"></SCRIPT>
<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/jquery-3.6.3.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad="initFunc()">
<FORM name="queueCriteria" id="queueCriteria" ID="queueCriteria" METHOD="post" TARGET="queueResultFrame" ACTION="../../servlet/eXH.ManagePatientQueue">
<%
	try
	{
		dbConn = ConnectionManager.getConnection(request);
		String patientID = XHDBAdapter.checkNull(request.getParameter("patientID"));
		String encounterID = XHDBAdapter.checkNull(request.getParameter("encounterID"));
		String facilityID = XHDBAdapter.checkNull(request.getParameter("facilityID"));
		String ticketNo = XHDBAdapter.checkNull(request.getParameter("ticketNo"));
		String roomNo = XHDBAdapter.checkNull(request.getParameter("roomNo"));
		String practitionerID = XHDBAdapter.checkNull(request.getParameter("practitionerID"));
		String serviceNo = XHDBAdapter.checkNull(request.getParameter("serviceNo"));
		String selected = "";
		String siteID = request.getParameter("siteID");
%>
<TABLE ALIGN="CENTER">
<TR>
	<TD CLASS="label">PatientID</TD>
	<TD CLASS="fields">
		<INPUT TYPE="text" name="patientID" id="patientID" ID="patientID" VALUE=<%= patientID %>>		
	</TD>
	<TD CLASS="label">Queue No</TD>
	<TD CLASS="fields">
		<INPUT TYPE="text" name="ticketNo" id="ticketNo" ID="ticketNo" VALUE=<%= ticketNo %>>		
	</TD>
<!-- 	<TD CLASS="label">Work Station</TD>
	<TD CLASS="fields">
		<INPUT TYPE="text" name="workStation" id="workStation" ID="workStation" VALUE="">		
	</TD> -->
<%
if(QueueManager.BRUNEI_SITE_ID.equals(siteID))
{
%>
	<TD CLASS="label">Counter</TD>
	<TD CLASS="fields">
		<INPUT TYPE="text" name="roomNo" id="roomNo" ID="roomNo" VALUE=<%= roomNo %>>
	</TD>
	<TD CLASS="label">Service No</TD>
	<TD CLASS="fields">
		<INPUT TYPE="text" name="serviceNo" id="serviceNo" ID="serviceNo" VALUE=<%= serviceNo %>>
	</TD>
	<TD CLASS="label">Practitioner ID</TD>
	<TD CLASS="fields">
		<INPUT TYPE="text" name="practitionerID" id="practitionerID" ID="practitionerID" VALUE=<%= practitionerID %>>
	</TD>
<%
}
else
{
%>
	<TD CLASS="label">Workstation</TD>
	<TD CLASS="fields">
		<INPUT TYPE="text" name="workStation" id="workStation" ID="workStation" VALUE="">
	</TD>
	<TD CLASS="label">Workflow</TD>
	<TD CLASS="fields">
		<INPUT TYPE="text" name="workflow" id="workflow" ID="workflow" VALUE="">
	</TD>
	<TD CLASS="label">Username</TD>
	<TD CLASS="fields">
		<INPUT TYPE="text" name="userName" id="userName" ID="userName" VALUE="">
	</TD>
	</TR>
	<TR>
	<TD CLASS="label">Scheduled Time</TD>
	<TD CLASS="fields">
		<INPUT TYPE="text" name="sheduledTime" id="sheduledTime" ID="sheduledTime" VALUE="">
	</TD>
	<TD CLASS="label">Next Station</TD>
	<TD CLASS="fields">
		<INPUT TYPE="text" name="nextStation" id="nextStation" ID="nextStation" VALUE="">
	</TD>
<%
}
%>
</TR>
</TABLE>
<TABLE ALIGN="right">
<TR>
	<TD CLASS="button">
		<INPUT TYPE="button" onClick="clearFrames(this)" VALUE="Save">
		<INPUT TYPE="button" onClick="clearFrames(this)" VALUE="Search">
	</TD>
</TR>
</TABLE>
<INPUT TYPE="hidden" ID="actionType" name="actionType" id="actionType" value="">
<INPUT TYPE="hidden" ID="siteID" name="siteID" id="siteID" value="<%= siteID %>">
<%
	}
	catch(Exception exp)
	{
		exp.printStackTrace(System.err);
	}
	finally
	{
		ConnectionManager.returnConnection(dbConn);
	}
%>
</FORM>
</BODY>
</HTML>

