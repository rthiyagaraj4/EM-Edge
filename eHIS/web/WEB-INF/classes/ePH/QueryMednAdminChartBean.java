/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 //saved on 29/10/2005 
package ePH;
import java.io.* ;
import java.util.* ;
import java.sql.* ;
/*import javax.rmi.* ;
import javax.naming.* ;*/
import ePH.Common.* ;
import eCommon.Common.* ;
//import ePH.Parameter.*;
import javax.servlet.* ;
import javax.servlet.http.*;
import oracle.sql.*;

public class QueryMednAdminChartBean extends PhAdapter implements Serializable {


	public QueryMednAdminChartBean(){
        try {
            doCommon();
        }
		catch(Exception e){
			e.printStackTrace();	
		}
	}
	public String getFacilityId(){
		return login_facility_id;
	}

	public HashMap loadSchDates(String encounter_id) {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		HashMap sch_dates			= new HashMap();
		ArrayList past_records		= new ArrayList();
		ArrayList future_records	= new ArrayList();

		String addn_qry				= "";
 		try{
			connection	= getConnection();
			addn_qry	=" AND TRUNC(SCH_DATE_TIME) <= TRUNC(SYSDATE) ORDER BY SCH_DATE";
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_SELECT15")+addn_qry);
			pstmt.setString( 1, encounter_id);
			pstmt.setString( 2, login_facility_id);
			resultSet	= pstmt.executeQuery() ;
			while( resultSet != null && resultSet.next() )	{
				past_records.add((String) resultSet.getString("SCH_DATE_TIME"));
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			addn_qry	=" AND TRUNC(SCH_DATE_TIME) > TRUNC(SYSDATE) ORDER BY SCH_DATE";
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_SELECT15")+addn_qry);
			pstmt.setString( 1, encounter_id);
			pstmt.setString( 2, login_facility_id);
			resultSet	= pstmt.executeQuery() ;
			while( resultSet != null && resultSet.next() )	{
				future_records.add((String) resultSet.getString("SCH_DATE_TIME"));
			}
			
			sch_dates.put("past_records",past_records);
			sch_dates.put("future_records",future_records);

		}
		catch ( Exception e )	{
			e.printStackTrace() ;				
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return sch_dates;	
	}

	public ArrayList getDates(String from_date, String to_date) {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList sch_dates			= new ArrayList();
 		try{
			connection	= getConnection();

			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_SELECT16"));
			pstmt.setString( 1, from_date);
			pstmt.setString( 2, to_date);
			pstmt.setString( 3, from_date);
			resultSet	= pstmt.executeQuery() ;
			while( resultSet != null && resultSet.next() )	{
				sch_dates.add((String) resultSet.getString("DIFF_DATE"));
			}
		}
		catch ( Exception e )	{
			e.printStackTrace() ;				
		} 
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return sch_dates;	
	}

	public ArrayList getEncounterPatientClass(String patient_id) {  // Changed type and method from String getEncounter(String patient_id)  to ArrayList getEncounterPatientClass(String patient_id) for ML-BRU-SCF-0499[IN035594]
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		//String encounter_id			= "";// Comment for ML-BRU-SCF-0499[IN035594]
		//String patient_class			= "";// comment for ML-BRU-SCF-0499[IN035594]
		ArrayList encounter_patientclass    = new ArrayList();
		String id_class =""; // added for ML-BRU-SCF-0499[IN035594]
		
 		try{
			connection	= getConnection();
			//pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_QUERY_MED_ADMIN_SELECT7"));
			pstmt		= connection.prepareStatement("SELECT ENCOUNTER_ID,PATIENT_CLASS FROM PR_ENCOUNTER WHERE PATIENT_ID= ? AND FACILITY_ID=? ORDER BY VISIT_ADM_DATE_TIME DESC ");// Changed table name from IP_OPEN_ENCOUNTER to PR_ENCOUNTER  for ML-BRU-SCF-0499 [IN035594]	& 'ORDER BY VISIT_ADM_DATE_TIME DESC' added for SKR-SCF-0721[IN036365] 			
			pstmt.setString( 1, patient_id);
			pstmt.setString( 2, login_facility_id);
			resultSet	= pstmt.executeQuery() ;
			//if( resultSet != null && resultSet.next() )	{// Comment for ML-BRU-SCF-0499 [IN035594]
			while( resultSet != null && resultSet.next() )	{
				//encounter_id	=	checkForNull((String) resultSet.getString("ENCOUNTER_ID"));// Comment for ML-BRU-SCF-0499 [IN035594]
				// patient_class	=	checkForNull((String) resultSet.getString("PATIENT_CLASS"));// Comment for ML-BRU-SCF-0499 [IN035594]
				id_class =  checkForNull((String) resultSet.getString("ENCOUNTER_ID"));
				id_class = id_class + "~";
				id_class = id_class + checkForNull((String) resultSet.getString("PATIENT_CLASS"));
				encounter_patientclass.add(id_class);
				id_class =""; 
			}
		}
		catch ( Exception e )	{
			e.printStackTrace() ;				
		} 
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}					
		//return encounter_id+"~"+patient_class;			
		return encounter_patientclass;	//return  only the encounter_id for ML-BRU-SCF-0499[IN035594]
	}

	public ArrayList populateNursingUnit(String facility_id,String user_id){
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList nursing_unit_list	= new ArrayList();

 		try{
			connection	= getConnection();
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_SELECT2"));
			pstmt.setString( 1, login_facility_id);
			pstmt.setString( 2, login_by_id);
			pstmt.setString( 3, login_facility_id);
			pstmt.setString(4,getLanguageId());

			resultSet	= pstmt.executeQuery() ;
			while( resultSet != null && resultSet.next() ){
				nursing_unit_list.add((String) resultSet.getString("NURSING_UNIT_CODE"));
				nursing_unit_list.add((String) resultSet.getString("SHORT_DESC"));
			}
		}
		catch ( Exception e )	{
			 nursing_unit_list.add(e.toString());
			e.printStackTrace() ;
		}
		finally {
			  try{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
			}
			catch(Exception es){es.printStackTrace();}
		}
		return nursing_unit_list;
	}

	public ArrayList getRecord(String past_date,String future_date,String to_date,String from_date,String encounter_id,String dishdflg,String orderby){//Added dishdflg,orderby for ML-BRU-SCF-1177
		String to_date1=to_date;
		String from_date1=from_date;
		String id=encounter_id;
		String p_date=past_date;
		String f_date=future_date;
		
		Connection connection 		= null;
		PreparedStatement pstmt1 	= null;
		PreparedStatement pstmt2 	= null;
		PreparedStatement pstmt3 	= null;
		PreparedStatement pstmt4 	= null;
		PreparedStatement pstmt5    = null;
		PreparedStatement pstmt6    = null;
		ResultSet resultSet1 		= null;
		ResultSet resultSet2 		= null;
		ResultSet resultSet3 		= null;
		ResultSet resultSet4 		= null;
		ResultSet resultSet5 		= null;
		ResultSet resultSet6 		= null;
		String te_date="";
		String temp_drug_code="";
		String disc_date_time="";//Added for ML-BRU-SCF-1177
		String hold_date_time="";//Added for ML-BRU-SCF-1177
		String can_date_time="";//Added for ML-BRU-SCF-1177
		String pract_name="";//Added for ML-BRU-SCF-1177
		String MFR_YN="";
		String temp_drug_strength="";
		String temp_drug_desc="";
		String order_id="";
		String tt_time="";
		String tt_qty="";
		String t_date="";
		String query1="";
		String dishdflgqry="";//Added for ML-BRU-SCF-1177
		String query2="";
		String query3="";
		//String query4="";
		String query5="";
		String query6="";
		String admin_recorded_yn="";
		String admin_recorded_date_time="";
		String administered_yn="";
		String admin_date_time="";
		String admin_not_recorded_flag="N";
		String admin_due_flag="N";
		String adr_remarks="";
		String adr_recorded_date_time="";
		String adr_recorded_by="";
        String adr_reson_code=" ";
		String adr_detail_flag="N";
		String pract_type="";
		String added_by_id="";
		String order_id1="";
		String order_line_num1="";
		String order_line_status="";
		String drug_class="";
		String sliding_scale_yn="";						
		String sliding_scale_range_unit="";						
		String sliding_scale_range_uom="";						
		String sliding_scale_adm_unit="";							
		String sliding_scale_adm_uom="";	
		String freq_nat="";	
		String medn_brought_by_patient_yn="";	
		String sch_date_time="";//Added for ML-BRU-SCF-1177
		String freq_code="";	
		String split_dose_yn = "";//ML-MMOH-SCF-1529
		String dosage = "";//ML-MMOH-SCF-1529
		int r=0;
		
		HashMap hm1=null;
		HashMap hm2=null;
		HashMap hm3=null;
		ArrayList patient_details = new ArrayList();
		ArrayList al_times=null;
		ArrayList al1 = null;
		ArrayList al2 = null;
		ArrayList temp_al=null;
		ArrayList dates=new ArrayList();
		String dosage_seq_no=""; //Added for PMG2014-CRF-0026 [IN:052701]
 		try{
			connection	= getConnection();

			if(!p_date.equals("")){
				query1=PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT20A")+" and trunc(sch_date_time)=TO_DATE(?,'DD/mm/yyyy HH24:MI') order by sch_date";
				pstmt1		= connection.prepareStatement(query1); 
				pstmt1.setString(1,id);
				pstmt1.setString(2,p_date);
			}
			else if(!f_date.equals("")){
				query1=PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT20A")+" and trunc(sch_date_time)=TO_DATE(?,'DD/mm/yyyy HH24:MI') order by sch_date";
				pstmt1		= connection.prepareStatement(query1); 
				pstmt1.setString(1,id);
				pstmt1.setString(2,f_date);
			}
			else if(to_date1.equals("") && from_date.equals("")){					
				query1=PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT20A")+"order by sch_date";
				pstmt1		= connection.prepareStatement(query1); 
				pstmt1.setString(1,id);	
			}
			else {
				query1=PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT20A")+" and TO_DATE(sch_date_time,'dd/mm/rrrr')  BETWEEN TO_DATE(?,'dd/mm/yyyy')  AND TO_DATE(?,'dd/mm/yyyy') order by sch_date";
				pstmt1		= connection.prepareStatement(query1); 
				pstmt1.setString(1,id);
				pstmt1.setString(2,to_date1);
				pstmt1.setString(3,from_date1);
			}

			resultSet1	= pstmt1.executeQuery() ;
			while( resultSet1 != null && resultSet1.next() ){  
				te_date=resultSet1.getString(1);
				dates.add(te_date);
				//***** for the purpose of getting differnt dates
			}
			// declaration stmts starts here
			dishdflgqry = "AND d.HOLD_DATE_TIME IS NULL AND d.DISC_DATE_TIME IS NULL AND d.CAN_DATE_TIME IS NULL";//Added for ML-BRU-SCF-1177
			//query2	=	PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT21")+"and encounter_id=? order by 1";
			query2 = "select distinct TO_CHAR(SCH_DATE_TIME,'HH24:MI'), a.dosage_seq_no from ph_medn_admin A,OR_ORDER_LINE B, am_frequency f where  trunc(SCH_DATE_TIME)=to_date(?,'dd/mm/yyyy')  AND A.ORDER_ID=B.ORDER_ID AND A.ORDER_LINE_NUM=B.ORDER_LINE_NUM AND ORDER_LINE_STATUS!='CN' and b.FREQ_CODE = F.FREQ_CODE and encounter_id=? order by 1";//removed f.freq_nature due to AAKH-SCF-0253 [IN:059491]
			pstmt2	= connection.prepareStatement(query2);

			//query3=PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT22"); 
			/*	query3="SELECT DISTINCT a.ord_drug_code, a.sch_dosage_uom_code,(CASE  WHEN (c.iv_prep_yn = '7' OR c.iv_prep_yn = '8')  THEN (CASE  WHEN a.ord_drug_code = 'FINAL PRODUCT' THEN (SELECT mfg_unit   FROM ph_tpn_worksheet_hdr   WHERE order_id = a.order_id and rownum<2)  WHEN a.ord_drug_code <> 'FINAL PRODUCT'   THEN (SELECT long_name FROM ph_tpn_regimen_lang_vw ph_tpn_regimen WHERE tpn_regimen_code = a.ord_drug_code and language_id = ?) END ) ELSE (CASE WHEN a.ord_drug_code = 'FINAL PRODUCT'  THEN (SELECT mfg_unit  FROM ph_worksheet_hdr   WHERE order_id = a.order_id and rownum<2) WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN b.drug_desc  END ) END ) drug_desc,  a.order_id, a.order_line_num,d.order_line_status,b.drug_class,e.pract_type,d.FREQ_CODE FROM ph_medn_admin a, ph_drug_lang_vw b, or_order c,or_order_line d ,am_practitioner_lang_vw e WHERE TRUNC (sch_date_time) = TO_DATE (?, 'dd/mm/yyyy')  AND a.ord_drug_code = b.drug_code(+)AND a.encounter_id = ?  AND a.order_id = c.order_id	AND a.order_id = d.order_id	AND a.order_line_num = d.order_line_num	 AND a.patient_id = c.patient_id  and c.ord_pract_id =e.practitioner_id and b.language_id(+) = ?  and e.language_id = ? AND ORDER_LINE_STATUS!='CN' ORDER BY a.order_id, a.order_line_num"; */

			/*====================Query modified for displaying the alternate dispensed drug===========================================*/
			if(dishdflg.equalsIgnoreCase("N"))//Modified for ML-BRU-SCF-1177--start
			query3=" SELECT DISTINCT a.ord_drug_code, a.sch_dosage_uom_code,(CASE  WHEN (c.iv_prep_yn = '7' OR c.iv_prep_yn = '8')  THEN (CASE  WHEN a.ord_drug_code = 'FINAL PRODUCT' THEN (SELECT mfg_unit   FROM ph_tpn_worksheet_hdr   WHERE order_id = a.order_id and rownum<2)  WHEN a.ord_drug_code <> 'FINAL PRODUCT'   THEN (SELECT long_name FROM ph_tpn_regimen_lang_vw ph_tpn_regimen WHERE tpn_regimen_code = a.ord_drug_code and language_id = ?) END ) ELSE (CASE WHEN a.ord_drug_code = 'FINAL PRODUCT'  THEN (SELECT mfg_unit  FROM ph_worksheet_hdr   WHERE order_id = a.order_id and rownum<2) WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN nvl((SELECT drug_desc FROM ph_drug_lang_vw ph_drug, ph_disp_dtl  WHERE /*ph_disp_dtl.disp_drug_code = ph_drug.drug_code*/ a.ord_drug_code = ph_drug.drug_code AND ph_disp_dtl.order_id = d.order_id 	   					  AND ph_disp_dtl.order_line_no = d.order_line_num AND ph_drug.language_id = ? AND ROWNUM < 2),b.DRUG_DESC)    END ) END ) drug_desc,  a.order_id, a.order_line_num,d.order_line_status,b.drug_class,e.pract_type,d.FREQ_CODE, f.MFR_YN, TO_CHAR(d.DISC_DATE_TIME,'DD/mm/yyyy HH24:MI')disc_date_time , e.PRACTITIONER_NAME,TO_CHAR(d.HOLD_DATE_TIME,'DD/mm/yyyy HH24:MI')hold_date_time,TO_CHAR(d.CAN_DATE_TIME,'DD/mm/yyyy HH24:MI')can_date_time,SPLIT_DOSE_YN, d.QTY_VALUE dosage  FROM ph_medn_admin a, ph_drug_lang_vw b, or_order c,or_order_line d ,am_practitioner_lang_vw e,or_order_line_ph f WHERE TRUNC (sch_date_time) = TO_DATE (?, 'dd/mm/yyyy')  AND a.ord_drug_code = b.drug_code(+)AND a.encounter_id = ?  AND a.order_id = c.order_id	AND a.order_id = d.order_id	AND a.order_line_num = d.order_line_num	 AND a.patient_id = c.patient_id  and c.ord_pract_id =e.practitioner_id and b.language_id(+) = ?  and e.language_id = ? AND ORDER_LINE_STATUS!='CN' "+dishdflgqry+" and a.order_id = f.order_id	AND a.order_line_num = f.order_line_num ORDER BY a.order_id, a.order_line_num ";///*ph_disp_dtl.disp_drug_code = ph_drug.drug_code*/ commented for CRF-0399	and SPLIT_DOSE_YN, d.QTY_VALUE dosage  for ML-MMOH-SCF-1529	
			
			else if(dishdflg.equalsIgnoreCase("Y") && orderby.trim().length()>0 && orderby.equalsIgnoreCase("status"))
			query3="select * from (SELECT DISTINCT a.ord_drug_code, a.sch_dosage_uom_code,(CASE  WHEN (c.iv_prep_yn = '7' OR c.iv_prep_yn = '8')  THEN (CASE  WHEN a.ord_drug_code = 'FINAL PRODUCT' THEN (SELECT mfg_unit   FROM ph_tpn_worksheet_hdr   WHERE order_id = a.order_id and rownum<2)  WHEN a.ord_drug_code <> 'FINAL PRODUCT'   THEN (SELECT long_name FROM ph_tpn_regimen_lang_vw ph_tpn_regimen WHERE tpn_regimen_code = a.ord_drug_code and language_id = ?) END ) ELSE (CASE WHEN a.ord_drug_code = 'FINAL PRODUCT'  THEN (SELECT mfg_unit  FROM ph_worksheet_hdr   WHERE order_id = a.order_id and rownum<2) WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN nvl((SELECT drug_desc FROM ph_drug_lang_vw ph_drug, ph_disp_dtl  WHERE /*ph_disp_dtl.disp_drug_code = ph_drug.drug_code*/ a.ord_drug_code = ph_drug.drug_code AND ph_disp_dtl.order_id = d.order_id AND ph_disp_dtl.order_line_no = d.order_line_num AND ph_drug.language_id = ? AND ROWNUM < 2),b.DRUG_DESC) END ) END ) drug_desc,  a.order_id, a.order_line_num,d.order_line_status,b.drug_class,e.pract_type,d.FREQ_CODE, f.MFR_YN ,TO_CHAR(d.DISC_DATE_TIME,'DD/mm/yyyy HH24:MI')disc_date_time , e.PRACTITIONER_NAME,TO_CHAR(d.HOLD_DATE_TIME,'DD/mm/yyyy HH24:MI')hold_date_time , TO_CHAR(d.CAN_DATE_TIME,'DD/mm/yyyy HH24:MI')can_date_time,SPLIT_DOSE_YN, d.QTY_VALUE dosage FROM ph_medn_admin a, ph_drug_lang_vw b, or_order c,or_order_line d ,am_practitioner_lang_vw e,or_order_line_ph f WHERE TRUNC (sch_date_time) = TO_DATE (?, 'dd/mm/yyyy')  AND a.ord_drug_code = b.drug_code(+)AND a.encounter_id = ?  AND a.order_id = c.order_id	AND a.order_id = d.order_id	AND a.order_line_num = d.order_line_num	 AND a.patient_id = c.patient_id  and c.ord_pract_id =e.practitioner_id and b.language_id(+) = ?  and e.language_id = ? AND ORDER_LINE_STATUS!='CN' and a.order_id = f.order_id	AND a.order_line_num = f.order_line_num ORDER BY disc_date_time,hold_date_time,a.order_id, a.order_line_num) order by rownum desc ";
			//ph_disp_dtl.disp_drug_code = ph_drug.drug_code commented for BRU-CRF-399.1 and SPLIT_DOSE_YN, d.QTY_VALUE dosage  for ML-MMOH-SCF-1529	
			else if(dishdflg.equalsIgnoreCase("Y") && orderby.trim().length()>0 && orderby.equalsIgnoreCase("sch"))
				query3=" SELECT DISTINCT a.ord_drug_code, a.sch_dosage_uom_code,(CASE  WHEN (c.iv_prep_yn = '7' OR c.iv_prep_yn = '8')  THEN (CASE  WHEN a.ord_drug_code = 'FINAL PRODUCT' THEN (SELECT mfg_unit   FROM ph_tpn_worksheet_hdr   WHERE order_id = a.order_id and rownum<2)  WHEN a.ord_drug_code <> 'FINAL PRODUCT'   THEN (SELECT long_name FROM ph_tpn_regimen_lang_vw ph_tpn_regimen WHERE tpn_regimen_code = a.ord_drug_code and language_id = ?) END ) ELSE (CASE WHEN a.ord_drug_code = 'FINAL PRODUCT'  THEN (SELECT mfg_unit  FROM ph_worksheet_hdr   WHERE order_id = a.order_id and rownum<2) WHEN a.ord_drug_code <> 'FINAL PRODUCT' THEN nvl((SELECT drug_desc FROM ph_drug_lang_vw ph_drug, ph_disp_dtl  WHERE /*ph_disp_dtl.disp_drug_code = ph_drug.drug_code*/ a.ord_drug_code = ph_drug.drug_code AND ph_disp_dtl.order_id = d.order_id 	   					  AND ph_disp_dtl.order_line_no = d.order_line_num AND ph_drug.language_id = ? AND ROWNUM < 2),b.DRUG_DESC)    END ) END ) drug_desc,  a.order_id, a.order_line_num,d.order_line_status,b.drug_class,e.pract_type,d.FREQ_CODE, f.MFR_YN ,TO_CHAR(d.DISC_DATE_TIME,'DD/mm/yyyy HH24:MI')disc_date_time , e.PRACTITIONER_NAME,TO_CHAR(d.HOLD_DATE_TIME,'DD/mm/yyyy HH24:MI')hold_date_time , TO_CHAR(d.CAN_DATE_TIME,'DD/mm/yyyy HH24:MI')can_date_time,SPLIT_DOSE_YN, d.QTY_VALUE dosage FROM ph_medn_admin a, ph_drug_lang_vw b, or_order c,or_order_line d ,am_practitioner_lang_vw e,or_order_line_ph f WHERE TRUNC (sch_date_time) = TO_DATE (?, 'dd/mm/yyyy')  AND a.ord_drug_code = b.drug_code(+)AND a.encounter_id = ?  AND a.order_id = c.order_id	AND a.order_id = d.order_id	AND a.order_line_num = d.order_line_num	 AND a.patient_id = c.patient_id  and c.ord_pract_id =e.practitioner_id and b.language_id(+) = ?  and e.language_id = ? AND ORDER_LINE_STATUS!='CN' and a.order_id = f.order_id	AND a.order_line_num = f.order_line_num ORDER BY a.order_id, a.order_line_num ";	
				//ph_disp_dtl.disp_drug_code = ph_drug.drug_code commented for BRU-CRF-399.1 and SPLIT_DOSE_YN, d.QTY_VALUE dosage  for ML-MMOH-SCF-1529	
				//Modified for ML-BRU-SCF-1177--end
			/*================================================================================================================*/

			pstmt3		= connection.prepareStatement(query3); 

			//query4=PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT23")+"and encounter_id=?";
			//query4="select TO_CHAR(SCH_DATE_TIME,'HH24:MI'),sch_dosage_qty,admin_recorded_yn,TO_CHAR(admin_recorded_date_time,'DD/mm/yyyy'),administered_yn,order_id,ADR_REMARKS,ADR_RECORDED_DATE_TIME,ADR_RECORDED_BY,ADR_REASON_CODE,ADDED_BY_ID,ORDER_LINE_NUM, SLIDING_SCALE_YN, SLIDING_SCALE_RANGE_UNIT, SLIDING_SCALE_RANGE_UOM, SLIDING_SCALE_ADM_UNIT, SLIDING_SCALE_ADM_UOM, MEDN_BROUGHT_BY_PATIENT_YN from ph_medn_admin where ord_drug_code= ? and  trunc(SCH_DATE_TIME)=to_date(?,'dd/mm/yyyy') and order_id=?"+"and encounter_id=?";
			//pstmt4 = connection.prepareStatement(query4); 

			//query6=PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT14");
			//pstmt6		= connection.prepareStatement(query6);

			query5=PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT25");
			pstmt5		= connection.prepareStatement(query5);

			query6="SELECT FREQ_NATURE FROM AM_FREQUENCY WHERE FREQ_CODE=?";
			pstmt6		= connection.prepareStatement(query6);

			// declaration stmts ends here
			for(int i=0;i<dates.size();i++){
				te_date=(String)dates.get(i);
				pstmt2.setString( 1,te_date );
				pstmt2.setString(2,id);
				resultSet2	= pstmt2.executeQuery();

				al_times=new ArrayList();
				while( resultSet2 != null && resultSet2.next() ){
					if(!al_times.contains((String)resultSet2.getString(1))){    // if condition added for SKR-SCF-1143
						al_times.add((String)resultSet2.getString(1));
						
						
					}
				}
				closeResultSet(resultSet2);

				hm3=new HashMap();
				hm3.put("dates",te_date);
				hm3.put("times",al_times);
				/*================================================================================================================*/

				pstmt3.setString(1,getLanguageId());
				pstmt3.setString(2,getLanguageId());
				pstmt3.setString(3, te_date);
				pstmt3.setString(4,id);
				pstmt3.setString(5,getLanguageId());
				pstmt3.setString(6,getLanguageId());
				/*================================================================================================================*/

				resultSet3	= pstmt3.executeQuery();
				al2=new ArrayList();
				while( resultSet3 != null && resultSet3.next() ){
					order_id1="";
					hm2=new HashMap();
					temp_drug_code=checkForNull((String)resultSet3.getString(1));
					temp_drug_strength=checkForNull((String)resultSet3.getString(2));
					temp_drug_desc=checkForNull((String)resultSet3.getString(3));
					order_id1=checkForNull((String)resultSet3.getString(4));
					order_line_num1=checkForNull((String)resultSet3.getString(5));
					order_line_status=checkForNull((String)resultSet3.getString(6));
					drug_class=checkForNull((String)resultSet3.getString(7));
					pract_type=checkForNull((String)resultSet3.getString(8));
					freq_code=checkForNull((String)resultSet3.getString(9));
					MFR_YN=checkForNull((String)resultSet3.getString(10),"N");
					disc_date_time=checkForNull((String)resultSet3.getString(11));//Added for ML-BRU-SCF-1177
					pract_name=checkForNull((String)resultSet3.getString(12),"N");//Added for ML-BRU-SCF-1177
					hold_date_time=checkForNull((String)resultSet3.getString(13));//Added for ML-BRU-SCF-1177
					can_date_time=checkForNull((String)resultSet3.getString(14));//Added for ML-BRU-SCF-1177
					split_dose_yn=checkForNull((String)resultSet3.getString(15)); //ML-MMOH-SCF-1529
					dosage=checkForNull((String)resultSet3.getString(16)); //ML-MMOH-SCF-1529

					hm2.put("drug_code",temp_drug_code);
					hm2.put("drug_desc",temp_drug_desc);
					hm2.put("order_id",order_id1);
					hm2.put("order_line_num",order_line_num1);
					hm2.put("drug_strength",temp_drug_strength);
					hm2.put("order_line_status",order_line_status);
					hm2.put("drug_class",drug_class);
					hm2.put("pract_type",pract_type);
					hm2.put("mfr_yn",MFR_YN);
					hm2.put("disc_date_time",disc_date_time);//Added for ML-BRU-SCF-1177
					hm2.put("pract_name",pract_name);//Added for ML-BRU-SCF-1177
					hm2.put("hold_date_time",hold_date_time);//Added for ML-BRU-SCF-1177
					hm2.put("can_date_time",can_date_time);//Added for ML-BRU-SCF-1177
					hm2.put("split_dose_yn",split_dose_yn); //ML-MMOH-SCF-1529
					hm2.put("dosage",dosage); //ML-MMOH-SCF-1529
					pstmt6.setString(1,freq_code);						
					resultSet6	= pstmt6.executeQuery();
					while( resultSet6 != null && resultSet6.next() ){
						freq_nat= resultSet6.getString("FREQ_NATURE");
					}
					closeResultSet(resultSet6);
					if(freq_nat.equals("P")){	
						//removed for SKR-SCF-0304 decode(a.DOSAGE_SEQ_NO,2,b.dosage, a.sch_strength) in the 									
						pstmt4 = connection.prepareStatement("select TO_CHAR(a.SCH_DATE_TIME,'HH24:MI'), b.dosage sch_strength, a.admin_recorded_yn,TO_CHAR(a.admin_recorded_date_time,'DD/mm/yyyy'),a.administered_yn,a.order_id,a.ADR_REMARKS,TO_CHAR (a.ADR_RECORDED_DATE_TIME, 'DD/MM/YYYY HH24:MI') ADR_RECORDED_DATE_TIME,a.ADR_RECORDED_BY,a.ADR_REASON_CODE,a.ADDED_BY_ID,a.ORDER_LINE_NUM, a.SLIDING_SCALE_YN, a.SLIDING_SCALE_RANGE_UNIT, a.SLIDING_SCALE_RANGE_UOM, a.SLIDING_SCALE_ADM_UNIT, a.SLIDING_SCALE_ADM_UOM, a.MEDN_BROUGHT_BY_PATIENT_YN,b.DOSAGE_UOM_CODE,TO_CHAR (a.sch_date_time,'DD/mm/yyyy HH24:MI')as sch_date_time1, a.DOSAGE_SEQ_NO from ph_medn_admin a, ph_patient_drug_profile b where a.ord_drug_code= ? and  trunc(a.SCH_DATE_TIME)=to_date(?,'dd/mm/yyyy') and a.order_id=? and a.encounter_id=? and b.ORIG_ORDER_LINE_NO=? and b.ORIG_ORDER_ID=a.order_id order by 1, a.DOSAGE_SEQ_NO");//Added sch_date_time1 for ML-BRU-SCF-1177	 //  a.DOSAGE_SEQ_NO Added for PMG2014-CRF-0026 [IN:052701]
					}
					else{
						pstmt4 = connection.prepareStatement("select TO_CHAR(SCH_DATE_TIME,'HH24:MI'),sch_dosage_qty,admin_recorded_yn,TO_CHAR(admin_recorded_date_time,'DD/mm/yyyy'),administered_yn,order_id,ADR_REMARKS, TO_CHAR (ADR_RECORDED_DATE_TIME, 'DD/MM/YYYY HH24:MI') ADR_RECORDED_DATE_TIME,ADR_RECORDED_BY,ADR_REASON_CODE,ADDED_BY_ID,ORDER_LINE_NUM, SLIDING_SCALE_YN, SLIDING_SCALE_RANGE_UNIT, SLIDING_SCALE_RANGE_UOM, SLIDING_SCALE_ADM_UNIT, SLIDING_SCALE_ADM_UOM, MEDN_BROUGHT_BY_PATIENT_YN,TO_CHAR (sch_date_time,'DD/mm/yyyy HH24:MI')as sch_date_time1, DOSAGE_SEQ_NO from ph_medn_admin where ord_drug_code= ? and  trunc(SCH_DATE_TIME)=to_date(?,'dd/mm/yyyy') and order_id=? and encounter_id=? and order_line_num=? order by 1, DOSAGE_SEQ_NO"); //Added sch_date_time1 for ML-BRU-SCF-1177 //  a.DOSAGE_SEQ_NO Added for PMG2014-CRF-0026 [IN:052701]
					}
					pstmt4.setString( 1,temp_drug_code);
					pstmt4.setString( 2,te_date); 
					pstmt4.setString( 3,order_id1); 
					pstmt4.setString( 4,id);
					//if(freq_nat.equals("P")) // Condition removed for IN21700 --01/06/2010 -- priya
					//{	// and order_line_num passed to non-prn query also to avoid multiple lines in MAR chart for OP taper orders 
					pstmt4.setString( 5,order_line_num1);
					//}
					resultSet4	= pstmt4.executeQuery();
					//closeStatement(pstmt4);
					al1=new ArrayList();
					while( resultSet4 != null && resultSet4.next() ){
						tt_time=resultSet4.getString(1);
						tt_qty=resultSet4.getString(2);
						if(freq_nat.equals("P")){
							temp_drug_strength=resultSet4.getString(19);
							hm2.put("drug_strength",temp_drug_strength);
						}
						admin_recorded_yn=checkForNull(resultSet4.getString(3));
						admin_recorded_date_time=checkForNull(resultSet4.getString(4));
						administered_yn=checkForNull(resultSet4.getString(5));
						order_id=checkForNull(resultSet4.getString(6));
						adr_detail_flag="N";

						adr_remarks=checkForNull(resultSet4.getString(7));
						adr_recorded_date_time=checkForNull(resultSet4.getString(8));
						adr_recorded_by=checkForNull(resultSet4.getString(9));
						adr_reson_code=checkForNull(resultSet4.getString(10));
						added_by_id=checkForNull(resultSet4.getString(11));
						dosage_seq_no=checkForNull(resultSet4.getString("DOSAGE_SEQ_NO"),""); // Added for PMG2014-CRF-0026 [IN:052701]
						sliding_scale_yn="";						
						sliding_scale_range_unit="";						
						sliding_scale_range_uom="";						
						sliding_scale_adm_unit="";							
						sliding_scale_adm_uom="";	
						sliding_scale_yn=checkForNull(resultSet4.getString(13));
						medn_brought_by_patient_yn=checkForNull(resultSet4.getString(18));
						if(freq_nat.equals("P"))//Added for ML-BRU-SCF-1177--start
							sch_date_time = checkForNull(resultSet4.getString(20));
						else
							sch_date_time = checkForNull(resultSet4.getString(19));//Added for ML-BRU-SCF-1177--end
						if(sliding_scale_yn.equals("Y")){														
							sliding_scale_range_unit=checkForNull(resultSet4.getString(14));						
							sliding_scale_range_uom=checkForNull(resultSet4.getString(15));						
							sliding_scale_adm_unit=checkForNull(resultSet4.getString(16));							
							sliding_scale_adm_uom=checkForNull(resultSet4.getString(17));	
						}
						else{				
							sliding_scale_range_unit="";						
							sliding_scale_range_uom="";						
							sliding_scale_adm_unit="";							
							sliding_scale_adm_uom="";	
						}							
						/*	pstmt6.setString( 1,added_by_id);
						resultSet6	= pstmt6.executeQuery();
						pract_type="";
						while( resultSet6 != null && resultSet6.next() ){
						pract_type=resultSet6.getString(1);
						}
						closeResultSet(resultSet6);*/

						if(!(adr_remarks.equals("") || adr_recorded_date_time.equals("") || adr_recorded_by.equals(""))){
							adr_detail_flag="Y";			
						}
						else{ 
							adr_detail_flag="N";	
						}

						t_date="";
						admin_date_time=te_date;
						t_date=admin_date_time+" "+tt_time;

						pstmt5.setString( 1,t_date );
						resultSet5	= pstmt5.executeQuery();
						r=0;admin_due_flag="N";admin_not_recorded_flag="N";
						while( resultSet5 != null && resultSet5.next() ){
							r=resultSet5.getInt(1);
						}
						closeResultSet(resultSet5);
						if( r >= 1){ 
							admin_due_flag="N";
						}
						else { 
							admin_due_flag="Y";
						}

						if(admin_due_flag.equals("N") && !administered_yn.equals("Y") && !admin_recorded_yn.equals("Y")){
							admin_not_recorded_flag="Y";
						}
						else { 
							admin_not_recorded_flag="N";
						}
							
						hm1=new HashMap();
						hm1.put("time",tt_time);
						hm1.put("qty",tt_qty);
						hm1.put("admin_recorded_yn",admin_recorded_yn);
						hm1.put("admin_recorded_date_time",admin_recorded_date_time);
						hm1.put("administered_yn",administered_yn);
						hm1.put("admin_date_time",admin_date_time);
						hm1.put("order_id",order_id);
						hm1.put("admin_due_flag",admin_due_flag);
						hm1.put("admin_not_recorded_flag",admin_not_recorded_flag);
						hm1.put("adr_detail_flag",adr_detail_flag);
						hm1.put("adr_remarks",adr_remarks);
						hm1.put("adr_recorded_date_time",adr_recorded_date_time);
						hm1.put("adr_recorded_by",adr_recorded_by);
						hm1.put("adr_reson_code",adr_reson_code);
						hm1.put("sliding_scale_yn",sliding_scale_yn);
						hm1.put("sliding_scale_range_unit",sliding_scale_range_unit);
						hm1.put("sliding_scale_range_uom",sliding_scale_range_uom);
						hm1.put("sliding_scale_adm_unit",sliding_scale_adm_unit);
						hm1.put("sliding_scale_adm_uom",sliding_scale_adm_uom);							
						hm1.put("medn_brought_by_patient_yn",medn_brought_by_patient_yn);							
						hm1.put("sch_date_time1",sch_date_time);//Added for ML-BRU-SCF-1177
						hm1.put("DOSAGE_SEQ_NO",dosage_seq_no); // Added for PMG2014-CRF-0026 [IN:052701]
						//hm1.put("pract_type",pract_type);

						al1.add(hm1);
					}
					closeResultSet(resultSet4);
					closeStatement(pstmt4);
					temp_al=new ArrayList();
					temp_al=reformat(al_times,al1);

					hm2.put("qty",temp_al);
					al2.add(hm2);
				}
				closeResultSet(resultSet3);
				hm3.put("desc_qty",al2);
				patient_details.add(hm3);
			}
		}
		catch ( Exception e )	{
			patient_details.add(e.toString());
			e.printStackTrace() ;

		} 
		finally {
			try{
				closeResultSet(resultSet1);
				closeResultSet(resultSet2);
				closeResultSet(resultSet3) ;
				closeResultSet(resultSet4);
				closeResultSet(resultSet5);
				closeResultSet(resultSet6);
				closeStatement(pstmt1);
				closeStatement(pstmt2);
				closeStatement(pstmt3);
				closeStatement(pstmt4);
				closeStatement(pstmt5);
				closeStatement(pstmt6);
				closeConnection(connection);
			}
			catch(Exception es){es.printStackTrace();}
		}
		return patient_details;
	}


	public static ArrayList reformat(ArrayList all_times,ArrayList sch_times){
		ArrayList sch_qty=new ArrayList();
		HashMap hm=new HashMap();
		HashMap hm1=null;
		
		String temp1="";
		String temp2="";
		String temp3="";
		String admin_recorded_yn="";
		String admin_recorded_date_time="";
		String administered_yn="";
		String admin_date_time="";
		String order_id="";
		String admin_not_recorded_flag="N";
		String admin_due_flag="N";
		String adr_detail_flag="N";
		String adr_remarks="";
		String adr_recorded_date_time="";
		String adr_recorded_by="";
		String adr_reson_code=" ";
		String pract_type="";
		String sliding_scale_yn="";	
		String sliding_scale_range_unit="";	
		String sliding_scale_range_uom="";	
		String sliding_scale_adm_unit="";	
		String sliding_scale_adm_uom="";
		String medn_brought_by_patient_yn="";	
		String sch_date_time1="";	//Added for ML-BRU-SCF-1177
		String dosage_seq_no = ""; // Added for PMG2014-CRF-0026 [IN:052701]
		int sch=sch_times.size();
		int all=all_times.size();
		if(all == sch){
			for(int i=0;i<sch;i++){
				hm1=new HashMap();
				hm=(HashMap)sch_times.get(i);
				hm1.put("order_id",(String)hm.get("order_id"));
				hm1.put("admin_recorded_yn",(String)hm.get("admin_recorded_yn"));
				hm1.put("admin_recorded_date_time",(String)hm.get("admin_recorded_date_time"));
				hm1.put("administered_yn",(String)hm.get("administered_yn"));
				hm1.put("admin_date_time",(String)hm.get("admin_date_time"));
				hm1.put("f_qty",(String)hm.get("qty"));
				hm1.put("admin_due_flag",(String)hm.get("admin_due_flag"));
				hm1.put("admin_not_recorded_flag",(String)hm.get("admin_not_recorded_flag"));
				hm1.put("adr_detail_flag",(String)hm.get("adr_detail_flag"));
				hm1.put("adr_remarks",(String)hm.get("adr_remarks"));
				hm1.put("adr_recorded_date_time",(String)hm.get("adr_recorded_date_time"));
				hm1.put("adr_recorded_by",(String)hm.get("adr_recorded_by"));
				hm1.put("adr_reson_code",(String)hm.get("adr_reson_code"));
				hm1.put("pract_type",(String)hm.get("pract_type"));
				hm1.put("sliding_scale_yn",(String)hm.get("sliding_scale_yn"));
				hm1.put("sliding_scale_range_unit",(String)hm.get("sliding_scale_range_unit"));
				hm1.put("sliding_scale_range_uom",(String)hm.get("sliding_scale_range_uom"));
				hm1.put("sliding_scale_adm_unit",(String)hm.get("sliding_scale_adm_unit"));
				hm1.put("sliding_scale_adm_uom",(String)hm.get("sliding_scale_adm_uom"));							
				hm1.put("medn_brought_by_patient_yn",(String)hm.get("medn_brought_by_patient_yn"));							
				hm1.put("sch_date_time1",(String)hm.get("sch_date_time1"));//Added for ML-BRU-SCF-1177
				hm1.put("DOSAGE_SEQ_NO",(String)hm.get("DOSAGE_SEQ_NO")); // Added for PMG2014-CRF-0026 [IN:052701]
				sch_qty.add(hm1);
			}
		}
		else{
			for(int i=0;i<all;i++){
				hm1=new HashMap();
				temp1=(String)all_times.get(i);
				for(int j=0;j<sch;j++){
					hm=(HashMap)sch_times.get(j);
					temp2=(String)hm.get("time");
									 
					if(temp2.equals(temp1)){
						temp3=(String)hm.get("qty");
						admin_recorded_yn=(String)hm.get("admin_recorded_yn");
						admin_recorded_date_time=(String)hm.get("admin_recorded_date_time");
						administered_yn=(String)hm.get("administered_yn");
						admin_date_time=(String)hm.get("admin_date_time");
						order_id=(String)hm.get("order_id");
						admin_due_flag=(String)hm.get("admin_due_flag");
						adr_detail_flag=(String)hm.get("adr_detail_flag");
						adr_remarks=(String)hm.get("adr_remarks");
						adr_recorded_date_time=(String)hm.get("adr_recorded_date_time");
						adr_recorded_by=(String)hm.get("adr_recorded_by");
						adr_reson_code=(String)hm.get("adr_reson_code");
						pract_type=(String)hm.get("pract_type");
						sliding_scale_yn=(String)hm.get("sliding_scale_yn");
						sliding_scale_range_unit=(String)hm.get("sliding_scale_range_unit");
						sliding_scale_range_uom=(String)hm.get("sliding_scale_range_uom");
						sliding_scale_adm_unit=(String)hm.get("sliding_scale_adm_unit");
						sliding_scale_adm_uom=(String)hm.get("sliding_scale_adm_uom");
						medn_brought_by_patient_yn=(String)hm.get("medn_brought_by_patient_yn");
						sch_date_time1 =(String)hm.get("sch_date_time1"); //Added for ML-BRU-SCF-1177
						dosage_seq_no =(String)hm.get("DOSAGE_SEQ_NO"); // Added for PMG2014-CRF-0026 [IN:052701]
						break;
					}
					if(j==(sch-1) && !temp2.equals(temp1)){
						temp3="";
						admin_recorded_yn="";
						admin_recorded_date_time="";
						administered_yn="";
						admin_date_time="";
						order_id="";
						admin_not_recorded_flag="N";
						admin_due_flag="N";
						adr_detail_flag="N";
						adr_remarks="";
						adr_recorded_date_time="";
						adr_recorded_by="";
						adr_reson_code="";
						pract_type="";
						sliding_scale_yn="";
						sliding_scale_range_unit="";
						sliding_scale_range_uom="";
						sliding_scale_adm_unit="";
						sliding_scale_adm_uom="";
						medn_brought_by_patient_yn="";
						sch_date_time1 = "";//Added for ML-BRU-SCF-1177
						dosage_seq_no = ""; // Added for PMG2014-CRF-0026 [IN:052701]
					}
				}
				hm1.put("order_id",order_id);
				hm1.put("admin_recorded_yn",admin_recorded_yn);
				hm1.put("admin_recorded_date_time",admin_recorded_date_time);
				hm1.put("administered_yn",administered_yn);
				hm1.put("admin_date_time",admin_date_time);
				hm1.put("f_qty",temp3);
				hm1.put("admin_due_flag",admin_due_flag);
				hm1.put("admin_not_recorded_flag",admin_not_recorded_flag);
				hm1.put("adr_detail_flag",adr_detail_flag);
				hm1.put("adr_remarks",adr_remarks);
				hm1.put("adr_recorded_date_time",adr_recorded_date_time);
				hm1.put("adr_recorded_by",adr_recorded_by);
				hm1.put("adr_reson_code",adr_reson_code);
				hm1.put("pract_type",pract_type);
				hm1.put("sliding_scale_yn",sliding_scale_yn);
				hm1.put("sliding_scale_range_unit",sliding_scale_range_unit);
				hm1.put("sliding_scale_range_uom",sliding_scale_range_uom);
				hm1.put("sliding_scale_adm_unit",sliding_scale_adm_unit);
				hm1.put("sliding_scale_adm_uom",sliding_scale_adm_uom);		 			  		  
				hm1.put("medn_brought_by_patient_yn",medn_brought_by_patient_yn);		 			  		  
				hm1.put("sch_date_time1",sch_date_time1);//Added for ML-BRU-SCF-1177
				hm1.put("DOSAGE_SEQ_NO",dosage_seq_no);// Added for PMG2014-CRF-0026 [IN:052701]
				sch_qty.add(hm1);
			}
			 			   
		}
		return sch_qty;  
	}
 
	public HashMap populateScheduleDetails(String facil_id,String encounter_id,String from_date,String to_date,String helddisc){
		Connection connection       = null ;
        CallableStatement cstmt     = null ;
        ResultSet resultSet         = null ;
		HashMap scheduleDetails		= new HashMap();
		try{
			connection				= getConnection() ;
			cstmt=connection.prepareCall("{call Ph_Query_Medn_Admin_Timings(?,?,?,?,?,?,?,?,?,?,?,?)}");

			cstmt.setString( 1, login_facility_id);
			cstmt.setString( 2, encounter_id);
			cstmt.setString( 3, from_date);
			cstmt.setString( 4, to_date);
			cstmt.setString( 5, helddisc);
		
			cstmt.registerOutParameter(6, Types.INTEGER );
		
			cstmt.registerOutParameter(7, Types.VARCHAR );
			cstmt.registerOutParameter(8, Types.VARCHAR );
			cstmt.registerOutParameter(9, Types.VARCHAR );
			cstmt.registerOutParameter(10, Types.VARCHAR );
			cstmt.registerOutParameter(11, Types.VARCHAR );
			cstmt.registerOutParameter(12, Types.VARCHAR );
			
			cstmt.execute() ;
		
			scheduleDetails.put("COL_COUNT", cstmt.getString(6));
			scheduleDetails.put("COL_TIMINGS",cstmt.getString( 7 ));
			scheduleDetails.put("DIS_YN",cstmt.getString( 8 ));
			scheduleDetails.put("HOLD_YN",cstmt.getString( 9 ));
			scheduleDetails.put("NO_DATE",cstmt.getString( 10));
			scheduleDetails.put("DATE_DETAILS",cstmt.getString( 11));
			scheduleDetails.put("SCH_DETAILS",cstmt.getString( 12 ));
			
		}
		catch ( Exception e ) {
			scheduleDetails.put("ERROR",e);
            e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( cstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){es.printStackTrace();}
        }
		return scheduleDetails;
	}
	public String getSysdate(){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sys_date				= "";
		try{
			connection				= getConnection() ;
			String str_qry			= PhRepository.getPhKeyValue("SQL_QUERY_MED_ADMIN_SELECT5");
			pstmt					= connection.prepareStatement(str_qry) ;
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				sys_date=resultSet.getString(1);
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){es.printStackTrace();}
        }
		return sys_date;
	}
	private void doCommon() throws Exception {
	}

