/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* 
-----------------------------------------------------------------------
Date       Edit History      Name        	Description
-----------------------------------------------------------------------
?             100            ?           	created
11/10/2013    IN043916		Karthi L		Alpha-CA>Summary Menu>Incorrect count is displayed in 'Pending Signatures' and 'Pending cosign' menu's
-----------------------------------------------------------------------
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


import eOR.ORCosignOrder.*;

public class ConsignOrders extends OrAdapter implements java.io.Serializable {

	protected String total_records = "";
	protected String pract_id = "";
	protected Hashtable allValues = new Hashtable();
	//protected ArrayList persistence_details		= new ArrayList();


	StringBuffer traceVals = new StringBuffer();

	public void setMode(String mode){					this.mode = mode;	}
	public void setTotalRecs(String total_records){	this.total_records = total_records;	}
	public void setPractId(String pract_id){			this.pract_id = pract_id;	}
/*	public void setDetails(ArrayList persistence_details){
			this.persistence_details=persistence_details;
	}
*/
	public String getMode(){					return mode;	}
	public String getTotalRecs(){				return total_records;	}
/*	public ArrayList getDetails(){		return persistence_details;	} */


	public void clear() {
		 	total_records		= "";
			pract_id			= "";
  	//		persistence_details = null;
		 	super.clear() ;
 	}




/**
	This will populate all the locations for the location type
	@param		:	String location_type
	@param		:	String practitioner_id
	@param		:	String facility_id
	@return		:	ArrayList
*/

	public ArrayList getLocation(String location_type, String practitioner_id, String facility_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_AUTHORISE_ORDER_SELECT_LOCN") ) ;
			
			pstmt.setString( 1,language_id);
			pstmt.setString( 2,language_id);
			pstmt.setString( 3,language_id);
			pstmt.setString( 4,language_id);
			pstmt.setString( 5,language_id);
			pstmt.setString( 6, practitioner_id.trim() ) ;
			pstmt.setString( 7, location_type.trim() ) ;
			pstmt.setString( 8, facility_id.trim() ) ;

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "locn_code" )  ;
				record[1] = resultSet.getString( "locn_short_desc" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}

		return OrderCat;
	}


/**
	This will value of Authorise required field ("Yes / No")
	@param		:	String practitioner_id
	@param		:	String resp_id
	@return		:	String
*/

	public String getAuthYN(Properties properties, String practitioner_id, String resp_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String  auth_yn= "";

		try {
			connection			= ConnectionManager.getConnection(properties) ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_CONSIGN_ORDER_SELECT_CONSIGN_YN") ) ;
			pstmt.setString( 1, practitioner_id.trim() ) ;
			pstmt.setString( 2, resp_id) ;
			pstmt.setString( 3, "Y" ) ;

			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				auth_yn = resultSet.getString( "cosign_yn" )  ;
			}

		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet(resultSet);
			closeStatement(pstmt);
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}

		return auth_yn;
	}


