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
import java.util.* ;
import java.sql.* ;
import ePH.Common.* ;
import eCommon.Common.* ;	    
import javax.servlet.* ;
import javax.servlet.http.*;
import java.text.SimpleDateFormat; //Added for MOHE-CRF-0167

public class WardReturnBean extends PhAdapter implements Serializable {
	protected String user_name				= "";
	protected String password				= "";
	protected String st_doc_type			= "";
	protected String curr_date				= "";
	protected String encounter_id			= "";
	protected String disp_locn_code			= "";
	protected String disp_cash_coll_stage	= "";
	protected String token_series_code		= "";
	protected String issue_uom_by			= "";
	protected String ToStoreCode			= "";
	protected String orderingfacilityid		= "";
	private Hashtable recordSet				= new Hashtable();
	protected ArrayList RetdocList	        =	new ArrayList();
	protected String getTradeName_Flag		= ""; 	// Added for AMS-SCF-0190 IN038440
	HashMap tabData	=	new HashMap();
	ArrayList scannedBatch  = new ArrayList(); // Added for GHL-CRF-0413.8 - Satrt
	HashMap scanned = new HashMap(); // Added for GHL-CRF-0413.8
	public HashMap getscannedDetails(){
		return scanned;
	}
	public HashMap setscannedDetails(HashMap scanned){
		return this.scanned=scanned;
	} // Added for GHL-CRF-0413.8  - End
	public ArrayList getScannedBatchDetails(){
		return scannedBatch;
	}
	public ArrayList setScannedBatchDetails(ArrayList scannedBatch){
		return this.scannedBatch=scannedBatch;
	} // Added for GHL-CRF-0413.8  - End
	//Added  for GHL-CRF-0412 start
	public String disp_locn_value;

	public String getDisp_locn_value() {
		return disp_locn_value;
	}

	public void setDisp_locn_value(String disp_locn_value) {
		this.disp_locn_value = disp_locn_value;
	}
	public String disp_locn;

	public String getDisp_locn() {
		return disp_locn;
	}

	public void setDisp_locn(String disp_locn) {
		this.disp_locn = disp_locn;
	}
	//Added  for GHL-CRF-0412 end

