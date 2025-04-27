<!DOCTYPE html>

<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html> 
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eFM/js/FMChFileRetDate.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
Connection con				=	null;
java.sql.Statement stmt		=	null;
ResultSet	rs				=	null;
java.sql.Statement stmt1	=	null;
ResultSet	rs1				=	null;

String str="", query_result="", facility_id="";
String curr_file_status      ="";
String curr_fs_locn_code     ="";
String curr_fs_locn_identity ="";
String short_desc            ="";
String login_user            ="";
String user_id               ="";
String curr_holder_name      ="";
String iss_date_time="",return_date_time="";
String user_security_yn      = "N";
String remarks="",file_no="",sys_date="",curr_facility_name=""; 

String volume_no="";
String p_access_all = "";

try
{
	con			=	ConnectionManager.getConnection(request);
	stmt		=	con.createStatement();
	stmt1		=	con.createStatement();

	facility_id	=	(String)session.getValue("facility_id");
	login_user	=	(String)session.getValue("login_user");

	str					= request.getParameter("whereClause");
	user_id				= request.getParameter("user_id");	
	user_security_yn	= request.getParameter("user_security_yn");
	p_access_all		= request.getParameter("p_access_all");
	sys_date			= request.getParameter("sysDate");

	if(user_security_yn == null || user_security_yn.equals("null")) user_security_yn = "N"; 
	if(p_access_all == null || p_access_all.equals("null")) p_access_all = ""; 
	if(sys_date == null || sys_date.equals("null")) sys_date = ""; 
	
	if(str==null) str="";
	

	if(user_security_yn.equals("Y"))
	{		

		if (p_access_all.equals("1"))
		{
			query_result="select decode(curr_file_status, 'T', 'In Transit', 'I', 'Inside', 'L','Lost','A', 'Archived','O', 'Outside') curr_file_status, curr_fs_locn_code , decode(curr_fs_locn_identity, 'D','Department','T','Practitioner','C','Clinic','N','Nursing Unit','X','External','E','Procedure Unit','Y','Daycare Unit')curr_fs_locn_identity, curr_fs_locn_desc short_desc, curr_holder_name, to_char(iss_date_time,'dd/mm/yyyy hh24:mi')iss_date_time, file_no,file_type_code, to_char(return_date_time,'dd/mm/yyyy hh24:mi')return_date_time, remarks,(case when a.curr_facility_id<>a.facility_id then '/ (' || curr_facility_name ||')' else '' end )curr_facility_name,volume_no from fm_curr_locn_vw a where a.facility_id='"+facility_id+"' and curr_file_status not in ('T','L','A','R') and  ((curr_file_status = 'I' and mr_pat_fs_locn_code != curr_fs_locn_code ) or (curr_file_status = 'O' ))  "+ str;
		}
		else
		{
			query_result="select decode(curr_file_status, 'T', 'In Transit', 'I', 'Inside', 'L','Lost','A', 'Archived','O', 'Outside') curr_file_status, curr_fs_locn_code , decode(curr_fs_locn_identity, 'D','Department','T','Practitioner','C','Clinic','N','Nursing Unit','X','External','E','Procedure Unit','Y','Daycare Unit')curr_fs_locn_identity, curr_fs_locn_desc short_desc, curr_holder_name, to_char(iss_date_time,'dd/mm/yyyy hh24:mi')iss_date_time,file_no,file_type_code, to_char(return_date_time,'dd/mm/yyyy hh24:mi')return_date_time, remarks,(case when a.curr_facility_id<>a.facility_id then '/ (' || curr_facility_name ||')' else '' end )curr_facility_name,volume_no from fm_curr_locn_vw a, fm_user_access_rights d where return_date_time is not null and  a.facility_id='"+facility_id+"' and curr_file_status not in ('T','L','A','R') and  ((curr_file_status = 'I' and mr_pat_fs_locn_code != curr_fs_locn_code ) or (curr_file_status = 'O' )) and a.facility_id=d.facility_id and a.mr_pat_fs_locn_code=d.fs_locn_code and d.CHANGE_RETURN_DATE_YN='Y' and d.appl_user_id='"+login_user+"' "+ str;
		}
	}
	else if(user_security_yn.equals("N"))
	{
		query_result="select decode(curr_file_status, 'T', 'In Transit', 'I', 'Inside', 'L','Lost','A', 'Archived','O', 'Outside') curr_file_status, curr_fs_locn_code , decode(curr_fs_locn_identity, 'D','Department','T','Practitioner','C','Clinic','N','Nursing Unit','X','External','E','Procedure Unit','Y','Daycare Unit') curr_fs_locn_identity, curr_fs_locn_desc short_desc, curr_holder_name,file_no,file_type_code, to_char(iss_date_time,'dd/mm/yyyy hh24:mi')iss_date_time, to_char(return_date_time,'dd/mm/yyyy hh24:mi')return_date_time, remarks, file_no,(case when curr_facility_id<>facility_id then '/ (' || curr_facility_name ||')' else '' end )curr_facility_name,volume_no from fm_curr_locn_vw  where return_date_time is not null and  facility_id='"+facility_id+"' and curr_file_status not in ('T','L','A','R') and  ((curr_file_status = 'I' and mr_pat_fs_locn_code != curr_fs_locn_code) or (curr_file_status = 'O' and mr_pat_fs_locn_code !=  curr_fs_locn_code)) "+ str;
	}
	if(stmt!= null)stmt.close();
	stmt	=	con.createStatement();
	
	rs=stmt.executeQuery(query_result);
	if(rs != null)
	{
		if(rs.next())
		{
			curr_file_status		=	rs.getString("curr_file_status");
			curr_fs_locn_code		=	rs.getString("curr_fs_locn_code");
			curr_fs_locn_identity	=	rs.getString("curr_fs_locn_identity");
			short_desc				=	rs.getString("short_desc");
			curr_holder_name		=	rs.getString("curr_holder_name");
			iss_date_time			=	rs.getString("iss_date_time");
			return_date_time		=	rs.getString("return_date_time");
			remarks					=	rs.getString("remarks");
			file_no					=	rs.getString("file_no");
			curr_facility_name		=	rs.getString("curr_facility_name");
			volume_no		        =	rs.getString("volume_no");
			
			if(curr_file_status == null || curr_file_status.equals("null"))curr_file_status="";
			if(curr_fs_locn_code == null || curr_fs_locn_code.equals("null"))curr_fs_locn_code="";
			if(curr_fs_locn_identity == null ||  curr_fs_locn_identity.equals("null")) curr_fs_locn_identity="";
			if(short_desc == null || short_desc.equals("null"))short_desc="";
			if(curr_holder_name == null || curr_holder_name.equals("null"))curr_holder_name="";
			if(iss_date_time == null || iss_date_time.equals("null"))iss_date_time="";
			if(return_date_time == null || return_date_time.equals("null"))return_date_time="";
			if(remarks == null || remarks.equals("null"))remarks="";
			if(curr_facility_name == null || curr_facility_name.equals("null")) curr_facility_name="";
%>
<body onMouseDown='CodeArrest()' onLoad='document.forms[0].return_date_time.focus()' onKeyDown = 'lockKey();'>
<center>
<form name='FMChFileRetDateResultFrame' id='FMChFileRetDateResultFrame'>
<table cellpadding='3' cellspacing='0' border='0' width='80%'>
<tr>
	<td  class='label' width='25%'><fmt:message key="eFM.DocumentStatus.label" bundle="${fm_labels}"/></td>
	<td class='fields' width='25%'><input type='text' name='curr_file_status' id='curr_file_status' value='<%=curr_file_status%>' size='10'  disabled ></td>
<!-- </tr>
<tr> -->
	<td class='label' width='25%'><fmt:message key="eFM.CurrentFSLocation.label" bundle="${fm_labels}"/></td>
	<td class='fields' width='25%'><input type='text' name='curr_fs_locn_desc' id='curr_fs_locn_desc'
	value='<%=short_desc%> (<%=curr_fs_locn_identity%>)' size ='45' disabled ><input type='hidden' name='curr_fs_locn_code' id='curr_fs_locn_code' value='<%=curr_fs_locn_code%>'><font size=1><%=curr_facility_name%></font></td>
</tr>
<tr>
	<td class='label'><fmt:message key="eFM.HolderName.label" bundle="${fm_labels}"/></td>
	<td class='fields' ><input type='text' name='curr_holder_name' id='curr_holder_name' value='<%=curr_holder_name%>' size='30' disabled ></td>
<!-- </tr>
<tr> -->
	<td class='label'><fmt:message key="eFM.IssueDateTime.label" bundle="${fm_labels}"/></td>
	<td class='fields' ><input type='text' name='iss_date_time' id='iss_date_time' value='<%=iss_date_time%>' size='16' disabled></td>
</tr>
<tr>
	<td class='label'><fmt:message key="Common.returndatetime.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type='text' id ='returndatetime' name='return_date_time' id='return_date_time' value='<%=return_date_time%>' size='16' maxlength='16' ><input type="image" src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('returndatetime', null, 'hh:mm');"><img src='../../eCommon/images/mandatory.gif'></img></td>
	<td class='label' colspan='2'>&nbsp;</td>
</tr>
<tr>
	<td class='label' valign='top'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
	<td class='fields' colspan='2'><textarea rows='3' cols='35' name='remarks'  onkeypress="checkMaxLimit(this,100)" onBlur="makeValidString(this);CheckMaxLen('Remarks',this,100,parent.parent.frames[2])" ><%=remarks%></textarea></td>
	<td class='label'>&nbsp;</td>
</tr>
<input type='hidden' name='file_no' id='file_no' value='<%=file_no%>'>
<input type='hidden' name='volume_no' id='volume_no' value='<%=volume_no%>'>
<input type='hidden' name='sys_date' id='sys_date' value='<%=sys_date%>'>
<input type='hidden' name='user_id' id='user_id' value='<%=user_id%>'>
</table>
</form>
</center>
</body>
</html>

<script>
	parent.frames[0].document.forms[0].p_curr_fs_loc.disabled=true;
	parent.frames[0].document.forms[0].patient_id.disabled=true;
	if(parent.frames[0].document.forms[0].file_no != null)
		parent.frames[0].document.forms[0].file_no.disabled=true;
	if(parent.frames[0].document.forms[0].file_type_code != null)
		parent.frames[0].document.forms[0].file_type_code.disabled=true;
	parent.frames[0].document.forms[0].reset1.disabled=false;
	parent.frames[0].document.forms[0].search_dtl.disabled=false;
	parent.frames[0].document.forms[0].p_curr_fs_loc.disabled=false;
</script>
<%
		}
		else
		{
%>
			<script>
			var msg = getMessage('DOC_RET_DATE_NOT_CHANGE','FM');
			parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+msg;			
			parent.frames[0].document.forms[0].reset1.disabled=false;
			parent.frames[0].document.forms[0].search_dtl.disabled=false;	
			parent.frames[0].document.forms[0].p_curr_fs_loc.disabled=false;
			</script>
<%
		}
	}
	if(stmt!= null)stmt.close();
	if(stmt1!= null)stmt1.close();
	if(rs!= null)rs.close();
	if(rs1!= null)rs1.close();
}
catch(Exception e)
{
	out.println("Exception while fetching connection"+e);
}
finally
{	
	ConnectionManager.returnConnection(con, request);
}
%>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

