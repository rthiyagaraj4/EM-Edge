/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*Created by Dharma on May 27th 2015*/ 
package eAE;
import java.util.* ;
import java.io.* ;
import java.sql.* ;
import javax.servlet.http.* ;
import javax.servlet.jsp.PageContext;
import org.json.simple.parser.JSONParser;
import org.json.simple.*;

import webbeans.eCommon.*;

public class AECommonBean implements java.io.Serializable{


/*Added by Dharma on May 27th 2015 against PMG2015-GDOH-CRF-0006 [IN:055606] Start*/

 public static Map getDisasterPatientSeries(Connection con, String userId, String locale,String site,String facilityId, String pat_ser_access_by_user_yn ) {

	PreparedStatement pstmt				= null;
	ResultSet rs						= null;
	TreeMap<String, String>  patientSeriesList			= new TreeMap<String, String>() ;
	String userAccessSql				= "";
	StringBuffer sqlbuf					= new StringBuffer();

	try {	
		if(pat_ser_access_by_user_yn.equals("Y")){
			userAccessSql	= "and pat_ser_grp_code IN (SELECT pat_ser_grp_code FROM MP_PAT_SER_GRP_FOR_USER WHERE APPL_USER_ID = '"+userId+"')";
		}
		sqlbuf.append("select pat_ser_grp_code, short_desc,id_type,pat_name_in_loc_lang_reqd_yn, prefix_reqd_yn from mp_pat_ser_grp_lang_vw where language_id='"+locale+"'  and  gen_pat_id_yn = 'Y' and gen_pid_using_alt_id1_rule_yn = 'N' and id_type in ('E', 'U','G','N') and (pat_ser_grp_code in (select pat_ser_grp_code from mp_pat_ser_facility where  site_or_facility_id = decode(site_or_facility,'S',?,'F',?) and used_status = 'N' ))  "+userAccessSql+" order by 2");
		pstmt = con.prepareStatement(sqlbuf.toString());
		pstmt.setString(1,site);
		pstmt.setString(2,facilityId);
		rs = pstmt.executeQuery();
		if(rs !=null)  {
			while(rs.next())  {
				 patientSeriesList.put( rs.getString(1), rs.getString(2) ) ;
			}
		}

	} catch ( Exception e ) {
		System.err.println( e ) ;
	} finally {
			try{
				if(pstmt !=null) pstmt.close();
				if(rs !=null) rs.close();
			} catch(Exception fe){
			}
	}

   return patientSeriesList ;
  }

  public static String getDownTimePatientsListCount(Connection con,String patientSeriesId,String facility_id) throws Exception{

		PreparedStatement pstmt				= null;
		ResultSet rs						= null;
		String result						= "";
		try{
			
			//pstmt = con.prepareStatement("SELECT SUM (DECODE ((SELECT COUNT (*) FROM bl_patient_fin_dtls WHERE patient_id = a.patient_id), 0, 0, 1)) used,SUM (DECODE ((SELECT COUNT (*) FROM bl_patient_fin_dtls WHERE patient_id = a.patient_id), 0, 1, 0)) UNUSED, SUM (1) total  FROM mp_patient a WHERE a.pat_ser_grp_code = ? AND a.disaster_regn_yn = 'Y'");
			
			pstmt = con.prepareStatement("SELECT SUM (DECODE (regn_date, null, 0, 1)) used,SUM (DECODE (regn_date, null, 1, 0)) not_used,SUM (1) total  FROM mp_patient  WHERE pat_ser_grp_code = ? AND DOWNTIME_REGN_YN = 'Y' and REGN_FACILITY_ID	= ?");

			pstmt.setString(1,patientSeriesId);
			pstmt.setString(2,facility_id);
			rs = pstmt.executeQuery();
			if(rs!=null){
			if (rs.next())
				result = Integer.toString(rs.getInt("used")) + "||" + Integer.toString(rs.getInt("not_used")) + "||" + Integer.toString(rs.getInt("total"));
			}

		
		}catch(Exception e)	{
			e.printStackTrace();
		}finally{
			try{
				if(rs !=null) rs.close();
				if(pstmt !=null) pstmt.close();
			} catch(Exception fe){
			}
		}

		return result;
	}

/*Added by Dharma on May 27th 2015 against PMG2015-GDOH-CRF-0006 [IN:055606] End*/

/*Added by Thamizh selvi on 31st Jan 2017 against ML-MMOH-CRF-0724 Start*/
	public static JSONArray getPriorityZoneList(Connection con, String locale, String facilityID) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		JSONArray arrJSON		= new JSONArray();
	
