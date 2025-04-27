/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
	Module		 : ePH
	Function	 : Generic Name by ATC Class
	Class Name	 : GenericNameByATCManager
	Created By	 : A.S.Raghunath
	Created Date : 
	Modified By	 :
	Modified Date:
	Version		 :
	Description  :				  
*/
//saved on 27/10/2005
package ePH.GenericNameByPharmaco ;

import java.rmi.* ;
import java.util.HashMap ;
import java.util.ArrayList;
import java.util.Properties;
import java.sql.* ;
import javax.ejb.* ;
import ePH.Common.PhEJBSessionAdapter ;


/**
*
* @ejb.bean
*	name="GenericNameByPharmaco"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="GenericNameByPharmaco"
*	local-jndi-name="GenericNameByPharmaco"
*	impl-class-name="ePH.GenericNameByPharmaco.GenericNameByPharmacoManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.GenericNameByPharmaco.GenericNameByPharmacoLocal"
*	remote-class="ePH.GenericNameByPharmaco.GenericNameByPharmacoRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.GenericNameByPharmaco.GenericNameByPharmacoLocalHome"
*	remote-class="ePH.GenericNameByPharmaco.GenericNameByPharmacoHome"
*	generate= "local,remote"
*
*
*/

public class GenericNameByPharmacoManager extends PhEJBSessionAdapter {

	Properties prop=null;

	String SQL_PH_GENERIC_NAME_BY_ATC_CLASS_SELECT3="";
	String SQL_PH_GENERIC_NAME_BY_PHARMACO_CLASS_SELECT4="";
	
