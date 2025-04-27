/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eSS.Group;

//import java.rmi.RemoteException;
import eSS.Common.SsEJBSessionAdapter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;
import java.util.HashMap;

/**
*
* @ejb.bean
*	name="Group"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="Group"
*	local-jndi-name="Group"
*	impl-class-name="eSS.Group.GroupManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSS.Group.GroupLocal"
*	remote-class="eSS.Group.GroupRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSS.Group.GroupLocalHome"
*	remote-class="eSS.Group.GroupHome"
*	generate= "local,remote"
*
*
*/
public class  GroupManager extends SsEJBSessionAdapter {

	protected void throwExceptionWhenFailed(HashMap hmResult) throws Exception{
		if(!((Boolean)hmResult.get(RESULT)).booleanValue()){
			throw new Exception((String)hmResult.get(MESSAGE));
		}
	}
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap delete( HashMap tabData, HashMap sqlMap )  {
		return new HashMap();
	}
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap insert(HashMap hmData, HashMap hmSQL)  {
		Connection	connection	=	null;
		HashMap		hmReturn	=	new HashMap();
		HashMap		hmResult	=	new HashMap();
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		ArrayList	alHdrData	=	new ArrayList();
		ArrayList	alDtlData	=	new ArrayList();
		ArrayList	alDtlRecords=	new ArrayList();
		Properties	properties	=	null;
		String		stSQL		=	null;

		hmReturn.put(RESULT,FALSE);

		try {
			properties			=	(Properties)	hmData.get("properties");
			connection			=	getConnection(properties);
			connection.setAutoCommit(false);

			alHdrData			=	(ArrayList)	hmData.get("HdrInsertData");
			stSQL				=	(String)	hmSQL.get ("HdrInsertSQL");
			
			hmArgData.put(DATA,alHdrData);
			hmArgSQL.put(INSERT_SQL,stSQL);

			hmReturn	=	insert(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);

			alDtlData	=	(ArrayList)		hmData.get("DtlInsertData");
			stSQL		=	(String)		hmSQL.get ("DtlInsertSQL");

			System.err.println("Before alDtlData: "+alDtlData);	
			for (int i=0; i<alDtlData.size();i++ ) {
				ArrayList	alDtlRecord	=	new ArrayList();
				HashMap hmRecord	=	(HashMap) alDtlData.get(i);
				alDtlRecord.add(alHdrData.get(0));
				alDtlRecord.add(hmRecord.get("ITEM_CODE"));
				alDtlRecord.add(hmRecord.get("ITEM_QTY"));
				alDtlRecord.add(alHdrData.get(22));
				alDtlRecord.add(alHdrData.get(23));
				alDtlRecord.add(alHdrData.get(24));
				alDtlRecord.add(alHdrData.get(22));
				alDtlRecord.add(alHdrData.get(23));
				alDtlRecord.add(alHdrData.get(24));
				
				alDtlRecords.add(alDtlRecord);
			}
			System.err.println("After alDtlRecords: "+alDtlRecords);	
			stSQL				=	(String)	hmSQL.get ("DtlInsertSQL");
			
			hmArgData.put(DATA,alDtlRecords);
			hmArgSQL.put(INSERT_SQL,stSQL);

			hmResult	=	insertBatch(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmResult);

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
	public HashMap modify(HashMap hmData, HashMap hmSQL) {
		Connection	connection	=	null;
		HashMap		hmReturn	=	new HashMap();
		HashMap		hmResult	=	new HashMap();
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		ArrayList	alHdrData	=	new ArrayList();
		ArrayList	alDtlData	=	new ArrayList();
		Properties	properties	=	null;
		String		stSQL		=	null;

		hmReturn.put(RESULT,FALSE);

		try {
			properties			=	(Properties)	hmData.get("properties");
			connection			=	getConnection(properties);
			connection.setAutoCommit(false);

			alHdrData			=	(ArrayList)	hmData.get("HdrModifyData");
			stSQL				=	(String)	hmSQL.get ("HdrModifySQL");
			
			hmArgData.put(DATA,alHdrData);
			hmArgSQL.put(UPDATE_SQL,stSQL);

			hmReturn	=	update(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);

			alDtlData	=	(ArrayList)		hmData.get("DtlModifyData");
			stSQL		=	(String)		hmSQL.get ("DtlModifySQL");


			for (int i=0; i<alDtlData.size();i++ ) {
				ArrayList	alDtlRecord	=	new ArrayList();
				hmResult.clear();
				HashMap hmRecord	=	(HashMap) alDtlData.get(i);
				if(hmRecord.get("MODE").toString().equals(MODE_INSERT)){
					alDtlRecord.add(alHdrData.get(24));
					alDtlRecord.add(hmRecord.get("ITEM_CODE"));
					alDtlRecord.add(hmRecord.get("ITEM_QTY"));
					alDtlRecord.add(alHdrData.get(21));
					alDtlRecord.add(alHdrData.get(22));
					alDtlRecord.add(alHdrData.get(23));
					alDtlRecord.add(alHdrData.get(21));
					alDtlRecord.add(alHdrData.get(22));
					alDtlRecord.add(alHdrData.get(23));

					stSQL				=	(String)	hmSQL.get ("DtlInsertSQL");
					hmArgData.put(DATA,alDtlRecord);
					hmArgSQL.put(INSERT_SQL,stSQL);
					hmResult	=	insert(connection, hmArgData, hmArgSQL);
				}
				else if(hmRecord.get("MODE").toString().equals(MODE_MODIFY)){
					alDtlRecord.add(new Long(hmRecord.get("ITEM_QTY").toString()));

					alDtlRecord.add(alHdrData.get(21));
					alDtlRecord.add(alHdrData.get(22));
					alDtlRecord.add(alHdrData.get(23));

					alDtlRecord.add(alHdrData.get(24));
					alDtlRecord.add(hmRecord.get("ITEM_CODE"));

					stSQL				=	(String)	hmSQL.get ("DtlModifySQL");
					hmArgData.put(DATA,alDtlRecord);
					hmArgSQL.put(UPDATE_SQL,stSQL);
					hmResult	=	update(connection, hmArgData, hmArgSQL);
				}
				else if(hmRecord.get("MODE").toString().equals(MODE_DELETE)){
					alDtlRecord.add(alHdrData.get(24));
					alDtlRecord.add(hmRecord.get("ITEM_CODE"));

					stSQL				=	(String)	hmSQL.get ("DtlDeleteSQL");
					hmArgData.put(DATA,alDtlRecord);
					hmArgSQL.put(DELETE_SQL,stSQL);
					hmResult	=	delete(connection, hmArgData, hmArgSQL);
				}
				else{
					hmResult.put(RESULT,FALSE);
					hmResult.put(MESSAGE,"Invalid Mode passed to EJB for detail at record # "+(i+1));
					hmResult.put(MSGID,"Invalid Mode");
				}
				throwExceptionWhenFailed(hmResult);
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
