/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
?             100            ?           created
08/06/2012	  IN032329		Menaka V	 Not able to record the special approval functions once a patient is picked up from the “Referral
										 List” in CA . 
--------------------------------------------------------------------------------------------------------
*/
package eOR;

import java.io.* ;
import java.util.* ;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;

import javax.servlet.*;
import javax.servlet.http.*;

import eOR.Common.* ;
import eCommon.Common.*;
import webbeans.eCommon.*;


import eOR.ORSplApprvOrder.*;

public class SpecialApproveOrders extends eOR.Common.OrAdapter implements java.io.Serializable {

	protected String order_type_code = "";
	protected String ord_consent_reqd_yn = "";
	protected String total_records = "";
	protected String pract_id = "";

//	protected HashMap all_final_values = new HashMap();

	protected Hashtable allValues = new Hashtable();

//	HttpServletRequest request 				= null;
//	HttpServletResponse response 			= null;
//	protected ArrayList persistence_details		= new ArrayList();

	StringBuffer traceVals = new StringBuffer();
	
	public void setMode(String mode){					this.mode = mode;	}
	public void setTotalRecs(String total_records){	this.total_records = total_records;	}
	public void setPractId(String pract_id){			this.pract_id = pract_id;	}

/*	public void setDetails(ArrayList persistence_details){
			this.persistence_details=persistence_details;
	}
*/

//	public void setFinalValues(HashMap all_final_values){this.all_final_values = all_final_values;	}


/*	public void setRequestResponse(HttpServletRequest request, HttpServletResponse response){
			this.request = request;
			this.response = response;
	}
*/

	public String getMode(){				return mode;	}
	public String getTotalRecs(){			return total_records;	}
    public Hashtable getAllValues() {
        return allValues;
    }
/*	public ArrayList getDetails(){		return persistence_details;	} */

//	public HashMap getFinalValues(){		return all_final_values;	}


 	public void clear() {
			order_type_code		= "";
			ord_consent_reqd_yn = "";
			total_records		= "";
			pract_id			= "";
 // 			persistence_details = null;
		 	super.clear() ;
 	}

/**
	This will populate all the locations for the location type
	@return		:	ArrayList
*/

	public ArrayList getLocation(Properties properties, String location_type, String practitioner_id, String facility_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;

		try {
			connection			= ConnectionManager.getConnection(properties) ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_AUTHORISE_ORDER_SELECT_LOCATION") ) ;
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, language_id);
			pstmt.setString( 3, practitioner_id.trim() ) ;
			pstmt.setString( 4, location_type.trim() ) ;
			pstmt.setString( 5, facility_id.trim() ) ;
			pstmt.setString( 6, language_id);
			pstmt.setString( 7, location_type.trim() ) ;


			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "locn_code" )  ;
				record[1] = resultSet.getString( "locn_short_desc" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null)  ConnectionManager.returnConnection(connection, properties);
		}

		return OrderCat;
	}


/**
	This will value of Special Approval required field ("Yes / No")
	@return		:	String
*/

	public String getSplYN(Properties properties, String practitioner_id, String resp_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String  auth_yn= "";

		try {
			connection			= ConnectionManager.getConnection(properties) ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SPECIAL_ORDER_SELECT_SPL_YN") ) ;
			pstmt.setString( 1, practitioner_id.trim() ) ;
			pstmt.setString( 2, resp_id) ;
			pstmt.setString( 3, "Y" ) ;

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				auth_yn = resultSet.getString( "spl_appr_yn" )  ;
			}

		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}

		return auth_yn;
	}


/**

	@return		:	String
*/

	public String getVisitAdmnDate(String facility_id, String encntr_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String  vist_adm_Date= "";

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_AUTHORISE_ORDER_VISIT_ADMN_DT") ) ;
			pstmt.setString( 1, facility_id.trim() ) ;
			pstmt.setString( 2, encntr_id) ;

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				vist_adm_Date = resultSet.getString( "vist_adm_Date" )  ;
			}

		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}

		return vist_adm_Date;
	}



