<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*,eRS.*,eCommon.Common.*" %>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<%
	request.setCharacterEncoding("UTF-8");
	String facility_id = (String)session.getAttribute("facility_id");
	String bean_id			= "Rs_workplace_bean" ;
	String bean_name		= "eRS.WorkplaceBean";
	String mode = request.getParameter("mode");
	int num = 0;
	char ch;
	int week_count = 0;
	String week_basis = "";
	
	String week_day = "";
	Connection conn = ConnectionManager.getConnection(request);
	PreparedStatement pstmt=null;
	ResultSet rs=null;

	Vector week_vector = new Vector();
	String query_week_days = "Select initcap ( substr ( day_of_week , 1 , 3 ) ) day_of_week from sm_day_of_week order by day_no";
	pstmt = conn.prepareStatement(query_week_days);
	rs = pstmt.executeQuery();
	while(rs.next())
	{
		week_vector.add(rs.getString("day_of_week"));
	}
	if(pstmt!=null) pstmt.close();
	if(rs!=null) rs.close();
%>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<!-- <Script Language="JavaScript" src="../../eCommon/js/messages.js"></Script> -->
   	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/MstCodeCommon.js' language='javascript'></script>
	<!-- <script src='../../eCommon/js/messages.js' language='javascript'></script> -->
	<script src="../js/Workplace.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<form name='frm_workplace_list' id='frm_workplace_list'>
<table border='0' cellpadding='0' cellspacing='0' align='center' width="90%">
<%
try{
	String query = "select work_cycle_basis from rs_parameter where nvl(facility_id,'!!') in (select facility_id from  rs_parameter where facility_id = ? union select '!!' from dual where not exists (select facility_id from rs_parameter where facility_id = ?))";
	String cntQuery = "select count(*) from rs_parameter where nvl(facility_id,'!!') in (select facility_id from  rs_parameter where facility_id = ? union select '!!' from dual where not exists (select facility_id from rs_parameter where facility_id = ?))";

	pstmt = conn.prepareStatement(cntQuery);
	pstmt.setString(1,facility_id);
	pstmt.setString(2,facility_id);

	int count=0;
	rs = pstmt.executeQuery();
	while(rs.next())
	{
	count = rs.getInt(1);
	}
	if (pstmt != null) pstmt.close();
    if (rs != null)   rs.close();

	if(count == 0)
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);history.go(-1);</script>");

	if(count > 0)
	{
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,facility_id);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			week_day = rs.getString("work_cycle_basis");
		}
	}
      if (pstmt != null) pstmt.close();
	  if (rs != null)   rs.close();
	
	//write code here to check the week_code variable and display the weeks...
	//week_day = "2W";
	num = Integer.parseInt(week_day.substring(0,1));
	ch = week_day.charAt(1);

	if(ch == 'M')
	{
		week_count = 5;
		week_basis = "Monthly";
	}
	else
	{
		week_count = num;
		week_basis = String.valueOf(num) + " Weekly";
	}


%>
	<tr>
		<td colspan="2">&nbsp</td>
	</tr>
	<tr>
		<td class='label' width="60%"><b> &nbsp;<fmt:message key="eRS.OperatingDaysApplicabilityfortheWorkCycle.label" bundle="${rs_labels}"/></b></td>
		<td width="40%" align='left' class='label'> <b> <%= week_basis %> </b></td>
	</tr>
	</table>
	<table border='0' cellpadding='0' cellspacing='0' align='center' width="90%">
	<tr>
		<td colspan="8">&nbsp</td>
	</tr>
	<tr>
		<td width="30%"></td>
		<%
			for(int i=0;i<week_vector.size();i++)
			{

				out.print("<td class='label' width='10%'><b>"+week_vector.get(i)+"</b></td>"); 
			}
		%>	
	</tr>
	
	<tr>
		<td class='label' width="30%" align='center'><b> <fmt:message key="Common.Default.label" bundle="${common_labels}"/> </b></td>
		<td width="10%">
			<select name='def_mon' id='def_mon' onchange='makeDef(this)'>
				<option value='W'><fmt:message key="eRS.WDay.label" bundle="${rs_labels}"/></option>
				<option value='N'><fmt:message key="eRS.NWDay.label" bundle="${rs_labels}"/></option>
				<option value='H'><fmt:message key="eRS.HDay.label" bundle="${rs_labels}"/></option>
			</select>
		</td>
		<td width="10%">
			<select name='def_tue' id='def_tue' onchange='makeDef(this)'>
				<option value='W'><fmt:message key="eRS.WDay.label" bundle="${rs_labels}"/></option>
				<option value='N'><fmt:message key="eRS.NWDay.label" bundle="${rs_labels}"/></option>
				<option value='H'><fmt:message key="eRS.HDay.label" bundle="${rs_labels}"/></option>
			</select>
		</td>
		<td width="10%"> 
			<select name='def_wed' id='def_wed' onchange='makeDef(this)'>
				<option value='W'><fmt:message key="eRS.WDay.label" bundle="${rs_labels}"/></option>
				<option value='N'><fmt:message key="eRS.NWDay.label" bundle="${rs_labels}"/></option>
				<option value='H'><fmt:message key="eRS.HDay.label" bundle="${rs_labels}"/></option>
			</select>
		</td>
		<td width="10%">
			<select name='def_thu' id='def_thu' onchange='makeDef(this)'>
				<option value='W'><fmt:message key="eRS.WDay.label" bundle="${rs_labels}"/></option>
				<option value='N'><fmt:message key="eRS.NWDay.label" bundle="${rs_labels}"/></option>
				<option value='H'><fmt:message key="eRS.HDay.label" bundle="${rs_labels}"/></option>
			</select>
		</td>
		<td width="10%">
			<select name='def_fri' id='def_fri' onchange='makeDef(this)'>
				<option value='W'><fmt:message key="eRS.WDay.label" bundle="${rs_labels}"/></option>
				<option value='N'><fmt:message key="eRS.NWDay.label" bundle="${rs_labels}"/></option>
				<option value='H'><fmt:message key="eRS.HDay.label" bundle="${rs_labels}"/></option>
			</select>
		</td>
		<td width="10%">
			<select name='def_sat' id='def_sat' onchange='makeDef(this)'>
				<option value='W'><fmt:message key="eRS.WDay.label" bundle="${rs_labels}"/></option>
				<option value='N'><fmt:message key="eRS.NWDay.label" bundle="${rs_labels}"/></option>
				<option value='H'><fmt:message key="eRS.HDay.label" bundle="${rs_labels}"/></option>
			</select>
		</td>
		<td width="10%">
			<select name='def_sun' id='def_sun' onchange='makeDef(this)'>
				<option value='W'><fmt:message key="eRS.WDay.label" bundle="${rs_labels}"/></option>
				<option value='N'><fmt:message key="eRS.NWDay.label" bundle="${rs_labels}"/></option>
				<option value='H'><fmt:message key="eRS.HDay.label" bundle="${rs_labels}"/></option>
			</select>
		</td>
	</tr>

