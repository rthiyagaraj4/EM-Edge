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
10/10/2019  IN070786                PRATHYUSHA                       MMS-KH-CRF-0016.1
---------------------------------------------------------------------------------------------------------------------------------------------------------
 */
 //saved on 29/10/2005
package ePH ;
import ePH.Prescription.*; 
import java.io.* ;
import java.util.* ;
import java.sql.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
//import java.io.* ;
//import java.util.* ;
//import java.sql.* ;
//import ePH.Common.* ;
import javax.servlet.* ;
import javax.servlet.http.*;
import oracle.sql.*;
import eCommon.SingleTableHandler.*;
import java.text.DecimalFormat; 

public class QueryPatientDrugProfileBean extends PhAdapter implements Serializable {

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

    public QueryPatientDrugProfileBean() {
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
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_COMMON_SELECT1") ) ;
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
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_SELECT1") ) ;
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
	public ArrayList getPresRemarks(String orig_order_id,String orig_order_line_no,String ReqDb,String enc_id1) {//Added  String ReqDb,String enc_id1 for MMS-DM-CRF-115.4
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		ArrayList	records		=	new ArrayList();
		String Sql              =  "";// Added for MMS-DM-CRF-115.4
		
		try{
			connection	= getConnection() ;
			Sql         =  "SELECT A.ORDER_LINE_FIELD_MNEMONIC, A.ORDER_LINE_FIELD_VALUE,B.REMARK_DESC FROM OR_ORDER_LINE_FIELD_VALUES ##REQDB## A,PH_PRES_REMARK_LANG_VW ##REQDB## B WHERE A.ORDER_LINE_FIELD_VALUE = B.REMARK_CODE(+) AND A.ORDER_ID=? AND A.ORDER_LINE_NUM=? AND A.ORDER_LINE_SEQ_NUM >=1 AND A.ORDER_LINE_SEQ_NUM <=200 AND B.LANGUAGE_ID(+) = ?" ;
			//pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_SELECT5") ) ;
			 Sql=Sql.replaceAll("##REQDB##",ReqDb);//Added   for MMS-DM-CRF-115.4
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

		
	public HashMap getHoldRemarks(String orig_order_id,String order_line_num,String ReqDb,String enc_id1){//Added  String ReqDb,String enc_id1 for MMS-DM-CRF-115.4
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		HashMap	records			=	new HashMap();
		String locale	= getLanguageId();
		String Sql      ="";//Added for MMS-DM-CRF-115.4
		try{
			connection	= getConnection() ;

			//pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_SELECT12") ) ;
			Sql   =  "SELECT b.CAN_LINE_REASON,B.HOLD_PRACT_ID,AM_GET_DESC.AM_PRACTITIONER ##REQDB## (B.HOLD_PRACT_ID,?,2) HOLD_PRACT_DESC,TO_CHAR(B.HOLD_DATE_TIME,'DD/MM/YYYY HH24:MI') HOLD_DATE_TIME ,B.DISC_PRACT_ID,AM_GET_DESC.AM_PRACTITIONER ##REQDB## (B.DISC_PRACT_ID,?,2) DISC_PRACT_DESC,TO_CHAR(B.DISC_DATE_TIME,'DD/MM/YYYY HH24:MI') DISC_DATE_TIME,B.CAN_PRACT_ID,AM_GET_DESC.AM_PRACTITIONER ##REQDB## (B.CAN_PRACT_ID,?,2) CAN_PRACT_DESC,TO_CHAR(B.CAN_DATE_TIME,'DD/MM/YYYY HH24:MI') CAN_DATE_TIME FROM OR_ORDER ##REQDB## A,OR_ORDER_LINE  ##REQDB## B WHERE A.ORDER_ID=B.ORDER_ID AND B.ORDER_ID=? AND ORDER_LINE_NUM=?" ;
			if(!ReqDb.equals("")){//Added   for MMS-DM-CRF-115.4

				 Sql =Sql+ " AND A.ENCOUNTER_ID =?" ;
			}
            Sql=Sql.replaceAll("##REQDB##",ReqDb);//Added   for MMS-DM-CRF-115.4

			pstmt		= connection.prepareStatement(Sql) ;
			
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);			
			pstmt.setString(4,orig_order_id);
			pstmt.setString(5,order_line_num);
			if(!ReqDb.equals("")){//IF CONDTION Added for MMS-DM-CRF-115.4

				pstmt.setString(6,enc_id1);
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
		
	public HashMap getRemarks(String orig_order_id,String orig_order_line_no,String patient_id,String srl_no,String ReqDb,String enc_id1){//Added  String ReqDb,String enc_id1 for MMS-DM-CRF-115.4
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		HashMap	records			=	new HashMap();
		String Sql              =   "";//Added for MMS-DM-CRF-115.4
		//String Sql1             =   "";//Added for MMS-DM-CRF-115.4 //Commented for common-icn-0048
		try{
			connection	= getConnection() ;

			Sql         = "SELECT A.PRN_REMARKS,A.ALLERGY_OVERRIDE_REASON, A.DISCONT_BY_ID, TO_CHAR(A.DISCONT_DATE_TIME,'DD/MM/YYYY')  DISCONT_DATE_TIME, A.DISCONT_REASON_CODE, A.CANCEL_BY_ID, TO_CHAR(A.CANCEL_DATE_TIME,'DD/MM/YYYY') CANCEL_DATE_TIME, 	    A.DOSAGE_LIMIT_OVERRIDE_REASON,A.DUPLICATE_DRUG_OVERRIDE_REASON,A.SPLIT_DOSE_PREVIEW, B.LAST_ACTION_TYPE, B.LAST_ACTION_REASON_DESC,B.HOLD_PRACT_ID, TO_CHAR(B.HOLD_DATE_TIME,'DD/MM/YYYY') HOLD_DATE_TIME,C.CAN_REASON HOLD_REASON,A.RETURN_REASON_CODE, A.ALT_DRUG_REMARKS, OLPH.PREGNANCY_OVERRIDE_REASON FROM PH_PATIENT_DRUG_PROFILE ##REQDB## A,OR_ORDER_LINE ##REQDB## B , OR_ORDER ##REQDB## C, OR_ORDER_LINE_PH ##REQDB## OLPH  WHERE A.ORIG_ORDER_ID=B.ORDER_ID AND A.ORIG_ORDER_LINE_NO=B.ORDER_LINE_NUM  AND A.ORIG_ORDER_ID=OLPH.ORDER_ID AND A.ORIG_ORDER_LINE_NO=OLPH.ORDER_LINE_NUM  AND A.ORIG_ORDER_ID=? AND   C.ORDER_ID=B.ORDER_ID AND A.ORIG_ORDER_LINE_NO=? AND	  A.PATIENT_ID=? AND  A.SRL_NO=?";

			if(!ReqDb.equals("")){

				 Sql =Sql+ " AND A.ENCOUNTER_ID =? AND A.ENCOUNTER_ID = C.ENCOUNTER_ID" ;
			}

			//pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_SELECT3") ) ;

			Sql=Sql.replaceAll("##REQDB##",ReqDb);//Added   for MMS-DM-CRF-115.4

			System.err.println("Sql@@@@===="+Sql+"ReqDb==="+ReqDb);


			pstmt		= connection.prepareStatement( Sql );
			
			pstmt.setString(1,orig_order_id);
			pstmt.setString(2,orig_order_line_no);
			pstmt.setString(3,patient_id);
			pstmt.setString(4,srl_no);
			if(!ReqDb.equals("")){//Added for MMS-DM-CRF-115.4
                pstmt.setString(5,enc_id1);
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

	public String getCompOrdRemarks(String orig_order_id,String orig_order_line_no,String ReqDb,String enc_id1) {//Added  String ReqDb,String enc_id1 for MMS-DM-CRF-115.4
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String complete_order_reason = "";
		String Sql              ="";//Added for MMS-DM-CRF-115.4
		
		try{
			connection	= getConnection() ;
//			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_SELECT5") ) ;
            Sql         = "SELECT REASON_DESC FROM PH_MEDN_TRN_REASON_LANG_VW ##REQDB## WHERE APPL_TRN_TYPE='CO' AND EFF_STATUS='E' AND LANGUAGE_ID = ? AND REASON_CODE IN (SELECT COMPLETE_ORDER_REASON FROM OR_ORDER_LINE_PH ##REQDB## WHERE ORDER_ID = ? AND ORDER_LINE_NUM = ?)" ;

			Sql=Sql.replaceAll("##REQDB##",ReqDb);//Added  String ReqDb,String enc_id1 for MMS-DM-CRF-115.4

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
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_SELECT4") ) ;
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
			pstmt				= connection.prepareStatement("SELECT DECODE(?,'en',PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG,PATIENT_NAME)) PATIENT_NAME,GET_AGE(DATE_OF_BIRTH) AGE, DECODE(SEX,'M','male','F','female','unknown') GENDER, to_char(DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH, DECEASED_YN,(select facility_name from sm_facility_param_lang_vw where facility_id = DECEASED_FACILITY_ID and language_id=?) DECEASED_FACILITY, DECEASED_ENCOUNTER_ID , TO_CHAR (DECEASED_DATE, 'dd/mm/yyyy hh24:mi') DECEASED_DATE FROM MP_PATIENT WHERE PATIENT_ID=?") ; //DECEASED_YN ,  DECEASED_DTL for [IN:036157]
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
	public String getReasonDesc(String trn_type,String reason_code,String ReqDb,String enc_id1){//Added  String ReqDb,String enc_id1 for MMS-DM-CRF-115.4

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	result		    =	"";
		String locale	= getLanguageId();// Add this for ML-BRU-SCF-0037[030949]	
		String Sql      ="";//Added for MMS-DM-CRF-115.4
		try{
			connection			= getConnection() ;

			Sql                 =  "SELECT  REASON_DESC FROM PH_MEDN_TRN_REASON_LANG_VW ##REQDB## PH_MEDN_TRN_REASON WHERE APPL_TRN_TYPE=? AND REASON_CODE=? AND EFF_STATUS='E' AND LANGUAGE_ID = ?";

			Sql=Sql.replaceAll("##REQDB##",ReqDb);//Added for MMS-DM-CRF-115.4
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
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_SELECT6") ) ;
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
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_SELECT7") ) ;
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
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_SELECT8") ) ;
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

	public HashMap discCancelDrug(String order_id,String order_line_no,String remarks,String reason,String status){
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;

		ArrayList mandatory_flds	=	new ArrayList();
		mandatory_flds.add(login_by_id);
		mandatory_flds.add(login_at_ws_no);
		mandatory_flds.add(login_facility_id);

		HashMap tabData	= new HashMap() ;
		HashMap sqlMap		= new HashMap() ;
/*		PrescriptionHome   home=null;
		PrescriptionRemote remote=null;*/
		try {
			//System.err.println(disc_cancel);

			tabData.put("properties", getProperties() );
			tabData.put("order_id",order_id);
			tabData.put("order_line_no",order_line_no);
			tabData.put("remarks",remarks);
			tabData.put("reason",reason);
			tabData.put("status",status);
			tabData.put("mandatory_flds",mandatory_flds);
			sqlMap.put( "SQL_PH_DRUG_PROFILE_QUERY_UPDATE_ORDER_LINE_A",PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_UPDATE_ORDER_LINE_A") );
			sqlMap.put( "SQL_PH_DRUG_PROFILE_QUERY_UPDATE_ORDER_LINE_B",PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_UPDATE_ORDER_LINE_B") );
			sqlMap.put( "SQL_PH_DRUG_PROFILE_QUERY_UPDATE_DRUG_PROFILE_A",PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_UPDATE_DRUG_PROFILE_A") );
			sqlMap.put( "SQL_PH_DRUG_PROFILE_QUERY_UPDATE_DRUG_PROFILE_B",PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_UPDATE_DRUG_PROFILE_B") );
			sqlMap.put( "SQL_PH_DRUG_PROFILE_QUERY_SELECT9",PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_SELECT9") );
			sqlMap.put( "SQL_PH_DRUG_PROFILE_QUERY_UPDATE_OR_ORDER",PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_UPDATE_OR_ORDER") );

/*			InitialContext context = new InitialContext() ;
			Object object = context.lookup( PhRepository.getPhKeyValue("JNDI_PH_PRESCRIPTION") ) ;
			home  = (PrescriptionHome) PortableRemoteObject.narrow( object, PrescriptionHome.class ) ;
			remote = home.create() ;
			HashMap result = remote.discontinueCancelDrug( tabData, sqlMap ) ;*/

			Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue("JNDI_PH_PRESCRIPTION"),PrescriptionHome.class ,getLocalEJB());
			Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]=new Object[2];
			argArray[0]=tabData;
			argArray[1]=sqlMap;

			Class[] paramArray=new Class[2];
			paramArray[0]=tabData.getClass();
			paramArray[1]=sqlMap.getClass();

			HashMap result=(HashMap)(busObj.getClass().getMethod("discontinueCancelDrug",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


			if( ((Boolean) result.get( "result" )).booleanValue() )	{
				map.put("flag",(String)result.get("flag"));
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) result.get( "msgid" ),"Common") ) ;
			}else {
				map.put("flag",(String)result.get("flag"));
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message", "Exception While Insertion:"+(String)map.get("flag") ) ;
			}
		}catch(Exception e) {
			map.put("message",e.toString());
			e.printStackTrace() ;
		}
/*		finally {
			try {}
			catch( Exception ee ){
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}
		}*/
		return map;	
	}

	public String isDiscontinuedAllowed(String disp_locn_code){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String allow_discontinue= "N";
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_PROFILE_QUERY_SELECT10")) ;
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

	public HashMap insert() {
	   
		HashMap map = new HashMap() ;
		ArrayList insertData = new ArrayList() ;

        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "Insert UNDER CONSTRUCTION" ) ;
		Connection connection	= null ;
	    PreparedStatement pstmt		= null ;
		ResultSet resultSet		= null ; 
		try{
			connection		= getConnection() ;
			connection.setAutoCommit(false);
			String srl_no="";		
			//String str_qry	=PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT54");
			String str_qry	="SELECT PH_PAT_EXT_DRUG_PROFILE_SEQ.NEXTVAL SRL_NO FROM dual";
			
			pstmt			= connection.prepareStatement(str_qry) ;
			resultSet		= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				srl_no=resultSet.getString("SRL_NO");
			}
			closeStatement(pstmt);
			closeResultSet(resultSet);
			
			dt_from=com.ehis.util.DateUtils.convertDate(dt_from,"DMYHM",locale,"en");
			dt_to=com.ehis.util.DateUtils.convertDate(dt_to,"DMYHM",locale,"en");

			insertData.add(patient_id) ;
			insertData.add(srl_no) ;
			insertData.add(p_facility_id) ;
			//if condtion added for IN070786
			if(pract_id !=""){
			insertData.add(checkForNull(pract_id)) ;
			insertData.add(checkForNull(pract_name)) ;
			}
			insertData.add(drug_code) ;
			insertData.add(drug_desc) ;
			insertData.add(dt_from) ;
			insertData.add(dt_to) ;
			insertData.add(Instructions) ;
			
			insertData.add(login_by_id.trim()) ;
			insertData.add(login_at_ws_no.trim()) ;
			insertData.add(login_facility_id.trim()) ;
			insertData.add(login_by_id.trim()) ;
			insertData.add(login_at_ws_no.trim()) ;
			insertData.add(login_facility_id.trim()) ;
			//added for IN070786 start
			insertData.add(route_code) ;
			insertData.add(frequency) ;
			insertData.add(qty_desc) ;
			insertData.add(dosage_type) ;
			insertData.add(qty_value) ;
			insertData.add(frequency_nature) ;
			//added for IN070786 end
			
			HashMap tabData = new HashMap() ;
			tabData.put( "properties", getProperties() );
			tabData.put( "InsertData",insertData);
			HashMap sqlMap = new HashMap() ;
				
			 // System.err.println("insertData------>"+insertData);
			 // System.err.println("tabData------>"+tabData);
			//if condtion added for IN070786
			 String InsertSQL="";
			 if(pract_id!=""){
			  InsertSQL="INSERT INTO PH_PATIENT_EXT_DRUG_PROFILE ( PATIENT_ID, SRL_NO, FACILITY_ID, PRACTITIONER_ID,PRACTITIONER_NAME, DRUG_CODE, DRUG_DESC, START_DATE, END_DATE, INSTRUCTIONS, ADDED_BY_ID,ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ROUTE_CODE,FREQUENCY,QTY_DESC,DOSAGE_TYPE,QTY_VALUE,FREQ_NATURE ) VALUES ( ?,?,?,?,?,?,?,TO_Date(?,'DD/MM/YYYY HH24:MI'),TO_Date( ?,'DD/MM/YYYY HH24:MI'),?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?,?,?,?)"; 
			 }
			 else{
				 InsertSQL= "INSERT INTO PH_PATIENT_EXT_DRUG_PROFILE ( PATIENT_ID, SRL_NO, FACILITY_ID,  DRUG_CODE, DRUG_DESC, START_DATE, END_DATE, INSTRUCTIONS, ADDED_BY_ID,ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ROUTE_CODE,FREQUENCY,QTY_DESC,DOSAGE_TYPE,QTY_VALUE,FREQ_NATURE) VALUES ( ?,?,?,?,?,TO_Date(?,'DD/MM/YYYY HH24:MI'),TO_Date( ?,'DD/MM/YYYY HH24:MI'),?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,?,?,?,?)";
			 }
			 //  sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue("SQL_PH_DRUG_ELIGIBLE_TERM_CODE_INSERT") );
			 sqlMap.put( "InsertSQL",InsertSQL);
			 
			 //System.err.println("sqlMap------>"+sqlMap);

			try {
	/*			InitialContext context = new InitialContext() ;
				Object object = context.lookup( CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER") ) ;

				home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
				remote = home.create() ;
				map = remote.insert( tabData, sqlMap ) ;*/

				Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
				Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]=new Object[2];
				argArray[0]=tabData;
				argArray[1]=sqlMap;

				Class[] paramArray=new Class[2];
				paramArray[0]=tabData.getClass();
				paramArray[1]=sqlMap.getClass();

				map=(HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				if( ((Boolean) map.get( "result" )).booleanValue() )
					map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
				else{
					if( ((String)map.get( "msgid" )).equals("CODE_ALREADY_EXISTS" ) )
						map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common") ) ;
					else
						map.put( "message", (map.get("msgid"))) ;
				}
			}
			catch(Exception e) {
				System.err.println( "Error Calling EJB : "+e ) ;
				map.put( "message", e.getMessage()) ;
				e.printStackTrace() ;
			}
		}
		catch(Exception e){
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", "exp :"+e.getMessage()) ;
			e.printStackTrace() ;
		}
		finally{
			try{
					closeConnection( connection );
				}
				catch(Exception es){
					es.printStackTrace();
				}		
		}
		return map ;
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
			str_qry			= PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_FT_SELECT25");
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
	public ArrayList getSlidingScaleTemplateDetails(String Order_Id,String Order_line_num,String ReqDb,String enc_id1){//Added  String ReqDb,String enc_id1 for MMS-DM-CRF-115.4
		Connection connection			= null;
        PreparedStatement pstmt			= null;      		
		ResultSet resultSet				= null;
		ArrayList slidingScaleDetails	= new ArrayList();	
		String remarks = "";
		String sql     ="";//Added for MMS-DM-CRF-115.4
		try {
            connection	= getConnection() ;
			sql         = "select ph_get_dosage_display ##REQDB## (?,?,?,?,?) DOSAGE_DTLS from dual" ;

			sql=sql.replaceAll("##REQDB##",ReqDb); //Added   for MMS-DM-CRF-115.4

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
	
	
	public String getTransacrionReason(String amend_reason_code, String trn_type,String ReqDb,String enc_id1){ // This method Added for ML-BRU-SCF-0098 [IN031837] 
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String locale	= getLanguageId();
		String trn_reason = "";
		String Sql  ="";//Added for MMS-DM-CRF-115.4
		
		try{
			connection	= getConnection() ;
			Sql         = "SELECT REASON_DESC FROM PH_MEDN_TRN_REASON_LANG ##REQDB##  WHERE REASON_CODE=?  AND APPL_TRN_TYPE=? AND LANGUAGE_ID=?";//Added for MMS-DM-CRF-115.4

			Sql=Sql.replaceAll("##REQDB##",ReqDb);//Added for MMS-DM-CRF-115.4

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

	public ArrayList getMedicalItem(String patientid, String item_code, String date_from, String date_to,String from,String to,String ReqDb,String enc_id1){//Added for Medical Tab //Added String ReqDb,String enc_id1 for MMS-DM-CRF-115.4
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;      
		int query_result_size		= 14;
		String prevnextlink			= "";
		int start = 0 ;
		int end = 0 ;
		long count=0;
		long i = 0;
		ArrayList	records		=	new ArrayList();
		String sbSql1 =""; //Added for MMS-DM-CRF-115.4
		try{
			connection	= getConnection() ;
			if ( from == null || from.equals(""))
				start = 1 ;
			else
				start = Integer.parseInt( from  ) ;

			if ( to == null || to.equals(""))
				end =query_result_size;
			else
				end = Integer.parseInt( to ) ; 
			StringBuffer sbSQL = new StringBuffer();

			sbSQL.append("SELECT b.added_date dt_ord_date, TO_CHAR (b.added_date,'DD/MM/YYYY HH24:MI') ord_date, TO_CHAR(b.added_date,'DD/MM/YYYY HH24:MI') disp_date, b.item_code, (SELECT DRUG_DESC FROM ph_drug_lang_vw ##REQDB## WHERE language_id = ? AND item_code = b.item_code) item_name, b.item_qty order_qty, b.item_qty disp_qty, (SELECT uo.short_desc FROM mm_item ##REQDB## itm  , am_uom_lang_vw ##REQDB## uo WHERE itm.item_code = b.item_code and itm.gen_uom_code = uo.UOM_CODE and UO.LANGUAGE_ID=? ) order_uom_desc, 'Dispensed - Complete' status_desc, (SELECT appl_user_name FROM sm_appl_user_lang_vw ##REQDB## WHERE language_id = ? AND appl_user_id = b.added_by_id) ordered_practitioner, (SELECT facility_name FROM sm_facility_param_lang_vw ##REQDB## WHERE language_id = ? AND facility_id = a.facility_id) || '- Dispense Location /' || (SELECT short_desc FROM ph_disp_locn_lang_vw ##REQDB## WHERE language_id = ? AND facility_id = a.facility_id AND disp_locn_code = a.store_code) ordering_details, decode(SAL_TRN_TYPE, 'I', 'IP', 'D','IP', 'O', 'OP','E', 'OP', 'X', 'XT') patient_class, '' order_id, 0 order_line_num, (SELECT short_desc FROM ph_disp_locn_lang_vw ##REQDB## WHERE language_id = ? AND facility_id = a.facility_id AND disp_locn_code = a.store_code) disp_locn FROM st_sal_hdr ##REQDB## a, st_sal_dtl ##REQDB## b WHERE a.facility_id = b.facility_id AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND b.item_code IN (SELECT item_code FROM ph_drug ##REQDB## WHERE drug_yn = 'N') AND a.module_id = 'PH' AND NOT EXISTS ((SELECT 'Y' FROM ph_disp_hdr ##REQDB##  c, ph_disp_dtl ##REQDB## d WHERE c.patient_id = a.patient_id AND c.doc_type = a.doc_type_code AND c.doc_no = a.doc_no AND c.facility_id = a.facility_id and c.disp_no = D.disp_no and B.DOC_SRL_NO = D.DOC_SRL_NO AND c.DISP_TRN_SEQ_NO||c.disp_no not IN (SELECT DISP_TRN_SEQ_NO||disp_no FROM ph_disp_cons_dtl ##REQDB## )) UNION (SELECT 'Y' FROM ph_disp_hdr_tmp ##REQDB## c, ph_disp_dtl_tmp ##REQDB## d WHERE c.patient_id = a.patient_id AND c.doc_type = a.doc_type_code AND c.doc_no = a.doc_no AND c.facility_id = a.facility_id and c.disp_tmp_no = d.disp_tmp_no  and B.DOC_SRL_NO = D.DOC_SRL_NO AND c.disp_trn_seq_no||c.disp_tmp_no not IN (SELECT disp_trn_seq_no||disp_no FROM ph_disp_cons_dtl ##REQDB## ))) AND patient_id = ? ");
			if(!ReqDb.equals(""))//Added for MMS-DM-CRF-115.4
				sbSQL.append(" AND  encounter_id = ? ");
			if(!item_code.equals(""))
				sbSQL.append(" AND B.item_code=? ");
			if(!date_from.equals("") && !date_to.equals(""))
				sbSQL.append(" AND trunc(b.added_date) between TO_DATE(?,'DD/MM/YYYY') and TO_DATE(?,'DD/MM/YYYY')");
			else if(!date_from.equals(""))
				sbSQL.append(" AND trunc(b.added_date) >= TO_DATE(?,'DD/MM/YYYY') ");
			else if(!date_to.equals(""))
				sbSQL.append(" AND  trunc(b.added_date) <= TO_DATE(?,'DD/MM/YYYY')");

			sbSQL.append(" UNION SELECT b.ord_date_time dt_ord_date, TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') ord_date, TO_CHAR(a.ord_date_time,'DD/MM/YYYY HH24:MI') disp_date, b.order_catalog_code, (SELECT drug_desc FROM ph_drug_lang_vw ##REQDB## WHERE language_id = ? AND drug_code = b.order_catalog_code) item_name, b.order_qty, pdp.tot_issued_qty disp_qty,uo.short_desc order_uom_desc, (SELECT short_desc FROM or_order_status_code_lang_vw ##REQDB## WHERE language_id = ? AND order_status_code = b.order_line_status) status_desc, (SELECT practitioner_name  FROM am_practitioner_lang_vw ##REQDB##  WHERE language_id = ? AND practitioner_id = a.ord_pract_id) ordered_practitioner, (SELECT facility_name FROM sm_facility_param_lang_vw ##REQDB## WHERE language_id = ? AND facility_id = a.ordering_facility_id) || DECODE (a.source_type, 'N', (SELECT '- Nursing Unit/' || short_desc FROM ip_nursing_unit_lang_vw ##REQDB## WHERE language_id = ? AND facility_id = a.ordering_facility_id AND nursing_unit_code = a.source_code), 'C', (SELECT '- Clinic/' || short_desc FROM op_clinic_lang_vw ##REQDB## WHERE language_id = ? AND facility_id = a.ordering_facility_id AND clinic_code = a.source_code), 'D', (SELECT '- Day Care/' || short_desc FROM ip_nursing_unit_lang_vw ##REQDB## WHERE language_id = ? AND facility_id = a.ordering_facility_id AND nursing_unit_code = a.source_code), 'E', (SELECT '- Emergency/' || short_desc FROM op_clinic_lang_vw ##REQDB## WHERE language_id = ? AND facility_id = a.ordering_facility_id AND clinic_code = a.source_code) ) || '/' || a.order_id ordering_details, a.patient_class, b.order_id, b.order_line_num, '' disp_locn FROM  or_order ##REQDB## a, or_order_line ##REQDB## b,ph_patient_drug_profile ##REQDB## pdp, am_uom_lang_vw ##REQDB## uo WHERE b.order_id = a.order_id AND b.order_id = pdp.orig_order_id AND b.order_line_num = pdp.orig_order_line_no AND a.ordering_facility_id = pdp.orig_facility_id and uo.uom_code = b.order_uom and uo.language_id=? AND order_catalog_code IN (SELECT drug_code FROM ph_drug ##REQDB## WHERE drug_yn = 'N') AND b.order_category = 'PH' AND a.patient_id =?");
		    
			if(!item_code.equals(""))
				sbSQL.append(" AND B.order_catalog_code=? ");
			if(!date_from.equals("") && !date_to.equals(""))
				sbSQL.append(" AND trunc(b.ord_date_time) between TO_DATE(?,'DD/MM/YYYY') and TO_DATE(?,'DD/MM/YYYY')");
			else if(!date_from.equals(""))
				sbSQL.append(" AND trunc(b.ord_date_time) >= TO_DATE(?,'DD/MM/YYYY') ");
			else if(!date_to.equals(""))
				sbSQL.append(" AND  trunc(b.ord_date_time) <= TO_DATE(?,'DD/MM/YYYY')");
			 if(!ReqDb.equals(""))
				sbSQL.append(" AND  a.encounter_id = ? ");

			sbSQL.append(" ORDER BY 1 DESC");

			sbSql1 =sbSQL.toString();//Added for MMS-DM-CRF-115.4
			sbSql1=sbSql1.replaceAll("##REQDB##",ReqDb);//Added for MMS-DM-CRF-115.4

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
			if(!ReqDb.equals(""))
				 pstmt.setString(++pcount,enc_id1); 
			if(!item_code.equals(""))
				pstmt.setString(++pcount,item_code); 
			if(!date_from.equals("") )
				pstmt.setString(++pcount,date_from); 
			if(!date_to.equals(""))
				pstmt.setString(++pcount,date_to); 

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
			if(!item_code.equals(""))
				pstmt.setString(++pcount,item_code); 
			if(!date_from.equals("") )
				pstmt.setString(++pcount,date_from); 
			if(!date_to.equals(""))
				pstmt.setString(++pcount,date_to); 
			if(!ReqDb.equals(""))
				 pstmt.setString(++pcount,enc_id1); 

			resultSet	= pstmt.executeQuery(); 

			records.add("link");
			while (resultSet !=null && resultSet.next() && i <= end+1){	
				if( start != 1 && (i+1) < start ) {
					i++;
					continue;
				}
				else i++;
				count++ ;
				if(i <= end ) { 
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
				}
			}
			if( start != 1 )
				prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start-query_result_size)+"','"+(end-query_result_size)+"','"+(patientid)+"')\">Previous&nbsp;&nbsp;</a>" ;
			if( count > 14 )
				prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start+query_result_size)+"','"+(end+query_result_size)+"','"+(patientid)+"')\">Next</a>" ;
			records.set(0,prevnextlink);   
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
			sql_str				= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT53");
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
			sql_str				= PhRepository.getPhKeyValue("SQL_PH_RETURNMEDICATION_SELECT");
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
			sql_str				= PhRepository.getPhKeyValue("SQL_PH_REISSUEMEDICATION_SELECT");
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
			String stSql = PhRepository.getPhKeyValue("SQL_PH_DISC_CANCELLED_DRUG_DTL_SELECT");
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
	
	public HashMap getDrugdetails(String drug_code){
		System.out.println("drug_dode"+drug_code);
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
				detailsMap.put("STRENGTH_UOM_DESC",getUomDisplay(login_facility_id,checkForNull(resultSet.getString("STRENGTH_UOM"))));
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
			pstmt1				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT65")) ;
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
			pstmt		= connection.prepareStatement("SELECT a.short_desc, a.uom_code, b.dflt_uom_yn qty_uom_yn FROM am_uom_lang_vw a, ph_uom_for_form b WHERE a.uom_code = b.uom_code AND b.form_code = ? AND a.qty_uom_yn = 'Y' AND a.language_id = ? UNION SELECT (select b.short_desc from am_uom_lang_vw b where b.uom_code=a.uom_code and b.language_id=?) short_desc, c.uom_code, c.dflt_uom_yn FROM am_uom_eqvl a, ph_uom_for_form c WHERE a.uom_code IN (SELECT uom_code FROM ph_uom_for_form WHERE form_code = ?) AND a.eqvl_uom_code IN (SELECT uom_code FROM ph_uom_for_form WHERE form_code = ?) AND c.uom_code = a.uom_code AND c.form_code = ? UNION SELECT (select b.short_desc from am_uom_lang_vw b where b.uom_code=a.eqvl_uom_code and b.language_id=?) short_desc , c.uom_code, c.dflt_uom_yn FROM am_uom_eqvl a, ph_uom_for_form c WHERE a.uom_code IN (SELECT uom_code FROM ph_uom_for_form WHERE form_code = ?) AND a.eqvl_uom_code IN (SELECT uom_code FROM ph_uom_for_form WHERE form_code = ?) AND c.uom_code = a.eqvl_uom_code AND c.form_code = ?" ) ;//added for performance issue MMS
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
				qty_values.add(getUomDisplay(login_facility_id,checkForNull(resultSet.getString("STRENGTH_UOM"))));
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
//SKR-SCF-1370
		public String getMFRfluidRemarks(String orderId,String orderLineNum){
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		String fluidRemark="";
		try{
			connection=getConnection();
			pstmt=connection.prepareStatement("SELECT MFR_REMARKS FROM OR_ORDER_LINE_PH WHERE ORDER_ID=? AND ORDER_LINE_NUM=?");
			pstmt.setString(1,orderId);
			pstmt.setString(2,orderLineNum);
			resultSet=pstmt.executeQuery();
			if(resultSet.next()){
				fluidRemark=resultSet.getString("MFR_REMARKS")==null?"":resultSet.getString("MFR_REMARKS");
			}			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				closeResultSet( resultSet) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return fluidRemark;
	}

//Adding start for NM-JD-CRF-0126
	public String getPreAllocationYN(String facility_id){
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		String pre_alloc_yn="";
		try{
			connection=getConnection();
			pstmt=connection.prepareStatement("SELECT PRE_ALLOC_APPL FROM PH_FACILITY_PARAM WHERE FACILITY_ID=?");
			pstmt.setString(1,facility_id);
			resultSet=pstmt.executeQuery();
			if(resultSet.next()){
				pre_alloc_yn=resultSet.getString("PRE_ALLOC_APPL")==null?"":resultSet.getString("PRE_ALLOC_APPL");
			}			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				closeResultSet( resultSet) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return pre_alloc_yn;
	}//Adding end for JD-CRF-0220
	//added for jd-crf-0220
	public String getdrugIntaractions(String orig_order_id,String orig_order_line_no,String patient_id,String srl_no,String ReqDb,String enc_id1){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String Sql              =   "";
		String drug_indication="";
		try{
			connection	= getConnection() ;

			Sql         = "SELECT DRUG_INDICATION FROM OR_ORDER_LINE_PH ##REQDB## OLPH  WHERE  OLPH.order_id= ? and OLPH.ORDER_LINE_NUM=?";
			Sql=Sql.replaceAll("##REQDB##",ReqDb);

			System.err.println("Sql@@@@===="+Sql+"ReqDb==="+ReqDb);


			pstmt		= connection.prepareStatement( Sql );
			
			pstmt.setString(1,orig_order_id);
			pstmt.setString(2,orig_order_line_no);
			
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				drug_indication=checkForNull(resultSet.getString("DRUG_INDICATION"));
					
					
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
		return drug_indication;	
	}

}
