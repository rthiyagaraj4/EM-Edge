/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR.Common;

import java.io.*;
import java.util.*;
import javax.rmi.* ;
import java.sql.*;
import javax.naming.* ;
import webbeans.eCommon.*;

import eOR.Common.*;

public class AccessRightBean extends OrAdapter
{
	protected String patient_id				= "" ;

	public AccessRightBean(){
		try{
			doCommon();
		}catch(Exception e) {System.out.println("Error in AccessRightBean");}
	 }

	 public void  setPatientId(String  patient_id) { this.patient_id = checkForNull(patient_id,""); }

	 public String getPatientId() { return this.patient_id ; }

	//	 Deriving the Logic to display the Menu Buttons or not
	public String getMenu(String menu_id,String resp_id,String pract_relation_id) throws Exception {

	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	String menu_value			= "";
	try{
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_MENU") ) ;
			pstmt.setString(1, menu_id);
			pstmt.setString(2, resp_id);
			pstmt.setString(3, pract_relation_id);

			resultSet	= pstmt.executeQuery() ;
			if ( resultSet != null )
			{
				while(resultSet.next())
				{
					menu_value = checkForNull(resultSet.getString( "Menu" ),"X") ;  // If not found then X
				}
			}
		}catch ( Exception e )	{
			System.err.println( "Error loading values Menu"+e) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		
		return menu_value;
	 }	 // End of the getMenu


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
				pstmt.setString(2, getLoginFacilityId()); // pass the facility_id
				resultSet	= pstmt.executeQuery() ;
				if ( resultSet != null )    // Only one record for the module_id
				{
					while(resultSet.next())
					{
						module_install_yn = checkForNull(resultSet.getString( "operational_yn" ),"N")  ;
					}
				}	// if there is no record, then also it should return as 'N'
			}catch ( Exception e )	{
				System.err.println( "Getting Module ID SM_MODULES_FACILITY" +e) ;
				e.printStackTrace() ;
				throw e ;
			} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			return module_install_yn;
	} // End of getFacilityModuleInstallYn

	// To get the Details for the Blood Transfusion
	public ArrayList getBloodTransfusion(String patient_id) throws Exception {
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
         	ArrayList BloodTransfusion  = new ArrayList() ;
			try{
					connection	= getConnection();
					pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_BLOOD_TRANSFUSION_DETAILS") ) ;
					pstmt.setString(1, checkForNull( patient_id,""));
					resultSet	= pstmt.executeQuery() ;
					while(resultSet!= null && resultSet.next())
					{
						ArrayList Blood = new ArrayList();
						Blood.add( resultSet.getString( "event_desc" )) ;
						Blood.add( resultSet.getString( "result_str" )) ;
						BloodTransfusion.add(Blood);
					}
				}catch ( Exception e )	{
					System.err.println( "Error loading values from database When Populating Blood Transfusion" +e) ;
					e.printStackTrace() ;
					throw e ;
				} finally {
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					closeConnection(connection);
				}
				return BloodTransfusion;
	}	 // End of the getBloodTransfusion


	//public void setAll( Hashtable recordSet ) {
	//	try{
	//	   }			catch(Exception e){}  
	//}//end of setALL

	/*********************METHOD TO Insert*************************/
	public HashMap insert(){
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		return map ;
	}

	 public void clear() {
		patient_id	= "" ;
		super.clear() ;
	 }//end of clear
	 private void doCommon() throws Exception {}
	 public void loadData() throws Exception {}

}