/**
	This will populate all the Status list by priority
	@return		:	ArrayList
*/

	public ArrayList getStatusByPriority(Properties properties, String source_type, String source_code, String practitioner_id, String resp_id, String patientId, String period_from, String period_to) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList OrderCat = new ArrayList() ;

		try {
			if(source_type.equals(" ")) source_type = null;
			if(source_code.equals(" ")) source_code = null;
			if(period_from.equals(" ")) period_from = null;
			if(period_to.equals(" ")) period_to = null;
	if ( !language_id.equals("en") )
{ 
		
period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMY",language_id,"en");
period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMY",language_id,"en");
}
			connection			= ConnectionManager.getConnection(properties) ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SPECIAL_ORDER_SELECT_STATUS_PRIORITY") ) ;
			pstmt.setString( 1, patientId);
			pstmt.setString( 2, source_type ) ;
			pstmt.setString( 3, source_type ) ;
			pstmt.setString( 4, source_code) ;
			pstmt.setString( 5, practitioner_id.trim() ) ;
			pstmt.setString( 6, resp_id.trim() ) ;
			pstmt.setString( 7, practitioner_id.trim() ) ;
			pstmt.setString( 8, period_from.trim() ) ;
			pstmt.setString( 9, period_to.trim() ) ;
			

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[4];
				record[0] = resultSet.getString( "priorty" )  ;
				record[1] = resultSet.getString( "totalCount" )  ;
				record[2] = resultSet.getString( "priority_desc" )  ;
				record[3] = resultSet.getString( "priority" )  ;

				OrderCat.add(record) ;
			}

		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}

		return OrderCat;
	}

    public ArrayList getStatusByPriority(Properties properties,String ord_facility, String source_type, String source_code, String practitioner_id, String resp_id, String patientId, String period_from, String period_to,String functionID,String filter) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList OrderCat = new ArrayList() ;
		String sql="";
		int indexid =1;//IN032329

		try {
			if(patientId.equals(""))	patientId	= null;//IN032329
			if(source_type.equals(" ")) source_type = null;
			if(source_code.equals(" ")) source_code = null;
			if(period_from.equals(" ")) period_from = null;
			if(period_to.equals(" ")) period_to = null;
			if(filter.equals("AL")) filter = "";
			if ( !language_id.equals("en") )
{ 
period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMY",language_id,"en");
period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMY",language_id,"en");
}

			connection			= ConnectionManager.getConnection(properties) ;
			//IN032329 Starts
			//sql=OrRepositoryExt.getOrKeyValue("SQL_OR_REVIEW_ORDER_SELECT_STATUS_PRIORITY");
			sql= "SELECT nvl(a.PRIORITY,'R') PRIORITY,COUNT (*) no_of_rec FROM OR_ORDER_PEND_STATUS_LOG a WHERE a.PEND_STATUS_IND=? AND NVL (a.cont_order_ind, 'DO') IN ('CO', 'DO', 'CR', 'DR') and ORDERING_FACILITY_ID=? and substr(a.order_id,1,2)!='CS' and  nvl(a.SOURCE_TYPE,'XX')=NVL(decode((?),'W','N',(?)), nvl(a.source_TYPE,'XX')) AND nvl(a.SOURCE_code,'XX') =NVL((?), nvl(a.source_CODE,'XX')) and a.patient_id = nvl(?,a.patient_id) and a.ORDER_DATE between TO_DATE(?,'dd/mm/yyyy') AND  TO_DATE(?,'dd/mm/yyyy')+.99999   ##FILTER1$$ AND a.order_category in (SELECT order_category  FROM or_review_user_categories  WHERE (practitioner_id = ?  or resp_id = ?) AND decode (?,'CS',cosign_yn,'PO',AUTH_YN,'PS',SPL_APPR_YN) = 'Y') ##FILTER$$ Group by nvl(a.PRIORITY,'R') order by decode(nvl(a.PRIORITY,'R'),'S','1','U','2','R','3')";
			if(patientId==null)
			{
				sql=sql.replace("##FILTER1$$","  and (a.source_type != 'R' OR (a.source_type, a.source_code) IN (SELECT locn_type ,locn_code  FROM ca_pract_by_locn_detail WHERE facility_id = ? and practitioner_id = (?) and performing_facility_id=? UNION ALL SELECT 'N',locn_code  FROM ca_pract_by_locn_view WHERE facility_id = ? and practitioner_id = (?) and locn_type='W') OR a.source_type = 'R' ) ");//ML-MMOH-SCF-2965
			}
			else 
			{
				sql=sql.replace("##FILTER1$$"," and a.patient_id = ?  ");
			}
			//IN032329 Ends
			/* Added By Arvind For CEF-804 */
			if(filter.equals("RP")){
			 sql=sql.replace("##FILTER$$"," AND EXISTS ( SELECT 1 FROM ca_encntr_pract_reln WHERE patient_id = a.patient_id AND practitioner_id =? AND SYSDATE BETWEEN begin_date_time AND NVL (end_date_time, SYSDATE) AND encounter_id = a.encounter_id  AND facility_id = a.ordering_facility_id AND NVL (status, '01') = '01') AND performing_facility_id =?");
			}else if(filter.equals("MS")){
			 sql=sql.replace("##FILTER$$"," AND EXISTS (SELECT 1 FROM pr_encounter b WHERE b.encounter_id = a.encounter_id AND  b.specialty_code IN (SELECT c.specialty_code FROM am_pract_all_splty_vw c  WHERE c.practitioner_id =? AND c.facility_id = a.ordering_facility_id)) /*AND NOT EXISTS ( SELECT 1 FROM ca_encntr_pract_reln WHERE patient_id = a.patient_id AND practitioner_id =? AND SYSDATE BETWEEN begin_date_time AND NVL (end_date_time, SYSDATE ) AND encounter_id = a.encounter_id AND facility_id =a.ordering_facility_id AND NVL (status, '01') = '01')*/ AND performing_facility_id =? AND a.order_date BETWEEN TRUNC (SYSDATE - 7) AND TRUNC (SYSDATE) + .9999 AND a.order_category != 'CS' AND (  a.source_type = 'R' OR (a.source_type, a.source_code) IN (SELECT DECODE (locn_type, 'W', 'N', locn_type), locn_code FROM ca_pract_by_locn_view   WHERE facility_id =? AND practitioner_id =?))");
			}else if(filter.equals("")){
				sql=sql.replace("##FILTER$$","");
			}
			
			/* End Here */
			System.out.println("sql-----316--------------"+sql);
			pstmt = connection.prepareStatement(sql); 	
			pstmt.setString( indexid++, functionID );
			pstmt.setString( indexid++, ord_facility.trim() );
			pstmt.setString( indexid++, source_type );
			pstmt.setString( indexid++, source_type );
			pstmt.setString( indexid++, source_code );
			pstmt.setString( indexid++, patientId );
			pstmt.setString( indexid++, period_from) ;
			pstmt.setString( indexid++, period_to) ;
			//IN032329 Starts
			//pstmt.setString( 9, ord_facility.trim()) ;
			//pstmt.setString( 10, practitioner_id.trim() ) ;
			/* added by Arvind */
			//pstmt.setString( 11, ord_facility.trim() ) ;

			/*end here */
			//pstmt.setString( 12, ord_facility.trim()) ;
			//pstmt.setString( 13, practitioner_id.trim() ) ;
			if(patientId==null)
			{
				pstmt.setString( indexid++, ord_facility.trim()) ;
				pstmt.setString( indexid++, practitioner_id.trim() ) ;
				pstmt.setString( indexid++, ord_facility.trim() ) ;
				pstmt.setString( indexid++, ord_facility.trim()) ;
				pstmt.setString( indexid++, practitioner_id.trim() ) ;
			}
			else
			{			
				pstmt.setString( indexid++, patientId) ;
			}
			//IN032329 Ends
			pstmt.setString( indexid++, practitioner_id.trim() ) ;
			pstmt.setString( indexid++, resp_id.trim() ) ;
			pstmt.setString( indexid++, functionID );
			if(filter.equals("RP")){
				pstmt.setString( indexid++, practitioner_id.trim() );
				pstmt.setString( indexid++, ord_facility.trim() );
			}else if(filter.equals("MS")){
				pstmt.setString( indexid++, practitioner_id.trim() );
		//		pstmt.setString( 18, practitioner_id.trim() );
				pstmt.setString( indexid++, ord_facility.trim() );
				pstmt.setString( indexid++, ord_facility.trim() );
				pstmt.setString( indexid++, practitioner_id.trim() );
			}

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[4];
				record[0] = resultSet.getString( "PRIORITY" )  ;
				record[1] = resultSet.getString( "no_of_rec" )  ;
				record[2] = resultSet.getString( "PRIORITY" )  ;
				OrderCat.add(record) ;
			}

		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}

		return OrderCat;
	}

