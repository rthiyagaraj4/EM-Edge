package eOP;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.util.*;
import java.io.*;
import webbeans.eCommon.*;


public class ReferralCurrentEncounterDetails implements Serializable {

public static ArrayList getIPCurrentEncounterDetails(Connection con, String Patient_id,String facilityId,java.util.Properties p) throws Exception{
    PreparedStatement pstmt		= null;
	ResultSet rs = null;
	ArrayList arrayList	= null;
	String sqlQuery = "";
	ReferralCurrentEncounterDetailsBean  CurrentEncounterDetailsBean=null; 
	String locale = p.getProperty("LOCALE");
	try{
		arrayList=new ArrayList();
		
	    sqlQuery="SELECT assign_care_locn_code, assign_care_locn_type, ip_get_desc.IP_NURSING_UNIT('"+facilityId+"', assign_care_locn_code,'"+locale+"','2')nursing_unit_short_desc  FROM pr_encounter a WHERE facility_id=? and patient_id=? and patient_class IN('IP','DC') and adt_status!='09' and discharge_date_time is null order by visit_adm_date_time desc";				
		pstmt = con.prepareStatement(sqlQuery);			
		pstmt.setString(1, facilityId);		
		pstmt.setString(2, Patient_id);
		rs=pstmt.executeQuery();
		if(rs!=null && rs.next()){
		  CurrentEncounterDetailsBean=new ReferralCurrentEncounterDetailsBean();		
		  CurrentEncounterDetailsBean.setAssigncareloccode(checkForNull(rs.getString("assign_care_locn_code"))); 		 
		  CurrentEncounterDetailsBean.setAssigncarelocdesc(checkForNull(rs.getString("nursing_unit_short_desc")));
          CurrentEncounterDetailsBean.setAssigncareloctype(checkForNull(rs.getString("assign_care_locn_type")));	    		  
		  arrayList.add(CurrentEncounterDetailsBean);
		 }
		if(rs!=null) rs.close(); 
		if(pstmt!=null) pstmt.close(); 

	}catch(Exception e){
		e.printStackTrace();
	}	
	return arrayList;
	
	}
	
public static ArrayList getOPCurrentEncounterDetails(Connection con, String Patient_id,String facilityId,java.util.Properties p) throws Exception{
    PreparedStatement pstmt		= null;
	ResultSet rs = null;
	ArrayList arrayList	= null;
	String sqlQuery = "";
	ReferralCurrentEncounterDetailsBean  CurrentEncounterDetailsBean=null; 
	String locale = p.getProperty("LOCALE");
	try{
		arrayList=new ArrayList();
		
	    sqlQuery="SELECT assign_care_locn_code, assign_care_locn_type, op_get_desc.op_clinic ('"+facilityId+"', assign_care_locn_code, '"+locale+"', 2) locn_desc FROM pr_encounter a WHERE facility_id=? and patient_id=? and patient_class IN('OP','EM') and visit_status!='99' and discharge_date_time is null order by visit_adm_date_time desc";
		pstmt = con.prepareStatement(sqlQuery);			
		pstmt.setString(1, facilityId);		
		pstmt.setString(2, Patient_id);
		rs=pstmt.executeQuery();
		if(rs!=null && rs.next()){
		  CurrentEncounterDetailsBean = new ReferralCurrentEncounterDetailsBean();		 
		  CurrentEncounterDetailsBean.setAssigncareloccode(checkForNull(rs.getString("assign_care_locn_code")));		  
		  CurrentEncounterDetailsBean.setAssigncarelocdesc(checkForNull(rs.getString("locn_desc")));
          CurrentEncounterDetailsBean.setAssigncareloctype(checkForNull(rs.getString("assign_care_locn_type")));	   		  
		  arrayList.add(CurrentEncounterDetailsBean);
		 }
		if(rs!=null) rs.close(); 
		if(pstmt!=null) pstmt.close(); 

	}catch(Exception e){
		e.printStackTrace();
	}	
	return arrayList;
	
	}
		
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
}
	