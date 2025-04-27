/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH ;

import java.io.Serializable ;
import java.util.ArrayList;
import java.sql.*;
import ePH.Common.* ;
import eCommon.Common.* ;

public class SRROnlineReportSet2Bean extends PhAdapter implements Serializable {

	public SRROnlineReportSet2Bean() {
		try {
			doCommon() ;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void doCommon() throws Exception {
	}

	public void clear() {
		super.clear() ;
	}

	// This method is used to retrieve the data depending on the query criteria
	public ArrayList getWorksheetList(String locale,String p_wrksheet_id, String p_pres_id,String patient_id,String fr_dispdate,String to_dispdate,String p_encounter,String p_pract_id,String p_disp_locn_code,String p_locn_type,String p_locn_code,String from,String to,String p_tokto,String p_tokfr,String p_facility_id,String p_type_ord)throws Exception{

		String ivPrepYn				= "";
		String sql				= "";
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList records=new ArrayList();
		String prevnextlink			= "";
		int query_result_size		= 14;
		int start = 0 ;
		int end = 0 ;
		long count=0;
		long i = 0;

          	if ( from == null || from.equals(""))
			start = 1 ;
		else
			start = Integer.parseInt( from  ) ;

		if ( to == null || to.equals(""))
			end =query_result_size;
		else
			end = Integer.parseInt( to ) ;
	

		try {
			connection = getConnection() ;

			if(p_type_ord.equals("IV")){ ivPrepYn = "AND D.IV_PREP_YN IN ('2','4')";}
			if(p_type_ord.equals("CYTO")){ ivPrepYn = "AND D.IV_PREP_YN IN ('0')";}
			if(p_type_ord.equals("CMP")){ ivPrepYn = "AND D.IV_PREP_YN IN ('6')";}
			if(p_type_ord.equals("TPN")){ ivPrepYn = "AND B.IV_PREP_YN IN ('8')";}

			if(p_type_ord.equals("TPN")){
				 sql = "SELECT a.TPN_WORKSHEET_ID, TO_CHAR (a.prep_date_time, 'DD/MM/YYYY HH24:MI') disp_date_time,a.order_id,''token_serial_no, '' token_daily_seq_no, b.patient_id patient_id,b.encounter_id encounter_id, patient_name patient_name, practitioner_name practitioner_name,b.trn_group_ref pres_no,'' stage FROM ph_tpn_worksheet_hdr a, or_order b, mp_patient c,        am_practitioner_lang_vw d  WHERE a.facility_id = ? AND b.patient_id = c.patient_id AND b.ord_pract_id = d.practitioner_id AND b.order_id = a.order_id AND a.tpn_worksheet_id = NVL (?, a.tpn_worksheet_id)    AND b.patient_id = NVL (?, b.patient_id) AND a.prep_date_time BETWEEN TO_DATE (?, 'DD/MM/YYYY') AND TO_DATE (?, 'DD/MM/YYYY') + 0.99999    AND b.trn_group_ref = NVL (?, b.trn_group_ref) AND b.encounter_id = NVL (?, b.encounter_id) AND b.ord_pract_id = NVL (?, b.ord_pract_id) AND a.disp_locn_code = ? AND b.source_type = NVL (?, b.source_type) AND b.source_code = NVL (?, b.source_code) AND d.language_id = ? "+ ivPrepYn +"  order by a.prep_date_time desc";
			}else{

			 //sql = "SELECT  a.worksheet_id, to_char(prep_date_time,'dd/mm/yyyy'), a.order_id, b.token_serial_no, b.daily_seq_num, d.patient_id, d.encounter_id, c.patient_name,  e.practitioner_name, d.trn_group_ref,Stage FROM ph_worksheet_hdr a,   (SELECT 'D' Stage,worksheet_id, token_serial_no, patient_class, daily_seq_num, patient_id, facility_id FROM ph_disp_hdr WHERE worksheet_id IS NOT NULL UNION ALL SELECT 'F'Stage,worksheet_id, token_serial_no, patient_class, daily_seq_num, patient_id, facility_id FROM ph_disp_hdr_tmp  WHERE worksheet_id IS NOT NULL) b,  mp_patient c,  or_order d,  am_practitioner_lang_vw e  WHERE a.worksheet_id = b.worksheet_id  AND a.facility_id = d.performing_facility_id AND a.disp_locn = d.performing_deptloc_code  AND b.patient_id = c.patient_id   AND b.facility_id = d.performing_facility_id  AND a.order_id = d.order_id   AND e.practitioner_id = d.ord_pract_id   AND a.facility_id = ?  AND e.language_id = ?  AND a.worksheet_id = NVL (?, a.worksheet_id)  AND a.prep_date_time BETWEEN TO_DATE (?, 'DD/MM/YYYY')  AND TO_DATE (?, 'DD/MM/YYYY')+0.99999  AND d.trn_group_ref = NVL (?, trn_group_ref)  AND d.patient_id = NVL (?, b.patient_id)      AND d.encounter_id = NVL (?, d.encounter_id)  AND d.ord_pract_id = NVL (?, d.ord_pract_id)  AND d.performing_deptloc_code = ?   AND d.source_type = NVL (?, d.source_type)  AND d.source_code = NVL (?, d.source_code) AND d.order_category = 'PH'			 AND NVL (b.daily_seq_num, 'X') BETWEEN DECODE (b.patient_class,'IP', NVL (?, NVL (b.daily_seq_num, 'X' ) ), NVL (b.daily_seq_num, 'X') ) AND DECODE  (b.patient_class,  'IP', NVL (?,NVL (b.daily_seq_num,'X') ), NVL (b.daily_seq_num, 'X'))  AND NVL (b.token_serial_no, '99')  BETWEEN DECODE (b.patient_class, 'OP', NVL (?, NVL (b.token_serial_no, '99')),  NVL (b.token_serial_no, '99') ) AND DECODE (b.patient_class,   'OP', NVL (?, NVL (b.token_serial_no, '99')), NVL (b.token_serial_no, '99') )  "+ ivPrepYn +"ORDER BY a.prep_date_time DESC"; Commented on 26/7/2010

			//Modified Query on 26/7/2010 For the Worksheet report ---token/display Sequence numbers are coming in order.
			 sql = "SELECT a.worksheet_id, TO_CHAR (prep_date_time, 'dd/mm/yyyy'), a.order_id, b.token_serial_no, b.daily_seq_num, d.patient_id, d.encounter_id, c.patient_name, e.practitioner_name, d.trn_group_ref, stage FROM ph_worksheet_hdr a,(SELECT 'D' stage, worksheet_id, token_serial_no, patient_class,daily_seq_num, patient_id, facility_id,DISP_LOCN_CODE FROM ph_disp_hdr WHERE worksheet_id IS NOT NULL UNION ALL SELECT 'F' stage, worksheet_id, token_serial_no, patient_class,daily_seq_num, patient_id, facility_id,DISP_LOCN_CODE FROM ph_disp_hdr_tmp WHERE worksheet_id IS NOT NULL) b,mp_patient c, or_order d,am_practitioner_lang_vw e WHERE a.worksheet_id = b.worksheet_id AND a.facility_id = d.performing_facility_id AND a.disp_locn = b.DISP_LOCN_CODE AND b.facility_id = a.FACILITY_ID AND a.disp_locn = d.performing_deptloc_code AND b.patient_id = c.patient_id AND b.facility_id = d.performing_facility_id AND a.order_id = d.order_id AND e.practitioner_id = d.ord_pract_id AND a.facility_id = ? AND e.language_id = ? AND a.worksheet_id = NVL (?, a.worksheet_id) AND a.prep_date_time BETWEEN TO_DATE (?, 'DD/MM/YYYY') AND TO_DATE (?, 'DD/MM/YYYY')+ 0.99999 AND d.trn_group_ref = NVL (?, trn_group_ref) AND d.patient_id = NVL (?, b.patient_id) AND d.encounter_id = NVL (?, d.encounter_id) AND d.ord_pract_id = NVL (?, d.ord_pract_id) AND d.performing_deptloc_code = ? AND d.source_type = NVL (?, d.source_type) AND d.source_code = NVL (?, d.source_code) AND d.order_category = 'PH' AND ((b.patient_class = 'IP' AND b.daily_seq_num BETWEEN NVL(?,b.daily_seq_num) AND NVL(?,b.daily_seq_num)) OR (B.PATIENT_CLASS = 'OP' AND b.token_serial_no BETWEEN NVL (?, b.token_serial_no) AND NVL (?, b.token_serial_no))) "+ ivPrepYn +" ORDER BY a.prep_date_time DESC";
			}

			pstmt = connection.prepareStatement(sql);

			if(p_type_ord.equals("TPN")){

				

			pstmt.setString(1,p_facility_id);
			pstmt.setString(2,p_wrksheet_id);
			pstmt.setString(3,patient_id);
			pstmt.setString(4,fr_dispdate);
			pstmt.setString(5,to_dispdate);
			pstmt.setString(6,p_pres_id);
			pstmt.setString(7,p_encounter);
			pstmt.setString(8,p_pract_id);
			pstmt.setString(9,p_disp_locn_code);
			pstmt.setString(10,p_locn_type);
			pstmt.setString(11,p_locn_code);
			pstmt.setString(12,locale);
	
			}
			else{
				
			pstmt.setString(1,p_facility_id);
			pstmt.setString(2,locale);
			pstmt.setString(3,p_wrksheet_id);
			pstmt.setString(4,fr_dispdate);
			pstmt.setString(5,to_dispdate);
			pstmt.setString(6,p_pres_id);
			pstmt.setString(7,patient_id);
		    pstmt.setString(8,p_encounter);
			pstmt.setString(9,p_pract_id);
			pstmt.setString(10,p_disp_locn_code);
			pstmt.setString(11,p_locn_type);
			pstmt.setString(12,p_locn_code);
			//Added If-else condition for the  Manufacturing Label & WorkSheet Reports issue on 27/7/2010
			if(p_tokfr.equals("") || p_tokto.equals(""))
			{
				
				pstmt.setString(13,p_tokfr);
				pstmt.setString(14,p_tokto);
				pstmt.setString(15,p_tokfr);
				pstmt.setString(16,p_tokto);

			}
			else
			{
				
				
				pstmt.setInt(13,Integer.parseInt(p_tokfr));
				pstmt.setInt(14,Integer.parseInt(p_tokto));
				pstmt.setInt(15,Integer.parseInt(p_tokfr));
				pstmt.setInt(16,Integer.parseInt(p_tokto));
			} //end else
			
			
			}
			
			resultSet = pstmt.executeQuery();
			records.add("link");
			while ( resultSet.next() && i <= end+1 ){
				if( start != 1 && (i+1) < start ) {
					i++;
					continue;
				}
				else i++;
				count++ ;
					if(i <= end ) {
			
				String arr[] = new String[12];	
				arr[0]=resultSet.getString(1);
				arr[1]=resultSet.getString(2);
				arr[2]=resultSet.getString(3);
				arr[3]=resultSet.getString(4);
				arr[4]=resultSet.getString(5);
				arr[5]=resultSet.getString(6);
				arr[6]=resultSet.getString(7);
				arr[7]=resultSet.getString(8);
				arr[8]=resultSet.getString(9);
				arr[9]=resultSet.getString(10);
				arr[10]=resultSet.getString(11);
				records.add(arr);
				}

			}
			if( start != 1 )
					prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start-query_result_size)+"','"+(end-query_result_size)+"','"+(patient_id)+"','"+(p_wrksheet_id)+"','"+(p_pres_id)+"','"+(fr_dispdate)+"','"+to_dispdate+"','"+(p_encounter)+"','"+(p_pract_id)+"','"+(p_facility_id)+"','"+(p_disp_locn_code)+"','"+(p_tokfr)+"','"+(p_tokto)+"','"+p_locn_type+"','"+p_locn_code+"')\">Previous&nbsp;&nbsp;</a>" ;

			if( count > 14 )
					prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start+query_result_size)+"','"+(end+query_result_size)+"','"+(patient_id)+"','"+(p_wrksheet_id)+"','"+(p_pres_id)+"','"+(fr_dispdate)+"','"+to_dispdate+"','"+(p_encounter)+"','"+(p_pract_id)+"','"+(p_facility_id)+"','"+(p_disp_locn_code)+"','"+(p_tokfr)+"','"+(p_tokto)+"','"+p_locn_type+"','"+p_locn_code+"')\">Next</a>" ;
				
			records.set(0,prevnextlink);
			

		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			throw e ;

		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
			es.printStackTrace() ;
			}
		}

