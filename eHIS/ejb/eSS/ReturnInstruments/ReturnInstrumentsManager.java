/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eSS.ReturnInstruments;

//import java.rmi.RemoteException;
import eSS.Common.SsEJBSessionAdapter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
*
* @ejb.bean
*	name="ReturnInstruments"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="ReturnInstruments"
*	local-jndi-name="ReturnInstruments"
*	impl-class-name="eSS.ReturnInstruments.ReturnInstrumentsManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSS.ReturnInstruments.ReturnInstrumentsLocal"
*	remote-class="eSS.ReturnInstruments.ReturnInstrumentsRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSS.ReturnInstruments.ReturnInstrumentsLocalHome"
*	remote-class="eSS.ReturnInstruments.ReturnInstrumentsHome"
*	generate= "local,remote"
*
*
*/

public class  ReturnInstrumentsManager extends SsEJBSessionAdapter {

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/


	public HashMap delete( HashMap hmData, HashMap hmSQL ) {
		Connection	connection	=	null;
		HashMap		hmReturn	=	new HashMap();
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		ArrayList	alDeleteData=	new ArrayList();
		Properties	properties	=	null;
		String		stSQL		=	null;

		hmReturn.put(RESULT,FALSE);
		try {
			properties			=	(Properties)	hmData.get("properties");
			connection			=	getConnection(properties);
			connection.setAutoCommit(false);

			alDeleteData		=	(ArrayList)	hmData.get("DeleteData");
			stSQL				=	(String)	hmSQL.get ("DtlDeleteSQL");
															
			hmArgData.put(DATA,alDeleteData);
			hmArgSQL.put(DELETE_SQL,stSQL);

			hmReturn	=	delete(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);

			alDeleteData		=	(ArrayList)	hmData.get("DeleteData");
			stSQL				=	(String)	hmSQL.get ("HdrDeleteSQL");
			
			hmArgData.put(DATA,alDeleteData);
			hmArgSQL.put(DELETE_SQL,stSQL);

			hmReturn	=	delete(connection, hmArgData, hmArgSQL);
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


	public HashMap insert(HashMap hmData, HashMap hmSQL) {
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

			for (int i=0; i<alDtlData.size();i++ ) {
				ArrayList	alDtlRecord	=	new ArrayList();
				HashMap hmRecord	=	(HashMap) alDtlData.get(i);
				StringTokenizer stGroupTrayItem=	new StringTokenizer((String)hmRecord.get("item_code"),"|");//21052    
				String stGroup_code	=	stGroupTrayItem.nextToken();
				String stTray_no	=	stGroupTrayItem.nextToken();
				String stItem_code	=	stGroupTrayItem.nextToken();
				alDtlRecord.add(alHdrData.get(0));
				alDtlRecord.add(alHdrData.get(1));
				alDtlRecord.add(alHdrData.get(2));
				alDtlRecord.add(stItem_code);
				alDtlRecord.add(hmRecord.get("contaminated_yn"));
				alDtlRecord.add(hmRecord.get("remarks"));
				alDtlRecord.add(hmRecord.get("ret_item_qty"));
				alDtlRecord.add(hmRecord.get("ret_item_cost"));
				alDtlRecord.add(hmRecord.get("damaged_yn"));
				alDtlRecord.add(stGroup_code);
				alDtlRecord.add(stTray_no);
				alDtlRecord.add(alHdrData.get(10));
				alDtlRecord.add(alHdrData.get(11));
				alDtlRecord.add(alHdrData.get(12));
				alDtlRecord.add(alHdrData.get(10));
				alDtlRecord.add(alHdrData.get(11));
				alDtlRecord.add(alHdrData.get(12));

				alDtlRecords.add(alDtlRecord);
			}
			stSQL				=	(String)	hmSQL.get ("DtlInsertSQL");
			
			hmArgData.put(DATA,alDtlRecords);
			hmArgSQL.put(INSERT_SQL,stSQL);

			hmResult	=	insertBatch(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmResult);
			if ( ((Boolean)hmData.get("isDocNoAutoGenYN")).booleanValue() ) {
			
				stSQL				=	(String)	hmSQL.get ("NextDocNoUpdateSQL");
				ArrayList alNextDocNoUpdateData	=	new ArrayList();
				alNextDocNoUpdateData.add(alHdrData.get(10));
				alNextDocNoUpdateData.add(alHdrData.get(11));
				alNextDocNoUpdateData.add(alHdrData.get(12));
				alNextDocNoUpdateData.add(alHdrData.get(1));

				hmArgData.put(DATA,alNextDocNoUpdateData);
				hmArgSQL.put(UPDATE_SQL,stSQL);
				hmResult	=	update(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmResult);
				hmReturn.put("flag","Doc No: "+alHdrData.get(2));
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
			
			
				StringTokenizer stItem_code=new StringTokenizer((String)hmRecord.get("item_code"),"|");//21052    
			
				String strGroup_code		=	stItem_code.nextToken();
				String strTray_no			=	stItem_code.nextToken();
				String item_code			=	stItem_code.nextToken();
				System.err.println("stItem_code_1==========>"+stItem_code);
				System.err.println("strGroup_code==========>"+strGroup_code);
				System.err.println("strTray_no==========>"+strTray_no);
				System.err.println("item_code==========>"+item_code);
				if(hmRecord.get("mode").toString().equals(MODE_INSERT)){
					alDtlRecord.add(alHdrData.get(9));
					alDtlRecord.add(alHdrData.get(10));
					alDtlRecord.add(alHdrData.get(11));
					alDtlRecord.add(item_code);
					alDtlRecord.add(hmRecord.get("contaminated_yn"));
					alDtlRecord.add(hmRecord.get("remarks"));
					alDtlRecord.add(hmRecord.get("ret_item_qty"));
					alDtlRecord.add(hmRecord.get("ret_item_cost"));
					alDtlRecord.add(hmRecord.get("damaged_yn"));

					alDtlRecord.add(alHdrData.get(6));
					alDtlRecord.add(alHdrData.get(7));
					alDtlRecord.add(alHdrData.get(8));
					alDtlRecord.add(alHdrData.get(6));
					alDtlRecord.add(alHdrData.get(7));
					alDtlRecord.add(alHdrData.get(8));

					stSQL				=	(String)	hmSQL.get ("DtlInsertSQL");
					hmArgData.put(DATA,alDtlRecord);
					hmArgSQL.put(INSERT_SQL,stSQL);
					hmResult	=	insert(connection, hmArgData, hmArgSQL);
				}
				else if(hmRecord.get("mode").toString().equals(MODE_MODIFY)){

					alDtlRecord.add(hmRecord.get("contaminated_yn"));
					alDtlRecord.add(hmRecord.get("remarks"));
					alDtlRecord.add(hmRecord.get("ret_item_qty"));
					alDtlRecord.add(hmRecord.get("ret_item_cost"));
					alDtlRecord.add(hmRecord.get("damaged_yn"));

					alDtlRecord.add(alHdrData.get(6));
					alDtlRecord.add(alHdrData.get(7));
					alDtlRecord.add(alHdrData.get(8));

					alDtlRecord.add(alHdrData.get(9));
					alDtlRecord.add(alHdrData.get(10));
					alDtlRecord.add(alHdrData.get(11));
					alDtlRecord.add(item_code);
					alDtlRecord.add(strGroup_code);
					alDtlRecord.add(strTray_no);
	
					stSQL				=	(String)	hmSQL.get ("DtlModifySQL");
					hmArgData.put(DATA,alDtlRecord);
					hmArgSQL.put(UPDATE_SQL,stSQL);
					hmResult	=	update(connection, hmArgData, hmArgSQL);
				}
				else if(hmRecord.get("mode").toString().equals(MODE_DELETE)){
					alDtlRecord.add(alHdrData.get(9));
					alDtlRecord.add(alHdrData.get(10));
					alDtlRecord.add(alHdrData.get(11));
					alDtlRecord.add(item_code);

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
