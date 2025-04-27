/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 *
 ******************************************************************************/
/*----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name      			Rev.Date		Rev.Name		         Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
	?				?				?				?					?						?
05/08/2020  IN072762            Chandrashekar                                              MO-CRF-20101.11
21/01/2021	10245				Durga Natarajan		21/01/2021		Ramesh G			ALPHA-CA-New clinical Event History
03/03/2022  29024                      K pranay                                           [ Common-ICN-0092 ]    unused local variable
---------------------------------------------------------------------------------------------------------------------------------------------------------
 */

package eCA ;
import java.io.* ;
import java.util.* ;
import java.sql.* ;
import eCA.Common.* ;
import eCommon.Common.* ;
import javax.servlet.* ;
import javax.servlet.http.*;
import oracle.sql.*;
import eCommon.SingleTableHandler.*;
import java.text.DecimalFormat; 

public class MedicationOrdersBean extends CaAdapter implements Serializable {

	String debug="";
	String drug_code="";
	String drug_desc="";
	String pract_id="";
	String pract_name="";
	String dt_from="";
	String dt_to="";
	String Instructions="";
	String patient_id="";
	String p_facility_id="";
	String locale="";
	int iNoOfDecimals=0;
	String route_code="";//added for IN070786
	String frequency="";//added for IN070786
	String qty_desc="";//added for IN070786
	String dosage_type="";//added for IN070786
	String qty_value="";//added for IN070786
	String frequency_nature="";//added for IN070786
	protected String alt_drug_remarks_ind = ""; //Added for Bru-HIMS-CRF-082 [IN:029948] -//"N" removed for [IN:41243]
	protected HashMap hmAltDrugRemarks		= new HashMap(); //Added for Bru-HIMS-CRF-082 [IN:029948]

    public MedicationOrdersBean() {
		try {
			doCommon();
		}
		catch(Exception e) {e.printStackTrace();}
    }

	public void clear() {
		super.clear() ;
	}
	
	public String getDebug(){
		return this.debug;
	}

	public int getNoOfDecimals(){
		return this.iNoOfDecimals;
	}
	public String getAltDrugRemarksInd(){ //Added for Bru-HIMS-CRF-082 [IN:029948]
		return this.alt_drug_remarks_ind;
	}
	public void setAltDrugRemarksInd(String alt_drug_remarks_ind){ //Added for Bru-HIMS-CRF-082 [IN:029948]
		this.alt_drug_remarks_ind = alt_drug_remarks_ind;
	}
     
    public void setAltDrugRemarks(String key,String alt_drug_remarks) {
		this.hmAltDrugRemarks.put(key,alt_drug_remarks);
	}
    public void removeAltDrugRemarks(String key) {
		if(this.hmAltDrugRemarks.containsKey(key))
			this.hmAltDrugRemarks.remove(key);
	}

	public HashMap getAltDrugRemarks(){
		return this.hmAltDrugRemarks;
	}

	public String getAltDrugRemarks(String key){
		if(this.hmAltDrugRemarks.containsKey(key))
			return (String)this.hmAltDrugRemarks.get(key);
		else
			return "";
	}

	private void doCommon() throws Exception {
	}

	public HashMap validate() throws Exception {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map ;
	}

	public HashMap modify() {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		return map;
	}
	public ArrayList getMedicationEventDates(Connection con,String locale,String patient_id,String encounter_id,String pract_id,String from_date,String to_date,String selTab,String patient_class,String facility_id,String status,String drug_id,String generic_id,String drug_category, String order_type,String date_order) throws Exception {//IN069654
	
	//System.err.println("locale==="+locale+"patient_id===="+patient_id+"encounter_id===="+encounter_id+"pract_id==="+pract_id+"from_date==="+from_date+"to_date==="+to_date+"selTab===="+selTab+"patient_class===="+patient_class+"facility_id==="+facility_id+"status==="+status+"drug_id==="+drug_id+"generic_id=="+generic_id);
	ArrayList eventDate = new ArrayList() ;
	PreparedStatement pStatment = null;
	ResultSet resultSet = null;
	int i=1;
	StringBuffer stMainSql	= new StringBuffer(); 
	String ext_sql ="";
	String sql_append	=	"";
	//String med_sql ="";//Common-ICN-0092  
	StringBuffer sbSQL = new StringBuffer();
	if(selTab.equals("M"))
		selTab="self_tab";
	if(selTab.equals("S"))
		selTab="my_tab";
if(drug_category.equals("D")){
	stMainSql.append("SELECT distinct DECODE (drug_yn,'N', '',TO_CHAR (a.start_date, 'DD/MM/YYYY HH24:MI'))start_date,to_char(a.start_date,'YYYYMMDDHH24MI')  sort_event_date_time FROM ph_patient_drug_profile a, ph_generic_name_lang_vw b,ph_drug_lang_vw c,or_order_line o,or_order q,or_order_status_code_lang_vw r,pr_encounter p,or_order_catalog z WHERE q.order_id = o.order_id AND a.patient_id = ?  AND a.start_date BETWEEN TO_DATE (NVL (?, '01/01/1472 00:01'), 'DD/MM/YYYY HH24:MI') AND   TO_DATE (NVL (?, '31/12/5000 00:01'), 'DD/MM/YYYY HH24:MI') + 0.99999 AND  a.generic_id = b.generic_id AND a.drug_code = c.drug_code and c.drug_code =z.order_catalog_code AND a.orig_order_id = o.order_id AND a.orig_order_line_no = o.order_line_num AND o.order_line_status = r.order_status_code AND b.language_id = c.language_id AND b.language_id = r.language_id AND b.language_id = ? AND c.drug_yn = 'Y' AND p.encounter_id(+) = a.encounter_id AND p.facility_id(+) = a.orig_facility_id ");
            
			if(patient_class.equals("IP"))
					stMainSql.append(" and p.patient_class = ? ");
			if(patient_class.equals("0P"))
					stMainSql.append(" and (p.patient_class = ? OR q.discharge_ind = 'D') ");	
			if(patient_class.equals("DC"))
					stMainSql.append(" and p.patient_class = ? ");	
			if(patient_class.equals("XT"))
					stMainSql.append(" and a.patient_class = NVL (?, '!') ");	
	        if(!encounter_id.equals(""))
					stMainSql.append(" and a.ENCOUNTER_ID = ? ");	
				
			if(!facility_id.equals(""))
				stMainSql.append("and a.FACILITY_ID = ?");

			if(!generic_id.equals(""))
				stMainSql.append("and a.generic_id = ?");

			if(!drug_id.equals(""))
				stMainSql.append("and a.drug_code = ?");
			if(!order_type.equals(""))
				stMainSql.append("and z.order_type_code = ?");
			
				
			if("self_tab".equals(selTab))
				//stMainSql.append(" and 'Y' = CA_PRACT_SPECILITY_YN(q.ORD_PRACT_ID,?,?) ");//commented for 10245
				stMainSql.append(" and 'Y' = CA_PRACT_SPECILITY_YN(q.ORD_PRACT_ID,?,a.facility_id) ");// 10245	
			if("my_tab".equals(selTab))
				stMainSql.append(" and q.ORD_PRACT_ID=? ");
					
			
	        if(patient_class.equals("XT")){
				if(status.equals("A")){
					sql_append	=	sql_append +" AND SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL ";
				}
				else if(status.equals("F")) {
					sql_append	=	sql_append +" AND A.START_DATE > SYSDATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL ";
				} 
				else if(status.equals("C")) {
					sql_append	=	sql_append +" AND SYSDATE >= A.END_DATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL  AND O.ORDER_LINE_STATUS IN ('DF')";
				} 
				else if(status.equals("DC")) {
					sql_append	=	sql_append +" AND O.DISC_DATE_TIME IS NOT NULL AND A.CANCEL_YN='N'";				
				} 
				else if(status.equals("HD") || status.equals("HC")) {
					sql_append	=	sql_append +" AND O.HOLD_DATE_TIME IS NOT NULL AND A.CANCEL_YN='N' AND O.ORDER_LINE_STATUS IN ('HD','HC')";				
				} 
				else if(status.equals("R")) {
					sql_append	=	sql_append +" AND A.RETURNED_QTY IS NOT NULL ";
				
				} 
				else if(status.equals("CN")) {
					sql_append	=	sql_append +" AND A.CANCEL_YN='Y' ";
					
				} 
				else if(status.equals("PG")) {          
					sql_append	=	sql_append +" AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND O.ORDER_LINE_STATUS IN ('PO','PC','PS') ";
						
				} 
				
				else if(status.equals("PO")) {
					sql_append	=	sql_append +" AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND O.ORDER_LINE_STATUS = 'PO' ";
				
				}
				else if(status.equals("PC")) {
					sql_append	=	sql_append +" AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND O.ORDER_LINE_STATUS = 'PC' ";				
				} 
				else if(status.equals("PS")) {
					sql_append	=sql_append +	" AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND O.ORDER_LINE_STATUS = 'PS' ";
				
				} 
				else {
					sql_append	=	sql_append +" AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL ";
				}
			}
			else if((patient_class.equals("IP") || patient_class.equals("DC")) && status.equals("A")) {
				sql_append	=	sql_append + " AND SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND O.ORDER_LINE_STATUS NOT IN ('PO','PS','CN','HD','HC','DC')";
			} 
			else if((patient_class.equals("OP") || patient_class.equals("EM")) && status.equals("A")) {
				sql_append	=	" AND SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND (NVL(A.TOT_ISSUED_QTY,0)-NVL(A.RETURNED_QTY,0))>=0 AND O.ORDER_LINE_STATUS NOT IN ('PO','PS','CN','HD','HC','DC')";
				
			} 
			else if(status.equals("A")) {
			//	serr.println("Inside status condition===");
				sql_append	=	sql_append + " AND ((A.PATIENT_CLASS = 'IP' AND SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND (NVL(A.TOT_ISSUED_QTY,0)-NVL(A.RETURNED_QTY,0))>=0 AND O.ORDER_LINE_STATUS NOT IN ('PO','PS','CN','HD','HC','DC')) OR (A.PATIENT_CLASS IN( 'OP' ,'XT') AND SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND (NVL(A.TOT_ISSUED_QTY,0)-NVL(A.RETURNED_QTY,0))>=0 AND O.ORDER_LINE_STATUS NOT IN ('PO','PS','CN','HD','HC','DC')))";
				
			} 
			else if(status.equals("F")) {
				sql_append	=	sql_append + " AND A.START_DATE > SYSDATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL ";
			} 
			else if(status.equals("C")) {
				sql_append	=	sql_append + " AND SYSDATE >= A.END_DATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL  AND O.ORDER_LINE_STATUS IN ('DF')";
			} 
			else	if(status.equals("DC")) {
				sql_append	=	sql_append + " AND O.DISC_DATE_TIME IS NOT NULL AND A.CANCEL_YN='N'";
				
			} 
			else if(status.equals("HD") || status.equals("HC")) {
				sql_append	=	sql_append + " AND O.HOLD_DATE_TIME IS NOT NULL AND A.CANCEL_YN='N' AND O.ORDER_LINE_STATUS IN ('HD','HC')";

			} 
			else if(status.equals("R")) {
				sql_append	=	sql_append + " AND A.RETURNED_QTY IS NOT NULL ";

			} 
			else if(status.equals("CN")) {
				sql_append	=	" AND A.CANCEL_YN='Y' ";

			} 
			else if(status.equals("PG")) {          
				sql_append	=	 sql_append +" AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND O.ORDER_LINE_STATUS IN ('PO','PC','PS') ";

			} 
			
			else if(status.equals("PO")) {
				sql_append	=	sql_append + " AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND O.ORDER_LINE_STATUS = 'PO' ";
			
			}
			else if(status.equals("PC")) {
				sql_append	=	sql_append + " AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND O.ORDER_LINE_STATUS = 'PC' ";
			
			} 
			else if(status.equals("PS")) {
				sql_append	=	sql_append + " AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND O.ORDER_LINE_STATUS = 'PS' ";
			
			} 
			if(date_order.equals("D"))
			sql_append  = sql_append + " order by sort_event_date_time desc";
		else
			sql_append  = sql_append +" order by sort_event_date_time asc";
		
//System.err.println("stMainSql@@===="+stMainSql+"sql_append@@@==========="+sql_append);
					stMainSql=	stMainSql.append(sql_append); 
		
	
	
//System.err.println("sbQryCriteria.toString()@@@@========"+stMainSql.toString());
try{
	 pStatment = con.prepareStatement(stMainSql.toString());
	 
	     pStatment.setString(i++, patient_id);
		 pStatment.setString(i++, from_date);
		 pStatment.setString(i++, to_date);
		 pStatment.setString(i++, locale);
		 if(!patient_class.equals(""))
			  pStatment.setString(i++, patient_class);
		 if(!encounter_id.equals(""))
			 pStatment.setString(i++, encounter_id);
		 if(!facility_id.equals(""))
		 pStatment.setString(i++, facility_id);

		 if(!generic_id.equals(""))
			 pStatment.setString(i++, generic_id);
		 if(!drug_id.equals(""))
			 pStatment.setString(i++, drug_id);
		 if(!order_type.equals(""))
			 pStatment.setString(i++, order_type);
		 
		 if("self_tab".equals(selTab)){
			pStatment.setString(i++, pract_id);
			 //pStatment.setString(i++, facility_id);//commented for 10245
		 }
		 
		 if("my_tab".equals(selTab)){
			 
			  pStatment.setString(i++, pract_id);
		 }
		 
		
		
	 resultSet = pStatment.executeQuery(); 
	 if ( resultSet != null )
	 {
		 
			while(resultSet.next())
			{
				
				eventDate.add(resultSet.getString("start_date")==null?"":resultSet.getString("start_date")); 
			}
		}
    }
	
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		if(resultSet != null) resultSet.close();
		if(pStatment != null) pStatment.close();
	}
}else if(drug_category.equals("E")){

	  ext_sql ="SELECT   DISTINCT TO_CHAR (A.START_DATE, 'DD/MM/YYYY HH24:MI') START_DATE FROM PH_PATIENT_EXT_DRUG_PROFILE A WHERE A.PATIENT_ID = ? AND A.START_DATE BETWEEN NVL (TO_DATE (?, 'DD/MM/YYYY HH24:MI'), SYSDATE - 30)  AND NVL (TO_DATE (?, 'DD/MM/YYYY HH24:MI'), SYSDATE + 30) ";

	       	
			if(!facility_id.equals(""))
				ext_sql      =ext_sql+ " AND A.FACILITY_ID = ?";

			if(!drug_id.equals(""))
				ext_sql   = ext_sql +" AND A.DRUG_CODE = ?";

	        if("self_tab".equals(selTab))
				//ext_sql =ext_sql+ " AND 'Y' = CA_PRACT_SPECILITY_YN(A.PRACTITIONER_ID,?,?) ";//commented for 10245
	        	ext_sql =ext_sql+ " AND 'Y' = CA_PRACT_SPECILITY_YN(A.PRACTITIONER_ID,?,a.facility_id) ";//added for 10245
			if("my_tab".equals(selTab))
				ext_sql= ext_sql+" AND A.PRACTITIONER_ID=? ";

			 if(date_order.equals("D"))
			    ext_sql  = ext_sql + " ORDER BY START_DATE DESC";
		else
			    ext_sql  = ext_sql +" ORDER BY START_DATE ASC";

	  try{
           
	         pStatment = con.prepareStatement(ext_sql);
						 pStatment.setString(i++, patient_id);
						 pStatment.setString(i++, from_date);
						 pStatment.setString(i++, to_date);
					 
					 if(!facility_id.equals(""))
					     pStatment.setString(i++, facility_id);
					 if(!drug_id.equals(""))
			             pStatment.setString(i++, drug_id);
					 
					 if("self_tab".equals(selTab)){
						 pStatment.setString(i++, pract_id);
						 //pStatment.setString(i++, facility_id);//commented for 10245
					 }
					 
					 if("my_tab".equals(selTab)){
						 
						  pStatment.setString(i++, pract_id);
					 }
					 
				 resultSet = pStatment.executeQuery(); 
				 if ( resultSet != null )
				 {
						while(resultSet.next())
						{
							eventDate.add(resultSet.getString("START_DATE")==null?"":resultSet.getString("START_DATE")); 
						}
					}
				}
	
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		if(resultSet != null) resultSet.close();
		if(pStatment != null) pStatment.close();
	}
}
	else if(drug_category.equals("M")){

		 String temp_pat_class ="";
		  if(patient_class.equals("IP"))
			  temp_pat_class ="I";
		  if(patient_class.equals("OP"))
			  temp_pat_class ="O";
		  if(patient_class.equals("DC"))
			  temp_pat_class ="D";
		  if(patient_class.equals("ER"))
			  temp_pat_class ="E";



		sbSQL.append("SELECT Distinct TO_CHAR (b.added_date,'DD/MM/YYYY HH24:MI') ord_date FROM st_sal_hdr  a, st_sal_dtl  b WHERE a.facility_id = b.facility_id AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND b.item_code IN (SELECT item_code FROM ph_drug  WHERE drug_yn = 'N') AND a.module_id = 'PH' AND NOT EXISTS ((SELECT 'Y' FROM ph_disp_hdr   c, ph_disp_dtl  d WHERE c.patient_id = a.patient_id AND c.doc_type = a.doc_type_code AND c.doc_no = a.doc_no AND c.facility_id = a.facility_id and c.disp_no = D.disp_no and B.DOC_SRL_NO = D.DOC_SRL_NO AND c.DISP_TRN_SEQ_NO||c.disp_no not IN (SELECT DISP_TRN_SEQ_NO||disp_no FROM ph_disp_cons_dtl  )) UNION (SELECT 'Y' FROM ph_disp_hdr_tmp  c, ph_disp_dtl_tmp  d WHERE c.patient_id = a.patient_id AND c.doc_type = a.doc_type_code AND c.doc_no = a.doc_no AND c.facility_id = a.facility_id and c.disp_tmp_no = d.disp_tmp_no  and B.DOC_SRL_NO = D.DOC_SRL_NO AND c.disp_trn_seq_no||c.disp_tmp_no not IN (SELECT disp_trn_seq_no||disp_no FROM ph_disp_cons_dtl  ))) AND patient_id = ? ");

		    if(!patient_class.equals(""))
				sbSQL.append(" AND a.SAL_TRN_TYPE =? ");
			if(!encounter_id.equals(""))//Added for MMS-DM-CRF-115.4
				sbSQL.append(" AND  encounter_id = ? ");
			if(!drug_id.equals(""))
				sbSQL.append(" AND B.item_code=? ");
			if(!from_date.equals("") && !to_date.equals(""))
				sbSQL.append(" AND trunc(b.added_date) between TO_DATE(?,'DD/MM/YYYY HH24:MI') and TO_DATE(?,'DD/MM/YYYY HH24:MI')");
			else if(!from_date.equals(""))
				sbSQL.append(" AND trunc(b.added_date) >= TO_DATE(?,'DD/MM/YYYY HH24:MI') ");
			else if(!to_date.equals(""))
				sbSQL.append(" AND  trunc(b.added_date) <= TO_DATE(?,'DD/MM/YYYY HH24:MI')");
			if(!facility_id.equals(""))
				sbSQL.append(" AND A.FACILITY_ID=? ");
			if("self_tab".equals(selTab))
				//sbSQL.append(" AND 'Y' = CA_PRACT_SPECILITY_YN(A.PRACTITIONER_ID,?,?) ");//commented for 10245
				sbSQL.append(" AND 'Y' = CA_PRACT_SPECILITY_YN(A.PRACTITIONER_ID,?,a.facility_id) ");//added for 10245
			if("my_tab".equals(selTab))
				sbSQL.append(" AND A.PRACTITIONER_ID=? ");
				

			sbSQL.append(" UNION SELECT  Distinct TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') ord_date FROM  or_order  a, or_order_line  b,ph_patient_drug_profile  pdp, am_uom_lang_vw  uo WHERE b.order_id = a.order_id AND b.order_id = pdp.orig_order_id AND b.order_line_num = pdp.orig_order_line_no AND a.ordering_facility_id = pdp.orig_facility_id and uo.uom_code = b.order_uom and uo.language_id=? AND order_catalog_code IN (SELECT drug_code FROM ph_drug  WHERE drug_yn = 'N') AND b.order_category = 'PH' AND a.patient_id =?");
		    
			if(!patient_class.equals(""))
				sbSQL.append(" AND a.patient_class =? ");
			if(!encounter_id.equals(""))//Added for MMS-DM-CRF-115.4
				sbSQL.append(" AND  a.encounter_id = ? ");
			if(!drug_id.equals(""))
				sbSQL.append(" AND B.ORDER_CATALOG_CODE=? ");
			if(!from_date.equals("") && !to_date.equals(""))
				sbSQL.append(" AND trunc(a.added_date) between TO_DATE(?,'DD/MM/YYYY HH24:MI') and TO_DATE(?,'DD/MM/YYYY HH24:MI')");
			else if(!from_date.equals(""))
				sbSQL.append(" AND trunc(a.added_date) >= TO_DATE(?,'DD/MM/YYYY HH24:MI') ");
			else if(!to_date.equals(""))
				sbSQL.append(" AND  trunc(a.added_date) <= TO_DATE(?,'DD/MM/YYYY HH24:MI')");
			if(!facility_id.equals(""))
				sbSQL.append(" AND A.ORDERING_FACILITY_ID=? ");
			if("self_tab".equals(selTab))
				//sbSQL.append(" AND 'Y' = CA_PRACT_SPECILITY_YN(A.ord_pract_id,?,?) ");//commented for 10245
				sbSQL.append(" AND 'Y' = CA_PRACT_SPECILITY_YN(A.ord_pract_id,?,pdp.facility_id) ");//added for 10245
			if("my_tab".equals(selTab))
				sbSQL.append(" AND A.ord_pract_id=? ");
			if(patient_class.equals("XT")){
				if(status.equals("A")){
					sbSQL.append(" AND SYSDATE BETWEEN pdp.START_DATE AND pdp.END_DATE AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL ");
				}
				else if(status.equals("F")) {
					sbSQL.append(" AND pdp.START_DATE > SYSDATE AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL ");
				} 
				else if(status.equals("C")) {
					sbSQL.append("  AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL  AND b.ORDER_LINE_STATUS IN ('DF')");
				} 
				else if(status.equals("DC")) {
					sbSQL.append(" AND b.DISC_DATE_TIME IS NOT NULL AND pdp.CANCEL_YN='N'");				
				} 
				else if(status.equals("HD") || status.equals("HC")) {
					sbSQL.append(" AND b.HOLD_DATE_TIME IS NOT NULL AND pdp.CANCEL_YN='N' AND b.ORDER_LINE_STATUS IN ('HD','HC')");				
				} 
				else if(status.equals("R")) {
					sbSQL.append(" AND pdp.RETURNED_QTY IS NOT NULL ");
				
				} 
				else if(status.equals("CN")) {
					sbSQL.append(" AND pdp.CANCEL_YN='Y' ");
					
				} 
				else if(status.equals("PG")) {          
					sbSQL.append(" AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL AND b.ORDER_LINE_STATUS IN ('PO','PC','PS') ");
						
				} 
				
				else if(status.equals("PO")) {
					sbSQL.append(" AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL AND b.ORDER_LINE_STATUS = 'PO' ");
				
				}
				else if(status.equals("PC")) {
					sbSQL.append(" AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL AND b.ORDER_LINE_STATUS = 'PC' ");				
				} 
				else if(status.equals("PS")) {
					sbSQL.append(" AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL AND b.ORDER_LINE_STATUS = 'PS' ");
				
				} 
				else {
					sbSQL.append(" AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL ");
				}
			}
			else if((patient_class.equals("IP") || patient_class.equals("DC")) && status.equals("A")) {
				sbSQL.append(" AND SYSDATE BETWEEN pdp.START_DATE AND pdp.END_DATE AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL AND b.ORDER_LINE_STATUS NOT IN ('PO','PS','CN','HD','HC','DC')");
			} 
			else if((patient_class.equals("OP") || patient_class.equals("EM")) && status.equals("A")) {
				sbSQL.append(" AND SYSDATE BETWEEN pdp.START_DATE AND pdp.END_DATE AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL AND (NVL(pdp.TOT_ISSUED_QTY,0)-NVL(pdp.RETURNED_QTY,0))>=0 AND b.ORDER_LINE_STATUS NOT IN ('PO','PS','CN','HD','HC','DC')");
				
			} 
			else if(status.equals("A")) {
			//	serr.println("Inside status condition===");
				sbSQL.append(" AND ((pdp.PATIENT_CLASS = 'IP' AND SYSDATE BETWEEN pdp.START_DATE AND pdp.END_DATE AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL AND (NVL(pdp.TOT_ISSUED_QTY,0)-NVL(pdp.RETURNED_QTY,0))>=0 AND b.ORDER_LINE_STATUS NOT IN ('PO','PS','CN','HD','HC','DC')) OR (pdp.PATIENT_CLASS IN( 'OP' ,'XT') AND SYSDATE BETWEEN pdp.START_DATE AND pdp.END_DATE AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL AND (NVL(pdp.TOT_ISSUED_QTY,0)-NVL(pdp.RETURNED_QTY,0))>=0 AND b.ORDER_LINE_STATUS NOT IN ('PO','PS','CN','HD','HC','DC')))");
				
			} 
			else if(status.equals("F")) {
				sbSQL.append(" AND pdp.START_DATE > SYSDATE AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL ");
			} 
			else if(status.equals("C")) {
				sbSQL.append(" AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL  AND b.ORDER_LINE_STATUS IN ('DF')");
			} 
			else	if(status.equals("DC")) {
				sbSQL.append(" AND b.DISC_DATE_TIME IS NOT NULL AND pdp.CANCEL_YN='N'");
				
			} 
			else if(status.equals("HD") || status.equals("HC")) {
				sbSQL.append(" AND b.HOLD_DATE_TIME IS NOT NULL AND pdp.CANCEL_YN='N' AND b.ORDER_LINE_STATUS IN ('HD','HC')");

			} 
			else if(status.equals("R")) {
				sbSQL.append(" AND pdp.RETURNED_QTY IS NOT NULL ");

			} 
			else if(status.equals("CN")) {
				sbSQL.append(" AND pdp.CANCEL_YN='Y' ");

			} 
			else if(status.equals("PG")) {          
				sbSQL.append(" AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL AND b.ORDER_LINE_STATUS IN ('PO','PC','PS') ");

			} 
			
			else if(status.equals("PO")) {
				sbSQL.append(" AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL AND b.ORDER_LINE_STATUS = 'PO' ");
			
			}
			else if(status.equals("PC")) {
				sbSQL.append(" AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL AND b.ORDER_LINE_STATUS = 'PC' ");
			
			} 
			else if(status.equals("PS")) {
				sbSQL.append(" AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL AND b.ORDER_LINE_STATUS = 'PS' ");
			
			}


			if(date_order.equals("D"))
			sbSQL.append(" order by ord_date desc");
		else
			sbSQL.append(" order by ord_date asc");
		
		
	
	

try{

	//System.err.println("event dates SQL for Medicalitems==="+sbSQL.toString());
	 pStatment = con.prepareStatement(sbSQL.toString());
	 
	     pStatment.setString(i++, patient_id);
		 if(!patient_class.equals(""))
              pStatment.setString(i++, temp_pat_class);
		 if(!encounter_id.equals(""))
			 pStatment.setString(i++, encounter_id);
		 if(!drug_id.equals(""))
			 pStatment.setString(i++, drug_id);
		 if(!from_date.equals("") && !to_date.equals("")){
		 pStatment.setString(i++, from_date);
		 pStatment.setString(i++, to_date);
		 }else if(!from_date.equals(""))
			 pStatment.setString(i++, from_date);
		 else if(!to_date.equals(""))
			 pStatment.setString(i++, to_date);
		 if(!facility_id.equals(""))
		 pStatment.setString(i++, facility_id);
		 if("self_tab".equals(selTab)){
			pStatment.setString(i++, pract_id);
			 //pStatment.setString(i++, facility_id);//commented for 10245
		 }
		 
		 if("my_tab".equals(selTab)){
			 
			  pStatment.setString(i++, pract_id);
		 }

		 pStatment.setString(i++, locale);
		 pStatment.setString(i++, patient_id);
		 if(!patient_class.equals(""))
  			  pStatment.setString(i++, patient_class);
		 if(!encounter_id.equals(""))
			 pStatment.setString(i++, encounter_id);
		 if(!drug_id.equals(""))
			 pStatment.setString(i++, drug_id);
		 if(!from_date.equals("") && !to_date.equals("")){
		 pStatment.setString(i++, from_date);
		 pStatment.setString(i++, to_date);
		 }else if(!from_date.equals(""))
			 pStatment.setString(i++, from_date);
		 else if(!to_date.equals(""))
			 pStatment.setString(i++, to_date);
		 if(!facility_id.equals(""))
		 pStatment.setString(i++, facility_id);
		 if("self_tab".equals(selTab)){
			pStatment.setString(i++, pract_id);
			// pStatment.setString(i++, facility_id);//commented for 10245
		 }
		 
		 if("my_tab".equals(selTab)){
			 
			  pStatment.setString(i++, pract_id);
		 }	 
		
		
	 resultSet = pStatment.executeQuery(); 
	 if ( resultSet != null )
	 {
			while(resultSet.next())
			{
				eventDate.add(resultSet.getString("ord_date")==null?"":resultSet.getString("ord_date")); 
			}
		}
    }
	
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		if(resultSet != null) resultSet.close();
		if(pStatment != null) pStatment.close();
	}

}

