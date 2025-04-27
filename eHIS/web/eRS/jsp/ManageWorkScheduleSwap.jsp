<!DOCTYPE html>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><fmt:message key="eRS.SwapShifts.label" bundle="${rs_labels}"/></title>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/dchk.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
<!-- <script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
 --><script language="JavaScript" src="../../eRS/js/ManageWorkScheduleSwap.js"></script>
<!-- <script language="JavaScript" src="../../eRS/js/RSMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<%	
  
	Connection con = null;

	PreparedStatement pstmt = null;

	ResultSet rs = null;
	ResultSet prs = null;

	String p_facility_id  = request.getParameter("p_facility_id");
	String p_workplace_code = request.getParameter("p_workplace_code");
	String p_date  = request.getParameter("p_date");
	int p_cell_no  = Integer.parseInt(request.getParameter("p_cell_no"));
	String p_role_type  = request.getParameter("p_role_type");
	String p_staff_id  = request.getParameter("p_staff_id");
	String p_staff_type  = request.getParameter("p_staff_type");
	String p_position_code  = request.getParameter("p_position_code");
	String p_shift_code  = request.getParameter("p_shift_code");
	String p_shift_mnemonic  = request.getParameter("p_shift_mnemonic");
	String p_schedule_date="";
	String p_staff_name="";
	String p_requirement_id = "";
	String staff_subs_same_grade_yn="";
	String staff_subs_high_to_low_yn="";
	String staff_subs_low_to_high_yn="";     
	String curr_shift_swap_yn="";
	String durn_for_swap_from_sos="";
	String count="";
	String grade_code =""; 
	String grade_level="";
	String[] wrk_record=null;
   String p_workplace_desc="";
	try{
		
		con = ConnectionManager.getConnection(request);
        StringBuffer temp_shift = new StringBuffer("'" + p_shift_code + "'");
	    //out.println("temp_shift----->"+temp_shift);
        while(temp_shift.toString().indexOf('|') != -1)
		{
			
            int index = temp_shift.toString().indexOf('|');
			//out.println("index--|"+index+"|---");
			
            temp_shift.replace(index,index+1,"','");
        }
		p_shift_code = temp_shift.toString();
		p_shift_code=p_shift_code.substring(1,(p_shift_code.length()-1));
		
       
		StringBuffer temp_mnemo = new StringBuffer("'" + p_shift_mnemonic + "'");
		//out.println("temp_mnemo---->"+temp_mnemo);
        while(temp_mnemo.toString().indexOf('|') != -1){
            int index = temp_mnemo.toString().indexOf('|');
			
            temp_mnemo.replace(index,index+1,"','");


        }
		p_shift_mnemonic = temp_mnemo.toString();
		//out.println("p_shift_mnemonic---->"+p_shift_mnemonic);
		p_shift_mnemonic=p_shift_mnemonic.substring(1,(p_shift_mnemonic.length()-1));
		//out.println("p_shift_mnemonic---->"+p_shift_mnemonic);
		
		String sql_sch_date = "select to_char(to_date(?,'dd/mm/yyyy') + ?,'dd/mm/yyyy' )p_schedule_date from dual";
		pstmt = con.prepareStatement(sql_sch_date);
		pstmt.setString(1,p_date);
		pstmt.setInt(2,p_cell_no);
		rs = pstmt.executeQuery();
		
		if(rs!=null){
			
			if(rs.next()){
				
				p_schedule_date = rs.getString("p_schedule_date");
				
			}
		}
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();

		String rs_param="select	staff_subs_same_grade_yn, staff_subs_high_to_low_yn, staff_subs_low_to_high_yn ,curr_shift_swap_yn, durn_for_swap_from_sos from rs_parameter where facility_id =?";
		pstmt = con.prepareStatement(rs_param);
		pstmt.setString(1,p_facility_id);
		rs = pstmt.executeQuery();
		if(rs!=null)
		{	
			if(rs.next())
			{	
					
			staff_subs_same_grade_yn=rs.getString("STAFF_SUBS_SAME_GRADE_YN");
			staff_subs_high_to_low_yn=rs.getString("STAFF_SUBS_HIGH_TO_LOW_YN");
			staff_subs_low_to_high_yn=rs.getString("STAFF_SUBS_LOW_TO_HIGH_YN");     
			curr_shift_swap_yn= rs.getString("CURR_SHIFT_SWAP_YN"); 
			durn_for_swap_from_sos = rs.getString("DURN_FOR_SWAP_FROM_SOS");
			}
			
		}
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
	
		if(staff_subs_same_grade_yn.equalsIgnoreCase("N") && staff_subs_high_to_low_yn.equalsIgnoreCase("N") && staff_subs_low_to_high_yn.equalsIgnoreCase("N")){
			out.println("<script>alert(getMessage('STAFF_SUBSTITUTION_FEATURE_NOT_ENABLED','RS'));</script>");
			out.println("<script>window.close();</script>");
		}
	
		String sql_satf_name ="select a.staff_name, a.grade_code, a.position_code, b.grade_level from am_staff_vw a, rs_grade b where role_type = ? and staff_id =?";
		 pstmt = con.prepareStatement(sql_satf_name);
		 pstmt.setString(1,p_role_type);
		 pstmt.setString(2,p_staff_id);
		 rs = pstmt.executeQuery();
		 
		 if(rs!=null){
			 
			if(rs.next()){
				
				p_staff_name = rs.getString("staff_name");
				grade_code = rs.getString("grade_code");
				grade_level = rs.getString("grade_level");

			}
		
		 }
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();

		
		//String sql_workplace_desc ="select workplace_desc from rs_workplace where facility_id=? and workplace_code=?";
		String sql_workplace_desc ="select workplace_desc from rs_workplace_lang_vw where facility_id=? and workplace_code=? and language_id = ?";

		pstmt = con.prepareStatement(sql_workplace_desc);
		pstmt.setString(1,p_facility_id);
		pstmt.setString(2,p_workplace_code);
		pstmt.setString(3,locale);
		 rs = pstmt.executeQuery();
		/* System.out.println("Values in manageworkscheduleswap.jsp 131-------->");
		 System.out.println("p_facility_id 132----|"+p_facility_id+"|---p_workplace_code 133----|"+p_workplace_code+"|---locale 134---|"+locale+"|---");*/
		 if(rs!=null){
			 
			if(rs.next()){
				
				p_workplace_desc = rs.getString("workplace_desc");
				
			}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		 }
		 
%>
<body>
<form name="ManageWorkScheduleSwap" id="ManageWorkScheduleSwap" action='../../servlet/eRS.ManageWorkScheduleSwapServlet' target='blankFrame' method="post">
<table cellpadding=0 cellspacing=0 border=0 width="100%" align='right'>

<tr>
	<td class='label' align='right' width='30%'><fmt:message key="eRS.ScheduleDate.label" bundle="${rs_labels}"/></td>
	<td class='querydata'>&nbsp;&nbsp;&nbsp;&nbsp;<%=p_schedule_date%></td>
	<td class='label'>&nbsp;</td>
</tr>
<tr>
	<td class='label' align='right' width='30%'><fmt:message key="eRS.Workplace.label" bundle="${rs_labels}"/></td>
	<td class='querydata'>&nbsp;&nbsp;&nbsp;&nbsp;<%=p_workplace_desc%></td>
	<td class='label'>&nbsp;</td>
</tr>
<tr>
	<td class='label' align='right' width='30%'><fmt:message key="eRS.Staff.label" bundle="${rs_labels}"/></td>
	<td class='querydata'>&nbsp;&nbsp;&nbsp;&nbsp;<%=p_staff_name%></td>
	<td class='label'>&nbsp;</td>
</tr>
<tr>
	<td colspan='3'>&nbsp;</td>
</tr>
<tr>
	<td width='30%'>&nbsp;</td>
	<td class='querydata'>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eRS.AllocatedShifts.label" bundle="${rs_labels}"/>&nbsp;&nbsp;&nbsp;</td>
	<td class='querydata' align='left'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
</tr>
<%
	//String sql_shifts = "select a.productive_flag productive_flag,a.shift_indicator shift_indicator,a.shift_code shift_code, a.long_desc shift_desc, a.mnemonic_key shift_mnemonic,to_char(b.shift_start_time,'dd/mm/yyyy hh24:mi:ss') shift_start_time,to_char(b.actual_end_time,'dd/mm/yyyy hh24:mi:ss') actual_end_time, decode(?,'N','N',decode(sign(sysdate - (b.shift_start_time + (((to_number(substr(?,1,2))*60) + to_number(substr(?,4))) / (24*60)))),1,'N','Y')) valid_yn from am_shift a, rs_work_schedule b where a.shift_code in (?) and a.shift_code = b.shift_code and b.facility_id = ? and b.workplace_code = ? and b.role_type = ?   and b.staff_id = ? and trunc(sysdate) = to_date(?,'dd/mm/yyyy') and sysdate between b.shift_start_time and b.actual_end_time union all select a.productive_flag,a.shift_indicator,b.shift_code,a.long_desc,a.mnemonic_key,	to_char(b.shift_start_time,'dd/mm/yyyy hh24:mi:ss'),	to_char(b.actual_end_time,'dd/mm/yyyy hh24:mi:ss'),'Y' valid_yn from am_shift a, rs_work_schedule b where b.facility_id = ? and b.workplace_code = ? and b.role_type=? and b.staff_id=? and b.schedule_date=to_date(?,'dd/mm/yyyy') and b.shift_start_time > sysdate and b.shift_code in (?) and a.shift_code=b.shift_code";

	String sql_shifts = "select a.productive_flag productive_flag,a.shift_indicator shift_indicator,a.shift_code shift_code, a.long_desc shift_desc, a.mnemonic_key shift_mnemonic,to_char(b.shift_start_time,'dd/mm/yyyy hh24:mi:ss') shift_start_time,to_char(b.actual_end_time,'dd/mm/yyyy hh24:mi:ss') actual_end_time, decode(?,'N','N',decode(sign(sysdate - (b.shift_start_time + (((to_number(substr(?,1,2))*60) + to_number(substr(?,4))) / (24*60)))),1,'N','Y')) valid_yn from am_shift_lang_vw a, rs_work_schedule b where a.shift_code in (?) and a.shift_code = b.shift_code and b.facility_id = ? and b.workplace_code = ? and b.role_type = ?   and b.staff_id = ? and trunc(sysdate) = to_date(?,'dd/mm/yyyy') and sysdate between b.shift_start_time and b.actual_end_time and a.language_id = ? union all select a.productive_flag,a.shift_indicator,b.shift_code,a.long_desc,a.mnemonic_key, to_char(b.shift_start_time,'dd/mm/yyyy hh24:mi:ss'), to_char(b.actual_end_time,'dd/mm/yyyy hh24:mi:ss'),'Y' valid_yn from am_shift_lang_vw a, rs_work_schedule b where b.facility_id = ? and b.workplace_code = ? and b.role_type=? and b.staff_id=? and b.schedule_date=to_date(?,'dd/mm/yyyy') and b.shift_start_time > sysdate and b.shift_code in (?) and a.shift_code=b.shift_code and a.language_id = ?";
    


	pstmt = con.prepareStatement(sql_shifts);
	pstmt.setString(1,curr_shift_swap_yn);
	pstmt.setString(2,durn_for_swap_from_sos);
	pstmt.setString(3,durn_for_swap_from_sos);
	pstmt.setString(4,p_shift_code);
	pstmt.setString(5,p_facility_id);
	pstmt.setString(6,p_workplace_code);
	pstmt.setString(7,p_role_type);
	pstmt.setString(8,p_staff_id);
	pstmt.setString(9,p_schedule_date);
	pstmt.setString(10,locale);
	pstmt.setString(11,p_facility_id);
	pstmt.setString(12,p_workplace_code);
	pstmt.setString(13,p_role_type);
	pstmt.setString(14,p_staff_id);
	pstmt.setString(15,p_schedule_date);
	pstmt.setString(16,p_shift_code);
	pstmt.setString(17,locale);
	
	prs = pstmt.executeQuery();
	
	String staff1_allocated_shifts_string="|";
	String valid_yn="";
	int shifts=0;
	if(prs!=null){
		int i = 0;
		while(prs.next()){
			 shifts=1;
			staff1_allocated_shifts_string +=prs.getString("shift_code")+"|";
			valid_yn=prs.getString("valid_yn");
			if(valid_yn.equalsIgnoreCase("N"))	{
				out.println("<tr>");
				out.println("<td class='label' width='30%' align='right'>&nbsp;</td>");
				out.println("<td class='label' width='30%' align='left'>&nbsp;&nbsp;&nbsp;&nbsp;"+prs.getString("shift_desc")+"&nbsp;&nbsp;"+prs.getString("shift_mnemonic")+"</td>");
				out.println("<td align='left'><INPUT TYPE='radio' disabled name='staff1_shft_code' id='staff1_shft_code' value='"+prs.getString("shift_code")+"' onclick=''></td>");
			}
			else{
			out.println("<tr>");
			out.println("<td class='label' width='30%' align='right'>&nbsp;</td>");
			out.println("<td class='label' width='30%' align='left'>&nbsp;&nbsp;&nbsp;&nbsp;"+prs.getString("shift_desc")+"&nbsp;&nbsp;"+prs.getString("shift_mnemonic")+"</td>");
			out.println("<td align='left'><INPUT TYPE='radio'  name='staff1_shft_code' id='staff1_shft_code' value='"+prs.getString("shift_code")+"' onClick='shiftchk(this)' ></td>");
			out.println("</tr>");
			i++;
			}
		}
		i--;
		count = ""+i;
	}
	if(pstmt!=null) pstmt.close();
	if(prs!=null) prs.close();
	
	if(shifts==0){
		out.println("<script>alert(getMessage('NO_VALID_SHIFTS_SWAP','RS'));</script>");
		out.println("<script>window.close();</script>");
	}
%>
<tr>
<td>&nbsp;</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td align='left'><INPUT TYPE="button" class='button' value='<fmt:message key="eRS.SwapWith.label" bundle="${rs_labels}"/>' onclick="swapwith()"></td>
</tr>
<tr>
<td colspan='3'>&nbsp;</td>
</tr>
</table>
<INPUT TYPE="hidden" name="staff1_allocated_shifts_string" id="staff1_allocated_shifts_string" value="<%=staff1_allocated_shifts_string%>">
<INPUT TYPE="hidden" name="p_shift_code" id="p_shift_code" value="<%=p_shift_code%>">
<INPUT TYPE="hidden" name="p_requirement_id" id="p_requirement_id" value="<%=p_requirement_id%>">
<INPUT TYPE="hidden" name="p_workplace_code" id="p_workplace_code" value="<%=p_workplace_code%>">
<INPUT TYPE="hidden" name="p_schedule_date" id="p_schedule_date" value="<%=p_schedule_date%>">
<INPUT TYPE="hidden" name="p_role_type" id="p_role_type" value="<%=p_role_type%>">
<INPUT TYPE="hidden" name="p_staff_id" id="p_staff_id" value="<%=p_staff_id%>">
<INPUT TYPE="hidden" name="p_staff_type" id="p_staff_type" value="<%=p_staff_type%>">
<INPUT TYPE="hidden" name="p_position_code" id="p_position_code" value="<%=p_position_code%>">
<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" value="<%=p_facility_id%>">
<INPUT TYPE="hidden" name="grade_code" id="grade_code" value="<%=grade_code%>">
<INPUT TYPE="hidden" name="grade_level" id="grade_level" value="<%=grade_level%>">
<INPUT TYPE="hidden" name="staff_subs_same_grade_yn" id="staff_subs_same_grade_yn" value="<%=staff_subs_same_grade_yn%>">
<INPUT TYPE="hidden" name="staff_subs_high_to_low_yn" id="staff_subs_high_to_low_yn" value="<%=staff_subs_high_to_low_yn%>">
<INPUT TYPE="hidden" name="staff_subs_low_to_high_yn" id="staff_subs_low_to_high_yn" value="<%=staff_subs_low_to_high_yn%>">
<INPUT TYPE="hidden" name="mnemonic" id="mnemonic" value="">
<INPUT TYPE="hidden" name="staff1_shiftcode_value" id="staff1_shiftcode_value" value="">
<INPUT TYPE="hidden" name="shift_start_time" id="shift_start_time" value="">
<INPUT TYPE="hidden" name="shift_end_time" id="shift_end_time" value="">
<INPUT TYPE="hidden" name="mode" id="mode" value="insert">
<INPUT TYPE="hidden" name="shift_indicator" id="shift_indicator" value="">
<INPUT TYPE="hidden" name="productive_flag" id="productive_flag" value="">
<INPUT TYPE="hidden" name="count" id="count" value="<%=count%>">
</form>
</body>
<%
	}
	catch (Exception e)
	{
		out.println(e.toString());
	}
	finally
	{
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
		ConnectionManager.returnConnection(con,request);
	}
%>
</html>

