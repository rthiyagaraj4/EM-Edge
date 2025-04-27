<!-- 
CRF Reference No: ML-MMOH-CRF-2069
Detected Release: Sep24
File Prepared by: Ajay Hatwate
File Prepared on: 11/07/2024
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@	page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" %>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
	<title><fmt:message key="Common.AuditTrail.label" bundle="${common_labels}"/></title>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<style type="text/css">

	
	TD.gridData1
	{
		background-color: #FFFFFF;
		height:18px;
		font-family: Verdana, Arial, Helvetica, sans-serif;
		font-size: 8pt;
		color: #000000;
		font-weight:normal;
		text-align:center;
		padding-left:10px;
		padding-right:10px;
		vertical-align:middle;
		border-bottom:1px;
		border-top:0px;
		border-left:0px;
		border-right:0px;
		border-style:solid;
		border-color:#EEEEEE;
	}
	</style>

</head>


<%
Connection conn=null;
PreparedStatement pstmt=null;
ResultSet rs=null;
String locale						=	((String)session.getAttribute("LOCALE"));
String patient_id					=	checkForNull(request.getParameter("patient_id"));
String encounter_id					=	checkForNull(request.getParameter("encounter_id"));
String datetime						=	"";
String userId						=	"";
String queue_status						=	"";
String queue_no						=	"";
try{
	conn = ConnectionManager.getConnection(request);

%>

<form name="ViewAuditTrailForm" id="ViewAuditTrailForm">
<table border='0' cellspacing="0"  width='100%'>
<tr>
<td class='PANELTOOLBAR' colspan='2' align='center'><fmt:message key="Common.AuditTrail.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.QueueNo.label" bundle="${common_labels}"/></td>

</tr>
</table>
<table border='0' cellspacing="0" width='100%'>
<tr>
<th width='16%'><fmt:message key="Common.QueueNo.label" bundle="${common_labels}"/></th>
<th width='16%'><fmt:message key="Common.action.label" bundle="${common_labels}"/></th>
<th width='16%'><fmt:message key="Common.DoneBy.label" bundle="${common_labels}"/></th>
<th width='16%'><fmt:message key="Common.ActionDateTime.label" bundle="${common_labels}"/></th>
</tr>
</table>
<div style="height: 135px; overflow-y: scroll ; ">
<table border='1' cellspacing="0"  width='100%' >
<%
String sql = "SELECT * FROM ae_queue_no_audit WHERE patient_id = ? AND encounter_id = ? ORDER BY added_date DESC";
	pstmt=conn.prepareStatement(sql);
	pstmt.setString(1, patient_id);
	pstmt.setString(2, encounter_id);
	rs=pstmt.executeQuery();
	while(rs.next()){
		datetime = checkForNull(rs.getString("ADDED_DATE"));
		userId = checkForNull(rs.getString("ADDED_BY_ID"));
		queue_no = checkForNull(rs.getString("QUEUE_NO"));
		queue_status = checkForNull(rs.getString("QUEUE_STATUS"));	
		
		if(queue_status.equals("A")){
			queue_status = "Assigned";
		}else if(queue_status.equals("M")){
			queue_status = "Modified";
		}else if(queue_status.equals("D")){
			queue_status = "Deleted";
		}
		
%>
			<tr>
			<td class='griddata' width='16%' style='text-align:center' align='center'><%=queue_no%></td>
			<td class='griddata' width='16%' style='text-align:center' align='center'><%=queue_status%></td>
			<td class='griddata' width='16%' style='text-align:center' align='center'><%=userId%></td>
			<td class='griddata' width='16%' style='text-align:center' align='center'><%=datetime%></td>		
		</tr>	
<%} %>


</table>
</div>
<table border='0' width='100%'>
<tr>
<td class='PANELTOOLBAR'>&nbsp;</td>
</tr>
<tr>
<td  class="button" ><input type="button" name="closeWindow" id="closeWindow" value = '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onclick="window.close()"/></td>
</tr>

</table>
</form>
</body>
<%
	}catch(Exception ex){
		out.println(ex);
		ex.printStackTrace();
	}finally{
		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();
		ConnectionManager.returnConnection(conn,request);
	}%>
</html>

<%!
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

