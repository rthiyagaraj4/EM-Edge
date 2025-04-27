/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eFM;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.util.*;
import java.io.*;
import webbeans.eCommon.*;


public class FMCurrentEncounterDetails implements Serializable {
   //public static ArrayList getCurrentEncounterDetails(Connection con,String encounterId,String fileNo,String facilityId,java.util.Properties p) throws Exception{
public static ArrayList getCurrentEncounterDetails(Connection con, String fileNo,String facilityId,java.util.Properties p) throws Exception{
    PreparedStatement pstmt		= null;
	ResultSet rs = null;
	ArrayList arrayList	= null;
	String sqlQuery = "";
	FMCurrentEncounterDetailsBean  CurrentEncounterDetailsBean=null; 
	String locale = p.getProperty("LOCALE");
	try{
		arrayList=new ArrayList();
		
	    sqlQuery="SELECT patient_class, assign_care_locn_code,assign_care_locn_type, assign_room_num, assign_bed_num,specialty_code, treatment_area_code, to_char(discharge_date_time, 'dd/mm/yyyy hh24:mi') discharge_date_time, priority_zone,ip_get_desc.ip_nursing_unit(a.facility_id, a.assign_care_locn_code,'"+locale+"',2) nursing_unit_short_desc,op_get_desc.OP_CLINIC(a.facility_id,assign_care_locn_code,'"+locale+"','2') clinic_desc,am_get_desc.am_speciality(a.specialty_code, '"+locale+"', 2) specialty_desc, (SELECT priority_zone_desc FROM ae_priority_zone_lang_vw b WHERE language_id =? AND eff_status = 'E' AND a.priority_zone = b.priority_zone) priority_zone_desc,ae_get_desc.ae_tmt_area_for_clinic(a.facility_id, a.assign_care_locn_code, a.treatment_area_code,'"+locale+"','2') treatment_area_desc FROM pr_encounter a WHERE facility_id=? and FILE_NO=?";
		
				
		pstmt = con.prepareStatement(sqlQuery);	
		pstmt.setString(1, locale);
		pstmt.setString(2, facilityId);
		//pstmt.setString(3, encounterId);
		pstmt.setString(3, fileNo);
		rs=pstmt.executeQuery();
		if(rs!=null && rs.next()){
		  CurrentEncounterDetailsBean=new FMCurrentEncounterDetailsBean();
		  CurrentEncounterDetailsBean.setPatientClass(checkForNull(rs.getString("patient_class")));
		  CurrentEncounterDetailsBean.setAssigncarecode(checkForNull(rs.getString("assign_care_locn_code"))); 
		  CurrentEncounterDetailsBean.setAssignCareType(checkForNull(rs.getString("assign_care_locn_type")));
		  CurrentEncounterDetailsBean.setNursingUnit(checkForNull(rs.getString("nursing_unit_short_desc")));
		  CurrentEncounterDetailsBean.setRoom(checkForNull(rs.getString("assign_room_num")));
		  CurrentEncounterDetailsBean.setBed(checkForNull(rs.getString("assign_bed_num"))); 
		  CurrentEncounterDetailsBean.setDischargedatetime(checkForNull(rs.getString("discharge_date_time"))); 
		  CurrentEncounterDetailsBean.setSpecility(checkForNull(rs.getString("specialty_desc")));
		  CurrentEncounterDetailsBean.setClinic(checkForNull(rs.getString("clinic_desc")));		  
		  CurrentEncounterDetailsBean.setPriorityzone(checkForNull(rs.getString("priority_zone_desc")));
		  CurrentEncounterDetailsBean.setTreatmentarea(checkForNull(rs.getString("treatment_area_desc")));		  
		  arrayList.add(CurrentEncounterDetailsBean);
		 }
		if(rs!=null) rs.close(); 
		if(pstmt!=null) pstmt.close(); 

	}catch(Exception e){
		e.printStackTrace();
	}	
	return arrayList;
	
	}
	
public static ArrayList getFromNursingunitDetails(Connection con,String patientid,String facilityId,java.util.Properties p) throws Exception{
    PreparedStatement pstmt		= null;
	ResultSet rs = null;
	ArrayList frmnursingunitList	= null;
	String frmnursingunitQuery= "";
	FMCurrentEncounterDetailsBean  FromNursingunitDetails=null; 
	String locale = p.getProperty("LOCALE");
	try{
		frmnursingunitList=new ArrayList();	    
		frmnursingunitQuery="SELECT ip_get_desc.Ip_nursing_unit(facility_id,fr_nursing_unit_code,'"+locale+"','2')fr_nursing_unit_desc,fr_room_no,fr_bed_no FROM ip_adt_trn  WHERE srl_no = (SELECT MAX(srl_no)  FROM ip_adt_trn    WHERE patient_id    ='"+patientid+"') AND patient_id = '"+patientid+"'";
		
		pstmt = con.prepareStatement(frmnursingunitQuery);	
		rs=pstmt.executeQuery();
		if(rs!=null && rs.next()){
		    FromNursingunitDetails=new FMCurrentEncounterDetailsBean();
		    FromNursingunitDetails.setFromnursingunit(checkForNull(rs.getString("fr_nursing_unit_desc")));
		    FromNursingunitDetails.setFromroom(checkForNull(rs.getString("fr_room_no")));
		    FromNursingunitDetails.setFrombed(checkForNull(rs.getString("fr_bed_no")));		 
		    frmnursingunitList.add(FromNursingunitDetails);
	    }
		 if(rs!=null) rs.close(); 
		 if(pstmt!=null) pstmt.close(); 
	}catch(Exception e){
		e.printStackTrace();
	}	
	return frmnursingunitList;
	
	}
//Audit Trail HSA-CRF-0306
	public static ArrayList getAuditTrailDetails(Connection con, String patientid,String fileNo,String volumeno, java.util.Properties p) throws Exception{
    PreparedStatement pstmt		= null;
	ResultSet rs = null;
	ArrayList auditTrailList	= null;
	String locale = p.getProperty("LOCALE");
	String AuditTrailQuery="";
	
	FMCurrentEncounterDetailsBean  AuditTrailDetailsBean=null; 
		
	try{
	  auditTrailList=new ArrayList();
	  AuditTrailQuery ="Select x.ADDED_DATE,X.PATIENT_ID,X.file_no,X.VOLUME_NO,X.DEST_FACILITY_ID,DECODE(X.MOVEMENT_TYPE,'C','CHGFSLOCN','I','ISSUE','F','TRANSFER','L','LOST','P','PULNGLIST','T','RCDATMRD') MOVEMENT_TYPE, to_char(X.REC_DATE_TIME,'dd/mm/rrrr hh24:mi') DATE_TIME, X.DEST_FS_LOCN_CODE LOCN_CODE,Y.SHORT_DESC LOCN_DESC,DECODE (X.DEST_LOCN_IDENTITY,'T',X.DEST_LOCN_ID,M.appl_user_name ) USER_ID,N.appl_user_name USER_ID2,X.REQ_REMARKS REMARKS,Z.SHORT_DESC NARRATION,DECODE(X.MOVEMENT_TYPE,'C','Change File Storage Locn','I','Confirm Issue File Receipt','F','Confirm Transfer File Receipt','L','Change File Status','P','Pulling List','T','Receive File at MRD') TRANSACTION, X.carried_by_name,(CASE WHEN X.transport_mode IS NOT NULL THEN (am_get_desc.am_transport_mode(X.transport_mode, 'en', '2') )END) transport_desc,X.mrd_receipt_remarks  From FM_MOVEMENT_LOG X,FM_STORAGE_LOCN Y,FM_NARRATION Z,SM_APPL_USER M,SM_APPL_USER N where X.DEST_FACILITY_ID=Y.FACILITY_ID (+) AND X.DEST_FS_LOCN_CODE=Y.FS_LOCN_CODE (+) AND X.PATIENT_ID ='"+patientid+"' AND X.file_no= NVL('"+fileNo+"',X.FILE_NO) AND X.VOLUME_NO=NVL('"+volumeno+"',X.VOLUME_NO) AND X.NARRATION_CODE = Z.NARRATION_CODE(+) AND X.dest_user_id = M.appl_user_id (+)AND X.added_by_id = N.appl_user_id AND X.MOVEMENT_TYPE !='T' UNION ALL Select x.ADDED_DATE,X.PATIENT_ID,X.file_no,X.VOLUME_NO,X.DEST_FACILITY_ID,DECODE(X.MOVEMENT_TYPE,'C','CHGFSLOCN','I','ISSUE','F','TRANSFER','L','LOST','P','PULNGLIST','T','RCDATMRD') MOVEMENT_TYPE, to_char(X.REC_DATE_TIME,'dd/mm/rrrr hh24:mi') DATE_TIME, X.DEST_FS_LOCN_CODE LOCN_CODE,Y.SHORT_DESC LOCN_DESC,DECODE (X.DEST_LOCN_IDENTITY,'T',X.DEST_LOCN_ID,M.appl_user_name ) USER_ID,N.appl_user_name USER_ID2,X.REQ_REMARKS REMARKS,Z.SHORT_DESC NARRATION,DECODE(X.MOVEMENT_TYPE,'C','Change File Storage Locn','I','Confirm Issue File Receipt','F','Confirm Transfer File Receipt','L','Change File Status','P','Pulling List','T','Receive File at MRD') TRANSACTION, X.carried_by_name,(CASE WHEN X.transport_mode IS NOT NULL THEN (am_get_desc.am_transport_mode(X.transport_mode, 'en', '2') )END) transport_desc,X.mrd_receipt_remarks From FM_MOVEMENT_LOG X,FM_STORAGE_LOCN Y,FM_NARRATION Z,SM_APPL_USER M,SM_APPL_USER N where X.DEST_FACILITY_ID=Y.FACILITY_ID (+) AND X.DEST_FS_LOCN_CODE=Y.FS_LOCN_CODE (+) AND X.PATIENT_ID ='"+patientid+"' AND X.file_no= NVL('"+fileNo+"',X.FILE_NO) AND X.VOLUME_NO=NVL('"+volumeno+"',X.VOLUME_NO) AND X.NARRATION_CODE = Z.NARRATION_CODE(+) AND X.dest_user_id = M.appl_user_id (+) AND X.added_by_id = N.appl_user_id AND X.MOVEMENT_TYPE ='T' AND (X.REC_DATE_TIME !=x.SENT_DATE_TIME) UNION ALL Select a.ADDED_DATE, A.PATIENT_ID,A.file_no,A.VOLUME_NO,A.SRC_FACILITY_ID,  NULL MOVEMENT_TYPE, to_char(A.SENT_DATE_TIME,'dd/mm/rrrr hh24:mi') DATE_TIME, A.SRC_FS_LOCN_CODE LOCN_CODE,B.SHORT_DESC LOCN_DESC,M.appl_user_name USER_ID, N.appl_user_name USER_ID2, A.ISS_REMARKS REMARKS,Z.SHORT_DESC NARRATION,DECODE(A.MOVEMENT_TYPE,'I','Issue File','F','Transfer File','T','Return to MRD','') TRANSACTION, A.carried_by_name,(CASE WHEN A.transport_mode IS NOT NULL THEN (am_get_desc.am_transport_mode(A.transport_mode, 'en', '2') )END) transport_desc,A.mrd_receipt_remarks From FM_MOVEMENT_LOG A, FM_STORAGE_LOCN B,FM_NARRATION Z,SM_APPL_USER M,SM_APPL_USER N WHERE A.SRC_FACILITY_ID=B.FACILITY_ID(+) AND A.SRC_FS_LOCN_CODE=B.FS_LOCN_CODE(+) AND A.PATIENT_ID ='"+patientid+"' AND A.file_no= NVL('"+fileNo+"',A.FILE_NO) AND A.VOLUME_NO=NVL('"+volumeno+"',A.VOLUME_NO) AND A.NARRATION_CODE = Z.NARRATION_CODE(+) AND A.dest_user_id = M.appl_user_id(+) AND A.added_by_id = N.appl_user_id AND A.MOVEMENT_TYPE IN ('I','F','T') UNION ALL SELECT a.ADDED_DATE, PATIENT_ID, file_no,VOLUME_NO,A.REQ_FACILITY_ID , 'REQUEST' MOVEMENT_TYPE, to_char(A.ADDED_DATE,'dd/mm/rrrr hh24:mi') DATE_TIME, A.REQ_FS_LOCN_CODE LOCN_CODE, C.SHORT_DESC LOCN_DESC,/*A.REQ_USER_ID USER_ID, A.REQ_USER_ID USER_ID2,*/ m.appl_user_name USER_ID, n.appl_user_name USER_ID2, B.REMARKS REMARKS, Z.SHORT_DESC NARRATION,'Request File' TRANSACTION,NULL,NULL,NULL FROM FM_REQ_HDR A,FM_REQ_DTL B,FM_STORAGE_LOCN C,FM_NARRATION Z, sm_appl_user m ,sm_appl_user n WHERE B.ISS_DATE_TIME IN (SELECT SENT_DATE_TIME FROM FM_MOVEMENT_LOG WHERE PATIENT_ID ='"+patientid+"' AND file_no= nvl('"+fileNo+"',file_no) AND VOLUME_NO=NVL('"+volumeno+"',VOLUME_NO)) AND A.REQ_NO = B.REQ_NO AND B.ISS_YN = 'Y' AND B.FILE_NO = nvl('"+fileNo+"',B.FILE_NO) AND A.REQ_FACILITY_ID = C.FACILITY_ID AND A.REQ_FS_LOCN_CODE = C.FS_LOCN_CODE AND a.req_user_id = m.appl_user_id(+) AND a.added_by_id = n.appl_user_id AND A.NARRATION_CODE = Z.NARRATION_CODE(+) ORDER BY 3,DATE_TIME";
	  
	  
	  
	  pstmt=con.prepareStatement(AuditTrailQuery);	 
	  rs=pstmt.executeQuery();
	  while(rs!=null && rs.next()){ 
        AuditTrailDetailsBean=new FMCurrentEncounterDetailsBean();
	    AuditTrailDetailsBean.setTransaction(checkForNull(rs.getString("TRANSACTION")));
		AuditTrailDetailsBean.setDatetime(checkForNull(rs.getString("date_time")));
		AuditTrailDetailsBean.setFsLocation(checkForNull(rs.getString("locn_desc")));
		AuditTrailDetailsBean.setBy(checkForNull(rs.getString("user_id2")));
		AuditTrailDetailsBean.setReason(checkForNull(rs.getString("narration")));
		AuditTrailDetailsBean.setRemarks(checkForNull(rs.getString("remarks")));		
		AuditTrailDetailsBean.setForwhom(checkForNull(rs.getString("user_id")));
		AuditTrailDetailsBean.setModeoftransfer(checkForNull(rs.getString("transport_desc")));
		AuditTrailDetailsBean.setCarriedByName(checkForNull(rs.getString("carried_by_name")));
		AuditTrailDetailsBean.setReturnRemarks(checkForNull(rs.getString("mrd_receipt_remarks")));
		auditTrailList.add(AuditTrailDetailsBean);
	  
	 } if(rs!=null) rs.close(); 
		 if(pstmt!=null) pstmt.close(); 
	
	}catch(Exception e){
	    e.printStackTrace();
	}
	  return auditTrailList;
}	
//End Audit trail HSA-CRF-0306
//File Movement History HSA-CRF-0306
	public static ArrayList getFileMovementHistory(Connection con, String patientid,String fileNo,String volumeno, java.util.Properties p) throws Exception{
    PreparedStatement pstmt		= null;
	ResultSet rs = null;
	ArrayList fileMovementHistoryList	= null;
	String locale = p.getProperty("LOCALE");
	String FileMovementHistQuery="";
	
	FMCurrentEncounterDetailsBean  FileMovementHistoryBean=null; 
	
	
	
	try{
	  fileMovementHistoryList=new ArrayList();
	  
	  FileMovementHistQuery="SELECT  TO_CHAR(a.sent_date_time,'DD/MM/YYYY HH24:MI')issuedate  , a.src_locn_identity  , FM_GET_DESC.FM_STORAGE_LOCN(A.SRC_FACILITY_ID, A.SRC_FS_LOCN_CODE,'"+locale+"','2') src_fs_locn_desc  , (  CASE   WHEN rec_date_time IS  NOT NULL   THEN  TO_CHAR(a.rec_date_time,'DD/MM/YYYY HH24:MI')  ELSE 'File In Transit'   END)recordeddatetime  , a.dest_locn_identity  , FM_GET_DESC.FM_STORAGE_LOCN(A.DEST_FACILITY_ID, A.DEST_FS_LOCN_CODE,'"+locale+"','2') dest_fs_locn_desc  , SM_GET_DESC.SM_APPL_USER(a.dest_user_id,'"+locale+"','1') appl_user_name  ,(  CASE   WHEN a.facility_id<>a.dest_facility_id   THEN  SM_GET_DESC.SM_FACILITY_PARAM(a.dest_facility_id,'"+locale+"','1')   ELSE '&nbsp;'   END)facility_name  , a.req_remarks  , a.iss_remarks  , a.mrd_receipt_remarks  FROM  fm_movement_log a WHERE a.file_no= '"+fileNo+"'  AND a.volume_no = "+volumeno+"  AND a.patient_id = '"+patientid+"'  ORDER BY  sent_date_time desc";
	  
	 
	  pstmt=con.prepareStatement(FileMovementHistQuery);	 
	  rs=pstmt.executeQuery();
	  while(rs!=null && rs.next()){ 
        FileMovementHistoryBean=new FMCurrentEncounterDetailsBean();
	   // FileMovementHistoryBean.setTransaction(checkForNull(rs.getString("TRANSACTION")));
		FileMovementHistoryBean.setIssuedDatetime(checkForNull(rs.getString("issuedate")));
		FileMovementHistoryBean.setIssuedFsLocation(checkForNull(rs.getString("src_fs_locn_desc")));
		FileMovementHistoryBean.setReceivedFsLocation(checkForNull(rs.getString("dest_fs_locn_desc")));
		FileMovementHistoryBean.setRequestRemarks(checkForNull(rs.getString("req_remarks")));	
		FileMovementHistoryBean.setIssueRemarks(checkForNull(rs.getString("iss_remarks")));	
		FileMovementHistoryBean.setReceivedDatetime(checkForNull(rs.getString("recordeddatetime")));
		FileMovementHistoryBean.setReturnRemarks(checkForNull(rs.getString("mrd_receipt_remarks")));	
		FileMovementHistoryBean.setBy(checkForNull(rs.getString("appl_user_name")));
		
		FileMovementHistoryBean.setSourcelocnidentity(checkForNull(rs.getString("src_locn_identity")));
		FileMovementHistoryBean.setDestlocnidentity(checkForNull(rs.getString("dest_locn_identity")));
		
		fileMovementHistoryList.add(FileMovementHistoryBean);
	  
	 } if(rs!=null) rs.close(); 
		 if(pstmt!=null) pstmt.close(); 
	
	}catch(Exception e){
	    e.printStackTrace();
	}/*finally {
		 if (con != null)
			  {
			    try {
					ConnectionManager.returnConnection(con,p);
		         } catch (Exception ee) {
						ee.printStackTrace();
				}
		      }
	}*/
	  return fileMovementHistoryList;
}	
//End File Movement History trail HSA-CRF-036
//Holiday for  MRD
public static ArrayList getHolodayForMRD(Connection con,String holidaydate,String holidayenddate,String FsLocationCode,String facilityId,java.util.Properties p){
Statement pmst=null;
ResultSet rs=null;
FMCurrentEncounterDetailsBean  HolidayForMRDBean=null; 
int totreccord=0;
StringBuffer HolidayQuery=new StringBuffer();
FMCurrentEncounterDetailsBean  HolidayBean=null; 
ArrayList holidayList=null;

   HolidayQuery.append("SELECT a.fs_locn_code fs_locn_code, a.long_desc long_desc,TO_CHAR (b.holiday_date, 'dd/mm/yyyy') holiday_val, b.holiday_date holiday_date1 FROM fm_storage_locn a, (SELECT TO_DATE ('"+holidaydate+"', 'dd/mm/yyyy') + ROWNUM- 1 holiday_date FROM sm_function");
   HolidayQuery.append(" WHERE ROWNUM <=TO_DATE ('"+holidayenddate+"', 'dd/mm/yyyy')- TO_DATE ('"+holidaydate+"', 'dd/mm/yyyy')+ 1) b");
   HolidayQuery.append(" WHERE a.facility_id = '"+facilityId+"' and fs_locn_code = '"+FsLocationCode+"'");     
   HolidayQuery.append(" AND NOT EXISTS (SELECT 1 FROM fm_holiday WHERE facility_id = a.facility_id AND fs_locn_code = '"+FsLocationCode+"'");
   HolidayQuery.append(" AND holiday_date = b.holiday_date) AND a.mr_locn_yn = 'Y' AND a.permanent_file_area_yn = 'Y'  MINUS");
   HolidayQuery.append(" SELECT   a.fs_locn_code fs_locn_code, a.long_desc long_desc,TO_CHAR (b.holiday_date, 'dd/mm/yyyy') holiday_val,");
   HolidayQuery.append(" b.holiday_date holiday_date1 FROM fm_storage_locn a, (SELECT TO_DATE ('"+holidaydate+"', 'dd/mm/yyyy') + ROWNUM- 1 holiday_date");
   HolidayQuery.append(" FROM sm_function WHERE ROWNUM <=TO_DATE ('"+holidayenddate+"', 'dd/mm/yyyy')- TO_DATE ('"+holidaydate+"', 'dd/mm/yyyy')+ 1) b");
   HolidayQuery.append(" WHERE a.facility_id = '"+facilityId+"' and fs_locn_code = '"+FsLocationCode+"' AND a.mr_locn_yn = 'Y'");
   HolidayQuery.append(" AND a.permanent_file_area_yn = 'Y' AND NOT EXISTS (SELECT 1 FROM fm_holiday WHERE facility_id = a.facility_id");
   HolidayQuery.append(" AND fs_locn_code = '"+FsLocationCode+"') AND a.mr_locn_yn = 'Y' AND a.permanent_file_area_yn = 'Y' ORDER BY 4, 2"); 
   
   
try{
   holidayList=new ArrayList();
  
   pmst = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
   rs=pmst.executeQuery(HolidayQuery.toString());
   rs.last();
   totreccord = rs.getRow();
   rs.beforeFirst();  
   
   
   if(totreccord==0){
    if(rs!=null)rs.close();
	//if(pmst!=null) pmst.close();
	HolidayQuery.setLength(0);
    HolidayQuery.append("SELECT l1.fs_locn_code, l1.long_desc, TO_CHAR (l2.trn_date, 'DD/MM/YYYY') holiday_val,l2.trn_date trn_hol_date    FROM (SELECT a.fs_locn_code fs_locn_code, a.long_desc long_desc FROM fm_storage_locn a WHERE a.facility_id ='"+facilityId+"' AND a.fs_locn_code ='"+FsLocationCode+"'");
    HolidayQuery.append(" AND a.permanent_file_area_yn = 'Y' AND a.mr_locn_yn = 'Y' AND a.eff_status = 'E'");
    HolidayQuery.append(" AND (a.facility_id, a.fs_locn_code) NOT IN (SELECT facility_id, fs_locn_code FROM fm_holiday WHERE facility_id = a.facility_id AND fs_locn_code = a.fs_locn_code)) l1,");
    HolidayQuery.append(" (SELECT TO_DATE ('"+holidaydate+"', 'dd/mm/rrrr') + ROWNUM - 1 trn_date FROM sm_function WHERE ROWNUM <=TO_DATE ('"+holidayenddate+"', 'dd/mm/rrrr')+ 1- TO_DATE ('"+holidaydate+"', 'dd/mm/rrrr')) l2 ORDER BY trn_hol_date ASC");
  
   }
   rs=pmst.executeQuery(HolidayQuery.toString());
  
      
   while(rs!=null&&rs.next()){
   HolidayBean=new FMCurrentEncounterDetailsBean();
   HolidayBean.setFslocationcode(checkForNull(rs.getString("fs_locn_code")));
   HolidayBean.setFslocationdescription(checkForNull(rs.getString("long_desc")));
   HolidayBean.setHolidaydate(checkForNull(rs.getString("holiday_val")));
   holidayList.add(HolidayBean);
   }     
   if(rs!=null) rs.close(); 
   if(pmst!=null) pmst.close(); 
   //System.err.println("holidayList Size===>"+holidayList.size());

}catch(Exception e){
  e.printStackTrace();
}
return holidayList;

}
public static String getCurrentDate(Connection con){
	 PreparedStatement pmst=null;  
	 ResultSet rs=null;
	 String crrent_Date="";
		  try{
			  pmst=con.prepareStatement("select to_char(sysdate,'dd/mm/yyyy') curr_date from dual");
			  rs=pmst.executeQuery();
			  if(rs!=null&&rs.next()){
				crrent_Date=checkForNull(rs.getString("curr_date"));
			  }	

            if(rs!=null) rs.close(); 
		    if(pmst!=null) pmst.close();   			  
		  
		  }catch(Exception e){
		   e.printStackTrace();
		  }  
 return crrent_Date;  

}
public static ArrayList getMrdLocation(Connection con,String facilityId){
PreparedStatement pmst=null;
ResultSet rs=null;
FMCurrentEncounterDetailsBean  MrdLocationBean=null;
ArrayList MrdLocationList=null; 
String MrdLocationQuery="select FS_LOCN_CODE,LONG_DESC from fm_storage_locn a where FACILITY_ID='"+facilityId+"' and MR_LOCN_YN='Y' and PERMANENT_FILE_AREA_YN='Y' and EFF_STATUS='E' ORDER BY LONG_DESC ASC";

try{
   MrdLocationList=new ArrayList();
   pmst=con.prepareStatement(MrdLocationQuery);
   rs=pmst.executeQuery();
   while(rs!=null&&rs.next()){
   MrdLocationBean=new FMCurrentEncounterDetailsBean();
   MrdLocationBean.setFslocationcode(checkForNull(rs.getString("FS_LOCN_CODE")));
   MrdLocationBean.setFslocationdescription(checkForNull(rs.getString("LONG_DESC")));
   MrdLocationList.add(MrdLocationBean);
   }
   
   if(rs!=null) rs.close(); 
   if(pmst!=null) pmst.close(); 
   

}catch(Exception e){
  e.printStackTrace();
}
return MrdLocationList;

}
public static ArrayList getCurrentFsLocationDetails(Connection con,String patient_id,String file_no,String file_volume,java.util.Properties p)
 throws Exception{
   PreparedStatement pstmt = null;
   ResultSet rs=null;
   FMCurrentEncounterDetailsBean  currentfsLocation=null;
    ArrayList arrlist=null;
	String Requestedby="",Issuedby="",Transferedby="",Movementtype="",Narration="",Transportdesc="",Carriedby="",Transfereddatetime="";	
	String locale = p.getProperty("LOCALE");
	StringBuffer fslocatiodetals=new StringBuffer();
	fslocatiodetals.append("SELECT   a.movement_type,a.added_date, a.patient_id, a.file_no, a.volume_no,  a.src_facility_id, NULL movement_type,");
    fslocatiodetals.append("TO_CHAR (a.sent_date_time, 'dd/mm/rrrr hh24:mi') date_time,  a.src_fs_locn_code locn_code, b.short_desc locn_desc,");
	fslocatiodetals.append(" m.appl_user_name user_id, n.appl_user_name user_id2, a.iss_remarks remarks, z.short_desc narration,");
	fslocatiodetals.append(" DECODE (a.movement_type,'I', 'Issue File', 'F', 'Transfer File', 'T', 'Return to MRD', '') TRANSACTION, a.carried_by_name,");
	fslocatiodetals.append("(CASE WHEN a.transport_mode IS NOT NULL THEN (am_get_desc.am_transport_mode (a.transport_mode,'"+locale+"','1')) END)");
	fslocatiodetals.append(" transport_desc,a.mrd_receipt_remarks,(CASE WHEN a.src_user_id IS NOT NULL THEN (sm_get_desc.sm_appl_user (a.src_user_id, '"+locale+"', '1')) END) issued_by, (CASE WHEN a.dest_user_id IS NOT NULL THEN (sm_get_desc.sm_appl_user (a.dest_user_id, '"+locale+"', '1')) END) reqname ");
	fslocatiodetals.append("FROM fm_movement_log a, fm_storage_locn b,fm_narration z,sm_appl_user m,sm_appl_user n");
	fslocatiodetals.append(" WHERE a.src_facility_id = b.facility_id(+) AND a.src_fs_locn_code = b.fs_locn_code(+) AND a.patient_id = '"+patient_id+"' AND ");
    fslocatiodetals.append(" a.file_no = NVL ('"+file_no+"', a.file_no) AND a.volume_no = NVL ('"+file_volume+"', a.volume_no)");
    fslocatiodetals.append(" AND a.narration_code = z.narration_code(+) AND a.dest_user_id = m.appl_user_id(+) AND a.added_by_id = n.appl_user_id AND a.movement_type IN ('I', 'F','T')  AND ( a.sent_date_time =(SELECT MAX(sent_date_time) FROM fm_movement_log WHERE patient_id ='"+patient_id+"'");
	fslocatiodetals.append(" AND file_no = NVL ('"+file_no+"', file_no)  AND volume_no = NVL ('"+file_volume+"', volume_no) AND movement_type ='I')");
    fslocatiodetals.append(" OR a.sent_date_time =(SELECT MAX(sent_date_time) FROM fm_movement_log WHERE  patient_id ='"+patient_id+"' AND file_no = NVL ('"+file_no+"', file_no)  AND volume_no = NVL ('"+file_volume+"', volume_no) AND movement_type ='F') OR a.sent_date_time =(SELECT MAX(sent_date_time) FROM fm_movement_log WHERE  patient_id ='"+patient_id+"' AND file_no = NVL ('"+file_no+"', file_no)  AND volume_no = NVL ('"+file_volume+"', volume_no) AND movement_type ='T')) order by added_date");

     	
	
	
	try{
	     arrlist=new ArrayList();
         pstmt=con.prepareStatement(fslocatiodetals.toString());
         rs=pstmt.executeQuery();
         while(rs!=null&&rs.next()){
		   currentfsLocation=new FMCurrentEncounterDetailsBean();		   
			Movementtype=checkForNull(rs.getString("movement_type"));                 		  
		    Carriedby=checkForNull(rs.getString("carried_by_name"));
			Transportdesc=checkForNull(rs.getString("transport_desc"));
			currentfsLocation.setMovementtype(Movementtype);			
			currentfsLocation.setCarriedby(Carriedby);
			currentfsLocation.setTransportdesc(Transportdesc);			
			//if(!Movementtype.equals("")&&Movementtype.equals("F")){
			Transferedby=checkForNull(rs.getString("issued_by"));  
            Transfereddatetime=checkForNull(rs.getString("date_time")); 			
			//}
			currentfsLocation.setTransferedby(Transferedby);
			currentfsLocation.setTransferdatetime(Transfereddatetime);
			arrlist.add(currentfsLocation);
		 } 
		  if(rs!=null) rs.close(); 
          if(pstmt!=null) pstmt.close(); 
	
	
	
	}catch(Exception e){
	   e.printStackTrace();
	}
	
return arrlist;
}

public static ArrayList getCurrentFsLocationRequestDetails(Connection con,String patient_id,String file_no,String file_volume,java.util.Properties p)
 throws Exception{
   PreparedStatement pstmt = null;
   ResultSet rs=null;
   FMCurrentEncounterDetailsBean  requestedBean=null;
    ArrayList requestList=null;
		
	String locale = p.getProperty("LOCALE");
	StringBuffer requesteddetals=new StringBuffer();
	/* Below line(s)   a.remarks added by Venkatesh.s against ML-MMOH-CRF-0393 */	
	requesteddetals.append("SELECT  a.remarks,a.added_date, n.appl_user_name requested_by,b.remarks remarks, z.short_desc narration,b.iss_date_time, TO_CHAR (b.iss_date_time, 'dd/mm/rrrr hh24:mi') isseddatetime, b.iss_user_id ");
	requesteddetals.append(",(CASE WHEN b.iss_user_id IS NOT NULL THEN (sm_get_desc.sm_appl_user (b.iss_user_id, '"+locale+"', '1')) END) issued_by");
    requesteddetals.append(" FROM fm_req_hdr a, fm_req_dtl b, fm_storage_locn c, fm_narration z, sm_appl_user m, sm_appl_user n WHERE  b.patient_id =  '"+patient_id+"' AND b.volume_no = NVL ('"+file_volume+"', b.volume_no) AND b.file_no = NVL ('"+file_no+"', b.file_no) and a.req_no = b.req_no ");
    requesteddetals.append(" AND b.file_no = NVL ('"+file_no+"', b.file_no) AND a.req_facility_id = c.facility_id AND a.req_fs_locn_code = c.fs_locn_code");
    requesteddetals.append(" AND a.req_user_id = m.appl_user_id(+) AND a.added_by_id = n.appl_user_id AND a.narration_code = z.narration_code(+)");
    requesteddetals.append(" and  (b.iss_date_time = (SELECT max(iss_date_time) FROM fm_req_dtl WHERE patient_id = '"+patient_id+"' AND file_no = NVL ('"+file_no+"', file_no) AND volume_no = NVL ('"+file_volume+"', volume_no)) OR b.iss_date_time IS NULL ) ORDER BY a.added_date");

     	
	
	
	try{
	     requestList=new ArrayList();
         pstmt=con.prepareStatement(requesteddetals.toString());
         rs=pstmt.executeQuery();
         while(rs!=null&&rs.next()){
		    requestedBean=new FMCurrentEncounterDetailsBean();		   
			requestedBean.setRequestedby(checkForNull(rs.getString("requested_by")));
			requestedBean.setIssuedby(checkForNull(rs.getString("issued_by")));	
            requestedBean.setNarration(checkForNull(rs.getString("narration")));
            requestedBean.setIssuedDatetime(checkForNull(rs.getString("isseddatetime")));			
          /* Below line(s) added by Venkatesh.s against ML-MMOH-CRF-0393 */
		    requestedBean.setRemarkforBorrow(checkForNull(rs.getString("remarks")));			
			/*end ML-MMOH-CRF-0393 */
			requestList.add(requestedBean);
		 }
 
        if(rs!=null) rs.close(); 
        if(pstmt!=null) pstmt.close(); 
 
	
	  }catch(Exception e){
	   e.printStackTrace();
	  }
	
return requestList;
}

public static ArrayList getFileCurrentEncounterDetails(Connection con, String patient_id,String current_loc_id,String loc_identity,String facilityId,java.util.Properties p) throws Exception{
    PreparedStatement pstmt		= null;
	ResultSet rs = null;
	ArrayList arrayList	= null;
	String sqlQuery = "";
	FMCurrentEncounterDetailsBean  CurrentEncounterDetailsBean=null; 
	String locale = p.getProperty("LOCALE");
	StringBuffer sql	= null;
	sql= new StringBuffer();
	try{
		arrayList=new ArrayList();
		
	    /*sqlQuery="SELECT patient_class, assign_care_locn_code,assign_care_locn_type, assign_room_num, assign_bed_num,specialty_code, treatment_area_code, to_char(discharge_date_time, 'dd/mm/yyyy hh24:mi') discharge_date_time, priority_zone,ip_get_desc.ip_nursing_unit(a.facility_id, a.assign_care_locn_code,'"+locale+"',2) nursing_unit_short_desc,op_get_desc.OP_CLINIC(a.facility_id,assign_care_locn_code,'"+locale+"','2') clinic_desc,am_get_desc.am_speciality(a.specialty_code, '"+locale+"', 2) specialty_desc, (SELECT priority_zone_desc FROM ae_priority_zone_lang_vw b WHERE language_id =? AND eff_status = 'E' AND a.priority_zone = b.priority_zone) priority_zone_desc,ae_get_desc.ae_tmt_area_for_clinic(a.facility_id, a.assign_care_locn_code, a.treatment_area_code,'"+locale+"','2') treatment_area_desc FROM pr_encounter a WHERE facility_id=? and patient_id=? and assign_care_locn_code=? AND visit_adm_date_time IN (SELECT MAX (visit_adm_date_time) FROM pr_encounter WHERE facility_id = ? AND patient_id = ?     AND assign_care_locn_code = ?)";*/
		sql.append("SELECT patient_class, assign_care_locn_code,assign_care_locn_type, assign_room_num, assign_bed_num,specialty_code, treatment_area_code, to_char(discharge_date_time, 'dd/mm/yyyy hh24:mi') discharge_date_time, priority_zone,ip_get_desc.ip_nursing_unit(a.facility_id, a.assign_care_locn_code,'"+locale+"',2) nursing_unit_short_desc,op_get_desc.OP_CLINIC(a.facility_id,assign_care_locn_code,'"+locale+"','2') clinic_desc,am_get_desc.am_speciality(a.specialty_code, '"+locale+"', 2) specialty_desc, (SELECT priority_zone_desc FROM ae_priority_zone_lang_vw b WHERE language_id =? AND eff_status = 'E' AND a.priority_zone = b.priority_zone) priority_zone_desc,ae_get_desc.ae_tmt_area_for_clinic(a.facility_id, a.assign_care_locn_code, a.treatment_area_code,'"+locale+"','2') treatment_area_desc, to_char(cancel_disch_date, 'dd/mm/yyyy hh24:mi') cancel_disch_date FROM pr_encounter a WHERE facility_id=? and patient_id=? ");
		if(loc_identity.equals("Y")){
		 sql.append(" and dc_unit_code=? and (visit_status!='99'  or visit_status is null) AND (adt_status!='09' or adt_status is null) ");
		}else{
		 sql.append(" and assign_care_locn_code=? and (visit_status!='99'  or visit_status is null) AND (adt_status!='09' or adt_status is null) ");
		 }		 
		 sql.append(" AND visit_adm_date_time IN (SELECT MAX (visit_adm_date_time) FROM pr_encounter WHERE facility_id = ? AND patient_id = ?  ");
		 if(loc_identity.equals("Y")){
		 sql.append(" and dc_unit_code=? and (visit_status!='99'  or visit_status is null) AND (adt_status!='09' or adt_status is null) )");
		 }else{
		 sql.append(" and assign_care_locn_code=? and (visit_status!='99'  or visit_status is null) AND (adt_status!='09' or adt_status is null) )");
		 }
		
		System.err.println("FMCurrentEncounterDetails.java getFileCurrentEncounterDetails sql.toString11===>"+sql.toString());
		System.err.println("FMCurrentEncounterDetails.java getFileCurrentEncounterDetails loc_identity11===>"+loc_identity);
		System.err.println("FMCurrentEncounterDetails.java patient_id11===>"+patient_id);
		System.err.println("FMCurrentEncounterDetails.java current_loc_id11===>"+current_loc_id);
		//System.err.println("FMCurrentEncounterDetails.java getFileCurrentEncounterDetails===>"+sqlQuery);
				
		pstmt = con.prepareStatement(sql.toString());	
		pstmt.setString(1, locale);
		pstmt.setString(2, facilityId);		
		pstmt.setString(3, patient_id);
		pstmt.setString(4, current_loc_id);
		pstmt.setString(5, facilityId);		
		pstmt.setString(6, patient_id);
		pstmt.setString(7, current_loc_id);
		rs=pstmt.executeQuery();
		if(rs!=null && rs.next()){
		  CurrentEncounterDetailsBean=new FMCurrentEncounterDetailsBean();
		  CurrentEncounterDetailsBean.setPatientClass(checkForNull(rs.getString("patient_class")));
		  CurrentEncounterDetailsBean.setAssigncarecode(checkForNull(rs.getString("assign_care_locn_code"))); 
		  CurrentEncounterDetailsBean.setAssignCareType(checkForNull(rs.getString("assign_care_locn_type")));
		  CurrentEncounterDetailsBean.setNursingUnit(checkForNull(rs.getString("nursing_unit_short_desc")));
		  CurrentEncounterDetailsBean.setRoom(checkForNull(rs.getString("assign_room_num")));
		  CurrentEncounterDetailsBean.setBed(checkForNull(rs.getString("assign_bed_num"))); 
		  CurrentEncounterDetailsBean.setDischargedatetime(checkForNull(rs.getString("discharge_date_time"))); 
		  CurrentEncounterDetailsBean.setSpecility(checkForNull(rs.getString("specialty_desc")));
		  CurrentEncounterDetailsBean.setClinic(checkForNull(rs.getString("clinic_desc")));		  
		  CurrentEncounterDetailsBean.setPriorityzone(checkForNull(rs.getString("priority_zone_desc")));
		  CurrentEncounterDetailsBean.setTreatmentarea(checkForNull(rs.getString("treatment_area_desc")));
          CurrentEncounterDetailsBean.setCanceldischarge(checkForNull(rs.getString("cancel_disch_date")));
		  
		  arrayList.add(CurrentEncounterDetailsBean);
		 }
		if(rs!=null) rs.close(); 
		if(pstmt!=null) pstmt.close(); 

	}catch(Exception e){
		e.printStackTrace();
	}	
	return arrayList;
	
	}
	
	
public static String getCurrentAssignCareLocation(Connection con, String patient_id,String current_loc_id,String facilityId,java.util.Properties p) throws Exception{
    PreparedStatement pstmt		= null;
	ResultSet rs = null;
		
	FMCurrentEncounterDetailsBean  CurrentEncounterDetailsBean=null; 
	String locale = p.getProperty("LOCALE");
	StringBuffer sql	= null;
	sql= new StringBuffer();
	String assigncar_locn="";
	try{		
	  
sql.append("SELECT assign_care_locn_code FROM pr_encounter where facility_id = ? AND patient_id = ? AND dc_unit_code = ?");
sql.append(" AND visit_adm_date_time IN (SELECT MAX (visit_adm_date_time) FROM pr_encounter WHERE facility_id =? AND patient_id =? AND dc_unit_code = ?)");  
        System.err.println("FMCurrentEncounterDetails.java getCurrentAssignCareLocation sql.toString===>"+sql.toString());		
		System.err.println("FMCurrentEncounterDetails.java patient_id===>"+patient_id);
		System.err.println("FMCurrentEncounterDetails.java current_loc_id===>"+current_loc_id);
		//System.err.println("FMCurrentEncounterDetails.java getFileCurrentEncounterDetails===>"+sqlQuery);
				
		pstmt = con.prepareStatement(sql.toString());	
		
		pstmt.setString(1, facilityId);		
		pstmt.setString(2, patient_id);
		pstmt.setString(3, current_loc_id);
		pstmt.setString(4, facilityId);		
		pstmt.setString(5, patient_id);
		pstmt.setString(6, current_loc_id);
		rs=pstmt.executeQuery();
		if(rs!=null && rs.next()){		 
		  assigncar_locn=checkForNull(rs.getString("assign_care_locn_code"));		  
		 }
		System.err.println("assigncar_locnassigncar_locn===>"+assigncar_locn); 
		if(rs!=null) rs.close(); 
		if(pstmt!=null) pstmt.close(); 

	}catch(Exception e){
		e.printStackTrace();
	}	
	return assigncar_locn;
	
	}


//End Holiday For MRD
	
	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
}
	
