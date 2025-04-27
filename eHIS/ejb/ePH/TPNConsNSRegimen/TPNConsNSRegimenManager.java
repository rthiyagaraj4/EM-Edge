/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH.TPNConsNSRegimen ;
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
*	name="TPNConsNSRegimen"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="TPNConsNSRegimen"
*	local-jndi-name="TPNConsNSRegimen"
*	impl-class-name="ePH.TPNConsNSRegimen.TPNConsNSRegimenManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePH.TPNConsNSRegimen.TPNConsNSRegimenLocal"
*	remote-class="ePH.TPNConsNSRegimen.TPNConsNSRegimenRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePH.TPNConsNSRegimen.TPNConsNSRegimenLocalHome"
*	remote-class="ePH.TPNConsNSRegimen.TPNConsNSRegimenHome"
*	generate= "local,remote"
*
*
*/

public class TPNConsNSRegimenManager extends PhEJBSessionAdapter {
	Properties prop=null;
	String SQL_PH_TPN_CONS_NS_REGIMEN_SELECT5 = "";
	String SQL_PH_TPN_CONS_NS_REGIMEN_SELECT6 = "";

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

    public HashMap insert( HashMap tabData, HashMap sqlMap )  {

		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		map.put( "msgid", "inside Insert" ) ;

		String SQL_PH_TPN_CONS_NS_REGIMEN_INSERT1 = (String)sqlMap.get("SQL_PH_TPN_CONS_NS_REGIMEN_INSERT1");
		String SQL_PH_TPN_CONS_NS_REGIMEN_INSERT2 = (String)sqlMap.get("SQL_PH_TPN_CONS_NS_REGIMEN_INSERT2");
		String SQL_PH_TPN_CONS_NS_REGIMEN_INSERT_APPLICABILITY=(String)sqlMap.get("SQL_PH_TPN_CONS_NS_REGIMEN_INSERT_APPLICABILITY");//added for ml-mmoh-crf-1201
			   SQL_PH_TPN_CONS_NS_REGIMEN_SELECT5 = (String)sqlMap.get("SQL_PH_TPN_CONS_NS_REGIMEN_SELECT5");
			   SQL_PH_TPN_CONS_NS_REGIMEN_SELECT6 = (String)sqlMap.get("SQL_PH_TPN_CONS_NS_REGIMEN_SELECT6");

		ArrayList common_values           = (ArrayList)tabData.get("common_values");
		ArrayList tpn_const_for_ns_regimen= (ArrayList)tabData.get("tpn_const_for_ns_regimen");
		ArrayList inv_item_for_ns_regimen = (ArrayList)tabData.get("inv_item_for_ns_regimen");
		prop = (Properties)tabData.get("properties");

		Connection connection = null ;
		PreparedStatement pstmt_insert1=null,pstmt_insert2 = null,pstmt_insert3=null ;//modified for ml-mmoh-crf-1201
		try {
			int count =1;
			int count1=1;//added for ml-mmoh-crf-1201
			connection = getConnection( prop ) ;
			pstmt_insert1 = connection.prepareStatement( SQL_PH_TPN_CONS_NS_REGIMEN_INSERT2 ) ;
			for (int i=0;i<inv_item_for_ns_regimen.size() ;i=i+8 ){//Changed 6 to 8 for ML-MMOH-CRF-1201
				count = 1;
				//pstmt_insert1.setString(count,getTPNConsNsRegimenSrlNo());			//CONST_SRL_NO
				pstmt_insert1.setString(count,(String)tpn_const_for_ns_regimen.get(0));			//CONST_GENERIC_CODE
				pstmt_insert1.setString(++count,(String)inv_item_for_ns_regimen.get(i+1));			//ITEM_CODE
				pstmt_insert1.setString(++count,(String)tpn_const_for_ns_regimen.get(1));			//CONST_SHORT_NAME
				pstmt_insert1.setString(++count,(String)tpn_const_for_ns_regimen.get(2));			//CONST_LONG_NAME
				pstmt_insert1.setString(++count,(String)tpn_const_for_ns_regimen.get(3));			//PHYSICAL_FORM
				pstmt_insert1.setString(++count,(String)tpn_const_for_ns_regimen.get(4));			//CONCENTRATION_PERCENT
				pstmt_insert1.setString(++count,(String)tpn_const_for_ns_regimen.get(5));			//MANUFACTURER_VAR_PERCENTAGE
				pstmt_insert1.setString(++count,(String)tpn_const_for_ns_regimen.get(6));			//EFF_STATUS
				pstmt_insert1.setString(++count,(String)common_values.get(0));			//ADDED_BY_ID
				pstmt_insert1.setString(++count,(String)common_values.get(1));			//ADDED_AT_WS_NO
				pstmt_insert1.setString(++count,(String)common_values.get(2));			//ADDED_FACILITY_ID
				pstmt_insert1.setString(++count,(String)common_values.get(0));			//MODIFIED_BY_ID
				pstmt_insert1.setString(++count,(String)common_values.get(1));			//MODIFIED_AT_WS_NO
				pstmt_insert1.setString(++count,(String)common_values.get(2));			//MODIFIED_FACILITY_ID
				pstmt_insert1.addBatch();
			}
			
			int[] result1= pstmt_insert1.executeBatch();
			//int result1= pstmt_insert1.executeUpdate();
		//	if(result1 < 0 ){
		//		throw new EJBException("Insert Failed");
		//	}
			for (int j=0;j<result1.length ;j++ ){
						// A number greater than or equal to zero  indicates success
						// A number -2 indicates that command is successful but number of rows updated is unknown
						// If it won't satisfy any of the above cancel the statement and throw an exception
						if(result1[j]<0  && result1[j] != -2 ){
							pstmt_insert1.cancel();
							throw new EJBException("Insert Failed");
						}			
			}

			pstmt_insert2 = connection.prepareStatement( SQL_PH_TPN_CONS_NS_REGIMEN_INSERT1 ) ;
			//added for ml-mmoh-crf-1201 start
			pstmt_insert3= connection.prepareStatement( SQL_PH_TPN_CONS_NS_REGIMEN_INSERT_APPLICABILITY ) ;
			ArrayList applicablList           = (ArrayList)tabData.get("applicablList");
			HashMap applicableMap =  (HashMap)tabData.get("applicableMap");
			HashMap map1 = new HashMap() ;
			boolean site_bru=(Boolean) tabData.get("site_bru");
			//added for ml-mmoh-crf-1201 end
           int srl_no = Integer.parseInt(getInvItemForNsRegimenSrlNo((String)inv_item_for_ns_regimen.get(0)));
//			for (int i=0;i<inv_item_for_ns_regimen.size() ;i=i+5 ){
			for (int i=0;i<inv_item_for_ns_regimen.size() ;i=i+8 ){//Changed 6 to 8 for ML-MMOH-CRF-1201
					count = 1;
					pstmt_insert2.setString(count, (srl_no++)+""  );		
					pstmt_insert2.setString(++count,(String)inv_item_for_ns_regimen.get(i));	
					pstmt_insert2.setString(++count,(String)inv_item_for_ns_regimen.get(i+1));		
					pstmt_insert2.setString(++count,(String)inv_item_for_ns_regimen.get(i+2));		
					pstmt_insert2.setString(++count,(String)inv_item_for_ns_regimen.get(i+3));						
					pstmt_insert2.setString(++count,(String)common_values.get(0));			
					pstmt_insert2.setString(++count,(String)common_values.get(1));			
					pstmt_insert2.setString(++count,(String)common_values.get(2));			
					pstmt_insert2.setString(++count,(String)common_values.get(0));			
					pstmt_insert2.setString(++count,(String)common_values.get(1));			
					pstmt_insert2.setString(++count,(String)common_values.get(2));			
					pstmt_insert2.setString(++count,(String)inv_item_for_ns_regimen.get(i+5));
					pstmt_insert2.setString(++count,(String)inv_item_for_ns_regimen.get(i+4));
					pstmt_insert2.setString(++count,(String)inv_item_for_ns_regimen.get(i+6));//Added for ML-MMOH-CRF-1201
					pstmt_insert2.setString(++count,(String)inv_item_for_ns_regimen.get(i+7));//Added for ML-MMOH-CRF-1201
					pstmt_insert2.addBatch();		
					//added for ml-mmoh-crf-1201 start
					if(site_bru){
					map1 = (HashMap)applicableMap.get((String)inv_item_for_ns_regimen.get(i+1));
					System.out.println("map1"+map1+"inv_item_for_ns_regimen"+inv_item_for_ns_regimen);
					System.out.println("map1"+map1+"inv_item_for_ns_regimen"+(String)inv_item_for_ns_regimen.get(i));
					System.out.println("map1"+map1+"inv_item_for_ns_regimen"+(String)inv_item_for_ns_regimen.get(i+1));
					
						for(int j=0;j<applicablList.size();j=j+2){
							count1=1;
							String code		=(String)applicablList.get(j);
							System.out.println(count1+"inv_item_for_ns_regimen"+(String)inv_item_for_ns_regimen.get(i));
							     pstmt_insert3.setString(count1,(String)inv_item_for_ns_regimen.get(i));	
								pstmt_insert3.setString(++count1,(String)inv_item_for_ns_regimen.get(i+1));
								pstmt_insert3.setString(++count1,code);
								if(applicableMap.containsKey((String)inv_item_for_ns_regimen.get(i+1))){
									 pstmt_insert3.setString(++count1,(String)map1.get(code));
								}
								else{
									pstmt_insert3.setString(++count1,"N");
								}pstmt_insert3.setString(++count1,(String)common_values.get(0));	
								pstmt_insert3.setString(++count1,(String)common_values.get(1));			
								pstmt_insert3.setString(++count1,(String)common_values.get(2));
								pstmt_insert3.setString(++count1,(String)common_values.get(0));			
								pstmt_insert3.setString(++count1,(String)common_values.get(1));			
								pstmt_insert3.setString(++count1,(String)common_values.get(2));	
								pstmt_insert3.addBatch();
						}
					}//added for ml-mmoh-crf-1201 end
			}
			

					int[] result2= pstmt_insert2.executeBatch();
					for (int j=0;j<result2.length ;j++ ) {

						// A number greater than or equal to zero  indicates success
						// A number -2 indicates that command is successful but number of rows updated is unknow
						// If it won't satisfy any of the above cancel the statement and throw an exception
						if(result2[j]<0  && result2[j] != -2 ){
							pstmt_insert2.cancel();
							throw new EJBException("Insert Failed");
						}			
					}
					//added for ml-mmoh-crf-1201 start
					int[] result3= pstmt_insert3.executeBatch();
					for (int j=0;j<result3.length ;j++ ) {

						// A number greater than or equal to zero  indicates success
						// A number -2 indicates that command is successful but number of rows updated is unknow
						// If it won't satisfy any of the above cancel the statement and throw an exception
						if(result3[j]<0  && result3[j] != -2 ){
							pstmt_insert3.cancel();
							throw new EJBException("Applicubility Insert Failed");
						}			
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
				closeStatement( pstmt_insert3 ) ; //common-icn-0029
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

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap modify( HashMap tabData, HashMap sqlMap )  {	
	
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		map.put( "flag", "0" ) ;
		map.put( "msgid", "inside Modify" ) ;
		String SQL_PH_TPN_CONS_NS_REGIMEN_INSERT1 = (String)sqlMap.get("SQL_PH_TPN_CONS_NS_REGIMEN_INSERT1");
		String SQL_PH_TPN_CONS_NS_REGIMEN_INSERT2 = (String)sqlMap.get("SQL_PH_TPN_CONS_NS_REGIMEN_INSERT2");
		String SQL_PH_TPN_CONS_NS_REGIMEN_DELETE  = (String)sqlMap.get("SQL_PH_TPN_CONS_NS_REGIMEN_DELETE");
		String SQL_PH_TPN_CONS_NS_REGIMEN_DELETE1  = (String)sqlMap.get("SQL_PH_TPN_CONS_NS_REGIMEN_DELETE1");
//		String SQL_PH_TPN_CONS_NS_REGIMEN_UPDATE  = (String)sqlMap.get("SQL_PH_TPN_CONS_NS_REGIMEN_UPDATE");
 	   SQL_PH_TPN_CONS_NS_REGIMEN_SELECT5 = (String)sqlMap.get("SQL_PH_TPN_CONS_NS_REGIMEN_SELECT5");
 	    String SQL_PH_TPN_CONS_NS_REGIMEN_INSERT_APPLICABILITY  = (String)sqlMap.get("SQL_PH_TPN_CONS_NS_REGIMEN_INSERT_APPLICABILITY");//added for ml-mmoh-crf-1201
		String SQL_PH_TPN_CONS_NS_REGIMEN_DELETE_APPLICABILITY  = (String)sqlMap.get("SQL_PH_TPN_CONS_NS_REGIMEN_DELETE_APPLICABILITY");//added for ml-mmoh-crf-1201
		ArrayList common_values           = (ArrayList)tabData.get("common_values");
		ArrayList tpn_const_for_ns_regimen= (ArrayList)tabData.get("tpn_const_for_ns_regimen");
		ArrayList inv_item_for_ns_regimen = (ArrayList)tabData.get("inv_item_for_ns_regimen");
		ArrayList exsting_items = (ArrayList)tabData.get("exsting_items");
		prop = (Properties)tabData.get("properties");

		Connection connection = null ;
		PreparedStatement pstmt_insert=null,pstmt_delete = null,pstmt_delete1 = null, pstmt_insert1 = null ,pstmt_delete2 = null, pstmt_insert2 = null;//added for ml-mmoh-crf-1201
		//added for ml-mmoh-crf-1201 start
		ArrayList applicablList           = (ArrayList)tabData.get("applicablList");
		HashMap applicableMap =  (HashMap)tabData.get("applicableMap");
		HashMap map1 = new HashMap() ;
		boolean site_bru=(Boolean) tabData.get("site_bru");
		int count1=0;
		//added for ml-mmoh-crf-1201end
//		int result2= 0;
		try {
			int count =1;
			connection = getConnection( prop ) ;

			pstmt_delete1 = connection.prepareStatement( SQL_PH_TPN_CONS_NS_REGIMEN_DELETE1 ) ;
			for(int i=0; i<exsting_items.size(); i++){
				pstmt_delete1.setString(1 ,(String)tpn_const_for_ns_regimen.get(0));
				pstmt_delete1.setString(2 ,(String)exsting_items.get(i));
				pstmt_delete1.addBatch();
			}
			
			int[] resultDelete = pstmt_delete1.executeBatch();
			
			for (int j=0;j<resultDelete.length ;j++ ){
						// A number greater than or equal to zero  indicates success
						// A number -2 indicates that command is successful but number of rows updated is unknown
						// If it won't satisfy any of the above cancel the statement and throw an exception
						if(resultDelete[j]<0  && resultDelete[j] != -2 ){
							pstmt_delete1.cancel();
							throw new EJBException("Delete Failed in tpn_const_for_ns_regimen");
						}			
			}
/*
			if(result2 < 0 ){
				throw new EJBException("Delete Failed in tpn_const_for_ns_regimen");
			}
*/

			pstmt_insert1 = connection.prepareStatement( SQL_PH_TPN_CONS_NS_REGIMEN_INSERT2 ) ;
			for (int i=0;i<inv_item_for_ns_regimen.size() ;i=i+8 ){//Changed 6 to 8 for ML-MMOH-CRF-1201
				count = 1;

				//pstmt_insert1.setString(count,getTPNConsNsRegimenSrlNo());			//CONST_SRL_NO
				pstmt_insert1.setString(count,(String)tpn_const_for_ns_regimen.get(0));			//CONST_GENERIC_CODE
				pstmt_insert1.setString(++count,(String)inv_item_for_ns_regimen.get(i+1));			//ITEM_CODE
				pstmt_insert1.setString(++count,(String)tpn_const_for_ns_regimen.get(1));			//CONST_SHORT_NAME
				pstmt_insert1.setString(++count,(String)tpn_const_for_ns_regimen.get(2));			//CONST_LONG_NAME
				pstmt_insert1.setString(++count,(String)tpn_const_for_ns_regimen.get(3));			//PHYSICAL_FORM
				pstmt_insert1.setString(++count,(String)tpn_const_for_ns_regimen.get(4));			//CONCENTRATION_PERCENT
				pstmt_insert1.setString(++count,(String)tpn_const_for_ns_regimen.get(5));			//MANUFACTURER_VAR_PERCENTAGE
				pstmt_insert1.setString(++count,(String)tpn_const_for_ns_regimen.get(6));			//EFF_STATUS
				pstmt_insert1.setString(++count,(String)common_values.get(0));			//ADDED_BY_ID
				pstmt_insert1.setString(++count,(String)common_values.get(1));			//ADDED_AT_WS_NO
				pstmt_insert1.setString(++count,(String)common_values.get(2));			//ADDED_FACILITY_ID
				pstmt_insert1.setString(++count,(String)common_values.get(0));			//MODIFIED_BY_ID
				pstmt_insert1.setString(++count,(String)common_values.get(1));			//MODIFIED_AT_WS_NO
				pstmt_insert1.setString(++count,(String)common_values.get(2));			//MODIFIED_FACILITY_ID
				pstmt_insert1.addBatch();

			}
			
			int[] result1= pstmt_insert1.executeBatch();
			//int result1= pstmt_insert1.executeUpdate();
		//	if(result1 < 0 ){
		//		throw new EJBException("Insert Failed");
		//	}
			for (int j=0;j<result1.length ;j++ ){
						// A number greater than or equal to zero  indicates success
						// A number -2 indicates that command is successful but number of rows updated is unknown
						// If it won't satisfy any of the above cancel the statement and throw an exception
						if(result1[j]<0  && result1[j] != -2 ){
							pstmt_insert1.cancel();
							throw new EJBException("Insert Failed in tpn_const_for_ns_regimen");
						}			
			}
		
/*
			pstmt_update = connection.prepareStatement( SQL_PH_TPN_CONS_NS_REGIMEN_UPDATE );
			for (int i=0;i<inv_item_for_ns_regimen.size() ;i=i+5 ){
					count = 1;

				pstmt_update.setString(count  ,(String)tpn_const_for_ns_regimen.get(2));				
				pstmt_update.setString(++count,(String)tpn_const_for_ns_regimen.get(3));			
				pstmt_update.setString(++count,(String)tpn_const_for_ns_regimen.get(4));			
				pstmt_update.setString(++count,(String)tpn_const_for_ns_regimen.get(5));			
				pstmt_update.setString(++count,(String)tpn_const_for_ns_regimen.get(6));			
				pstmt_update.setString(++count,(String)tpn_const_for_ns_regimen.get(7));			
				pstmt_update.setString(++count,(String)common_values.get(0));			//MODIFIED_BY_ID
				pstmt_update.setString(++count,(String)common_values.get(1));			//MODIFIED_AT_WS_NO
				pstmt_update.setString(++count,(String)common_values.get(2));			//MODIFIED_FACILITY_ID
				pstmt_update.setString(++count,(String)tpn_const_for_ns_regimen.get(0));
				//pstmt_update.setString(++count,(String)tpn_const_for_ns_regimen.get(1));
				pstmt_update.setString(++count,(String)inv_item_for_ns_regimen.get(i+1));
				pstmt_update.addBatch();
			}

			//int result1= pstmt_update.executeUpdate();
			//if(result1 < 0 ){
			//	throw new EJBException("Update Failed");
		//	}
		
			int[] result1= pstmt_update.executeBatch();
			for (int j=0;j<result1.length ;j++ ){
				// A number greater than or equal to zero  indicates success
				// A number -2 indicates that command is successful but number of rows updated is unknow
				// If it won't satisfy any of the above cancel the statement and throw an exception
				if(result1[j]<0  && result1[j] != -2 ){
					pstmt_insert.cancel();
					throw new EJBException("Insert Failed");
				}			
			}
*/

			pstmt_delete = connection.prepareStatement( SQL_PH_TPN_CONS_NS_REGIMEN_DELETE ) ;

			for(int i=0; i<exsting_items.size(); i++){
				pstmt_delete.setString(1 ,(String)tpn_const_for_ns_regimen.get(0));
				pstmt_delete.setString(2 ,(String)exsting_items.get(i));
				pstmt_delete.addBatch();
			}
			
			int[] resultDelete1 = pstmt_delete.executeBatch();
			
			for (int j=0;j<resultDelete1.length ;j++ ){
						// A number greater than or equal to zero  indicates success
						// A number -2 indicates that command is successful but number of rows updated is unknown
						// If it won't satisfy any of the above cancel the statement and throw an exception
						if(resultDelete1[j]<0  && resultDelete1[j] != -2 ){
							pstmt_delete.cancel();
							throw new EJBException("Delete Failed in ph_inv_tpn_for_cons_regimen");
						}			
			}

/*
			pstmt_delete.setString(1 ,(String)tpn_const_for_ns_regimen.get(0));
			result2= pstmt_delete.executeUpdate();
			if(result2 < 0 ){
				throw new EJBException("Delete Failed in ph_inv_tpn_for_cons_regimen");
			}
*/		   //added for ml-mmoh-crf-1201 start
 pstmt_delete2=connection.prepareStatement( SQL_PH_TPN_CONS_NS_REGIMEN_DELETE_APPLICABILITY ) ;
			for(int i=0; i<exsting_items.size(); i++){
				pstmt_delete2.setString(1 ,(String)tpn_const_for_ns_regimen.get(0));
				pstmt_delete2.setString(2 ,(String)exsting_items.get(i));
				pstmt_delete2.setString( 3,(String)common_values.get(2));
				pstmt_delete2.addBatch();
			}
			
			int[] resultDelete2 = pstmt_delete2.executeBatch();
			
			for (int j=0;j<resultDelete2.length ;j++ ){
						// A number greater than or equal to zero  indicates success
						// A number -2 indicates that command is successful but number of rows updated is unknown
						// If it won't satisfy any of the above cancel the statement and throw an exception
						if(resultDelete2[j]<0  && resultDelete2[j] != -2 ){
							pstmt_delete2.cancel();
							throw new EJBException("Delete Failed in ph_inv_tpn_for_cons_regimen");
						}			
			}
       pstmt_insert2=connection.prepareStatement( SQL_PH_TPN_CONS_NS_REGIMEN_INSERT_APPLICABILITY ) ;
	   //added for ml-mmoh-crf-1201 end

			pstmt_insert = connection.prepareStatement( SQL_PH_TPN_CONS_NS_REGIMEN_INSERT1 ) ;

			int srl_no = Integer.parseInt(getInvItemForNsRegimenSrlNo((String)inv_item_for_ns_regimen.get(0)));
//			for (int i=0;i<inv_item_for_ns_regimen.size() ;i=i+5 ){
			for (int i=0;i<inv_item_for_ns_regimen.size() ;i=i+8 ) {//Changed 6 to 8 for ML-MMOH-CRF-1201
					count = 1;
					pstmt_insert.setString(count, (srl_no++)+""  );		
					pstmt_insert.setString(++count,(String)inv_item_for_ns_regimen.get(i));	
					pstmt_insert.setString(++count,(String)inv_item_for_ns_regimen.get(i+1));		
					pstmt_insert.setString(++count,(String)inv_item_for_ns_regimen.get(i+2));		
					pstmt_insert.setString(++count,(String)inv_item_for_ns_regimen.get(i+3));		
					pstmt_insert.setString(++count,(String)common_values.get(0));			
					pstmt_insert.setString(++count,(String)common_values.get(1));			
					pstmt_insert.setString(++count,(String)common_values.get(2));			
					pstmt_insert.setString(++count,(String)common_values.get(0));			
					pstmt_insert.setString(++count,(String)common_values.get(1));			
					pstmt_insert.setString(++count,(String)common_values.get(2));	
					pstmt_insert.setString(++count,((String)inv_item_for_ns_regimen.get(i+5)).trim());	
					pstmt_insert.setString(++count,((String)inv_item_for_ns_regimen.get(i+4)).trim());
					pstmt_insert.setString(++count,((String)inv_item_for_ns_regimen.get(i+6)).trim());//Added for ML-MMOH-CRF-1201
					pstmt_insert.setString(++count,((String)inv_item_for_ns_regimen.get(i+7)).trim());//Added for ML-MMOH-CRF-1201
					pstmt_insert.addBatch();
				//added for ml-mmoh-crf-1201 start
					if(site_bru){
					
					map1 = (HashMap)applicableMap.get((String)inv_item_for_ns_regimen.get(i+1));
					System.out.println("map1"+map1+"inv_item_for_ns_regimen"+inv_item_for_ns_regimen);
					System.out.println("map1"+map1+"inv_item_for_ns_regimen"+(String)inv_item_for_ns_regimen.get(i));
					System.out.println("map1"+map1+"inv_item_for_ns_regimen"+(String)inv_item_for_ns_regimen.get(i+1));
					
						for(int j=0;j<applicablList.size();j=j+2){
							count1=1;
							String code		=(String)applicablList.get(j);
							System.out.println(count1+"inv_item_for_ns_regimen"+(String)inv_item_for_ns_regimen.get(i));
							pstmt_insert2.setString(count1,(String)inv_item_for_ns_regimen.get(i));	
							pstmt_insert2.setString(++count1,(String)inv_item_for_ns_regimen.get(i+1));
							pstmt_insert2.setString(++count1,code);
						if(applicableMap.containsKey((String)inv_item_for_ns_regimen.get(i+1))){
							 pstmt_insert2.setString(++count1,(String)map1.get(code));
						}
						else{
							pstmt_insert2.setString(++count1,"N");
						}
								pstmt_insert2.setString(++count1,(String)common_values.get(0));	
								pstmt_insert2.setString(++count1,(String)common_values.get(1));			
								pstmt_insert2.setString(++count1,(String)common_values.get(2));
								pstmt_insert2.setString(++count1,(String)common_values.get(0));			
								pstmt_insert2.setString(++count1,(String)common_values.get(1));			
								pstmt_insert2.setString(++count1,(String)common_values.get(2));	
								pstmt_insert2.addBatch();
						}
					}//added for ml-mmoh-crf-1201 end
			}
			int[] result3= pstmt_insert.executeBatch();
			for (int j=0;j<result3.length ;j++ ){
				// A number greater than or equal to zero  indicates success
				// A number -2 indicates that command is successful but number of rows updated is unknow
				// If it won't satisfy any of the above cancel the statement and throw an exception
				if(result3[j]<0  && result3[j] != -2 ){
					pstmt_insert.cancel();
					throw new EJBException("Insert Failed in ph_inv_tpn_for_cons_regimen");
				}			
			}//added for ml-mmoh-crf-1201 start
			int[] result4= pstmt_insert2.executeBatch();
			for (int j=0;j<result4.length ;j++ ){
				// A number greater than or equal to zero  indicates success
				// A number -2 indicates that command is successful but number of rows updated is unknow
				// If it won't satisfy any of the above cancel the statement and throw an exception
				if(result4[j]<0  && result4[j] != -2 ){
					pstmt_insert2.cancel();
					throw new EJBException("Insert Failed in ph_inv_tpn_for_cons_regimen");
				}			
			}//added for ml-mmoh-crf-1201 end
			
	
			
			map.put( "result", new Boolean( true ) ) ;
			map.put( "msgid", "RECORD_MODIFIED" ) ;
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
				closeStatement( pstmt_insert ) ;
				closeStatement( pstmt_delete ) ;
				closeStatement( pstmt_delete1 ) ;
				closeStatement( pstmt_insert1 ) ;
				closeStatement( pstmt_insert2 ) ;//common-icn-0029
				closeStatement( pstmt_delete2 ) ; //common-icn-0029
				
				closeConnection( connection,prop );
			} catch ( Exception fe ) {
				System.err.println( fe.getMessage() ) ;
				fe.printStackTrace() ;
				map.put( "msgid", fe.toString() ) ;
			}
		}
		map.put( "flag","0");
		return map ;
	 }
				  
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap delete( HashMap tabData, HashMap sqlMap )  {
		HashMap map = new HashMap() ;
		return map;
	}	
	
	public String getTPNConsNsRegimenSrlNo()throws Exception{
		String srl_no ="";
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			connection = getConnection(prop) ;
			pstmt = connection.prepareStatement( SQL_PH_TPN_CONS_NS_REGIMEN_SELECT6 );	
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null && resultSet.next() ) {
				srl_no = resultSet.getString("COUNT");
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
			}catch(Exception es){es.printStackTrace();
			}
		}
		return srl_no;
	}

	public String getInvItemForNsRegimenSrlNo(String generic_code)throws Exception{
		String srl_no ="";
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			connection = getConnection(prop) ;
			pstmt = connection.prepareStatement( SQL_PH_TPN_CONS_NS_REGIMEN_SELECT5 );	
			pstmt.setString(1,generic_code);
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null && resultSet.next() ) {
				srl_no = resultSet.getString("COUNT");
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
			}catch(Exception es){es.printStackTrace();
			}
		}
		return srl_no;
	}
}