/**
	This will populate all the Status list by priority
	@param		:	String source_type
	@param		:	String source_code
	@param		:	String practitioner_id
	@param		:	String resp_id
	@param		:	String facility_id
	@return		:	ArrayList
*/

	public ArrayList getStatusByPriority(Properties properties, String source_type, String source_code, String practitioner_id, String resp_id, String facility_id, String patientId, String period_from  ,String period_to, String functionID) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList OrderCat = new ArrayList() ;
		String sql="";

		try {
			if(source_type.equals(" ")) source_type = null;
			if(source_code.equals(" ")) source_code = null;
			if(patientId==null || patientId.equals(" ")) patientId = "";
			
			/* Thai date validations start 14/02/2007*/
            if(period_from == null || period_from.equals("null") || period_from.equals("&nbsp;") || period_from.equals(" ")) period_from = "";
			if(period_to == null || period_to.equals("null") || period_to.equals("&nbsp;") || period_to.equals(" ")) period_to = "";

		if (!language_id.equals("en")){

			period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMY",language_id,"en");
            period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMY",language_id,"en");
		  }
			/* Thai date validations start 14/02/2007*/


			connection			= ConnectionManager.getConnection(properties) ;
			sql = OrRepositoryExt.getOrKeyValue("SQL_OR_REVIEW_ORDER_SELECT_STATUS_PRIORITY");
			sql = sql.replace("##FILTER$$"," AND (A.FORCE_COSIGN_YN='N'  OR (A.FORCE_COSIGN_YN='Y' AND  a.ORD_PRACT_ID = ?) OR (A.FORCE_COSIGN_YN='Y' AND EXISTS (SELECT 1 FROM PR_ENCOUNTER WHERE FACILITY_ID=A.ORDERING_FACILITY_ID AND ENCOUNTER_ID=A.ENCOUNTER_ID AND  ATTEND_PRACTITIONER_ID= ?)))");
			pstmt = connection.prepareStatement(sql); 

			//pstmt = connection.prepareStatement( "SELECT nvl(a.PRIORITY,'R') PRIORITY,COUNT (*) no_of_rec FROM OR_ORDER_PEND_STATUS_LOG a WHERE a.PEND_STATUS_IND='CS' and ORDERING_FACILITY_ID=? and  nvl(a.SOURCE_TYPE,'XX')=NVL(decode((?),'W','N',(?)), nvl(a.source_TYPE,'XX')) AND nvl(a.SOURCE_code,'XX') =NVL((?), nvl(a.source_CODE,'XX')) and a.patient_id = nvl(?,a.patient_id) and a.ORDER_DATE between TO_DATE(?,'dd/mm/yyyy') AND  TO_DATE(?,'dd/mm/yyyy')+.99999   and (a.source_type, a.source_code) IN (SELECT DECODE (locn_type, 'W', 'N', locn_type),  locn_code FROM ca_pract_by_locn_view WHERE facility_id = ? AND practitioner_id = ?) Group by nvl(a.PRIORITY,'R') order by decode(nvl(a.PRIORITY,'R'),'S','1','U','2','R','3')" ) ;
     		
			// Commented below lines for IN043916
			
			/* pstmt.setString( 1, functionID );
			pstmt.setString( 2, facility_id );
			pstmt.setString( 3, source_type );
			pstmt.setString( 4, source_type );
			pstmt.setString( 5, source_code );
			pstmt.setString( 6, patientId );
			pstmt.setString( 7, period_from) ;
			pstmt.setString( 8, period_to) ;
			pstmt.setString( 9, facility_id) ;
			pstmt.setString( 10, practitioner_id.trim() ) ;
			//Added by Uma on 6/4/2010 for IN016226
			pstmt.setString( 11, facility_id) ;
			pstmt.setString( 12, facility_id) ;
			pstmt.setString( 13, practitioner_id.trim() ) ;
			pstmt.setString( 14, practitioner_id.trim() ) ;
			pstmt.setString( 15, resp_id.trim() ) ;
			pstmt.setString( 16, functionID );
			pstmt.setString( 17, practitioner_id.trim() );
			pstmt.setString( 18, practitioner_id.trim() );
			*/
			// added for IN043916
			int count = 0;	
			pstmt.setString( ++count, functionID );
			pstmt.setString( ++count, facility_id );
			pstmt.setString( ++count, source_type );
			pstmt.setString( ++count, source_type );
			pstmt.setString( ++count, source_code );
			pstmt.setString( ++count, patientId );
			pstmt.setString( ++count, period_from) ;
			pstmt.setString( ++count, period_to) ;
			pstmt.setString( ++count, practitioner_id.trim() ) ;
			pstmt.setString( ++count, facility_id) ;
			pstmt.setString( ++count, practitioner_id.trim() ) ;
			pstmt.setString( ++count, practitioner_id.trim() ) ;
			pstmt.setString( ++count, resp_id.trim() ) ;
			pstmt.setString( ++count, functionID );
			pstmt.setString( ++count, practitioner_id.trim() );
			pstmt.setString( ++count, practitioner_id.trim() );
			// End IN043916
 			resultSet = pstmt.executeQuery() ;
  			while ( resultSet != null && resultSet.next() ) 
			{

				String[] record = new String[4];
 				record[0] = resultSet.getString( "PRIORITY" )  ;
				record[1] = resultSet.getString( "no_of_rec" )  ;

				OrderCat.add(record) ;
			}

		} 
		catch ( Exception e )	
		{

			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			if(connection!=null) ConnectionManager.returnConnection(connection, properties);
		}

		return OrderCat;
	}


