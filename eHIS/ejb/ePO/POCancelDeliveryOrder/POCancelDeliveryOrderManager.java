/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePO.POCancelDeliveryOrder;
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
*	name="POCancelDeliveryOrder"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="POCancelDeliveryOrder"
*	local-jndi-name="POCancelDeliveryOrder"
*	impl-class-name="ePO.POCancelDeliveryOrder.POCancelDeliveryOrderManager"
*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="ePO.POCancelDeliveryOrder.POCancelDeliveryOrderLocal"
*	remote-class="ePO.POCancelDeliveryOrder.POCancelDeliveryOrderRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="ePO.POCancelDeliveryOrder.POCancelDeliveryOrderLocalHome"
*	remote-class="ePO.POCancelDeliveryOrder.POCancelDeliveryOrderHome"
*	generate= "local,remote"
*
*
*/ 

public class  POCancelDeliveryOrderManager extends PoEJBSessionAdapter {

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
			System.out.println("alData mangr====>" +alData);
           	sql = (String) hmSQL.get	("UpdateHDRSQL");
			System.out.println("sql mangr====>" +sql);
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
			}else{  
			/** @ update pending quantity in po_Order_detail */
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
			}
			else {      

				 alData =	(ArrayList) hmData.get("AlMmItemUpd");
				System.out.println("alData mangr====>" +alData);
				sql = (String) hmSQL.get	("ALMMSQL");
				System.out.println("sql mangr====>" +sql);
				preparedStatement = connection.prepareStatement(sql);
					System.out.println("alData.size()=109===>" +alData.size());

				for (int index = 0; index < alData.size(); index++) {
					alRecord = (java.util.ArrayList) alData.get(index);
					System.out.println("alRecord=109===>" +alRecord);
					setData(preparedStatement, alRecord);
					preparedStatement.addBatch();
				} 

				iaResult = preparedStatement.executeBatch();
				System.out.println("iaResult=116===>" +iaResult);

				
				for (int i=0;i<iaResult.length ;i++){
						if((iaResult[i] != -2) && (iaResult[i]<0)){
						failedRecordIndex = i;
						isUpdateSuccessful = false;
						break;
					}	
				}  
				//System.out.println("po_pending quantity "+ iaResult.length);
				/** @ update po_pending quantity*/
				if(isUpdateSuccessful && hmData.containsKey("AlReqDtlUpd")){
					alData =	(ArrayList) hmData.get("AlReqDtlUpd");
					System.out.println("alData mangr====>" +alData);
					sql = (String) hmSQL.get	("AlReqDtlUpdSQL");
					System.out.println("sql mangr====>" +sql);
					preparedStatement = connection.prepareStatement(sql);


					for (int index = 0; index < alData.size(); index++) {
						alRecord = (java.util.ArrayList) alData.get(index);
						System.out.println("alRecord mangr====>" +alRecord);
						String req_no      =  (String)alRecord.get(4);
						System.out.println("req_no mangr====>" +req_no);
						//if (!req_no.equals("")){
						setData(preparedStatement, alRecord);
						preparedStatement.addBatch();
						//}
					}
					
                    System.out.println("preparedStatement===>" +preparedStatement);
					//System.out.println("req_no mangr====>" +req_no);
					iaResult = preparedStatement.executeBatch();
					System.out.println("iaResult mangr====>" +iaResult);
					
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
}
