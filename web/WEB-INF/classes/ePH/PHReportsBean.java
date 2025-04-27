/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 //saved on 02.11.2005
package ePH ;

import java.io.Serializable ;
import java.util.*;
import java.sql.*;
import ePH.Common.* ;
import eCommon.Common.* ;

public class PHReportsBean extends PhAdapter implements Serializable {

	public PHReportsBean() {
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

	public ArrayList getMasterList(String locale) {
		ArrayList masterList = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_REPORTS_MASTER_LIST" )) ;
			pstmt.setString(1,locale);
			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					masterList.add( resultSet.getString( "MASTER_CODE" ) ) ;
					masterList.add( resultSet.getString( "MASTER_CODE_DESC" ) );
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

		return masterList;
	}
	/* Over-ridden Adapter methods end here */

	public ArrayList getRefferedPrescriptions(String patient_id, String order_date_from, String order_date_to, String ord_by) {
		ArrayList referredPrescriptions = new ArrayList() ;
		HashMap record = null;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		StringBuilder sqlAppend= new StringBuilder();
		try {
			connection = getConnection() ;
			if( !order_date_from.equals("")  && !order_date_to.equals(""))
				sqlAppend.append(" AND TO_DATE (a.ref_date_time, 'DD/MM/RRRR' ) BETWEEN  TO_DATE(?, 'DD/MM/RRRR') AND  TO_DATE(?, 'DD/MM/RRRR') ");
			else if( !order_date_from.equals("") )
				sqlAppend.append(" AND TO_DATE (a.ref_date_time, 'DD/MM/RRRR' ) >=  TO_DATE (?, 'DD/MM/RRRR') ");
			else if( !order_date_to.equals(""))
				sqlAppend.append(" AND TO_DATE (a.ref_date_time, 'DD/MM/RRRR' ) <=  TO_DATE (?, 'DD/MM/RRRR') ");
			sqlAppend.append(" ORDER BY ord_date");
			if(ord_by.equals("DESCEND"))
				sqlAppend.append(" DESC");
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_REPORTS_REF_PRESC_SELECT" )+sqlAppend.toString());
			//pstmt = connection.prepareStatement( "SELECT A.REF_FACILITY_ID REF_FACILITY_ID, A.REF_DATE_TIME REF_DATE_TIME, B.DISP_DATE_TIME ORD_DATE, A.REF_SENT_PRACT_ID REF_SENT_PRACT_ID, A.REF_SENT_REMARKS REF_SENT_REMARKS, A.ORDER_ID ORDER_ID, B.DISP_NO DISP_NO ,c.short_desc disp_locn_desc FROM OR_ORDER A, PH_DISP_HDR B ,ph_disp_locn_lang_vw c WHERE A.ORDER_ID = B.ORDER_ID AND TO_DATE(B.DISP_DATE_TIME,'DD/MM/RRRR') BETWEEN  NVL(TO_DATE(?,'DD/MM/RRRR'),B.DISP_DATE_TIME) AND  NVL(TO_DATE(?,'DD/MM/RRRR'),B.DISP_DATE_TIME) AND A.PATIENT_ID=? AND A.REF_FACILITY_ID IS NOT NULL and b.FACILITY_ID=c.facility_id and trunc(DISP_DATE_TIME)=trunc(REF_DATE_TIME) and a.PERFORMING_DEPTLOC_CODE=c.disp_locn_code AND c.language_id = ? ORDER BY ORD_DATE"+orderby) ;
			int iCount=1;
			pstmt.setString(iCount++,getLanguageId());
			pstmt.setString(iCount++,patient_id);
			if(!order_date_from.equals("") )
				pstmt.setString(iCount++,order_date_from);
			if( !order_date_to.equals(""))
				pstmt.setString(iCount++,order_date_to);
			resultSet = pstmt.executeQuery() ;
			
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					record = new HashMap();

					record.put("ReferredFacility",checkForNull(resultSet.getString( "REF_FACILITY_ID" ))) ;
					record.put("ReferredPractitioner",checkForNull(resultSet.getString( "REF_SENT_PRACT_ID" ))) ;
					record.put("ReferredRemarks",checkForNull(resultSet.getString( "REF_SENT_REMARKS" ))) ;
					record.put("orderId",checkForNull(resultSet.getString( "ORDER_ID" ))) ;
					record.put("dispNo",checkForNull(resultSet.getString( "DISP_NO" ))) ;
					record.put("disp_locn_desc",checkForNull(resultSet.getString( "disp_locn_desc" ))) ;
				
					referredPrescriptions.add(record);
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
		return referredPrescriptions;
	}

	public ArrayList getDispLocn(String loc_type,String locale) {
		ArrayList disp_loc = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		try {
			connection = getConnection() ;
			if(loc_type.equals("C")){
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_REPORTS_DISP_SELECT1" )) ;
				pstmt.setString(1,locale);
			}
			else{
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_REPORTS_DISP_SELECT2" )) ;
				pstmt.setString(1,locale);
			}
			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					disp_loc.add( resultSet.getString( "DISP_LOCN_CODE" ) ) ;
					disp_loc.add( resultSet.getString( "LONG_DESC" ) );
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
		return disp_loc;
	}

	public ArrayList getFacilitys() {
		ArrayList facilities = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_ORDER_ROUTING_SELECT1" )) ;
			pstmt.setString(1,getLanguageId());
			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					facilities.add( resultSet.getString( "FACILITY_ID" ) ) ;
					facilities.add( resultSet.getString( "FACILITY_NAME" ) );
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

		return facilities;
	}


	
	public ArrayList getDespTimings(String disp_locn_code){
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList desptimes = new ArrayList();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_REPORTS_DISP_TIME_SELECT" )) ;
			pstmt.setString(1, login_facility_id);
			pstmt.setString(2, disp_locn_code);
			resultSet = pstmt.executeQuery() ;

			while (resultSet.next()) {
				desptimes.add(resultSet.getString("WORKING_HOURS_FROM"));
				desptimes.add(resultSet.getString("WORKING_HOURS_TO"));
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
		return desptimes;
	}

public ArrayList getAllDispLocn() {
		ArrayList disp_loc = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		try {
			connection = getConnection() ;
			
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_REPORTS_DISP_SELECT3" )) ;
			pstmt.setString(1, login_facility_id);
			pstmt.setString(2, getLanguageId());
			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					disp_loc.add( resultSet.getString( "DISP_LOCN_CODE" ) ) ;
					disp_loc.add( resultSet.getString( "SHORT_DESC" ) );
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

		return disp_loc;
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

	public String getSysDate() {
		String to_day="";
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_MEDN_ADMN_DATE_SELECT5" )) ;
			
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					to_day= resultSet.getString( "today" );
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

		return to_day;
	}
 
 public ArrayList  getProcessIds(String nursing_unit){

		ArrayList process_ids = new ArrayList();
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        

		try{
			connection			= getConnection() ;
			//pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_FILL_PROCESS_SELECT6"));
			pstmt				= connection.prepareStatement( "SELECT distinct FILL_PROC_ID FROM  ph_disp_hdr_tmp WHERE   LOCN_CODE =? and TRUNC(ADDED_DATE) = TRUNC(SYSDATE) and FILL_PROC_ID is not null order by FILL_PROC_ID");
			pstmt.setString(1,nursing_unit);
			resultSet = pstmt.executeQuery() ;
			
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					process_ids.add( resultSet.getString( "FILL_PROC_ID" ) );
				}
			}
		}catch ( Exception e ) {
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
        
		return process_ids;
	}

// get the order ids and corresponding disp ids 

 public ArrayList  getDispIds(String fillProcId,String n_unit_code){

		ArrayList order_ids = new ArrayList();
		ArrayList disp_ids = new ArrayList();
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_FILL_PROCESS_SELECT7A"));
			pstmt.setString(1,n_unit_code);
			pstmt.setString(2,fillProcId);
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					order_ids.add( resultSet.getString("ORDER_ID"));
				}
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;

		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		try{   
			StringBuffer strBuf = new StringBuffer();
			if(order_ids.size() > 0){
				strBuf.append("WHERE ORDER_ID in (?");
				for(int i=1; i<order_ids.size(); i++){
					strBuf.append(",");
					strBuf.append("?");
				}
				strBuf.append(")");
			}
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_FILL_PROCESS_SELECT8")+strBuf.toString());

			if(order_ids.size() > 0){
				for(int i=0; i<order_ids.size(); i++){
					pstmt.setString(i+1,(String)order_ids.get(i));	
				}
			}
		    resultSet = pstmt.executeQuery() ; 
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					disp_ids.add( resultSet.getString("FRMDSP"));
					disp_ids.add( resultSet.getString("TODSP"));
				}
			}
         }
		 catch (Exception e ){
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
		return disp_ids;
	}

	/*======code for getting return medication reason code and desc*/
	public ArrayList getReturnReasoncodes() {
		ArrayList reason_code = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		try {
			connection = getConnection() ;
			
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_RET_MEDN_SELECT6" )) ;
			pstmt.setString(1,getLanguageId());
			
			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					reason_code.add( resultSet.getString( "reason_code" ) ) ;
					reason_code.add( resultSet.getString( "reason_desc" ) );
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

		return reason_code;
	}

   public ArrayList getOrderingFacilityId(String p_user_name) {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		//System.err.println("p_user_name----->"+p_user_name);
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
		}catch ( Exception e ) {
			e.printStackTrace() ;
			result.add(e.toString());
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es) {
				es.printStackTrace() ;
			}
		}
		//System.err.println("result--from bean--->"+result);
		return result;
	}



public ArrayList getOrderingFacilities(String userName, String locale)
	{
		ArrayList order_facilities = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String sql = "SELECT B.FACILITY_ID FACILITY_ID,B.FACILITY_NAME FACILITY_NAME FROM SM_FACILITY_FOR_USER A, SM_FACILITY_PARAM_lang_vw B WHERE A.FACILITY_ID = B.FACILITY_ID AND B.STATUS ='E' AND APPL_USER_ID = ? AND B.LANGUAGE_ID= ?";

		try {
			connection = getConnection() ;
			
			pstmt = connection.prepareStatement(sql) ;
			pstmt.setString(1,userName);
			pstmt.setString(2,locale);
		
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					order_facilities.add( resultSet.getString( "FACILITY_ID" ) ) ;
					order_facilities.add( resultSet.getString( "FACILITY_NAME" ) );
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

		return order_facilities;

	}
//Added New Method to validate Patient Id. SCF.No-0237 & IN033170
	public ArrayList getPatientDetails(String patient_id){
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		ArrayList	records		=	new ArrayList();

		try{
			connection			= getConnection() ;
			//pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_DISP_DRUG_BY_PATIENT_SELECT2") ) ;
			pstmt				= connection.prepareStatement( "SELECT DECODE(?,'en',PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG,PATIENT_NAME)) PATIENT_NAME,GET_AGE(DATE_OF_BIRTH) AGE, DECODE(SEX,'M','male','F','female','unknown') GENDER, to_char(DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH FROM MP_PATIENT WHERE PATIENT_ID=?" ) ;
			pstmt.setString(1,getLanguageId());
			pstmt.setString(2,patient_id);
			resultSet	= pstmt.executeQuery();
			if(resultSet != null && resultSet.next() ) {
				records.add(resultSet.getString("PATIENT_NAME"));
				records.add(resultSet.getString("AGE"));
				records.add(resultSet.getString("GENDER"));
				records.add(resultSet.getString("DATE_OF_BIRTH"));
			}
		}
		catch(Exception e){
			records.add(e.toString());
			e.printStackTrace();
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){es.printStackTrace();}
		}
		return records;	
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
				main_patientId = checkForNull(resultSet.getString("VALID_PATIENT_ID"));					
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
		return main_patientId;	
	}

	public ArrayList getDispLocation() { //added for Bru-HIMS-CRF-085 [IN:029951]
		ArrayList displocation = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISP_LOCN_COMN_SELECT4" )) ;
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
	//Added for MMS-QH-CRF-0106 [IN:039374] - Start
	public ArrayList getCustomer(){
		ArrayList customer = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ITEM_CONSUMPTION_CUSTOMER_SELECT")) ;
			pstmt.setString(1,getLanguageId());
			resultSet = pstmt.executeQuery();
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					customer.add( resultSet.getString( "CUST_CODE" ) ) ;
					customer.add( resultSet.getString( "SHORT_NAME" ) );
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
		return customer;
	}

	public ArrayList getCustomerGroup(){
		ArrayList custGroup = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_CUSTOMER_GROUP_SELECT")) ;
			pstmt.setString(1,getLanguageId());
			resultSet = pstmt.executeQuery();
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					custGroup.add( resultSet.getString( "CUST_GROUP_CODE" ) ) ;
					custGroup.add( resultSet.getString( "SHORT_DESC" ) );
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
		return custGroup;
	}
	
	public int getRecord(String disp_locn_code,String dt_from,String dt_to,String customer_code,String pat_class,String customer_group_frm,String customer_group_to){
	    
	   // ArrayList custReport = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		int count=0;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ITEM_CONSUMPTION_REPORT_SELECT")) ;
			
			//pstmt.setString(1,getLanguageId());
			pstmt.setString(1,getLoginFacilityId());
			pstmt.setString(2,disp_locn_code);
			pstmt.setString(3,dt_from);
			pstmt.setString(4,dt_to);
			pstmt.setString(5,customer_code);
			pstmt.setString(6,pat_class);
			pstmt.setString(7,customer_group_frm);
			pstmt.setString(8,customer_group_to);
			
			resultSet = pstmt.executeQuery();
			if ( resultSet != null && resultSet.next()) {
				/*while ( resultSet.next() ) {
				    custReport.add( resultSet.getString( "item_code" ) ) ;
				}*/
				count = Integer.parseInt(checkForNull(resultSet.getString( "item_count" ),"0"));
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
		return count;
	}//Added for MMS-QH-CRF-0106 [IN:039374] - End

	public ArrayList getPolicy(){ //added for MMS-QH-CRF-0110[IN039378] start 
		ArrayList policy = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_POLICY_SELECT")) ;
			resultSet = pstmt.executeQuery();
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					policy.add( resultSet.getString( "POLICY_TYPE_CODE" ) ) ;
					policy.add( resultSet.getString( "SHORT_DESC" ) );
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
		return policy;
	}
	public ArrayList getSpecaility(){ 
		ArrayList speciality = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ORDER_ROUTING_SELECT2")) ;
			pstmt.setString(1,getLoginFacilityId());
			pstmt.setString(2,getLanguageId());
			resultSet = pstmt.executeQuery();
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					speciality.add( resultSet.getString( "NURSING_UNIT_CODE" ) ) ;
					speciality.add( resultSet.getString( "SHORT_DESC" ) );
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
		return speciality;
	}
	
	public int getQueyCountCostlyRxCustomer(String custgrpfrom,String custfrom,String fromdate,String todate,String p_sal_trn_type){ //added for MMS-QH-CRF-0110[IN039378] end 
		//ArrayList speciality = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		
		//String query="SELECT  count(*) count FROM st_sal_hdr b, st_sal_dtl a, (SELECT cust_code, patient_id, episode_id encounter_id, operating_facility_id facility_id FROM bl_episode_fin_dtls WHERE episode_type IN ('D', 'I') UNION SELECT cust_code, patient_id, TO_NUMBER (episode_id || '000' || visit_id) encounter_id, operating_facility_id facility_id FROM bl_visit_fin_dtls WHERE episode_type IN ('E', 'O') UNION SELECT cust_code, patient_id, NULL encouner_id, NULL facliity_id FROM bl_patient_fin_dtls) c,(SELECT facility_id, doc_type_code, doc_no, doc_srl_no, SUM (sal_item_qty) sal_item_qty, SUM (ret_item_qty) ret_item_qty, (SUM (sal_item_qty) - SUM (ret_item_qty)) total_batch_qty FROM st_sal_dtl_exp GROUP BY facility_id, doc_type_code, doc_no, doc_srl_no) d WHERE a.facility_id = b.facility_id AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND a.facility_id = d.facility_id AND a.doc_type_code = d.doc_type_code AND a.doc_no = d.doc_no AND a.doc_srl_no = d.doc_srl_no AND b.finalized_yn = 'Y' AND c.patient_id = b.patient_id AND NVL (c.encounter_id, 0) = NVL (b.encounter_id, 0) AND NVL (c.facility_id, b.facility_id) = b.facility_id AND b.sal_trn_type = NVL (?, b.sal_trn_type) AND b.doc_date BETWEEN TO_DATE (?, 'DD/MM/YYYY') AND TO_DATE (?, 'DD/MM/YYYY') + 0.900 AND ( ? IS NULL AND NVL (cust_code, 'X') = NVL (cust_code, 'X') OR (? IS NOT NULL AND cust_code BETWEEN NVL (?, cust_code) AND NVL (?, cust_code) ) OR ( ? IS NULL AND NVL (cust_code, 'X') = NVL (cust_code, 'X') OR ? IS NOT NULL AND EXISTS ( SELECT 'Y' FROM ar_customer WHERE cust_group_code BETWEEN NVL (?, cust_group_code ) AND NVL (?, cust_group_code )) ) )"; //commented for IN045590
		String query="SELECT  COUNT (*) COUNT FROM st_sal_hdr b, st_sal_dtl a, (SELECT cust_code, patient_id, episode_id encounter_id, operating_facility_id facility_id FROM bl_episode_fin_dtls WHERE episode_type IN ('D', 'I') UNION SELECT cust_code, patient_id, TO_NUMBER (episode_id || '000' || visit_id) encounter_id, operating_facility_id facility_id FROM bl_visit_fin_dtls WHERE episode_type IN ('E', 'O') UNION SELECT cust_code, patient_id, NULL encouner_id, NULL facliity_id FROM bl_patient_fin_dtls) c, (SELECT   facility_id, doc_type_code, doc_no, doc_srl_no, SUM (sal_item_qty) sal_item_qty, SUM (ret_item_qty) ret_item_qty, (SUM (sal_item_qty) - SUM (ret_item_qty)) total_batch_qty FROM st_sal_dtl_exp GROUP BY facility_id, doc_type_code, doc_no, doc_srl_no) d WHERE a.facility_id = b.facility_id AND a.doc_type_code = b.doc_type_code AND a.doc_no = b.doc_no AND a.facility_id = d.facility_id AND a.doc_type_code = d.doc_type_code AND a.doc_no = d.doc_no AND a.doc_srl_no = d.doc_srl_no AND b.finalized_yn = 'Y' AND c.patient_id = b.patient_id AND NVL (c.encounter_id, 0) = NVL (b.encounter_id, 0) AND NVL (c.facility_id, b.facility_id) = b.facility_id AND b.sal_trn_type = NVL (?, b.sal_trn_type) AND b.doc_date BETWEEN TO_DATE (?, 'DD/MM/YYYY') AND TO_DATE (?, 'DD/MM/YYYY') + 0.900 AND NVL (cust_code, '!') = NVL (?, NVL (cust_code, '!')) AND (   (? IS NULL AND 1 = 1) OR ( ? IS NOT NULL AND EXISTS ( SELECT 'Y' FROM ar_customer WHERE cust_group_code = NVL (?, cust_group_code)) ) )"; 
		int count=0;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(query);
			
			pstmt.setString(1,p_sal_trn_type);
			pstmt.setString(2,fromdate);
			pstmt.setString(3,todate);
			pstmt.setString(4,custfrom);
			pstmt.setString(5,custgrpfrom);
			pstmt.setString(6,custgrpfrom);
			pstmt.setString(7,custgrpfrom);
			resultSet = pstmt.executeQuery();
			if ( resultSet != null && resultSet.next()) {
				count=resultSet.getInt("count" ) ;
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
		return count;
	}
	public ArrayList getCustomerBasedCustgrp(String custgrp){ // added for MMS-QH-CRF-0110[IN045590] start
		ArrayList customer = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			connection = getConnection() ;
			if(custgrp!=null && !custgrp.equals("")){
				pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_CUSTOMER_SELECT")) ;
				pstmt.setString(1,custgrp);
				pstmt.setString(2,getLanguageId());
			}
			else{
				pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_ITEM_CONSUMPTION_CUSTOMER_SELECT")) ;
				pstmt.setString(1,getLanguageId());
			}
			resultSet = pstmt.executeQuery();
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					customer.add( resultSet.getString( "CUST_CODE" ) ) ;
					customer.add( resultSet.getString( "SHORT_NAME" ) );
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
		return customer;
	}//added for MMS-QH-CRF-0110[IN045590] end

	public int getConsumptionByDoctor(String p_date_from,String p_date_to,String p_patient_class,String p_pract_id,String p_locn_code,String p_cust_grp_frm_code,String p_cust_grp_to_code,String p_cust_frm_code,String p_policy_type_code){//Added for MMS-QH-CRF-0108-Start
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		int count=0;
		try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_CONSUMPTION_BY_DOCTOR_SELECT")) ;
				pstmt.setString(1,p_date_from.trim());
				pstmt.setString(2,p_date_to.trim());
				pstmt.setString(3,p_patient_class.trim());
				pstmt.setString(4,p_patient_class.trim());//added for IN50969 start
				pstmt.setString(5,p_patient_class.trim());
				pstmt.setString(6,p_patient_class.trim());
				pstmt.setString(7,p_patient_class.trim());//added for IN50969 end
				pstmt.setString(8,p_pract_id.trim());
				pstmt.setString(9,p_locn_code.trim());
				pstmt.setString(10,p_cust_grp_frm_code.trim());
				pstmt.setString(11,p_cust_grp_to_code.trim());
				pstmt.setString(12,p_cust_frm_code.trim());
				pstmt.setString(13,p_policy_type_code.trim());
				resultSet = pstmt.executeQuery();
				if ( resultSet != null && resultSet.next()) {
					count = Integer.parseInt(checkForNull(resultSet.getString( "ITEM_COUNT" ),"0"));
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
		return count;
	}
	 public ArrayList getAllSpecaility(){ 
		ArrayList speciality = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_SPECIALITY_SELECT")) ;
			pstmt.setString(1,getLanguageId());
			resultSet = pstmt.executeQuery();
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					speciality.add( resultSet.getString( "CODE" ) ) ;
					speciality.add( resultSet.getString( "DESCRIPTION" ) );
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
		return speciality;
	}//Added for MMS-QH-CRF-0108-End
	
	public ArrayList getBillingGroup(){    
		ArrayList billingGroup = new ArrayList();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_BILLING_GROUP_SELECT")) ;
			pstmt.setString(1,getLanguageId());
			resultSet = pstmt.executeQuery();
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					billingGroup.add( resultSet.getString( "BLNG_GRP_ID" ) ) ;
					billingGroup.add( resultSet.getString( "SHORT_DESC" ) );
					billingGroup.add( resultSet.getString( "SETTLEMENT_IND" ) );
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
		return billingGroup;
	}
	public ArrayList getDispLocation(String facility_id) { //added for HSA-CRF-0137 [IN:048413]
		ArrayList displocation = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISP_LOCN_COMN_SELECT4" )) ;
			pstmt.setString(1,facility_id);
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
	
	public ArrayList getEncounterIdDetails( String patient_id, String pat_cat){//Added for MMS-DM-CRF-0012 [IN:054569]
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		ArrayList EncounterIdList = new ArrayList();
		try{
			connection = getConnection() ;
			if(pat_cat.equals("")){
				pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_RETMEDICATION_ALL_ENCOUNTER_SELECT"));
				pstmt.setString(1, patient_id);
				pstmt.setString(2, login_facility_id);
				pstmt.setString(3, patient_id);
				pstmt.setString(4, login_facility_id);
			}
			else{
				if(pat_cat.equals("IP"))
					pat_cat = "I";
				else if(pat_cat.equals("OP"))
					pat_cat = "O";
				pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_RETMEDICATION_ENCOUNTER_SELECT"));
				pstmt.setString(1, patient_id);
				pstmt.setString(2, pat_cat);
				pstmt.setString(3, pat_cat);
				pstmt.setString(4, login_facility_id);
				pstmt.setString(5, patient_id);
				pstmt.setString(6, pat_cat);
				pstmt.setString(7, login_facility_id);
			}
			resultSet			= pstmt.executeQuery();
			if(resultSet!=null){
				while(resultSet.next()){
					EncounterIdList.add(resultSet.getString("ENCOUNTER_ID"));
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
		return EncounterIdList;
	}
	
	public String getWeekRangeOfSysdate(){//added for HSA-CRF-0284 [IN:053276] 
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
	//	ArrayList EncounterIdList = new ArrayList();  Removed for IN063877
		StringBuffer sql = new StringBuffer();
	    sql.append("Select TO_CHAR(SYSDATE,'DD/MM/rrrr'),TO_CHAR(SYSDATE+6,'DD/MM/rrrr')  From DUAL " );
		String strVal = "";
		String date_range_week = "";
	//	String current_week_date = "";  Removed for IN063877
		try{
			connection  =  getConnection();
			pstmt = connection.prepareStatement(sql.toString()); 
			resultSet = pstmt.executeQuery();
			if(resultSet.next()){
				strVal = resultSet.getString(1); 
				strVal	= com.ehis.util.DateUtils.getCurrentDate("DMY",language_id);
				date_range_week = resultSet.getString(2);
			}
			date_range_week = strVal+":"+date_range_week;
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
		return date_range_week;
	}

	public ArrayList getFormDtls() { //added for HSA-CRF-0236 [IN:051488]
		ArrayList alFormDtls = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TDM_SELECT_FORM" )) ;
			pstmt.setString(1,getLanguageId());

			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					alFormDtls.add( resultSet.getString( "FORM_CODE" ) ) ;
					alFormDtls.add( resultSet.getString( "FORM_DESC" ) );
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
		return alFormDtls;
	}

	public ArrayList getOPDispLocations(String facility_id) { //added for HSA-CRF-0237 [IN:051697]
		ArrayList displocation = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_FACILITY_PARAM_SELECT6" )) ;
			pstmt.setString(1,facility_id);
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
	
	public String getMonthRangeOfSysdate(){ //added for MMS--QH-CRF-0116 [IN:039384] - Start
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
	//	ArrayList EncounterIdList = new ArrayList();  Removed for IN063877
		StringBuffer sql = new StringBuffer();
	    sql.append("Select TO_CHAR(SYSDATE,'DD/MM/rrrr'),TO_CHAR(SYSDATE-31,'DD/MM/rrrr')  From DUAL " );
		String strVal = "";
		String date_range_month = "";
		try{
			connection  =  getConnection();
			pstmt = connection.prepareStatement(sql.toString()); 
			resultSet = pstmt.executeQuery();
			if(resultSet.next()){
				strVal = resultSet.getString(1); 
				strVal	= com.ehis.util.DateUtils.getCurrentDate("DMY","en");
				date_range_month = resultSet.getString(2);
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
		return date_range_month;
	} //added for MMS--QH-CRF-0116 [IN:039384] - End
 
	
	//added for ML-MMOH-CRF-1089 START
	public String getiv_prep_yn(String worksheet_id){ 
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		StringBuffer sql = new StringBuffer(); 
	    
		sql.append("select distinct WS_TYPE from PH_TPN_WORKSHEET_HDR where TPN_WORKSHEET_ID=? " );
		
	    String strVal = "";
		try{
			connection  =  getConnection();
			pstmt = connection.prepareStatement(sql.toString()); 
			pstmt.setString(1,worksheet_id);
			
			resultSet = pstmt.executeQuery();
			if(resultSet.next()){
				strVal = resultSet.getString("WS_TYPE"); 
		
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
		return strVal;
	}
	//added for ML-MMOH-CRF-1089 END

// Added for AAKH-CRF-0140 STARTS
	public String getWeekRangeSysdate(){ 
		Connection connection	= null ;
		PreparedStatement pstmt	= null ;
		ResultSet resultSet		= null ;
		StringBuffer sql = new StringBuffer();
	    sql.append("Select TO_CHAR(SYSDATE-6,'DD/MM/rrrr'),TO_CHAR(SYSDATE,'DD/MM/rrrr')  From DUAL " );
		String strValFrom		= "";
		String strValTo			= "";
		String strDate			= "";
		try{
				connection  =  getConnection();
				pstmt = connection.prepareStatement(sql.toString()); 
				resultSet = pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
					strValFrom = resultSet.getString(1); 
					strValTo = resultSet.getString(2);
				}
				strDate = strValFrom+":"+strValTo;
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
		return strDate;
	}
	// END for AAKH-CRF-0140 ENDS
	// PMG2022-MMS-CRF-0002   [39764 START]
		public boolean getSiteSalesReport(){
	        Connection  con=null;
	        boolean  phGrpDescCodeSiteSpecificYN=false;
	        try
	        {
	                con=getConnection();
	                phGrpDescCodeSiteSpecificYN=eCommon.Common.CommonBean.isSiteSpecific(con,"PH","DRUG_USAGE_SALES_REPORT");
	        }
	        catch(Exception e){
	          e.printStackTrace();
	       }
	       finally{
	               try{
	                 closeConnection(con);
	       }
	      catch(Exception es){
	           es.printStackTrace();
	      }
	   }
	   return  phGrpDescCodeSiteSpecificYN;
	  }
	// PMG2022-MMS-CRF-0002   [39764 END]
}