		try{

			String priorZoneSql = " SELECT PRIORITY_ZONE,PRIORITY_ZONE_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID= ? and EFF_STATUS='E' order by PRIORITY_ZONE_ORDER asc ";

			pstmt   = con.prepareStatement(priorZoneSql);
			pstmt.setString(1,locale) ;
			rs    = pstmt.executeQuery();

			while(rs!=null && rs.next()){
				
				JSONObject jsonObj	= new JSONObject();
				String priorityZone		= rs.getString("PRIORITY_ZONE")==null?"":rs.getString("PRIORITY_ZONE");
				String priorityZoneDesc		= rs.getString("PRIORITY_ZONE_DESC")==null?"":rs.getString("PRIORITY_ZONE_DESC");

				jsonObj.put("PRIORITY_ZONE",priorityZone);
				jsonObj.put("PRIORITY_ZONE_DESC",priorityZoneDesc);
				
				arrJSON.add(jsonObj);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getPriorityZoneList - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
	}
/*End*/

/*Added by Thamizh selvi on 2nd Feb 2017 against ML-MMOH-CRF-0634 Start*/
	public static JSONArray getTermSetList(Connection con) throws Exception{
		Statement stmt	= null;
		ResultSet rs 			= null;
		JSONArray arrJSON		= new JSONArray();

		try{

			String termSetSql = "select term_set_id,term_set_desc from mr_term_set where diag_spec_yn='Y' and EFF_STATUS='E' order by term_set_desc";
			stmt = con.createStatement();
			rs = stmt.executeQuery(termSetSql);
			
			while(rs!=null && rs.next()){
				JSONObject jsonObj	= new JSONObject();
				String termSetID = rs.getString("term_set_id")==null?"":rs.getString("term_set_id");
				String termSetDesc = rs.getString("term_set_desc")==null?"":rs.getString("term_set_desc");

				jsonObj.put("term_set_id",termSetID);
				jsonObj.put("term_set_desc",termSetDesc);
				
				arrJSON.add(jsonObj);

			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getTermSetList - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
	}

	public static String getSysDate(Connection con) throws Exception{
		Statement stmt	= null;
		ResultSet rs 	= null;
		String sysdate	= null;

		try{

			String sysDateSql = "Select to_char(sysdate,'DD/MM/YYYY') currdate from dual";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sysDateSql);
			
			while(rs!=null && rs.next()){
				sysdate = rs.getString("currdate")==null?"":rs.getString("currdate");

			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getSysDate - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return sysdate;
	}

/*End*/

/*Added by Ashwini on 26-Apr-2017 for ML-MMOH-CRF-0641 Start*/
	public static JSONArray getSecTriageRemarks(Connection con, String encounter_id) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rset 			= null;
		JSONArray arrJSON		= new JSONArray();

		try{

			String sqlQuery = "select TO_CHAR(recorded_date,'dd/mm/yyyy hh24:mi:ss')recorded_date, remarks from AE_PAT_EMERGENCY_DETAIL where encounter_id = ? and remarks IS NOT NULL order by recorded_date desc";

			pstmt= con.prepareStatement(sqlQuery);
			pstmt.setString(1,encounter_id);
			rset= pstmt.executeQuery();
			
			while(rset!=null && rset.next()){
				JSONObject jsonObj	= new JSONObject();
				String recorded_date = rset.getString("recorded_date")==null?"":rset.getString("recorded_date");
				String remarks = rset.getString("remarks")==null?"":rset.getString("remarks");

				jsonObj.put("recorded_date",recorded_date);
				jsonObj.put("remarks",remarks);
				
				arrJSON.add(jsonObj);

			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rset!=null)rset.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getSecTriageRemarks - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
	}

	public static String getDisasterRegnDate(Connection con, String encounter_id) throws Exception{
		PreparedStatement pstmt1	= null;
		ResultSet rset1 			= null;
		String regn_date_time		= null;
		
		try{

			String sqlQuery1 = "SELECT TO_CHAR(regn_date_time,'dd/mm/yyyy hh24:mi:ss')regn_date_time FROM ae_disaster_pat_regn a WHERE EXISTS (SELECT 1 FROM ae_current_patient b WHERE b.encounter_id BETWEEN a.from_encounter_id AND a.to_encounter_id AND b.encounter_id = ?)";

			pstmt1= con.prepareStatement(sqlQuery1);
			pstmt1.setString(1,encounter_id);
			rset1= pstmt1.executeQuery();
			
			if(rset1!=null && rset1.next()){
				regn_date_time = rset1.getString("regn_date_time")==null?"":rset1.getString("regn_date_time");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rset1!=null)rset1.close();
				if(pstmt1!=null)pstmt1.close();
			}catch(Exception ex){
				System.err.println("Exception in getDisasterRegnDate - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return regn_date_time;
	}

/*End*/

public static JSONObject getPlaceOfOccurrence(Connection con,String place_occurrence_type_code,String long_desc,String short_desc,String enabled,String[] ord,String whereClause,int currentPageNo) throws Exception
{ 
		Statement stmt=null;
		ResultSet rs=null;
		JSONObject json	= new JSONObject();
		JSONArray pmbArrJSON		= new JSONArray();
		//StringBuffer sqlSb			= new StringBuffer(); //commented for checkstyle
		int recordsPerPage 			= 16;
		int noOfRecs = 0;
		//int noOfRecords 			= 0; //commented for checkstyle
		int noOfPages	 			= 0;	
		int from 		 			= 1;
		int to			 			= recordsPerPage;
		StringBuffer sql = new StringBuffer();
		
		if(currentPageNo!=1){
			from		= (currentPageNo - 1) * recordsPerPage +1;
			to			= (from -1) + recordsPerPage;
		}
	
	try{
		
		if ( (whereClause == null || whereClause.equals("")) ) {
		 
		 int andCheck 				= 0;
		 // Changing to Upper case and checking
		 place_occurrence_type_code			= place_occurrence_type_code.toUpperCase();
	
	 if ( !(place_occurrence_type_code== null || place_occurrence_type_code.equals("")) ){
	  sql.append( " where upper(PLACE_OCCURRENCE_TYPE_CODE) like upper('"+place_occurrence_type_code+"%')");
	  andCheck 	= 1;
	 }
	
	if ( !(long_desc == null || long_desc.equals("")) )
	 {

	    if ( andCheck == 1 )
	    {
			  sql.append(" and ");
	     	  sql.append(" upper(LONG_DESC) like upper('"+long_desc+"%')");
	    }
	    else
	    {
			 sql.append(" where upper(LONG_DESC) like upper('"+long_desc+"%')");
			 andCheck 	= 1;
	    }
	 }
     if ( !(short_desc == null || short_desc.equals("")) )
	 {

	    if ( andCheck == 1 )
	    {
			  sql.append(" and ");
	     	  sql.append(" upper(short_desc) like upper('"+short_desc+"%')");
	    }
	    else
	    {
			 sql.append(" where upper(short_desc) like upper('"+short_desc+"%')");
			 andCheck 	= 1;
	    }
	 }
	  if ( !(enabled == null || enabled.equals("")) )
	     {

   	        if ( enabled.equals("E") )
            {
				if ( andCheck == 0 ) 
				 {
					sql.append(" where EFF_STATUS='E'");
					andCheck = 1;
				}
				else{
					 sql.append(" and EFF_STATUS='E'");
				}
			}
   			if ( enabled.equals("D") )
			{

			  if ( andCheck == 0 ) 
			   {
					sql.append(" where  EFF_STATUS='D'");
					andCheck = 1; 
				}
	          else{
				  sql.append(" and EFF_STATUS='D'");
			  }
	       }
   			if ( enabled.equals("B") )
   			{
   	   		} 
	    }
	//appending order by clause

	if ( !(ord == null || ord .equals("")) )
	{

		sql.append(" order by ");

		for ( int i=0;i < ord.length;i++ )
	 	{
	 	if ( i == ord.length - 1 ){
			sql.append(ord[i]);
		}
		else{
			sql.append(ord[i]+",");
		}
		}
	}  
	} //end of where clause IF
	else 
		{

			sql.append(whereClause);
		}
	stmt = con.createStatement();

	  StringBuffer strsql = new StringBuffer("select * from ( ");
	  strsql.append("select COUNT (*) OVER () noOfRecords,rownum as rcnt,PLACE_OCCURRENCE_TYPE_CODE,LONG_DESC,SHORT_DESC,EFF_STATUS from AE_PLACE_OF_OCCURRENCE  ");
	  
	  strsql.append(sql.toString());
	  strsql.append(" ) results where rcnt between '"+from+"' AND '"+to+"'");
	  
 	  rs = stmt.executeQuery(strsql.toString());
	  
	  while(rs!=null && rs.next()){
				JSONObject jsonObj	= new JSONObject();
				noOfRecs	= rs.getInt("noOfRecords");
				String POCode		= rs.getString("PLACE_OCCURRENCE_TYPE_CODE")==null?"":rs.getString("PLACE_OCCURRENCE_TYPE_CODE");
				String POLDesc	= rs.getString("LONG_DESC")==null?"":rs.getString("LONG_DESC");
				String POSDesc	= rs.getString("SHORT_DESC")==null?"":rs.getString("SHORT_DESC");
				String POStatus	= rs.getString("EFF_STATUS")==null?"":rs.getString("EFF_STATUS");
				
			
				jsonObj.put("POCode",POCode);
				jsonObj.put("POLDesc",POLDesc);
				jsonObj.put("POSDesc",POSDesc);
				jsonObj.put("POStatus",POStatus);
				
				
				pmbArrJSON.add(jsonObj);
			}
			noOfPages = (int) Math.ceil(noOfRecs * 1.0 / recordsPerPage);
			if(to > noOfRecs){
				to	= noOfRecs;
			}
			
			json.put("PMBArray",pmbArrJSON);
			json.put("currentPageNo", currentPageNo);
			json.put("noOfRecords", noOfRecs);
			json.put("noOfPages", noOfPages);
	
	}
	catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(stmt!=null)	stmt.close();
		 if(rs!=null)	rs.close();
		
			}catch(Exception ex){
				System.err.println("Exception in getPlaceOfOccurrence - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		
	return json;
}
/*Added by Thamizh selvi on 20th Oct 2017 for ML-MMOH-CRF-0623 Start*/
public static JSONObject getAEParam(Connection con, String facilityId) throws Exception{

		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		JSONObject jsonObj			= new JSONObject();
		String allowBackdateConsYn	= "";
		String allowBackdateConsHrs	= "";
		String aeParamAllowedDate	= "";
		//Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657
		String invokeRecallForAE	= "";
		//Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409
		String reconfirm_case_of_trauma	= "";

		try{
			String sql = " select backdate_cons_allowed_yn, backdate_cons_allowed_hrs, to_char((sysdate - (backdate_cons_allowed_hrs / 24)), 'dd/mm/yyyy hh24:mi') aeParamAllowedDate, invoke_recall_for_ae, reconfirm_case_of_trauma from ae_param where operating_facility_id='"+facilityId+"' ";
			
			pstmt = con.prepareStatement(sql);
			rs	= pstmt.executeQuery();

			if(rs!=null && rs.next()){
				allowBackdateConsYn	= rs.getString("backdate_cons_allowed_yn");
				allowBackdateConsHrs= rs.getString("backdate_cons_allowed_hrs");
				aeParamAllowedDate	= rs.getString("aeParamAllowedDate");
				//Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657
				invokeRecallForAE	= rs.getString("invoke_recall_for_ae");
				//Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409
				reconfirm_case_of_trauma = rs.getString("reconfirm_case_of_trauma");
			}
			
			jsonObj.put("allowBackdateConsYn",allowBackdateConsYn);
			jsonObj.put("allowBackdateConsHrs",allowBackdateConsHrs);
			jsonObj.put("aeParamAllowedDate",aeParamAllowedDate);
			//Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657
			jsonObj.put("invokeRecallForAE",invokeRecallForAE);
			//Added by Ashwini on 18-Jan-2021 for ML-MMOH-CRF-1409
			jsonObj.put("reconfirm_case_of_trauma",reconfirm_case_of_trauma);

		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getAEParam - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
}

public static JSONObject getCurrentStatusOfAEPatient(Connection con, String facilityId, String encounterId) throws Exception{

		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		JSONObject jsonObj			= new JSONObject();
		String assignTmtAreaTime	= "";
		String sysDateTime			= "";
		String queueStatus			= "";

		try{
			String sql = " SELECT TO_CHAR (assign_tmt_area_time, 'dd/mm/yyyy hh24:mi' ) assign_tmt_area_time, TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi') sys_date_time, queue_status FROM op_patient_queue WHERE facility_id = '"+facilityId+"' AND encounter_id = '"+encounterId+"' ";
			
			pstmt = con.prepareStatement(sql);
			rs	= pstmt.executeQuery();

			if(rs!=null && rs.next()){
				assignTmtAreaTime	= rs.getString("assign_tmt_area_time");
				sysDateTime			= rs.getString("sys_date_time");
				queueStatus			= rs.getString("queue_status");
			}
			
			jsonObj.put("assignTmtAreaTime",assignTmtAreaTime);
			jsonObj.put("sysDateTime",sysDateTime);
			jsonObj.put("queueStatus",queueStatus);

		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getCurrentStatusOfAEPatient - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
}/*End*/

/*Added by Thamizh selvi for ML-MMOH-CRF-0623 on 31st Oct 2017 Start*/
public static JSONObject getBackdatedConsDtls(Connection con, String locale, String facilityId, String trnFromDate, String trnToDate, String patient_id, int currentPageNo, int recordsPerPage) throws Exception{

	PreparedStatement pstmt	= null;
	ResultSet rs 			= null;
	JSONArray arrJSON		= new JSONArray();
	JSONObject json			= new JSONObject();
	StringBuffer sqlSb		= new StringBuffer();

	int noOfRecs				= 0;
	int noOfPages	 			= 0;	
	int from 		 			= 1;
	int to			 			= recordsPerPage;
		
	if(currentPageNo!=1){
		from		= (currentPageNo - 1) * recordsPerPage +1;
		to			= (from -1) + recordsPerPage;
	}

	try{
		
		sqlSb.append("select * from (SELECT  results.*, rownum as rcnt FROM (");

		sqlSb.append(" SELECT COUNT (*) OVER () noOfRecords, a.patient_id, DECODE ('"+locale+"', 'en', c.patient_name, NVL (c.patient_name_loc_lang, c.patient_name) ) patient_name, ae_get_desc.ae_tmt_area_for_clinic (b.facility_id, b.locn_code, b.treatment_area_code, 'en', '2' ) treatment_area_desc, to_char(a.transaction_date_time,'dd/mm/yyyy hh24:mi') transaction_date_time, to_char(a.backdated_cons_date_time,'dd/mm/yyyy hh24:mi') backdated_cons_date_time, a.backdated_cons_done_by_id FROM ae_cons_backdated_audit a, op_patient_queue b, mp_patient c WHERE a.facility_id = '"+facilityId+"' AND a.encounter_id = b.encounter_id AND a.patient_id = c.patient_id AND TRUNC (a.transaction_date_time) BETWEEN TO_DATE ('"+trnFromDate+"', 'dd/mm/yyyy' ) AND TO_DATE ('"+trnToDate+"', 'dd/mm/yyyy' ) AND a.patient_id like '"+patient_id+"%' ORDER BY TO_DATE(TO_CHAR(a.transaction_date_time, 'dd/mm/yyyy hh24:mi'), 'dd/mm/yyyy hh24:mi'), a.patient_id ");

		sqlSb.append(" ) results ) where rcnt between '"+from+"' AND '"+to+"'");
			
		pstmt = con.prepareStatement(sqlSb.toString());
		rs	= pstmt.executeQuery();

		while(rs!=null && rs.next()){
				
			JSONObject jsonObj	= new JSONObject();
			noOfRecs				= rs.getInt("noOfRecords");
			String patientId		= rs.getString("patient_id")==null?"":rs.getString("patient_id");
			String patientName		= rs.getString("patient_name")==null?"":rs.getString("patient_name");
			String treatmentZone	= rs.getString("treatment_area_desc")==null?"":rs.getString("treatment_area_desc");
			String trnDate			= rs.getString("transaction_date_time")==null?"":rs.getString("transaction_date_time");
			String consBackDate		= rs.getString("backdated_cons_date_time")==null?"":rs.getString("backdated_cons_date_time");
			String consDoneBy		= rs.getString("backdated_cons_done_by_id")==null?"":rs.getString("backdated_cons_done_by_id");

			jsonObj.put("patientId",patientId);
			jsonObj.put("patientName",patientName);
			jsonObj.put("treatmentZone",treatmentZone);
			jsonObj.put("trnDate",trnDate);
			jsonObj.put("consBackDate",consBackDate);
			jsonObj.put("consDoneBy",consDoneBy);
			arrJSON.add(jsonObj);

		}
		
		noOfPages = (int) Math.ceil(noOfRecs * 1.0 / recordsPerPage);
		if(to > noOfRecs){
			to	= noOfRecs;
		}
		json.put("backDatedConsDtlsArr",arrJSON);
		json.put("currentPageNo", currentPageNo);
		json.put("noOfRecords", noOfRecs);
		json.put("noOfPages", noOfPages);
			
	}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		try{
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
		}catch(Exception ex){
			System.err.println("Exception in getBackdatedConsDtls - "+ex.getMessage());
			ex.printStackTrace();
		}
	}
	return json;
}/*End*/

	/*Added by Ashwini on 18-Dec-2017 for ML-MMOH-CRF-0657*/
	public static int getFollowUpCnt(Connection con, String patient_id, String facilityId) throws Exception{
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		String sql					= "";
		int cnt						= 0;

		try{
			sql	= "select count(*) recall_tdy from OP_PATIENT_QUEUE where patient_id = '"+patient_id+"' AND facility_id = '"+facilityId+"' AND to_char(recall_date, 'dd/mm/yyyy') = to_char(sysdate,'dd/mm/yyyy') AND PATIENT_CLASS = 'EM' AND recalled_enc_id IS NULL";

			pstmt	= con.prepareStatement(sql);
			rs		= pstmt.executeQuery();
			if(rs!=null && rs.next()){
				cnt	= rs.getInt("recall_tdy");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getFollowUpCnt method  - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return cnt;
	}

	public static JSONArray getFollowUpDetails(Connection con, String patient_id, String facilityId) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rset 			= null;
		JSONArray arrJSON		= new JSONArray();

		try{
			String sqlQuery = "SELECT encounter_id, TO_CHAR (QUEUE_DATE, 'dd/mm/yyyy hh24:mi') enc_date_time, TO_CHAR (recall_date, 'dd/mm/yyyy hh24:mi') recall_date FROM OP_PATIENT_QUEUE WHERE patient_id = ? AND facility_id = ? AND to_char(recall_date, 'dd/mm/yyyy') = to_char(sysdate,'dd/mm/yyyy') AND PATIENT_CLASS = 'EM' AND recalled_enc_id IS NULL order by recall_date desc";

			pstmt= con.prepareStatement(sqlQuery);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,facilityId);
			rset= pstmt.executeQuery();
			
			while(rset!=null && rset.next()){

				JSONObject jsonObj	= new JSONObject();
				String encounter_id = rset.getString("encounter_id")==null?"":rset.getString("encounter_id");
				String enc_date_time = rset.getString("enc_date_time")==null?"":rset.getString("enc_date_time");
				String recall_date = rset.getString("recall_date")==null?"":rset.getString("recall_date");

				jsonObj.put("encounter_id",encounter_id);
				jsonObj.put("enc_date_time",enc_date_time);
				jsonObj.put("recall_date",recall_date);
				
				arrJSON.add(jsonObj);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rset!=null)rset.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getFollowUpDetails - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
	}
	/*End ML-MMOH-CRF-0657*/

	/*Added by Thamizh selvi on 15th Mar 2018 against ML-MMOH-CRF-0645 Start*/
	public static JSONArray getOSCCTypeList(Connection con, String locale, String RepDb) throws Exception{
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		JSONArray osccTypeArrJSON	= new JSONArray();
	
		try{

			String osccTypeSql = " SELECT a.inj_category_code inj_category_code, b.inj_subcategory_code inj_subcategory_code, b.short_desc subcategory_short_desc FROM ae_injury_category ##REPDB## a, ae_injury_subcategory_lang_vw ##REPDB## b WHERE a.inj_category_code = b.inj_category_code AND b.language_id = '"+locale+"' AND a.eff_status = 'E' AND b.eff_status = 'E' AND a.oscc_yn = 'Y' ORDER BY b.short_desc ";//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
			
			osccTypeSql = osccTypeSql.replaceAll("##REPDB##",RepDb);//Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
			pstmt   = con.prepareStatement(osccTypeSql);
			rs    = pstmt.executeQuery();

			while(rs!=null && rs.next()){
				
				JSONObject osccTypeJsonObj	= new JSONObject();
				String injCategoryCode		= checkForNull(rs.getString("inj_category_code"));
				String injSubCategoryCode	= checkForNull(rs.getString("inj_subcategory_code"));
				String subCategoryShortDesc	= checkForNull(rs.getString("subcategory_short_desc"));

				osccTypeJsonObj.put("injCategoryCode",injCategoryCode);
				osccTypeJsonObj.put("injSubCategoryCode",injSubCategoryCode);
				osccTypeJsonObj.put("subCategoryShortDesc",subCategoryShortDesc);
				
				osccTypeArrJSON.add(osccTypeJsonObj);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getOSCCTypeList - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return osccTypeArrJSON;
	}
	/*End*/

	/*Added by Ashwini on 30-Mar-2018 for PMG2018-COMN-CRF-0001*/
	public static JSONObject getAEBedOccupiedStatus(Connection con, String bay_no, String clinic_code, String facilityId) throws Exception{
		Statement stmt			= null;
		ResultSet rs 			= null;
		JSONObject jsonObj		= new JSONObject();

		try{
			String sql = "SELECT 1 FROM ae_bed_for_trmt_area WHERE ( current_status = 'O' OR (current_status = 'R' AND (to_date(to_char(sysdate, 'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi') <= to_date(to_char(occupied_until_date_time, 'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi'))) ) AND bed_no = '"+bay_no+"' AND clinic_code = '"+clinic_code+"' AND facility_id = '"+facilityId+"'";
			
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			if(rs!=null && rs.next()){

					String isBedOccupied = "EXIST";
					jsonObj.put("isBedOccupied",isBedOccupied);

			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getAEBedOccupiedStatus - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}
	public static String getBedBayEffStatus(Connection con, String bay_no, String clinic_code, String facility_id) throws Exception{
		PreparedStatement pstmt1	= null;
		ResultSet rset1 			= null;
		String eff_status			= null;
		
		try{

			String sqlQuery1 = " SELECT eff_status FROM ae_spare_bays WHERE bay_no = ? AND clinic_code = ? AND facility_id = ? ";

			pstmt1= con.prepareStatement(sqlQuery1);
			pstmt1.setString(1,bay_no);
			pstmt1.setString(2,clinic_code);
			pstmt1.setString(3,facility_id);
			rset1= pstmt1.executeQuery();
			
			if(rset1!=null && rset1.next()){
				eff_status = rset1.getString("eff_status")==null?"":rset1.getString("eff_status");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rset1!=null)rset1.close();
				if(pstmt1!=null)pstmt1.close();
			}catch(Exception ex){
				System.err.println("Exception in getBedBayEffStatus - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return eff_status;
	}
	/*End PMG2018-COMN-CRF-0001*/

// Added for ML-MMOH-CRF-0656 by Shanmukh start	
public static  String getAETrgRecDateTime(Connection con,  String facilityId, String encounter_id, String RepDb) throws Exception{
		PreparedStatement pstmt		= null;
		ResultSet rs 			= null;
		
		String secTrgRecDateTimeList	= "";
		try{
	              String sqlgetAETrgRecDateTime="SELECT TO_CHAR(recorded_date,'dd/mm/yyyy hh24:mi:ss') recorded_date from ae_pat_emergency_detail ##REPDB## where facility_id=? and encounter_id=? ";//Modified by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				  
				  sqlgetAETrgRecDateTime = sqlgetAETrgRecDateTime.replaceAll("##REPDB##",RepDb);//Added by Thamizh selvi on 29th June 2018 against MMS-DM-CRF-0115.1
				  pstmt = con.prepareStatement(sqlgetAETrgRecDateTime);
				  pstmt.setString	(1,	facilityId);
				  pstmt.setString	(2,	encounter_id);;
				  rs = pstmt.executeQuery();
				  
				while(rs!=null && rs.next())
				{
				
					secTrgRecDateTimeList += rs.getString("recorded_date")+"^";
				}
				  
				  }catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getAETrgRecDateTime - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
	  return secTrgRecDateTimeList;
}
//END

	/*Added by Ashwini on 10-Apr-2018 for ML-MMOH-CRF-0652*/
	public static JSONArray getDiagnosisDtls(Connection con, String locale, String patientId, String encounterId, String facilityId) throws Exception
	{
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		JSONArray diagDtlsArrJSON	= new JSONArray();
	
		try{

			String diagnosisDtlsSql = " SELECT mr_get_desc.mr_term_set(a.term_set_id,'en',1) term_set_desc, a.term_code, a.term_code_short_desc, TO_CHAR (a.recorded_date_time, 'dd/mm/yyyy hh24:mi') recorded_date, decode(a.nature,'A','Actual','P','Potential','W','Wellness') nature, (SELECT mr_get_desc.mr_accuracy (a.accuracy_code, '"+locale+"', '2' ) short_desc FROM mr_accuracy WHERE accuracy_code = a.accuracy_code) accuracy_short_desc, decode(a.status,'A','Active') status FROM pr_diagnosis_enc_dtl a WHERE a.patient_id = '"+patientId+"' and a.status = 'A' and a.encounter_id = '"+encounterId+"' and a.facility_id = '"+facilityId+"' order by recorded_date_time desc ";

			pstmt   = con.prepareStatement(diagnosisDtlsSql);
			rs		= pstmt.executeQuery();

			while(rs!=null && rs.next()){
				
				JSONObject diagDtlsJsonObj	= new JSONObject();
				String term_set_desc		= checkForNull(rs.getString("term_set_desc"));
				String term_code			= checkForNull(rs.getString("term_code"));
				String term_code_short_desc	= checkForNull(rs.getString("term_code_short_desc"));
				String recorded_date_time	= checkForNull(rs.getString("recorded_date"));
				String accuracy_short_desc	= checkForNull(rs.getString("accuracy_short_desc"));
				String status				= checkForNull(rs.getString("status"));
				String nature				= checkForNull(rs.getString("nature"));

				diagDtlsJsonObj.put("term_set_desc",term_set_desc);
				diagDtlsJsonObj.put("term_code",term_code);
				diagDtlsJsonObj.put("term_code_short_desc",term_code_short_desc);
				diagDtlsJsonObj.put("recorded_date_time",recorded_date_time);
				diagDtlsJsonObj.put("accuracy_short_desc",accuracy_short_desc);
				diagDtlsJsonObj.put("status",status);
				diagDtlsJsonObj.put("nature",nature);
				
				diagDtlsArrJSON.add(diagDtlsJsonObj);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getDiagnosisDtls - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return diagDtlsArrJSON;
	}
	/*End ML-MMOH-CRF-0652*/

// added by mujafar for ML-MMOH-CRF-0632 START	
	public static JSONObject getPatientData(Connection con,  String patientId,String facilityId,String locale) throws Exception
	{
	
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		JSONObject json				= new JSONObject();
		
		
		String res_addr_line1 = "";
		String res_addr_line2 = "";
		String res_addr_line3 = "";
		String res_addr_line4 = "";
		String res_town_desc = "";
		String res_area_desc = "";
		String res_region_desc = "";
		String postal_desc = "";
		String res_country_desc = "";
		String res_tel_no = "";
		String res_mob_no = "";
		String res_mail_id = "";
		String date_of_birth = "";
		String res_national_id_no = "";
		String pat_name = "";
		String res_town_code="";
		String res_area_code="";
		String res_region_code="";
		String postal_code="";
		String res_country_code="";
		String ocpn_desc = ""; // ADDED BY MUJAFAR for ML-MMOH-CRF-0632
        //Below added by Suji Keerthi for ML-MMOH-CRF-1527 US008
		String mail_addr_line1 = "";
		String mail_addr_line2 = "";
		String mail_addr_line3 = "";
		String mail_addr_line4 = "";
		String mail_town_desc = "";
		String mail_area_desc = "";
		String mail_region_desc = "";
		String mail_postal_desc = "";
		String mail_country_desc = "";
		String mail_town_code="";
		String mail_area_code="";
		String mail_region_code="";
		String mail_postal_code="";
		String mail_country_code="";
		String res_contact_name = "";
		String mail_contact_name = "";
        String contact3_mode = "";
		String contact3_no = "";
		String contact4_mode = "";
		String contact4_no = "";
		String contact5_mode = "";
		String contact5_no = "";
		//Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008
		
		if(!patientId.equals(""))
		{
			
			try{                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
				
				String sql="select b.ADDR1_LINE1 res_addr_line1 ,b.ADDR1_LINE2 res_addr_line2,b.ADDR1_LINE3 res_addr_line3,b.ADDR1_LINE4 res_addr_line4,b.RES_TOWN1_CODE res_town_code,mp_get_desc.MP_RES_TOWN(b.res_town1_code,'"+locale+"',1) res_town_desc,b.RES_AREA1_CODE res_area_code,mp_get_desc.MP_RES_AREA(b.res_area1_code,'"+locale+"',1) res_area_desc,b.REGION1_CODE res_region_code,mp_get_desc.MP_REGION(b.region1_code,'"+locale+"',1) res_region_desc,b.POSTAL1_CODE postal_code,mp_get_desc.MP_POSTAL_CODE(b.postal1_code,'"+locale+"',2) postal_desc,b.COUNTRY1_CODE res_country_code,mp_get_desc.MP_COUNTRY(b.COUNTRY1_CODE,'"+locale+"',1) res_country_desc,a.CONTACT1_NO res_tel_no,a.CONTACT2_NO res_mob_no,a.EMAIL_ID res_mail_id, to_char(a.date_of_birth, 'dd/mm/yyyy') date_of_birth,a.NATIONAL_ID_NO res_national_id_no,decode('"+locale+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) Patient_Name,c.OCPN_CODE,MP_GET_DESC.mp_occupation(c.OCPN_CODE,'"+locale+"','2')OCPN_DESC,b.ADDR2_LINE1 mail_addr_line1 ,b.ADDR2_LINE2 mail_addr_line2,b.ADDR2_LINE3 mail_addr_line3,b.ADDR2_LINE4 mail_addr_line4,b.RES_TOWN2_CODE mail_town_code,mp_get_desc.MP_RES_TOWN(b.res_town2_code,'"+locale+"',1) mail_town_desc,b.RES_AREA2_CODE mail_area_code,mp_get_desc.MP_RES_AREA(b.res_area2_code,'"+locale+"',1) mail_area_desc,b.REGION2_CODE mail_region_code,mp_get_desc.MP_REGION(b.region2_code,'"+locale+"',1) mail_region_desc,b.POSTAL2_CODE mail_postal_code,mp_get_desc.MP_POSTAL_CODE(b.postal2_code,'"+locale+"',2) mail_postal_desc,b.COUNTRY2_CODE mail_country_code,mp_get_desc.MP_COUNTRY(b.COUNTRY2_CODE,'"+locale+"',1) mail_country_desc,b.CONTACT1_NAME res_contact_name,b.CONTACT2_NAME mail_contact_name,a.CONTACT3_MODE contact3_mode,a.CONTACT3_NO contact3_no,a.CONTACT4_MODE contact4_mode,a.CONTACT4_NO contact4_no,a.CONTACT5_MODE contact5_mode,a.CONTACT5_NO contact5_no from mp_patient a,MP_PAT_ADDRESSES b,MP_PAT_REL_CONTACTS c where a.patient_id=b.patient_id and a.patient_id = c.patient_id and a.patient_id='"+patientId+"' " ;   // modified for ML-MMOH-CRF-0632  
				//Query Modified by Suji Keerthi for ML-MMOH-CRF-1527 US008
				
	
				pstmt   = con.prepareStatement(sql);
				rs		= pstmt.executeQuery();
				if(rs!=null && rs.next())
				{
					res_addr_line1 = checkForNull( rs.getString("res_addr_line1") );
					res_addr_line2 = checkForNull( rs.getString("res_addr_line2") );
					res_addr_line3 = checkForNull( rs.getString("res_addr_line3") );
					res_addr_line4 = checkForNull( rs.getString("res_addr_line4") );
					res_town_code  = checkForNull( rs.getString("res_town_code") );
					res_town_desc = checkForNull( rs.getString("res_town_desc") );
					res_area_code = checkForNull( rs.getString("res_area_code") );
					res_area_desc = checkForNull( rs.getString("res_area_desc") );
					res_region_code = checkForNull( rs.getString("res_region_code") );
					res_region_desc = checkForNull( rs.getString("res_region_desc") );
					postal_code = checkForNull( rs.getString("postal_code") );
					postal_desc = checkForNull( rs.getString("postal_desc") ); 
					res_country_code=checkForNull( rs.getString("res_country_code") );
					res_country_desc = checkForNull( rs.getString("res_country_desc") );
					res_tel_no = checkForNull( rs.getString("res_tel_no") );
					res_mob_no = checkForNull( rs.getString("res_mob_no") );
					res_mail_id = checkForNull( rs.getString("res_mail_id") );
					date_of_birth = checkForNull( rs.getString("date_of_birth") );
					res_national_id_no = checkForNull( rs.getString("res_national_id_no") );
					pat_name = 	checkForNull( rs.getString("Patient_Name") ); 
					ocpn_desc = checkForNull( rs.getString("ocpn_desc") );  // ADDED by mujafar for ML-MMOH-CRF-0632
                    //Below added by Suji Keerthi for ML-MMOH-CRF-1527 US008
					mail_addr_line1 = checkForNull( rs.getString("mail_addr_line1") );
					mail_addr_line2 = checkForNull( rs.getString("mail_addr_line2") );
					mail_addr_line3 = checkForNull( rs.getString("mail_addr_line3") );
					mail_addr_line4 = checkForNull( rs.getString("mail_addr_line4") );
					mail_town_code  = checkForNull( rs.getString("mail_town_code") );
					mail_town_desc = checkForNull( rs.getString("mail_town_desc") );
					mail_area_code = checkForNull( rs.getString("mail_area_code") );
					mail_area_desc = checkForNull( rs.getString("mail_area_desc") );
					mail_region_code = checkForNull( rs.getString("mail_region_code") );
					mail_region_desc = checkForNull( rs.getString("mail_region_desc") );
					mail_postal_code = checkForNull( rs.getString("mail_postal_code") );
					mail_postal_desc = checkForNull( rs.getString("mail_postal_desc") ); 
					mail_country_code=checkForNull( rs.getString("mail_country_code") );
					mail_country_desc = checkForNull( rs.getString("mail_country_desc") );
					res_contact_name = checkForNull( rs.getString("res_contact_name") );
					mail_contact_name = checkForNull( rs.getString("mail_contact_name") );

					contact3_mode   = checkForNull( rs.getString("contact3_mode") );
					contact3_no     = checkForNull( rs.getString("contact3_no") );
					contact4_mode   = checkForNull( rs.getString("contact4_mode") );
					contact4_no     = checkForNull( rs.getString("contact4_no") );
					contact5_mode   = checkForNull( rs.getString("contact5_mode") );
					contact5_no     = checkForNull( rs.getString("contact5_no") );
					//Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008
				}
				
				json.put("res_addr_line1",res_addr_line1);
				json.put("res_addr_line2",res_addr_line2);
				json.put("res_addr_line3",res_addr_line3);
				json.put("res_addr_line4",res_addr_line4);
				json.put("res_town_code",res_town_code);
				json.put("res_town_desc",res_town_desc);
				json.put("res_area_desc",res_area_desc);
				json.put("res_region_desc",res_region_desc);
				json.put("postal_desc",postal_desc);
				json.put("res_country_desc",res_country_desc);
				json.put("res_tel_no",res_tel_no);
				json.put("res_mob_no",res_mob_no);
				json.put("res_mail_id",res_mail_id);
				json.put("date_of_birth",date_of_birth);
				json.put("res_national_id_no",res_national_id_no);
				json.put("pat_name",pat_name);
				json.put("res_town_code",res_town_code);
				json.put("res_area_code",res_area_code);
				json.put("res_region_code",res_region_code);
				json.put("postal_code",postal_code);
				json.put("res_country_code",res_country_code);
				json.put("ocpn_desc",ocpn_desc); // added by mujafar for ML-MMOH-CRF-0632
                //Below added by Suji Keerthi for ML-MMOH-CRF-1527 US008
				json.put("mail_addr_line1",mail_addr_line1);
				json.put("mail_addr_line2",mail_addr_line2);
				json.put("mail_addr_line3",mail_addr_line3);
				json.put("mail_addr_line4",mail_addr_line4);
				json.put("mail_town_desc",mail_town_desc);
				json.put("mail_area_desc",mail_area_desc);
				json.put("mail_region_desc",mail_region_desc);
				json.put("mail_postal_desc",mail_postal_desc);
				json.put("mail_country_desc",mail_country_desc);
				json.put("mail_town_code",mail_town_code);
				json.put("mail_area_code",mail_area_code);
                json.put("mail_region_code",mail_region_code);
				json.put("mail_postal_code",mail_postal_code);
				json.put("mail_country_code",mail_country_code);
				json.put("res_contact_name",res_contact_name);
				json.put("mail_contact_name",mail_contact_name);

				json.put("contact3_mode",contact3_mode);
				json.put("contact3_no",contact3_no);
				json.put("contact4_mode",contact4_mode);
				json.put("contact4_no",contact4_no);
				json.put("contact5_mode",contact5_mode);
				json.put("contact5_no",contact5_no);
				//Ended by Suji Keerthi for ML-MMOH-CRF-1527 US008
			
			}
			catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getPatientData method  - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
			
			
		}
		
	return json;
	
	}
	// added by mujafar for ML-MMOH-CRF-0632 END
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals("null"))) ? "" : inputString );
	}

	/*Added by Thamizh selvi on 10th May 2018 against ML-MMOH-CRF-0658 Start*/
	public static JSONObject getFieldOrder(Connection con,String facility_id,String user_id ) throws java.sql.SQLException 
	{  
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs1 = null;
		ArrayList fieldNames = new ArrayList();
		ArrayList appendedFields = new ArrayList();
		int recCnt = 0 ;
		/*Added by Thamizh selvi on 4th May 2018 against ML-MMOH-CRF-0658 Start*/
		JSONObject fieldsJsonObj	= new JSONObject();
		int DFCnt = 0 ;
		int newRecsCnt = 0 ;
		/*End*/
		String fid="";
		String uid="";
		//Below line added for this CRF ML-MMOH-CRF-0637
		//int recordCount=0; //Commented for checkstyle
		//PreparedStatement pstmt = null; //Commented for checkstyle
		Statement stmt2 = null;
		ResultSet rs2 = null;
		
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select count(*) from AE_CURR_EMERG_PAT_RESULT where Facility_id='"+facility_id+"' and User_id='"+user_id+"'");

			if ((rs != null) && (rs.next()) )
			{
				recCnt = rs.getInt(1);
			}
			/*Added by Thamizh selvi on 4th May 2018 against ML-MMOH-CRF-0658 Start*/
			rs = stmt.executeQuery("select count(*) from AE_CURR_EMERG_PAT_RESULT where Facility_id='DF' and User_id='*ALL'");
			if ((rs != null) && (rs.next()) )
			{
				DFCnt = rs.getInt(1);
			}
			
			if(recCnt == 0){
				newRecsCnt	= 0;
				uid			= "*ALL";
				fid			= "DF";
			}else if(recCnt != DFCnt){
				newRecsCnt	= DFCnt - recCnt;
				uid			= user_id;
				fid			= facility_id;
			}else{
				newRecsCnt	= 0;
				uid			= user_id;
				fid			= facility_id;
			}/*End*/

			/*if (recCnt == 0) {
				uid="*ALL";
				fid="DF";
			}
			else
			{
				uid=user_id;
				fid=facility_id;

			}*/

		//Below line added for this CRF ML-MMOH-CRF-0637
	
		String sqlQuery="select field_name, lower(field_name)||'~'||field_desc From AE_CURR_EMERG_PAT_RESULT where facility_id = ? and user_id = ? order by Field_order asc";
		
		//End this CRF ML-MMOH-CRF-0637
			
			
			pstmt1	=	con.prepareStatement(sqlQuery);

			pstmt1.setString(1,fid);
			pstmt1.setString(2,uid);

			rs1 =	pstmt1.executeQuery();

			while (rs1.next())
			{
				fieldNames.add(rs1.getString(1));
				appendedFields.add(rs1.getString(2));
			}

            if(rs1 != null) rs1.close() ; //Added for checkstyle
			/*Added by Thamizh selvi on 4th May 2018 against ML-MMOH-CRF-0658 Start*/
			if (newRecsCnt != 0){
					
				String newRecsSql = "select field_name, lower(field_name)||'~'||field_desc From AE_CURR_EMERG_PAT_RESULT where facility_id = ? and user_id = ? and field_order between ? and ? order by Field_order asc";

				pstmt1	=	con.prepareStatement(newRecsSql);

				pstmt1.setString(1,"DF");
				pstmt1.setString(2,"*ALL");
				pstmt1.setInt(3,recCnt+1);
				pstmt1.setInt(4,DFCnt);
				rs1 =	pstmt1.executeQuery();
				
				while (rs1.next()){
					fieldNames.add(rs1.getString(1));
					appendedFields.add(rs1.getString(2));
				}
			}
			fieldsJsonObj.put("newRecsCnt",newRecsCnt);
			fieldsJsonObj.put("recCnt",recCnt);
			fieldsJsonObj.put("DFCnt",DFCnt);
			fieldsJsonObj.put("fieldNames",fieldNames);
			fieldsJsonObj.put("appendedFields",appendedFields);
			/*End*/
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(rs1!=null) rs1.close();
			if(pstmt1!=null)	pstmt1.close();
			if(stmt!=null)	stmt.close();
			//if(rs!=null)	rs = null;  //Commented for checkstyle
			if(rs != null) rs.close() ; //Added for checkstyle
			
			if(stmt2!=null)	stmt2.close();
			if(rs2!=null)	rs2 = null;	
		}
		//The fields are added to the list in the order of their display
		return fieldsJsonObj;
	}
	/*End*/
	
	/*Added by Ashwini on 10-May-2018 for ML-MMOH-CRF-1133*/
	public static JSONObject getRegistrationDate(Connection con, String facility_id, String encounter_id) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		JSONObject jsonObj		= new JSONObject();

		try{
			String sql = "SELECT TO_CHAR (visit_adm_date_time,'dd/mm/yyyy hh24:mi') visit_adm_date_time FROM pr_encounter WHERE facility_id = ? AND encounter_id = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,encounter_id);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){

					String visit_adm_date_time = rs.getString("visit_adm_date_time");
					jsonObj.put("visit_adm_date_time",visit_adm_date_time);

			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getRegistrationDate - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}
	/*End ML-MMOH-CRF-1133*/

	/* Added by mujafar for ML-MMOH-CRF-1040 START*/
	public static int getSecTriageRemarksCount(Connection con, String encounter_id, String facilityId) throws Exception{
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		String sql					= "";
		int cnt						= 0;
		try{
			sql="select count(REMARKS) rem_count from AE_PAT_EMERGENCY_DETAIL where encounter_id='"+encounter_id+"' and facility_id='"+facilityId+"' and REMARKS is NOT NULL";
			pstmt	= con.prepareStatement(sql);
			rs		= pstmt.executeQuery();
			if(rs!=null && rs.next()){
				cnt	= rs.getInt("rem_count");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getSecTriageRemarksCount method  - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return cnt;
	}
/* Added by mujafar for ML-MMOH-CRF-1040 END*/



/* Added by mujafar for KDAH-CRF-0526 START*/ 
	public static int getEffectiveStatus(Connection con, String visitTypeCode, String facilityId) throws Exception{
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		String sql					= "";
		int cnt						= 0;

		try{
			
	sql="select count(*) cont from op_visit_type_for_clinic_vw where visit_type_code='"+visitTypeCode+"' and facility_id='"+facilityId+"' and eff_status='E' ";
			

			pstmt	= con.prepareStatement(sql);
			rs		= pstmt.executeQuery();
			if(rs!=null && rs.next()){
				cnt	= rs.getInt("cont");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getEffectiveStatus method  - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return cnt;
	}
	
	
	public static String getAEfollowupType(Connection con,  String facilityId,String patientID,String dflt_time_reg_auto_update,String cl_code) throws Exception{
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		//String sql					= ""; //Commented for checkstyle
		//int cnt						= 0; //Commented for checkstyle
		
		int dflt_time_val = Integer.parseInt(dflt_time_reg_auto_update);
		String followup_type = "";
		//CallableStatement cs1 = null ; //Commented for checkstyle
		try{
						
			String str_val = "select ae_followup_type(?,?,?,?) followup_type from dual" ;
			pstmt=con.prepareStatement(str_val);
			pstmt.setString(1,patientID);
			pstmt.setString(2,facilityId);
			pstmt.setInt(3,dflt_time_val);
			pstmt.setString(4,cl_code);
			
			rs = pstmt.executeQuery();
			
		if(rs!=null && rs.next()){
			followup_type		= (rs.getString("followup_type")==null || rs.getString("followup_type")=="")?"" : rs.getString("followup_type");
		}
		
		if(pstmt != null) pstmt.close();
		if(rs  != null) rs.close();
			
			
			
			}
			catch(Exception e)
			{
			 e.printStackTrace();	
			}	
				
			
			
	
		finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getAEfollowupType method  - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return followup_type;
	}
	
	
	
/* Added by mujafar for KDAH-CRF-0526 END*/

/*Added by Arthi for ML-MMOH-CRF-1975 on 02-Nov-2022*/
public static JSONArray getPriorityValue(Connection con, String locale, String priority_zone) throws Exception{
	Statement stmt			= null;
	ResultSet rs 			= null;
	JSONArray arrJSON		= new JSONArray();
	String sql				= "";

	try{
		sql = "select priority_code,short_desc from ae_pat_priority_lang_vw where language_id='"+locale+"' and PRIORITY_ZONE='"+priority_zone+"' and EFF_STATUS='E'";
		
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);

		while(rs!=null && rs.next()){
			
			JSONObject jsonObj = new JSONObject();
			String priority_code = rs.getString("priority_code")==null?"":rs.getString("priority_code");
			String short_desc = rs.getString("short_desc")==null?"":rs.getString("short_desc");

			jsonObj.put("priority_code",priority_code);
			jsonObj.put("short_desc",short_desc);
			arrJSON.add(jsonObj);
		}
		
	}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		try{
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
		}catch(Exception ex){
			System.err.println("Exception in getPriorityValue - "+ex.getMessage());
			ex.printStackTrace();
		}
	}
	return arrJSON;
}
/*End ML-MMOH-CRF-1975*/

	public static JSONObject getForAdmissionValue(Connection con, String facility_id, String loginUser) throws Exception{
		PreparedStatement pstmt	= null;
		PreparedStatement prpstmt = null;
		PreparedStatement acc_pstmt = null;
		ResultSet rs 			= null;
		ResultSet rs1 			= null;
		ResultSet rs2 			= null;
		JSONObject jsonObj		= new JSONObject();
		String sql = "";
		String pract_sql = "";
		String access_rights_sql = "";
		String enable_admission_tab = "";
		String pract_type = "";
		String sel_admission_yn = "";
		String sel_cancel_yn = "";
		String sel_referral_yn = "";
		try{
			sql = "select ENABLE_ADMISSION_TAB from ae_param where operating_facility_id = ?";
			pract_sql="select  b.pract_type pract_type from sm_appl_user a,am_practitioner b where a.appl_user_id = ? and a.func_role_id = b.practitioner_id";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){
					enable_admission_tab = rs.getString("ENABLE_ADMISSION_TAB");
			}
			prpstmt=con.prepareStatement(pract_sql);
			prpstmt.setString(1,loginUser);
			rs1 = prpstmt.executeQuery();
			if(rs1!= null &&  rs1.next() ){
					pract_type=checkForNull(rs1.getString("pract_type"));
			}
			access_rights_sql="select FOR_ADMISSION_YN , CANCEL_FOR_ADMISSION_YN , MODIFY_REFERRAL_YN from AE_ACCS_RIGHTS_BY_PRAC_TYPE where pract_type =?";
			acc_pstmt=con.prepareStatement(access_rights_sql);
			acc_pstmt.setString	(1,pract_type);
			rs2 = acc_pstmt.executeQuery();
			if(rs2!= null &&  rs2.next() ){
			sel_admission_yn=rs2.getString("FOR_ADMISSION_YN");
			sel_cancel_yn=rs2.getString("CANCEL_FOR_ADMISSION_YN");
			sel_referral_yn=rs2.getString("MODIFY_REFERRAL_YN");
			}
			jsonObj.put("enable_admission_tab",enable_admission_tab);
			jsonObj.put("sel_admission_yn",sel_admission_yn);
			jsonObj.put("sel_cancel_yn",sel_cancel_yn);
			jsonObj.put("sel_referral_yn",sel_referral_yn);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(rs1!=null)rs1.close();//Added for CheckStyle Issue DEC23
				if(rs2!=null)rs2.close();//Added for CheckStyle Issue DEC23
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getRegistrationDate - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}
	public static JSONObject IPEncPatData(Connection con, String patient_id) throws Exception{
		PreparedStatement pstmt	= null;
		PreparedStatement acc_pstmt = null;
		ResultSet rs 			= null;
		String sql = "";
		String sql1 = "";
		JSONObject jsonObj		= new JSONObject();
		int cntYN = 0;
		String adtStatus = "";
		String assign_bed_num = "";
		try{
			//sql = "select count(patient_id) as count from pr_encounter where patient_id = ? and ((assign_bed_num IS NULL OR assign_bed_num IS NOT NULL) and (adt_status = '08' or adt_status != '08') ) and (patient_class = 'IP' OR patient_class = 'DC') ";
			sql = "SELECT  (CASE WHEN (( (f.assign_bed_num is null or f.assign_bed_num is not null ) and f.adt_status <= '04' ) AND (f.patient_class = 'IP' OR f.patient_class = 'DC') ) THEN 1 ELSE 0 END ) cnt FROM ae_current_patient a, pr_encounter f WHERE f.facility_id = a.facility_id AND f.patient_id = a.patient_id and f.patient_id = ? and f.patient_class in ('IP','DC')";
			
		
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,patient_id);
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()){
					cntYN = rs.getInt("cnt");
			}
			if(rs!=null)rs.close();//Added for Checkstyle issue DEC23
			sql1 = "select assign_bed_num,adt_status from pr_encounter where patient_id = ? and patient_class in ('IP','DC')";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1,patient_id);
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next()){
					adtStatus = rs.getString("adt_status");
					assign_bed_num = rs.getString("assign_bed_num");
			}
			jsonObj.put("cntYN",cntYN);
			jsonObj.put("adtStatus",adtStatus);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in IPEncPatData - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}
}//end of class
