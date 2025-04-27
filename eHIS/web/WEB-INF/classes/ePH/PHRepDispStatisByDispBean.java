/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/

/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		           Name		          Rev.Date		        Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
02/11/2017	  	ML-MMOH-CRF-0977(IN065505)    prathyusha 											   TPN Standard – Request for Offline label should follow TPN Online Label format. 
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
 //saved on 02.11.2005
package ePH ;

import java.io.Serializable ;
import java.util.ArrayList;
import java.util.*;
import java.sql.*;
import ePH.Common.* ;
import eCommon.Common.* ;

public class PHRepDispStatisByDispBean extends PhAdapter implements Serializable {

	private String docNoForMc							= "N";//added for GHL-SCF-1069 [IN:060605]
	/**
	 * @return the alternateAmendReason//added for GHL-SCF-1069 [IN:060605]
	 */
	public String getDocNoForMc() {
		return docNoForMc;
	}
	/**
	 * @param alternateAmendReason the alternateAmendReason to set//added for GHL-SCF-1069 [IN:060605]
	 */
	public void setDocNoForMc(String docNoForMc) {
		this.docNoForMc = docNoForMc;
	}
	public PHRepDispStatisByDispBean() {
		try {
			doCommon() ;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/* Over-ridden Adapter methods start here */
	private void doCommon() throws Exception {
	}

	public void clear() {
		super.clear() ;
	}

	public String getMednOrList() {
		String  med_or_yn		= "";
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_MEDN_ORD_STAT_PRACT_SELECT" )) ;
		/*	pstmt.setString(1,login_facility_id);*/

			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				if ( resultSet.next() ) {
					med_or_yn	= resultSet.getString( "INSTALL_YN" ) ;
				}
			}
		}
		catch ( Exception e ) {
			//System.err.println( "Error loading values from database" ) ;
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
		return med_or_yn;
    } 	/* Over-ridden Adapter methods end here */

	/* for Balance Medication sheet */
	public String getMednPrnList() {
		String  med_pr_yn		= "";
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_BAL_MEDN_PRINT_REQ" )) ;
			pstmt.setString(1,login_facility_id);

			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				if ( resultSet.next() ) {
					med_pr_yn	= resultSet.getString( "PRINT_BAL_MED_SHEET_OP_YN" ) ;
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
		return med_pr_yn;
    }

	public ArrayList getMednFacilityList() {
		ArrayList facilityList = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DRUG_DIAGNOSIS1" )) ;
			pstmt.setString(1,login_by_id);
			pstmt.setString(2,getLanguageId());

			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					facilityList.add( resultSet.getString( "FACILITY_ID" ) ) ;
					facilityList.add( resultSet.getString( "FACILITY_NAME" ) );
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
			catch(Exception es) {es.printStackTrace(); }
		}
		return facilityList;
	}/*   Facility desc returns ends here    */

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
		return pat_txt_length;	
	}

	public ArrayList getPatientList() {
		ArrayList patientList = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_PATIENT_CLASS_SELECT1" )) ;
			pstmt.setString(1,getLanguageId());
		//	pstmt.setString(1,login_by_id);

			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					patientList.add( resultSet.getString( "PATIENT_CLASS" ) ) ;
				//	facilityList.add( resultSet.getString( "FACILITY_NAME" ) );
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
		return patientList;
	}	// patient Class list

	public ArrayList getOrderTypelist() {
		ArrayList OrderTypeList = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ORDER_TYPE_CODE_SELECT1" )) ;
			pstmt.setString(1,getLanguageId());
		//	pstmt.setString(1,login_by_id);
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					OrderTypeList.add( resultSet.getString( "ORDER_TYPE_CODE" ) ) ;
				//	facilityList.add( resultSet.getString( "FACILITY_NAME" ) );
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
		return OrderTypeList;
	}

	public String getSysdate() {
		String sysdate		    = "" ;
		Connection connection   = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet     = null ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISP_MEDICATION_SELECT25" )) ;
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null && resultSet.next()) {
				sysdate	=	resultSet.getString( "TODAY" )  ;
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
		return sysdate;
	}
	
