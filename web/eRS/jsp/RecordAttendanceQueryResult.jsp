<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 			:	
*	Created By		:	Subbulakshmky. k
*	Created On		:	29 Nov 2004
--%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%
	String facility_id = (String)session.getAttribute("facility_id");
	String workplace_code = request.getParameter( "workplace_code" )==null?"":request.getParameter( "workplace_code" );
	String role_type = request.getParameter( "role_type" )==null?"":request.getParameter( "role_type" );
	String staff_id = request.getParameter( "staff_id" )==null?"":request.getParameter( "staff_id" );
	String shift_code = request.getParameter( "shift_code" )==null?"":request.getParameter( "shift_code" );
	String max_duration_in_mints=request.getParameter("max_duration_in_mints")==null?"":request.getParameter( "max_duration_in_mints" );

	Connection conn 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;

	ArrayList Staff_Data		= new ArrayList();

	String[] record				= null;
	//String sql_shift="Select a.facility_id, a.workplace_code, a.role_type, a.staff_id, to_char(a.schedule_date,'dd/mm/yyyy')schedule_date , a.shift_code, to_char(a.shift_start_time,'hh24:mm') shift_start_time, to_char(a.shift_end_time,'hh24:mm') shift_end_time, to_char(a.user_step_in_time,'hh24:mm') step_in_time, to_char(a.user_step_out_time,'hh24:mm') step_out_time, b.short_desc shift_desc, c.position_desc, nvl(d.practitioner_name,e.other_staff_name) staff_name  From rs_work_Schedule a, am_shift b, am_position c, am_practitioner d, am_other_staff e  Where a.facility_id = ? And a.workplace_code = ? And (? is null or a.role_type = ?) And (? is null or a.staff_id = ?)And a.schedule_date = a.schedule_date And ( ? is null or a.shift_code = ?) And b.shift_code = a.shift_code And c.position_code = a.position_code And d.practitioner_id(+) = a.staff_id And e.other_staff_id(+) = a.staff_id and a.schedule_date = trunc(sysdate) order by shift_desc, a.role_type, c.position_desc, staff_name";
	String sql_shift="Select a.facility_id, a.workplace_code, a.role_type, a.staff_id, to_char(a.schedule_date,'dd/mm/yyyy')schedule_date , a.shift_code, to_char(a.shift_start_time,'hh24:mm') shift_start_time, to_char(a.shift_end_time,'hh24:mm') shift_end_time, to_char(a.user_step_in_time,'hh24:mm') step_in_time, to_char(a.user_step_out_time,'hh24:mm') step_out_time, b.short_desc shift_desc, c.position_desc, nvl(d.practitioner_name,e.other_staff_name) staff_name  From rs_work_Schedule a, am_shift_lang_vw b, am_position_lang_vw c, am_practitioner_lang_vw d, am_other_staff_lang_vw e  Where a.facility_id = ? And a.workplace_code = ? And (? is null or a.role_type = ?) And (? is null or a.staff_id = ?)And a.schedule_date = a.schedule_date And ( ? is null or a.shift_code = ?) And b.shift_code = a.shift_code And c.position_code = a.position_code And d.practitioner_id(+) = a.staff_id And e.other_staff_id(+) = a.staff_id and a.schedule_date = trunc(sysdate) and b.language_id = ? and c.language_id = ? and d.language_id(+) = ? and e.language_id(+) = ? order by shift_desc, a.role_type, c.position_desc, staff_name";

	conn = ConnectionManager.getConnection(request);
	
	try {
		//to get the shift data
		pstmt = conn.prepareStatement( sql_shift);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,workplace_code);
		pstmt.setString(3,role_type);
		pstmt.setString(4,role_type);
		pstmt.setString(5,staff_id);
		pstmt.setString(6,staff_id);
		pstmt.setString(7,shift_code);
		pstmt.setString(8,shift_code);
		pstmt.setString(9,locale);
		pstmt.setString(10,locale);
		pstmt.setString(11,locale);
		pstmt.setString(12,locale);
		resultSet = pstmt.executeQuery();
	
		while (resultSet != null && resultSet.next()) 
		{
			record = new String[13];				
			record[0] = resultSet.getString("facility_id");
			record[1] = resultSet.getString("workplace_code");
			record[2] = resultSet.getString("role_type");
			record[3] = resultSet.getString("staff_id");
			record[4] = resultSet.getString("schedule_date");
			record[5] = resultSet.getString("shift_code");
			record[6] = resultSet.getString("shift_start_time");
			record[7] = resultSet.getString("shift_end_time");
			record[8] = resultSet.getString("step_in_time");
			record[9] = resultSet.getString("step_out_time");
			record[10] = resultSet.getString("shift_desc");
			record[11] = resultSet.getString("position_desc");
			record[12] = resultSet.getString("staff_name");
			Staff_Data.add(record) ;
		}
		
		
		if(pstmt != null) pstmt.close() ;
		if(resultSet != null) resultSet.close() ;
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} finally {
		if(pstmt != null) pstmt.close() ;
		if(resultSet != null) resultSet.close() ;
		ConnectionManager.returnConnection(conn,request);
	}
