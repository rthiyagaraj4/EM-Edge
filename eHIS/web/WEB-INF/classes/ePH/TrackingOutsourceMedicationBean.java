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
import ePH.TrackingOutsourceMedn.*;

public class TrackingOutsourceMedicationBean extends PhAdapter implements Serializable {

	private String source = "";
	private String user_name = "";
	private String pinNo = "";
	private String today_date	= "";
	private String today_date_time	= "";
	private String date_plus_365 = "";	
	private String date_plus_30	= "";
	private String date_minus_30= "";
	private String disp_locn_code = "";
	private String disp_locn_name = "";
	private String password	 = "";
	private String order_type = "";
	private String trackingAction = "";
	private String referral_facility = "";
	private String tracking_remarks = "";
	private HashMap access_details = null;
	private HashMap hmTrackingDetails = null;
	private HashMap hmOutsourceProductDetails = null;

	public String getTodayDate(){
		return this.today_date;
	}
	public void setTodayDate(String today_date){
		this.today_date = today_date;
	}
	public String getSource(){
		return this.source;
	}
	public void setSource(String source){
		this.source = source;
	}
	public String getUserName(){
		return this.user_name;
	}
	public void setUserName(String user_name){
		this.user_name = user_name;
	}
	public String getPassword(){
		return this.password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getPinNo(){
		return this.pinNo;
	}
	public void setPinNo(String pinNo){
		this.pinNo = pinNo;
	}
	public void setDispLocnCode(String disp_locn_code){
		this.disp_locn_code = disp_locn_code;
	}
	public String getDispLocnCode(){
		return disp_locn_code;
	}
	public String getDispLocnName(){
		return this.disp_locn_name;
	}
	public void setDispLocnName(String disp_locn_name){
		this.disp_locn_name = disp_locn_name;
	}
	public void setAccessDetails(HashMap access_details){
		this.access_details = access_details;
	}
	public HashMap getAccessDetails(){
		return 	access_details;
	}
	public String getDate_plus_30(){
		return this.date_plus_30;
	}
	public void setDate_plus_30(String date_plus_30){
		this.date_plus_30 = date_plus_30;
	}
	public String getDate_minus_30(){
		return this.date_minus_30;
	}
	public void setDate_minus_30(String date_minus_30){
		this.date_minus_30=date_minus_30;
	}
	public String getOrderType(){
		return this.order_type;
	}
	public void setOrderType(String order_type){
		this.order_type=order_type;
	}
	public String getTrackingAction(){
		return this.trackingAction;
	}
	public void setTrackingAction(String trackingAction){
		this.trackingAction=trackingAction;
	}
	public String getReferralFacility(){
		return this.referral_facility;
	}
	public void setReferralFacility(String referral_facility){
		this.referral_facility=referral_facility;
	}
	public String getTrackingRemarks(){
		return this.tracking_remarks;
	}
	public void setTrackingRemarks(String tracking_remarks){
		this.tracking_remarks=tracking_remarks;
	}
	public HashMap getTrackingDetails(){
		if(hmTrackingDetails ==null)
			hmTrackingDetails = new HashMap();
		return this.hmTrackingDetails;
	}
	public void setTrackingDetails(HashMap hmTrackingDetails){
		this.hmTrackingDetails=hmTrackingDetails;
	}
	public void clearTrackingDetails(){
		this.hmTrackingDetails.clear();
		setTrackingRemarks("");
	}
	public HashMap getOutsourceProductDetails(){
		if(hmOutsourceProductDetails ==null)
			hmOutsourceProductDetails = new HashMap();
		return this.hmOutsourceProductDetails;
	}
	public void setOutsourceProductDetails(HashMap hmOutsourceProductDetails){
		this.hmOutsourceProductDetails=hmOutsourceProductDetails;
	}
	public void clearOutsourceProductDetails(){
		this.hmOutsourceProductDetails.clear();
	}
	public void setAll( Hashtable recordSet ) {
		if(recordSet.get("mode") != null){
             mode = (String)recordSet.get("mode") ;
		}
		if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
			if(recordSet.get("OUTSOURCING_REF_FACILITY") != null){
				 setReferralFacility((String)recordSet.get("OUTSOURCING_REF_FACILITY"));
			}
		}
		else{
			if(recordSet.get("TRACKING_REF_FACILITY") != null){
				 setReferralFacility((String)recordSet.get("TRACKING_REF_FACILITY"));
			}
		}
	/*	if(recordSet.get("remarks") != null){
             setTrackingRemarks((String)recordSet.get("remarks"));
		}*/
	}

	public void clear(){
		source = "";                 
		user_name = "";              
		pinNo = "";                  
		today_date	= "";           
		today_date_time	= "";       
		date_plus_365 = "";	        
		date_plus_30	= "";           
		date_minus_30= "";           
		disp_locn_code = "";         
		disp_locn_name = "";         
		password	 = "";              
		order_type = "";             
		trackingAction = "";         
		access_details = null;      
		hmTrackingDetails = null; 
	}

