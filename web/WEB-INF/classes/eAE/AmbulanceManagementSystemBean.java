/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eAE;
import java.io.* ;
import java.util.* ;
import java.sql.* ;
import eCommon.Common.* ;
import oracle.sql.*;

public class AmbulanceManagementSystemBean implements Serializable {

public ArrayList getAmbulanceMaintDet(String facility_id,String ambId,Connection con){
	PreparedStatement pstmt 	= null;
	ResultSet rs                = null;
	ArrayList list				= new ArrayList();
	String query="select NVL((select LONG_DESC   from MP_RES_TOWN where RES_TOWN_CODE = AMB_LOCATION and rownum <=1),AMB_LOCATION) PARKING_LOCATION ,to_char(SUSPEND_MAINT_DATE,'DD/MM/YYYY HH24:MI') SUSPEND_MAINT_DATE,SUSPEND_MAINT_PRD_VALUE,SUSPEND_MAINT_REASON,decode(SUSPEND_MAINT_PRD_TYPE,'H','Hours','D','Days') SUSPEND_MAINT_PRD_TYPE from  AE_AMB_VEHICLE WHERE	FACILITY_ID  = ? and AMB_VEHICLE_ID	= ?";
	try{
       	pstmt = con.prepareStatement(query); 
		pstmt.setString(1,facility_id);
		pstmt.setString(2,ambId);
		rs=pstmt.executeQuery();
		if(rs.next()){
			list.add(rs.getString("PARKING_LOCATION")==null?"":rs.getString("PARKING_LOCATION"));
			list.add(rs.getString("SUSPEND_MAINT_DATE")==null?"":rs.getString("SUSPEND_MAINT_DATE"));
			list.add(rs.getString("SUSPEND_MAINT_PRD_VALUE")==null?"":rs.getString("SUSPEND_MAINT_PRD_VALUE"));
			list.add(rs.getString("SUSPEND_MAINT_REASON")==null?"":rs.getString("SUSPEND_MAINT_REASON"));
			list.add(rs.getString("SUSPEND_MAINT_PRD_TYPE")==null?"":rs.getString("SUSPEND_MAINT_PRD_TYPE"));
		}

	}catch(Exception e){
		e.printStackTrace();
	}
	finally {
		try{
			if(pstmt==null)	pstmt.close();
			if(rs==null) rs.close();
			pstmt=null;
			rs=null;
		}catch(Exception es){
			es.printStackTrace();			
		}
	}
	return list;
}


public ArrayList getAmbulanceLocnDet(String facility_id,String caseno,Connection con){
	PreparedStatement pstmt 	= null;
	ResultSet rs                = null;
	ArrayList list				= new ArrayList();
	String query="SELECT NVL((select LONG_DESC   from MP_RES_TOWN where RES_TOWN_CODE = AMB_CURRENT_LOCATION and rownum <=1),A.AMB_CURRENT_LOCATION)  AMB_CURRENT_LOCATION ,REMARKS ,(select short_Desc from am_uom where uom_code = b.AMB_UOM ) Distance_Mileage ,B.AMB_START_MILEAGE AMB_START_MILEAGE , to_char(b.AMB_CASE_START_DATE,'dd/mm/yyyy hh24:mi') start_time from AE_AMB_OPEN_REQUEST A , AE_AMB_CASE_REQUEST B where a.facility_id = ? and a.amb_case_no = ? and a.facility_id = b.facility_id and a.amb_Case_no = b.amb_Case_no";
	try{
       	pstmt = con.prepareStatement(query); 
		pstmt.setString(1,facility_id);
		pstmt.setString(2,caseno);
		rs=pstmt.executeQuery();
		if(rs.next()){
			list.add(rs.getString("AMB_CURRENT_LOCATION")==null?"":rs.getString("AMB_CURRENT_LOCATION"));
			list.add(rs.getString("REMARKS")==null?"":rs.getString("REMARKS"));
			list.add(rs.getString("DISTANCE_MILEAGE")==null?"":rs.getString("DISTANCE_MILEAGE"));
			list.add(rs.getString("AMB_START_MILEAGE")==null?"":rs.getString("AMB_START_MILEAGE"));
			list.add(rs.getString("START_TIME")==null?"":rs.getString("START_TIME"));
		}

	}catch(Exception e){
		e.printStackTrace();
	}
	finally {
		try{
			if(pstmt==null)	pstmt.close();
			if(rs==null) rs.close();
			pstmt=null;
			rs=null;
		}catch(Exception es){
			es.printStackTrace();			
		}
	}
	return list;
}

public String loadDestn(String caseno,String facility_id,Connection con){
	PreparedStatement pstmt 	= null;
	ResultSet rs                = null;
	String destn				="";
	String query="select destn_locn_desc from ae_amb_case_request  where amb_case_no=? and facility_id=?";
	try{
       	pstmt = con.prepareStatement(query); 
		pstmt.setString(1,caseno);
		pstmt.setString(2,facility_id);
		rs=pstmt.executeQuery();
		if(rs.next()){
			destn=rs.getString(1)==null?"":rs.getString(1);
		}

	}catch(Exception e){
		e.printStackTrace();
	}
	finally {
		try{
			if(pstmt==null)	pstmt.close();
			if(rs==null) rs.close();
			pstmt=null;
			rs=null;
		}catch(Exception es){
			es.printStackTrace();			
		}
	}
	return destn;
}

public ArrayList getVehicleDet(String ambid,String facility_id,Connection con){
	PreparedStatement pstmt 	= null;
	ResultSet rs                = null;
	ArrayList list				= new ArrayList();
	String query="SELECT   a.amb_vehicle_id amb_vehicle_id, a.amb_regn_no amb_regn_no,(CASE WHEN a.suspend_maint_yn = 'Y' THEN 'M' ELSE CASE WHEN a.suspend_maint_yn = 'N' AND EXISTS (SELECT 'Y' FROM ae_amb_open_request WHERE facility_id = a.facility_id AND amb_vehicle_id = a.amb_vehicle_id) THEN 'A' ELSE CASE WHEN a.suspend_maint_yn = 'N' AND NOT EXISTS (SELECT 'Y' FROM ae_amb_open_request WHERE facility_id = a.facility_id AND amb_vehicle_id = a.amb_vehicle_id) THEN 'B' END END END) amb_status,b.amb_case_no amb_case_no,(SELECT patient_name || '/' || sex || '/' || get_age (date_of_birth) FROM ae_amb_case_request WHERE facility_id = b.facility_id AND amb_case_no = b.amb_case_no) patient_dtls, a.amb_location amb_park_location, (SELECT (SELECT practitioner_name FROM am_pract_for_amb_vw WHERE practitioner_id = amb_resource_id AND pract_source = amb_resource_type) FROM ae_amb_vehicle_resource WHERE facility_id = a.facility_id AND amb_vehicle_id = a.amb_vehicle_id AND contact_disply_yn = 'Y') amb_cont_name, (SELECT (SELECT contact_no FROM am_pract_for_amb_vw WHERE practitioner_id = amb_resource_id AND pract_source = amb_resource_type) FROM ae_amb_vehicle_resource WHERE facility_id = a.facility_id AND amb_vehicle_id = a.amb_vehicle_id AND contact_disply_yn = 'Y') amb_cont_phone, amb_vehicle_type, (CASE WHEN 'Y' = (SELECT 'Y' FROM ae_amb_open_request WHERE facility_id = a.facility_id AND amb_vehicle_id = a.amb_vehicle_id) THEN b.amb_current_location ELSE a.amb_location END ) amb_location FROM ae_amb_vehicle a, ae_amb_open_request b WHERE a.facility_id = ? AND a.eff_status = 'E' AND a.facility_id = b.facility_id(+) AND a.amb_vehicle_id = b.amb_vehicle_id(+) AND a.amb_vehicle_id=?";
	try{
       	pstmt = con.prepareStatement(query); 
		pstmt.setString(1,facility_id);
		pstmt.setString(2,ambid);
		rs=pstmt.executeQuery();
		if(rs.next()){
			list.add(rs.getString("amb_vehicle_id")==null?"":rs.getString("amb_vehicle_id"));
			list.add(rs.getString("amb_regn_no")==null?"":rs.getString("amb_regn_no"));
			list.add(rs.getString("amb_location")==null?"":rs.getString("amb_location"));
			list.add(rs.getString("amb_status")==null?"":rs.getString("amb_status"));
			list.add(rs.getString("amb_cont_name")==null?"":rs.getString("amb_cont_name"));
			list.add(rs.getString("amb_cont_phone")==null?"":rs.getString("amb_cont_phone"));
			list.add(rs.getString("amb_vehicle_type")==null?"":rs.getString("amb_vehicle_type"));
			list.add(rs.getString("patient_dtls")==null?"":rs.getString("patient_dtls"));
		}

	}catch(Exception e){
		e.printStackTrace();
	}
	finally {
		try{
			if(pstmt==null)	pstmt.close();
			if(rs==null) rs.close();
			pstmt=null;
			rs=null;
		}catch(Exception es){
			es.printStackTrace();			
		}
	}
	return list;

}
}
