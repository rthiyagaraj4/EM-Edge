<!DOCTYPE html>
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
<script language="javascript" src="../../eCommon/js/dchk.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
<!-- <script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="JavaScript" src="../../eRS/js/ManageWorkScheduleSwap.js"></script>
<!-- <script language="JavaScript" src="../../eRS/js/RSMessages.js"></script> -->
<%

	String p_facility_id  = request.getParameter("p_facility_id");
	String p_workplace_code = request.getParameter("p_workplace_code");
	String p_role_type  = request.getParameter("p_role_type");
	String p_position_code  = request.getParameter("p_position_code");
	String p_schedule_date=request.getParameter("p_schedule_date");
	
	String p_requirement_id = request.getParameter("p_requirement_id");
	String new_workplace_code = request.getParameter("new_workplace_code");
	String new_staff_id = request.getParameter("new_staff_id");
	String curr_shift_swap_yn="";
	String durn_for_swap_from_sos="";
	if(new_workplace_code.equals(""))
	new_workplace_code=p_workplace_code;

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	PreparedStatement pstmt_staff = null;
	ResultSet rs_staff=null;
		
    try
	{	
		con = ConnectionManager.getConnection(request);
		
		String sql="Select max_continuous_work_duration, curr_shift_swap_yn, durn_for_swap_from_sos from rs_parameter Where facility_id =?";

		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,p_facility_id);
		rs = pstmt.executeQuery();
		while( rs!=null && rs.next())
		{
			curr_shift_swap_yn=rs.getString("curr_shift_swap_yn");
			durn_for_swap_from_sos=rs.getString("durn_for_swap_from_sos");
		}
		if (pstmt != null) pstmt.close();
		if (rs != null) rs.close();

		String sql_req="select shift_code from rs_workplace_requirement_dtl where facility_id=? and workplace_code = ? and requirement_id = ? and position_code = ?";

		pstmt = con.prepareStatement(sql_req);
		pstmt.setString(1,p_facility_id);
		pstmt.setString(2,p_workplace_code);
		pstmt.setString(3,p_requirement_id);
		pstmt.setString(4,p_position_code);
		rs = pstmt.executeQuery();
		String valid_shifts_string="|";
		while( rs!=null && rs.next())
		{
			valid_shifts_string +=rs.getString("shift_code")+"|";
		}
		if (pstmt != null) pstmt.close();
		if (rs != null) rs.close();

		//String sql_newshifts="select a.productive_flag productive_flag,a.shift_indicator shift_indicator, a.shift_code shift_code, a.long_desc shift_desc, a.mnemonic_key shift_mnemonic, decode(instr(?,'|'||a.shift_code||'|'),0,'N',decode(?,'N','N',decode(sign(sysdate - (b.shift_start_time +(((to_number(substr(?,1,2))*60) + to_number(substr(?,4)))/ (24*60)))),1,'N','Y')))valid_yn from am_shift a, rs_work_schedule b where b.facility_id = ? and b.workplace_code = ? and b.role_type = ? and b.staff_id = ? and trunc(sysdate) = to_date(?,'dd/mm/yyyy') and	a.shift_code = b.shift_code and sysdate between b.shift_start_time  and b.actual_end_time union all select a.productive_flag,a.shift_indicator, 	b.shift_code,a.long_desc,a.mnemonic_key,	decode(instr(?,'|'||a.shift_code||'|'),0,'N','Y') valid_yn from am_shift a, rs_work_schedule b where b.facility_id = ? and b.workplace_code = ? and b.role_type = ? and b.staff_id = ? and b.schedule_date=to_date(?,'dd/mm/yyyy') and b.shift_start_time > sysdate and a.shift_code=b.shift_code order by shift_desc";
		String sql_newshifts="select a.productive_flag productive_flag,a.shift_indicator shift_indicator, a.shift_code shift_code, a.long_desc shift_desc, a.mnemonic_key shift_mnemonic, decode(instr(?,'|'||a.shift_code||'|'),0,'N',decode(?,'N','N',decode(sign(sysdate - (b.shift_start_time +(((to_number(substr(?,1,2))*60) + to_number(substr(?,4)))/ (24*60)))),1,'N','Y')))valid_yn from am_shift_lang_vw a, rs_work_schedule b where b.facility_id = ? and b.workplace_code = ? and b.role_type = ? and b.staff_id = ? and trunc(sysdate) = to_date(?,'dd/mm/yyyy') and a.shift_code = b.shift_code and sysdate between b.shift_start_time  and b.actual_end_time and a.language_id = ? union all select a.productive_flag,a.shift_indicator,  b.shift_code,a.long_desc,a.mnemonic_key, decode(instr(?,'|'||a.shift_code||'|'),0,'N','Y') valid_yn from am_shift_lang_vw a, rs_work_schedule b where b.facility_id = ? and b.workplace_code = ? and b.role_type = ? and b.staff_id = ? and b.schedule_date=to_date(?,'dd/mm/yyyy') and b.shift_start_time > sysdate and a.shift_code=b.shift_code and a.language_id = ? order by shift_desc";

		String valid_yn="";
		String shift_code="";
		String shift_mnemonic="";
		String shift_desc="";

		pstmt_staff = con.prepareStatement(sql_newshifts);
		pstmt_staff.setString(1,valid_shifts_string);
		pstmt_staff.setString(2,curr_shift_swap_yn);
		pstmt_staff.setString(3,durn_for_swap_from_sos);
		pstmt_staff.setString(4,durn_for_swap_from_sos);
		pstmt_staff.setString(5,p_facility_id);
		pstmt_staff.setString(6,new_workplace_code);
		pstmt_staff.setString(7,p_role_type);
		pstmt_staff.setString(8,new_staff_id);
		pstmt_staff.setString(9,p_schedule_date);
		pstmt_staff.setString(10,locale);
		pstmt_staff.setString(11,valid_shifts_string);
		pstmt_staff.setString(12,p_facility_id);
		pstmt_staff.setString(13,new_workplace_code);
		pstmt_staff.setString(14,p_role_type);
		pstmt_staff.setString(15,new_staff_id);
		pstmt_staff.setString(16,p_schedule_date);
		pstmt_staff.setString(17,locale);
		rs_staff = pstmt_staff.executeQuery();
