/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST;

//import eCommon.Common.CommonAdapter;
import eST.Common.StTransaction;
//import eST.Common.StRepository;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import  java.util.ResourceBundle;
//import java.util.Hashtable;
//import eCommon.Common.CommonBean;

public class SalesHistoryBean extends StTransaction implements Serializable{

	private String item_code;
	private String store_code;
	private String searchFunction="N";
	private String patient_name;


	
	public void setItem_code(String item_code) {
		 this.item_code = item_code;
	}

	public String getItem_code( ) {
		 return item_code;
	}

	public void setStore_code(String store_code) {
		 this.store_code = store_code;
	}

	public String getStore_code( ) {
		 return store_code;
	}

	public String getSaleType()
	{
		String languageId							=		getLanguageId();
		java.util.Locale loc						=		new java.util.Locale(languageId);

		java.util.ResourceBundle common_labels		=		java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
		//java.util.ResourceBundle op_labels		=		java.util.ResourceBundle.getBundle( "eOP.resources.Labels",loc);
		java.util.ResourceBundle st_labels			=		java.util.ResourceBundle.getBundle( "eST.resources.Labels",loc);

		return getStaticListOptionTag("I,"+common_labels.getString("Common.Inpatients.label")+";O,"+common_labels.getString("Common.Outpatients.label")+";R,"+st_labels.getString("eST.Referrals.label")+";H,"+common_labels.getString("Common.Discharge.label")+";X,"+st_labels.getString("eST.DirectSales.label")+";E,"+common_labels.getString("Common.emergency.label")+";D,"+common_labels.getString("Common.daycare.label")+";%,"+common_labels.getString("Common.all.label")+";","%");
	}




	public String getSearchFunction( ) {
		 return searchFunction;
		 //round(NVL(sum(b.item_sal_value),0),3) grand_total
	}

	public void setPatient_name(String patient_name) {
		 this.patient_name = patient_name;
	}

	public String getPatient_name( ) {
		 return patient_name;
	}


