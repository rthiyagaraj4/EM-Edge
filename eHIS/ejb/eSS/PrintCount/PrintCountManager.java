/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eSS.PrintCount;

//import java.rmi.RemoteException;
import eSS.Common.SsEJBSessionAdapter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;
import java.util.HashMap;

/**
*
* @ejb.bean
*	name="PrintCount"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="PrintCount"
*	local-jndi-name="PrintCount"
*	impl-class-name="eSS.PrintCount.PrintCountManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSS.PrintCount.PrintCountLocal"
*	remote-class="eSS.PrintCount.PrintCountRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSS.PrintCount.PrintCountLocalHome"
*	remote-class="eSS.PrintCount.PrintCountHome"
*	generate= "local,remote"
*
*
*/

public class  PrintCountManager extends SsEJBSessionAdapter {

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
		Connection	connection	=	null;
		HashMap		hmReturn	=	new HashMap();
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		ArrayList	alHdrData	=	new ArrayList();
		//ArrayList	alDtlData	=	new ArrayList();
		ArrayList	alGpHdrData	=	new ArrayList();
		Properties	properties	=	null;
		String		stSQL		=	null;

		hmReturn.put(RESULT,FALSE);

		try {
			properties			=	(Properties)	hmData.get("properties");
			connection			=	getConnection(properties);
			connection.setAutoCommit(false);

			alHdrData			=	(ArrayList)	hmData.get("HdrInsertData");
			stSQL		=	(String)		hmSQL.get ("InsertParamSQL");
			ArrayList	alDtlRecord	=	new ArrayList();
			
				alDtlRecord.add(alHdrData.get(0));
				alDtlRecord.add(alHdrData.get(1));
				alDtlRecord.add(alHdrData.get(2));
				alDtlRecord.add(alHdrData.get(3));
				alDtlRecord.add(alHdrData.get(4));
				alDtlRecord.add(alHdrData.get(5));
				alDtlRecord.add(alHdrData.get(6));
				alDtlRecord.add(alHdrData.get(7));
				alDtlRecord.add(alHdrData.get(8));
				alDtlRecord.add(alHdrData.get(9));
				alDtlRecord.add(alHdrData.get(10));
				alDtlRecord.add(alHdrData.get(8));
				alDtlRecord.add(alHdrData.get(9));
				alDtlRecord.add(alHdrData.get(10));
				//System.err.println("before first Statement ");
				hmArgData.put(DATA,alDtlRecord);
				hmArgSQL.put(INSERT_SQL,stSQL);
				hmReturn	=	insert(connection, hmArgData, hmArgSQL);
				//System.err.println("After the Statement "+hmReturn);
				throwExceptionWhenFailed(hmReturn);
				
				stSQL		=	(String)		hmSQL.get ("InsertHdrSQL");
				
				alGpHdrData.add(alHdrData.get(8));
				alGpHdrData.add(alHdrData.get(9));
				alGpHdrData.add(alHdrData.get(10));
				alGpHdrData.add(alHdrData.get(8));
				alGpHdrData.add(alHdrData.get(9));
				alGpHdrData.add(alHdrData.get(10));
				alGpHdrData.add(alHdrData.get(10));
				alGpHdrData.add(alHdrData.get(1));
		//System.err.println("before second Statement ");
				hmArgData.put(DATA,alGpHdrData);
				hmArgSQL.put(INSERT_SQL,stSQL);
				hmReturn	=	insert(connection, hmArgData, hmArgSQL);

			//System.err.println("after second Statement "+hmReturn);	
		
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

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap modify(HashMap hmData, HashMap hmSQL){// throws RemoteException{
				return getMessageHashMap(false);
	}
}