	// insert method starts here

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
    public HashMap insert( HashMap tabData, HashMap sqlMap )  {
		
		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;			
		final String SQL_PH_GENERIC_NAME_INSERT = (String) sqlMap.get( "SQL_PH_GENERIC_NAME_INSERT" );
		final String SQL_PH_GENERIC_NAME_BY_PHARMACO_CLASS_INSERT = (String) sqlMap.get( "SQL_PH_GENERIC_NAME_BY_PHARMACO_CLASS_INSERT" );
					 SQL_PH_GENERIC_NAME_BY_ATC_CLASS_SELECT3= (String) sqlMap.get( "SQL_PH_GENERIC_NAME_BY_ATC_CLASS_SELECT3");
					 SQL_PH_GENERIC_NAME_BY_PHARMACO_CLASS_SELECT4= (String) sqlMap.get( "SQL_PH_GENERIC_NAME_BY_PHARMACO_CLASS_SELECT4");

							  prop  = (Properties)tabData.get( "properties" );			            
		String  login_by_id			= (String)tabData.get("login_by_id");
		String	login_at_ws_no		= (String)tabData.get("login_at_ws_no");
		String	login_facility_id	= (String)tabData.get("login_facility_id");
		
		String  generic_name		= (String)tabData.get("generic_name");
		String  drug_name			= (String)tabData.get("drug_name");
		String  eff_status			= (String)tabData.get("eff_status");

		ArrayList arrList=(ArrayList)tabData.get("arrList");
		
		Connection connection = null ;
		PreparedStatement pstmt_insert = null ;
		try {
			connection = getConnection( prop ) ;
			pstmt_insert = connection.prepareStatement( SQL_PH_GENERIC_NAME_INSERT ) ;
			String generic_id=getGenericId();
			pstmt_insert.setString(1,generic_id);
			pstmt_insert.setString(2,generic_name);
			pstmt_insert.setString(3,drug_name);
			pstmt_insert.setString(4,"");
			pstmt_insert.setString(5,eff_status);
			pstmt_insert.setString(6,login_by_id);
			pstmt_insert.setString(7,login_at_ws_no);
			pstmt_insert.setString(8,login_facility_id);
			pstmt_insert.setString(9,login_by_id);
			pstmt_insert.setString(10,login_at_ws_no);
			pstmt_insert.setString(11,login_facility_id);
			int result1= pstmt_insert.executeUpdate();
			if(result1 < 0 ){
						throw new EJBException("Insert Failed");
			}

			if(pstmt_insert!=null)
			closeStatement( pstmt_insert ) ;

			pstmt_insert = connection.prepareStatement( SQL_PH_GENERIC_NAME_BY_PHARMACO_CLASS_INSERT ) ;
			// clear the batch
			pstmt_insert.clearBatch();
			int sr_no=getSrNo(generic_id);
			for (int i=0;i<arrList.size() ;i++ ){
				String[] record=(String[])arrList.get(i); 
				if ((record[0]).trim().equals("")){
					record[0]=null;
				}
				if ((record[1]).trim().equals("")){
					record[1]=null;
				}
				if ((record[2]).trim().equals("")){
					record[2]=null;
				}
								
				pstmt_insert.setString(1,generic_id);
				pstmt_insert.setString(2,(sr_no++)+"");
				pstmt_insert.setString(3,record[0]);
				pstmt_insert.setString(4,record[1]);
				pstmt_insert.setString(5,record[2]);
				pstmt_insert.setString(6,login_by_id);
				pstmt_insert.setString(7,login_at_ws_no);
				pstmt_insert.setString(8,login_facility_id);
				pstmt_insert.setString(9,login_by_id);
				pstmt_insert.setString(10,login_at_ws_no);
				pstmt_insert.setString(11,login_facility_id);
				// add the statement to the batch
				pstmt_insert.addBatch();				
			}
			int[] result2= pstmt_insert.executeBatch();
			for (int i=0;i<result2.length ;i++ ){
				// A number greater than or equal to zero  indicates success
				// A number -2 indicates that command is successful but number of rows updated is unknow
				// If it won't satisfy any of the above cancel the statement and throw an exception
				if(result2[i]<0  && result2[i] != -2 ){
					pstmt_insert.cancel();
					throw new EJBException("Insert Failed");
				}			
			}
			map.put( "result", new Boolean( true ) ) ;
			messages.append( "RECORD_INSERTED" ) ;
			connection.commit();
		}
		catch( Exception e ) {
			try{
				connection.rollback();
				throw new EJBException( e.getMessage() ) ;
			}
			catch ( Exception ee ) {
				messages.append( ee.getMessage() ) ;
			}
			messages.append( e.getMessage() ) ;
			e.printStackTrace() ;
		} finally {
			try {
				closeStatement( pstmt_insert ) ;
				closeConnection( connection,prop );
			} catch ( Exception fe ) {
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}
		map.put( "msgid", messages.toString() ) ;
		map.put( "flag","0");
		return map ;
	}
// insert method ends here


//  modify method starts here
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap modify( HashMap tabData, HashMap sqlMap )  {

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		
		final String SQL_PH_GENERIC_NAME_UPDATE = (String) sqlMap.get( "SQL_PH_GENERIC_NAME_UPDATE" );
		final String SQL_PH_GENERIC_NAME_BY_ATC_CLASS_DELETE  = (String) sqlMap.get( "SQL_PH_GENERIC_NAME_BY_ATC_CLASS_DELETE" );
		final String SQL_PH_GENERIC_NAME_BY_ATC_CLASS_INSERT  = (String) sqlMap.get( "SQL_PH_GENERIC_NAME_BY_ATC_CLASS_INSERT" );
					 SQL_PH_GENERIC_NAME_BY_PHARMACO_CLASS_SELECT4 = (String) sqlMap.get( "SQL_PH_GENERIC_NAME_BY_PHARMACO_CLASS_SELECT4");

							  prop  = (Properties)tabData.get( "properties" );			            
		String  login_by_id			= (String)tabData.get("login_by_id");
		String	login_at_ws_no		= (String)tabData.get("login_at_ws_no");
		String	login_facility_id	= (String)tabData.get("login_facility_id");
		
		String  generic_id			= (String)tabData.get("generic_id");
		String  generic_name		= (String)tabData.get("generic_name");
		String  drug_name			= (String)tabData.get("drug_name");
		String  eff_status			= (String)tabData.get("eff_status");

		Connection connection = null ;
		PreparedStatement pstmt_update = null ;
		PreparedStatement pstmt_delete = null ;
		PreparedStatement pstmt_insert = null ;

		try {
			connection = getConnection( prop ) ;
			// Update the table ph_generic_name
			pstmt_update = connection.prepareStatement( SQL_PH_GENERIC_NAME_UPDATE ) ;
			pstmt_update.setString(1,generic_name);
			pstmt_update.setString(2,drug_name);
			pstmt_update.setString(3,eff_status);
			pstmt_update.setString(4,login_by_id);
			pstmt_update.setString(5,login_at_ws_no);
			pstmt_update.setString(6,login_facility_id);
			pstmt_update.setString(7,generic_id);
			pstmt_update.executeUpdate();

			// deleting the selected records from ph_generic_name_by_atc_class
			ArrayList delete=(ArrayList)tabData.get("deleteOld");
			if (delete.size() > 0)	{
				pstmt_delete = connection.prepareStatement( SQL_PH_GENERIC_NAME_BY_ATC_CLASS_DELETE ) ;
				for (int i=0;i<delete.size() ;i++ ) {
					pstmt_delete.setString(1,generic_id);
					pstmt_delete.setString(2,(String)delete.get(i));
					// adding the statement to the batch
					pstmt_delete.addBatch();
				}				
				int[] result2=pstmt_delete.executeBatch();
				for (int i=0;i<result2.length ;i++ ){
				// A number greater than or equal to zero  indicates success
				// A number -2 indicates that command is successful but number of rows updated is unknow
				// If it won't satisfy any of the above cancel the statement and throw an exception
					if(result2[i]<0  && result2[i] != -2 ){
						pstmt_delete.cancel();
						connection.rollback();
						throw new EJBException("Delete Failed");
					}			
				}
			}			
			//inserting the selected records into ph_generic_name_by_atc_class
			ArrayList insertNew=(ArrayList)tabData.get("insertNew");
			if (insertNew.size() > 0)	{
				// Getting the serial number based on generic_id
				int sr_no=getSrNo(generic_id);
				pstmt_insert = connection.prepareStatement( SQL_PH_GENERIC_NAME_BY_ATC_CLASS_INSERT ) ;
				for (int i=0;i<insertNew.size() ;i++ ) {
					String[] record=(String[])insertNew.get(i); 
					if ((record[0]).trim().equals("")){
						record[0]=null;
					}
					if ((record[1]).trim().equals("")){
						record[1]=null;
					}
					if ((record[2]).trim().equals("")){
						record[2]=null;
					}
					if ((record[3]).trim().equals("")){
						record[3]=null;
					}
					if ((record[4]).trim().equals("")){
						record[4]=null;
					}
					pstmt_insert.setString(1,generic_id);
					pstmt_insert.setString(2,(sr_no++)+"");
					pstmt_insert.setString(3,record[0]);
					pstmt_insert.setString(4,record[1]);
					pstmt_insert.setString(5,record[2]);
					pstmt_insert.setString(6,record[3]);
					pstmt_insert.setString(7,record[4]);
					pstmt_insert.setString(8,login_by_id);
					pstmt_insert.setString(9,login_at_ws_no);
					pstmt_insert.setString(10,login_facility_id);
					pstmt_insert.setString(11,login_by_id);
					pstmt_insert.setString(12,login_at_ws_no);
					pstmt_insert.setString(13,login_facility_id);
					// add the statement to the batch
					pstmt_insert.addBatch();					
				}
				int[] result3= pstmt_insert.executeBatch();
				for (int i=0;i<result3.length ;i++ ){
				// A number greater than or equal to zero  indicates success
				// A number -2 indicates that command is successful but number of rows updated is unknow
				// If it won't satisfy any of the above cancel the statement and throw an exception
					if(result3[i]<0  && result3[i] != -2 ){
						pstmt_insert.cancel();
						connection.rollback();
						throw new EJBException("Insert Failed");
					}			
				}			
			}
			map.put( "result", new Boolean( true ) ) ;				
			map.put( "msgid","RECORD_MODIFIED");
			connection.commit();
		}
		catch( Exception e ) {
			
			try{
				System.err.println("ASRN::(TEST)(1):"+e.getMessage() ) ;
				map.put( "result", new Boolean( false ) ) ;
				connection.rollback();
				throw new EJBException( e.getMessage() ) ;
			}
			catch ( Exception ee ) {
				System.err.println("ASRN::(TEST)(2):"+ee.getMessage() ) ;
				map.put( "result", new Boolean( false ) ) ;
				map.put( "msgid",ee.getMessage());
			}			
			map.put( "msgid",e.getMessage());
			e.printStackTrace() ;
		} finally {
			try {
				closeStatement( pstmt_insert ) ;
				closeStatement( pstmt_update ) ;
				closeStatement( pstmt_delete ) ;
				closeConnection( connection,prop );
			} catch ( Exception fe ) {
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
			}
		}
		map.put( "flag","0");
		return map ;
	}

	// delete method starts here
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap delete( HashMap tabData, HashMap sqlMap )  {

		StringBuffer messages = new StringBuffer() ;
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		map.put( "msgid", messages.toString() ) ;
		return map ;
	}
	// delete method ends here


	//This method is used to get the generic_id

	public String getGenericId() throws Exception {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String generic_id="";
		try {
			connection = getConnection(prop) ;
			pstmt = connection.prepareStatement( SQL_PH_GENERIC_NAME_BY_ATC_CLASS_SELECT3 );
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null && resultSet.next() ) {
				generic_id=resultSet.getString("NEXT_GENERIC_ID" ) ;
			}
		}
		catch ( Exception e ){
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection,prop );
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return generic_id;
	}

	// This method is used to get the serial number based on generic_id
	public int getSrNo(String generic_id) throws Exception
	{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		int sr_no=0;
		try {
			connection = getConnection(prop) ;
			pstmt = connection.prepareStatement( SQL_PH_GENERIC_NAME_BY_PHARMACO_CLASS_SELECT4 );
			pstmt.setString(1,generic_id.trim());
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null && resultSet.next() ) {
				sr_no=resultSet.getInt("NEXT_SRL_NO" ) ;
			}
		}
		catch ( Exception e ){
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection,prop );
			}catch(Exception es){
				es.printStackTrace();
			}
		}
		return sr_no;
	}
}