/**
	This will populate all the Status list by Category
	@param		:	String ord_facility
	@param		:	String source_type
	@param		:	String source_code
	@param		:	String practitioner_id
	@param		:	String resp_id
	@return		:	ArrayList
*/

	public ArrayList getStatusByCategory(Properties properties, String ord_facility, String source_type, String source_code, String practitioner_id, String resp_id, String patientId, String period_from, String period_to, String functionID) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;
		String sql="";
		try {
			if(source_type.equals(" ")) source_type = null;
			if(source_code.equals(" ")) source_code = null;
			if(patientId==null || patientId.equals(" ")) patientId = "";
			
			/* Thai date validations start 14/02/2007*/
            if(period_from == null || period_from.equals("null") || period_from.equals("&nbsp;") || period_from.equals(" ")) period_from = "";
			if(period_to == null || period_to.equals("null") || period_to.equals("&nbsp;") || period_to.equals(" ")) period_to = "";

		  if (!language_id.equals("en")){

			period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMY",language_id,"en");
		    period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMY",language_id,"en");
		     }
			/* Thai date validations end 14/02/2007*/

			connection			= ConnectionManager.getConnection(properties) ;
			sql=OrRepositoryExt.getOrKeyValue("SQL_OR_REVIEW_ORDER_SELECT_STATUS_CATEGORY");
			sql=sql.replace("##FILTER$$"," AND (A.FORCE_COSIGN_YN='N'  OR (A.FORCE_COSIGN_YN='Y' AND  a.ORD_PRACT_ID = ?) OR (A.FORCE_COSIGN_YN='Y' AND EXISTS (SELECT 1 FROM PR_ENCOUNTER WHERE FACILITY_ID=A.ORDERING_FACILITY_ID AND ENCOUNTER_ID=A.ENCOUNTER_ID AND  ATTEND_PRACTITIONER_ID= ?)))");
			pstmt = connection.prepareStatement(sql); 
			//pstmt = connection.prepareStatement( "SELECT OR_GET_DESC.OR_ORDER_CATEGORY (a.order_category,?,'2')   short_description,COUNT (*) no_of_rec, a.order_category ord_cat FROM OR_ORDER_PEND_STATUS_LOG a WHERE a.PEND_STATUS_IND='CS' and ORDERING_FACILITY_ID=? and nvl(a.SOURCE_TYPE,'XX')=NVL(decode((?),'W','N',(?)),nvl(a.source_TYPE,'XX')) AND nvl(a.SOURCE_code,'XX') =NVL((?),nvl(a.source_CODE,'XX')) AND  a.patient_id = nvl(?, a.patient_id) and  a.ORDER_DATE between TO_DATE(?,'dd/mm/yyyy') AND  TO_DATE(?,'dd/mm/yyyy')+0.99999 and (a.source_type, a.source_code) IN (SELECT DECODE (locn_type, 'W', 'N', locn_type),  locn_code FROM ca_pract_by_locn_view WHERE facility_id = ? AND practitioner_id = ?) Group by  a.order_category Order by 1" ) ;

            /*pstmt.setString( 1, language_id);
			pstmt.setString( 2, language_id);
			pstmt.setString( 3, patientId);
			pstmt.setString( 4, ord_facility ) ;
			pstmt.setString( 5, source_type ) ;
			pstmt.setString( 6, source_type ) ;
			pstmt.setString( 7, source_code) ;
			pstmt.setString( 8, practitioner_id.trim() ) ;
			pstmt.setString( 9, resp_id.trim() );
			pstmt.setString( 10, practitioner_id.trim() ) ;
			pstmt.setString( 11, period_from) ;
			pstmt.setString( 12, period_to ) ;
            pstmt.setString( 13, language_id);*/
			
			// commented below lines for IN043916 - Start
			/*
			
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, functionID );
			pstmt.setString( 3, ord_facility ) ;
			pstmt.setString( 4, source_type ) ;
			pstmt.setString( 5, source_type ) ;
			pstmt.setString( 6, source_code) ;
			pstmt.setString( 7, patientId);
			pstmt.setString( 8, period_from ) ;
			pstmt.setString( 9, period_to ) ;
			pstmt.setString( 10, ord_facility ) ;
			pstmt.setString( 11, practitioner_id.trim() ) ;
			//Added by Uma on 6/4/2010 for IN016226
			pstmt.setString( 12, ord_facility ) ;
			pstmt.setString( 13, ord_facility ) ;
			pstmt.setString( 14, practitioner_id.trim() ) ;
			pstmt.setString( 15, practitioner_id.trim() ) ;
			pstmt.setString( 16, resp_id.trim() ) ;
			pstmt.setString( 17, functionID );
			pstmt.setString( 18, practitioner_id.trim() );
			pstmt.setString( 19, practitioner_id.trim() );
			*/
			
			// added for IN043916
			int count = 0;	
			pstmt.setString( ++count, language_id);
			pstmt.setString(  ++count, functionID );
			pstmt.setString(  ++count, ord_facility ) ;
			pstmt.setString(  ++count, source_type ) ;
			pstmt.setString(  ++count, source_type ) ;
			pstmt.setString(  ++count, source_code) ;
			pstmt.setString(  ++count, patientId);
			pstmt.setString(  ++count, period_from ) ;
			pstmt.setString(  ++count, period_to ) ;
			pstmt.setString(  ++count, ord_facility ) ;
			pstmt.setString(  ++count, practitioner_id.trim() ) ;
			pstmt.setString(  ++count, ord_facility ) ;
			pstmt.setString(  ++count, practitioner_id.trim() ) ;
			pstmt.setString(  ++count, practitioner_id.trim() ) ;
			pstmt.setString(  ++count, resp_id.trim() ) ;
			pstmt.setString(  ++count, functionID );
			pstmt.setString(  ++count, practitioner_id.trim() );
			pstmt.setString(  ++count, practitioner_id.trim() );
			// End IN043916
 
			resultSet = pstmt.executeQuery() ;
 			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[4];		
				record[0] = resultSet.getString( "short_description" )  ;
				record[1] = resultSet.getString( "no_of_rec" )  ;
				record[2] = resultSet.getString( "ord_cat" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{

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
	@param		:	String ord_facility
	@param		:	String source_type
	@param		:	String source_code
	@param		:	String practitioner_id
	@param		:	String resp_id
	@param		:	String priority
	@param		:	String ord_cat
	@param		:	String order_by

	@return		:	ArrayList
*/

	public ArrayList getStatusByDetail(String ord_facility, String source_type, String source_code, String practitioner_id, String resp_id, String priority, String ord_cat, String order_by, String patientId, String period_from, String period_to, int start, int end, String functionID) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;
		String sql="";
 		//int total_records			= 0;

		try {
			if(source_type.equals(" ")) source_type = null;
			if(source_code.equals(" ")) source_code = null;
			if(priority.equals(" ")) priority = null;
			if(ord_cat.equals(" ")) ord_cat = null;
			if(order_by.equals(" ")) order_by = null;
			if(patientId == null || patientId.equals("")) patientId = "";

	/* Thai date validations start 14/02/2007 */
			if(period_from == null || period_from.equals("null") || period_from.equals("&nbsp;") || period_from.equals(" ")) period_from = "";
			if(period_to == null || period_to.equals("null") || period_to.equals("&nbsp;") || period_to.equals(" ")) period_to = "";
		
		if (!language_id.equals("en")){
	         period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMY",language_id,"en");
		     period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMY",language_id,"en");
		  }
      /* Thai date validations end 14/02/2007 */
			connection = getConnection() ;
			sql=OrRepositoryExt.getOrKeyValue("SQL_OR_REVIEW_ORDER_SELECT_STATUS_DTL");
			sql=sql.replace("##FILTER$$"," AND (A.FORCE_COSIGN_YN='N'  OR (A.FORCE_COSIGN_YN='Y' AND  a.ORD_PRACT_ID = ?) OR (A.FORCE_COSIGN_YN='Y' AND EXISTS (SELECT 1 FROM PR_ENCOUNTER WHERE FACILITY_ID=A.ORDERING_FACILITY_ID AND ENCOUNTER_ID=A.ENCOUNTER_ID AND  ATTEND_PRACTITIONER_ID= ?)))");
			pstmt = connection.prepareStatement(sql);

			//pstmt = connection.prepareStatement( "SELECT  order_category, OR_GET_DESC.OR_ORDER_CATEGORY (order_category,?,'2')  order_category_short_desc,  Priority Priority_desc, AM_GET_DESC.AM_PATIENT_CLASS(patient_class, ?,'2') patient_class_short_desc,patient_class, LOCATION_TYPE||'/'||LOCN_SHORT_DESC location_details ,ORDER_ID,patient_id, encounter_id, TO_CHAR(ORD_DATE_TIME,'DD/MM/YYYY HH24:MI') order_date_time, OR_GET_ORDER_CATALOG(order_id,order_type_code,?)  order_detail, decode(?,'en',PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG,PATIENT_NAME)) PATIENT_NAME,LOCN_SHORT_DESC,SOURCE_TYPE,SOURCE_CODE,Priority,ORDER_TYPE_CODE , ORD_PRACT_ID, AM_GET_DESC.AM_PRACTITIONER(ORD_PRACT_ID,?,'1') ORDERING_PRACT_NAME, ORDER_STATUS, OR_GET_DESC.OR_ORDER_STATUS_CODE(order_status,?,'2')   order_status_short_desc, ord_consent_reqd_yn, location_type, sex, date_of_birth,GET_AGE(DATE_OF_BIRTH) age  ,nvl(cont_ordeR_ind,'DO') cont_order_ind from or_order_vw a  WHERE  patient_id = nvl(?, patient_id) and ordering_facility_id = (?) AND ORD_COSIGN_REQD_YN = 'Y' and order_status not in  (select order_status_code from or_order_Status_code where order_Status_type in ('99','96','93') )  and nvl(SOURCE_TYPE,'XX')=NVL(decode((?),'W','N',(?)), nvl(source_TYPE,'XX')) AND nvl(SOURCE_code,'XX') =NVL((?), nvl(source_CODE,'XX')) and nvl(Priority,'R') =nvl((?),nvl(Priority,'R'))   and order_category =nvl((?),order_category)  AND exists (select order_category from or_review_user_categories  where (practitioner_id =?  or REsp_id = ?)  and ordeR_Category = a.order_category and COSIGN_YN = 'Y')  And (source_type is not null and (source_type,source_CODE) IN (SELECT DECODE(LOCN_TYPE,'W','N',LOCN_TYPE),locn_code FROM ca_pract_by_locn_view WHERE practitioner_id=(?)) or source_type is null )   and ORD_COSIGN_BY_PRACT_ID  is null and    ORD_COSIGN_DATE_TIME is null  and  nvl(cont_order_ind,'DO') in ('CO','DO','CR','DR')  and trunc(ORD_DATE_TIME)  between to_date(nvl((?),'01/01/1000'),'dd/mm/yyyy') 			 and  to_date(nvl((?),'31/12/9999'),'dd/mm/yyyy')  order by  decode((?),'P',decode(priority,'S','1','U','2','R','3'),'O',Order_category),DECODE((?),'O',decode(priority,'S','1','U','2','R','3',ord_date_Time))" ) ;
			pstmt.setString(1 , language_id);
			pstmt.setString(2 , language_id);
			pstmt.setString(3 , language_id);
			pstmt.setString(4 , language_id);
			pstmt.setString(5 , language_id);
			pstmt.setString(6 , language_id);
			pstmt.setString(7 , language_id);
			pstmt.setString(8 , login_facility_id);
			pstmt.setString(9 , login_by_id);
			pstmt.setString(10 , resp_id.trim());
			pstmt.setString(11 , practitioner_id.trim());
			pstmt.setString(12 , language_id);
			pstmt.setString(13 , functionID);
			pstmt.setString(14 , patientId);
			pstmt.setString(15 , ord_facility ) ;
			pstmt.setString(16 , source_type ) ;
			pstmt.setString(17 , source_type ) ;
			pstmt.setString(18 , source_code) ;
			pstmt.setString(19 , priority) ;
			pstmt.setString(20 , ord_cat) ;
			pstmt.setString(21 , practitioner_id.trim() ) ;
			pstmt.setString(22 , resp_id.trim() ) ;
			pstmt.setString(23 , functionID);
			pstmt.setString(24 , practitioner_id.trim() ) ;
			//Added by Uma on 6/4/2010 for IN016226
			pstmt.setString(25 , ord_facility.trim());
			pstmt.setString(26 , practitioner_id.trim() ) ;
			pstmt.setString(27 , period_from);
			pstmt.setString(28 , period_to);
			pstmt.setString(29 , practitioner_id.trim() ) ;
			pstmt.setString(30 , practitioner_id.trim() ) ;
			pstmt.setString(31 , order_by) ;
			pstmt.setString(32 , order_by) ;

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

						String[] record = new String[26];
						record[0] = checkForNull(resultSet.getString( "order_category" ),"");
						record[1] = checkForNull(resultSet.getString( "order_category_short_desc" ),"");
						record[2] = checkForNull(resultSet.getString( "Priority_desc" ),"");
						record[3] = checkForNull(resultSet.getString( "patient_class_short_desc" ),"");
						record[4] = checkForNull(resultSet.getString( "patient_class" ),"");
						record[5] = checkForNull(resultSet.getString( "location_description" ),"")  ;
						record[6] = checkForNull(resultSet.getString( "order_id" ),"")  ;
						record[7] = checkForNull(resultSet.getString( "patient_id" ),"")  ;
						record[8] = checkForNull(resultSet.getString( "encounter_id" ),"")  ;
						record[9] = checkForNull(resultSet.getString( "order_date_time" ),"")  ;
						record[10] = checkForNull(resultSet.getString( "order_detail" ),"")  ;
						record[11] = checkForNull(resultSet.getString( "PATIENT_NAME" ),"")  ;
						record[12] = checkForNull(resultSet.getString( "ORDERING_PRACT_NAME" ),"")  ;
						record[13] = checkForNull(resultSet.getString( "Priority" ),"")  ;
						record[14] = checkForNull(resultSet.getString( "source_type" ),"")  ;
						record[15] = checkForNull(resultSet.getString( "source_code" ),"")  ;
						record[16] = checkForNull(resultSet.getString( "order_type" ),"")  ;
						record[17] = resultSet.getString( "order_status" )  ;
						record[18] = resultSet.getString( "ord_consent_reqd_yn" )  ;
						record[19] = checkForNull(resultSet.getString( "patient_class" ),"")  ;
						record[20] = checkForNull(resultSet.getString( "source_type" ),"")  ;
						record[21] = checkForNull(resultSet.getString( "date_of_birth" ),"")  ;
						record[22] = checkForNull(resultSet.getString( "sex" ),"")  ;
						record[23] = checkForNull(resultSet.getString( "age" ),"")  ;
						record[24] = checkForNull(resultSet.getString( "cont_order_ind" ),"")  ;

						// Pass the total Number of Records
						//record[25] = String.valueOf(total_records);
 
						OrderCat.add(record) ;
						start++;
				}
				if (resultSet.next())
				{
					String[] templist = (String[])OrderCat.get(0);
					templist[25] = ""+(end+7);
					OrderCat.set(0,templist);
				}
 		  }	
		} catch ( Exception e )	{

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
			map = cosignOrder();
		}catch(Exception e){
			e.printStackTrace();
		}

		return map;
}

