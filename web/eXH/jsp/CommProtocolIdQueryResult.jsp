<!DOCTYPE html>
<html>  
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<head> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eXH/js/CommProtocolId.js'></script> 
<script Language="JavaScript"  src="../../eCommon/js/common.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="APPL_RESULTS" id="APPL_RESULTS" method="POST" action=''  >

	<%
			boolean boolToggle =  true;	
			String strTDClass = "";
			// #MOD#03
			String qry_id = "COMMPROTID";
			Connection conn = null;
								 
			try
			{
				request.setAttribute(XHQueryRender.strQueryId,qry_id);
				// #MOD#04
				request.setAttribute(XHQueryRender.col,"48"); //changed by prithivi for ML-MMOH-CRF-0491 on 20/07/2016 -eNotification -added 5 new columns for soap 37 tp 42
				
				conn = ConnectionManager.getConnection(request);	
				HashMap resultsQry = XHQueryRender.getResults(request,session,conn);
				
				ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
				
				ArrayList arrCol = null;
				boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
				boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
				String strPrevious = "Previous"; 
				String strNext  = "Next"; 
				if (boolPrevious == true)
				{
					strPrevious = "Previous"; 
				}
				else
				{
					strPrevious = " ";
				}
				if (boolNext== true)
				{
						strNext  = "Next"; 
				}
				else
				{
					strNext  = " ";
				}
		%>
<table border=1 cellspacing=0 cellpadding=3 width='100%' align=center>
<%
if(arrRow.size()==0)
{
%>

<script>
alert(getMessage("XH1021","XH"));history.go(-1);
</script>

<% } else { %>
	<tr>
	<td colspan="5" align="right" class="CAGROUP" > 
	<A class='label' style='cursor:pointer' onClick="funAction('P')"><%=strPrevious %></A>
	<A class='label'  onClick="funAction('N')" style='cursor:pointer' ><%=strNext %></A>
	</td>
	</tr>

<tr>
	<td class='COLUMNHEADER'  width='30%'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='25%'><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='25%'><fmt:message key="eXH.CommunicationType.Label" bundle="${xh_labels}"/></td>
	<td class='COLUMNHEADER'  width='25%'><fmt:message key="Common.mode.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER'  width='25%'><fmt:message key="eXH.Module.Label" bundle="${xh_labels}"/></td>  
</tr>

	<%
	for (int j=0; j<arrRow.size();j++)
	{
		arrCol = (ArrayList)arrRow.get(j);
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
		String prot_type = (String)arrCol.get(36);
		String prot_mode = "";
/*
		if(arrCol.get(2).equals("T")){
		    prot_type = "TCP/IP";
		}
		else if(arrCol.get(2).equals("F")){
		    prot_type = "File";
		}

	else if(arrCol.get(2).equals("R")){
		    prot_type = "RS232";
		}
		else if(arrCol.get(2).equals("X")){
		    prot_type = "Fax";
		}
		else if(arrCol.get(2).equals("M")){
		    prot_type = "Mail";
		}
		else if(arrCol.get(2).equals("S")){
		    prot_type = "SMS";
		}
		else if(arrCol.get(2).equals("D")){
		    prot_type = "ODBC";
		}
		else if(arrCol.get(2).equals("OT")){
		    prot_type = "Oracle Table";
		}
		else if(arrCol.get(2).equals("RP")){
		    prot_type = "Replication";
		}else if(arrCol.get(2).equals("W")){
		    prot_type = "Webservice";
		}
		else if(arrCol.get(2).equals("JM")){
		    prot_type = "Java Mail";
		}
*/
		if(arrCol.get(3).equals("I")){
		    prot_mode = "Inbound";
		}
		else if(arrCol.get(3).equals("O")){
		    prot_mode = "Outbound";
		}

	%>

	<tr>
	<td style='cursor:pointer' <%=strTDClass%> align="left" >
	<a href='#' onClick='funModify(this)' protocol_id='<%=arrCol.get(0)+""%>' protocol_name='<%=arrCol.get(1)+""%>' protocol_type='<%=arrCol.get(2)+""%>'
	protocol_mode='<%=arrCol.get(3)+""%>' 
	file_dir='<%=arrCol.get(4)+""%>' file_type='<%=arrCol.get(5)+""%>' ip_address='<%=arrCol.get(6)+""%>' port_no='<%=arrCol.get(7)+""%>' ack_type='<%=arrCol.get(8)+""%>' retry_intrvl='<%=arrCol.get(9)+""%>' max_retries='<%=arrCol.get(10)+""%>' file_intrvl='<%=arrCol.get(11)+""%>'
	filenaming_api='<%=arrCol.get(12)+""%>' 
	data_intrvl='<%=arrCol.get(13)+""%>' datainput_api='<%=arrCol.get(14)+""%>' 
	statistics_api='<%=arrCol.get(15)+""%>' auto_restart_type='<%=arrCol.get(16)+""%>' auto_restart_time='<%=arrCol.get(17)+""%>' 	module_Id='<%=arrCol.get(18)+""%>' db_conn_string='<%=arrCol.get(19)+""%>'
	db_driver='<%=arrCol.get(20)+""%>' fax_id='<%=arrCol.get(21)+""%>'
	mail_id='<%=arrCol.get(22)+""%>' module_Name='<%=arrCol.get(23)+""%>' 
	oracle_table_qry='<%=java.net.URLEncoder.encode((String)arrCol.get(24))+""%>'
	oracle_table_ins_qry='<%=java.net.URLEncoder.encode((String)arrCol.get(25))+""%>' solicitedYN='<%=arrCol.get(26)+""%>' ack_dir='<%=arrCol.get(27)+""%>' 
	stylesht_path='<%=arrCol.get(28)+""%>' sub_module_Id='<%=arrCol.get(29)+""%>'
	sub_module_Name='<%=arrCol.get(30)+""%>' error_dir='<%=arrCol.get(31)+""%>' odbc_uid='<%=arrCol.get(32)+""%>' odbc_pwd='<%=arrCol.get(33)+""%>' odbc_sid='<%=arrCol.get(34)+""%>' dblink_name='<%=arrCol.get(35)+""%>' httpUserAgent='<%=arrCol.get(37)+""%>' httpContentType='<%=arrCol.get(38)+""%>' httpTransferEncoding='<%=arrCol.get(39)+""%>' httpSoapAction='<%=arrCol.get(40)+""%>' httpContentLength='<%=arrCol.get(41)+""%>'  mail_host='<%=arrCol.get(42)+""%>' mail_port='<%=arrCol.get(43)+""%>' mail_config='<%=arrCol.get(44)+""%>' mail_smtp_auth_flag='<%=arrCol.get(45)+""%>' mail_smtp_starttls_flag='<%=arrCol.get(46)+""%>' mail_attachment_flag='<%=arrCol.get(47)+""%>' >
	<%=arrCol.get(0)+""%> 
	</a> 
	</b>
	</td>
	<td <%=strTDClass%> align="left"> 
		<%=""+arrCol.get(1) %>
	</td>
	<td <%=strTDClass%> align="left"> 
		<%=prot_type %>
	</td>
	<td <%=strTDClass%> align="center">
		<%=prot_mode %>
	</td>
	<td <%=strTDClass%> align="center">
		<%=""+arrCol.get(18) %>
	</td>

	</tr>
	<%
	}
}
if(arrRow!=null) arrRow.clear();
if(arrCol!=null) arrCol.clear();
if(resultsQry!=null) resultsQry.clear();
}
	catch(Exception e1)
	{
		out.println("Error="+e1);
	}
	finally
	{
		ConnectionManager.returnConnection(conn);
	}
	%>
	</table>

	<input type='hidden' name='mode' id='mode' value='U' >
	<input type='hidden' name='action_type' id='action_type' value=''>
	<input type='hidden' name='protocol_id' id='protocol_id' value=''>
	<input type='hidden' name='protocol_name' id='protocol_name' value=''>
	<input type='hidden' name='protocol_type' id='protocol_type' value=''>
	<input type='hidden' name='protocol_mode' id='protocol_mode' value=''>
	<input type='hidden' name='file_dir' id='file_dir' value=''>
	<input type='hidden' name='file_type' id='file_type' value=''>
	<input type='hidden' name='ip_address' id='ip_address' value=''>
	<input type='hidden' name='port_no' id='port_no' value=''>
	<input type='hidden' name='ack_type' id='ack_type' value=''>
	<input type='hidden' name='retry_intrvl' id='retry_intrvl' value=''>
	<input type='hidden' name='max_retries' id='max_retries' value=''>
	<input type='hidden' name='file_intrvl' id='file_intrvl' value=''>
	<input type='hidden' name='filenaming_api' id='filenaming_api' value=''>
	<input type='hidden' name='data_intrvl' id='data_intrvl' value=''>
	<input type='hidden' name='datainput_api' id='datainput_api' value=''>
	<input type='hidden' name='statistics_api' id='statistics_api' value=''>
	<input type='hidden' name='auto_restart_type' id='auto_restart_type' value=''>
	<input type='hidden' name='auto_restart_time' id='auto_restart_time' value=''>
	<input type='hidden' name='module_Id' id='module_Id' value=''>
	<input type='hidden' name='db_conn_string' id='db_conn_string' value=''>
	<input type='hidden' name='db_driver' id='db_driver' value=''>
	<input type='hidden' name='fax_id' id='fax_id' value=''>
	<input type='hidden' name='mail_id' id='mail_id' value=''>
	<input type='hidden' name='module_Name' id='module_Name' value=''>
    <input type='hidden' name='recipient_name' id='recipient_name' value=''>
    <input type='hidden' name='to_mail' id='to_mail' value=''>
    <input type='hidden' name='solicitedYN' id='solicitedYN' value=''>
	<input type='hidden' name='oracle_table_qry' id='oracle_table_qry' value=''>
    <input type='hidden' name='oracle_table_ins_qry' id='oracle_table_ins_qry' value=''>
	<input type='hidden' name='ack_dir' id='ack_dir' value=''>  
	<input type='hidden' name='stylesht_path' id='stylesht_path' value=''> 
	<input type='hidden' name='sub_module_Id' id='sub_module_Id' value=''> 
	<input type='hidden' name='sub_module_Name' id='sub_module_Name' value=''> 
	<input type='hidden' name='error_dir' id='error_dir' value=''>  
	<input type='hidden' name='odbc_uid' id='odbc_uid' value=''> 
	<input type='hidden' name='odbc_pwd' id='odbc_pwd' value=''> 
	<input type='hidden' name='odbc_sid' id='odbc_sid' value=''> 
	<input type='hidden' name='dblink_name' id='dblink_name' value=''>
	<input type='hidden' name='httpUserAgent' id='httpUserAgent' value=''>
	<input type='hidden' name='httpContentType' id='httpContentType' value=''>
	<input type='hidden' name='httpTransferEncoding' id='httpTransferEncoding' value=''>
	<input type='hidden' name='httpSoapAction' id='httpSoapAction' value=''>
	<input type='hidden' name='httpContentLength' id='httpContentLength' value=''>
	
	<input type='hidden' name='mail_host' id='mail_host' value=''>
	<input type='hidden' name='mail_port' id='mail_port' value=''>
	<input type='hidden' name='mail_config' id='mail_config' value=''>
	<input type='hidden' name='mail_smtp_auth_flag' id='mail_smtp_auth_flag' value=''>
	<input type='hidden' name='mail_smtp_starttls_flag' id='mail_smtp_starttls_flag' value=''>
	<input type='hidden' name='mail_attachment_flag' id='mail_attachment_flag' value=''>
</form>
</html>


