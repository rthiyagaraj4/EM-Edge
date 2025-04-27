/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 //saved on 29/10/2005 
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		   Edit History	       Name		         Description
-------------------------------------------------------------------------------------------------------------------------------------------
?				100					?                 created
02/07/2021		TFS-20824         Prabha			ML-MMOH-SCF-1853
--------------------------------------------------------------------------------------------------------------------------------------------
*/
package ePH ;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
import ePH.Common.* ;
import eCommon.Common.* ;


public class QueryPatientsBySpecificDrugBean extends PhAdapter implements Serializable {

	String debug="";
    public QueryPatientsBySpecificDrugBean() {
        try {
            doCommon();
        }
        catch(Exception e) {
			e.printStackTrace();
		}
    }

	public void clear() {
		super.clear() ;
	}
	
	public String getDebug(){
		return this.debug;
	}

	private void doCommon() throws Exception {
	}

	public void setAll( Hashtable recordSet ) {
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;

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

	
	public ArrayList getDrugDetails(String patient_id,String order_id,String order_line_num,String sr_no){

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		ArrayList	records		=	new ArrayList();

		try{
			connection	= getConnection() ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PACT_BY_SPEC_DRUG_QUERY_SELECT2") ) ; 
			pstmt.setString(1,patient_id.trim());
			pstmt.setString(2,order_id.trim());
			pstmt.setString(3,order_line_num.trim());
			pstmt.setString(4,sr_no.trim());
			pstmt.setString(5,getLanguageId());
			pstmt.setString(6,getLanguageId());
			pstmt.setString(7,getLanguageId());

			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				records.add(resultSet.getString("DRUG_DESC"));
				records.add(resultSet.getString("STRENGTH"));
				records.add(resultSet.getString("FORM_DESC"));
				records.add(resultSet.getString("DOSAGE_DETAILS"));
				records.add(resultSet.getString("ROUTE_DESC"));
				records.add(resultSet.getString("START_DATE"));
				records.add(resultSet.getString("END_DATE"));
			}	
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PACT_BY_SPEC_DRUG_QUERY_SELECT3") ) ;
			pstmt.setString(1,patient_id.trim());
			pstmt.setString(2,order_id.trim());
			pstmt.setString(3,order_line_num.trim());
			pstmt.setString(4,sr_no.trim());
			resultSet	= pstmt.executeQuery(); 
			if( resultSet != null && resultSet.next() ) {
				records.add(resultSet.getString("ORDER_LINE_FIELD_VALUE"));
				records.add(resultSet.getString("SPLIT_DOSE_PREVIEW"));
				records.add(resultSet.getString("ALLERGY_OVERRIDE_REASON"));
				records.add(resultSet.getString("DOSAGE_LIMIT_OVERRIDE_REASON"));
				records.add(resultSet.getString("DISCONT_BY_ID"));
				records.add(resultSet.getString("DISCONT_DATE_TIME"));
				records.add(resultSet.getString("DISCONT_REASON_CODE"));
			}	
		}catch(Exception e){
				records.add(e.toString());
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){es.printStackTrace();
			}
		}
		return records;	




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
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
		}catch(Exception e){
				records.add(e.toString());
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
es.printStackTrace();			}
		}
		return records;	
	}
	
	public ArrayList getFrom_and_To_date() {///added for performance tuning start
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
	}////added for performance tuning end
	
	//Added for ML-MMOH-SCF-1853 -Start
	
	public String getDischargeInd(String order_id)
	{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String dis_ind = "";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement("SELECT DISCHARGE_IND FROM OR_ORDER WHERE ORDER_ID = ?") ;
			pstmt.setString(1,order_id);
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null && resultSet.next()) {
				   dis_ind = resultSet.getString("DISCHARGE_IND")==null?"":resultSet.getString("DISCHARGE_IND");
			}
	   }
		catch(Exception e)
		{
			e.printStackTrace() ;
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
		
		return dis_ind;

	}
	
	//Added for ML-MMOH-SCF-1853 -End
}