	public ArrayList getEncounterArrayList(String patient_id) throws Exception{ 
		String stParameters[]={getLoginFacilityId(),patient_id};
		return fetchRecords(getStRepositoryValue("SQL_ST_MAN_REQ_ENCOUNTER_SELECT_LIST_1"),stParameters);
	}



	
/* @Name - Priya
 * @Date - 07/07/2010
 * @Inc# - 21346 (AK-CRF-0018)
 * @Desc - Two parameters have been added to the function 'queryResultDetails' in SalesHistoryBean 
*/	


public ArrayList queryResultDetails(String facility_id,String store_code2,String item_code2,String sal_trn_type2,String patient_id2,String from_date2 , String to_date2,String encounter_id2, String sal_doc_type2, String doc_no2) throws Exception
	{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList expDetailsList = new ArrayList();
		String sal_trn_type_query = "";
		try {
				if(sal_trn_type2.equals("I")){
					  sal_trn_type_query = " and b.take_home_yn ='N' ";
				 }else if(sal_trn_type2.equals("H")){
					  sal_trn_type_query = " and b.take_home_yn ='Y' ";
					  sal_trn_type2 = "I";
				 }

			connection = getConnection() ;
			//pstmt = connection.prepareStatement(getStRepositoryValue("SQL_ST_GRD_TOTAL_SALES_HISTORY") ) ;
			//pstmt = connection.prepareStatement("select  sum(round(NVL(b.GROSS_CHARGE_AMT,0),2)) grand_tot,sum(round(NVL(b.item_cost_value,0),2)) cost_grand_tot from  st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f where a.facility_id=b.facility_id and a.doc_type_code=b.doc_type_code and a.doc_no=b.doc_no and a.doc_type_code=c.doc_type_code and  a.store_code=d.store_code and b.item_code=e.item_code and a.patient_id=f.patient_id and a.facility_id = (?) and a.store_code LIKE UPPER(?) and b.item_code LIKE UPPER(?) and a.sal_trn_type like ?"+sal_trn_type_query+"  and a.patient_id LIKE UPPER(?) and (a.doc_date BETWEEN to_date(TO_CHAR(nvl(?,'01/01/1901')),'dd/mm/yyyy') and to_date(TO_CHAR(nvl(?,'31/12/3012')),'dd/mm/yyyy')) and to_char(NVL(encounter_id,'0')) LIKE ? and a.FINALIZED_YN = 'Y'") ;
			/* @Name - Priya
			 * @Date - 07/07/2010
			 * @Inc# - 21346 (AK-CRF-0018)
			 * @Desc - The above query is modified to pass the two new parameters 
			*/
			//pstmt = connection.prepareStatement("SELECT SUM (ROUND (grand_tot, 2)) grand_tot,SUM (ROUND (cost_grand_tot, 2)) cost_grand_tot FROM (SELECT  (CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN (ROUND (NVL (b.gross_charge_amt, 0), 2)) WHEN a.module_id = 'PH' THEN (SELECT ROUND (NVL (h.upd_gross_charge_amt, 0), 2) FROM bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND g.operating_facility_id = h.operating_facility_id AND g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num AND g.serv_item_code = h.serv_item_code AND g.primary_key_main = b.doc_type_code || '-' || b.doc_no) END ) grand_tot, (ROUND (NVL (b.item_cost_value, 0), 2) ) cost_grand_tot /*sum(round(NVL(b.GROSS_CHARGE_AMT,0),2)) grand_tot,sum(round(NVL(b.item_cost_value,0),2)) cost_grand_tot*/ FROM st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code  AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = (?) AND a.store_code LIKE UPPER (?) AND b.item_code LIKE UPPER (?) AND a.sal_trn_type LIKE ? "+sal_trn_type_query+" AND a.patient_id LIKE UPPER (?) AND (a.doc_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901' ) ), 'dd/mm/yyyy' ) AND TO_DATE (TO_CHAR (NVL (?, '31/12/3012' ) ), 'dd/mm/yyyy' ) ) AND TO_CHAR (NVL (a.encounter_id, '0')) LIKE ? AND a.finalized_yn = 'Y' AND a.doc_type_code LIKE ? AND a.doc_no LIKE ?) ") ;
			//modified by Ganga to get Grand Total for all transaction, corrected for single row returns more value

			//String sql = "SELECT SUM (ROUND (grand_tot, 2)) grand_tot,SUM (ROUND (cost_grand_tot, 2)) cost_grand_tot FROM (SELECT  (CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN (ROUND (NVL (b.gross_charge_amt, 0), 2)) WHEN a.module_id = 'PH' THEN (SELECT ROUND(sum(NVL (h.upd_gross_charge_amt, 0)), 2)  FROM bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND g.operating_facility_id = h.operating_facility_id AND g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num AND g.serv_item_code = h.serv_item_code AND g.primary_key_main = b.doc_type_code || '-' || b.doc_no and h.patient_id=g.patient_id and h.patient_id=a.patient_id and g.serv_item_code=b.item_code ) END ) grand_tot, (ROUND (NVL (b.item_cost_value, 0), 2) ) cost_grand_tot /*sum(round(NVL(b.GROSS_CHARGE_AMT,0),2)) grand_tot,sum(round(NVL(b.item_cost_value,0),2)) cost_grand_tot*/ FROM st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code  AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = ?  AND  a.doc_date BETWEEN TO_DATE(?, 'dd/mm/yyyy') AND TO_DATE(?,'dd/mm/yyyy')  AND a.finalized_yn = 'Y' ";

			//Modified by Sakti against MMS-SCF-0337 inc#48949 Cost Value increase
			//String sql = "SELECT SUM (ROUND (grand_tot, 2)) grand_tot,SUM (ROUND (cost_grand_tot, 2)) cost_grand_tot FROM (SELECT  (CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN (ROUND (NVL (b.gross_charge_amt, 0), 2)) WHEN a.module_id = 'PH' THEN (SELECT ROUND(sum(NVL (h.upd_gross_charge_amt, 0)), 2)  FROM bl_patient_charges_interface g, bl_patient_charges_folio h WHERE g.operating_facility_id = a.facility_id AND g.operating_facility_id = h.operating_facility_id AND g.trx_doc_ref = h.trx_doc_ref AND g.trx_doc_ref_line_num = h.trx_doc_ref_line_num AND g.serv_item_code = h.serv_item_code AND g.primary_key_main = b.doc_type_code || '-' || b.doc_no and h.patient_id=g.patient_id and h.patient_id=a.patient_id and g.serv_item_code=b.item_code ) END ) grand_tot, /* (ROUND (NVL (b.item_cost_value, 0), 2) ) cost_grand_tot sum(round(NVL(b.GROSS_CHARGE_AMT,0),2)) grand_tot,sum(round(NVL(b.item_cost_value,0),2)) cost_grand_tot*/ ROUND(((  b.item_qty * (SELECT ROUND (AVG (curr_unit_cost), 3)  FROM st_item_unit_cost_history  WHERE trn_type IN ('OBS', 'GRN')  AND item_code = b.item_code and changed_Date <= a.doc_Date)) * st_get_uom_conv_fac_sing_str (b.item_code,  a.store_code)),3) cost_grand_tot FROM st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code  AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = ?  AND  a.doc_date BETWEEN TO_DATE(?, 'dd/mm/yyyy') AND TO_DATE(?,'dd/mm/yyyy')  AND a.finalized_yn = 'Y' ";
			//Modified by Sakti against MMS-SCF-0381 inc#50206 Unit_cost,sale_value(MMS-SCF-0380,MMS-SCF-0344) logic changed.
			//String sql = "SELECT SUM (ROUND (grand_tot, 2)) grand_tot,SUM (ROUND (cost_grand_tot, 2)) cost_grand_tot FROM (SELECT  (CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN (ROUND (NVL (b.gross_charge_amt, 0), 2)) WHEN a.module_id = 'PH' THEN st_display_sale_value(a.facility_id,b.doc_type_code,b.doc_no,a.patient_id,b.item_code) END ) grand_tot, /* (ROUND (NVL (b.item_cost_value, 0), 2) ) cost_grand_tot sum(round(NVL(b.GROSS_CHARGE_AMT,0),2)) grand_tot,sum(round(NVL(b.item_cost_value,0),2)) cost_grand_tot*/ ROUND ((  (  b.item_qty * (st_display_unit_cost(b.item_code,trunc(a.doc_date)))) * st_get_uom_conv_fac_sing_str (b.item_code, a.store_code)),3) cost_grand_tot FROM st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code  AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = ?  AND  a.doc_date BETWEEN TO_DATE(?, 'dd/mm/yyyy') AND TO_DATE(?,'dd/mm/yyyy')  AND a.finalized_yn = 'Y' ";
			//Modified by suresh.r on 23-12-2014 against Inc 52413 (unitcost fun passed modified_date)
			String sql = "SELECT SUM (ROUND (grand_tot, 2)) grand_tot,SUM (ROUND (cost_grand_tot, 2)) cost_grand_tot FROM (SELECT  (CASE WHEN a.module_id = 'ST' OR a.module_id = 'OT' THEN (ROUND (NVL (b.gross_charge_amt, 0), 2)) WHEN a.module_id = 'PH' THEN st_display_sale_value(a.facility_id,b.doc_type_code,b.doc_no,a.patient_id,b.item_code) END ) grand_tot, /* (ROUND (NVL (b.item_cost_value, 0), 2) ) cost_grand_tot sum(round(NVL(b.GROSS_CHARGE_AMT,0),2)) grand_tot,sum(round(NVL(b.item_cost_value,0),2)) cost_grand_tot*/ ROUND ((  (  b.item_qty * (st_display_unit_cost(b.item_code,a.modified_date))) * st_get_uom_conv_fac_sing_str (b.item_code, a.store_code)),3) cost_grand_tot FROM st_sal_hdr a, st_sal_dtl b, sy_doc_type_master c, mm_store d, mm_item e, mp_patient f WHERE a.facility_id = b.facility_id AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND a.doc_type_code = c.doc_type_code AND a.store_code = d.store_code  AND b.item_code = e.item_code AND a.patient_id = f.patient_id AND a.facility_id = ?  AND  a.doc_date BETWEEN TO_DATE(?, 'dd/mm/yyyy') AND TO_DATE(?,'dd/mm/yyyy')  AND a.finalized_yn = 'Y' ";
			
			if(!(sal_doc_type2.equals(""))){
			//sql = sql + " and a.doc_type_code =" + "'"+sal_doc_type2+"'"  ;
				sql = sql + " and a.doc_type_code =?"; // COMMON-ICN-0184
			}
			if(!(doc_no2.equals(""))){
			//sql = sql + " and a.doc_no =" + "'"+doc_no2+"'"  ;
				sql = sql + " and a.doc_no =?"; // COMMON-ICN-0184
			}
			if(!(sal_trn_type2.equals("%"))){
			//sql = sql + " and a.sal_trn_type =" + "'"+sal_trn_type2+"'"  ;
				sql = sql + " and a.sal_trn_type =?"; // COMMON-ICN-0184
			}
				
			if(!(store_code2.equals(""))){
			//sql = sql + " and a.store_code =" + "'"+store_code2+"'"  ;
				sql = sql + " and a.store_code =?"; // COMMON-ICN-0184
			}
			if(!(item_code2.equals(""))	){
			//sql = sql + " and b.item_code = " + "'"+item_code2+"'"  ;
				sql = sql + " and b.item_code = ?"; // COMMON-ICN-0184
			} 
			if(!(patient_id2.equals(""))){
			//sql = sql + " and a.patient_id =" + "'"+patient_id2+"'"  ;
			sql = sql + " and a.patient_id =?"; // COMMON-ICN-0184
			}
			if(!(encounter_id2.equals(""))){
			//sql = sql + " and a.encounter_id = " + "'"+encounter_id2+"'"  ;
				sql = sql + " and a.encounter_id = ?"; // COMMON-ICN-0184
			}
			if(!(sal_trn_type_query.equals(""))){
			sql = sql + sal_trn_type_query ;
			}
			
			sql = sql + " )";

			
			pstmt = connection.prepareStatement(sql);
			int pstcount=1; // COMMON-ICN-0184
			pstmt.setString( pstcount, facility_id ) ;
			pstmt.setString( ++pstcount, from_date2 ) ;
			pstmt.setString( ++pstcount, to_date2 ) ;
			if(!(sal_doc_type2.equals(""))){
				pstmt.setString( ++pstcount, sal_doc_type2 ) ; // COMMON-ICN-0184
			}
			if(!(doc_no2.equals(""))){
				pstmt.setString( ++pstcount, doc_no2 ) ;
			}
			if(!(sal_trn_type2.equals("%"))){
				pstmt.setString( ++pstcount, sal_trn_type2 ) ;
			}
				
			if(!(store_code2.equals(""))){
				pstmt.setString( ++pstcount, store_code2 ) ;
			}
			if(!(item_code2.equals(""))	){
				pstmt.setString( ++pstcount, item_code2 ) ;
			}
			if(!(patient_id2.equals(""))){
				pstmt.setString( ++pstcount, patient_id2 ) ;
			}
			if(!(encounter_id2.equals(""))){
				pstmt.setString( ++pstcount, encounter_id2 ) ; // COMMON-ICN-0184
			}
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				HashMap dataRow=new HashMap();

				dataRow.put("grand_tot",resultSet.getString("grand_tot")) ;
				dataRow.put("cost_grand_tot",resultSet.getString("cost_grand_tot")) ;
				expDetailsList.add(dataRow);
			}
			}