%>
</head>
<body>
<form name="ManageWorkScheduleStaff2shifts_form" id="ManageWorkScheduleStaff2shifts_form" action='../../servlet/eRS.ManageWorkScheduleSwapServlet' target='blankFrame' method="post">
<table cellpadding=0 cellspacing=0 border=0 width="103%" align='right'>
<tr>
	<td width='30%'>&nbsp;</td>
	<td class='querydata'>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eRS.AllocatedShifts.label" bundle="${rs_labels}"/></td>
	<td class='querydata' align='left'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
</tr>
<%

	String staff2_allocated_shifts_string="|";
	while( rs_staff!=null && rs_staff.next())
	{
		staff2_allocated_shifts_string +=rs_staff.getString("shift_code")+"|";
		valid_yn=rs_staff.getString("valid_yn");
		shift_code=rs_staff.getString("shift_code");
		shift_desc=rs_staff.getString("shift_desc");
		shift_mnemonic=rs_staff.getString("shift_mnemonic");
		
		if(valid_yn.equalsIgnoreCase("N")){
		out.println("<tr>");
		out.println("<td class='label' width='30%' align='right'>&nbsp;</td>");
		out.println("<td class='label' width='30%' align='left'>&nbsp;&nbsp;&nbsp;&nbsp;"+shift_desc+"&nbsp;&nbsp;"+shift_mnemonic+"</td>");
		
		out.println("<td align='left'><INPUT TYPE='radio' disabled name='staff2_shft_code' id='staff2_shft_code' value='"+shift_code+"'' ></td>");

		out.println("</tr>");
		}
		else{
			out.println("<tr>");
			out.println("<td class='label' width='30%' align='right'>&nbsp;</td>");
			out.println("<td class='label' width='30%' align='left'>&nbsp;&nbsp;&nbsp;&nbsp;"+shift_desc+"&nbsp;&nbsp;"+shift_mnemonic+"</td>");
			
			out.println("<td align='left'><INPUT TYPE='radio'  name='staff2_shft_code' id='staff2_shft_code' value='"+shift_code+"' onClick='staff2shiftchk(this);validate();' ></td>");

			out.println("</tr>");
		}
	}
	if (pstmt_staff != null) pstmt_staff.close();
	if (rs_staff != null) rs_staff.close();
