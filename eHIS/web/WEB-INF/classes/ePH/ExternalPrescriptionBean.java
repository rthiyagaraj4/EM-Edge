/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
24/02/2021		TFS-15598       Prabha          MOHE-CRF-0074
---------------------------------------------------------------------------------------------------------------
*/ 

 package ePH ;
import java.io.Serializable ;
import java.util.* ;   
import java.sql.* ;
import ePH.Common.* ;
import eCommon.Common.* ;


public class ExternalPrescriptionBean extends PhAdapter implements Serializable {

	private  ArrayList referralFcy=new ArrayList();
	public ExternalPrescriptionBean() {
		try {
			doCommon() ;
		}
		catch(Exception e) {System.err.println("Error @ start");
		}
	}

	/* Over-ridden Adapter methods start here */
	private void doCommon() throws Exception {
	}

	public ArrayList getReferralFacilities() {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
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

	public String getSystemDate() throws Exception{
        
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String sysdate			= "";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( CommonRepository.getCommonKeyValue("SQL_SYS_DATE_TIME")) ;
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				sysdate = (String)resultSet.getString("SYS_DATE");
				
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
		return sysdate;
    }

	public void clear()
	{
		referralFcy=new ArrayList();
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
			}catch(Exception es){	pat_txt_length	=es.toString();
			}
		}
		
		return pat_txt_length;	
	}

public ArrayList getOtherRefFacility() { 
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ;        
		ArrayList	ref_facility	=	new ArrayList() ;

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT110B"));
			pstmt.setString(1,getLanguageId());
			resultSet	        = pstmt.executeQuery();
			
			while( resultSet != null && resultSet.next() ) {
				ref_facility.add(resultSet.getString("hcare_setting_type_code"));
				ref_facility.add(resultSet.getString("short_desc"));
							
			}						
		}catch(Exception e){
				System.err.println(e);
				e.printStackTrace();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){es.printStackTrace();
			}
		}
		return ref_facility;	

	}	
	
/*========function for loading  referal facilities from AM_REFERAL TABLE==========*/
/* public ArrayList getAmRefFacility() { 
		Connection connection		=	null ;
		PreparedStatement pstmt		=	null ;
		ResultSet resultSet			=	null ;        
		ArrayList	ref_facility	=	new ArrayList() ;
		HashMap     ref_fac   =null;

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT110") ) ;	
			resultSet	= pstmt.executeQuery();			
			while( resultSet != null && resultSet.next() ) {
				ref_fac=new HashMap();
				ref_fac.put("REFERRAL_CODE",(String)(resultSet.getString("REFERRAL_CODE")));
				ref_fac.put("SHORT_DESC",(String)(resultSet.getString("SHORT_DESC")));
				ref_facility.add(ref_fac);
				
			}				
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
		}catch(Exception e){
				System.err.println(e);
				e.printStackTrace();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){	System.err.println(es);
				es.printStackTrace();
	
			}
		}
		return ref_facility;	

	}	*/

	public String getRegPatientButton(){//added for CRF-0216[IN050148] start
		String regPatientButton_yn="X";
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement("select nvl(GET_TASK_APPLICABILITY(?,NULL,'',''),'X') conf_access_flag FROM dual") ;
			pstmt.setString(1,"PH_REG_PAT_EXT_PRES");
			resultSet = pstmt.executeQuery() ;
			while (resultSet.next()) {
				regPatientButton_yn = checkForNull(resultSet.getString("CONF_ACCESS_FLAG"));
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
		return regPatientButton_yn;
	}//added for CRF-0216[IN050148] end	
	
	//Added for MOHE-CRF-0074
	public ArrayList getRegionCheckExt(String region_code) {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		ArrayList result=new ArrayList();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement("SELECT facility_id, facility_name FROM sm_facility_param_lang_vw sm_facility_param WHERE facility_id <> ? AND REGION_CODE= ? AND language_id = ? ORDER BY 2");
			
			pstmt.setString(1,login_facility_id.trim());
			pstmt.setString(2,region_code);
			pstmt.setString(3,getLanguageId());
			resultSet = pstmt.executeQuery() ;			

			while (resultSet!=null && resultSet.next()) {
				result.add(resultSet.getString("FACILITY_ID")==null?"":resultSet.getString("FACILITY_ID"));
				result.add(resultSet.getString("FACILITY_NAME")==null?"":resultSet.getString("FACILITY_NAME"));
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
	//Added for MOHE-CRF-0074
}
