<!DOCTYPE html>

<%@ page import ="java.sql.*,java.util.*,java.net.*,webbeans.eCommon.*,eDS.Common.JSONObject,eDS.Common.JSONArray" contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
	Connection conn=null;
	conn=ConnectionManager.getConnection(request);
	try{
		String locale			= (String)session.getAttribute("LOCALE");
		String facility_id		= (String) session.getValue( "facility_id" ) ;
		String pract_id			= request.getParameter("pract_id")==null?"":request.getParameter("pract_id");
		String block_date		= request.getParameter("block_date")==null?"":request.getParameter("block_date");
		String block_time		= request.getParameter("block_time")==null?"":request.getParameter("block_time");
		String clinic_code		= request.getParameter("cl_code")==null?"":request.getParameter("cl_code");
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		if(block_time.equals("")){
			String sql = "select to_char(sysdate,'hh24:mi:ss') SysTime from dual";
			pstmt = conn.prepareStatement(sql);
			//System.err.println("sql==>"+sql);
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()){
				block_time		= rs.getString("SysTime");
			}
			if(pstmt != null) pstmt.close();
			if(rs  != null) rs.close();
		}
		
		boolean isJsonResults		= false;
		JSONObject json = new JSONObject();
		
		String sql1	= "SELECT 1 FROM oa_block_appt WHERE block_date = TO_DATE (?, 'dd/mm/yyyy') AND facility_id = ? AND practitioner_id = ?  AND TO_DATE (TO_CHAR (effective_from_date_time, 'dd/mm/yyyy') || ?,'dd/mm/yyyy hh24:mi:ss') BETWEEN effective_from_date_time AND effective_to_date_time AND CLINIC_CODE=?";
		pstmt = conn.prepareStatement(sql1);
		
		pstmt.setString(1,block_date);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,pract_id);
		pstmt.setString(4,block_time);
		pstmt.setString(5,clinic_code);
		//System.err.println("sql1==>"+sql1);
		rs = pstmt.executeQuery();
		if(rs!=null && rs.next()){
			isJsonResults	= true;	
		}
		if(!isJsonResults){
			if(pstmt != null) pstmt.close();
			if(rs  != null) rs.close();
		
			String sql2	= "SELECT SCHEDULE_STATUS FROM oa_clinic_schedule WHERE clinic_date = TO_DATE (?, 'dd/mm/yyyy') AND practitioner_id = ? AND facility_id	= ? and schedule_status='B' AND CLINIC_CODE=?";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1,block_date);
			pstmt.setString(2,pract_id);
			pstmt.setString(3,facility_id);
			pstmt.setString(4,clinic_code);
			rs = pstmt.executeQuery();
			//System.err.println("sql2==>"+sql2);
			if(rs!=null && rs.next()){
				isJsonResults	= true;	
			}
		}
		json.put("isJsonResults", isJsonResults);
		json.put("block_time", block_time);
		out.print(json);
		if(pstmt != null) pstmt.close();
		if(rs  != null) rs.close();
		
	}catch(Exception e) { 
		e.printStackTrace();
		
	}finally{ 
		if(conn != null) {
			ConnectionManager.returnConnection(conn,request);
		}	
	}                           
%>          
            
            
