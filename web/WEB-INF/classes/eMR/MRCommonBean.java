/*Created by Thamizh selvi 7th Nov 2016 against HSA-CRF-0213*/ 
package eMR;

import java.sql.*;
import java.io.*;
import java.util.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.*;
import webbeans.eCommon.*;
import eFM.FMCurrentEncounterDetailsBean;

public class MRCommonBean implements Serializable{
	
	public static JSONArray getChapterList(Connection con) throws Exception{
		Statement stmt=null;
		ResultSet rs 	= null;
		JSONArray arrJSON		= new JSONArray();

		try{
			String sql = "select term_code from mr_term_code where code_level = 1 and term_set_id = 'ICD10' AND term_code != '*OTH' order by term_code";
			
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			while(rs!=null && rs.next()){
				
				JSONObject jsonObj	= new JSONObject();
				String termCode		= rs.getString("term_code")==null?"":rs.getString("term_code");
				jsonObj.put("term_code",termCode);
				arrJSON.add(jsonObj);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getChapterList - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
	}
	
	
	
// added by mujafar for ML-MMOH-CRF-0704 START	
public static ArrayList getHolodayForMRP(Connection con,String holidaydate,String holidayenddate,String facilityId) throws Exception
{ 
Statement pmst=null;
ResultSet rs=null;
//FMCurrentEncounterDetailsBean  HolidayForMRPBean=null; --commented for checkstyle
int totreccord=0;
StringBuffer HolidayQuery=new StringBuffer();
FMCurrentEncounterDetailsBean  HolidayBean=null; 
ArrayList holidayList=null;

   HolidayQuery.append("SELECT  TO_CHAR (b.holiday_date, 'dd/mm/yyyy') holiday_val,b.holiday_date holiday_date1 FROM (SELECT TO_DATE ('"+holidaydate+"', 'dd/mm/yyyy') + ROWNUM  - 1 holiday_date FROM sm_function WHERE ROWNUM <= TO_DATE ('"+holidayenddate+"', 'dd/mm/yyyy')  - TO_DATE ('"+holidaydate+"', 'dd/mm/yyyy')  + 1) b where  NOT EXISTS ( SELECT 1 FROM mr_report_holiday where facility_id = '"+facilityId+"' AND holiday_date = b.holiday_date)");
 
try{
   holidayList=new ArrayList();
 
   pmst = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
   rs=pmst.executeQuery(HolidayQuery.toString());
   rs.last();
   totreccord = rs.getRow();
   
   rs.beforeFirst();     
   while(rs!=null&&rs.next()){ 
   HolidayBean=new FMCurrentEncounterDetailsBean();
   HolidayBean.setHolidaydate(checkForNull(rs.getString("holiday_val")));
   holidayList.add(HolidayBean);
   }    
	
   if(rs!=null) rs.close(); 
   if(pmst!=null) pmst.close(); 
  

}catch(Exception e){
  e.printStackTrace();
}
return holidayList;

}

public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}

	// added by mujafar for ML-MMOH-CRF-0704 END
	
	/*Added by Ashwini on 05-May-2017 for ML-MMOH-CRF-0698*/
	public static JSONObject getPatientDetails(Connection con, String patient_id, String facility_id, String enc_type, String frm_enc_date, String to_enc_date ,int currentPageNo) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rset 			= null;
		JSONObject json			= new JSONObject();
		JSONArray arrJSON		= new JSONArray();
		StringBuffer sqlQuery	= new StringBuffer();
		int recordsPerPage 			= 20;
		int noOfRecs				= 0;
		//int noOfRecords 			= 0; --commented for checkstyle 
		int noOfPages	 			= 0;	
		int from 		 			= 1;
		int to			 			= recordsPerPage;

		if(currentPageNo!=1){
			from		= (currentPageNo - 1) * recordsPerPage +1;
			to			= (from -1) + recordsPerPage;
		}

		try
		{
			sqlQuery.append("select * from (SELECT  results.*, rownum as rcnt FROM (");

			sqlQuery.append("SELECT COUNT (*) OVER () noOfRecords, a.patient_id, a.patient_name, DECODE (a.sex, 'M', 'Male', 'F', 'Female', 'U', 'Unknown') gender FROM mp_patient a WHERE EXISTS ( SELECT 1 FROM pr_encounter b WHERE a.patient_id = b.patient_id AND a.patient_id like upper('"+patient_id+"%')  AND b.facility_id = '"+facility_id+"' AND NVL (b.patient_class, 'X') = NVL ('"+enc_type+"', b.patient_class) AND (b.adt_status != '09' OR b.visit_status != '99') AND TRUNC (b.visit_adm_date_time) BETWEEN TO_DATE ('"+frm_enc_date+"', 'dd/mm/rrrr' ) AND TO_DATE ('"+to_enc_date+"', 'dd/mm/rrrr' )) order by patient_id asc");
			
			sqlQuery.append(" ) results ) where rcnt between '"+from+"' AND '"+to+"'");

			pstmt= con.prepareStatement(sqlQuery.toString());
			rset= pstmt.executeQuery();

			while(rset!=null && rset.next())
			{
				JSONObject jsonObj	= new JSONObject();
				noOfRecs	= rset.getInt("noOfRecords");
				String pat_id = rset.getString("patient_id")==null?"":rset.getString("patient_id");
				String patient_name = rset.getString("patient_name")==null?"":rset.getString("patient_name");
				String gender = rset.getString("gender")==null?"":rset.getString("gender");

				jsonObj.put("patient_id",pat_id);
				jsonObj.put("patient_name",patient_name);
				jsonObj.put("gender",gender);
				arrJSON.add(jsonObj);
			}

			noOfPages = (int) Math.ceil(noOfRecs * 1.0 / recordsPerPage);
			if(to > noOfRecs)
				{
				to	= noOfRecs;
				}
			json.put("patDtlArray",arrJSON);
			json.put("currentPageNo", currentPageNo);
			json.put("noOfRecords", noOfRecs);
			json.put("noOfPages", noOfPages);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try
			{
				if(rset!=null)rset.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getPatientDetails - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return json;
	}

	//Added by Sangeetha for ML-MMOH-SCF-0714 on 15/may/17
	public static String getRenameToDaggerYN(Connection con) throws Exception{
		Statement stmt	=null;
		ResultSet rs 	= null;
		String renameAsteriskToDagger_yn = null;
		try{
			String sql = "SELECT CASE WHEN upper(customer_id) = upper(key_1) THEN value_1 WHEN upper(customer_id) = upper(key_2) THEN value_2 WHEN upper(customer_id) = upper(key_3) THEN value_3 ELSE 'N' END key_value FROM sm_function_control a, sm_site_param b WHERE a.functionality_id = 'RENAME_ASTERISK_TO_DAGGER'";
			
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			while(rs!=null && rs.next()){
				renameAsteriskToDagger_yn		= rs.getString("key_value");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getRenameToDaggerYN - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return renameAsteriskToDagger_yn;
	}
	
	/*Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719*/
	public static JSONArray getReasonList(Connection con) throws Exception{
		Statement stmt			= null;
		ResultSet rs 			= null;
		JSONArray arrJSON		= new JSONArray();

		try{
			String sql = "select contact_reason_code, contact_reason from am_contact_reason where eff_status = 'E' and cancel_medical_request_yn = 'Y'";
			
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			while(rs!=null && rs.next()){
				
				JSONObject jsonObj	= new JSONObject();
				String reasonCode		= rs.getString("contact_reason_code")==null?"":rs.getString("contact_reason_code");
				String reasonDesc		= rs.getString("contact_reason")==null?"":rs.getString("contact_reason");
				jsonObj.put("reasonCode",reasonCode);
				jsonObj.put("reasonDesc",reasonDesc);
				arrJSON.add(jsonObj);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getReasonList - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
	}
	
	public static JSONObject getCutOffDateIncompReqCount(Connection con,String facilityId) throws Exception{
		PreparedStatement pstmt		= null;
		Statement stmt				= null;
		ResultSet rs 				= null;
		String cutOffDate			= "";
		Integer count				= 0;
		JSONObject jsonObj			= new JSONObject();

		try{
			String sql = "select to_char((sysdate-auto_cancel_medical_req_days),'dd/mm/yyyy') cut_off_date from mr_parameter";
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);
			
			if(rs!=null && rs.next()){
				cutOffDate	= rs.getString("cut_off_date");
			}

			String countSql = " SELECT count(*) incomp_req_count FROM mr_report_request_hdr WHERE facility_id = '"+facilityId+"' AND request_status = '7' AND TRUNC(status_incomplete_date) < to_date('"+cutOffDate+"','dd/mm/yyyy') ";
			pstmt = con.prepareStatement(countSql);
			
			if(rs!=null)rs.close(); //Added for checkstyle
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){
				count	= rs.getInt("incomp_req_count");
			}

			jsonObj.put("cutOffDate",cutOffDate);
			jsonObj.put("count",count);
		
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getCutOffDateIncompReqCount - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}

	public static JSONObject getIncompleteReqDtls(Connection con, String locale, String facilityId, String cutOffDate, int currentPageNo) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		JSONArray arrJSON		= new JSONArray();
		JSONObject json			= new JSONObject();
		StringBuffer sqlSb		= new StringBuffer();

		int recordsPerPage 			= 14;
		int noOfRecs				= 0;
		//int noOfRecords 			= 0; --commented for checkstyle
		int noOfPages	 			= 0;	
		int from 		 			= 1;
		int to			 			= recordsPerPage;
		
		if(currentPageNo!=1){
			from		= (currentPageNo - 1) * recordsPerPage +1;
			to			= (from -1) + recordsPerPage;
		}

		try{
		
			sqlSb.append("select * from (SELECT  results.*, rownum as rcnt FROM (");

			sqlSb.append(" SELECT COUNT (*) OVER () noOfRecords, request_id, to_char(request_date,'dd/mm/yyyy') request_date, DECODE ('"+locale+"', 'en', patient_name, NVL (patient_name_loc_lang, patient_name) ) patient_name, patient_id, gender FROM mr_report_request_hdr_vw WHERE facility_id = '"+facilityId+"' AND TRUNC (status_incomplete_date) < TO_DATE ('"+cutOffDate+"', 'dd/mm/yyyy') AND request_status = '7' ORDER BY 2 ");

			sqlSb.append(" ) results ) where rcnt between '"+from+"' AND '"+to+"'");
			
			pstmt = con.prepareStatement(sqlSb.toString());
			rs	= pstmt.executeQuery();

			while(rs!=null && rs.next()){
				
				JSONObject jsonObj	= new JSONObject();
				noOfRecs				= rs.getInt("noOfRecords");
				Long requestId			= rs.getLong("request_id");
				String requestDate		= rs.getString("request_date")==null?"":rs.getString("request_date");
				String patientName		= rs.getString("patient_name")==null?"":rs.getString("patient_name");
				String patientId		= rs.getString("patient_id")==null?"":rs.getString("patient_id");
				String gender			= rs.getString("gender")==null?"":rs.getString("gender");
				jsonObj.put("requestId",requestId);
				jsonObj.put("requestDate",requestDate);
				jsonObj.put("patientName",patientName);
				jsonObj.put("patientId",patientId);
				jsonObj.put("gender",gender);
				arrJSON.add(jsonObj);
			}

			noOfPages = (int) Math.ceil(noOfRecs * 1.0 / recordsPerPage);
			if(to > noOfRecs){
				to	= noOfRecs;
			}
			json.put("IncompReqArray",arrJSON);
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
				System.err.println("Exception in getIncompleteReqDtls - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return json;
	}
	/*End*/

	/*Added by Ashwini on on 07-Jul-2017 for ML-MMOH-CRF-0702*/
	public static JSONObject getRequestId(Connection con, String facility_id, int currentPageNo) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rset 			= null;
		JSONObject json			= new JSONObject();
		JSONArray arrJSON		= new JSONArray();
		StringBuffer sqlQuery	= new StringBuffer();
		int recordsPerPage 			= 15;
		int noOfRecs				= 0;
		//int noOfRecords 			= 0; --commented for checkstyle
		int noOfPages	 			= 0;	
		int from 		 			= 1;
		int to			 			= recordsPerPage;

		if(currentPageNo!=1){
			from		= (currentPageNo - 1) * recordsPerPage +1;
			to			= (from -1) + recordsPerPage;
		}

		try
		{
			sqlQuery.append("select * from (SELECT  results.*, rownum as rcnt FROM (");

			sqlQuery.append("select COUNT (*) OVER () noOfRecords, year_num, start_srl_no, max_srl_no, next_srl_no, facility_id from MR_REQUEST_ID_FOR_FCY where facility_id = '"+facility_id+"' order by year_num desc");
			
			sqlQuery.append(" ) results ) where rcnt between '"+from+"' AND '"+to+"'");

			pstmt= con.prepareStatement(sqlQuery.toString());
			rset= pstmt.executeQuery();

			while(rset!=null && rset.next())
			{
				JSONObject jsonObj	= new JSONObject();
				noOfRecs	= rset.getInt("noOfRecords");
				String req_year = rset.getString("year_num")==null?"":rset.getString("year_num");
				String start_no = rset.getString("start_srl_no")==null?"":rset.getString("start_srl_no");
				String max_no = rset.getString("max_srl_no")==null?"":rset.getString("max_srl_no");
				String next_no = rset.getString("next_srl_no")==null?"":rset.getString("next_srl_no");

				jsonObj.put("req_year",req_year);
				jsonObj.put("start_no",start_no);
				jsonObj.put("max_no",max_no);
				jsonObj.put("next_no",next_no);
				arrJSON.add(jsonObj);
			}

			noOfPages = (int) Math.ceil(noOfRecs * 1.0 / recordsPerPage);
			if(to > noOfRecs)
				{
				to	= noOfRecs;
				}
			json.put("reqIdArray",arrJSON);
			json.put("currentPageNo", currentPageNo);
			json.put("noOfRecords", noOfRecs);
			json.put("noOfPages", noOfPages);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try
			{
				if(rset!=null)rset.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getRequestId - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return json;
	}

	/*Added By Ashwini on 21-Aug-2017 for ML-MMOH-CRF-0708*/
	public static JSONArray getTransModeListForApplMode(Connection con) throws Exception{
		Statement stmt			= null;
		ResultSet rs 			= null;
		JSONArray arrJSON		= new JSONArray();

		try{
			String sql = "SELECT transport_mode, short_desc FROM am_transport_mode WHERE application_mode = 'Y' AND eff_status = 'E'";
			
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			while(rs!=null && rs.next()){
				
				JSONObject jsonObj	= new JSONObject();
				String transport_mode		= rs.getString("transport_mode")==null?"":rs.getString("transport_mode");
				String short_desc		= rs.getString("short_desc")==null?"":rs.getString("short_desc");
				jsonObj.put("transport_mode",transport_mode);
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
				System.err.println("Exception in getTransModeListForApplMode - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
	}

	public static JSONArray getTransModeListForCollMode(Connection con) throws Exception{
		Statement stmt			= null;
		ResultSet rs 			= null;
		JSONArray arrJSON		= new JSONArray();

		try{
			String sql = "SELECT transport_mode, short_desc FROM am_transport_mode WHERE collection_mode = 'Y' AND eff_status = 'E'";
			
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			while(rs!=null && rs.next()){
				
				JSONObject jsonObj	= new JSONObject();
				String transport_mode		= rs.getString("transport_mode")==null?"":rs.getString("transport_mode");
				String short_desc		= rs.getString("short_desc")==null?"":rs.getString("short_desc");
				jsonObj.put("transport_mode",transport_mode);
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
				System.err.println("Exception in getTransModeListForCollMode - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
	}

	public static JSONArray getTransModeListForNotifiMode(Connection con) throws Exception{
		Statement stmt			= null;
		ResultSet rs 			= null;
		JSONArray arrJSON		= new JSONArray();

		try{
			String sql = "SELECT transport_mode, short_desc FROM am_transport_mode WHERE notification_mode = 'Y' AND eff_status = 'E'";
			
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			while(rs!=null && rs.next()){
				
				JSONObject jsonObj	= new JSONObject();
				String transport_mode		= rs.getString("transport_mode")==null?"":rs.getString("transport_mode");
				String short_desc		= rs.getString("short_desc")==null?"":rs.getString("short_desc");
				jsonObj.put("transport_mode",transport_mode);
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
				System.err.println("Exception in getTransModeListForNotifiMode - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
	}
	/*End ML-MMOH-CRF-0708*/

	/*Added by Ashwini on 04-Oct-2017 for ML-MMOH-CRF-0763 and ML-MMOH-CRF-0764*/
	public static JSONObject getCompltdRepDetails(Connection con, String locale, String function_id, String recv_mrd, String p_fm_Date, String p_to_Date, String req_id, String patient_id, String facility_id, int currentPageNo) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rset 			= null;
		JSONObject json			= new JSONObject();
		JSONArray arrJSON		= new JSONArray();
		StringBuffer sqlQuery	= new StringBuffer();
		int recordsPerPage 			= 15;
		int noOfRecs				= 0;
		//int noOfRecords 			= 0; --commented for checkstyle
		int noOfPages	 			= 0;	
		int from 		 			= 1;
		int to			 			= recordsPerPage;

		if(currentPageNo!=1){
			from		= (currentPageNo - 1) * recordsPerPage +1;
			to			= (from -1) + recordsPerPage;
		}

		try
		{
			sqlQuery.append(" select * from (SELECT  results.*, rownum as rcnt FROM ( ");
			//Modified by Dharma on 17th Dec 2019 against ML-MMOH-CRF-1368	
			//sqlQuery.append(" select COUNT (*) OVER () noOfRecords, request_id, to_char(request_date,'dd/mm/yyyy') request_date, request_date AS request_date_order, patient_id, patient_name, initcap(gender) gender, to_char(collect_date,'dd/mm/yyyy hh24:mi') collect_date, request_status_desc, am_get_desc.AM_PRACTITIONER(forwarded_pract_id,'bm','1') forwarded_pract_name FROM mr_report_request_hdr_vw ");
			sqlQuery.append(" select COUNT (*) OVER () noOfRecords, request_id, to_char(request_date,'dd/mm/yyyy') request_date, request_date AS request_date_order, patient_id, patient_name, initcap(gender) gender, to_char(collect_date,'dd/mm/yyyy hh24:mi') collect_date, request_status_desc, am_get_desc.AM_PRACTITIONER(forwarded_pract_id,'bm','1') forwarded_pract_name, (nvl(amount,0) + nvl(addl_amount,0)) TOT_AMOUNT FROM mr_report_request_hdr_vw ");
			
			if(function_id.equals("NOTICE_OF_COMPLTD_REP_NOTIFIC"))
			{
			sqlQuery.append(" WHERE request_status = '5' AND prepared_date BETWEEN DECODE ('"+recv_mrd+"', 'Y', TO_DATE ('01/01/' || '"+p_fm_Date+"', 'DD/MM/YYYY' ), 'M', TO_DATE ('"+p_fm_Date+"', 'MM/YYYY'), 'D', TO_DATE ('"+p_fm_Date+"', 'DD/MM/YYYY') ) AND DECODE ('"+recv_mrd+"', 'Y', TO_DATE ('31/12/' || '"+p_to_Date+"', 'DD/MM/YYYY' ) + 0.99999, 'M', LAST_DAY (TO_DATE ('"+p_to_Date+"', 'MM/YYYY' ) ) + .9999, 'D', TO_DATE ('"+p_to_Date+"', 'DD/MM/YYYY') + .9999 ) ");
			} 
			else if(function_id.equals("CONFIRM_POST_RECEIPT_MED_REP"))
			{
			sqlQuery.append(" WHERE request_status = '6' AND delivered_date BETWEEN DECODE ('"+recv_mrd+"', 'Y', TO_DATE ('01/01/' || '"+p_fm_Date+"', 'DD/MM/YYYY' ), 'M', TO_DATE ('"+p_fm_Date+"', 'MM/YYYY'), 'D', TO_DATE ('"+p_fm_Date+"', 'DD/MM/YYYY') ) AND DECODE ('"+recv_mrd+"', 'Y', TO_DATE ('31/12/' || '"+p_to_Date+"', 'DD/MM/YYYY' ) + 0.99999, 'M', LAST_DAY (TO_DATE ('"+p_to_Date+"', 'MM/YYYY' ) ) + .9999, 'D', TO_DATE ('"+p_to_Date+"', 'DD/MM/YYYY') + .9999 ) ");
			}
			else if(function_id.equals("MEDICAL_REPORT_APP"))
			{
			sqlQuery.append(" WHERE request_status = '9' AND forwarded_hod_cord_date BETWEEN DECODE ('"+recv_mrd+"', 'Y', TO_DATE ('01/01/' || '"+p_fm_Date+"', 'DD/MM/YYYY' ), 'M', TO_DATE ('"+p_fm_Date+"', 'MM/YYYY'), 'D', TO_DATE ('"+p_fm_Date+"', 'DD/MM/YYYY') ) AND DECODE ('"+recv_mrd+"', 'Y', TO_DATE ('31/12/' || '"+p_to_Date+"', 'DD/MM/YYYY' ) + 0.99999, 'M', LAST_DAY (TO_DATE ('"+p_to_Date+"', 'MM/YYYY' ) ) + .9999, 'D', TO_DATE ('"+p_to_Date+"', 'DD/MM/YYYY') + .9999 ) ");
			}
			else if(function_id.equals("PREPARE_MEDICAL_REPORT"))
			{
			sqlQuery.append(" WHERE request_status = '4' AND prepared_date BETWEEN DECODE ('"+recv_mrd+"', 'Y', TO_DATE ('01/01/' || '"+p_fm_Date+"', 'DD/MM/YYYY' ), 'M', TO_DATE ('"+p_fm_Date+"', 'MM/YYYY'), 'D', TO_DATE ('"+p_fm_Date+"', 'DD/MM/YYYY') ) AND DECODE ('"+recv_mrd+"', 'Y', TO_DATE ('31/12/' || '"+p_to_Date+"', 'DD/MM/YYYY' ) + 0.99999, 'M', LAST_DAY (TO_DATE ('"+p_to_Date+"', 'MM/YYYY' ) ) + .9999, 'D', TO_DATE ('"+p_to_Date+"', 'DD/MM/YYYY') + .9999 ) ");
			}
			//Added by Ashwini on 03-Jul-2018 for ML-MMOH-CRF-0722
			else if(("REFUND_LETTER").equals(function_id))
			{
			sqlQuery.append(" WHERE (request_status = '8' OR request_status = '99') AND charges_appl_yn = 'Y' AND request_date BETWEEN DECODE ('"+recv_mrd+"', 'Y', TO_DATE ('01/01/' || '"+p_fm_Date+"', 'DD/MM/YYYY' ), 'M', TO_DATE ('"+p_fm_Date+"', 'MM/YYYY'), 'D', TO_DATE ('"+p_fm_Date+"', 'DD/MM/YYYY') ) AND DECODE ('"+recv_mrd+"', 'Y', TO_DATE ('31/12/' || '"+p_to_Date+"', 'DD/MM/YYYY' ) + 0.99999, 'M', LAST_DAY (TO_DATE ('"+p_to_Date+"', 'MM/YYYY' ) ) + .9999, 'D', TO_DATE ('"+p_to_Date+"', 'DD/MM/YYYY') + .9999 ) ");
			}
			
			//Added by Ashwini on 03-Jul-2018 for ML-MMOH-CRF-0722
			if(("REFUND_LETTER").equals(function_id))
			{
			sqlQuery.append(" AND facility_id = '"+facility_id+"' AND (overdue_status != 'Y' OR overdue_status IS NULL) AND request_id LIKE UPPER (NVL ('"+req_id+"', '%')) AND patient_id LIKE UPPER (NVL ('"+patient_id+"', '%')) ORDER BY request_date_order ");
			}
			else
			{
			sqlQuery.append(" AND facility_id = '"+facility_id+"' AND overdue_status ='N' AND request_id LIKE UPPER (NVL ('"+req_id+"', '%')) AND patient_id LIKE UPPER (NVL ('"+patient_id+"', '%')) ORDER BY request_date_order ");
			}
			
			sqlQuery.append(" ) results ) where rcnt between '"+from+"' AND '"+to+"'");

			pstmt= con.prepareStatement(sqlQuery.toString());
			rset= pstmt.executeQuery();

			while(rset!=null && rset.next())
			{
				JSONObject jsonObj	= new JSONObject();
				noOfRecs	= rset.getInt("noOfRecords");
				String request_id = rset.getString("request_id")==null?"":rset.getString("request_id");
				String request_date = rset.getString("request_date")==null?"":rset.getString("request_date");
				String pat_id = rset.getString("patient_id")==null?"":rset.getString("patient_id");
				String patient_name = rset.getString("patient_name")==null?"":rset.getString("patient_name");
				String gender = rset.getString("gender")==null?"":rset.getString("gender");
				String practitioner_name = rset.getString("forwarded_pract_name")==null?"":rset.getString("forwarded_pract_name");
				String collect_date = rset.getString("collect_date")==null?"":rset.getString("collect_date");
				String request_status = rset.getString("request_status_desc")==null?"":rset.getString("request_status_desc");
				int tot_amount	= rset.getInt("TOT_AMOUNT");		
				jsonObj.put("request_id",request_id);
				jsonObj.put("request_date",request_date);
				jsonObj.put("patient_id",pat_id);
				jsonObj.put("patient_name",patient_name);
				jsonObj.put("gender",gender);
				jsonObj.put("practitioner_name",practitioner_name);
				jsonObj.put("collect_date",collect_date);
				jsonObj.put("request_status",request_status);
				jsonObj.put("tot_amount",tot_amount);//Added By Dharma on 17th Dec 2019 against ML-MMOH-CRF-1368
				arrJSON.add(jsonObj);
			}

			noOfPages = (int) Math.ceil(noOfRecs * 1.0 / recordsPerPage);
			if(to > noOfRecs)
				{
				to	= noOfRecs;
				}
			json.put("compltdRepArray",arrJSON);
			json.put("currentPageNo", currentPageNo);
			json.put("noOfRecords", noOfRecs);
			json.put("noOfPages", noOfPages);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try
			{
				if(rset!=null)rset.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getCompltdRepDetails - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return json;
	}
	
	
		// Added by mujafar for ML-MMOH-CRF-0713
	public static JSONArray getRejectReasonList(Connection con) throws Exception{
		Statement stmt			= null;
		ResultSet rs 			= null;
		JSONArray arrJSON		= new JSONArray();

		try{
			String sql = "select contact_reason_code, contact_reason from am_contact_reason where eff_status = 'E' and reject_request_mrp_yn = 'Y'";
			
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			while(rs!=null && rs.next()){
				
				JSONObject jsonObj	= new JSONObject();
				String reasonCode		= rs.getString("contact_reason_code")==null?"":rs.getString("contact_reason_code");
				String reasonDesc		= rs.getString("contact_reason")==null?"":rs.getString("contact_reason");
				jsonObj.put("reasonCode",reasonCode);
				jsonObj.put("reasonDesc",reasonDesc);
				arrJSON.add(jsonObj);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getRejectReasonList - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
	}
	// below function added by mujafar for ML-MMOH-CRF-0714
	public static JSONArray getRejectReportReasonList(Connection con,String reason) throws Exception{
		Statement stmt			= null;
		ResultSet rs 			= null;
		JSONArray arrJSON		= new JSONArray();
		String whereClause		= "";

		try{
			/*Added By Dharma on 10th Mar 2020 against ML-MMOH-CRF-1473 Start*/
			if(reason.equals("reject")){
				whereClause	= " and reject_report_mrp_yn = 'Y'";
			}else if(reason.equals("rejectToMRDbyPract")){
				whereClause	= " and rejected_to_mrd_by_pract_yn = 'Y'";
			}else if(reason.equals("returnToHODbyPract")){
				whereClause	= " and return_to_hod_by_pract_yn = 'Y'";
			}
			/*Added By Dharma on 10th Mar 2020 against ML-MMOH-CRF-1473 End*/
			
			String sql = "select contact_reason_code, contact_reason from am_contact_reason where eff_status = 'E' "+whereClause+"";
			
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			while(rs!=null && rs.next()){
				
				JSONObject jsonObj	= new JSONObject();
				String reasonCode		= rs.getString("contact_reason_code")==null?"":rs.getString("contact_reason_code");
				String reasonDesc		= rs.getString("contact_reason")==null?"":rs.getString("contact_reason");
				jsonObj.put("reasonCode",reasonCode);
				jsonObj.put("reasonDesc",reasonDesc);
				arrJSON.add(jsonObj);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getRejectReportReasonList - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
	}
	// added by mujafar for ML-MMOH-CRF-0718
	public static String getSelfPractitioner(Connection con,String loginID,String facilityID,String locale) throws Exception
	{
		String pract_Name="";
		String func_role_id="";
		String result_val="";
		Statement stmt			= null;
		ResultSet rs 			= null;
		
	try{
		
		
		stmt = con.createStatement();
		String sql = "select FUNC_ROLE_ID,am_get_desc.am_practitioner(func_role_id, '"+locale+"', '1') pract_name from sm_appl_user where  APPL_USER_ID='"+loginID+"' and func_role='P' ";
			rs	= stmt.executeQuery(sql);
		
			if(rs!=null && rs.next())
			{
				
				pract_Name = rs.getString("pract_name");
				func_role_id = rs.getString("func_role_id");
				result_val = func_role_id+"~~"+pract_Name;
			}
		
		
		
		
	}
	catch(Exception ex){
	ex.printStackTrace();
	}
	finally{
		try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getSelfPractitioner - "+ex.getMessage());
				ex.printStackTrace();
			}
		
	}
	
	return result_val;
	
}


// added by mujafar for ML-MMOH-CRF-0762
	public static String getIndicator(Connection con,String requestor_type_code) throws Exception
	{
		
		String indicator_val="";
		
		Statement stmt			= null;
		ResultSet rs 			= null;
		
	try{
		
		
		stmt = con.createStatement();
		String sql = "select CLASSIFICATION_IND from MR_REQUESTOR_TYPE where REQUESTOR_TYPE_CODE='"+requestor_type_code+"'  ";
			rs	= stmt.executeQuery(sql);
		
			if(rs!=null && rs.next())
			{
				
				indicator_val = rs.getString("CLASSIFICATION_IND");
				
				
			}
		
		
		
		
	}
	catch(Exception ex){
	ex.printStackTrace();
	}
	finally{
		try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getIndicator - "+ex.getMessage());
				ex.printStackTrace();
			}
		
	}
	
	return indicator_val;
	
}




public static JSONArray getChecklistValues(Connection con, String requestor_type_code,String requestor_code) throws Exception{
		Statement stmt			= null;
		ResultSet rs 			= null;
		
		
		JSONArray arrJSON		= new JSONArray();
		
		requestor_type_code=requestor_type_code.trim();
		requestor_code     = requestor_code.trim();

		try{
			String sql = "";
			if(requestor_code.equals(""))
			 sql="SELECT * FROM (SELECT   d.long_desc, c.chk_list_code, c.added_date,RANK () OVER (PARTITION BY c.chk_list_code ORDER BY c.added_date ASC)rnk FROM mr_requestor a, mr_requestor_type b,mr_chklist_for_requestor c,chk_list_medical_report d WHERE a.INDICATOR = b.requestor_type_code AND a.requestor_code = c.requestor_id AND c.chk_list_code = d.chk_list_code AND b.requestor_type_code = '"+requestor_type_code+"'  ORDER BY c.added_date, c.chk_list_code)  WHERE rnk = 1 AND ROWNUM <= 25";//Modified by Kamatchi S for ML-MMOH-CRF-1464
			else
			 sql="SELECT * FROM (SELECT   d.long_desc, c.chk_list_code, c.added_date,RANK () OVER (PARTITION BY c.chk_list_code ORDER BY c.added_date ASC)rnk FROM mr_requestor a, mr_requestor_type b,mr_chklist_for_requestor c,chk_list_medical_report d WHERE a.INDICATOR = b.requestor_type_code AND a.requestor_code = c.requestor_id AND c.chk_list_code = d.chk_list_code AND b.requestor_type_code = '"+requestor_type_code+"' and a.requestor_code = '"+requestor_code+"'  ORDER BY c.added_date, c.chk_list_code)  WHERE rnk = 1 AND ROWNUM <= 25";//Modified by Kamatchi S for ML-MMOH-CRF-1464
			
			System.out.println("sql::"+sql);
			
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			while(rs!=null && rs.next()){
				
				
				String long_desc		= rs.getString("long_desc")==null?"":rs.getString("long_desc");
				String chk_list_code		= rs.getString("chk_list_code")==null?"":rs.getString("chk_list_code");
				
				JSONObject jsonObj	= new JSONObject();
				jsonObj.put("long_desc",long_desc);
				jsonObj.put("chk_list_code",chk_list_code);
				arrJSON.add(jsonObj);
				
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getChecklistValues - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
	}
	
	
public static JSONArray getAuditChecklist(Connection con, String request_id,String facilityID) throws Exception{
		Statement stmt			= null;
		ResultSet rs 			= null;
		
		
		JSONArray arrJSON		= new JSONArray();
		
		request_id=request_id.trim();
		

		try{
			String sql = "";
			
			 
			sql= "select DISTINCT to_char(MODIFIED_DATE,'dd/mm/yyyy hh24:mI')modified_date,modified_by_id,request_id from mr_check_list_audit where  request_id='"+request_id+"' and facility_id='"+facilityID+"' order by 1" ;
			
			
			
		
			
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			while(rs!=null && rs.next()){
				
				
				String modified_date		= rs.getString("modified_date")==null?"":rs.getString("modified_date");
				String modified_by_id		= rs.getString("modified_by_id")==null?"":rs.getString("modified_by_id");
				
				JSONObject jsonObj	= new JSONObject();
				jsonObj.put("modified_date",modified_date);
				jsonObj.put("modified_by_id",modified_by_id);
				arrJSON.add(jsonObj);
				
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getAuditChecklist - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
	}
	
	public static JSONArray getAuditChecklistValues(Connection con, String request_id,String modified_date,String modified_by_id,String facilityID) throws Exception{
		Statement stmt			= null;
		ResultSet rs 			= null;
		
		
		JSONArray arrJSON		= new JSONArray();
		
		request_id=request_id.trim();
		modified_date = modified_date.trim();
		modified_by_id = modified_by_id.trim();

		try{
			String sql = "";
			
			 
			sql= "SELECT (select long_desc from chk_list_medical_report where chk_list_code =check_list1_code)check_list1_desc,(select long_desc from chk_list_medical_report where chk_list_code =check_list2_code)check_list2_desc,(select long_desc from chk_list_medical_report where chk_list_code =check_list3_code)check_list3_desc,(select long_desc from chk_list_medical_report where chk_list_code =check_list4_code)check_list4_desc,(select long_desc from chk_list_medical_report where chk_list_code =check_list5_code)check_list5_desc,(select long_desc from chk_list_medical_report where chk_list_code =check_list6_code)check_list6_desc,(select long_desc from chk_list_medical_report where chk_list_code =check_list7_code)check_list7_desc,(select long_desc from chk_list_medical_report where chk_list_code =check_list8_code)check_list8_desc,(select long_desc from chk_list_medical_report where chk_list_code =check_list9_code)check_list9_desc,(select long_desc from chk_list_medical_report where chk_list_code =check_list10_code)check_list10_desc, (select long_desc from chk_list_medical_report where chk_list_code =check_list11_code)check_list11_desc,(select long_desc from chk_list_medical_report where chk_list_code =check_list12_code)check_list12_desc,(select long_desc from chk_list_medical_report where chk_list_code =check_list13_code)check_list13_desc,(select long_desc from chk_list_medical_report where chk_list_code =check_list14_code)check_list14_desc,(select long_desc from chk_list_medical_report where chk_list_code =check_list15_code)check_list15_desc,(select long_desc from chk_list_medical_report where chk_list_code =check_list16_code)check_list16_desc,(select long_desc from chk_list_medical_report where chk_list_code =check_list17_code)check_list17_desc,(select long_desc from chk_list_medical_report where chk_list_code =check_list18_code)check_list18_desc,(select long_desc from chk_list_medical_report where chk_list_code =check_list19_code)check_list19_desc,(select long_desc from chk_list_medical_report where chk_list_code =check_list20_code)check_list20_desc,(select long_desc from chk_list_medical_report where chk_list_code =check_list21_code)check_list21_desc,(select long_desc from chk_list_medical_report where chk_list_code =check_list22_code)check_list22_desc,(select long_desc from chk_list_medical_report where chk_list_code =check_list23_code)check_list23_desc,(select long_desc from chk_list_medical_report where chk_list_code =check_list24_code)check_list24_desc,(select long_desc from chk_list_medical_report where chk_list_code =check_list25_code)check_list25_desc,check_list1_code, check_list2_code, check_list3_code,check_list4_code, check_list5_code, check_list6_code, check_list7_code,check_list8_code, check_list9_code, check_list10_code,check_list11_code,check_list12_code,check_list13_code,check_list14_code,check_list15_code,check_list16_code,check_list17_code,check_list18_code,check_list19_code,check_list20_code,check_list21_code,check_list22_code,check_list23_code,check_list24_code,check_list25_code,CHECK_LIST1_STATUS,CHECK_LIST2_STATUS,CHECK_LIST3_STATUS,CHECK_LIST4_STATUS,CHECK_LIST5_STATUS,CHECK_LIST6_STATUS,CHECK_LIST7_STATUS,CHECK_LIST8_STATUS,CHECK_LIST9_STATUS,CHECK_LIST10_STATUS,CHECK_LIST11_STATUS,CHECK_LIST12_STATUS,CHECK_LIST13_STATUS,CHECK_LIST14_STATUS,CHECK_LIST15_STATUS,CHECK_LIST16_STATUS,CHECK_LIST17_STATUS,CHECK_LIST18_STATUS,CHECK_LIST19_STATUS,CHECK_LIST20_STATUS,CHECK_LIST21_STATUS,CHECK_LIST22_STATUS,CHECK_LIST23_STATUS,CHECK_LIST24_STATUS,CHECK_LIST25_STATUS  FROM mr_check_list_audit WHERE facility_id = '"+facilityID+"' AND request_id = '"+request_id+"'  AND TO_CHAR (modified_date, 'DD/MM/YYYY HH24:MI') LIKE '"+modified_date+"' AND modified_by_id = '"+modified_by_id+"' AND MODIFIED_DATE IN (SELECT MAX(MODIFIED_DATE) FROM  mr_check_list_audit  WHERE facility_id = '"+facilityID+"'  AND request_id = '"+request_id+"'  AND TO_CHAR (modified_date, 'DD/MM/YYYY HH24:MI') LIKE '"+modified_date+"' ) " ;//Modified by Kamatchi S for ML-MMOH-CRF-1464
			
			
			
		
			
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			while(rs!=null && rs.next()){
				
				
				String check_list1_code		= rs.getString("check_list1_code")==null?"":rs.getString("check_list1_code");
				String check_list2_code		= rs.getString("check_list2_code")==null?"":rs.getString("check_list2_code");
				String check_list3_code		= rs.getString("check_list3_code")==null?"":rs.getString("check_list3_code");
				String check_list4_code		= rs.getString("check_list4_code")==null?"":rs.getString("check_list4_code");
				String check_list5_code		= rs.getString("check_list5_code")==null?"":rs.getString("check_list5_code");
				String check_list6_code		= rs.getString("check_list6_code")==null?"":rs.getString("check_list6_code");
				String check_list7_code		= rs.getString("check_list7_code")==null?"":rs.getString("check_list7_code");
				String check_list8_code		= rs.getString("check_list8_code")==null?"":rs.getString("check_list8_code");
				String check_list9_code		= rs.getString("check_list9_code")==null?"":rs.getString("check_list9_code");
				String check_list10_code	= rs.getString("check_list10_code")==null?"":rs.getString("check_list10_code");
				//Added by Kamatchi S for ML-MMOH-CRF-1464 START
				String check_list11_code	= rs.getString("check_list11_code")==null?"":rs.getString("check_list11_code");
				String check_list12_code	= rs.getString("check_list12_code")==null?"":rs.getString("check_list12_code");
				String check_list13_code	= rs.getString("check_list13_code")==null?"":rs.getString("check_list13_code");
				String check_list14_code	= rs.getString("check_list14_code")==null?"":rs.getString("check_list14_code");
				String check_list15_code	= rs.getString("check_list15_code")==null?"":rs.getString("check_list15_code");
				String check_list16_code	= rs.getString("check_list16_code")==null?"":rs.getString("check_list16_code");
				String check_list17_code	= rs.getString("check_list17_code")==null?"":rs.getString("check_list17_code");
				String check_list18_code	= rs.getString("check_list18_code")==null?"":rs.getString("check_list18_code");
				String check_list19_code	= rs.getString("check_list19_code")==null?"":rs.getString("check_list19_code");
				String check_list20_code	= rs.getString("check_list20_code")==null?"":rs.getString("check_list20_code");
				String check_list21_code	= rs.getString("check_list21_code")==null?"":rs.getString("check_list21_code");
				String check_list22_code	= rs.getString("check_list22_code")==null?"":rs.getString("check_list22_code");
				String check_list23_code	= rs.getString("check_list23_code")==null?"":rs.getString("check_list23_code");
				String check_list24_code	= rs.getString("check_list24_code")==null?"":rs.getString("check_list24_code");
				String check_list25_code	= rs.getString("check_list25_code")==null?"":rs.getString("check_list25_code");
				//Added by Kamatchi S for ML-MMOH-CRF-1464 END
				
				String check_list1_desc		= rs.getString("check_list1_desc")==null?"":rs.getString("check_list1_desc");
				String check_list2_desc		= rs.getString("check_list2_desc")==null?"":rs.getString("check_list2_desc");
				String check_list3_desc		= rs.getString("check_list3_desc")==null?"":rs.getString("check_list3_desc");
				String check_list4_desc		= rs.getString("check_list4_desc")==null?"":rs.getString("check_list4_desc");
				String check_list5_desc		= rs.getString("check_list5_desc")==null?"":rs.getString("check_list5_desc");
				String check_list6_desc		= rs.getString("check_list6_desc")==null?"":rs.getString("check_list6_desc");
				String check_list7_desc		= rs.getString("check_list7_desc")==null?"":rs.getString("check_list7_desc");
				String check_list8_desc		= rs.getString("check_list8_desc")==null?"":rs.getString("check_list8_desc");
				String check_list9_desc		= rs.getString("check_list9_desc")==null?"":rs.getString("check_list9_desc");
				String check_list10_desc	= rs.getString("check_list10_desc")==null?"":rs.getString("check_list10_desc");
				//Added by Kamatchi S for ML-MMOH-CRF-1464 START
				String check_list11_desc	= rs.getString("check_list11_desc")==null?"":rs.getString("check_list11_desc");
				String check_list12_desc	= rs.getString("check_list12_desc")==null?"":rs.getString("check_list12_desc");
				String check_list13_desc	= rs.getString("check_list13_desc")==null?"":rs.getString("check_list13_desc");
				String check_list14_desc	= rs.getString("check_list14_desc")==null?"":rs.getString("check_list14_desc");
				String check_list15_desc	= rs.getString("check_list15_desc")==null?"":rs.getString("check_list15_desc");
				String check_list16_desc	= rs.getString("check_list16_desc")==null?"":rs.getString("check_list16_desc");
				String check_list17_desc	= rs.getString("check_list17_desc")==null?"":rs.getString("check_list17_desc");
				String check_list18_desc	= rs.getString("check_list18_desc")==null?"":rs.getString("check_list18_desc");
				String check_list19_desc	= rs.getString("check_list19_desc")==null?"":rs.getString("check_list19_desc");
				String check_list20_desc	= rs.getString("check_list20_desc")==null?"":rs.getString("check_list20_desc");
				String check_list21_desc	= rs.getString("check_list21_desc")==null?"":rs.getString("check_list21_desc");
				String check_list22_desc	= rs.getString("check_list22_desc")==null?"":rs.getString("check_list22_desc");
				String check_list23_desc	= rs.getString("check_list23_desc")==null?"":rs.getString("check_list23_desc");
				String check_list24_desc	= rs.getString("check_list24_desc")==null?"":rs.getString("check_list24_desc");
				String check_list25_desc	= rs.getString("check_list25_desc")==null?"":rs.getString("check_list25_desc");
				//Added by Kamatchi S for ML-MMOH-CRF-1464 END
				
				
				
				
				
				String check_list1_status		= rs.getString("check_list1_status")==null?"":rs.getString("check_list1_status");
				String check_list2_status		= rs.getString("check_list2_status")==null?"":rs.getString("check_list2_status");
				String check_list3_status	= rs.getString("check_list3_status")==null?"":rs.getString("check_list3_status");
				String check_list4_status	= rs.getString("check_list4_status")==null?"":rs.getString("check_list4_status");
				String check_list5_status	= rs.getString("check_list5_status")==null?"":rs.getString("check_list5_status");
				String check_list6_status	= rs.getString("check_list6_status")==null?"":rs.getString("check_list6_status");
				String check_list7_status	= rs.getString("check_list7_status")==null?"":rs.getString("check_list7_status");
				String check_list8_status		= rs.getString("check_list8_status")==null?"":rs.getString("check_list8_status");
				String check_list9_status	= rs.getString("check_list9_status")==null?"":rs.getString("check_list9_status");
				String check_list10_status		= rs.getString("check_list10_status")==null?"":rs.getString("check_list10_status");
				//Added by Kamatchi S for ML-MMOH-CRF-1464 START
				String check_list11_status		= rs.getString("check_list11_status")==null?"":rs.getString("check_list11_status");
				String check_list12_status		= rs.getString("check_list12_status")==null?"":rs.getString("check_list12_status");
				String check_list13_status		= rs.getString("check_list13_status")==null?"":rs.getString("check_list13_status");
				String check_list14_status		= rs.getString("check_list14_status")==null?"":rs.getString("check_list14_status");
				String check_list15_status		= rs.getString("check_list15_status")==null?"":rs.getString("check_list15_status");
				String check_list16_status		= rs.getString("check_list16_status")==null?"":rs.getString("check_list16_status");
				String check_list17_status		= rs.getString("check_list17_status")==null?"":rs.getString("check_list17_status");
				String check_list18_status		= rs.getString("check_list18_status")==null?"":rs.getString("check_list18_status");
				String check_list19_status		= rs.getString("check_list19_status")==null?"":rs.getString("check_list19_status");
				String check_list20_status		= rs.getString("check_list20_status")==null?"":rs.getString("check_list20_status");
				String check_list21_status		= rs.getString("check_list21_status")==null?"":rs.getString("check_list21_status");
				String check_list22_status		= rs.getString("check_list22_status")==null?"":rs.getString("check_list22_status");
				String check_list23_status		= rs.getString("check_list23_status")==null?"":rs.getString("check_list23_status");
				String check_list24_status		= rs.getString("check_list24_status")==null?"":rs.getString("check_list24_status");
				String check_list25_status		= rs.getString("check_list25_status")==null?"":rs.getString("check_list25_status");
				//Added by Kamatchi S for ML-MMOH-CRF-1464 END
				
				
				JSONObject jsonObj	= new JSONObject();
				jsonObj.put("check_list_code_1",check_list1_code);
				jsonObj.put("check_list_code_2",check_list2_code);
				jsonObj.put("check_list_code_3",check_list3_code);
				jsonObj.put("check_list_code_4",check_list4_code);
				jsonObj.put("check_list_code_5",check_list5_code);
				jsonObj.put("check_list_code_6",check_list6_code);
				jsonObj.put("check_list_code_7",check_list7_code);
				jsonObj.put("check_list_code_8",check_list8_code);
				jsonObj.put("check_list_code_9",check_list9_code);
				jsonObj.put("check_list_code_10",check_list10_code);
				//Added by Kamatchi S for ML-MMOH-CRF-1464 START
				jsonObj.put("check_list_code_11",check_list11_code);
				jsonObj.put("check_list_code_12",check_list12_code);
				jsonObj.put("check_list_code_13",check_list13_code);
				jsonObj.put("check_list_code_14",check_list14_code);
				jsonObj.put("check_list_code_15",check_list15_code);
				jsonObj.put("check_list_code_16",check_list16_code);
				jsonObj.put("check_list_code_17",check_list17_code);
				jsonObj.put("check_list_code_18",check_list18_code);
				jsonObj.put("check_list_code_19",check_list19_code);
				jsonObj.put("check_list_code_20",check_list20_code);
				jsonObj.put("check_list_code_21",check_list21_code);
				jsonObj.put("check_list_code_22",check_list22_code);
				jsonObj.put("check_list_code_23",check_list23_code);
				jsonObj.put("check_list_code_24",check_list24_code);
				jsonObj.put("check_list_code_25",check_list25_code);
				//Added by Kamatchi S for ML-MMOH-CRF-1464 END
				jsonObj.put("check_list_desc_1",check_list1_desc);
				jsonObj.put("check_list_desc_2",check_list2_desc);
				jsonObj.put("check_list_desc_3",check_list3_desc);
				jsonObj.put("check_list_desc_4",check_list4_desc);
				jsonObj.put("check_list_desc_5",check_list5_desc);
				jsonObj.put("check_list_desc_6",check_list6_desc);
				jsonObj.put("check_list_desc_7",check_list7_desc);
				jsonObj.put("check_list_desc_8",check_list8_desc);
				jsonObj.put("check_list_desc_9",check_list9_desc);
				jsonObj.put("check_list_desc_10",check_list10_desc);
				//Added by Kamatchi S for ML-MMOH-CRF-1464 START
				jsonObj.put("check_list_desc_11",check_list11_desc);
				jsonObj.put("check_list_desc_12",check_list12_desc);
				jsonObj.put("check_list_desc_13",check_list13_desc);
				jsonObj.put("check_list_desc_14",check_list14_desc);
				jsonObj.put("check_list_desc_15",check_list15_desc);
				jsonObj.put("check_list_desc_16",check_list16_desc);
				jsonObj.put("check_list_desc_17",check_list17_desc);
				jsonObj.put("check_list_desc_18",check_list18_desc);
				jsonObj.put("check_list_desc_19",check_list19_desc);
				jsonObj.put("check_list_desc_20",check_list20_desc);
				jsonObj.put("check_list_desc_21",check_list21_desc);
				jsonObj.put("check_list_desc_22",check_list22_desc);
				jsonObj.put("check_list_desc_23",check_list23_desc);
				jsonObj.put("check_list_desc_24",check_list24_desc);
				jsonObj.put("check_list_desc_25",check_list25_desc);
				//Added by Kamatchi S for ML-MMOH-CRF-1464 END
				
				
				
				jsonObj.put("check_list_status_1",check_list1_status);
				jsonObj.put("check_list_status_2",check_list2_status);
				jsonObj.put("check_list_status_3",check_list3_status);
				jsonObj.put("check_list_status_4",check_list4_status);
				jsonObj.put("check_list_status_5",check_list5_status);
				jsonObj.put("check_list_status_6",check_list6_status);
				jsonObj.put("check_list_status_7",check_list7_status);
				jsonObj.put("check_list_status_8",check_list8_status);
				jsonObj.put("check_list_status_9",check_list9_status);
				jsonObj.put("check_list_status_10",check_list10_status);
				//Added by Kamatchi S for ML-MMOH-CRF-1464 START
				jsonObj.put("check_list_status_11",check_list11_status);
				jsonObj.put("check_list_status_12",check_list12_status);
				jsonObj.put("check_list_status_13",check_list13_status);
				jsonObj.put("check_list_status_14",check_list14_status);
				jsonObj.put("check_list_status_15",check_list15_status);
				jsonObj.put("check_list_status_16",check_list16_status);
				jsonObj.put("check_list_status_17",check_list17_status);
				jsonObj.put("check_list_status_18",check_list18_status);
				jsonObj.put("check_list_status_19",check_list19_status);
				jsonObj.put("check_list_status_20",check_list20_status);
				jsonObj.put("check_list_status_21",check_list21_status);
				jsonObj.put("check_list_status_22",check_list22_status);
				jsonObj.put("check_list_status_23",check_list23_status);
				jsonObj.put("check_list_status_24",check_list24_status);
				jsonObj.put("check_list_status_25",check_list25_status);
				//Added by Kamatchi S for ML-MMOH-CRF-1464 END
				arrJSON.add(jsonObj);
				
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getAuditChecklistValues - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
	}
	
	
	
// added by mujafar for ML-MMOH-CRF-0762 end






	/*Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707*/
	public static JSONObject getRequestorType(Connection con, String requestor_type_code) throws Exception{
		Statement stmt			= null;
		ResultSet rs 			= null;
		JSONObject jsonObj	= new JSONObject();

		try{
			String sql = "select requestor_type_code,long_desc,short_desc,eff_status,CLASSIFICATION_IND from MR_REQUESTOR_TYPE where requestor_type_code='"+requestor_type_code+"'"; // added by mujafar for ML-MMOH-CRF-0762 
			
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			if(rs!=null && rs.next()){
				
				String requestor_type_cd		= rs.getString("requestor_type_code")==null?"":rs.getString("requestor_type_code");
				String long_desc		= rs.getString("long_desc")==null?"":rs.getString("long_desc");
				String short_desc		= rs.getString("short_desc")==null?"":rs.getString("short_desc");
				String eff_status		= rs.getString("eff_status")==null?"":rs.getString("eff_status");
				String class_indicator = rs.getString("CLASSIFICATION_IND")==null?"":rs.getString("CLASSIFICATION_IND");  // added by mujafar for ML-MMOH-CRF-0762 
				jsonObj.put("requestor_type_code",requestor_type_cd);
				jsonObj.put("long_desc",long_desc);
				jsonObj.put("short_desc",short_desc);
				jsonObj.put("eff_status",eff_status);
				jsonObj.put("class_indicator_val",class_indicator); // added by mujafar for ML-MMOH-CRF-0762 
				
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getRequestorType - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}
	
	
	// added by mujafar for ML-MMOH-CRF-0762 START
	
	public static JSONObject getCheckListDetails(Connection con, String chk_list_code1) throws Exception{
		Statement stmt			= null;
		ResultSet rs 			= null;
		JSONObject jsonObj	= new JSONObject();

		try{
			String sql = "select chk_list_code,long_desc,short_desc,eff_status from CHK_LIST_MEDICAL_REPORT where chk_list_code='"+chk_list_code1+"'"; 
			
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			if(rs!=null && rs.next()){
				
				String chk_list_code		= rs.getString("chk_list_code")==null?"":rs.getString("chk_list_code");
				String long_desc		= rs.getString("long_desc")==null?"":rs.getString("long_desc");
				String short_desc		= rs.getString("short_desc")==null?"":rs.getString("short_desc");
				String eff_status		= rs.getString("eff_status")==null?"":rs.getString("eff_status");
				
				jsonObj.put("chk_list_code",chk_list_code);
				jsonObj.put("long_desc",long_desc);
				jsonObj.put("short_desc",short_desc);
				jsonObj.put("eff_status",eff_status);
				
				
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getCheckListDetails - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}
	
	
	
	
	// added by mujafar for ML-MMOH-CRF-0762 END

	/*Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707*/
	public static JSONObject getRequestorTypeExist(Connection con, String requestor_type_code, String facilityId) throws Exception{
		Statement stmt			= null;
		ResultSet rs 			= null;
		JSONObject jsonObj	= new JSONObject();

		try{
			String sql = "select 1 from MR_REQUESTOR where indicator='"+requestor_type_code+"' and facility_id='"+facilityId+"'";
			
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			if(rs!=null && rs.next()){
				
				String requestor_type_exist_yn="EXIT";
				jsonObj.put("requestor_type_exist_yn",requestor_type_exist_yn);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getRequestorTypeExist - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}

	/*Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707*/
	public static JSONArray getRequestorTypeForRequestor(Connection con) throws Exception{
		Statement stmt			= null;
		ResultSet rs 			= null;
		JSONArray arrJSON		= new JSONArray();

		try{
			String sql = "SELECT requestor_type_code, long_desc FROM MR_REQUESTOR_TYPE WHERE eff_status = 'E' order by long_desc asc";
			
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			while(rs!=null && rs.next()){
				
				JSONObject jsonObj	= new JSONObject();
				String requestor_type_code		= rs.getString("requestor_type_code")==null?"":rs.getString("requestor_type_code");
				String long_desc		= rs.getString("long_desc")==null?"":rs.getString("long_desc");
				jsonObj.put("requestor_type_code",requestor_type_code);
				jsonObj.put("long_desc",long_desc);
				arrJSON.add(jsonObj);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getRequestorTypeForRequestor - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
	}
	
	/*Added by Ashwini on 01-Nov-2017 for ML-MMOH-CRF-0707*/
	public static String MRUserAccRightsForReqType(Connection con,String facilityId, String userId) throws Exception{
		
		PreparedStatement pstmt		= null;
		ResultSet rs				= null;
		String requestor_type_yn	= null;

		try{
		
			String accessRightsSql = "select requestor_type_yn from mr_user_access_rights where facility_id='"+facilityId+"' and appl_user_id='"+userId+"' ";

			pstmt = con.prepareStatement(accessRightsSql);
			rs	 = pstmt.executeQuery();

			if(rs!=null && rs.next()){
				requestor_type_yn = rs.getString("requestor_type_yn");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in MRUserAccRightsForReqType - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return requestor_type_yn;
	}
	
	// below method added by mujafar for ML-MMOH-CRF-0716
	public static JSONArray getMedicalTeamList(Connection con,String facilityId, String Splcode,String effStatus,String locale) throws Exception{
		Statement stmt			= null;
		ResultSet rs 			= null;
		JSONArray arrJSON		= new JSONArray();
		String sql1				= "";
		try{
			if(!Splcode.equals("")){
				sql1	= " and a.SPECIALITY_CODE = '"+Splcode+"'"; 	
				
			}
			if(effStatus.equals("E")){
				sql1	= sql1 + " and a.EFF_STATUS ='E'"; 	
			}
			
			//String sql = "select distinct(a.team_id)team_id,a.short_desc short_desc from am_medical_team a,am_pract_for_team b where a.team_id = b.team_id and a.APPL_FOR_MR_YN='Y' and a.FACILITY_ID='"+facilityId+"' and a.EFF_STATUS ='E' ";
			String sql = "select distinct(a.team_id)team_id,a.short_desc short_desc,(select MR_MEDICAL_TEAM_PRACT_DTLS(a.team_id,'"+facilityId+"','"+locale+"') from dual) pract_list from am_medical_team a,am_pract_for_team b where a.team_id = b.team_id and a.APPL_FOR_MR_YN='Y' and a.FACILITY_ID='"+facilityId+"'  ";
			sql = sql + sql1;
			
			
			
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			while(rs!=null && rs.next()){
				
				JSONObject jsonObj	= new JSONObject();
				String team_id		= rs.getString("team_id")==null?"":rs.getString("team_id");
				String short_desc		= rs.getString("short_desc")==null?"":rs.getString("short_desc");
				String pract_list		= rs.getString("pract_list")==null?"":rs.getString("pract_list");
				jsonObj.put("team_id",team_id);
				jsonObj.put("short_desc",short_desc);
				jsonObj.put("pract_list",pract_list);
				arrJSON.add(jsonObj);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getMedicalTeam - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
	}
	
	public static JSONArray getMedicalTeamList_view(Connection con,String facilityId) throws Exception{
		Statement stmt			= null;
		ResultSet rs 			= null;
		JSONArray arrJSON		= new JSONArray();

		try{
			String sql = "select distinct(a.team_id)team_id,a.short_desc short_desc from am_medical_team a,am_pract_for_team b where a.team_id = b.team_id and a.APPL_FOR_MR_YN='Y' and a.FACILITY_ID='"+facilityId+"'  ";
		
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			while(rs!=null && rs.next()){
				
				JSONObject jsonObj	= new JSONObject();
				String team_id		= rs.getString("team_id")==null?"":rs.getString("team_id");
				String short_desc		= rs.getString("short_desc")==null?"":rs.getString("short_desc");
				jsonObj.put("team_id",team_id);
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
				System.err.println("Exception in getMedicalTeam - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
	}
/*Below line added for this CRF ML-MMOH-CRF-0868*/
public static String [] getExternalCauseDiagCode(Connection con, String patientId, String termsetId, String termSetCode){
  Statement stmt=null;
  ResultSet rs=null;
  String support_term_code="", support_termcode_desc="";
  
  StringBuffer supporting_code=new StringBuffer();
  StringBuffer supporting_desc=new StringBuffer();
  
  String[] externalCauseArray = new String[0];
  
  String SQLQuery="SELECT a.supp_term_code supporting_code, b.short_desc shortdesc  FROM pr_support_diagnosis a, mr_term_code b WHERE b.term_code = a.supp_term_code AND a.patient_id = '"+patientId+"' and a.TERM_SET_ID=b.TERM_SET_ID and a.TERM_SET_ID='"+termsetId+"' and a.term_code='"+termSetCode+"' and CROSS_REF_TYPE='E' order by shortdesc asc";
   
 try{
    stmt=con.createStatement(); 
	rs=stmt.executeQuery(SQLQuery);
	while(rs!=null && rs.next()){
	  support_term_code=rs.getString("supporting_code")==null?"":rs.getString("supporting_code");	
	  if(!support_term_code.equals("")) supporting_code.append(support_term_code).append(", ");     	   
	  support_termcode_desc=rs.getString("shortdesc")==null?"":rs.getString("shortdesc");
	  if(!support_termcode_desc.equals("")) supporting_desc.append(support_termcode_desc).append(", ");	 
	}
	if(supporting_code.toString().length() >0) support_term_code=supporting_code.toString().substring(0, supporting_code.toString().length()-2);
	if(supporting_desc.toString().length() >0) support_termcode_desc=supporting_desc.toString().substring(0, supporting_desc.toString().length()-2);
		
	if(support_term_code.length()>0){
		externalCauseArray = new String[2];
		externalCauseArray[0]=support_term_code;
		externalCauseArray[1]=support_termcode_desc;
	}	
 
 }catch(Exception e){
    e.printStackTrace();
 }finally{
		try{
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
		}catch(Exception ex){
			System.err.println("Exception in getExternalCauseDiagCode - "+ex.getMessage());
			ex.printStackTrace();
		}
}			
 return externalCauseArray;
}		
//End this CRF ML-MMOH-CRF-0868	


// added by mujafar for ML-MMOH-CRF-0762 start

public static int getChecklistCount(Connection con,String requestorID) throws Exception{
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		String sql					= "";
		int cnt				= 0;
		try{
			sql				= "select count(*)chk_list_count from mr_chklist_for_requestor where REQUESTOR_ID='"+requestorID+"'";
			
			pstmt			= con.prepareStatement(sql);
			rs				= pstmt.executeQuery();
			if(rs!=null && rs.next()){
				cnt			= rs.getInt("chk_list_count");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getChecklistCount method  - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return cnt;
	}


	public static JSONObject getCheckListStatus(Connection con, String patient_id,String request_id, String facilityId) throws Exception{
		Statement stmt			= null; // added by mujafar for ML-MMOH-CRF-0762
		ResultSet rs 			= null;
		JSONObject jsonObj	= new JSONObject();

		try{
			String sql = "select CHECK_LIST1_STATUS,CHECK_LIST2_STATUS,CHECK_LIST3_STATUS,CHECK_LIST4_STATUS,CHECK_LIST5_STATUS,CHECK_LIST6_STATUS,CHECK_LIST7_STATUS,CHECK_LIST8_STATUS,CHECK_LIST9_STATUS,CHECK_LIST10_STATUS,CHECK_LIST11_STATUS,CHECK_LIST12_STATUS,CHECK_LIST13_STATUS,CHECK_LIST14_STATUS,CHECK_LIST15_STATUS,CHECK_LIST16_STATUS,CHECK_LIST17_STATUS,CHECK_LIST18_STATUS,CHECK_LIST19_STATUS,CHECK_LIST20_STATUS,CHECK_LIST21_STATUS,CHECK_LIST22_STATUS,CHECK_LIST23_STATUS,CHECK_LIST24_STATUS,CHECK_LIST25_STATUS from MR_CHECK_LIST_HDR where patient_id='"+patient_id+"'  and request_id='"+request_id+"' and facility_id='"+facilityId+"' ";//Modified by Kamatchi S for ML-MMOH-CRF-1464
			
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			if(rs!=null && rs.next()){
				
				
				
				
				
				jsonObj.put("check_list1_status",checkForNull(rs.getString("CHECK_LIST1_STATUS")));
				jsonObj.put("check_list2_status",checkForNull(rs.getString("CHECK_LIST2_STATUS")));
				jsonObj.put("check_list3_status",checkForNull(rs.getString("CHECK_LIST3_STATUS")));
				jsonObj.put("check_list4_status",checkForNull(rs.getString("CHECK_LIST4_STATUS")));
				jsonObj.put("check_list5_status",checkForNull(rs.getString("CHECK_LIST5_STATUS")));
				jsonObj.put("check_list6_status",checkForNull(rs.getString("CHECK_LIST6_STATUS")));
				jsonObj.put("check_list7_status",checkForNull(rs.getString("CHECK_LIST7_STATUS")));
				jsonObj.put("check_list8_status",checkForNull(rs.getString("CHECK_LIST8_STATUS")));
				jsonObj.put("check_list9_status",checkForNull(rs.getString("CHECK_LIST9_STATUS")));
				jsonObj.put("check_list10_status",checkForNull(rs.getString("CHECK_LIST10_STATUS")));
				//Added by Kamatchi S for ML-MMOH-CRF-1464 START
				jsonObj.put("check_list11_status",checkForNull(rs.getString("CHECK_LIST11_STATUS")));
				jsonObj.put("check_list12_status",checkForNull(rs.getString("CHECK_LIST12_STATUS")));
				jsonObj.put("check_list13_status",checkForNull(rs.getString("CHECK_LIST13_STATUS")));
				jsonObj.put("check_list14_status",checkForNull(rs.getString("CHECK_LIST14_STATUS")));
				jsonObj.put("check_list15_status",checkForNull(rs.getString("CHECK_LIST15_STATUS")));
				jsonObj.put("check_list16_status",checkForNull(rs.getString("CHECK_LIST16_STATUS")));
				jsonObj.put("check_list17_status",checkForNull(rs.getString("CHECK_LIST17_STATUS")));
				jsonObj.put("check_list18_status",checkForNull(rs.getString("CHECK_LIST18_STATUS")));
				jsonObj.put("check_list19_status",checkForNull(rs.getString("CHECK_LIST19_STATUS")));
				jsonObj.put("check_list20_status",checkForNull(rs.getString("CHECK_LIST20_STATUS")));
				jsonObj.put("check_list21_status",checkForNull(rs.getString("CHECK_LIST21_STATUS")));
				jsonObj.put("check_list22_status",checkForNull(rs.getString("CHECK_LIST22_STATUS")));
				jsonObj.put("check_list23_status",checkForNull(rs.getString("CHECK_LIST23_STATUS")));
				jsonObj.put("check_list24_status",checkForNull(rs.getString("CHECK_LIST24_STATUS")));
				jsonObj.put("check_list25_status",checkForNull(rs.getString("CHECK_LIST25_STATUS")));
				//Modified by Kamatchi S for ML-MMOH-CRF-1464 END
				
				
				
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getCheckListStatus - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}
	

// added by mujafar for ML-MMOH-CRF-0762 end

// added by mujafar for ML-MMOH-CRF-0878 START





public static String getConfirmRecode(Connection con,String facilityId, String userId) throws Exception{
		
		PreparedStatement pstmt		= null;
		ResultSet rs				= null;
		String confirm_appl_yn	= null;

		try{
		
			String accessRightsSql = "SELECT CONFIRM_APPL,stage_no from MR_RECODE_PRIVI_SETUP where stage_no in ((select STAGE_NO FROM MR_RECODE_PRIVI_SETUP_DTL WHERE APPL_USER_ID='"+userId+"' AND FACILITY_ID='"+facilityId+"'))" ;

			pstmt = con.prepareStatement(accessRightsSql);
			rs	 = pstmt.executeQuery();

			if(rs!=null && rs.next()){
				confirm_appl_yn = rs.getString("CONFIRM_APPL");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in MRUserAccRightsForReqType - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return confirm_appl_yn;
	}


// added by mujafar for ML-MMOH-CRF-0878 END

// added by mujafar for ML-MMOH-CF-1281 START


public static JSONObject getTermcode(Connection con) throws Exception{
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		JSONObject json				= new JSONObject();
		String sql					= "";
		JSONArray jsonArray			= new JSONArray();

		try{
			sql						= " select term_code from mr_term_code where term_set_id='ICD10' and EFF_STATUS='E' and MULTI_DESC_YN='Y' order by 1";

			pstmt					= con.prepareStatement(sql);
			rs						= pstmt.executeQuery();
			
			while(rs!=null && rs.next()){
				String term_code		= rs.getString("term_code")==null?"":rs.getString("term_code");
				
				JSONObject jsonObj			= new JSONObject();		
				jsonObj.put("term_code",term_code);
				jsonArray.add(jsonObj);
			}
			json.put("results",jsonArray);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getTermcode method  - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return json;
	}




public static JSONObject getTermCodeDescription(Connection con,String termSetID,String termcode) throws Exception{ // modified by mujafar ML-MMOH-CRF-1281 US3
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		JSONObject json				= new JSONObject();
		String sql					= "";
		String multi_desc_yn        = "N";
		JSONArray jsonArray			= new JSONArray();
		int termCodeCount = 0;

		try{
			sql						= "select * from MR_TERM_CODE_OTH_DESC a ,mr_term_code b where a.term_set_id=b.term_set_id and a.term_code=b.term_code and b.term_set_id=? and b.term_code=? ";

			// select * from MR_TERM_CODE_OTH_DESC a ,mr_term_code b where a.term_set_id=b.term_set_id and a.term_code=b.term_code and b.term_set_id=? and b.term_code=?
			pstmt					= con.prepareStatement(sql);
			pstmt.setString(1,termSetID);
			pstmt.setString(2,termcode);
			rs						= pstmt.executeQuery();
			JSONObject jsonObj			= new JSONObject();	
			
			if(rs!=null && rs.next()){
				String description1		= rs.getString("description1")==null?"":rs.getString("description1");
				String description2 	= rs.getString("description2")==null?"":rs.getString("description2");
				String description3		= rs.getString("description3")==null?"":rs.getString("description3");
				String description4		= rs.getString("description4")==null?"":rs.getString("description4");
				String description5		= rs.getString("description5")==null?"":rs.getString("description5");
				String description6		= rs.getString("description6")==null?"":rs.getString("description6");
				String description7		= rs.getString("description7")==null?"":rs.getString("description7");
				String description8		= rs.getString("description8")==null?"":rs.getString("description8");
				String description9		= rs.getString("description9")==null?"":rs.getString("description9");
				String description10		= rs.getString("description10")==null?"":rs.getString("description10");
				multi_desc_yn		= rs.getString("multi_desc_yn")==null?"":rs.getString("multi_desc_yn");
				
				
					
				jsonObj.put("description1",description1);
				jsonObj.put("description2",description2);
				jsonObj.put("description3",description3);
				jsonObj.put("description4",description4);
				jsonObj.put("description5",description5);
				jsonObj.put("description6",description6);
				jsonObj.put("description7",description7);
				jsonObj.put("description8",description8);
				jsonObj.put("description9",description9);
				jsonObj.put("description10",description10);
				termCodeCount = 1;
			}
			jsonObj.put("termCodeCount",termCodeCount);
			jsonObj.put("multi_desc_yn",multi_desc_yn);
			jsonArray.add(jsonObj);
			json.put("results",jsonArray);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getTermCodeDescription method  - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return json;
	}
	// added by mujafar for ML-MMOH-CF-1281 END

	/*Added by Ashwini on 22-Jan-2019 for ML-MMOH-CRF-1272*/
	public static JSONObject getAccessionNum(Connection conn, String EncounterId, String patient_id) throws Exception{
		Statement stmt			= null;
		ResultSet rs 			= null;
		JSONObject jsonObj		= new JSONObject();
		String accession_num	= "";

		try{
			String sql = "SELECT * FROM (SELECT accession_num FROM ca_note_group a, ca_note_type b, ca_encntr_note c WHERE a.note_group = b.note_group_id AND b.note_type = c.note_type AND a.appl_task_id = 'DISCHARGE_SUMMARY' AND c.event_status IN ('4', '5') AND c.encounter_id = '"+EncounterId+"' AND c.patient_id = '"+patient_id+"' ORDER BY c.modified_date DESC) WHERE ROWNUM = 1";
			
			stmt = conn.createStatement();
			rs	= stmt.executeQuery(sql);

			if(rs!=null && rs.next()){
				
				accession_num = rs.getString("accession_num")==null?"":rs.getString("accession_num");				
				
			}

			jsonObj.put("accession_num",accession_num);

			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getAccessionNum - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}


// added by mujafar for ML-MMOH-CF-1281 END
	/*Added by Thamizh selvi for ML-MMOH-CRF-1233 on 29th Jan 2019 Start*/
	public static JSONObject getModifiedRepAuditDtls(Connection con, String locale, String facilityId, String modFromDate, String modToDate, String patient_id, int currentPageNo, int recordsPerPage) throws Exception{
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

			sqlSb.append(" SELECT COUNT (*) OVER () noofrecords, a.patient_id, a.request_id, DECODE ('"+locale+"', 'en', b.patient_name, NVL (b.patient_name_loc_lang, b.patient_name) ) patient_name, b.gender, am_get_desc.am_practitioner (a.prepare_pract_id, '"+locale+"', '1' ) prepare_practitioner_name, TO_CHAR (a.prepared_date, 'dd/mm/yyyy hh24:mi' ) prepared_date, TO_CHAR (a.delivered_date, 'dd/mm/yyyy hh24:mi' ) delivered_date, TO_CHAR (a.collect_date, 'dd/mm/yyyy hh24:mi' ) collect_date, TO_CHAR (a.revised_collect_date, 'dd/mm/yyyy hh24:mi' ) revised_collect_date, am_get_desc.am_transport_mode (a.collection_mode, '"+locale+"', '2' ) collection_mode_desc, sm_get_desc.sm_appl_user (a.added_by_id, '"+locale+"', '1' ) modified_by_name, TO_CHAR (a.added_date, 'dd/mm/yyyy hh24:mi' ) modification_date, a.modification_remarks FROM mr_report_modified_audit a, mr_report_request_hdr_vw b WHERE a.request_id = b.request_id AND a.patient_id LIKE '"+patient_id+"%' AND b.request_type = 'MR' AND a.facility_id = '"+facilityId+"' AND TRUNC (a.added_date) BETWEEN TO_DATE ('"+modFromDate+"', 'dd/mm/yyyy' ) AND TO_DATE ('"+modToDate+"', 'dd/mm/yyyy' ) ORDER BY a.added_date DESC, a.request_id ASC ");

			sqlSb.append(" ) results ) where rcnt between '"+from+"' AND '"+to+"'");
				
			pstmt = con.prepareStatement(sqlSb.toString());
			rs	= pstmt.executeQuery();

			while(rs!=null && rs.next()){
					
				JSONObject jsonObj	= new JSONObject();
				noOfRecs				= rs.getInt("noOfRecords");
				String patientId		= rs.getString("patient_id")==null?"":rs.getString("patient_id");
				String requestId		= rs.getString("request_id")==null?"":rs.getString("request_id");
				String patientName		= rs.getString("patient_name")==null?"":rs.getString("patient_name");
				String gender			= rs.getString("gender")==null?"":rs.getString("gender");
				String preparePractName	= rs.getString("prepare_practitioner_name")==null?"":rs.getString("prepare_practitioner_name");
				String preparedDate		= rs.getString("prepared_date")==null?"":rs.getString("prepared_date");
				String deliveredDate	= rs.getString("delivered_date")==null?"":rs.getString("delivered_date");
				String collectDate		= rs.getString("collect_date")==null?"":rs.getString("collect_date");
				String reviseCollectDt	= rs.getString("revised_collect_date")==null?"":rs.getString("revised_collect_date");
				String collectionMode	= rs.getString("collection_mode_desc")==null?"":rs.getString("collection_mode_desc");
				String modifiedBy		= rs.getString("modified_by_name")==null?"":rs.getString("modified_by_name");
				String modifiedDate		= rs.getString("modification_date")==null?"":rs.getString("modification_date");
				String modRemarks		= rs.getString("modification_remarks")==null?"":rs.getString("modification_remarks");

				jsonObj.put("patientId",patientId);
				jsonObj.put("requestId",requestId);
				jsonObj.put("patientName",patientName);
				jsonObj.put("gender",gender);
				jsonObj.put("preparePractName",preparePractName);
				jsonObj.put("preparedDate",preparedDate);
				jsonObj.put("deliveredDate",deliveredDate);
				jsonObj.put("collectDate",collectDate);
				jsonObj.put("reviseCollectDt",reviseCollectDt);
				jsonObj.put("collectionMode",collectionMode);
				jsonObj.put("modifiedBy",modifiedBy);
				jsonObj.put("modifiedDate",modifiedDate);
				jsonObj.put("modRemarks",modRemarks);
				arrJSON.add(jsonObj);

			}
			
			noOfPages = (int) Math.ceil(noOfRecs * 1.0 / recordsPerPage);
			if(to > noOfRecs){
				to	= noOfRecs;
			}
			json.put("modifiedRepAuditDtlsArr",arrJSON);
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
				System.err.println("Exception in getModifiedRepAuditDtls - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return json;
	}

	public static String getlatestRejectionDate(Connection con, String facilityId, String requestId) throws Exception{
		
		PreparedStatement pstmt		= null;
		ResultSet rs				= null;
		String modificationYN		= null;

		try{
		
			String modificationYNSql = "SELECT 'Y' modified_yn FROM mr_report_request_hdr a, mr_report_modified_audit b WHERE a.request_id = b.request_id AND a.facility_id = b.facility_id AND a.request_id = '"+requestId+"' AND a.facility_id = '"+facilityId+"' AND b.added_date = (SELECT MAX (added_date) FROM mr_report_modified_audit WHERE facility_id = '"+facilityId+"' AND request_id = '"+requestId+"') AND b.added_date > a.received_date" ;

			pstmt = con.prepareStatement(modificationYNSql);
			rs	 = pstmt.executeQuery();

			if(rs!=null && rs.next()){
				modificationYN = rs.getString("modified_yn") == null? "N" : rs.getString("modified_yn");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getlatestRejectionDate - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return modificationYN;
	}/*End*/
	
	/*Added by Ashwini on 25-Feb-2019 for MO-CRF-20149*/
	public static JSONArray getSpeciality(Connection con, String locale) throws Exception{
		Statement stmt		= null;
		ResultSet rs 		= null;
		JSONArray arrJSON	= new JSONArray();

		try{
			String sql = "select long_desc, speciality_code from am_speciality_lang_vw where eff_status = 'E' and MR_APPL_YN = 'Y' and language_id='"+locale+"' order by long_desc";
			
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			while(rs!=null && rs.next()){
				
				JSONObject jsonObj	= new JSONObject();
				String spec_long_desc		= rs.getString("long_desc")==null?"":rs.getString("long_desc");
				jsonObj.put("long_desc",spec_long_desc);
				String speciality_code		= rs.getString("speciality_code")==null?"":rs.getString("speciality_code");
				jsonObj.put("speciality_code",speciality_code);
				arrJSON.add(jsonObj);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getSpeciality - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
	}
	/*End MO-CRF-20149*/

	/*Added by Ashwini on 03-May-2019 for ML-MMOH-CRF-1292*/
	public static JSONObject getPreviousMonthYear(Connection conn, String req_type, String date_my) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		JSONObject jsonObj		= new JSONObject();
		String previous_my	= "";

		try{
			String sql = "select DECODE('"+req_type+"','M', to_char(add_months(trunc(TO_DATE('"+date_my+"','MM/YYYY')),-1),'MM/YYYY'), 'Y', TO_NUMBER(TO_CHAR (TO_DATE ('"+date_my+"','YYYY'),'YYYY'))-1)previous_my FROM DUAL";
			
			pstmt = conn.prepareStatement(sql);
			rs	= pstmt.executeQuery();

			if(rs!=null && rs.next()){
				
				previous_my = rs.getString("previous_my")==null?"":rs.getString("previous_my");				
				
			}

			jsonObj.put("previous_my",previous_my);

		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getPreviousMonthYear - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}
	
	// Added by mujafar for ML-MMOH-CRF-1280 START
	public static JSONObject getFieldOrder(Connection con,String facility_id,String user_id ) throws java.sql.SQLException 
	{  
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs1 = null;
		ArrayList fieldNames = new ArrayList();
		ArrayList appendedFields = new ArrayList();
		int recCnt = 0 ;
		JSONObject fieldsJsonObj	= new JSONObject();
		String fid="";
		String uid="";
		
		//int recordCount=0; //Commented for checkstyle
		//PreparedStatement pstmt = null; //Commented for checkstyle
		//Statement stmt2 = null; //Commented for checkstyle
		//ResultSet rs2 = null; //Commented for checkstyle
		
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select count(*) from MR_REPORT_RESULT_ORDER where Facility_id='"+facility_id+"' and User_id='"+user_id+"'");

			if ((rs != null) && (rs.next()) )
			{
				recCnt = rs.getInt(1);
			}
			
			
			if(recCnt == 0){
				
				uid			= "*ALL";
				fid			= "DF";
			}else{
				
				uid			= user_id;
				fid			= facility_id;
			}
			
			recCnt = 0;
			
		String sqlQuery="select field_name, lower(field_name)||'~'||field_desc||'~'||APPL_YN From MR_REPORT_RESULT_ORDER where facility_id = ? and user_id = ? order by Field_order asc";
			pstmt1	=	con.prepareStatement(sqlQuery);
			pstmt1.setString(1,fid);
			pstmt1.setString(2,uid);

			rs1 =	pstmt1.executeQuery();
				while (rs1.next()){
					fieldNames.add(rs1.getString(1));
					appendedFields.add(rs1.getString(2));
					recCnt++;
				}
			
			
			fieldsJsonObj.put("recCnt",recCnt);
			fieldsJsonObj.put("fieldNames",fieldNames);
			fieldsJsonObj.put("appendedFields",appendedFields);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(rs1!=null) rs1.close();
			if(pstmt1!=null)	pstmt1.close();
			if(stmt!=null)	stmt.close();
			//if(rs!=null)	rs = null; //Commented for checkstyle
			if(rs!=null) rs.close(); //Added for checkstyle
			
		}
		
		return fieldsJsonObj;
	}
	
	public static JSONObject getFieldNames(Connection con,String facility_id,String user_id ) throws java.sql.SQLException 
	{
	
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList fieldNames = new ArrayList();
		JSONObject fieldsJsonObj	= new JSONObject();
		int recCnt = 0 ;
		String fid="";
		String uid="";
		try {
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("select count(*) from MR_REPORT_RESULT_ORDER where Facility_id='"+facility_id+"' and User_id='"+user_id+"'");

			if ((rs != null) && (rs.next()) )
			{
				recCnt = rs.getInt(1);
			}
			
			
			if(recCnt == 0){
				
				uid			= "*ALL";
				fid			= "DF";
			}else{
				
				uid			= user_id;
				fid			= facility_id;
			}
			
			recCnt = 0;
			
			if(rs!=null) rs.close();
			
			if(stmt!=null)	stmt.close();
			
			stmt = con.createStatement();
			
			rs = stmt.executeQuery("select field_name from MR_REPORT_RESULT_ORDER where facility_id = '"+fid+"' and user_id ='"+uid+"' and appl_yn='Y' order by Field_order asc ");

			while ((rs != null) && (rs.next()) )
			{
				fieldNames.add(rs.getString(1));
				recCnt++;
			}
				
			
			fieldsJsonObj.put("fieldNames",fieldNames);
			fieldsJsonObj.put("recCnt",recCnt);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(rs!=null) rs.close();
			
			if(stmt!=null)	stmt.close();
		
		}
		
		return fieldsJsonObj;	
	}
	// Added by mujafar for ML-MMOH-CRF-1280 END	
	
	/*Added by Ashwini on 29-Jul-2019 for ML-MMOH-CRF-1352*/
	public static JSONObject getClinicList(Connection con, String service_list, String facility_id) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rset 			= null;
		JSONObject json			= new JSONObject();
		JSONArray arrJSON		= new JSONArray();
		StringBuffer sqlQuery	= new StringBuffer();
		int noOfRecs			= 0;

		try
		{
			if (("ED").equals(service_list))
			{
				sqlQuery.append("SELECT COUNT (*) OVER () noofrecords, clinic_code, short_desc, check_yn FROM (SELECT a.clinic_code, short_desc, 'Y' check_yn FROM op_clinic a, mr_report_of_op_attendance b WHERE a.facility_id = '"+facility_id+"' AND level_of_care_ind = 'E' AND care_locn_type_ind = 'C' AND specialist_clinic_yn <> 'Y' AND eff_status = 'E' AND a.clinic_code = b.clinic_code AND a.facility_id = b.facility_id AND b.service_code = '"+service_list+"' UNION SELECT a.clinic_code, short_desc, 'N' check_yn FROM op_clinic a WHERE a.facility_id = '"+facility_id+"' AND level_of_care_ind = 'E' AND care_locn_type_ind = 'C' AND specialist_clinic_yn <> 'Y' AND eff_status = 'E' AND clinic_code NOT IN (SELECT clinic_code FROM mr_report_of_op_attendance b WHERE a.clinic_code = b.clinic_code AND a.facility_id = b.facility_id AND b.service_code = '"+service_list+"') ORDER BY clinic_code)");
			}
			else if (("SC").equals(service_list))
			{
				sqlQuery.append("SELECT COUNT (*) OVER () noofrecords, clinic_code, short_desc, check_yn FROM (SELECT a.clinic_code, short_desc, 'Y' check_yn FROM op_clinic a, mr_report_of_op_attendance b WHERE a.facility_id = '"+facility_id+"' AND level_of_care_ind = 'A' AND care_locn_type_ind = 'C' AND specialist_clinic_yn = 'Y' AND eff_status = 'E' AND a.clinic_code = b.clinic_code AND a.facility_id = b.facility_id AND b.service_code = '"+service_list+"' UNION SELECT a.clinic_code, short_desc, 'N' check_yn FROM op_clinic a WHERE a.facility_id = '"+facility_id+"' AND level_of_care_ind = 'A' AND care_locn_type_ind = 'C' AND specialist_clinic_yn = 'Y' AND eff_status = 'E' AND clinic_code NOT IN (SELECT clinic_code FROM mr_report_of_op_attendance b WHERE a.clinic_code = b.clinic_code AND a.facility_id = b.facility_id AND b.service_code = '"+service_list+"') ORDER BY clinic_code)");
			}
			else if (("ST").equals(service_list))
			{
				sqlQuery.append("SELECT COUNT (*) OVER () noofrecords, clinic_code, short_desc, check_yn FROM (SELECT a.clinic_code, short_desc, 'Y' check_yn FROM op_clinic a, mr_report_of_op_attendance b WHERE a.facility_id = '"+facility_id+"' AND level_of_care_ind = 'A' AND care_locn_type_ind = 'C' AND specialist_clinic_yn != 'Y' AND eff_status = 'E' AND a.clinic_code = b.clinic_code AND a.facility_id = b.facility_id AND b.service_code = '"+service_list+"' UNION SELECT a.clinic_code, short_desc, 'N' check_yn FROM op_clinic a WHERE a.facility_id = '"+facility_id+"' AND level_of_care_ind = 'A' AND care_locn_type_ind = 'C' AND specialist_clinic_yn != 'Y' AND eff_status = 'E' AND clinic_code NOT IN (SELECT clinic_code FROM mr_report_of_op_attendance b WHERE a.clinic_code = b.clinic_code AND a.facility_id = b.facility_id AND b.service_code = '"+service_list+"') ORDER BY clinic_code)");
			}
			else if (("PU").equals(service_list))
			{
				sqlQuery.append("SELECT COUNT (*) OVER () noofrecords, clinic_code, short_desc, check_yn FROM (SELECT a.clinic_code, short_desc, 'Y' check_yn FROM op_clinic a, mr_report_of_op_attendance b WHERE a.facility_id = '"+facility_id+"' AND care_locn_type_ind = 'E' AND eff_status = 'E' AND a.clinic_code = b.clinic_code AND a.facility_id = b.facility_id AND b.service_code = '"+service_list+"' UNION SELECT a.clinic_code, short_desc, 'N' check_yn FROM op_clinic a WHERE a.facility_id = '"+facility_id+"' AND care_locn_type_ind = 'E' AND eff_status = 'E' AND clinic_code NOT IN (SELECT clinic_code FROM mr_report_of_op_attendance b WHERE a.clinic_code = b.clinic_code AND a.facility_id = b.facility_id AND b.service_code = '"+service_list+"') ORDER BY clinic_code)");
			}

			pstmt = con.prepareStatement(sqlQuery.toString());
			rset = pstmt.executeQuery();

			while(rset!=null && rset.next())
			{
				JSONObject jsonObj = new JSONObject();
				noOfRecs = rset.getInt("noOfRecords");
				String clinic_code = rset.getString("clinic_code")==null?"":rset.getString("clinic_code");
				String short_desc = rset.getString("short_desc")==null?"":rset.getString("short_desc");
				String check_yn = rset.getString("check_yn")==null?"":rset.getString("check_yn");

				jsonObj.put("clinic_code",clinic_code);
				jsonObj.put("short_desc",short_desc);
				jsonObj.put("check_yn",check_yn);
				arrJSON.add(jsonObj);
			}

			json.put("clinicListArray",arrJSON);
			json.put("noOfRecords", noOfRecs);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try
			{
				if(rset!=null)rset.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getClinicList - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return json;
	}
	/*End ML-MMOH-CRF-1352*/

	/*Added by Ashwini on 26-Aug-2019 for ML-MMOH-CRF-1348*/
	public static JSONObject getClinicProcUnitList(Connection con, String service_list, String location_list, String facility_id) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rset 			= null;
		JSONObject json			= new JSONObject();
		JSONArray arrJSON		= new JSONArray();
		StringBuffer sqlQuery	= new StringBuffer();
		int noOfRecs			= 0;

		try
		{
			if (("KK").equals(service_list) && ("CL").equals(location_list))
			{
				sqlQuery.append("SELECT COUNT (*) OVER () noofrecords, clinic_code, short_desc, check_yn FROM (SELECT a.clinic_code, short_desc, 'Y' check_yn FROM op_clinic a, mr_report_on_referral_sources b WHERE a.facility_id = '"+facility_id+"' AND level_of_care_ind = 'A' AND care_locn_type_ind = 'C' AND specialist_clinic_yn != 'Y' AND eff_status = 'E' AND a.clinic_code = b.clinic_code AND a.facility_id = b.facility_id AND b.service_code = '"+service_list+"' AND b.location_code = '"+location_list+"' UNION SELECT a.clinic_code, short_desc, 'N' check_yn FROM op_clinic a WHERE a.facility_id = '"+facility_id+"' AND level_of_care_ind = 'A' AND care_locn_type_ind = 'C' AND specialist_clinic_yn != 'Y' AND eff_status = 'E' AND clinic_code NOT IN (SELECT clinic_code FROM mr_report_on_referral_sources b WHERE a.clinic_code = b.clinic_code AND a.facility_id = b.facility_id AND b.service_code = '"+service_list+"' AND b.location_code = '"+location_list+"') ORDER BY clinic_code)");
			}
			else if (("KK").equals(service_list) && ("PU").equals(location_list))
			{
				sqlQuery.append("SELECT COUNT (*) OVER () noofrecords, clinic_code, short_desc, check_yn FROM (SELECT a.clinic_code, short_desc, 'Y' check_yn FROM op_clinic a, mr_report_on_referral_sources b WHERE a.facility_id = '"+facility_id+"' AND care_locn_type_ind = 'E' AND eff_status = 'E' AND a.clinic_code = b.clinic_code AND a.facility_id = b.facility_id AND b.service_code = '"+service_list+"' AND b.location_code = '"+location_list+"' UNION SELECT a.clinic_code, short_desc, 'N' check_yn FROM op_clinic a WHERE a.facility_id = '"+facility_id+"' AND care_locn_type_ind = 'E' AND eff_status = 'E' AND clinic_code NOT IN (SELECT clinic_code FROM mr_report_on_referral_sources b WHERE a.clinic_code = b.clinic_code AND a.facility_id = b.facility_id AND b.location_code = '"+location_list+"') ORDER BY clinic_code)");
			}
			else if (("PC").equals(service_list) && ("PU").equals(location_list))
			{
				sqlQuery.append("SELECT COUNT (*) OVER () noofrecords, clinic_code, short_desc, check_yn FROM (SELECT a.clinic_code, short_desc, 'Y' check_yn FROM op_clinic a, mr_report_on_referral_sources b WHERE a.facility_id = '"+facility_id+"' AND care_locn_type_ind = 'E' AND eff_status = 'E' AND a.clinic_code = b.clinic_code AND a.facility_id = b.facility_id AND b.service_code = '"+service_list+"' AND b.location_code = '"+location_list+"' UNION SELECT a.clinic_code, short_desc, 'N' check_yn FROM op_clinic a WHERE a.facility_id = '"+facility_id+"' AND care_locn_type_ind = 'E' AND eff_status = 'E' AND clinic_code NOT IN (SELECT clinic_code FROM mr_report_on_referral_sources b WHERE a.clinic_code = b.clinic_code AND a.facility_id = b.facility_id AND b.location_code = '"+location_list+"') ORDER BY clinic_code)");
			}

			pstmt = con.prepareStatement(sqlQuery.toString());
			rset = pstmt.executeQuery();

			while(rset!=null && rset.next())
			{
				JSONObject jsonObj = new JSONObject();
				noOfRecs = rset.getInt("noOfRecords");
				String clinic_code = rset.getString("clinic_code")==null?"":rset.getString("clinic_code");
				String short_desc = rset.getString("short_desc")==null?"":rset.getString("short_desc");
				String check_yn = rset.getString("check_yn")==null?"":rset.getString("check_yn");

				jsonObj.put("clinic_code",clinic_code);
				jsonObj.put("short_desc",short_desc);
				jsonObj.put("check_yn",check_yn);
				arrJSON.add(jsonObj);
			}

			json.put("ClinicProcUnitArray",arrJSON);
			json.put("noOfRecords", noOfRecs);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try
			{
				if(rset!=null)rset.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getClinicProcUnitList - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return json;
	}
	/*End ML-MMOH-CRF-1348*/

	/*Added by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349*/
	public static JSONObject getOPClinicList(Connection con, String service_list, String facility_id) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rset 			= null;
		JSONObject json			= new JSONObject();
		JSONArray arrJSON		= new JSONArray();
		StringBuffer sqlQuery	= new StringBuffer();
		int noOfRecs			= 0;

		try
		{
			if (("ED").equals(service_list))
			{
				sqlQuery.append("SELECT COUNT (*) OVER () noofrecords, clinic_code, short_desc, check_yn FROM (SELECT a.clinic_code, short_desc, 'Y' check_yn FROM op_clinic a, MR_REPORT_PER_PL206 b WHERE a.facility_id = '"+facility_id+"' AND level_of_care_ind = 'E' AND care_locn_type_ind = 'C' AND specialist_clinic_yn <> 'Y' AND eff_status = 'E' AND a.clinic_code = b.clinic_code AND a.facility_id = b.facility_id AND b.service_code = '"+service_list+"' UNION SELECT a.clinic_code, short_desc, 'N' check_yn FROM op_clinic a WHERE a.facility_id = '"+facility_id+"' AND level_of_care_ind = 'E' AND care_locn_type_ind = 'C' AND specialist_clinic_yn <> 'Y' AND eff_status = 'E' AND clinic_code NOT IN (SELECT clinic_code FROM MR_REPORT_PER_PL206 b WHERE a.clinic_code = b.clinic_code AND a.facility_id = b.facility_id AND b.service_code = '"+service_list+"') ORDER BY clinic_code)");
			}
			else if (("SC").equals(service_list))
			{
				sqlQuery.append("SELECT COUNT (*) OVER () noofrecords, clinic_code, short_desc, check_yn FROM (SELECT a.clinic_code, short_desc, 'Y' check_yn FROM op_clinic a, MR_REPORT_PER_PL206 b WHERE a.facility_id = '"+facility_id+"' AND level_of_care_ind = 'A' AND care_locn_type_ind = 'C' AND specialist_clinic_yn = 'Y' AND eff_status = 'E' AND a.clinic_code = b.clinic_code AND a.facility_id = b.facility_id AND b.service_code = '"+service_list+"' UNION SELECT a.clinic_code, short_desc, 'N' check_yn FROM op_clinic a WHERE a.facility_id = '"+facility_id+"' AND level_of_care_ind = 'A' AND care_locn_type_ind = 'C' AND specialist_clinic_yn = 'Y' AND eff_status = 'E' AND clinic_code NOT IN (SELECT clinic_code FROM MR_REPORT_PER_PL206 b WHERE a.clinic_code = b.clinic_code AND a.facility_id = b.facility_id AND b.service_code = '"+service_list+"') ORDER BY clinic_code)");
			}
			else if (("ST").equals(service_list))
			{
				sqlQuery.append("SELECT COUNT (*) OVER () noofrecords, clinic_code, short_desc, check_yn FROM (SELECT a.clinic_code, short_desc, 'Y' check_yn FROM op_clinic a, MR_REPORT_PER_PL206 b WHERE a.facility_id = '"+facility_id+"' AND level_of_care_ind = 'A' AND care_locn_type_ind = 'C' AND specialist_clinic_yn != 'Y' AND eff_status = 'E' AND a.clinic_code = b.clinic_code AND a.facility_id = b.facility_id AND b.service_code = '"+service_list+"' UNION SELECT a.clinic_code, short_desc, 'N' check_yn FROM op_clinic a WHERE a.facility_id = '"+facility_id+"' AND level_of_care_ind = 'A' AND care_locn_type_ind = 'C' AND specialist_clinic_yn != 'Y' AND eff_status = 'E' AND clinic_code NOT IN (SELECT clinic_code FROM MR_REPORT_PER_PL206 b WHERE a.clinic_code = b.clinic_code AND a.facility_id = b.facility_id AND b.service_code = '"+service_list+"') ORDER BY clinic_code)");
			}
			else if (("PU").equals(service_list))
			{
				sqlQuery.append("SELECT COUNT (*) OVER () noofrecords, clinic_code, short_desc, check_yn FROM (SELECT a.clinic_code, short_desc, 'Y' check_yn FROM op_clinic a, MR_REPORT_PER_PL206 b WHERE a.facility_id = '"+facility_id+"' AND care_locn_type_ind = 'E' AND eff_status = 'E' AND a.clinic_code = b.clinic_code AND a.facility_id = b.facility_id AND b.service_code = '"+service_list+"' UNION SELECT a.clinic_code, short_desc, 'N' check_yn FROM op_clinic a WHERE a.facility_id = '"+facility_id+"' AND care_locn_type_ind = 'E' AND eff_status = 'E' AND clinic_code NOT IN (SELECT clinic_code FROM MR_REPORT_PER_PL206 b WHERE a.clinic_code = b.clinic_code AND a.facility_id = b.facility_id AND b.service_code = '"+service_list+"') ORDER BY clinic_code)");
			}

			pstmt = con.prepareStatement(sqlQuery.toString());
			rset = pstmt.executeQuery();

			while(rset!=null && rset.next())
			{
				JSONObject jsonObj = new JSONObject();
				noOfRecs = rset.getInt("noOfRecords");
				String clinic_code = rset.getString("clinic_code")==null?"":rset.getString("clinic_code");
				String short_desc = rset.getString("short_desc")==null?"":rset.getString("short_desc");
				String check_yn = rset.getString("check_yn")==null?"":rset.getString("check_yn");

				jsonObj.put("clinic_code",clinic_code);
				jsonObj.put("short_desc",short_desc);
				jsonObj.put("check_yn",check_yn);
				arrJSON.add(jsonObj);
			}

			json.put("OPClinicListArray",arrJSON);
			json.put("noOfRecords", noOfRecs);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try
			{
				if(rset!=null)rset.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getOPClinicList - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return json;
	}

	public static String getVisitTypeForService(Connection con, String language_id, String facility_id, String service_code, String clinic_code) throws Exception{
		Statement stmt				= null;
		ResultSet rs 				= null;
		StringBuffer type_code_desc = new StringBuffer();

		try{
			String sql = "SELECT DISTINCT op_get_desc.op_visit_type (a.facility_id, a.visit_type_code, '"+language_id+"', '2' ) visit_type_desc, a.visit_type_code FROM op_visit_type_for_clinic a, mr_report_per_pl206 b WHERE a.facility_id = b.facility_id AND a.clinic_code = b.clinic_code AND b.service_code = '"+service_code+"' AND a.facility_id = '"+facility_id+"' AND b.clinic_code LIKE UPPER (NVL ('"+clinic_code+"', '%')) AND a.eff_status = 'E' ORDER BY visit_type_desc";
			
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			while(rs!=null && rs.next()){
				
				String visit_type_code	= rs.getString("visit_type_code")==null?"":rs.getString("visit_type_code");
				String visit_type_desc	= rs.getString("visit_type_desc")==null?"":rs.getString("visit_type_desc");

				type_code_desc.append(visit_type_code+"##"+visit_type_desc);
				type_code_desc.append("~");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getVisitTypeForService - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return type_code_desc.toString();
	}
	/*End ML-MMOH-CRF-1349*/

	/*Added by Ashwini on 24-Oct-2019 for MMS-DM-SCF-0645*/
	public static String getTermCodeEffStatus(Connection con, String term_code, String term_set_id) throws Exception{
		
		PreparedStatement pstmt	= null;
		ResultSet rs			= null;
		String eff_status		= "";

		try{
		
			String Sql = "SELECT eff_status FROM mr_term_code WHERE term_code = '"+term_code+"' AND term_set_id = '"+term_set_id+"'" ;

			pstmt = con.prepareStatement(Sql);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){
				eff_status = rs.getString("eff_status") == null? "" : rs.getString("eff_status");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getTermCodeEffStatus - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return eff_status;
	}
	/*End  MMS-DM-SCF-0645*/

	/*Added by Ashwini on 27-Mar-2020 for GHL-CRF-0614.1*/
	public static int getDrugCnt(Connection con,String facility_id) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rs = null;
		String sql = "";
		int cnt	= 0;

		try{
			sql		= "SELECT COUNT (*) drug_cnt FROM ph_facility_param WHERE facility_id = '"+facility_id+"' AND drug_db_interface_yn = 'Y' AND drug_db_product_id = 'CIMS'";
			pstmt	= con.prepareStatement(sql);
			rs		= pstmt.executeQuery();

			if(rs!=null && rs.next()){
				cnt	= rs.getInt("drug_cnt");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getDrugCnt method - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return cnt;
	}

	public static JSONArray getGenericType(Connection con) throws Exception{
		Statement stmt		= null;
		ResultSet rs 		= null;
		JSONArray arrJSON	= new JSONArray();

		try{
			String sql = "SELECT DISTINCT a.thirdparty_type generice_type FROM ph_generic_ext_prod_ref a WHERE a.eff_status = 'E' AND a.product_id = 'CIMS' AND a.thirdparty_type IS NOT NULL ORDER BY a.thirdparty_type";
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while(rs!=null && rs.next()){
				
				JSONObject jsonObj = new JSONObject();
				String generice_type = rs.getString("generice_type")==null?"":rs.getString("generice_type");
				jsonObj.put("generice_type",generice_type);
				arrJSON.add(jsonObj);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getGenericType - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
	}
	/*End GHL-CRF-0614.1*/
		
	/*Added By Dharma on 2nd Dec 2019 against ML-MMOH-CRF-1454 Start*/
	public static int getMROpenReqCount(Connection con,String specialtyCode) throws Exception{
		PreparedStatement pstmt		= null;
		ResultSet rs 				= null;
		String sql					= "";
		int cnt				= 0;
		try{
			sql				= "SELECT COUNT (*) totcnt FROM mr_report_request_hdr WHERE specialty_code = '"+specialtyCode+"' AND request_status NOT IN ('8', '6') AND request_type = 'MR'";
			pstmt			= con.prepareStatement(sql);
			rs				= pstmt.executeQuery();
			if(rs!=null && rs.next()){
				cnt			= rs.getInt("totcnt");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getMROpenReqCount method  - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return cnt;
	}
	
	
	public static String getLaestEncSpecialtyCode(Connection con, String encIdsForSpecialty, String facilityId) throws Exception{
		Statement stmt				= null;
		ResultSet rs 				= null;
		String specialtyCode		= "";

		try{
			String sql = "SELECT specialty_code FROM pr_encounter WHERE visit_adm_date_time =  (SELECT MAX (visit_adm_date_time) FROM pr_encounter WHERE encounter_id IN ("+encIdsForSpecialty+") AND facility_id = '"+facilityId+"') and encounter_id IN ("+encIdsForSpecialty+") AND facility_id = '"+facilityId+"'";
			System.err.println("sql==>"+sql);
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			while(rs!=null && rs.next()){
				specialtyCode = checkForNull(rs.getString("specialty_code"));
			}
			System.err.println("specialtyCode==>"+specialtyCode);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getLaestEncSpecialtyCode - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return specialtyCode;
	}


	/*Added By Dharma on 2nd Dec 2019 against ML-MMOH-CRF-1454 End*/
	
	/*Added By Dharma on 13th Dec 2019 against ML-MMOH-CRF-1362 Start*/
	public static JSONObject getRequestorAddress(Connection con, String requestorId,String facilityId) throws Exception{
		Statement stmt			= null;
		ResultSet rs 			= null;
		JSONObject jsonObj	= new JSONObject();

		try{
			String sql = "select ADDR_LINE1,ADDR_LINE2,ADDR_LINE3,ADDR_LINE4,TOWN_CODE,TOWN_SHORT_DESC,AREA_CODE,AREA_SHORT_DESC,REGION_CODE,REGION_SHORT_DESC,POSTAL_CODE, POSTAL_SHORT_DESC, COUNTRY_CODE, COUNTRY_NAME, CONTACT1_NO,CONTACT2_NO, EMAIL_ID from mr_requestor_vw where REQUESTOR_CODE='"+requestorId+"' and FACILITY_ID = '"+facilityId+"'";  
			
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			if(rs!=null && rs.next()){
				
				String addressLine1			= checkForNull(rs.getString("ADDR_LINE1"));
				String addressLine2			= checkForNull(rs.getString("ADDR_LINE2"));
				String addressLine3			= checkForNull(rs.getString("ADDR_LINE3"));
				String addressLine4			= checkForNull(rs.getString("ADDR_LINE4"));
				String townCode				= checkForNull(rs.getString("TOWN_CODE"));
				String townDesc				= checkForNull(rs.getString("TOWN_SHORT_DESC"));
				String areaCode				= checkForNull(rs.getString("AREA_CODE"));
				String areaDesc				= checkForNull(rs.getString("AREA_SHORT_DESC"));
				String regionCode			= checkForNull(rs.getString("REGION_CODE"));
				String regionDesc			= checkForNull(rs.getString("REGION_SHORT_DESC"));
				String postalCode			= checkForNull(rs.getString("POSTAL_CODE")); 
				String PostalDesc			= checkForNull(rs.getString("POSTAL_SHORT_DESC"));
				String countryCode			= checkForNull(rs.getString("COUNTRY_CODE"));
				String countryName			= checkForNull(rs.getString("COUNTRY_NAME"));
				String contactNo1			= checkForNull(rs.getString("CONTACT1_NO"));
				String contactNo2			= checkForNull(rs.getString("CONTACT2_NO"));
				String emailId				= checkForNull(rs.getString("EMAIL_ID"));

				
				
				jsonObj.put("addressLine1",addressLine1);
				jsonObj.put("addressLine2",addressLine2);
				jsonObj.put("addressLine3",addressLine3);
				jsonObj.put("addressLine4",addressLine4);
				jsonObj.put("townCode",townCode);
				jsonObj.put("townDesc",townDesc);
				jsonObj.put("areaCode",areaCode);
				jsonObj.put("areaDesc",areaDesc);
				jsonObj.put("regionCode",regionCode);
				jsonObj.put("regionDesc",regionDesc);
				jsonObj.put("postalCode",postalCode);
				jsonObj.put("PostalDesc",PostalDesc);
				jsonObj.put("countryCode",countryCode);
				jsonObj.put("countryName",countryName);
				jsonObj.put("contactNo1",contactNo1);
				jsonObj.put("contactNo2",contactNo2);
				jsonObj.put("emailId",emailId);				
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getRequestorAddress - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return jsonObj;
	}
	/*Added By Dharma on 13th Dec 2019 against ML-MMOH-CRF-1362 End*/
	/*Added By Dharma against on 5th May 2020 ML-MMOH-CRF-1406 Start*/
	public static String getSpecialityDesc(Connection con, String language_id, String speciality_code) throws Exception{
		Statement stmt				= null;
		ResultSet rs 				= null;
		String short_desc			= "";

		try{
			String sql = "select am_get_desc.AM_speciality('"+speciality_code+"','"+language_id+"','2') short_desc from dual";
			
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			while(rs!=null && rs.next()){
				short_desc	= rs.getString("short_desc")==null?"":rs.getString("short_desc");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getSpecialityDesc - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return short_desc;
	}
	/*Added By Dharma on 5th May 2020 against ML-MMOH-CRF-1406  End*/
	/*Added by Afruddin for ML-MMOH-CRF-1527 US9 on 28-jun-2020*/
	public static JSONArray getPatientCategory(Connection con) throws Exception{
		Statement stmt			= null;
		ResultSet rs 			= null;
		JSONArray arrJSON		= new JSONArray();
		
        
		try{
			String sql = "select  PAT_CAT_CODE, SHORT_DESC from MP_PAT_CATEGORY WHERE EFF_STATUS='E'";
			
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);

			while(rs!=null && rs.next()){
				
				JSONObject jsonObj	= new JSONObject();
				
				String PAT_CAT_CODE		= rs.getString("PAT_CAT_CODE")==null?"":rs.getString("PAT_CAT_CODE");
				String SHORT_DESC = rs.getString("SHORT_DESC")==null?"":rs.getString("SHORT_DESC");
				jsonObj.put("PAT_CAT_CODE",PAT_CAT_CODE);
				jsonObj.put("SHORT_DESC",SHORT_DESC);
				
				
				arrJSON.add(jsonObj);
			}
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getPatientCategory - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
		}
	public static JSONArray getRhcategory(Connection con,String facility_id) throws Exception{
		Statement stmt			= null;
		ResultSet rs 			= null;
		JSONArray arrJSON		= new JSONArray();
		
        
		try{
			String sql = "select   PAT_CAT_CODE,RH_CAT_CODE from MR_REPORT_PER_RH101 WHERE FACILITY_ID='"+facility_id+"'";
			
			stmt = con.createStatement();
			rs	= stmt.executeQuery(sql);
			
			while(rs!=null && rs.next()){
				
				JSONObject jsonObj	= new JSONObject();
				
				String PAT_CAT_CODE		= rs.getString("PAT_CAT_CODE")==null?"":rs.getString("PAT_CAT_CODE");
				String RH_CAT_CODE = rs.getString("RH_CAT_CODE")==null?"":rs.getString("RH_CAT_CODE");
				jsonObj.put("PAT_CAT_CODE",PAT_CAT_CODE);
				jsonObj.put("RH_CAT_CODE",RH_CAT_CODE);
				arrJSON.add(jsonObj);
				
				
			}
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getRhcategory - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return arrJSON;
		}
	
		/*Ended by afruddin for ML-MMOH-CRF-1527 US9 on 28-jun-2020*/

	/*Added by Ashwini on 03-Sep-2020 for ML-MMOH-CRF-1351*/
	public static JSONObject getEDOBClinicList(Connection con, String service_list, String facility_id) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rset 			= null;
		JSONObject json			= new JSONObject();
		JSONArray arrJSON		= new JSONArray();
		int noOfRecs			= 0;

		try
		{
			String sql = "SELECT COUNT (*) OVER () noofrecords, clinic_code, short_desc, check_yn FROM (SELECT a.clinic_code, short_desc, 'Y' check_yn FROM op_clinic a, mr_rep_op_attend_zone_catg b WHERE a.facility_id = '"+facility_id+"' AND level_of_care_ind = 'E' AND eff_status = 'E' AND a.clinic_code = b.clinic_code AND a.facility_id = b.facility_id AND b.service_code = '"+service_list+"' UNION SELECT a.clinic_code, short_desc, 'N' check_yn FROM op_clinic a WHERE a.facility_id = '"+facility_id+"' AND level_of_care_ind = 'E' AND eff_status = 'E' AND clinic_code NOT IN (SELECT clinic_code FROM mr_rep_op_attend_zone_catg b WHERE a.clinic_code = b.clinic_code AND a.facility_id = b.facility_id AND b.service_code = '"+service_list+"') ORDER BY clinic_code)";

			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while(rset!=null && rset.next())
			{
				JSONObject jsonObj = new JSONObject();
				noOfRecs = rset.getInt("noOfRecords");
				String clinic_code = rset.getString("clinic_code")==null?"":rset.getString("clinic_code");
				String short_desc = rset.getString("short_desc")==null?"":rset.getString("short_desc");
				String check_yn = rset.getString("check_yn")==null?"":rset.getString("check_yn");

				jsonObj.put("clinic_code",clinic_code);
				jsonObj.put("short_desc",short_desc);
				jsonObj.put("check_yn",check_yn);
				arrJSON.add(jsonObj);
			}

			json.put("clinicListArray",arrJSON);
			json.put("noOfRecords", noOfRecs);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try
			{
				if(rset!=null)rset.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getEDOBClinicList - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return json;
	}

	public static int getEDOBClinicCnt(Connection con, String clinic_code, String facility_id, String service_code) throws Exception{
		PreparedStatement pstmt	= null;
		ResultSet rset 			= null;
		int clinic_cnt			= 0;

		try
		{
			String sql = "SELECT COUNT (*) clinic_cnt FROM mr_rep_op_attend_zone_catg WHERE clinic_code = '"+clinic_code+"' AND facility_id = '"+facility_id+"' AND service_code != '"+service_code+"'";

			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while(rset!=null && rset.next())
			{
				clinic_cnt = rset.getInt("clinic_cnt");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try
			{
				if(rset!=null)rset.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getEDOBClinicCnt - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return clinic_cnt;
	}
	/*End ML-MMOH-CRF-1351*/ 
	//Added by Suji Keerthi for ML-MMOH-CRF-1395 US001 on Dec-30,2020
	public static String getMRParameterValues(Connection con) throws Exception{
		
		PreparedStatement pstmt	= null;
		ResultSet rs			= null;
		String diag_class_mand_yn		= "";

		try{
			String Sql = "select * from MR_PARAMETER";

			pstmt = con.prepareStatement(Sql);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){
				diag_class_mand_yn = rs.getString("diag_class_mand_yn") == null? "" : rs.getString("diag_class_mand_yn");
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getMRParameterValues - "+ex.getMessage());
				ex.printStackTrace();
			}
		}
		return diag_class_mand_yn;
	}
	 //Ended by Suji Keerthi for ML-MMOH-CRF-1395 US001 on Dec-30,2020

     //Added by Arthi on 18-Jul-2022 for ML-MMOH-CRF-1906
     public static JSONObject getPatDtlMedRep(Connection con, String locale, String pat_id) throws Exception{

	    JSONObject jsonObj		= new JSONObject();
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String sql				= "";
		String patient_id		= "";
		String patient_name		= "";
		String patient_gender	= "";
		String patient_age		= "";

		try{
			
			sql = "SELECT patient_id, DECODE ('"+locale+"', 'en', patient_name, NVL (patient_name_loc_lang, patient_name)) patient_name, sex, calculate_age (TO_CHAR (date_of_birth, 'dd/mm/yyyy'), 1) age FROM mp_patient WHERE patient_id = '"+pat_id+"' ";
		
		    pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){
				patient_id = checkForNull(rs.getString("patient_id"));
				patient_name = checkForNull(rs.getString("patient_name"));
				patient_gender = checkForNull(rs.getString("sex"));
				patient_age = checkForNull(rs.getString("age"));
			}

			jsonObj.put("patient_id",patient_id);
			jsonObj.put("patient_name",patient_name);
			jsonObj.put("patient_gender",patient_gender);
			jsonObj.put("patient_age",patient_age);
		
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getPatDtlMedRep - "+ex.getMessage());
				ex.printStackTrace();
			}
		}

		return jsonObj;

     }
     //End ML-MMOH-CRF-1906
     
	 //Added by Arthi on 12-Oct-2022 for ML-MMOH-SCF-2123
	 public static String getFreeTextApplYN(Connection con, String termset_id) throws Exception{
			
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String sql				= "";
		String free_text_applicable_yn = "";

		try{

			sql = "SELECT free_text_applicable_yn FROM mr_term_set WHERE term_set_id = '"+termset_id+"'";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){
				free_text_applicable_yn = checkForNull(rs.getString("free_text_applicable_yn"));
			}

		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getFreeTextApplYN - "+ex.getMessage());
				ex.printStackTrace();
			}
		}

		return free_text_applicable_yn;
	}
	//End ML-MMOH-SCF-2123
	// Added by Kamatchi S for AAKH-CRF-0153 START
	public static String getInsurance(Connection con, String facilityId, String PatientId , String EpisodeId,String episode_type) throws Exception{
			
		PreparedStatement pstmt	= null;
		ResultSet rs 			= null;
		String sql				= "";
		String insurance = "";

		try{

			sql = "select blcommon.get_valid_pat_blng_grp('"+facilityId+"','"+PatientId+"','"+EpisodeId+"','1','"+episode_type+"') as insurance from dual";

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next()){
				insurance = checkForNull(rs.getString("insurance"));
			}

		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getInsurance - "+ex.getMessage());
				ex.printStackTrace();
			}
		}

		return insurance;
	}

	public static JSONObject getInsuranceDetails(Connection con, String facilityId, String PatientId , String EpisodeType, int EpisodeId, int visitId) throws Exception{
			
		ResultSet rs 			= null;
		JSONObject jsonObj	= new JSONObject();
		CallableStatement cstmt = null ;
		String payer = "";
		String policy_no = "";
		String policy_start_date = "";
		String policy_end_date ="";
		String membership_id = "";
		try{

			cstmt=con.prepareCall("{call BLCOMMONPROC.BL_GET_POLICY_DTLS(?,?,?,?,?,?,?,?,?,?) }"); 
			cstmt.setString(1,facilityId);
			cstmt.setString(2,PatientId);
			cstmt.setString(3,EpisodeType);
			cstmt.setInt(4,EpisodeId);
			cstmt.setInt(5,visitId);
			cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(8,java.sql.Types.DATE);
			cstmt.registerOutParameter(9,java.sql.Types.DATE);
			cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);

			cstmt.execute();
			payer = ((String)cstmt.getString(6));
			policy_no = ((String)cstmt.getString(7));
			policy_start_date = cstmt.getString(8);
			policy_end_date = cstmt.getString(9);
			membership_id = ((String)cstmt.getString(10));

			jsonObj.put("payer" , payer);
			jsonObj.put("policy_no" , policy_no);
			jsonObj.put("policy_start_date" , policy_start_date);
			jsonObj.put("policy_end_date" , policy_end_date);
			jsonObj.put("membership_id" , membership_id);

		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rs!=null)rs.close();
				if(cstmt!=null)cstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getInsurance - "+ex.getMessage());
				ex.printStackTrace();
			}
		}

		return jsonObj;
	}
	// Added by Kamatchi S for AAKH-CRF-0153 END

	//Added by kamatchi S for MMS-DM-CRF-0229.1
	public static JSONObject getRestrictYN(Connection con, String patient_id,String encounter_id,String diagcode,String locale,String diagset) throws Exception{
		JSONObject jsonObj	= new JSONObject();
		PreparedStatement pstmt	= null;
		ResultSet rset 			= null;
		String sql				= "";
		String sql1				= "";
		String sql2				= "";
		int cnt = 0;
		ArrayList<String> arr1 = new ArrayList<String>(); 
		ArrayList<String> arr2 = new ArrayList<String>();
		ArrayList<String> arr3 = new ArrayList<String>();
		String restrictYN = "N";
		String restrict = "";
		String drug_code = "";
		String drug_desc = "";
		String generic_id = "";
		String generic_name = "";
		String start_date= "";
		String end_date= "";
		String remarks= "";
		String drugName = "";
		String toCheckValue = "Y";
		Boolean checkDrug = false;
		try{

			sql1 = "SELECT a.drug_code drug_code, b.drug_desc drug_desc, a.generic_id generic_id, c.generic_name generic_name, TO_CHAR (a.start_date, 'DD/MM/YYYY hh24:mi') start_date, TO_CHAR (a.end_date, 'DD/MM/YYYY hh24:mi') end_date FROM ph_patient_drug_profile a, ph_drug_lang_vw b, ph_generic_name c WHERE a.patient_id = ? AND a.encounter_id = ? AND a.drug_code = b.drug_code AND a.generic_id = c.generic_id AND TO_DATE (a.end_date, 'dd/mm/yyyy hh24:mi') >= TO_DATE (SYSDATE, 'dd/mm/yyyy hh24:mi') AND TO_DATE (SYSDATE, 'DD/MM/RRRR HH24:MI') BETWEEN TO_DATE (a.start_date, 'DD/MM/RRRR HH24:MI') AND TO_DATE (a.end_date, 'DD/MM/RRRR HH24:MI') AND a.discont_date_time IS NULL AND a.on_hold_date_time IS NULL AND a.cancel_yn = 'N' AND a.stop_yn = 'N' AND b.language_id(+) = 'en'";

			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,encounter_id);
			rset = pstmt.executeQuery();
			while(rset!=null && rset.next()){
				drug_code = checkForNull(rset.getString("drug_code"));
				drug_desc = checkForNull(rset.getString("drug_desc"));
				generic_id = checkForNull(rset.getString("generic_id"));
				generic_name = checkForNull(rset.getString("generic_name"));
				start_date = checkForNull(rset.getString("start_date"));
				end_date = checkForNull(rset.getString("end_date"));
				arr1.add(generic_id); 
				arr2.add(drug_code);
			}
	sql ="SELECT ROW_NUMBER () OVER (PARTITION BY intr_type1 || intr_type2 || intr_code1 || intr_code2 ORDER BY ( form_code1 || form_code2) DESC) srl_no, b.intr_type1, b.intr_type2, intr_code2 intr_code, intr_code1 intr_code1, d1.generic_id generic_id1, DECODE (form_code1, '*A', 'All', (SELECT form_desc FROM ph_form_lang_vw WHERE form_code = b.form_code2 AND language_id = d1.language_id) ) form_desc, d1.generic_name intr_name2, b.intr_severity_level, b.intr_signif_level, b.intr_prob_level, intr_restrt_yn, intr_remarks, 'I' drug_inter_type FROM ph_drug_interaction b, ph_generic_name_lang_vw d1 WHERE intr_type1 = 'G' AND intr_type2 = 'I' AND b.intr_code1 = d1.generic_id AND term_set_id = '"+diagset+"'  AND intr_code2 = '"+diagcode+"' AND intr_code1 IN ("+convertArray(arr1)+") AND d1.language_id = '"+locale+"' AND b.eff_status = 'E' UNION ALL SELECT ROW_NUMBER () OVER (PARTITION BY intr_type1 || intr_type2 || intr_code1 || intr_code2 ORDER BY ( form_code1 || form_code2) DESC) srl_no, b.intr_type1, b.intr_type2, intr_code2 intr_code, intr_code1 intr_code1, d1.drug_desc generic_id1, DECODE (form_code1, '*A', 'All', (SELECT form_desc FROM ph_form_lang_vw WHERE form_code = b.form_code2 AND language_id = d1.language_id) ) form_desc, d1.drug_desc intr_name2, b.intr_severity_level, b.intr_signif_level, b.intr_prob_level, intr_restrt_yn, intr_remarks, 'I' drug_inter_type FROM ph_drug_interaction b, ph_drug_lang_vw d1 WHERE intr_type1 = 'D' AND intr_type2 = 'I' AND b.intr_code1 = d1.drug_code AND term_set_id = '"+diagset+"' AND intr_code2 = '"+diagcode+"' AND intr_code1 IN ("+convertArray(arr2)+") AND d1.language_id = '"+locale+"' AND b.eff_status = 'E' ";
		System.err.println("hi sql ==>"+sql.toString());
		if(rset != null) rset.close(); //Added for Checkstyle issue DEC23
		pstmt = con.prepareStatement(sql);
		rset = pstmt.executeQuery();
		while(rset != null && rset.next()) 
		{  			
			restrictYN	= rset.getString("intr_restrt_yn") == null ? "" : rset.getString("intr_restrt_yn");
			remarks	= rset.getString("intr_remarks") == null ? "" : rset.getString("intr_remarks");
			drugName = rset.getString("intr_name2") == null ? "" : rset.getString("intr_name2");
			arr3.add(restrictYN);
			checkDrug = true;
		}
		for (String element : arr3) {
            if (element.equals(toCheckValue)) {
                restrict = "Y";
            }
        }
		if(rset != null) rset.close(); //Added for Checkstyle issue DEC23
		sql2 = "SELECT count(*) cnt FROM ph_patient_drug_profile a, ph_drug_lang_vw b, ph_generic_name c WHERE a.patient_id = ? AND a.encounter_id = ? AND a.drug_code = b.drug_code AND a.generic_id = c.generic_id AND TO_DATE (a.end_date, 'dd/mm/yyyy hh24:mi') >= TO_DATE (SYSDATE, 'dd/mm/yyyy hh24:mi') AND TO_DATE (SYSDATE, 'DD/MM/RRRR HH24:MI') BETWEEN TO_DATE (a.start_date, 'DD/MM/RRRR HH24:MI') AND TO_DATE (a.end_date, 'DD/MM/RRRR HH24:MI') AND a.discont_date_time IS NULL AND a.on_hold_date_time IS NULL AND a.cancel_yn = 'N' AND a.stop_yn = 'N' AND b.language_id(+) = 'en'";

			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,encounter_id);
			rset = pstmt.executeQuery();

			if(rset!=null && rset.next()){
				cnt = rset.getInt("cnt");
			}
		
		jsonObj.put("restrictYN" , restrict);
		jsonObj.put("remarks" , remarks);
		jsonObj.put("checkDrug" , checkDrug);
		jsonObj.put("drugName" , drugName);
		jsonObj.put("start_date" , start_date);
		jsonObj.put("end_date" , end_date);
		jsonObj.put("cnt" , cnt);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
			}catch(Exception ex){
				System.err.println("Exception in getRestrictYN - "+ex.getMessage());
				ex.printStackTrace();
			}
		}

		return jsonObj;
	}


	public static String convertArray(ArrayList array){
		String str="";
		if(array !=null || array.size()>0){
		for(int i=0;i<array.size();i++){
	if(i==0){
	str="'"+array.get(i)+"'";
	} else {
	str=str+",'"+array.get(i)+"'";
	}
		}
			}
			return str;

	}

	//End MMS-DM-CRF-0229.1

}	
