<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<HTML>  
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.*,eXB.*,eXB.XBDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% //String locale = ((String)session.getAttribute("LOCALE"));%>
<% 
 
String event_type = "";
String event_name = "";
String sent_file_id  = "";
String sent_date   = "";
String facilityID = "";
String referrenceNo = "";
String replyFileID = "";
String replyDate = "";
String sentFileIDFieldDisp = "";

String mode = XBDBAdapter.checkNull(request.getParameter("mode"));				
String fun_id = XBDBAdapter.checkNull((String)session.getAttribute("fun_id"));  

if(mode.equals("U"))
{
	event_type=XBDBAdapter.checkNull(request.getParameter("event_type"));
	event_name=XBDBAdapter.checkNull(request.getParameter("event_name"));
	sent_file_id=XBDBAdapter.checkNull(request.getParameter("sent_file_id"));
	sent_date=XBDBAdapter.checkNull(request.getParameter("sent_date"));
	facilityID = XBDBAdapter.checkNull(request.getParameter("facilityID"));
	referrenceNo = XBDBAdapter.checkNull(request.getParameter("referrenceNo"));
	replyFileID = XBDBAdapter.checkNull(request.getParameter("replyFileID"));
	replyDate = XBDBAdapter.checkNull(request.getParameter("replyDate"));
	if(!XHUtil.isStrEmpty(replyFileID)) sentFileIDFieldDisp = "disabled";
}

Connection con = null;
Statement stmt = null;
ResultSet rs = null;
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<HEAD>
 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src='../../eXB/js/XBExportFiles.js' ></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 			  

</HEAD>
<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'  >
<form name="Mastersetup_form" id="Mastersetup_form" target='messageFrame' method='post' action='../../servlet/eXB.ExportFilesAddModifyServlet'>

<table cellspacing=0 cellpadding=3 width='100%' align=center>
<input type="hidden" name="fun_id" id="fun_id" id="fun_id" value="<%=fun_id%>">
<tr>																		   
	<td width='10%'></td>
	<td width='20%'></td>
	<td width='20%'></td>
	<td width='10%'></td>
	<td width='10%'></td>
	<td width='10%'></td>
	<td width='20%'></td>
</tr> 												 

<tr> </tr>

<tr>
	<td class=label >Event Type</td>
	<td align="left">
		<input type="hidden" name="event_type" id="event_type"  value="<%=XBDBAdapter.checkNull(event_type)%>">
		<input type="text" id="event_name"  name="event_name" id="event_name" size="35" maxlength="30" value='<%=XBDBAdapter.checkNull(event_name)%>' onBlur='searchEventType();' title='Event Type' disabled>
	</td>
	<td> </td> <td> </td>
</tr>

<tr>
<td class=label>Sent File ID</td>
	<td align="left"><INPUT TYPE="text" name="sent_file_id" id="sent_file_id" size=35 value='<%=sent_file_id%>' <%= sentFileIDFieldDisp %>> </td>
	<td></td> <td></td> 
</tr>

<tr>
<td class='label' >Sent Date</td>
	<td align="left"><INPUT TYPE="text" name="sent_date" id="sent_date" size=35 value='<%=sent_date%>' disabled> </td>
	<td></td> <td></td> 
</tr>
<td class='label'><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></td>
	<td align=left><INPUT TYPE="text" name="facilityID1" id="facilityID1" size=35 value='<%= facilityID %>' disabled></td>
	<td></td> <td></td> 
</tr> 
<td class='label'><fmt:message key="eXH.DOC_REF_NO.Label" bundle="${xh_labels}"/></td> 
	<td align="left"><INPUT TYPE="text" name="referrenceNo1" id="referrenceNo1" size=35 value='<%= referrenceNo %>' disabled></td>
	<td></td> <td></td> 
</tr> 
<td class='label'><fmt:message key="eXH.REPLY_FILE_ID.Label" bundle="${xh_labels}"/></td>
	<td align=left><INPUT TYPE="text" name="replyFileID" id="replyFileID" size=35 value='<%= replyFileID %>' disabled></td>
	<td></td> <td></td> 
</tr> 
<td class='label'><fmt:message key="eXH.REPLY_DATE.Label" bundle="${xh_labels}"/></td>
	<td align="left"><INPUT TYPE="text" name="replyDate" id="replyDate" size=35 value='<%= replyDate %>' disabled></td>
	<td></td> <td></td> 
</tr> 
<tr>
	<td width='20%'></td>
	<td width='45%'></td>
	<td width='20%'></td>
	<td width='20%'></td>
</tr>
</table> 
<%
	if(stmt != null) stmt.close();
	if(rs != null) rs.close();
	ConnectionManager.returnConnection(con);
%>

<input type=hidden name=act_mode value='<%=mode%>'>
<input type=hidden name="referrenceNo" id="referrenceNo" value='<%= referrenceNo %>'>
<input type=hidden name="facilityID" id="facilityID" value='<%= facilityID %>'>

</form>									  

</BODY> 
</HTML> 						  

