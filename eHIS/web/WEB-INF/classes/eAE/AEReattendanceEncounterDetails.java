package eAE;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.util.*;
import java.io.*;
import webbeans.eCommon.*;


public class AEReattendanceEncounterDetails implements Serializable {

public static ArrayList getAEEncounterDetails(Connection con, String Patient_id,String facilityId,java.util.Properties p) throws Exception{
    PreparedStatement pstmt		= null;
	ResultSet rs = null;
	ArrayList arrayList	= null;
	String sqlQuery = "";
	AEReattendanceEncounterDetailsBean  EncounterDetailsBean=null; 
	String locale = p.getProperty("LOCALE");
	try{
		arrayList=new ArrayList();
		
	    sqlQuery="select to_char (discharge_date_time,'DD/MM/YYYY HH24:MI:SS') discharge_date_time,to_char (visit_adm_date_time,'DD/MM/YYYY HH24:MI:SS') visit_adm_date_time,to_char (sysdate, 'DD/MM/YYYY HH24:MI:SS') crrent_date, op_get_desc.op_clinic(facility_id,                              assign_care_locn_code,'"+locale+"',2) clinic_desc,(select max_hrs_for_re_attend from ae_param where operating_facility_id = '"+facilityId+"') maxhrsforreattend  from pr_encounter where discharge_date_time =(select max (discharge_date_time) as discharge_date_time from pr_encounter where patient_id = '"+Patient_id+"' and patient_class in ('EM') and discharge_date_time is not null and facility_id = '"+facilityId+"' and visit_status  = '07') and patient_class in ('EM') and discharge_date_time is not null and facility_id = '"+facilityId+"' and visit_status = '07'";
 
        System.err.println("AEReattendanceEncounterDetails.java sqlQuery===>"+sqlQuery);	   
		pstmt = con.prepareStatement(sqlQuery);			
		//pstmt.setString(1, facilityId);		
		//pstmt.setString(2, Patient_id);
		rs=pstmt.executeQuery();
		if(rs!=null && rs.next()){
		  EncounterDetailsBean=new AEReattendanceEncounterDetailsBean();		
		  EncounterDetailsBean.setDischargedate(checkForNull(rs.getString("discharge_date_time"))); 		 
		  EncounterDetailsBean.setVisitdate(checkForNull(rs.getString("visit_adm_date_time")));
          EncounterDetailsBean.setCurrentdate(checkForNull(rs.getString("crrent_date")));	
          EncounterDetailsBean.setClinicdesc(checkForNull(rs.getString("clinic_desc")));
          EncounterDetailsBean.setMaxhrsforreattend(checkForNull(rs.getString("maxhrsforreattend"))); 		  
		  arrayList.add(EncounterDetailsBean);
		 }
		if(rs!=null) rs.close(); 
		if(pstmt!=null) pstmt.close(); 

	}catch(Exception e){
		e.printStackTrace();
	}	
	return arrayList;
	
	}
	
public static String getAEReattendanceDetails(Connection con, String facilityId,java.util.Properties p) throws Exception{
	 
	PreparedStatement pstmt		= null;
	ResultSet rs = null;
	String locale = p.getProperty("LOCALE");
	String re_attendace_within_hour="";
	
	try{
	
	    String sqlQuery="select reg_attendace_within_hour from ae_param where operating_facility_id ='"+facilityId+"'"; 
		
		
			pstmt = con.prepareStatement(sqlQuery);		
			rs=pstmt.executeQuery();
			if(rs!=null && rs.next()){		  	
			re_attendace_within_hour=checkForNull(rs.getString("reg_attendace_within_hour"));          
			}
			if(rs!=null) rs.close(); 
			if(pstmt!=null) pstmt.close(); 
			
	}catch(Exception e){
		e.printStackTrace();
	}	
	return re_attendace_within_hour;
}
	
    public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
}
	