	public ArrayList getDispNos(String patient_id, String disp_date,String pat_class,String order_type, String p_doc_no) {// , String p_doc_noadded for AMS-CRF-0079 [IN:050762]
		ArrayList disp_nos		= new ArrayList() ;
		Connection connection   = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet     = null ;
		StringBuffer sbSQL = new StringBuffer();//added for AMS-CRF-0079 [IN:050762]
		try {
			connection = getConnection() ;   
      boolean site_report_type = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","DISP_SHEET_CHECK");// added for ML-MMOH-CRF-0468
			if(!site_report_type){
			
			sbSQL.append("SELECT DISP_NO, B.IV_PREP_YN FROM PH_DISP_HDR A , OR_ORDER B WHERE A.ORDER_ID = B.ORDER_ID ");//added for AMS-CRF-0079 [IN:050762] -start
			}
      else{
      sbSQL.append("SELECT DISP_NO, B.IV_PREP_YN FROM PH_DISP_HDR A , OR_ORDER B, PR_ENCOUNTER C WHERE A.ORDER_ID = B.ORDER_ID ");//added for AMS-CRF-0079 [IN:050762] -start //Modified for GHL-CRF-0627
			}
      if(p_doc_no!= null && !p_doc_no.equals(""))
				sbSQL.append(" AND A.DOC_NO= ? ");
			if(patient_id!= null && !patient_id.equals(""))
				sbSQL.append(" AND A.PATIENT_ID= ? ");
			if(order_type.equals("RX")){
				sbSQL.append("AND (B.IV_PREP_YN IS NULL OR B.IV_PREP_YN = 'N') ");
				//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_PRINT_DISP_SHEET_SELECT2A" )) ;	//commented for AMS-CRF-0079 [IN:050762] 
			}
			else{
				sbSQL.append("and b.iv_prep_yn in('1','3','7','5','9') ");
				//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_PRINT_DISP_SHEET_SELECT2" )) ;//commented for AMS-CRF-0079 [IN:050762] -start
			}
			if(!site_report_type){
			sbSQL.append(" AND TRUNC(A.DISP_DATE_TIME)=TO_DATE(?,'DD/MM/YYYY') AND B.PATIENT_CLASS=? AND A.FACILITY_ID =? ORDER BY A.DISP_NO");
			}else
      sbSQL.append(" AND TRUNC(A.DISP_DATE_TIME)=TO_DATE(?,'DD/MM/YYYY') AND C.PATIENT_CLASS=? AND A.FACILITY_ID =? AND B.PATIENT_ID = C.PATIENT_ID AND B.ENCOUNTER_ID = C.ENCOUNTER_ID ORDER BY A.DISP_NO"); //Modified for GHL-CRF-0627
			pstmt = connection.prepareStatement( sbSQL.toString()) ;
			int i=0;
			if(p_doc_no!= null && !p_doc_no.equals(""))
				pstmt.setString(++i,p_doc_no);
			if(patient_id!= null && !patient_id.equals(""))//added for AMS-CRF-0079 [IN:050762] -end
				pstmt.setString(++i,patient_id);
			pstmt.setString(++i,disp_date);
			pstmt.setString(++i,pat_class);
			pstmt.setString(++i,login_facility_id);// code added for IN048930
			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next()) {
				disp_nos.add(checkForNull(resultSet.getString( "DISP_NO" )))  ;
				disp_nos.add(checkForNull(resultSet.getString( "IV_PREP_YN" )))  ;				
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
		return disp_nos;
	}
	// getDispNosFill is to bring the disp nos after filling/allocation stage
	public ArrayList getDispNosFill(String patient_id, String disp_date,String pat_class,String order_type, String p_doc_no) { // , String p_doc_noadded for AMS-CRF-0079 [IN:050762] -start
		ArrayList disp_nos		= new ArrayList() ;
		Connection connection   = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet     = null ;
		StringBuffer sbSQL = new StringBuffer();//added for AMS-CRF-0079 [IN:050762] -start
		try {
			connection = getConnection() ;
		boolean site_report_type = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","DISP_SHEET_CHECK");// added for ML-MMOH-CRF-0468
			if(!site_report_type){
    	sbSQL.append("SELECT DISP_TMP_NO,B.IV_PREP_YN FROM PH_DISP_HDR_TMP A , OR_ORDER B WHERE A.ORDER_ID = B.ORDER_ID "); //added for AMS-CRF-0079 [IN:050762] -start
			}else
      sbSQL.append("SELECT DISP_TMP_NO,B.IV_PREP_YN FROM PH_DISP_HDR_TMP A , OR_ORDER B, PR_ENCOUNTER C WHERE A.ORDER_ID = B.ORDER_ID "); //added for AMS-CRF-0079 [IN:050762] -start //modified for GHL-CRF-0627
			if(p_doc_no!= null && !p_doc_no.equals(""))
				sbSQL.append(" AND A.DOC_NO= ? ");
			if(patient_id!= null && !patient_id.equals(""))
				sbSQL.append(" AND A.PATIENT_ID= ? ");
			if(order_type.equals("RX")){
				sbSQL.append("AND (B.IV_PREP_YN IS NULL OR B.IV_PREP_YN = 'N') ");
				//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_PRINT_DISP_SHEET_SELECT3A" )) ;//Commented for AMS-CRF-0079 [IN:050762]
			}
			else{
				sbSQL.append("and b.iv_prep_yn in('1','3','7','5','9') ");
				//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_PRINT_DISP_SHEET_SELECT3" )) ;//Commented for AMS-CRF-0079 [IN:050762]
			}
			if(!site_report_type){
			sbSQL.append(" AND TRUNC(A.RECORD_DATE_TIME)=TO_DATE(?,'DD/MM/YYYY') AND B.PATIENT_CLASS=? AND A.FACILITY_ID =? ORDER BY A.DISP_TMP_NO");
}else
      sbSQL.append(" AND TRUNC(A.RECORD_DATE_TIME)=TO_DATE(?,'DD/MM/YYYY') AND C.PATIENT_CLASS=? AND A.FACILITY_ID =? AND B.PATIENT_ID = C.PATIENT_ID AND B.ENCOUNTER_ID = C.ENCOUNTER_ID ORDER BY A.DISP_TMP_NO"); //modified for GHL-CRF-0627
			System.err.println("sbSQL===>" + sbSQL);
			pstmt = connection.prepareStatement( sbSQL.toString()) ;
			int i=0;
			if(p_doc_no!= null && !p_doc_no.equals(""))
				pstmt.setString(++i,p_doc_no);
			if(patient_id!= null && !patient_id.equals(""))//added for AMS-CRF-0079 [IN:050762] -end
				pstmt.setString(++i,patient_id);
			pstmt.setString(++i,disp_date);
			pstmt.setString(++i,pat_class);
			pstmt.setString(++i,login_facility_id);// code added for IN048930
			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next()) {
				disp_nos.add(checkForNull(resultSet.getString( "DISP_TMP_NO" )))  ;
				disp_nos.add(checkForNull(resultSet.getString( "IV_PREP_YN" )))  ;				
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
		return disp_nos;
	}

	public ArrayList getLabelNos(String disp_no) {
		ArrayList label_nos		= new ArrayList() ;
		Connection connection   = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet     = null ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_PRINT_DISP_LABEL_SELECT2" )) ;
			pstmt.setString(1,disp_no);
			pstmt.setString(2,login_facility_id);
			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next()) {
				label_nos.add(checkForNull(resultSet.getString( "SRL_NO" )))  ;
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

		return label_nos;
	}

	public HashMap populateNursingUnit(){
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		HashMap  NursingUnitValues  = new HashMap();
		ArrayList nursing_unit_code	= new ArrayList();
		ArrayList nursing_unit_desc	= new ArrayList();

		try{
			connection	= getConnection();
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_MED_ADMIN_SELECT2B"));
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,login_by_id );
			pstmt.setString(3,login_facility_id);
			pstmt.setString(4,getLanguageId());
			resultSet	= pstmt.executeQuery() ;
			while( resultSet != null && resultSet.next() ){
				 nursing_unit_code.add((String) resultSet.getString("NURSING_UNIT_CODE"));
				 nursing_unit_desc.add((String) resultSet.getString("SHORT_DESC"));
			}
		}
		catch ( Exception e )	{
			 nursing_unit_code.add(e.toString());
			e.printStackTrace() ;
		} 
		finally {
		  try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}catch(Exception es){es.printStackTrace();}
		}
		NursingUnitValues.put("code",(ArrayList)nursing_unit_code);
		NursingUnitValues.put("desc",(ArrayList)nursing_unit_desc);
	//	System.err.println("frm bean NursingUnitValues"+NursingUnitValues);
		return NursingUnitValues;
	}

