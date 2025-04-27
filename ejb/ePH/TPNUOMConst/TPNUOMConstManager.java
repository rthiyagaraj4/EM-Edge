/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH.TPNUOMConst ;

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
*	name="TPNUOMConst"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="TPNUOMConst"
*	local-jndi-name="TPNUOMConst"
*	impl-class-name="ePH.TPNUOMConst.TPNUOMConstManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.TPNUOMConst.TPNUOMConstLocal"
*	remote-class="ePH.TPNUOMConst.TPNUOMConstRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.TPNUOMConst.TPNUOMConstLocalHome"
*	remote-class="ePH.TPNUOMConst.TPNUOMConstHome"
*	generate= "local,remote"
*
*
*/

public class TPNUOMConstManager extends PhEJBSessionAdapter {
	Properties prop=null;
	String SQL_PH_TPN_PARAMETERS_SELECT7 ="";
	String SQL_PH_TPN_PARAMETERS_SELECT8 ="";
	// insert method starts here

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

    public HashMap insert( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		map.put( "msgid", "inside Insert" ) ;

		String SQL_PH_TPN_PARAM_INSERT			 = (String)sqlMap.get("SQL_PH_TPN_PARAM_INSERT");
		String SQL_PH_TPN_PARAM_FOR_CONST_INSERT = (String)sqlMap.get("SQL_PH_TPN_PARAM_FOR_CONST_INSERT");
		String SQL_PH_TPN_PARAM_UPDATE			 = (String)sqlMap.get("SQL_PH_TPN_PARAM_UPDATE");
		String SQL_PH_TPN_PARAM_FOR_CONST_UPDATE = (String)sqlMap.get("SQL_PH_TPN_PARAM_FOR_CONST_UPDATE");
				 SQL_PH_TPN_PARAMETERS_SELECT7	 = (String)sqlMap.get("SQL_PH_TPN_PARAMETERS_SELECT7");
				 SQL_PH_TPN_PARAMETERS_SELECT8	 = (String)sqlMap.get("SQL_PH_TPN_PARAMETERS_SELECT8");
         String SQL_PH_TPN_PARAM_FOR_CONST_DELETE=(String)sqlMap.get("SQL_PH_TPN_PARAM_FOR_CONST_DELETE");
		ArrayList common_values          = (ArrayList)tabData.get("common_values");
		ArrayList ph_tpn_param			 = (ArrayList)tabData.get("ph_tpn_param");
		ArrayList ph_tpn_param_for_const = (ArrayList)tabData.get("ph_tpn_param_for_const");
		//System.out.println("tpn values in ejb"+ph_tpn_param);

		prop = (Properties)tabData.get("properties");

		Connection connection = null ;
		PreparedStatement pstmt_insert1=null,pstmt_insert2 = null ;
		PreparedStatement pstmt_update1=null,pstmt_update2 = null ,pstmt_delete2=null;;
		try {
			connection = getConnection( prop ) ;
			if(validateTPNParam().equals("I")){
				pstmt_insert1 = connection.prepareStatement( SQL_PH_TPN_PARAM_INSERT ) ;
				pstmt_insert1.setString(1,(String)ph_tpn_param.get(0));			//energy_unit              
				pstmt_insert1.setString(2,(String)ph_tpn_param.get(1));			//regimen_presc_base_unit  
				pstmt_insert1.setString(3,(String)common_values.get(0));		//added_by_id              
				pstmt_insert1.setString(4,(String)common_values.get(1));		//added_at_ws_no           
				pstmt_insert1.setString(5,(String)common_values.get(2));		//added_facility_id        
				pstmt_insert1.setString(6,(String)common_values.get(0));		//modified_by_id           
				pstmt_insert1.setString(7,(String)common_values.get(1));		//modified_at_ws_no        
				pstmt_insert1.setString(8,(String)common_values.get(2));		//modified_facility_id 
				
				pstmt_insert1.setString(9,(String)ph_tpn_param.get(2));		//max weight           
				pstmt_insert1.setString(10,(String)ph_tpn_param.get(3));		//min weight       
				pstmt_insert1.setString(11,(String)ph_tpn_param.get(4));		//expiry period           
				pstmt_insert1.setString(12,(String)ph_tpn_param.get(5));		//itemfluid_yn        
				pstmt_insert1.setString(13,(String)ph_tpn_param.get(6));		//ord_regmn_ind

				int result1= pstmt_insert1.executeUpdate();
				if(result1 < 0 ){
					throw new EJBException("Insert Failed");
				}
			}else{
				//System.out.println("inside update"+ph_tpn_param);
				pstmt_update1 = connection.prepareStatement( SQL_PH_TPN_PARAM_UPDATE ) ;
				pstmt_update1.setString(1,(String)ph_tpn_param.get(0));			//energy_unit              
				pstmt_update1.setString(2,(String)ph_tpn_param.get(1));			//regimen_presc_base_unit  
				pstmt_update1.setString(3,(String)common_values.get(0));		//modified_by_id              
				pstmt_update1.setString(4,(String)common_values.get(1));		//modified_at_ws_no           
				pstmt_update1.setString(5,(String)common_values.get(2));		//modified_facility_id 
				
				pstmt_update1.setString(6,(String)ph_tpn_param.get(2));		//max weight           
				pstmt_update1.setString(7,(String)ph_tpn_param.get(3));		//min weight       
				pstmt_update1.setString(8,(String)ph_tpn_param.get(4));		//expiry period           
				pstmt_update1.setString(9,(String)ph_tpn_param.get(5));		//itemfluid_yn        
				pstmt_update1.setString(10,(String)ph_tpn_param.get(6));		//ord_regmn_ind

				int result1= pstmt_update1.executeUpdate();

				//System.err.println("result1------------>"+result1);
				if(result1 < 0 ){
					throw new EJBException("Update Failed");
				}
			}
			
			pstmt_insert2 = connection.prepareStatement( SQL_PH_TPN_PARAM_FOR_CONST_INSERT ) ;
			pstmt_update2 = connection.prepareStatement( SQL_PH_TPN_PARAM_FOR_CONST_UPDATE ) ;
			//newley added line
			pstmt_delete2=connection.prepareStatement( SQL_PH_TPN_PARAM_FOR_CONST_DELETE ) ;
	//System.err.println("From the TPN Value");
	pstmt_delete2.executeUpdate();
		//System.err.println("from delete after");
			for (int i=0;i<ph_tpn_param_for_const.size() ;i=i+7 ){
				//System.err.println("inside the for loop");
				/*if(validateTPNParamForConst((String)ph_tpn_param_for_const.get(i)).equals("I"))
					{*/
							//Newly Added Line
					pstmt_insert2.setString(1,(String)ph_tpn_param_for_const.get(i));		//SRL_NO
					pstmt_insert2.setString(2,(String)ph_tpn_param_for_const.get(i+1));		//GROUP_OR_INDIVIDUAL_IND
					pstmt_insert2.setString(3,(String)ph_tpn_param_for_const.get(i+2));		//CONST_GROUP_CODE       
					pstmt_insert2.setString(4,(String)ph_tpn_param_for_const.get(i+3));		//REGIMEN_SETUP_UNIT     
					pstmt_insert2.setString(5,(String)ph_tpn_param_for_const.get(i+4));		//ORDERING_UNIT          
					pstmt_insert2.setString(6,(String)ph_tpn_param_for_const.get(i+5));		//ORDER_QTY_LIMIT_UNIT   
					pstmt_insert2.setString(7,(String)ph_tpn_param_for_const.get(i+6));		//PREP_UNIT              
					pstmt_insert2.setString(8,(String)common_values.get(0));			//ADDED_BY_ID            
					pstmt_insert2.setString(9,(String)common_values.get(1));			//ADDED_AT_WS_NO         
					pstmt_insert2.setString(10,(String)common_values.get(2));			//ADDED_FACILITY_ID      
					pstmt_insert2.setString(11,(String)common_values.get(0));			//MODIFIED_BY_ID         
					pstmt_insert2.setString(12,(String)common_values.get(1));			//MODIFIED_AT_WS_NO      
					pstmt_insert2.setString(13,(String)common_values.get(2));			//MODIFIED_FACILITY_ID   
					pstmt_insert2.addBatch();		
					int[] result2= pstmt_insert2.executeBatch();
				//	System.err.println("result2-------------->"+result2.length);
					for (int j=0;j<result2.length ;j++ ){
						// A number greater than or equal to zero  indicates success
						// A number -2 indicates that command is successful but number of rows updated is unknow
						// If it won't satisfy any of the above cancel the statement and throw an exception
						if(result2[j]<0  && result2[j] != -2 ){
							pstmt_insert2.cancel();
							throw new EJBException("Insert Failed");
						}			
					}
			//	} if block close
				
					/*else{
					pstmt_update2.setString(1,(String)ph_tpn_param_for_const.get(i+1));	//	GROUP_OR_INDIVIDUAL_IND
					pstmt_update2.setString(2,(String)ph_tpn_param_for_const.get(i+2));	//	CONST_GROUP_CODE
					pstmt_update2.setString(3,(String)ph_tpn_param_for_const.get(i+3));	//	REGIMEN_SETUP_UNIT
					pstmt_update2.setString(4,(String)ph_tpn_param_for_const.get(i+4));	//	ORDERING_UNIT
					pstmt_update2.setString(5,(String)ph_tpn_param_for_const.get(i+5));	//	ORDER_QTY_LIMIT_UNIT
					pstmt_update2.setString(6,(String)ph_tpn_param_for_const.get(i+6));	//	PREP_UNIT
					pstmt_update2.setString(7,(String)common_values.get(0));			//	MODIFIED_BY_ID
					pstmt_update2.setString(8,(String)common_values.get(1));			//	MODIFIED_AT_WS_NO
					pstmt_update2.setString(9,(String)common_values.get(2));			//	MODIFIED_FACILITY_ID
					pstmt_update2.setString(10,(String)ph_tpn_param_for_const.get(i));	//	SRL_NO
					pstmt_update2.addBatch();		
					int[] result2= pstmt_update2.executeBatch();
					for (int j=0;j<result2.length ;j++ ){
						// A number greater than or equal to zero  indicates success
						// A number -2 indicates that command is successful but number of rows updated is unknow
						// If it won't satisfy any of the above cancel the statement and throw an exception
						if(result2[j]<0  && result2[j] != -2 ){
							pstmt_update2.cancel();
							throw new EJBException("Insert Failed");
						}			
					}
				}  */
			}			
			map.put( "result", new Boolean( true ) ) ;
			map.put( "msgid", "RECORD_INSERTED" ) ;
			connection.commit();
		}catch( Exception e ) {
			map.put( "msgid", e.toString() ) ;
			try{
				connection.rollback();
				throw new EJBException( e.getMessage() ) ;
			}
			catch ( Exception ee ) {
				 System.err.println(ee.getMessage())  ;
			}
			System.err.println(e.getMessage())  ;
			e.printStackTrace() ;
		 }finally {
			try {
				closeStatement( pstmt_insert1 ) ;
				closeStatement( pstmt_insert2 ) ;
				closeStatement( pstmt_update1 ) ;
				closeStatement( pstmt_update2 ) ;
				closeStatement(pstmt_delete2);
				closeConnection( connection,prop );
			} catch ( Exception fe ) {
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
				map.put( "msgid", fe.toString() ) ;
			}
		}
		map.put( "flag","0");
		return map;
	}

	//  modify method starts here
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap modify( HashMap tabData, HashMap sqlMap )  {		
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		map.put( "msgid", "inside Modify" ) ;
		return map ;
	}
				  
	// delete method starts here

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap delete( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		return map;
	}	

	public String validateTPNParam() throws Exception{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String flag="I";
		try {
			connection = getConnection(prop) ;
			pstmt = connection.prepareStatement( SQL_PH_TPN_PARAMETERS_SELECT7 );			
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null && resultSet.next() ) {
				if(resultSet.getInt("COUNT" )>0){
					flag="U";
				}
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
			}catch(Exception es){ es.printStackTrace();
			}
		}
		return flag;
	}

	public String validateTPNParamForConst(String srl_no) throws Exception{
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String flag="I";
		try {
			connection = getConnection(prop) ;
			pstmt = connection.prepareStatement( SQL_PH_TPN_PARAMETERS_SELECT8 );	
			pstmt.setString(1,srl_no.trim());
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null && resultSet.next() ) {
				if(resultSet.getInt("COUNT" )>0){
					flag="U";
				}
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
			}catch(Exception es){ es.printStackTrace();
			}
		}
		return flag;
	}
}
