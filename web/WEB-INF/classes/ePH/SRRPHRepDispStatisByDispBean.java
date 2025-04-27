/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 //saved on 29/12/2009


package ePH ;

import java.io.Serializable ;
import java.util.ArrayList;
import java.sql.*;
import ePH.Common.* ;
import eCommon.Common.* ;



public class SRRPHRepDispStatisByDispBean extends PhAdapter implements Serializable {
	
		
	public SRRPHRepDispStatisByDispBean() {
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
	
	public ArrayList getDispLocnList(String facility_id){

		ArrayList dispLocnList = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			//String disp_locn_sql = PhRepository.getPhKeyValue("SQL_PH_REPORT_DISP_LOCATION");
			String disp_locn_sql ="SELECT DISP_LOCN_CODE, SHORT_DESC FROM PH_DISP_LOCN_LANG_VW PH_DISP_LOCN WHERE EFF_STATUS='E' and facility_id =NVL(?,facility_id) AND LANGUAGE_ID = ? ORDER BY SHORT_DESC";
			connection = getConnection() ;
			pstmt = connection.prepareStatement(disp_locn_sql) ;
			pstmt.setString(1, facility_id);
			pstmt.setString(2,getLanguageId());

			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					dispLocnList.add( resultSet.getString( "disp_locn_code" ) ) ;
					dispLocnList.add( resultSet.getString( "short_desc" ) );
				}
			}
		}
		catch ( Exception e ) {
			System.err.println( "Error loading DispLocn List from database" ) ;
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
		return dispLocnList;
	}

	public ArrayList getDrugCategory(){

		ArrayList drugCategoryList = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			String drug_category_sql = "SELECT A.DRUG_CATG_CODE, A.SHORT_DESC FROM PH_DRUG_CATG_LANG_VW A WHERE EFF_STATUS = 'E' AND LANGUAGE_ID=? ORDER BY 2 ";
			connection = getConnection() ;
			pstmt = connection.prepareStatement(drug_category_sql) ;
			pstmt.setString(1,getLanguageId());

			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					drugCategoryList.add( resultSet.getString( "DRUG_CATG_CODE" ) ) ;
					drugCategoryList.add( resultSet.getString( "SHORT_DESC" ) );
				}
			}
		}
		catch ( Exception e ) {
			System.err.println( "Error loading drugCategory List from database" ) ;
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
		return drugCategoryList;
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
			}catch(Exception es){es.printStackTrace();
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
			System.err.println( "Error loading values from database" ) ;
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
            System.err.println( "Error while while getting IV LEGENDS " ) ;
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

	public ArrayList getMednDateList() {
		ArrayList dateList = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_MEDN_ADMN_DATE_SELECT1" )) ;
			
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					dateList.add( resultSet.getString( "IN_DATE" ) ) ;
					dateList.add( resultSet.getString( "EN_DATE" ) );
					dateList.add( resultSet.getString( "AD_DATE" ) );
				}
			}
		}
		catch ( Exception e ) {
			System.err.println( "Error loading values from database" ) ;
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
		return dateList;
	}

	  public ArrayList loadFillProcessID(String process_type ,String process_date) {
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String process_id			=	"";

		ArrayList fill_process_id	= new ArrayList();

		try{
		connection = getConnection() ;
		String str_qry	="SELECT DISTINCT A.FILL_PROC_ID FROM PH_FILL_PROCESS_PARAM A,PH_DISP_HDR_TMP B WHERE PROC_TYPE=nvl(?,PROC_TYPE)  AND A.FILL_PROC_ID=B.FILL_PROC_ID AND TRUNC(FILL_PROC_DATE_TIME)=TO_DATE(?,'DD/MM/YYYY')";
		pstmt			= connection.prepareStatement(str_qry) ;
		pstmt.setString(1,process_type);
		pstmt.setString(2,process_date);
		resultSet		= pstmt.executeQuery();
		while(resultSet!=null && resultSet.next()){
			process_id		=	resultSet.getString(1);
			fill_process_id.add(process_id);
		}
		 
	    }catch ( Exception e ) {
                e.printStackTrace() ;
           
			} finally {
                try{
                    closeResultSet( resultSet ) ;
                    closeStatement( pstmt ) ;
                    closeConnection( connection );
                    }catch(Exception es){
					es.printStackTrace() ;
					}
              }


		return fill_process_id;


  }

}
