/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------
06/04/2017				IN063878				Badmavathi B					        					 Unused variables
-------------------------------------------------------------------------------------------------------------------------------
*/
package ePO.POCancelOrder;
import javax.ejb.SessionContext;
import javax.ejb.EJBException;
import eCommon.Common.*;
import ePO.Common.PoEJBSessionAdapter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList; 
import java.util.Properties;
import java.util.HashMap;
 import java.sql.PreparedStatement;
import java.sql.ResultSet;
 
/**
*
* @ejb.bean
*	name="POCancelOrder"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="POCancelOrder"
*	local-jndi-name="POCancelOrder"
*	impl-class-name="ePO.POCancelOrder.POCancelOrderManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePO.POCancelOrder.POCancelOrderLocal"
*	remote-class="ePO.POCancelOrder.POCancelOrderRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePO.POCancelOrder.POCancelOrderLocalHome"
*	remote-class="ePO.POCancelOrder.POCancelOrderHome"
*	generate= "local,remote"
*
*
*/ 

public class  POCancelOrderManager extends PoEJBSessionAdapter {

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

			  if(!isUpdateSuccessful){
				connection.rollback();
				throw new EJBException("Update failed while updating cancel qty at the index " + failedRecordIndex);
			}
			/** @ update pending quantity in po_Order_detail */
			//Commented by Rabbani #Inc no :38549 on 12-MAR-2013 Starts
			/*else{
			alData =	(ArrayList) hmData.get("DetailUpdateData");
			System.out.println("alData mangr==dtl==>" +alData);
			sql = (String) hmSQL.get("UpdateDTLSQL");
			System.out.println("sql mangr=dtl===>" +sql);
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
				throw new EJBException("Update failed while updating cancel qty at the index " + failedRecordIndex);
			}*/
			//ends
			else {      

				alData =	(ArrayList) hmData.get("AlMmItemUpd");
				sql = (String) hmSQL.get	("ALMMSQL");
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
				if(isUpdateSuccessful && hmData.containsKey("AlReqDtlUpd")){
					alData =	(ArrayList) hmData.get("AlReqDtlUpd");
					sql = (String) hmSQL.get	("AlReqDtlUpdSQL");
					preparedStatement = connection.prepareStatement(sql);


					for (int index = 0; index < alData.size(); index++) {
						alRecord = (java.util.ArrayList) alData.get(index);
						//String req_no      =  (String)alRecord.get(4); Commented for unused variable IN063878
						//if (!req_no.equals("")){
						setData(preparedStatement, alRecord);
						preparedStatement.addBatch();
						//}
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
				}
				else {
					connection.commit();
					hmReturn.put(RESULT,TRUE);
					hmReturn.put(MESSAGE,RECORD_INSERTED);
				}
			}
			if (connection!=null) {
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
	
	protected final String MESSAGE = "message";
	protected final String RESULT = "result";
	protected final Boolean TRUE = new Boolean(true);
	protected final Boolean FALSE =	new Boolean(false);
	private final String RECORD_INSERTED = "RECORD_INSERTED";
    
}
