<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	
*	Created By		:	Suchilagna Panigrahi
*	Created On		:	17 Feb 2005
--%>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- <script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="JavaScript" src="../../eRS/js/ManageWorkScheduleOvertime.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	Connection conn = null;

	PreparedStatement pstmt_schedule_date = null;
	PreparedStatement pstmt_date_type = null;
	PreparedStatement pstmt_curr_overtime = null;
	PreparedStatement pstmt_reqid_v = null;
	PreparedStatement pstmt_reqid_c = null;
	PreparedStatement pstmt_shift_code = null;
	PreparedStatement pstmt_shift = null;
	PreparedStatement pstmt_reason = null;
	PreparedStatement pstmt_start_end_time = null;

	ResultSet rs_schedule_date = null;
	ResultSet rs_date_type = null;
	ResultSet rs_curr_overtime = null;
	ResultSet rs_reqid_v = null;
	ResultSet rs_reqid_c = null;
	ResultSet rs_shift_code = null;
	ResultSet rs_shift = null;
	ResultSet rs_reason = null;
	ResultSet rs_start_end_time = null;

	String p_facility_id  = request.getParameter("p_facility_id")==null?"":request.getParameter("p_facility_id");
	String p_workplace_code = request.getParameter("p_workplace_code")==null?"":request.getParameter("p_workplace_code");
	String p_date  = request.getParameter("p_date")==null?"":request.getParameter("p_date");
	int p_cell_no  = Integer.parseInt(request.getParameter("p_cell_no")==null?"":request.getParameter("p_cell_no"));
	String p_role_type  = request.getParameter("p_role_type")==null?"":request.getParameter("p_role_type");
	String p_staff_type  = request.getParameter("p_staff_type")==null?"":request.getParameter("p_staff_type");
	String p_staff_id  = request.getParameter("p_staff_id")==null?"":request.getParameter("p_staff_id");
	String p_position_code  = request.getParameter("p_position_code")==null?"":request.getParameter("p_position_code");
	String p_shift_code  = request.getParameter("p_shift_code")==null?"":request.getParameter("p_shift_code");
	String p_shift_mnemonic  = request.getParameter("p_shift_mnemonic")==null?"":request.getParameter("p_shift_mnemonic");
	String p_requirement_id = "";
	String date_type = "";
	String curr_shift_overtime_yn = "";
	String durn_for_overtime_from_sos = "";
	String p_schedule_date = "";
	Vector shift_list = new	Vector();

	try{
		conn = ConnectionManager.getConnection(request);

		String sql_schedule_date="select to_char(to_date(?,'dd/mm/yyyy') + ?,'dd/mm/yyyy') p_schedule_date from dual";
		pstmt_schedule_date=conn.prepareStatement(sql_schedule_date);
		pstmt_schedule_date.setString(1,p_date);
		pstmt_schedule_date.setInt(2,p_cell_no);
		rs_schedule_date = pstmt_schedule_date.executeQuery();

		while(rs_schedule_date!=null && rs_schedule_date.next()){
			p_schedule_date = rs_schedule_date.getString("p_schedule_date");
		}
		if(pstmt_schedule_date != null) 
			pstmt_schedule_date.close();
		if(rs_schedule_date != null)
			rs_schedule_date.close();
		String sql_date_type = "SELECT DECODE( SIGN(TRUNC(SYSDATE) - TO_DATE('2/8/2005','dd/mm/yyyy')),0,'C','F')date_type FROM dual";

		pstmt_date_type=conn.prepareStatement(sql_date_type);
		rs_date_type = pstmt_date_type.executeQuery();

		while(rs_date_type!=null && rs_date_type.next()){
			date_type = rs_date_type.getString("date_type");
		}
		if(pstmt_date_type != null)
			pstmt_date_type.close();
		if(rs_date_type != null)
			rs_date_type.close();

		String sql_curr_overtime="Select max_continuous_work_duration, curr_shift_overtime_yn, durn_for_overtime_from_sos from rs_parameter Where facility_id = ?";

		pstmt_curr_overtime = conn.prepareStatement(sql_curr_overtime);
		pstmt_curr_overtime.setString(1,p_facility_id);
		rs_curr_overtime = pstmt_curr_overtime.executeQuery();
		while(rs_curr_overtime.next() && rs_curr_overtime!=null){
			curr_shift_overtime_yn=rs_curr_overtime.getString("curr_shift_overtime_yn")==null ? "":rs_curr_overtime.getString("curr_shift_overtime_yn");
			durn_for_overtime_from_sos=rs_curr_overtime.getString("durn_for_overtime_from_sos") == null ? "":rs_curr_overtime.getString("durn_for_overtime_from_sos");
		}
		if(pstmt_curr_overtime != null)
			pstmt_curr_overtime.close();
		if(rs_curr_overtime != null)
			rs_curr_overtime.close();

		String sql_requiredid_v="Select requirement_id from rs_workplace_requirement where facility_id = ? and workplace_code = ? and  requirement_type = 'V' and to_date(?,'dd/mm/yyyy') between requirement_date_fm and requirement_date_to";

		pstmt_reqid_v=conn.prepareStatement(sql_requiredid_v);
		pstmt_reqid_v.setString(1,p_facility_id);
		pstmt_reqid_v.setString(2,p_workplace_code);
		pstmt_reqid_v.setString(3,p_schedule_date);
		rs_reqid_v=pstmt_reqid_v.executeQuery();
		while(rs_reqid_v.next() && rs_reqid_v!=null){
			p_requirement_id=rs_reqid_v.getString("requirement_id");
		}
		if(pstmt_reqid_v != null) 
			pstmt_reqid_v.close();
		if(rs_reqid_v != null)
			rs_reqid_v.close();
		if(p_requirement_id.equals("")){
			String sql_requiredid_c="Select requirement_id from rs_workplace_requirement where facility_id = ? and workplace_code =? and requirement_type = 'C' and requirement_date_fm is null and requirement_date_to is null";
			pstmt_reqid_c=conn.prepareStatement(sql_requiredid_c);
			pstmt_reqid_c.setString(1,p_facility_id);
			pstmt_reqid_c.setString(2,p_workplace_code);
			rs_reqid_c=pstmt_reqid_c.executeQuery();
			while(rs_reqid_c.next() && rs_reqid_c!=null){
				p_requirement_id=rs_reqid_c.getString("requirement_id");
			}
			if(pstmt_reqid_c != null)
				pstmt_reqid_c.close();
			if(rs_reqid_c != null)
				rs_reqid_c.close();
		}
			
		//String sql_shift_code = "Select distinct a.shift_code,a.long_desc shift_desc,b.shift_mnemonic from am_shift a,rs_shift_for_workplace b where b.facility_id=? and a.shift_code In(";
		String sql_shift_code = "Select distinct a.shift_code,a.long_desc shift_desc,b.shift_mnemonic from am_shift_lang_vw a,rs_shift_for_workplace b where b.facility_id=? and a.language_id = ? and a.shift_code In(";
		StringTokenizer ShiftCode = new StringTokenizer(p_shift_code,"|");
		boolean flag = true;
		while(ShiftCode.hasMoreTokens()){
			if(!flag)
				sql_shift_code =sql_shift_code + ",";
			if(flag){
				sql_shift_code = sql_shift_code +"'" + (ShiftCode.nextToken().trim()) + "'";
				flag = false;
			}
			else{
				sql_shift_code =sql_shift_code + "'" + (ShiftCode.nextToken().trim()) + "'";
			}
		}
		StringTokenizer shift_mnemonic = new StringTokenizer(p_shift_mnemonic,"|");
		sql_shift_code =sql_shift_code	+	") and b.shift_mnemonic in(";
		flag	=	true;
		while(shift_mnemonic.hasMoreTokens()){				
			if(!flag)
			sql_shift_code	=sql_shift_code 	+ ",";
			if(flag){
				sql_shift_code	=sql_shift_code + "'"+(shift_mnemonic.nextToken().trim())+"'";
				flag	=	false;
			} 
			else{
				sql_shift_code	=sql_shift_code + "'"+(shift_mnemonic.nextToken().trim())+"'";
			}
		}
		sql_shift_code	=sql_shift_code	+ ") and a.shift_code=b.shift_code and a.shift_indicator = 'P' ";
		
		pstmt_shift_code = conn.prepareStatement(sql_shift_code);
		pstmt_shift_code.setString(1,p_facility_id);
		pstmt_shift_code.setString(2,locale);
		rs_shift_code = pstmt_shift_code.executeQuery();
		while(rs_shift_code.next() && rs_shift_code!=null)	{
			shift_list.add(rs_shift_code.getString("shift_code"));
			shift_list.add(rs_shift_code.getString("shift_desc"));
			shift_list.add(rs_shift_code.getString("shift_mnemonic"));
		}
		if(pstmt_shift_code != null)
			pstmt_shift_code.close();
		if(rs_shift_code != null)
			rs_shift_code.close();
%>
</head>
<body onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<form target='blankFrame' name="ManageWorkSchedule_Overtime" id="ManageWorkSchedule_Overtime" method='post' action='../../servlet/eRS.ManageWorkScheduleOvertimeServlet'>
	
<table cellpadding=0 cellspacing=0 border=0 width="103%" align='right'>
<tr>
	<td colspan='2'>&nbsp;</td>
	<td></td>
</tr>
<tr>
	<td class='querydata' align='right' width='30%'><fmt:message key="eRS.ScheduleDate.label" bundle="${rs_labels}"/></td>
	<td class='label' width='30%'>&nbsp;&nbsp;&nbsp;&nbsp;<%=p_schedule_date%></td>
	<td></td>
</tr>
	<tr>
	<td colspan='2'>&nbsp;</td>
	<td></td>
</tr>
<tr>
	<td class='label' align='right'><fmt:message key="Common.SHIFT.label" bundle="${common_labels}"/></td>
	<td>&nbsp;&nbsp;&nbsp;<select name="shift" id="shift" onChange='ChangeType(this.form,this);display(start_time)'>
			<option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
		
<%
		for(int i=0;i<shift_list.size();i +=3){
%>
		<option value='<%=shift_list.get(i)%>'><%=(String)shift_list.get(i+1)%></option>			
<%
		}
%>
	</SELECT>&nbsp;<img src="../../eCommon/images/mandatory.gif">
<%
		for(int i=0;i<shift_list.size();i +=3){
%>
		<input type="hidden" name="shift_mnemonic" id="shift_mnemonic" value="<%=shift_list.get(i+2)%>">

<%
		}
%>
		<input type="hidden" name="start_time1" id="start_time1" value="">
		<input type="hidden" name="end_time1" id="end_time1" value="" >
					
	</td>
	<td id="start_time" class="data"></td>
		
</tr>
<tr>
	<td colspan='2'>&nbsp;</td>
		<td></td>

</tr>
<tr>
	<td class='label' width='25%' align='right'><fmt:message key="eRS.OverTimeDuration.label" bundle="${rs_labels}"/></td>
	<td class="label">&nbsp;&nbsp;&nbsp;<input type="text" size="1" maxlength="2" name="over_time_durn1" id="over_time_durn1" onblur='CheckForHours(this)' onkeypress="return allowPositiveNumber()">:<input type="text" size="1" maxlength="2" name="over_time_durn2" id="over_time_durn2" onblur='CheckForMinutes(this,over_time_durn1);' onkeypress="return allowPositiveNumber()">&nbsp;hh:mi&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		<td></td>
</tr>
		<tr>
	<td colspan='2'>&nbsp;</td>
			<td></td>
</tr>
<tr>
	<td class='label' width='25%' align='right'><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
<%
	//String sql_reason="select reason_code,reason_desc from rs_reason where activity_type_code = 'OT' and eff_status = 'E' order by reason_desc";
	String sql_reason="select reason_code,reason_desc from rs_reason_lang_vw where language_id = ? and activity_type_code = 'OT' and eff_status = 'E' order by reason_desc";
	pstmt_reason = conn.prepareStatement(sql_reason);
	pstmt_reason.setString(1,locale);
	
	rs_reason = pstmt_reason.executeQuery();
	
%>
	<td>&nbsp;&nbsp;&nbsp;<SELECT name="reason" id="reason">
			<option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
<%	
		while(rs_reason.next() && rs_reason!=null){
			out.println("<option value='"+rs_reason.getString("reason_code")+"'>"+rs_reason.getString("reason_desc")+"</option>");
		}
		if(pstmt_reason != null)
			pstmt_reason.close();
		if(rs_reason != null)
			rs_reason.close();
%>
		</SELECT>&nbsp;<img src="../../eCommon/images/mandatory.gif">
	</td>
	<td></td>
</tr>
<tr>
	<td colspan='2'>&nbsp;</td>
		<td></td>

</tr>
<tr>
	<td class='label' width='25%' align='right'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
	<td>&nbsp;&nbsp;&nbsp;<TEXTAREA NAME="remarks" COLS="25" onKeyPress="checkMaxLimit(this,2000);"></TEXTAREA></td>
	<td></td>
</tr>
<tr>
	<td colspan='2'>&nbsp;</td>
		<td></td>
</tr>
<tr>
	<td>&nbsp;</td>
	<td></td>
	<td align='right'><INPUT TYPE="button" class='button' value='<fmt:message key="Common.apply.label" bundle="${common_labels}"/>' onclick="apply()"><INPUT TYPE="button" class='button' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick="windclose()"></td>

</tr>
<tr>
	<td colspan='2'>&nbsp;</td>
		<td></td>

</tr>
</table>
<input type="hidden" name="p_shift_code" id="p_shift_code" value="<%=p_shift_code%>">
<input type="hidden" name="p_requirement_id" id="p_requirement_id" value="<%=p_requirement_id%>">
<input type="hidden" name="p_workplace_code" id="p_workplace_code" value="<%=p_workplace_code%>">
<input type="hidden" name="p_schedule_date" id="p_schedule_date" value="<%=p_schedule_date%>">
<input type="hidden" name="p_role_type" id="p_role_type" value="<%=p_role_type%>">
<input type="hidden" name="p_staff_id" id="p_staff_id" value="<%=p_staff_id%>">
<input TYPE="hidden" name="p_staff_type" id="p_staff_type" value="<%=p_staff_type%>">
<input type="hidden" name="p_position_code" id="p_position_code" value="<%=p_position_code%>">
<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=p_facility_id%>">
<input type="hidden" name="date_type" id="date_type" value="<%=date_type%>">
<input type="hidden" name="shift_start_time" id="shift_start_time" value="">
<input type="hidden" name="actual_end_time" id="actual_end_time" value="">
<input type="hidden" name="curr_shift_overtime_yn" id="curr_shift_overtime_yn" value="<%=curr_shift_overtime_yn%>">
<input type="hidden" name="durn_for_overtime_from_sos" id="durn_for_overtime_from_sos" value="<%=durn_for_overtime_from_sos%>">
<input type="hidden" name="shift_end_date_time" id="shift_end_date_time" value="">
<input type="hidden" name="shift_start_date_time" id="shift_start_date_time" value="">
<input type="hidden" name="actual_end_date_time" id="actual_end_date_time" value="">
<input type="hidden" name="mode" id="mode" value="insert">
</form>
</body>
		
<%
	}catch (Exception e){
		out.println(e.toString());
	}
	finally{
		try
		{
		if(rs_schedule_date!=null) rs_schedule_date.close();
		if(rs_reqid_v!=null) rs_reqid_v.close();
		if(rs_reqid_c!=null) rs_reqid_c.close();
		if(rs_shift_code!=null) rs_shift_code.close();
		if(rs_shift!=null) rs_shift.close();
		if(rs_reason!=null) rs_reason.close();
		if(rs_date_type!=null) rs_date_type.close();
		if(rs_curr_overtime!=null) rs_curr_overtime.close();
		if(rs_start_end_time!=null) rs_start_end_time.close();

		if(pstmt_start_end_time!=null) pstmt_start_end_time.close();
		if(pstmt_schedule_date!=null) pstmt_schedule_date.close();
		if(pstmt_reqid_v!=null) pstmt_reqid_v.close();
		if(pstmt_reqid_c!=null) pstmt_reqid_c.close();
		if(pstmt_shift_code!=null) pstmt_shift_code.close();
		if(pstmt_shift!=null) pstmt_shift.close();
		if(pstmt_reason!=null) pstmt_reason.close();
		if(pstmt_curr_overtime!=null) pstmt_curr_overtime.close();
		if(pstmt_reason!=null) pstmt_reason.close();

		ConnectionManager.returnConnection(conn,request);
		}
		catch(Exception exp)
		{
			out.println(exp.toString());
		}
	}
%>
</html>	