/**
	This will populate all the Status list by Category
	@return		:	ArrayList
*/

	public HashMap cosignOrder() throws Exception {
		HashMap map = new HashMap() ;

		HashMap updt_map1 = new HashMap();
		HashMap sqlMap = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;


		String order_id = "";
		String cont_order_ind = "";
		//int result = 0;
		//int count = 0;
		int cnt=0;

		traceVals.append("total recs rt :  >"+total_records);
		int int_total_records = Integer.parseInt(total_records);
		try {
			for(int i=0; i<int_total_records; i++){
				if(((String)allValues.get("chk"+i)).equalsIgnoreCase("on")){
					order_id= (String)allValues.get("ord_id"+i);
					cont_order_ind= (String)allValues.get("cont_order_ind"+i);

					try{
						sqlMap.put("SQL_OR_CONSIGN_ORDER_UPDATE_ORDER",OrRepository.getOrKeyValue("SQL_OR_CONSIGN_ORDER_UPDATE_ORDER") );
						sqlMap.put("SQL_OR_CONSIGN_ORDER_UPDATE_ORDER_FREQ_EXPLN",OrRepository.getOrKeyValue("SQL_OR_CONSIGN_ORDER_UPDATE_ORDER_FREQ_EXPLN") );
					}catch(Exception e){
						e.printStackTrace();
					}

					String[] updt_data1 = new String[2];
					updt_data1[0] = (String)order_id;

					updt_map1.put("consign_data"+cnt,updt_data1);
					updt_map1.put("cont_order_ind"+cnt,cont_order_ind);
					cnt++;
				}//end of if condition
			}//end of for loop

			updt_map1.put("pract_id",pract_id);
			updt_map1.put("totalCount",""+cnt);
			updt_map1.put( "login_by_id",login_by_id ) ;
			updt_map1.put( "login_at_ws_no",login_at_ws_no ) ;
        	updt_map1.put( "login_facility_id",login_facility_id ) ;

			//ORConsignOrderHome home = null ;
			//ORConsignOrderRemote remote = null ;

			try {
				
				updt_map1.put( "properties", getProperties() );
				/*InitialContext context = new InitialContext() ;
				Object object = context.lookup( OrRepository.getOrKeyValue("OR_CONSIGN_ORDER_JNDI") ) ;
				home  = (ORConsignOrderHome) PortableRemoteObject.narrow( object, ORConsignOrderHome.class ) ;
				
				remote = home.create() ;
				//ORConsignOrderManager remote1 = new ORConsignOrderManager();
				map = remote.insert( updt_map1, sqlMap ) ;*/
				
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome( OrRepository.getOrKeyValue("OR_CONSIGN_ORDER_JNDI"), ORConsignOrderHome.class, getLocalEJB());
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
				
				//traceVals.append("map value   >"+map);

				
			if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				}else{
					//map.put( "message", ((String) map.get("msgid"))) ;
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "COMMON")) ;
		
				}

		map.put( "traceVal", traceVals.toString() ) ;




			} catch(Exception e) {
				map.put( "message", e.getMessage() ) ;
				e.printStackTrace() ;
			} finally {
				clear();
				/*try {
					if( remote != null )
						remote.remove() ;
				} catch( Exception ee ) {

					map.put( "message", ee.getMessage() ) ;
				}*/
			}


		} catch ( Exception e )	{

			e.printStackTrace() ;
			throw e ;
		}  
		map.put("traceVal", traceVals.toString());
		return map;
	}

/**
	This will set all the values to set methods - persistant methods
	@param		:   recordSet-Hashtable
	@return		:	void
*/

	public void setAll( Hashtable recordSet ) {
		allValues = recordSet;
   /* Thai date validations start 14/02/2007*/
		String period_from = (String)allValues.get("period_from");
		String period_to = (String)allValues.get("period_to");
		
		if(period_from == null || period_from.equals("null") || period_from.equals("&nbsp;") || period_from.equals(" ")) period_from = "";
		if(period_to == null || period_to.equals("null") || period_to.equals("&nbsp;") || period_to.equals(" ")) period_to = "";

		if (!language_id.equals("en")){

		period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMY",language_id,"en");
		period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMY",language_id,"en");
		}
		allValues.put("period_from",period_from);
		allValues.put("period_to",period_to);
/* Thai date validations start 14/02/2007*/
		if(recordSet.containsKey("total_recs")){
			setTotalRecs((String)recordSet.get("total_recs"));
		}
		if(recordSet.containsKey("practitioner_id")){
			setPractId((String)recordSet.get("practitioner_id"));
		}
		this.mode = (String)recordSet.get( "mode" );
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
				valid_operational_yn = getOperationalStatus("COSIGN_ORDER", order_id , "");
				
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
}
