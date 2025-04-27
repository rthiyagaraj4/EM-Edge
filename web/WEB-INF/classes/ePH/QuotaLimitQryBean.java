
/*

Date        Edit History    Name                Rev.Date    Rev.Name        Description
------------------------------------------------------------------------------------------------------------------------------
03/05/2023		TFS-43531  Raja Hanumanthu		04/05/2023	Ramesh Goli   ML-MMOH-CRF-1823
05/09/2023		TFS-45628      Raja Hanumanthu		05/09/2023	Ramesh Goli   ML-MMOH-CRF-1823.1

------------------------------------------------------------------------------------------------------------------------------
*/
package ePH ;
import java.io.* ;
import java.util.* ;
import java.sql.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
import webbeans.eCommon.ConnectionManager;

public class QuotaLimitQryBean extends PhAdapter implements Serializable {
	
	public ArrayList getDrugName(String locale,String patient_id,String drug_code,String splCode,String p_ord_fm_date,String p_ord_to_date){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		ArrayList	finalRecords		=	new ArrayList();
		
		try{
			/*pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PACT_BY_SPEC_DRUG_QUERY_SELECT2") ) ;*/ 
	    	/*String query01 =  "SELECT a.patient_id patient_id, DECODE ('"+locale+"', 'en', d.patient_name, '"+locale+"', NVL (d.patient_name_loc_lang, d.patient_name) ) || '/' || get_age (d.date_of_birth) || '/' || DECODE (d.sex, 'M', 'Male', 'F', 'Female', 'Unknown') patient_dtls, b.catalog_desc drug_desc, e.short_desc order_status, a.order_id prescription_no, to_char(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time, am_get_desc.am_speciality (c.specialty_code, '"+locale+"', 2 ) specialty FROM or_order a, or_order_line b, pr_encounter c, mp_patient d, or_order_status_code_lang_vw e WHERE a.order_id = b.order_id AND c.facility_id = a.ordering_facility_id AND a.encounter_id = c.encounter_id AND a.order_category = 'PH' AND d.patient_id = a.patient_id AND e.order_status_code = b.order_line_status AND e.language_id = '"+locale+"'  "
	    		+ "AND b.order_catalog_code = '"+drug_code+"'  AND c.specialty_code = '"+splCode+"'  AND d.patient_id = NVL ('"+patient_id+"', a.patient_id) AND TRUNC (a.ord_date_time) BETWEEN TO_DATE (NVL ('"+dt_from+"', '01/01/1900'), 'DD/MM/RRRR' ) AND TO_DATE (NVL ('"+dt_to+"', SYSDATE), 'DD/MM/RRRR' )"; */
	    	//String query =  "SELECT a.patient_id patient_id, DECODE (?, 'en', d.patient_name, ?, NVL (d.patient_name_loc_lang, d.patient_name) ) || '/' || get_age (d.date_of_birth) || '/' || DECODE (d.sex, 'M', 'Male', 'F', 'Female', 'Unknown') patient_dtls, b.catalog_desc drug_desc, e.short_desc order_status, a.order_id prescription_no, to_char(a.ord_date_time,'DD/MM/YYYY HH24:MI') order_date_time, am_get_desc.am_speciality (c.specialty_code, ?, 2 ) specialty FROM or_order a, or_order_line b, pr_encounter c, mp_patient d, or_order_status_code_lang_vw e WHERE a.order_id = b.order_id AND c.facility_id = a.ordering_facility_id AND a.encounter_id = c.encounter_id AND a.order_category = 'PH' AND d.patient_id = a.patient_id AND e.order_status_code = b.order_line_status AND e.language_id = ?  AND b.order_catalog_code = ?  AND c.specialty_code = ?  AND d.patient_id = NVL (?, a.patient_id) AND TRUNC (a.ord_date_time) BETWEEN TO_DATE (NVL (?, '01/01/1900'), 'DD/MM/RRRR' ) AND TO_DATE (NVL (?, SYSDATE), 'DD/MM/RRRR' )";
			//String query ="SELECT a.patient_id patient_id, DECODE (?, 'en', d.patient_name, ?, NVL (d.patient_name_loc_lang, d.patient_name) ) || '/' || get_age (d.date_of_birth) || '/' || DECODE (d.sex, 'M', 'Male', 'F', 'Female', 'Unknown') patient_dtls, b.catalog_desc drug_desc, e.short_desc order_status, a.order_id prescription_no, TO_CHAR (a.ord_date_time, 'DD/MM/YYYY HH24:MI') order_date_time, am_get_desc.am_speciality (c.specialty_code, ?, 2) specialty FROM or_order a, or_order_line b, pr_encounter c, 		  mp_patient d, or_order_status_code_lang_vw e, PH_DRUG_QUOTA_LIMIT h                     WHERE a.order_id = b.order_id AND c.facility_id = a.ordering_facility_id AND a.encounter_id = c.encounter_id AND a.order_category = 'PH' AND d.patient_id = a.patient_id AND e.order_status_code = b.order_line_status AND e.language_id = ? AND b.order_catalog_code = ? AND c.specialty_code = ? AND d.patient_id = NVL (?, a.patient_id) AND TRUNC (a.ord_date_time) BETWEEN TO_DATE (NVL (?, '01/01/1900'), 'DD/MM/RRRR' ) AND TO_DATE (NVL (?, SYSDATE), 'DD/MM/RRRR') and h.drug_code=b.ORDER_CATALOG_CODE and h.SPECIALITY_CODE =c.specialty_code"; // Commented for 50794 - PH-ML-MMOH-CRF-1823.1-US020/03
	    	String query = "SELECT  a.patient_id patient_id, DECODE (?, 'en', d.patient_name, ?, NVL (d.patient_name_loc_lang, d.patient_name) ) || '/' || get_age (d.date_of_birth) || '/' || DECODE (d.sex, 'M', 'Male', 'F', 'Female', 'Unknown') patient_dtls, b.catalog_desc drug_desc, e.short_desc order_status, a.order_id prescription_no, TO_CHAR (a.ord_date_time, 'DD/MM/YYYY HH24:MI') order_date_time, am_get_desc.am_speciality (c.SPECIALITY_CODE, ?, 2) specialty FROM or_order a,or_order_line b, PH_PATIENT_DRUG_PROFILE c,mp_patient d, or_order_status_code_lang_vw e, PH_DRUG_QUOTA_LIMIT h, or_order_line_ph f WHERE a.order_id = b.order_id AND c.facility_id = a.ordering_facility_id AND a.encounter_id = c.encounter_id AND a.order_category = 'PH' AND d.patient_id = a.patient_id AND e.order_status_code = b.order_line_status AND e.language_id = ? AND b.order_catalog_code = ? AND c.SPECIALITY_CODE = ? AND d.patient_id = NVL (?, a.patient_id) AND TRUNC (a.ord_date_time) BETWEEN TO_DATE (NVL (?, '01/01/1900'), 'DD/MM/RRRR') AND TO_DATE (NVL (?, SYSDATE), 'DD/MM/RRRR') and h.drug_code=b.ORDER_CATALOG_CODE and h.SPECIALITY_CODE =c.SPECIALITY_CODE and b.order_id=c.ORIG_ORDER_ID and b.order_line_num=c.ORIG_ORDER_LINE_NO and b.order_id =f.order_id and b.order_line_num=f.order_line_num and f.QUOTA_CURR_VALUE is not null  order by order_date_time";// Modified for 50794  PH-ML-MMOH-CRF-1823.1-US020/03
			connection	= getConnection() ;
	    	pstmt = connection.prepareStatement(query);
	    	pstmt.setString(1,locale);
	    	pstmt.setString(2,locale);
	    	pstmt.setString(3,locale);
	    	pstmt.setString(4,locale);
	    	pstmt.setString(5,drug_code);
	    	pstmt.setString(6,splCode);
	    	pstmt.setString(7,patient_id);
	    	pstmt.setString(8,p_ord_fm_date);
	     	pstmt.setString(9,p_ord_to_date);
			resultSet	= pstmt.executeQuery(); 
			System.out.println("resultSet"+resultSet);
		 		while(resultSet.next()){ 
		 			ArrayList	records		=	new ArrayList();
	    		records.add(resultSet.getString("PATIENT_ID"));
				records.add(resultSet.getString("PATIENT_DTLS"));
				records.add(resultSet.getString("DRUG_DESC"));
				records.add(resultSet.getString("ORDER_STATUS"));
				records.add(resultSet.getString("PRESCRIPTION_NO"));
				records.add(resultSet.getString("ORDER_DATE_TIME"));
				records.add(resultSet.getString("SPECIALTY"));	
				finalRecords.add(records);
			}	
		 		
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
		}catch(Exception e){
				//records.add(e.toString());
				
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){es.printStackTrace();
			}
		}
		return finalRecords;
  }
}