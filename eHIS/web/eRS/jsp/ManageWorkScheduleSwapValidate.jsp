<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=ISO-8859-1"%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<html>
<head>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- <script language="JavaScript" src="../../eRS/js/RSMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<%	
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ResultSet rsv=null;
	
try{
	con = ConnectionManager.getConnection(request);
	String p_workplace_code = request.getParameter("p_workplace_code");
	String p_role_type  = request.getParameter("p_role_type");
	String p_staff_id  = request.getParameter("p_staff_id");
	String p_schedule_date=request.getParameter("p_schedule_date");
	String p_staff_type  = request.getParameter("p_staff_type");
	
	String staff1_shift_code=request.getParameter("staff1_shift_code");
	String new_workplace_code=request.getParameter("new_workplace_code");
	if(new_workplace_code.equals(""))
	new_workplace_code=p_workplace_code;
	String new_staff_id=request.getParameter("new_staff_id");
	String staff2_shift_code=request.getParameter("staff2_shift_code");
	String staff1_allocated_shifts_string=request.getParameter("staff1_allocated_shifts_string");
	String staff2_allocated_shifts_string=request.getParameter("staff2_allocated_shifts_string");

	String durn_for_swap_from_sos=request.getParameter("durn_for_swap_from_sos");
	String old_shift_indicator =""; 
	String old_productive_flag="";
	String new_shift_indicator =""; 
	String new_productive_flag="";
	String old_mnemonic_key="";
	String new_mnemonic_key="";
	String staff_1_valid_shift_yn="";
	String staff_2_valid_shift_yn="";
	String sql_pflag_indicator_shift1 ="select shift_indicator,productive_flag,mnemonic_key from am_shift where shift_code=?";
	pstmt = con.prepareStatement(sql_pflag_indicator_shift1);
	pstmt.setString(1,staff1_shift_code);
	rs = pstmt.executeQuery();
	 if(rs!=null){
		if(rs.next()){
			old_shift_indicator = rs.getString("shift_indicator");
			old_productive_flag = rs.getString("productive_flag");
			old_mnemonic_key = rs.getString("mnemonic_key"); 
		}
	 }
	if(pstmt!=null) pstmt.close();
	if(rs!=null) rs.close();

	String sql_pflag_indicator_shift2 ="select shift_indicator,productive_flag,mnemonic_key from am_shift where shift_code=?";
	pstmt = con.prepareStatement(sql_pflag_indicator_shift2);
	pstmt.setString(1,staff2_shift_code);
	rs = pstmt.executeQuery();
	 
	 if(rs!=null){
		if(rs.next()){
			new_shift_indicator = rs.getString("shift_indicator");
			new_productive_flag = rs.getString("productive_flag");
			new_mnemonic_key = rs.getString("mnemonic_key"); 
		}
	 }
	if(pstmt!=null) pstmt.close();
	if(rs!=null) rs.close();
	String same_shift_valid="select decode(instr(?,'|'||?),0,'Y','N') staff_1_valid_shift_yn, decode(instr(?,'|'||?),0,'Y','N') staff_2_valid_shift_yn from dual ";

	pstmt = con.prepareStatement(same_shift_valid);
	pstmt.setString(1,staff2_allocated_shifts_string);
	pstmt.setString(2,staff1_shift_code);
	pstmt.setString(3,staff1_allocated_shifts_string);
	pstmt.setString(4,staff2_shift_code);
	rsv = pstmt.executeQuery();
	while( rsv!=null && rsv.next()){
		staff_1_valid_shift_yn=rsv.getString("staff_1_valid_shift_yn");
		staff_2_valid_shift_yn=rsv.getString("staff_2_valid_shift_yn");

	}
	if (pstmt != null) pstmt.close();
	if (rsv != null) rsv.close();
	int i = 0;
	if(staff_1_valid_shift_yn.equals("N")){
		out.println("<script>alert(getMessage('STAFF1_SHIFT_ALREADY_ASSIGNED_TO_STAFF2_SHIFT','RS'));</script>");
		out.println("<script>parent.ManageWorkScheduleStaff2Shifts_frame.document.ManageWorkScheduleStaff2shifts_form.reason.value='';</script>");
		i = 1;
	}
	if(i==0)	{
		if(staff_2_valid_shift_yn.equals("N")){
			out.println("<script>alert(getMessage('STAFF2_SHIFT_ALREADY_ASSIGNED_TO_STAFF1_SHIFT','RS')); </script>");
			out.println("<script>parent.ManageWorkScheduleStaff2Shifts_frame.document.ManageWorkScheduleStaff2shifts_form.reason.value='';</script>");
			i=2;
		}
	}
	StringBuffer stb= new StringBuffer(durn_for_swap_from_sos);
	String hr=stb.substring(0,2);
	String mi=stb.substring(3);

	String staff1_shift_start_time = "";
	String staff1_actual_end_time = "";
	String staff2_shift_start_time = "";
	String staff2_actual_end_time = "";

	// To get the staff1 shift start and end time 
	String sql_stf1_times="select 	to_char(shift_start_time,'dd/mm/yyyy hh24:mi') staff1_shift_start_time, to_char(actual_end_time,'dd/mm/yyyy hh24:mi') staff1_actual_end_time from  rs_work_schedule where	role_type = ? and	staff_id = ? and  workplace_code = ? and  schedule_date = to_date(?,'dd/mm/yyyy') and  shift_code = ?";

	pstmt = con.prepareStatement(sql_stf1_times);
	pstmt.setString(1,p_role_type);
	pstmt.setString(2,p_staff_id);
	pstmt.setString(3,p_workplace_code);
	pstmt.setString(4,p_schedule_date);
	pstmt.setString(5,staff1_shift_code);
	rs = pstmt.executeQuery();
	 if(rs!=null) {
		if(rs.next()){
		 staff1_shift_start_time = rs.getString("staff1_shift_start_time");
		 staff1_actual_end_time = rs.getString("staff1_actual_end_time");
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	 }


	// To get the staff2 shift start and end time 
	String sql_stf2_times="select to_char(shift_start_time,'dd/mm/yyyy hh24:mi') staff2_shift_start_time,to_char(actual_end_time,'dd/mm/yyyy hh24:mi') staff2_actual_end_time from  rs_work_schedule where	role_type = ? and	staff_id = ? and  workplace_code = ? and  schedule_date = to_date(?,'dd/mm/yyyy') and  shift_code = ? ";
   
	pstmt = con.prepareStatement(sql_stf2_times);
	pstmt.setString(1,p_role_type);
	pstmt.setString(2,new_staff_id);
	pstmt.setString(3,new_workplace_code);
	pstmt.setString(4,p_schedule_date);
	pstmt.setString(5,staff2_shift_code);
	
	rs = pstmt.executeQuery();
	 if(rs!=null){
		if(rs.next()){
			 staff2_shift_start_time = rs.getString("staff2_shift_start_time");
			 staff2_actual_end_time = rs.getString("staff2_actual_end_time");
		}
	 }
	if(pstmt!=null) pstmt.close();
	if(rs!=null) rs.close();

	String staff1_overlaps_yn="";
	String staff2_overlaps_yn="";

	// Validate if there will be any schedule overlap due to swap of shift for staff 1
	String sql_staff1_overlap=" select decode(nvl(count(*),0),0,'N','Y')  staff1_overlaps_yn from rs_work_schedule where role_type = ? and staff_id = ? and shift_code !=? and (	to_date(?,'dd/mm/yyyy hh24:mi') between shift_start_time and actual_end_time or to_date(?,'dd/mm/yyyy hh24:mi')+ ((("+hr+"*60)+("+mi+"))/(24*60)) between shift_start_time and actual_end_time)";

	pstmt = con.prepareStatement(sql_staff1_overlap);
	pstmt.setString(1,p_role_type);
	pstmt.setString(2,p_staff_id);
	pstmt.setString(3,staff1_shift_code);
	pstmt.setString(4,staff2_shift_start_time);
	pstmt.setString(5,staff2_actual_end_time);
	
	rs = pstmt.executeQuery();
	 if(rs!=null){
		if(rs.next()){
			staff1_overlaps_yn = rs.getString("staff1_overlaps_yn");
		}
	 }
	if(pstmt!=null) pstmt.close();
	if(rs!=null) rs.close();

	if(i==0){
		if(staff1_overlaps_yn.equals("Y")){

			out.println("<script>alert(getMessage('STAFF1_SCHEDULE_OVERLAPS_WITH_STAFF2','RS'));</script>");
			out.println("<script>parent.ManageWorkScheduleStaff2Shifts_frame.document.ManageWorkScheduleStaff2shifts_form.reason.value='';</script>");
		}
		i=3;
	}
	// Validate if there will be any schedule overlap due to swap of shift for staff 2
	String sql_staff2_overlap="select decode(nvl(count(*),0),0,'N','Y')  staff2_overlaps_yn from rs_work_schedule where role_type = ? and staff_id = ? and shift_code !=? and (	to_date(?,'dd/mm/yyyy hh24:mi') between shift_start_time and actual_end_time or to_date(?,'dd/mm/yyyy hh24:mi')+ ((("+hr+"*60)+("+mi+"))/(24*60))between shift_start_time and actual_end_time)";

	pstmt = con.prepareStatement(sql_staff2_overlap);
	pstmt.setString(1,p_role_type);
	pstmt.setString(2,new_staff_id);
	pstmt.setString(3,staff2_shift_code);
	pstmt.setString(4,staff1_shift_start_time);
	pstmt.setString(5,staff1_actual_end_time);
	
	rs = pstmt.executeQuery();
	 if(rs!=null){
		if(rs.next()){
			staff2_overlaps_yn = rs.getString("staff2_overlaps_yn");
		}
	 }
	if(pstmt!=null) pstmt.close();
	if(rs!=null) rs.close();
	if(i==0){
		if(staff2_overlaps_yn.equals("Y")){
			out.println("<script>alert(getMessage('STAFF2_SCHEDULE_OVERLAPS_WITH_STAFF1','RS'));</script>");
			out.println("<script>parent.ManageWorkScheduleStaff2Shifts_frame.document.ManageWorkScheduleStaff2shifts_form.reason.value='';</script>");
		}
	}
%>
<script>
parent.ManageWorkScheduleStaff2Shifts_frame.ManageWorkScheduleStaff2shifts_form.p_staff_type.value="<%=p_staff_type%>";
parent.ManageWorkScheduleStaff2Shifts_frame.ManageWorkScheduleStaff2shifts_form.p_staff_id.value="<%=p_staff_id%>";
parent.ManageWorkScheduleStaff2Shifts_frame.ManageWorkScheduleStaff2shifts_form.staff1_shift_code.value="<%=staff1_shift_code%>";
parent.ManageWorkScheduleStaff2Shifts_frame.ManageWorkScheduleStaff2shifts_form.new_workplace_code.value="<%=new_workplace_code%>";
parent.ManageWorkScheduleStaff2Shifts_frame.ManageWorkScheduleStaff2shifts_form.new_staff_id.value="<%=new_staff_id%>";
parent.ManageWorkScheduleStaff2Shifts_frame.ManageWorkScheduleStaff2shifts_form.staff2_shift_code.value="<%=staff2_shift_code%>";
parent.ManageWorkScheduleStaff2Shifts_frame.ManageWorkScheduleStaff2shifts_form.old_shift_indicator.value="<%=old_shift_indicator%>";
parent.ManageWorkScheduleStaff2Shifts_frame.ManageWorkScheduleStaff2shifts_form.old_productive_flag.value="<%=old_productive_flag%>";
parent.ManageWorkScheduleStaff2Shifts_frame.ManageWorkScheduleStaff2shifts_form.old_mnemonic_key.value="<%=old_mnemonic_key%>";
parent.ManageWorkScheduleStaff2Shifts_frame.ManageWorkScheduleStaff2shifts_form.new_shift_indicator.value="<%=new_shift_indicator%>";
parent.ManageWorkScheduleStaff2Shifts_frame.ManageWorkScheduleStaff2shifts_form.new_productive_flag.value="<%=new_productive_flag%>";
parent.ManageWorkScheduleStaff2Shifts_frame.ManageWorkScheduleStaff2shifts_form.new_mnemonic_key.value="<%=new_mnemonic_key%>";
</script>
<%

	}
	catch (Exception e){
		out.println(e.toString());
	}
	finally{
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
		ConnectionManager.returnConnection(con,request);
	}
%>
</html>

