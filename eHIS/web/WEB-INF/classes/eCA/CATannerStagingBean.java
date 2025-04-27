/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
---------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name      	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------------------
23/10/2018		IN067402		Prakash		10/09/2018		Ramesh Goli		ML-MMOH-CRF-0813.1
---------------------------------------------------------------------------------------------------------------------------------------------
*/
package eCA;

import java.io.* ;
import java.sql.* ;
import java.util.ArrayList;
import javax.servlet.http.* ;
import org.json.simple.*;
import webbeans.eCommon.*;
public class  CATannerStagingBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;
	//public String getTannerStagingScoreDetails(HttpServletRequest request, String patientId,String encounter_id) throws Exception{
    public ArrayList getTannerStagingScoreDetails(HttpServletRequest request, String patientId,String encounter_id) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		//String tannerStagingDetails		= "";IN069057
		ArrayList tannerStagingDetails	= new ArrayList() ;
		
		try{
			con = ConnectionManager.getConnection(request);

			//String tannerStagingScoreSql = " SELECT TANNERSTAGING,ROWNUM FROM(SELECT PUBIC_HAIR_STAGE||'|'||PUBERTY_STAGE TANNERSTAGING FROM CA_TANNER_STAGING_DTL WHERE PATIENT_ID=? /*AND ENCOUNTER_ID=?*/ ORDER BY EVENT_DATE_TIME DESC)  WHERE ROWNUM=1";
			String tannerStagingScoreSql = " SELECT TANNERSTAGING,TO_CHAR (event_date_time, 'dd/mm/yyyy hh24:mi:ss') event_date_time,ROWNUM FROM(SELECT PUBIC_HAIR_STAGE||'|'||PUBERTY_STAGE TANNERSTAGING,event_date_time FROM CA_TANNER_STAGING_DTL WHERE PATIENT_ID=? ORDER BY EVENT_DATE_TIME DESC)  WHERE ROWNUM=1";

			pstmt   = con.prepareStatement(tannerStagingScoreSql);
			pstmt.setString(1,patientId) ;			
			//pstmt.setString(2,encounter_id); commented for IN069047
			rs    = pstmt.executeQuery();

			if(rs!=null && rs.next()){
				//tannerStagingDetails = rs.getString("TANNERSTAGING")==null?"":rs.getString("TANNERSTAGING");IN069057	
				tannerStagingDetails.add(rs.getString( "TANNERSTAGING"));
				tannerStagingDetails.add(rs.getString( "event_date_time"));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con != null) ConnectionManager.returnConnection(con);
			}catch(Exception ex){
				System.err.println("Exception in getTannerStagingScoreDetails - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return tannerStagingDetails;
	}
	
	//public JSONObject getBallardScoreHeaderDetails(HttpServletRequest request, String patientId,String facility_id,String local,String login_practitioner_id) throws Exception{ //IN069046
	public JSONObject getBallardScoreHeaderDetails(HttpServletRequest request, String patientId,String facility_id,String local,String login_practitioner_id,String recorded_date) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		
		JSONObject jsonObj	= new JSONObject();
		String siteName 	= "";
		String facilityName = "";
		String patientName	= "";
		String recordedDate	= "";
		String practitionerName		= "";
		String loginPractitionerName = "";
		String note_print_time_interval="0";
		try{
			con = ConnectionManager.getConnection(request);

			String ballardScoreheaderSql = " SELECT SM_GET_DESC.SM_SITE_PARAM(SITE_ID,?,'1') SITE_NAME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') FACILITY_NAME FROM SM_FACILITY_PARAM WHERE FACILITY_ID=? ";
			//String ballardScorePatientSql =" SELECT PATIENT_ID,MP_GET_DESC.MP_PATIENT(PATIENT_ID,'1') PATIENT_NAME, TO_CHAR(EVENT_DATE_TIME,'dd/mm/yyyy hh24:mi') EVENT_DATE_TIME,AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,'1') PRACTITIONER_NAME,AM_GET_DESC.AM_PRACTITIONER(?,?,'1') LOGIN_PRACTITIONER_NAME  FROM CA_TANNER_STAGING_DTL WHERE PATIENT_ID=? AND ROWNUM=1";
			String ballardScorePatientSql =" SELECT PATIENT_ID,MP_GET_DESC.MP_PATIENT(PATIENT_ID,'1') PATIENT_NAME, TO_CHAR(EVENT_DATE_TIME,'dd/mm/yyyy hh24:mi:ss') EVENT_DATE_TIME,AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,'1') PRACTITIONER_NAME,AM_GET_DESC.AM_PRACTITIONER(?,?,'1') LOGIN_PRACTITIONER_NAME  FROM CA_TANNER_STAGING_DTL WHERE PATIENT_ID=? AND to_char(event_date_time,'dd/mm/yyyy hh24:mi:ss')=to_char (to_date(?,'dd/mm/yyyy hh24:mi:ss'), 'dd/mm/rrrr hh24:mi:ss')";//IN069046
			pstmt   = con.prepareStatement(ballardScoreheaderSql);
			pstmt.setString(1,local) ;	
			pstmt.setString(2,local) ;			
			pstmt.setString(3,facility_id) ;
			
			rs    = pstmt.executeQuery();

			if(rs!=null && rs.next()){
				siteName		= rs.getString("SITE_NAME")==null?"":rs.getString("SITE_NAME");
				facilityName	= rs.getString("FACILITY_NAME")==null?"":rs.getString("FACILITY_NAME");
			}
			
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			
			pstmt   = con.prepareStatement(ballardScorePatientSql);
			pstmt.setString(1,local) ;	
			pstmt.setString(2,login_practitioner_id) ;
			pstmt.setString(3,local) ;
			pstmt.setString(4,patientId) ;
			pstmt.setString(5,recorded_date) ;//IN069046
			
			rs    = pstmt.executeQuery();

			if(rs!=null && rs.next()){
				patientName		= rs.getString("PATIENT_NAME")==null?"":rs.getString("PATIENT_NAME");
				recordedDate	= rs.getString("EVENT_DATE_TIME")==null?"":rs.getString("EVENT_DATE_TIME");
				practitionerName	= rs.getString("PRACTITIONER_NAME")==null?"":rs.getString("PRACTITIONER_NAME");
				loginPractitionerName	= rs.getString("LOGIN_PRACTITIONER_NAME")==null?"":rs.getString("LOGIN_PRACTITIONER_NAME");
			}
			
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			
			pstmt	=	con.prepareStatement("SELECT NOTE_PRINT_TIME_INTERVAL FROM CA_NOTE_PARAM ");
			rs    = pstmt.executeQuery();
			if(rs!=null && rs.next()){			
				note_print_time_interval			= rs.getString("NOTE_PRINT_TIME_INTERVAL") == null ? "0" : (String)rs.getString("NOTE_PRINT_TIME_INTERVAL");
			}
			
			jsonObj.put("SITE_NAME",siteName);
			jsonObj.put("FACILITY_NAME",facilityName);
			jsonObj.put("PATIENT_NAME",patientName);
			jsonObj.put("EVENT_DATE_TIME",recordedDate);
			jsonObj.put("PRACTITIONER_NAME",practitionerName);
			jsonObj.put("LOGIN_PRACTITIONER_NAME",loginPractitionerName);
			jsonObj.put("NOTE_PRINT_TIME_INTERVAL",note_print_time_interval);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con != null) ConnectionManager.returnConnection(con);
			}catch(Exception ex){
				System.err.println("Exception in getBallardScoreDetails - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}
	//IN067402 Starts
	public ArrayList getTannerStagingAuditDetails(HttpServletRequest request,String pract_id,String locale,String patientId,String encounter_id,String date_from,String date_to) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		
		if(pract_id.equals(" ") || pract_id.equals("null")) pract_id = "";
		if(locale.equals(" ") || locale.equals("null")) locale = "";
		if(patientId.equals(" ") || patientId.equals("null")) patientId = "";
		if(encounter_id.equals(" ") || encounter_id.equals("null")) encounter_id = "";
		if(date_from.equals(" ") || date_from.equals("null")) date_from = "";
		if(date_to.equals(" ") || date_to.equals("null")) date_to = "";
		
		int i = 1;
		ArrayList tannerStagingAuditDetails	= new ArrayList() ;
		try{
			con = ConnectionManager.getConnection(request);

			StringBuffer tannerStagingAuditSql	  = new StringBuffer();
			
			tannerStagingAuditSql.append("SELECT am_get_desc.am_practitioner (practitioner_id, ?, '1') prac_name, tanner_audit ,event_date_time,encounter_id,ROWNUM FROM(SELECT PUBIC_HAIR_STAGE||'|'||PUBERTY_STAGE TANNER_AUDIT,TO_CHAR (event_date_time, 'dd/mm/yyyy hh24:mi:ss') event_date_time,encounter_id,practitioner_id,to_number(to_char(event_date_time,'YYYYMMDDHH24MISS')) RR FROM CA_TANNER_STAGING_DTL WHERE PATIENT_ID=?");
			if(!date_from.equals("") && !date_to.equals("")){
				tannerStagingAuditSql.append(" and event_date_time between to_date(?,'DD/MM/YYYY hh24:mi:ss') and to_date(?,'DD/MM/YYYY hh24:mi:ss') ");
			}
			else if(!date_from.equals("")){
				tannerStagingAuditSql.append("and event_date_time >= to_date(NVL(?,'01/01/1000'),'dd/mm/yyyy hh24:mi:ss')");
			}
			else if(!date_to.equals("")){
				tannerStagingAuditSql.append("and event_date_time <= to_date(NVL(?,'01/01/9999'),'dd/mm/yyyy hh24:mi:ss')+0.00068287 ");
			}
			if(!encounter_id.equals("")){
				tannerStagingAuditSql.append(" AND encounter_id = ? ");
			}
			tannerStagingAuditSql.append(" order by RR desc) ");
			
			pstmt   = con.prepareStatement(tannerStagingAuditSql.toString());
			pstmt.setString(i++,locale) ;		
			pstmt.setString(i++,patientId) ;
			
			if(!date_from.equals("") && !date_to.equals("")){
				pstmt.setString(i++,date_from) ;	
				pstmt.setString(i++,date_to) ;	
			}
			else if(!date_from.equals("")){	
				pstmt.setString(i++,date_from) ;
			}
			else if(!date_to.equals("")){	
				pstmt.setString(i++,date_to) ;
			}
			
			if(!encounter_id.equals("")){	
				pstmt.setString(i++,encounter_id);
			}
			
			rs    = pstmt.executeQuery();

			while(rs.next()){ 
					ArrayList TannerAuditDetails	= new ArrayList() ;
					TannerAuditDetails.add(rs.getString( "prac_name"));
					TannerAuditDetails.add(rs.getString( "tanner_audit"));
					TannerAuditDetails.add(rs.getString( "event_date_time"));
					TannerAuditDetails.add(rs.getString( "encounter_id"));
					tannerStagingAuditDetails.add(TannerAuditDetails);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con != null) ConnectionManager.returnConnection(con);
			}catch(Exception ex){
				System.err.println("Exception in getTannerStagingScoreDetails - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return tannerStagingAuditDetails;
	}
	//IN067402 ends
}