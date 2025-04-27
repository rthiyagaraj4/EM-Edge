/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSS.Acknowledgement;

//import java.rmi.RemoteException;
import eSS.Common.SsEJBSessionAdapter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Properties;
import java.util.HashMap;
import java.sql.PreparedStatement;

import javax.ejb.EJBException;
/**
*
* @ejb.bean
*	name="Acknowledgement"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="Acknowledgement"
*	local-jndi-name="Acknowledgement"
*	impl-class-name="eSS.Acknowledgement.AcknowledgementManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSS.Acknowledgement.AcknowledgementLocal"
*	remote-class="eSS.Acknowledgement.AcknowledgementRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSS.Acknowledgement.AcknowledgementLocalHome"
*	remote-class="eSS.Acknowledgement.AcknowledgementHome"
*	generate= "local,remote"
*
*
*/
public class  AcknowledgementManager extends SsEJBSessionAdapter {

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
		return getMessageHashMap(false);
	}
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap modify(HashMap hmData, HashMap hmSQL){// throws RemoteException{
		Connection	connection	=	null;
		HashMap		hmReturn	=	new HashMap();
		/* HashMap		hmArgData	=	new HashMap(); // Comented by Sakti as this is unused against inc#48061 
		HashMap		hmArgSQL	=	new HashMap();
		ArrayList	alHdrData	=	new ArrayList();*/
		ArrayList	alDtlData	=	new ArrayList();
		Properties	properties	=	null;
		String		stSQL		=	null;
		PreparedStatement preparedStatement	=	null;
		//ArrayList alData = null;
		ArrayList alRecord = null;

		hmReturn.put(RESULT,FALSE);
		int[] iaResult = null;
		int failedRecordIndex = 0;
		boolean isUpdateSuccessful = true;

		try {
			properties			=	(Properties)	hmData.get("properties");
			connection			=	getConnection(properties);
			connection.setAutoCommit(false);

		
			//alHdrData			=	(ArrayList)	hmData.get("HdrModifyData"); 
			alDtlData	=	(ArrayList)		hmData.get("alDtlModifyData");
			stSQL		=	(String)		hmSQL.get ("DtlModifySQL");
			
			//Added by Sakti Sankar  against BRU-HIMS-CRF-372
			preparedStatement = connection.prepareStatement(stSQL);
			for (int index = 0; index < alDtlData.size(); index++) {
				alRecord = (java.util.ArrayList) alDtlData.get(index);
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
				throw new EJBException("Update failed  at the index " + failedRecordIndex);
			}
			else {
				connection.commit();
				hmReturn.put(RESULT,TRUE);
				hmReturn.put(MESSAGE,"RECORD_INSERTED"); 
			}

			//Added ends
			/*for (int i=0; i<alDtlData.size();i++ ) {
				ArrayList	alDtlRecord	=	new ArrayList();
				hmReturn.clear();
				HashMap hmRecord	=	(HashMap) alDtlData.get(i);
				alDtlRecord.add(hmRecord.get("RECEIPT_DATE").toString()); //rof_status                     
				alDtlRecord.add(alHdrData.get(0));													 //receipt_date                 
				alDtlRecord.add(alHdrData.get(0));													 //received_by_id             
				alDtlRecord.add(alHdrData.get(1));													 //modified_by_id             
				alDtlRecord.add(alHdrData.get(2));													 //modified_date              
				alDtlRecord.add(alHdrData.get(3));													 //modified_at_ws_no     
				alDtlRecord.add(alHdrData.get(4));													 //modified_facility_id      
				alDtlRecord.add(hmRecord.get("GROUP_CODE"));						 //doc_type_code             
				alDtlRecord.add(hmRecord.get("TRAY_NO"));								 //doc_no                           
				stSQL				=	(String)	hmSQL.get ("DtlModifySQL");				 //group_code                  
				hmArgData.put(DATA,alDtlRecord);													 //tray_no
				hmArgSQL.put(UPDATE_SQL,stSQL);
				hmReturn	=	update(connection, hmArgData, hmArgSQL);
				throwExceptionWhenFailed(hmReturn);
			}
			connection.commit();*/
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
				if(preparedStatement!=null) {
					preparedStatement.close();
				}
				closeConnection( connection, properties );
			}
			catch (Exception exception){
				exception.printStackTrace();
			}
		}
		return hmReturn;
	}
	
	private boolean setData(PreparedStatement preparedStatement, ArrayList alData){
		return setData(preparedStatement,alData.toArray());
	}
	
	private boolean setData(PreparedStatement preparedStatement, Object objFields[]) {
        boolean	returnValue	=	true;
		try {
            for(int index = 0; index < objFields.length; index++) {
				if(objFields[index] instanceof Date) 
                    preparedStatement.setDate(index + 1, (Date)objFields[index]);
			
				else if(objFields[index] instanceof Timestamp) 
                    preparedStatement.setTimestamp(index + 1, (Timestamp)objFields[index]);

				else if(objFields[index] instanceof String)
                     preparedStatement.setString(index + 1, (String)objFields[index]);
				
				else if(objFields[index] instanceof Integer)
					preparedStatement.setInt(index + 1, ((Integer)objFields[index]).intValue());

				else if(objFields[index] instanceof Long)
                    preparedStatement.setLong(index + 1, ((Long)objFields[index]).longValue());

				else if(objFields[index] instanceof Double)
                    preparedStatement.setDouble(index + 1, ((Double)objFields[index]).doubleValue());

                else if(objFields[index] instanceof Float)
                    preparedStatement.setFloat(index + 1, ((Float)objFields[index]).floatValue());
            }
        }
        catch(Exception exception) {
            exception.printStackTrace();
			returnValue	=	false;
        }
        return returnValue;
    }
} 
