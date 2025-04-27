/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST.ChangeExpiryFlag;

//import java.rmi.RemoteException;
import eST.Common.StEJBSessionAdapter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;
import java.util.HashMap;

/**
*
* @ejb.bean
*	name="ChangeExpiryFlag"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ChangeExpiryFlag"
*	local-jndi-name="ChangeExpiryFlag"
*	impl-class-name="eST.ChangeExpiryFlag.ChangeExpiryFlagManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eST.ChangeExpiryFlag.ChangeExpiryFlagLocal"
*	remote-class="eST.ChangeExpiryFlag.ChangeExpiryFlagRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eST.ChangeExpiryFlag.ChangeExpiryFlagLocalHome"
*	remote-class="eST.ChangeExpiryFlag.ChangeExpiryFlagHome"
*	generate= "local,remote"
*
*
*/

public class ChangeExpiryFlagManager extends StEJBSessionAdapter {

	HashMap hmData;
	HashMap hmSQL;
	HashMap	hmReturn;
	Properties	properties	=	null;

	/* Variables which are needed to call the routines to update the online-store and 
	other tables.	
	*/

/*	String finalized_yn="";

	String item_code					= "";
	String store_code					= "";
	String trn_type						= "";
	String trn_qty						= "";
	String trn_cost						= "";
	String trn_value					= "";	

	String trade_id						= "";
	String bin_location_code			= "";
	String expiry_date_or_receipt_date	= "";
	String suspended_batch_allowed_yn	= "";
	String batch_id						= "";

	String		stSQL		=	null;*/


	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap insert(HashMap hmDataValues, HashMap hmSQLValues) {//throws RemoteException{
		return getMessageHashMap(false);
	}

	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap delete( HashMap hmDataValues, HashMap hmSQLValues) {//throws RemoteException {
		return getMessageHashMap(false);
	}

	/*
	 Method, which is responsible for inserting the data in to the related tables
	 for the adjustStock transaction. This method will in turn call the other methods
	 to do the corresponding updates.
	 @param hmDataValues, the data to be inserted
	 @param hmSQLValues, the queries used for the corresponding updates
	 @return HashMap, the result and the messages
	*/
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap modify(HashMap hmDataValues, HashMap hmSQLValues) { //throws RemoteException

		Connection	connection	=	null;


		hmData		= hmDataValues;
		hmSQL		= hmSQLValues;

		hmReturn	=	new HashMap();		

		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();


//		ArrayList	alCommonData;
		hmReturn.put(RESULT,FALSE);

		try {
			properties			=	(Properties)	hmData.get("properties");
			connection			=	getConnection(properties);
			connection.setAutoCommit(false);

			ArrayList	StItemUpdateData			=	new ArrayList();
			ArrayList	ALBatchControlUpdateData	=	new ArrayList();
			ArrayList	alBatchControlInsertData	=	new ArrayList();//NMC-JD-SCF-0261
			String		stSQL						=	null;
//st_item
			StItemUpdateData	=	(ArrayList)	hmData.get("StItemUpdateData");
//st_item_batch			
//			ArrayList	ALBatchUpdateData	=	(ArrayList)	hmData.get("alBatchUpdateData");
			ArrayList	ALBatchDeleteData	=	(ArrayList)	hmData.get("alBatchDeleteData");
			ArrayList	ALBatchInsertData	=	(ArrayList)	hmData.get("alBatchInsertData");
//st_batch_control			
			ALBatchControlUpdateData	=	(ArrayList)	hmData.get("alBatchControlUpdateData");
		//	ALBatchControlDeleteDataRows			=	(ArrayList)	hmData.get("BatchControlDeleteData");
			alBatchControlInsertData = (ArrayList)	hmData.get("alBatchControlInsertData");//NMC-JD-SCF-0261 

			stSQL	=	(String)hmSQL.get ("StItemUpdateSQL");
			hmArgData.put(DATA,StItemUpdateData);
			hmArgSQL.put(UPDATE_SQL,stSQL);
			hmReturn	=	update(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);

// logic of batch_id applicable updation added on Friday, November 14, 2003 by manish
			stSQL	=	(String)hmSQL.get ("SQL_ST_ITEM_UPDATE_BATCH_ID_FOR_CHANGE_EXPIRY");
			StItemUpdateData.remove(0);//remove expiry_yn
			hmArgData.put(DATA,StItemUpdateData);
			hmArgSQL.put(UPDATE_SQL,stSQL);
			hmReturn	=	update(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
//batch update
			if (ALBatchDeleteData.size()>0) {
				stSQL		=	(String)hmSQL.get ("StBatchDeleteSQL");
				hmArgData.put(DATA,ALBatchDeleteData);
				hmArgSQL.put(BATCH_SQL,stSQL);
				hmReturn	=	operateBatch(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmReturn);
			}
			//added for NMC-JD-SCF-0261
			if (alBatchControlInsertData.size()>0) {
				stSQL		=	(String)hmSQL.get ("StBatchControlInsertSQL");
				hmArgData.put(DATA,alBatchControlInsertData);
				hmArgSQL.put(BATCH_SQL,stSQL);
				hmReturn	=	operateBatch(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmReturn);
			}
			if (ALBatchControlUpdateData.size()>0) {
				stSQL		=	(String)hmSQL.get ("StBatchControlUpdateSQL");
				hmArgData.put(DATA,ALBatchControlUpdateData);
				hmArgSQL.put(BATCH_SQL,stSQL);
				hmReturn	=	operateBatch(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmReturn);
			}

			if (ALBatchInsertData.size()>0) {
				stSQL		=	(String)hmSQL.get ("StBatchInsertSQL");
				hmArgData.put(DATA,ALBatchInsertData);
				hmArgSQL.put(BATCH_SQL,stSQL);
				hmReturn	=	operateBatch(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmReturn);
			}
			connection.commit();
        }
		catch(Exception exception) 
		{
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
