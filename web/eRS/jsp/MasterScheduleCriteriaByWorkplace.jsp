<!DOCTYPE html>
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	MasterSheduleCriteriaByWorkplace.jsp
*	Purpose 			:
*	Created By		:	Subbulakshmy. K
*	Created On		:	24-11-2004
*/
%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,eRS.*,java.sql.*,webbeans.eCommon.*"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="JavaScript" src="../../eRS/js/MasterSchedule.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../js/RSCommon.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%  
	String mode	   = request.getParameter("mode") ;
	String facility_id = (String)session.getAttribute("facility_id");
	String user_id = (String)session.getValue("login_user");
	String function_id = request.getParameter( "function_id") ;
	Connection conn 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	ArrayList Locn_Data		= new ArrayList();
	String[] record				= null;
	String work_cycle="";
	String week_basis="";
	int week_count=0;
	String sql_locn="Select locn_type, short_desc from am_care_locn_type order by short_desc";

	String sql_work_cycle="select facility_id,work_cycle_basis from rs_parameter where facility_id in   (select facility_id from rs_parameter where facility_id = ?  union select facility_id from rs_parameter   where facility_id = '*A' and not exists (select facility_id from rs_parameter where facility_id = ?))";

	conn =  ConnectionManager.getConnection(request);
	try {
		//to get the locantion type
		pstmt = conn.prepareStatement( sql_locn);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			record = new String[2];				
			record[0] = resultSet.getString("locn_type");
			record[1] = resultSet.getString("short_desc");
			Locn_Data.add(record) ;
		}
		if(pstmt != null)
			pstmt.close();
		if(resultSet != null)
			resultSet.close();

		//to get work_cycle_basis
		pstmt = conn.prepareStatement( sql_work_cycle);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,facility_id);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			work_cycle=resultSet.getString("work_cycle_basis");
		}
		if(pstmt != null)
			pstmt.close();
		if(resultSet != null)
			resultSet.close();
		week_count = Integer.parseInt(work_cycle.substring(0,1));
		char ch = work_cycle.charAt(1);
		if(ch == 'M'){
			week_count = 5;
			week_basis = "Monthly";
		}
		else{
			week_basis = String.valueOf(week_count) + " Weekly";
		}
%>
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<form name=form_byWorkplace>
	<table border='0' cellpadding='0' cellspacing='0' align='left' width="100%">
		<tr>
			<td class='label' width='12%' align='right'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
			<td width='23%' align='left'>&nbsp;<select name="locn_type" id="locn_type" onchange='locn_change();'>
				<option value='' selected>---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---- </option>
<%
						for(int i=0; i<Locn_Data.size();i++){
							record=(String[])Locn_Data.get(i);
%>
						<option value=<%=record[0]%>><%=record[1]%></option>
<%
					}
%>					
				</select></td>
			<td colspan=2>&nbsp;</td>
			<td class='label' width='15%' align='right'><fmt:message key="eRS.WorkCycleBasis.label" bundle="${rs_labels}"/></td>
			<td class='label' width='15%' align='left'><b>&nbsp;<%=week_basis%></b></td>
		</tr>
		<tr >
			<td class='label' width='12%' align='right'><fmt:message key="eRS.Workplace.label" bundle="${rs_labels}"/></td>
			<td width='23%' align='left'>&nbsp;<input name='workplace_desc' id='workplace_desc' type='text' size='35' maxlength='30' Onblur='selectWorplace("T",workplace_desc);'><input class='button' type=button name="workplaceLookup" id="workplaceLookup" value="?" Onclick="selectWorplace('B',workplace_desc);">&nbsp;<img src="../../eCommon/images/mandatory.gif">	
			<input type='hidden' name='workplace_code' id='workplace_code' value=''>
			</td>
			<td class='label' width='12%' align='right'><fmt:message key="eRS.Requirement.label" bundle="${rs_labels}"/></td>
			<td width='23%' align='left'>&nbsp;<input name='requirement_id' id='requirement_id' type='text' size='20' maxlength='10' onblur='selectRequirement("T", requirement_id);displayDateRange(req_data);'><input class='button' type=button name='requirementLookup' id='requirementLookup' value='?' onclick='selectRequirement("B", requirement_id);displayDateRange(req_data);'>&nbsp;<img src='../../eCommon/images/mandatory.gif'>
			<input type='hidden' name='requirement_desc' id='requirement_desc' value=''></td>
			<input type='hidden' name='date_range' id='date_range' value=''></td>
			 <td id='req_data' class='label' colspan='2' width='15%' align='left' ></td>
			</div>
		</tr>
		<tr>
			<td class='label' width='12%' align='right'><fmt:message key="Common.RoleType.label" bundle="${common_labels}"/></td>
			<td width='23%' align='left'>&nbsp;<select name="role_type" id="role_type" onchange='role_change();'>
				<option value='' selected>-- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -- </option>
						<option value='P'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
						<option value='O'><fmt:message key="Common.OtherStaff.label" bundle="${common_labels}"/></option>
				</select></td>
			<td class='label' width='12%' align='right'><fmt:message key="eRS.StaffType.label" bundle="${rs_labels}"/></td>
			<td width='23%' align='left'>&nbsp;<select name="staff_type" id="staff_type" onchange='stafftype_change();'>
				<option value='' selected>---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---- </option></select></td>
			<td colspan='2'></td>
		</tr>
		<tr>
		<td class='label' width='12%' align='right'><fmt:message key="Common.Position.label" bundle="${common_labels}"/></td>
		<td width='23%' align='left'>&nbsp;<select name='position' id='position' onchange='position_change();'>
				<option value='' selected>---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---- </option></select></td>
		<td class='label' width='12%' align='right'><fmt:message key="eRS.StaffID.label" bundle="${rs_labels}"/></td>
		<td width='23%' align='left'>&nbsp;<input name='staff_id' id='staff_id' type='text' size='20' maxlength='10' readonly><input class='button' type=button name="staffIDLookup" id="staffIDLookup" value="?" Onclick='selectStaffID(staff_id);'></td>
		<input type='hidden' name='staff_name' id='staff_name' value=''>
		<td class='label' width='15%' align='right'><b><fmt:message key="Common.view.label" bundle="${common_labels}"/></b></td>
			<td class='label' width='15%' align='left'>&nbsp;<select name='view' id='view'>
					<option value='all' selected><fmt:message key="eRS.AllStaff.label" bundle="${rs_labels}"/></option>
					<option value='aloc'><fmt:message key="eRS.AllocatedStaff.label" bundle="${rs_labels}"/></option></td>
		</tr>
		<tr><td colspan=5>&nbsp;</td>
			<td><input type='button' class='button' value='<fmt:message key="eRS.ShowDetails.label" bundle="${rs_labels}"/>'onclick='showDetails();'></td>
		</tr>
	</table>
	<input type='hidden' name='mode' id='mode'  value='<%=mode%>'>
	<input type='hidden' name='facility_id' id='facility_id'  value='<%=facility_id%>'>
	<input type='hidden' name='user_id' id='user_id'  value='<%=user_id%>'>
	<input type='hidden' name='function_id' id='function_id'  value='<%=function_id%>'>
	<input type='hidden' name='form_name' id='form_name' value='form_byWorkplace'>
	<input type='hidden' name='week_count' id='week_count'  value='<%=week_count%>'>
</form>
</body>
<%
	}catch( Exception e ){
		e.printStackTrace() ;
		throw e ;
	} 
	finally{
		resultSet.close() ;
		pstmt.close() ;
	   ConnectionManager.returnConnection(conn,request);
	}%>
</html>

