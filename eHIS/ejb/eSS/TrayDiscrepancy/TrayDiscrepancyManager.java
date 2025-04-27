/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eSS.TrayDiscrepancy;

//import java.rmi.RemoteException;
import eSS.Common.SsEJBSessionAdapter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;
import java.util.HashMap;


/**
*
* @ejb.bean
*	name="TrayDiscrepancy"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="TrayDiscrepancy"
*	local-jndi-name="TrayDiscrepancy"
*	impl-class-name="eSS.TrayDiscrepancy.TrayDiscrepancyManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSS.TrayDiscrepancy.TrayDiscrepancyLocal"
*	remote-class="eSS.TrayDiscrepancy.TrayDiscrepancyRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSS.TrayDiscrepancy.TrayDiscrepancyLocalHome"
*	remote-class="eSS.TrayDiscrepancy.TrayDiscrepancyHome"
*	generate= "local,remote"
*
*
*/



public class  TrayDiscrepancyManager extends SsEJBSessionAdapter {

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
		return getMessageHashMap(false);
	}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap insert(HashMap hmData, HashMap hmSQL)  {
		Connection	connection	=	null;
		HashMap		hmReturn	=	new HashMap();
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		ArrayList	alCommonData=	new ArrayList();
		ArrayList	alDtlData	=	new ArrayList();
		//ArrayList	alDtlRecords=	new ArrayList();
		Properties	properties	=	null;
		String		stSQL		=	null;

		hmReturn.put(RESULT,FALSE);

		try {
			properties			=	(Properties)	hmData.get("properties");
			connection			=	getConnection(properties);
			connection.setAutoCommit(false);

			alCommonData			=	(ArrayList)	hmData.get("CommonInsertData");

			alDtlData	=	(ArrayList)		hmData.get("DtlInsertData");
			stSQL		=	(String)		hmSQL.get ("DtlInsertSQL");

			for (int i=0; i<alDtlData.size();i++ ) {
				ArrayList	alDtlRecord	=	new ArrayList();
				hmReturn.clear();
				HashMap hmRecord	=	(HashMap) alDtlData.get(i);
				if(hmRecord.get("mode").toString().equals(MODE_INSERT)){
					alDtlRecord.add(alCommonData.get(5));
					alDtlRecord.add(alCommonData.get(0));
					alDtlRecord.add(alCommonData.get(1));
					alDtlRecord.add(hmRecord.get("item_code"));
					alDtlRecord.add(hmRecord.get("write_off_reason_code"));
					alDtlRecord.add(hmRecord.get("discrepancy_qty"));
					alDtlRecord.add(hmRecord.get("discrepancy_type"));
					alDtlRecord.add(hmRecord.get("remarks"));
					alDtlRecord.add(alCommonData.get(2));
					alDtlRecord.add(hmRecord.get("charge_amt"));
					alDtlRecord.add("O");
					alDtlRecord.add("Y");
					alDtlRecord.add(alCommonData.get(3));
					alDtlRecord.add(alCommonData.get(4));
					alDtlRecord.add(alCommonData.get(5));
					alDtlRecord.add(alCommonData.get(3));
					alDtlRecord.add(alCommonData.get(4));
					alDtlRecord.add(alCommonData.get(5));				
					stSQL				=	(String)	hmSQL.get ("InsertSQL");
					hmArgData.put(DATA,alDtlRecord);
					hmArgSQL.put(INSERT_SQL,stSQL);
					hmReturn	=	insert(connection, hmArgData, hmArgSQL);
				}
				else if(hmRecord.get("mode").toString().equals(MODE_MODIFY)){
					alDtlRecord.add(hmRecord.get("discrepancy_qty"));
					alDtlRecord.add(hmRecord.get("discrepancy_type"));
					alDtlRecord.add(hmRecord.get("remarks"));
					alDtlRecord.add(alCommonData.get(2));
					alDtlRecord.add(hmRecord.get("charge_amt"));
					alDtlRecord.add("Y");

					alDtlRecord.add(alCommonData.get(3));
					alDtlRecord.add(alCommonData.get(4));
					alDtlRecord.add(alCommonData.get(5));

					alDtlRecord.add(alCommonData.get(0));
					alDtlRecord.add(alCommonData.get(1));
					alDtlRecord.add(hmRecord.get("item_code"));
					alDtlRecord.add(hmRecord.get("write_off_reason_code"));

					stSQL				=	(String)	hmSQL.get ("ModifySQL");
					hmArgData.put(DATA,alDtlRecord);
					hmArgSQL.put(UPDATE_SQL,stSQL);
					
					hmReturn	=	update(connection, hmArgData, hmArgSQL);
				}
				else if(hmRecord.get("mode").toString().equals(MODE_DELETE)){
					alDtlRecord.add(alCommonData.get(0));
					alDtlRecord.add(alCommonData.get(1));
					alDtlRecord.add(hmRecord.get("item_code"));
					alDtlRecord.add(hmRecord.get("write_off_reason_code"));

					stSQL				=	(String)	hmSQL.get ("DeleteSQL");
					hmArgData.put(DATA,alDtlRecord);
					hmArgSQL.put(DELETE_SQL,stSQL);
					hmReturn	=	delete(connection, hmArgData, hmArgSQL);
				}
				else{
					hmReturn.put(RESULT,FALSE);
					hmReturn.put(MESSAGE,"Invalid Mode passed to EJB for detail at record # "+(i+1));
					hmReturn.put(MSGID,"Invalid Mode");
				}
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