/**
	This will populate all the Status list by Category
	@return		:	ArrayList
*/

	public ArrayList getStatusByCategory(Properties properties,String ord_facility, String source_type, String source_code, String practitioner_id, String resp_id, String patientId, String period_from, String period_to,String functionID,String filter) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;
		String sql="";
		int indexid =1;//IN032329
		try {
			if(patientId.equals(""))	patientId	= null;//IN032329
			if(source_type.equals(" ")) source_type = null;
			if(source_code.equals(" ")) source_code = null;
			if(period_from.equals(" ")) period_from = null;
			if(period_to.equals(" ")) period_to = null;
			if(filter.equals("AL")) filter = "";
			if ( !language_id.equals("en") )
{ 
period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMY",language_id,"en");
period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMY",language_id,"en");
}

			connection			= ConnectionManager.getConnection(properties) ;
			//IN032329 Starts
			//sql=OrRepositoryExt.getOrKeyValue("SQL_OR_REVIEW_ORDER_SELECT_STATUS_CATEGORY");
			sql="SELECT OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2')   short_description,COUNT (*) no_of_rec, a.order_category ord_cat FROM OR_ORDER_PEND_STATUS_LOG a WHERE a.PEND_STATUS_IND=?  AND NVL (a.cont_order_ind, 'DO') IN ('CO', 'DO', 'CR', 'DR') and ORDERING_FACILITY_ID=? and substr(a.order_id,1,2)!='CS' and nvl(a.SOURCE_TYPE,'XX')=NVL(decode((?),'W','N',(?)),nvl(a.source_TYPE,'XX')) AND nvl(a.SOURCE_code,'XX') =NVL((?),nvl(a.source_CODE,'XX')) AND  a.patient_id = nvl(?, a.patient_id) and  a.ORDER_DATE between TO_DATE(?,'dd/mm/yyyy') AND  TO_DATE(?,'dd/mm/yyyy')+0.99999 ##FILTER1$$ and a.order_category in (SELECT order_category  FROM or_review_user_categories  WHERE (practitioner_id = ?  or resp_id = ?) AND decode (?,'CS',cosign_yn,'PO',AUTH_YN,'PS',SPL_APPR_YN) = 'Y')  ##FILTER$$ Group by  a.order_category Order by 1";
			if(patientId==null)
			{
				sql=sql.replace("##FILTER1$$","  and (a.source_type != 'R' OR (a.source_type, a.source_code) IN (SELECT locn_type ,locn_code  FROM ca_pract_by_locn_detail WHERE facility_id = ? and practitioner_id = (?) and performing_facility_id=? UNION ALL SELECT 'N',locn_code  FROM ca_pract_by_locn_view WHERE facility_id = ? and practitioner_id = (?) and locn_type='W') OR a.source_type = 'R' )");////ML-MMOH-SCF-2965
			}
			else 
			{
				sql=sql.replace("##FILTER1$$"," and a.patient_id = ?  ");
			}
			//IN032329 Ends
			/* Added By Arvind For CRF-804*/

			if(filter.equals("RP")){
				sql=sql.replace("##FILTER$$","AND EXISTS ( SELECT 1 FROM ca_encntr_pract_reln WHERE patient_id = a.patient_id AND practitioner_id =? AND SYSDATE BETWEEN begin_date_time AND NVL (end_date_time, SYSDATE) AND encounter_id = a.encounter_id  AND facility_id = a.ordering_facility_id AND NVL (status, '01') = '01') AND performing_facility_id =?");
			}else if(filter.equals("MS")){
			 sql=sql.replace("##FILTER$$"," AND EXISTS (SELECT 1 FROM pr_encounter b WHERE b.encounter_id = a.encounter_id AND  b.specialty_code IN (SELECT c.specialty_code FROM am_pract_all_splty_vw c  WHERE c.practitioner_id =? AND c.facility_id = a.ordering_facility_id)) /*AND NOT EXISTS ( SELECT 1 FROM ca_encntr_pract_reln WHERE patient_id = a.patient_id AND practitioner_id =? AND SYSDATE BETWEEN begin_date_time AND NVL (end_date_time, SYSDATE ) AND encounter_id = a.encounter_id AND facility_id =a.ordering_facility_id AND NVL (status, '01') = '01')*/ AND performing_facility_id =? AND a.order_date BETWEEN TRUNC (SYSDATE - 7) AND TRUNC (SYSDATE) + .9999 AND a.order_category != 'CS' AND (  a.source_type = 'R' OR (a.source_type, a.source_code) IN (SELECT DECODE (locn_type, 'W', 'N', locn_type), locn_code FROM ca_pract_by_locn_view   WHERE facility_id =? AND practitioner_id =?))");
			}else if(filter.equals("")){
				sql=sql.replace("##FILTER$$","");
			}

			/* End Here */
			System.out.println("sql-----434--------------"+sql);
			pstmt = connection.prepareStatement(sql); 	
			pstmt.setString( indexid++, language_id);
			pstmt.setString( indexid++, functionID );
			pstmt.setString( indexid++, ord_facility ) ;
			pstmt.setString( indexid++, source_type ) ;
			pstmt.setString( indexid++, source_type ) ;
			pstmt.setString( indexid++, source_code) ;
			pstmt.setString( indexid++, patientId);
			pstmt.setString( indexid++, period_from ) ;
			pstmt.setString( indexid++, period_to ) ;
			//IN032329 Starts
			//pstmt.setString( 10, ord_facility ) ;
			//pstmt.setString( 11, practitioner_id.trim() ) ;
			/* Added By Arvind For CRF-804*/
			//pstmt.setString( 12, ord_facility.trim() ) ;
			/*End Here */
			//pstmt.setString( 13, ord_facility ) ;
			//pstmt.setString( 14, practitioner_id.trim() ) ;
			if(patientId==null)
			{
				pstmt.setString( indexid++, ord_facility.trim()) ;
				pstmt.setString( indexid++, practitioner_id.trim() ) ;
				pstmt.setString( indexid++, ord_facility.trim() ) ;
				pstmt.setString( indexid++, ord_facility.trim()) ;
				pstmt.setString( indexid++, practitioner_id.trim() ) ;
			}
			else
			{			
				pstmt.setString( indexid++, patientId) ;
			}
			//IN032329 Ends
			pstmt.setString( indexid++, practitioner_id.trim() ) ;
			pstmt.setString( indexid++, resp_id.trim() ) ;
			pstmt.setString( indexid++, functionID );
			if(filter.equals("RP")){
				pstmt.setString( indexid++, practitioner_id.trim() );
				pstmt.setString( indexid++, ord_facility.trim() );
			}else if(filter.equals("MS")){
				pstmt.setString( indexid++, practitioner_id.trim() );
			//	pstmt.setString( 19, practitioner_id.trim() );
				pstmt.setString( indexid++, ord_facility.trim() );
				pstmt.setString( indexid++, ord_facility.trim() );
				pstmt.setString( indexid++, practitioner_id.trim() );
			}

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[4];
				record[0] = resultSet.getString( "short_description" )  ;
				record[1] = resultSet.getString( "ord_cat" )  ;
				record[2] = resultSet.getString( "no_of_rec" )  ;
				record[3] = resultSet.getString( "short_description" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}

		return OrderCat;
	}