	public HashMap populateDispenselocn(String facility_id){ //new parameter added for  Dispensing Facility  on date 16-03-2009 
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		HashMap  Dispenselocn  = new HashMap();
		ArrayList  locn_code 	= new ArrayList();
		ArrayList locn_desc	= new ArrayList();

		try{
			connection	= getConnection();
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_DISP_DRUGS_REPORT_SELECT1"));
			pstmt.setString(1,facility_id);
			pstmt.setString(2,getLanguageId());
			resultSet	= pstmt.executeQuery() ;
			while( resultSet != null && resultSet.next() ){
				 locn_code.add((String) resultSet.getString("DISP_LOCN_CODE"));
				 locn_desc.add((String) resultSet.getString("SHORT_DESC"));
			}
		}
		catch ( Exception e )	{
			// practitioner_id.add(e.toString());
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
		Dispenselocn.put("code",(ArrayList)locn_code);
		Dispenselocn.put("desc",(ArrayList)locn_desc);
	//	System.err.println("frm bean Dispenselocn"+Dispenselocn);
		return Dispenselocn;
	}
	//Afhthdd on date 16-03-2009

	public HashMap getOrderingFacilityId(String p_user_name,String locale) {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		HashMap  LoginFacility  = new HashMap();
		ArrayList  loginFacility_code 	= new ArrayList();
		ArrayList loginFacility_desc	= new ArrayList();
		try {
			connection = getConnection() ;
			//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISPLOCN_SELECT" )) ;
			pstmt = connection.prepareStatement("SELECT B.FACILITY_ID FACILITY_ID,B.FACILITY_NAME FACILITY_NAME FROM SM_FACILITY_FOR_USER A, SM_FACILITY_PARAM_lang_vw B WHERE A.FACILITY_ID = B.FACILITY_ID AND B.STATUS ='E' AND APPL_USER_ID = ? AND B.LANGUAGE_ID= ?") ;
			pstmt.setString(1,p_user_name);
			pstmt.setString(2,locale);

			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				loginFacility_code.add(resultSet.getString("FACILITY_ID"));
				loginFacility_desc.add(resultSet.getString("FACILITY_NAME"));
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
			loginFacility_code.add(e.toString());
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
		LoginFacility.put("FACILITY_ID",(ArrayList)loginFacility_code);
		LoginFacility.put("FACILITY_NAME",(ArrayList)loginFacility_desc);
		//System.err.println("LoginFacility--from bean--->"+LoginFacility);
		return LoginFacility;
	}//End of addition  on date 16-03-2009

	public HashMap populateDangDrugsDisplocn(){
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		HashMap  Dispenselocn  = new HashMap();
		ArrayList  locn_code 	= new ArrayList();
		ArrayList locn_desc	= new ArrayList();

		try{
			connection	= getConnection();
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_DANG_DRUGS_REPORT_SELECT1"));
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,getLanguageId());
			resultSet	= pstmt.executeQuery() ;
			while( resultSet != null && resultSet.next() ){
				 locn_code.add((String) resultSet.getString("DISP_LOCN_CODE"));
				 locn_desc.add((String) resultSet.getString("SHORT_DESC"));
			}
		}
		catch ( Exception e )	{
			// practitioner_id.add(e.toString());
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
		Dispenselocn.put("code",(ArrayList)locn_code);
		Dispenselocn.put("desc",(ArrayList)locn_desc);
	//	System.err.println("frm bean Dispenselocn"+Dispenselocn);
		return Dispenselocn;
	}

	public HashMap populateDispensedBy(){
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		HashMap  Dispensedby  = new HashMap();
		ArrayList  practitioner_id 	= new ArrayList();
		ArrayList practitioner_name	= new ArrayList();

		try{
			connection	= getConnection();
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_ORDER_TYPE_CODE_SELECT2"));
			pstmt.setString(1,getLanguageId());
			resultSet	= pstmt.executeQuery() ;
			while( resultSet != null && resultSet.next() ){
				 practitioner_id.add((String) resultSet.getString("PRACTITIONER_ID"));
				 practitioner_name.add((String) resultSet.getString("PRACTITIONER_NAME"));
			}
		}
		catch ( Exception e )	{
			// practitioner_id.add(e.toString());
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
		Dispensedby.put("id",(ArrayList)practitioner_id);
		Dispensedby.put("name",(ArrayList)practitioner_name);
	//	System.err.println("frm bean Dispensedby"+Dispensedby);
		return Dispensedby;
	}

	public ArrayList populateFillProcessId(String dispdate){

		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList  fillproc_id 	= new ArrayList();

		try{
			connection	= getConnection();
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_DISP_DRUGS_REPORT_SELECT2"));
			pstmt.setString(1,dispdate);

			resultSet	= pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() ){
				fillproc_id.add((String) resultSet.getString("FILL_PROC_ID"));
			}
		}
		catch ( Exception e )	{
			// practitioner_id.add(e.toString());
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
		return fillproc_id;
	}

	public ArrayList getSyrngDispNos(String patient_id, String disp_date,String pat_class) {
		ArrayList disp_nos		= new ArrayList() ;
		Connection connection   = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet     = null ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_SYRINGE_FOR_ADMIX_SELECT" )) ;
			pstmt.setString(1,patient_id);
			pstmt.setString(2,disp_date);
			pstmt.setString(3,pat_class);
			resultSet = pstmt.executeQuery() ;
	
			while ( resultSet != null && resultSet.next()) {
				disp_nos.add(checkForNull(resultSet.getString( "DISP_NO" )))  ;
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
		return disp_nos;
	}

	public String getDefaultLanguageForDispenseLabel(String patient_id) throws Exception{

		String result			= "";
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		try {
	       connection	= getConnection() ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_DFLT_LANG1")) ;
			pstmt.setString(1,patient_id);
            resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){				
				result=resultSet.getString("LOCAL_YN");				
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
		return result;
	}

	/* The following methods returns the worksheet id's for the selected criteria. */
	public ArrayList getAllWorksheets(String report_type,String patient_class,String stage,String disp_locn_code,String from_date,String to_date,String facility_id,String from,String to)throws Exception{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList records=new ArrayList();
		String prevnextlink			= "";
		String ivPrepYn				= "";
		int	wrkShtId				= 0;
		String prpDtTme				= "";
		String wrkShtPrpBy			= "";
		String orderStatus			= "";
		int query_result_size		= 14;
		int start = 0 ;
		int end = 0 ;

		if ( from == null || from.equals(""))
			start = 1 ;
		else
			start = Integer.parseInt( from  ) ;

		if ( to == null || to.equals(""))
			end =query_result_size;
		else
			end = Integer.parseInt( to ) ;
		
		long count=0;
		long i = 0;

		if(report_type.equals("IV")){
			ivPrepYn = "AND B.IV_PREP_YN IN ('2','4')";
		}
		if(report_type.equals("CYTO")){ 
			ivPrepYn = "AND B.IV_PREP_YN IN ('0')";}
		if(report_type.equals("CMP")){
			ivPrepYn = "AND B.IV_PREP_YN IN ('6')";
		}
		if(report_type.equals("TPN")){
			ivPrepYn = "AND B.IV_PREP_YN IN ('8')";
		}
		//added for ML-MMOH-CRF-0977 start
		if(report_type.equals("TPNN")){
			ivPrepYn = "AND B.IV_PREP_YN IN ('8')";
		}
		if(report_type.equals("TPNS")){
			ivPrepYn = "AND B.IV_PREP_YN IN ('7')";
		}
		//added for ML-MMOH-CRF-0977  end
		String SQL_QUERY_SELECT_WRKSHT_4= PhRepository.getPhKeyValue("SQL_QUERY_SELECT_WRKSHT_2") +"	and b.order_status in ('DP','DF','DD','DE') " + ivPrepYn ;//'DD','DE' ADDED FOR MMS-KH-CRF-0014
		String SQL_QUERY_SELECT_WRKSHT_3= PhRepository.getPhKeyValue("SQL_QUERY_SELECT_WRKSHT_1") +"	and b.order_status in ('DP','DF','DD','DE') " + ivPrepYn ;//'DD','DE' ADDED FOR MMS-KH-CRF-0014
		try {
			connection = getConnection() ; 
			if(stage.equals("FA")){
					if(report_type.equals("TPN")){
					pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_QUERY_SELECT_WRKSHT_2")+ivPrepYn);
				}
					else if(report_type.equals("TPNN") || report_type.equals("TPNS")){//else ifadded for ML-MMOH-CRF-0977 start
						pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_QUERY_SELECT_WRKSHT_2")+ivPrepYn);
					}
				else {
					pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_QUERY_SELECT_WRKSHT_1")+ivPrepYn);
				}
			}
			else{
				if(report_type.equals("TPN") ){
					pstmt = connection.prepareStatement(SQL_QUERY_SELECT_WRKSHT_4);
				}
				else if(report_type.equals("TPNN")  || report_type.equals("TPNS")){//else if added for ML-MMOH-CRF-0977 start
					pstmt = connection.prepareStatement(SQL_QUERY_SELECT_WRKSHT_4);
				}
				else {
					pstmt = connection.prepareStatement(SQL_QUERY_SELECT_WRKSHT_3);
				}
			}

			pstmt.setString(1,facility_id.trim());
			pstmt.setString(2,disp_locn_code.trim());
			pstmt.setString(3,from_date.trim());
			pstmt.setString(4,to_date.trim());
			pstmt.setString(5,patient_class.trim());
			
			resultSet = pstmt.executeQuery() ;
			records.add("link");
			ArrayList recrd=null;

			while ( resultSet.next() && i <= end+1 ){
				if( start != 1 && (i+1) < start ) {
					i++;
					continue;
				}
				else i++;
				count++ ;
				if(i <= end ) {
					recrd=new ArrayList();
					wrkShtId			= resultSet.getInt("WORKSHEET_ID");
					prpDtTme			= resultSet.getString("PREP_DATE_TIME");
					wrkShtPrpBy			= resultSet.getString("WS_PREP_BY");
					orderStatus			= resultSet.getString("ORDER_STATUS");

					recrd.add(wrkShtId+"");
					recrd.add(prpDtTme);
					recrd.add(wrkShtPrpBy);
					recrd.add(orderStatus);
					records.add(recrd);
				}
			}
			if( start != 1 )
					prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start-query_result_size)+"','"+(end-query_result_size)+"','"+(report_type)+"','"+(patient_class)+"','"+(stage)+"','"+disp_locn_code+"','"+(from_date)+"','"+(to_date)+"')\">Previous&nbsp;&nbsp;</a>" ;

			if( count > 14 )
					prevnextlink += "<td align='right'><a href=\"javascript:SubmitLink('"+(start+query_result_size)+"','"+(end+query_result_size)+"','"+(report_type)+"','"+(patient_class)+"','"+(stage)+"','"+disp_locn_code+"','"+(from_date)+"','"+(to_date)+"')\">Next</a>" ;
				
			records.set(0,prevnextlink);
		}
		catch ( Exception e ){
			e.printStackTrace() ;
			throw e ;
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

	// Method to get all the serial numbers for the given dsip numer in the given stage.
	public ArrayList getDispSrlNO(String disp_no,String curr_stage) {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		ArrayList alt_dtls		= new ArrayList();

		/*	A--->allocation/filling
		    D---->delivery/allstages	*/
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT136")) ;
			pstmt.setString(1,curr_stage);
			pstmt.setString(2,disp_no);
			pstmt.setString(3,login_facility_id);
			pstmt.setString(4,curr_stage);
			pstmt.setString(5,disp_no);
			pstmt.setString(6,login_facility_id);
			pstmt.setString(7,disp_no);//Added for [IN:047652]
			pstmt.setString(8,login_facility_id);//Added for [IN:047652]

            resultSet	= pstmt.executeQuery() ;
			while(resultSet.next()){
				alt_dtls.add(resultSet.getString("S_NO"));	
			}
			
			closeResultSet( resultSet ) ;//added for CRF-394/02[47510] start
			closeStatement( pstmt ) ;
			
			/*if(alt_dtls.size()==0){	// Commented for [IN:047652]
				pstmt		= connection.prepareStatement(" SELECT srl_no s_no FROM ph_disp_cons_dtl WHERE  disp_no = ? AND facility_id = ? AND disp_qty > 0 ") ;
				pstmt.setString(1,disp_no);
				pstmt.setString(2,login_facility_id);
				resultSet	= pstmt.executeQuery() ;
				while(resultSet.next()){
					alt_dtls.add(resultSet.getString("S_NO"));	
				}
			}//added for CRF-394/02[47510] end*/
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
		return alt_dtls;
	}

	public String getOrderId(String disp_no,String curr_stage) throws Exception{
		
		String order_id				= "";
        Connection connection			= null ;
        PreparedStatement pstmt			= null ;
        ResultSet resultSet				= null;

        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT139") ) ;
			
			pstmt.setString(1,curr_stage);
			pstmt.setString(2,disp_no);
			pstmt.setString(3,login_facility_id);
			pstmt.setString(4,curr_stage);
			pstmt.setString(5,disp_no);
			pstmt.setString(6,login_facility_id);
		
		    resultSet = pstmt.executeQuery() ;
            if ( resultSet != null && resultSet.next() ) {
				order_id	=	resultSet.getString("ORDER_ID");
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
		return order_id;
	}

/* This method returns the scheduled time for the IV Intermittent order */
	public ArrayList getOrderLineFieldValues(String order_id) {
		Connection connection				= null;
        PreparedStatement pstmt				= null;
        ResultSet resultSet					= null;	
		ArrayList order_line_field_values	= new ArrayList();	

		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT138")) ;
			pstmt.setString(1,order_id);
			resultSet	= pstmt.executeQuery() ;
			while(resultSet.next()){
				order_line_field_values.add(resultSet.getString("ORDER_LINE_FIELD_VALUE"));	
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
		return order_line_field_values;
   }

	/* This function is used get repeat value for IV with additives repaetvalue=duration/infuseover */
   public int getRepeatValue(String order_id) {
		Connection connection				= null;
        PreparedStatement pstmt				= null;
        ResultSet resultSet					= null;	
		int repaat_value					=0;

		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT140")) ;
			pstmt.setString(1,order_id);
			resultSet	= pstmt.executeQuery() ;
			if(resultSet.next()){
				repaat_value=resultSet.getInt("RepeatValue");	
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
		return repaat_value;
   }

   public String getSMLOcalLanguageID(){
		Connection connection				= null;
        PreparedStatement pstmt				= null;
        ResultSet resultSet					= null;	
		String language_id			        = "";

		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( "select LANGUAGE_ID from sm_language where PRIMARY_LANG_YN ='N' and EFF_STATUS='E' and rownum<2") ;			
			resultSet	= pstmt.executeQuery() ;
			while(resultSet.next()){
				language_id = checkForNull(resultSet.getString("LANGUAGE_ID"));
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
		return language_id;
	}

	//Code Added For Bru-HIMS-CRF-074 - Start
	public ArrayList getLangNameAndId(String langID){
        Connection connection				= null;
        PreparedStatement pstmt				= null;
        ResultSet resultSet					= null;	
		ArrayList landNameAndId			    = new ArrayList();
		try {
            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( "select LANGUAGE_ID,SHORT_NAME from sm_language where LANGUAGE_ID =?") ;
            pstmt.setString(1,langID);			
			resultSet	= pstmt.executeQuery() ;
			while(resultSet.next()){
				landNameAndId.add(checkForNull(resultSet.getString("LANGUAGE_ID")));
				landNameAndId.add(checkForNull(resultSet.getString("SHORT_NAME")));
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
		return landNameAndId;
   }
    //Code Added For Bru-HIMS-CRF-074 - End
	public String getDocNoDisplay() throws Exception{ //code added for GHL-CRF-0323[IN:040527] --Start 
		String result			= "N";
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;  
        String crit_field_id	=  "";//added for GHL-SCF-1069 [IN:060605]
		try {
	        connection	= getConnection() ;         
	        pstmt		= connection.prepareStatement( "SELECT CRIT_FIELD_ID,CRIT_FIELD_VAL FROM  PH_DISP_MEDN_DFLT WHERE FUNCTION_ID = 'PH_REPORT_DISP_SHEET' AND FACILITY_ID = DECODE (?, FACILITY_ID, FACILITY_ID, '*A') AND CRIT_FIELD_ID IN ('DISP_DOC_NO','DISP_DOC_NO_MC')") ;
			pstmt.setString(1,login_facility_id);
	            resultSet	= pstmt.executeQuery() ;
			while(resultSet.next()){	
				crit_field_id = checkForNull(resultSet.getString("CRIT_FIELD_ID"));//added if condition and DISP_DOC_NO_MC for GHL-SCF-1069 [IN:060605]
				if(crit_field_id.equals("DISP_DOC_NO"))
					result= checkForNull(resultSet.getString("CRIT_FIELD_VAL"),"N");
				else if(crit_field_id.equals("DISP_DOC_NO_MC"))
					setDocNoForMc(checkForNull(resultSet.getString("CRIT_FIELD_VAL"),"N"));		
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
		return result;
	} //code added for GHL-CRF-0323[IN:040527] --End 

	public ArrayList getDocNos(String patient_id, String disp_date,String pat_class,String stage) {	//code added for GHL-CRF-0323[IN:040527]--Start
		ArrayList doc_nos		= new ArrayList() ;
		Connection connection   = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet     = null ;

		try {
			connection = getConnection() ;
			if(stage.equals("D") ){
			//	pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_SELECT_DOC_NO_DELIVERY" )) ;
				boolean site_report_type = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","DISP_SHEET_CHECK");// added for ML-MMOH-CRF-0468
			if(!site_report_type){
      	pstmt = connection.prepareStatement("SELECT DISTINCT doc_no FROM ph_disp_hdr a, or_order b WHERE a.order_id = b.order_id AND a.patient_id = ? AND TRUNC (a.disp_date_time) = TO_DATE (?, 'DD/MM/YYYY') AND b.patient_class = ? ORDER BY doc_no");
			}else
      	pstmt = connection.prepareStatement("SELECT DISTINCT doc_no FROM ph_disp_hdr a, or_order b, pr_encounter c WHERE a.order_id = b.order_id AND a.patient_id = ? AND TRUNC (a.disp_date_time) = TO_DATE (?, 'DD/MM/YYYY') AND c.patient_class = ? AND b.patient_id = c.patient_id AND B.ENCOUNTER_ID = C.ENCOUNTER_ID ORDER BY doc_no"); //modified for GHL-CRF-0627
			}
			else{
				//pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_SELECT_DOC_NO_FILL" )) ;
					boolean site_report_type = eCommon.Common.CommonBean.isSiteSpecific(connection, "PH","DISP_SHEET_CHECK");// added for ML-MMOH-CRF-0468
			if(!site_report_type){
        pstmt = connection.prepareStatement("SELECT DISTINCT doc_no FROM ph_disp_hdr_tmp a, or_order b WHERE a.order_id = b.order_id	AND a.patient_id = ? AND TRUNC (a.dispensed_date_time) = TO_DATE (?, 'DD/MM/YYYY') AND b.patient_class = ? ORDER BY doc_no");
			}else
      	pstmt = connection.prepareStatement("SELECT DISTINCT doc_no FROM ph_disp_hdr_tmp a, or_order b, pr_encounter c WHERE a.order_id = b.order_id	AND a.patient_id = ? AND TRUNC (a.dispensed_date_time) = TO_DATE (?, 'DD/MM/YYYY') AND c.patient_class = ? AND b.patient_id = c.patient_id AND B.ENCOUNTER_ID = C.ENCOUNTER_ID ORDER BY doc_no"); //modified for GHL-CRF-0627
			}
			
			pstmt.setString(1,patient_id);
			pstmt.setString(2,disp_date);
			pstmt.setString(3,pat_class);
			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next()) {
				doc_nos.add(checkForNull(resultSet.getString("DOC_NO")))  ;								
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
		return doc_nos;
	}//code added for GHL-CRF-0323[IN:040527]--End

	public ArrayList getMedicalItemDispNos(String patient_id, String disp_date,String pat_class, String stage) { //Added for Bru-HIMS-CRF-394 [IN:043205]
		ArrayList disp_nos		= new ArrayList() ;
		Connection connection   = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet     = null ;
		try {
			connection = getConnection() ;
			int count=0;
			if(stage.equals("D")){
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_PRINT_DISP_MEDICAL_ITEM_LABEL" )) ;
			}
			else{
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_PRINT_DISP_MEDICAL_ITEM_LABEL_TMP" )) ;
			}
			pstmt.setString(++count,patient_id);
			pstmt.setString(++count,disp_date);
			pstmt.setString(++count,pat_class);
			pstmt.setString(++count,patient_id);
			pstmt.setString(++count,disp_date);
			pstmt.setString(++count,pat_class);
			resultSet = pstmt.executeQuery() ;
			while ( resultSet != null && resultSet.next()) {
				disp_nos.add(checkForNull(resultSet.getString( "DISP_NO" )))  ;
			}
		}
		catch ( Exception e ) {
			System.err.println( "Error loading sysdate" +e.toString()) ;
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {es.printStackTrace();

			}
		}	
		return disp_nos;
	}

	public String getPatientID(String p_doc_no){// added for AMS-CRF-0079 [IN:050762]
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	patient_id	=	"" ;
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_SELECT_PATIENT_ID_FOR_DOC_NO_TMP") ) ;
			pstmt.setString(1, p_doc_no);
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				patient_id	=	checkForNull(resultSet.getString("PATIENT_ID"));
			}	
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(patient_id.equals("")){
				pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_SELECT_PATIENT_ID_FOR_DOC_NO") ) ;
				pstmt.setString(1, p_doc_no);
				resultSet	= pstmt.executeQuery(); 
				if( resultSet != null && resultSet.next() ) {
					patient_id	=	checkForNull(resultSet.getString("PATIENT_ID"));
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
		return patient_id;	
	}
	
	public ArrayList getIvLegends() {//added for HSA-CRF-0221 [IN:050539] 
		Connection connection	= null;
        PreparedStatement pstmt = null;
        ResultSet resultSet		= null;
		ArrayList ivLegends		= new ArrayList();

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT127"));
			pstmt.setString(1, getLanguageId());
			resultSet	= pstmt.executeQuery();

			while (resultSet.next()) {
				ivLegends.add(checkForNull(resultSet.getString("IV_DRUG_FLUID_CONTINUOUS_LG")));
				ivLegends.add(checkForNull(resultSet.getString("IV_WITHOUT_ADDITIVES_LG")));
				ivLegends.add(checkForNull(resultSet.getString("IV_DRUG_FLUID_INTERMITTENT_LG")));
			}
		}
		catch (Exception e) {
			ivLegends.add(e);
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {}
		}
		return ivLegends;
	}
}