		return records;
	}
/*  WorksheetList end  here    */

public ArrayList getHomeMedicationList(String locale, String p_pres_id,String patient_id,String fr_dispdate,String to_dispdate,String p_encounter,String p_disp_locn_code,String p_locn_type,String p_locn_code,String from,String to,String p_tokto,String p_tokfr,String p_facility_id)throws Exception{

		String sql				= "";
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList records=new ArrayList();
		String prevnextlink			= "";
		int query_result_size		= 14;
		int start = 0 ;
		int end = 0 ;
		long count=0;
		long i = 0;

          	if ( from == null || from.equals(""))
			start = 1 ;
		else
			start = Integer.parseInt( from  ) ;

		if ( to == null || to.equals(""))
			end =query_result_size;
		else
			end = Integer.parseInt( to ) ;
	

		try {
			connection = getConnection() ;
		
			 //sql = "select * from(SELECT distinct trn_group_ref prescription_id,a.patient_id, a.encounter_id, b.patient_name, short_desc disp_locn,  TO_CHAR (f.DISP_DATE_TIME, 'dd/mm/yyyy') DISP_DATE_TIME,   d.token_serial_no token_no,PRACTITIONER_NAME  FROM or_order a,  mp_patient b, ph_disp_locn_lang_vw c,   ph_ord_for_disp_queue d, ph_disp_queue e, ph_disp_hdr  f, am_practitioner_lang_vw g  WHERE a.patient_id = b.patient_id  AND a.performing_deptloc_code = c.disp_locn_code and a.order_id =f.order_id and a.performing_deptloc_code = f.disp_locn_code 	 and a.ORD_PRACT_ID =g.practitioner_id and g.language_id =? and f.facility_id =?  AND c.language_id = ?  AND c.facility_id = ?   AND d.facility_id = ?  AND d.disp_locn_code = a.performing_deptloc_code  AND d.queue_shift = '*ALL'   AND a.order_id = d.order_id   AND d.facility_id = e.facility_id   AND d.disp_locn_code = e.disp_locn_code  AND d.queue_date = e.queue_date  AND d.queue_shift = e.queue_shift   AND d.token_series_code = e.token_series_code  AND d.token_serial_no = e.token_serial_no  AND f.DISP_DATE_TIME BETWEEN TO_DATE (?, 'DD/MM/YYYY')     AND TO_DATE (?, 'DD/MM/YYYY') 	 and a.trn_group_ref =nvl(?,a.trn_group_ref)	and d.token_serial_no BETWEEN nvl(?,d.token_serial_no ) AND  nvl(?,d.token_serial_no) AND a.patient_id = NVL (?, a.patient_id)   AND a.encounter_id = NVL (?, a.encounter_id)     AND a.source_type = NVL (?, a.source_type)    AND a.source_code = NVL (?, a.source_code) and f.disp_locn_code =? and e.token_status not in('DF','DP')  and DISCHARGE_IND ='D'  union all SELECT   distinct trn_group_ref prescription_id,a.patient_id, a.encounter_id, b.patient_name, short_desc disp_locn,   TO_CHAR (f.DISPENSED_DATE_TIME, 'dd/mm/yyyy') DISP_DATE_TIME,  d.token_serial_no token_no,PRACTITIONER_NAME     FROM or_order a,   mp_patient b,   ph_disp_locn_lang_vw c,   ph_ord_for_disp_queue d,   ph_disp_queue e, ph_disp_hdr_tmp  f, am_practitioner_lang_vw g    WHERE a.patient_id = b.patient_id   AND a.performing_deptloc_code = c.disp_locn_code 	 and a.order_id =f.order_id 	 and a.order_id =f.order_id  and f.disp_locn_code =?  and f.facility_id =? and a.ORD_PRACT_ID =g.practitioner_id and g.language_id =?  AND c.language_id = ?   AND c.facility_id = ?   AND d.facility_id = ?	 AND d.disp_locn_code = a.performing_deptloc_code   AND d.queue_shift = '*ALL'   AND a.order_id = d.order_id   AND d.facility_id = e.facility_id   AND d.disp_locn_code = e.disp_locn_code   AND d.queue_date = e.queue_date AND d.queue_shift = e.queue_shift   AND d.token_series_code = e.token_series_code  AND d.token_serial_no = e.token_serial_no  AND f.DISPENSED_DATE_TIME BETWEEN TO_DATE (?, 'DD/MM/YYYY')              AND TO_DATE (?, 'DD/MM/YYYY')+ 0.99999 and a.trn_group_ref =nvl(?,a.trn_group_ref)	and d.token_serial_no BETWEEN nvl(?,d.token_serial_no ) AND  nvl(?,d.token_serial_no)	 AND a.patient_id = NVL (?, a.patient_id)      AND a.encounter_id = NVL (?, a.encounter_id) AND a.source_type = NVL (?, a.source_type)      AND a.source_code = NVL (?, a.source_code) 	  and f.disp_locn_code =? and e.token_status not in('DF','DP') and DISCHARGE_IND ='D' )	 ORDER BY to_Date(DISP_DATE_TIME,'dd/mm/yyyy') DESC,to_number(token_no) desc";
			//and e.token_status not in('DF','DP')

			//Modified Above Query For getting Records (removed the token status condition) regarding incident num:25082 on 2/Dec/2010===By Sandhya
			// sql = "select * from(SELECT distinct trn_group_ref prescription_id,a.patient_id, a.encounter_id, nvl(decode(?,'en',b.patient_name,PATIENT_NAME_LOC_LANG),b.patient_name)patient_name, short_desc disp_locn,  TO_CHAR (f.DISP_DATE_TIME, 'dd/mm/yyyy') DISP_DATE_TIME,   d.token_serial_no token_no,PRACTITIONER_NAME  FROM or_order a,  mp_patient b, ph_disp_locn_lang_vw c,   ph_ord_for_disp_queue d, ph_disp_queue e, ph_disp_hdr  f, am_practitioner_lang_vw g  WHERE a.patient_id = b.patient_id  AND a.performing_deptloc_code = c.disp_locn_code and a.order_id =f.order_id and a.performing_deptloc_code = f.disp_locn_code 	 and a.ORD_PRACT_ID =g.practitioner_id and g.language_id =? and f.facility_id =?  AND c.language_id = ?  AND c.facility_id = ?   AND d.facility_id = ?  AND d.disp_locn_code = a.performing_deptloc_code  AND d.queue_shift = '*ALL'   AND a.order_id = d.order_id   AND d.facility_id = e.facility_id   AND d.disp_locn_code = e.disp_locn_code  AND d.queue_date = e.queue_date  AND d.queue_shift = e.queue_shift   AND d.token_series_code = e.token_series_code  AND d.token_serial_no = e.token_serial_no  AND f.DISP_DATE_TIME BETWEEN TO_DATE (?, 'DD/MM/YYYY')     AND TO_DATE (?, 'DD/MM/YYYY')+ 0.99999 and a.trn_group_ref =nvl(?,a.trn_group_ref)	and d.token_serial_no BETWEEN nvl(?,d.token_serial_no ) AND  nvl(?,d.token_serial_no) AND a.patient_id = NVL (?, a.patient_id)   AND a.encounter_id = NVL (?, a.encounter_id)     AND a.source_type = NVL (?, a.source_type)    AND a.source_code = NVL (?, a.source_code) and f.disp_locn_code =? and DISCHARGE_IND ='D'  union all SELECT   distinct trn_group_ref prescription_id,a.patient_id, a.encounter_id, nvl(decode(?,'en',b.patient_name,PATIENT_NAME_LOC_LANG),b.patient_name)patient_name, short_desc disp_locn,   TO_CHAR (f.DISPENSED_DATE_TIME, 'dd/mm/yyyy') DISP_DATE_TIME,  d.token_serial_no token_no,PRACTITIONER_NAME     FROM or_order a,   mp_patient b,   ph_disp_locn_lang_vw c,   ph_ord_for_disp_queue d,   ph_disp_queue e, ph_disp_hdr_tmp  f, am_practitioner_lang_vw g    WHERE a.patient_id = b.patient_id   AND a.performing_deptloc_code = c.disp_locn_code 	 and a.order_id =f.order_id 	 and a.order_id =f.order_id  and f.disp_locn_code =?  and f.facility_id =? and a.ORD_PRACT_ID =g.practitioner_id and g.language_id =?  AND c.language_id = ?   AND c.facility_id = ?   AND d.facility_id = ?	 AND d.disp_locn_code = a.performing_deptloc_code   AND d.queue_shift = '*ALL'   AND a.order_id = d.order_id   AND d.facility_id = e.facility_id   AND d.disp_locn_code = e.disp_locn_code   AND d.queue_date = e.queue_date AND d.queue_shift = e.queue_shift   AND d.token_series_code = e.token_series_code  AND d.token_serial_no = e.token_serial_no  AND f.DISPENSED_DATE_TIME BETWEEN TO_DATE (?, 'DD/MM/YYYY')              AND TO_DATE (?, 'DD/MM/YYYY')+ 0.99999 and a.trn_group_ref =nvl(?,a.trn_group_ref)	and d.token_serial_no BETWEEN nvl(?,d.token_serial_no ) AND  nvl(?,d.token_serial_no)	 AND a.patient_id = NVL (?, a.patient_id)      AND a.encounter_id = NVL (?, a.encounter_id) AND a.source_type = NVL (?, a.source_type)      AND a.source_code = NVL (?, a.source_code) 	  and f.disp_locn_code =? and DISCHARGE_IND ='D' )	 ORDER BY to_Date(DISP_DATE_TIME,'dd/mm/yyyy') DESC,to_number(token_no) desc";

			//Removed DISCHARGE_IND ='D' condition regarding incident 25525===By Naveen on 16/DEC/2010
			 sql = "select * from(SELECT distinct trn_group_ref prescription_id,a.patient_id, a.encounter_id, nvl(decode(?,'en',b.patient_name,PATIENT_NAME_LOC_LANG),b.patient_name)patient_name, short_desc disp_locn,  TO_CHAR (f.DISP_DATE_TIME, 'dd/mm/yyyy') DISP_DATE_TIME,   d.token_serial_no token_no,PRACTITIONER_NAME  FROM or_order a,  mp_patient b, ph_disp_locn_lang_vw c,   ph_ord_for_disp_queue d, ph_disp_queue e, ph_disp_hdr  f, am_practitioner_lang_vw g  WHERE a.patient_id = b.patient_id  AND a.performing_deptloc_code = c.disp_locn_code and a.order_id =f.order_id and a.performing_deptloc_code = f.disp_locn_code 	 and a.ORD_PRACT_ID =g.practitioner_id and g.language_id =? and f.facility_id =?  AND c.language_id = ?  AND c.facility_id = ?   AND d.facility_id = ?  AND d.disp_locn_code = a.performing_deptloc_code  AND d.queue_shift = '*ALL'   AND a.order_id = d.order_id   AND d.facility_id = e.facility_id   AND d.disp_locn_code = e.disp_locn_code  AND d.queue_date = e.queue_date  AND d.queue_shift = e.queue_shift   AND d.token_series_code = e.token_series_code  AND d.token_serial_no = e.token_serial_no  AND f.DISP_DATE_TIME BETWEEN TO_DATE (?, 'DD/MM/YYYY')     AND TO_DATE (?, 'DD/MM/YYYY')+ 0.99999 and a.trn_group_ref =nvl(?,a.trn_group_ref)	and d.token_serial_no BETWEEN nvl(?,d.token_serial_no ) AND  nvl(?,d.token_serial_no) AND a.patient_id = NVL (?, a.patient_id)   AND a.encounter_id = NVL (?, a.encounter_id)     AND a.source_type = NVL (?, a.source_type)    AND a.source_code = NVL (?, a.source_code) and f.disp_locn_code =?   union all SELECT   distinct trn_group_ref prescription_id,a.patient_id, a.encounter_id, nvl(decode(?,'en',b.patient_name,PATIENT_NAME_LOC_LANG),b.patient_name)patient_name, short_desc disp_locn,   TO_CHAR (f.DISPENSED_DATE_TIME, 'dd/mm/yyyy') DISP_DATE_TIME,  d.token_serial_no token_no,PRACTITIONER_NAME     FROM or_order a,   mp_patient b,   ph_disp_locn_lang_vw c,   ph_ord_for_disp_queue d,   ph_disp_queue e, ph_disp_hdr_tmp  f, am_practitioner_lang_vw g    WHERE a.patient_id = b.patient_id   AND a.performing_deptloc_code = c.disp_locn_code 	 and a.order_id =f.order_id 	 and a.order_id =f.order_id  and f.disp_locn_code =?  and f.facility_id =? and a.ORD_PRACT_ID =g.practitioner_id and g.language_id =?  AND c.language_id = ?   AND c.facility_id = ?   AND d.facility_id = ?	 AND d.disp_locn_code = a.performing_deptloc_code   AND d.queue_shift = '*ALL'   AND a.order_id = d.order_id   AND d.facility_id = e.facility_id   AND d.disp_locn_code = e.disp_locn_code   AND d.queue_date = e.queue_date AND d.queue_shift = e.queue_shift   AND d.token_series_code = e.token_series_code  AND d.token_serial_no = e.token_serial_no  AND f.DISPENSED_DATE_TIME BETWEEN TO_DATE (?, 'DD/MM/YYYY')              AND TO_DATE (?, 'DD/MM/YYYY')+ 0.99999 and a.trn_group_ref =nvl(?,a.trn_group_ref)	and d.token_serial_no BETWEEN nvl(?,d.token_serial_no ) AND  nvl(?,d.token_serial_no)	 AND a.patient_id = NVL (?, a.patient_id)      AND a.encounter_id = NVL (?, a.encounter_id) AND a.source_type = NVL (?, a.source_type)      AND a.source_code = NVL (?, a.source_code) 	  and f.disp_locn_code =?  )	 ORDER BY to_Date(DISP_DATE_TIME,'dd/mm/yyyy') DESC,to_number(token_no) desc";
			
			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,p_facility_id);
			pstmt.setString(4,locale);
			pstmt.setString(5,p_facility_id);
			pstmt.setString(6,p_facility_id);
			pstmt.setString(7,fr_dispdate);
			pstmt.setString(8,to_dispdate);
			pstmt.setString(9,p_pres_id);
			pstmt.setString(10,p_tokfr);
			pstmt.setString(11,p_tokto);
			pstmt.setString(12,patient_id);
			pstmt.setString(13,p_encounter);
			
			pstmt.setString(14,p_locn_type);
			pstmt.setString(15,p_locn_code);
			pstmt.setString(16,p_disp_locn_code);
			pstmt.setString(17,locale);
			pstmt.setString(18,p_disp_locn_code);
			pstmt.setString(19,p_facility_id);
			pstmt.setString(20,locale);
			pstmt.setString(21,locale);
			pstmt.setString(22,p_facility_id);
			pstmt.setString(23,p_facility_id);
			pstmt.setString(24,fr_dispdate);
			pstmt.setString(25,to_dispdate);
			pstmt.setString(26,p_pres_id);
			pstmt.setString(27,p_tokfr);
			pstmt.setString(28,p_tokto);
			pstmt.setString(29,patient_id);
		    pstmt.setString(30,p_encounter);
		
			pstmt.setString(31,p_locn_type);
			pstmt.setString(32,p_locn_code);	
			pstmt.setString(33,p_disp_locn_code);

			

			resultSet = pstmt.executeQuery();
			records.add("link");
			while ( resultSet.next() && i <= end+1 ){
				if( start != 1 && (i+1) < start ) {
					i++;
					continue;
				}
				else i++;
				count++ ;
					if(i <= end ) {
			
				String arr[] = new String[12];	
				arr[0]=resultSet.getString(1);
				arr[1]=resultSet.getString(2);
				arr[2]=resultSet.getString(3);
				arr[3]=resultSet.getString(4);
				arr[4]=resultSet.getString(5);
				arr[5]=resultSet.getString(6);
				arr[6]=resultSet.getString(7);
				arr[7]=resultSet.getString(8);
				records.add(arr);
				}

			}
			if( start != 1 )
					prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start-query_result_size)+"','"+(end-query_result_size)+"','"+(patient_id)+"','"+(p_pres_id)+"','"+(fr_dispdate)+"','"+to_dispdate+"','"+(p_encounter)+"','"+(p_facility_id)+"','"+(p_disp_locn_code)+"','"+(p_tokfr)+"','"+(p_tokto)+"','"+p_locn_type+"','"+p_locn_code+"')\">Previous&nbsp;&nbsp;</a>" ;

			if( count > 14 )
					prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start+query_result_size)+"','"+(end+query_result_size)+"','"+(patient_id)+"','"+(p_pres_id)+"','"+(fr_dispdate)+"','"+to_dispdate+"','"+(p_encounter)+"','"+(p_facility_id)+"','"+(p_disp_locn_code)+"','"+(p_tokfr)+"','"+(p_tokto)+"','"+p_locn_type+"','"+p_locn_code+"')\">Next</a>" ;
				
			records.set(0,prevnextlink);
			

		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			throw e ;

		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
			es.printStackTrace() ;
			}
		}

		return records;
	}
