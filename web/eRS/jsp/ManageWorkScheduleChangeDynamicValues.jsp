<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<!-- <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> -->
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String shift_val = request.getParameter("shift_val");
	String p_schedule_date = request.getParameter("p_schedule_date");

	try{
		con = ConnectionManager.getConnection(request);
		//String sql = "select decode(SHIFT_INDICATOR,'P','Productive','U','Unproductive') SHIFT_INDICATOR,decode(PRODUCTIVE_FLAG,'W','Working','O','Oncall') PRODUCTIVE_FLAG,mnemonic_key new_mnemonic,?||to_char(shift_start_time,'hh24:mi') shift_start_time,to_char(to_date(?,'dd/mm/yyyy')+            decode(sign(to_date(to_char(shift_start_time,'hh24:mi'),'hh24:mi') -                    to_date(to_char(shift_end_time,'hh24:mi'),'hh24:mi')),1,1,0 ),'dd/mm/yyyy') ||to_char(shift_end_time,'hh24:mi')   shift_end_time from am_shift where shift_code=?";
		String sql = "select decode(SHIFT_INDICATOR,'P','Productive','U','Unproductive') SHIFT_INDICATOR,decode(PRODUCTIVE_FLAG,'W','Working','O','Oncall') PRODUCTIVE_FLAG,mnemonic_key new_mnemonic,?||to_char(shift_start_time,'hh24:mi') shift_start_time,to_char(to_date(?,'dd/mm/yyyy')+            decode(sign(to_date(to_char(shift_start_time,'hh24:mi'),'hh24:mi') -                    to_date(to_char(shift_end_time,'hh24:mi'),'hh24:mi')),1,1,0 ),'dd/mm/yyyy') ||to_char(shift_end_time,'hh24:mi')   shift_end_time from am_shift where shift_code=?";

		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,p_schedule_date);
		pstmt.setString(2,p_schedule_date);
		pstmt.setString(3,shift_val);
		rs = pstmt.executeQuery();
		String new_shift_indicator = "";
		String new_productive_flag = "";
		String new_mnemonic="";
		String new_shift_start_time="";
		String new_shift_end_time="";
		String new_shft_indicator_chng="";
		String new_shft_product_flag_chng="";

		if(rs!=null){
			if(rs.next()){
				new_shift_indicator = rs.getString("SHIFT_INDICATOR")==null?"":rs.getString("SHIFT_INDICATOR");
				new_productive_flag = rs.getString("PRODUCTIVE_FLAG")==null?"":rs.getString("PRODUCTIVE_FLAG");
				new_mnemonic = rs.getString("new_mnemonic");
				new_shift_start_time = rs.getString("shift_start_time");
				new_shift_end_time = rs.getString("shift_end_time");
			}
			if(pstmt!=null) pstmt.close();
			if(rs!=null) rs.close();

			if(new_shift_indicator.equalsIgnoreCase("Productive")){
				new_shft_indicator_chng="P";
			}
			else if(new_shift_indicator.equalsIgnoreCase("Unproductive")){
				new_shft_indicator_chng="U";
			}

			if(new_productive_flag.equalsIgnoreCase("Working")){
				new_shft_product_flag_chng="W";
			}
			else if(new_productive_flag.equalsIgnoreCase("Oncall")){
				new_shft_product_flag_chng="O";
			}
		}
%>
<script>
	
	parent.ManageWorkScheduleChange_frame.document.getElementById("productive").innerText=""+"    "+"<%=new_shift_indicator%>"+"      "+"<%=new_productive_flag%>";
	parent.ManageWorkScheduleChange_frame.document.ChangeShift.new_mnemonic.value = "<%=new_mnemonic%>";
	parent.ManageWorkScheduleChange_frame.document.ChangeShift.new_shift_start_time.value = "<%=new_shift_start_time%>";
	parent.ManageWorkScheduleChange_frame.document.ChangeShift.new_shift_end_time.value = "<%=new_shift_end_time%>";
	parent.ManageWorkScheduleChange_frame.document.ChangeShift.new_shift_indicator.value = "<%=new_shft_indicator_chng%>";
	parent.ManageWorkScheduleChange_frame.document.ChangeShift.new_productive_flag.value = "<%=new_shft_product_flag_chng%>";

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
