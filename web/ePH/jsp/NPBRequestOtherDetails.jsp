<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
	<head>
<% 
	try{
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
		String request_form_name = request.getParameter("request_form_name")==null?"":request.getParameter("request_form_name");
		String request_pract_name = request.getParameter("request_pract_name")==null?"":request.getParameter("request_pract_name");
		String reject_pract_name = request.getParameter("reject_pract_name")==null?"N":request.getParameter("reject_pract_name");
		String can_pract_name = request.getParameter("can_pract_name")==null?"":request.getParameter("can_pract_name");
		String ack_pract_name = request.getParameter("ack_pract_name")==null?"":request.getParameter("ack_pract_name");
		String apr_pract_name = request.getParameter("apr_pract_name")==null?"":request.getParameter("apr_pract_name");
		String request_date = request.getParameter("request_form_name")==null?"":request.getParameter("request_form_name");
		String request_date_time = request.getParameter("request_date_time")==null?"":request.getParameter("request_date_time");
		String request_can_date_time = request.getParameter("request_can_date_time")==null?"N":request.getParameter("request_can_date_time");
		String request_rej_date_time = request.getParameter("request_rej_date_time")==null?"":request.getParameter("request_rej_date_time");
		String request_aprv_date_time = request.getParameter("request_aprv_date_time")==null?"":request.getParameter("request_aprv_date_time");
		String request_ack_date_time = request.getParameter("request_ack_date_time")==null?"":request.getParameter("request_ack_date_time");
		// addedfor incidentML-BRU-SCF-0367 [IN:034747](3rd point) -start
		String request_can_reason = request.getParameter("request_can_reason")==null?"":java.net.URLDecoder.decode(request.getParameter("request_can_reason"),"UTF-8");
		String request_rej_reason = request.getParameter("request_rej_reason")==null?"":java.net.URLDecoder.decode(request.getParameter("request_rej_reason"),"UTF-8");
		String request_ack_reason = request.getParameter("request_ack_reason")==null?"":java.net.URLDecoder.decode(request.getParameter("request_ack_reason"),"UTF-8");
		String request_aprv_reason = request.getParameter("request_aprv_reason")==null?"":java.net.URLDecoder.decode(request.getParameter("request_aprv_reason"),"UTF-8");
		// addeded for incidentML-BRU-SCF-0367 [IN:034747](3rd point) -end
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<title><fmt:message key="Common.RequestDetails.label" bundle="${common_labels}"/></title>
	</head>
	<body>
		<form name='NPBRequestDetail' id='NPBRequestDetail'>
			<br>
				<table cellpadding=0 cellspacing=0 width="100%" align="center" border='1'>
					<tr>
						<th colspan='4'><%=request_form_name%></th>
					</tr>
<%
					if(!request_pract_name.equals("")){
%>
						<tr >
							<td width='10%' nowrap class='label'><fmt:message key="Common.RequestedBy.label" bundle="${common_labels}"/></td>
							<td width='25%' nowrap class='label'><%=request_pract_name%>&nbsp;</td>
							<td width='25%' nowrap class='label'><%=request_date_time%>&nbsp;</td>
							<td width='40%' wrap class='label'>&nbsp;</td> <!-- added  for incidentML-BRU-SCF-0367 [IN:034747](3rd point) -->
						</tr>
<%
					}
					if(!ack_pract_name.equals("")){
%>
						<tr >
							<td width='10%' nowrap class='label'><fmt:message key="ePH.Acknowledgedby.label" bundle="${ph_labels}"/></td>
							<td width='25%' nowrap class='label'><%=ack_pract_name%>&nbsp;</td>
							<td width='25%' nowrap class='label'><%=request_ack_date_time%>&nbsp;</td>
							<td width='40%' wrap class='label'><%=request_ack_reason%>&nbsp;</td> <!-- added  for incidentML-BRU-SCF-0367 [IN:034747](3rd point) -->
						</tr>
<%
					}
					if(!apr_pract_name.equals("")){
%>
						<tr >
							<td width='10%' nowrap class='label'><fmt:message key="Common.ApprovedBy.label" bundle="${common_labels}"/></td>
							<td width='25%' nowrap class='label'><%=apr_pract_name%>&nbsp;</td>
							<td width='25%' nowrap class='label'><%=request_aprv_date_time%>&nbsp;</td>
							<td width='40%' wrap class='label'><%=request_aprv_reason%>&nbsp;</td> <!-- added  for incidentML-BRU-SCF-0367 [IN:034747](3rd point) -->
						</tr>
<%
					}
					if(!can_pract_name.equals("")){
%>
						<tr >
							<td width='10%' nowrap class='label'><fmt:message key="Common.cancelledby.label" bundle="${common_labels}"/></td>
							<td width='25%' nowrap class='label'><%=can_pract_name%>&nbsp;</td>
							<td width='25%' nowrap class='label'><%=request_can_date_time%>&nbsp;</td>
							<td width='40%' wrap class='label'><%=request_can_reason%>&nbsp;</td> <!-- added  for incidentML-BRU-SCF-0367 [IN:034747](3rd point) -->
						</tr>
<%
					}
					if(!reject_pract_name.equals("")){
%>
						<tr >
							<td width='10%' nowrap class='label'> <fmt:message key="ePH.Rejectedby.label" bundle="${ph_labels}"/></td>
							<td width='25%' nowrap class='label'><%=reject_pract_name%>&nbsp;</td>
							<td width='25%' nowrap class='label'><%=request_rej_date_time%>&nbsp;</td>
							<td width='40%' wrap class='label'><%=request_rej_reason%>&nbsp;</td> <!-- added  for incidentML-BRU-SCF-0367 [IN:034747](3rd point) -->
						</tr>
<%
					}
%>
				</table>
		</form>
	</body>
<%
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
</html> 