/**
	This will populate all the Status list by Category
	@return		:	ArrayList
*/

	public ArrayList getStatusByDetail(String ord_facility, String source_type, String source_code, String practitioner_id, String resp_id, String priority, String ord_cat, String order_by, String patientId, String period_from, String period_to, int start, int end,String functionID,String filter) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;
 		//int total_records			= 0;
		int indexid =1;//IN032329
		try {
			if(patientId.equals(""))	patientId	= null;//IN032329
			if(source_type.equals(" ")) source_type = null;
			if(source_code.equals(" ")) source_code = null;
			if(priority.equals(" ")) priority = null;
			if(ord_cat.equals(" ")) ord_cat = null;
			if(order_by.equals(" ")) order_by = null;
			if(period_from.equals(" ")) period_from = null;
			if(period_to.equals(" ")) period_to = null;
			if(filter.equals("AL")) filter = "";
			if ( !language_id.equals("en") )
{ 
period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMY",language_id,"en");
period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMY",language_id,"en");
}

			connection = getConnection() ;
			//IN032329 Starts
			//String sql=OrRepositoryExt.getOrKeyValue("SQL_OR_REVIEW_ORDER_SELECT_STATUS_DTL");
			String sql="SELECT   a.order_category order_category,         or_get_desc.or_order_category(a.order_category,?,'2') order_category_short_desc,a.priority priority_desc,am_get_desc.am_patient_class(a.patient_class,?,'2') patient_class_short_desc,a.patient_class patient_class,a.order_id order_id,a.patient_id patient_id, a.encounter_id encounter_id,TO_CHAR ( ORDER_DATE,'DD/MM/YYYY HH24:MI') order_date_time,or_get_order_catalog (a.order_id, a.order_type, ?) order_detail,DECODE (?,'en', patient_name,NVL (patient_name_loc_lang, patient_name)) patient_name, a.source_type source_type, a.source_code source_code, a.priority priority, a.order_type order_type,a.ord_pract_id ord_pract_id,am_get_desc.am_practitioner (a.ord_pract_id,?,'1') ordering_pract_name,sex, date_of_birth,get_age (date_of_birth) age,NVL (a.cont_order_ind, 'DO') cont_order_ind,c.ord_appr_reqd_yn ord_appr_reqd_yn, c.ord_appr_by_user_id ord_appr_by_user_id,c.ord_consent_reqd_yn ord_consent_reqd_yn, c.ord_consent_by_id ord_consent_by_id,c.ORDER_STATUS ORDER_STATUS,case when a.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(a.ordering_facility_id,a.source_code,?,'2') else op_get_desc.op_clinic(a.ordering_facility_id,a.source_code,?,'2') end  location_description,OR_PRIVILEGE_BY_ORDER( 'AUTHORIZE' ,c.order_category ,c.ORDER_TYPE_CODE, Null, ?, ?, ?, c.order_id,?)  privilege_yn,AM_GET_DESC.AM_speciality(speciality_code,?,'2') speciality_desc,speciality_code  speciality_code,c.order_set_id order_set_id FROM OR_ORDER_PEND_STATUS_LOG a, mp_patient b, or_order c WHERE a.order_id=c.order_id and a.patient_id=c.patient_id and a.PEND_STATUS_IND=?  and a.patient_id=b.patient_id and a.patient_id = NVL (?, a.patient_id) AND a.ordering_facility_id = (?)  AND NVL (a.source_type, 'XX') = NVL (DECODE ((?), 'W', 'N', (?)), NVL (a.source_type, 'XX'))  AND NVL (a.source_code, 'XX') = NVL ((?), NVL (a.source_code, 'XX')) AND NVL (a.priority, 'R') = NVL ((?), NVL (a.priority, 'R')) and a.order_category =nvl((?),a.order_category) and a.order_category in (SELECT order_category  FROM or_review_user_categories  WHERE (practitioner_id = ?  or resp_id = ?) AND decode (?,'CS',cosign_yn,'PO',AUTH_YN,'PS',SPL_APPR_YN) = 'Y')  ##FILTER1$$ and substr(a.order_id,1,2)!='CS' AND NVL (a.cont_order_ind, 'DO') IN ('CO', 'DO', 'CR', 'DR') AND  ORDER_DATE  BETWEEN TO_DATE (NVL ((?),'01/01/1000'),'dd/mm/yyyy') AND TO_DATE (NVL ((?),'31/12/9999'),'dd/mm/yyyy')+.999 ##FILTER$$ ORDER BY DECODE ((?),'P', DECODE (priority, 'S', '1','U', '2', 'R', '3'),'O', order_category),DECODE ((?),'O', DECODE (priority,'S', '1', 'U', '2','R', '3',ORDER_DATE))";
			if(patientId==null)
			{
				sql=sql.replace("##FILTER1$$"," AND (a.source_type IS NOT NULL and a.source_type!='R' OR (a.source_type, a.source_code) IN (SELECT locn_type ,locn_code  FROM ca_pract_by_locn_view WHERE practitioner_id = (?) and a.performing_facility_id=? UNION ALL SELECT 'N',locn_code  FROM ca_pract_by_locn_detail WHERE practitioner_id = (?) and locn_type='W')  OR a.source_type = 'R' OR a.source_type IS NULL )");//ML-MMOH-SCF-2965
			}
			else 
			{
				sql=sql.replace("##FILTER1$$"," and a.patient_id = ?  ");
			}
			//IN032329 Ends
			sql=sql.replace("AUTHORIZE","APPROVAL");
			if(filter.trim().equalsIgnoreCase("RP")){	
				sql=sql.replace("##FILTER$$"," AND EXISTS (SELECT 1 FROM ca_encntr_pract_reln WHERE patient_id = a.patient_id AND practitioner_id =? AND SYSDATE BETWEEN begin_date_time  AND NVL (end_date_time, SYSDATE) AND encounter_id = a.encounter_id  AND a.performing_facility_id = a.ordering_facility_id AND facility_id = a.ordering_facility_id  AND NVL (status, '01') = '01')");
			}else if(filter.trim().equalsIgnoreCase("MS")){					
				sql=sql.replace("##FILTER$$"," AND EXISTS (SELECT 1 FROM pr_encounter b WHERE b.encounter_id = a.encounter_id AND b.specialty_code IN (SELECT c.specialty_code FROM am_pract_all_splty_vw c  WHERE c.practitioner_id =? AND c.facility_id = a.ordering_facility_id))  /*AND NOT EXISTS ( SELECT 1 FROM ca_encntr_pract_reln WHERE patient_id = a.patient_id AND practitioner_id =? AND SYSDATE BETWEEN begin_date_time AND NVL (end_date_time, SYSDATE ) AND encounter_id = a.encounter_id AND facility_id = a.ordering_facility_id AND NVL (status, '01') = '01')*/ AND a.performing_facility_id =? AND a.order_date BETWEEN TRUNC (SYSDATE - 7) AND TRUNC (SYSDATE) + .9999 AND  a.order_category != 'CS' AND (a.source_type = 'R' OR (a.source_type, a.source_code)  IN (SELECT DECODE (locn_type, 'W', 'N', locn_type), locn_code FROM ca_pract_by_locn_view  WHERE facility_id = ? AND practitioner_id = ?))");
			}else if(filter.trim().equals("")){						
				sql=sql.replace("##FILTER$$","");	
			}
			
			System.out.println("sql-----555--------------"+sql);
			pstmt = connection.prepareStatement(sql) ;

			pstmt.setString(indexid++, language_id);
			pstmt.setString(indexid++, language_id);
			pstmt.setString(indexid++, language_id);
			pstmt.setString(indexid++, language_id);
			pstmt.setString(indexid++, language_id);
			pstmt.setString(indexid++, language_id);
			pstmt.setString(indexid++, language_id);
			pstmt.setString(indexid++, login_facility_id);
			pstmt.setString(indexid++, login_by_id);
			pstmt.setString(indexid++, resp_id.trim());
			pstmt.setString(indexid++, practitioner_id.trim());
			pstmt.setString(indexid++, language_id);
			pstmt.setString(indexid++, functionID);
			pstmt.setString(indexid++, patientId);
			pstmt.setString(indexid++, ord_facility ) ;
			pstmt.setString(indexid++, source_type ) ;
			pstmt.setString(indexid++, source_type ) ;
			pstmt.setString(indexid++, source_code) ;
			pstmt.setString(indexid++, priority) ;
			pstmt.setString(indexid++, ord_cat) ;
			pstmt.setString(indexid++, practitioner_id.trim() ) ;
			pstmt.setString(indexid++, resp_id.trim() ) ;
			pstmt.setString(indexid++, functionID);
			//IN032329 Starts
			//pstmt.setString(24, practitioner_id.trim() ) ;
			/* Added By Arvind For CRF-804*/
			//pstmt.setString(25, ord_facility.trim() ) ;		
			/* End Here */
			//pstmt.setString(26, practitioner_id.trim() ) ;
			if(patientId==null)
			{
				pstmt.setString(indexid++, practitioner_id.trim() ) ;
				pstmt.setString(indexid++, ord_facility.trim() ) ;
				pstmt.setString(indexid++, practitioner_id.trim() ) ;
			}
			else
			{			
				pstmt.setString( indexid++, patientId) ;
			}
			//IN032329 Ends
			pstmt.setString(indexid++, period_from);
			pstmt.setString(indexid++, period_to);
			if(filter.equalsIgnoreCase("RP")){				
				pstmt.setString(indexid++, practitioner_id.trim() );				
				pstmt.setString(indexid++, order_by) ;
				pstmt.setString(indexid++, order_by) ;								
			}else if(filter.equalsIgnoreCase("MS")){				
				pstmt.setString(indexid++, practitioner_id.trim() );
			//	pstmt.setString(30,practitioner_id.trim() );
				pstmt.setString(indexid++,ord_facility.trim());
				pstmt.setString(indexid++,ord_facility.trim());
				pstmt.setString(indexid++,practitioner_id.trim());
				pstmt.setString(indexid++,order_by) ;
				pstmt.setString(indexid++,order_by) ;				
			}else if(filter.equals("")){
					pstmt.setString(indexid++, order_by) ;
					pstmt.setString(indexid++, order_by) ;
			}				

			resultSet = pstmt.executeQuery() ;

			if(resultSet!=null) {
				/*resultSet.last(); //move to the last
				total_records = resultSet.getRow();
			}
			if(resultSet!=null && total_records > 0){
					resultSet.beforeFirst()  ;
					if(start!=0 && start!=1)
	 					resultSet.absolute(start-1); */

				if(start > 0)
					for(int i=0;(i<start-1 && resultSet.next());i++);	
				
				while ( start <= end && resultSet!=null && resultSet.next()) {
					String[] record = new String[32];
					record[0] = resultSet.getString( "order_category" )  ;
					record[1] = resultSet.getString( "order_category_short_desc" )  ;
					record[2] = resultSet.getString( "Priority_desc" )  ;
					record[3] = resultSet.getString( "patient_class_short_desc" )  ;
					record[4] = resultSet.getString( "patient_class" )  ;
					record[5] = resultSet.getString( "location_description" )  ;
					record[6] = resultSet.getString( "order_id" )  ;
					record[7] = resultSet.getString( "patient_id" )  ;
					record[8] = resultSet.getString( "encounter_id" )  ;
					record[9] = resultSet.getString( "order_date_time" )  ;
					record[10] = resultSet.getString( "order_detail" )  ;
					record[11] = resultSet.getString( "PATIENT_NAME" )  ;
					record[12] = resultSet.getString( "ORDERING_PRACT_NAME" )  ;
					record[13] = resultSet.getString( "Priority" )  ;
					record[14] = resultSet.getString( "source_type" )  ;
					record[15] = resultSet.getString( "source_code" )  ;
					record[16] = resultSet.getString( "order_type" )  ;
					record[17] = resultSet.getString( "order_status" )  ;
					record[18] = resultSet.getString( "ord_consent_reqd_yn" )  ;
					record[19] = resultSet.getString( "patient_class" )  ;
					record[20] = resultSet.getString( "source_type" )  ;
					record[21] = resultSet.getString( "date_of_birth" )  ;
					record[22] = resultSet.getString( "sex" )  ;
					record[23] = resultSet.getString( "age" )  ;
					record[24] = resultSet.getString( "cont_order_ind" )  ;
					record[25] = resultSet.getString( "ord_appr_reqd_yn" )  ;
					record[26] = resultSet.getString( "ord_appr_by_user_id" )  ;
					record[27] = resultSet.getString( "ord_consent_reqd_yn" )  ;
					record[28] = resultSet.getString( "ord_consent_by_id" )  ;	
					record[29] = resultSet.getString( "privilege_yn");
					record[30] = resultSet.getString( "order_set_id");
					// Pass the total Number of Records
					//record[30] = String.valueOf(total_records);
				
					OrderCat.add(record) ;
					start++;
				}
				if (resultSet.next())
				{
					String[] templist = (String[])OrderCat.get(0);
					templist[31] = ""+(end+7);
					OrderCat.set(0,templist);
				}

 		  }
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}

		return OrderCat;
	}

