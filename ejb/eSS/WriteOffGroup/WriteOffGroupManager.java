/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eSS.WriteOffGroup;

//WriteOffGroupLocalHomeimport java.rmi.RemoteException;
import eSS.Common.SsEJBSessionAdapter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;
import java.util.HashMap;
import eCommon.Common.*;


/**
*
* @ejb.bean
*	name="WriteOffGroup"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="WriteOffGroup"
*	local-jndi-name="WriteOffGroup"
*	impl-class-name="eSS.WriteOffGroup.WriteOffGroupManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSS.WriteOffGroup.WriteOffGroupLocal"
*	remote-class="eSS.WriteOffGroup.WriteOffGroupRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSS.WriteOffGroup.WriteOffGroupLocalHome"
*	remote-class="eSS.WriteOffGroup.WriteOffGroupHome"
*	generate= "local,remote"
*
*
*/


public class  WriteOffGroupManager extends SsEJBSessionAdapter {


/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap delete( HashMap hmData, HashMap hmSQL )  {
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

			for (int i=0; i<alDtlData.size();i++ ) {
				ArrayList	alDtlRecord	=	new ArrayList();
				HashMap hmRecord	=	(HashMap) alDtlData.get(i);
				alDtlRecord.add(alHdrData.get(0));
				alDtlRecord.add(alHdrData.get(1));
				alDtlRecord.add(alHdrData.get(2));
				alDtlRecord.add(hmRecord.get("group_code"));
				alDtlRecord.add(hmRecord.get("tray_no"));
				alDtlRecord.add(hmRecord.get("write_off_reason_code"));
				alDtlRecord.add(hmRecord.get("remarks"));
				alDtlRecord.add(hmRecord.get("group_code"));
				//alDtlRecord.add(hmRecord.get("write_off_cost"));
				alDtlRecord.add(alHdrData.get(8));
				alDtlRecord.add(alHdrData.get(9));
				alDtlRecord.add(alHdrData.get(10));
				alDtlRecord.add(alHdrData.get(8));
				alDtlRecord.add(alHdrData.get(9));
				alDtlRecord.add(alHdrData.get(10));
				//System.out.println(alDtlRecord);
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
				alNextDocNoUpdateData.add(alHdrData.get(8));
				alNextDocNoUpdateData.add(alHdrData.get(9));
				alNextDocNoUpdateData.add(alHdrData.get(10));
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

	public HashMap modify(HashMap hmData, HashMap hmSQL){
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

////System.out.println("here");
////System.out.println("alDtlData.size()"+alDtlData.size());


			for (int i=0; i<alDtlData.size();i++ ) {
				ArrayList	alDtlRecord	=	new ArrayList();
				hmResult.clear();
				HashMap hmRecord	=	(HashMap) alDtlData.get(i);
				//System.out.println("mode"+hmRecord.get("mode").toString());

				if(hmRecord.get("mode").toString().equals(MODE_INSERT)){
					alDtlRecord.add(alHdrData.get(8));
					alDtlRecord.add(alHdrData.get(9));
					alDtlRecord.add(alHdrData.get(10));
					alDtlRecord.add(hmRecord.get("group_code"));
					alDtlRecord.add(hmRecord.get("tray_no"));
					alDtlRecord.add(hmRecord.get("write_off_reason_code"));
					alDtlRecord.add(hmRecord.get("remarks"));
					alDtlRecord.add(hmRecord.get("group_code"));
					alDtlRecord.add(alHdrData.get(5));
					alDtlRecord.add(alHdrData.get(6));
					alDtlRecord.add(alHdrData.get(7));
					alDtlRecord.add(alHdrData.get(5));
					alDtlRecord.add(alHdrData.get(6));
					alDtlRecord.add(alHdrData.get(7));

					stSQL				=	(String)	hmSQL.get ("DtlInsertSQL");
					hmArgData.put(DATA,alDtlRecord);
					hmArgSQL.put(INSERT_SQL,stSQL);
					hmResult	=	insert(connection, hmArgData, hmArgSQL);
				}
				else if(hmRecord.get("mode").toString().equals(MODE_MODIFY)){
//					alDtlRecord.add(new Long(hmRecord.get("request_qty").toString()));

				
//					alDtlRecord.add(hmRecord.get("group_code"));
//					alDtlRecord.add(hmRecord.get("tray_no"));
					alDtlRecord.add(hmRecord.get("write_off_reason_code"));
					alDtlRecord.add(hmRecord.get("remarks"));

					alDtlRecord.add(alHdrData.get(5));
					alDtlRecord.add(alHdrData.get(6));
					alDtlRecord.add(alHdrData.get(7));

					alDtlRecord.add(alHdrData.get(8));
					alDtlRecord.add(alHdrData.get(9));
					alDtlRecord.add(alHdrData.get(10));
					alDtlRecord.add(hmRecord.get("group_code"));
					alDtlRecord.add(hmRecord.get("tray_no"));

					stSQL				=	(String)	hmSQL.get ("DtlModifySQL");
					hmArgData.put(DATA,alDtlRecord);
					hmArgSQL.put(UPDATE_SQL,stSQL);
					hmResult	=	update(connection, hmArgData, hmArgSQL);
				}
				else if(hmRecord.get("mode").toString().equals(MODE_DELETE)){
					alDtlRecord.add(alHdrData.get(7));
					alDtlRecord.add(alHdrData.get(9));
					alDtlRecord.add(alHdrData.get(10));
					alDtlRecord.add(hmRecord.get("group_code"));
					alDtlRecord.add(hmRecord.get("tray_no"));
			

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
