/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST.CancelCountSheet;

//import java.rmi.RemoteException;
import eST.Common.StEJBSessionAdapter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;
import java.util.HashMap;




/**
*
* @ejb.bean
*	name="CancelCountSheet"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="CancelCountSheet"
*	local-jndi-name="CancelCountSheet"
*	impl-class-name="eST.CancelCountSheet.CancelCountSheetManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eST.CancelCountSheet.CancelCountSheetLocal"
*	remote-class="eST.CancelCountSheet.CancelCountSheetRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eST.CancelCountSheet.CancelCountSheetLocalHome"
*	remote-class="eST.CancelCountSheet.CancelCountSheetHome"
*	generate= "local,remote"
*
*
*/
public class CancelCountSheetManager extends StEJBSessionAdapter {

	HashMap hmData;
	HashMap hmSQL;
	HashMap	hmReturn;
	Properties	properties	=	null;
	//String		stSQL		=	null;
	int size;

	
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap modify(HashMap hmDataValues, HashMap hmSQLValues) {
		return getMessageHashMap(false);
	}

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap delete( HashMap hmDataValues, HashMap hmSQLValues)  {
		return getMessageHashMap(false);
	}
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap insert(HashMap hmDataValues, HashMap hmSQLValues) {

	

		Connection connection = null;
		hmData			= hmDataValues;
		hmSQL			= hmSQLValues;
		hmReturn		= new HashMap();
		//HashMap hmResult = new HashMap();

		try {
			properties					=	(Properties)	hmData.get("properties");
			
			connection					=	getConnection(properties);
			connection.setAutoCommit(false);

			ArrayList st_phy_delete 		= (ArrayList) hmDataValues.get("st_phy_delete");
			ArrayList st_hdr_delete		= (ArrayList) hmDataValues.get("st_hdr_delete");

			ArrayList st_can_cnt		= (ArrayList) hmDataValues.get("st_can_cnt");
			ArrayList store_delete		= (ArrayList) hmDataValues.get("store_delete");
			ArrayList item_delete			= (ArrayList) hmDataValues.get("item_delete");
			String stPhy_inv_id=null;
			String stFacility_id=null;

			HashMap hmCommonData			= (HashMap) hmDataValues.get("CommonData");

// Added on 1/20/2005 for inserting records into cancel count sheet table
			
			
			size = st_can_cnt.size();
			String stSQL11 = (String)hmSQL.get ("SQL_ST_CANC_PHY_INV_ITEMS");			
			
			//  INSERT INTO ST_CANC_PHY_INV_ITEMS

			ArrayList alTempData11 = new ArrayList();
			for(int i=0;i<size;i++) {
				HashMap hmRecord = (HashMap) st_can_cnt.get(i);
				ArrayList alExpiredBatch = new ArrayList();
				alExpiredBatch.add(hmRecord.get("facility_id"));
				alExpiredBatch.add(hmRecord.get("PHY_INV_ID"));
				alExpiredBatch.add(hmRecord.get("STORE_CODE"));
				alExpiredBatch.add(hmRecord.get("ITEM_CODE"));
				alExpiredBatch.add(hmRecord.get("PHY_INV_DATE"));
				alExpiredBatch.add(hmCommonData.get("login_by_id"));
				alExpiredBatch.add(hmCommonData.get("login_at_ws_no"));
				alExpiredBatch.add(hmCommonData.get("login_facility_id"));
				alExpiredBatch.add(hmCommonData.get("login_by_id"));
				alExpiredBatch.add(hmCommonData.get("login_at_ws_no"));
				alExpiredBatch.add(hmCommonData.get("login_facility_id"));
				alTempData11.add(alExpiredBatch);
			
			}
				HashMap hmInsertData11	=	new HashMap();
				HashMap hmSql11			=	new HashMap();
				hmInsertData11.put(DATA,alTempData11);
				hmSql11.put(BATCH_SQL,stSQL11);
				hmReturn =  operateBatch(connection, hmInsertData11, hmSql11);

				throwExceptionWhenFailed(hmReturn);



// End of 1/20/2005



			//ArrayList deleteDetailsData = new ArrayList();
			
			
			size = st_phy_delete.size();
		
			String stSQL1 = (String)hmSQL.get ("phy_inv_dtl_delete");			
		
			
			//DELETE FROM st_phy_inv_dtl WHERE facility_id= ? AND phy_inv_id= ? AND store_code= ? AND item_code= ?

			ArrayList alTempData1 = new ArrayList();

			for(int i=0;i<size;i++) {
				HashMap hmRecord = (HashMap) st_phy_delete.get(i);

				ArrayList alExpiredBatch = new ArrayList();

				alExpiredBatch.add(hmRecord.get("facility_id"));
				alExpiredBatch.add(hmRecord.get("PHY_INV_ID"));
				alExpiredBatch.add(hmRecord.get("STORE_CODE"));
				alExpiredBatch.add(hmRecord.get("ITEM_CODE"));
				stPhy_inv_id=(String)hmRecord.get("PHY_INV_ID");
				stFacility_id=(String)hmRecord.get("facility_id");
				alTempData1.add(alExpiredBatch);
			
			}
				HashMap hmInsertData1	=	new HashMap();
				HashMap hmSql1			=	new HashMap();
				hmInsertData1.put(DATA,alTempData1);
				hmSql1.put(BATCH_SQL,stSQL1);
				
				hmReturn =  operateBatch(connection, hmInsertData1, hmSql1);

				throwExceptionWhenFailed(hmReturn);


   			//DELETE FROM st_phy_inv_dtl WHERE facility_id= ? AND phy_inv_id= ? AND store_code= ? AND item_code= ?
			size = st_hdr_delete.size();
			
			ArrayList alTempData2 = new ArrayList();

			String stSQL2 = (String)hmSQL.get ("phy_inv_hdr_delete");
			
				ArrayList alExpiredBatch=null;
				HashMap hmRecord =null;
				for(int i=0;i<size;i++) {
				hmRecord = (HashMap) st_hdr_delete.get(i);
				alExpiredBatch = new ArrayList ();
				alExpiredBatch.add(hmRecord.get("facility_id"));
				alExpiredBatch.add(hmRecord.get("PHY_INV_ID"));
				alExpiredBatch.add(hmRecord.get("STORE_CODE"));
				alExpiredBatch.add(hmRecord.get("ITEM_CODE"));
			
				alTempData2.add(alExpiredBatch);
			
			
			}


			HashMap hmInsertData2	=	new HashMap();
			HashMap hmSql2			=	new HashMap();
			hmInsertData2.put(DATA,alTempData2);
			hmSql2.put(BATCH_SQL,stSQL2);
			hmReturn =  operateBatch(connection, hmInsertData2, hmSql2);
			throwExceptionWhenFailed(hmReturn);
			//UPDATE st_item_batch SET phy_inv_id=NULL, phy_inv_start_qty=NULL, phy_inv_start_date=NULL WHERE phy_inv_id= ?  AND store_code= ? AND item_code= ?


			String stSQL3 = (String)hmSQL.get ("store_batch_update");
		
		
			ArrayList alTempData3	= new ArrayList();
			size = store_delete.size();

				for(int i=0;i<size;i++) {
				hmRecord = (HashMap) store_delete.get(i);
				alExpiredBatch = new ArrayList ();
				alExpiredBatch.add(hmCommonData.get("login_by_id"));
				alExpiredBatch.add(hmCommonData.get("login_at_ws_no"));
				alExpiredBatch.add(hmCommonData.get("login_facility_id"));
				alExpiredBatch.add(hmRecord.get("PHY_INV_ID"));
				alExpiredBatch.add(hmRecord.get("STORE_CODE"));
				alExpiredBatch.add(hmRecord.get("ITEM_CODE"));
				
				alTempData3.add(alExpiredBatch);

				
			}
				HashMap hmInsertData3	=	new HashMap();
				HashMap hmSql3			=	new HashMap();
				hmInsertData3.put(DATA,alTempData3);
				hmSql3.put(BATCH_SQL,stSQL3);
			hmReturn =  operateBatch(connection, hmInsertData3, hmSql3);
			throwExceptionWhenFailed(hmReturn);



			//UPDATE st_item_store SET phy_inv_id=NULL, phy_inv_start_qty=NULL, phy_inv_start_date=NULL WHERE phy_inv_id= ?  AND store_code= ? AND item_code= ? 



			String stSQL4 = (String)hmSQL.get ("item_batch_update");
			
	
			ArrayList alTempData4	= new ArrayList();
			int size = item_delete.size();

				for(int i=0;i<size;i++) {
				hmRecord = (HashMap) item_delete.get(i);
				alExpiredBatch = new ArrayList ();
				alExpiredBatch.add(hmCommonData.get("login_by_id"));
				alExpiredBatch.add(hmCommonData.get("login_at_ws_no"));
				alExpiredBatch.add(hmCommonData.get("login_facility_id"));
				alExpiredBatch.add(hmRecord.get("PHY_INV_ID"));
				alExpiredBatch.add(hmRecord.get("STORE_CODE"));
				alExpiredBatch.add(hmRecord.get("ITEM_CODE"));
				alTempData4.add(alExpiredBatch);
				
				
			}
				HashMap hmInsertData4	=	new HashMap();
				HashMap hmSql4			=	new HashMap();
				hmInsertData4.put(DATA,alTempData4);
				hmSql4.put(BATCH_SQL,stSQL4);
			hmReturn =  operateBatch(connection, hmInsertData4, hmSql4);
			throwExceptionWhenFailed(hmReturn);

			
		String []stParameters=	{stFacility_id, stPhy_inv_id};

			HashMap hmCountHDR=fetchRecord(connection,(String)hmSQL.get("SQL_ST_PHY_INV_HDR_SELECT_COUNT"), stParameters);
			HashMap hmCountDTL=fetchRecord(connection,(String)hmSQL.get("SQL_ST_PHY_INV_DTL_SELECT_COUNT"), stParameters);

			if (hmCountHDR.get("TOTAL").equals("0")&&hmCountDTL.get("TOTAL").equals("0")) {

			String stSQL5 = (String)hmSQL.get ("SQL_ST_PHY_INV_PARAM_UPDATE_FOR_CANCEL");
			
	
			ArrayList alTempData5	= new ArrayList();
			int size1 = item_delete.size();

				for(int i=0;i<size1;i++) {
				hmRecord = (HashMap) item_delete.get(i);
				alExpiredBatch = new ArrayList ();
				alExpiredBatch.add(hmCommonData.get("login_by_id"));
				alExpiredBatch.add(hmCommonData.get("login_at_ws_no"));
				alExpiredBatch.add(hmCommonData.get("login_facility_id"));
				alExpiredBatch.add(hmCommonData.get("login_facility_id"));
				alExpiredBatch.add(hmRecord.get("PHY_INV_ID"));
				alTempData5.add(alExpiredBatch);
			}
				HashMap hmInsertData5	=	new HashMap();
				HashMap hmSql5			=	new HashMap();
				hmInsertData5.put(DATA,alTempData5);
				hmSql5.put(BATCH_SQL,stSQL5);
			hmReturn =  operateBatch(connection, hmInsertData5, hmSql5);
			throwExceptionWhenFailed(hmReturn);


			}



			connection.commit();
		}
		catch(Exception exception) {
			try {
				connection.rollback();
				exception.printStackTrace();
			}
			catch (Exception subException) {
				subException.printStackTrace();
			}
			hmReturn.put(RESULT,FALSE);
			hmReturn.put(MSGID,exception.getMessage());
			hmReturn.put(MESSAGE,exception.toString());
		}
		finally{
			try{
				closeConnection( connection, properties );
			}
			catch (Exception exception){
				exception.printStackTrace();
			}
		}
		return hmReturn;
	}

}
