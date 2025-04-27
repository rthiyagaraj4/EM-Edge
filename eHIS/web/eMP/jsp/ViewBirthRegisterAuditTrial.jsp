<!DOCTYPE html>
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
//ResultSet rs1=null;
//Properties p						=	(java.util.Properties) session.getValue( "jdbc" );
//String login_user					=	p.getProperty( "login_user" ) ;
String locale						=	((String)session.getAttribute("LOCALE"));
String patient_id					=	checkForNull(request.getParameter("patient_id"));
String initial_print_user           =	"";
String print_date_time1             =	"";
String login_user_id				=	"";
String print_date_time   			=	"";
String no_of_copies					=	"";
String work_station_no				=	"";
String initial_print_yn				=	"";
String outcome						=	"";
String type_of_Document             =	"";

try{

	conn = ConnectionManager.getConnection(request);

%>

<form name="ViewAuditTrailForm" id="ViewAuditTrailForm">
<table border='0' cellspacing="0"  width='100%'>
<tr>
<th class='PANELTOOLBAR' colspan='2' align='center'><fmt:message key="Common.print.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/></th>

</tr>
<%

   	String sql = "select outcome from MP_BIRTH_REGISTER where patient_id = '"+patient_id+"'";

	pstmt=conn.prepareStatement(sql);

	rs=pstmt.executeQuery();
	while(rs.next()){		
		outcome		=	checkForNull(rs.getString("outcome"));
	}
	if(pstmt!=null)pstmt.close();
	if(rs!=null)rs.close();

    StringBuffer queryS1 = new StringBuffer();

    queryS1.append("select sm_get_desc.sm_appl_user(added_by_id,'"+locale+"','1') initial_print_user, to_char(added_date,'dd/mm/yyyy hh24:mi:ss') print_date_time from sm_print_routing_audit where  patient_id = '"+patient_id+"' and module_id = 'MP' ");

	if (outcome.equals("L"))
	{
		queryS1.append(" and report_id = 'MPBIRCER' and initial_print_yn = 'Y' ");
	}
	else if (outcome.equals("S"))
	{
		queryS1.append(" and report_id = 'MPSTBCER'  and initial_print_yn = 'Y' ");
	}

	pstmt=conn.prepareStatement(queryS1.toString());

	rs=pstmt.executeQuery();
	while(rs.next()){		
		initial_print_user		=	checkForNull(rs.getString("initial_print_user"));
		print_date_time1		=	checkForNull(rs.getString("print_date_time"));
	}
	if(pstmt!=null)pstmt.close();
	if(rs!=null)rs.close();
	if((queryS1 != null) && (queryS1.length() > 0))
		{
			queryS1.delete(0,queryS1.length());
		}

%>
<tr>
<th class='PANELTOOLBAR' align='left' ><fmt:message key="Common.InitialPrint.label" bundle="${common_labels}"/>&nbsp;: <%=initial_print_user%></th>
<th class='PANELTOOLBAR' align='right'><fmt:message key="Common.InitialPrintDt.label" bundle="${common_labels}"/> : <%=print_date_time1%></th>
</tr>
</table>
<table border='0' cellspacing="0" width='100%'>
<tr>
<th width='16%'><fmt:message key="Common.PrintedBy.label" bundle="${common_labels}"/></th>
<th width='16%'><fmt:message key="Common.DateAndTimePrinting.label" bundle="${common_labels}"/></th>
<th width='16%'><fmt:message key="Common.NumberOfCopies.label" bundle="${common_labels}"/></th>
<th width='16%'><fmt:message key="Common.WorkstationNo.label" bundle="${common_labels}"/></th>
<th width='16%'><fmt:message key="Common.InitialPrintYN.label" bundle="${common_labels}"/></th>
<th width='16%'><fmt:message key="Common.TypeofDocument.label" bundle="${common_labels}"/></th>
</tr>
</table>
<div style="height: 135px; overflow-y: scroll ; ">
<table border='1' cellspacing="0"  width='100%' >
<%
	StringBuffer queryS2 = new StringBuffer();
    
	queryS2.append("select sm_get_desc.sm_appl_user(added_by_id,'"+locale+"','1') login_user_id, to_char(added_date,'dd/mm/yyyy hh24:mi:ss') print_date_time, no_of_copies,added_at_ws_no work_station_no, initial_print_yn,sm_get_desc.sm_report(module_id,report_id,'"+locale+"' ,'1') type_of_Document from sm_print_routing_audit  where  patient_id = '"+patient_id+"' and module_id = 'MP' ");
	
	if (outcome.equals("L"))
	{
		queryS2.append(" and report_id = 'MPBIRCER' order by audit_srl_no desc  ");
	}
	else if (outcome.equals("S"))
	{
		queryS2.append(" and report_id = 'MPSTBCER'  order by audit_srl_no desc  ");
	}

	pstmt=conn.prepareStatement(queryS2.toString());
	rs=pstmt.executeQuery();
	while(rs.next()){
		login_user_id		    =	checkForNull(rs.getString("login_user_id"));
		print_date_time   		=	checkForNull(rs.getString("print_date_time"));
		no_of_copies			=	checkForNull(rs.getString("no_of_copies"));
		work_station_no			=	checkForNull(rs.getString("work_station_no"));		
		initial_print_yn		=	checkForNull(rs.getString("initial_print_yn"));	
		type_of_Document          =	checkForNull(rs.getString("type_of_Document"));	
		
		%>
		<tr>
			<td class='griddata1' width='16%' align='center'><%=login_user_id%></td>
			<td class='griddata1' width='16%' align='center'><%=print_date_time%></td>
			<td class='griddata1' width='16%' align='center'><%=no_of_copies%></td>
			<td class='griddata1' width='16%' align='center'><%=work_station_no%></td>
			<td class='griddata1' width='16%' align='center'><%=initial_print_yn%></td>			
			<td class='griddata1' width='16%' align='center'><%=type_of_Document%></td>			
		</tr>	
		<%
		
	}

	if(pstmt!=null)pstmt.close();
	if(rs!=null)rs.close();
	if((queryS2 != null) && (queryS2.length() > 0))
		{
			queryS2.delete(0,queryS2.length());
		}
%>
</table>
</div>
<table border='0' width='100%'>
<tr>
<th class='PANELTOOLBAR'>&nbsp;</th>
</tr>
<tr>
<td  class="button" ><input type="button" name="closeWindow" id="closeWindow" value = '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onclick="parent.document.querySelectorAll('#dialog_tag')[parent.document.querySelectorAll('#dialog_tag').length-1].close();"/></td>
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