/*  HomeMedicationList end  here    */


	public ArrayList getRefillMedicationList(String locale, String p_pres_id,String patient_id,String fr_dispdate,String to_dispdate,String p_encounter,String p_pract_id,String p_disp_locn_code,String p_locn_type,String p_locn_code,String from,String to,String p_tok,String p_facility_id)throws Exception{

		String sql				= "";
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList records=new ArrayList();
		String prevnextlink			= "";
		int query_result_size		= 14;
		int start = 0 ;
		int end = 0 ;
		long count=0;
		long i = 0;

          	if ( from == null || from.equals(""))
			start = 1 ;
		else
			start = Integer.parseInt( from  ) ;

		if ( to == null || to.equals(""))
			end =query_result_size;
		else
			end = Integer.parseInt( to ) ;
	

		try {
			connection = getConnection() ;
		 //Modified Query for the incident num:23847 on 26/Nov/2010===By sandhya
			 //sql = "select * from(SELECT DISTINCT trn_group_ref prescription_id, a.patient_id, a.encounter_id, b.patient_name, short_desc disp_locn,  TO_CHAR (f.disp_date_time, 'dd/mm/yyyy') disp_date_time,   practitioner_name, f.token_serial_no token_no, f.daily_seq_num  FROM or_order a, mp_patient b,  ph_disp_locn_lang_vw c,  ph_disp_hdr f,  am_practitioner_lang_vw g  WHERE a.patient_id = b.patient_id  AND a.performing_deptloc_code = c.disp_locn_code  AND a.order_id = f.order_id  AND a.performing_deptloc_code = f.disp_locn_code  AND a.ord_pract_id = g.practitioner_id  AND g.language_id = ?  AND f.facility_id = ?  AND c.language_id = ?  AND c.facility_id = ? AND f.disp_date_time BETWEEN TO_DATE (?, 'DD/MM/YYYY')  AND TO_DATE (?, 'DD/MM/YYYY')+0.9999  AND a.trn_group_ref = NVL (?, a.trn_group_ref)  AND a.patient_id = NVL (?, a.patient_id)  AND a.encounter_id = NVL (?, a.encounter_id)  AND a.ord_pract_id = NVL (?, a.ord_pract_id)  AND a.source_type = NVL (?, a.source_type)   AND a.source_code = NVL (?, a.source_code)   AND f.disp_locn_code = ?  AND a.patient_class = 'OP' AND NVL (f.daily_seq_num, 'X') =  DECODE (a.patient_class,  'IP', NVL (?, NVL (f.daily_seq_num, 'X')),  NVL (f.daily_seq_num, 'X') ) AND NVL (f.token_serial_no, '99999') =  DECODE (a.patient_class, 'OP', NVL (?, NVL (f.token_serial_no, '99999')),  NVL (f.token_serial_no, '99999') ) and (SELECT count(*) cnt  FROM or_order_line a, or_order b  WHERE b.patient_id = f.patient_id  AND a.order_id = b.order_id  AND a.num_of_refills > 0  AND refill_single_cont_order_yn = 'Y'  AND b.parent_order_id = f.order_id) >0 union all  SELECT DISTINCT trn_group_ref prescription_id, a.patient_id, a.encounter_id,  b.patient_name, short_desc disp_locn,  TO_CHAR (f.DISPENSED_DATE_TIME, 'dd/mm/yyyy') disp_date_time,  practitioner_name, f.token_serial_no token_no,  f.daily_seq_num     FROM or_order a,   mp_patient b,  ph_disp_locn_lang_vw c,  ph_disp_hdr_tmp  f, am_practitioner_lang_vw g   WHERE a.patient_id = b.patient_id   AND a.performing_deptloc_code = c.disp_locn_code 	 and a.order_id =f.order_id and a.order_id =f.order_id 	AND a.patient_class = 'OP' and f.disp_locn_code =? and f.facility_id = ? and a.ORD_PRACT_ID =g.practitioner_id 	 and g.language_id = ? 	 AND c.language_id = ?      AND c.facility_id = ?   AND f.DISPENSED_DATE_TIME BETWEEN TO_DATE (?, 'DD/MM/YYYY')   AND TO_DATE (?, 'DD/MM/YYYY')+0.9999  and a.trn_group_ref =nvl(?,a.trn_group_ref) AND a.patient_id = NVL (?, a.patient_id)  AND a.encounter_id = NVL (?, a.encounter_id)   AND a.ord_pract_id = NVL (?, a.ord_pract_id)      AND a.source_type = NVL (?, a.source_type)    AND a.source_code = NVL (?, a.source_code) 	 and f.disp_locn_code =?		 and ( SELECT count(*) cnt   FROM or_order_line a, or_order b  WHERE b.patient_id = f.patient_id   AND a.order_id = b.order_id   AND a.num_of_refills > 0  AND refill_single_cont_order_yn = 'Y'   AND b.parent_order_id = f.order_id) >0 ) ORDER BY to_Date(DISP_DATE_TIME,'dd/mm/yyyy') DESC";


			 sql = "select * from(SELECT DISTINCT trn_group_ref prescription_id, a.patient_id, a.encounter_id, nvl( decode(?,'en',b.patient_name, patient_name_loc_lang),patient_name) patient_name, short_desc disp_locn,  TO_CHAR (f.disp_date_time, 'dd/mm/yyyy') disp_date_time,   practitioner_name, f.token_serial_no token_no, f.daily_seq_num  FROM or_order a, mp_patient b,  ph_disp_locn_lang_vw c,  ph_disp_hdr f,  am_practitioner_lang_vw g  WHERE a.patient_id = b.patient_id  AND a.performing_deptloc_code = c.disp_locn_code  AND a.order_id = f.order_id  AND a.performing_deptloc_code = f.disp_locn_code  AND a.ord_pract_id = g.practitioner_id  AND g.language_id = ?  AND f.facility_id = ?  AND c.language_id = ?  AND c.facility_id = ? AND f.disp_date_time BETWEEN TO_DATE (?, 'DD/MM/YYYY')  AND TO_DATE (?, 'DD/MM/YYYY')+0.9999  AND a.trn_group_ref = NVL (?, a.trn_group_ref)  AND a.patient_id = NVL (?, a.patient_id)  AND a.encounter_id = NVL (?, a.encounter_id)  AND a.ord_pract_id = NVL (?, a.ord_pract_id)  AND a.source_type = NVL (?, a.source_type)   AND a.source_code = NVL (?, a.source_code)   AND f.disp_locn_code = ?  AND a.patient_class = 'OP' AND NVL (f.daily_seq_num, 'X') =  DECODE (a.patient_class,  'IP', NVL (?, NVL (f.daily_seq_num, 'X')),  NVL (f.daily_seq_num, 'X') ) AND NVL (f.token_serial_no, '99999') =  DECODE (a.patient_class, 'OP', NVL (?, NVL (f.token_serial_no, '99999')),  NVL (f.token_serial_no, '99999') ) and (SELECT count(*) cnt  FROM or_order_line a, or_order b  WHERE b.patient_id = f.patient_id  AND a.order_id = b.order_id  AND a.num_of_refills > 0  AND refill_single_cont_order_yn = 'Y'  AND b.order_id = f.order_id) >0 union all  SELECT DISTINCT trn_group_ref prescription_id, a.patient_id, a.encounter_id,  nvl( decode(?,'en',b.patient_name, patient_name_loc_lang),patient_name) patient_name, short_desc disp_locn,  TO_CHAR (f.DISPENSED_DATE_TIME, 'dd/mm/yyyy') disp_date_time,  practitioner_name, f.token_serial_no token_no,  f.daily_seq_num     FROM or_order a,   mp_patient b,  ph_disp_locn_lang_vw c,  ph_disp_hdr_tmp  f, am_practitioner_lang_vw g   WHERE a.patient_id = b.patient_id   AND a.performing_deptloc_code = c.disp_locn_code 	 and a.order_id =f.order_id and a.order_id =f.order_id 	AND a.patient_class = 'OP' and f.disp_locn_code =? and f.facility_id = ? and a.ORD_PRACT_ID =g.practitioner_id 	 and g.language_id = ? 	 AND c.language_id = ?      AND c.facility_id = ?   AND f.DISPENSED_DATE_TIME BETWEEN TO_DATE (?, 'DD/MM/YYYY')   AND TO_DATE (?, 'DD/MM/YYYY')+0.9999  and a.trn_group_ref =nvl(?,a.trn_group_ref) AND a.patient_id = NVL (?, a.patient_id)  AND a.encounter_id = NVL (?, a.encounter_id)   AND a.ord_pract_id = NVL (?, a.ord_pract_id)      AND a.source_type = NVL (?, a.source_type)    AND a.source_code = NVL (?, a.source_code) 	 and f.disp_locn_code =?		 and ( SELECT count(*) cnt   FROM or_order_line a, or_order b  WHERE b.patient_id = f.patient_id   AND a.order_id = b.order_id   AND a.num_of_refills > 0  AND refill_single_cont_order_yn = 'Y'   AND b.order_id = f.order_id) >0 ) ORDER BY to_Date(DISP_DATE_TIME,'dd/mm/yyyy') DESC";
			
			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1,locale); //Added 26126 
			pstmt.setString(2,locale);
			pstmt.setString(3,p_facility_id);
			pstmt.setString(4,locale);
			pstmt.setString(5,p_facility_id);
			pstmt.setString(6,fr_dispdate);
			pstmt.setString(7,to_dispdate);
			pstmt.setString(8,p_pres_id);
			pstmt.setString(9,patient_id);
			pstmt.setString(10,p_encounter);
			pstmt.setString(11,p_pract_id);
			pstmt.setString(12,p_locn_type);
			pstmt.setString(13,p_locn_code);
			pstmt.setString(14,p_disp_locn_code);
			pstmt.setString(15,p_tok);
			pstmt.setString(16,p_tok);
			pstmt.setString(17,locale);
			pstmt.setString(18,p_disp_locn_code);
			pstmt.setString(19,p_facility_id);
			pstmt.setString(20,locale);
			pstmt.setString(21,locale);
			pstmt.setString(22,p_facility_id);
			pstmt.setString(23,fr_dispdate);
			pstmt.setString(24,to_dispdate);
			pstmt.setString(25,p_pres_id);
			pstmt.setString(26,patient_id);
		    pstmt.setString(27,p_encounter);
			pstmt.setString(28,p_pract_id);
			pstmt.setString(29,p_locn_type);
			pstmt.setString(30,p_locn_code);	
			pstmt.setString(31,p_disp_locn_code);

			

			resultSet = pstmt.executeQuery();
			records.add("link");
			while ( resultSet.next() && i <= end+1 ){
				if( start != 1 && (i+1) < start ) {
					i++;
					continue;
				}
				else i++;
				count++ ;
					if(i <= end ) {
			
				String arr[] = new String[12];	
				arr[0]=resultSet.getString(1);
				arr[1]=resultSet.getString(2);
				arr[2]=resultSet.getString(3);
				arr[3]=resultSet.getString(4);
				arr[4]=resultSet.getString(5);
				arr[5]=resultSet.getString(6);
				arr[6]=resultSet.getString(7);
				arr[7]=resultSet.getString(8);
				arr[8]=resultSet.getString(9);
				records.add(arr);
				}

			}
			if( start != 1 )
					prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start-query_result_size)+"','"+(end-query_result_size)+"','"+(patient_id)+"','"+(p_pres_id)+"','"+(fr_dispdate)+"','"+to_dispdate+"','"+(p_encounter)+"','"+(p_pract_id)+"','"+(p_facility_id)+"','"+(p_disp_locn_code)+"','"+(p_tok)+"','"+p_locn_type+"','"+p_locn_code+"')\">Previous&nbsp;&nbsp;</a>" ;

			if( count > 14 )
					prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start+query_result_size)+"','"+(end+query_result_size)+"','"+(patient_id)+"','"+(p_pres_id)+"','"+(fr_dispdate)+"','"+to_dispdate+"','"+(p_encounter)+"','"+(p_pract_id)+"','"+(p_facility_id)+"','"+(p_disp_locn_code)+"','"+(p_tok)+"','"+p_locn_type+"','"+p_locn_code+"')\">Next</a>" ;
				
			records.set(0,prevnextlink);
			

		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			throw e ;

		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
			es.printStackTrace() ;
			}
		}

		return records;
	}
