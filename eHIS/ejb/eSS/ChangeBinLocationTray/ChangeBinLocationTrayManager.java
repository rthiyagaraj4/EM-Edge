/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eSS.ChangeBinLocationTray;

//import java.rmi.RemoteException;
import eSS.Common.SsEJBSessionAdapter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;
import java.util.HashMap;

/**
*
* @ejb.bean
*	name="ChangeBinLocationTray"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ChangeBinLocationTray"
*	local-jndi-name="ChangeBinLocationTray"
*	impl-class-name="eSS.ChangeBinLocationTray.ChangeBinLocationTrayManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSS.ChangeBinLocationTray.ChangeBinLocationTrayLocal"
*	remote-class="eSS.ChangeBinLocationTray.ChangeBinLocationTrayRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSS.ChangeBinLocationTray.ChangeBinLocationTrayLocalHome"
*	remote-class="eSS.ChangeBinLocationTray.ChangeBinLocationTrayHome"
*	generate= "local,remote"
*
*
*/

public class  ChangeBinLocationTrayManager extends SsEJBSessionAdapter {

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap delete( HashMap hmData, HashMap hmSQL ) {
		return getMessageHashMap(false);
	}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap insert(HashMap hmData, HashMap hmSQL) {
		return getMessageHashMap(false);
	}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap modify(HashMap hmData, HashMap hmSQL){// throws RemoteException{
		Connection	connection	=	null;
		HashMap		hmReturn	=	new HashMap();
//		HashMap		hmResult	=	new HashMap();
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		
		ArrayList	alDtlData	=	new ArrayList();
		Properties	properties	=	null;
		String		stSQL		=	null;

		hmReturn.put(RESULT,FALSE);

		try {
			properties			=	(Properties)	hmData.get("properties");
			connection			=	getConnection(properties);
			connection.setAutoCommit(false);

		

			alDtlData	=	(ArrayList)		hmData.get("ModifyData");
			stSQL		=	(String)		hmSQL.get ("ModifySQL");

			//System.err.println("stSQL"+stSQL);
			
				hmArgData.put(DATA,alDtlData);
				hmArgSQL.put(INSERT_SQL,stSQL);
				hmReturn	=	insertBatch(connection, hmArgData, hmArgSQL);

				throwExceptionWhenFailed(hmReturn);
			
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
