<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,webbeans.eCommon.*,eDS.Common.JSONObject,eDS.Common.JSONArray,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%
// This file added by dharma this file retruns only a json array....
	request.setCharacterEncoding("UTF-8");
	Connection conn=null;
	conn=ConnectionManager.getConnection(request);

try{
	String locale					= (String)session.getAttribute("LOCALE");
	String facility_id				= (String) session.getValue( "facility_id" ) ;
	String action					= request.getParameter("action")==null?"":request.getParameter("action");
	String patient_id				= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	int rowcnt					= 0;
	
	PreparedStatement pstmt			= null;
	ResultSet rs					= null;
	JSONObject json 				= new JSONObject();
	if(action.equals("get_service_details")){
		String dept_code				= request.getParameter("dept_code")==null?"":request.getParameter("dept_code");
		String recordslist			= "";

		String service_code					= "";
		String short_desc					= "";
	
		
		String  sql = "select SERVICE_CODE, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"',2) short_desc from AM_FACILITY_SERVICE_VW a where eff_status='E' and operating_facility_id=? and dept_code=? order by short_desc";
		pstmt		= conn.prepareStatement(sql.toString());
		pstmt.setString(1,facility_id);
	 	pstmt.setString(2,dept_code);
	  	rs = pstmt.executeQuery();
		JSONArray JsonlistArr = new JSONArray();
		while(rs.next()){
	 		JSONObject jsonobj		= new JSONObject();
	 		service_code			= rs.getString("service_code");
	 		short_desc				= rs.getString("short_desc");
	 		jsonobj.put("service_code",service_code);
	 		jsonobj.put("short_desc",short_desc);
			JsonlistArr.put(jsonobj);
			rowcnt++;
		}
		if(rowcnt>0){
			recordslist = JsonlistArr.toString();	
		}
		if(pstmt != null) pstmt.close();
		if(rs  != null) rs.close();
		json.put("recordslist", recordslist);
		json.put("rowcnt", rowcnt);
		out.print(json);
	}else if(action.equals("get_embalm_completed_status")){
		String  sql = "select 1 from mo_embalm_service where EMBALM_AT_HOSPITAL_YN = 'Y' and embalm_status < '04' and patient_id = ?  and facility_id = ?";
		pstmt		= conn.prepareStatement(sql.toString());
		pstmt.setString(1,patient_id);
	 	pstmt.setString(2,facility_id);
	  	rs = pstmt.executeQuery();
		while(rs.next()){
			rowcnt++;
		}
		if(pstmt != null) pstmt.close();
		if(rs  != null) rs.close();
		json.put("rowcnt", rowcnt);
		out.print(json);
	}
}catch(Exception e) { 
	e.printStackTrace();
	
}finally{ 
	if(conn != null) {
		ConnectionManager.returnConnection(conn,request);
	}	
}                           
%>          
            
            