			catch(Exception e) {
		
				e.printStackTrace();
			}
		
			finally {
            try {
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }
			catch(Exception es) {
				es.printStackTrace();
            }
			}
			return expDetailsList;


			}

public void clear()
	{
	this.item_code="";
	this.store_code="";
	}

/*Method moved to Adapter class as this is used commonly in more than 8 functions Mahesh 14/12/2009*/
/*	public String getAccessCostDetails(){
		String cost_yn			  = "N";	
		HashMap view_cost_yn	  = new HashMap();
		try{
			view_cost_yn = fetchRecord(getStRepositoryValue("ST_SQL_VIEW_COST_YN_SELECT"),getLoginById());
		}catch(Exception e){
			cost_yn = "";
		}
		if(view_cost_yn.size() > 0){
			//Check For Null is added on 14/12/2009 By Mahesh
			cost_yn = checkForNull((String)view_cost_yn.get("VIEW_COST_YN"),"N");
		}
		return cost_yn;
	}
*/
	public String getPatientNationality(String strPatientId) throws Exception {
		ArrayList alParams = new ArrayList();	 		
        try{
			alParams.add(strPatientId);
			alParams.add(getLanguageId());
            HashMap hashmap = fetchRecord("SELECT SHORT_NAME COUNTRY FROM MP_COUNTRY_LANG_VW C, MP_PATIENT MP WHERE MP.PATIENT_ID = UPPER(?) AND MP.NATIONALITY_CODE = C.COUNTRY_CODE AND C.LANGUAGE_ID = ?", alParams);
            return checkForNull((String)hashmap.get("COUNTRY"));
        }
        catch(Exception exception){
            exception.printStackTrace();
			throw exception;
        }
    }
}


