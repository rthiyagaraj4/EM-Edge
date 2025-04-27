<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*, java.net.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %> 
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eOA/js/ClinicAllocation.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
Connection conn	=null; 
Statement  stmt	=null;
ResultSet  rSet	=null;
String slot_appt_ctrl=request.getParameter("slot_appt_ctrl");
String alcn_criteria=request.getParameter("alcn_criteria");
String max_patients_per_day=request.getParameter("max_patients_per_day");
String stat_grp_id="";
String stat_grp_desc="";
String group_sql  ="select stat_grp_id,stat_grp_desc from am_stat_group  where stat_grp_id in 	(select stat_grp_id from am_stat_grp_for_program where module_id = 'OA' and program_id = 'TIME_TABLE') order by stat_grp_desc";
try{
	conn=ConnectionManager.getConnection(request);
%>
<body  OnMouseDown="CodeArrest()"onKeyDown = 'lockKey()' >
<form name='alcn_add_form' id='alcn_add_form'>
<table border=0 cellpadding=0 cellspacing=0 width='100%' align='center'>
<tr><td colspan='2'>&nbsp;</td></tr>
<tr>
<%if(alcn_criteria.equals("NG")){%>
<td class='LABEL'><fmt:message key="Common.nationality.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
<%}else{%>
<td class='LABEL'>Other Group</td>
<%}%>
<td>
<select name='pat_category' id='pat_category'>
<option value="">------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
<%
	stmt=conn.createStatement();
	rSet=stmt.executeQuery(group_sql);
	while(rSet!=null && rSet.next()){
		stat_grp_id=rSet.getString("stat_grp_id");
		stat_grp_desc=rSet.getString("stat_grp_desc");
		out.println("<option value='"+stat_grp_id+"'>"+stat_grp_desc+"</option>");
		//out.println("<input type='hidden' name='"+stat_grp_id+"' id='"+stat_grp_id+"' value='"+stat_grp_desc+"'>");
	}
%>
</select><img src="../../eCommon/images/mandatory.gif" align='center'></img>
</td>
</tr>
<tr>
<%if(slot_appt_ctrl.equals("S")){%>
<td class='LABEL'><fmt:message key="eOA.NoofSlots.label" bundle="${oa_labels}"/></td>
<%}else{%>
<td class='LABEL'><fmt:message key="eAE.NoofPatients.label" bundle="${ae_labels}"/></td>
<%}%>
<td class='fields'><input type='text' name='no_solts' id='no_solts' size='2' MAXLENGTH='3' onKeyPress="return CheckForSpecChar(event)" onBlur='CheckLimit(this);CheckForNumber(this);'><img src="../../eCommon/images/mandatory.gif" align='center'></img></td>
</tr>
<tr>
<td></td>
<td class='button'><input type='button' name='Add' id='Add' value='Add'  class="BUTTON" onclick='addGroup()'><input type='button' name='clear' id='clear' value='Clear'  class="BUTTON" onclick='clearGroup()'></td>
</tr>
</table>
<input type="hidden" name="max_patients_per_day" id="max_patients_per_day" value="<%=max_patients_per_day%>">
	<input type="hidden" name="modify" id="modify" value=''>
</form>
</body>
<%
	if(rSet!=null) rSet.close();
	if(stmt!=null) stmt.close();
}catch(Exception exception){
	exception.printStackTrace();
}finally{
	ConnectionManager.returnConnection(conn,request);
}
%>
</html>