	public String getPatientIDLength(){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	pat_txt_length	=	null ;

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_COMMON_SELECT1") ) ;
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				pat_txt_length	=	checkForNull(resultSet.getString("PATIENT_ID_LENGTH"));
			}						
		}
		catch(Exception e){
				pat_txt_length	=e.toString();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();	
			}
		}
		return pat_txt_length;	
	}

	public String checkIVOrder(String order_id){
	    Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;
		String iv_prep_yn="";
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT27") ) ;
			pstmt.setString(1,order_id);
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				iv_prep_yn	= resultSet.getString(1);
				if(iv_prep_yn == null){iv_prep_yn="";}
			}						
		}
		catch(Exception e){
				iv_prep_yn=e.toString();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();	
			}
		}
		return iv_prep_yn;	

	}

	public String getAdmn_chng_dose_reason_desc(String reason_code){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;
		String sql = "";
		String reason_desc ="";
		try{
			connection			= getConnection() ;
			sql ="SELECT REASON_DESC FROM PH_MEDN_TRN_REASON_LANG_VW WHERE APPL_TRN_TYPE='DM' AND REASON_CODE =? AND LANGUAGE_ID=?";

			pstmt				= connection.prepareStatement( sql) ;
			pstmt.setString(1,reason_code);
			pstmt.setString(2,getLanguageId());
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				reason_desc	= resultSet.getString("REASON_DESC");
			}						
		}
		catch(Exception e){
				System.out.println(e.toString());
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return reason_desc;	
	}

	//Code added for RUT-SCF-0093 IN 32106 -Start
	public String getUserName(String user_id,String language_id){
		String user_name		="";
		Connection oConnection				= null;		
		PreparedStatement oPreparedStmt		= null;      		
		ResultSet oResultSet				= null;
		try{  
			oConnection	= getConnection() ;
			String sqlString="select appl_user_name from SM_APPL_USER_LANG_VW where APPL_USER_ID =? and language_id=?";
			oPreparedStmt		= oConnection.prepareStatement(sqlString);
			oPreparedStmt.setString(1,user_id);	
			oPreparedStmt.setString(2,language_id);
			oResultSet	= oPreparedStmt.executeQuery() ;
			if(oResultSet !=null && oResultSet.next()){
				user_name=oResultSet.getString("appl_user_name");	
				if(user_name==null || user_name==""){
					user_name=user_id;
					
				}
			}
			else{
				user_name=user_id;
			}
		}
		catch (Exception execption){
			execption.printStackTrace();
		}
		finally{
			try{
				closeResultSet( oResultSet ) ;
				closeStatement(oPreparedStmt);
				closeConnection(oConnection); 
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return user_name;
	}
	//Code added for RUT-SCF-0093 IN 32106 -End

	public String getAltDosageDetails(String pres_drug_code,String alt_drug_code,String order_id,String order_line_no) throws Exception{
		Connection connection = null;
		PreparedStatement pstmt	= null;
		PreparedStatement pstmt1 = null;
		ResultSet resultSet		= null;
		ResultSet resultSet1	= null;
		String dosage_dtl	    = "";
		String dosage			= "";
		String pres_base_uom	= "";
		try {

			connection	= getConnection() ;
			

			pstmt		= connection.prepareStatement( "select ph_alt_drug_dosage_details(?,?,?,?,?,?) dosage_dtl from dual") ; //changed ph_dosage_details to ph_alt_dosage_details  for CRF-0399.1
			pstmt.setString(1,login_facility_id);  
			pstmt.setString(2,getLanguageId());
			pstmt.setString(3,pres_drug_code);  
			pstmt.setString(4,alt_drug_code);
			pstmt.setString(5,order_id);
			pstmt.setString(6,order_line_no);
			resultSet	= pstmt.executeQuery() ;
			if(resultSet!=null && resultSet.next()){
			  dosage_dtl= checkForNull(resultSet.getString("DOSAGE_DTL"));
				dosage = (String)dosage_dtl.split(" ")[0];
				if(dosage==null|| dosage.equals(""))
					dosage = "0";

			}
			pstmt1		= connection.prepareStatement( "select PRES_BASE_UOM from ph_drug where drug_code=?") ; 
			pstmt1.setString(1,alt_drug_code);  
			resultSet1	= pstmt1.executeQuery() ;
			if(resultSet1!=null && resultSet1.next()){
				pres_base_uom = checkForNull(resultSet1.getString("PRES_BASE_UOM"));
			}
			

			
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeStatement( pstmt1 ) ;
			closeResultSet( resultSet1 ) ;
			closeConnection( connection );
		}
		return dosage+"~"+pres_base_uom+"~"+getUomDisplay(login_facility_id,checkForNull(pres_base_uom));
	}
//added for BRU-CRF-399.1 - start
public String getAltDrugDesc(String order_id,String order_line_no) throws Exception{
		Connection connection = null;
		PreparedStatement pstmt	= null;
		//PreparedStatement pstmt1 = null;
		ResultSet resultSet		= null;
		//ResultSet resultSet1	= null;
		String alt_desc	    = "";
		 
		try {

			connection	= getConnection() ;
			pstmt		= connection.prepareStatement("SELECT distinct (select drug_desc from ph_drug where drug_code= f.admin_drug_code) alt_desc   FROM ph_medn_admin a, ph_medn_admin_dtl f WHERE  f.facility_id = a.facility_id    AND f.encounter_id = a.encounter_id   AND f.order_id = a.order_id    AND f.sch_date_time = a.sch_date_time    AND f.ord_drug_code = a.ord_drug_code   AND f.ord_drug_code != f.admin_drug_code    AND a.dosage_seq_no = f.dosage_seq_no AND a.order_id = f.order_id   and a.order_id = ? and order_line_num = ?") ; 
		
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_no);
			resultSet	= pstmt.executeQuery() ;
			if(resultSet!=null && resultSet.next()){
			  alt_desc= checkForNull(resultSet.getString("alt_desc"));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}
		return alt_desc;
	}
//added for BRU-CRF-399.1 - end
//added for ML-MMOH-SCF-1674 - start
	public String getSplitDosage(String orderid,String order_line_num,String sch_time)throws Exception{

		Connection connection = null ;
        PreparedStatement pstmt = null ;
        String sch_dosage="";
		ResultSet resultSet		= null ;
        try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement("SELECT ORDER_LINE_DOSE_QTY_VALUE FROM OR_ORDER_LINE_FIELD_VALUES WHERE ORDER_ID=? AND ORDER_LINE_FIELD_MNEMONIC='SCHED_ADMIN_TIME'  AND ORDER_LINE_NUM=? AND ORDER_LINE_FIELD_VALUE=?");
		    pstmt.setString(1,orderid);
			pstmt.setString(2,order_line_num);
			pstmt.setString(3,sch_time);
			
			 
			  resultSet = pstmt.executeQuery();
			if( resultSet != null && resultSet.next() ) {
					sch_dosage=resultSet.getString("ORDER_LINE_DOSE_QTY_VALUE");
			}
        }catch ( Exception e ) {

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
				es.printStackTrace();
			}
        }
		return sch_dosage;
	}
//added for ML-MMOH-SCF-1674 - end	
}
