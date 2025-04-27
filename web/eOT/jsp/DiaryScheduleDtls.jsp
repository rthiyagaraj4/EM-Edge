<!DOCTYPE html>
<%@page  import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.Common.*,eOT.*,eOT.Common.*" contentType=" text/html;charset=UTF-8" %>

<%-- Mandatory declarations start --%>

<%@include file="../../eCommon/jsp/Common.jsp" %>

<%-- Mandatory declarations end --%>

<% 
	String locale = (String)session.getAttribute("LOCALE");
	Connection connection	= null;
	PreparedStatement pstmt = null;
	ResultSet resultset		= null;
	String surgeon_code = request.getParameter("surgeon_code");
	String theatre_code = request.getParameter("theatre_code");
	String facility_id =(String) session.getAttribute("facility_id"); 

	String[] days = new String[]{"N","N","N","N","N","N","N"};
	String maxdate = "";
	String curdate = "";
	String date1 = "";
	try{
		connection = ConnectionManager.getConnection(request);

		String timetablesql = "SELECT DECODE(A.day_code, 0, B.day_no, A.day_code) day_code FROM ot_diary_timetable A, sm_day_of_week B WHERE A.operating_facility_id = ?   AND A.resource_id = ? AND A.oper_room_code = ? AND A.day_code = DECODE(A.day_code, '0', A.day_code, B.day_no) ORDER BY 1";     
		
		String dtuptosql = "select to_char(max(booking_date), 'dd/mm/yyyy') from OT_DIARY_SCHEDULE WHERE team_doctor_code = ? and oper_room_code = ? ";
		
		pstmt = connection.prepareStatement(timetablesql);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,surgeon_code);
		pstmt.setString(3,theatre_code);
		resultset = pstmt.executeQuery();

		while(resultset.next()){
			//days[resultset.getInt(1)-1]="Y";
			//Modified by rajesh on 04/02/09 fort passing the values to procedure as Blank instead of Y/N
			days[resultset.getInt(1)-1]="Y";
		}

		String str_days="";
		for(int i=0;i<days.length;i++){
			str_days=str_days+((i==0)?days[i]:"::"+days[i]);
	}
		if(resultset!=null)resultset.close();
		if(pstmt!=null)pstmt.close();

		pstmt = connection.prepareStatement(dtuptosql);
		pstmt.setString(1,surgeon_code);
		pstmt.setString(2,theatre_code);
		resultset = pstmt.executeQuery();
 		while(resultset.next()){
	      maxdate = resultset.getString(1);
		  maxdate=maxdate==null?"NOT_GENERATED":maxdate;
		  maxdate=maxdate.equals("null")?"NOT_GENERATED":maxdate;
		  if(!maxdate.equals("NOT_GENERATED"))
			maxdate = com.ehis.util.DateUtils.convertDate(maxdate,"DMY","en",locale);
		}

		if(resultset!=null)resultset.close();
		if(pstmt!=null)pstmt.close();

		pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
		resultset = pstmt.executeQuery();
		while(resultset.next()){
		   curdate = com.ehis.util.DateUtils.convertDate(resultset.getString("CURRENT_DATE"),"DMY","en",locale);
		}
		
  		if(resultset!=null)resultset.close();
		if(pstmt!=null)pstmt.close();
		//added  by parul for IN009461 on 5/27/2009
		String sql = "select to_char(max(booking_date)+1, 'dd/mm/yyyy') newdate from OT_DIARY_SCHEDULE WHERE	team_doctor_code = ? and oper_room_code = ? ";
			
			pstmt=connection.prepareStatement(sql);
			pstmt.setString(1,surgeon_code);
			pstmt.setString(2,theatre_code);
			resultset = pstmt.executeQuery();
 			while(resultset.next()){
			date1 = resultset.getString(1);
			}
		if(resultset!=null)resultset.close();
		if(pstmt!=null)pstmt.close();
		out.println(str_days+"@@"+maxdate+"##"+curdate+"##"+date1);

	}

	catch(Exception e){
		System.err.println("Err Msg in DiaryScheduleDtls.jsp"+e.getMessage());
	} finally{
		try{
			if(resultset!=null)resultset.close();
			if(pstmt!=null)pstmt.close();
			if(connection!=null)
			ConnectionManager.returnConnection(connection,request);
		}catch(Exception e){}
	}
	
%>