return eventDate;
}

public ArrayList getDrugDetails(Connection con,String locale,String patient_id,String encounter_id,String pract_id,String from_date,String to_date,String selTab,String pat_class,String req_facility_id,String status,String drug_id,String generic_id,String drug_category, String order_type,String date_order,boolean site,boolean display_transfer_locn,boolean siteOrder) throws Exception {//IN069654

    PreparedStatement pStatment = null;
	ResultSet resultSet = null;
	int i=1;
	String sql_append	=	"", stMainSql="",ip_patient_order="";
	ArrayList drugDetails = new ArrayList();
	ArrayList recordDetails =new ArrayList();
	String date_by       ="";

	if(date_order.equals("D"))
            date_by =" desc ";
	else 
		    date_by =" asc ";
	

	if(pat_class.equals("XT")){
				if(status.equals("A")){
					sql_append	=	" AND SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL ";
				}
				else if(status.equals("F")) {
					sql_append	=	" AND A.START_DATE > SYSDATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL ";
				} 
				else if(status.equals("C")) {
					sql_append	=	" AND SYSDATE >= A.END_DATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL  AND O.ORDER_LINE_STATUS IN ('DF')";
				} 
				else if(status.equals("DC")) {
					sql_append	=	" AND O.DISC_DATE_TIME IS NOT NULL AND A.CANCEL_YN='N'";				
				} 
				else if(status.equals("HD") || status.equals("HC")) {
					sql_append	=	" AND O.HOLD_DATE_TIME IS NOT NULL AND A.CANCEL_YN='N' AND O.ORDER_LINE_STATUS IN ('HD','HC')";				
				} 
				else if(status.equals("R")) {
					sql_append	=	" AND A.RETURNED_QTY IS NOT NULL ";
				
				} 
				else if(status.equals("CN")) {
					sql_append	=	" AND A.CANCEL_YN='Y' ";
					
				} 
				else if(status.equals("PG")) {          
					sql_append	=	" AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND O.ORDER_LINE_STATUS IN ('PO','PC','PS') ";
						
				} 
				
				else if(status.equals("PO")) {
					sql_append	=	" AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND O.ORDER_LINE_STATUS = 'PO' ";
				
				}
				else if(status.equals("PC")) {
					sql_append	=	" AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND O.ORDER_LINE_STATUS = 'PC' ";				
				} 
				else if(status.equals("PS")) {
					sql_append	=	" AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND O.ORDER_LINE_STATUS = 'PS' ";
				
				} 
				else {
					sql_append	=	"AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL ";
				}
			}
			else if((pat_class.equals("IP") || pat_class.equals("DC")) && status.equals("A")) {
				sql_append	=	" AND SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND O.ORDER_LINE_STATUS NOT IN ('PO','PS','CN','HD','HC','DC')";
			} 
			else if((pat_class.equals("OP") || pat_class.equals("EM")) && status.equals("A")) {
				sql_append	=	" AND SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND (NVL(A.TOT_ISSUED_QTY,0)-NVL(A.RETURNED_QTY,0))>=0 AND O.ORDER_LINE_STATUS NOT IN ('PO','PS','CN','HD','HC','DC')";
				
			} 
			else if(status.equals("A")) {
				sql_append	=	" AND ((A.PATIENT_CLASS = 'IP' AND SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND (NVL(A.TOT_ISSUED_QTY,0)-NVL(A.RETURNED_QTY,0))>=0 AND O.ORDER_LINE_STATUS NOT IN ('PO','PS','CN','HD','HC','DC')) OR (A.PATIENT_CLASS IN( 'OP' ,'XT') AND SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND (NVL(A.TOT_ISSUED_QTY,0)-NVL(A.RETURNED_QTY,0))>=0 AND O.ORDER_LINE_STATUS NOT IN ('PO','PS','CN','HD','HC','DC')))";
				
			} 
			else if(status.equals("F")) {
				sql_append	=	" AND A.START_DATE > SYSDATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL ";
			} 
			else if(status.equals("C")) {
				sql_append	=	" AND SYSDATE >= A.END_DATE AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL  AND O.ORDER_LINE_STATUS IN ('DF')";
			} 
			else	if(status.equals("DC")) {
				sql_append	=	" AND O.DISC_DATE_TIME IS NOT NULL AND A.CANCEL_YN='N'";
				
			} 
			else if(status.equals("HD") || status.equals("HC")) {
				sql_append	=	" AND O.HOLD_DATE_TIME IS NOT NULL AND A.CANCEL_YN='N' AND O.ORDER_LINE_STATUS IN ('HD','HC')";
				
			} 
			else if(status.equals("R")) {
				sql_append	=	" AND A.RETURNED_QTY IS NOT NULL ";
				
			} 
			else if(status.equals("CN")) {
				sql_append	=	" AND A.CANCEL_YN='Y' ";
				
			} 
			else if(status.equals("PG")) {          
				sql_append	=	" AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND O.ORDER_LINE_STATUS IN ('PO','PC','PS') ";
				
			} 
			else if(status.equals("PN")) {
				
			} 
			else if(status.equals("PO")) {
				sql_append	=	" AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND O.ORDER_LINE_STATUS = 'PO' ";
				
			}
			else if(status.equals("PC")) {
				sql_append	=	" AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND O.ORDER_LINE_STATUS = 'PC' ";
				
			} 
			else if(status.equals("PS")) {
				sql_append	=	" AND A.CANCEL_YN='N' AND A.STOP_YN='N' AND A.ON_HOLD_DATE_TIME IS NULL AND A.DISCONT_DATE_TIME IS NULL AND O.ORDER_LINE_STATUS = 'PS' ";
				
			} 
			else {
				
			}
			 
				
		
			//Common parameters.
			//HashMap sqlMap = new HashMap();//Common-ICN-0092  
			

			if(pat_class.equals("XT")){
				
				stMainSql = "SELECT A.ORIG_ORDER_ID, A.ORIG_ORDER_LINE_NO, A.SRL_NO, A.IV_PREP_YN, Q.IV_PREP_YN LINE_IV_PREP_YN, Q.DISCHARGE_IND, O.ORDER_LINE_STATUS, O.CHILD_ORDER_YN, A.INFUSE_OVER, A.TRN_TYPE_IND, A.DRUG_CODE, C.DRUG_DESC, A.DISPENSED_DRUGS, A.ROUTE_CODE, DECODE(A.IV_PREP_YN,'6',' ',PH_GET_DESC.PH_ROUTE  (A.ROUTE_CODE,B.LANGUAGE_ID,'1')) ROUTE_DESC,    DECODE(DRUG_YN,'N','',DECODE(A.IV_PREP_YN, '6',((RTRIM(RTRIM(TO_CHAR(O.QTY_VALUE, '999999990.999999'),'0'),'.'))||' '||AM_GET_DESC.AM_UOM  (O.QTY_UNIT,B.LANGUAGE_ID,'2')|| CHR (13) || DECODE (A.SPLIT_YN, 'Y', '(DIVIDED), ',', ') || H.FREQ_DESC || ', ' || CHR (13)|| DURATION|| ' '|| AM_GET_DESC.AM_DURATION_TYPE  (A.DURN_TYPE,B.LANGUAGE_ID,'1')),(DECODE(S.SLIDING_SCALE_YN ,'Y',''/*'SLIDING SCALE'*/,( RTRIM(RTRIM(TO_CHAR(A.DOSAGE, '999999990.999999'),'0'),'.') )|| ' '|| AM_GET_DESC.AM_UOM  (A.DOSAGE_UOM_CODE,B.LANGUAGE_ID,'2') )|| CHR (13)|| DECODE (A.SPLIT_YN, 'Y', '(DIVIDED), ', ', ') || H.FREQ_DESC || ', '|| CHR (13)|| DURATION|| ' '|| AM_GET_DESC.AM_DURATION_TYPE  (A.DURN_TYPE,B.LANGUAGE_ID,'1'))) )DOSAGE_DETAILS, DECODE(DRUG_YN,'N','',TO_CHAR (A.START_DATE, 'DD/MM/YYYY HH24:MI')) START_DATE, DECODE(DRUG_YN,'N','',TO_CHAR (A.END_DATE, 'DD/MM/YYYY HH24:MI')) END_DATE, A.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER  (A.PRES_PRACTITIONER_ID,B.LANGUAGE_ID,'1') PRACTITIONER_NAME, SM_GET_DESC.SM_FACILITY_PARAM  (A.ORIG_FACILITY_ID,B.LANGUAGE_ID,'1') FACILITY_NAME, OP_GET_DESC.OP_CLINIC  (A.ORIG_FACILITY_ID,A.LOCN_CODE,B.LANGUAGE_ID,'2') LOCATION, (CASE /* SRR20056-SCF-7416 [INCIDENT NO. 27457] WHEN Q.CAN_REASON IS NOT NULL  THEN 'HOLD'  */ WHEN O.CAN_DATE_TIME IS NOT NULL  THEN 'CANCEL' WHEN O.HOLD_DATE_TIME IS NOT NULL  THEN 'HOLD' WHEN O.DISC_DATE_TIME IS NOT NULL  THEN 'DIS-CONTINUED' WHEN SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND (NVL (A.TOT_ISSUED_QTY, 0) - NVL (A.RETURNED_QTY, 0)) != 0  THEN 'ACTIVE' ELSE 'INACTIVE' END ) STATUS, (SELECT COUNT (*)  FROM OR_ORDER_LINE_FIELD_VALUES   B   WHERE B.ORDER_ID = A.ORIG_ORDER_ID AND B.ORDER_LINE_NUM = A.ORIG_ORDER_LINE_NO) REMARKS, S.PRES_QTY_UOM PRESCRIBED_UOM , O.LAST_ACTION_REASON_DESC, A.HEIGHT, A.HEIGHT_UOM, A.WEIGHT, A.WEIGHT_UOM, A.BSA, A.BMI, A.PRESCRIBED_QTY, A.TOT_ISSUED_QTY, A.RETURNED_QTY, A.TOT_ADMINISTERED_QTY, A.DOSAGE_UOM_CODE, A.REISSUED_QTY, A.REISSUE_DATE_TIME, A.REISSUE_REASON_CODE, O.ORDER_UOM, TO_CHAR (A.RETURN_DATE_TIME, 'DD/MM/YYYY') RETURN_DATE_TIME, (NVL (A.TOT_ISSUED_QTY, 0) - NVL (A.RETURNED_QTY, 0)) RET_DIFF , C.STRENGTH_PER_VALUE_PRES_UOM, C.CONTENT_IN_PRES_BASE_UOM, C.PRES_BASE_UOM, R.SHORT_DESC LINE_STATUS_DESC, S.FORMULARY_ITEM_YN ,  S.SLIDING_SCALE_YN, A.SLIDING_SCALE_ADM_UNIT, A.SLIDING_SCALE_ADM_UOM,PH_GET_ALTERNATES  (A.ORIG_ORDER_ID, A.ORIG_ORDER_LINE_NO) ALTERNATES,S.COMPLETE_ORDER_REASON,H.FREQ_NATURE,S.DOSAGE_TYPE DOSAGE_TYPE,S.MFR_YN MFRYN, (SELECT COUNT(*) FROM PH_MEDN_ADMIN  WHERE ORDER_ID=A.ORIG_ORDER_ID AND ORDER_LINE_NUM=A.ORIG_ORDER_LINE_NO AND ADMN_DOSE_CHNG_REMARKS IS NOT NULL) ADMIN_DOSE_CHNG_REASON_CNT,O.QTY_UNIT,NVL(A.SPLIT_YN,'N') SPLIT_DOSE_YN,A.PRN_REMARKS,K.ROUTE_COLOR,S.AMENDED_BY_ID,S.AMEND_REASON_CODE,S.AMEND_REASON,S.AMENDED_DATE,A.STRENGTH, A.ALT_DRUG_REMARKS, S.VERIFY_REMARKS, S.PREGNANCY_OVERRIDE_REASON, S.ALLOCATE_REMARKS_CODE, S.ALLOCATE_TASK_FINDING,S.FILL_REMARKS_CODE, S.FILL_TASK_FINDING,S.DELIVERY_REMARKS_CODE, S.DELIVERY_TASK_FINDING, (SELECT COUNT(DISP_NO)  FROM PH_DISP_DTL WHERE ORDER_ID=O.ORDER_ID AND ORDER_LINE_NO=O.ORDER_LINE_NUM)DISPENSE_COUNT,Q.HOME_LEAVE_MEDN_YN,Q.REF_SENT_REMARKS,S.DISC_CANCELLED_ORDERS, S.LAST_DISPENSED_DATE,B.GENERIC_NAME,Q.REF_SENT_PRACT_ID,O.ORDER_QTY";
				
				if(site){
			    stMainSql = stMainSql+"  ,AM_GET_DESC.AM_PRACTITIONER  ((SELECT ADDED_BY_ID FROM PH_PATIENT_DRUG_PROFILE  WHERE ORIG_ORDER_ID = O.ORDER_ID AND ORIG_ORDER_LINE_NO=O.ORDER_LINE_NUM AND DRUG_CODE = C.DRUG_CODE),B.LANGUAGE_ID,'1') ADDED_BY_ID";
				
				}
				else{
					stMainSql=stMainSql+",A.ADDED_BY_ID";
				}
				
				stMainSql =stMainSql+" FROM PH_PATIENT_DRUG_PROFILE  A, PH_GENERIC_NAME_LANG_VW  B, PH_DRUG_LANG_VW  C, AM_FREQUENCY_LANG_VW  H, OR_ORDER_LINE  O, OR_ORDER  Q,OR_ORDER_STATUS_CODE_LANG_VW  R,OR_ORDER_LINE_PH  S ,PH_ROUTE  K WHERE Q.ORDER_ID = O.ORDER_ID AND A.PATIENT_ID = ? AND A.PATIENT_CLASS =  NVL (?, '!')  AND A.START_DATE BETWEEN TO_DATE ( NVL (?,'01/01/1472 00:01'), 'DD/MM/YYYY HH24:MI')  AND TO_DATE ( NVL (?,'31/12/5000 00:01'), 'DD/MM/YYYY HH24:MI') + 0.99999  AND A.GENERIC_ID BETWEEN NVL (?, '!') AND NVL (?, '~') AND A.DRUG_CODE BETWEEN NVL (?, '!') AND NVL (?, '~') AND A.GENERIC_ID = B.GENERIC_ID AND A.DRUG_CODE = C.DRUG_CODE AND H.FREQ_CODE = A.FREQ_CODE AND A.ORIG_ORDER_ID = O.ORDER_ID AND K.ROUTE_CODE=A.ROUTE_CODE AND A.ORIG_ORDER_LINE_NO = O.ORDER_LINE_NUM AND O.ORDER_LINE_STATUS = R.ORDER_STATUS_CODE 	AND O.ORDER_ID=S.ORDER_ID AND O.ORDER_LINE_NUM=S.ORDER_LINE_NUM	AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = H.LANGUAGE_ID AND B.LANGUAGE_ID = R.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND C.DRUG_YN='Y' ";
				if(!encounter_id.equals("")){
					stMainSql =stMainSql+" AND A.ENCOUNTER_ID = ?" ;
				}
               	if(!req_facility_id.equals(""))
				      stMainSql= stMainSql+" and a.FACILITY_ID = ?";
				if(selTab.equals("S"))
				      stMainSql= stMainSql+" and q.ORD_PRACT_ID=?";
                if(selTab.equals("M"))
                	 // stMainSql= stMainSql+" and 'Y' = CA_PRACT_SPECILITY_YN(a.PRACTITIONER_ID,?,?)";//commmented for 10245
                	stMainSql= stMainSql+" and 'Y' = CA_PRACT_SPECILITY_YN(a.PRACTITIONER_ID,?,a.facility_id)";//added for 10245
				if(!order_type.equals(""))
					stMainSql= stMainSql+" and o.order_type_code=?";

				
				stMainSql = stMainSql +  sql_append + " ORDER BY A.START_DATE "+date_by+" ";
			}
			else if(pat_class.equals("IP")) { 
					if(siteOrder || display_transfer_locn){
					ip_patient_order="Q.ORIG_SOURCE_CODE";

					}
					else{
					ip_patient_order="A.LOCN_CODE";
					}
					
					stMainSql = "SELECT A.ORIG_ORDER_ID, A.ORIG_ORDER_LINE_NO, A.SRL_NO, A.IV_PREP_YN, Q.IV_PREP_YN LINE_IV_PREP_YN, Q.DISCHARGE_IND, O.ORDER_LINE_STATUS, O.CHILD_ORDER_YN, A.INFUSE_OVER, A.TRN_TYPE_IND, A.DRUG_CODE, C.DRUG_DESC, A.DISPENSED_DRUGS, A.ROUTE_CODE, DECODE(A.IV_PREP_YN,'6',' ',PH_GET_DESC.PH_ROUTE  (A.ROUTE_CODE,B.LANGUAGE_ID,'1')) ROUTE_DESC,DECODE(DRUG_YN,'N','', DECODE(A.IV_PREP_YN, '6',((RTRIM(RTRIM(TO_CHAR(O.QTY_VALUE, '999999990.999999'),'0'),'.'))||' '||AM_GET_DESC.AM_UOM  (O.QTY_UNIT,B.LANGUAGE_ID,'2')|| CHR (13)|| DECODE (A.SPLIT_YN, 'Y', '(DIVIDED), ', ', ') || H.FREQ_DESC || ', '|| CHR (13)   || DURATION|| ' '|| AM_GET_DESC.AM_DURATION_TYPE  (A.DURN_TYPE,B.LANGUAGE_ID,'1')),(DECODE(S.SLIDING_SCALE_YN ,'Y',''/*'SLIDING SCALE'*/,( RTRIM(RTRIM(TO_CHAR(A.DOSAGE, '999999990.999999'),'0'),'.') )|| ' '|| AM_GET_DESC.AM_UOM  (A.DOSAGE_UOM_CODE,B.LANGUAGE_ID,'2'))|| CHR (13)|| DECODE (A.SPLIT_YN, 'Y', '(DIVIDED), ',', ') || H.FREQ_DESC || ', '|| CHR (13)|| DURATION|| ' '|| AM_GET_DESC.AM_DURATION_TYPE  (A.DURN_TYPE,B.LANGUAGE_ID,'1'))) )DOSAGE_DETAILS, DECODE(DRUG_YN,'N','',TO_CHAR (A.START_DATE, 'DD/MM/YYYY HH24:MI') )START_DATE, DECODE(DRUG_YN,'N','',TO_CHAR (A.END_DATE, 'DD/MM/YYYY HH24:MI')) END_DATE, DECODE(P.PATIENT_CLASS,NULL,'XT',P.PATIENT_CLASS) PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER  (A.PRES_PRACTITIONER_ID,B.LANGUAGE_ID,'1') PRACTITIONER_NAME, SM_GET_DESC.SM_FACILITY_PARAM  (A.ORIG_FACILITY_ID,B.LANGUAGE_ID,'1') FACILITY_NAME, DECODE (A.LOCN_TYPE, NULL, AM_GET_DESC.AM_REFERRAL  (A.LOCN_CODE,B.LANGUAGE_ID,'2'),'N', IP_GET_DESC.IP_NURSING_UNIT (A.ORIG_FACILITY_ID,"+ip_patient_order+",B.LANGUAGE_ID,'2'), 'C', OP_GET_DESC.OP_CLINIC  (A.ORIG_FACILITY_ID,A.LOCN_CODE,B.LANGUAGE_ID,'2') ) LOCATION,(CASE /* SRR20056-SCF-7416 [INCIDENT NO. 27457] WHEN Q.CAN_REASON IS NOT NULL  THEN 'HOLD' */ WHEN O.CAN_DATE_TIME IS NOT NULL  THEN 'CANCEL' WHEN O.HOLD_DATE_TIME IS NOT NULL THEN 'HOLD' WHEN O.DISC_DATE_TIME IS NOT NULL THEN 'DIS-CONTINUED' WHEN SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND (NVL (A.TOT_ISSUED_QTY, 0) - NVL (A.RETURNED_QTY, 0)) != 0 THEN 'ACTIVE' ELSE 'INACTIVE' END ) STATUS, (SELECT COUNT (*) FROM OR_ORDER_LINE_FIELD_VALUES  B  WHERE B.ORDER_ID = A.ORIG_ORDER_ID  AND B.ORDER_LINE_NUM = A.ORIG_ORDER_LINE_NO) REMARKS, S.PRES_QTY_UOM PRESCRIBED_UOM, O.LAST_ACTION_REASON_DESC, A.HEIGHT, A.HEIGHT_UOM, A.WEIGHT, A.WEIGHT_UOM, A.BSA, A.BMI, A.PRESCRIBED_QTY, A.TOT_ISSUED_QTY, A.RETURNED_QTY, A.TOT_ADMINISTERED_QTY, A.DOSAGE_UOM_CODE, A.REISSUED_QTY, TO_CHAR (A.REISSUE_DATE_TIME, 'DD/MM/YYYY HH24:MI') REISSUE_DATE_TIME, A.REISSUE_REASON_CODE, O.ORDER_UOM, TO_CHAR (A.RETURN_DATE_TIME, 'DD/MM/YYYY HH24:MI') RETURN_DATE_TIME, (NVL (A.TOT_ISSUED_QTY, 0) - NVL (A.RETURNED_QTY, 0)) RET_DIFF, C.STRENGTH_PER_VALUE_PRES_UOM, C.CONTENT_IN_PRES_BASE_UOM, C.PRES_BASE_UOM, R.SHORT_DESC LINE_STATUS_DESC, S.FORMULARY_ITEM_YN,  S.SLIDING_SCALE_YN, A.SLIDING_SCALE_ADM_UNIT, A.SLIDING_SCALE_ADM_UOM,PH_GET_ALTERNATES  (A.ORIG_ORDER_ID, A.ORIG_ORDER_LINE_NO) ALTERNATES,S.COMPLETE_ORDER_REASON,H.FREQ_NATURE, S.DOSAGE_TYPE DOSAGE_TYPE,S.MFR_YN MFRYN,(SELECT COUNT(*) FROM PH_MEDN_ADMIN  WHERE ORDER_ID=A.ORIG_ORDER_ID AND ORDER_LINE_NUM=A.ORIG_ORDER_LINE_NO AND ADMN_DOSE_CHNG_REMARKS IS NOT NULL) ADMIN_DOSE_CHNG_REASON_CNT,O.QTY_UNIT,NVL(A.SPLIT_YN,'N') SPLIT_DOSE_YN,A.PRN_REMARKS, K.ROUTE_COLOR,S.AMENDED_BY_ID,S.AMEND_REASON_CODE,S.AMEND_REASON,S.AMENDED_DATE,A.STRENGTH, A.ALT_DRUG_REMARKS, S.VERIFY_REMARKS, S.PREGNANCY_OVERRIDE_REASON, S.ALLOCATE_REMARKS_CODE, S.ALLOCATE_TASK_FINDING,S.FILL_REMARKS_CODE, S.FILL_TASK_FINDING,S.DELIVERY_REMARKS_CODE, S.DELIVERY_TASK_FINDING, (SELECT COUNT(DISP_NO)  FROM PH_DISP_DTL  WHERE ORDER_ID=O.ORDER_ID AND ORDER_LINE_NO=O.ORDER_LINE_NUM) DISPENSE_COUNT,Q.HOME_LEAVE_MEDN_YN,Q.REF_SENT_REMARKS, S.DISC_CANCELLED_ORDERS, S.LAST_DISPENSED_DATE,B.GENERIC_NAME,Q.REF_SENT_PRACT_ID,O.ORDER_QTY";

				if(site){
			    stMainSql = stMainSql+"  ,AM_GET_DESC.AM_PRACTITIONER  ((SELECT ADDED_BY_ID FROM PH_PATIENT_DRUG_PROFILE WHERE ORIG_ORDER_ID = O.ORDER_ID AND ORIG_ORDER_LINE_NO=O.ORDER_LINE_NUM AND DRUG_CODE = C.DRUG_CODE AND PRES_PRACTITIONER_ID <> A.ADDED_BY_ID),B.LANGUAGE_ID,'1') ADDED_BY_ID";
			  
				}
				else{
					stMainSql=stMainSql+",A.ADDED_BY_ID";
				}
			
				stMainSql=stMainSql+" FROM PH_PATIENT_DRUG_PROFILE  A, PH_GENERIC_NAME_LANG_VW  B, PH_DRUG_LANG_VW  C, AM_FREQUENCY_LANG_VW  H, OR_ORDER_LINE  O, OR_ORDER  Q,OR_ORDER_STATUS_CODE_LANG_VW  R ,OR_ORDER_LINE_PH  S,PH_ROUTE  K, PR_ENCOUNTER  P WHERE Q.ORDER_ID = O.ORDER_ID AND A.PATIENT_ID = ? AND P.PATIENT_CLASS = ? AND (Q.DISCHARGE_IND IS NULL OR  Q.DISCHARGE_IND ='N') AND A.START_DATE BETWEEN TO_DATE ( NVL (?,'01/01/1472 00:01'), 'DD/MM/YYYY HH24:MI')  AND TO_DATE ( NVL (?,'31/12/5000 00:01'), 'DD/MM/YYYY HH24:MI') + 0.99999  AND A.GENERIC_ID BETWEEN NVL (?, '!') AND NVL (?, '~') AND A.DRUG_CODE BETWEEN NVL (?, '!') AND NVL (?, '~') AND A.GENERIC_ID = B.GENERIC_ID AND A.DRUG_CODE = C.DRUG_CODE AND H.FREQ_CODE = A.FREQ_CODE AND A.ORIG_ORDER_ID = O.ORDER_ID AND A.ORIG_ORDER_LINE_NO = O.ORDER_LINE_NUM AND O.ORDER_LINE_STATUS = R.ORDER_STATUS_CODE AND K.ROUTE_CODE=A.ROUTE_CODE AND O.ORDER_ID=S.ORDER_ID AND O.ORDER_LINE_NUM=S.ORDER_LINE_NUM AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = H.LANGUAGE_ID AND B.LANGUAGE_ID = R.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND C.DRUG_YN ='Y' AND P.ENCOUNTER_ID(+) = A.ENCOUNTER_ID AND P.FACILITY_ID(+) = A.ORIG_FACILITY_ID ";

				if(!encounter_id.equals("")){
					stMainSql =stMainSql+" AND A.ENCOUNTER_ID = ?" ;
				}

				if(!req_facility_id.equals(""))
				      stMainSql= stMainSql+" and a.FACILITY_ID = ?";
				if(selTab.equals("S"))
				      stMainSql= stMainSql+" and q.ORD_PRACT_ID=?";
                if(selTab.equals("M"))
                	 // stMainSql= stMainSql+" and 'Y' = CA_PRACT_SPECILITY_YN(a.PRACTITIONER_ID,?,?)";//commmented for 10245
                	stMainSql= stMainSql+" and 'Y' = CA_PRACT_SPECILITY_YN(a.PRACTITIONER_ID,?,a.facility_id)";//added for 10245
				if(!order_type.equals(""))
					stMainSql= stMainSql+" and o.order_type_code=?";

				
				if (!sql_append.equals(""))
					stMainSql =  stMainSql +  sql_append + " ORDER BY A.START_DATE "+date_by+",A.ORIG_ORDER_ID,A.ORIG_ORDER_LINE_NO";
				else
					stMainSql =  stMainSql+" ORDER BY A.START_DATE "+date_by+"";
			}
			else if(pat_class.equals("OP")) {
				stMainSql = "SELECT A.ORIG_ORDER_ID, A.ORIG_ORDER_LINE_NO, A.SRL_NO, A.IV_PREP_YN, Q.IV_PREP_YN LINE_IV_PREP_YN, Q.DISCHARGE_IND, O.ORDER_LINE_STATUS, O.CHILD_ORDER_YN, A.INFUSE_OVER, A.TRN_TYPE_IND, A.DRUG_CODE, C.DRUG_DESC, A.DISPENSED_DRUGS, A.ROUTE_CODE, decode(A.IV_PREP_YN,'6',' ',ph_get_desc.ph_route  (a.route_code,b.language_id,'1')) ROUTE_DESC,decode(drug_yn,'N','', DECODE(a.iv_prep_yn, '6',((RTRIM(rtrim(to_char(o.qty_value, '999999990.999999'),'0'),'.'))||' '||am_get_desc.am_uom  (o.qty_unit,b.language_id,'2')|| CHR (13)|| DECODE (a.split_yn, 'Y', '(Divided), ', ', ') || h.freq_desc || ', '|| CHR (13)   || DURATION|| ' '|| am_get_desc.am_duration_type  (a.durn_type,b.language_id,'1')),(decode(s.SLIDING_SCALE_YN ,'Y',''/*'Sliding Scale'*/,( RTRIM(rtrim(to_char(a.dosage, '999999990.999999'),'0'),'.') )|| ' '|| am_get_desc.am_uom  (a.dosage_uom_code,b.language_id,'2'))|| CHR (13)|| DECODE (a.split_yn, 'Y', '(Divided), ',', ') || h.freq_desc || ', '|| CHR (13)|| DURATION|| ' '|| am_get_desc.am_duration_type  (a.durn_type,b.language_id,'1'))) )DOSAGE_DETAILS, decode(drug_yn,'N','',TO_CHAR (A.START_DATE, 'DD/MM/YYYY HH24:MI') )START_DATE, decode(drug_yn,'N','',TO_CHAR (A.END_DATE, 'DD/MM/YYYY HH24:MI')) END_DATE, decode(p.patient_class,null,'XT',p.patient_class) patient_class, am_get_desc.am_practitioner  (a.pres_practitioner_id,b.language_id,'1') PRACTITIONER_NAME, sm_get_desc.sm_facility_param  (a.orig_facility_id,b.language_id,'1') FACILITY_NAME, DECODE (a.LOCN_TYPE, NULL, am_get_desc.am_referral  (a.locn_code,b.language_id,'2'),'N', ip_get_desc.ip_nursing_unit  (a.orig_facility_id,a.locn_code,b.language_id,'2'), 'C', op_get_desc.OP_CLINIC  (a.orig_facility_id,a.locn_code,b.language_id,'2') ) LOCATION,(CASE /* SRR20056-SCF-7416 [Incident No. 27457] WHEN Q.CAN_REASON IS NOT NULL  THEN 'HOLD' */ WHEN O.CAN_DATE_TIME IS NOT NULL  THEN 'CANCEL' WHEN O.HOLD_DATE_TIME IS NOT NULL THEN 'HOLD' WHEN O.DISC_DATE_TIME IS NOT NULL THEN 'DIS-CONTINUED' WHEN SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND (NVL (A.TOT_ISSUED_QTY, 0) - NVL (A.RETURNED_QTY, 0)) != 0 THEN 'ACTIVE' ELSE 'INACTIVE' END ) STATUS, (SELECT COUNT (*) FROM OR_ORDER_LINE_FIELD_VALUES  B  WHERE B.ORDER_ID = A.ORIG_ORDER_ID  AND B.ORDER_LINE_NUM = A.ORIG_ORDER_LINE_NO) REMARKS, S.PRES_QTY_UOM PRESCRIBED_UOM, O.LAST_ACTION_REASON_DESC, A.HEIGHT, A.HEIGHT_UOM, A.WEIGHT, A.WEIGHT_UOM, A.BSA, A.BMI, A.PRESCRIBED_QTY, A.TOT_ISSUED_QTY, A.RETURNED_QTY, A.TOT_ADMINISTERED_QTY, A.DOSAGE_UOM_CODE, A.REISSUED_QTY, TO_CHAR (A.REISSUE_DATE_TIME, 'DD/MM/YYYY HH24:MI') REISSUE_DATE_TIME, A.REISSUE_REASON_CODE, O.ORDER_UOM, TO_CHAR (A.RETURN_DATE_TIME, 'DD/MM/YYYY HH24:MI') RETURN_DATE_TIME, (NVL (A.TOT_ISSUED_QTY, 0) - NVL (A.RETURNED_QTY, 0)) RET_DIFF, C.STRENGTH_PER_VALUE_PRES_UOM, C.CONTENT_IN_PRES_BASE_UOM, c.PRES_BASE_UOM, R.SHORT_DESC LINE_STATUS_DESC, s.FORMULARY_ITEM_YN,  s.SLIDING_SCALE_YN, a.SLIDING_SCALE_ADM_UNIT, a.SLIDING_SCALE_ADM_UOM,ph_get_alternates  (A.ORIG_ORDER_ID, A.ORIG_ORDER_LINE_NO) alternates,s.COMPLETE_ORDER_REASON,h.FREQ_NATURE, S.DOSAGE_TYPE dosage_type,S.MFR_YN mfrYN,(SELECT COUNT(*) FROM PH_MEDN_ADMIN  WHERE ORDER_ID=A.ORIG_ORDER_ID AND ORDER_LINE_NUM=A.ORIG_ORDER_LINE_NO AND ADMN_DOSE_CHNG_REMARKS IS NOT NULL) ADMIN_DOSE_CHNG_REASON_CNT,O.QTY_UNIT,nvl(a.split_yn,'N') split_dose_yn,A.PRN_REMARKS, K.ROUTE_COLOR,s.AMENDED_BY_ID,s.AMEND_REASON_CODE,s.AMEND_REASON,s.AMENDED_DATE,A.STRENGTH, A.ALT_DRUG_REMARKS, s.VERIFY_REMARKS, s.PREGNANCY_OVERRIDE_REASON, S.ALLOCATE_REMARKS_CODE, s.allocate_task_finding,s.FILL_REMARKS_CODE, s.fill_task_finding,s.DELIVERY_REMARKS_CODE, s.delivery_task_finding, (select count(DISP_NO)  from ph_disp_dtl  where order_id=o.order_id and order_line_no=o.order_line_num) DISPENSE_COUNT,Q.home_leave_medn_yn,Q.REF_SENT_REMARKS, S.DISC_CANCELLED_ORDERS, S.LAST_DISPENSED_DATE,B.GENERIC_NAME,q.ref_sent_pract_id,O.ORDER_QTY";
				if(site){
			    stMainSql = stMainSql+"  ,am_get_desc.am_practitioner  ((SELECT added_by_id FROM ph_patient_drug_profile  WHERE orig_order_id = o.order_id and ORIG_ORDER_LINE_NO=o.ORDER_LINE_NUM AND drug_code = c.drug_code and PRES_PRACTITIONER_ID <> a.added_by_id),b.language_id,'1') ADDED_BY_ID";
			  
				}
				else{
					stMainSql=stMainSql+",A.ADDED_BY_ID";
				}
				
				stMainSql=stMainSql+" FROM PH_PATIENT_DRUG_PROFILE  A, PH_GENERIC_NAME_LANG_VW  B, PH_DRUG_LANG_VW  C, AM_FREQUENCY_LANG_VW  H, OR_ORDER_LINE  O, OR_ORDER  Q,OR_ORDER_STATUS_CODE_LANG_VW  R ,or_order_line_ph  s,PH_ROUTE  K, PR_ENCOUNTER  P WHERE Q.ORDER_ID = O.ORDER_ID AND A.PATIENT_ID = ? AND (p.PATIENT_CLASS = ? OR q.discharge_ind = 'D') AND A.START_DATE BETWEEN TO_DATE ( NVL (?,'01/01/1472 00:01'), 'DD/MM/YYYY HH24:MI')  AND TO_DATE ( NVL (?,'31/12/5000 00:01'), 'DD/MM/YYYY HH24:MI') + 0.99999  AND A.GENERIC_ID BETWEEN NVL (?, '!') AND NVL (?, '~') AND A.DRUG_CODE BETWEEN NVL (?, '!') AND NVL (?, '~') AND A.GENERIC_ID = B.GENERIC_ID AND A.DRUG_CODE = C.DRUG_CODE AND H.FREQ_CODE = A.FREQ_CODE AND A.ORIG_ORDER_ID = O.ORDER_ID AND A.ORIG_ORDER_LINE_NO = O.ORDER_LINE_NUM AND O.ORDER_LINE_STATUS = R.ORDER_STATUS_CODE and K.ROUTE_CODE=A.ROUTE_CODE AND o.order_id=s.order_ID and O.ORDER_LINE_NUM=s.ORDER_LINE_NUM AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = H.LANGUAGE_ID AND B.LANGUAGE_ID = R.LANGUAGE_ID AND B.LANGUAGE_ID = ? and c.DRUG_YN ='Y' AND P.ENCOUNTER_ID(+) = A.ENCOUNTER_ID AND P.FACILITY_ID(+) = A.ORIG_FACILITY_ID ";

				if(!encounter_id.equals("")){
					stMainSql =stMainSql+" AND A.ENCOUNTER_ID = ?" ;
				}

				if( !req_facility_id.equals(""))
				      stMainSql= stMainSql+" and a.FACILITY_ID = ?";
				if(selTab.equals("S"))
				      stMainSql= stMainSql+" and q.ORD_PRACT_ID=?";
                if(selTab.equals("M"))
                	 // stMainSql= stMainSql+" and 'Y' = CA_PRACT_SPECILITY_YN(a.PRACTITIONER_ID,?,?)";//commmented for 10245
                	stMainSql= stMainSql+" and 'Y' = CA_PRACT_SPECILITY_YN(a.PRACTITIONER_ID,?,a.facility_id)";//added for 10245
				if(!order_type.equals(""))
					stMainSql= stMainSql+" and o.order_type_code=?";

				if (!sql_append.equals(""))
					stMainSql =  stMainSql +  sql_append + " ORDER BY A.START_DATE "+date_by+",A.ORIG_ORDER_ID,A.ORIG_ORDER_LINE_NO";
				else
					stMainSql =  stMainSql+" ORDER BY A.START_DATE "+date_by+"";
			}
			else if(pat_class.equals("")){ 
			if(siteOrder || display_transfer_locn){ 
				ip_patient_order="q.orig_source_code";

				}
				else{
				ip_patient_order="a.locn_code";
				}
			   stMainSql = "SELECT A.ORIG_ORDER_ID, A.ORIG_ORDER_LINE_NO, A.SRL_NO, A.IV_PREP_YN, Q.IV_PREP_YN LINE_IV_PREP_YN, Q.DISCHARGE_IND, O.ORDER_LINE_STATUS, O.CHILD_ORDER_YN, A.INFUSE_OVER, A.TRN_TYPE_IND, A.DRUG_CODE, C.DRUG_DESC, A.DISPENSED_DRUGS, A.ROUTE_CODE, decode(A.IV_PREP_YN,'6',' ',ph_get_desc.ph_route  (a.route_code,b.language_id,'1')) ROUTE_DESC, decode(drug_yn,'N','',DECODE(a.iv_prep_yn, '6',((RTRIM(rtrim(to_char(o.qty_value, '999999990.999999'),'0'),'.'))||' '||am_get_desc.am_uom  (o.qty_unit,b.language_id,'2')|| CHR (13)|| DECODE (a.split_yn, 'Y', '(Divided), ',', ') || h.freq_desc || ', '|| CHR (13)   || DURATION|| ' '|| am_get_desc.am_duration_type  (a.durn_type,b.language_id,'1')),(decode(s.SLIDING_SCALE_YN ,'Y',''/*'Sliding Scale'*/,( RTRIM(rtrim(to_char(a.dosage, '999999990.999999'),'0'),'.') )|| ' '|| am_get_desc.am_uom  (a.dosage_uom_code,b.language_id,'2'))|| CHR (13)|| DECODE (a.split_yn, 'Y', '(Divided), ',', ') || h.freq_desc || ', '|| CHR (13)|| DURATION|| ' '|| am_get_desc.am_duration_type(a.durn_type,b.language_id,'1'))) )DOSAGE_DETAILS, decode(drug_yn,'N','',TO_CHAR (A.START_DATE, 'DD/MM/YYYY HH24:MI')) START_DATE, decode(drug_yn,'N','',TO_CHAR (A.END_DATE, 'DD/MM/YYYY HH24:MI')) END_DATE, decode(p.patient_class,null,'XT',p.patient_class) patient_class, am_get_desc.am_practitioner  (a.pres_practitioner_id,b.language_id,'1') practitioner_name, sm_get_desc.sm_facility_param  (a.orig_facility_id,b.language_id,'1') FACILITY_NAME, DECODE (a.LOCN_TYPE, NULL, am_get_desc.am_referral  (a.locn_code,b.language_id,'2'),'N', ip_get_desc.ip_nursing_unit  (a.orig_facility_id,"+ip_patient_order+",b.language_id,'2'), 'C', op_get_desc.OP_CLINIC  (a.orig_facility_id,a.locn_code,b.language_id,'2') ) LOCATION,(CASE /* SRR20056-SCF-7416 [Incident No. 27457] WHEN Q.CAN_REASON IS NOT NULL  THEN 'HOLD' */ WHEN O.CAN_DATE_TIME IS NOT NULL  THEN 'CANCEL' WHEN O.HOLD_DATE_TIME IS NOT NULL THEN 'HOLD' WHEN O.DISC_DATE_TIME IS NOT NULL THEN 'DIS-CONTINUED' WHEN SYSDATE BETWEEN A.START_DATE AND A.END_DATE AND (NVL (A.TOT_ISSUED_QTY, 0) - NVL (A.RETURNED_QTY, 0)) != 0 THEN 'ACTIVE' ELSE 'INACTIVE' END ) STATUS, (SELECT COUNT (*) FROM OR_ORDER_LINE_FIELD_VALUES  B  WHERE B.ORDER_ID = A.ORIG_ORDER_ID  AND B.ORDER_LINE_NUM = A.ORIG_ORDER_LINE_NO) REMARKS, S.PRES_QTY_UOM PRESCRIBED_UOM, O.LAST_ACTION_REASON_DESC, A.HEIGHT, A.HEIGHT_UOM, A.WEIGHT, A.WEIGHT_UOM, A.BSA, A.BMI, A.PRESCRIBED_QTY, A.TOT_ISSUED_QTY, A.RETURNED_QTY, A.TOT_ADMINISTERED_QTY, A.DOSAGE_UOM_CODE, A.REISSUED_QTY, TO_CHAR (A.REISSUE_DATE_TIME, 'DD/MM/YYYY HH24:MI') REISSUE_DATE_TIME, A.REISSUE_REASON_CODE, O.ORDER_UOM, TO_CHAR (A.RETURN_DATE_TIME, 'DD/MM/YYYY HH24:MI') RETURN_DATE_TIME, (NVL (A.TOT_ISSUED_QTY, 0) - NVL (A.RETURNED_QTY, 0)) RET_DIFF, C.STRENGTH_PER_VALUE_PRES_UOM, C.CONTENT_IN_PRES_BASE_UOM, c.PRES_BASE_UOM, R.SHORT_DESC LINE_STATUS_DESC, s.FORMULARY_ITEM_YN,  s.SLIDING_SCALE_YN, a.SLIDING_SCALE_ADM_UNIT, a.SLIDING_SCALE_ADM_UOM,ph_get_alternates  (A.ORIG_ORDER_ID, A.ORIG_ORDER_LINE_NO) alternates,s.COMPLETE_ORDER_REASON,h.FREQ_NATURE, S.DOSAGE_TYPE dosage_type,S.MFR_YN mfrYN,(SELECT COUNT(*) FROM PH_MEDN_ADMIN WHERE ORDER_ID=A.ORIG_ORDER_ID AND ORDER_LINE_NUM=A.ORIG_ORDER_LINE_NO AND ADMN_DOSE_CHNG_REMARKS IS NOT NULL) ADMIN_DOSE_CHNG_REASON_CNT,O.QTY_UNIT,nvl(a.split_yn,'N') split_dose_yn, A.PRN_REMARKS,K.ROUTE_COLOR,s.AMENDED_BY_ID, s.AMEND_REASON_CODE, s.AMEND_REASON, s.AMENDED_DATE,A.STRENGTH, A.ALT_DRUG_REMARKS, s.VERIFY_REMARKS, s.PREGNANCY_OVERRIDE_REASON, S.ALLOCATE_REMARKS_CODE, s.allocate_task_finding,s.FILL_REMARKS_CODE, s.fill_task_finding,s.DELIVERY_REMARKS_CODE, s.delivery_task_finding, (select count(DISP_NO)  from ph_disp_dtl   where order_id=o.order_id and order_line_no=o.order_line_num) DISPENSE_COUNT,Q.home_leave_medn_yn,Q.REF_SENT_REMARKS, S.DISC_CANCELLED_ORDERS, S.LAST_DISPENSED_DATE,B.GENERIC_NAME,q.ref_sent_pract_id,O.ORDER_QTY";
				if(site){
			    stMainSql = stMainSql+"  ,am_get_desc.am_practitioner  ((SELECT added_by_id FROM ph_patient_drug_profile  WHERE orig_order_id = o.order_id and ORIG_ORDER_LINE_NO=o.ORDER_LINE_NUM AND drug_code = c.drug_code and PRES_PRACTITIONER_ID <> a.added_by_id),b.language_id,'1') ADDED_BY_ID";
			 
				}
				else{
					stMainSql=stMainSql+",A.ADDED_BY_ID";
				}
				
				stMainSql=stMainSql+" FROM PH_PATIENT_DRUG_PROFILE  A, PH_GENERIC_NAME_LANG_VW  B, PH_DRUG_LANG_VW  C, AM_FREQUENCY_LANG_VW  H, OR_ORDER_LINE  O, OR_ORDER  Q,OR_ORDER_STATUS_CODE_LANG_VW  R ,or_order_line_ph  s ,PH_ROUTE  K, PR_ENCOUNTER  P  WHERE Q.ORDER_ID = O.ORDER_ID AND A.PATIENT_ID = ?  AND A.START_DATE BETWEEN TO_DATE ( NVL (?,'01/01/1472 00:01'), 'DD/MM/YYYY HH24:MI')  AND TO_DATE ( NVL (?,'31/12/5000 00:01'), 'DD/MM/YYYY HH24:MI') + 0.99999  AND A.GENERIC_ID BETWEEN NVL (?, '!') AND NVL (?, '~') AND A.DRUG_CODE BETWEEN NVL (?, '!') AND NVL (?, '~') AND A.GENERIC_ID = B.GENERIC_ID AND K.ROUTE_CODE=A.ROUTE_CODE AND A.DRUG_CODE = C.DRUG_CODE AND H.FREQ_CODE = A.FREQ_CODE AND A.ORIG_ORDER_ID = O.ORDER_ID AND A.ORIG_ORDER_LINE_NO = O.ORDER_LINE_NUM AND O.ORDER_LINE_STATUS = R.ORDER_STATUS_CODE and o.order_id=s.order_id and O.ORDER_LINE_NUM=s.ORDER_LINE_NUM AND B.LANGUAGE_ID = C.LANGUAGE_ID AND B.LANGUAGE_ID = H.LANGUAGE_ID AND B.LANGUAGE_ID = R.LANGUAGE_ID AND B.LANGUAGE_ID = ? and c.DRUG_YN ='Y' AND P.ENCOUNTER_ID(+) = A.ENCOUNTER_ID AND P.FACILITY_ID(+) = A.ORIG_FACILITY_ID ";

				if(!encounter_id.equals("")){
					stMainSql =stMainSql+" AND A.ENCOUNTER_ID = ?" ;
				}

				if(!req_facility_id.equals(""))
				      stMainSql= stMainSql+" and a.FACILITY_ID = ?";
				if(selTab.equals("S"))
				      stMainSql= stMainSql+" and q.ORD_PRACT_ID=?";
                if(selTab.equals("M"))
				      //stMainSql= stMainSql+" and 'Y' = CA_PRACT_SPECILITY_YN(q.ORD_PRACT_ID,?,?)";//commented for 10245
                	stMainSql= stMainSql+" and 'Y' = CA_PRACT_SPECILITY_YN(q.ORD_PRACT_ID,?,a.facility_id)";//added for 10245
				if(!order_type.equals(""))
					stMainSql= stMainSql+" and o.order_type_code=?";

				if (!sql_append.equals(""))
					stMainSql=  stMainSql +  sql_append + " ORDER BY A.START_DATE "+date_by+",A.ORIG_ORDER_ID,A.ORIG_ORDER_LINE_NO";
				else
					stMainSql = stMainSql+" ORDER BY A.START_DATE "+date_by+"";
			}
			else {
			stMainSql = "SELECT a.orig_order_id, a.orig_order_line_no, a.srl_no, a.iv_prep_yn, q.iv_prep_yn line_iv_prep_yn, q.discharge_ind, o.order_line_status, o.child_order_yn, a.infuse_over, a.trn_type_ind, a.drug_code, c.drug_desc, a.dispensed_drugs, a.route_code, DECODE (a.iv_prep_yn, '6', ' ', ph_get_desc.ph_route  (a.route_code, b.language_id, '1') ) route_desc, DECODE (drug_yn, 'N', '', DECODE (a.iv_prep_yn, '6', ( (RTRIM (RTRIM (TO_CHAR (o.qty_value, '999999990.999999' ), '0' ), '.' ) ) || ' ' || am_get_desc.am_uom  (o.qty_unit, b.language_id, '2' ) || CHR (13) || DECODE (a.split_yn, 'Y', '(Divided), ', ', ') || h.freq_desc || ', ' || CHR (13) || DURATION || ' ' || am_get_desc.am_duration_type (a.durn_type, b.language_id, '1' ) ), ( DECODE (s.sliding_scale_yn, 'Y', '' /*'Sliding Scale'*/, (RTRIM (RTRIM (TO_CHAR (a.dosage, '999999990.999999' ), '0' ), '.' ) ) || ' ' || am_get_desc.am_uom   (a.dosage_uom_code, b.language_id, '2' ) ) || CHR (13) || DECODE (a.split_yn, 'Y', '(Divided), ', ', ') || h.freq_desc || ', ' || CHR (13) || DURATION || ' ' || am_get_desc.am_duration_type  (a.durn_type, b.language_id, '1' ) ) ) ) dosage_details, DECODE (drug_yn, 'N', '', TO_CHAR (a.start_date, 'DD/MM/YYYY HH24:MI') ) start_date, DECODE (drug_yn, 'N', '', TO_CHAR (a.end_date, 'DD/MM/YYYY HH24:MI') ) end_date, DECODE (p.patient_class, NULL, 'XT', p.patient_class) patient_class, am_get_desc.am_practitioner  (a.pres_practitioner_id, b.language_id, '1' ) practitioner_name, sm_get_desc.sm_facility_param  (a.orig_facility_id, b.language_id, '1' ) facility_name, DECODE (a.locn_type, NULL, am_get_desc.am_referral (a.locn_code, b.language_id, '2' ), 'N', ip_get_desc.ip_nursing_unit  (a.orig_facility_id, a.locn_code, b.language_id, '2' ), 'C', op_get_desc.op_clinic (a.orig_facility_id, a.locn_code, b.language_id, '2' ) ) LOCATION, (CASE /* SRR20056-SCF-7416 [Incident No. 27457] WHEN Q.CAN_REASON IS NOT NULL THEN 'HOLD' */ WHEN o.can_date_time IS NOT NULL THEN 'CANCEL' WHEN o.hold_date_time IS NOT NULL THEN 'HOLD' WHEN o.disc_date_time IS NOT NULL THEN 'DIS-CONTINUED' WHEN SYSDATE BETWEEN a.start_date AND a.end_date AND (NVL (a.tot_issued_qty, 0) - NVL (a.returned_qty, 0)) != 0 THEN 'ACTIVE' ELSE 'INACTIVE' END ) status, (SELECT COUNT (*) FROM or_order_line_field_values  b WHERE b.order_id = a.orig_order_id AND b.order_line_num = a.orig_order_line_no) remarks, s.pres_qty_uom prescribed_uom, o.last_action_reason_desc, a.height, a.height_uom, a.weight, a.weight_uom, a.bsa, a.bmi, a.prescribed_qty, a.tot_issued_qty, a.returned_qty, a.tot_administered_qty, a.dosage_uom_code, a.reissued_qty, TO_CHAR (a.reissue_date_time, 'DD/MM/YYYY HH24:MI') reissue_date_time, a.reissue_reason_code, o.order_uom, TO_CHAR (a.return_date_time, 'DD/MM/YYYY HH24:MI') return_date_time, (NVL (a.tot_issued_qty, 0) - NVL (a.returned_qty, 0)) ret_diff, c.strength_per_value_pres_uom, c.content_in_pres_base_uom, c.pres_base_uom, r.short_desc line_status_desc, s.formulary_item_yn, s.sliding_scale_yn, a.sliding_scale_adm_unit, a.sliding_scale_adm_uom, ph_get_alternates  (a.orig_order_id, a.orig_order_line_no) alternates, s.complete_order_reason, h.freq_nature, s.dosage_type dosage_type, s.mfr_yn mfryn, (SELECT COUNT (*) FROM ph_medn_admin  WHERE order_id = a.orig_order_id AND order_line_num = a.orig_order_line_no AND admn_dose_chng_remarks IS NOT NULL) admin_dose_chng_reason_cnt, o.qty_unit, NVL (a.split_yn, 'N') split_dose_yn, a.prn_remarks, k.route_color, s.amended_by_id, s.amend_reason_code, s.amend_reason, s.amended_date, a.strength, a.alt_drug_remarks, s.verify_remarks, s.pregnancy_override_reason, s.allocate_remarks_code, s.allocate_task_finding, s.fill_remarks_code, s.fill_task_finding, s.delivery_remarks_code, s.delivery_task_finding, (SELECT COUNT (disp_no) FROM ph_disp_dtl  WHERE order_id = o.order_id AND order_line_no = o.order_line_num) dispense_count, q.home_leave_medn_yn, q.ref_sent_remarks, s.disc_cancelled_orders, s.last_dispensed_date, b.generic_name, q.ref_sent_pract_id ,O.ORDER_QTY";
			
			if(site){
			    stMainSql = stMainSql+"  ,am_get_desc.am_practitioner  ((SELECT added_by_id FROM ph_patient_drug_profile  WHERE orig_order_id = o.order_id  and ORIG_ORDER_LINE_NO=o.ORDER_LINE_NUM AND drug_code = c.drug_code and PRES_PRACTITIONER_ID <> a.added_by_id),b.language_id,'1') ADDED_BY_ID";
				
			}
				else{
					stMainSql=stMainSql+",A.ADDED_BY_ID";
				}
			
			stMainSql=stMainSql+" FROM ph_patient_drug_profile  a, ph_generic_name_lang_vw  b, ph_drug_lang_vw  c, am_frequency_lang_vw  h, or_order_line  o, or_order  q, or_order_status_code_lang_vw  r, or_order_line_ph  s, ph_route  k, pr_encounter  p WHERE q.order_id = o.order_id AND a.patient_id = ? AND p.patient_class = ? AND A.START_DATE BETWEEN TO_DATE ( NVL (?,'01/01/1472 00:01'), 'DD/MM/YYYY HH24:MI')  AND TO_DATE ( NVL (?,'31/12/5000 00:01'), 'DD/MM/YYYY HH24:MI') + 0.99999  AND a.generic_id BETWEEN NVL (?, '!') AND NVL (?, '~') AND a.drug_code BETWEEN NVL (?, '!') AND NVL (?, '~') AND a.generic_id = b.generic_id AND a.drug_code = c.drug_code AND h.freq_code = a.freq_code AND a.orig_order_id = o.order_id AND a.orig_order_line_no = o.order_line_num AND o.order_line_status = r.order_status_code AND k.route_code = a.route_code AND o.order_id = s.order_id AND o.order_line_num = s.order_line_num AND b.language_id = c.language_id AND b.language_id = h.language_id AND b.language_id = r.language_id AND b.language_id = ? AND c.drug_yn = 'Y' AND p.encounter_id(+) = a.encounter_id AND p.facility_id(+) = a.orig_facility_id /*AND SYSDATE BETWEEN a.start_date AND a.end_date*/ AND a.cancel_yn = 'N' AND a.stop_yn = 'N' AND a.on_hold_date_time IS NULL AND a.discont_date_time IS NULL AND (NVL (a.tot_issued_qty, 0) - NVL (a.returned_qty, 0)) >= 0  ";
			

			if(!encounter_id.equals("")){
				    stMainSql =stMainSql+" AND A.ENCOUNTER_ID = ?" ;
			  }
				if(!req_facility_id.equals(""))
				      stMainSql= stMainSql+" and a.FACILITY_ID = ?";
				if(selTab.equals("S"))
				      stMainSql= stMainSql+" and q.ORD_PRACT_ID=?";
                if(selTab.equals("M"))
				     // stMainSql= stMainSql+" and 'Y' = CA_PRACT_SPECILITY_YN(a.PRACTITIONER_ID,?,?)";//commmented for 10245
                	stMainSql= stMainSql+" and 'Y' = CA_PRACT_SPECILITY_YN(a.PRACTITIONER_ID,?,a.facility_id)";//added for 10245
				if(!order_type.equals(""))
					stMainSql= stMainSql+" and o.order_type_code=?";


			if (!sql_append.equals(""))
					stMainSql = stMainSql +  sql_append + " ORDER BY A.START_DATE "+date_by+",A.ORIG_ORDER_ID,A.ORIG_ORDER_LINE_NO";
				else
					stMainSql = stMainSql+" ORDER BY A.START_DATE "+date_by+"";
			}

 try{
	 
				 pStatment = con.prepareStatement(stMainSql.toString());
				 pStatment.setString(i++, patient_id);
				 if(!pat_class.equals(""))
                   pStatment.setString(i++, pat_class);
				 pStatment.setString(i++, from_date);
				 pStatment.setString(i++, to_date);
				 pStatment.setString(i++, generic_id);
				 pStatment.setString(i++, generic_id);
				 pStatment.setString(i++, drug_id);
				 pStatment.setString(i++, drug_id);
				 pStatment.setString(i++, locale);
				
				 if(!encounter_id.equals(""))
					 pStatment.setString(i++, encounter_id);
				 if(!req_facility_id.equals(""))
				 pStatment.setString(i++, req_facility_id);
				 
				 if(selTab.equals("M")){
					 pStatment.setString(i++, pract_id);
					// pStatment.setString(i++, req_facility_id);//commented for 10245
				 }
				 
				 if(selTab.equals("S")){
					 
					  pStatment.setString(i++, pract_id);
				 }
				 
				 if(!order_type.equals(""))
					 pStatment.setString(i++, order_type);
				
				
			 resultSet = pStatment.executeQuery(); 
			 //int j=0;//Common-ICN-0092  
			 if ( resultSet != null )
			 {
					while(resultSet.next() )
					//for(int j =0;j<resultSet.size();j+=85)
					{
						recordDetails =new ArrayList();
						recordDetails.add(resultSet.getString("IV_PREP_YN")==null?"":resultSet.getString("IV_PREP_YN"));  //0
						recordDetails.add(resultSet.getString("INFUSE_OVER")==null?"":resultSet.getString("INFUSE_OVER")); //1
						recordDetails.add(resultSet.getString("TRN_TYPE_IND")==null?"":resultSet.getString("TRN_TYPE_IND")); //2
						recordDetails.add(resultSet.getString("STATUS")==null?"":resultSet.getString("STATUS")); //3
						recordDetails.add(resultSet.getString("DRUG_CODE")==null?"":resultSet.getString("DRUG_CODE")); //4
						recordDetails.add(resultSet.getString("DRUG_DESC")==null?"":resultSet.getString("DRUG_DESC"));//5
						recordDetails.add(resultSet.getString("ROUTE_CODE")==null?"":resultSet.getString("ROUTE_CODE")); //6
						recordDetails.add(resultSet.getString("ROUTE_DESC")==null?"":resultSet.getString("ROUTE_DESC")); //7
						recordDetails.add(resultSet.getString("DOSAGE_DETAILS")==null?"":resultSet.getString("DOSAGE_DETAILS")); //8
						recordDetails.add(resultSet.getString("START_DATE")==null?"":resultSet.getString("START_DATE")); //9
						recordDetails.add(resultSet.getString("END_DATE")==null?"":resultSet.getString("END_DATE"));  //10
						recordDetails.add(resultSet.getString("PATIENT_CLASS")==null?"":resultSet.getString("PATIENT_CLASS"));
						recordDetails.add(resultSet.getString("PRACTITIONER_NAME")==null?"":resultSet.getString("PRACTITIONER_NAME"));
						recordDetails.add(resultSet.getString("LOCATION")==null?"":resultSet.getString("LOCATION"));
						recordDetails.add(resultSet.getString("FACILITY_NAME")==null?"":resultSet.getString("FACILITY_NAME"));
						recordDetails.add(resultSet.getString("ORIG_ORDER_ID")==null?"":resultSet.getString("ORIG_ORDER_ID"));//15
						recordDetails.add(resultSet.getString("ORIG_ORDER_LINE_NO")==null?"":resultSet.getString("ORIG_ORDER_LINE_NO"));
						recordDetails.add(resultSet.getString("SRL_NO")==null?"":resultSet.getString("SRL_NO"));
						recordDetails.add(resultSet.getString("REMARKS")==null?"":resultSet.getString("REMARKS"));
						recordDetails.add(resultSet.getString("HEIGHT")==null?"":resultSet.getString("HEIGHT"));
						recordDetails.add(resultSet.getString("HEIGHT_UOM")==null?"":resultSet.getString("HEIGHT_UOM"));   //20
						recordDetails.add(resultSet.getString("WEIGHT")==null?"":resultSet.getString("WEIGHT"));
						recordDetails.add(resultSet.getString("WEIGHT_UOM")==null?"":resultSet.getString("WEIGHT_UOM"));
						recordDetails.add(resultSet.getString("BSA")==null?"":resultSet.getString("BSA"));
						recordDetails.add(resultSet.getString("LINE_IV_PREP_YN")==null?"":resultSet.getString("LINE_IV_PREP_YN"));
						recordDetails.add(resultSet.getString("DISCHARGE_IND")==null?"":resultSet.getString("DISCHARGE_IND"));   //25
						recordDetails.add(resultSet.getString("LAST_ACTION_REASON_DESC")==null?"":resultSet.getString("LAST_ACTION_REASON_DESC"));
						recordDetails.add(resultSet.getString("PRESCRIBED_QTY")==null?"":resultSet.getString("PRESCRIBED_QTY"));
						recordDetails.add(resultSet.getString("TOT_ISSUED_QTY")==null?"":resultSet.getString("TOT_ISSUED_QTY"));
						recordDetails.add(resultSet.getString("RETURNED_QTY")==null?"":resultSet.getString("RETURNED_QTY"));
						recordDetails.add(resultSet.getString("RETURN_DATE_TIME")==null?"":resultSet.getString("RETURN_DATE_TIME"));  //30
						recordDetails.add(resultSet.getString("ORDER_UOM")==null?"":resultSet.getString("ORDER_UOM"));
						recordDetails.add(resultSet.getString("DISPENSED_DRUGS")==null?"":resultSet.getString("DISPENSED_DRUGS"));
						recordDetails.add(resultSet.getString("TOT_ADMINISTERED_QTY")==null?"":resultSet.getString("TOT_ADMINISTERED_QTY"));
						recordDetails.add(resultSet.getString("RET_DIFF")==null?"":resultSet.getString("RET_DIFF"));
						recordDetails.add(resultSet.getString("ORDER_LINE_STATUS")==null?"":resultSet.getString("ORDER_LINE_STATUS"));  //35
						recordDetails.add(resultSet.getString("CHILD_ORDER_YN")==null?"":resultSet.getString("CHILD_ORDER_YN"));
						recordDetails.add(resultSet.getString("DOSAGE_UOM_CODE")==null?"":resultSet.getString("DOSAGE_UOM_CODE"));
						recordDetails.add(resultSet.getString("BMI")==null?"":resultSet.getString("BMI"));
						recordDetails.add(resultSet.getString("REISSUED_QTY")==null?"":resultSet.getString("REISSUED_QTY"));
						recordDetails.add(resultSet.getString("PRESCRIBED_UOM")==null?"":resultSet.getString("PRESCRIBED_UOM"));  //40
						recordDetails.add(resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM")==null?"":resultSet.getString("STRENGTH_PER_VALUE_PRES_UOM"));
						recordDetails.add(resultSet.getString("CONTENT_IN_PRES_BASE_UOM")==null?"":resultSet.getString("CONTENT_IN_PRES_BASE_UOM"));
						recordDetails.add(resultSet.getString("REISSUE_DATE_TIME")==null?"":resultSet.getString("REISSUE_DATE_TIME"));
						recordDetails.add(resultSet.getString("LINE_STATUS_DESC")==null?"":resultSet.getString("LINE_STATUS_DESC"));
						recordDetails.add(resultSet.getString("FORMULARY_ITEM_YN")==null?"":resultSet.getString("FORMULARY_ITEM_YN")); 
						recordDetails.add(resultSet.getString("SLIDING_SCALE_YN")==null?"":resultSet.getString("SLIDING_SCALE_YN")); //46
						recordDetails.add(resultSet.getString("SLIDING_SCALE_ADM_UNIT")==null?"":resultSet.getString("SLIDING_SCALE_ADM_UNIT")); 
						recordDetails.add(resultSet.getString("SLIDING_SCALE_ADM_UOM")==null?"":resultSet.getString("SLIDING_SCALE_ADM_UOM")); 
						recordDetails.add(resultSet.getString("alternates")==null?"":resultSet.getString("alternates")); 
						recordDetails.add(resultSet.getString("COMPLETE_ORDER_REASON")==null?"":resultSet.getString("COMPLETE_ORDER_REASON")); //50
						recordDetails.add(resultSet.getString("FREQ_NATURE")==null?"":resultSet.getString("FREQ_NATURE"));
						recordDetails.add(resultSet.getString("dosage_type")==null?"":resultSet.getString("dosage_type"));
						recordDetails.add(resultSet.getString("ADMIN_DOSE_CHNG_REASON_CNT")==null?"":resultSet.getString("ADMIN_DOSE_CHNG_REASON_CNT")); //53
						recordDetails.add(resultSet.getString("QTY_UNIT")==null?"":resultSet.getString("QTY_UNIT")); //54
						recordDetails.add(resultSet.getString("mfrYN")==null?"":resultSet.getString("mfrYN")); //55
						recordDetails.add(resultSet.getString("split_dose_yn")==null?"":resultSet.getString("split_dose_yn")); //56
						recordDetails.add(resultSet.getString("PRN_REMARKS")==null?"":resultSet.getString("PRN_REMARKS")); //57
						recordDetails.add(resultSet.getString("ROUTE_COLOR")==null?"":resultSet.getString("ROUTE_COLOR")); //58 // Code Added For CRF - 0034	
						
						recordDetails.add(resultSet.getString("AMENDED_BY_ID")==null?"":resultSet.getString("AMENDED_BY_ID"));	//below code Added for ML-BRU-SCF-0098 [IN031837] -- Start
						recordDetails.add(resultSet.getString("AMEND_REASON")==null?"":resultSet.getString("AMEND_REASON")); //60 
						recordDetails.add(resultSet.getString("AMEND_REASON_CODE")==null?"":resultSet.getString("AMEND_REASON_CODE"));  
						recordDetails.add(resultSet.getString("AMENDED_DATE")==null?"":resultSet.getString("AMENDED_DATE"));	//Above code Added for ML-BRU-SCF-0098 [IN031837] -- End
						recordDetails.add(resultSet.getString("STRENGTH")==null?"":resultSet.getString("STRENGTH"));
						recordDetails.add(resultSet.getString("ALT_DRUG_REMARKS")==null?"":resultSet.getString("ALT_DRUG_REMARKS")); //Added for Bru-HIMS-CRF-082 [IN:029948]
						recordDetails.add(resultSet.getString("PREGNANCY_OVERRIDE_REASON")==null?"":resultSet.getString("PREGNANCY_OVERRIDE_REASON")); //Added for RUT-CRF-0063 [IN:029601] //65
						recordDetails.add(resultSet.getString("ALLOCATE_REMARKS_CODE")==null?"":resultSet.getString("ALLOCATE_REMARKS_CODE"));//code added for ML-BRU-SCF-0971[IN042220] --Start 
						recordDetails.add(resultSet.getString("ALLOCATE_TASK_FINDING")==null?"":resultSet.getString("ALLOCATE_TASK_FINDING"));
						recordDetails.add(resultSet.getString("FILL_REMARKS_CODE")==null?"":resultSet.getString("FILL_REMARKS_CODE")); 
						recordDetails.add(resultSet.getString("FILL_TASK_FINDING")==null?"":resultSet.getString("FILL_TASK_FINDING")); 
						recordDetails.add(resultSet.getString("DELIVERY_REMARKS_CODE")==null?"":resultSet.getString("DELIVERY_REMARKS_CODE"));
						recordDetails.add(resultSet.getString("DELIVERY_TASK_FINDING")==null?"":resultSet.getString("DELIVERY_TASK_FINDING"));//code added for ML-BRU-SCF-0971[IN042220] --End
						recordDetails.add(resultSet.getString("DISPENSE_COUNT")==null?"":resultSet.getString("DISPENSE_COUNT"));//code added for  ML-BRU-SCF-1116 [IN:044786] //72
						recordDetails.add(resultSet.getString("PRES_BASE_UOM")==null?"":resultSet.getString("PRES_BASE_UOM"));//code added for  ML-BRU-SCF-1190 [IN:045647] //73
						recordDetails.add(resultSet.getString("home_leave_medn_yn")==null?"":resultSet.getString("home_leave_medn_yn"));//Added for Bru-HIMS-CRF-093-DD1[IN047223]
						recordDetails.add(resultSet.getString("REF_SENT_REMARKS")==null?"":resultSet.getString("REF_SENT_REMARKS"));//Added for HSA-CRF-0155 [IN048487]
						recordDetails.add(resultSet.getString("DISC_CANCELLED_ORDERS")==null?"":resultSet.getString("DISC_CANCELLED_ORDERS"));//Added for HSA-CRF-0138 [IN:048414] //76
						recordDetails.add(resultSet.getString("LAST_DISPENSED_DATE")==null?"":resultSet.getString("LAST_DISPENSED_DATE"));//Added for HSA-CRF-0138 [IN:048414] //77
						recordDetails.add(resultSet.getString("VERIFY_REMARKS")==null?"":resultSet.getString("VERIFY_REMARKS"));//Added for ML-MMOH-SCF-0327 [IN:058772] //78
						recordDetails.add(resultSet.getString("GENERIC_NAME")==null?"":resultSet.getString("GENERIC_NAME"));//ADDED GENERIC_NAME for AAKH-CRF-0088 [IN:060357]
						 recordDetails.add(resultSet.getString("REF_SENT_PRACT_ID")==null?"":resultSet.getString("REF_SENT_PRACT_ID"));//added ADDED_BY_ID  for ml-mmoh-crf-0510 [IN060510] 
						 recordDetails.add(resultSet.getString("ADDED_BY_ID")==null?"":resultSet.getString("ADDED_BY_ID"));//added ADDED_BY_ID  for ml-mmoh-crf-0510 [IN060510] 
						recordDetails.add(resultSet.getString("ORDER_QTY")==null?"":resultSet.getString("ORDER_QTY"));//82//Added for ARYU-SCF-0034
						//System.err.println("recordDetails@@@===="+recordDetails);
						drugDetails.add(recordDetails);
						//System.err.println("drugDetails@@===="+drugDetails);
						
					}
				}

				   
			}
			
			catch(Exception e){
				e.printStackTrace();
			}
			finally{
				if(resultSet != null) resultSet.close();
				if(pStatment != null) pStatment.close();
			}
			//System.err.println("drugDetails @@@==========="+recordDetails);
        return drugDetails;
}

 public ArrayList getExternalDrugResults(String locale,String patient_id,String encounter_id,String pract_id,String from_date,String to_date,String selTab,String pat_class,String req_facility_id,String status,String drug_id,String generic_id,String date_order) throws Exception {

	    String sql= "";
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		ArrayList extDrugResults	=	new ArrayList() ;
		ArrayList RecordList    = new ArrayList();
	  //String temp_start_date  = "";// Common-ICN-0092  

		try{
			

			connection			= getConnection() ;

			sql =  "SELECT A.DRUG_CODE,A.DRUG_DESC,TO_CHAR(A.START_DATE,'DD/MM/YYYY HH24:MI') START_DATE,TO_CHAR(A.END_DATE,'DD/MM/YYYY HH24:MI') END_DATE,A.PRACTITIONER_NAME,A.INSTRUCTIONS,(SELECT GENERIC_NAME FROM PH_DRUG_VW  WHERE DRUG_CODE=A.DRUG_CODE) GENERIC_NAME,AM_GET_DESC.AM_PRACTITIONER  (A.ADDED_BY_ID,?,'1')ADDED,A.ADDED_BY_ID,A.PRACTITIONER_ID,A.ACCESSION_NUM,A.SRL_NO,A.QTY_VALUE,A.QTY_DESC,(SELECT ROUTE_DESC FROM PH_DRUG_VW  WHERE DRUG_CODE = A.DRUG_CODE) ROUTE_DESC, (SELECT FREQ_DESC FROM AM_FREQUENCY WHERE FREQ_CODE = A.FREQUENCY)FREQ_DESC,(SELECT FREQ_NATURE FROM AM_FREQUENCY WHERE FREQ_CODE = A.FREQUENCY) FREQ_NATURE FROM PH_PATIENT_EXT_DRUG_PROFILE  A WHERE A.PATIENT_ID  = ? AND A.START_DATE BETWEEN NVL (TO_DATE (?, 'DD/MM/YYYY HH24:MI'), SYSDATE - 30)  AND NVL (TO_DATE (?, 'DD/MM/YYYY HH24:MI'), SYSDATE + 30)";
			
			
			/*	if(!encounter_id.equals("")){
						sql =sql+" AND A.ENCOUNTER_ID = ?" ;
				  }*/
				if(!req_facility_id.equals(""))
				      sql= sql+" AND A.FACILITY_ID = ?";
				if(selTab.equals("S"))
				      sql= sql+" AND A.PRACTITIONER_ID=NVL(?,A.PRACTITIONER_ID)";
                if(selTab.equals("M"))
				      //sql= sql+" AND 'Y' = CA_PRACT_SPECILITY_YN(a.PRACTITIONER_ID,?,?)";//commented for 10245
                	sql= sql+" AND 'Y' = CA_PRACT_SPECILITY_YN(a.PRACTITIONER_ID,?,a.facility_id)";//added for 10245
				
				if(!drug_id.equals(""))
					sql= sql+" AND A.DRUG_CODE=?";
				if(date_order.equals("D"))
			       sql  = sql + " ORDER BY A.START_DATE DESC";
		        else
			        sql  = sql +" ORDER BY A.START_DATE ASC";

				//System.err.println("sql for Ext drugs result@@==="+sql);

				pstmt				= connection.prepareStatement(sql) ; 
				//System.err.println("locale@@==="+locale+"patient_id==="+patient_id+"from_date==="+from_date+"to_date=="+to_date+"encounter_id==="+encounter_id+"req_facility_id=="+req_facility_id+"pract_id==="+pract_id+"selTab==="+selTab+"drug_id==="+drug_id);
				int i=1;

			pstmt.setString(i++,locale); 
			pstmt.setString(i++,patient_id); 
			//System.err.println("from_date==="+from_date);
			pstmt.setString(i++, from_date);
			//System.err.println("to_date==="+to_date);
			pstmt.setString(i++, to_date);
			/*if(!encounter_id.equals(""))
			pstmt.setString(i++,encounter_id);*/
			if(!req_facility_id.equals(""))
			pstmt.setString(i++,req_facility_id); 
			if(selTab.equals("S"))
			pstmt.setString(i++,pract_id); 
			if(selTab.equals("M")){
			pstmt.setString(i++,pract_id); 
			//pstmt.setString(i++, req_facility_id);//commmented  for 10245
			}
			if(!drug_id.equals(""))
			pstmt.setString(i++, drug_id);
			
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next()) {	

				RecordList = new ArrayList();
				RecordList.add(checkForNull(resultSet.getString("DRUG_CODE"))); //0
				RecordList.add(checkForNull(resultSet.getString("DRUG_DESC"))); //1
				RecordList.add(checkForNull(resultSet.getString("START_DATE"))); //2
				RecordList.add(checkForNull(resultSet.getString("END_DATE"))); //3
				RecordList.add(checkForNull(resultSet.getString("PRACTITIONER_NAME"))); //4
				RecordList.add(checkForNull(resultSet.getString("INSTRUCTIONS"))); //5
				RecordList.add(checkForNull(resultSet.getString("GENERIC_NAME"))); //6
				RecordList.add(checkForNull(resultSet.getString("ADDED"))); //7
				RecordList.add(checkForNull(resultSet.getString("ADDED_BY_ID"))); //8
				RecordList.add(checkForNull(resultSet.getString("PRACTITIONER_ID"))); //9
				RecordList.add(checkForNull(resultSet.getString("ACCESSION_NUM"))); //10
				RecordList.add(checkForNull(resultSet.getString("SRL_NO"))); //11
				RecordList.add(checkForNull(resultSet.getString("QTY_VALUE"))); //12
				RecordList.add(checkForNull(resultSet.getString("QTY_DESC"))); //13
				RecordList.add(checkForNull(resultSet.getString("ROUTE_DESC"))); //14
				RecordList.add(checkForNull(resultSet.getString("FREQ_DESC")));//15
				RecordList.add(checkForNull(resultSet.getString("FREQ_NATURE")));//16

				extDrugResults.add(RecordList);
				
			}
		 
		}
		catch(Exception e){
			e.printStackTrace();
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
		return extDrugResults;	

 }

public String getUomDisplay(String facility_id, String uom_code) {

		String uomDisplay = uom_code;
		Connection connection = null ;
		//CallableStatement callableStatement =  null;		
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection		= getConnection() ;
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select PH_GET_UOM_DISPLAY('"+facility_id+"','"+uom_code+"','"+language_id+"') UOM_DISPLAY from dual");

			if(resultSet!=null && resultSet.next())
			{
				uomDisplay = resultSet.getString("UOM_DISPLAY");
			}

			
		}catch ( Exception e ) {
			e.printStackTrace() ;
			uomDisplay = uom_code;
		}
		finally {
			try{
				closeResultSet( resultSet );
				//closeStatement( callableStatement ) ;
				closeStatement( statement ) ;
				closeConnection( connection ); 
			}catch(Exception es ){
				es.printStackTrace() ;
			}
		}
		return uomDisplay==null?"":uomDisplay;
	}

	public ArrayList getAllLocations(String order_id, String order_line_no){

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		ArrayList all_locations	=	new ArrayList() ;

		try{
			int noOfDecimals = getNoOfDecimals();
			String decimalStringFormat = "#.";
			if(noOfDecimals == 0)
				 decimalStringFormat = "#";
			for (int i=0;i<noOfDecimals;i++){
				decimalStringFormat += "#";
			}
			DecimalFormat dfToInteger = new DecimalFormat(decimalStringFormat);	
			String alt_drug_remarks = "";
			String disp_qty = "", disp_date;

			connection			= getConnection() ;
			//pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_SELECT13") ) ;
			//pstmt				= connection.prepareStatement("SELECT X.DISP_LOCN_CODE,B.SHORT_DESC DISP_DESC, A.DISP_QTY disp_qty ,E.SHORT_DESC DISP_QTY_uom, TO_CHAR(A.ADDED_DATE,'DD/MM/YYYY HH24:MI') DISPENSED_DATE, d.drug_desc DISPENSED_DRUG_DESC FROM PH_DISP_HDR X, PH_DISP_DTL A, PH_DISP_LOCN_LANG_VW B, (SELECT drug_code drug_code,drug_desc drug_desc FROM ph_drug_lang_vw  WHERE language_id=? UNION SELECT TPN_REGIMEN_CODE  DRUG_CODE, LONG_NAME DRUG_DESC FROM  ph_tpn_regimen_lang_vw WHERE language_id=?) d, AM_UOM E WHERE X.ORDER_ID=? AND x.FACILITY_ID = a.FACILITY_ID AND x.DISP_NO = a.DISP_NO AND a.ORDER_LINE_NO= NVL(?,a.ORDER_LINE_NO) AND D.DRUG_CODE = A.DISP_DRUG_CODE AND E.UOM_CODE = A.DISP_UOM_CODE AND B.FACILITY_ID = X.FACILITY_ID AND B.DISP_LOCN_CODE = X.DISP_LOCN_CODE AND B.LANGUAGE_ID = ? ") ; Commented By sandhya
			//Modified Query for getting UOM value as thai(AM_UOM_LANG_VW) regarding incident num:24563 on 22/Nov/2010==By sandhya
			pstmt				= connection.prepareStatement("SELECT X.DISP_LOCN_CODE,B.SHORT_DESC DISP_DESC, A.DISP_QTY disp_qty ,E.SHORT_DESC DISP_QTY_uom, TO_CHAR(A.ADDED_DATE,'DD/MM/YYYY HH24:MI') DISPENSED_DATE, d.drug_desc DISPENSED_DRUG_DESC, aplusr.APPL_USER_NAME DISPENSED_BY,a.alt_drug_remarks, 'D' STATUS, A.ALLOCATE_REMARKS_CODE, A.allocate_task_finding, A.FILL_REMARKS_CODE, A.fill_task_finding, A.DELIVERY_REMARKS_CODE, A.delivery_task_finding, a.added_date FROM PH_DISP_HDR X, PH_DISP_DTL A, PH_DISP_LOCN_LANG_VW B,(SELECT drug_code drug_code,drug_desc drug_desc FROM ph_drug_lang_vw  WHERE language_id=? UNION SELECT TPN_REGIMEN_CODE  DRUG_CODE, LONG_NAME DRUG_DESC FROM  ph_tpn_regimen_lang_vw WHERE language_id=?) d, AM_UOM_LANG_VW E, sm_appl_user_lang_vw aplusr WHERE X.ORDER_ID=? AND x.FACILITY_ID = a.FACILITY_ID AND x.DISP_NO = a.DISP_NO AND a.ORDER_LINE_NO= NVL(?,a.ORDER_LINE_NO) AND D.DRUG_CODE = A.DISP_DRUG_CODE AND E.UOM_CODE = A.DISP_UOM_CODE AND B.FACILITY_ID = X.FACILITY_ID AND B.DISP_LOCN_CODE = X.DISP_LOCN_CODE AND aplusr.APPL_USER_ID = X.DISPENSED_BY AND B.LANGUAGE_ID = ? AND E.LANGUAGE_ID = ? and aplusr.language_id = b.language_id  UNION ALL SELECT   x.DISP_LOCN_CODE, b.short_desc disp_desc, a.DISP_QTY disp_qty, e.short_desc disp_qty_uom, TO_CHAR (a.added_date, 'DD/MM/YYYY HH24:MI') dispensed_date, d.drug_desc dispensed_drug_desc, aplusr.appl_user_name dispensed_by, a.alt_drug_remarks, 'A' STATUS, A.ALLOCATE_REMARKS_CODE, A.allocate_task_finding, A.FILL_REMARKS_CODE, A.fill_task_finding, A.DELIVERY_REMARKS_CODE, A.delivery_task_finding, a.added_date FROM ph_disp_hdr_tmp x, ph_disp_dtl_tmp a, ph_disp_locn_lang_vw b, (SELECT drug_code drug_code,drug_desc drug_desc FROM ph_drug_lang_vw  WHERE language_id=? UNION SELECT TPN_REGIMEN_CODE  DRUG_CODE, LONG_NAME DRUG_DESC FROM  ph_tpn_regimen_lang_vw WHERE language_id=?) d, AM_UOM_LANG_VW E, sm_appl_user_lang_vw aplusr WHERE X.ORDER_ID=? AND x.FACILITY_ID = a.FACILITY_ID AND x.DISP_TMP_NO = a.DISP_TMP_NO AND a.ORDER_LINE_NO= NVL(?,a.ORDER_LINE_NO) AND D.DRUG_CODE = A.DISP_DRUG_CODE AND E.UOM_CODE = A.DISP_UOM_CODE AND B.FACILITY_ID = X.FACILITY_ID AND B.DISP_LOCN_CODE = X.DISP_LOCN_CODE AND aplusr.APPL_USER_ID = X.DISPENSED_BY AND B.LANGUAGE_ID = ? AND E.LANGUAGE_ID = ? and aplusr.language_id = b.language_id ORDER BY  added_date DESC") ; //Added  order by for getting dispensed date in sorting order===regdng inc==26216==By shaympriya==01/FEB/2011 // sm_appl_user_lang_vw joined to get DISPENSED_BY for ML-BRU-SCF-0430 INC[035169]

			pstmt.setString(1,getLanguageId()); 
			pstmt.setString(2,getLanguageId()); 
			pstmt.setString(3, order_id);
			pstmt.setString(4, order_line_no);
			pstmt.setString(5,getLanguageId()); 
			pstmt.setString(6,getLanguageId()); 
			pstmt.setString(7,getLanguageId()); 
			pstmt.setString(8,getLanguageId()); 
			pstmt.setString(9, order_id);
			pstmt.setString(10, order_line_no);
			pstmt.setString(11,getLanguageId()); 
			pstmt.setString(12,getLanguageId()); 
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next()) {	
				disp_date = checkForNull(resultSet.getString("DISPENSED_DATE"));
				all_locations.add(disp_date); //0
				all_locations.add(checkForNull(resultSet.getString("DISPENSED_DRUG_DESC")));
				all_locations.add(checkForNull(resultSet.getString("DISP_DESC")));
				disp_qty =(dfToInteger.format(Double.parseDouble(resultSet.getString("DISP_QTY")))+"")+" "+resultSet.getString("DISP_QTY_uom");
				all_locations.add(disp_qty); //3
				all_locations.add(checkForNull(resultSet.getString("DISPENSED_BY"))); // Added for  ML-BRU-SCF-0430 INC[035169]
				all_locations.add(checkForNull(resultSet.getString("STATUS")));//added for  Bru-HIMS-CRF-082 [IN:029948]
				alt_drug_remarks = checkForNull(resultSet.getString("ALT_DRUG_REMARKS"));
				if(!alt_drug_remarks.equals(""))
					setAltDrugRemarks(order_id+"~"+order_line_no+"~"+disp_date, alt_drug_remarks);
				all_locations.add(alt_drug_remarks); //6 //added for  Bru-HIMS-CRF-082 [IN:029948]
				all_locations.add(checkForNull(resultSet.getString("ALLOCATE_REMARKS_CODE"))); //7 //added for ML-BRU-SCF-0971[IN042220] -Start
				all_locations.add(checkForNull(resultSet.getString("ALLOCATE_TASK_FINDING"))); //8
				all_locations.add(checkForNull(resultSet.getString("FILL_REMARKS_CODE")));  //9
				all_locations.add(checkForNull(resultSet.getString("FILL_TASK_FINDING"))); //10
				all_locations.add(checkForNull(resultSet.getString("DELIVERY_REMARKS_CODE"))); //11
				all_locations.add(checkForNull(resultSet.getString("DELIVERY_TASK_FINDING")));//added for ML-BRU-SCF-0971[IN042220] //12
			}					
		}
		catch(Exception e){
			e.printStackTrace();
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
		return all_locations;	
	}

	public String getPatientIDLength(){

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	pat_txt_length	=	null ;

		try{
			connection			= getConnection() ;
			//pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_COMMON_SELECT1") ) ;
			resultSet	= pstmt.executeQuery(); 
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
			}catch(Exception es){es.printStackTrace();
			}
		}
		return pat_txt_length;	
	}

	public ArrayList getPatientClass(){

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		ArrayList	records		=	new ArrayList();

		try{
			connection			= getConnection() ;
			//pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_SELECT1") ) ;
			pstmt.setString(1,getLanguageId()); 
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
					records.add(resultSet.getString("PATIENT_CLASS"));
					records.add(resultSet.getString("SHORT_DESC"));
			}						
		}catch(Exception e){
				records.add(e.toString());
		} 
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return records;	
	}

	// This method is used to remove the records if  IV_PREP_YN = 'Y' and INFUSE_OVER is NULL

	public ArrayList getAllDisplayedRecords(ArrayList result){
		for (int i=2;i<result.size(); i++ ){
			ArrayList actual_record	= (ArrayList)result.get(i);
			String IV_prep_yn   = (String)actual_record.get(0);
			if(actual_record.size() >0){
				Object second		= actual_record.get(1);
				if (IV_prep_yn.equals("Y")&& second==null){
					result.remove(i);
					i=i-1;
				}
			}
		}	
		return result;
	}	
	public ArrayList getPresRemarks(String orig_order_id,String orig_order_line_no,String ReqDb,String encounter_id) {//Added  String ReqDb,String encounter_id for MMS-DM-CRF-115.4
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		ArrayList	records		=	new ArrayList();
		String Sql              =  "";// Added for MMS-DM-CRF-115.4
		
		try{
			connection	= getConnection() ;
			Sql         =  "SELECT A.ORDER_LINE_FIELD_MNEMONIC, A.ORDER_LINE_FIELD_VALUE,B.REMARK_DESC FROM OR_ORDER_LINE_FIELD_VALUES  A,PH_PRES_REMARK_LANG_VW  B WHERE A.ORDER_LINE_FIELD_VALUE = B.REMARK_CODE(+) AND A.ORDER_ID=? AND A.ORDER_LINE_NUM=? AND A.ORDER_LINE_SEQ_NUM >=1 AND A.ORDER_LINE_SEQ_NUM <=200 AND B.LANGUAGE_ID(+) = ?" ;
			//pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_SELECT5") ) ;
			 Sql=Sql.replaceAll("",ReqDb);//Added   for MMS-DM-CRF-115.4
			pstmt		= connection.prepareStatement( Sql ) ;
			pstmt.setString(1,orig_order_id);
			pstmt.setString(2,orig_order_line_no);
			pstmt.setString(3,getLanguageId()); 

			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
				if((resultSet.getString("ORDER_LINE_FIELD_MNEMONIC")).equals("PRES_REMARKS")) {
					records.add(resultSet.getString("REMARK_DESC"));
				} else {
					records.add(resultSet.getString("ORDER_LINE_FIELD_VALUE"));
				}
			}						
		}
		catch(Exception e){
				records.add(e.toString());
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return records;	
	}

		
	public HashMap getHoldRemarks(String orig_order_id,String order_line_num,String ReqDb,String encounter_id){//Added  String ReqDb,String encounter_id for MMS-DM-CRF-115.4
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		HashMap	records			=	new HashMap();
		String locale	= getLanguageId();
		String Sql      ="";//Added for MMS-DM-CRF-115.4
		try{
			connection	= getConnection() ;

			//pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_SELECT12") ) ;
			Sql   =  "SELECT b.CAN_LINE_REASON,B.HOLD_PRACT_ID,AM_GET_DESC.AM_PRACTITIONER  (B.HOLD_PRACT_ID,?,2) HOLD_PRACT_DESC,TO_CHAR(B.HOLD_DATE_TIME,'DD/MM/YYYY HH24:MI') HOLD_DATE_TIME ,B.DISC_PRACT_ID,AM_GET_DESC.AM_PRACTITIONER  (B.DISC_PRACT_ID,?,2) DISC_PRACT_DESC,TO_CHAR(B.DISC_DATE_TIME,'DD/MM/YYYY HH24:MI') DISC_DATE_TIME,B.CAN_PRACT_ID,AM_GET_DESC.AM_PRACTITIONER  (B.CAN_PRACT_ID,?,2) CAN_PRACT_DESC,TO_CHAR(B.CAN_DATE_TIME,'DD/MM/YYYY HH24:MI') CAN_DATE_TIME FROM OR_ORDER  A,OR_ORDER_LINE   B WHERE A.ORDER_ID=B.ORDER_ID AND B.ORDER_ID=? AND ORDER_LINE_NUM=?" ;
			if(!ReqDb.equals("")){//Added   for MMS-DM-CRF-115.4

				 Sql =Sql+ " AND A.ENCOUNTER_ID =?" ;
			}
            Sql=Sql.replaceAll("",ReqDb);//Added   for MMS-DM-CRF-115.4

			pstmt		= connection.prepareStatement(Sql) ;
			
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);			
			pstmt.setString(4,orig_order_id);
			pstmt.setString(5,order_line_num);
			if(!ReqDb.equals("")){//IF CONDTION Added for MMS-DM-CRF-115.4

				pstmt.setString(6,encounter_id);
			}

			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				records.put("CAN_REASON",checkForNull(resultSet.getString("CAN_LINE_REASON")));
				records.put("HOLD_PRACT_ID",checkForNull(resultSet.getString("HOLD_PRACT_ID")));
				records.put("HOLD_DATE_TIME",checkForNull(resultSet.getString("HOLD_DATE_TIME")));
				records.put("DISC_PRACT_ID",checkForNull(resultSet.getString("DISC_PRACT_ID")));
				records.put("DISC_DATE_TIME",checkForNull(resultSet.getString("DISC_DATE_TIME")));
				records.put("CAN_PRACT_ID",checkForNull(resultSet.getString("CAN_PRACT_ID")));
				records.put("CAN_DATE_TIME",checkForNull(resultSet.getString("CAN_DATE_TIME")));
				records.put("HOLD_PRACT_DESC",checkForNull(resultSet.getString("HOLD_PRACT_DESC")));
				records.put("DISC_PRACT_DESC",checkForNull(resultSet.getString("DISC_PRACT_DESC")));
				records.put("CAN_PRACT_DESC",checkForNull(resultSet.getString("CAN_PRACT_DESC")));
			}						
		}catch(Exception e){
			e.printStackTrace();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return records;	
	}
		
	public HashMap getRemarks(String orig_order_id,String orig_order_line_no,String patient_id,String srl_no,String ReqDb,String encounter_id){//Added  String ReqDb,String encounter_id for MMS-DM-CRF-115.4
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		HashMap	records			=	new HashMap();
		String Sql              =   "";//Added for MMS-DM-CRF-115.4
	 //String Sql1             =   "";//Added for MMS-DM-CRF-115.4//Common-ICN-0092  
		try{
			connection	= getConnection() ;

			Sql         = "SELECT A.PRN_REMARKS,A.ALLERGY_OVERRIDE_REASON, A.DISCONT_BY_ID, TO_CHAR(A.DISCONT_DATE_TIME,'DD/MM/YYYY')  DISCONT_DATE_TIME, A.DISCONT_REASON_CODE, A.CANCEL_BY_ID, TO_CHAR(A.CANCEL_DATE_TIME,'DD/MM/YYYY') CANCEL_DATE_TIME, 	    A.DOSAGE_LIMIT_OVERRIDE_REASON,A.DUPLICATE_DRUG_OVERRIDE_REASON,A.SPLIT_DOSE_PREVIEW, B.LAST_ACTION_TYPE, B.LAST_ACTION_REASON_DESC,B.HOLD_PRACT_ID, TO_CHAR(B.HOLD_DATE_TIME,'DD/MM/YYYY') HOLD_DATE_TIME,C.CAN_REASON HOLD_REASON,A.RETURN_REASON_CODE, A.ALT_DRUG_REMARKS, OLPH.PREGNANCY_OVERRIDE_REASON FROM PH_PATIENT_DRUG_PROFILE  A,OR_ORDER_LINE  B , OR_ORDER  C, OR_ORDER_LINE_PH  OLPH  WHERE A.ORIG_ORDER_ID=B.ORDER_ID AND A.ORIG_ORDER_LINE_NO=B.ORDER_LINE_NUM  AND A.ORIG_ORDER_ID=OLPH.ORDER_ID AND A.ORIG_ORDER_LINE_NO=OLPH.ORDER_LINE_NUM  AND A.ORIG_ORDER_ID=? AND   C.ORDER_ID=B.ORDER_ID AND A.ORIG_ORDER_LINE_NO=? AND	  A.PATIENT_ID=? AND  A.SRL_NO=?";

			if(!ReqDb.equals("")){

				 Sql =Sql+ " AND A.ENCOUNTER_ID =? AND A.ENCOUNTER_ID = C.ENCOUNTER_ID" ;
			}

			//pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_SELECT3") ) ;

			Sql=Sql.replaceAll("",ReqDb);//Added   for MMS-DM-CRF-115.4

			//System.err.println("Sql@@@@===="+Sql+"ReqDb==="+ReqDb);


			pstmt		= connection.prepareStatement( Sql );
			
			pstmt.setString(1,orig_order_id);
			pstmt.setString(2,orig_order_line_no);
			pstmt.setString(3,patient_id);
			pstmt.setString(4,srl_no);
			if(!ReqDb.equals("")){//Added for MMS-DM-CRF-115.4
                pstmt.setString(5,encounter_id);
			}
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
					records.put("SPLIT_DOSE_PREVIEW",checkForNull(resultSet.getString("SPLIT_DOSE_PREVIEW")));
					records.put("ALLERGY_REASON",checkForNull(resultSet.getString("ALLERGY_OVERRIDE_REASON")));
					records.put("OVERRIDE_REASON",checkForNull(resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON")));
					records.put("DUPLICATE_REASON",checkForNull(resultSet.getString("DUPLICATE_DRUG_OVERRIDE_REASON")));
					records.put("DISCONT_ID",checkForNull(resultSet.getString("DISCONT_BY_ID")));
					records.put("DICONT_DATE",checkForNull(resultSet.getString("DISCONT_DATE_TIME")));
					records.put("REASON",checkForNull(resultSet.getString("LAST_ACTION_REASON_DESC")));
					records.put("CANCEL_BY_ID",checkForNull(resultSet.getString("CANCEL_BY_ID")));
					records.put("CANCEL_DATE_TIME",checkForNull(resultSet.getString("CANCEL_DATE_TIME")));
					records.put("HOLD_PRACT_ID",checkForNull(resultSet.getString("HOLD_PRACT_ID")));
					records.put("HOLD_DATE_TIME",checkForNull(resultSet.getString("HOLD_DATE_TIME")));
					records.put("HOLD_REASON",checkForNull(resultSet.getString("HOLD_REASON")));
					records.put("RETURN_REASON_CODE",checkForNull(resultSet.getString("RETURN_REASON_CODE")));
					records.put("PRN_REMARKS",checkForNull(resultSet.getString("PRN_REMARKS")));
					records.put("ALT_DRUG_REMARKS",(resultSet.getString("ALT_DRUG_REMARKS")));
					records.put("PREGNANCY_OVERRIDE_REASON",checkForNull(resultSet.getString("PREGNANCY_OVERRIDE_REASON")));
			}						
		}
		catch(Exception e){
			e.printStackTrace();
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
		return records;	
	}

	public String getCompOrdRemarks(String orig_order_id,String orig_order_line_no,String ReqDb,String encounter_id) {//Added  String ReqDb,String encounter_id for MMS-DM-CRF-115.4
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String complete_order_reason = "";
		String Sql              ="";//Added for MMS-DM-CRF-115.4
		
		try{
			connection	= getConnection() ;
//			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_SELECT5") ) ;
            Sql         = "SELECT REASON_DESC FROM PH_MEDN_TRN_REASON_LANG_VW  WHERE APPL_TRN_TYPE='CO' AND EFF_STATUS='E' AND LANGUAGE_ID = ? AND REASON_CODE IN (SELECT COMPLETE_ORDER_REASON FROM OR_ORDER_LINE_PH  WHERE ORDER_ID = ? AND ORDER_LINE_NUM = ?)" ;

			Sql=Sql.replaceAll("",ReqDb);//Added  String ReqDb,String encounter_id for MMS-DM-CRF-115.4

			pstmt		= connection.prepareStatement(Sql) ;
			pstmt.setString(1,getLanguageId()); 
			pstmt.setString(2,orig_order_id);
			pstmt.setString(3,orig_order_line_no);

			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
					complete_order_reason = resultSet.getString("REASON_DESC");
					if(complete_order_reason == null) {complete_order_reason = "";}
			}						
		}
		catch(Exception e){
				//records.add(e.toString());
				System.err.println("complete order reason failed : "+e);
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return complete_order_reason;	
	}

	public ArrayList getMedicationDetails(String orig_order_id){
	
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		ArrayList	records		=	new ArrayList();

		ArrayList fluid		  = new ArrayList();
		ArrayList ingredients = new ArrayList();

		try{
			connection	= getConnection() ;
			//pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_SELECT4") ) ;
			pstmt.setString(1,orig_order_id);
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
				if (resultSet.getString("INFUSE_OVER") != null){
					fluid.add(resultSet.getString("DRUG_CODE"));
					fluid.add(resultSet.getString("DRUG_DESC"));
					fluid.add(resultSet.getString("FORM_CODE"));
					fluid.add(resultSet.getString("FORM_DESC"));
					fluid.add(resultSet.getString("STRENGTH"));
					fluid.add(resultSet.getString("PRESCRIBED_QTY"));
					fluid.add(resultSet.getString("DOSAGE_UOM_CODE"));
					fluid.add(resultSet.getString("FLOW_RATE"));
					fluid.add(resultSet.getString("INFUSE_OVER"));
					fluid.add(resultSet.getString("INFUSE_OVER_UNIT"));
					fluid.add(resultSet.getString("FREQ_DESC"));
					fluid.add(resultSet.getString("DURATION"));
					fluid.add(resultSet.getString("DURN_DESC"));
				}
				else{
					ingredients.add(resultSet.getString("DRUG_CODE"));
					ingredients.add(resultSet.getString("DRUG_DESC"));
					ingredients.add(resultSet.getString("FORM_CODE"));
					ingredients.add(resultSet.getString("FORM_DESC"));
					ingredients.add(resultSet.getString("STRENGTH"));
					ingredients.add(resultSet.getString("PRESCRIBED_QTY"));
					ingredients.add(resultSet.getString("DOSAGE_UOM_CODE"));
				}
			}	
			records.add(fluid);
			records.add(ingredients);

		}catch(Exception e){
				records.add(e.toString());
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();			
			}
		}
		return records;	
	}

	public ArrayList getPatientDetails(String id){

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String localee=getLanguageId()==null?"en":getLanguageId();
		ArrayList	records		=	new ArrayList();

		try{
			connection			= getConnection() ;
//			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_DISP_DRUG_BY_PATIENT_SELECT2") ) ;
			//pstmt				= connection.prepareStatement("SELECT DECODE(?,'en',PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG,PATIENT_NAME)) PATIENT_NAME,GET_AGE(DATE_OF_BIRTH) AGE, DECODE(SEX,'M','male','F','female','unknown') GENDER, to_char(DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH, DECEASED_YN,(select facility_name from sm_facility_param_lang_vw where facility_id = DECEASED_FACILITY_ID and language_id=?) DECEASED_FACILITY, DECEASED_ENCOUNTER_ID , TO_CHAR (DECEASED_DATE, 'dd/mm/yyyy hh24:mi') DECEASED_DATE FROM MP_PATIENT WHERE PATIENT_ID=?") ; //DECEASED_YN ,  DECEASED_DTL for [IN:036157]
			pstmt.setString(1,localee);
			pstmt.setString(2,localee);
			pstmt.setString(3,id);
			resultSet	= pstmt.executeQuery(); 
			while( resultSet != null && resultSet.next() ) {
				records.add(resultSet.getString("PATIENT_NAME"));
				records.add(resultSet.getString("AGE"));
				records.add(resultSet.getString("GENDER"));
				records.add(checkForNull(resultSet.getString("DECEASED_YN"))); //added for [IN:036157]
				records.add(checkForNull(resultSet.getString("DECEASED_FACILITY"))); //added for [IN:036157]
				records.add(checkForNull(resultSet.getString("DECEASED_ENCOUNTER_ID"))); //added for [IN:036157]
				records.add(checkForNull(resultSet.getString("DECEASED_DATE"))); //added for [IN:036157]
			}
		}
		catch(Exception e){
			records.add(e.toString());
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
		return records;	
	}
	public String getReasonDesc(String trn_type,String reason_code,String ReqDb,String encounter_id){//Added  String ReqDb,String encounter_id for MMS-DM-CRF-115.4

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	result		    =	"";
		String locale	= getLanguageId();// Add this for ML-BRU-SCF-0037[030949]	
		String Sql      ="";//Added for MMS-DM-CRF-115.4
		try{
			connection			= getConnection() ;

			Sql                 =  "SELECT  REASON_DESC FROM PH_MEDN_TRN_REASON_LANG_VW  PH_MEDN_TRN_REASON WHERE APPL_TRN_TYPE=? AND REASON_CODE=? AND EFF_STATUS='E' AND LANGUAGE_ID = ?";

			Sql=Sql.replaceAll("",ReqDb);//Added for MMS-DM-CRF-115.4
			//pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_COMMON_SELECT4") ) ;
			pstmt				= connection.prepareStatement( Sql ) ;
			pstmt.setString(1,trn_type);
			pstmt.setString(2,reason_code);
			pstmt.setString(3,locale);   // Add this for ML-BRU-SCF-0037[030949]	
		
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				result = resultSet.getString("REASON_DESC");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){es.printStackTrace();}
		}
		return result;	
	}

	public String isReturnedMedication(String order_id,String order_line_no){

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	result		    =	"";
		try{
			connection			= getConnection() ;
			//pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_SELECT6") ) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_no);			
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				result = resultSet.getString("RETURNED_MEDICATION");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){es.printStackTrace();}
		}
		return result;	
	}

	public HashMap isCancelDiscontinuedApplicable(String order_id,String order_line_no){

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		HashMap	result		    =	new HashMap();
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( "SELECT COUNT(*) COUNT FROM or_order_line WHERE order_line_status IN ('DP','DF','AL','IP','DD','DE') AND END_DATE_TIME >= SYSDATE AND order_id = ? AND order_line_num = ?" ) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_no);			
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				if(resultSet.getInt("COUNT")>0){
					result.put("DISCONTINUE","Y");
				}else{
					result.put("DISCONTINUE","N");
				}
			}
							closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;


			if(!result.containsKey("DISCONTINUE")){
				result.put("DISCONTINUE","N");
			}
			pstmt				= connection.prepareStatement( "SELECT COUNT(*) COUNT FROM or_order_line WHERE order_line_status IN ('OS','RG') AND END_DATE_TIME >= SYSDATE AND order_id = ? AND order_line_num = ?" ) ;
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_no);			
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				if(resultSet.getInt("COUNT")>0){
					result.put("CANCEL","Y");
				}else{
					result.put("CANCEL","N");
				}
			}
			if(!result.containsKey("CANCEL")){
				result.put("CANCEL","N");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){es.printStackTrace();}
		}

		return result;	
	}


	public String isDiscontinuedAllowed(String disp_locn_code){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String allow_discontinue= "N";
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( "SELECT CHANGE_DOSE_DURN_VERIFY_YN FROM PH_DISP_RIGHTS WHERE FACILITY_ID = ? AND DISP_LOCN_CODE = ? AND APPL_USER_ID = ?") ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,disp_locn_code);
			pstmt.setString(3,login_by_id);
			resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
				allow_discontinue =	resultSet.getString("CHANGE_DOSE_DURN_VERIFY_YN");
			}			
		}catch ( Exception e ) {
		//	System.err.println( e ) ;
			e.printStackTrace() ;			
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
				}catch(Exception es){es.printStackTrace();}
		}
		return allow_discontinue;
	}

   public void setAll(Hashtable recordSet){
	    if(recordSet.containsKey("mode"))
		setMode((String)recordSet.get("mode")) ;
		if(recordSet.containsKey("drug_code"))
        drug_code=(String)recordSet.get("drug_code");
		if(recordSet.containsKey("drug_desc"))
        drug_desc=(String)recordSet.get("drug_desc");
		if(recordSet.containsKey("pract_name"))
        pract_name=checkForNull((String)recordSet.get("pract_name"));//checkForNull added for IN070786
		if(recordSet.containsKey("pract_id"))
        pract_id=checkForNull((String)recordSet.get("pract_id"));//checkForNull added for IN070786
		if(recordSet.containsKey("dt_from"))
        dt_from=(String)recordSet.get("dt_from");
		if(recordSet.containsKey("dt_to"))
        dt_to=(String)recordSet.get("dt_to");
		if(recordSet.containsKey("Instructions"))
        Instructions=(String)recordSet.get("Instructions");
		if(recordSet.containsKey("patient_id"))
        patient_id=(String)recordSet.get("patient_id");
		if(recordSet.containsKey("p_facility_id"))
        p_facility_id=(String)recordSet.get("p_facility_id");
		//added for IN070786 start
		if(recordSet.containsKey("route_code"))
			route_code=(String)recordSet.get("route_code");
		if(recordSet.containsKey("frequency"))
			frequency=(String)recordSet.get("frequency");
		if(recordSet.containsKey("qty_desc"))
			qty_desc=(String)recordSet.get("qty_desc");
		if(recordSet.containsKey("dosage"))
			dosage_type=(String)recordSet.get("dosage");
		if(recordSet.containsKey("qty_value"))
			qty_value=(String)recordSet.get("qty_value");
		if(recordSet.containsKey("frequency_nature"))
			frequency_nature=(String)recordSet.get("frequency_nature");
			//added for IN070786 end
		
			
		

		if(recordSet.containsKey("language_id"))
        locale=(String)recordSet.get("language_id");
		 	
  	}

	

	public String compareDate(String start_date){
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		int count=0;
		String str_qry				=	"";
		String return_str			=	"";
		try{
			connection		= getConnection() ;
			str_qry			= "select count(*) from dual where ( to_date(to_char(sysdate,'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi') >= to_date(?,'dd/mm/yyyy hh24:mi'))";//PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT25");
			pstmt					= connection.prepareStatement(str_qry) ;

			pstmt.setString(1,start_date.trim());
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				count=resultSet.getInt(1);
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;

			 if(count >=1){
				return_str	=	"N";
			 } 
			 else {
				 return_str	=	"Y";
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
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return return_str;
	}
	
	public String getPackSizeFluid(String order_id){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String content_in_pres_base_uom		= "";
		try {
            connection	= getConnection() ;
            //pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_SELECT14 (new id )")) ;
			String sql_query = "SELECT A.CONTENT_IN_PRES_BASE_UOM CONTENT_IN_PRES_BASE_UOM FROM PH_DRUG A, OR_ORDER_LINE B WHERE A.DRUG_CODE = B.ORDER_CATALOG_CODE AND ORDER_ID = ? AND ORDER_LINE_NUM = '1'";
			pstmt		= connection.prepareStatement(sql_query) ;
			pstmt.setString(1,order_id);

			resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
				content_in_pres_base_uom =	resultSet.getString("CONTENT_IN_PRES_BASE_UOM");
			}			
		}
		catch ( Exception e ) {
		//	System.err.println( e ) ;
			e.printStackTrace() ;			
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
		return content_in_pres_base_uom;
	}

	public int getPPNIOrderValues(String OrderId, String sPatientId){
		Connection			oConnection				= null;
        PreparedStatement	oPreparedStmt			= null;      		
		ResultSet			oResultSet				= null;
		//ArrayList			alPPNItemDetails		= null;
		//StringBuffer		sbItemIds				= new StringBuffer(" ('");
		//HashMap				hmPPNStoredValues				= null;
		//StringBuffer		sbCriteriaConditions	= new StringBuffer("");
		//ArrayList			alItemCodes				= new ArrayList();	
		int count =0;
		try{
            oConnection	= getConnection() ;
			String sSQL =   "select count(*) count from ph_ppn_orders A, PH_TPN_REGIMEN B where facility_id = ? AND order_id =? and patient_id =?  AND B.TPN_REGIMEN_CODE= A.ITEM_CODE";
			oPreparedStmt		= oConnection.prepareStatement(sSQL);

			oPreparedStmt.setString(1,login_facility_id);			
			oPreparedStmt.setString(2,OrderId);			
			oPreparedStmt.setString(3,sPatientId);			
			oResultSet	= oPreparedStmt.executeQuery() ;
			if(oResultSet !=null && oResultSet.next()){	
				count = oResultSet.getInt("count");			
			}
		}
		catch ( Exception e ) {
			System.err.println( "Exception in getPPNIOrderValues():"+e.toString() ) ;
			e.printStackTrace() ;			
		}
		finally {
			try{
				closeResultSet( oResultSet ) ;
				closeStatement( oPreparedStmt ) ;			
				closeConnection( oConnection ); 
			}
			catch(Exception ex){
				ex.printStackTrace() ;			
			}
		}
		return count;
	}

	public void setNoOfDecimals() {
		Connection oConnection		    = null;
		ResultSet oResultSet			= null;
		Statement oStatement			= null;
		
		try {
			oConnection	= getConnection() ;
			oStatement	= oConnection.createStatement();
			oResultSet	= oStatement.executeQuery(" select NO_OF_DECIMALS from st_acc_entity_param");
			if(oResultSet!=null && oResultSet.next()){
				iNoOfDecimals = oResultSet.getString("NO_OF_DECIMALS")==null?0:Integer.parseInt(oResultSet.getString("NO_OF_DECIMALS"));
			}
		}
		catch ( Exception e ){
			e.printStackTrace() ;
		}
		finally{
			try{
				closeResultSet( oResultSet ) ;
				closeStatement( oStatement ) ;
				closeConnection( oConnection ); 
			}
			catch ( Exception e ){
				e.printStackTrace() ;
			}
		}
	}

	// method getSlidingScaleTemplateDetails Added for 10.X-CRF-SRR20056-CRF-0675-PH-SL-2 -- Start
	public ArrayList getSlidingScaleTemplateDetails(String Order_Id,String Order_line_num,String ReqDb,String encounter_id){//Added  String ReqDb,String encounter_id for MMS-DM-CRF-115.4
		Connection connection			= null;
        PreparedStatement pstmt			= null;      		
		ResultSet resultSet				= null;
		ArrayList slidingScaleDetails	= new ArrayList();	
		String remarks = "";
		String sql     ="";//Added for MMS-DM-CRF-115.4
		try {
            connection	= getConnection() ;
			sql         = "select ph_get_dosage_display  (?,?,?,?,?) DOSAGE_DTLS from dual" ;

			sql=sql.replaceAll("",ReqDb); //Added   for MMS-DM-CRF-115.4

			//pstmt		= connection.prepareStatement("select ph_get_dosage_display (?,?,?,?,?) DOSAGE_DTLS from dual");
			pstmt		= connection.prepareStatement(sql);
			pstmt.setString(1,Order_Id);			
			pstmt.setString(2,Order_line_num);			
			pstmt.setString(3,login_facility_id);			
			pstmt.setString(4,"");			
			pstmt.setString(5,"");			
			resultSet	= pstmt.executeQuery() ;
			if (resultSet !=null && resultSet.next()){
				slidingScaleDetails.add(resultSet.getString("DOSAGE_DTLS")==null?"":resultSet.getString("DOSAGE_DTLS"));
			}
			if(slidingScaleDetails.size() == 0)
				slidingScaleDetails.add("");
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;			
			}
			catch(Exception ex){
				ex.printStackTrace() ;			
			}

			pstmt		= connection.prepareStatement("select A.TEMPLATE_ID, A.SRL_NO, A.RANGE_FROM, A.RANGE_TO, A.ADMIN_UNITS, B.RANGE_UOM_CODE, B.ADMIN_UNITS_UOM_CODE, A.REMARKS,B.TEMPLATE_DESC from OR_ORDER_LINE_PH_SLD_SCALE A, ph_sliding_scale_tmpl B where A.TEMPLATE_ID = B.TEMPLATE_ID and A.order_id=? and A.order_line_num=? order by a.srl_no");
			pstmt.setString(1,Order_Id);			
			pstmt.setString(2,Order_line_num);			
			resultSet	= pstmt.executeQuery() ;
			while (resultSet !=null && resultSet.next()){
				slidingScaleDetails.add(resultSet.getString("TEMPLATE_ID"));
				slidingScaleDetails.add(resultSet.getString("SRL_NO"));
				slidingScaleDetails.add(resultSet.getString("RANGE_FROM"));
				slidingScaleDetails.add(resultSet.getString("RANGE_TO"));
				slidingScaleDetails.add(resultSet.getString("ADMIN_UNITS"));
				slidingScaleDetails.add(resultSet.getString("RANGE_UOM_CODE"));
				slidingScaleDetails.add(resultSet.getString("ADMIN_UNITS_UOM_CODE"));
				remarks = resultSet.getString("REMARKS");
				if(remarks !=null || !remarks.equals(""))
					slidingScaleDetails.add(java.net.URLEncoder.encode(remarks,"UTF-8"));	
				else
					slidingScaleDetails.add("");	
				slidingScaleDetails.add(resultSet.getString("TEMPLATE_DESC"));				
			}
		}
		catch ( Exception e ) {
			System.err.println( "Exception in getSlidingScaleTemplateDetails():"+e.toString() ) ;
			e.printStackTrace() ;			
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;			
				closeConnection( connection ); 
			}
			catch(Exception ex){
				ex.printStackTrace() ;			
			}
		}
		return slidingScaleDetails;
	}//Added for 10.X-CRF-SRR20056-CRF-0675-PH-SL-2 -- End
	
	
	public String getTransacrionReason(String amend_reason_code, String trn_type,String ReqDb,String encounter_id){ // This method Added for ML-BRU-SCF-0098 [IN031837] 
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String locale	= getLanguageId();
		String trn_reason = "";
		String Sql  ="";//Added for MMS-DM-CRF-115.4
		
		try{
			connection	= getConnection() ;
			Sql         = "SELECT REASON_DESC FROM PH_MEDN_TRN_REASON_LANG   WHERE REASON_CODE=?  AND APPL_TRN_TYPE=? AND LANGUAGE_ID=?";//Added for MMS-DM-CRF-115.4

			Sql=Sql.replaceAll("",ReqDb);//Added for MMS-DM-CRF-115.4

			pstmt		= connection.prepareStatement(Sql);			
			pstmt.setString(1,amend_reason_code);
			pstmt.setString(2,trn_type);
			pstmt.setString(3,locale);			
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
					trn_reason = resultSet.getString("REASON_DESC");											
			}
		}
		catch(Exception e){
			e.printStackTrace();
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
		return trn_reason;	
	}

	public String DuplicateCheck(String patient_Id){ 	// added for ML-BRU-SCF-0621[IN036565]
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;    
		String main_patientId = "";		
		try{
			connection	= getConnection() ;					
			pstmt		= connection.prepareStatement("SELECT VALID_PATIENT_ID FROM DR_MP_PATIENT WHERE DUPLICATE_PATIENT_ID =? ");			
			pstmt.setString(1,patient_Id);						
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				main_patientId = resultSet.getString("VALID_PATIENT_ID");					
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();			
			}
		}		
		return main_patientId;	
	}
	public void setFacilityParamValues(){	//added for Bru-HIMS-CRF-082 [IN:029948]
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String Alt_drug_remarks_ind	= "N";
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement( "select ALT_DRUG_REMARKS_IND FROM ph_facility_param where facility_id =?") ;
			pstmt.setString(1,login_facility_id.trim());
            resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				Alt_drug_remarks_ind = checkForNull(resultSet.getString("ALT_DRUG_REMARKS_IND"));
			}
			setAltDrugRemarksInd(Alt_drug_remarks_ind);
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
			catch ( Exception es ) {
				es.printStackTrace() ;
			}
		}
	}

	public ArrayList getMedicalItem(String patientid, String item_code, String date_from, String date_to,String encounter_id,String pract_id,String selTab,String patient_class,String facility_id,String status, String order_type,String date_order){//Added for Medical Tab //Added String ReqDb,String encounter_id for MMS-DM-CRF-115.4
	
	//System.err.println("patientid@@==="+patientid+"item_code==="+item_code+"date_from==="+date_from+"date_to==="+date_to+"encounter_id=="+encounter_id+"pract_id==="+pract_id+"selTab==="+selTab+"patient_class==="+patient_class+"facility_id==="+facility_id+"status==="+status+"order_type==="+order_type+"date_order==="+date_order);
	
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;      
	  //int query_result_size		= 14;//Common-ICN-0092  
	 //String prevnextlink			= "";//Common-ICN-0092  
	 //int start = 0 ;//Common-ICN-0092  
	 //int end = 0 ;//Common-ICN-0092  
	 //long count=0;//Common-ICN-0092  
	//long i = 0;//
		ArrayList	records		=	new ArrayList();
	  //ArrayList medRecords    = new ArrayList();//Common-ICN-0092  
		String sbSql1 =""; //Added for MMS-DM-CRF-115.4
		try{
			connection	= getConnection() ;
			String temp_pat_class ="";
		  if(patient_class.equals("IP"))
			  temp_pat_class ="I";
		  if(patient_class.equals("OP"))
			  temp_pat_class ="O";
		  if(patient_class.equals("DC"))
			  temp_pat_class ="D";
		  if(patient_class.equals("ER"))
			  temp_pat_class ="E";
			StringBuffer sbSQL = new StringBuffer();

			sbSQL.append("SELECT b.added_date dt_ord_date, TO_CHAR (b.added_date,'DD/MM/YYYY HH24:MI') ord_date, TO_CHAR(b.added_date,'DD/MM/YYYY HH24:MI') disp_date, b.item_code, (SELECT DRUG_DESC FROM ph_drug_lang_vw  WHERE language_id = ? AND item_code = b.item_code) item_name, b.item_qty order_qty, b.item_qty disp_qty, (SELECT uo.short_desc FROM mm_item  itm  , am_uom_lang_vw  uo WHERE itm.item_code = b.item_code and itm.gen_uom_code = uo.UOM_CODE and UO.LANGUAGE_ID=? ) order_uom_desc, 'Dispensed - Complete' status_desc, (SELECT appl_user_name FROM sm_appl_user_lang_vw  WHERE language_id = ? AND appl_user_id = b.added_by_id) ordered_practitioner, (SELECT facility_name FROM sm_facility_param_lang_vw  WHERE language_id = ? AND facility_id = a.facility_id) || '- Dispense Location /' || (SELECT short_desc FROM ph_disp_locn_lang_vw  WHERE language_id = ? AND facility_id = a.facility_id AND disp_locn_code = a.store_code) ordering_details, decode(SAL_TRN_TYPE, 'I', 'IP', 'D','IP', 'O', 'OP','E', 'OP', 'X', 'XT') patient_class, '' order_id, 0 order_line_num, (SELECT short_desc FROM ph_disp_locn_lang_vw  WHERE language_id = ? AND facility_id = a.facility_id AND disp_locn_code = a.store_code) disp_locn FROM st_sal_hdr  a, st_sal_dtl  b WHERE a.facility_id = b.facility_id AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND b.item_code IN (SELECT item_code FROM ph_drug  WHERE drug_yn = 'N') AND a.module_id = 'PH' AND NOT EXISTS ((SELECT 'Y' FROM ph_disp_hdr   c, ph_disp_dtl  d WHERE c.patient_id = a.patient_id AND c.doc_type = a.doc_type_code AND c.doc_no = a.doc_no AND c.facility_id = a.facility_id and c.disp_no = D.disp_no and B.DOC_SRL_NO = D.DOC_SRL_NO AND c.DISP_TRN_SEQ_NO||c.disp_no not IN (SELECT DISP_TRN_SEQ_NO||disp_no FROM ph_disp_cons_dtl  )) UNION (SELECT 'Y' FROM ph_disp_hdr_tmp  c, ph_disp_dtl_tmp  d WHERE c.patient_id = a.patient_id AND c.doc_type = a.doc_type_code AND c.doc_no = a.doc_no AND c.facility_id = a.facility_id and c.disp_tmp_no = d.disp_tmp_no  and B.DOC_SRL_NO = D.DOC_SRL_NO AND c.disp_trn_seq_no||c.disp_tmp_no not IN (SELECT disp_trn_seq_no||disp_no FROM ph_disp_cons_dtl  ))) AND patient_id = ? ");

			if(!patient_class.equals(""))
				sbSQL.append(" AND a.SAL_TRN_TYPE =? ");
			if(!encounter_id.equals(""))//Added for MMS-DM-CRF-115.4
				sbSQL.append(" AND  encounter_id = ? ");
			if(!item_code.equals(""))
				sbSQL.append(" AND B.item_code=? ");
			if(!date_from.equals("") && !date_to.equals(""))
				sbSQL.append(" AND trunc(b.added_date) between TO_DATE(?,'DD/MM/YYYY HH24:MI') and TO_DATE(?,'DD/MM/YYYY HH24:MI')");
			else if(!date_from.equals(""))
				sbSQL.append(" AND trunc(b.added_date) >= TO_DATE(?,'DD/MM/YYYY HH24:MI') ");
			else if(!date_to.equals(""))
				sbSQL.append(" AND  trunc(b.added_date) <= TO_DATE(?,'DD/MM/YYYY HH24:MI')");
			if(!facility_id.equals(""))
				sbSQL.append(" AND A.FACILITY_ID=? ");
			if("M".equals(selTab))
				//sbSQL.append(" AND 'Y' = CA_PRACT_SPECILITY_YN(A.PRACTITIONER_ID,?,?) ");//commented for 10245
				sbSQL.append(" AND 'Y' = CA_PRACT_SPECILITY_YN(A.PRACTITIONER_ID,?,a.facility_id) ");//added for 10245
			if("S".equals(selTab))
				sbSQL.append(" AND A.PRACTITIONER_ID=? ");
				

			

			sbSQL.append(" UNION SELECT b.ord_date_time dt_ord_date, TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') ord_date, TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') disp_date, b.order_catalog_code, (SELECT drug_desc FROM ph_drug_lang_vw  WHERE language_id = ? AND drug_code = b.order_catalog_code) item_name, b.order_qty, pdp.tot_issued_qty disp_qty,uo.short_desc order_uom_desc, (SELECT short_desc FROM or_order_status_code_lang_vw  WHERE language_id = ? AND order_status_code = b.order_line_status) status_desc, (SELECT practitioner_name  FROM am_practitioner_lang_vw   WHERE language_id = ? AND practitioner_id = a.ord_pract_id) ordered_practitioner, (SELECT facility_name FROM sm_facility_param_lang_vw  WHERE language_id = ? AND facility_id = a.ordering_facility_id) || DECODE (a.source_type, 'N', (SELECT '- Nursing Unit/' || short_desc FROM ip_nursing_unit_lang_vw  WHERE language_id = ? AND facility_id = a.ordering_facility_id AND nursing_unit_code = a.source_code), 'C', (SELECT '- Clinic/' || short_desc FROM op_clinic_lang_vw  WHERE language_id = ? AND facility_id = a.ordering_facility_id AND clinic_code = a.source_code), 'D', (SELECT '- Day Care/' || short_desc FROM ip_nursing_unit_lang_vw  WHERE language_id = ? AND facility_id = a.ordering_facility_id AND nursing_unit_code = a.source_code), 'E', (SELECT '- Emergency/' || short_desc FROM op_clinic_lang_vw  WHERE language_id = ? AND facility_id = a.ordering_facility_id AND clinic_code = a.source_code) ) || '/' || a.order_id ordering_details, a.patient_class, b.order_id, b.order_line_num, '' disp_locn FROM  or_order  a, or_order_line  b,ph_patient_drug_profile  pdp, am_uom_lang_vw  uo WHERE b.order_id = a.order_id AND b.order_id = pdp.orig_order_id AND b.order_line_num = pdp.orig_order_line_no AND a.ordering_facility_id = pdp.orig_facility_id and uo.uom_code = b.order_uom and uo.language_id=? AND order_catalog_code IN (SELECT drug_code FROM ph_drug  WHERE drug_yn = 'N') AND b.order_category = 'PH' AND a.patient_id =?");
		    
			if(!patient_class.equals(""))
				sbSQL.append(" AND a.patient_class =? ");
			if(!encounter_id.equals(""))//Added for MMS-DM-CRF-115.4
				sbSQL.append(" AND  a.encounter_id = ? ");
			if(!item_code.equals(""))
				sbSQL.append(" AND B.ORDER_CATALOG_CODE=? ");
			if(!date_from.equals("") && !date_to.equals(""))
				sbSQL.append(" AND trunc(b.added_date) between TO_DATE(?,'DD/MM/YYYY HH24:MI') and TO_DATE(?,'DD/MM/YYYY HH24:MI')");
			else if(!date_from.equals(""))
				sbSQL.append(" AND trunc(b.added_date) >= TO_DATE(?,'DD/MM/YYYY HH24:MI') ");
			else if(!date_to.equals(""))
				sbSQL.append(" AND  trunc(b.added_date) <= TO_DATE(?,'DD/MM/YYYY HH24:MI')");
			if(!facility_id.equals(""))
				sbSQL.append(" AND A.ORDERING_FACILITY_ID=? ");
			if("M".equals(selTab))
				//sbSQL.append(" AND 'Y' = CA_PRACT_SPECILITY_YN(A.ord_pract_id,?,?) ");//commented for 10245
				sbSQL.append(" AND 'Y' = CA_PRACT_SPECILITY_YN(A.ord_pract_id,?,pdp.facility_id) ");//added for 10245
			if("S".equals(selTab))
				sbSQL.append(" AND A.ord_pract_id=? ");
			if(patient_class.equals("XT")){
				if(status.equals("A")){
					sbSQL.append(" AND SYSDATE BETWEEN pdp.START_DATE AND pdp.END_DATE AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL ");
				}
				else if(status.equals("F")) {
					sbSQL.append(" AND pdp.START_DATE > SYSDATE AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL ");
				} 
				else if(status.equals("C")) {
					sbSQL.append("  AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL  AND b.ORDER_LINE_STATUS IN ('DF')");
				} 
				else if(status.equals("DC")) {
					sbSQL.append(" AND b.DISC_DATE_TIME IS NOT NULL AND pdp.CANCEL_YN='N'");				
				} 
				else if(status.equals("HD") || status.equals("HC")) {
					sbSQL.append(" AND b.HOLD_DATE_TIME IS NOT NULL AND pdp.CANCEL_YN='N' AND b.ORDER_LINE_STATUS IN ('HD','HC')");				
				} 
				else if(status.equals("R")) {
					sbSQL.append(" AND pdp.RETURNED_QTY IS NOT NULL ");
				
				} 
				else if(status.equals("CN")) {
					sbSQL.append(" AND pdp.CANCEL_YN='Y' ");
					
				} 
				else if(status.equals("PG")) {          
					sbSQL.append(" AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL AND b.ORDER_LINE_STATUS IN ('PO','PC','PS') ");
						
				} 
				
				else if(status.equals("PO")) {
					sbSQL.append(" AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL AND b.ORDER_LINE_STATUS = 'PO' ");
				
				}
				else if(status.equals("PC")) {
					sbSQL.append(" AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL AND b.ORDER_LINE_STATUS = 'PC' ");				
				} 
				else if(status.equals("PS")) {
					sbSQL.append(" AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL AND b.ORDER_LINE_STATUS = 'PS' ");
				
				} 
				else {
					sbSQL.append(" AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL ");
				}
			}
			else if((patient_class.equals("IP") || patient_class.equals("DC")) && status.equals("A")) {
				sbSQL.append(" AND SYSDATE BETWEEN pdp.START_DATE AND pdp.END_DATE AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL AND b.ORDER_LINE_STATUS NOT IN ('PO','PS','CN','HD','HC','DC')");
			} 
			else if((patient_class.equals("OP") || patient_class.equals("EM")) && status.equals("A")) {
				sbSQL.append(" AND SYSDATE BETWEEN pdp.START_DATE AND pdp.END_DATE AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL AND (NVL(pdp.TOT_ISSUED_QTY,0)-NVL(pdp.RETURNED_QTY,0))>=0 AND b.ORDER_LINE_STATUS NOT IN ('PO','PS','CN','HD','HC','DC')");
				
			} 
			else if(status.equals("A")) {
			//	serr.println("Inside status condition===");
				sbSQL.append(" AND ((pdp.PATIENT_CLASS = 'IP' AND SYSDATE BETWEEN pdp.START_DATE AND pdp.END_DATE AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL AND (NVL(pdp.TOT_ISSUED_QTY,0)-NVL(pdp.RETURNED_QTY,0))>=0 AND b.ORDER_LINE_STATUS NOT IN ('PO','PS','CN','HD','HC','DC')) OR (pdp.PATIENT_CLASS IN( 'OP' ,'XT') AND SYSDATE BETWEEN pdp.START_DATE AND pdp.END_DATE AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL AND (NVL(pdp.TOT_ISSUED_QTY,0)-NVL(pdp.RETURNED_QTY,0))>=0 AND b.ORDER_LINE_STATUS NOT IN ('PO','PS','CN','HD','HC','DC')))");
				
			} 
			else if(status.equals("F")) {
				sbSQL.append(" AND pdp.START_DATE > SYSDATE AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL ");
			} 
			else if(status.equals("C")) {
				sbSQL.append(" AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL  AND b.ORDER_LINE_STATUS IN ('DF')");
			} 
			else	if(status.equals("DC")) {
				sbSQL.append(" AND b.DISC_DATE_TIME IS NOT NULL AND pdp.CANCEL_YN='N'");
				
			} 
			else if(status.equals("HD") || status.equals("HC")) {
				sbSQL.append(" AND b.HOLD_DATE_TIME IS NOT NULL AND pdp.CANCEL_YN='N' AND b.ORDER_LINE_STATUS IN ('HD','HC')");

			} 
			else if(status.equals("R")) {
				sbSQL.append(" AND pdp.RETURNED_QTY IS NOT NULL ");

			} 
			else if(status.equals("CN")) {
				sbSQL.append(" AND pdp.CANCEL_YN='Y' ");

			} 
			else if(status.equals("PG")) {          
				sbSQL.append(" AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL AND b.ORDER_LINE_STATUS IN ('PO','PC','PS') ");

			} 
			
			else if(status.equals("PO")) {
				sbSQL.append(" AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL AND b.ORDER_LINE_STATUS = 'PO' ");
			
			}
			else if(status.equals("PC")) {
				sbSQL.append(" AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL AND b.ORDER_LINE_STATUS = 'PC' ");
			
			} 
			else if(status.equals("PS")) {
				sbSQL.append(" AND pdp.CANCEL_YN='N' AND pdp.STOP_YN='N' AND pdp.ON_HOLD_DATE_TIME IS NULL AND pdp.DISCONT_DATE_TIME IS NULL AND b.ORDER_LINE_STATUS = 'PS' ");
			
			}

			if(date_order.equals("D"))
			    sbSQL.append(" ORDER BY 2 DESC");
			else
				sbSQL.append(" ORDER BY 2 ASC");

			sbSql1 =sbSQL.toString();//Added for MMS-DM-CRF-115.4

			//System.err.println("sbSql1@@==="+sbSql1);

			pstmt		= connection.prepareStatement( sbSql1) ;
           // pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PATIENT_PROFILE_MEDICAL_ITEM_SELECT")) ;
            int pcount=0;
			pstmt.setString(++pcount,getLanguageId());	//1
			pstmt.setString(++pcount,getLanguageId());
			pstmt.setString(++pcount,getLanguageId());
			pstmt.setString(++pcount,getLanguageId());
			pstmt.setString(++pcount,getLanguageId());
			pstmt.setString(++pcount,getLanguageId()); //5
			pstmt.setString(++pcount,patientid); 
			if(!patient_class.equals(""))
				pstmt.setString(++pcount,temp_pat_class); 
			if(!encounter_id.equals(""))
				 pstmt.setString(++pcount,encounter_id); 
			if(!item_code.equals(""))
				pstmt.setString(++pcount,item_code); 
			if(!date_from.equals("") )
				pstmt.setString(++pcount,date_from); 
			if(!date_to.equals(""))
				pstmt.setString(++pcount,date_to); 
			if(!facility_id.equals(""))
			 pstmt.setString(++pcount, facility_id);
			 if("M".equals(selTab)){
				pstmt.setString(++pcount, pract_id);
				 //pstmt.setString(++pcount, facility_id);//commented for 10245
			 }
			 if("S".equals(selTab)){
				  pstmt.setString(++pcount, pract_id);
			 }
			pstmt.setString(++pcount,getLanguageId());
			pstmt.setString(++pcount,getLanguageId());
			pstmt.setString(++pcount,getLanguageId());
			pstmt.setString(++pcount,getLanguageId());
			pstmt.setString(++pcount,getLanguageId());
			pstmt.setString(++pcount,getLanguageId());
			pstmt.setString(++pcount,getLanguageId());
			pstmt.setString(++pcount,getLanguageId());
			pstmt.setString(++pcount,getLanguageId());
			pstmt.setString(++pcount,patientid);
			if(!patient_class.equals(""))
				pstmt.setString(++pcount,patient_class);
			if(!encounter_id.equals(""))
				 pstmt.setString(++pcount,encounter_id); 
			if(!item_code.equals(""))
				pstmt.setString(++pcount,item_code); 
			if(!date_from.equals("") )
				pstmt.setString(++pcount,date_from); 
			if(!date_to.equals(""))
				pstmt.setString(++pcount,date_to); 		
			if(!facility_id.equals(""))
			 pstmt.setString(++pcount, facility_id);
			 if("M".equals(selTab)){
				pstmt.setString(++pcount, pract_id);
				//pstmt.setString(++pcount, facility_id);//commented for 10245
			 }
			 if("S".equals(selTab)){
				  pstmt.setString(++pcount, pract_id);
			 }

			resultSet	= pstmt.executeQuery(); 

			while (resultSet !=null && resultSet.next() ){
				

				  // records = new ArrayList(); 
					records.add(checkForNull(resultSet.getString("ORD_DATE")));
					records.add(checkForNull(resultSet.getString("ITEM_CODE")));
					records.add(checkForNull(resultSet.getString("ITEM_NAME")));
					records.add(checkForNull(resultSet.getString("ORDER_QTY")));
					records.add(checkForNull(resultSet.getString("ORDER_UOM_DESC")));
					records.add(checkForNull(resultSet.getString("STATUS_DESC")));
					records.add(checkForNull(resultSet.getString("ORDERED_PRACTITIONER")));
					records.add(checkForNull(resultSet.getString("ORDERING_DETAILS")));
					records.add(checkForNull(resultSet.getString("DISP_QTY")));
					records.add(checkForNull(resultSet.getString("PATIENT_CLASS")));
					records.add(checkForNull(resultSet.getString("ORDER_ID")));
					records.add(checkForNull(resultSet.getString("ORDER_LINE_NUM")));
					records.add(checkForNull(resultSet.getString("DISP_DATE")));
					records.add(checkForNull(resultSet.getString("DISP_LOCN")));
					//medRecords.add(records);
				}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return records;	
	}
	
	public String getConvFactor(String pres_uom,String qty_uom)	{
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String sql_str;
		String equl_value		= "1";
		try{
			connection			= getConnection() ;
			sql_str				= "";//PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT53");
			pstmt				= connection.prepareStatement(sql_str) ;

			pstmt.setString(1,pres_uom);
			pstmt.setString(2,qty_uom);
			pstmt.setString(3,pres_uom);
			pstmt.setString(4,qty_uom);
			resultSet	= pstmt.executeQuery();
			if ( resultSet != null && resultSet.next() ) {
				equl_value	=	checkForNull(resultSet.getString("EQVL_VALUE"),"1");
			}
		}
		catch(Exception e){
			equl_value=e.toString();
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
		return equl_value;
	}

	public ArrayList getReturnMedicationRecords(String order_id, String order_line_no){//Added for ML-BRU-SCF-1394[IN0501010]

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		ArrayList all_locations	=	new ArrayList() ;
		String sql_str="";
		try{
			int noOfDecimals = getNoOfDecimals();
			String decimalStringFormat = "#.";
			if(noOfDecimals == 0)
				decimalStringFormat = "#";
			for (int i=0;i<noOfDecimals;i++){
				decimalStringFormat += "#";
			}
			DecimalFormat dfToInteger = new DecimalFormat(decimalStringFormat);	
			String ret_qty = "", ret_date="";
			connection			= getConnection() ;
			//sql_str				= PhRepository.getPhKeyValue("SQL_PH_RETURNMEDICATION_SELECT");
			pstmt				= connection.prepareStatement(sql_str);

			pstmt.setString(1,getLanguageId()); 
			pstmt.setString(2,getLanguageId()); 
			pstmt.setString(3,order_id);
			pstmt.setString(4,order_line_no);
			pstmt.setString(5,getLanguageId()); 
			pstmt.setString(6,getLanguageId()); 
			resultSet	= pstmt.executeQuery(); 
			while (resultSet !=null && resultSet.next()){	
				ret_date = checkForNull(resultSet.getString("RETURNED_DATE_TIME"));
				all_locations.add(ret_date); //0
				all_locations.add(checkForNull(resultSet.getString("RETURNED_DRUG_DESC")));//1
				ret_qty =(dfToInteger.format(Double.parseDouble(resultSet.getString("RETURNED_QTY")))+"")+" "+resultSet.getString("RET_QTY_UOM");
				all_locations.add(ret_qty); //2
				all_locations.add(checkForNull(resultSet.getString("RETURNED_BY"))); //3
				all_locations.add(checkForNull(resultSet.getString("STATUS")));//4
				all_locations.add(checkForNull(resultSet.getString("ALT_DRUG_REMARKS")));//5
				all_locations.add(checkForNull(resultSet.getString("DISP_LOCN_CODE")));//6
			}

		}
		catch(Exception e){
			e.printStackTrace();
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
		return all_locations;
	}

	public ArrayList getReIssueMedicationRecords(String order_id, String order_line_no){//Added for ML-BRU-SCF-1394[IN0501010]
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		ArrayList all_locations	=	new ArrayList() ;
		String sql_str="";
		try{
			int noOfDecimals = getNoOfDecimals();
			String decimalStringFormat = "#.";
			if(noOfDecimals == 0)
				decimalStringFormat = "#";
			for (int i=0;i<noOfDecimals;i++){
				decimalStringFormat += "#";
			}
			DecimalFormat dfToInteger = new DecimalFormat(decimalStringFormat);	
			String reissue_qty = "", reissue_date="";
			connection			= getConnection() ;
			//sql_str				= PhRepository.getPhKeyValue("SQL_PH_REISSUEMEDICATION_SELECT");
			pstmt				= connection.prepareStatement(sql_str);

			pstmt.setString(1,getLanguageId()); 
			pstmt.setString(2,getLanguageId()); 
			pstmt.setString(3,order_id);
			pstmt.setString(4,order_line_no);
			pstmt.setString(5,getLanguageId()); 
			pstmt.setString(6,getLanguageId()); 
			resultSet	= pstmt.executeQuery(); 
			while (resultSet !=null && resultSet.next()){	
				reissue_date = checkForNull(resultSet.getString("REISSUE_DATE_TIME"));
				all_locations.add(reissue_date); //0
				all_locations.add(checkForNull(resultSet.getString("REISSUED_DRUG_DESC")));//1
				reissue_qty =(dfToInteger.format(Double.parseDouble(resultSet.getString("REISSUED_QTY")))+"")+" "+resultSet.getString("REISSUE_QTY_UOM");
				all_locations.add(reissue_qty); //2
				all_locations.add(checkForNull(resultSet.getString("REISSUED_BY"))); //3
				all_locations.add(checkForNull(resultSet.getString("STATUS")));//4
				all_locations.add(checkForNull(resultSet.getString("ALT_DRUG_REMARKS")));//5
				all_locations.add(checkForNull(resultSet.getString("DISP_LOCN_CODE")));//6
			}
		}
		catch(Exception e){
			e.printStackTrace();
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
		return all_locations;
	}

	public ArrayList getDiscCancelledOrderDetails(String disc_cancelled_orders) throws Exception{	//Added for HSA-CRF-0138 [IN:048414]
		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;		
		ArrayList discCancelledOrderDetails = new ArrayList();
		try {
			connection	= getConnection() ;
			String stSql = "";//PhRepository.getPhKeyValue("SQL_PH_DISC_CANCELLED_DRUG_DTL_SELECT");
			stSql = stSql+" AND (A.ORDER_ID, A.ORDER_LINE_NUM) IN ("+disc_cancelled_orders+") ORDER BY A.ORDER_ID || A.ORDER_LINE_NUM";
			pstmt		= connection.prepareStatement(stSql) ;
			pstmt.setString(1,getLanguageId());						
			pstmt.setString(2,getLanguageId());						
			pstmt.setString(3,getLanguageId());						
			resultSet	= pstmt.executeQuery() ;
			while(resultSet.next()){
				discCancelledOrderDetails.add(checkForNull(resultSet.getString("ORDER_ID"))); //0
				discCancelledOrderDetails.add(checkForNull(resultSet.getString("DRUG_DESC")));
				discCancelledOrderDetails.add(checkForNull(resultSet.getString("START_DATE_TIME")));
				discCancelledOrderDetails.add(checkForNull(resultSet.getString("END_DATE_TIME")));
				discCancelledOrderDetails.add(checkForNull(resultSet.getString("ORD_PRACT_NAME")));
				discCancelledOrderDetails.add(checkForNull(resultSet.getString("ORD_PRACT_ID"))); //5
				discCancelledOrderDetails.add(checkForNull(resultSet.getString("DISC_CAN_PRACT_NAME")));
				discCancelledOrderDetails.add(checkForNull(resultSet.getString("DISC_CAN_PRACT_ID")));
				discCancelledOrderDetails.add(checkForNull(resultSet.getString("CAN_LINE_REASON")));//8
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
		return discCancelledOrderDetails;
	} 
	public void UpdateAccessNo(String accession_no,String patient_id,String drug_code,String srl_no,String facility_id) throws Exception{	//Added for AAKH-CRF-0088.2 [IN061987]
		Connection connection	= null;
		PreparedStatement pstmt	= null;
	//	ArrayList discCancelledOrderDetails = new ArrayList(); Removed for IN063877
		try {
			connection	= getConnection() ;
			pstmt		= connection.prepareStatement("UPDATE PH_PATIENT_EXT_DRUG_PROFILE SET ACCESSION_NUM = ? WHERE PATIENT_ID = ? AND DRUG_CODE = ? AND SRL_NO=? AND FACILITY_ID=? ");
			pstmt.setString(1,accession_no);
			pstmt.setString(2,patient_id); 
			pstmt.setString(3,drug_code);
			pstmt.setString(4,srl_no);
			pstmt.setString(5,facility_id);
			pstmt.executeUpdate();
			connection.commit();
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}
	}
	
	public String getReturnMedicationUom(String order_id, String order_line_no){// Added for ICN-69026 - Start

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String ret_uom	=	"";
		String sql_str="";
		try{
			connection			= getConnection() ;
			sql_str				= "SELECT disp_qty_uom FROM ph_disp_dtl a, ph_disp_drug_batch b WHERE a.disp_no = b.disp_no and a.srl_no = b.srl_no AND a.disp_drug_code = b.drug_code AND a.order_id = ? AND a.order_line_no = ? AND ROWNUM <= 1";
			pstmt				= connection.prepareStatement(sql_str);
			 
			pstmt.setString(1,order_id);
			pstmt.setString(2,order_line_no);			
			resultSet	= pstmt.executeQuery(); 
			while (resultSet !=null && resultSet.next()){	
				ret_uom = checkForNull(resultSet.getString("disp_qty_uom")).trim();
				break;
			}

		}
		catch(Exception e){
			e.printStackTrace();
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
		return ret_uom;
	} // Added for ICN-69026 - End
	
	//added for MMS-KH-CRF-0016.1 START
	
	public HashMap getrecordDetails(String drug_code){
	
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;  
		PreparedStatement pstmt1 =	null ;
		ResultSet resultSet1		=	null ;
		PreparedStatement pstmt2 =	null ;
		ResultSet resultSet2		=	null ;
		
		String sql_str="";
		HashMap detailsMap			= new HashMap();
		ArrayList FreqList			= new ArrayList();
		ArrayList routes		=  new ArrayList();
		locale= getLanguageId()==null?"en":getLanguageId();
		String form_code="";
		try{
			connection			= getConnection() ;
			sql_str				= "SELECT form_code,route_code,DEFAULT_DOSAGE_BY,strength_value,CALC_DOSG_BY_FREQ_DURN_YN,FRACT_DOSE_APPL_YN,STRENGTH_UOM FROM ph_drug where drug_code=?";
			pstmt				= connection.prepareStatement(sql_str);
			 
			pstmt.setString(1,drug_code);
						
			resultSet	= pstmt.executeQuery(); 
			while (resultSet !=null && resultSet.next()){	
				form_code= checkForNull(resultSet.getString("FORM_CODE")).trim();
				detailsMap.put("FORM_CODE",form_code);
				detailsMap.put("ROUTE_CODE",checkForNull(resultSet.getString("ROUTE_CODE")).trim());
				detailsMap.put("STRENGTH_VALUE",checkForNull(resultSet.getString("STRENGTH_VALUE")).trim());
				detailsMap.put("DEFAULT_DOSAGE_BY",checkForNull(resultSet.getString("DEFAULT_DOSAGE_BY")).trim());
				detailsMap.put("STRENGTH_UOM",checkForNull(resultSet.getString("STRENGTH_UOM")));
				//detailsMap.put("STRENGTH_UOM_DESC",getUomDisplay(login_facility_id,checkForNull(resultSet.getString("STRENGTH_UOM"))));
				if(resultSet.getString("CALC_DOSG_BY_FREQ_DURN_YN")== null || resultSet.getString("CALC_DOSG_BY_FREQ_DURN_YN").equals("N")){
					
						detailsMap.put("DOSAGE_TYPE","A");					
					
						detailsMap.put("ORI_DOSAGE_TYPE","A");
				
				}
				else{
					if(resultSet.getString("STRENGTH_VALUE")== null ||resultSet.getString("STRENGTH_VALUE").equals("0")  || resultSet.getString("FRACT_DOSE_APPL_YN").equals("N")|| resultSet.getString("FRACT_DOSE_APPL_YN")== null){
						
						detailsMap.put("DOSAGE_TYPE","Q");	
						detailsMap.put("ORI_DOSAGE_TYPE","Q");
											
					}
					else{
						detailsMap.put("DOSAGE_TYPE","S");	
						detailsMap.put("ORI_DOSAGE_TYPE","S");
					}
				}					
			}
			//pstmt1				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT65")) ;
			pstmt1.setString(1,form_code);
			pstmt1.setString(2, locale);
			resultSet1	= pstmt1.executeQuery();

			while ( resultSet1 != null && resultSet1.next() ) {
				routes.add(checkForNull(resultSet1.getString("ROUTE_CODE")));
				routes.add(checkForNull(resultSet1.getString("ROUTE_DESC")));
				routes.add(checkForNull(resultSet1.getString("ROUTE_COLOR")));
			}
			
			detailsMap.put("routes",routes);

			
			String sql_query="SELECT DISTINCT A.FREQ_CODE,A.FREQ_DESC, A.FREQ_NATURE FROM AM_FREQUENCY_LANG_VW A, OR_FREQ_CATALOG_SCOPE B WHERE A.EFF_STATUS='E' AND A.FREQ_NATURE NOT IN ('C','Y') AND A.FREQ_CODE = B.FREQ_CODE AND ((A.SCHEDULED_YN='Y'  and exists (select 1 from am_frequency_admin_day_time c where b.freq_code = c.freq_code   and c.admin_facility_id in (?,'*A',?) ) )  OR (a.scheduled_yn = 'N') OR A.FREQ_NATURE IN ('P','O'))  AND B.ORDER_CATALOG_CODE=? AND A.LANGUAGE_ID = ? ORDER BY 2";
	
			pstmt2				= connection.prepareStatement(sql_query) ;
			pstmt2.setString(1,login_facility_id);
			pstmt2.setString(2,login_facility_id);
			pstmt2.setString(3,drug_code);
			pstmt2.setString(4, locale);
			resultSet2	= pstmt2.executeQuery();

			while ( resultSet2 != null && resultSet2.next() ) {
				FreqList.add(checkForNull(resultSet2.getString("FREQ_CODE")));
				FreqList.add(checkForNull(resultSet2.getString("FREQ_DESC")));
				FreqList.add(checkForNull(resultSet2.getString("FREQ_NATURE")));
			}
			
			detailsMap.put("FreqList",FreqList);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt1) ;
				closeResultSet( resultSet2 ) ;
				closeStatement( pstmt2) ;
				
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return detailsMap;
	}
	public ArrayList loadQtyDetails(String form_code){
		ArrayList	qty_values  = new ArrayList();
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		locale= getLanguageId()==null?"en":getLanguageId();
		
		try{
			connection	= getConnection() ;
			//pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT12A") ) ;
			//pstmt		= connection.prepareStatement("SELECT a.short_desc, a.uom_code, b.dflt_uom_yn qty_uom_yn FROM am_uom_lang_vw a, ph_uom_for_form b WHERE a.uom_code = b.uom_code AND b.form_code = ? AND a.qty_uom_yn = 'Y' AND a.language_id = ? UNION SELECT (select b.short_desc from am_uom_lang_vw b where b.uom_code=a.uom_code and b.language_id=?) short_desc, c.uom_code, c.dflt_uom_yn FROM am_uom_eqvl a, ph_uom_for_form c WHERE a.uom_code IN (SELECT uom_code FROM ph_uom_for_form WHERE form_code = ?) AND a.eqvl_uom_code IN (SELECT uom_code FROM ph_uom_for_form WHERE form_code = ?) AND c.uom_code = a.uom_code AND c.form_code = ? UNION SELECT (select b.short_desc from am_uom_lang_vw b where b.uom_code=a.eqvl_uom_code and b.language_id=?) short_desc , c.uom_code, c.dflt_uom_yn FROM am_uom_eqvl a, ph_uom_for_form c WHERE a.uom_code IN (SELECT uom_code FROM ph_uom_for_form WHERE form_code = ?) AND a.eqvl_uom_code IN (SELECT uom_code FROM ph_uom_for_form WHERE form_code = ?) AND c.uom_code = a.eqvl_uom_code AND c.form_code = ?" ) ;//added for performance issue MMS
			pstmt.setString(1,form_code);
			pstmt.setString(2,locale);		
			pstmt.setString(3,locale);		//added for performance issue MMS
			pstmt.setString(4,form_code);
			pstmt.setString(5,form_code);
			pstmt.setString(6,form_code);//added for performance issue MMS
			pstmt.setString(7,locale);		
			pstmt.setString(8,form_code);
			pstmt.setString(9,form_code);		
			pstmt.setString(10,form_code);		//added for performance issue MMS
			resultSet	= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				qty_values.add(resultSet.getString("UOM_CODE"));
				qty_values.add(resultSet.getString("SHORT_DESC"));
				qty_values.add(resultSet.getString("QTY_UOM_YN"));
			}
		}
		catch(Exception e){
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){ 
				es.printStackTrace() ;
			}
		}
		return qty_values;
	}
	public ArrayList strengthDetails(String drug_code){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;  
		String sql_str="";
		ArrayList qty_values			= new ArrayList();
		
		try{
			connection			= getConnection() ;
			sql_str				= "SELECT form_code,route_code,DEFAULT_DOSAGE_BY,strength_value,CALC_DOSG_BY_FREQ_DURN_YN,FRACT_DOSE_APPL_YN,STRENGTH_UOM FROM ph_drug where drug_code=?";
			pstmt				= connection.prepareStatement(sql_str);
			 
			pstmt.setString(1,drug_code);
						
			resultSet	= pstmt.executeQuery(); 
			while (resultSet !=null && resultSet.next()){	
				qty_values.add(checkForNull(resultSet.getString("STRENGTH_UOM")));
				//qty_values.add(getUomDisplay(login_facility_id,checkForNull(resultSet.getString("STRENGTH_UOM"))));
			}
		}
			catch(Exception e){
				e.printStackTrace() ;
			}
			finally {
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection( connection );
				}
				catch(Exception es){ 
					es.printStackTrace() ;
				}
			}
		return qty_values;
	}
	//ADDED FOR IN070786 END
}