/*  RefillMedicationList end  here    */


 
public ArrayList getFillListByNursingList(String p_disp_facility_id, String p_fill_proc_ty,String p_fill_proc_fr_dt,String p_fill_proc_to_dt,String p_select,String p_fr_nurs_unit,String p_to_nurs_unit,String p_facility_id,String p_build,String from,String to)throws Exception{

		String sql				= "";
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList records=new ArrayList();
		String prevnextlink			= "";
		int query_result_size		= 14;
		int start = 0 ;
		int end = 0 ;
		long count=0;
		long i = 0;

          	if ( from == null || from.equals(""))
			start = 1 ;
		else
			start = Integer.parseInt( from  ) ;

		if ( to == null || to.equals(""))
			end =query_result_size;
		else
			end = Integer.parseInt( to ) ;
	

		try {
			connection = getConnection() ;
		
			 //sql = "SELECT  a.nursing_unit_code, last_fill_proc_id, proc_type, TO_CHAR (fill_proc_date_time, 'dd/mm/yyyy hh24:mi') fill_proc_date_time ,SHORT_DESC nursing_unit_name FROM ph_last_fill_int_dtl a, ph_fill_process_param b,IP_NURSING_UNIT_LANG_VW C WHERE fill_proc_id = last_fill_proc_id AND A.nursing_unit_code =C.nursing_unit_code AND last_fill_proc_id = NVL (?, last_fill_proc_id) AND proc_type = NVL (?, proc_type) AND TRUNC (fill_proc_date_time) BETWEEN (NVL (TO_DATE (?,'dd/mm/yyyy'),trunc(fill_proc_date_time))) AND  ( NVL (TO_DATE (?,'dd/mm/yyyy'),  trunc(fill_proc_date_time)))+ 0.99999 AND nursing_unit_or_locn = ? AND ((? = 'N' AND a.nursing_unit_code BETWEEN NVL (?, '!') AND NVL (?, '~')) OR (?= 'L' AND a.nursing_unit_code IN (SELECT nursing_unit_code FROM ip_nursing_unit_location WHERE facility_id = ? AND bldng_code = ?))) AND LANGUAGE_ID=?"; //Commented  on 23/07/2010 
			 sql = "SELECT  a.nursing_unit_code, last_fill_proc_id, proc_type, TO_CHAR (fill_proc_date_time, 'dd/mm/yyyy hh24:mi') fill_proc_date_time_order,SHORT_DESC nursing_unit_name FROM ph_last_fill_int_dtl a, ph_fill_process_param b,IP_NURSING_UNIT_LANG_VW C WHERE fill_proc_id = last_fill_proc_id AND A.nursing_unit_code =C.nursing_unit_code AND last_fill_proc_id = NVL (?, last_fill_proc_id) AND proc_type = NVL (?, proc_type) AND TRUNC (fill_proc_date_time) BETWEEN (NVL (TO_DATE (?,'dd/mm/yyyy'),trunc(fill_proc_date_time))) AND  ( NVL (TO_DATE (?,'dd/mm/yyyy'),  trunc(fill_proc_date_time)))+ 0.99999 AND nursing_unit_or_locn = ? AND ((? = 'N' AND a.nursing_unit_code BETWEEN NVL (?, '!') AND NVL (?, '~')) OR (?= 'L' AND a.nursing_unit_code IN (SELECT nursing_unit_code FROM ip_nursing_unit_location WHERE facility_id = ? AND bldng_code = ?))) AND LANGUAGE_ID=? order by b.fill_proc_date_time desc";  //Added Order by desc for getting orders in descending order on 23/07/2010.
			
			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1,p_disp_facility_id);
			pstmt.setString(2,p_fill_proc_ty);
			pstmt.setString(3,p_fill_proc_fr_dt);
			pstmt.setString(4,p_fill_proc_to_dt);
			pstmt.setString(5,p_select);
			pstmt.setString(6,p_select);
			pstmt.setString(7,p_fr_nurs_unit);
			pstmt.setString(8,p_to_nurs_unit);
			pstmt.setString(9,p_select);
			pstmt.setString(10,p_facility_id);
			pstmt.setString(11,p_build);
			pstmt.setString(12,getLanguageId());
			
					

			resultSet = pstmt.executeQuery();
			records.add("link");
			while ( resultSet.next() && i <= end+1 ){
				if( start != 1 && (i+1) < start ) {
					i++;
					continue;
				}
				else i++;
				count++ ;
					if(i <= end ) {
			
					records.add((String)resultSet.getString("nursing_unit_code"));
					records.add((String)resultSet.getString("last_fill_proc_id"));
					records.add((String)resultSet.getString("proc_type"));
					records.add((String)resultSet.getString("fill_proc_date_time_order"));
					records.add((String)resultSet.getString("nursing_unit_name"));
				}

			}
			if( start != 1 )
					prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start-query_result_size)+"','"+(end-query_result_size)+"','"+(p_disp_facility_id)+"','"+(p_fill_proc_ty)+"','"+(p_fill_proc_fr_dt)+"','"+p_fill_proc_to_dt+"','"+(p_select)+"','"+(p_facility_id)+"','"+(p_fr_nurs_unit)+"','"+(p_to_nurs_unit)+"','"+(p_build)+"')\">Previous&nbsp;&nbsp;</a>" ;

			if( count > 14 )
					prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start+query_result_size)+"','"+(end+query_result_size)+"','"+(p_disp_facility_id)+"','"+(p_fill_proc_ty)+"','"+(p_fill_proc_fr_dt)+"','"+p_fill_proc_to_dt+"','"+(p_select)+"','"+(p_facility_id)+"','"+(p_fr_nurs_unit)+"','"+(p_to_nurs_unit)+"','"+(p_build)+"')\">Next</a>" ;
				
			records.set(0,prevnextlink);
			

		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			throw e ;

		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
			es.printStackTrace() ;
			}
		}

		return records;
	}
