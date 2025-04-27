/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST.SuspendOrReinstate;

//import java.rmi.RemoteException;
import eST.Common.StEJBSessionAdapter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;
import java.util.HashMap;

/**
*
* @ejb.bean
*	name="SuspendOrReinstate"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="SuspendOrReinstate"
*	local-jndi-name="SuspendOrReinstate"
*	impl-class-name="eST.SuspendOrReinstate.SuspendOrReinstateManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eST.SuspendOrReinstate.SuspendOrReinstateLocal"
*	remote-class="eST.SuspendOrReinstate.SuspendOrReinstateRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eST.SuspendOrReinstate.SuspendOrReinstateLocalHome"
*	remote-class="eST.SuspendOrReinstate.SuspendOrReinstateHome"
*	generate= "local,remote"
*
*
*/


public class SuspendOrReinstateManager extends StEJBSessionAdapter {

//	HashMap hmData;
//	HashMap hmSQL;
//	HashMap	hmReturn;

//	Properties	properties	=	null;
//	String		stSQL		=	null;


	/** Dummy method
	*/
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap modify(HashMap hmDataValues, HashMap hmSQLValues) {//throws RemoteException{
		return getMessageHashMap(false);
	}

	/** Dummy method
	*/
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap delete( HashMap hmDataValues, HashMap hmSQLValues) {//throws RemoteException {
		return getMessageHashMap(false);
	}

	/**
	* Method, which is responsible for inserting the data in to the related tables
	* for the adjustStock transaction. This method will in turn call the other methods
	* to do the corresponding updates.
	* @param hmDataValues, the data to be inserted
	* @param hmSQLValues, the queries used for the corresponding updates
	* @return HashMap, the result and the messages
	*/
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap insert(HashMap hashmap, HashMap hmSQLValues) {

        Connection connection = null;

        HashMap hashmapHDrdata = new HashMap();
        HashMap hashmapHDrquery = new HashMap();
        HashMap hashmapResult = new HashMap();
        HashMap hashmapDtldata = new HashMap();
        HashMap hashmapDtlquery = new HashMap();
		HashMap hashmapHistrydata = new HashMap();
        HashMap hashmapHistryquery = new HashMap();


        Properties properties = null;
//        Object obj = null;

        hashmapResult.put("result", FALSE);
        try
        {
            properties = (Properties)hashmap.get("properties");
            connection = getConnection(properties);
            connection.setAutoCommit(false);

			ArrayList arrayControlData = (ArrayList)hashmap.get("ControlData");
			if(arrayControlData != null){
            String ControlQuery = (String)hmSQLValues.get("BatchControlSQL");
			hashmapDtldata.put("DATA",arrayControlData);
			hashmapDtlquery.put(BATCH_SQL,ControlQuery);
			hashmapResult =  operateBatch(connection, hashmapDtldata, hashmapDtlquery);
			throwExceptionWhenFailed(hashmapResult);
           }
			ArrayList arrayBatchData = (ArrayList)hashmap.get("BatchData");
			String BatchQuery = (String)hmSQLValues.get("ItemBatchSQL");
			hashmapHDrdata.put("DATA",arrayBatchData);
			hashmapHDrquery.put(BATCH_SQL,BatchQuery);
			hashmapResult =  operateBatch(connection, hashmapHDrdata, hashmapHDrquery);
			throwExceptionWhenFailed(hashmapResult);
			
			//Added by Rabbani #Bru_HIMS-CRF-111 Insert st_batch_status_upd_history on 13-AUG-13
			ArrayList arrayBatchStatusData = (ArrayList)hashmap.get("AlInsertBatchStatus");
			if(arrayBatchStatusData != null){ 
			String BatchStatusQuery = (String)hmSQLValues.get("InsertBatchStatusSQL");
			hashmapHistrydata.put("DATA",arrayBatchStatusData);
			hashmapHistryquery.put(BATCH_SQL,BatchStatusQuery);
			hashmapResult =  operateBatch(connection, hashmapHistrydata, hashmapHistryquery);
            throwExceptionWhenFailed(hashmapResult);
           }
		   //ends


            connection.commit();
        }
        catch(Exception exception)
        {
            try
            {
                connection.rollback();
                exception.printStackTrace();
            }
            catch(Exception exception1)
            {
                exception1.printStackTrace();
            }
            hashmapResult.put("result", FALSE);
            hashmapResult.put("msgid", exception.getMessage());
            hashmapResult.put("message", exception.toString());
        }
        finally
        {
            try
            {
                closeConnection(connection, properties);
            }
            catch(Exception exception3)
            {
                exception3.printStackTrace();
            }
        }
        return hashmapResult;
    }
}
