/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT ;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ehis.util.DateUtils;
import com.iba.framework.core.util.DateUtil;

import eCommon.Common.CommonRepository;
import eOT.Common.OTAdapter;
import eOT.Common.OTRepository;
//import com.debug.sql.*;
// MMS-ME-SCF0051 start
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import org.apache.commons.codec.binary.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.spec.AlgorithmParameterSpec;
// MMS-ME-SCF0051 end

public class SlateBean extends OTAdapter implements Serializable {

	HashMap all_scheduled_case_details = null;
	HashMap all_unscheduled_case_details = null;
	HashMap all_waitlist_details = null;
	HashMap all_reschedule_details = null;
	Properties	p = this.properties;
	String	locale	= "";
	
	/* private String TEMP_SQL = "SELECT 0 IS_SCHD,  A.PATIENT_ID PATIENT_ID, DECODE (D.SEX, 'M', 'MALE', 'F', 'FEMALE') SEX, 'Emergency' CURRENT_LOCN, " 
			+ "NVL(DISPLAY_STATUS,A.STATUS_DESC) STATUS,  COLOR_CODE, A.OPER_DATE BKG_DATE, A.OPER_DATE BKG_ST_TIME  FROM OT_UNSCHD_OPERS_VW A, OT_POST_OPER_HDR B ," 
			+ " MP_PATIENT D,OT_DISPLAY_MAPPING MAP WHERE    A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND A.OPER_NUM   = B.OPER_NUM   AND A.PATIENT_ID = D.PATIENT_ID " 
			+ "AND A.OPER_STATUS = MAP.STATUS_CODE (+) AND A.OPERATING_FACILITY_ID = ? AND  A.LANGUAGE_ID = ? " 
			+ " UNION SELECT 1 IS_SCHD,  A.PATIENT_ID PATIENT_ID, " 
			+ "DECODE (D.SEX, 'M', 'MALE', 'F', 'FEMALE') SEX, OT_PAT_CURR_LOCATION(A.OPERATING_FACILITY_ID,NULL,A.APPT_REF_NUM,NULL,a.language_id) CURRENT_LOCN, " 
			+ "NVL(DISPLAY_STATUS,A.STATUS_DESC) STATUS,  COLOR_CODE, A.APPT_DATE BKG_DATE, A.APPT_FROM_TIME BKG_ST_TIME    FROM OT_SCHD_OPERS_VW A, OT_BOOKING_HDR B, " 
			+ "MP_PATIENT D,OT_DISPLAY_MAPPING MAP  WHERE  A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID AND A.APPT_REF_NUM = B.BOOKING_NUM AND A.PATIENT_ID =" 
			+ " D.PATIENT_ID AND A.BOOKING_STAGE IN (SELECT STAGE_CODE FROM OT_BOOKING_FIN_STAGES WHERE SERIAL_NO IN (SELECT MAX (SERIAL_NO) FROM OT_BOOKING_FIN_STAGES)) " 
			+ "AND A.APPT_DATE = NVL(OPER_DATE, A.APPT_DATE)  AND A.OPER_STATUS = MAP.STATUS_CODE (+)  AND A.OPERATING_FACILITY_ID = ? AND  A.LANGUAGE_ID = ?";  */ //Common-ICN-0055
	public SlateBean() {
        try {
			doCommon();
			p = this.properties;
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
		}catch(Exception e) {}
	}

	public void doCommon() throws Exception {
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
	}

	public void clear(){
		all_scheduled_case_details		= null;
		all_unscheduled_case_details	= null;
		all_waitlist_details			= null;
		all_reschedule_details			= null;
	}

	public String getSysDateTime(){
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		String curr_date		= "";
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				curr_date = resultSet.getString("CURRENT_DATE");
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		return curr_date;
	}