	public void clearOutSourceDtls(){
		hmTrackingDetails = null;
		hmOutsourceProductDetails = null;
	}
	public ArrayList checkToProceed(String facility_id) {
		setTodaysDate();
		ArrayList result		= new ArrayList();
		Connection connection	= null;
		PreparedStatement pstmt	= null;
		ResultSet resultSet		= null;
		try {
			connection = getConnection() ;
			boolean proceed			= false;
			String disp_locn_code	= "";
			// Get the logged in user password
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT31") ) ;
			pstmt.setString(1,login_by_id.trim());
			pstmt.setString(2,getLanguageId());
			resultSet = pstmt.executeQuery() ;
			if ( resultSet.next() ) {
				setUserName(resultSet.getString("APPL_USER_NAME"));
				setPinNo(resultSet.getString("PIN_NO"));			
			}
			closeStatement(pstmt);
			closeResultSet(resultSet);

			//CHECK WHETHER LOGGED-IN USER IS PHARMACIST OR NOT.
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT1") ) ;
			pstmt.setString(1,login_by_id.trim());
			resultSet = pstmt.executeQuery() ;

			if ( resultSet.next() ) {
				proceed	= true ;
			}
			else {
				result.add("NO DISPLAY-1");
				return result;
			}

			//CHECK WHETHER OR MODULE IS INSTALLED OR NOT.
			if (proceed) {
				proceed = false ;
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT2") ) ;
				resultSet = pstmt.executeQuery() ;
				if ( resultSet.next() ) {
					proceed = true ;
				}
				else {
					result.add("NO DISPLAY-2");
					return result;
				}
			}

			//CHECK WHETHER LOGGED-IN WORKSTATION NO. MAPS WITH THE WS_NO IN PH_WS_NO_FOR_DISP_LOCN
			if (proceed) {
				proceed = false ;
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;

				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT3") ) ;
				pstmt.setString(1,facility_id.trim());
				pstmt.setString(2,login_at_ws_no.trim());
				resultSet = pstmt.executeQuery() ;

				if (resultSet.next()) {
					disp_locn_code = disp_locn_code + " AND (A.DISP_LOCN_CODE = '" + resultSet.getString("DISP_LOCN_CODE") + "' OR ";
					while ( resultSet.next() ) {
						disp_locn_code = disp_locn_code + "A.DISP_LOCN_CODE = '";
						disp_locn_code = disp_locn_code + resultSet.getString("DISP_LOCN_CODE") + "' OR ";
					}
					disp_locn_code = disp_locn_code.substring(0, disp_locn_code.length()-4);
					disp_locn_code = disp_locn_code + ") ORDER BY 1";
					proceed = true ;
				}
				else {
					result.add("NO DISPLAY-3");
					return result;
				}
			}

			//CHECK FOR DISP_REGN_REQD_YN='Y/N' AND ISSUE_TOKEN_ON_REGN_YN='Y/N' IN PH_DISP_LOCN TABLE AND ACK_YN='Y' IN PH_DISP_RIGHTS TABLE FOR THE GENERATED DISP_LOCN_CODE's IN THE ABOVE STAGE
			if (proceed) {
				proceed = false ;
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				// This block will be executed if the method is called from Dispense Medication function
				String sql ="SELECT a.short_desc, a.disp_locn_code  FROM ph_disp_locn_lang_vw a, ph_disp_rights b WHERE a.facility_id = ? AND b.facility_id = a.facility_id  AND b.appl_user_id = ? AND a.disp_locn_code = b.disp_locn_code AND B.TRACK_OUTSOURCING_YN = 'Y' AND a.language_id = ? "+disp_locn_code;
				pstmt = connection.prepareStatement( sql ) ;
				disp_locn_code = "";
				pstmt.setString(1,facility_id.trim());
				pstmt.setString(2,login_by_id.trim());
				pstmt.setString(3,getLanguageId());
				resultSet = pstmt.executeQuery() ;
				if ( resultSet.next() ) {
					disp_locn_code = resultSet.getString("DISP_LOCN_CODE") + ","+ resultSet.getString("SHORT_DESC") + "|";
					while ( resultSet.next() ) {
						disp_locn_code = disp_locn_code + resultSet.getString("DISP_LOCN_CODE") + ","+ resultSet.getString("SHORT_DESC") + "|" ;
					}
					result.add(disp_locn_code);
				}
				else {
					result.add("NO DISPLAY-4");
					return result;
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
				es.printStackTrace();
			}
		}
		return result;
	}

	public void setTodaysDate(){
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null;
		try{
			connection	= getConnection() ;
			// pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT25") ) ;
			pstmt		=connection.prepareStatement("SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') TODAY,TO_CHAR(SYSDATE,'DD/MM/YYYY hh24:mi') TODAY_DATE_TIME,TO_CHAR(SYSDATE+365,'DD/MM/YYYY') DATE_PLUS_365 , TO_CHAR(SYSDATE+30,'DD/MM/YYYY') DATE_PLUS_30, TO_CHAR(SYSDATE-30,'DD/MM/YYYY') DATE_minus_30 FROM DUAL");
			resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
				setTodayDate(resultSet.getString("TODAY"));
				this.today_date_time	= resultSet.getString("TODAY_DATE_TIME");
				this.date_plus_365		= resultSet.getString("DATE_PLUS_365");
				this.date_plus_30		= resultSet.getString("DATE_PLUS_30");
				this.date_minus_30		= resultSet.getString("DATE_minus_30");
			}
		}
		catch(Exception e){
			e.printStackTrace();
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
	}
	public boolean validateThePassword(String password)throws Exception{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null;
		try{
			connection	= getConnection() ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT27") ) ;
			pstmt.setString(1,login_by_id.trim());
			resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
				if((resultSet.getString("PASSWORD")).equals(password)){
					return true;
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
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
		return false;
	}
	public void setAccessDetails(String disp_locn)throws Exception{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null;
		HashMap hmAccessDetail = new HashMap();
		try{
			connection	= getConnection() ;
			String sql = "SELECT OUTSOURCING_SEND_YN, OUTSOURCING_RECEIVE_YN, OUTSOURCING_DELIVER_YN, OUTSOURCING_DEF_ACTION, OUTSOURCING_DEF_FACILITY FROM  ph_disp_rights  WHERE facility_id = ? AND appl_user_id = ? AND disp_locn_code = ? AND TRACK_OUTSOURCING_YN = 'Y' ";
			pstmt		= connection.prepareStatement( sql ) ;
			pstmt.setString(1,login_facility_id.trim());
			pstmt.setString(2,login_by_id.trim());
			pstmt.setString(3,disp_locn.trim());
			resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
				hmAccessDetail.put("OUTSOURCING_SEND_YN", checkForNull(resultSet.getString("OUTSOURCING_SEND_YN"),"N") );
				hmAccessDetail.put("OUTSOURCING_RECEIVE_YN", checkForNull(resultSet.getString("OUTSOURCING_RECEIVE_YN"),"N") );
				hmAccessDetail.put("OUTSOURCING_DELIVER_YN", checkForNull(resultSet.getString("OUTSOURCING_DELIVER_YN"),"N") );
				hmAccessDetail.put("OUTSOURCING_DEF_ACTION", checkForNull(resultSet.getString("OUTSOURCING_DEF_ACTION"),"") );
				hmAccessDetail.put("OUTSOURCING_DEF_FACILITY", checkForNull(resultSet.getString("OUTSOURCING_DEF_FACILITY"),"") );
			}
			setAccessDetails(hmAccessDetail);
		}
		catch(Exception e){
			e.printStackTrace();
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
	}

	public ArrayList getReferralFacilities() {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList referralFcy = new ArrayList();
		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ORDER_ROUTING_SELECT1A" )) ;
			
			pstmt.setString(1,login_facility_id.trim());
			pstmt.setString(2,getLanguageId());
			resultSet = pstmt.executeQuery() ;			

			while (resultSet.next()) {
				referralFcy.add(resultSet.getString("FACILITY_ID"));
				referralFcy.add(resultSet.getString("FACILITY_NAME"));
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
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
		return referralFcy;
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

	public ArrayList getIVLegends() throws Exception{	
		Connection connection			= null ;
		PreparedStatement pstmt			= null ;
		ResultSet resultSet				= null;
		ArrayList iv_legends			= new ArrayList();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT127") ) ;
			pstmt.setString(1,getLanguageId());
			resultSet = pstmt.executeQuery() ;
			while( resultSet.next() ) {
				iv_legends.add("IVAD");
				iv_legends.add(resultSet.getString("iv_drug_fluid_continuous_dir"));
				iv_legends.add("IVAA");
				iv_legends.add(resultSet.getString("iv_drug_fluid_continuous_adm"));
				iv_legends.add("IVID");
				iv_legends.add(resultSet.getString("IV_DRUG_FLUID_INTERMITTENT_dir"));
				iv_legends.add("IVIA");
				iv_legends.add(resultSet.getString("IV_DRUG_FLUID_INTERMITTENT_adm"));
				iv_legends.add("IVWA");
				iv_legends.add(resultSet.getString("IV_WITHOUT_ADDITIVES_LG")); 
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
		return iv_legends;
	}

	public ArrayList queryTrackingDetails(String trackingAction, String order_date_from, String order_date_to, String patient_id, String drug_code, String from,String to){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ; 
		ArrayList alTrackingDetailsTmp = new ArrayList();
		HashMap hmTrackingDetails = new HashMap();
		int index=0;
		String prevnextlink			= "";
		int query_result_size		= 10;
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
		try{
			connection			= getConnection() ;
			StringBuffer sbSql = new StringBuffer();
			StringBuffer sbOutSourceIdList= new StringBuffer();
			if(trackingAction.equals("S")){
				sbSql.append("SELECT a.patient_id, a.ENCOUNTER_ID, NVL (DECODE (?, 'en', pat.patient_name, pat.patient_name_loc_lang ), pat.patient_name ) patient_name, get_age (pat.date_of_birth) age, pat.sex, a.order_id, b.order_line_num, B.ORDER_CATALOG_CODE, c.GENERIC_ID , drug.drug_desc, TO_CHAR (a.ord_date_time, 'DD/MM/YYYY HH24:MI') ord_date_time, a.source_type, a.source_code, (CASE WHEN (a.source_type = 'C' OR a.source_type = 'E') THEN (SELECT short_desc FROM op_clinic_lang_vw WHERE facility_id = a.ordering_facility_id AND clinic_code = a.source_code AND language_id = ?) ELSE (SELECT short_desc FROM ip_nursing_unit_lang_vw WHERE facility_id = a.ordering_facility_id AND nursing_unit_code = a.source_code AND language_id = ?) END ) source_desc, a.ord_pract_id, f.practitioner_name, a.ordering_facility_id, g.facility_name, K.ORDER_STATUS_TYPE FROM or_order a, or_order_line b, or_order_line_ph c, mp_patient pat, (SELECT drug_desc drug_desc, drug_code drug_code, LANGUAGE_ID FROM ph_drug_lang_vw  WHERE (DISCONTINUED_YN IS NULL OR DISCONTINUED_YN !='Y')  UNION SELECT NVL (short_name, long_name) drug_desc, tpn_regimen_code drug_code, LANGUAGE_ID FROM ph_tpn_regimen_lang_vw  WHERE (DISCONTINUED_YN IS NULL OR DISCONTINUED_YN !='Y')) drug, am_practitioner_lang_vw f, sm_facility_param_lang_vw g, OR_ORDER_STATUS_CODE K WHERE a.order_id = b.order_id AND a.order_id = c.order_id AND b.order_line_num = c.order_line_num AND c.complete_order_reason = '*SE' and b.ORDER_LINE_STATUS = K.ORDER_STATUS_CODE AND a.patient_id = pat.patient_id AND b.order_catalog_code = drug.drug_code AND a.ord_pract_id = f.practitioner_id AND a.ordering_facility_id = g.facility_id AND a.ord_date_time BETWEEN TO_DATE (?, 'DD/MM/YYYY' ) AND TO_DATE (?, 'DD/MM/YYYY' )+.99999 AND B.ORDER_LINE_STATUS IN ('DF','DE') AND A.PERFORMING_DEPTLOC_CODE =?");    // Added for CRF-PH- Bru-HIMS-CRF-087/12 -TPN  IN#38706//DE ADDED FOR MMS-KH-CRF-0014   
				//sbSql.append("SELECT a.patient_id, a.ENCOUNTER_ID, NVL (DECODE (?, 'en', pat.patient_name, pat.patient_name_loc_lang ), pat.patient_name ) patient_name, get_age (pat.date_of_birth) age, pat.sex, a.order_id, b.order_line_num, B.ORDER_CATALOG_CODE , c.GENERIC_ID, or_get_order_catalog(a.order_id, A.ORDER_TYPE_CODE, ?, F.PRACT_TYPE, b.order_line_num ) drug_dtl,TO_CHAR (a.ord_date_time, 'DD/MM/YYYY HH24:MI') ord_date_time, a.source_type, a.source_code, (CASE WHEN (a.source_type = 'C' OR a.source_type = 'E') THEN (SELECT short_desc FROM op_clinic_lang_vw WHERE facility_id = a.ordering_facility_id AND clinic_code = a.source_code AND language_id = ?) ELSE (SELECT short_desc FROM ip_nursing_unit_lang_vw WHERE facility_id = a.ordering_facility_id AND nursing_unit_code = a.source_code AND language_id = ?) END ) source_desc, a.ord_pract_id, f.practitioner_name, a.ordering_facility_id, g.facility_name, K.ORDER_STATUS_TYPE FROM or_order a, or_order_line b, or_order_line_ph c, mp_patient pat, am_practitioner_lang_vw f, sm_facility_param_lang_vw g, OR_ORDER_STATUS_CODE K WHERE a.order_id = b.order_id AND a.order_id = c.order_id AND b.order_line_num = c.order_line_num AND c.complete_order_reason = '*SE'  and b.ORDER_LINE_STATUS = K.ORDER_STATUS_CODE AND a.patient_id = pat.patient_id AND  a.ord_pract_id = f.practitioner_id AND a.ordering_facility_id = g.facility_id AND a.ord_date_time BETWEEN TO_DATE (?, 'DD/MM/YYYY' ) AND TO_DATE (?, 'DD/MM/YYYY' )+.99999 AND B.ORDER_LINE_STATUS='DF' AND A.PERFORMING_DEPTLOC_CODE =?");
				if(patient_id!=null && !patient_id.equals(""))
					sbSql.append(" AND a.patient_id=?");
				if(getOrderType().equals("NOR")) {
					sbSql.append(" AND (A.IV_PREP_YN IS NULL OR A.IV_PREP_YN='N') ");
				}
				else if(getOrderType().equals("IVAD")) {
					sbSql.append(" AND A.IV_PREP_YN IN('1') ");
				}
				else if(getOrderType().equals("IVAA")) {
					sbSql.append(" AND A.IV_PREP_YN IN('2') ");
				}
				else if(getOrderType().equals("IVWA")) {
					sbSql.append( " AND A.IV_PREP_YN IN('5') ");
				}
				else if(getOrderType().equals("IVID")) {
					sbSql.append(" AND A.IV_PREP_YN IN('3') ");
				}
				else if(getOrderType().equals("IVIA")) {
					sbSql.append(" AND A.IV_PREP_YN IN('4') ");
				}
				else if(getOrderType().equals("TD")) {
					sbSql.append( " AND A.IV_PREP_YN ='7' ");
				}
				else if(getOrderType().equals("TA")) {
					sbSql.append(" AND A.IV_PREP_YN ='8' ");
				}
				else if(getOrderType().equals("CD")) {
					sbSql.append(" AND A.IV_PREP_YN = '9' ");
				}
				else if(getOrderType().equals("CA")) {
					sbSql.append( " AND A.IV_PREP_YN = '0' ");
				}
				else if(getOrderType().equals("CO")) {
					sbSql.append( " AND A.IV_PREP_YN = '6' ");
				}
				if(drug_code!=null && !drug_code.equals(""))
					sbSql.append(" AND b.order_catalog_code=?");
				sbSql.append(" AND drug.language_id = ? AND f.language_id = ? AND g.language_id = ? ORDER BY a.patient_id, patient_name, a.ord_date_time");

				pstmt				= connection.prepareStatement( sbSql.toString()) ;
				pstmt.setString(++index,getLanguageId());
				pstmt.setString(++index,getLanguageId());
				pstmt.setString(++index,getLanguageId());
				pstmt.setString(++index,order_date_from);
				pstmt.setString(++index,order_date_to);
				pstmt.setString(++index,getDispLocnCode());
				if(patient_id!=null && !patient_id.equals(""))
					pstmt.setString(++index,patient_id);
				if(drug_code!=null && !drug_code.equals(""))
					pstmt.setString(++index,drug_code);

				pstmt.setString(++index,getLanguageId());
				pstmt.setString(++index,getLanguageId());
				pstmt.setString(++index,getLanguageId());
				resultSet	= pstmt.executeQuery(); 
				alTrackingDetailsTmp.add("link");
				if( resultSet != null ) { 
					while(resultSet.next()&& i <= end+1){
						if( start != 1 && (i+1) < start ) {
							i++;
							continue;
						}
						else i++;
							count++ ;
						if(i<=end) {
							hmTrackingDetails = new HashMap();
							hmTrackingDetails.put("PATIENT_ID",checkForNull(resultSet.getString("PATIENT_ID")));
							hmTrackingDetails.put("ENCOUNTER_ID",checkForNull(resultSet.getString("ENCOUNTER_ID")));
							hmTrackingDetails.put("PATIENT_NAME",checkForNull(resultSet.getString("PATIENT_NAME")));
							hmTrackingDetails.put("AGE",checkForNull(resultSet.getString("AGE")));
							hmTrackingDetails.put("SEX",checkForNull(resultSet.getString("SEX")));
							hmTrackingDetails.put("ORDER_ID",checkForNull(resultSet.getString("ORDER_ID")));
							hmTrackingDetails.put("ORDER_LINE_NUM",checkForNull(resultSet.getString("ORDER_LINE_NUM")));
							hmTrackingDetails.put("ORDER_STATUS_TYPE",checkForNull(resultSet.getString("ORDER_STATUS_TYPE")));
							hmTrackingDetails.put("DRUG_CODE",checkForNull(resultSet.getString("ORDER_CATALOG_CODE")));
							hmTrackingDetails.put("GENERIC_ID",checkForNull(resultSet.getString("GENERIC_ID")));
							hmTrackingDetails.put("DRUG_DESC",checkForNull(resultSet.getString("DRUG_DESC")));
							hmTrackingDetails.put("ORD_DATE_TIME",checkForNull(resultSet.getString("ORD_DATE_TIME")));
							hmTrackingDetails.put("SOURCE_TYPE",checkForNull(resultSet.getString("SOURCE_TYPE")));
							hmTrackingDetails.put("SOURCE_CODE",checkForNull(resultSet.getString("SOURCE_CODE")));
							hmTrackingDetails.put("SOURCE_DESC",checkForNull(resultSet.getString("SOURCE_DESC")));
							hmTrackingDetails.put("ORD_PRACT_ID",checkForNull(resultSet.getString("ORD_PRACT_ID")));
							hmTrackingDetails.put("PRACTITIONER_NAME",checkForNull(resultSet.getString("PRACTITIONER_NAME")));
							hmTrackingDetails.put("ORDERING_FACILITY_ID",checkForNull(resultSet.getString("ORDERING_FACILITY_ID")));
							hmTrackingDetails.put("FACILITY_NAME",checkForNull(resultSet.getString("FACILITY_NAME")));
							//hmTrackingDetails.put("",checkForNull(resultSet.getString("")));
							//hmTrackingDetails.put("",checkForNull(resultSet.getString("")));
							alTrackingDetailsTmp.add(hmTrackingDetails);
						}
					}
				}	
			}
			else {
				if(trackingAction.equals("R")){
					//sbSql.append("SELECT a.patient_id, a.encounter_id, NVL (DECODE (?, 'en', pat.patient_name, pat.patient_name_loc_lang), pat.patient_name ) patient_name, get_age (pat.date_of_birth) age, pat.sex, a.order_id, b.order_line_num, b.order_catalog_code, c.generic_id, drug.drug_desc, TO_CHAR (a.ord_date_time, 'DD/MM/YYYY HH24:MI') ord_date_time, a.source_type, a.source_code, (CASE WHEN (a.source_type = 'C' OR a.source_type = 'E') THEN (SELECT short_desc FROM op_clinic_lang_vw WHERE facility_id = a.ordering_facility_id AND clinic_code = a.source_code AND language_id = ?) ELSE (SELECT short_desc FROM ip_nursing_unit_lang_vw WHERE facility_id = a.ordering_facility_id AND nursing_unit_code = a.source_code AND language_id = ?) END ) source_desc, a.ord_pract_id, f.practitioner_name, a.ordering_facility_id, g.facility_name, k.order_status_type, a.patient_class, om.outsource_id, om.facility_id, om.REFERRAL_FACILITY, om.OUTSOURCED_BY,  (select practitioner_name from am_practitioner_lang_vw where PRACTITIONER_ID=om.outsourced_by and language_id='en' ) outsourced_pract_name, TO_CHAR (om.OUTSOURCED_DATE, 'DD/MM/YYYY HH24:MI') OUTSOURCED_DATE, OUTSOURCED_REMARKS FROM or_order a, or_order_line b, or_order_line_ph c, mp_patient pat, (SELECT drug_desc drug_desc, drug_code drug_code, language_id FROM ph_drug_lang_vw WHERE discontinued_yn != 'Y' UNION SELECT NVL (short_name, long_name) drug_desc, tpn_regimen_code drug_code, language_id FROM ph_tpn_regimen_lang_vw WHERE discontinued_yn != 'Y') drug, am_practitioner_lang_vw f, sm_facility_param_lang_vw g, or_order_status_code k, PH_OUTSOURCE_MEDN om WHERE a.order_id = b.order_id AND a.order_id = c.order_id AND b.order_line_num = c.order_line_num and b.order_id = om.order_id and b.order_line_num = om.order_line_num  and om.REFERRAL_FACILITY = ? AND c.complete_order_reason = '*SE' AND b.order_line_status = k.order_status_code AND a.patient_id = pat.patient_id AND b.order_catalog_code = drug.drug_code AND a.ord_pract_id = f.practitioner_id AND a.ordering_facility_id = g.facility_id AND a.ord_date_time BETWEEN TO_DATE (?, 'DD/MM/YYYY') AND TO_DATE (?, 'DD/MM/YYYY') + .99999 AND b.order_line_status = 'SE' AND om.disp_locn_code = ? ");
					sbSql.append("SELECT a.patient_id, a.encounter_id, NVL (DECODE (?, 'en', pat.patient_name, pat.patient_name_loc_lang), pat.patient_name ) patient_name, get_age (pat.date_of_birth) age, pat.sex, a.order_id, b.order_line_num, b.order_catalog_code, c.generic_id, drug.drug_desc, TO_CHAR (a.ord_date_time, 'DD/MM/YYYY HH24:MI') ord_date_time, a.source_type, a.source_code, (CASE WHEN (a.source_type = 'C' OR a.source_type = 'E') THEN (SELECT short_desc FROM op_clinic_lang_vw WHERE facility_id = a.ordering_facility_id AND clinic_code = a.source_code AND language_id = ?) ELSE (SELECT short_desc FROM ip_nursing_unit_lang_vw WHERE facility_id = a.ordering_facility_id AND nursing_unit_code = a.source_code AND language_id = ?) END ) source_desc, a.ord_pract_id, f.practitioner_name, a.ordering_facility_id, g.facility_name, k.order_status_type, a.patient_class, om.outsource_id, om.facility_id, om.REFERRAL_FACILITY, om.OUTSOURCED_BY,  (select practitioner_name from am_practitioner_lang_vw where PRACTITIONER_ID=om.outsourced_by and language_id='en' ) outsourced_pract_name, TO_CHAR (om.OUTSOURCED_DATE, 'DD/MM/YYYY HH24:MI') OUTSOURCED_DATE, OUTSOURCED_REMARKS FROM or_order a, or_order_line b, or_order_line_ph c, mp_patient pat, (SELECT drug_desc drug_desc, drug_code drug_code, language_id FROM ph_drug_lang_vw WHERE (discontinued_yn is null OR discontinued_yn != 'Y') UNION SELECT NVL (short_name, long_name) drug_desc, tpn_regimen_code drug_code, language_id FROM ph_tpn_regimen_lang_vw WHERE (discontinued_yn is null OR discontinued_yn != 'Y')) drug, am_practitioner_lang_vw f, sm_facility_param_lang_vw g, or_order_status_code k, PH_OUTSOURCE_MEDN om WHERE a.order_id = b.order_id AND a.order_id = c.order_id AND b.order_line_num = c.order_line_num and b.order_id = om.order_id and b.order_line_num = om.order_line_num  and om.REFERRAL_FACILITY = ? AND c.complete_order_reason = '*SE' AND b.order_line_status = k.order_status_code AND a.patient_id = pat.patient_id AND b.order_catalog_code = drug.drug_code AND a.ord_pract_id = f.practitioner_id AND a.ordering_facility_id = g.facility_id AND a.ord_date_time BETWEEN TO_DATE (?, 'DD/MM/YYYY') AND TO_DATE (?, 'DD/MM/YYYY') + .99999 AND b.order_line_status = 'SE' AND om.disp_locn_code = ? ");  // Added for CRF-PH- Bru-HIMS-CRF-087/12 -TPN  IN#38706   
				}
				else if(trackingAction.equals("D")){
					//sbSql.append("SELECT a.patient_id, a.encounter_id, NVL (DECODE (?, 'en', pat.patient_name, pat.patient_name_loc_lang), pat.patient_name ) patient_name, get_age (pat.date_of_birth) age, pat.sex, a.order_id, b.order_line_num, b.order_catalog_code, c.generic_id, drug.drug_desc, TO_CHAR (a.ord_date_time, 'DD/MM/YYYY HH24:MI') ord_date_time, a.source_type, a.source_code, (CASE WHEN (a.source_type = 'C' OR a.source_type = 'E') THEN (SELECT short_desc FROM op_clinic_lang_vw WHERE facility_id = a.ordering_facility_id AND clinic_code = a.source_code AND language_id = ?) ELSE (SELECT short_desc FROM ip_nursing_unit_lang_vw WHERE facility_id = a.ordering_facility_id AND nursing_unit_code = a.source_code AND language_id = ?) END ) source_desc, a.ord_pract_id, f.practitioner_name, a.ordering_facility_id, g.facility_name, k.order_status_type, a.patient_class, om.outsource_id, om.facility_id, om.REFERRAL_FACILITY, om.OUTSOURCED_BY,  (select practitioner_name from am_practitioner_lang_vw where PRACTITIONER_ID=om.outsourced_by and language_id='en' ) outsourced_pract_name, TO_CHAR (om.OUTSOURCED_DATE, 'DD/MM/YYYY HH24:MI') OUTSOURCED_DATE, OUTSOURCED_REMARKS FROM or_order a, or_order_line b, or_order_line_ph c, mp_patient pat, (SELECT drug_desc drug_desc, drug_code drug_code, language_id FROM ph_drug_lang_vw WHERE discontinued_yn != 'Y' UNION SELECT NVL (short_name, long_name) drug_desc, tpn_regimen_code drug_code, language_id FROM ph_tpn_regimen_lang_vw WHERE discontinued_yn != 'Y') drug, am_practitioner_lang_vw f, sm_facility_param_lang_vw g, or_order_status_code k, PH_OUTSOURCE_MEDN om WHERE a.order_id = b.order_id AND a.order_id = c.order_id AND b.order_line_num = c.order_line_num and b.order_id = om.order_id and b.order_line_num = om.order_line_num  and om.REFERRAL_FACILITY = ? AND c.complete_order_reason = '*SE' AND b.order_line_status = k.order_status_code AND a.patient_id = pat.patient_id AND b.order_catalog_code = drug.drug_code AND a.ord_pract_id = f.practitioner_id AND a.ordering_facility_id = g.facility_id AND a.ord_date_time BETWEEN TO_DATE (?, 'DD/MM/YYYY') AND TO_DATE (?, 'DD/MM/YYYY') + .99999 AND b.order_line_status = 'RC' AND om.disp_locn_code = ? ");
					sbSql.append("SELECT a.patient_id, a.encounter_id, NVL (DECODE (?, 'en', pat.patient_name, pat.patient_name_loc_lang), pat.patient_name ) patient_name, get_age (pat.date_of_birth) age, pat.sex, a.order_id, b.order_line_num, b.order_catalog_code, c.generic_id, drug.drug_desc, TO_CHAR (a.ord_date_time, 'DD/MM/YYYY HH24:MI') ord_date_time, a.source_type, a.source_code, (CASE WHEN (a.source_type = 'C' OR a.source_type = 'E') THEN (SELECT short_desc FROM op_clinic_lang_vw WHERE facility_id = a.ordering_facility_id AND clinic_code = a.source_code AND language_id = ?) ELSE (SELECT short_desc FROM ip_nursing_unit_lang_vw WHERE facility_id = a.ordering_facility_id AND nursing_unit_code = a.source_code AND language_id = ?) END ) source_desc, a.ord_pract_id, f.practitioner_name, a.ordering_facility_id, g.facility_name, k.order_status_type, a.patient_class, om.outsource_id, om.facility_id, om.REFERRAL_FACILITY, om.OUTSOURCED_BY,  (select practitioner_name from am_practitioner_lang_vw where PRACTITIONER_ID=om.outsourced_by and language_id='en' ) outsourced_pract_name, TO_CHAR (om.OUTSOURCED_DATE, 'DD/MM/YYYY HH24:MI') OUTSOURCED_DATE, OUTSOURCED_REMARKS FROM or_order a, or_order_line b, or_order_line_ph c, mp_patient pat, (SELECT drug_desc drug_desc, drug_code drug_code, language_id FROM ph_drug_lang_vw WHERE (discontinued_yn is null OR discontinued_yn != 'Y') UNION SELECT NVL (short_name, long_name) drug_desc, tpn_regimen_code drug_code, language_id FROM ph_tpn_regimen_lang_vw WHERE (discontinued_yn is null OR discontinued_yn != 'Y')) drug, am_practitioner_lang_vw f, sm_facility_param_lang_vw g, or_order_status_code k, PH_OUTSOURCE_MEDN om WHERE a.order_id = b.order_id AND a.order_id = c.order_id AND b.order_line_num = c.order_line_num and b.order_id = om.order_id and b.order_line_num = om.order_line_num  and om.REFERRAL_FACILITY = ? AND c.complete_order_reason = '*SE' AND b.order_line_status = k.order_status_code AND a.patient_id = pat.patient_id AND b.order_catalog_code = drug.drug_code AND a.ord_pract_id = f.practitioner_id AND a.ordering_facility_id = g.facility_id AND a.ord_date_time BETWEEN TO_DATE (?, 'DD/MM/YYYY') AND TO_DATE (?, 'DD/MM/YYYY') + .99999 AND b.order_line_status = 'RC' AND om.disp_locn_code = ? ");  // Added for CRF-PH- Bru-HIMS-CRF-087/12 -TPN  IN#38706   
				}

				if(patient_id!=null && !patient_id.equals(""))
					sbSql.append(" AND a.patient_id=?");
				if(getOrderType().equals("NOR")) {
					sbSql.append(" AND (A.IV_PREP_YN IS NULL OR A.IV_PREP_YN='N') ");
				}
				else if(getOrderType().equals("IVAD")) {
					sbSql.append(" AND A.IV_PREP_YN IN('1') ");
				}
				else if(getOrderType().equals("IVAA")) {
					sbSql.append(" AND A.IV_PREP_YN IN('2') ");
				}
				else if(getOrderType().equals("IVWA")) {
					sbSql.append( " AND A.IV_PREP_YN IN('5') ");
				}
				else if(getOrderType().equals("IVID")) {
					sbSql.append(" AND A.IV_PREP_YN IN('3') ");
				}
				else if(getOrderType().equals("IVIA")) {
					sbSql.append(" AND A.IV_PREP_YN IN('4') ");
				}
				else if(getOrderType().equals("TD")) {
					sbSql.append( " AND A.IV_PREP_YN ='7' ");
				}
				else if(getOrderType().equals("TA")) {
					sbSql.append(" AND A.IV_PREP_YN ='8' ");
				}
				else if(getOrderType().equals("CD")) {
					sbSql.append(" AND A.IV_PREP_YN = '9' ");
				}
				else if(getOrderType().equals("CA")) {
					sbSql.append( " AND A.IV_PREP_YN = '0' ");
				}
				else if(getOrderType().equals("CO")) {
					sbSql.append( " AND A.IV_PREP_YN = '6' ");
				}
				if(drug_code!=null && !drug_code.equals(""))
					sbSql.append(" AND b.order_catalog_code=?");
				sbSql.append(" AND drug.language_id = ? AND f.language_id = ? AND g.language_id = ? ORDER BY a.patient_id, patient_name, a.ord_date_time");
				pstmt				= connection.prepareStatement( sbSql.toString()) ;

				pstmt.setString(++index,getLanguageId());
				pstmt.setString(++index,getLanguageId());
				pstmt.setString(++index,getLanguageId());
				pstmt.setString(++index,getReferralFacility());
				pstmt.setString(++index,order_date_from);
				pstmt.setString(++index,order_date_to);
				pstmt.setString(++index,getDispLocnCode());
				if(patient_id!=null && !patient_id.equals(""))
					pstmt.setString(++index,patient_id);
				if(drug_code!=null && !drug_code.equals(""))
					pstmt.setString(++index,drug_code);

				pstmt.setString(++index,getLanguageId());
				pstmt.setString(++index,getLanguageId());
				pstmt.setString(++index,getLanguageId());
				resultSet	= pstmt.executeQuery(); 
				alTrackingDetailsTmp.add("link");
				if( resultSet != null ) { 
					while(resultSet.next()&& i <= end+1){
						if( start != 1 && (i+1) < start ) {
							i++;
							continue;
						}
						else i++;
							count++ ;
						if(i<=end) {
							hmTrackingDetails = new HashMap();
							hmTrackingDetails.put("PATIENT_ID",checkForNull(resultSet.getString("PATIENT_ID")));
							hmTrackingDetails.put("ENCOUNTER_ID",checkForNull(resultSet.getString("ENCOUNTER_ID")));
							hmTrackingDetails.put("PATIENT_NAME",checkForNull(resultSet.getString("PATIENT_NAME")));
							hmTrackingDetails.put("AGE",checkForNull(resultSet.getString("AGE")));
							hmTrackingDetails.put("SEX",checkForNull(resultSet.getString("SEX")));
							hmTrackingDetails.put("ORDER_ID",checkForNull(resultSet.getString("ORDER_ID")));
							hmTrackingDetails.put("ORDER_LINE_NUM",checkForNull(resultSet.getString("ORDER_LINE_NUM")));
							hmTrackingDetails.put("ORDER_STATUS_TYPE",checkForNull(resultSet.getString("ORDER_STATUS_TYPE")));
							hmTrackingDetails.put("DRUG_CODE",checkForNull(resultSet.getString("ORDER_CATALOG_CODE")));
							hmTrackingDetails.put("GENERIC_ID",checkForNull(resultSet.getString("GENERIC_ID")));
							hmTrackingDetails.put("DRUG_DESC",checkForNull(resultSet.getString("DRUG_DESC")));
							hmTrackingDetails.put("ORD_DATE_TIME",checkForNull(resultSet.getString("ORD_DATE_TIME")));
							hmTrackingDetails.put("SOURCE_TYPE",checkForNull(resultSet.getString("SOURCE_TYPE")));
							hmTrackingDetails.put("SOURCE_CODE",checkForNull(resultSet.getString("SOURCE_CODE")));
							hmTrackingDetails.put("SOURCE_DESC",checkForNull(resultSet.getString("SOURCE_DESC")));
							hmTrackingDetails.put("DELIVERED_SOURCE_DESC",checkForNull(resultSet.getString("SOURCE_DESC")));
							hmTrackingDetails.put("DELIVERED_SOURCE_CODE",checkForNull(resultSet.getString("SOURCE_CODE")));
							hmTrackingDetails.put("ORD_PRACT_ID",checkForNull(resultSet.getString("ORD_PRACT_ID")));
							hmTrackingDetails.put("PRACTITIONER_NAME",checkForNull(resultSet.getString("PRACTITIONER_NAME")));
							hmTrackingDetails.put("ORDERING_FACILITY_ID",checkForNull(resultSet.getString("ORDERING_FACILITY_ID")));
							hmTrackingDetails.put("FACILITY_NAME",checkForNull(resultSet.getString("FACILITY_NAME")));
							hmTrackingDetails.put("PATIENT_CLASS",checkForNull(resultSet.getString("PATIENT_CLASS")));
							hmTrackingDetails.put("OUTSOURCE_ID",checkForNull(resultSet.getString("OUTSOURCE_ID")));
							hmTrackingDetails.put("FACILITY_ID",checkForNull(resultSet.getString("FACILITY_ID")));
							hmTrackingDetails.put("REFERRAL_FACILITY",checkForNull(resultSet.getString("REFERRAL_FACILITY")));
							hmTrackingDetails.put("OUTSOURCED_BY",checkForNull(resultSet.getString("OUTSOURCED_BY")));
							hmTrackingDetails.put("OUTSOURCED_PRACT_NAME",checkForNull(resultSet.getString("OUTSOURCED_PRACT_NAME")));
							hmTrackingDetails.put("OUTSOURCED_DATE",checkForNull(resultSet.getString("OUTSOURCED_DATE")));
							hmTrackingDetails.put("OUTSOURCED_REMARKS",checkForNull(resultSet.getString("OUTSOURCED_REMARKS")));
							alTrackingDetailsTmp.add(hmTrackingDetails);
							if(trackingAction.equals("D") && !checkForNull(resultSet.getString("OUTSOURCE_ID")).equals(""))
								sbOutSourceIdList.append("'"+resultSet.getString("OUTSOURCE_ID")+"', ");
						}
					}
				}
				if(trackingAction.equals("D") && sbOutSourceIdList.length()>0){
					String sOutSourceIdList = sbOutSourceIdList.toString();
					if(sOutSourceIdList!=null && !sOutSourceIdList.equals("")&& sOutSourceIdList.lastIndexOf(",")>0){
						sOutSourceIdList = sOutSourceIdList.substring(0, sOutSourceIdList.lastIndexOf(","));
						setOutsourceProductDetails(queryOutsourceProductDetails(sOutSourceIdList));
					}
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
		if( start != 1 )
			prevnextlink = prevnextlink + "<td align='right' id='Navigation'><a href=\"javascript:SubmitLinkOutSource('"+(start-query_result_size)+"','"+(end-query_result_size)+"')\">Previous&nbsp;&nbsp;</a>" ;

		if( count > 10 ){
			prevnextlink = prevnextlink + "<td align='right' id='Navigation'><a href=\"javascript:SubmitLinkOutSource('"+(start+query_result_size)+"','"+(end+query_result_size)+"')\">Next</a>" ;
		}
		
		if(alTrackingDetailsTmp!=null)	{					
			alTrackingDetailsTmp.set(0,prevnextlink);				
		}
		return alTrackingDetailsTmp;
	}

	public HashMap queryOutsourceProductDetails(String sOutSourceIdList){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ; 
		ArrayList alProductDetails = null;
		ArrayList alIngredientDetails = null;
		HashMap hmProductDetailList = new HashMap();
		HashMap hmProductDetails = new HashMap();
		HashMap hmOutsourceDetails = new HashMap();
		//String ingredient=""; //Commented for common-icn-0048
		String prevOutsourceId="", outsourceId="", prevProductId="", productId="", sSql=""; //Modified for common-icn-0048

		try{
			connection			= getConnection() ;
			int index =0;
			
			sSql =  "select om.OUTSOURCE_ID, om.OUTSOURCED_BY, (SELECT practitioner_name FROM am_practitioner_lang_vw WHERE practitioner_id = om.outsourced_by AND language_id = ?) outsourced_pract_name, to_char(om.OUTSOURCED_DATE, 'DD/MM/YYYY HH24:MI') OUTSOURCED_DATE, om.OUTSOURCED_REMARKS, om.RECEIVED_BY, (SELECT practitioner_name FROM am_practitioner_lang_vw WHERE practitioner_id = om.RECEIVED_BY AND language_id = ?) received_pract_name, to_char(om.RECEIVED_DATE, 'DD/MM/YYYY HH24:MI') RECEIVED_DATE, om.RECEIVED_REMARKS, om.DELIVERED_BY, (SELECT practitioner_name FROM am_practitioner_lang_vw WHERE practitioner_id = om.DELIVERED_BY AND language_id = ?) delivered_pract_name, to_char(om.DELIVERED_DATE, 'DD/MM/YYYY HH24:MI') DELIVERED_DATE, om.DELIVERED_SOURCE_CODE, ORD.SOURCE_TYPE, (CASE WHEN (ord.source_type = 'C' OR ord.source_type = 'E') THEN (SELECT short_desc FROM op_clinic_lang_vw WHERE facility_id = om.facility_id AND clinic_code = om.DELIVERED_SOURCE_CODE AND language_id = ?) ELSE (SELECT short_desc FROM ip_nursing_unit_lang_vw WHERE facility_id = om.facility_id AND nursing_unit_code = om.DELIVERED_SOURCE_CODE AND language_id =?) END ) source_desc, om.DELIVERED_TO, om.DELIVERED_TO_IND, PROD.SRL_NO, PROD.PRODUCT_ID, PROD.PRODUCT_NAME, PROD.BATCH_ID, to_char(PROD.EXPIRY_DATE, 'DD/MM/YYYY') EXPIRY_DATE, PROD.QUANTITY, PROD.QUANTITY_UOM, PROD.REMARKS, INGNT.INGRD_LINE_SRL, INGNT.INGREDIANTS from ph_outsource_medn om, PH_OUTSOURCE_MEDN_PRD_DTL prod, PH_OUTSOURCE_MEDN_INGR_DTL ingnt, or_order ord where om.FACILITY_ID = PROD.FACILITY_ID(+) and om.OUTSOURCE_ID = PROD.OUTSOURCE_ID(+) and PROD.FACILITY_ID = INGNT.FACILITY_ID(+) and PROD.OUTSOURCE_ID = INGNT.OUTSOURCE_ID(+) and PROD.PRODUCT_ID = INGNT.PRODUCT_ID(+) and PROD.SRL_NO = INGNT.SRL_NO(+) and OM.ORDER_ID = ORD.ORDER_ID and om.facility_id =? and om.OUTSOURCE_ID in ("+sOutSourceIdList+") order by OUTSOURCE_ID, SRL_NO, INGRD_LINE_SRL";

			pstmt				= connection.prepareStatement( sSql) ;
			pstmt.setString(++index,getLanguageId());
			pstmt.setString(++index,getLanguageId());
			pstmt.setString(++index,getLanguageId());
			pstmt.setString(++index,getLanguageId());
			pstmt.setString(++index,getLanguageId());
			pstmt.setString(++index,login_facility_id);
			//pstmt.setString(++index,sOutSourceIdList);
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null ) { 
				while(resultSet.next()){
					outsourceId = checkForNull(resultSet.getString("OUTSOURCE_ID"));
					if(!outsourceId.equals(prevOutsourceId)){
						if(!prevOutsourceId.equals("") && hmProductDetails.size()>0){
							hmProductDetails.put("ingredients",alIngredientDetails);
							alProductDetails.add(hmProductDetails);
							hmProductDetailList.put(prevOutsourceId,alProductDetails);
						}
						prevOutsourceId=outsourceId;
						prevProductId="";
						alIngredientDetails = new ArrayList();
						hmProductDetails = new HashMap();
						alProductDetails = new ArrayList();
						hmOutsourceDetails = new HashMap();
						hmOutsourceDetails.put("OUTSOURCED_BY",checkForNull(resultSet.getString("OUTSOURCED_BY")));
						hmOutsourceDetails.put("OUTSOURCED_PRACT_NAME",checkForNull(resultSet.getString("OUTSOURCED_PRACT_NAME")));
						hmOutsourceDetails.put("OUTSOURCED_DATE",checkForNull(resultSet.getString("OUTSOURCED_DATE")));
						hmOutsourceDetails.put("OUTSOURCED_REMARKS",checkForNull(resultSet.getString("OUTSOURCED_REMARKS")));
						hmOutsourceDetails.put("RECEIVED_BY",checkForNull(resultSet.getString("RECEIVED_BY")));
						hmOutsourceDetails.put("RECEIVED_PRACT_NAME",checkForNull(resultSet.getString("RECEIVED_PRACT_NAME")));
						hmOutsourceDetails.put("RECEIVED_DATE",checkForNull(resultSet.getString("RECEIVED_DATE")));
						hmOutsourceDetails.put("RECEIVED_REMARKS",checkForNull(resultSet.getString("RECEIVED_REMARKS")));
						hmOutsourceDetails.put("DELIVERED_BY",checkForNull(resultSet.getString("DELIVERED_BY")));
						hmOutsourceDetails.put("DELIVERED_PRACT_NAME",checkForNull(resultSet.getString("DELIVERED_PRACT_NAME")));
						hmOutsourceDetails.put("DELIVERED_DATE",checkForNull(resultSet.getString("DELIVERED_DATE")));
						hmOutsourceDetails.put("DELIVERED_SOURCE_CODE",checkForNull(resultSet.getString("DELIVERED_SOURCE_CODE")));
						hmOutsourceDetails.put("SOURCE_DESC",checkForNull(resultSet.getString("SOURCE_DESC")));
						hmOutsourceDetails.put("SOURCE_TYPE",checkForNull(resultSet.getString("SOURCE_TYPE")));
						hmOutsourceDetails.put("DELIVERED_TO",checkForNull(resultSet.getString("DELIVERED_TO")));
						hmOutsourceDetails.put("DELIVERED_TO_IND",checkForNull(resultSet.getString("DELIVERED_TO_IND")));
						alProductDetails.add(hmOutsourceDetails);
					}
					productId = checkForNull(resultSet.getString("PRODUCT_ID"));
					if(!productId.equals("")){
						if(!productId.equals(prevProductId)){
							if(!prevProductId.equals("")){
								hmProductDetails.put("ingredients",alIngredientDetails);
								alProductDetails.add(hmProductDetails);
								alIngredientDetails = new ArrayList();
								hmProductDetails = new HashMap();
							}
							hmProductDetails.put("SRL_NO",checkForNull(resultSet.getString("SRL_NO")));
							hmProductDetails.put("productId",checkForNull(resultSet.getString("PRODUCT_ID")));
							hmProductDetails.put("productName",checkForNull(resultSet.getString("PRODUCT_NAME")));
							hmProductDetails.put("batchId",checkForNull(resultSet.getString("BATCH_ID")));
							hmProductDetails.put("expiryDate",checkForNull(resultSet.getString("EXPIRY_DATE")));
							hmProductDetails.put("quantity",checkForNull(resultSet.getString("QUANTITY")));
							hmProductDetails.put("quantityUOM",checkForNull(resultSet.getString("QUANTITY_UOM")));
							hmProductDetails.put("remarks",checkForNull(resultSet.getString("REMARKS")));
							alIngredientDetails.add(checkForNull(resultSet.getString("INGREDIANTS")));
							prevProductId=productId;
						}
						else{
							alIngredientDetails.add(checkForNull(resultSet.getString("INGREDIANTS")));
						}
					}
				}
				if(!productId.equals("")){
					hmProductDetails.put("ingredients",alIngredientDetails);
					alProductDetails.add(hmProductDetails);
				}
				hmProductDetailList.put(outsourceId,alProductDetails);
			}
		}
		catch(Exception e){
			System.err.println("=====sSql====>"+sSql+" sOutSourceIdList="+sOutSourceIdList);
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
		return hmProductDetailList;
	}

	public String getOutSourceId(String orderId, String OrderLineNum){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ; 
		String  outsourceId="", sSql="";

		try{
			connection			= getConnection() ;
			int index =0;
			
			sSql =  "select om.OUTSOURCE_ID FROM ph_outsource_medn om, or_order_line ORDL where OM.ORDER_ID = ORDL.ORDER_ID and om.order_line_num =ORDL.order_line_num and om.order_id=? and om.order_line_num=?";

			pstmt				= connection.prepareStatement( sSql) ;
			pstmt.setString(++index, orderId);
			pstmt.setString(++index, OrderLineNum);
			//pstmt.setString(++index,sOutSourceIdList);
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) { 
				outsourceId = checkForNull(resultSet.getString("OUTSOURCE_ID"));
			}
		}
		catch(Exception e){
			System.err.println("=====sSql====>"+sSql+" orderId="+orderId+" OrderLineNum="+OrderLineNum);
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
		return outsourceId;
	}
	
	public HashMap insert() {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		ArrayList mandatory_flds	=	new ArrayList();
		mandatory_flds.add(login_by_id);
		mandatory_flds.add(login_at_ws_no);
		mandatory_flds.add(login_facility_id);
		HashMap tabData	= new HashMap() ;
		HashMap sqlMap		= new HashMap() ;
		try {
			tabData.put("properties", getProperties() );
			tabData.put("mandatory_flds", mandatory_flds );
			tabData.put("hmTrackingDetails", getTrackingDetails() );
			tabData.put("FACILITY_ID", login_facility_id);
			tabData.put("DISP_LOCN_CODE", getDispLocnCode());
			tabData.put("REFERRAL_FACILITY", getReferralFacility());
			tabData.put("OUTSOURCED_REMARKS", getTrackingRemarks());

			String sqlUpdate_OR_ORDER_LINE = "UPDATE or_order_line SET order_line_status = ?,  modified_date = SYSDATE, modified_by_id = ?, modified_facility_id = ?,     modified_at_ws_no = ?, PREV_ORDER_LINE_STATUS = ? WHERE order_id = ? AND order_line_num =? ";
			String sqlInsert_PH_OUTSOURCE_MEDN = "insert into PH_OUTSOURCE_MEDN ( FACILITY_ID , OUTSOURCE_ID , DISP_LOCN_CODE , PATIENT_ID , ORDER_ID , ORDER_LINE_NUM , OUTSOURCED_BY , OUTSOURCED_DATE , REFERRAL_FACILITY , OUTSOURCED_REMARKS , ADDED_BY_ID , ADDED_DATE , ADDED_AT_WS_NO , ADDED_FACILITY_ID , MODIFIED_BY_ID , MODIFIED_DATE , MODIFIED_AT_WS_NO , MODIFIED_FACILITY_ID) values (?, ?,?,?,?,?,?, sysdate,?,?,?, sysdate, ?,?,?, sysdate,?,?)";
			String sqlGet_OUTSOURCE_ID = " select PH_OUTSOURCE_MEDN_SEQ.NEXTVAL OUTSOURCE_ID from dual ";

			//sqlMap.put( "SQL_PH_RENEW_PRESCRIPTION_INSERT2",PhRepository.getPhKeyValue("SQL_PH_RENEW_PRESCRIPTION_INSERT2") );
			//sqlMap.put( "SQL_PH_PRESCRIPTION_MODIFY8",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_MODIFY8") );
			sqlMap.put( "SQL_PH_OUTSOURCE_MEDN_INSERT",sqlInsert_PH_OUTSOURCE_MEDN);
			sqlMap.put( "SQL_PH_OUTSOURCE_MEDN_UPDATE_OR_ORDER_LINE",sqlUpdate_OR_ORDER_LINE);
			sqlMap.put( "SQL_PH_OUTSOURCE_MEDN_GET_OUTSOURCE_ID",sqlGet_OUTSOURCE_ID);
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_TRACKING_OUTSOURCE_MEDN" ),TrackingOutsourceMednHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;
			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass(); ;
			paramArray[1] = sqlMap.getClass();
			HashMap result = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			if( ((Boolean) result.get( "result" )).booleanValue() )	{
				map.put("flag",(String)result.get("flag"));
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) result.get( "msgid" ),"PH"));
			}
			else {
				map.put("flag",(String)result.get("flag"));
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message", getMessage(getLanguageId(),"EXCEPTION_OCCURED_WHILE_INSERTION","PH")+" : "+(String)map.get("flag") ) ;
			}

		}
		catch(Exception e) {
			map.put("message",e.toString());
			e.printStackTrace() ;
		}
		return map ;
	}

	public HashMap modify() {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		ArrayList mandatory_flds	=	new ArrayList();
		mandatory_flds.add(login_by_id);
		mandatory_flds.add(login_at_ws_no);
		mandatory_flds.add(login_facility_id);
		HashMap tabData	= new HashMap() ;
		HashMap sqlMap		= new HashMap() ;
		try {
			tabData.put("properties", getProperties() );
			tabData.put("mandatory_flds", mandatory_flds );
			tabData.put("hmTrackingDetails", getTrackingDetails() );
			tabData.put("FACILITY_ID", login_facility_id);
			tabData.put("DISP_LOCN_CODE", getDispLocnCode());
			tabData.put("REFERRAL_FACILITY", getReferralFacility());
			tabData.put("TRACKING_ACTION", getTrackingAction());
			if(getTrackingAction().equals("R")){
				tabData.put("RECEIVEED_REMARKS", getTrackingRemarks());
				String sqlUpdate_OR_ORDER_LINE = "UPDATE or_order_line SET order_line_status = ?,  modified_date = SYSDATE, modified_by_id = ?, modified_facility_id = ?,     modified_at_ws_no = ?, PREV_ORDER_LINE_STATUS = ? WHERE order_id = ? AND order_line_num =? ";
				String sqlupdate_PH_OUTSOURCE_MEDN = "update PH_OUTSOURCE_MEDN set RECEIVED_BY=?, RECEIVED_DATE=sysdate, RECEIVED_REMARKS=?, MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where facility_id=? and outsource_id=?";
				String sqlinsert_PH_OUTSOURCE_MEDN_PRD_DTL = "insert into PH_OUTSOURCE_MEDN_PRD_DTL (FACILITY_ID, OUTSOURCE_ID, SRL_NO, PRODUCT_ID, PRODUCT_NAME, BATCH_ID, EXPIRY_DATE, QUANTITY, QUANTITY_UOM, REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values(?,?,?,?,?,?,to_date(?,'DD/MM/YYYY'),?,?,?,?,sysdate, ?,?,?, sysdate, ?,?)";
				String sqlinsert_PH_OUTSOURCE_MEDN_INGR_DTL = "insert into PH_OUTSOURCE_MEDN_INGR_DTL (FACILITY_ID, OUTSOURCE_ID, SRL_NO, PRODUCT_ID, INGRD_LINE_SRL, INGREDIANTS , ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) values(?,?,?,?,?,?,?, sysdate, ?,?,?, sysdate, ?,?)";

				sqlMap.put( "SQL_PH_OUTSOURCE_MEDN_UPDATE_OR_ORDER_LINE",sqlUpdate_OR_ORDER_LINE);
				sqlMap.put( "SQL_PH_OUTSOURCE_MEDN_UPDATE",sqlupdate_PH_OUTSOURCE_MEDN );
				sqlMap.put( "SQL_PH_OUTSOURCE_MEDN_PRD_DTL_INSERT",sqlinsert_PH_OUTSOURCE_MEDN_PRD_DTL);
				sqlMap.put( "SQL_PH_OUTSOURCE_MEDN_INGR_DTL_INSERT",sqlinsert_PH_OUTSOURCE_MEDN_INGR_DTL);
			}
			else{
				String sqlUpdate_OR_ORDER_LINE = "UPDATE or_order_line SET order_line_status = ?,  modified_date = SYSDATE, modified_by_id = ?, modified_facility_id = ?,     modified_at_ws_no = ?, PREV_ORDER_LINE_STATUS = ? WHERE order_id = ? AND order_line_num =? ";
				String sqlupdate_PH_OUTSOURCE_MEDN = "update PH_OUTSOURCE_MEDN set DELIVERED_BY=?, DELIVERED_TO_IND=?, DELIVERED_TO=?, DELIVERED_DATE=sysdate, DELIVERED_SOURCE_CODE=?, MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where facility_id=? and outsource_id=?";

				sqlMap.put( "SQL_PH_OUTSOURCE_MEDN_UPDATE_OR_ORDER_LINE",sqlUpdate_OR_ORDER_LINE);
				sqlMap.put( "SQL_PH_OUTSOURCE_MEDN_UPDATE",sqlupdate_PH_OUTSOURCE_MEDN );
			}
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_TRACKING_OUTSOURCE_MEDN" ),TrackingOutsourceMednHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;
			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass(); ;
			paramArray[1] = sqlMap.getClass();
			HashMap result = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			if( ((Boolean) result.get( "result" )).booleanValue() )	{
				map.put("flag",(String)result.get("flag"));
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) result.get( "msgid" ),"PH"));
			}
			else {
				map.put("flag",(String)result.get("flag"));
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message", getMessage(getLanguageId(),"EXCEPTION_OCCURED_WHILE_INSERTION","PH")+" : "+(String)map.get("flag") ) ;
			}

		}
		catch(Exception e) {
			map.put("message",e.toString());
			e.printStackTrace() ;
		}
		return map ;
	}
}//end of class
