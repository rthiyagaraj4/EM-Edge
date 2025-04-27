/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST.CancelRequest;


import javax.ejb.SessionContext;
import javax.ejb.EJBException;
import eCommon.Common.*;
import eST.Common.StEJBSessionAdapter;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.BatchUpdateException;
//import java.sql.SQLException;
//import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Properties;
import java.util.HashMap;
//import java.rmi.RemoteException;

/**
*
* @ejb.bean
*	name="CancelRequest"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="CancelRequest"
*	local-jndi-name="CancelRequest"
*	impl-class-name="eST.CancelRequest.CancelRequestManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eST.CancelRequest.CancelRequestLocal"
*	remote-class="eST.CancelRequest.CancelRequestRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eST.CancelRequest.CancelRequestLocalHome"
*	remote-class="eST.CancelRequest.CancelRequestHome"
*	generate= "local,remote"
*
*
*/

public class  CancelRequestManager extends StEJBSessionAdapter {

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
		Connection	connection = null;
		HashMap hmReturn = new HashMap();
		PreparedStatement preparedStatement	=	null;
		Properties properties = null;
		ArrayList alData = null;
		ArrayList alRecord = null;
		String sql =	"";
		

		hmReturn.put(RESULT,FALSE);

		int[] iaResult = null;
		int failedRecordIndex = 0;
		boolean isUpdateSuccessful = true;
		try {
			properties =	(Properties) hmData.get("properties");
			connection = getConnection(properties);
			connection.setAutoCommit(false);
			alData =	(ArrayList) hmData.get("HeaderUpdateData");
			if(alData != null){  //Added by Rabbani # Bru-HIMS-CRF-118[INC NO:30077] on 19-JULY-2013
           	sql = (String) hmSQL.get	("UpdateHDRSQL");
			preparedStatement = connection.prepareStatement(sql);


			for (int index = 0; index < alData.size(); index++) {
				alRecord = (java.util.ArrayList) alData.get(index);
				setData(preparedStatement, alRecord);
				preparedStatement.addBatch();
			}

			iaResult = preparedStatement.executeBatch();
           

			for (int i=0;i<iaResult.length ;i++){
				if((iaResult[i] != -2) && (iaResult[i]<0)){
					failedRecordIndex = i;
					isUpdateSuccessful = false;
					break;
				}	
			}
          }
		if(hmData.containsKey("DetailUpdateData")) { //Added condition only By Sakti Sankar against AAKH-SCF-0023 on 07/03/2013
			if(!isUpdateSuccessful){
				connection.rollback();
				throw new EJBException("Update failed while updating cancel flag at the index " + failedRecordIndex);
			}else{            //added by Rabbani,#inc no:27426 ,dt:12/07/2011 //starts
			/** @ update pending quantity in st_requset_dtl */
			alData =	(ArrayList) hmData.get("DetailUpdateData");
			sql = (String) hmSQL.get("UpdateDTLSQL");
			preparedStatement = connection.prepareStatement(sql);


			for (int index = 0; index < alData.size(); index++) {
				alRecord = (java.util.ArrayList) alData.get(index);
				setData(preparedStatement, alRecord);
				preparedStatement.addBatch(); 
			}

			iaResult = preparedStatement.executeBatch();
			
			for (int i=0;i<iaResult.length ;i++){
					if((iaResult[i] != -2) && (iaResult[i]<0)){
					failedRecordIndex = i;
					isUpdateSuccessful = false;
					break;
				}	
			}  
		}
	} //Added condition only ends
			  if(!isUpdateSuccessful){
				connection.rollback();
				throw new EJBException("Update failed while updating cancel qty at the index " + failedRecordIndex);
			}else {     //12-07-11 ends here

				alData =	(ArrayList) hmData.get("RevertBackData");
				sql = (String) hmSQL.get	("RevertBackSQL");
				preparedStatement = connection.prepareStatement(sql);


				for (int index = 0; index < alData.size(); index++) {
					alRecord = (java.util.ArrayList) alData.get(index);
					setData(preparedStatement, alRecord);
					preparedStatement.addBatch();
				}

				iaResult = preparedStatement.executeBatch();
				
				for (int i=0;i<iaResult.length ;i++){
						if((iaResult[i] != -2) && (iaResult[i]<0)){
						failedRecordIndex = i;
						isUpdateSuccessful = false;
						break;
					}	
				}
				 
				/** @ update po_pending quantity*/
				if(isUpdateSuccessful && hmData.containsKey("PORevertBackData")){
					alData =	(ArrayList) hmData.get("PORevertBackData");
					sql = (String) hmSQL.get	("PORevertBackSQL");
					preparedStatement = connection.prepareStatement(sql);


					for (int index = 0; index < alData.size(); index++) {
						alRecord = (java.util.ArrayList) alData.get(index);
						setData(preparedStatement, alRecord);
						preparedStatement.addBatch();
					}

					iaResult = preparedStatement.executeBatch();
					
					for (int i=0;i<iaResult.length ;i++){
						if((iaResult[i] != -2) && (iaResult[i]<0)){
							failedRecordIndex = i;
							isUpdateSuccessful = false;
							break;
						}	
					}

				}
				if(!isUpdateSuccessful){
					connection.rollback();
					throw new EJBException("Update failed while reverting back the pending request qty at the index " + failedRecordIndex);
				}else {
					connection.commit();
					hmReturn.put(RESULT,TRUE);
					hmReturn.put(MESSAGE,RECORD_INSERTED);
				}
			}if (connection!=null) {
					closeConnection(connection,properties);	
		}
		
		}
		catch(Exception e) {
			try {
				connection.rollback();			
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
			hmReturn.put("message",e);
		}
		finally {
			 try{
				if(preparedStatement!=null)
					preparedStatement.close();
				if (connection!=null) {
					closeConnection(connection,(Properties)hmData.get(properties));	
				}
			}
			catch (Exception exception){
				exception.printStackTrace();
			}
		}

		return hmReturn;		

		/* Code to Revert back the pending item qty of st_item_store */

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
