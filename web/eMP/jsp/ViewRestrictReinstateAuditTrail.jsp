<!DOCTYPE html>
<!-- 
CRF Reference No: MMS-DM-CRF-0210.1
Detected Release: Dec23
File Prepared by: Ajay Hatwate
File Prepared on: 04/10/2023
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
String datetime						=	"";
String userId						=	"";
String action						=	"";
String restrict_yn						=	"";
String reason						=	"";
try{
	conn = ConnectionManager.getConnection(request);

%>

<form name="ViewAuditTrailForm" id="ViewAuditTrailForm">
<table border='0' cellspacing="0"  width='100%'>
<tr>
<td class='PANELTOOLBAR' colspan='2' align='center'><fmt:message key="Common.AuditTrail.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.RestrictReinstate.label" bundle="${common_labels}"/></td>

</tr>
</table>
<table border='0' cellspacing="0" width='100%'>
<tr>
<th width='16%'><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></th>
<th width='16%'><fmt:message key="Common.userid.label" bundle="${common_labels}"/></th>
<th width='16%'><fmt:message key="Common.action.label" bundle="${common_labels}"/></th>
<th width='16%'><fmt:message key="Common.reason.label" bundle="${common_labels}"/></th>
</tr>
</table>
<div style="height: 90px; overflow-y: scroll ; ">
<table border='1' cellspacing="0"  width='100%' >
<%
String sql = "select a.restrict_reinstate_yn, (select b.long_desc from MP_PAT_RESTRICTION_REASON b where b.reason_code = a.reason_code) reason, (select c.practitioner_name from am_practitioner c where c.practitioner_id = a.modified_by_id) user_id, to_char(a.modified_date,'DD/MM/YYYY HH24:MI') modified_date from mp_pat_restrict_audit a where a.patient_id = ? order by modified_date asc";

	pstmt=conn.prepareStatement(sql);
	pstmt.setString(1, patient_id);
	rs=pstmt.executeQuery();
	while(rs.next()){
		datetime = checkForNull(rs.getString("modified_date"));
		userId = checkForNull(rs.getString("user_id"));
		reason = checkForNull(rs.getString("reason"));
		restrict_yn = checkForNull(rs.getString("restrict_reinstate_yn"));
		if(restrict_yn.equals("Y")){
			action = "Restrict";
		}else{
			action="Reinstate";
			reason = "&nbsp;";
		}
		
%>
			<tr>
			<td class='griddata' width='16%' align='center'><%=datetime%></td>
			<td class='griddata' width='16%' align='center'><%=userId%></td>
			<td class='griddata' width='16%' align='center'><%=action%></td>
			<td class='griddata' width='16%' align='center'><%=reason%></td>		
		</tr>	

<%} %>


</table>
</div>
<table border='0' width='100%'>
<tr>
<td class='PANELTOOLBAR'>&nbsp;</td>
</tr>
<tr>
<td  class="button" ><input type="button" name="closeWindow" id="closeWindow" value = '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onclick="const dialogTag = parent.document.getElementById('dialog_tag');dialogTag.close();"/></td>
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

