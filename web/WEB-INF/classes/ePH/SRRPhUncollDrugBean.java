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

public class SRRPhUncollDrugBean extends PhAdapter implements Serializable {
	protected String billingYN		=	""; 

	public SRRPhUncollDrugBean() {
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
	//setters and getters for Billing when billing setup is on.....
	public void setBillingYN(String billingYN) {
		this.billingYN	= billingYN;
	}

	public String getBillingYN(){
		return this.billingYN;
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
 	/* Over-ridden Adapter methods end here */


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
			System.err.println( "Error loading facility list" +e.toString()) ;
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { es.printStackTrace();
}
		}

		return facilityList;
	}
/*   Facility desc returns ends here    */

/*  Dispense Location starts where disp_locn_type = 'P' */

public ArrayList getDispLocationList(String facility_id) {
		ArrayList displocationlist = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String facility_id1 = facility_id;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISP_LOCN_COMN_SELECT1" )) ;
			pstmt.setString(1,login_by_id);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,facility_id1);
			pstmt.setString(4, getLanguageId());

			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					displocationlist.add( resultSet.getString( "DISP_LOCN_CODE" ) ) ;
					displocationlist.add( resultSet.getString( "SHORT_DESC" ) );
				}
			}

		}
		catch ( Exception e ) {
			System.err.println( "Error loading Dispense Location list" +e.toString()) ;
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

		return displocationlist;
	}
	/*Patient search starts...........*/
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
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return pat_txt_length;	
	}
	//code added to check  Billing interface on 28/12/09 for the function Prescribe Pattern.
public String checkforbillinginterface()throws Exception{
	//System.out.println("Inside Billing Interface======>" );
		Connection connection			= null;
		PreparedStatement pstmt_select	= null;
		ResultSet resultSet			    = null;	
		String bl_interface_yn					= "N";
		try{
        connection = getConnection() ;
		pstmt_select = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_BL_SELECT2")) ;
		pstmt_select.setString(1,login_facility_id);
		resultSet				= pstmt_select.executeQuery();
        if (resultSet.next() ) {
			bl_interface_yn=resultSet.getString("BL_INTERFACE_YN");
			if(bl_interface_yn==null){
                bl_interface_yn="N";
			}
	    }
		}catch(Exception exception){
			
			exception.printStackTrace();
			throw exception;
		}
		finally{
			    closeResultSet( resultSet ) ;
				closeStatement( pstmt_select ) ;
				closeConnection( connection );
		}
		return bl_interface_yn;
	}
	/*Code starts for the EDLCLASSIFICATIONLIST VALUES */
public ArrayList getEDLClassficationList(){
	//System.out.println("inside bean getEDLClassficationList");
	  Connection connection			 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet				 =		null ;
		//ArrayList ItemclassArraylist =		new ArrayList();
		ArrayList EDLClassArraylist =		new ArrayList();
		
		try {
			connection	 = getConnection() ;
			//pstmt			 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TERM_SET_SELECT1" )) ;
			//pstmt			 = connection.prepareStatement("SELECT ITEM_CLASS_CODE,SHORT_DESC from MM_ITEM_CLASS_LANG_VW WHERE LANGUAGE_ID=? order by short_desc" ) ;
			pstmt			 = connection.prepareStatement("SELECT edl_code,substr(PATH,3) edl_desc FROM (SELECT description,eff_status,edl_code, LEVEL l_level,SYS_CONNECT_BY_PATH (description, '->') PATH, parent_code FROM (SELECT *      FROM ph_edl_classifications)START WITH parent_code IS NULL CONNECT BY PRIOR edl_code = parent_code) where edl_code NOT IN (SELECT DISTINCT parent_code FROM ph_edl_classifications WHERE parent_code IS NOT NULL) order by edl_desc") ;
			//pstmt.setString(1,getLanguageId());
			resultSet      = pstmt.executeQuery() ;
			while (resultSet.next()) {
				HashMap rec		=	new HashMap();
				String code,desc;
				code					=	resultSet.getString("EDL_CODE");
				desc					=	resultSet.getString("EDL_DESC");
				rec.put("code",code);
				rec.put("desc",desc);
				EDLClassArraylist.add(rec);
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
		//return ItemclassArraylist;
		return EDLClassArraylist;
	  }  //Code ends for the EDLClassificationList



	
}
