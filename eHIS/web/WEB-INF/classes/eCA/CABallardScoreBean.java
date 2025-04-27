/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA;

import java.io.* ;
import java.sql.* ;
import javax.servlet.http.* ;
import org.json.simple.*;
import webbeans.eCommon.*;
public class  CABallardScoreBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;
	//	public JSONArray getBallardScoreDetails(HttpServletRequest request, String patientId) throws Exception{//commented for IN067564
	public JSONArray getBallardScoreDetails(HttpServletRequest request, String patientId,String isAuditYN,String encounter_id,String Recorded_date) throws Exception{// added for IN067564
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		JSONArray arrJSON		= new JSONArray();
		//IN067564 starts
	    String ballardScoreSql = "";
	    String ballardscoreview = "";
		//IN067564 ends
	
		try{
			con = ConnectionManager.getConnection(request);
			//IN067564 starts
            if(isAuditYN.equals("Y")){
				ballardscoreview = "SELECT  a.ballard_score_code, a.ballard_score_value, b.ballard_score_type, b.ballard_score_css FROM ca_ballard_score_action a, ca_ballard_score_code b WHERE a.ballard_score_code = b.ballard_score_code AND a.patient_id = ? AND a.encounter_id = ? and a.EVENT_DATE_TIME = to_date(?, 'DD/MM/YYYY hh24:mi:ss') ";
				pstmt   = con.prepareStatement(ballardscoreview);
			     pstmt.setString(1,patientId) ;
                 pstmt.setString(2,encounter_id) ;
				 pstmt.setString(3,Recorded_date) ;
				
			}
			else
			{
			ballardScoreSql = " SELECT A.BALLARD_SCORE_CODE,A.BALLARD_SCORE_VALUE,B.BALLARD_SCORE_TYPE,B.BALLARD_SCORE_CSS FROM CA_BALLARD_SCORE_DTL A, CA_BALLARD_SCORE_CODE B WHERE A.BALLARD_SCORE_CODE=B.BALLARD_SCORE_CODE AND PATIENT_ID=? ";
			pstmt   = con.prepareStatement(ballardScoreSql);
				pstmt.setString(1,patientId) ;	
			}
			//IN067564 ends
			rs    = pstmt.executeQuery();
			while(rs!=null && rs.next()){
				
				JSONObject jsonObj	= new JSONObject();
				String code		= rs.getString("BALLARD_SCORE_CODE")==null?"":rs.getString("BALLARD_SCORE_CODE");
				String value	= rs.getString("BALLARD_SCORE_VALUE")==null?"":rs.getString("BALLARD_SCORE_VALUE");
				String parentId	= rs.getString("BALLARD_SCORE_TYPE")==null?"":rs.getString("BALLARD_SCORE_TYPE");
				String css		= rs.getString("BALLARD_SCORE_CSS")==null?"":rs.getString("BALLARD_SCORE_CSS");
				jsonObj.put("B_CODE",code);
				jsonObj.put("B_VALUE",value);
				jsonObj.put("PARENT_ID",parentId);
				jsonObj.put("B_CSS",css);
				
				arrJSON.add(jsonObj);
				
			}
			
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
		return arrJSON;
	}
	//public JSONObject getBallardScoreHeaderDetails(HttpServletRequest request, String patientId,String facility_id,String local,String login_practitioner_id) throws Exception{//commented for IN067564
	public JSONObject getBallardScoreHeaderDetails(HttpServletRequest request, String patientId,String facility_id,String local,String login_practitioner_id,String isAuditYN,String encounter_id,String Recorded_date) throws Exception{
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
			String ballardScorePatientSql =" SELECT PATIENT_ID,MP_GET_DESC.MP_PATIENT(PATIENT_ID,'1') PATIENT_NAME, TO_CHAR(EVENT_DATE_TIME,'dd/mm/yyyy hh24:mi:ss') EVENT_DATE_TIME,AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,'1') PRACTITIONER_NAME,AM_GET_DESC.AM_PRACTITIONER(?,?,'1') LOGIN_PRACTITIONER_NAME  FROM CA_BALLARD_SCORE_DTL WHERE PATIENT_ID=? AND ROWNUM=1";
			////IN067564 starts
			String ballardScoreAuditPrintSql ="SELECT distinct patient_id, mp_get_desc.mp_patient (patient_id, '1') patient_name,TO_CHAR (event_date_time, 'dd/mm/yyyy hh24:mi:ss') event_date_time,am_get_desc.am_practitioner (practitioner_id, ?, '1') practitioner_name,am_get_desc.am_practitioner (?,?, '1') login_practitioner_name FROM ca_ballard_score_action WHERE patient_id = ? and encounter_id=? and EVENT_DATE_TIME = to_date(?, 'DD/MM/YYYY hh24:mi:ss')";
			//IN067564 ends
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
			//IN067564 starts
			if(isAuditYN.equals("Y")){
				pstmt   = con.prepareStatement(ballardScoreAuditPrintSql);
				pstmt.setString(1,local) ;	
				pstmt.setString(2,login_practitioner_id) ;	
				pstmt.setString(3,local) ;
				pstmt.setString(4,patientId) ;
				pstmt.setString(5,encounter_id) ;
				pstmt.setString(6,Recorded_date) ;
				
			
			}else{//IN067564 ends
				pstmt   = con.prepareStatement(ballardScorePatientSql);
				pstmt.setString(1,local) ;	
				pstmt.setString(2,login_practitioner_id) ;	
				pstmt.setString(3,local) ;
				pstmt.setString(4,patientId) ;
				
			}
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
	//IN067564 starts
	public JSONArray getBallardScoreAuditDetails(HttpServletRequest request, String patientId,String locale,String facility_id,String encounter_id,String date_from, String date_to) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		JSONArray arrJSON		= new JSONArray();
		String practitionerName	= "";
		String recordedDate		= "";
		String enc_id  ="";
		int i = 1;
		
		try{
			con = ConnectionManager.getConnection(request);

			StringBuffer ballardScoreAuditdetailSql	  = new StringBuffer();
			ballardScoreAuditdetailSql.append(" SELECT distinct TO_CHAR (event_date_time, 'dd/mm/yyyy hh24:mi:ss') event_date_time,am_get_desc.am_practitioner (practitioner_id,?,'1'  ) practitioner_name,encounter_id,to_number(to_char(event_date_time,'YYYYMMDDHH24MISS'))event_date_time_1 FROM ca_ballard_score_action WHERE patient_id = ? AND facility_id = ? ");
			if(!date_from.equals("") && !date_to.equals("")){
				ballardScoreAuditdetailSql.append(" and event_date_time between to_date(?,'DD/MM/YYYY hh24:mi:ss') and to_date(?,'DD/MM/YYYY hh24:mi:ss') ");
			}
			else if(!date_from.equals("")){
			 
				ballardScoreAuditdetailSql.append("and event_date_time >= to_date(NVL(?,'01/01/1000'),'dd/mm/yyyy hh24:mi:ss')");
			}
			else if(!date_to.equals("")){
				
				ballardScoreAuditdetailSql.append("and event_date_time <= to_date(NVL(?,'01/01/9999'),'dd/mm/yyyy hh24:mi:ss')+0.00068287 ");
			}
			if(!encounter_id.equals("")){
				ballardScoreAuditdetailSql.append(" AND encounter_id = ? ");
			}
			ballardScoreAuditdetailSql.append(" order by event_date_time_1 desc ");  
		
			pstmt   = con.prepareStatement(ballardScoreAuditdetailSql.toString());
			pstmt.setString(i++,locale) ;	
			pstmt.setString(i++,patientId) ;	
			pstmt.setString(i++,facility_id) ;	
			
			if(!date_from.equals("") && !date_to.equals("")){
				pstmt.setString(i++,date_from) ;	
				pstmt.setString(i++,date_to) ;	
			}else if(!date_from.equals("")){	
		
				pstmt.setString(i++,date_from) ;
			}else if(!date_to.equals("")){	
				pstmt.setString(i++,date_to) ;
			}
			if(!encounter_id.equals("")){
			pstmt.setString(i++,encounter_id) ;	
			}
			rs    = pstmt.executeQuery();

			while(rs!=null && rs.next()){
				JSONObject jsonObj	= new JSONObject();

				recordedDate	= rs.getString("EVENT_DATE_TIME")==null?"":rs.getString("EVENT_DATE_TIME");
				practitionerName	= rs.getString("PRACTITIONER_NAME")==null?"":rs.getString("PRACTITIONER_NAME");
                enc_id	= rs.getString("encounter_id")==null?"":rs.getString("encounter_id");
				
				jsonObj.put("recordedDate",recordedDate);
				jsonObj.put("practitionerName",practitionerName);
				jsonObj.put("enc_id",enc_id);

				arrJSON.add(jsonObj);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con != null) ConnectionManager.returnConnection(con);
			}catch(Exception ex){
				System.err.println("Exception in getBallardScoreAuditDetails - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
	}////IN067564 ends
	public String getBallardScoreRecordedYN(HttpServletRequest request, String patientId) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String scoreRecordedYN	= "N";
	
		try{
			con = ConnectionManager.getConnection(request);

			String ballardScoreSql = " SELECT COUNT(*) TOT_COUNT FROM CA_BALLARD_SCORE_DTL A WHERE  PATIENT_ID=? ";

			pstmt   = con.prepareStatement(ballardScoreSql);
			pstmt.setString(1,patientId) ;			
			
			rs    = pstmt.executeQuery();

			if(rs!=null && rs.next()){			
				
				scoreRecordedYN		= rs.getInt("TOT_COUNT")==0?"N":"Y";
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con != null) ConnectionManager.returnConnection(con);
			}catch(Exception ex){
				System.err.println("Exception in getBallardScoreRecordedYN - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return scoreRecordedYN;
	}
	//IN067564 starts
	public String getBallardScoreNotRecordedYN(HttpServletRequest request,String patientId,String encounter_id,String date_from, String date_to) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String RecordedScoreYN	= "N";
		int i = 1;
	
		try{
			con = ConnectionManager.getConnection(request); 
            StringBuffer ballardRecordedScoreSql = new StringBuffer();
			ballardRecordedScoreSql.append(" SELECT COUNT(*) TOT_COUNT FROM CA_BALLARD_SCORE_Action A WHERE  PATIENT_ID=? ");
			if(!encounter_id.equals("")){
				ballardRecordedScoreSql.append(" AND encounter_id = ? ");
			}if(!date_from.equals("") && !date_to.equals("")){
				ballardRecordedScoreSql.append(" and event_date_time between to_date(?,'DD/MM/YYYY hh24:mi:ss') and to_date(?,'DD/MM/YYYY hh24:mi:ss') ");
			}else if(!date_from.equals("")){
				ballardRecordedScoreSql.append("and event_date_time >= to_date(NVL(?,'01/01/1000'),'dd/mm/yyyy hh24:mi:ss')");
			}else if(!date_to.equals("")){
				ballardRecordedScoreSql.append("and event_date_time <= to_date(NVL(?,'01/01/9999'),'dd/mm/yyyy hh24:mi:ss')+0.00068287 ");
			}

			pstmt   = con.prepareStatement(ballardRecordedScoreSql.toString());
			pstmt.setString(i++,patientId) ;
			if(!encounter_id.equals("")){
				pstmt.setString(i++,encounter_id) ;
			}
			if(!date_from.equals("") && !date_to.equals("")){
				pstmt.setString(i++,date_from) ;	
				pstmt.setString(i++,date_to) ;	
			}else if(!date_from.equals("")){	
				pstmt.setString(i++,date_from) ;
			}else if(!date_to.equals("")){	
				pstmt.setString(i++,date_to) ;
			}
			
			rs    = pstmt.executeQuery();

			if(rs!=null && rs.next()){			
				
				RecordedScoreYN		= rs.getInt("TOT_COUNT")==0?"N":"Y";
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con != null) ConnectionManager.returnConnection(con);
			}catch(Exception ex){
				System.err.println("Exception in getBallardScoreNotRecordedYN - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return RecordedScoreYN;
	}
	
}//IN067564 starts