	public ArrayList getSpecialities(){
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		ArrayList arr_list		= new ArrayList();
		try{
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SLATE_SELECT2")) ;
			pstmt.setString(1,locale);
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				arr_list.add(resultSet.getString("OPER_GROUP_CODE"));
				arr_list.add(resultSet.getString("LONG_DESC"));
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		return arr_list;
	}

	public ArrayList getTheatreTypes(){
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		ArrayList arr_list		= new ArrayList();
		try{
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SLATE_SELECT3")) ;
			pstmt.setString(1,locale);
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				arr_list.add(resultSet.getString("LOCN_TYPE"));
				arr_list.add(resultSet.getString("SHORT_DESC"));
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		return arr_list;
	}

	public ArrayList getTheatres(String theatre_type){
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		ArrayList arr_list		= new ArrayList();
		try{
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SLATE_SELECT4")) ;
			pstmt.setString(1,locale);
			pstmt.setString(2,login_facility_id);
			if(theatre_type.equals("ALL"))
				theatre_type = "";
			pstmt.setString(3,theatre_type);
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				arr_list.add(resultSet.getString("OPER_ROOM_CODE"));
				arr_list.add(resultSet.getString("SHORT_DESC"));
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		return arr_list;
	}

	public ArrayList getAllTheatres(String surgeon_code, String speciality_code){
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		ArrayList arr_list		= new ArrayList();
		try{
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SLATE_WAILIST_SELECT13")) ;
			pstmt.setString(1,locale);
			pstmt.setString(2,login_facility_id);
			pstmt.setString(3,login_facility_id);
			pstmt.setString(4,surgeon_code);
			pstmt.setString(5,speciality_code);
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				arr_list.add(resultSet.getString("OPER_ROOM_CODE"));
				arr_list.add(resultSet.getString("SHORT_DESC"));
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		return arr_list;
	}


	public ArrayList getUserRoles(){
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		ArrayList arr_list		= new ArrayList();
		try{
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SLATE_SELECT6")) ;
			pstmt.setString(1,locale);
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				arr_list.add(resultSet.getString("ROLE_ID"));
				arr_list.add(resultSet.getString("ROLE_DESC"));
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		return arr_list;
	}
//PMG-CRF-003
	public ArrayList getApplicableUserRoles(String user_id){
			Connection connection   = null ;
	        PreparedStatement pstmt = null ;
	        ResultSet resultSet     = null ;
			ArrayList arr_list		= new ArrayList();
			try{
				p=getProperties();
				locale	= (String) p.getProperty("LOCALE");
				connection			= getConnection() ;
				StringBuffer RecsDispBuffer = new StringBuffer();
					RecsDispBuffer.append("SELECT   a.role_id role_id, a.role_desc role_desc, a.role_type role_type	");
					RecsDispBuffer.append("FROM ot_roles_lang_vw a	");
					RecsDispBuffer.append("WHERE role_type IN (SELECT role_type	");
					RecsDispBuffer.append("FROM ot_pract_types_for_role_type	");
					RecsDispBuffer.append("WHERE pract_type IN (SELECT pract_type	");
					RecsDispBuffer.append("FROM sm_appl_user_vw	");
					RecsDispBuffer.append("WHERE appl_user_id = ?))	");
					RecsDispBuffer.append("AND language_id = ?		");
					RecsDispBuffer.append("AND appl_to_ot_slate = 'Y'	");
					RecsDispBuffer.append("ORDER BY role_type, role_desc	");
				pstmt= connection.prepareStatement(RecsDispBuffer.toString());
				pstmt.setString(1,user_id);
				pstmt.setString(2, locale);
				resultSet			= pstmt.executeQuery();
				while(resultSet!=null && resultSet.next()){
					arr_list.add(resultSet.getString("ROLE_ID"));
					System.err.println("ROLE_ID==========="+resultSet.getString("ROLE_ID"));
					arr_list.add(resultSet.getString("ROLE_DESC"));
					System.err.println("ROLE_DESC========="+resultSet.getString("ROLE_DESC"));
				}
			}catch ( Exception e ) {
	            e.printStackTrace() ;
			}finally {
	            try{
	                closeResultSet( resultSet ) ;
	                closeStatement( pstmt ) ;
					closeConnection( connection );
	             }catch(Exception es){es.printStackTrace();}
	        }
			return arr_list;
	}
	public ArrayList getDefaultUserRoles(String user_id){
			Connection connection   = null ;
	        PreparedStatement pstmt = null ;
	        ResultSet resultSet     = null ;
			ArrayList arr_list		= new ArrayList();
			try{
				p=getProperties();
				locale	= (String) p.getProperty("LOCALE");
				connection			= getConnection() ;
				String role_type_slate="select ROLE_ID , ROLE_DESC from OT_ROLES_FOR_USERS where APPL_USER_ID= ? and APPLICABILITY='A'";
				pstmt= connection.prepareStatement(role_type_slate);
				pstmt.setString(1,user_id);
				resultSet			= pstmt.executeQuery();
				while(resultSet!=null && resultSet.next()){
					arr_list.add(resultSet.getString("ROLE_ID"));
					arr_list.add(resultSet.getString("ROLE_DESC"));
				}
			}catch ( Exception e ) {
	            e.printStackTrace() ;
			}finally {
	            try{
	                closeResultSet( resultSet ) ;
	                closeStatement( pstmt ) ;
	                closeConnection( connection );
	             }catch(Exception es){es.printStackTrace();}
	        }
			return arr_list;
	}
	//PMG-CRF-003
	public boolean loadScheduledCases(String theatre_date,String theatre_from,String theatre_to,String speciality,String surgeon,String status,String theatre_date_from,String elec_emer,String doc_status,String scan_vals,String theatre_type,String patient_id){//MO-CRF-20082
		HashMap scheduled_case_details = null;
			all_scheduled_case_details = new HashMap();
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		PreparedStatement pstmt1 = null ;
        ResultSet resultSet1     = null ;
		int index	= 0;
		try{
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
			connection			= getConnection() ;
			//Below query is changed against ML-BRU-SCF-0994 on 10/1/2013 by MuthuN /* OPER_ROOM_DESC */
			String sql_sch_cases=" SELECT A.APPT_DATE BKG_DATE, A.APPT_FROM_TIME BKG_ST_TIME, TO_CHAR(A.APPT_DATE,'DD/MM/YYYY') APPT_DATE, a.ORDER_ID ORDER_ID, TO_CHAR(a.APPT_FROM_TIME,'HH24:MI') APPT_FROM_TIME,TO_CHAR(a.APPT_TO_TIME,'HH24:MI') APPT_TO_TIME, a.PATIENT_ID PATIENT_ID, (SELECT DECODE ('"+locale+"', 'en', NVL (PATIENT_NAME, PATIENT_NAME_LOC_LANG), NVL (PATIENT_NAME_LOC_LANG, PATIENT_NAME) )  FROM MP_PATIENT WHERE PATIENT_ID = A.PATIENT_ID)  PATIENT_NAME,(SELECT CURR_ENCOUNTER_ID FROM MP_PATIENT  WHERE PATIENT_ID=a.patient_id) CURR_ENCOUNTER_ID, (SELECT CURR_PATIENT_CLASS FROM MP_PATIENT WHERE PATIENT_ID=a.patient_id)CURR_PATIENT_CLASS, a.OPER_CODE OPER_CODE, a.OPER_DESC OPER_DESC, a.SPECIALITY_CODE SPECIALITY_CODE, a.SPECIALITY_DESC SPECIALITY_DESC, a.SURGEON_CODE SURGEON_CODE, a.SURGEON_NAME SURGEON_NAME, a.OPER_STATUS OPER_STATUS, a.OPER_NUM OPER_NUM, a.STATUS_DESC STATUS_DESC, a.APPT_REF_NUM APPT_REF_NUM, a.COLOR_IND COLOR_IND, a.TEXT_COLOR TEXT_COLOR, NVL(a.NURSING_DOC_COMP_YN,'N') NURSING_DOC_COMP_YN, NVL(a.SURGEON_DOC_COMP_YN,'N') SURGEON_DOC_COMP_YN,  a.OPER_ROOM_CODE OPER_ROOM_CODE,a.OPER_ROOM_DESC OPER_ROOM_DESC,c.SHORT_DESC SHORT_DESC,b.RESCHEDULED_COUNT RESCHEDULED_COUNT,NVL(a.ANAESTHESIA_DOC_COMP_YN,'N') ANAESTHESIA_DOC_COMP_YN,TO_CHAR(a.CASE_CALLED_TIME,'DD/MM/YYYY HH24:MI') CASE_CALLED_TIME,TO_CHAR(a.CHECK_OUT_FROM_WARD_TIME,'DD/MM/YYYY HH24:MI') CHECK_OUT_FROM_WARD_TIME,a.HOLDING_AREA_CODE,OT_PAT_CURR_LOCATION (A.OPERATING_FACILITY_ID,NULL,A.APPT_REF_NUM,NULL,'"+locale+"') current_locn,a.asa_score_code  FROM OT_SCHD_OPERS_VW  a,OT_BOOKING_HDR b, OT_NATURE_OF_SURGERY_LANG_VW c  WHERE C.LANGUAGE_ID = '"+locale+"' AND a.OPERATING_FACILITY_ID='"+login_facility_id+"' AND a.OPERATING_FACILITY_ID= b.OPERATING_FACILITY_ID AND a.APPT_REF_NUM = b.BOOKING_NUM AND  b.NATURE_CODE = c.NATURE_CODE  AND a.APPT_DATE BETWEEN to_date('"+theatre_date_from+"','dd/mm/yyyy') AND to_date('"+theatre_date+"','dd/mm/yyyy') AND upper(C.NATURE_TYPE ) = DECODE('"+elec_emer+"','EL','EL','EM','EM','A',C.NATURE_TYPE) AND NVL(a.OPER_ROOM_CODE,'X')=NVL('"+theatre_from+"',NVL(a.OPER_ROOM_CODE,'X')) AND ((NVL( '"+theatre_type+"','X') = 'X') OR (A.OPER_ROOM_CODE IN (SELECT OPER_ROOM_CODE FROM OT_OPER_ROOM WHERE THEATRE_TYPE =  '"+theatre_type+"'))) AND INSTR(NVL(a.ALL_SPECIALITY_CODES,'#X#'),NVL(DECODE('"+speciality+"',NULL,NULL,'#'||'"+speciality+"'||'#'),NVL(a.ALL_SPECIALITY_CODES,'X')))>0 AND NVL(a.SURGEON_CODE,'X')=NVL('"+surgeon+"',NVL(a.SURGEON_CODE,'X')) AND NVL(a.PATIENT_ID,'X')=NVL('"+patient_id+"',NVL(a.PATIENT_ID,'X')) AND (('"+doc_status+"' = 0) OR  ('"+doc_status+"' = 1 and A.OPER_STATUS IN ('"+status+"'))) AND a.booking_stage in (select stage_code from ot_booking_fin_stages where serial_no in (select max(serial_no) from ot_booking_fin_stages)) AND A.LANGUAGE_ID = '"+locale+"' ORDER BY BKG_DATE DESC, BKG_ST_TIME ASC"; //Added asa_score_code for crf-0021//MO-CRF-20082
			pstmt = connection.prepareStatement(sql_sch_cases) ;
				resultSet= pstmt.executeQuery();
				while(resultSet!=null && resultSet.next()){
				index++;
				scheduled_case_details = new HashMap();
				scheduled_case_details.put("appt_date",resultSet.getString("APPT_DATE"));
				scheduled_case_details.put("order_id",resultSet.getString("ORDER_ID"));
				scheduled_case_details.put("appt_from_time",resultSet.getString("APPT_FROM_TIME"));
				scheduled_case_details.put("appt_to_time",resultSet.getString("APPT_TO_TIME"));
				scheduled_case_details.put("patient_id",resultSet.getString("PATIENT_ID"));
				scheduled_case_details.put("patient_name",resultSet.getString("PATIENT_NAME"));
				scheduled_case_details.put("oper_code",resultSet.getString("OPER_CODE"));
				scheduled_case_details.put("oper_desc",resultSet.getString("OPER_DESC"));
				scheduled_case_details.put("speciality_code",resultSet.getString("SPECIALITY_CODE"));
				scheduled_case_details.put("speciality_desc",resultSet.getString("SPECIALITY_DESC"));
				scheduled_case_details.put("surgeon_code",resultSet.getString("SURGEON_CODE"));
				scheduled_case_details.put("surgeon_name",resultSet.getString("SURGEON_NAME"));
				scheduled_case_details.put("oper_status",resultSet.getString("OPER_STATUS"));
				scheduled_case_details.put("oper_num",resultSet.getString("OPER_NUM"));
				scheduled_case_details.put("status_desc",resultSet.getString("STATUS_DESC"));
				scheduled_case_details.put("appt_ref_num",resultSet.getString("APPT_REF_NUM"));
				scheduled_case_details.put("color_ind",resultSet.getString("COLOR_IND"));
				scheduled_case_details.put("text_color",resultSet.getString("TEXT_COLOR"));
				scheduled_case_details.put("nursing_doc_comp_yn",resultSet.getString("NURSING_DOC_COMP_YN"));
				//scheduled_case_details.put("implant_entry_cmp_yn",resultSet.getString("IMPLANT_ENTRY_CMP_YN"));
				scheduled_case_details.put("surgeon_doc_comp_yn",resultSet.getString("SURGEON_DOC_COMP_YN"));
				/*scheduled_case_details.put("proc_chrg_cmp_yn",resultSet.getString("PROC_CHRG_CMP_YN"));
				scheduled_case_details.put("consumable_entry_cmp_yn",resultSet.getString("CONSUMABLE_ENTRY_CMP_YN"));
				scheduled_case_details.put("equipment_entry_cmp_yn",resultSet.getString("EQUIPMENT_ENTRY_CMP_YN"));
				scheduled_case_details.put("instrument_entry_cmp_yn",resultSet.getString("INSTRUMENT_ENTRY_CMP_YN"));*/
				scheduled_case_details.put("oper_room_code",resultSet.getString("OPER_ROOM_CODE"));
				scheduled_case_details.put("oper_room_desc",resultSet.getString("OPER_ROOM_DESC"));
				scheduled_case_details.put("nature_short_desc",resultSet.getString("SHORT_DESC"));
				scheduled_case_details.put("reschedule_count",resultSet.getString("RESCHEDULED_COUNT"));
				scheduled_case_details.put("anaesthesia_doc_comp_yn",resultSet.getString("ANAESTHESIA_DOC_COMP_YN"));
				scheduled_case_details.put("case_called_time",resultSet.getString("CASE_CALLED_TIME"));
				scheduled_case_details.put("check_out_from_ward_time",resultSet.getString("CHECK_OUT_FROM_WARD_TIME"));
				scheduled_case_details.put("holding_area_code",resultSet.getString("HOLDING_AREA_CODE"));
				scheduled_case_details.put("current_locn",resultSet.getString("current_locn"));
				scheduled_case_details.put("asa_score_code",resultSet.getString("asa_score_code"));  // Added for crf-0021
				scheduled_case_details.put("curr_encounter_id",resultSet.getString("curr_encounter_id"));  // Added for crf-0021
				scheduled_case_details.put("curr_patient_class",resultSet.getString("curr_patient_class"));
				scheduled_case_details.put("curr_patient_id",resultSet.getString("patient_id"));//MO-CRF-20082

				if(resultSet.getString("OPER_NUM")!=null || resultSet.getString("APPT_REF_NUM")!=null){
					if(Integer.parseInt(resultSet.getString("OPER_STATUS"))<40){


					scheduled_case_details.put("check_in_time","");
					scheduled_case_details.put("check_into_holding_area_time","");
					scheduled_case_details.put("check_into_or_time","");
					scheduled_case_details.put("nursing_doc_comp_time","");
					scheduled_case_details.put("surgeon_doc_comp_time","");
					scheduled_case_details.put("anaesthetist_doc_comp_time","");
					scheduled_case_details.put("recovery_start_time","");
					scheduled_case_details.put("recovery_end_time","");
				//	}
					}else{
					}

				}
				all_scheduled_case_details.put(index+"",scheduled_case_details);				
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
				closeResultSet( resultSet1 ) ;
                closeStatement( pstmt1 ) ;
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		if(index==0)
			return false;
		return true;
	}
	public HashMap getScheduledCases(){
		if(all_scheduled_case_details==null)
			all_scheduled_case_details=new HashMap();
		return this.all_scheduled_case_details;
	}
	public int getPatientCount(String facilityId)
	{

		int rowCount = 0;
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
        StringBuffer sql = new StringBuffer();
		int index	= 1;
		try{
			p = getProperties();
			locale	= (String) p.getProperty("LOCALE");
			connection = getConnection() ;
			sql.append( "SELECT COUNT(*) FROM (");
			sql.append(OTRepository.getOTKeyValue("PATIENT_DASHBOARD_SELECT"));
			sql.append(") ORDER BY ROWNUM ASC, BKG_DATE DESC, BKG_ST_TIME ASC");

			String sysdate  = getSysDateTime();
			String previousDate = getPreviousDate(sysdate);
			pstmt = connection.prepareStatement(sql.toString()) ;
			pstmt.setString(index++, facilityId);
			pstmt.setString(index++, locale);
			pstmt.setString(index++, sysdate);
			pstmt.setString(index++, facilityId);
			pstmt.setString(index++, locale);
			pstmt.setString(index++, sysdate);
			pstmt.setString(index++, sysdate);
			pstmt.setString(index++, previousDate);
			resultSet = pstmt.executeQuery();
			while(resultSet!=null && resultSet.next())
			{
				rowCount = resultSet.getInt(1);
			}
		}
		catch ( Exception e )
		{
            e.printStackTrace() ;
		}
		finally
		{
            try
            {
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }
            catch(Exception es)
            {
            	es.printStackTrace();
            }
        }
		return rowCount;
	}
	public HashMap patientCurrentStatus(String from, String to, String facilityId, LinkedHashMap detailMap)
	{
		HashMap scheduled_case_details = null;
		HashMap patientCurrentStatusMap = new HashMap();
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		PreparedStatement pstmt1 = null ;
        ResultSet resultSet1     = null ;
        StringBuffer sql = new StringBuffer();
        String codeDescCol = "";
		int index	= 1;
		try{
			p = getProperties();
			locale	= (String) p.getProperty("LOCALE");
			connection = getConnection() ;
			sql.append( "SELECT * FROM ( SELECT   ROWNUM RW1, IS_SCHD, PATIENT_ID, SEX, CURRENT_LOCN, operstatus, STATUS, COLOR_CODE, BKG_DATE, BKG_ST_TIME FROM (");
			sql.append(OTRepository.getOTKeyValue("PATIENT_DASHBOARD_SELECT"));
			sql.append(")) WHERE RW1 BETWEEN ? and ? ORDER BY patient_id asc, RW1 ASC, BKG_DATE DESC, BKG_ST_TIME ASC");
			String sysdate  = getSysDateTime();
			String previousDate = getPreviousDate(sysdate);
			pstmt = connection.prepareStatement(sql.toString()) ;
			pstmt.setString(index++, facilityId);
			pstmt.setString(index++, locale);
			pstmt.setString(index++, sysdate);
			pstmt.setString(index++, facilityId);
			pstmt.setString(index++, locale);
			pstmt.setString(index++, sysdate);
			pstmt.setString(index++, sysdate);
			pstmt.setString(index++, previousDate);
			pstmt.setString(index++, from);
			pstmt.setString(index++, to);
			resultSet = pstmt.executeQuery();
			//reset index
			index = 0;
			while(resultSet!=null && resultSet.next())
			{
				scheduled_case_details = new HashMap();
				scheduled_case_details.put("PATIENT_ID",resultSet.getString("PATIENT_ID"));
				scheduled_case_details.put("STATUS",resultSet.getString("STATUS"));
				scheduled_case_details.put("SEX",resultSet.getString("SEX"));
				scheduled_case_details.put("COLOR_CODE",resultSet.getString("COLOR_CODE"));
				String isSchString = resultSet.getString("IS_SCHD");
				scheduled_case_details.put("IS_SCHD",isSchString);
				if("0".equals(isSchString))
				{
					//scheduled_case_details.put("CURRENT_LOCN","");
					scheduled_case_details.put("CURRENT_LOCN",resultSet.getString("CURRENT_LOCN"));
				}
				else
				{
					if(resultSet.getString("CURRENT_LOCN") != null)
					{
						StringTokenizer strToken1=new StringTokenizer(resultSet.getString("CURRENT_LOCN"),"$$");
						scheduled_case_details.put("CURRENT_LOCN",strToken1.nextToken());
					}
					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					String apptDate = df.format(resultSet.getDate("BKG_DATE"));
					if(!sysdate.equals(apptDate))
					{
						scheduled_case_details.put("PREV_DAY","1");
					}
				}
				if(detailMap != null && detailMap.containsKey(resultSet.getString("operstatus")))
				{
					codeDescCol = (String)detailMap.get(resultSet.getString("operstatus"));
					String[] colourAndDescArr = codeDescCol.split("~");
					scheduled_case_details.put("STATUS", colourAndDescArr[0]);
					scheduled_case_details.put("COLOR_CODE", "#"+colourAndDescArr[1]);
				}
				patientCurrentStatusMap.put(index, scheduled_case_details);
				index++;
			}
		}
		catch ( Exception e ) 
		{
            e.printStackTrace() ;
		}
		finally 
		{
            try
            {
				closeResultSet( resultSet1 ) ;
                closeStatement( pstmt1 ) ;
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }
            catch(Exception es)
            {
            	es.printStackTrace();
            }
        }
		return patientCurrentStatusMap;
	}
	public boolean loadUnScheduledCases(String theatre_date,String theatre_from,String theatre_to,String speciality,String surgeon,String status,String theatre_date_from,String elec_emer,String doc_status,String scan_vals,String theatre_type,String patient_id){//MO-CRF-20082
		HashMap unscheduled_case_details = null;
			all_unscheduled_case_details = new HashMap();
		//StatementFactory.setDefaultDebug(DebugLevel.VERBOSE);
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        PreparedStatement pstmt1 = null ;
        ResultSet resultSet     = null ;
        ResultSet resultSet1     = null ;

		int index	= 0;
		try{
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
			connection	= getConnection() ;
			//String sql_unsch_cases="SELECT A.OPER_DATE OP_DATE, TO_CHAR(A.OPER_DATE,'DD/MM/YYYY') OPER_DATE, a.ORDER_ID ORDER_ID, b.ENCOUNTER_ID ENCOUNTER_ID, a.PATIENT_ID  PATIENT_ID,(SELECT DECODE ('"+locale+"', 'en', NVL (patient_name, patient_name_loc_lang), NVL (patient_name_loc_lang, patient_name) )  FROM MP_PATIENT WHERE PATIENT_ID = a.PATIENT_ID)  PATIENT_NAME, a.OPER_CODE OPER_CODE,a. OPER_DESC OPER_DESC ,a. SPECIALITY_CODE  SPECIALITY_CODE, a. SPECIALITY_DESC  SPECIALITY_DESC,a. SURGEON_CODE  SURGEON_CODE,a. SURGEON_NAME  SURGEON_NAME,a. OPER_STATUS  OPER_STATUS, a.OPER_NUM OPER_NUM, a.STATUS_DESC STATUS_DESC, a.COLOR_IND COLOR_IND,  a.TEXT_COLOR TEXT_COLOR, NVL(a.NURSING_DOC_COMP_YN,'N') NURSING_DOC_COMP_YN,  NVL(a.SURGEON_DOC_COMP_YN,'N') SURGEON_DOC_COMP_YN,a.OPER_ROOM_CODE OPER_ROOM_CODE, c.SHORT_DESC NAT_SHORT_DESC,NVL(a.ANAESTHESIA_DOC_COMP_YN,'N') ANAESTHESIA_DOC_COMP_YN  FROM OT_UNSCHD_OPERS_VW a, ot_post_oper_hdr b, OT_NATURE_OF_SURGERY_LANG_VW c WHERE C.LANGUAGE_ID = '"+locale+"' AND a.OPERATING_FACILITY_ID='"+login_facility_id+"' AND a.OPERATING_FACILITY_ID=b.OPERATING_FACILITY_ID AND a.OPER_NUM   = b.OPER_NUM AND  b.NATURE_CODE  = c.NATURE_CODE AND NVL(a.OPER_ROOM_CODE,'X')=NVL('"+theatre_from+"',NVL(a.OPER_ROOM_CODE,'X')) AND   a.OPER_DATE BETWEEN to_date('"+theatre_date_from+"','dd/mm/yyyy') AND to_date('"+theatre_date+"','dd/mm/yyyy') AND upper(C.NATURE_TYPE ) = DECODE('"+elec_emer+"','EL','EL','EM','EM','A',C.NATURE_TYPE) AND INSTR(NVL(a.ALL_SPECIALITY_CODES,'#X#'), NVL(DECODE('"+speciality+"',NULL,NULL,'#'||'"+speciality+"'||'#'),NVL(a.ALL_SPECIALITY_CODES,'X')))>0 AND NVL(a.SURGEON_CODE,'X')=NVL('"+surgeon+"',NVL(a.SURGEON_CODE,'X')) AND (('"+doc_status+"' = 0) OR  ('"+doc_status+"' = 1 and A.OPER_STATUS IN ('"+status+"'))) AND A.LANGUAGE_ID='"+locale+"' ORDER BY OP_DATE DESC ";
			//Below query is changed against ML-BRU-SCF-0994 on 10/1/2013 by MuthuN /* OPER_ROOM_DESC */
			String sql_unsch_cases="SELECT A.OPER_DATE OP_DATE, TO_CHAR(A.OPER_DATE,'DD/MM/YYYY') OPER_DATE, a.ORDER_ID ORDER_ID, b.ENCOUNTER_ID ENCOUNTER_ID, a.PATIENT_ID  PATIENT_ID,(SELECT DECODE ('"+locale+"', 'en', NVL (patient_name, patient_name_loc_lang), NVL (patient_name_loc_lang, patient_name) )  FROM MP_PATIENT WHERE PATIENT_ID = a.PATIENT_ID)  PATIENT_NAME, a.OPER_CODE OPER_CODE,a. OPER_DESC OPER_DESC ,a. SPECIALITY_CODE  SPECIALITY_CODE, a. SPECIALITY_DESC  SPECIALITY_DESC,a. SURGEON_CODE  SURGEON_CODE,a. SURGEON_NAME  SURGEON_NAME,a. OPER_STATUS  OPER_STATUS, a.OPER_NUM OPER_NUM, a.STATUS_DESC STATUS_DESC, a.COLOR_IND COLOR_IND,  a.TEXT_COLOR TEXT_COLOR, NVL(a.NURSING_DOC_COMP_YN,'N') NURSING_DOC_COMP_YN,  NVL(a.SURGEON_DOC_COMP_YN,'N') SURGEON_DOC_COMP_YN,NVL(b.PROC_CHRG_CMP_YN,'N') PROC_CHRG_CMP_YN,NVL(b.IMPLANT_ENTRY_CMP_YN,'N') IMPLANT_ENTRY_CMP_YN,NVL(b.CONSUMABLE_ENTRY_CMP_YN,'N') CONSUMABLE_ENTRY_CMP_YN,NVL(b.EQUIPMENT_ENTRY_CMP_YN,'N') EQUIPMENT_ENTRY_CMP_YN,NVL(b.INSTRUMENT_ENTRY_CMP_YN,'N') INSTRUMENT_ENTRY_CMP_YN, a.OPER_ROOM_CODE OPER_ROOM_CODE ,(SELECT g.short_desc FROM ot_oper_room_lang_vw g WHERE g.operating_facility_id = a.operating_facility_id AND g.oper_room_code = a.oper_room_code AND g.language_id = c.language_id) oper_room_desc, c.SHORT_DESC NAT_SHORT_DESC,NVL(a.ANAESTHESIA_DOC_COMP_YN,'N') ANAESTHESIA_DOC_COMP_YN, a.asa_score_code FROM OT_UNSCHD_OPERS_VW a, ot_post_oper_hdr b, OT_NATURE_OF_SURGERY_LANG_VW c WHERE C.LANGUAGE_ID = '"+locale+"' AND a.OPERATING_FACILITY_ID='"+login_facility_id+"' AND a.OPERATING_FACILITY_ID=b.OPERATING_FACILITY_ID AND a.OPER_NUM   = b.OPER_NUM AND  b.NATURE_CODE  = c.NATURE_CODE AND NVL(a.OPER_ROOM_CODE,'X')=NVL('"+theatre_from+"',NVL(a.OPER_ROOM_CODE,'X')) AND ((NVL( '"+theatre_type+"','X') = 'X') OR (A.OPER_ROOM_CODE IN (SELECT OPER_ROOM_CODE FROM OT_OPER_ROOM WHERE THEATRE_TYPE =  '"+theatre_type+"'))) AND   a.OPER_DATE BETWEEN to_date('"+theatre_date_from+"','dd/mm/yyyy') AND to_date('"+theatre_date+"','dd/mm/yyyy') AND upper(C.NATURE_TYPE ) = DECODE('"+elec_emer+"','EL','EL','EM','EM','A',C.NATURE_TYPE) AND (NVL( '"+speciality+"','X') = 'X' OR (NVL(a.SPECIALITY_CODE,'X') = NVL( '"+speciality+"','X'))) AND NVL(a.SURGEON_CODE,'X')=NVL('"+surgeon+"',NVL(a.SURGEON_CODE,'X')) AND NVL(a.PATIENT_ID,'X')=NVL('"+patient_id+"',NVL(a.PATIENT_ID,'X')) AND (('"+doc_status+"' = 0) OR  ('"+doc_status+"' = 1 and A.OPER_STATUS IN ('"+status+"'))) AND A.LANGUAGE_ID='"+locale+"' ORDER BY OP_DATE DESC ";//MO-CRF-20082
			pstmt		= connection.prepareStatement(sql_unsch_cases);
			resultSet	= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				index++;
				unscheduled_case_details = new HashMap();
				unscheduled_case_details.put("oper_date",resultSet.getString("OPER_DATE"));
				unscheduled_case_details.put("order_id",resultSet.getString("ORDER_ID"));
				unscheduled_case_details.put("patient_id",resultSet.getString("PATIENT_ID"));
				unscheduled_case_details.put("patient_name",resultSet.getString("PATIENT_NAME"));
				unscheduled_case_details.put("oper_code",resultSet.getString("OPER_CODE"));
				unscheduled_case_details.put("oper_desc",resultSet.getString("OPER_DESC"));
				unscheduled_case_details.put("speciality_code",resultSet.getString("SPECIALITY_CODE"));
				unscheduled_case_details.put("speciality_desc",resultSet.getString("SPECIALITY_DESC"));
				unscheduled_case_details.put("surgeon_code",resultSet.getString("SURGEON_CODE"));
				unscheduled_case_details.put("surgeon_name",resultSet.getString("SURGEON_NAME"));
				unscheduled_case_details.put("oper_status",resultSet.getString("OPER_STATUS"));
				unscheduled_case_details.put("oper_num",resultSet.getString("OPER_NUM"));
				unscheduled_case_details.put("status_desc",resultSet.getString("STATUS_DESC"));
				unscheduled_case_details.put("color_ind",resultSet.getString("COLOR_IND"));
				unscheduled_case_details.put("text_color",resultSet.getString("TEXT_COLOR"));
				unscheduled_case_details.put("nursing_doc_comp_yn",resultSet.getString("NURSING_DOC_COMP_YN"));
				unscheduled_case_details.put("surgeon_doc_comp_yn",resultSet.getString("SURGEON_DOC_COMP_YN"));
				unscheduled_case_details.put("proc_chrg_cmp_yn",resultSet.getString("PROC_CHRG_CMP_YN"));
				unscheduled_case_details.put("implant_entry_cmp_yn",resultSet.getString("IMPLANT_ENTRY_CMP_YN"));
				unscheduled_case_details.put("consumable_entry_cmp_yn",resultSet.getString("CONSUMABLE_ENTRY_CMP_YN"));
				unscheduled_case_details.put("equipment_entry_cmp_yn",resultSet.getString("EQUIPMENT_ENTRY_CMP_YN"));
				unscheduled_case_details.put("instrument_entry_cmp_yn",resultSet.getString("INSTRUMENT_ENTRY_CMP_YN"));
				unscheduled_case_details.put("oper_room_code",resultSet.getString("OPER_ROOM_CODE"));
				unscheduled_case_details.put("oper_room_desc",resultSet.getString("OPER_ROOM_DESC"));
				unscheduled_case_details.put("nature_short_desc",resultSet.getString("NAT_SHORT_DESC"));
				unscheduled_case_details.put("anaesthesia_doc_comp_yn",resultSet.getString("ANAESTHESIA_DOC_COMP_YN"));
				unscheduled_case_details.put("encounter_id",resultSet.getString("ENCOUNTER_ID"));// newly included by rajesh for CRF -0311
				unscheduled_case_details.put("asa_score_code",resultSet.getString("asa_score_code"));
				unscheduled_case_details.put("patient_id",resultSet.getString("PATIENT_ID"));//MO-CRF-20082

				if(resultSet.getString("OPER_NUM")!=null){
				/*	pstmt1	= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SLATE_STATUS_TIMES1")) ;
					pstmt1.setString(1,locale);
					pstmt1.setString(2,login_facility_id);
					pstmt1.setString(3,resultSet.getString("OPER_NUM"));
					resultSet1			= pstmt1.executeQuery();
					if(resultSet1!=null && resultSet1.next()){
						unscheduled_case_details.put("check_in_time",checkForNull(resultSet1.getString("CHECK_IN_TIME")));
						unscheduled_case_details.put("cancellation_date_time",resultSet1.getString("CANCELLATION_DATE_TIME"));
						unscheduled_case_details.put("cancelled_by",resultSet1.getString("CANCELLED_BY"));
						unscheduled_case_details.put("cancel_reason",resultSet1.getString("CANCEL_REASON"));
						unscheduled_case_details.put("check_into_holding_area_time",checkForNull(resultSet1.getString("CHECK_INTO_HOLDING_AREA_TIME")));
						unscheduled_case_details.put("check_into_or_time",checkForNull(resultSet1.getString("CHECK_INTO_OR_TIME")));
						unscheduled_case_details.put("nursing_doc_comp_time",checkForNull(resultSet1.getString("NURSING_DOC_COMP_TIME")));
						unscheduled_case_details.put("surgeon_doc_comp_time",checkForNull(resultSet1.getString("SURGEON_DOC_COMP_TIME")));
						unscheduled_case_details.put("anaesthetist_doc_comp_time",checkForNull(resultSet1.getString("ANAESTHETIST_DOC_COMP_TIME")));
						unscheduled_case_details.put("recovery_start_time",checkForNull(resultSet1.getString("RECOVERY_START_TIME")));
						unscheduled_case_details.put("recovery_end_time",checkForNull(resultSet1.getString("RECOVERY_END_TIME")));
						unscheduled_case_details.put("check_out_time",checkForNull(resultSet1.getString("CHECK_OUT_TIME")));
						unscheduled_case_details.put("holding_area_code",checkForNull(resultSet1.getString("HOLDING_AREA_CODE")));
					}*/
				}
				all_unscheduled_case_details.put(index+"",unscheduled_case_details);
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
                closeResultSet( resultSet1 ) ;
                closeResultSet( resultSet ) ;
                closeStatement( pstmt1 ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		if(index==0)
			return false;
		return true;
	}
	public HashMap getUnScheduledCases(){
		if(all_unscheduled_case_details==null)
			all_unscheduled_case_details=new HashMap();
		return this.all_unscheduled_case_details;
	}

	public ArrayList getMenuList(String oper_status, String role_id, String slate_waitlist_flag, String sch_unsch_flag){
		ArrayList result = new ArrayList();
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		String function_id="";
		try{
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
			connection			= getConnection() ;
			if(slate_waitlist_flag.equals("SLATE")){
				pstmt	= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SLATE_SELECT9"));
				pstmt.setString(1,locale);
				pstmt.setString(2,oper_status);
				pstmt.setString(3,role_id);
			}else if(slate_waitlist_flag.equals("WAITLIST")){
				pstmt	= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SLATE_SELECT12"));
				pstmt.setString(1,locale);
			}
			resultSet	= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				function_id = resultSet.getString("FUNCTION_ID");
					if(sch_unsch_flag.equals("UNSCHEDULED") && function_id.equals("17")){
						// do not include this function_id for unscheduled cases.
					}else{
						result.add(function_id);
						result.add(resultSet.getString("FUNCTION_DESC_USER"));
						result.add(resultSet.getString("URL_DESC"));
				}
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){}
        }
		return result;
	}
	public ArrayList validateUserPwd(String user_id,String password,String function_id){
		// this method does 2 validations:
		// 1 to check the valid user_id/pwd
		// 2 to check whether it exists in the user_functions by calling checkUserFunctions
		ArrayList result		= new ArrayList();
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		String valid_pwd		= "";
		
//----------------------------------- MMS-ME-SCF-0051 start
		String decrypted_password="";
			 System.err.println(" Encrypt password checker 732============="+password);
			 try {
			System.err.println("72=============");//Base64.encodeToString(mStringToEncode.getBytes(), Base64.NO_WRAP)
			String initVector="5D9r9ZVzEYYgha93/aUK2w==";
			byte[] IvkeyBytes = initVector.getBytes("UTF-8");
			IvParameterSpec ivSpec = new IvParameterSpec(Base64.decodeBase64(IvkeyBytes));
				 								System.err.println("73=============");
			String initVector1="u/Gu5posvwDsXUnV5Zaq4g==";
			byte[] IvkeyBytes1 = initVector1.getBytes("UTF-8");
            SecretKeySpec newKey = new SecretKeySpec(Base64.decodeBase64(IvkeyBytes1), "AES");
			 									System.err.println("74=============");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			 									System.err.println("77=============");
            cipher.init(Cipher.DECRYPT_MODE, newKey, ivSpec);		
 												System.err.println("79=============");			
			decrypted_password = new String(cipher.doFinal(Base64.decodeBase64(password.getBytes("UTF-8"))), "UTF-8");
			System.err.println("============"+decrypted_password);
			} 
			catch (Exception e ) {
			System.err.println("Exception occured while Decryption the Password============"+e);
            e.printStackTrace();
        }
		finally {
			System.err.println("85,decrypted_password============"+decrypted_password);
			}
			
//----------------------------------- MMS-ME-SCF-0051 end
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SLATE_SELECT10")) ;
			pstmt.setString(1,user_id);
			//pstmt.setString(2,password);
			resultSet	= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				valid_pwd = resultSet.getString("PWD");
			}
			valid_pwd=valid_pwd==null?"":valid_pwd;
			valid_pwd=valid_pwd.equalsIgnoreCase("null")?"":valid_pwd;
			valid_pwd=valid_pwd.equals("")?"":valid_pwd;

			if(valid_pwd.equalsIgnoreCase(decrypted_password)) // MMS-ME-SCF-0051
				result.add("Y");
			else
				result.add("N");
			result.add(checkAuthUserForFunction(user_id,function_id)); //check authorization for user/function
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){}
        }
		return result;
	}

	public String checkAuthUserForFunction(String user_id,String function_id){
		// this method does 2 validations:
		// 1 to check the valid user_id/pwd
		// 2 to check whether it exists in the user_functions by calling checkUserFunctions
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		String valid_user		= "N";
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SLATE_SELECT11")) ;
			pstmt.setString(1,user_id);
			pstmt.setString(2,function_id);
			resultSet	= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				valid_user = resultSet.getString("VALID_USER");
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){}
        }
		return valid_user;
	}
	public String updateStatusAndCommit(String function_id,String appt_ref_num, String oper_num,String slate_user_id,String waitlist_flag,String order_id,String waitlist_num,String theatre){
		String error_text = "";
		String status = "";
		Connection connection  = null ;
		CallableStatement cstmt= null ;
		int index=1;
		try{
			if(waitlist_flag!=null && !waitlist_flag.equals("Y"))
				waitlist_flag="";
			if(order_id!=null && order_id.equals("null"))
				order_id="";
			if(waitlist_num!=null && waitlist_num.equals("null"))
				waitlist_num="";
			connection	= getConnection() ;
//			cstmt=connection.prepareCall("{call OT_UPDATE_STATUS(?,?,?,null,null,null,?,?,?,?,?,null,null,?,?,?,?)}");
			cstmt=connection.prepareCall("{call OT_UPDATE_OPER_DTLS(?,?,?,null,null,null,?,?,?,?,?,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,?,?,?,?,?)}");
			cstmt.setString( index++, function_id);		 // function_id
			cstmt.setString( index++, login_facility_id);// operating_facility_id
			cstmt.setString( index++, appt_ref_num);	 // booking_num			
			cstmt.setString( index++, "N");				 // DOC_COMPL_YN for Recovery
			cstmt.setString( index++, waitlist_num);	 // ADDNL_FLD1 , waitlist_num
			cstmt.setString( index++, waitlist_flag);	 // ADDNL_FLD2 is WAITLIST_FLAG(only for SLATE_WAITLIST Tab
			cstmt.setString( index++, order_id);		 // ADDNL_FLD3 for Order_id(only for SLATE_WAITLIST Tab
			cstmt.setString( index++, theatre);			 // ADDNL_FLD4 for Order_id(only for SLATE_WAITLIST Tab
			cstmt.setString( index++, slate_user_id);	 // USER_ID , Slate login_id 
			cstmt.setString( index++, login_at_ws_no);	 // WS_NO
			cstmt.registerOutParameter( index++, Types.VARCHAR );	  // STATUS-> 'E' for Error and 'S' for Success
			cstmt.registerOutParameter( index++, Types.VARCHAR );  // ERROR_TEXT
			cstmt.registerOutParameter( index, Types.VARCHAR );  // LANG_ERROR_TEXT
			cstmt.execute() ;
			connection.commit();
			status = cstmt.getString(index-2);
			if(status.equals("E")){
				error_text = cstmt.getString(index-1);
				error_text = cstmt.getString(index);
			}else
				error_text = "RECORD_INSERTED";
		}catch ( Exception e ) {
	        e.printStackTrace() ;
		}finally {
            try{
                closeStatement( cstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		return error_text;
	}

// Barcode methiods Start from here
	public ArrayList getBarcodeMenuList(){
		ArrayList result = new ArrayList();
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		try{
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
			connection	= getConnection() ;
			pstmt		= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_BARCODE_SELECT1")) ;
			pstmt.setString(1,locale);
			resultSet	= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				result.add(resultSet.getString("FUNCTION_ID"));
				result.add(resultSet.getString("FUNCTION_DESC_USER"));
				result.add(resultSet.getString("URL_DESC"));
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){}
        }
		return result;
	}

// End of Barcode methods

// Start of WaitList methods
	public boolean loadWaitlistDetails(String preferred_date,String speciality,String surgeon){
		HashMap waitlist_details = null;
			all_waitlist_details = new HashMap();

		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		int index	= 0;
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SLATE_WAITLIST_SELECT12")) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,preferred_date);
			pstmt.setString(3,speciality);
			pstmt.setString(4,surgeon);
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				index++;
				waitlist_details = new HashMap();
				waitlist_details.put("order_id",resultSet.getString("ORDER_ID"));
				waitlist_details.put("patient_id",resultSet.getString("PATIENT_ID"));
				waitlist_details.put("patient_name",resultSet.getString("PATIENT_NAME"));
				waitlist_details.put("surgery_type",resultSet.getString("SURGERY_TYPE"));
				waitlist_details.put("speciality_code",resultSet.getString("SPECIALITY_CODE"));
				waitlist_details.put("speciality_desc",resultSet.getString("SPECIALITY_DESC"));
				waitlist_details.put("surgeon_code",resultSet.getString("SURGEON_CODE"));
				waitlist_details.put("surgeon_name",resultSet.getString("SURGEON_NAME"));
				waitlist_details.put("preferred_date",resultSet.getString("PREFERRED_DATE"));
				waitlist_details.put("waitlist_num",resultSet.getString("WAITLIST_NUM"));		
				waitlist_details.put("oper_desc",resultSet.getString("OPER_DESC"));	
				waitlist_details.put("multiple_opers_yn",resultSet.getString("MULTIPLE_OPERS_YN"));	
				
				all_waitlist_details.put(index+"",waitlist_details);				
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		if(index==0)
			return false;
		return true;
	}
	public HashMap getWaitlistDetails(){
		if(all_waitlist_details==null)
			all_waitlist_details=new HashMap();
		return this.all_waitlist_details;
	}

// End of Waitlist methods

// Start of ReSchedule methods
	public boolean loadReScheduleDetails(String booking_date,String theatre, String speciality,String surgeon,String view_status){
		HashMap reschedule_details = null;
			all_reschedule_details = new HashMap();

		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		int index	= 0;
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SLATE_RESCHEDULE_SELECT13")) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,booking_date+" 00:00");
			pstmt.setString(3,booking_date+" 23:59");
			pstmt.setString(4,theatre);
			pstmt.setString(5,speciality);
			pstmt.setString(6,surgeon);
			if(view_status.equals("P")){
				pstmt.setString(7,"0");
				pstmt.setString(8,"0");
			}else if(view_status.equals("C")){
				pstmt.setString(7,"9");
				pstmt.setString(8,"9");
			}else if(view_status.equals("B")){
				pstmt.setString(7,"0");
				pstmt.setString(8,"9");
			}
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				index++;
				reschedule_details = new HashMap();
				reschedule_details.put("order_id",resultSet.getString("ORDER_ID"));
				reschedule_details.put("patient_id",resultSet.getString("PATIENT_ID"));
				reschedule_details.put("patient_name",resultSet.getString("PATIENT_NAME"));
				reschedule_details.put("oper_room_desc",resultSet.getString("OPER_ROOM_DESC"));
				reschedule_details.put("surgeon_code",resultSet.getString("SURGEON_CODE"));
				reschedule_details.put("surgeon_name",resultSet.getString("SURGEON_NAME"));
				reschedule_details.put("speciality_code",resultSet.getString("SPECIALITY_CODE"));
				reschedule_details.put("speciality_desc",resultSet.getString("SPECIALITY_DESC"));
				reschedule_details.put("oper_desc",resultSet.getString("OPER_DESC"));
				reschedule_details.put("appt_ref_num",resultSet.getString("APPT_REF_NUM"));
				reschedule_details.put("date_of_birth",resultSet.getString("DATE_OF_BIRTH"));
				reschedule_details.put("sex",resultSet.getString("SEX"));
				reschedule_details.put("oper_code",resultSet.getString("OPER_CODE"));
				reschedule_details.put("oper_room_code",resultSet.getString("OPER_ROOM_CODE"));
				all_reschedule_details.put(index+"",reschedule_details);				
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		if(index==0)
			return false;
		return true;
	}
	public HashMap getReScheduleDetails(){
		if(all_reschedule_details==null)
			all_reschedule_details=new HashMap();
		return this.all_reschedule_details;
	}

// End of Waitlist methods

	public ArrayList getWaitListMultipleOperations(String waitlist_num){
		ArrayList result = new ArrayList();
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		try{
			p=getProperties();
			locale	= (String) p.getProperty("LOCALE");
			connection	= getConnection() ;
			pstmt		= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SLATE_SELECT13")) ;
			pstmt.setString(1,locale);
			pstmt.setString(2,waitlist_num);
			resultSet	= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				result.add(resultSet.getString("OPER_DESC"));
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){}
        }
		return result;
	}

	public ArrayList getQueryResultPagproceduree(HashMap sqlMap, HashMap funcMap, HttpServletRequest req, boolean lookup  ) throws Exception {
        return getQueryResultPage2( sqlMap, funcMap, req, lookup, Integer.parseInt( (String)CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE") ) );
    }
	/* Commented by bshankar on 11/Sep/2006. Checked and found that, this procedure is not used anywhere.
	public ArrayList getQueryResultPage1 (HashMap sqlMap, HashMap funcMap,HttpServletRequest req,int query_result_size ) throws Exception {
        return getQueryResultPage2( sqlMap, funcMap, req, false, query_result_size );
    }
	*/
	private void setOrderby(String ord[]) {
        if ( !(ord == null || ord .equals("")) ) {
            orderBy=" order by ";
            for ( int i=0;i < ord.length;i++ ) {
                if ( i == ord.length - 1 ) {
                    orderBy += ord[i];
                } else {
                    orderBy += ord[i]+",";
                }
            }//for
        }//outer if
    }//method
public  ArrayList getQueryResultPage2 (HashMap sqlMap, HashMap funcMap, HttpServletRequest req, boolean lookup, int query_result_size ) throws Exception {
        Connection connection       = null;
        String[] orderbycolumns     = req.getParameterValues("orderbycolumns") ;
        if(orderbycolumns == null)  orderbycolumns = new String[0] ;
        if( !lookup && orderbycolumns.length>0 ) setOrderby(orderbycolumns);
        String from                 = req.getParameter( "from" ) ;
        String to                   = req.getParameter( "to" ) ;
        ArrayList displayFields     = (ArrayList)funcMap.get( "displayFields" ) ;
        ArrayList chkFields         = (ArrayList)funcMap.get( "chkFields" ) ;
        String searchCriteria       = checkForNull( (String)funcMap.get( "searchCriteria" )) ;
        String sqlData              = (String)sqlMap.get( "sqlData" );
        ArrayList error             = new ArrayList();
        String prevnextlink         = "";
        //int query_result_size       = Integer.parseInt( (String)CommonRepository.getCommonKeyValue("QUERY_RESULT_SIZE") );

        StringBuffer msgsb = new StringBuffer();
        int start = 0 ;
        int end = 0 ;

        if ( from == null )
            start = 1 ;
        else
            start = Integer.parseInt( from  ) ;

        if ( to == null )
            end =query_result_size;
        else
            end = Integer.parseInt( to ) ;

        PreparedStatement pstmtCount  =null;
        PreparedStatement pstmtData = null;
        ResultSet rs=null;
        //int maxRecord = 0; //Common-ICN-0055
        ArrayList result = new ArrayList();
        result.clear();
        result.add("total");
        result.add("prevnext");
        try {
            HttpSession session = req.getSession(false) ;
            setProperties((java.util.Properties)session.getAttribute("jdbc")) ;

            connection=getConnection();
            int fldkey=1;
            try {
                msgsb.append( " SQL : "+sqlData );
                msgsb.append( " Connection : " + connection );
                if( !lookup && orderbycolumns.length>0 )
                    pstmtData = connection.prepareStatement( sqlData + orderBy );
                else
                    pstmtData = connection.prepareStatement( sqlData );
                msgsb.append( " PreparedStatement : " + pstmtData);

                for(int fldcount=0; fldcount<chkFields.size(); fldcount++) {
                    Object fldValue = chkFields.get(fldcount) ;
                    if( fldValue instanceof String ) {
                        if( !lookup )
                          pstmtData.setString( fldkey, ((String) chkFields.get(fldcount))) ;
                        else {
                            if( searchCriteria.equals( "S" ) )
                                pstmtData.setString( fldkey, ((String) chkFields.get(fldcount))+"%" ) ;
                            else if( searchCriteria.equals( "E" ) )
                                pstmtData.setString( fldkey, "%"+((String) chkFields.get(fldcount)) ) ;
                            else if( searchCriteria.equals( "C" ) )
                                pstmtData.setString( fldkey, "%"+((String) chkFields.get(fldcount))+"%" ) ;
                            else
                                pstmtData.setString( fldkey, ((String) chkFields.get(fldcount))+"%" ) ;
                        }
                    }
                    else if ( fldValue instanceof Integer )
                        pstmtData.setInt( fldkey, ((Integer)fldValue).intValue() ) ;
                    else if ( fldValue instanceof Long )
                        pstmtData.setLong( fldkey, ((Long)fldValue).longValue() ) ;
                    else if ( fldValue instanceof Float )
                        pstmtData.setFloat( fldkey, ((Float)fldValue).floatValue() ) ;
                    else if ( fldValue instanceof Double )
                        pstmtData.setDouble( fldkey, ((Double)fldValue).doubleValue() ) ;
                    fldkey++;
                }//for
                rs = null;
                rs = pstmtData.executeQuery();
                msgsb.append( "ResultSet : " + rs);
                long count = 0;
                long i = 0;

                if( rs != null ) {
                    while( rs.next() && i <= end+1 ) {
                        if( start != 1 && (i+1) < start ) {
                            i++;
                            continue;
                        }
                        else i++;
                        count++ ;
                        if(i <= end ) {
                            ArrayList records=new ArrayList();
                            records.clear();
                            for( int dispfldCount=0;  dispfldCount<displayFields.size();  dispfldCount++ )
                                records.add(rs.getString((String)displayFields.get( dispfldCount )));
                            result.add(records);
                        }
                    }
                    result.set( 0, String.valueOf( count ) ) ;
                    if( start != 1 )
                        prevnextlink += "<td align=\"right\"><a href=\"javascript:SubmitLink("+(start-query_result_size)+","+(end-query_result_size)+");\">Previous</A>" ;
                    if( count > query_result_size )
                        prevnextlink += "&nbsp;&nbsp;<td align=\"right\"><a href=\"javascript:SubmitLink("+(start+query_result_size)+","+(end+query_result_size)+");\">Next</A>" ;
                    result.set( 1, prevnextlink ) ;
                }

            }catch(Exception ed) {
                error.add("Exception from sqlData :" +ed.getMessage()+msgsb.toString() );
                result.add(error);
            }
        } catch(Exception ex) {
                error.add(ex.getMessage());
                result.add(error);
        } finally {
            try{
                if( rs != null ) closeResultSet( rs ) ;
                if( pstmtData != null ) closeStatement( pstmtData ) ;
                if( pstmtCount != null ) closeStatement( pstmtCount ) ;
                if ( connection != null ) closeConnection( connection ) ;
            } catch(Exception e) {
                error.add(e.getMessage());
                result.add(error);
            }
        }
        return result;
    }



	public ArrayList getScheduledMultipleOperations(String call_from,String booking_num,String oper_num){
		ArrayList result = new ArrayList();
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		try{
			p=getProperties();			
			locale	= (String) p.getProperty("LOCALE");
			connection	= getConnection() ;	//Added Against Common-ICN-0031
			if(call_from.equals("scheduled_cases")){
			if(oper_num.equals("")){
				//connection	= getConnection() ;	//Commented Against Common-ICN-0031
				pstmt		= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SLATE_SELECT14")) ;
				pstmt.setString(1,locale);
			//	pstmt.setString(2,locale);
				pstmt.setString(2,booking_num);
				//Added for incident 27032 by Anitha on 4/8/2011
				pstmt.setString(3,login_facility_id);
				resultSet	= pstmt.executeQuery();
				while(resultSet!=null && resultSet.next()){
					result.add(resultSet.getString("OPER_DESC"));
				}
			}
			else{
				//connection	= getConnection() ;	//Commented Against Common-ICN-0031
				pstmt		= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SLATE_SELECT16")) ;
				pstmt.setString(1,locale);
				pstmt.setString(2,oper_num);
				resultSet	= pstmt.executeQuery();
				while(resultSet!=null && resultSet.next()){
					result.add(resultSet.getString("OPER_DESC"));
				}
			}
			}
			else if(call_from.equals("un_scheduled_cases")){
				//connection	= getConnection() ;	//Commented Against Common-ICN-0031
				pstmt		= connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SLATE_SELECT16")) ;
				pstmt.setString(1,locale);
				pstmt.setString(2,oper_num);
				resultSet	= pstmt.executeQuery();
				while(resultSet!=null && resultSet.next()){
					result.add(resultSet.getString("OPER_DESC"));
				}

			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){}
        }
		return result;
	}

	public ArrayList getOperationOrderStatusText(String appt_ref_num){
		ArrayList result		= new ArrayList();
		Connection connection   = null ;
        CallableStatement cstmt = null ;
		String status			= "S" ;
		String order_status_type = "";
		String status_desc		= "" ;
		String status_indicator = "" ;
		String lang_error_text = "";
		String result_text = "";
		try{
			connection	= getConnection() ;
			cstmt=connection.prepareCall("{call OT_GET_SLATE_ORDER_STATUS(?,?,?,?,?,?,?,null,?,?)}");
			cstmt.setString( 1, login_facility_id);
			cstmt.setString( 2, appt_ref_num);

			cstmt.registerOutParameter( 3, Types.VARCHAR );	  // ORDER_STATUS_TYPE
			cstmt.registerOutParameter( 4, Types.VARCHAR );	  // STATUS DESC
			cstmt.registerOutParameter( 5, Types.VARCHAR );	  // V_STATUS_INDICATOR			
			cstmt.registerOutParameter( 6, Types.VARCHAR );	  // STATUS-> 'E' for Error and 'S' for Success
			cstmt.registerOutParameter( 7, Types.VARCHAR );  // ERROR_TEXT
			cstmt.registerOutParameter( 8, Types.VARCHAR );  // ADD FIELD
			cstmt.registerOutParameter( 9, Types.VARCHAR );  // LANG_ERROR_TEXT
			cstmt.execute() ;
			order_status_type	= cstmt.getString(3);
			status_desc			= cstmt.getString(4);
			status_indicator	= cstmt.getString(5);
			status				= cstmt.getString(6);
			result_text				= cstmt.getString(8);
			lang_error_text		= cstmt.getString(9);


			if(status.equals("E")){

			}
		}catch ( Exception e ) {
			status="E";
			order_status_type = "";
			status_indicator  = "*";
            e.printStackTrace() ;
		}finally {
            try{
                closeStatement( cstmt ) ;
                closeConnection( connection );
             }catch(Exception es){}
        }
		result.add(status);
		result.add(order_status_type);
		result.add(status_desc);
		result.add(status_indicator);
		result.add(result_text);
		return result;
	}

	/**
		@author: subramanian
		@comment This function compare the passing date with sysdate to show the menu in OT-SLATE.
		if it is passing date is greater than current date menu is disabled otherwise menu is shown
		@Param theatre_date
		@returns Y OR N
	*/
	public String isMenuShown(String theatre_date){
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		String flag 	= "";
		String sql  = "select decode(SIGN(to_date('"+theatre_date+"','DD/MM/YYYY')-TRUNC(SYSDATE)),1,'Y','N') FROM DUAL";
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(sql) ;
			resultSet			= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				flag = resultSet.getString(1);
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		return flag;
	}

	public String getSlateStatusTimes(String called_from, HashMap slate_details, String reschedule_count){
		// This procedure is created by bshankar on 31/07/2006. 
		// Moved the code from SchSearchResults and UnSchSearchResults and written the common code here
		StringBuffer status_times  = new StringBuffer();
		String cancelled_date_time = "";
		if(called_from.equals("SCH")){
			status_times.append("<B>");
			status_times.append("Case call Time: ");
			status_times.append("</B>");
			status_times.append(checkForNull(DateUtils.convertDate((String)slate_details.get("case_called_time"),"DMYHM","en",locale)));
			status_times.append(",");
			status_times.append("<B>");
			status_times.append("Ward Checkout Time: ");
			status_times.append("</B>");
			status_times.append(checkForNull(DateUtils.convertDate((String)slate_details.get("check_out_from_ward_time"),"DMYHM","en",locale)));
			status_times.append(",");
		}
		status_times.append("<B>");
		status_times.append("Check-In Time: ");
		status_times.append("</B>");
		//status_times.append(checkForNull((String)slate_details.get("check_in_time")));
		status_times.append(checkForNull(DateUtils.convertDate((String)slate_details.get("check_in_time"),"DMYHM","en",locale)));
		//cancelled_date_time = checkForNull((String)slate_details.get("cancellation_date_time"));
		status_times.append(checkForNull(DateUtils.convertDate((String)slate_details.get("cancellation_date_time"),"DMYHM","en",locale)));
		if(!cancelled_date_time.equals("")){
			status_times.append(",");
			status_times.append("<B>");
			status_times.append("Cancelled By: ");
			status_times.append("</B>");
			status_times.append(checkForNull((String)slate_details.get("cancelled_by")));

			status_times.append(",");
			status_times.append("<B>");
			status_times.append("Cancelled Date/Time: ");
			status_times.append("</B>");
			status_times.append(cancelled_date_time);				

			status_times.append(",");
			status_times.append("<B>");
			status_times.append("Cancelled Reason: ");
			status_times.append("</B>");
			status_times.append(checkForNull((String)slate_details.get("cancel_reason")));
		}else{
			// Below lines are not applicable if the Booking is Cancelled.
			status_times.append(",");
			status_times.append("<B>");
			status_times.append("Holding Area Time: ");
			status_times.append("</B>");
			//status_times.append(checkForNull((String)slate_details.get("check_into_holding_area_time"))+"( "+checkForNull((String)slate_details.get("holding_area_code"))+" )");
			status_times.append(checkForNull(DateUtils.convertDate((String)slate_details.get("check_into_holding_area_time"),"DMYHM","en",locale)));
			status_times.append(",");
			status_times.append("<B>");
			status_times.append("Check-In to OR Time: ");
			status_times.append("</B>");
			//status_times.append(checkForNull((String)slate_details.get("check_into_or_time")));
			status_times.append(checkForNull(DateUtils.convertDate((String)slate_details.get("check_into_or_time"),"DMYHM","en",locale)));
			status_times.append(",");
			status_times.append("<B>");
			status_times.append("Nursing Documentation Completed Time: ");
			status_times.append("</B>");
			//status_times.append(checkForNull((String)slate_details.get("nursing_doc_comp_time")));
			status_times.append(checkForNull(DateUtils.convertDate((String)slate_details.get("nursing_doc_comp_time"),"DMYHM","en",locale)));
			status_times.append(",");
			status_times.append("<B>");
			status_times.append("Surgeon Documentation Completed Time: ");
			status_times.append("</B>");
			//status_times.append(checkForNull((String)slate_details.get("surgeon_doc_comp_time")));
			status_times.append(checkForNull(DateUtils.convertDate((String)slate_details.get("surgeon_doc_comp_time"),"DMYHM","en",locale)));
			status_times.append(",");
			status_times.append("<B>");
			status_times.append("Anaesthetist Documentation Completed Time: ");
			status_times.append("</B>");
			//status_times.append(checkForNull((String)slate_details.get("anaesthetist_doc_comp_time")));
			status_times.append(checkForNull(DateUtils.convertDate((String)slate_details.get("anaesthetist_doc_comp_time"),"DMYHM","en",locale)));
			status_times.append(",");
			status_times.append("<B>");
			status_times.append("Recovery Start Time: ");
			status_times.append("</B>");
			//status_times.append(checkForNull((String)slate_details.get("recovery_start_time")));
			status_times.append(checkForNull(DateUtils.convertDate((String)slate_details.get("recovery_start_time"),"DMYHM","en",locale)));
			status_times.append(",");
			status_times.append("<B>");
			status_times.append("Recovery End Time: ");
			status_times.append("</B>");
			//status_times.append(checkForNull((String)slate_details.get("recovery_end_time")));
			status_times.append(checkForNull(DateUtils.convertDate((String)slate_details.get("recovery_end_time"),"DMYHM","en",locale)));
			status_times.append(",");
			status_times.append("<B>");
			status_times.append("Check Out Time : ");
		    status_times.append("</B>");
			//status_times.append(checkForNull((String)slate_details.get("recovery_end_time")));
			status_times.append(checkForNull(DateUtils.convertDate((String)slate_details.get("check_out_time"),"DMYHM","en",locale)));
		}
		if(called_from.equals("SCH")){
			if(Integer.parseInt(reschedule_count)>0)
			{
				status_times.append(",");
				status_times.append("<B>");
				status_times.append("Reschedule Count: ");
				status_times.append("</B>");
				status_times.append(checkForNull((String)slate_details.get("reschedule_count")));
			}
		}
		return status_times.toString();
	}
	private String getPreviousDate(String sysdate)
	{
		try
		{
			Date todayObj = DateUtil.convertStringToDate("dd/MM/yyyy", sysdate);
			Calendar calendar = Calendar.getInstance();
		    calendar.setTime(todayObj);
	        calendar.add(Calendar.DAY_OF_YEAR, -1);
	        Date previousDate = calendar.getTime();
	        if (previousDate != null) {
	        	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				String returnValue = df.format(previousDate);
				return returnValue;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sysdate;
	}
//AAKH-CRF-0064 Starts
	public HashMap getSurgeonName(String userid,String facilitid,String language)
	{
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
        HashMap SurgeonName=null;
		try
		{
			StringBuffer SurgeonNameQuery=new StringBuffer();
			SurgeonName=new HashMap();
			connection			= getConnection() ;
			SurgeonNameQuery.append("	SELECT   short_name description, practitioner_id code	");
			SurgeonNameQuery.append("	FROM am_practitioner_lang_vw	");
			SurgeonNameQuery.append("	WHERE language_id = ?	");
			SurgeonNameQuery.append("	AND pract_type IN (SELECT pract_type	");
			SurgeonNameQuery.append("	FROM ot_pract_types_for_role_type	");
			SurgeonNameQuery.append("	WHERE role_type = 'OS')	");
			SurgeonNameQuery.append("	AND NVL (eff_status, 'X') <> 'S'	");
			SurgeonNameQuery.append("	AND EXISTS (	");
			SurgeonNameQuery.append("	SELECT *	");
			SurgeonNameQuery.append("	FROM ot_roles	");
			SurgeonNameQuery.append("	WHERE role_id IN (	");
			SurgeonNameQuery.append("	SELECT role_id	");
			SurgeonNameQuery.append("	FROM ot_roles_for_users	");
			SurgeonNameQuery.append("	WHERE appl_user_id = ?	");
			SurgeonNameQuery.append("	AND is_default = 'Y')	");
			SurgeonNameQuery.append("	AND role_type = 'OS')	");
			SurgeonNameQuery.append("	AND EXISTS(SELECT DEF_USER_ROLE FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID=? AND DEF_USER_ROLE='Y' )	");
			SurgeonNameQuery.append("	AND practitioner_id = 		");
			SurgeonNameQuery.append("	(SELECT practitioner_id		");
			SurgeonNameQuery.append("	FROM am_practitioner_lang_vw	");
			SurgeonNameQuery.append("	WHERE practitioner_name = (SELECT practitioner_name		");
			SurgeonNameQuery.append("	FROM sm_appl_user_vw	");
			SurgeonNameQuery.append("	WHERE appl_user_id = ?	)	");
			SurgeonNameQuery.append("	AND language_id = ?		)	");
			SurgeonNameQuery.append("	ORDER BY 1	");
			pstmt = connection.prepareStatement(SurgeonNameQuery.toString()) ;
			pstmt.setString(1,language);
			pstmt.setString(2,userid);
			pstmt.setString(3,facilitid);
			pstmt.setString(4,userid);
			pstmt.setString(5,language);
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()==true){
				SurgeonName.put("surgeon_name",resultSet.getString("description"));
				SurgeonName.put("surgeon",resultSet.getString("code"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
            try{
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
             }catch(Exception es){es.printStackTrace();}
        }
		return SurgeonName;
	}
//AAKH-CRF-0064 Ends
}
