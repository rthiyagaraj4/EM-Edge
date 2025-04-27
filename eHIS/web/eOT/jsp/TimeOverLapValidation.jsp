<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<% 
		String facility_id = request.getParameter("facility_id");
		String room_code = request.getParameter("room_code");
		String splty_code = request.getParameter("splty_code");
		String day_code = request.getParameter("day_code");
		String st_time = request.getParameter("start_time");
		String end_time = request.getParameter("end_time");
		String mode = request.getParameter("mode");
		String selected_weeks = request.getParameter("selected_weeks");
		//This flag checks whether days are All Days or specific days
	    boolean day_flag = ("0".equals(day_code))?true:false;
		String schedule_type =  request.getParameter("schdule_type");
		boolean schedule_flag = ("S".equals(schedule_type))?true:false;
		if(schedule_flag){
//			String[] weeks = new String[selected_weeks.length()];
		}
		String index = "";
		String wk1="";
		String wk2="";
		String wk3="";
		String wk4="";
		String wk5="";
		
		/*if("U".equals(mode)){
			out.println("Y");
			return;
		}*/
		String SQL_TIMESLOTS ="SELECT TO_CHAR(START_TIME_DATE,'HH24:MI'),TO_CHAR(END_TIME_DATE,'HH24:MI'),SCHEDULE_TYPE,FIRST_WEEK_YN,SECOND_WEEK_YN,THIRD_WEEK_YN,FOURTH_WEEK_YN,FIFTH_WEEK_YN FROM OT_SPECIALITY_TIME_TABLE  WHERE OPERATING_FACILITY_ID=?  AND OPER_ROOM_CODE =?  AND SPECIALITY_CODE= ?";
		
		String SQL_TIMESLOTS_1 ="SELECT TO_CHAR(START_TIME_DATE,'HH24:MI'),TO_CHAR(END_TIME_DATE,'HH24:MI'),SCHEDULE_TYPE,FIRST_WEEK_YN,SECOND_WEEK_YN,THIRD_WEEK_YN,FOURTH_WEEK_YN,FIFTH_WEEK_YN FROM OT_SPECIALITY_TIME_TABLE  WHERE OPERATING_FACILITY_ID=?  AND OPER_ROOM_CODE =?  AND SPECIALITY_CODE= ?  AND DAY_CODE=?";
		
		

		String SQL = (day_flag)?SQL_TIMESLOTS:SQL_TIMESLOTS_1;
		
		//1- checking start_time  2-Comparing St_time 3-Comparing EndTime
		//1- checking end_time  2-Comparing st_time 3-Comparing EndTime
		String SQL_OVERLAP ="SELECT 'X' FROM DUAL WHERE TO_DATE(?,'HH24:MI') BETWEEN TO_DATE(?,'HH24:MI') AND TO_DATE(?,'HH24:MI') UNION SELECT 'X' FROM DUAL WHERE TO_DATE(?,'HH24:MI') BETWEEN TO_DATE(?,'HH24:MI') AND TO_DATE(?,'HH24:MI')";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rst = null;
		ResultSet rst1 = null;
		boolean result = false;
		String retVal="Y";
		try{
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,room_code);
			pstmt.setString(3,splty_code);
			if(!day_flag) pstmt.setString(4,day_code);
			rst = pstmt.executeQuery();
			while(rst.next()){
				wk1 = rst.getString(4);
				wk2 = rst.getString(5);
				wk3 = rst.getString(6);
				wk4 = rst.getString(7);
				wk5 = rst.getString(8);
				pstmt1=con.prepareStatement(SQL_OVERLAP);
				pstmt1.setString(1,st_time);
				pstmt1.setString(2,rst.getString(1));
				pstmt1.setString(3,rst.getString(2));
				pstmt1.setString(4,end_time);
				pstmt1.setString(5,rst.getString(1));
				pstmt1.setString(6,rst.getString(2));
				rst1 = pstmt1.executeQuery();
				if(rst1.next()) {
					result=("X".equals(rst1.getString(1)))?true:false;
				}

				if(result){
					retVal="X";
					break;
				}
			}
			//checking week overlap
			if(schedule_flag){
				int size = selected_weeks.length();
				for(int i=0; i<size;i++){
					index = selected_weeks.substring(i,i+1);
					switch(index.charAt(0)){
						case '1': retVal = ("Y".equals(wk1))?"X":"N";break;
						case '2': retVal = ("Y".equals(wk2))?"X":"N";break;
						case '3': retVal = ("Y".equals(wk3))?"X":"N";break;
						case '4': retVal = ("Y".equals(wk4))?"X":"N";break;
						case '5': retVal = ("Y".equals(wk5))?"X":"N";break;
					}
					if("X".equals(retVal)) break;
				}
			}
			out.println(retVal);
		}catch(Exception e){
			System.err.println("Err Msg in TimeOverLapValidation.jsp"+e.getMessage());
		} finally{
			try{
				if(rst!=null) rst.close();
				if(rst1!=null) rst1.close();
				if(pstmt!=null) pstmt.close();
				if(pstmt1!=null) pstmt1.close();
				if(con!=null) ConnectionManager.returnConnection(con,request);
			}catch(Exception e){}
		}
		

%>



