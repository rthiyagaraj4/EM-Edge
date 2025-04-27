<!DOCTYPE html>
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	ManageWorkSheduleCriteriaByWorkplace.jsp
*	Purpose 			:
*	Created By		:	Subbulakshmy. K
*	Created On		:	17-12-2004
*/
%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
<script language="javascript" src="../js/RSCommon.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eRS/js/ManageWorkSchedule.js"></script>
<!-- <script language="javascript" src="../../eRS/js/RSMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<%
	String mode	   = request.getParameter("mode")==null?"":request.getParameter("mode");
	String p_mode	   = request.getParameter("p_mode")==null?"":request.getParameter("p_mode");
	String facility_id = (String)session.getAttribute("facility_id")==null?"":(String)session.getAttribute("facility_id");
	String user_id = (String)session.getValue("login_user")==null?"":(String)session.getAttribute("login_user");
	String function_id = request.getParameter( "function_id") ==null?"":request.getParameter("function_id");
	String p_locn_type = request.getParameter( "p_locn_type") ==null?"":request.getParameter("p_locn_type");
	String p_locn_code = request.getParameter( "p_locn_code") ==null?"":request.getParameter("p_locn_code");
	String workplace_code="", workplace_desc="";
	boolean flag=false;
	//System.err.println("facility_id----|" +facility_id+ "|----p_locn_type---|" +p_locn_type+ "|----p_locn_code---|" +p_locn_code+ "|---workplace_code--|" +workplace_code+ "|---workplace_desc---|" +workplace_desc+ "|---");

	Connection conn 		= null;

	PreparedStatement pstmt 	= null;
	PreparedStatement pstmt_currdate 	= null;

	ResultSet resultSet 		= null;
	ResultSet rs_currdate 		= null;

	ArrayList Locn_Data		= new ArrayList();
	String[] record				= null;
	String currentdate="";
	String sql_locn="Select locn_type, short_desc from am_care_locn_type order by short_desc";

	conn = ConnectionManager.getConnection(request);
	try {

		pstmt_currdate=conn.prepareStatement("select to_char(sysdate,'dd/mm/yyyy') d from dual ");
		rs_currdate=pstmt_currdate.executeQuery();
		rs_currdate.next();
		currentdate = rs_currdate.getString("d");
		if(pstmt_currdate!=null)
			pstmt_currdate.close();
		if(rs_currdate!=null)
			rs_currdate.close();

		//to get the locantion type
		pstmt = conn.prepareStatement( sql_locn);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			record = new String[2];				
			record[0] = resultSet.getString("locn_type");
			record[1] = resultSet.getString("short_desc");
			Locn_Data.add(record) ;
		}
		if(pstmt!=null)
			pstmt.close();
		if(resultSet!=null)
			resultSet.close();
%>
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<form name=form_ManageWorkScheduleCriteria>
	<table border='0' cellpadding='0' cellspacing='0' align='left' width="100%">
		<tr>
			<td class='label' width='12%' align='right'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
			<td width='20%' align='left'>&nbsp;<select name="locn_type" id="locn_type" onchange='locn_change();'>
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
			<td colspan='3'>&nbsp;</td>
			<td class='label' colspan='3' align='left'><!-- Work Cycle Basis -->&nbsp;<b><%/*=week_basis*/%></b></td>
		</tr>
<%
		if(p_mode.equals("CA")){
			String sql_wrkplace="";
			//System.err.println("if condition sql_wrkplace 107 in jsp----->" +sql_wrkplace);
			//to get the wrkplace code
			if(p_locn_type.equals("IP") || p_locn_type.equals("DC")){
				//System.err.println("inner if condition sql_wrkplace 107 in jsp----->" +sql_wrkplace);
				sql_wrkplace="select workplace_code from rs_locn_for_workplace where facility_id = ? and locn_code = (select nursing_unit_code  from ip_nursing_unit	  where facility_id = ? and nursing_unit_code = ?)";
				flag=true;
			}
			else 

				if(p_locn_type.equals("OP") || p_locn_type.equals("EM")){
					sql_wrkplace="select workplace_code  from rs_locn_for_workplace where facility_id = ? and locn_code = (select clinic_code from op_clinic where facility_id = ? and clinic_code = ?)";
					flag=true;
			}
			if(flag){
				pstmt = conn.prepareStatement( sql_wrkplace);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,facility_id);
				pstmt.setString(3,p_locn_code);
				resultSet = pstmt.executeQuery() ;
				while (resultSet != null && resultSet.next()) {
					workplace_code = resultSet.getString("workplace_code")==null?"":resultSet.getString("workplace_code");
				}
				if(pstmt!=null)
					pstmt.close();
				if(resultSet!=null)
					resultSet.close();
			}
			//to get the workplace description
			if(!workplace_code.equals("")){
				String sql_workplace_desc="select workplace_desc  from rs_workplace where facility_id = ? and workplace_code = ?";
				pstmt = conn.prepareStatement( sql_workplace_desc);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,workplace_code);
				resultSet = pstmt.executeQuery() ;
				while (resultSet != null && resultSet.next()) {
					workplace_desc = resultSet.getString("workplace_desc")==null?"":resultSet.getString("workplace_desc");
				}
				if(pstmt!=null)
					pstmt.close();
				if(resultSet!=null)
					resultSet.close();
			}