	public WardReturnBean(){
		//Constructor
		try{
			doCommon() ;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/* Over-ridden Adapter methods start here */
	private void doCommon() throws Exception {
	}

	public void clear(){
		super.clear() ;
		this.disp_locn_code	= "";
		this.encounter_id	= "";
		if(this.recordSet !=null)
			recordSet.clear();
	}

	/* Over-ridden Adapter methods endS here */
	/* Function specific methods start */


	public String getLoggedInFacility(){
		return login_facility_id;
	}
	
	private String getStockDocType() {
		return this.st_doc_type;
	}

	private void setCurrDate(String curr_date) {
		this.curr_date	=	curr_date;
	}

	private void setEncounter(String encounter_id) {
		this.encounter_id	=	encounter_id;
	}

	private String getEncounter() {
		return this.encounter_id;
	}

	private String getCurrDate() {
		return this.curr_date;
	}

	public void setDispLocnCode(String displocncode){
			this.disp_locn_code=displocncode;
	}
	public String getDispLocnCode(){
			return disp_locn_code;
	}
	public void setDispCashCollStage(String disp_cash_coll_stage){
		this.disp_cash_coll_stage = disp_cash_coll_stage;
	}
	public String getDispCashCollStage(){
		return 	disp_cash_coll_stage;
	}
	public void setTokenSeriesCode(String token_series_code){
		this.token_series_code = token_series_code;
	}
	public String getTokenSeriesCode(){
		return 	token_series_code;
	}
    public void setToStoreCode(String ToStoreCode){
		this.ToStoreCode = ToStoreCode;
	}
	public String getToStoreCode(){
		return 	ToStoreCode;
	}
	public void setOrderingFacilityID(String orderingfacilityid) {
		this.orderingfacilityid	=	orderingfacilityid;
	}

	public String getOrderingFacilityID() {
		return this.orderingfacilityid;
	}
	
   public ArrayList getRetdocList() {
		return this.RetdocList;
	}

	public void setRetdocList( ArrayList RetdocList){
		this.RetdocList = RetdocList;
	}

	// Added for AMS-SCF-0190 IN038440- start
	public void setTradeName_Flag(String TradeName_Flag){
		this.getTradeName_Flag=TradeName_Flag;
	}
	
	public String getTradeName_Flag(){
		return this.getTradeName_Flag;
	}
	// Added for AMS-SCF-0190 IN038440- start
	public void setAll( Hashtable recordSet ) {
		/* This function also is called by the controller when apply is pressed 
		recordSet is nothing but a hashtable containing all form values
		
		*/
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;
		this.recordSet = recordSet;
	}

	public ArrayList getDispLocn(String Category,String locale){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
	    ArrayList result=new ArrayList();
		StringBuffer sql						 = new StringBuffer();
	  
        try {
            connection = getConnection() ;
			//	To get the dispense locations associated with the user
			sql.append(PhRepository.getPhKeyValue("SQL_PH_RET_MEDN_SELECT2"));
			if (Category.equals("I")){
				sql.append(" AND a.ip_allow_drug_return_yn='Y'");
			}
			else if (Category.equals("O")){
				sql.append(" AND a.allow_drug_return_yn='Y'");
			}
			pstmt= connection.prepareStatement(  sql.toString()) ;
			pstmt.setString(1,Category);
			pstmt.setString(2,login_facility_id);
			pstmt.setString(3,login_by_id.trim());
			pstmt.setString(4,login_at_ws_no.trim());
			pstmt.setString(5,locale);

            resultSet = pstmt.executeQuery() ;
            while ( resultSet.next() ) {
				result.add(resultSet.getString("DISP_LOCN_CODE"));
				result.add(resultSet.getString("SHORT_DESC"));
			}
		}
		catch ( Exception e ) {
			result.add(e.toString());
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
		return result;
	}

	public ArrayList getWardResult(String patientid,String StoreCode,String facility_id,String locale){
	  Connection connection			 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet				 =		null ;
		ArrayList wardResult =		new ArrayList();
		
		try {
			connection	 = getConnection() ;
			//pstmt			 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TERM_SET_SELECT1" )) ;
			pstmt			 = connection.prepareStatement("SELECT d.DRUG_DESC DRUG_DESC, BATCH_ID, A.DISP_NO DISP_NO, EXPIRY_DATE,A.RET_TO_DISP_LOCN_CODE, TO_CHAR (A.DISP_DATE_TIME,'dd/mm/yyyy ') DISP_DATE_TIME, STORE_ACKNOWLEDGE_STATUS,ACKNOWLEDGE_REASON ,b.RETURNED_QTY, RETURN_UOM_CODE,E.SHORT_DESC FROM PH_WARD_RETURN_HDR A,PH_WARD_RETURN_DTL B,PH_DISP_DRUG_BATCH C,PH_DRUG_LANG_VW D,PH_DISP_LOCN_LANG_VW E WHERE A.FACILITY_ID = B.FACILITY_ID AND A.RET_DOC_NO = B.RET_DOC_NO AND C.DISP_NO = B.DISP_NO AND C.SRL_NO = B.SRL_NO AND C.SRL_NO_BATCH = B.SRL_NO_BATCH AND D.DRUG_CODE = B.ITEM_CODE AND E.DISP_LOCN_CODE = A.RET_TO_DISP_LOCN_CODE AND A.FACILITY_ID = ? AND A.RET_TO_DISP_LOCN_CODE = ? AND C.FACILITY_ID = ? AND A.PATIENT_ID = ? AND D.LANGUAGE_ID = ? AND E.LANGUAGE_ID = ? AND NVL(b.STORE_ACKNOWLEDGE_STATUS,'$') <> 'C' and exists (select 'X' from ip_open_encounter where facility_id = a.facility_id and encounter_id = a.encounter_id) ORDER BY A.DISP_DATE_TIME") ; //Added "and exists (select 'X' from ip_open_encounter where facility_id = a.facility_id and encounter_id = a.encounter_id)" to display drugs only from current encounter IN032455 // AND EXISTS ( SELECT 'X' FROM ip_open_encounter WHERE facility_id = a.facility_id AND encounter_id = a.encounter_id) condition removed for KDAH-SCF-0402 reverted fix of KDAH-SCF-402 for KDAH-SCF-419 // AND NVL(b.STORE_ACKNOWLEDGE_STATUS,'$') <> 'C' Added for KDAH-SCF-0448
			
			pstmt.setString(1,facility_id.trim());
			pstmt.setString(2,StoreCode.trim());
			pstmt.setString(3,facility_id.trim());
			pstmt.setString(4,patientid.trim());
			pstmt.setString(5,locale);
			pstmt.setString(6,locale);
			
			resultSet      = pstmt.executeQuery() ;

			while (resultSet.next()) {
				HashMap rec		=	new HashMap();
				
				//rec.put("ADDED_DATE",resultSet.getString("ADDED_DATE"));
				rec.put("DRUG_DESC",resultSet.getString("DRUG_DESC"));
				rec.put("BATCH_ID",resultSet.getString("BATCH_ID"));
				rec.put("DISP_NO",resultSet.getString("DISP_NO"));
				rec.put("EXPIRY_DATE",resultSet.getString("EXPIRY_DATE"));
				rec.put("RET_TO_DISP_LOCN_CODE",resultSet.getString("RET_TO_DISP_LOCN_CODE"));
				rec.put("DISP_DATE_TIME",resultSet.getString("DISP_DATE_TIME"));
				rec.put("STORE_ACKNOWLEDGE_STATUS",resultSet.getString("STORE_ACKNOWLEDGE_STATUS"));
				rec.put("ACKNOWLEDGE_REASON",resultSet.getString("ACKNOWLEDGE_REASON"));
				rec.put("RETURNED_QTY",resultSet.getString("RETURNED_QTY"));
				rec.put("RETURN_UOM_CODE",resultSet.getString("RETURN_UOM_CODE"));
				rec.put("SHORT_DESC",resultSet.getString("SHORT_DESC"));
				wardResult.add(rec);
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
		return wardResult;
	}

	public ArrayList getDrugDetails(String patientid,String drugcode,String nationalid,String healthcard,String dispno,String cutoff,String orderid,String displocn,String locale){
         
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		  String ackWC="";//Added for GHL-CRF-0399
		 ArrayList result=new ArrayList();
		 String ack_required = checkToProceed(login_facility_id.trim());//added for mms-kh-crf-0014
        try {
            connection = getConnection() ;
			
			//Added for GHL-CRF-0399 start 
			//boolean siteAck = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","WARD_ACK"); //Commented for common-icn-0048
			if(ack_required.equals("Y")){//added for MMS-KH-CRF-0014
					ackWC="and f.ward_acknowledge = 'A'";
				}
				//Added for GHL-CRF-0399 end
			int cnt=1;

			//  String sql=" SELECT DISTINCT disp_drug_code, d.drug_desc FROM (SELECT drug_desc drug_desc, drug_code drug_code ,content_in_pres_base_uom content_in_pres_base_uom  FROM ph_drug_lang_vw WHERE language_id = ? UNION SELECT NVL (short_name, long_name) drug_desc,tpn_regimen_code drug_code,nvl(content_in_base_unit,1) content_in_pres_base_uom FROM ph_tpn_regimen_lang_vw   WHERE standard_regimen_yn = 'Y' and language_id = ?) d,ph_disp_dtl a, ph_disp_hdr b,   mp_patient c ,or_order   e WHERE a.facility_id = b.facility_id AND a.disp_no = b.disp_no  AND c.patient_id = b.patient_id and e.order_id =b.order_id 	and e.ORDERING_FACILITY_ID =? AND b.patient_id = ? AND a.added_date >=  TO_DATE (?, 'dd/mm/yyyy hh24:mi')  AND a.disp_drug_code = d.drug_code AND a.facility_id = ? AND b.order_id = NVL (?, b.order_id) AND a.disp_no = NVL (?, a.disp_no) AND a.disp_drug_code = NVL (?, a.disp_drug_code)AND a.disp_locn_code = NVL (?, a.disp_locn_code) AND a.disp_qty <> NVL (a.returned_qty, 0) AND a.DISP_QTY > Ceil(NVL((select TOT_ADMINISTERED_QTY from ph_patient_drug_profile where patient_id = b.patient_id and orig_order_id = a.order_id and orig_order_line_no =a.order_line_no),0)/D.CONTENT_IN_PRES_BASE_UOM)  AND EXISTS (  SELECT * FROM ph_disp_drug_batch WHERE SYSDATE < expiry_date AND disp_no = a.disp_no AND facility_id = a.facility_id AND srl_no = a.srl_no)";

			//String sql=" SELECT DISTINCT disp_drug_code, d.drug_desc FROM (SELECT drug_desc drug_desc, drug_code drug_code ,content_in_pres_base_uom content_in_pres_base_uom  FROM ph_drug_lang_vw WHERE language_id = ? UNION SELECT NVL (short_name, long_name) drug_desc,tpn_regimen_code drug_code,nvl(content_in_base_unit,1) content_in_pres_base_uom FROM ph_tpn_regimen_lang_vw   WHERE standard_regimen_yn = 'Y' and language_id = ?) d,ph_disp_dtl a, ph_disp_hdr b,   mp_patient c ,or_order   e WHERE a.facility_id = b.facility_id AND a.disp_no = b.disp_no  AND c.patient_id = b.patient_id and e.order_id =b.order_id and NVL(e.iv_prep_yn,'X') not in('2','4','6','8','0') and e.ORDERING_FACILITY_ID =? AND b.patient_id = ? AND a.added_date >=  TO_DATE (?, 'dd/mm/yyyy hh24:mi')  AND a.disp_drug_code = d.drug_code AND a.facility_id = ? AND b.order_id = NVL (?, b.order_id) AND a.disp_no LIKE NVL(?, a.disp_no) AND a.disp_drug_code = NVL (?, a.disp_drug_code)AND a.disp_locn_code = NVL (?, a.disp_locn_code) AND e.PATIENT_CLASS = NVL ('IP', e.PATIENT_CLASS) AND a.disp_qty <> NVL (a.returned_qty, 0) AND a.DISP_QTY > Ceil(NVL((select TOT_ADMINISTERED_QTY from ph_patient_drug_profile where patient_id = b.patient_id and orig_order_id = a.order_id and orig_order_line_no =a.order_line_no),0)/D.CONTENT_IN_PRES_BASE_UOM)  AND EXISTS (  (  SELECT * FROM ph_disp_drug_batch X, ST_ITEM Y  WHERE disp_no = a.disp_no  AND (( USE_AFTER_EXPIRY_YN ='N' and SYSDATE < expiry_date) or  (USE_AFTER_EXPIRY_YN ='Y') ) AND X.ITEM_CODE =Y.ITEM_CODE  AND facility_id = a.facility_id   AND srl_no = a.srl_no))";
			//String sql=" SELECT DISTINCT disp_drug_code, d.drug_desc,(select SHORT_NAME from am_trade_name_lang_vw where trade_id=f.trade_id and language_id=?) SHORT_NAME FROM (SELECT drug_desc drug_desc, drug_code drug_code ,content_in_pres_base_uom content_in_pres_base_uom  FROM ph_drug_lang_vw WHERE language_id = ? UNION SELECT NVL (short_name, long_name) drug_desc,tpn_regimen_code drug_code,nvl(content_in_base_unit,1) content_in_pres_base_uom FROM ph_tpn_regimen_lang_vw   WHERE standard_regimen_yn = 'Y' and language_id = ?) d,ph_disp_dtl a, ph_disp_hdr b,   mp_patient c ,or_order   e, ph_disp_drug_batch F WHERE a.facility_id = b.facility_id AND a.disp_no = b.disp_no  AND c.patient_id = b.patient_id and e.order_id =b.order_id and NVL(e.iv_prep_yn,'X') not in('2','4','6','8','0') and e.ORDERING_FACILITY_ID =? AND b.patient_id = ? AND a.added_date >=  TO_DATE (?, 'dd/mm/yyyy hh24:mi')  AND a.disp_drug_code = d.drug_code AND a.facility_id = ? AND b.order_id = NVL (?, b.order_id) AND a.disp_no LIKE NVL(?, a.disp_no) AND a.disp_drug_code = NVL (?, a.disp_drug_code)AND a.disp_locn_code = NVL (?, a.disp_locn_code) AND e.PATIENT_CLASS = NVL ('IP', e.PATIENT_CLASS) AND a.disp_qty <> NVL (a.returned_qty, 0) AND (select sum (disp_qty) from ph_disp_dtl where  order_id = a.order_id   AND order_line_no = a.order_line_no) > Ceil(NVL((select TOT_ADMINISTERED_QTY from ph_patient_drug_profile where patient_id = b.patient_id and orig_order_id = a.order_id and orig_order_line_no =a.order_line_no),0)/D.CONTENT_IN_PRES_BASE_UOM)  and (a.disp_qty - nvl((select sum(RETURNED_QTY) tot_ward_ret_qty from ph_ward_return_dtl  where DISP_NO=a.disp_no and  SRL_NO=a.srl_no  ),0 ))>0 AND EXISTS (  (  SELECT * FROM ph_disp_drug_batch X, ST_ITEM Y  WHERE disp_no = a.disp_no  AND (( USE_AFTER_EXPIRY_YN ='N' and SYSDATE < expiry_date) or  (USE_AFTER_EXPIRY_YN ='Y') ) AND X.ITEM_CODE =Y.ITEM_CODE  AND facility_id = a.facility_id   AND srl_no = a.srl_no)) and exists (select 'X' from ip_open_encounter where facility_id = b.facility_id and encounter_id = b.encounter_id) AND f.facility_id=a.facility_id AND f.DISP_LOCN_CODE=a.disp_locn_code AND f.disp_no=a.disp_no AND f.srl_no=a.srl_no ORDER BY d.drug_desc";//commented for performance tunning GHL-SCF-1084
		
		//c.patient_id = b.patient_id,mp_patient c, is removed for AMRI-SCF-519//a.disp_qty changed to F.disp_qty modified for ml-bru-scf-1880//MODIFIED FOR DGB ISSUE 
			String sql="SELECT DISTINCT disp_drug_code, d.drug_desc, (SELECT short_name FROM am_trade_name_lang_vw WHERE trade_id = f.trade_id AND language_id = ?) short_name,a.disp_locn_code,(SELECT short_desc FROM ph_disp_locn_lang_vw WHERE disp_locn_code = a.disp_locn_code AND language_id = ? AND a.facility_id = b.facility_id) location  FROM (SELECT drug_desc drug_desc, drug_code drug_code, content_in_pres_base_uom content_in_pres_base_uom FROM ph_drug_lang_vw WHERE drug_code BETWEEN NVL ('', '%%') AND NVL ('', drug_code ) AND language_id = ? UNION SELECT NVL (short_name, long_name) drug_desc, tpn_regimen_code drug_code, NVL (content_in_base_unit, 1) content_in_pres_base_uom FROM ph_tpn_regimen_lang_vw WHERE standard_regimen_yn = 'Y' AND tpn_regimen_code BETWEEN NVL ('', '%%') AND NVL ('', tpn_regimen_code) AND language_id = ?) d, ph_disp_dtl a, ph_disp_hdr b, or_order e, ph_disp_drug_batch f WHERE a.facility_id = b.facility_id AND a.disp_no = b.disp_no  AND e.order_id = b.order_id AND NVL (e.iv_prep_yn, 'X') NOT IN ('2', '4', '6', '8', '0') AND e.ordering_facility_id = ? AND b.patient_id = ? AND a.added_date >= TO_DATE (?, 'dd/mm/yyyy hh24:mi') AND a.disp_drug_code = d.drug_code AND a.facility_id = ? AND b.order_id = NVL (?, b.order_id) AND a.disp_no LIKE NVL (?, a.disp_no) AND a.disp_drug_code = NVL (?, a.disp_drug_code) AND a.disp_locn_code = NVL (?, a.disp_locn_code) AND e.patient_class = NVL ('IP', e.patient_class) AND f.disp_qty <> NVL (a.returned_qty, 0) AND (SELECT SUM (disp_qty) FROM ph_disp_dtl WHERE order_id = a.order_id AND order_line_no = a.order_line_no) > CEIL ( NVL ((SELECT tot_administered_qty FROM ph_patient_drug_profile WHERE patient_id = b.patient_id AND orig_order_id = a.order_id AND orig_order_line_no = a.order_line_no), 0 ) / d.content_in_pres_base_uom ) AND ( f.disp_qty - NVL ((SELECT SUM (returned_qty) tot_ward_ret_qty FROM ph_ward_return_dtl WHERE disp_no = a.disp_no AND srl_no = a.srl_no AND NVL (store_acknowledge_status, '*') <> 'C'), 0) ) > 0 AND EXISTS ( (SELECT * FROM ph_disp_drug_batch x, st_item y WHERE disp_no = a.disp_no AND ( ( use_after_expiry_yn = 'N' AND SYSDATE < expiry_date ) OR (use_after_expiry_yn = 'Y') ) AND x.item_code = y.item_code AND facility_id = a.facility_id AND srl_no = a.srl_no)) AND EXISTS ( SELECT 'X' FROM ip_open_encounter WHERE facility_id = b.facility_id AND encounter_id = b.encounter_id) AND f.facility_id = a.facility_id AND f.disp_locn_code = a.disp_locn_code AND f.disp_no = a.disp_no AND f.srl_no = a.srl_no AND b.facility_id BETWEEN NVL ('', '%%') AND NVL ('', b.facility_id )"+ackWC+" ORDER BY d.drug_desc";////added for performance tunning GHL-SCF-1084 // added acknowledgestatus for KDAH-CRF-0250 [IN:039018] ackWC added for GHL-CRF-0399 location and a.disp_locn_code  added for GHL-CRF-0412AND // a.disp_qty changed to f.disp_qty for ML-BRU-SCF-1880
		
		    pstmt = connection.prepareStatement( sql) ;
		    pstmt.setString(cnt,locale);
			pstmt.setString(++cnt,locale);//added for GHL-CRF-0412
			pstmt.setString(++cnt,locale);
			pstmt.setString(++cnt,locale);		
			pstmt.setString(++cnt,this.orderingfacilityid);
			pstmt.setString(++cnt,patientid.trim());
			pstmt.setString(++cnt,cutoff);
			pstmt.setString(++cnt,login_facility_id.trim());
			pstmt.setString(++cnt,orderid.trim());
			pstmt.setString(++cnt,dispno.trim());
			pstmt.setString(++cnt,drugcode.trim());
			pstmt.setString(++cnt,"");

            resultSet = pstmt.executeQuery() ;
		
            while ( resultSet.next() ) {
				result.add(resultSet.getString("DISP_DRUG_CODE"));
				result.add(resultSet.getString("DRUG_DESC"));
				result.add(resultSet.getString("SHORT_NAME"));
				result.add(resultSet.getString("DISP_LOCN_CODE"));//added for GHL-CRF-0412
				result.add(resultSet.getString("LOCATION"));//added for GHL-CRF-0412
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			result.add(e.toString());
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
		return result;
	}
	//IN-38440 & SCF-190 Added new function to get Flag based Trade Name display
	public String getEffectiveFlag(){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	flag	=	null ;

		try{
			String sql="select CRIT_FIELD_VAL from PH_DISP_MEDN_DFLT WHERE FUNCTION_ID=? and FACILITY_ID = DECODE(?, FACILITY_ID, FACILITY_ID,'*A')  and CRIT_FIELD_ID=?";
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(sql) ;
			
			pstmt.setString(1,"WARDRETN_RETN_MEDN");
			pstmt.setString(2,login_facility_id.trim());
			pstmt.setString(3,"DISP_TRADE_NAME");
			
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				flag	=	checkForNull(resultSet.getString("CRIT_FIELD_VAL"));
			}	
			else{
				flag="";
			}
		}
		catch(Exception e){
			flag	=e.toString();
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
		return flag;	
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
				es.printStackTrace() ;
			}
		}
		return pat_txt_length;	
	}

	public ArrayList getBinDetails(String drugcodes,String displocn,String locale){
       	    
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		HashMap records=null;
		ArrayList result=new ArrayList();
        try {
            connection = getConnection() ;
			pstmt = connection.prepareStatement("SELECT b.bin_location_code, b.short_desc,(CASE WHEN (a.item_code = c.item_code AND a.store_code = c.store_code AND a.bin_location_code = c.bin_location_code) THEN 'Y' ELSE 'N' END) default_yn  FROM st_item_store_bin_locn a, mm_bin_location_lang_vw b, st_item_store c WHERE a.item_code = ? AND a.store_code = ? AND a.eff_status = 'Y' AND a.store_code = b.store_code AND a.bin_location_code = b.bin_location_code AND a.item_code = c.item_code AND a.store_code = c.store_code AND b.language_id = ?") ;
			pstmt.setString(1,drugcodes.trim());
			pstmt.setString(2,displocn.trim());
			pstmt.setString(3,locale.trim());
            resultSet = pstmt.executeQuery() ;
            while (resultSet.next()) {
				records=new HashMap();
				records.put("bin_location_code",checkForNull(resultSet.getString("bin_location_code")));			
				records.put("short_desc",checkForNull(resultSet.getString("short_desc")));
				records.put("Default_YN",checkForNull(resultSet.getString("Default_YN")));
				result.add(records);				
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
	
		return result;
	}

	public void getTokenSeries() {
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ;        
    	token_series_code	        =   "";
		disp_cash_coll_stage        =	"";

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT73B") ) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,this.getDispLocnCode());
			pstmt.setString(3,login_at_ws_no);
			pstmt.setString(4,getLanguageId());
			resultSet	= pstmt.executeQuery();
			
			while( resultSet != null && resultSet.next() ) {
				//token_series_desc   =   checkForNull(resultSet.getString("DESCRIPTION"));
				token_series_code     =   checkForNull(resultSet.getString("TOKEN_SERIES_CODE"));
				disp_cash_coll_stage  =   checkForNull(resultSet.getString("DISP_CASH_COLL_STAGE")); // IP billing receipt stage
				setDispCashCollStage(disp_cash_coll_stage);
				if(disp_cash_coll_stage.equals("D")||disp_cash_coll_stage.equals("X")){
					token_series_code ="";
				}
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
	}

	public ArrayList getBatchDetails(String patientid,String drugcodes,String nationalid,String healthcard,String dispno,String cutoff,String orderid,String displocn,String ToStoreCode,String barcode_id){  // barcode_id added for GHL-CRF-0413.8
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		PreparedStatement pstmt1= null;
		PreparedStatement pstmt2= null;
        ResultSet resultSet1	= null;
		ResultSet resultSet2	= null;

		 ArrayList result		= new ArrayList();
		 HashMap bat_admin_qty  = new HashMap();
		 int tot_admin_qty		=	0; 
		 int returnable         =   0;
		 int admin_qty			=	0;//Added for GHL-CRF-0482
		 String doc_srl_no		=  "";
		 String trade_id		=  "";
		 String sql				=  "";
		 String ackWC="";//Added for GHL-CRF-0399
		 String iv_prep_yn		= ""; //GHL-CRF-0482
		 String ack_required = checkToProceed(login_facility_id.trim());//added for mms-kh-crf-0014
        try {	
			
			setDispLocnCode(displocn);
			getTokenSeries();
			connection = getConnection() ;
			boolean isSite_spec_patient_stock = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","PATIENT_STOCK_REQUIRED"); //added for GHL-CRF-0482
			boolean barcode_2d_applicable = eCommon.Common.CommonBean.isSiteSpecific(connection, "ST","2D_BARCODE_APPLICABLE"); //added for MOHE-CRF-0167
			//Added for GHL-CRF-0399 start 
			
			boolean siteAck = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","WARD_ACK");
			if(ack_required.equals("Y")){//siteAck modified to ack_required for mms-kh-crf-0014
					ackWC="and a.ward_acknowledge = 'A'";
				}
				//Added for GHL-CRF-0399 end

         // sql="SELECT d.drug_desc, decode(j.USE_AFTER_EXPIRY_YN,'Y','Y','N',DECODE (GREATEST (SYSDATE, expiry_date), SYSDATE, 'N', 'Y') )valid, c.doc_type, c.doc_no, a.store_code, a.item_code, a.bin_location_code,a.batch_id, TO_CHAR (a.expiry_date, 'DD/MM/YYYY') expiry_date, a.trade_id TRADE_ID, a.disp_no, a.srl_no, b.doc_srl_no, a.srl_no_batch, TO_CHAR (b.added_date, 'dd/mm/yyyy') added_date, a.disp_qty issuedqty, b.disp_uom_code qtyuom, a.disp_qty - (NVL (a.returned_qty, 0) + NVL ( (SELECT SUM (RETURNED_QTY) tot_ward_ret_qty FROM ph_ward_return_dtl WHERE DISP_NO = a.disp_no AND SRL_NO = a.srl_no AND SRL_NO_BATCH = a.srl_no_batch AND STORE_ACKNOWLEDGE_STATUS is NULL), 0) +NVL ( (SELECT SUM (REJ_QTY) FROM ph_ward_return_dtl WHERE disp_no = a.disp_no AND srl_no = a.srl_no AND SRL_NO_BATCH = a.SRL_NO_BATCH ), 0)) returnable, NVL ( a.returned_qty + NVL ( (SELECT SUM (REJ_QTY ) FROM ph_ward_return_dtl WHERE disp_no = a.disp_no AND srl_no = a.srl_no AND SRL_NO_BATCH = a.SRL_NO_BATCH ), 0), 0) RETURNEDQTY, c.encounter_id, b.order_id, b.order_line_no, b.issue_qty, b.issue_uom_code,g.short_desc disp_locn_desc,(SELECT short_desc  FROM am_uom_lang_vw WHERE uom_code = b.issue_uom_code AND language_id = ?) short_desc, (SELECT def_issue_uom def_issue_uom FROM st_item_store  WHERE eff_status = 'E'  AND item_code = a.item_code  AND store_code = ?) to_store_def_issue_uom,  c.patient_class patient_class, c.locn_code from_locn_code,t.short_name TRADE_NAME FROM (SELECT drug_desc drug_desc, drug_code drug_code, NVL (content_in_pres_base_uom, 1) content_in_pres_base_uom FROM ph_drug_lang_vw  WHERE language_id = ? UNION  SELECT NVL (short_name, long_name) drug_desc, tpn_regimen_code drug_code, NVL (content_in_base_unit, 1) content_in_pres_base_uom FROM ph_tpn_regimen_lang_vw  WHERE standard_regimen_yn = 'Y' AND language_id = ?) d, ph_disp_drug_batch a, ph_disp_dtl b, ph_disp_hdr c, mp_patient e, ph_disp_locn_lang_vw g ,st_item j,st_sal_hdr k,or_order l,am_trade_name_lang_vw t WHERE a.facility_id = b.facility_id and k.doc_no = c.doc_no and k.doc_type_code=c.doc_type and k.facility_id = c.FACILITY_ID  AND a.disp_no = b.disp_no  AND a.srl_no = b.srl_no  AND c.patient_id = e.patient_id  AND c.facility_id = b.facility_id  AND c.disp_no = b.disp_no  AND b.disp_drug_code = d.drug_code  AND e.patient_id =  ?  AND b.added_date >= TO_DATE (?, 'dd/mm/yyyy hh24:mi')  AND b.facility_id = ?  AND b.disp_no = NVL (?, a.disp_no)   AND a.disp_qty <> NVL (a.returned_qty, 0)  and a.item_code=j.item_code  AND (( j.USE_AFTER_EXPIRY_YN ='N' and SYSDATE < expiry_date) or  (j.USE_AFTER_EXPIRY_YN ='Y') )  AND a.store_code = g.disp_locn_code  AND a.facility_id = g.facility_id   AND g.language_id = ? and (a.disp_qty - nvl((select sum(RETURNED_QTY) tot_ward_ret_qty from ph_ward_return_dtl  where DISP_NO=a.disp_no and  SRL_NO=a.srl_no  and SRL_NO_BATCH=a.srl_no_batch AND NVL(store_acknowledge_status,'*') <> 'C'),0 ))>0 and l.patient_class = NVL ('IP', l.patient_class) AND NVL (l.iv_prep_yn, 'X') NOT IN ('2', '4', '6', '8', '0') AND c.order_id = l.order_id and exists (select 'X' from ip_open_encounter where facility_id = c.facility_id and encounter_id = c.encounter_id) AND a.facility_id  = t.added_facility_id(+) AND a.trade_id = t.trade_id(+) AND t.language_id(+)=? "; //Added "and exists (select 'X' from ip_open_encounter where facility_id = c.facility_id and encounter_id = c.encounter_id)" to display drugs only from current encounter IN032455. // TRADE_NAME, am_trade_name_lang_vw added for AMS-SCF-0190 IN038440. and k.FINALIZED_YN = 'Y'//Added 'AND NVL(store_acknowledge_status,'*') <> 'C'),0 )' for KDAH-CRF-0250 [IN:039018]// commented for GHL-SCF-1084 [IN:060932]
		//( ( ( use_after_expiry_yn = 'N' AND SYSDATE < expiry_date)OR (  use_after_expiry_yn = 'N' AND expiry_yn = 'N') )OR (use_after_expiry_yn = 'Y')) ADDED FOR KDAH-SCF-604
			if((!barcode_id.equals("")|| drugcodes.length()>0) && siteAck) // if else condition Added for GHL-CRF-0413.8
				sql = "SELECT d.drug_desc,DECODE (j.use_after_expiry_yn,'Y', 'Y','N', DECODE (GREATEST (SYSDATE, expiry_date),SYSDATE, 'N','Y')) valid , c.doc_type, c.doc_no, a.store_code, a.item_code, a.bin_location_code,a.batch_id, TO_CHAR (a.expiry_date, 'DD/MM/YYYY')expiry_date,a.trade_id trade_id, a.disp_no, a.srl_no, b.doc_srl_no, a.srl_no_batch,TO_CHAR (b.added_date, 'dd/mm/yyyy') added_date, a.disp_qty issuedqty,b.disp_uom_code qtyuom,a.disp_qty - ( NVL (a.returned_qty, 0) + NVL ((SELECT NVL (SUM (returned_qty), 0) tot_ward_ret_qty FROM ph_ward_return_dtl WHERE facility_id = a.facility_id AND disp_no = b.disp_no AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch AND store_acknowledge_status IS NULL), 0 ) + NVL ((SELECT SUM (rej_qty) FROM ph_ward_return_dtl WHERE facility_id = a.facility_id AND disp_no = b.disp_no AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch), 0 ) ) returnable, NVL ( a.returned_qty + NVL ((SELECT SUM (rej_qty) FROM ph_ward_return_dtl WHERE facility_id = a.facility_id AND disp_no = b.disp_no AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch), 0 ), 0 ) returnedqty, c.encounter_id, b.order_id, b.order_line_no, b.issue_qty, b.issue_uom_code, (SELECT g.short_desc FROM ph_disp_locn_lang_vw g WHERE a.store_code = g.disp_locn_code AND a.facility_id = g.facility_id AND g.language_id = ?) disp_locn_desc, (SELECT short_desc FROM am_uom_lang_vw WHERE uom_code = b.issue_uom_code AND language_id = ?) short_desc, (SELECT def_issue_uom def_issue_uom FROM st_item_store WHERE eff_status = 'E' AND item_code = a.item_code AND store_code = ?) to_store_def_issue_uom, c.patient_class patient_class, c.locn_code from_locn_code, (SELECT t.short_name FROM am_trade_name_lang_vw t WHERE a.facility_id = t.added_facility_id AND a.trade_id = t.trade_id AND t.language_id = ?) trade_name, st.barcode_id,a.DISP_QTY_UOM,iv_prep_yn FROM (SELECT drug_desc drug_desc, drug_code drug_code, NVL (content_in_pres_base_uom, 1) content_in_pres_base_uom FROM ph_drug_lang_vw WHERE language_id = ? UNION SELECT NVL (short_name, long_name) drug_desc, tpn_regimen_code drug_code, NVL (content_in_base_unit, 1) content_in_pres_base_uom FROM ph_tpn_regimen_lang_vw WHERE standard_regimen_yn = 'Y' AND language_id = ?) d, ph_disp_drug_batch a, ph_disp_dtl b, ph_disp_hdr c, st_item j, st_sal_hdr k, st_batch_control st, or_order l WHERE a.facility_id = b.facility_id AND k.doc_no = c.doc_no AND k.doc_type_code = c.doc_type AND k.facility_id = c.facility_id AND a.disp_no = b.disp_no AND a.srl_no = b.srl_no AND c.facility_id = b.facility_id AND c.disp_no = b.disp_no AND b.disp_drug_code = d.drug_code AND l.patient_id = ? AND b.added_date >= TO_DATE (?, 'dd/mm/yyyy hh24:mi') AND b.facility_id = ? AND b.disp_no = NVL (?, a.disp_no) AND a.disp_qty <> NVL (a.returned_qty, 0) AND a.item_code = j.item_code AND ( ( ( use_after_expiry_yn = 'N' AND SYSDATE < expiry_date)OR (  use_after_expiry_yn = 'N' AND expiry_yn = 'N') )OR (use_after_expiry_yn = 'Y')) AND ( a.disp_qty - NVL ((SELECT SUM (returned_qty) tot_ward_ret_qty FROM ph_ward_return_dtl WHERE facility_id = a.facility_id AND disp_no = b.disp_no AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch AND NVL (store_acknowledge_status, '*') <> 'C'), 0 ) ) > 0 AND l.patient_class = NVL ('IP', l.patient_class) AND NVL (l.iv_prep_yn, 'X') NOT IN ('2', '4', '6', '8', '0') AND c.order_id = l.order_id AND b.order_id = c.order_id and exists (select 'X' from ip_open_encounter where facility_id = c.facility_id and encounter_id = c.encounter_id) ";//and exists (select 'X' from ip_open_encounter where facility_id = c.facility_id and encounter_id = c.encounter_id) Added for KDAH-SCF-419 and a.DISP_QTY_UOM added for ML-BRU-SCF-1842 and iv_prep_yn added for GHL-CRF-0482
			else
		 sql = "SELECT d.drug_desc,DECODE (j.use_after_expiry_yn,'Y', 'Y','N', DECODE (GREATEST (SYSDATE, expiry_date),SYSDATE, 'N','Y')) valid , c.doc_type, c.doc_no, a.store_code, a.item_code, a.bin_location_code,a.batch_id, TO_CHAR (a.expiry_date, 'DD/MM/YYYY')expiry_date,a.trade_id trade_id, a.disp_no, a.srl_no, b.doc_srl_no, a.srl_no_batch,TO_CHAR (b.added_date, 'dd/mm/yyyy') added_date, a.disp_qty issuedqty,b.disp_uom_code qtyuom,a.disp_qty - ( NVL (a.returned_qty, 0) + NVL ((SELECT NVL (SUM (returned_qty), 0) tot_ward_ret_qty FROM ph_ward_return_dtl WHERE facility_id = a.facility_id AND disp_no = b.disp_no AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch AND store_acknowledge_status IS NULL), 0 ) + NVL ((SELECT SUM (rej_qty) FROM ph_ward_return_dtl WHERE facility_id = a.facility_id AND disp_no = b.disp_no AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch), 0 ) ) returnable, NVL ( a.returned_qty + NVL ((SELECT SUM (rej_qty) FROM ph_ward_return_dtl WHERE facility_id = a.facility_id AND disp_no = b.disp_no AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch), 0 ), 0 ) returnedqty, c.encounter_id, b.order_id, b.order_line_no, b.issue_qty, b.issue_uom_code, (SELECT g.short_desc FROM ph_disp_locn_lang_vw g WHERE a.store_code = g.disp_locn_code AND a.facility_id = g.facility_id AND g.language_id = ?) disp_locn_desc, (SELECT short_desc FROM am_uom_lang_vw WHERE uom_code = b.issue_uom_code AND language_id = ?) short_desc, (SELECT def_issue_uom def_issue_uom FROM st_item_store WHERE eff_status = 'E' AND item_code = a.item_code AND store_code = ?) to_store_def_issue_uom, c.patient_class patient_class, c.locn_code from_locn_code, (SELECT t.short_name FROM am_trade_name_lang_vw t WHERE a.facility_id = t.added_facility_id AND a.trade_id = t.trade_id AND t.language_id = ?) trade_name,a.DISP_QTY_UOM, iv_prep_yn FROM (SELECT drug_desc drug_desc, drug_code drug_code, NVL (content_in_pres_base_uom, 1) content_in_pres_base_uom FROM ph_drug_lang_vw WHERE language_id = ? UNION SELECT NVL (short_name, long_name) drug_desc, tpn_regimen_code drug_code, NVL (content_in_base_unit, 1) content_in_pres_base_uom FROM ph_tpn_regimen_lang_vw WHERE standard_regimen_yn = 'Y' AND language_id = ?) d, ph_disp_drug_batch a, ph_disp_dtl b, ph_disp_hdr c, st_item j, st_sal_hdr k, or_order l WHERE a.facility_id = b.facility_id AND k.doc_no = c.doc_no AND k.doc_type_code = c.doc_type AND k.facility_id = c.facility_id AND a.disp_no = b.disp_no AND a.srl_no = b.srl_no AND c.facility_id = b.facility_id AND c.disp_no = b.disp_no AND b.disp_drug_code = d.drug_code AND l.patient_id = ? AND b.added_date >= TO_DATE (?, 'dd/mm/yyyy hh24:mi') AND b.facility_id = ? AND b.disp_no = NVL (?, a.disp_no) AND a.disp_qty <> NVL (a.returned_qty, 0) AND a.item_code = j.item_code AND ( ( ( use_after_expiry_yn = 'N' AND SYSDATE < expiry_date)OR (  use_after_expiry_yn = 'N' AND expiry_yn = 'N') )OR (use_after_expiry_yn = 'Y')) AND ( a.disp_qty - NVL ((SELECT SUM (returned_qty) tot_ward_ret_qty FROM ph_ward_return_dtl WHERE facility_id = a.facility_id AND disp_no = b.disp_no AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch AND NVL (store_acknowledge_status, '*') <> 'C'), 0 ) ) > 0 AND l.patient_class = NVL ('IP', l.patient_class) AND NVL (l.iv_prep_yn, 'X') NOT IN ('2', '4', '6', '8', '0') AND c.order_id = l.order_id AND b.order_id = c.order_id and exists (select 'X' from ip_open_encounter where facility_id = c.facility_id and encounter_id = c.encounter_id) ";//and exists (select 'X' from ip_open_encounter where facility_id = c.facility_id and encounter_id = c.encounter_id) Added for KDAH-SCF-419 and a.DISP_QTY_UOM added for ML-BRU-SCF-1842 and iv_prep_yn added for GHL-CRF-0482
		 //Replaced AND disp_no = a.disp_no qith AND disp_no = b.disp_no in all the places for GHL-SCF-1084//
//sql = "SELECT d.drug_desc,DECODE (j.use_after_expiry_yn,'Y', 'Y','N', DECODE (GREATEST (SYSDATE, expiry_date),SYSDATE, 'N','Y')) valid , c.doc_type, c.doc_no, a.store_code, a.item_code, a.bin_location_code,a.batch_id, TO_CHAR (a.expiry_date, 'DD/MM/YYYY')expiry_date,a.trade_id trade_id, a.disp_no, a.srl_no, b.doc_srl_no, a.srl_no_batch,TO_CHAR (b.added_date, 'dd/mm/yyyy') added_date, a.disp_qty issuedqty,b.disp_uom_code qtyuom,a.disp_qty - ( NVL (a.returned_qty, 0) + NVL ((SELECT NVL (SUM (returned_qty), 0) tot_ward_ret_qty FROM ph_ward_return_dtl WHERE facility_id = a.facility_id AND disp_no = a.disp_no AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch AND store_acknowledge_status IS NULL), 0 ) + NVL ((SELECT SUM (rej_qty) FROM ph_ward_return_dtl WHERE facility_id = a.facility_id AND disp_no = a.disp_no AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch), 0 ) ) returnable, NVL ( a.returned_qty + NVL ((SELECT SUM (rej_qty) FROM ph_ward_return_dtl WHERE facility_id = a.facility_id AND disp_no = a.disp_no AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch), 0 ), 0 ) returnedqty, c.encounter_id, b.order_id, b.order_line_no, b.issue_qty, b.issue_uom_code, (SELECT g.short_desc FROM ph_disp_locn_lang_vw g WHERE a.store_code = g.disp_locn_code AND a.facility_id = g.facility_id AND g.language_id = ?) disp_locn_desc, (SELECT short_desc FROM am_uom_lang_vw WHERE uom_code = b.issue_uom_code AND language_id = ?) short_desc, (SELECT def_issue_uom def_issue_uom FROM st_item_store WHERE eff_status = 'E' AND item_code = a.item_code AND store_code = ?) to_store_def_issue_uom, c.patient_class patient_class, c.locn_code from_locn_code, (SELECT t.short_name FROM am_trade_name_lang_vw t WHERE a.facility_id = t.added_facility_id AND a.trade_id = t.trade_id AND t.language_id = ?) trade_name FROM (SELECT drug_desc drug_desc, drug_code drug_code, NVL (content_in_pres_base_uom, 1) content_in_pres_base_uom FROM ph_drug_lang_vw WHERE language_id = ? UNION SELECT NVL (short_name, long_name) drug_desc, tpn_regimen_code drug_code, NVL (content_in_base_unit, 1) content_in_pres_base_uom FROM ph_tpn_regimen_lang_vw WHERE standard_regimen_yn = 'Y' AND language_id = ?) d, ph_disp_drug_batch a, ph_disp_dtl b, ph_disp_hdr c, st_item j, st_sal_hdr k, or_order l WHERE a.facility_id = b.facility_id AND k.doc_no = c.doc_no AND k.doc_type_code = c.doc_type AND k.facility_id = c.facility_id AND a.disp_no = b.disp_no AND a.srl_no = b.srl_no AND c.facility_id = b.facility_id AND c.disp_no = b.disp_no AND b.disp_drug_code = d.drug_code AND l.patient_id = ? AND b.added_date >= TO_DATE (?, 'dd/mm/yyyy hh24:mi') AND b.facility_id = ? AND b.disp_no = NVL (?, a.disp_no) AND a.disp_qty <> NVL (a.returned_qty, 0) AND a.item_code = j.item_code AND ( (j.use_after_expiry_yn = 'N' AND SYSDATE < expiry_date) OR (j.use_after_expiry_yn = 'Y') ) AND ( a.disp_qty - NVL ((SELECT SUM (returned_qty) tot_ward_ret_qty FROM ph_ward_return_dtl WHERE facility_id = a.facility_id AND disp_no = a.disp_no AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch AND NVL (store_acknowledge_status, '*') <> 'C'), 0 ) ) > 0 AND l.patient_class = NVL ('IP', l.patient_class) AND NVL (l.iv_prep_yn, 'X') NOT IN ('2', '4', '6', '8', '0') AND c.order_id = l.order_id AND b.order_id = c.order_id ";// added new query for GHL-SCF-1084 [IN:060932]//Commented and added same query below with modificatio for GHL-SCF-1084//and exists (select 'X' from ip_open_encounter where facility_id = c.facility_id and encounter_id = c.encounter_id added for KDAH-SCF-0419
			String sql2="select   sum((CASE WHEN c.DOSAGE_TYPE ='S' THEN ceil((sum(b.ADMIN_DOSAGE_QTY)/d.STRENGTH_VALUE)/d.CONTENT_IN_PRES_BASE_UOM ) ELSE ceil(sum(b.ADMIN_DOSAGE_QTY)/d.CONTENT_IN_PRES_BASE_UOM) END )) tot_admin_qty from ph_medn_admin a ,ph_medn_admin_dtl b,or_order_line_ph c ,(SELECT drug_desc drug_desc, drug_code drug_code,NVL (content_in_pres_base_uom, 1) content_in_pres_base_uom,strength_value  FROM ph_drug_lang_vw  WHERE language_id = ? and drug_code = ? UNION SELECT NVL (short_name, long_name) drug_desc, tpn_regimen_code drug_code,   NVL (content_in_base_unit, 1) content_in_pres_base_uom,1 strength_value FROM ph_tpn_regimen_lang_vw WHERE standard_regimen_yn = 'Y' AND language_id = ? and TPN_REGIMEN_CODE =? ) d where   a.FACILITY_ID=b.FACILITY_ID  and a.ENCOUNTER_ID=b.ENCOUNTER_ID  and a.ORD_DRUG_CODE=b.ORD_DRUG_CODE  and a.order_id=b.order_id  and a.DOSAGE_SEQ_NO =b.DOSAGE_SEQ_NO and a.order_id=? and a. ORDER_LINE_NUM =?   and a.order_id =c.order_id  and a.ORDER_LINE_NUM  =c.ORDER_LINE_NUM and b.facility_id=?  and a.ADMIN_RECORDED_YN ='Y' and b.item_code=? and BATCH_ID =?and EXPIRY_DATE=to_date(?,'dd/mm/yyyy')  and TRADE_ID =?  and b.ADMIN_DRUG_CODE =d.drug_code and exists (select 'X' from ip_open_encounter where facility_id = a.facility_id and encounter_id = a.encounter_id) group by BATCH_ID, EXPIRY_DATE, TRADE_ID ,b.ADMIN_DOSAGE_QTY ,c.DOSAGE_TYPE,d.STRENGTH_VALUE, d.CONTENT_IN_PRES_BASE_UOM ";//Added "and exists (select 'X' from ip_open_encounter where facility_id = a.facility_id and encounter_id = a.encounter_id)" to display drugs only from current encounter IN032455

			String sql3 = "SELECT   SUM ((CASE WHEN (SELECT dosage_type FROM or_order_line_ph WHERE order_id = b.order_id AND ROWNUM <= 1) = 'S' THEN CEIL (  ((b.admin_dosage_qty) / d.strength_value) / d.content_in_pres_base_uom ) ELSE CEIL ((b.admin_dosage_qty) / d.content_in_pres_base_uom) END ) ) tot_admin_qty  FROM ph_medn_admin_dtl b,(SELECT drug_desc drug_desc, drug_code drug_code, NVL (content_in_pres_base_uom, 1) content_in_pres_base_uom, strength_value FROM ph_drug_lang_vw WHERE language_id = ? AND drug_code = ?) d WHERE  b.batch_order_id =? AND batch_id = ? AND expiry_date = TO_DATE (?, 'dd/mm/yyyy') AND b.item_code = ? AND b.admin_drug_code = d.drug_code GROUP BY batch_id, expiry_date, trade_id, b.admin_dosage_qty, d.strength_value, d.content_in_pres_base_uom"; //added for GHL-CRF-0482
		


		   
		    String doc_srl_no_sql="select doc_srl_no from  st_sal_dtl_exp  where facility_id = ? AND doc_type_code =? AND doc_no=? AND store_code = ? AND item_code = ? AND batch_id = ? and expiry_date_or_receipt_date = TO_DATE(?,'DD/MM/YYYY HH24:MI') AND bin_location_code =? AND trade_id =?";

           pstmt1= connection.prepareStatement( sql2) ;
		   //added for GHL-CRF-0482
		   if(isSite_spec_patient_stock){
	   		   pstmt2= connection.prepareStatement( sql3) ;
		   }

			
			StringTokenizer drugCodeToken = new StringTokenizer(drugcodes, ",");
			int drugcounter=drugCodeToken.countTokens();

			String appendString="";
			int tokencount=0;
			HashMap BatchDetails   = new HashMap();//Adding start for MOHE-CRF-0167
	        String  gtin           = ""; 
	        String batch_id        = "";
			String expiry_date     = "";
			HashMap siteValues =new HashMap();
			String include_exp_date_yn ="N";

			
			if(barcode_2d_applicable && !barcode_id.equals("")){	
				siteValues =eCommon.Common.CommonBean.getSiteSpecificDetails(connection, "ST","2D_BARCODE_APPLICABLE");	
	             BatchDetails =getBarcodedetails(barcode_id);
	             gtin =(String)BatchDetails.get("GTIN")==null?"":(String)BatchDetails.get("GTIN");
                 batch_id =(String)BatchDetails.get("BATCH_ID")==null?"":(String)BatchDetails.get("BATCH_ID");

				 if(siteValues.containsKey("key1"))
					  include_exp_date_yn =(String)siteValues.get("value1");
               if(include_exp_date_yn.equals("Y")){
				 expiry_date = (String)BatchDetails.get("EXPIRY_DATE")==null?"":(String)BatchDetails.get("EXPIRY_DATE");
System.err.println("expiry_date@@@==="+expiry_date);
				 SimpleDateFormat inputFormat = new SimpleDateFormat("ddmmyyyy");
		         SimpleDateFormat outputFormat = new SimpleDateFormat("dd/mm/yyyy");
		         java.util.Date inputDate = inputFormat.parse(expiry_date); 

		         String temp_exp_date = outputFormat.format(inputDate);

				      appendString = appendString+" and a.batch_id ='"+batch_id +"' and a.EXPIRY_DATE = to_date('"+temp_exp_date +"','dd/mm/yyyy')  and st.item_code =a.item_code and st.batch_id=a.batch_id and st.EXPIRY_DATE_OR_RECEIPT_DATE=a.EXPIRY_DATE ";
			   }else{
				       appendString = appendString+" and a.batch_id ='"+batch_id +"' and st.item_code =a.item_code and st.batch_id=a.batch_id and st.EXPIRY_DATE_OR_RECEIPT_DATE=a.EXPIRY_DATE ";
			   }
			}else{//Adding end for MOHE-CRF-0167
			 if(!barcode_id.equals("") && siteAck && drugcounter==0)  // Added for GHL-CRF-0413.8 
				appendString = appendString+" and st.barcode_id =? and st.item_code =a.item_code and st.batch_id=a.batch_id and st.EXPIRY_DATE_OR_RECEIPT_DATE=a.EXPIRY_DATE ";
			}

	
			if (drugcounter==1){
				sql=sql+" and  ( B.DISP_DRUG_CODE="+drugCodeToken.nextToken();
				if(!barcode_id.equals("") && siteAck){
				  sql= sql	+" or st.barcode_id=? ) and st.item_code =a.item_code and st.batch_id=a.batch_id and st.EXPIRY_DATE_OR_RECEIPT_DATE=a.EXPIRY_DATE "+ackWC +" order by d.drug_desc,a.disp_no";//ackWC added for GHL-CRF-0399
				}else{
					sql=sql+")";
					if(siteAck){
					     sql =sql+" and st.item_code =a.item_code and st.batch_id=a.batch_id and st.EXPIRY_DATE_OR_RECEIPT_DATE=a.EXPIRY_DATE "+ackWC +" order by d.drug_desc,a.disp_no";
					}else{
						sql =sql+ackWC +" order by d.drug_desc,a.disp_no";
					}

				}
			}
			else{
				while (drugCodeToken.hasMoreTokens()){
					if (tokencount==0){
						appendString=appendString+" and ( B.DISP_DRUG_CODE="+drugCodeToken.nextToken()+" ";
						tokencount=1;
					}
					else{
						appendString=appendString+" or  B.DISP_DRUG_CODE="+drugCodeToken.nextToken()+" ";
					}
				}
				if(drugcounter!=0 && !barcode_id.equals("") && siteAck){
						appendString=appendString+" or st.barcode_id=?  ";
					
					}
				if(drugcounter!=0)
				  appendString=appendString+")";
				if(siteAck)
				     appendString=appendString+" and st.item_code =a.item_code and st.batch_id=a.batch_id and st.EXPIRY_DATE_OR_RECEIPT_DATE=a.EXPIRY_DATE ";
				
				sql=sql+appendString+ackWC+ "order by d.drug_desc,a.disp_no";//ackWC added for GHL-CRF-0399
			}
			int cnt	=	1;
			System.err.println("sql for ward return get batch details======"+sql);
			System.err.println("ToStoreCode===="+ToStoreCode+"patientid==="+patientid+"cutoff===="+cutoff+"dispno===="+dispno);
        	pstmt = connection.prepareStatement( sql) ;
			pstmt.setString(cnt,getLanguageId());
			pstmt.setString(++cnt,getLanguageId());// added  for GHL-SCF-1084 [IN:060932]
			pstmt.setString(++cnt,ToStoreCode);
			pstmt.setString(++cnt,getLanguageId());
			pstmt.setString(++cnt,getLanguageId());
			pstmt.setString(++cnt,getLanguageId());// added for GHL-SCF-1084 [IN:060932]
        	pstmt.setString(++cnt,patientid.trim());
			pstmt.setString(++cnt,cutoff);
			pstmt.setString(++cnt,login_facility_id.trim());			
			pstmt.setString(++cnt,dispno.trim());
			if(!barcode_id.equals("") && siteAck && !barcode_2d_applicable) // Added for GHL-CRF-0413.8//barcode_2d_applicable Added for MOHE-CRF-0167
				pstmt.setString(++cnt,barcode_id.trim());
			//pstmt.setString(++cnt,getLanguageId());// commented  for GHL-SCF-1084 [IN:060932]
			//pstmt.setString(++cnt,patcat);
			//pstmt.setString(++cnt,getLanguageId());// commented  for GHL-SCF-1084 [IN:060932]
			
            resultSet = pstmt.executeQuery() ;
            if(!barcode_id.equals("") && siteAck) // Added for GHL-CRF-0413.8 - Start
            {
            	if(!scannedBatch.contains(barcode_id.trim())){
                	result = scannedBatch; 
                }     		
            } // Added for GHL-CRF-0431.8 - End
            while ( resultSet.next() ) {
				result.add(resultSet.getString("DRUG_DESC"));	//0
				result.add(resultSet.getString("BATCH_ID"));	
				result.add(resultSet.getString("EXPIRY_DATE")); 
				result.add(resultSet.getString("DISP_NO"));		
				result.add(resultSet.getString("ADDED_DATE"));	//4
				result.add(resultSet.getString("ISSUEDQTY"));	//5
				result.add(resultSet.getString("QTYUOM"));
				result.add(resultSet.getString("RETURNEDQTY"));
				result.add(resultSet.getString("RETURNABLE"));
				result.add(resultSet.getString("SRL_NO"));
				result.add(resultSet.getString("SRL_NO_BATCH"));	//10
				result.add(resultSet.getString("VALID"));
				result.add(resultSet.getString("DOC_TYPE"));
				result.add(resultSet.getString("DOC_NO"));
				result.add(resultSet.getString("STORE_CODE"));
				result.add(resultSet.getString("ITEM_CODE"));		//15
				result.add(resultSet.getString("BIN_LOCATION_CODE"));
				//result.add(resultSet.getString("doc_srl_no"));
				doc_srl_no=resultSet.getString("doc_srl_no")==null?"":resultSet.getString("doc_srl_no");
				trade_id=resultSet.getString("TRADE_ID")==null?"":resultSet.getString("TRADE_ID");
				
			   if(!doc_srl_no.equals("")){
				  result.add(doc_srl_no);	//17
				}
				else if(doc_srl_no.equals("")){
				System.err.println("doc_srl_no_sql ward return@@====="+doc_srl_no_sql);
					pstmt = connection.prepareStatement( doc_srl_no_sql) ;
									
					pstmt.setString(1,login_facility_id.trim());
					pstmt.setString(2,resultSet.getString("DOC_TYPE")==null?"":resultSet.getString("DOC_TYPE"));
					pstmt.setString(3,resultSet.getString("DOC_NO")==null?"":resultSet.getString("DOC_NO"));
					pstmt.setString(4,resultSet.getString("STORE_CODE")==null?"":resultSet.getString("STORE_CODE"));
					pstmt.setString(5,resultSet.getString("ITEM_CODE")==null?"":resultSet.getString("ITEM_CODE"));
					pstmt.setString(6,resultSet.getString("BATCH_ID")==null?"":resultSet.getString("BATCH_ID"));
					pstmt.setString(7,resultSet.getString("EXPIRY_DATE")==null?"":resultSet.getString("EXPIRY_DATE"));
					pstmt.setString(8,resultSet.getString("BIN_LOCATION_CODE")==null?"":resultSet.getString("BIN_LOCATION_CODE"));
					pstmt.setString(9,trade_id);
					
					resultSet2 = pstmt.executeQuery() ;
					if( resultSet2.next() ) {		
						  result.add(resultSet2.getString("doc_srl_no"));	//17
					}
				}

				result.add(resultSet.getString("disp_locn_desc"));	//18
				result.add(resultSet.getString("TO_STORE_DEF_ISSUE_UOM")==null?"":resultSet.getString("TO_STORE_DEF_ISSUE_UOM"));//19

				tot_admin_qty = 0;
				returnable    = Integer.parseInt(resultSet.getString("RETURNABLE"));
			   	if(bat_admin_qty.containsKey(resultSet.getString("order_id")+resultSet.getString("order_line_no")+resultSet.getString("ITEM_CODE")+resultSet.getString("BATCH_ID")+resultSet.getString("EXPIRY_DATE")+resultSet.getString("trade_id")) ){
					tot_admin_qty =Integer.parseInt((String)bat_admin_qty.get(resultSet.getString("order_id")+resultSet.getString("order_line_no")+resultSet.getString("ITEM_CODE")+resultSet.getString("BATCH_ID")+resultSet.getString("EXPIRY_DATE")+resultSet.getString("trade_id")));

				}
				else{
					if(isSite_spec_patient_stock && iv_prep_yn.equals("")){
						pstmt2.setString(1,getLanguageId());
						pstmt2.setString(2,resultSet.getString("ITEM_CODE"));
						pstmt2.setString(3,resultSet.getString("order_id"));
						pstmt2.setString(4,resultSet.getString("BATCH_ID"));
						pstmt2.setString(5,resultSet.getString("EXPIRY_DATE"));
						pstmt2.setString(6,resultSet.getString("ITEM_CODE"));
						resultSet1 = pstmt2.executeQuery() ;
					}else{
						pstmt1.setString(1,getLanguageId());
						pstmt1.setString(2,resultSet.getString("ITEM_CODE"));
						pstmt1.setString(3,getLanguageId());
						pstmt1.setString(4,resultSet.getString("ITEM_CODE"));
						pstmt1.setString(5,resultSet.getString("order_id"));
						pstmt1.setString(6,resultSet.getString("order_line_no"));
						pstmt1.setString(7,login_facility_id);
						pstmt1.setString(8,resultSet.getString("ITEM_CODE"));
						pstmt1.setString(9,resultSet.getString("BATCH_ID"));
						pstmt1.setString(10,resultSet.getString("EXPIRY_DATE"));
						pstmt1.setString(11,resultSet.getString("trade_id"));
						resultSet1 = pstmt1.executeQuery() ;
					}
					//resultSet1 = pstmt1.executeQuery() ;
					while ( resultSet1.next() ) {                 
						admin_qty =resultSet1.getInt("tot_admin_qty");
						tot_admin_qty = tot_admin_qty+admin_qty;
					}
					closeResultSet( resultSet1 ) ;
				}

				if(tot_admin_qty >0){	
					if(returnable <tot_admin_qty){
						result.add("N");	//20
						result.add("0");
						// tot_admin_qty =0;//commented for 26175
						tot_admin_qty =tot_admin_qty - returnable;//added for 26175

					}
					else{
						returnable = returnable - tot_admin_qty;
						if(returnable <0){
							tot_admin_qty = tot_admin_qty - returnable;
							result.add("N");		//20
							result.add("0");
						}
						else{
							result.add("Y");	//20
							result.add(returnable+"");
							tot_admin_qty = 0;
							tot_admin_qty =tot_admin_qty - returnable;//added for 26175
						}
					}     
					bat_admin_qty.put(resultSet.getString("order_id")+resultSet.getString("order_line_no")+resultSet.getString("ITEM_CODE")+resultSet.getString("BATCH_ID")+resultSet.getString("EXPIRY_DATE")+resultSet.getString("trade_id"),tot_admin_qty+"");
				}
				else{
					result.add("Y");	//20
					result.add(returnable+"");
				}
                result.add(resultSet.getString("ISSUE_QTY")==null?"":resultSet.getString("ISSUE_QTY"));	//22
				result.add(resultSet.getString("ISSUE_UOM_CODE")==null?"":resultSet.getString("ISSUE_UOM_CODE")); 
				result.add(resultSet.getString("SHORT_DESC")==null?"":resultSet.getString("SHORT_DESC"));
				result.add(resultSet.getString("patient_class")==null?"":resultSet.getString("patient_class"));
				result.add(resultSet.getString("order_id")==null?"":resultSet.getString("order_id"));
				result.add(resultSet.getString("order_line_no")==null?"":resultSet.getString("order_line_no"));
				result.add(resultSet.getString("from_locn_code")==null?"":resultSet.getString("from_locn_code"));
				result.add(resultSet.getString("ENCOUNTER_ID")==null?"":resultSet.getString("ENCOUNTER_ID"));	//29
				result.add(resultSet.getString("TRADE_NAME")==null?"":resultSet.getString("TRADE_NAME"));	//30  Added for  AMS-SCF-0190 IN038440
				result.add(tot_admin_qty);	//31  Added for  AMS-SCF-0190 IN038440
				if((!barcode_id.equals("") || drugcodes.length()>0) && siteAck && !barcode_2d_applicable){ // Added for GHL-CRF-0413.8

					result.add(resultSet.getString("BARCODE_ID")==null?"":resultSet.getString("BARCODE_ID")); // Added for GHL-CRF-0413.8
					result.add(0);
				}else if (barcode_2d_applicable && (!barcode_id.equals("") || drugcodes.length()>0))//Added for MOHE-CRF-0167
				{
					System.err.println("@@778=="+barcode_id);
					result.add(barcode_id); 
					result.add(0);
				}//Adding end for MOHE-CRF-0167

				result.add(resultSet.getString("DISP_QTY_UOM")==null?"":resultSet.getString("DISP_QTY_UOM"));//added for ML-BRU-SCF-1842
				//setEncounter(resultSet.getString("ENCOUNTER_ID"));
			}
			tabData.put("BatchDetails",result);
			if((!barcode_id.equals("") || drugcodes.length()>0 ) && siteAck) // Added for GHL-CRF-0413.8 - Start
            {
				if(!scannedBatch.contains(barcode_id.trim())){
					setScannedBatchDetails(result);
                } 	   		
            } // Added for GHL-CRF-0431.8 - End
		}
		catch ( Exception e ) {
			e.printStackTrace();
			result.add(e.toString());
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeResultSet( resultSet2 ) ;
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt ) ;
				closeStatement( pstmt1 ) ;
				closeStatement( pstmt2 ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return result;
	}

	public String getCutOff(){
        Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String cutoff			= "";

        try {
            connection = getConnection() ;

			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_RET_MEDN_SELECT4") ) ;
			pstmt.setString(1,login_facility_id.trim());
            resultSet = pstmt.executeQuery() ;
            if ( resultSet.next() ) {
				cutoff=resultSet.getString("CUTOFF");
				setCurrDate(resultSet.getString("CURR_DATE"));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			return e.toString();
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
		return cutoff;
	}

	public ArrayList getReturnRemarks(){
        Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		ArrayList result		= new ArrayList();
        try {
            connection = getConnection() ;
			String sql=PhRepository.getPhKeyValue("SQL_PH_RET_MEDN_SELECT6") ;
			pstmt = connection.prepareStatement( sql) ;
			pstmt.setString(1,getLanguageId());
            resultSet = pstmt.executeQuery() ;
            while ( resultSet.next() ) {
				result.add(resultSet.getString("REASON_CODE"));
				result.add(resultSet.getString("REASON_DESC"));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			result.add(e.toString());
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
		return result;
	}

	public ArrayList getPatientDetails(String patientid){
        Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		 ArrayList result		= new ArrayList();
        try {
            connection = getConnection() ;

			String sql=PhRepository.getPhKeyValue("SQL_PH_RET_MEDN_SELECT8") ;
			pstmt = connection.prepareStatement( sql) ;
			pstmt.setString(1,getLanguageId());
			pstmt.setString(2,patientid);
            resultSet = pstmt.executeQuery() ;
            while ( resultSet.next() ) {
				result.add(resultSet.getString("PATIENT_NAME"));
				result.add(resultSet.getString("SEX"));
				result.add(resultSet.getString("AGE"));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			result.add(e.toString());
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
		return result;
	}

	public String getPatient_ID(String disp_no)throws Exception{
		String patient_id	="";
        Connection connection	= null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet		= null;
        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_HDR_SELECT") ) ;
			pstmt.setString(1,disp_no);
		    resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				patient_id=resultSet.getString("patient_id") == null ? "":resultSet.getString("patient_id");
			}
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
				es.printStackTrace();
			}
        }
		return patient_id;
	}

/*============================variable uom==========================*/
	public HashMap getStoreDfltIssueUOMAndBaseUOM (String drug_code,String disp_locn_code){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		HashMap def_issue_uoms	= new HashMap();
		try {
            connection	= getConnection() ;
          //  pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT161")) ;
			pstmt		= connection.prepareStatement( "SELECT DEF_ISSUE_UOM,GEN_UOM_CODE FROM ST_ITEM_STORE a, mm_item b WHERE STOCK_ITEM_YN = 'Y' AND a.STORE_CODE = ? AND a.ITEM_CODE = ? AND a.EFF_STATUS = 'E'and b.EFF_STATUS='E' and a.item_code =b.item_code") ;

			pstmt.setString(1,disp_locn_code);
			pstmt.setString(2,drug_code);
            resultSet	= pstmt.executeQuery() ;
			
			if (resultSet.next()){
				def_issue_uoms.put("DEF_ISSUE_UOM",	checkForNull(resultSet.getString("DEF_ISSUE_UOM")));				
				def_issue_uoms.put("BASE_UOM",	checkForNull(resultSet.getString("GEN_UOM_CODE")));
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
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return def_issue_uoms;
	}

	public int  lcm(int frm_tmp, int to_tmp) {
		int lowest = frm_tmp < to_tmp ? frm_tmp : to_tmp;
		int hcd = 1;
		for (int i = lowest; i > 1; i--) {
			if (frm_tmp % i == 0 && to_tmp % i == 0) {
				hcd = i;
				break;
			}
		}
		int lcm = (frm_tmp * to_tmp) / hcd;
		return lcm;
	}

	public int getEqulValue (String item_code,String uom_code,String equl_uom_code){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		int eqvl_value			= 1; //changed from deft value "0" to "1" for ICN 30186
		try {
            connection	= getConnection() ;
          //  pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT161")) ;
			//pstmt		= connection.prepareStatement( "select EQVL_VALUE from MM_ITEM_UOM_DEFN where  EFF_STATUS = 'E' and ITEM_CODE=? and UOM_CODE =? and EQVL_UOM_CODE=?") ;
			pstmt		= connection.prepareStatement( "select PH_calculate_equl_val(ITEM_CODE,UOM_CODE,EQVL_UOM_CODE) EQVL_VALUE from MM_ITEM_UOM_DEFN where  EFF_STATUS = 'E' and ITEM_CODE=? and UOM_CODE =? and EQVL_UOM_CODE=?") ;

			pstmt.setString(1,item_code);
			pstmt.setString(2,uom_code);
			pstmt.setString(3,equl_uom_code);
            resultSet	= pstmt.executeQuery() ;
			
			if (resultSet.next()){
				eqvl_value = resultSet.getInt("EQVL_VALUE");				
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
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return eqvl_value;
	}

	public ArrayList getOrderingFacilityId(String p_user_name) {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList result=new ArrayList();
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISPLOCN_SELECT" )) ;
			pstmt = connection.prepareStatement("SELECT B.FACILITY_ID FACILITY_ID,B.FACILITY_NAME FACILITY_NAME FROM SM_FACILITY_FOR_USER A, SM_FACILITY_PARAM_lang_vw B WHERE A.FACILITY_ID = B.FACILITY_ID AND B.STATUS ='E' AND APPL_USER_ID = ? AND B.LANGUAGE_ID= ?") ;
			pstmt.setString(1,p_user_name);
			pstmt.setString(2,getLanguageId());

			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				result.add(resultSet.getString("FACILITY_ID"));
				result.add(resultSet.getString("FACILITY_NAME"));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			result.add(e.toString());
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
		return result;
	}

	public String getISSUE_UOM_BY (){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		     issue_uom_by		= "";
		try {
            connection	= getConnection() ;
          //  pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT161")) ;
			pstmt		= connection.prepareStatement( "select ISSUE_UOM_BY from ph_param") ;			
            resultSet	= pstmt.executeQuery() ;			
			if (resultSet.next()){
				issue_uom_by = resultSet.getString("ISSUE_UOM_BY");			
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
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return issue_uom_by;
	}

	public HashMap insert(){
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
	 	
		Connection connection				  = null;
		PreparedStatement pstmt             = null ;
		PreparedStatement pstmt1           = null ;
		PreparedStatement pstmt2           = null ;
		PreparedStatement pstmt3           = null ;
		PreparedStatement pstmt2_sel           = null ; //added for SKR-SCF-0393 [IN30939]
		ResultSet resultSet				      = null ;
		ResultSet resultSet1				      = null ;
		PreparedStatement pstmt_select_balQty	= null;
//		ResultSet rset						= null;   Removed for IN063877

		int[] rowsInserted_dtl					  = new int[100];
		String disp_date_time					  = "";
		String dispno							  = "";
		String actualReturn						  = "";
		String disp_locn_code				      = "";
		String order_id							  = "";
		String patientid						  = "";
		String patient_class					  = "";
		String from_locn_code				      = "";
		String ToStoreCode					      = "";
		String remarks							  = "";
		String order_line_no				      = "";
		String srl_no							  = "";
		String srl_no_batch					      = "";
		String drugcodes				          = "";
		String qty_uom						      = "";
		String encounter_id_drug_lvl			  = "";
		boolean retMedRestrStage = false; // Added for GHL-CRF-0412.3
		int    ward_tran_seq_no					  = 0;
		ArrayList datarr	=	new ArrayList();
		ArrayList batchdetails = new ArrayList();

		float disp_qty = 0;
		float tot_rtn_qty =0;

		int total_count = Integer.parseInt((String)recordSet.get("totalrows"));	
		
		try{
		
			ArrayList RetdocList=new ArrayList();			
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement("INSERT INTO PH_WARD_RETURN_HDR(FACILITY_ID,RET_DOC_NO,DISP_NO, DISP_DATE_TIME, DISP_LOCN_CODE, ORDER_ID, PATIENT_ID, ENCOUNTER_ID, PATIENT_CLASS, FROM_LOCN_CODE, RET_TO_DISP_LOCN_CODE, RETURN_REASON, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,WARD_RET_TRX_NO) VALUES(?,?,?,To_Date(?,'DD/MM/YYYY hh24:mi'),?,?,?,?,?,?,?,?,?,Sysdate,?,?,?,Sysdate,?,?,?)");
			pstmt2					= connection.prepareStatement("INSERT INTO PH_WARD_RETURN_DTL(FACILITY_ID, RET_DOC_NO, RET_DOC_LINE_NO, ORDER_ID, ORDER_LINE_NO, DISP_NO, SRL_NO, SRL_NO_BATCH, BIN_LOCATION_CODE, ACKNOWLEDGE_REASON, ACKNOWLEDGED_BY_ID, ITEM_CODE, RETURN_UOM_CODE, STORE_ACKNOWLEDGE_STATUS, RETURNED_QTY, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,Sysdate,?,?,?,Sysdate,?,?)");
			pstmt2_sel				= connection.prepareStatement("SELECT 1 FROM PH_WARD_RETURN_DTL WHERE FACILITY_ID=? AND DISP_NO=? AND SRL_NO=? FOR UPDATE NOWAIT");   // for update added for the issue SKR-SCF-0393 [IN30939] to create a row level lock
			//one transation should be one number(this is developed  for online reports purpose). 
			pstmt3					= connection.prepareStatement("select PH_WARD_RET_SEQ.NEXTVAL  WARD_RET_SEQ_NO from dual");
			pstmt_select_balQty	=	connection.prepareStatement("SELECT ( NVL (a.returned_qty, 0) + NVL ((SELECT SUM (returned_qty) tot_ward_ret_qty FROM ph_ward_return_dtl WHERE disp_no = a.disp_no AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch AND store_acknowledge_status IS NULL), 0 ) + NVL ((SELECT SUM (rej_qty) FROM ph_ward_return_dtl WHERE disp_no = a.disp_no AND srl_no = a.srl_no AND srl_no_batch = a.srl_no_batch), 0 ) ) returned_qty FROM ph_disp_drug_batch a WHERE FACILITY_ID=? AND DISP_NO=? AND SRL_NO=? AND SRL_NO_BATCH=?"); 
			resultSet1				= pstmt3.executeQuery();
			if(resultSet1!=null && resultSet1.next()){
				ward_tran_seq_no		=Integer.parseInt(resultSet1.getString("WARD_RET_SEQ_NO"));
			}
			pstmt1					= connection.prepareStatement("select PH_RETN_TRN_SEQ.NEXTVAL  RET_DOC_NO from dual");
			int RET_DOC_NO		=0;	
			
			ArrayList retMedRestr = getDischargeStage(login_facility_id, (String)recordSet.get("encounter_id"+"1"),(String)recordSet.get("patientid"));  // Added for GHL-CRF-0412.3 -Start
			
			if(retMedRestr!=null && retMedRestr.size()>0){
				if(retMedRestr.size()>2){
	              if(retMedRestr.get(2).equals("I") && ((retMedRestr.get(0).equals("Y") || retMedRestr.get(1).equals("7"))))
          	         retMedRestrStage=true;
                  else if(retMedRestr.get(2).equals("P") && (retMedRestr.get(1).equals("7")))
          	         retMedRestrStage=true;
				}
           else if(retMedRestr.get(0).equals("08") && (retMedRestr.get(1).equals("I")|| retMedRestr.get(1).equals("P") || retMedRestr.get(1).equals("D")))
          	  retMedRestrStage=true;	
			}		
        	 
			if(retMedRestrStage){
					throw new Exception();		
			}   // Added for GHL-CRF-0412.3 - End
			
			for (int i=1;i<=total_count ;i++ ){
				
				disp_date_time			= (String)recordSet.get("disp_date_time"+i);							
				dispno					= (String)recordSet.get("dispno"+i);			
				actualReturn			= (String)recordSet.get("actualReturn"+i);				
				disp_locn_code			= (String)recordSet.get("disp_locn_code"+i);
				order_id				= 	(String)recordSet.get("order_id"+i);
				patientid				= (String)recordSet.get("patientid");
				patient_class			= (String)recordSet.get("patient_class"+i);
				from_locn_code			= (String)recordSet.get("from_locn_code"+i);
				ToStoreCode				= (String)recordSet.get("ToStoreCode");
				remarks					= (String)recordSet.get("remarks");
				order_line_no			= (String)recordSet.get("order_line_no"+i);
				srl_no					= (String)recordSet.get("srl_no"+i);
				srl_no_batch			= (String)recordSet.get("srl_no_batch"+i)	;	
				drugcodes				= 	(String)recordSet.get("drugcodes"+i);
				qty_uom					= (String)recordSet.get("qty_uom"+i);
				encounter_id_drug_lvl	= (String)recordSet.get("encounter_id"+i);

				datarr.add(disp_date_time);
				datarr.add(dispno);
				datarr.add(actualReturn);
				datarr.add(disp_locn_code);
				datarr.add(order_id);
				datarr.add(patientid);
				datarr.add(patient_class);
				datarr.add(from_locn_code);
				datarr.add(ToStoreCode);
				datarr.add(remarks);
				datarr.add(order_line_no);
				datarr.add(srl_no);
				datarr.add(srl_no_batch);
				datarr.add(drugcodes);
				datarr.add(qty_uom);
				datarr.add(encounter_id_drug_lvl);
				tabData.put("RECORD"+i,datarr);
				
				RET_DOC_NO		=0;	

				if(!actualReturn.equals("0") && !actualReturn.equals("") ){
					resultSet				= pstmt1.executeQuery();

					if(resultSet!=null && resultSet.next()){
						RET_DOC_NO		=Integer.parseInt(resultSet.getString("RET_DOC_NO"));
					}

					RetdocList.add(ward_tran_seq_no);
					pstmt.setString(1,login_facility_id.trim());
					pstmt.setInt(2,RET_DOC_NO);
					pstmt.setString(3,dispno.trim());
					pstmt.setString(4,disp_date_time.trim());
					pstmt.setString(5,disp_locn_code.trim());
					pstmt.setString(6,order_id.trim());
					pstmt.setString(7,patientid.trim());
					//pstmt.setString(8,this.encounter_id);
					pstmt.setString(8,encounter_id_drug_lvl);
					pstmt.setString(9,patient_class.trim());
					pstmt.setString(10,from_locn_code.trim());
					pstmt.setString(11,ToStoreCode.trim());
					pstmt.setString(12,remarks.trim());
					pstmt.setString(13,login_by_id.trim());
					pstmt.setString(14,login_at_ws_no.trim());
					pstmt.setString(15,login_facility_id.trim());
					pstmt.setString(16,login_by_id.trim());
					pstmt.setString(17,login_at_ws_no.trim());
					pstmt.setString(18,login_facility_id.trim());
					pstmt.setInt(19,ward_tran_seq_no);
					
					pstmt.addBatch();
					
					int ret_doc_line_no = 1;
					//This execution will make a row level lock in PH_WARD_RETURN_DTL, When the specific row is locked a SQL Exception will be thrown, which is handled below
					pstmt2_sel.setString(1,login_facility_id.trim()); //added for SKR-SCF-0393 [IN30939] -- begin
					pstmt2_sel.setString(2,dispno.trim());
					pstmt2_sel.setString(3,srl_no.trim());
					pstmt2_sel.executeQuery(); //added for SKR-SCF-0393 [IN30939] - end 
					
					pstmt2.setString(1,login_facility_id.trim());
					pstmt2.setInt(2,RET_DOC_NO);
					pstmt2.setInt(3,ret_doc_line_no);
					pstmt2.setString(4,order_id.trim());
					pstmt2.setString(5,order_line_no.trim());
					pstmt2.setString(6,dispno.trim());
					pstmt2.setString(7,srl_no.trim());
					pstmt2.setString(8,srl_no_batch.trim());
					pstmt2.setString(9,"");
					pstmt2.setString(10,"");
					pstmt2.setString(11,"");
					pstmt2.setString(12,drugcodes.trim());
					pstmt2.setString(13,qty_uom.trim());
					pstmt2.setString(14,"");
					pstmt2.setString(15,actualReturn.trim());
					pstmt2.setString(16,login_by_id.trim());
					pstmt2.setString(17,login_at_ws_no.trim());
					pstmt2.setString(18,login_facility_id.trim());
					pstmt2.setString(19,login_by_id.trim());
					pstmt2.setString(20,login_at_ws_no.trim());
					pstmt2.setString(21,login_facility_id.trim());

					pstmt2.addBatch();
				}
			}//for

			closeResultSet( resultSet ) ;
			closeStatement( pstmt1) ;
			
			int[] rowsInserted			= pstmt.executeBatch();
			rowsInserted_dtl		= pstmt2.executeBatch();
			boolean wardRetStatus = true;
			for (int i=0; i<rowsInserted.length; i++) {
				if ( rowsInserted[i] < 0 && rowsInserted[i] != -2) {
					connection.rollback();
					wardRetStatus = false;
					break;
				}
			}
			if(wardRetStatus){
				for (int i=0; i<rowsInserted_dtl.length; i++) {
					if ( rowsInserted_dtl[i] < 0 && rowsInserted_dtl[i] != -2) {
						connection.rollback();
						wardRetStatus = false;
						break;
					}
				}
			}
			//Added for IN030939	SKR-SCF-0393-start 
			if(wardRetStatus)  {
				float totAdminQty=0;
				for (int i=1; i<=total_count;i++ ){
					datarr			=	(ArrayList)tabData.get("RECORD"+i)==null?new ArrayList():(ArrayList)tabData.get("RECORD"+i);
					batchdetails    =    (ArrayList)tabData.get("BatchDetails")==null?new ArrayList():(ArrayList)tabData.get("BatchDetails");
					if(batchdetails.size()>0){
						if(datarr!=null && (String)datarr.get(2)!=null && !((String)datarr.get(2)).equals("")) {
							/*pstmt_select_balQty.setString(1,login_facility_id.trim());//Commented for GHL-SCF-1084
							pstmt_select_balQty.setString(2,(String)batchdetails.get(3));
							pstmt_select_balQty.setString(3,(String)batchdetails.get(9));
							pstmt_select_balQty.setString(4,(String)batchdetails.get(10));
							rset	=	pstmt_select_balQty.executeQuery();
							if(rset.next()){
								tot_rtn_qty		=	rset.getFloat("RETURNED_QTY"); 
							}*/
							disp_qty = Float.parseFloat(batchdetails.get(5).toString());
							totAdminQty = Float.parseFloat(batchdetails.get(31).toString());
							float curr_ret_qty =Float.parseFloat((String)datarr.get(2));//Added for GHL-SCF-1084
							float returnable_qty =Float.parseFloat(batchdetails.get(8).toString());//Added for GHL-SCF-1084
							float prev_ret_qty =disp_qty-returnable_qty;//Added for GHL-SCF-1084
							tot_rtn_qty=prev_ret_qty+curr_ret_qty;//Added for GHL-SCF-1084
						//	System.err.println("curr_ret_qty==="+curr_ret_qty+"returnable_qty==="+returnable_qty+"prev_ret_qty===="+prev_ret_qty);
						//	System.err.println("tot_rtn_qty@@@@====="+tot_rtn_qty+"disp_qty@@@===="+disp_qty+"totAdminQty==="+totAdminQty+"batchdetails==="+batchdetails);
						//	System.err.println("tabData==="+tabData);
							tot_rtn_qty = tot_rtn_qty+totAdminQty;
							if( tot_rtn_qty>disp_qty){
								connection.rollback();
								map.put( "result", new Boolean( false ) ) ;
								map.put( "message", "APP-PH0902 Record Already In Use - It is used by Other User.Please Try again...") ;
								map.put("flag","0");
								return map ;
							}
						}
					}
				}
				//Added for IN030939	SKR-SCF-0393 -end 
			}
			connection.commit();
			map.put( "result", new Boolean( true ) ) ;	
			map.put( "message", getMessage(getLanguageId(),"RECORD_INSERTED","PH") ) ;
			setRetdocList(RetdocList);
		}//try
		catch(SQLException e){   //Added for SKR-SCF-0393 IN030939  - begin
			e.printStackTrace();
			if(e.getMessage().toUpperCase().contains("NOWAIT SPECIFIED")){
				map.put( "result", new Boolean( false ) ) ; 
				map.put( "message", "APP-PH0902 Record Already In Use - It is used by Other User.Please Try again...") ;
				map.put("flag","0");
			}
			else{
				map.put( "result", new Boolean( false ) ) ; 
				map.put( "message", e.getMessage()) ;
				map.put("flag","0");
			}
			try{
				connection.rollback();
			}
			catch(Exception ee){
				ee.printStackTrace() ;
			}
		}//Added for SKR-SCF-0393 IN030939  - end
		catch(Exception e){
			if(retMedRestrStage){ // if condition added for GHL-CRF-0412.3 - Start
				map.put( "result", new Boolean( false ) ) ;	
				map.put( "message", getMessage(getLanguageId(),"CANNOT_RETURN","PH"));
			} // if condition added for GHL-CRF-0412.3 - End
			else{ 
			map.put( "result", new Boolean( false ) ) ; 
			map.put( "message", e.getMessage()) ;
			map.put("flag","0");
			e.printStackTrace() ;
			}
			try{
				connection.rollback();
			}
			catch(Exception ee){
				ee.printStackTrace() ;
			}
		}//catch
		finally{
			try{
				closeResultSet( resultSet ) ;
				closeResultSet( resultSet1 ) ;
				closeStatement( pstmt ) ;
				closeStatement( pstmt1) ;
				closeStatement( pstmt2) ;
				closeStatement( pstmt3) ;
				closeConnection( connection );
			}
			catch(Exception ex){
				ex.printStackTrace() ;
			}
		}//finally
		return map;
	}

	public boolean getBillGenStatus(String patient_id, String ordering_facility_id, String episode_id){ // Added for JD-CRF-0178 [IN:039208] 
		boolean bill_gen_yn = false;
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String discharge_bill_gen_ind = "";
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_SELECT_DISCHARGE_BILL_GEN_IND")) ;
			pstmt.setString(1,patient_id);
			pstmt.setString(2,ordering_facility_id);
			pstmt.setString(3,episode_id);
            resultSet	= pstmt.executeQuery() ;			
			if (resultSet.next()){
				discharge_bill_gen_ind = checkForNull(resultSet.getString("DISCHARGE_BILL_GEN_IND"));
			}
			if(discharge_bill_gen_ind.equals("Y"))
				bill_gen_yn = true;
		}
		catch ( Exception e ) {
			e.printStackTrace() ;			
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
		return bill_gen_yn;
	}
	public String getEpisodeId(String patient_id){
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		String episode_id = "";
		try{
			connection = getConnection() ;
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_SELECT_ENCOUNTER_DTL"));
			pstmt.setString(1, patient_id);
			pstmt.setString(2, login_facility_id);
			resultSet			= pstmt.executeQuery();  
			if(resultSet!=null){
				if(resultSet.next()){
					episode_id = 	resultSet.getString("EPISODE_ID")	;					
				}
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
				es.printStackTrace() ;
			}
		}		
		return episode_id;
	}//code added for FD-JD-CRF-0178[IN039208]--End
	

	// ADDED for  KDAH-CRF-250-U001 By prathyusha .p on 07-04-2016 start
	public String getSysDate() {
		String to_day = "";
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(PhRepository
					.getPhKeyValue("SQL_PH_MEDN_ADMN_DATE_SELECT5"));

			resultSet = pstmt.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					to_day = resultSet.getString("today");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			} catch (Exception es) {
				es.printStackTrace();
			}
		}
		return to_day;
	}

	public ArrayList getDrugDetails(String patientid, String drugcode,
			String nationalid, String healthcard, String dispno, String cutoff,
			String orderid, String displocn, String locale,
			String wardReturnYN, String Ward_Date_From, String ward_Date_To) {

		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		ArrayList result = new ArrayList();
		String ackWC="";//Added for GHL-CRF-0399
		String ack_required = checkToProceed(login_facility_id.trim());//added for mms-kh-crf-0014
		try {
			connection = getConnection();
			//Added for GHL-CRF-0399 start 
			
			//boolean siteAck = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","WARD_ACK"); //Commented for common-icn-0048
			if(ack_required.equals("Y")){//siteAck modified to ack_required for mms-kh-crf-0014
					ackWC="and a.ward_acknowledge = 'A'";
				}
				//Added for GHL-CRF-0399 end
			int cnt = 1;
//Commenting start for GHL-SCF-1084
			//String wardReturnQuery = "SELECT  k.ret_doc_line_no,k.ret_doc_no,a.srl_no,a.srl_no_batch,b.order_id,b.order_line_no,(SELECT short_desc FROM ph_disp_locn WHERE disp_locn_code = j.ret_to_disp_locn_code) location_code,d.drug_desc, a.batch_id, TO_CHAR (a.expiry_date, 'DD/MM/YYYY') expiry_date,a.disp_no,a.disp_qty issuedqty, b.disp_uom_code qtyuom,NVL (k.bal_qty, k.returned_qty) returnable, c.encounter_id,b.issue_qty, b.issue_uom_code,a.item_code,(SELECT short_desc FROM am_uom_lang_vw WHERE uom_code = b.issue_uom_code AND language_id = ?) short_desc,TO_CHAR (k.modified_date, 'DD/MM/YYYY HH24:MI') modified_date,m.reason_desc return_reason FROM (SELECT DRUG_DESC DRUG_DESC, DRUG_CODE DRUG_CODE,NVL (CONTENT_IN_PRES_BASE_UOM, 1) CONTENT_IN_PRES_BASE_UOM FROM PH_DRUG_LANG_VW WHERE LANGUAGE_ID =? UNION SELECT NVL (SHORT_NAME, LONG_NAME) DRUG_DESC,TPN_REGIMEN_CODE DRUG_CODE,NVL (CONTENT_IN_BASE_UNIT, 1) CONTENT_IN_PRES_BASE_UOM FROM PH_TPN_REGIMEN_LANG_VW WHERE STANDARD_REGIMEN_YN = 'Y' AND LANGUAGE_ID = ?) D,PH_DISP_DRUG_BATCH A,PH_DISP_DTL B,PH_DISP_HDR C,MP_PATIENT E,PH_DISP_LOCN_LANG_VW G, OR_ORDER_LINE H,AM_PRACTITIONER_LANG_VW I,PH_WARD_RETURN_HDR J,PH_WARD_RETURN_DTL K,SM_APPL_USER_LANG_VW L,PH_MEDN_TRN_REASON_LANG_VW M,OR_ORDER N ,st_item O WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DISP_NO = B.DISP_NO AND A.SRL_NO = B.SRL_NO AND C.PATIENT_ID = E.PATIENT_ID AND C.FACILITY_ID = B.FACILITY_ID AND C.DISP_NO = B.DISP_NO AND B.DISP_DRUG_CODE = D.DRUG_CODE and c.order_id =n.order_id  and n.ORDERING_FACILITY_ID  =? AND E.PATIENT_ID = ? AND C.FACILITY_ID=J.FACILITY_ID AND C.PATIENT_ID =J.PATIENT_ID AND C.DISP_NO =J.DISP_NO  AND J.FACILITY_ID=K.FACILITY_ID AND J.RET_DOC_NO=K.RET_DOC_NO AND J.DISP_NO   =K.DISP_NO AND B.SRL_NO =K.SRL_NO AND A.SRL_NO_BATCH=K.SRL_NO_BATCH AND NVL(K.BAL_QTY,K.RETURNED_QTY) > 0 AND ( K.STORE_ACKNOWLEDGE_STATUS IS NULL) AND J.ADDED_DATE BETWEEN TO_DATE (?, 'DD/MM/YYYY')AND TO_DATE (?, 'DD/MM/YYYY')+.99999 AND J.FROM_LOCN_CODE =NVL(?,J.FROM_LOCN_CODE) AND J.ADDED_BY_ID =L.APPL_USER_ID AND J.RETURN_REASON=M.REASON_CODE AND M.APPL_TRN_TYPE='T' "+ackWC; //ackWC Added for GHL-CRF-0399
			//wardReturnQuery += "AND A.FACILITY_ID = ?  AND C.ORDER_ID = NVL (?, C.ORDER_ID) AND A.DISP_NO LIKE NVL (?, A.DISP_NO) AND A.DISP_LOCN_CODE = NVL (?, A.DISP_LOCN_CODE) AND A.DISP_QTY <> NVL (A.RETURNED_QTY, 0) and a.item_code=O.item_code AND (( O.USE_AFTER_EXPIRY_YN ='N' and SYSDATE < expiry_date) or  (O.USE_AFTER_EXPIRY_YN ='Y') ) AND A.STORE_CODE = G.DISP_LOCN_CODE AND A.FACILITY_ID = G.FACILITY_ID AND G.LANGUAGE_ID = ? AND H.ORDER_ID = B.ORDER_ID AND H.ORDER_LINE_NUM = B.ORDER_LINE_NO AND H.DISC_PRACT_ID = I.PRACTITIONER_ID(+) AND I.LANGUAGE_ID(+) = ? AND L.LANGUAGE_ID = ? AND M.LANGUAGE_ID = ? AND B.DISP_DRUG_CODE=NVL(?,B.DISP_DRUG_CODE) AND c.ENCOUNTER_ID = Nvl(?,c.ENCOUNTER_ID) and c.patient_class in (?)  order by k.modified_date desc";//modified GHL-CRF-0339
			//Commenting end for GHL-SCF-1084
			//Addign start for GHL-SCF-1084
			String wardReturnQuery = "SELECT  k.ret_doc_line_no,k.ret_doc_no,a.srl_no,a.srl_no_batch,b.order_id,b.order_line_no,(SELECT short_desc FROM ph_disp_locn WHERE disp_locn_code = j.ret_to_disp_locn_code) location_code,d.drug_desc, a.batch_id, TO_CHAR (a.expiry_date, 'DD/MM/YYYY') expiry_date,a.disp_no,a.disp_qty issuedqty, b.disp_uom_code qtyuom,NVL (k.bal_qty, k.returned_qty) returnable, c.encounter_id,b.issue_qty, b.issue_uom_code,a.item_code,(SELECT short_desc FROM am_uom_lang_vw WHERE uom_code = b.issue_uom_code AND language_id = ?) short_desc,TO_CHAR (k.modified_date, 'DD/MM/YYYY HH24:MI') modified_date,(select reason_desc from ph_medn_trn_reason_lang_vw where  appl_trn_type = 'T' and j.return_reason = reason_code  AND language_id = ? and rownum<=1) return_reason  FROM (SELECT DRUG_DESC DRUG_DESC, DRUG_CODE DRUG_CODE,NVL (CONTENT_IN_PRES_BASE_UOM, 1) CONTENT_IN_PRES_BASE_UOM FROM PH_DRUG_LANG_VW WHERE LANGUAGE_ID =? and drug_code BETWEEN NVL (?, '%%') AND NVL (?, drug_code ) UNION SELECT NVL (SHORT_NAME, LONG_NAME) DRUG_DESC,TPN_REGIMEN_CODE DRUG_CODE,NVL (CONTENT_IN_BASE_UNIT, 1) CONTENT_IN_PRES_BASE_UOM FROM PH_TPN_REGIMEN_LANG_VW WHERE STANDARD_REGIMEN_YN = 'Y' AND tpn_regimen_code BETWEEN NVL (?, '%%') and NVL (?, tpn_regimen_code) AND LANGUAGE_ID = ?) D,PH_DISP_DRUG_BATCH A,PH_DISP_DTL B,PH_DISP_HDR C,PH_DISP_LOCN_LANG_VW G,PH_WARD_RETURN_HDR J,PH_WARD_RETURN_DTL K,SM_APPL_USER_LANG_VW L,st_item O WHERE A.FACILITY_ID = B.FACILITY_ID AND A.DISP_NO = B.DISP_NO AND A.SRL_NO = B.SRL_NO  AND C.FACILITY_ID = B.FACILITY_ID AND C.DISP_NO = B.DISP_NO AND B.DISP_DRUG_CODE = D.DRUG_CODE  and c.facility_id=? AND C.PATIENT_ID = ? AND C.FACILITY_ID=J.FACILITY_ID AND C.PATIENT_ID =J.PATIENT_ID AND C.DISP_NO =J.DISP_NO  AND J.FACILITY_ID=K.FACILITY_ID AND J.RET_DOC_NO=K.RET_DOC_NO AND J.DISP_NO   =K.DISP_NO AND B.SRL_NO =K.SRL_NO AND A.SRL_NO_BATCH=K.SRL_NO_BATCH AND NVL(K.BAL_QTY,K.RETURNED_QTY) > 0 AND ( K.STORE_ACKNOWLEDGE_STATUS IS NULL) AND J.ADDED_DATE BETWEEN TO_DATE (?, 'DD/MM/YYYY')AND TO_DATE (?, 'DD/MM/YYYY')+.99999 AND J.FROM_LOCN_CODE =NVL(?,J.FROM_LOCN_CODE) AND J.ADDED_BY_ID =L.APPL_USER_ID  "+ackWC; //ackWC Added for GHL-CRF-0399
			wardReturnQuery += " AND C.ORDER_ID = NVL (?, C.ORDER_ID) AND A.DISP_NO LIKE NVL (?, A.DISP_NO) AND A.DISP_LOCN_CODE = NVL (?, A.DISP_LOCN_CODE) AND A.DISP_QTY <> NVL (A.RETURNED_QTY, 0) and a.item_code=O.item_code AND (( O.USE_AFTER_EXPIRY_YN ='N' and SYSDATE < expiry_date) or  (O.USE_AFTER_EXPIRY_YN ='Y') ) AND A.STORE_CODE = G.DISP_LOCN_CODE AND A.FACILITY_ID = G.FACILITY_ID AND g.language_id = l.language_id AND  G.LANGUAGE_ID = ? and C.order_id = b.order_id and C.disp_no = k.disp_no   AND B.DISP_DRUG_CODE=NVL(?,B.DISP_DRUG_CODE) AND c.ENCOUNTER_ID = Nvl(?,c.ENCOUNTER_ID) and c.patient_class in (?)  order by k.modified_date desc";//modified GHL-CRF-0339 //AND g.language_id = l.language_id ADDED FOR GHL-SCF-1448		//Adding end for GHL-SCF-1084

			String patcat = "I";
			if (patcat.equals("O")) {
				patcat = " 'OP', 'EM', 'XT'";
			} else if (patcat.equals("I")) {
				patcat = " 'IP', 'DC'";
			} else {
				patcat = " 'XT' ";
			}
			int index = wardReturnQuery.lastIndexOf('?');
			wardReturnQuery = wardReturnQuery.substring(0, index) + patcat
					+ wardReturnQuery.substring(index + 1);
			System.err.println("wardReturnQuery=========" + wardReturnQuery);
			System.err.println("patientid====="+patientid+"Ward_Date_From===="+Ward_Date_From+"ward_Date_To===="+ward_Date_To+"orderid===="+orderid+"dispno===="+dispno+"drugcode==="+drugcode+"encounter_id==="+encounter_id);
			pstmt = connection.prepareStatement(wardReturnQuery);
			pstmt.setString(cnt, getLanguageId());
			pstmt.setString(++cnt, getLanguageId());
			pstmt.setString(++cnt, getLanguageId());
			pstmt.setString(++cnt, drugcode.trim());//Added
			pstmt.setString(++cnt, drugcode.trim());//Added
			pstmt.setString(++cnt, drugcode.trim());//Added
			pstmt.setString(++cnt, drugcode.trim());//Added
			pstmt.setString(++cnt, getLanguageId());
			pstmt.setString(++cnt, login_facility_id);// this.orderingfacilityid);
			pstmt.setString(++cnt, patientid.trim());
			pstmt.setString(++cnt, Ward_Date_From);
			pstmt.setString(++cnt, ward_Date_To);
			pstmt.setString(++cnt, "");
			//pstmt.setString(++cnt, login_facility_id.trim());//Commented for GHL-SCF-1084
			pstmt.setString(++cnt, orderid.trim());
			pstmt.setString(++cnt,dispno );
			pstmt.setString(++cnt, "");
			pstmt.setString(++cnt, getLanguageId());
			//pstmt.setString(++cnt, getLanguageId());//Commented for GHL-SCF-1084
			//pstmt.setString(++cnt, getLanguageId());//Commented for GHL-SCF-1084
			//pstmt.setString(++cnt, getLanguageId());//Commented for GHL-SCF-1084
			pstmt.setString(++cnt, drugcode.trim());
			pstmt.setString(++cnt, encounter_id.trim());

			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {

				result.add(resultSet.getString("DRUG_DESC")); // 0
				result.add(resultSet.getString("ENCOUNTER_ID")); // 1
				result.add(resultSet.getString("BATCH_ID")); // 2
				result.add(resultSet.getString("EXPIRY_DATE")); // 3
				result.add(resultSet.getString("DISP_NO")); // 4
				result.add(resultSet.getString("LOCATION_CODE"));// 5
				result.add(resultSet.getString("MODIFIED_DATE")); // 6
				result.add(resultSet.getString("ISSUEDQTY") == null ? ""
						: resultSet.getString("ISSUEDQTY")); // 7
				result.add(resultSet.getString("RETURNABLE")); // 8
				result.add(resultSet.getString("QTYUOM")); // 9
				result.add(resultSet.getString("RETURN_REASON")); // 10
				result.add(resultSet.getString("ITEM_CODE")); // 11
				result.add(resultSet.getString("SRL_NO")); // 12
				result.add(resultSet.getString("SRL_NO_BATCH")); // 13
				result.add(resultSet.getString("ORDER_ID")); // 14
				result.add(resultSet.getString("ORDER_LINE_NO")); // 15
				result.add(resultSet.getString("RET_DOC_NO")); // 16
				result.add(resultSet.getString("RET_DOC_LINE_NO")); // 17
				 
				

			}

		} catch (Exception e) {
			e.printStackTrace();
			result.add(e.toString());
		} finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			} catch (Exception es) {
				es.printStackTrace();
			}
		}
		return result;
	}

	public String getUomDisplay(String facility_id, String uom_code) {

		String uomDisplay = uom_code;
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		PreparedStatement pstmt = null;
		try {
			connection = getConnection();
			//statement = connection.createStatement();
			pstmt = connection.prepareStatement("select PH_GET_UOM_DISPLAY(?,?,?) UOM_DISPLAY from dual");
			//resultSet = statement.executeQuery("select PH_GET_UOM_DISPLAY('"+ facility_id + "','" + uom_code + "','" + language_id+ "') UOM_DISPLAY from dual");
			pstmt.setString(1,facility_id ); // COMMON-ICN-0184
			pstmt.setString(2,uom_code ); // COMMON-ICN-0184
			pstmt.setString(3,language_id ); // COMMON-ICN-0184
			resultSet=pstmt.executeQuery();

			if (resultSet != null && resultSet.next()) {
				uomDisplay = resultSet.getString("UOM_DISPLAY");
			}

		} catch (Exception e) {
			e.printStackTrace();
			uomDisplay = uom_code;
		} finally {
			try {
				closeResultSet(resultSet);
				// closeStatement( callableStatement ) ;
				closeStatement(statement);
				closeConnection(connection);
			} catch (Exception es) {
				es.printStackTrace();
			}
		}
		return uomDisplay == null ? "" : uomDisplay;
	}
	public ArrayList getFrom_and_To_date() {
		ArrayList from_and_to_date=new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_PAT_SPEC_DRUG_DATE_RANGE_SELECT" )) ;
			
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					from_and_to_date.add(resultSet.getString( "today" ));
					from_and_to_date.add(resultSet.getString("todayminusthirty"));
					
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
			catch(Exception es) {es.printStackTrace();}
		}

		return from_and_to_date;
	}

	// ADDED for KDAH-CRF-250-U001 By prathyusha .p on 07-04-2016 end
	
	public HashMap modify(){//Added modify method for KDAH-CRF-0250 [IN:039018]
		HashMap map = new HashMap();
		boolean successFlag = false;
		int tot_rec=Integer.parseInt((String)recordSet.get("total_count"));
		ArrayList insertRow				= new ArrayList();
		Connection con=null;
		PreparedStatement pstmt = null;
	
		for(int i=1;i<=tot_rec;i++){
			if (((String)recordSet.get("chk_"+ i)).trim().equals("Y")){
				insertRow.add(recordSet.get("dispno"+i));
				insertRow.add(recordSet.get("srlno"+i));
				insertRow.add(recordSet.get("srlnobatch"+i));
				insertRow.add(recordSet.get("retdocno"+i));
				insertRow.add(recordSet.get("retdoclineno"+i));
			}
		}
		try{
		con = getConnection();
		pstmt = con.prepareStatement("UPDATE PH_WARD_RETURN_DTL A SET A.STORE_ACKNOWLEDGE_STATUS='C' WHERE DISP_NO = ? AND SRL_NO = ? AND SRL_NO_BATCH = ? AND RET_DOC_NO = ? AND RET_DOC_LINE_NO = ?");
		if(insertRow.size()>0){
			for(int j=0;j<insertRow.size();j+=5){
				pstmt.setString(1,(String) insertRow.get(j));
				pstmt.setString(2,(String) insertRow.get(j+1));
				pstmt.setString(3,(String) insertRow.get(j+2));
				pstmt.setString(4,(String) insertRow.get(j+3));
				pstmt.setString(5,(String) insertRow.get(j+4));
				pstmt.executeUpdate();
				successFlag = true;
			}
			
		}else{
			map.put( "result", new Boolean( false ) ) ;	
			map.put( "message", getMessage(getLanguageId(),"PH_REASON_ONE_SELECTED","PH") ) ;
		}
		if(successFlag){
			con.commit();
		map.put( "result", new Boolean( true ) ) ;	
		map.put( "message", getMessage(getLanguageId(),"RECORD_INSERTED","PH") ) ;
		}
		}catch (Exception e) {
			e.printStackTrace();
			map.put( "result", new Boolean( false ) ) ;	
			map.put( "message", "ERROR While updating the record in PH_WARD_RETURN_DTL"+e.getMessage() ) ;
		}finally{
			try{
			con.close();
			pstmt.close();
			}catch (Exception eclose) {
				// TODO: handle exception
				eclose.printStackTrace();
			}
		}
		
		return map;
	}
	public ArrayList getDischargeStage(String facilityId, String encounterId,String patientId) {  // Added for GHL-CRF-0412.3 - Start
		ArrayList result  = 	new ArrayList();;
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
        try {
            connection = getConnection() ;

			String sql="SELECT a.pre_dis_initiate_yn, a.oth_adt_status, b.ret_medic_restr_stage FROM ip_open_encounter a,ph_facility_param b WHERE a.encounter_id =? AND a.facility_id =? AND a.patient_id =? AND a.facility_id = b.facility_id";
			pstmt = connection.prepareStatement(sql) ;
			pstmt.setString(1,encounterId);
			pstmt.setString(2,facilityId);
			pstmt.setString(3,patientId);
            resultSet = pstmt.executeQuery();
            while ( resultSet.next() ) {
            	result.add(resultSet.getString("PRE_DIS_INITIATE_YN")==null?"":resultSet.getString("PRE_DIS_INITIATE_YN"));
				result.add(resultSet.getString("OTH_ADT_STATUS")==null?"":resultSet.getString("OTH_ADT_STATUS"));
				result.add(resultSet.getString("RET_MEDIC_RESTR_STAGE")==null?"":resultSet.getString("RET_MEDIC_RESTR_STAGE"));
			}
            if(result.size()==0){
            	sql="select a.adt_status,b.ret_medic_restr_stage from pr_encounter a,ph_facility_param b WHERE a.encounter_id =? AND a.facility_id =? AND a.patient_id =? AND a.facility_id = b.facility_id";
            	pstmt = connection.prepareStatement(sql) ;
    			pstmt.setString(1,encounterId);
    			pstmt.setString(2,facilityId);
    			pstmt.setString(3,patientId);
                resultSet = pstmt.executeQuery();
                
                while ( resultSet.next() ) {
    				result.add(resultSet.getString("ADT_STATUS")==null?"":resultSet.getString("ADT_STATUS"));
    				result.add(resultSet.getString("RET_MEDIC_RESTR_STAGE")==null?"":resultSet.getString("RET_MEDIC_RESTR_STAGE"));
    			}
            }
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			result.add(e.toString());
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
           return result;       
    }	 // Added for GHL-CRF-0412.3 - End	
public boolean isSiteSpecific(String moduleId, String functionalityId){ //Added for GHL-CRF-0413.8 - Start
		boolean site=false;
	    Connection con	= null;  
        try{
        	con =			getConnection();		
        	site = eCommon.Common.CommonBean.isSiteSpecific(con,moduleId,functionalityId);	
		}
        catch(Exception e){
            e.printStackTrace();
        }
		finally{
			try{
			closeConnection(con);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return site;
   } //Added for GHL-CRF-0413.8 - End
//ADDED FOR MMS-KH-CRF-0014 START
	public String checkToProceed(String facility_id) {
	    	String result		= "";
			Connection connection	= null;
			PreparedStatement pstmt	= null;
			ResultSet resultSet		= null;
			try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_WRD_ACK_APPLICABLE_YN") ) ;
				pstmt.setString(1,facility_id.trim());
				resultSet = pstmt.executeQuery() ;
				if ( resultSet.next() ) {
					//result=resultSet.getString("WARD_ACK_REQUIRED_YN");
					result=resultSet.getString("WARD_ACK_REQUIRED_YN")==null?"N":resultSet.getString("WARD_ACK_REQUIRED_YN");
					}
					closeStatement(pstmt);
				closeResultSet(resultSet);
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
				catch(Exception es) { es.printStackTrace();
			}
				}
	
			return result;
	}
	//ADDED FOR MMS-KH-CRF-0014 END
  
}
