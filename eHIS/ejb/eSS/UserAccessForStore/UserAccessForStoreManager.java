/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eSS.UserAccessForStore;

//import java.rmi.RemoteException;
import eSS.Common.SsEJBSessionAdapter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;
import java.util.HashMap;



/**
*
* @ejb.bean
*	name="UserAccessForStore"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="UserAccessForStore"
*	local-jndi-name="UserAccessForStore"
*	impl-class-name="eSS.UserAccessForStore.UserAccessForStoreManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSS.UserAccessForStore.UserAccessForStoreLocal"
*	remote-class="eSS.UserAccessForStore.UserAccessForStoreRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSS.UserAccessForStore.UserAccessForStoreLocalHome"
*	remote-class="eSS.UserAccessForStore.UserAccessForStoreHome"
*	generate= "local,remote"
*
*
*/


public class  UserAccessForStoreManager extends SsEJBSessionAdapter {
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
public HashMap delete( HashMap hmData, HashMap hmSQL )  {
		return getMessageHashMap(false);
	}
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap modify(HashMap hmData, HashMap hmSQL) {
		Connection	connection	=	null;
		HashMap		hmReturn	=	new HashMap();
//		HashMap		hmResult	=	new HashMap();
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		ArrayList	alData		=	new ArrayList();
		Properties	properties	=	null;
		String		stSQL		=	null;

		hmReturn.put(RESULT,FALSE);
		hmReturn.put(MESSAGE,"No Record to Process..");
		hmReturn.put(MSGID,"NO_RECORD_TO_PROCESS");

		try {
			properties			=	(Properties)	hmData.get("properties");
			connection			=	getConnection(properties);
			connection.setAutoCommit(false);

			alData				=	(ArrayList)	hmData.get("InsertData");
			stSQL				=	(String)	hmSQL.get ("InsertSQL");
			/*if(alData.size()>0){
				hmArgData.put(DATA,alData);
				hmArgSQL.put(INSERT_SQL,stSQL);
				hmReturn	=	insertBatch(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmReturn);
			}*/

			alData			=	(ArrayList)	hmData.get("UpdateData");
			stSQL				=	(String)	hmSQL.get ("UpdateSQL");
			if(alData.size()>0){
				hmArgData.put(DATA,alData);
				hmArgSQL.put(INSERT_SQL,stSQL);
				hmReturn	=	insertBatch(connection, hmArgData, hmArgSQL);
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
		//return getMessageHashMap(false);
//	}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap insert(HashMap hmData, HashMap hmSQL)  {
		Connection	connection	=	null;
		HashMap		hmReturn	=	new HashMap();
//		HashMap		hmResult	=	new HashMap();
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		ArrayList	alData		=	new ArrayList();
		Properties	properties	=	null;
		String		stSQL		=	null;

		hmReturn.put(RESULT,FALSE);
		hmReturn.put(MESSAGE,"No Record to Process..");
		hmReturn.put(MSGID,"NO_RECORD_TO_PROCESS");

		try {
			properties			=	(Properties)	hmData.get("properties");
			connection			=	getConnection(properties);
			connection.setAutoCommit(false);

			alData			=	(ArrayList)	hmData.get("InsertData");
			stSQL				=	(String)	hmSQL.get ("InsertSQL");
			if(alData.size()>0){
				hmArgData.put(DATA,alData);
				hmArgSQL.put(INSERT_SQL,stSQL);
				hmReturn	=	insertBatch(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmReturn);
			}

			alData			=	(ArrayList)	hmData.get("UpdateData");
			stSQL				=	(String)	hmSQL.get ("UpdateSQL");
			if(alData.size()>0){
				hmArgData.put(DATA,alData);
				hmArgSQL.put(INSERT_SQL,stSQL);
				hmReturn	=	insertBatch(connection, hmArgData, hmArgSQL);
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