%>
		<tr >
			<td class='label' width='12%' align='right'><fmt:message key="eRS.WorkPlace.label" bundle="${rs_labels}"/></td>
			<td width='20%' align='left'>&nbsp;<input name='workplace_desc' id='workplace_desc' type='text' size='20' readonly value='<%=workplace_desc%>' ><input class='button' type=button name="workplaceLookup" id="workplaceLookup" value="?" disabled>&nbsp;<img src="../../eCommon/images/mandatory.gif"> 
			<input type='hidden' name='workplace_code' id='workplace_code' value='<%=workplace_code%>'>
			</td>
<%
		}
		else{
			//System.err.println("else block");
%>
		<tr >
			<td class='label' width='12%' align='right'><fmt:message key="eRS.WorkPlace.label" bundle="${rs_labels}"/></td>
			<td width='20%' align='left'>&nbsp;<input name='workplace_desc' id='workplace_desc' type='text' size='35' maxlength='30' onblur="selectWorplace('T',this)"><input class='button' type=button name="workplaceLookup" id="workplaceLookup" value="?" Onclick="selectWorplace('B',workplace_desc)">&nbsp;<img src="../../eCommon/images/mandatory.gif"> 
			<input type='hidden' name='workplace_code' id='workplace_code' value=''>
			</td>
<%
		 }
%>
			<td class='label' width='12%' align='right'><fmt:message key="Common.RoleType.label" bundle="${common_labels}"/></td>
			<td width='20%' align='left'>&nbsp;<select name="role_type" id="role_type" onchange='role_change();'>
				<option value='' selected>-- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -- </option>
						<option value='P'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
						<option value='O'><fmt:message key="Common.OtherStaff.label" bundle="${common_labels}"/></option>
				</select></td>
			<td colspan='3'>&nbsp;</td>
		</tr>
		<tr>
			<td class='label' width='12%' align='right'><fmt:message key="eRS.StaffType.label" bundle="${rs_labels}"/></td>
			<td width='20%' align='left'>&nbsp;<select name="staff_type" id="staff_type" onchange='stafftype_change();'>
				<option value='' selected>---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---- </option></select></td>
		<td class='label' width='12%' align='right'><fmt:message key="Common.Position.label" bundle="${common_labels}"/></td>
		<td width='20%' align='left'>&nbsp;<select name='position' id='position' onchange='position_change();'>
				<option value='' selected>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---- </option></select></td>
		<td colspan='3'>&nbsp;</td>
		</tr>
		<tr>
			<td class='label' width='12%' align='right'><fmt:message key="eRS.Staff.label" bundle="${rs_labels}"/> </td>
			<td width='20%' align='left'>&nbsp;<input name='staff_id' id='staff_id' type='text' size='20' maxlength='10' readonly><input class='button' type=button name="staffIDLookup" id="staffIDLookup" value="?" Onclick="selectStaffID(staff_id)"></td>
			<input type='hidden' name='staff_name' id='staff_name' value=''>
			<td colspan='5'>&nbsp;</td>
		</tr>
		</tr><tr>
			<td class='label' width='12%' align='right'><fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.date.label" bundle="${common_labels}"/> </td>
			<td width='20%' align='left'>&nbsp;<input name='frmdate' id='frmdate' id='id_frmdate' type='text' size='8' maxlength='10' value='' onBlur="CheckDate(this), checkFromDate();" onKeyPress='return AllowDateFormat();'><img  name='frmdate_img' src='../../eCommon/images/CommonCalendar.gif' onclick="return showCal(frmdate,'id_frmdate');">&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
			<td class='label' width='12%' align='right'><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.date.label" bundle="${common_labels}"/> </td>
			<td width='20%' align='left'>&nbsp;<input name='todate' id='todate' id='id_todate' type='text' size='8' maxlength='10' value='' onBlur='CheckDate(this), checkToDate();' onKeyPress='return AllowDateFormat();'><img  name='frmdate_img' src='../../eCommon/images/CommonCalendar.gif' onclick="return showCal(todate,'id_todate');">&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
			<td colspan='2'>&nbsp;</td>
			<td  align='right'><input type='button' class='button' value='<fmt:message key="eRS.ShowDetails.label" bundle="${rs_labels}"/>'onclick='showDetails();'></td>
		</tr>
	</table>
	<input type='hidden' name='mode' id='mode'  value='<%=mode%>'>
	<input type='hidden' name='facility_id' id='facility_id'  value='<%=facility_id%>'>
	<input type='hidden' name='locale' id='locale'  value='<%=locale%>'>
	<input type='hidden' name='user_id' id='user_id'  value='<%=user_id%>'>
	<input type='hidden' name='function_id' id='function_id'  value='<%=function_id%>'>
	<input type='hidden' name='form_name' id='form_name' value='form_ManageWorkScheduleCriteria'>
	<input type='hidden' name='DAYS' id='DAYS'  value='14'>
	<input type='hidden' name='sys_date' id='sys_date' value='<%=currentdate%>'>
	
</form>
</body>
<%
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	}
	finally {
		try
		{
		if(pstmt_currdate!=null)
			pstmt_currdate.close();
		if(rs_currdate!=null)
			rs_currdate.close();
		if(pstmt!=null)
			pstmt.close();
		if(resultSet!=null)
			resultSet.close();
		ConnectionManager.returnConnection(conn,request);
		}
		catch(Exception exp)
		{
			out.println(exp.toString());
		}
	}
%>
</html>