/*  HomeMedicationList end  here    */

public ArrayList getDispLocation() {
		ArrayList displocation = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISP_LOCN_COMN_SELECT3" )) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,getLanguageId());

			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					displocation.add( resultSet.getString( "DISP_LOCN_CODE" ) ) ;
					displocation.add( resultSet.getString( "SHORT_DESC" ) );
				}
			}

		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
			es.printStackTrace() ;
			}
		}

		return displocation;
	}
public String getPatientIDLength()
{
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	pat_txt_length	=	null ;

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_COMMON_SELECT1") ) ;
			resultSet			= pstmt.executeQuery(); 
			
			if( resultSet != null && resultSet.next() ) {
				pat_txt_length	=	checkForNull(resultSet.getString("PATIENT_ID_LENGTH"));
			}						
		}catch(Exception e){
				pat_txt_length	=e.toString();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			    }catch(Exception es){  
				es.printStackTrace() ;
				}
		      }
			return pat_txt_length;	
	  }

	  /*Medication Return Voucher starts...*/


	 public ArrayList getMedicationReturnVoucherList(String locale, String p_pres_id, String patient_id, String fr_retndate,String to_retndate,String p_encounter,String p_retn_locn_code,String p_locn_type,String p_locn_code,String from,String to,String p_medretno)throws Exception{

		String sql				= "";
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList records=new ArrayList();
		String prevnextlink			= "";
		int query_result_size		= 14;
		int start = 0 ;
		int end = 0 ;
		long count=0;
		long i = 0;

          	if ( from == null || from.equals(""))
			start = 1 ;
		else
			start = Integer.parseInt( from  ) ;

		if ( to == null || to.equals(""))
			end =query_result_size;
		else
			end = Integer.parseInt( to ) ;
	

		try {
			connection = getConnection() ;
		//Modified Query For getting Patient name into specified language regarding incident num:25081 on 1/Dec/2010===By Sandhya
			//sql="SELECT DISTINCT e.rtn_medn_no rtn_medn_no, a.patient_id patient_id, patient_name, c.trn_group_ref trn_group_ref,a.encounter_id encounter_id, d.practitioner_name practitioner_name, short_desc disp_locn, TO_CHAR (e.returned_date, 'dd/mm/yyyy') returned_date,ret_disp_locn_code FROM ph_disp_hdr a,mp_patient b, or_order c, am_practitioner_lang_vw d, ph_retn_medn e, ph_disp_locn_lang_vw f WHERE a.patient_id = b.patient_id AND a.order_id = c.order_id AND c.ord_pract_id = d.practitioner_id AND d.language_id = ? AND a.disp_no = e.disp_no AND a.facility_id = e.facility_id AND e.ret_disp_locn_code = f.disp_locn_code AND f.language_id = ? AND a.patient_id = ? AND TRUNC (e.returned_date) BETWEEN TO_DATE (?, 'DD/MM/YYYY') AND  TO_DATE (?,'DD/MM/YYYY')+ 0.99999 AND c.trn_group_ref = NVL (?, c.trn_group_ref) AND e.rtn_medn_no = NVL (?, e.rtn_medn_no) AND a.encounter_id = NVL (?, a.encounter_id) AND e.ret_disp_locn_code = NVL (?, ret_disp_locn_code) AND c.source_type = NVL (?, c.source_type) AND c.source_code = NVL (?, c.source_code) ORDER BY to_date(returned_date,'dd/mm/yyyy') DESC, disp_locn DESC, to_number(e.rtn_medn_no) DESC"

			 sql = "SELECT DISTINCT e.rtn_medn_no rtn_medn_no, a.patient_id patient_id, nvl(decode(?,'en',b.patient_name,PATIENT_NAME_LOC_LANG),b.patient_name)patient_name, c.trn_group_ref trn_group_ref,a.encounter_id encounter_id, d.practitioner_name practitioner_name, short_desc disp_locn, TO_CHAR (e.returned_date, 'dd/mm/yyyy') returned_date,ret_disp_locn_code FROM ph_disp_hdr a,mp_patient b, or_order c, am_practitioner_lang_vw d, ph_retn_medn e, ph_disp_locn_lang_vw f WHERE a.patient_id = b.patient_id AND a.order_id = c.order_id AND c.ord_pract_id = d.practitioner_id AND d.language_id = ? AND a.disp_no = e.disp_no AND a.facility_id = e.facility_id AND e.ret_disp_locn_code = f.disp_locn_code AND f.language_id = ? AND a.patient_id = ? AND TRUNC (e.returned_date) BETWEEN TO_DATE (?, 'DD/MM/YYYY') AND  TO_DATE (?,'DD/MM/YYYY')+ 0.99999 AND c.trn_group_ref = NVL (?, c.trn_group_ref) AND e.rtn_medn_no = NVL (?, e.rtn_medn_no) AND a.encounter_id = NVL (?, a.encounter_id) AND e.ret_disp_locn_code = NVL (?, ret_disp_locn_code) AND c.source_type = NVL (?, c.source_type) AND c.source_code = NVL (?, c.source_code) ORDER BY to_date(returned_date,'dd/mm/yyyy') DESC, disp_locn DESC, to_number(e.rtn_medn_no) DESC";
			
			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1,locale);
            pstmt.setString(2,locale);
            pstmt.setString(3,locale);
            pstmt.setString(4,patient_id);
            pstmt.setString(5,fr_retndate);
            pstmt.setString(6,to_retndate);
			pstmt.setString(7,p_pres_id);
			pstmt.setString(8,p_medretno);
			pstmt.setString(9,p_encounter);
			pstmt.setString(10,p_retn_locn_code);
			pstmt.setString(11,p_locn_type);
			pstmt.setString(12,p_locn_code);
			

			resultSet = pstmt.executeQuery();
			records.add("link");
			
			
			
			
			
			while ( resultSet.next() && i <= end+1){
				
				if( start != 1 && (i+1) < start ) {
					i++;
					continue;
				}
				else i++;
				count++ ;
					if(i <= end ) {
						
			
					records.add((String)resultSet.getString("rtn_medn_no"));
					records.add((String)resultSet.getString("patient_id"));
					records.add((String)resultSet.getString("patient_name"));
					records.add((String)resultSet.getString("trn_group_ref"));
					records.add((String)resultSet.getString("encounter_id"));
					records.add((String)resultSet.getString("practitioner_name"));
					records.add((String)resultSet.getString("disp_locn"));
					records.add((String)resultSet.getString("returned_date"));
					records.add((String)resultSet.getString("ret_disp_locn_code"));
					
				}

			}
			if( start != 1 )
					prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start-query_result_size)+"','"+(end-query_result_size)+"','"+(patient_id)+"','"+(p_pres_id)+"','"+(fr_retndate)+"','"+to_retndate+"','"+(p_encounter)+"','"+(p_retn_locn_code)+"','"+p_locn_type+"','"+p_locn_code+"')\">Previous&nbsp;&nbsp;</a>" ;

			if( count > 14 )
					prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start+query_result_size)+"','"+(end+query_result_size)+"','"+(patient_id)+"','"+(p_pres_id)+"','"+(fr_retndate)+"','"+to_retndate+"','"+(p_encounter)+"','"+(p_retn_locn_code)+"','"+p_locn_type+"','"+p_locn_code+"')\">Next</a>" ;
				
			records.set(0,prevnextlink);
			

		}
		catch ( Exception e ) {
			e.printStackTrace() ;	
			
			throw e ;
			//System.err.println(e.toString());

		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
			es.printStackTrace() ;
			}
		}

		return records;
	}


	public ArrayList getMedicationReturnVoucherListNursingunit(String locale, String p_pres_id, String patient_id, String fr_retndate,String to_retndate,String p_encounter,String p_ret_to_disp_locn_code,String p_locn_type,String p_locn_code,String from,String to,String p_ret_doc_no,String p_facility_id)throws Exception{

		String sql				= "";
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList records=new ArrayList();
		String prevnextlink			= "";
		int query_result_size		= 14;
		int start = 0 ;
		int end = 0 ;
		long count=0;
		long i = 0;

          	if ( from == null || from.equals(""))
			start = 1 ;
		else
			start = Integer.parseInt( from  ) ;

		if ( to == null || to.equals(""))
			end =query_result_size;
		else
			end = Integer.parseInt( to ) ;
	

		try {
			connection = getConnection() ;
		
			// sql = "SELECT DISTINCT e.ret_doc_no ret_doc_no, a.patient_id patient_id, patient_name, c.trn_group_ref trn_group_ref,a.encounter_id encounter_id, d.practitioner_name practitioner_name, short_desc disp_locn,TO_CHAR (e.added_date, 'dd/mm/yyyy') returned_date,e.ret_to_disp_locn_code FROM ph_disp_hdr a,mp_patient b,or_order c,am_practitioner_lang_vw d,ph_ward_return_hdr e,ph_disp_locn_lang_vw f WHERE a.patient_id = ? AND a.patient_id = b.patient_id AND a.order_id = c.order_id AND c.ord_pract_id = d.practitioner_id AND d.language_id = ? AND a.disp_no = e.disp_no  AND e.facility_id = ? AND a.facility_id = e.facility_id AND e.ret_to_disp_locn_code = f.disp_locn_code AND f.language_id = ? AND f.facility_id = ? AND TRUNC (e.added_date) BETWEEN TO_DATE (?,'DD/MM/YYYY' ) AND  TO_DATE (?,'DD/MM/YYYY') + 0.99999 AND c.trn_group_ref = NVL (?, c.trn_group_ref) AND e.ret_doc_no = NVL (?, e.ret_doc_no) AND a.encounter_id = NVL (?, a.encounter_id) AND e.ret_to_disp_locn_code = NVL (?, e.ret_to_disp_locn_code) AND c.source_type = NVL (?, c.source_type) AND c.source_code = NVL (?, c.source_code) ORDER BY returned_date DESC, disp_locn DESC, e.ret_doc_no DESC";
			 sql = "SELECT DISTINCT e.WARD_RET_TRX_NO ret_doc_no, a.patient_id patient_id, nvl( decode(?,'en',b.patient_name, patient_name_loc_lang),patient_name) patient_name, c.trn_group_ref trn_group_ref,a.encounter_id encounter_id, d.practitioner_name practitioner_name, short_desc disp_locn,TO_CHAR (e.added_date, 'dd/mm/yyyy') returned_date,e.ret_to_disp_locn_code FROM ph_disp_hdr a,mp_patient b,or_order c,am_practitioner_lang_vw d,ph_ward_return_hdr e,ph_disp_locn_lang_vw f WHERE a.patient_id = ? AND a.patient_id = b.patient_id AND a.order_id = c.order_id AND c.ord_pract_id = d.practitioner_id AND d.language_id = ? AND a.disp_no = e.disp_no  AND e.facility_id = ? AND a.facility_id = e.facility_id AND e.ret_to_disp_locn_code = f.disp_locn_code AND f.language_id = ? AND f.facility_id = ? AND TRUNC (e.added_date) BETWEEN TO_DATE (?,'DD/MM/YYYY' ) AND  TO_DATE (?,'DD/MM/YYYY') + 0.99999 AND c.trn_group_ref = NVL (?, c.trn_group_ref) AND e.WARD_RET_TRX_NO = NVL (?, e.WARD_RET_TRX_NO) AND a.encounter_id = NVL (?, a.encounter_id) AND e.ret_to_disp_locn_code = NVL (?, e.ret_to_disp_locn_code) AND c.source_type = NVL (?, c.source_type) AND c.source_code = NVL (?, c.source_code) ORDER BY returned_date DESC, disp_locn DESC, e.WARD_RET_TRX_NO DESC";
			
			pstmt = connection.prepareStatement(sql);
			 pstmt.setString(1,locale); //Added for 26150
			pstmt.setString(2,patient_id);
            pstmt.setString(3,locale);
            pstmt.setString(4,p_facility_id);
            pstmt.setString(5,locale);
            pstmt.setString(6,p_facility_id);
			pstmt.setString(7,fr_retndate);
			pstmt.setString(8,to_retndate);
			pstmt.setString(9,p_pres_id);
			pstmt.setString(10,p_ret_doc_no);
			pstmt.setString(11,p_encounter);
			pstmt.setString(12,p_ret_to_disp_locn_code);
			pstmt.setString(13,"");
			pstmt.setString(14,"");
			/*System.err.println("locale====>" +locale);
			System.err.println("patient_id====>" +patient_id);
			System.err.println("locale====>" +locale);
			System.err.println("p_facility_id====>" +p_facility_id);
			System.err.println("locale====>" +locale);
			System.err.println("p_facility_id====>" +p_facility_id);
			System.err.println("fr_retndate====>" +fr_retndate);
			System.err.println("to_retndate====>" +to_retndate);
			System.err.println("p_pres_id====>" +p_pres_id);
			System.err.println("p_ret_doc_no====>" +p_ret_doc_no);
			System.err.println("p_encounter====>" +p_encounter);
			System.err.println("p_ret_to_disp_locn_code====>" +p_ret_to_disp_locn_code);*/
			
			resultSet = pstmt.executeQuery();
			//System.out.println("resultSet======>" +resultSet);
			records.add("link");
							
			
			while ( resultSet.next() && i <= end+1){
				
				if( start != 1 && (i+1) < start ) {
					i++;
					continue;
				}
				else i++;
				count++ ;
					if(i <= end ) {
						
			
					records.add((String)resultSet.getString("ret_doc_no"));
					records.add((String)resultSet.getString("patient_id"));
					records.add((String)resultSet.getString("patient_name"));
					records.add((String)resultSet.getString("trn_group_ref"));
					records.add((String)resultSet.getString("encounter_id"));
					records.add((String)resultSet.getString("practitioner_name"));
					records.add((String)resultSet.getString("disp_locn"));
					records.add((String)resultSet.getString("returned_date"));
					records.add((String)resultSet.getString("ret_to_disp_locn_code"));
					
				}

			}
			if( start != 1 )
					prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start-query_result_size)+"','"+(end-query_result_size)+"','"+(patient_id)+"','"+(p_pres_id)+"','"+(fr_retndate)+"','"+to_retndate+"','"+(p_encounter)+"','"+(p_ret_to_disp_locn_code)+"','"+p_locn_type+"','"+p_locn_code+"')\">Previous&nbsp;&nbsp;</a>" ;

			if( count > 14 )
					prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start+query_result_size)+"','"+(end+query_result_size)+"','"+(patient_id)+"','"+(p_pres_id)+"','"+(fr_retndate)+"','"+to_retndate+"','"+(p_encounter)+"','"+(p_ret_to_disp_locn_code)+"','"+p_locn_type+"','"+p_locn_code+"')\">Next</a>" ;
				
			records.set(0,prevnextlink);
			

		}
		catch ( Exception e ) {
			e.printStackTrace() ;	
			
			throw e ;
			//System.err.println(e.toString());

		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
			es.printStackTrace() ;
			}
		}

		return records;
	}
	


}
