<!DOCTYPE html>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

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
<!-- <script language="JavaScript" src="../../eRS/js/RSMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
<%		
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt_staff = null;
	ResultSet rs_staff = null;

    try
	{
	con = ConnectionManager.getConnection(request);
	String p_facility_id  = request.getParameter("p_facility_id");
	String p_workplace_code = request.getParameter("p_workplace_code");
	String p_role_type  = request.getParameter("p_role_type");
	String p_staff_id  = request.getParameter("p_staff_id");
	String p_position_code  = request.getParameter("p_position_code");
	String staff1_shift_code  = request.getParameter("staff1_shift_code");
	String p_schedule_date=request.getParameter("p_schedule_date");
	String grade_code=request.getParameter("grade_code");
	String staff1_grade_level=request.getParameter("grade_level");
	String staff_subs_same_grade_yn=request.getParameter("staff_subs_same_grade_yn");
    String staff_subs_high_to_low_yn=request.getParameter("staff_subs_high_to_low_yn");
	String staff_subs_low_to_high_yn=request.getParameter("staff_subs_low_to_high_yn");
	String workplace_code="";
	String workplace_desc="";
	String staff_id="";
	String staff_name="";
	String p_requirement_id="";

	String sql_requirement_v="Select requirement_id from rs_workplace_requirement where facility_id = ? and workplace_code =? and requirement_type = 'V' and to_date(?,'dd/mm/yyyy') between requirement_date_fm and requirement_date_to";
	pstmt=con.prepareStatement(sql_requirement_v);
	pstmt.setString(1,p_facility_id);
	pstmt.setString(2,p_workplace_code);
	pstmt.setString(3,p_schedule_date);
	rs=pstmt.executeQuery();
	while(rs!=null && rs.next()){
		p_requirement_id = rs.getString("requirement_id");
		
	}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	if(p_requirement_id=="" || p_requirement_id==null){
		String sql_requirement_c="Select requirement_id from rs_workplace_requirement where facility_id = ? and workplace_code = ? and requirement_type = 'C'and requirement_date_fm is null and requirement_date_to is null";
		pstmt=con.prepareStatement(sql_requirement_c);
		pstmt.setString(1,p_facility_id);
		pstmt.setString(2,p_workplace_code);
		rs=pstmt.executeQuery();
		while(rs!=null && rs.next()){
			p_requirement_id = rs.getString("requirement_id");
		 }
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
	}
	String sql="select distinct a.role_type,a.staff_id,a.staff_name from rs_work_schedule c, am_staff_vw a, rs_grade b where c.facility_id = ? and c.workplace_code =? and c.schedule_date = to_date(?,'dd/mm/yyyy') and c.position_code = ? and c.role_type = ? and c.staff_id != ? and a.role_type = c.role_type and a.staff_id = c.staff_id and b.grade_code = a.grade_code ";

	if(staff_subs_same_grade_yn.equalsIgnoreCase("Y") || staff_subs_high_to_low_yn.equalsIgnoreCase("Y") || staff_subs_low_to_high_yn.equalsIgnoreCase("Y")){
		sql = sql + " and ( ";
	}
	
	int flag = 0;
	if(staff_subs_same_grade_yn.equalsIgnoreCase("Y")){
		sql = sql +	" b.grade_level = '"+staff1_grade_level+"' ";
		flag = 1;
	}
	if(staff_subs_high_to_low_yn.equalsIgnoreCase("Y")){
		if(flag == 1){
			sql = sql + " or ";
		}
		sql = sql + " b.grade_level > '"+staff1_grade_level+"' ";
		flag = 1;
	}	

	if(staff_subs_low_to_high_yn.equalsIgnoreCase("Y")){
		if(flag == 1){
			sql = sql + " or ";
		}
		sql = sql + " b.grade_level < '"+staff1_grade_level+"' ";
	}

	if(staff_subs_same_grade_yn.equalsIgnoreCase("Y") || staff_subs_high_to_low_yn.equalsIgnoreCase("Y") || staff_subs_low_to_high_yn.equalsIgnoreCase("Y")){
		sql = sql + " ) ";
	}
	sql = sql + " order by a.staff_name ";
%>
</head>
<body>
<form name="ManageWorkScheduleSwap1" id="ManageWorkScheduleSwap1" action='' target='blankFrame' method="post">
<table cellpadding=0 cellspacing=0 border=0 width="100%" align='right'>
<tr>
	<td class='label' width='30%' align='right'><fmt:message key="eRS.WorkPlace.label" bundle="${rs_labels}"/></td>
	<td>&nbsp;&nbsp;&nbsp;<SELECT name="new_workplace" id="new_workplace" onchange="populateStaff(this.form)">
<%	
//String sql_work="select facility_id,workplace_code,workplace_desc from rs_workplace where facility_id = ? and workplace_code in(select workplace_code from rs_staff_for_workplace where facility_id = ? and role_type = ? and staff_id = ? and to_date(?,'dd/mm/yyyy') between eff_date_from and nvl(eff_date_to,to_date('31/12/2200','dd/mm/yyyy'))) and workplace_code in (SELECT a.workplace_code FROM RS_WORKPLACE_REQUIREMENT a  WHERE a.facility_id = ?  AND a.requirement_type = 'V' AND TO_DATE(?,'dd/mm/yyyy') BETWEEN a.requirement_date_fm AND a.requirement_date_to AND ? = (select shift_code from rs_workplace_requirement_dtl where facility_id = ? and workplace_code = a.workplace_code and requirement_id = a.requirement_id   and position_code = ? and shift_code =?) AND EXISTS(select shift_code from rs_workplace_requirement_dtl where facility_id = ? and workplace_code = ? and requirement_id = ? and position_code = ? and shift_code !=? intersect select shift_code from rs_workplace_requirement_dtl where facility_id = a.facility_id and workplace_code = a.workplace_code and requirement_id = a.requirement_id and position_code =? and shift_code !=?) UNION SELECT a.workplace_code FROM RS_WORKPLACE_REQUIREMENT a WHERE a.facility_id =? AND a.requirement_type = 'C' AND a.requirement_date_fm IS NULL AND a.requirement_date_to IS NULL  AND ? =(select shift_code from rs_workplace_requirement_dtl where facility_id = ? and workplace_code = a.workplace_code and requirement_id = a.requirement_id and position_code = ? and shift_code =?)AND  EXISTS (select shift_code from rs_workplace_requirement_dtl where facility_id = ?  and workplace_code = ? and requirement_id = ? and position_code = ? and shift_code !=? intersect select shift_code from rs_workplace_requirement_dtl where facility_id = a.facility_id and workplace_code = a.workplace_code and requirement_id = a.requirement_id and position_code = ? and shift_code != ?))";

    /*System.err.println("p_facility_id----"+p_facility_id);
	System.err.println("p_facility_id----"+p_facility_id);
	System.err.println("p_role_type----"+p_role_type);
	System.err.println("p_staff_id----"+p_staff_id);
	System.err.println("p_schedule_date----"+p_schedule_date);
	System.err.println("p_facility_id----"+p_facility_id);
	System.err.println("p_schedule_date----"+p_schedule_date);
	System.err.println("staff1_shift_code----"+staff1_shift_code);
	System.err.println("p_facility_id----"+p_facility_id);
	System.err.println("p_position_code----"+p_position_code);
	System.err.println("staff1_shift_code----"+staff1_shift_code);
	System.err.println("p_facility_id----"+p_facility_id);
	System.err.println("p_workplace_code----"+p_workplace_code);
	System.err.println("p_requirement_id----"+p_requirement_id);
	System.err.println("p_position_code----"+p_position_code);
	System.err.println("staff1_shift_code----"+staff1_shift_code);
	System.err.println("p_position_code----"+p_position_code);
	System.err.println("staff1_shift_code----"+staff1_shift_code);
	System.err.println("p_facility_id----"+p_facility_id);
	System.err.println("staff1_shift_code----"+staff1_shift_code);
	System.err.println("p_facility_id----"+p_facility_id);
	System.err.println("p_position_code----"+p_position_code);
	System.err.println("staff1_shift_code----"+staff1_shift_code);
	System.err.println("p_facility_id----"+p_facility_id);
	System.err.println("p_workplace_code----"+p_workplace_code);
	System.err.println("p_requirement_id----"+p_requirement_id);
	System.err.println("p_position_code----"+p_position_code);
	System.err.println("staff1_shift_code----"+staff1_shift_code);
	System.err.println("p_position_code----"+p_position_code);
	System.err.println("staff1_shift_code----"+staff1_shift_code);
	System.err.println("locale----"+locale);  */


String sql_work="select facility_id,workplace_code,workplace_desc from rs_workplace_lang_vw where facility_id = ? and workplace_code in(select workplace_code from rs_staff_for_workplace where facility_id = ? and role_type = ? and staff_id = ? and to_date(?,'dd/mm/yyyy') between eff_date_from and nvl(eff_date_to,to_date('31/12/2200','dd/mm/yyyy'))) and workplace_code in (SELECT a.workplace_code FROM rs_workplace_requirement a  WHERE a.facility_id = ?  AND a.requirement_type = 'V' AND TO_DATE(?,'dd/mm/yyyy') BETWEEN a.requirement_date_fm AND a.requirement_date_to AND ? = (select shift_code from rs_workplace_requirement_dtl where facility_id = ? and workplace_code = a.workplace_code and requirement_id = a.requirement_id   and position_code = ? and shift_code =?) AND EXISTS(select shift_code from rs_workplace_requirement_dtl where facility_id = ? and workplace_code = ? and requirement_id = ? and position_code = ? and shift_code !=? intersect select shift_code from rs_workplace_requirement_dtl where facility_id = a.facility_id and workplace_code = a.workplace_code and requirement_id = a.requirement_id and position_code =? and shift_code !=?) UNION SELECT a.workplace_code FROM RS_WORKPLACE_REQUIREMENT a WHERE a.facility_id =? AND a.requirement_type = 'C' AND a.requirement_date_fm IS NULL AND a.requirement_date_to IS NULL  AND ? =(select shift_code from rs_workplace_requirement_dtl where facility_id = ? and workplace_code = a.workplace_code and requirement_id = a.requirement_id and position_code = ? and shift_code =?)AND  EXISTS (select shift_code from rs_workplace_requirement_dtl where facility_id = ?  and workplace_code = ? and requirement_id = ? and position_code = ? and shift_code !=? intersect select shift_code from rs_workplace_requirement_dtl where facility_id = a.facility_id and workplace_code = a.workplace_code and requirement_id = a.requirement_id and position_code = ? and shift_code != ?)) and language_id = ?";

	pstmt = con.prepareStatement(sql_work);
	pstmt.setString(1,p_facility_id);
	pstmt.setString(2,p_facility_id);
	pstmt.setString(3,p_role_type);
	pstmt.setString(4,p_staff_id);
	pstmt.setString(5,p_schedule_date);
	pstmt.setString(6,p_facility_id);
	pstmt.setString(7,p_schedule_date);
	pstmt.setString(8,staff1_shift_code);
	pstmt.setString(9,p_facility_id);
	pstmt.setString(10,p_position_code);
	pstmt.setString(11,staff1_shift_code);
	pstmt.setString(12,p_facility_id);
	pstmt.setString(13,p_workplace_code);
	pstmt.setString(14,p_requirement_id);
	pstmt.setString(15,p_position_code);
	pstmt.setString(16,staff1_shift_code);
	pstmt.setString(17,p_position_code);
	pstmt.setString(18,staff1_shift_code);
	pstmt.setString(19,p_facility_id);
	pstmt.setString(20,staff1_shift_code);
	pstmt.setString(21,p_facility_id);
	pstmt.setString(22,p_position_code);
	pstmt.setString(23,staff1_shift_code);
	pstmt.setString(24,p_facility_id);
	pstmt.setString(25,p_workplace_code);
	pstmt.setString(26,p_requirement_id);
	pstmt.setString(27,p_position_code);
	pstmt.setString(28,staff1_shift_code);
	pstmt.setString(29,p_position_code);
	pstmt.setString(30,staff1_shift_code);
	pstmt.setString(31,locale);

	rs = pstmt.executeQuery();

	if(rs!=null){
		while(rs.next()){
			workplace_code = rs.getString("workplace_code");
			workplace_desc= rs.getString("workplace_desc");
			if(workplace_code.equalsIgnoreCase(p_workplace_code)){
			  out.println("<option selected value='"+workplace_code+"'>"+workplace_desc+"</option>");
			}
			else{
			  out.println("<option value='"+workplace_code+"'>"+workplace_desc+"</option>");
			}
		}
	}
	if(pstmt!=null) pstmt.close();
	if(rs!=null) rs.close();
%>
	</SELECT>&nbsp;<img src="../../eCommon/images/mandatory.gif">
	</td>
	<td>&nbsp;</td>
</tr>

<tr>
	<td class='label' width='30%' align='right'><fmt:message key="eRS.Staff.label" bundle="${rs_labels}"/></td>
	<td>&nbsp;&nbsp;&nbsp;<SELECT name="new_staff" id="new_staff" onchange="populateNewShifts()">
	<option value"">------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
<%
	System.err.println("sql------->"+sql);

	pstmt_staff = con.prepareStatement(sql);
    pstmt_staff.setString(1,p_facility_id);
    pstmt_staff.setString(2,p_workplace_code);
    pstmt_staff.setString(3,p_schedule_date);
    pstmt_staff.setString(4,p_position_code);
    pstmt_staff.setString(5,p_role_type);
    pstmt_staff.setString(6,p_staff_id);

   System.err.println("p_facility_id------->"+p_facility_id);
   System.err.println("p_workplace_code------->"+p_workplace_code);
   System.err.println("p_schedule_date------->"+p_schedule_date);
   System.err.println("p_position_code------->"+p_position_code);
   System.err.println("p_role_type------->"+p_role_type);
   System.err.println("p_staff_id------->"+p_staff_id);
	rs_staff = pstmt_staff.executeQuery();
	 
	if(rs_staff!=null){
		while(rs_staff.next()){
			staff_id = rs_staff.getString("staff_id");
			staff_name= rs_staff.getString("staff_name");
			out.println("<option value="+staff_id+'>'+staff_name+"</option>");
		}
	}
	if(pstmt_staff!=null) pstmt_staff.close();
	if(rs_staff!=null) rs_staff.close();
	
%>
	</SELECT>&nbsp;<img src="../../eCommon/images/mandatory.gif">
	</td>
	<td>&nbsp;</td>

</table>
<INPUT TYPE="hidden" name="new_staff_id" id="new_staff_id" value="">
<INPUT TYPE="hidden" name="new_workplace_code" id="new_workplace_code" value="">
<INPUT TYPE="hidden" name="p_workplace_code" id="p_workplace_code" value="<%=p_workplace_code%>">
<INPUT TYPE="hidden" name="p_requirement_id" id="p_requirement_id" value="<%=p_requirement_id%>">
<INPUT TYPE="hidden" name="p_schedule_date" id="p_schedule_date" value="<%=p_schedule_date%>">
<INPUT TYPE="hidden" name="p_role_type" id="p_role_type" value="<%=p_role_type%>">
<INPUT TYPE="hidden" name="p_staff_id" id="p_staff_id" value="<%=p_staff_id%>">
<INPUT TYPE="hidden" name="p_position_code" id="p_position_code" value="<%=p_position_code%>">
<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" value="<%=p_facility_id%>">
<INPUT TYPE="hidden" name="grade_code" id="grade_code" value="<%=grade_code%>">
<INPUT TYPE="hidden" name="grade_level" id="grade_level" value="<%=staff1_grade_level%>">
<INPUT TYPE="hidden" name="staff_subs_same_grade_yn" id="staff_subs_same_grade_yn" value="<%=staff_subs_same_grade_yn%>">
<INPUT TYPE="hidden" name="staff_subs_high_to_low_yn" id="staff_subs_high_to_low_yn" value="<%=staff_subs_high_to_low_yn%>">
<INPUT TYPE="hidden" name="staff_subs_low_to_high_yn" id="staff_subs_low_to_high_yn" value="<%=staff_subs_low_to_high_yn%>">

</form>
</body>
<%
	}
	catch (Exception e){
		out.println(e.toString());
	}
	finally{
		if(rs_staff!=null) rs_staff.close();
		if(pstmt_staff!=null) pstmt_staff.close();
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		ConnectionManager.returnConnection(con,request);
	}
%>
</html>
	