public HashMap insert(){
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		try{

			map = splApprvOrder();
		}catch(Exception e){
			System.err.println("Insertion Failed "+e);
			map.put( "message", e.getMessage() ) ;
			e.printStackTrace() ;
		}

		return map;
}

/**
	This will populate all the Status list by Category
	@return		:	ArrayList
*/

	public HashMap splApprvOrder() throws Exception {

		HashMap map = new HashMap() ;
		StringBuffer tmpBuff	= new StringBuffer();
		map.put( "result", new Boolean( false ) ) ;

		Connection connection 		= null;
		PreparedStatement pstmt1 	= null;
		PreparedStatement pstmt2 	= null;
		PreparedStatement pstmt3 	= null;
		PreparedStatement pstmt4 	= null;
		ResultSet resultSet 		= null;
		ResultSet resultSet1 		= null;

		HashMap updt_map1 = new HashMap();
		HashMap sqlMap = new HashMap() ;

		String regn_reqd_yn			= "";
		String order_status_code 	= "";
		String order_id = "";
		String cont_order_ind = "";
		String order_category = "";
		//String lab_install_yn	= "";changed on 7/18/2007 for lab_install_yn by uma 
		String rd_install_yn    = "";
		String labchk="";
		String order_set_id="";
		String order_set_bill_yn="N";

		int count = 0;
		int cnt=0;
		String[] record1 = null;

		int int_total_records = Integer.parseInt(total_records);
		try {

			//lab_install_yn = getFacilityModuleInstallYn("RL");changed on 7/18/2007 for lab_install_yn by uma
			rd_install_yn  = getFacilityModuleInstallYn("RD");



			connection = getConnection() ;
			pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_AUTHORISE_ORDER_REGN_REQD_YN_CHK") ) ;
			pstmt2 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SPECIAL_ORDER_REGN_REQD_YN_YES") ) ;
			pstmt3 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SPECIAL_ORDER_REGN_REQD_YN_NO") ) ;
			for(int i=0; i<int_total_records; i++){

				if(((String)allValues.get("chk"+i)).equalsIgnoreCase("on")){

					order_type_code = (String)allValues.get("ord_typ_code"+i);
					cont_order_ind = (String)allValues.get("cont_order_ind"+i);
					order_category = (String)allValues.get("order_category"+i);
					//cont_order_ind = "DO";
					ord_consent_reqd_yn= (String)allValues.get("ord_consent_yn"+i);
					order_id= (String)allValues.get("ord_id"+i); 
					order_set_id= (((String)allValues.get("order_set_id"+i))==null?"":((String)allValues.get("order_set_id"+i))); 
					order_set_bill_yn=(((String)getOrderSetDetails(order_set_id))==null?"":((String)getOrderSetDetails(order_set_id))); 

					//connection = getConnection() ;
					//pstmt1 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_AUTHORISE_ORDER_REGN_REQD_YN_CHK") ) ;
					pstmt1.clearParameters();
					pstmt1.setString( 1, order_type_code ) ;
					resultSet = pstmt1.executeQuery() ;


					if ( resultSet != null && resultSet.next() ) {
						regn_reqd_yn= resultSet.getString( "regn_reqd_yn" )  ;
					}

					closeResultSet( resultSet ) ;

					//=============================
					pstmt4 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_SELECT_OTH_DTLS") ) ;
				pstmt4.setString( 1, checkForNull(order_id) );
         
				resultSet1 = pstmt4.executeQuery() ;
				if( resultSet1 != null && resultSet1.next() ) { 
						 record1 = new String[1];// Only One record
						record1[0]=resultSet1.getString( "ORDER_CATALOG_CODE" )  ;
				}
						closeResultSet( resultSet1 ) ;
						closeStatement( pstmt4 ) ;

			labchk=checkForNull(getmoduleRL(record1[0],(String)allValues.get("order_category"+i),(String)allValues.get("ord_typ_code"+i),login_facility_id),"");

					if(regn_reqd_yn.equals("Y")) {
 						//if ( (lab_install_yn.equals("Y") && order_category.equals("LB") ) || (rd_install_yn.equals("Y") && order_category.equals("RD")) )    {changed on 7/18/2007 for lab_install_yn change by uma 
 						if ( (labchk.equalsIgnoreCase("IBARL") && order_category.equals("LB") ) || (rd_install_yn.equals("Y") && order_category.equals("RD")) )    {
							pstmt3.clearParameters();
							//pstmt3 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SPECIAL_ORDER_REGN_REQD_YN_NO") ) ;
							resultSet = pstmt3.executeQuery() ;
						}	else {
							pstmt2.clearParameters();
							//pstmt2 = connection.prepareStatement(   OrRepository.getOrKeyValue("SQL_OR_SPECIAL_ORDER_REGN_REQD_YN_YES") ) ;
							resultSet = pstmt2.executeQuery() ;
						}
					}else { // if(regn_reqd_yn.equals("N")){
						 pstmt3.clearParameters();
						// pstmt3 = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SPECIAL_ORDER_REGN_REQD_YN_NO") ) ;
				 		 resultSet = pstmt3.executeQuery() ;
					}

						
					//resultSet = pstmt.executeQuery() ;

					while ( resultSet != null && resultSet.next() ) {
						order_status_code= resultSet.getString( "order_status_code" )  ;
					}

					closeResultSet( resultSet ) ;


					//traceVals.append("ord_consent_reqd_yn >"+ord_consent_reqd_yn);

					//=============================
					try{
						sqlMap.put("SQL_OR_SPECIAL_ORDER_CANCEL_WITH_CONSENT_REQD",OrRepository.getOrKeyValue("SQL_OR_SPECIAL_ORDER_CANCEL_WITH_CONSENT_REQD") );
						sqlMap.put("SQL_OR_SPECIAL_ORDER_CANCEL_WITHOUT_CONSENT_REQD",OrRepository.getOrKeyValue("SQL_OR_SPECIAL_ORDER_CANCEL_WITHOUT_CONSENT_REQD") );
						sqlMap.put("SQL_OR_SPECIAL_ORDER_UPDATE_ORDER_LINE",OrRepository.getOrKeyValue("SQL_OR_SPECIAL_ORDER_UPDATE_ORDER_LINE") );

						sqlMap.put("SQL_OR_SPECIAL_ORDER_CANCEL_WITH_CONSENT_REQD_FREQ_EXPLN",OrRepository.getOrKeyValue("SQL_OR_SPECIAL_ORDER_CANCEL_WITH_CONSENT_REQD_FREQ_EXPLN") );
						sqlMap.put("SQL_OR_SPECIAL_ORDER_CANCEL_WITHOUT_CONSENT_REQD_FREQ_EXPLN",OrRepository.getOrKeyValue("SQL_OR_SPECIAL_ORDER_CANCEL_WITHOUT_CONSENT_REQD_FREQ_EXPLN") );
						sqlMap.put("SQL_OR_SPECIAL_ORDER_UPDATE_ORDER_LINE_FREQ_EXPLN",OrRepository.getOrKeyValue("SQL_OR_SPECIAL_ORDER_UPDATE_ORDER_LINE_FREQ_EXPLN") );
						sqlMap.put("SQL_OR_ORDER_COMPLETE_STATUS",OrRepository.getOrKeyValue("SQL_OR_ORDER_COMPLETE_STATUS") );
						sqlMap.put("SQL_OR_BL_WITHOUT_ORDER_CATALOG",OrRepository.getOrKeyValue("SQL_OR_BL_WITHOUT_ORDER_CATALOG") );
						sqlMap.put("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_STATUS_TYPE") );
						sqlMap.put("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_STATUS") );
						sqlMap.put("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_LINE_STATUS",OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_UPDATE_ORDER_SET_LINE_STATUS") );


					}catch(Exception e){
						System.err.println("in SpecialApprovaOrders.java,exception1="+e);
						map.put( "message", e.getMessage() ) ;
						e.printStackTrace() ;
					}



					if(ord_consent_reqd_yn.equals("Y")){
						String[] updt_data = new String[3];
						updt_map1.put("ord_consent_reqd_yn","YES");
						updt_data[0] = (String)order_status_code;
						updt_data[1] = (String)pract_id;
						updt_data[2] = (String)order_id;


 						updt_map1.put("data"+count ,updt_data);

					}else if(ord_consent_reqd_yn.equals("N")){
						String[] updt_data = new String[3];

						updt_map1.put("ord_consent_reqd_yn","NO");
						updt_data[0] = (String)order_status_code;
						updt_data[1] = (String)pract_id;
						updt_data[2] = (String)order_id;

 						updt_map1.put("data"+count ,updt_data);

					}
					count++;

					String[] updt_data1 = new String[4];

					updt_data1[0] = (String)order_status_code;
					updt_data1[1] = (String)order_id;
					updt_data1[2] = (String)order_set_id;
					updt_data1[3] = (String)order_set_bill_yn;

					updt_map1.put("lineData"+cnt,updt_data1);
					updt_map1.put("cont_order_ind"+cnt,cont_order_ind);


					cnt++;
				}//end of if condition
			}//end of for loop

			updt_map1.put("totalCount",""+count);
			updt_map1.put("lineCount",""+cnt);
			updt_map1.put( "login_by_id",login_by_id ) ;
			updt_map1.put( "login_at_ws_no",login_at_ws_no ) ;
        	updt_map1.put( "login_facility_id",login_facility_id ) ;

			//ORSplApprvOrderHome home = null ;
			//ORSplApprvOrderRemote remote = null ;


			try {
				updt_map1.put( "properties", getProperties() );

				/*InitialContext context = new InitialContext() ;
				Object object = context.lookup( OrRepository.getOrKeyValue("OR_SPECIAL_ORDER_JNDI") ) ;
				home  = (ORSplApprvOrderHome) PortableRemoteObject.narrow( object, ORSplApprvOrderHome.class ) ;
			
				remote = home.create() ;


				//ORSplApprvOrderManager remote1 = new ORSplApprvOrderManager();
				//map = remote1.insert( updt_map1, sqlMap ) ;

				map = remote.insert( updt_map1, sqlMap ) ;
*/
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepository.getOrKeyValue("OR_SPECIAL_ORDER_JNDI"), ORSplApprvOrderHome.class, getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[]	= new Object[2];
					argArray[0]		= updt_map1;
					argArray[1]		= sqlMap;
				Class [] paramArray = new Class[2];
					paramArray[0]	= updt_map1.getClass();
					paramArray[1]	= sqlMap.getClass();
				map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
						
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
				argArray	= null;
				paramArray	= null;

				if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				}

				map.put("traceVal", (String)tmpBuff.toString());
				tmpBuff.setLength(0);



			//	boolean map_result = ((Boolean)map.get( "result" )).booleanValue();

				/*if(map_result){
					traceVals.append("<><>map result is true<><>");
					traceVals.append("requset"+(request == null));
					java.util.Properties props = null;

					if(request == null)
						traceVals.append("====request isnull> after the methoid");
					else
					{
//						traceVals.append("====map> getting session ");
//						HttpSession session = request.getSession(false);
//						traceVals.append("====map> got session: " + session );
					}

					OnLinePrinting online_print = new OnLinePrinting(request,response);
					//traceVals.append("==== online_print obj ?>?>?>" + online_print);

					HashMap tmp_map = (HashMap)online_print.callOnlinePrint(allValues);
					//traceVals.append("====map> after the methoid");
					String tmp_vals = (String)tmp_map.get("traceVal");
					//traceVals.append("====tmp_vals >"+tmp_vals);

				}*/



			} catch(Exception e) {
				System.err.println( "Error Calling EJB,in SpecialApprovaOrders.java,exception2="+e);
				map.put( "message", e.getMessage() ) ;
				e.printStackTrace() ;
			} finally {
				clear();
				/*try {
					if( remote != null )
						remote.remove() ;
				} catch( Exception ee ) {
					System.err.println( ee.getMessage() ) ;
					map.put( "message", ee.getMessage() ) ;
				}*/
			}


		} catch ( Exception e )	{
			System.err.println( "Error loading values from database,in SpecialApprovaOrders.java,exception3=" +e) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt1 ) ;
			closeStatement( pstmt2 ) ;
			closeStatement( pstmt3 ) ;
			closeConnection(connection);

		}
		map.put("traceVal", traceVals.toString());
		return map;
	}



	 // To check whether the module has been installed or not, sm_modules_facility.operational_yn(Difft table referred)  if installed it return as 'Y' otherwise 'N'
		public String getFacilityModuleInstallYn(String module_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String module_install_yn	= "N";
		try{

				connection	= getConnection();
				pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CHECK_FACILITY_MODULE_INSTALL_YN"));
				pstmt.setString(1, module_id);
				pstmt.setString(2, login_facility_id); // pass the facility_id
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )    // Only one record for the module_id
				{
					while(resultSet.next())
					{
						module_install_yn = checkForNull(resultSet.getString( "operational_yn" ),"N")  ;
					}
				}	// if there is no record, then also it should return as 'N'
			}catch ( Exception e )	{
				System.err.println( "Getting Module ID from database" +e) ;
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			return module_install_yn;
	} // End of getFacilityModuleInstallYn

