/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eSS.RequestGroup;

//import java.rmi.RemoteException;
import eSS.Common.SsEJBSessionAdapter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;
import java.util.HashMap;
import eCommon.Common.*;

/**
*
* @ejb.bean
*	name="RequestGroup"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="RequestGroup"
*	local-jndi-name="RequestGroup"
*	impl-class-name="eSS.RequestGroup.RequestGroupManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSS.RequestGroup.RequestGroupLocal"
*	remote-class="eSS.RequestGroup.RequestGroupRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSS.RequestGroup.RequestGroupLocalHome"
*	remote-class="eSS.RequestGroup.RequestGroupHome"
*	generate= "local,remote"
*
*
*/


public class  RequestGroupManager extends SsEJBSessionAdapter {

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

		ArrayList	alHdrData		=	new ArrayList();
		ArrayList	alDtlData		=	new ArrayList();
		ArrayList	alPendReqData	=	new ArrayList();
		HashMap		hmResult	=	new HashMap();


		hmReturn.put(RESULT,FALSE);
		try {
			properties			=	(Properties)	hmData.get("properties");
			connection			=	getConnection(properties);
			connection.setAutoCommit(false);


			//Added for 36422	Bru-HIMS-CRF-268.2 Ganga
			alHdrData			=	(ArrayList)	hmData.get("HdrModifyData");
			alDtlData			=	(ArrayList)	hmData.get("DtlModifyData");
			for (int i=0; i<alDtlData.size();i++ ) {
				
				HashMap hmRecord	=	(HashMap) alDtlData.get(i);		
					
				alPendReqData		=	new ArrayList();			

				alPendReqData.add(hmRecord.get("request_qty"));
				alPendReqData.add(hmRecord.get("request_qty"));
				alPendReqData.add(alHdrData.get(1));
				alPendReqData.add(alHdrData.get(2));
				alPendReqData.add(alHdrData.get(3));
				alPendReqData.add(alHdrData.get(0));
				alPendReqData.add(hmRecord.get("req_group_code"));

				stSQL				=	(String)	hmSQL.get ("UpdateGroupForStoreReduceSQL");

				hmArgData.put(DATA,alPendReqData);
				hmArgSQL.put(UPDATE_SQL,stSQL);
				hmResult	=	update(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmResult);//Ends	
			}


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

		ArrayList	alPendReqData		=	null;

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
			//stSQL		=	(String)		hmSQL.get ("DtlInsertSQL");

			for (int i=0; i<alDtlData.size();i++ ) {
				ArrayList	alDtlRecord	=	new ArrayList();
				HashMap hmRecord	=	(HashMap) alDtlData.get(i);
				alDtlRecord.add(alHdrData.get(0));
				alDtlRecord.add(alHdrData.get(1));
				alDtlRecord.add(alHdrData.get(2));
				alDtlRecord.add(hmRecord.get("req_group_code"));
				alDtlRecord.add(hmRecord.get("auth_group_code"));
				alDtlRecord.add(hmRecord.get("request_qty"));
				//Commented by Rabbani #INC no:32068 on 06/12/2012
				/*alDtlRecord.add(alHdrData.get(10));
				alDtlRecord.add(alHdrData.get(11));
				alDtlRecord.add(alHdrData.get(12));
				alDtlRecord.add(alHdrData.get(10));
				alDtlRecord.add(alHdrData.get(11));
				alDtlRecord.add(alHdrData.get(12));*/
				
				//Added by Rabbani #INC no:32068 on 06/12/2012
				alDtlRecord.add(alHdrData.get(11));
				alDtlRecord.add(alHdrData.get(12));
				alDtlRecord.add(alHdrData.get(13));
				alDtlRecord.add(alHdrData.get(11));
				alDtlRecord.add(alHdrData.get(12));
				alDtlRecord.add(alHdrData.get(13));
				
				alDtlRecords.add(alDtlRecord);

				//Added for 36422	Bru-HIMS-CRF-268.2 Ganga
				alPendReqData		=	new ArrayList();			
				
				alPendReqData.add(hmRecord.get("request_qty"));
				alPendReqData.add(hmRecord.get("request_qty"));
				alPendReqData.add(alHdrData.get(11));
				alPendReqData.add(alHdrData.get(12));
				alPendReqData.add(alHdrData.get(13));
				alPendReqData.add(alHdrData.get(4));
				alPendReqData.add(hmRecord.get("req_group_code"));

				stSQL				=	(String)	hmSQL.get ("UpdateGroupForStoreSQL");
				hmArgData.put(DATA,alPendReqData);
				hmArgSQL.put(UPDATE_SQL,stSQL);
				hmResult	=	update(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmResult);//Ends				
			}

			stSQL				=	(String)	hmSQL.get ("DtlInsertSQL");
			
			hmArgData.put(DATA,alDtlRecords);
			hmArgSQL.put(INSERT_SQL,stSQL);
			hmResult	=	insertBatch(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmResult);


			if ( ((Boolean)hmData.get("isDocNoAutoGenYN")).booleanValue() ) {
				stSQL				=	(String)	hmSQL.get ("NextDocNoUpdateSQL");

				ArrayList alNextDocNoUpdateData	=	new ArrayList();
				//Commented by Rabbani #INC no:32068 on 06/12/2012
				/*alNextDocNoUpdateData.add(alHdrData.get(10));
				alNextDocNoUpdateData.add(alHdrData.get(11));
				alNextDocNoUpdateData.add(alHdrData.get(12));*/
				//Added by Rabbani #INC no:32068 on 06/12/2012
				alNextDocNoUpdateData.add(alHdrData.get(11));  
				alNextDocNoUpdateData.add(alHdrData.get(12));   
				alNextDocNoUpdateData.add(alHdrData.get(13)); 
               //ends				
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
		ArrayList alPendReqData	=	null;
		ArrayList params		=	null;

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
				if(hmRecord.get("mode").toString().equals(MODE_INSERT)){
					alDtlRecord.add(alHdrData.get(11));
					alDtlRecord.add(alHdrData.get(12));
					alDtlRecord.add(alHdrData.get(13));
					alDtlRecord.add(hmRecord.get("req_group_code"));
					alDtlRecord.add(hmRecord.get("auth_group_code"));
					alDtlRecord.add(hmRecord.get("request_qty"));
					alDtlRecord.add(alHdrData.get(7));
					alDtlRecord.add(alHdrData.get(8));
					alDtlRecord.add(alHdrData.get(9));
					alDtlRecord.add(alHdrData.get(7));
					alDtlRecord.add(alHdrData.get(8));
					alDtlRecord.add(alHdrData.get(9));

					stSQL				=	(String)	hmSQL.get ("DtlInsertSQL");
					hmArgData.put(DATA,alDtlRecord);
					hmArgSQL.put(INSERT_SQL,stSQL);
					hmResult	=	insert(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmResult);

					//Added for 36422	Bru-HIMS-CRF-268.2 Ganga
					alPendReqData		=	new ArrayList();			

					alPendReqData.add(hmRecord.get("request_qty"));
					alPendReqData.add(hmRecord.get("request_qty"));
					alPendReqData.add(alHdrData.get(7));
					alPendReqData.add(alHdrData.get(8));
					alPendReqData.add(alHdrData.get(9));
					alPendReqData.add(alHdrData.get(1));
					alPendReqData.add(hmRecord.get("req_group_code"));

					stSQL				=	(String)	hmSQL.get ("UpdateGroupForStoreSQL");
					hmArgData.put(DATA,alPendReqData);
					hmArgSQL.put(UPDATE_SQL,stSQL);
					hmResult	=	update(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmResult);//Ends				

				}
				else if(hmRecord.get("mode").toString().equals(MODE_MODIFY)){

					//Added for 36422	Bru-HIMS-CRF-268.2 Ganga
					params = new ArrayList();

					params.add(alHdrData.get(11));
					params.add(alHdrData.get(12));
					params.add(alHdrData.get(13));
					params.add(hmRecord.get("req_group_code"));

					String old_request_qty = (String)(fetchRecord(connection,(String)hmSQL.get ("RequestQtySelectSQL"),params).get("REQUEST_QTY"));

					double req_qty=Double.parseDouble((String)hmRecord.get("request_qty"));
					
					if(old_request_qty != null) {
						double i_old_request_qty = Double.parseDouble(old_request_qty);
						String new_req_qty = ""+(-(i_old_request_qty-req_qty));						
										
						alPendReqData		=	new ArrayList();			

						alPendReqData.add(new_req_qty);
						alPendReqData.add(new_req_qty);
						alPendReqData.add(alHdrData.get(7));
						alPendReqData.add(alHdrData.get(8));
						alPendReqData.add(alHdrData.get(9));
						alPendReqData.add(alHdrData.get(1));
						alPendReqData.add(hmRecord.get("req_group_code"));

						stSQL				=	(String)	hmSQL.get ("UpdateGroupForStoreSQL");
						hmArgData.put(DATA,alPendReqData);
						hmArgSQL.put(UPDATE_SQL,stSQL);
						hmResult	=	update(connection, hmArgData, hmArgSQL);
						throwExceptionWhenFailed(hmResult);//Ends
					}


					alDtlRecord.add(hmRecord.get("auth_group_code"));
					alDtlRecord.add(new Long(hmRecord.get("request_qty").toString()));
					alDtlRecord.add(alHdrData.get(7));
					alDtlRecord.add(alHdrData.get(8));
					alDtlRecord.add(alHdrData.get(9));
					alDtlRecord.add(alHdrData.get(11));
					alDtlRecord.add(alHdrData.get(12));
					alDtlRecord.add(alHdrData.get(13));
					alDtlRecord.add(hmRecord.get("req_group_code"));

					stSQL				=	(String)	hmSQL.get ("DtlModifySQL");
					hmArgData.put(DATA,alDtlRecord);
					hmArgSQL.put(UPDATE_SQL,stSQL);
					hmResult	=	update(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmResult);
				}
				else if(hmRecord.get("mode").toString().equals(MODE_DELETE)){
					alDtlRecord.add(alHdrData.get(11));
					alDtlRecord.add(alHdrData.get(12));
					alDtlRecord.add(alHdrData.get(13));
					alDtlRecord.add(hmRecord.get("req_group_code"));

					stSQL				=	(String)	hmSQL.get ("DtlDeleteSQL");
					hmArgData.put(DATA,alDtlRecord);
					hmArgSQL.put(DELETE_SQL,stSQL);
					hmResult	=	delete(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmResult);

					//Added for 36422	Bru-HIMS-CRF-268.2 Ganga
					alPendReqData		=	new ArrayList();			

					alPendReqData.add(hmRecord.get("request_qty"));
					alPendReqData.add(hmRecord.get("request_qty"));
					alPendReqData.add(alHdrData.get(7));
					alPendReqData.add(alHdrData.get(8));
					alPendReqData.add(alHdrData.get(9));
					alPendReqData.add(alHdrData.get(1));
					alPendReqData.add(hmRecord.get("req_group_code"));

					stSQL				=	(String)	hmSQL.get ("UpdateGroupForStoreReduceSQL");
					hmArgData.put(DATA,alPendReqData);
					hmArgSQL.put(UPDATE_SQL,stSQL);
					hmResult	=	update(connection, hmArgData, hmArgSQL);
					throwExceptionWhenFailed(hmResult);//Ends	

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
