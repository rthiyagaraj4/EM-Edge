<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,webbeans.eCommon.*,eDS.Common.JSONObject" contentType="text/html;charset=UTF-8" %>


<%
//Based on the action arguments its return values..By default it will return group details and total member in the group as json format.... dharma
	request.setCharacterEncoding("UTF-8");
	Connection conn=null;
	conn=ConnectionManager.getConnection(request);

try{
	String locale			= (String)session.getAttribute("LOCALE");
	String facility_id		= (String) session.getValue( "facility_id" ) ;
	String Group_id			= request.getParameter("GroupId")==null?"":request.getParameter("GroupId");
	String LOCN_NAME		= "";
	String LOCN_CODE		= "";
	String MIN_PATIENTS		= "";
	String MAX_PATIENTS		= "";
	String apptdate			= request.getParameter("apptdate")==null?"":request.getParameter("apptdate");
	String apptslabfmtime	= request.getParameter("fromtime")==null?"":request.getParameter("fromtime");
	String apptslabtotime	= request.getParameter("totime")==null?"":request.getParameter("totime");
	String cliniccode		= request.getParameter("cliniccode")==null?"":request.getParameter("cliniccode");
	String action			= request.getParameter("action")==null?"":request.getParameter("action");
	String action1			= request.getParameter("action1")==null?"":request.getParameter("action1");
	int isJsonResults		= 0;
	int TotMemberInGroup	= 0;
	int BookingCount		= 0;
	int SlabOverLapCount	= 0;
	int AvailableSlabCount	= 0;
	PreparedStatement pstmt=null;
	ResultSet rs1=null;
	
	JSONObject json = new JSONObject();
	String sql = "select  op_get_desc.op_clinic('"+facility_id+"', LOCN_CODE, '"+locale+"','1') LOCN_NAME,LOCN_CODE,MIN_PATIENTS,MAX_PATIENTS  from oa_group_hdr where GROUP_ID=?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,Group_id);
	rs1 = pstmt.executeQuery();			
	if(rs1!=null && rs1.next()) {		 
		LOCN_NAME = rs1.getString("LOCN_NAME")==null?"":rs1.getString("LOCN_NAME");
		LOCN_CODE = rs1.getString("LOCN_CODE")==null?"":rs1.getString("LOCN_CODE");	
		MIN_PATIENTS = rs1.getString("MIN_PATIENTS")==null?"":rs1.getString("MIN_PATIENTS");
		MAX_PATIENTS = rs1.getString("MAX_PATIENTS")==null?"":rs1.getString("MAX_PATIENTS");	
	} 
	
	if(!LOCN_NAME.equals("") && !MIN_PATIENTS.equals("") && !MAX_PATIENTS.equals("")){
	      json.put("LOCN_NAME", LOCN_NAME);  
	      json.put("LOCN_CODE", LOCN_CODE); 
	      json.put("MIN_PATIENTS", MIN_PATIENTS);  
	      json.put("MAX_PATIENTS", MAX_PATIENTS); 
	      isJsonResults	= 1;
	}
		
	
	
	String sql1 = "select count(*) TOTGRPMEM from OA_GROUP_DTLS where GROUP_ID=?";
	pstmt = conn.prepareStatement(sql1);
	pstmt.setString(1,Group_id);
	rs1 = pstmt.executeQuery();	
	if(rs1!=null && rs1.next()) {		 
		TotMemberInGroup = rs1.getInt("TOTGRPMEM");
	}
	json.put("TotMemberInGroup", TotMemberInGroup);

		
	if(action.equals("get_booking_count")){
		String sql2 = "select count(*) BookingCount from oa_appt where GROUP_ID='"+Group_id+"' and appt_slab_from_time=to_date('"+apptslabfmtime+"','hh24:mi') and appt_slab_to_time=to_date('"+apptslabtotime+"','hh24:mi') and appt_date=to_date('"+apptdate+"','dd/mm/yyyy') and  facility_id = '"+facility_id+"' ";
		pstmt = conn.prepareStatement(sql2);
		rs1 = pstmt.executeQuery();	
		if(rs1!=null && rs1.next()) {		 
			BookingCount = rs1.getInt("BookingCount");
		}
		json.put("BOOKING_COUNT", BookingCount);//group booking count
	}else if(action.equals("get_slap_overlap_count")){
		String Sql3	= "SELECT count(*) SlabOverLapCount  FROM oa_appt WHERE facility_id = '"+facility_id+"'   AND ((TO_DATE('"+apptslabfmtime+"','HH24:mi') + (1 / (60 * 24))   BETWEEN   TO_DATE(TO_CHAR(appt_slab_from_time, 'HH24:mi'),'HH24:mi') + (1 / (60 * 24)) AND TO_DATE (TO_CHAR (appt_slab_to_time, 'HH24:mi'), 'HH24:mi')) OR (TO_DATE ('"+apptslabtotime+"', 'HH24:mi') BETWEEN  TO_DATE (TO_CHAR (appt_slab_from_time, 'HH24:mi'),'HH24:mi') + (1 / (60 * 24)) AND TO_DATE (TO_CHAR (appt_slab_to_time, 'HH24:mi'), 'HH24:mi') ) OR (TO_DATE (TO_CHAR (appt_slab_from_time, 'hh24:miss'), 'hh24:miss') > TO_DATE ('"+apptslabfmtime+"', 'hh24:miss') AND TO_DATE (TO_CHAR (appt_slab_from_time, 'hh24:miss'),'hh24:miss') < TO_DATE ('"+apptslabtotime+"', 'hh24:miss'))) AND appt_date = TO_DATE ('"+apptdate+"', 'dd/mm/yyyy')   AND patient_id IN (SELECT patient_id FROM oa_group_dtls)";
		pstmt = conn.prepareStatement(Sql3);
		rs1 = pstmt.executeQuery();	
		if(rs1!=null && rs1.next()) {		 
			SlabOverLapCount = rs1.getInt("SlabOverLapCount");
		}
		json.put("SLAP_OVERLAP_COUNT", SlabOverLapCount);//slab over lab count

		
	
	}else if(action.equals("chk_is_group_location")){
		String locnCode			= request.getParameter("locnCode");
		int IsGroupLocation	= 0;
		String Sql5	= "SELECT count(*) GroupLocationCount  FROM oa_group_hdr WHERE ADDED_FACILITY_ID = '"+facility_id+"' and LOCN_CODE = '"+locnCode+"' ";
		pstmt = conn.prepareStatement(Sql5);
		rs1 = pstmt.executeQuery();	
		if(rs1!=null && rs1.next()) {		 
			IsGroupLocation = rs1.getInt("GroupLocationCount");
			isJsonResults	= 1;
		}
		json.put("IsGroupLocation", IsGroupLocation);
	}
	

	
	if(action1.equals("get_available_slaps_count")){
		
		String sql4 = "select count(*) AvailableSlabCount from oa_clinic_schedule_slot_slab where to_date(to_char(slot_slab_start_time,'hh24:mi'),'hh24:mi') =to_date('"+apptslabfmtime+"','hh24:mi') and to_date(to_char(slot_slab_end_time,'hh24:mi'),'hh24:mi')=to_date('"+apptslabtotime+"','hh24:mi') and CLINIC_DATE=to_date('"+apptdate+"','dd/mm/yyyy') and CLINIC_CODE='"+cliniccode+"' and FACILITY_ID='"+facility_id+"'  AND schedule_status is null";
		pstmt = conn.prepareStatement(sql4);
		System.err.println("Sql4 =>>>"+sql4);
		rs1 = pstmt.executeQuery();	
		if(rs1!=null && rs1.next()) {		 
			AvailableSlabCount = rs1.getInt("AvailableSlabCount");
			isJsonResults	= 1;
		}
		json.put("AVAILABLE_SLAP_COUNT", AvailableSlabCount);
		
	}
	
	
	
	if(pstmt != null) pstmt.close();
	if(rs1  != null) rs1.close();
	json.put("isJsonResults", isJsonResults);
	out.print(json);
	
	
}catch(Exception e) { 
	e.printStackTrace();
	
}finally{ 
	if(conn != null) {
		ConnectionManager.returnConnection(conn,request);
	}	
}                           
%>          
            
            
