/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSS.CancelRequestGroup;

import javax.ejb.SessionContext;
import javax.ejb.EJBException;
import eCommon.Common.*;
import eSS.Common.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Properties; 
import java.util.HashMap;

/**
*
* @ejb.bean
*	name="CancelRequestGroup"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="CancelRequestGroup"
*	local-jndi-name="CancelRequestGroup"
*	impl-class-name="eSS.CancelRequestGroup.CancelRequestGroupManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSS.CancelRequestGroup.CancelRequestGroupLocal"
*	remote-class="eSS.CancelRequestGroup.CancelRequestGroupRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSS.CancelRequestGroup.CancelRequestGroupLocalHome"
*	remote-class="eSS.CancelRequestGroup.CancelRequestGroupHome"
*	generate= "local,remote" 
*
*
*/

public class  CancelRequestGroupManager extends SsEJBSessionAdapter {

	public SessionContext context = null;
	
	public void setSessionContext( SessionContext sessionContext) {
		super.setSessionContext(sessionContext);
		this.context = sessionContext;
	}

	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap modify(HashMap hmData, HashMap hmSQL) 	{
		Connection	connection	=	null;
		HashMap		hmReturn	=	new HashMap();
		HashMap		hmResult	=	new HashMap();
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		ArrayList	alHdrData	=	new ArrayList();
		ArrayList	alDtlData	=	new ArrayList();
		ArrayList	alDtlRecord	=	new ArrayList();
		ArrayList	alDelReqRecord	=	new ArrayList();
		Properties	properties	=	null;
		String		stSQL		=	null;
				
		hmReturn.put(RESULT,FALSE);
		String cancelAll = (String)hmData.get("cancelAll");
		
		try {
			properties =	(Properties) hmData.get("properties");
			connection = getConnection(properties);
			connection.setAutoCommit(false);
			alHdrData =	(ArrayList) hmData.get("ModifyData");
			alDtlData	=	(ArrayList)		hmData.get("alPendReqData");

		if(cancelAll.equals("Y")){
			
				stSQL = (String) hmSQL.get	("ModifySQL");
				hmArgData.put(DATA,alHdrData);
				hmArgSQL.put(UPDATE_SQL,stSQL);
				hmReturn	=	update(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmReturn);
					
			
			 for (int i=0; i<alDtlData.size();i++ ) {
				alDtlRecord	=	new ArrayList();
				HashMap hmRecord	=	(HashMap) alDtlData.get(i);
			
				alDtlRecord.add(hmRecord.get("request_qty"));
				alDtlRecord.add(hmRecord.get("request_qty"));
				alDtlRecord.add(alHdrData.get(2));
				alDtlRecord.add(alHdrData.get(3));
				alDtlRecord.add(alHdrData.get(4));
				alDtlRecord.add(hmRecord.get("req_by_store_code"));
				alDtlRecord.add(hmRecord.get("request_group_code"));
				
				stSQL				=	(String)	hmSQL.get ("UpdateGroupForStoreSQL");
				hmArgData.put(DATA,alDtlRecord);
				hmArgSQL.put(UPDATE_SQL,stSQL);
				hmResult	=	update(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmResult);//Ends		

			}
		}else{
					
			 for (int i=0; i<alDtlData.size();i++ ) {
				alDtlRecord	=	new ArrayList();
				HashMap hmRecord	=	(HashMap) alDtlData.get(i);
			
				alDtlRecord.add(hmRecord.get("request_qty"));
				alDtlRecord.add(hmRecord.get("request_qty"));
				alDtlRecord.add(alHdrData.get(2));
				alDtlRecord.add(alHdrData.get(3));
				alDtlRecord.add(alHdrData.get(4));
				alDtlRecord.add(hmRecord.get("req_by_store_code"));
				alDtlRecord.add(hmRecord.get("request_group_code"));
								
				stSQL				=	(String)	hmSQL.get ("UpdateGroupForStoreSQL");
				hmArgData.put(DATA,alDtlRecord);
				hmArgSQL.put(UPDATE_SQL,stSQL);
				hmReturn	=	update(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmReturn);//Ends
				
				//Delete request Detail starts
				alDelReqRecord	=	new ArrayList();
				alDelReqRecord.add(hmRecord.get("facility_id"));
				alDelReqRecord.add(hmRecord.get("doc_type_code"));
				alDelReqRecord.add(hmRecord.get("doc_no"));
				alDelReqRecord.add(hmRecord.get("group_code"));
								
				stSQL				=	(String)	hmSQL.get ("DeleteRequestDetailSQL");
				hmArgData.put(DATA,alDelReqRecord);
				hmArgSQL.put(UPDATE_SQL,stSQL);
				hmReturn	=	update(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmReturn);//Ends	
				
				
			}

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
	System.out.println("hmReturn in  modify EJB"+hmReturn);
		return hmReturn;		

	}
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap insert (HashMap hmData, HashMap hmSQL) {
		return getMessageHashMap(false);
	}
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap delete (HashMap hmData, HashMap hmSQL )  {
		return getMessageHashMap(false);
	}
}
 
