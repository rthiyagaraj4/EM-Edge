<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<script>
	function ChkNumberInput1(fld, e, deci)
{
if (parseInt(deci)>0)
   var strCheck = '.0123456789';
else
   var strCheck = '0123456789';
	
var whichCode = (window.Event) ? e.which : e.keyCode;
if (whichCode == 13) return true;  // Enter

key = String.fromCharCode(whichCode);  // Get key value from key code

if (strCheck.indexOf(key) == -1) return false;  // Not a valid key

}

function SpeCharCheck(which) {
fldval = which.value;
fldval = fldval.replace(/^\s+/,""); // strip leading spaces
if (/[^.0-9\s]/i.test(fldval)) { // only alphanumeric and space allowed
alert ("You have entered one or more invalid characters - try again!");
which.value = "";
which.focus();
return false;
}
}

</script>
<%

Connection conn=null;
			try{
				 request.setCharacterEncoding("UTF-8");
			conn = ConnectionManager.getConnection(request);
	Statement stmt=conn.createStatement();
	ResultSet rset=null;
	String eff_date_from="",eff_date_to="";

// By sbchand start on 24th July, 2001
	String app_server_ip = "" ;
// By sbchand end on 24th July, 2001
String rep_cfg_key = "" ;
%>

<% 
      String Report_Service_Id = request.getParameter("Report_Service_Id");
      String Remarks=""; 
try{
%>
<html><head><%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
		<Script src="../../eSM/js/ReportService.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body onload='FocusFirstElement()'  onKeyDown = 'lockKey()';  onMouseDown='CodeArrest()'>
<%

String sql = "select Report_Service_Id,Report_Service_Name,Remarks,eff_date_from,eff_date_to,eff_status, app_server_ip,rep_cfg_key from Sm_Report_Service where Report_Service_Id='"+Report_Service_Id+"'";
rset = stmt.executeQuery(sql);
rset.next();
%>
<form name='report_service_form' id='report_service_form' action='../../servlet/eSM.ReportServiceServlet' method='post' target='messageFrame'> 
<div align='left'><br><br><br><br><br><br>
<table border='0' cellpadding='0' cellspacing='0' width='90%' align='center'>
	<tr>
		<td width='35%'>&nbsp;</td>
		<td width='65%' colspan='2'>&nbsp;</td>
	</tr>
	<tr>
		<td width='37%' class='label'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
		<td class='fields' width='63%' colspan='2'>
	<input type='text' name='Report_Service_Id' id='Report_Service_Id' value='<%=rset.getString("Report_Service_Id")%>' size='8' maxlength='8' OnBlur='ChangeUpperCase(this)' readonly >&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'>
<%
// By sbchand start on 24th July, 2001
	app_server_ip = rset.getString( "app_server_ip" ) ;

	if ( app_server_ip == null ) app_server_ip = "" ;
// By sbchand end on 24th July, 2001      
	rep_cfg_key =  rset.getString( "rep_cfg_key" )==null?"":rset.getString( "rep_cfg_key" ) ;

	if ( rset.getDate("eff_date_from") != null )
		{
		 java.util.Date date = rset.getDate("eff_date_from");
		 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
 		 eff_date_from = formatter.format(date);
 		 date = null;
 		 formatter = null;
 		}



	if ( rset.getDate("eff_date_to") != null)
	{
	 java.util.Date date1 = rset.getDate("eff_date_to");
	 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
	 eff_date_to = formatter.format(date1);
	 date1 = null;
	 formatter = null;
	}


if ( rset.getString("eff_status").equals("E") )
{%>
		</td>
	</tr>
	<tr>
		<td width='35%'>&nbsp;</td>
		<td width='65%' colspan='2'>&nbsp;</td>
	</tr>
	<tr>
		<td width='37%' class='label'><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
		<td class='fields' width='63%' colspan='2'><input type='text'  onBlur='makeValidString(this)'   name='Report_Service_Name' id='Report_Service_Name' size='30' maxlength='30' value='<%=rset.getString("Report_Service_Name")%>'>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'>


	<!-- // By sbchand start on 24th July, 2001 -->
		</td>
	</tr>
	<tr>
			<td width='35%'>&nbsp;</td>
			<td width='65%' colspan='2'>&nbsp;</td>
	</tr>
	<tr>
			<td width='37%' class='label'><fmt:message key="eSM.ReportServerIPAddress.label" bundle="${sm_labels}"/></td>
			<td class='fields' width='63%' colspan='2'><input type='text'  onBlur='makeValidString(this);SpeCharCheck(this)'  name='app_server_ip' id='app_server_ip' onKeyPress='return(ChkNumberInput1(this,event,2))'  size='30' maxlength='30' value='<%=app_server_ip%>'>&nbsp;     <!-- Added by Ashwin K where size and maxlength are increased to 30 for COMMON-ICN-0093 on 03.03.2022 -->
<!-- // By sbchand end on 24th July, 2001 -->
<%		
	Remarks= rset.getString("Remarks")==null ? "" : rset.getString("Remarks");
%>
 			</td>
	</tr>
	<tr>
		<td width='35%'>&nbsp;</td>
		<td width='65%' colspan='2'>&nbsp;</td>
	</tr>
	<tr>
		<td width='37%' class='label' valign='center'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td width='63%' colspan='2' class='fields'><TextArea  name='Remarks'   onBlur='makeValidString(this)'  cols='40' rows='5' onkeypress='checkMaxLimit(this,200)' ><%=Remarks%></TextArea>
		</td>
	</tr>
	<tr>
		<td width='35%'>&nbsp;</td>
		<td width='65%' colspan='2'>&nbsp;</td>
	</tr>
	<tr>
			<td width='37%' class='label'><fmt:message key="eSM.ReportConfigKey.label" bundle="${sm_labels}"/></td>
			<td class='fields' width='63%' colspan='2'><input type='text'  onBlur='makeValidString(this)'  name='rep_cfg_key' id='rep_cfg_key'  size='10' maxlength='10' value='<%=rep_cfg_key%>'>&nbsp;
 			</td>
	</tr>
	<tr>
		<td width='35%'>&nbsp;</td>
		<td width='65%' colspan='2'>&nbsp;</td>
	</tr>
	
	
	<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10' onblur='CheckDate(this)'  value='<%=eff_date_from%>'>

 		
 
	
	<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'  onblur='CheckDate(this)'  value='<%=eff_date_to%>'>

	
	<tr>
		<td width='37%' class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td class='fields' width='63%' colspan='2'><input type='checkbox' name='eff_status' id='eff_status' value='E'
<%
	String eff_status = rset.getString("eff_status"); 

	if  ( eff_status.equals("E") ) 
	{%>
		checked >&nbsp;
	<%}
	else {%>
		>&nbsp;
	<%}%>

		</td>
	</tr>
	<tr>
			<td width='35%'>&nbsp;</td>
			<td width='65%' colspan='2'>&nbsp;</td>
	</tr>
</table>
</div><input type='hidden' name='function' id='function' value='modify'><input type='hidden' name='eff_date_from' id='eff_date_from' value=''><input type='hidden' name='eff_date_to' id='eff_date_to' value=''><input type='hidden' name='function_name' id='function_name' value='modify'></form>
<%}
else {%>
	</td>
	</tr>
	<tr>
		<td width='35%'>&nbsp;</td>
		<td width='65%' colspan='2'>&nbsp;</td>
	</tr>
	<tr>
		<td width='37%' class='label'><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
		<td class='fields' width='63%' colspan='2'><input type='text' name='Report_Service_Name' id='Report_Service_Name' size='30' value='<%=rset.getString("Report_Service_Name")%>' readonly>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>

<!-- // By sbchand start on 24th July, 2001 -->
	</td>
	</tr>
	<tr>
		<td width='35%'>&nbsp;</td>
		<td width='65%' colspan='2'>&nbsp;</td>
	</tr>
	<tr>
		<td width='37%' class='label'><fmt:message key="eSM.ReportServerIPAddress.label" bundle="${sm_labels}"/></td>
		<td class='fields' width='63%' colspan='2'><input type='text' name='app_server_ip' id='app_server_ip' size='30' maxlength='30' value='<%=app_server_ip%>' onblur='SpeCharCheck(this)' readonly>&nbsp;  <!-- Added by Ashwin K where size and maxlength are increased to 30 for COMMON-ICN-0093 on 03.03.2022 -->
<!-- // By sbchand end on 24th July, 2001
	 -->
	<%Remarks= rset.getString("Remarks")==null ? "" : rset.getString("Remarks");%>
	</td>
	</tr>
	<tr>
		<td width='35%'>&nbsp;</td>
		<td width='65%' colspan='2'>&nbsp;</td>
	</tr>
	<tr>
		<td width='37%' class='label' valign='top'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td class='fields' width='63%' colspan='2'><TextArea  name='Remarks' cols='40' rows='5' onkeypress='checkMaxLimit(this,200)' readonly><%=Remarks%></TextArea>
	</td></tr>
	<tr>
		<td width='35%'>&nbsp;</td>
		<td width='65%' colspan='2'>&nbsp;</td>
	</tr>
	<tr>
			<td width='37%' class='label'><fmt:message key="eSM.ReportConfigKey.label" bundle="${sm_labels}"/></td>
			<td class='fields' width='63%' colspan='2'><input type='text'  onBlur='makeValidString(this);SpeCharCheck(this)'  name='rep_cfg_key' id='rep_cfg_key'  size='10' maxlength='10' value='<%=rep_cfg_key%>'>&nbsp;
 			</td>
	</tr>
	<tr>
		<td width='35%'>&nbsp;</td>
		<td width='65%' colspan='2'>&nbsp;</td>
	</tr>
	

	
	<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10' onblur='CheckDate(this)'  value='<%=eff_date_from%>'readonly>
	

	<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'  onblur='CheckDate(this)'  value='<%=eff_date_to%>'readonly>

	
	<tr>
		<td width='37%' class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td class='fields' width='63%' colspan='2'><input type='checkbox' name='eff_status' id='eff_status' value='E'
<%
	String eff_status = rset.getString("eff_status"); 

	if  ( eff_status.equals("E") ) 
	{%>
		checked >&nbsp;
	<%}
	else{%> 
		>&nbsp;
	<%}%>
	</td>
	</tr>
	<tr>
		<td width='35%'>&nbsp;</td>
		<td width='65%' colspan='2'>&nbsp;</td>
	</tr>
</table>
</div><input type='hidden' name='function' id='function' value='modify'><input type='hidden' name='eff_date_from' id='eff_date_from' value=''><input type='hidden' name='eff_date_to' id='eff_date_to' value=''><input type='hidden' name='function_name' id='function_name' value='modify'></form>
<%}
	if(rset != null) rset.close();
	if(stmt != null) stmt.close();	
}
catch ( Exception e ) {}
%>
</body>
</html>
<%
}catch(Exception e){out.println(e);}
finally { 
		ConnectionManager.returnConnection(conn,request);
}	
%>