%>
	<tr>
	<td class='label' width='30%' align='right'><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
<%
	String sql_reason="select reason_code,reason_desc from rs_reason where activity_type_code = 'SW' and eff_status = 'E' order by reason_desc";
	pstmt = con.prepareStatement(sql_reason);
	rs = pstmt.executeQuery();
	
%>
	<td>&nbsp;&nbsp;&nbsp;<SELECT name="reason" id="reason" onchange='validate();' >
			<option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
<%	
		while(rs!=null  && rs.next())
		  {
			out.println("<option value='"+rs.getString("reason_code")+"'>"+rs.getString("reason_desc")+"</option>");
		  }
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	
%>
		</SELECT><img src="../../eCommon/images/mandatory.gif">
	</td>
	<td></td>
</tr>

<tr>
	<td class='label' width='30%' align='right'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
	<td>&nbsp;&nbsp;&nbsp;<TEXTAREA NAME="remarks" COLS="30" onkeypress='return notallowenter(event);'></TEXTAREA>
	</td>
	<td></td>
	
</tr>

<tr>
	<td colspan='3'>&nbsp;</td>
</tr>

</table>
	
	<INPUT TYPE="hidden" name="staff2_shiftcode_value" id="staff2_shiftcode_value" value="">

<INPUT TYPE="hidden" name="staff2_allocated_shifts_string" id="staff2_allocated_shifts_string" value="<%=staff2_allocated_shifts_string%>">
<INPUT TYPE="hidden" name="durn_for_swap_from_sos" id="durn_for_swap_from_sos" value="<%=durn_for_swap_from_sos%>">
<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" value="<%=p_facility_id%>">
<INPUT TYPE="hidden" name="p_workplace_code" id="p_workplace_code" value="<%=p_workplace_code%>">
<INPUT TYPE="hidden" name="p_requirement_id" id="p_requirement_id" value="<%=p_requirement_id%>">
<INPUT TYPE="hidden" name="p_schedule_date" id="p_schedule_date" value="<%=p_schedule_date%>">
<INPUT TYPE="hidden" name="p_role_type" id="p_role_type" value="<%=p_role_type%>">
<INPUT TYPE="hidden" name="p_position_code" id="p_position_code" value="<%=p_position_code%>">
<INPUT TYPE="hidden" name="p_staff_type" id="p_staff_type" value="">
<INPUT TYPE="hidden" name="p_staff_id" id="p_staff_id" value="">
<INPUT TYPE="hidden" name="staff1_shift_code" id="staff1_shift_code" value="">
<INPUT TYPE="hidden" name="new_workplace_code" id="new_workplace_code" value="">
<INPUT TYPE="hidden" name="new_staff_id" id="new_staff_id" value="">
<INPUT TYPE="hidden" name="staff2_shift_code" id="staff2_shift_code" value="">
<INPUT TYPE="hidden" name="old_shift_indicator" id="old_shift_indicator" value="">
<INPUT TYPE="hidden" name="old_productive_flag" id="old_productive_flag" value="">
<INPUT TYPE="hidden" name="old_mnemonic_key" id="old_mnemonic_key" value="">
<INPUT TYPE="hidden" name="new_shift_indicator" id="new_shift_indicator" value="">
<INPUT TYPE="hidden" name="new_productive_flag" id="new_productive_flag" value="">
<INPUT TYPE="hidden" name="new_mnemonic_key" id="new_mnemonic_key" value="">
</form>
</body>
<%	}
	catch(Exception e){out.print(e.toString());}
	finally {
		if (pstmt != null) pstmt.close();
		if (rs != null) rs.close();
		ConnectionManager.returnConnection(con,request);
	}
%>