/**
	This will value of Special Approval required field ("Yes / No")
	@return		:	String
*/

	public String getSplApprvlYN(String practitioner_id, String resp_id, String ord_category) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String  spl_appr_yn			= "";

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_AUTHORISE_ORDER_SELECT_SPL_APPRVL_YN") ) ;
			pstmt.setString( 1, practitioner_id.trim() ) ;
			pstmt.setString( 2, resp_id) ;
			pstmt.setString( 3, ord_category) ;
			pstmt.setString( 4, "Y" ) ;

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				spl_appr_yn = resultSet.getString( "spl_appr_yn" )  ;
			}

		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}

		return spl_appr_yn;
	}



/**
	This will set all the values to set methods - persistant methods
	@param		:   recordSet-Hashtable
	@return		:	void
*/

	public void setAll( Hashtable recordSet ) {
/*thai date change*/

if ( !language_id.equals("en") )
{ 

	String period_from = (String)recordSet.get("period_from");
		String period_to = (String)recordSet.get("period_to");	
		if (period_from.equals(" ") || period_from.equals("null")) period_from="";
		if (period_to.equals(" ") || period_to.equals("null")) period_to="";
		period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMY",language_id,"en");
		period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMY",language_id,"en");
		recordSet.put("period_from",period_from);
		recordSet.put("period_to",period_to);
}
/*thai date change*/
		allValues = recordSet;
		//System.err.println("##SpecialApproveOrders.java,in setall method,allValues="+allValues);
		
		if(recordSet.containsKey("total_recs")){
			setTotalRecs((String)recordSet.get("total_recs"));
		}
		if(recordSet.containsKey("practitioner_id")){
			setPractId((String)recordSet.get("practitioner_id"));
		}
		this.mode = (String)recordSet.get( "mode" );
//		this.request = (javax.servlet.http.HttpServletRequest)recordSet.get("HttpRequest") ;
//		this.response = (javax.servlet.http.HttpServletResponse)recordSet.get("HttpResponse") ;
	}

/***
 *Method called before trasaction where validations should take place.
 * @return      HashMap containing the error information.
 * @throws Exception
*/
    public HashMap validate() throws Exception {
        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "" ) ;
		
		String order_id = "";
		String valid_operational_yn = "";

		int int_total_records = Integer.parseInt(total_records);
		
		for(int i=0; i<int_total_records; i++){
			
			if(((String)allValues.get("chk"+i)).equalsIgnoreCase("on")){
				order_id			 = (String)allValues.get("ord_id"+i);
				valid_operational_yn = getOperationalStatus("SPECIALAPPROVAL_ORDER", order_id , "");
				
			}
			if(valid_operational_yn.equals("N")){
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message", getMessage(language_id, "OR_STATUS_CHANGED","OR") ) ;
				map.put( "invalidCode", ""+i ) ;
				
				break;
			}
			
		}
        return map ;
    }
		
public String getOrderSetDetails(String order_id) throws Exception 
{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String record = "N" ;
		try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_ENTRY_GET_ORDER_SET_BILL_DETAILS") ) ;
				pstmt.setString( 1,order_id.trim());
				resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) 
			{
				record = resultSet.getString("bill_yn")  ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return record;
	}
	

}
