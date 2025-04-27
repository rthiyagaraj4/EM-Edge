<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%		
	

	String p_facility_id  = request.getParameter("p_facility_id");
	String new_workplace_code = request.getParameter("new_workplace_code");
	String p_role_type  = request.getParameter("p_role_type");
	String p_staff_id  = request.getParameter("p_staff_id");
	String p_position_code  = request.getParameter("p_position_code");
	String p_schedule_date=request.getParameter("p_schedule_date");
	String staff1_grade_level=request.getParameter("grade_level");
	String staff_subs_same_grade_yn=request.getParameter("staff_subs_same_grade_yn");
    String staff_subs_high_to_low_yn=request.getParameter("staff_subs_high_to_low_yn");
	String staff_subs_low_to_high_yn=request.getParameter("staff_subs_low_to_high_yn");
		
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	String staff_id="";
	String staff_name="";
	String comp=" ";
				
	try{	
		con = ConnectionManager.getConnection(request);
		String sql="select distinct a.role_type,a.staff_id,a.staff_name from rs_work_schedule c, am_staff_vw a, rs_grade b where c.facility_id = ? and c.workplace_code =? and c.schedule_date = to_date(?,'dd/mm/yyyy') and c.position_code =? and c.role_type = ? and c.staff_id != ? and a.role_type = c.role_type and a.staff_id = c.staff_id and b.grade_code = a.grade_code ";

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
		System.err.println("sql---->"+sql);
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,p_facility_id);
		pstmt.setString(2,new_workplace_code);
		pstmt.setString(3,p_schedule_date);
		pstmt.setString(4,p_position_code);
		pstmt.setString(5,p_role_type);
		pstmt.setString(6,p_staff_id);
		rs = pstmt.executeQuery();
		//System.err.println("rs------>"+rs);
		while( rs!=null && rs.next()){
			staff_id=rs.getString("staff_id");
			staff_name=rs.getString("staff_name");
			comp="parent.ManageWorkScheduleSwap_frame.document.forms[0].new_staff";

%>
	<script>
			var temp_id = "<%=staff_id%>";
			var temp_name="<%=staff_name%>";
			var opt=parent.ManageWorkScheduleSwap_frame.document.createElement("OPTION");
			opt.text=temp_name;
			opt.value=temp_id;
			var comp=<%=comp%>;
			comp.add(opt)
	</script>
<%	
		
		}
		if(pstmt != null)
			pstmt.close();
		if(rs != null)
			rs.close();
	}
	catch(Exception e){
		out.print(e);
	}
	finally {
		if(pstmt != null)
			pstmt.close();
		if(rs != null)
			rs.close();
		ConnectionManager.returnConnection(con,request);
	}
%>
