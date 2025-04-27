/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package ePH;

import java.io.Serializable;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import ePH.Common.*;
import eCommon.Common.*;
import ePH.IVPrescription.*;
import eOR.*;

public class IVPiggyBackBean extends PhAdapter implements Serializable {
private String DrugIndicationRemarks				= null ;//Added for  ML-BRU-CRF-072[Inc:29938]
	public IVPiggyBackBean() {
		try{
			doCommon();
        }catch(Exception e) {e.printStackTrace();}
	}
	private void doCommon() throws Exception {
	}
	public void clear() {
		super.clear();
	}
	//Added for  ML-BRU-CRF-072[Inc:29938] start	
	public void setDrugIndicationRemarks(String DrugIndicationRemarks)	{
	
		this.DrugIndicationRemarks	=DrugIndicationRemarks;
		
	}
	
	public String getDrugIndicationRemarks()	{
		return this.DrugIndicationRemarks;
		
	}
	//Added for  ML-BRU-CRF-072[Inc:29938] End
	public ArrayList getSheduleFrequency(String drug_code){
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		ArrayList result		= new ArrayList();
		try {
			connection = getConnection() ;
//			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_IV_PB_FREQ_DESC") );
			pstmt = connection.prepareStatement("SELECT DISTINCT a.freq_code, a.freq_desc FROM am_frequency_lang_vw a, or_freq_catalog_scope b, am_frequency_admin_day_time c WHERE a.eff_status = 'E' AND (a.freq_nature <> 'C' AND a.freq_nature <> 'P' AND a.freq_nature <> 'O') AND a.freq_code = b.freq_code AND ( ( b.freq_code = c.freq_code AND a.repeat_value = (CASE WHEN (SELECT COUNT (*) FROM am_frequency_admin_day_time WHERE freq_code = a.freq_code AND admin_facility_id = ?) = 0 THEN (SELECT COUNT (*) FROM am_frequency_admin_day_time WHERE freq_code = a.freq_code AND admin_facility_id = '*A') ELSE (SELECT COUNT (*) FROM am_frequency_admin_day_time WHERE freq_code = a.freq_code AND admin_facility_id = ?) END ) ) OR A.FREQ_NATURE IN ('I')) AND b.order_catalog_code = ? AND a.language_id = ? ORDER BY 2");

			
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,login_facility_id);
			pstmt.setString(3,drug_code);
			pstmt.setString(4,getLanguageId());
			resultSet = pstmt.executeQuery() ;
			while (resultSet != null && resultSet.next()){
				result.add(resultSet.getString("FREQ_CODE"));
				result.add(resultSet.getString("FREQ_DESC"));
			}
		}catch(Exception e){
			e.printStackTrace();

		}finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return result;
	}
	public ArrayList getDrugSheduleFrequency(String fluidCode){
//		,String drugCode
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		ArrayList result		= new ArrayList();
		try {
			connection = getConnection() ;
//			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_IV_PB_FREQ_SEL") );
			pstmt = connection.prepareStatement( "SELECT DISTINCT A.FREQ_CODE,A.FREQ_DESC FROM AM_FREQUENCY_LANG_VW A, OR_FREQ_CATALOG_SCOPE B WHERE A.FREQ_CODE=B.FREQ_CODE AND A.EFF_STATUS='E' AND (A.FREQ_NATURE <> 'C' AND A.FREQ_NATURE <>'P' AND A.FREQ_NATURE <>'O') AND B.ORDER_CATALOG_CODE IN (?,?) AND A.LANGUAGE_ID = ? ORDER BY FREQ_DESC" );
			pstmt.setString(1,fluidCode);
			pstmt.setString(2,fluidCode);
			pstmt.setString(3,getLanguageId());
//			pstmt.setString(2,drugCode);
			resultSet = pstmt.executeQuery() ;
			while (resultSet != null && resultSet.next()){
				result.add(resultSet.getString("FREQ_CODE"));
				result.add(resultSet.getString("FREQ_DESC"));
			}
		}catch(Exception e){
			System.err.println(e); e.printStackTrace();
		}finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
			}
		}
		return result;
	}

	public HashMap getMaxDuration(){
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		HashMap result			= new HashMap();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_IV_PB_MAX_DURN") );
			resultSet = pstmt.executeQuery() ;
			if (resultSet != null && resultSet.next()){
				result.put("IP",resultSet.getString("IP_DAYS"));
				result.put("OP",resultSet.getString("OP_DAYS"));				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return result;
	}
	public Hashtable loadDurnDesc(){

		Hashtable	durn_values  = new Hashtable();
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String	durn_code		= "";
		String	durn_desc		= "";
		String locale= getLanguageId()==null?"en":getLanguageId();

		try{
			connection	= getConnection() ;
			pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT13A") ) ;
			pstmt.setString(1, locale);
			resultSet	= pstmt.executeQuery();
			while ( resultSet != null && resultSet.next() ) {
				durn_code	=	resultSet.getString("DURN_TYPE");
				durn_desc	=	resultSet.getString("DURN_DESC");
				durn_values.put(durn_code,durn_desc);
			}
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
			}catch(Exception es){
				es.printStackTrace() ;
			}

		}catch(Exception e){
			durn_values.put("Exception",e.toString());
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){ 
				durn_values.put("Exception",es.toString());
			}
		}
		return durn_values;
	}
   public HashMap ChkAdMixture(){
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;
		String iv_admixture_appl_yn="";
		HashMap result			= new HashMap();
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT91") );
			pstmt.setString(1,getLoginFacilityId());

			resultSet = pstmt.executeQuery() ;
			if (resultSet != null && resultSet.next())
			{
                 iv_admixture_appl_yn =resultSet.getString("IV_ADMIXTURE_APPL_YN");
			     result.put("IV_ADMIXTURE_APPL_YN",iv_admixture_appl_yn);
				 result.put("ALERT_PRACTITIONER_YN",resultSet.getString("ALERT_PRACTITIONER_YN"));

			}
			closeStatement(pstmt);
			closeResultSet(resultSet);

            if(iv_admixture_appl_yn.equals("Y"))
            {
			  pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT92") );
			  pstmt.setString(1,getLoginFacilityId());
			  resultSet = pstmt.executeQuery() ;
			
			   if (resultSet != null && resultSet.next()){
				result.put("time_flag",resultSet.getString(1));
				
			   }
				closeStatement(pstmt);
				closeResultSet(resultSet);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		
		return result;
	}
/*========================================================*/

public int getADRCount(String patient_id,String drug_code){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		int count					= 0;
		try{
			connection				= getConnection() ;
			pstmt					= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT102")) ;
			pstmt.setString(1,patient_id);
			pstmt.setString(2,drug_code);
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				count = resultSet.getInt("count");			
			}
			
		}catch ( Exception e ) {
			System.err.println( "Error while checking adr count  :"+e ) ;
            e.printStackTrace() ;
		}finally {
            try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
            }catch(Exception es){
				es.printStackTrace();
			}
        }
		return count;
	}


}