<%
	

	for(int j=1;j<=week_count;j++)
	{
		%>
		<tr>		
			<td class='label' width="30%" align='center'><b> <fmt:message key="Common.Week.label" bundle="${common_labels}"/><%= j %> </b></td>
		<%
		for(int k=1;k<=7;k++)
		{
			%>
			<td>
				<select name="week_<%=j%>_day_<%=k%>" id="week_<%=j%>_day_<%=k%>">
					<option value='W'><fmt:message key="eRS.WDay.label" bundle="${rs_labels}"/></option>
					<option value='N'><fmt:message key="eRS.NWDay.label" bundle="${rs_labels}"/></option>
					<option value='H'><fmt:message key="eRS.HDay.label" bundle="${rs_labels}"/></option>
				</select>
			</td>
			<%
		}
		%>
		</tr>
		<%
	}
}catch(Exception e)
{
	out.println(e.getMessage());
	e.printStackTrace();
}
finally {
	  if (pstmt != null) pstmt.close();
	  if (rs != null)   rs.close();
	  ConnectionManager.returnConnection(conn,request);
	}
%>
<input type='hidden' name='noOfWeeks' id='noOfWeeks' value='<%= num %>'>
<input type='hidden' name='locn_type' id='locn_type' value=''>
<input type='hidden' name='workplace_code' id='workplace_code' value=''>
<input type='hidden' name='workplace_desc' id='workplace_desc' value=''>
<input type='hidden' name='wday_from_hh' id='wday_from_hh' value=''>
<input type='hidden' name='wday_from_mm' id='wday_from_mm' value=''>
<input type='hidden' name='wday_to_hh' id='wday_to_hh' value=''>
<input type='hidden' name='wday_to_mm' id='wday_to_mm' value=''>
<input type='hidden' name='nwday_from_hh' id='nwday_from_hh' value=''>
<input type='hidden' name='nwday_from_mm' id='nwday_from_mm' value=''>
<input type='hidden' name='nwday_to_hh' id='nwday_to_hh' value=''>
<input type='hidden' name='nwday_to_mm' id='nwday_to_mm' value=''>
<input type='hidden' name='hday_from_hh' id='hday_from_hh' value=''>
<input type='hidden' name='hday_from_mm' id='hday_from_mm' value=''>
<input type='hidden' name='hday_to_hh' id='hday_to_hh' value=''>
<input type='hidden' name='hday_to_mm' id='hday_to_mm' value=''>
<input type='hidden' name='staff_util' id='staff_util' value=''>
<input type='hidden' name='eff_status' id='eff_status' value=''>
<input type='hidden' name='facility_id' id='facility_id' value='<%= facility_id %>'>
<input type='hidden' name='bean_id' id='bean_id' value='<%= bean_id %>'>
<input type='hidden' name='bean_name' id='bean_name' value='<%= bean_name %>'>
<input type='hidden' name='mode' id='mode' value='<%= mode %>'>
<input type='hidden' name='work_cycle_basis' id='work_cycle_basis' value='<%= week_day %>'>
</form>
</body>
</html>