%>

	<html>
	<head>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<!-- <script language="javascript" src="../js/RSMessages.js"></script> -->
		<script language="javascript" src="../js/RecordAttendance.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../js/RSCommon.js"></script>
		<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
	</head>
<% 
	if(Staff_Data.size()>0)
	{		
%>
			<body onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
			<form name='form_RAQueryResult' id='form_RAQueryResult' action='../../servlet/eRS.RecordAttendanceServlet' method='POST' target='messageFrame'>
				<table cellpadding=0 cellspacing=0 border='1' width="100%" align=center>
<% 
		shift_code="";
		String classvalue="";
		for(int i=0; i<Staff_Data.size();i++){
				if (  i % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;

			record=(String[])Staff_Data.get(i);
			if(!(shift_code.equals(record[5]))){
%>
				<tr><td class='label' width='10%'><b><fmt:message key="Common.SHIFT.label" bundle="${common_labels}"/>:</b></td>
						<td class='label' width='15%'><%=record[10]%></td>
						<td class='label' width='10%'><b><fmt:message key="eRS.Timings.label" bundle="${rs_labels}"/>:</b></td>
						<td class='label'  colspan='4'> <b><fmt:message key="Common.from.label" bundle="${common_labels}"/></b>&nbsp;&nbsp;<%=record[6]%>&nbsp;&nbsp;
								<b><fmt:message key="Common.to.label" bundle="${common_labels}"/></b>&nbsp;&nbsp;<%=record[7]%></td>
				</tr>
				<tr><th width='10%'><fmt:message key="Common.Role.label" bundle="${common_labels}"/></th>
						<th width='15%'><fmt:message key="Common.Position.label" bundle="${common_labels}"/></th>
						<th width='10%'><fmt:message key="eRS.StaffId.label" bundle="${rs_labels}"/></th>
						<th width='35%'><fmt:message key="eRS.StaffName.label" bundle="${rs_labels}"/></th>
						<th width='10%'><fmt:message key="eRS.StepIn.label" bundle="${rs_labels}"/></th>
						<th width='10%'><fmt:message key="eRS.StepOut.label" bundle="${rs_labels}"/></th>
						<th width='10%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
				</tr>
<%
			}
			shift_code=record[5];
			String role="";
			if(record[2].equals("P"))
				role="Practitioner";
			else
				role="OtherStaff";
%>
			<tr><td class='<%=classvalue%>' width='10%'><%=role%></td>
					<input type='hidden' name='role_type<%=i%>' id='role_type<%=i%>' value='<%=record[2]%>'>
					<td class='<%=classvalue%>' width='15%'><%=record[11]%></td>
					<td class='<%=classvalue%>' width='10%'><%=record[3]%></td>
					<input type='hidden' name='staff_id<%=i%>' id='staff_id<%=i%>' value='<%=record[3]%>'>
					<input type='hidden' name='schedule_date<%=i%>' id='schedule_date<%=i%>' value='<%=record[4]%>'>
					<input type='hidden' name='shift_code<%=i%>' id='shift_code<%=i%>' value='<%=record[5]%>'>
					<input type='hidden' name='shift_start_time<%=i%>' id='shift_start_time<%=i%>' value='<%=record[6]%>'>
					<input type='hidden' name='shift_end_time<%=i%>' id='shift_end_time<%=i%>' value='<%=record[7]%>'>
					<td class='<%=classvalue%>' width='35%'><%=record[12]%></td>
<%
					String readonly="";
					if(record[8]==null){
%>
						<td class='<%=classvalue%>' width='10%'><input type='text' size='2' maxlength='2' name='stepin_hh<%=i%>' id='stepin_hh<%=i%>' onkeypress='return allowPositiveNumber();' onblur='return CheckForHours(this);'>:<input type='text' size='2' maxlength='2' name='stepin_mm<%=i%>' id='stepin_mm<%=i%>'  onkeypress='return allowPositiveNumber();' onblur='return CheckForMinutes(this);'></td>
<%
					}
					else{
						readonly="readonly";
						String stepin_hh=record[8].substring(0,2);
						String stepin_mm=record[8].substring(3);	
%>		
						<td class='<%=classvalue%>' width='10%'><input type='text' size='2' name='stepin_hh<%=i%>' id='stepin_hh<%=i%>' <%=readonly%> value='<%=stepin_hh%>'>:<input type='text' size='2' name='stepin_mm<%=i%>' id='stepin_mm<%=i%>'  <%=readonly%> value='<%=stepin_mm%>'></td>
<%
						readonly="";
					}
					if(record[9]==null){
%>
						<td class='<%=classvalue%>' width='10%'><input type='text' size='2' maxlength='2' name='stepout_hh<%=i%>' id='stepout_hh<%=i%>'  onkeypress='return allowPositiveNumber();' onblur='return CheckForHours(this);' <%=readonly%>>:<input type='text' size='2' maxlength='2' name='stepout_mm<%=i%>' id='stepout_mm<%=i%>'  onkeypress='return allowPositiveNumber();' onblur='return CheckForMinutes(this);' <%=readonly%>></td>
						<td class='<%=classvalue%>' width='10%' align='center'><input type='checkbox' name='select_yn<%=i%>' id='select_yn<%=i%>' value='N' onclick='onSelect(this);'></td>
<%
					}
					else{
						readonly="readonly";
						String stepout_hh=record[9].substring(0,2);
						String stepout_mm=record[9].substring(3);	
%>		
						<td class='<%=classvalue%>' width='10%'><input type='text' size='2' name='stepout_hh<%=i%>' id='stepout_hh<%=i%>' <%=readonly%> value='<%=stepout_hh%>'>:<input type='text' size='2' name='stepout_mm<%=i%>' id='stepout_mm<%=i%>'  <%=readonly%> value='<%=stepout_mm%>'></td>
						
						<td class='<%=classvalue%>' width='10%' align='center'><input type='checkbox' name='select_yn<%=i%>' id='select_yn<%=i%>' value='N' disabled onclick='onSelect(this);'></td>
					
<%				}
				}
%>
				</table>
				<input type='hidden' name='max_duration_in_mints' id='max_duration_in_mints' value='<%=max_duration_in_mints%>'>
				<input type='hidden' name='totalRecords' id='totalRecords' value='<%=Staff_Data.size()%>'>
				<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
				<input type='hidden' name='workplace_code' id='workplace_code' value='<%=workplace_code%>'>
			</form>
			</body>
<% 
		}
		else
		{
			%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);
	</script>
	<%
		}
%>
</html>

