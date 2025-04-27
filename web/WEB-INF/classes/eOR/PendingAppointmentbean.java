/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
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

public class PendingAppointmentbean extends OrAdapter implements java.io.Serializable {

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

/**
	This will populate all the Status list by priority
	@param		:	String source_type
	@param		:	String source_code
	@param		:	String practitioner_id
	@param		:	String resp_id
	@param		:	String facility_id
	@return		:	ArrayList
*/

	
	public ArrayList getStatusByPriority(Properties properties, String source_type, String source_code, String practitioner_id, String resp_id, String facility_id, String patientId, String period_from  ,String period_to,String filter) throws Exception {
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

			if(filter == null || filter.equals("null") || filter.equals("&nbsp;") || filter.equals(" "))
				filter = "";
			
		if (!language_id.equals("en")){

			period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMY",language_id,"en");
            period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMY",language_id,"en");
		  }
			/* Thai date validations start 14/02/2007*/  	 


			connection			= ConnectionManager.getConnection(properties) ;
			/* Added By : Arvind
							  Date : 09/01/2010
							  CRF  : PMG20089-CRF-829
							  Discription : Below code added to write query for Priority based on selected filter . 
						*/

			sql=OrRepositoryExt.getOrKeyValue("SQL_OR_APPT_ORDER_SELECT_STATUS_PRIORITY") ;
			if (filter.equals("MP"))
			{				
				sql=sql.replace("$$Filter##","  AND EXISTS (SELECT 1 FROM PR_ENCOUNTER WHERE FACILITY_ID=A.ORDERING_FACILITY_ID AND ENCOUNTER_ID=A.ENCOUNTER_ID AND  ATTEND_PRACTITIONER_ID=?) ");				
			}
			else if(filter.equals("RP"))
			{				
				sql=sql.replace("$$Filter##","  AND EXISTS (SELECT 1 from ca_encntr_pract_reln  where patient_id =A.PATIENT_ID and PRACTITIONER_ID =? and sysdate between begin_date_time and nvl(end_date_time,sysdate) AND ENCOUNTER_ID = A.ENCOUNTER_ID AND FACILITY_ID=A.ORDERING_FACILITY_ID AND NVL(STATUS,'01')='01' )");
			}
			else if (filter.equals("OP"))
			{
				 sql=sql.replace("$$Filter##"," AND a.ord_pract_id =? ");
			}
			else
			{				
				sql=sql.replace("$$Filter##","");
			}		
			
			/* End Here */


			pstmt = connection.prepareStatement(sql.toString()); //OrRepositoryExt.getOrKeyValue("SQL_OR_APPT_ORDER_SELECT_STATUS_PRIORITY") ) ;
         	pstmt.setString( 1, patientId );
			pstmt.setString( 2, facility_id ) ;
			pstmt.setString( 3, source_type ) ;
			pstmt.setString( 4, source_type ) ;
			pstmt.setString( 5, source_code) ;
			pstmt.setString( 6, practitioner_id.trim() ) ;
			pstmt.setString( 7, period_from) ;
			pstmt.setString( 8, period_to ) ;

			/* Added By : Arvind
							  Date : 09/01/2010
							  CRF  : PMG20089-CRF-829
							  Discription : Below code added to pass parameter based on filter .
						*/

			if (filter.equals("MP"))
			{
				pstmt.setString( 9, practitioner_id.trim() ) ;
			}
			else if (filter.equals("OP"))
			{
				pstmt.setString( 9, practitioner_id.trim() ) ;
			}
			else if (filter.equals("RP"))
			{
				pstmt.setString( 9, practitioner_id.trim() ) ;
			}	
			
			/* End Here */
			
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


/**
	This will populate all the Status list by Category
	@param		:	String ord_facility
	@param		:	String source_type
	@param		:	String source_code
	@param		:	String practitioner_id
	@param		:	String resp_id
	@return		:	ArrayList
*/

	public ArrayList getStatusByCategory(Properties properties, String ord_facility, String source_type, String source_code, String practitioner_id, String resp_id, String patientId, String period_from, String period_to,String filter) throws Exception {
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
			 if(filter == null || filter.equals("null") || filter.equals("&nbsp;") || filter.equals(" "))
				filter = "";
			/* Thai date validations end 14/02/2007*/

			connection			= ConnectionManager.getConnection(properties) ;

			/* Added By : Arvind
							  Date : 09/01/2010
							  CRF  : PMG20089-CRF-829
							  Discription : Below code added to write query for catagory based on selected filter . 
						*/

			sql=OrRepositoryExt.getOrKeyValue("SQL_OR_APPT_ORDER_SELECT_STATUS_CATEGORY") ;
			if (filter.equals("MP"))
			{				
				sql=sql.replace("$$Filter##","  AND EXISTS (SELECT 1 FROM PR_ENCOUNTER WHERE FACILITY_ID=A.ORDERING_FACILITY_ID AND ENCOUNTER_ID=A.ENCOUNTER_ID AND  ATTEND_PRACTITIONER_ID=?) ");				
			}
			else if(filter.equals("RP"))
			{				
				sql=sql.replace("$$Filter##","  AND EXISTS (SELECT 1 from ca_encntr_pract_reln  where patient_id =A.PATIENT_ID and PRACTITIONER_ID =? and sysdate between begin_date_time and nvl(end_date_time,sysdate) AND ENCOUNTER_ID = A.ENCOUNTER_ID AND FACILITY_ID=A.ORDERING_FACILITY_ID AND NVL(STATUS,'01')='01' )");
			}
			else if (filter.equals("OP"))
			{
				 sql=sql.replace("$$Filter##"," AND a.ord_pract_id =? ");
			}
			else
			{				
				sql=sql.replace("$$Filter##","");
			}
			/* End Here */
			pstmt = connection.prepareStatement(sql.toString()); //OrRepositoryExt.getOrKeyValue("SQL_OR_APPT_ORDER_SELECT_STATUS_CATEGORY") ) ;

            pstmt.setString( 1, language_id);
			pstmt.setString( 2, language_id);
			pstmt.setString( 3, patientId);
			pstmt.setString( 4, ord_facility ) ;
			pstmt.setString( 5, source_type ) ;
			pstmt.setString( 6, source_type ) ;
			pstmt.setString( 7, source_code) ;
			pstmt.setString( 8, practitioner_id.trim() ) ;
			pstmt.setString( 9, period_from) ;
			pstmt.setString( 10, period_to ) ; 			


			/* Added By : Arvind
							  Date : 09/01/2010
							  CRF  : PMG20089-CRF-829
							  Discription : Below code added to pass parameter based on filter .
						*/


			if (filter.equals("MP"))
			{				
				pstmt.setString( 11, practitioner_id.trim() ) ;				
			}
			else if (filter.equals("OP"))
			{
				pstmt.setString( 11, practitioner_id.trim() ) ;
			}
			else if (filter.equals("RP"))
			{
				pstmt.setString( 11, practitioner_id.trim() ) ;
			}	

			if (filter.equals("AL") ||filter.equals(""))
			{
				pstmt.setString( 11, language_id);	
			}
			else
			{
					pstmt.setString( 12, language_id);	
			}

			
			/* End Here */

			resultSet = pstmt.executeQuery() ;
 			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[4];		
				record[0] = resultSet.getString( "short_desc" )  ;
				record[1] = resultSet.getString( "order_category" )  ;
				record[2] = resultSet.getString( "num" )  ;
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

	public ArrayList getStatusByDetail(String ord_facility, String source_type, String source_code, String practitioner_id, String resp_id, String priority, String ord_cat, String order_by, String patientId, String period_from, String period_to, int start, int end,String filter) throws Exception {
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

			if(filter == null || filter.equals("null") || filter.equals("&nbsp;") || filter.equals(" "))
				filter = "";

	/* Thai date validations start 14/02/2007 */
			if(period_from == null || period_from.equals("null") || period_from.equals("&nbsp;") || period_from.equals(" ")) period_from = "";
			if(period_to == null || period_to.equals("null") || period_to.equals("&nbsp;") || period_to.equals(" ")) period_to = "";
		
		if (!language_id.equals("en")){
	         period_from = com.ehis.util.DateUtils.convertDate(period_from,"DMY",language_id,"en");
		     period_to = com.ehis.util.DateUtils.convertDate(period_to,"DMY",language_id,"en");
		  }
      /* Thai date validations end 14/02/2007 */
			connection = getConnection() ;

			/* Added By : Arvind
							  Date : 09/01/2010
							  CRF  : PMG20089-CRF-829
							  Discription : Below code added to write query for Details  based on selected filter . 
						*/

			sql=OrRepositoryExt.getOrKeyValue("SQL_OR_APPT_ORDER_SELECT_STATUS_DTL") ;
			if (filter.equals("MP"))
			{				
				sql=sql.replace("$$Filter##","  AND EXISTS (SELECT 1 FROM PR_ENCOUNTER WHERE FACILITY_ID=A.ORDERING_FACILITY_ID AND ENCOUNTER_ID=A.ENCOUNTER_ID AND  ATTEND_PRACTITIONER_ID=?) ");				
			}
			else if(filter.equals("RP"))
			{				
				sql=sql.replace("$$Filter##","  AND EXISTS (SELECT 1 from ca_encntr_pract_reln  where patient_id =A.PATIENT_ID and PRACTITIONER_ID =? and sysdate between begin_date_time and nvl(end_date_time,sysdate) AND ENCOUNTER_ID = A.ENCOUNTER_ID AND FACILITY_ID=A.ORDERING_FACILITY_ID AND NVL(STATUS,'01')='01' )");
			}
			else if (filter.equals("OP"))
			{
				 sql=sql.replace("$$Filter##"," AND a.ord_pract_id =? ");
			}
			else
			{				
				sql=sql.replace("$$Filter##","");
			}			
			pstmt = connection.prepareStatement(sql.toString());	
			
			/* End HEre */

			pstmt.setString(1, language_id);
			pstmt.setString(2, language_id);
			pstmt.setString(3, language_id);
			pstmt.setString(4, language_id);
			pstmt.setString(5, language_id);
			pstmt.setString(6, language_id);
			pstmt.setString(7, language_id);
			pstmt.setString(8, patientId);
			pstmt.setString(9, ord_facility ) ;
			pstmt.setString(10, source_type ) ;
			pstmt.setString(11, source_type ) ;
			pstmt.setString(12, source_code) ;
			pstmt.setString(13, priority) ;
			pstmt.setString(14, ord_cat) ;
			pstmt.setString(15, practitioner_id.trim() ) ;
			pstmt.setString(16, period_from);
			pstmt.setString(17, period_to);

			/* Added By : Arvind
							  Date : 09/01/2010
							  CRF  : PMG20089-CRF-829
							  Discription : Below code added to pass parameter based on filter . 
						*/

			if (filter.equals("MP"))
			{				
				pstmt.setString( 18, practitioner_id.trim() ) ;				
			}
			else if (filter.equals("OP"))
			{
				pstmt.setString( 18, practitioner_id.trim() ) ;
			}
			else if (filter.equals("RP"))
			{
				pstmt.setString( 18, practitioner_id.trim() ) ;
			}	

			if (filter.equals("AL") || filter.equals(""))
			{
				pstmt.setString(18, order_by) ;
				pstmt.setString(19, order_by) ;
			}
			else
			{
					pstmt.setString(19, order_by) ;
					pstmt.setString(20, order_by) ;
			}			
			

			/* End Here */
			resultSet = pstmt.executeQuery() ;

			if(resultSet!=null) {
				
				if(start > 0)
					for(int i=0;(i<start-1 && resultSet.next());i++);
				
				while ( start <= end && resultSet!=null && resultSet.next()) {

						String[] record = new String[24];
						record[0] = resultSet.getString( "ORDER_ID" )  ;
						record[1] = resultSet.getString( "ORDER_LINE_NUM" )  ;
						record[2] = resultSet.getString( "order_date_time" )  ;
						record[3] = resultSet.getString( "order_detail" )  ;
						record[4] = resultSet.getString( "order_category" )  ;
						record[5] = resultSet.getString( "ORDER_TYPE_CODE" )  ;
						record[6] = resultSet.getString( "order_category_short_desc" )  ;
						record[7] = resultSet.getString( "Priority" )  ;
						record[8] = resultSet.getString( "Priority_desc" )  ;
						record[9] = resultSet.getString( "ORD_PRACT_ID" )  ;
						record[10] = resultSet.getString( "ORDERING_PRACT_NAME" )  ;
						record[11] = resultSet.getString( "cont_order_ind" )  ;
						record[12] = resultSet.getString( "patient_class" )  ;
						record[13] = resultSet.getString( "patient_class_short_desc" )  ;
						record[14] = resultSet.getString( "SOURCE_TYPE" )  ;
						record[15] = resultSet.getString( "SOURCE_CODE" )  ;
						record[16] = resultSet.getString( "LOCN_DESC" )  ;
						record[17] = resultSet.getString( "patient_id" )  ;
						record[18] = resultSet.getString( "encounter_id" )  ;
						record[19] = resultSet.getString( "patient_name" )  ;
						record[20] = resultSet.getString( "sex" )  ;
						record[21] = resultSet.getString( "date_of_birth" )  ;
						record[22] = resultSet.getString( "age" )  ;

 
						OrderCat.add(record) ;
						start++;
				}
				if (resultSet.next())
				{
					String[] templist = (String[])OrderCat.get(0);
					templist[23] = ""+(end+7);
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


	public String getCatalogCode( String order_id, String order_line_num) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String record = "";

		try {
			

			connection			= getConnection() ;
			pstmt = connection.prepareStatement( OrRepositoryExt.getOrKeyValue("SQL_OR_APPT_ORDER_SELECT_CATALOG") ) ;
         	pstmt.setString( 1, order_id );
			pstmt.setString( 2, order_line_num ) ;
			resultSet = pstmt.executeQuery() ;
  			while ( resultSet != null && resultSet.next() ) {

				
 				record = resultSet.getString( "order_catalog_code" )  ;
				//record[1] = resultSet.getString( "totalCount" )  ;
				//OrderCat.add(record) ;
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

		return record;
	}



}


