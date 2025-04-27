/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eSS.AssignBinLocation;

import javax.ejb.SessionContext;
import javax.ejb.EJBException;
import eCommon.Common.*;
import eSS.Common.SsEJBSessionAdapter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.BatchUpdateException;
import java.sql.SQLException;
import java.sql.Timestamp;
//import java.rmi.RemoteException ;
import java.util.ArrayList;
import java.util.Properties;
import java.util.HashMap;

/**
*
* @ejb.bean
*	name="AssignBinLocation"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="AssignBinLocation"
*	local-jndi-name="AssignBinLocation"
*	impl-class-name="eSS.AssignBinLocation.AssignBinLocationManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSS.AssignBinLocation.AssignBinLocationLocal"
*	remote-class="eSS.AssignBinLocation.AssignBinLocationRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSS.AssignBinLocation.AssignBinLocationLocalHome"
*	remote-class="eSS.AssignBinLocation.AssignBinLocationHome"
*	generate= "local,remote"
*
*
*/

public class  AssignBinLocationManager extends SsEJBSessionAdapter {

	public SessionContext context = null;
	
	public void setSessionContext( SessionContext sessionContext) {
		super.setSessionContext(sessionContext);
		this.context = sessionContext;
	}

//	public HashMap modifyBatch(HashMap hmData, HashMap hmSQL) {
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap modify(HashMap hmData, HashMap hmSQL) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		HashMap hmResult = new HashMap();
		String sql = "";
		ArrayList alData = new ArrayList();
		ArrayList alRecord = new ArrayList();
		boolean isUpdateSuccessful = true;
		int failedRecordIndex = -1;

		int[] updateResult = null;
		hmResult.put(RESULT,FALSE);
		hmResult.put(MESSAGE,"No records found to be modified..");

		alData = (ArrayList) hmData.get ("UpdateData");
		sql = (String) hmSQL.get ("UpdateSQL");
		System.err.println("alData-----------------------------"+alData);
		System.err.println("sql-----------------------------"+sql);

		try {
			connection = getConnection((Properties)hmData.get("properties")) ;
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(sql);
			for (int index = 0; index < alData.size(); index++) {
				alRecord = (java.util.ArrayList) alData.get(index);
				//System.err.println("alRecord-----------------------------"+alRecord);
				setData(preparedStatement, alRecord);
				preparedStatement.addBatch();
			}
			updateResult = preparedStatement.executeBatch();
			
		
		System.err.println("updateResult-----------------------------"+updateResult);
			//preparedStatement.clearParameters();
			for (int i=0;i<updateResult.length ;i++){
				if((updateResult[i] != -2) && (updateResult[i]<0)){
					failedRecordIndex = i;
					isUpdateSuccessful = false;
					break;
				}	
			}
			
			if(isUpdateSuccessful){
				//System.err.println("comes inside isUpdateSuccessful");
				connection.commit();
				hmResult.put(RESULT,TRUE);
				//hmResult.put(MSGID,RECORD_MODIFIED);
				hmResult.put(MESSAGE,RECORD_MODIFIED);
			}
			else {
				connection.rollback();
				throw new EJBException("Update failed while updating record " + failedRecordIndex);
			}
		}
		catch(Exception exception) {
			hmResult.put(RESULT,FALSE);
			hmResult.put(MESSAGE,exception.toString());
			exception.printStackTrace();
		}
		finally{
			try{
				if(preparedStatement!=null)
					preparedStatement.close();
				if(connection != null)
                    closeConnection(connection, (Properties)hmData.get("properties")) ;
			}
			catch (Exception exception){
				exception.printStackTrace();
			}
		}
		return hmResult;
	}

	private boolean setData(PreparedStatement preparedStatement, ArrayList alData){
		return 	setData(preparedStatement,alData.toArray());
	}
	
	private boolean setData(PreparedStatement preparedStatement, Object objFields[]) {
        boolean	returnValue = true;
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
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap insert(HashMap hmData, HashMap hmSQL)	{
		HashMap hmReturn = new HashMap();
		return hmReturn;
	}

	/*public HashMap modify(HashMap hmData, HashMap hmSQL)	{
					System.err.println("@@@@ modify" );

		HashMap hmReturn = new HashMap();
		return hmReturn;
	}*/

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap delete(HashMap hmData, HashMap hmSQL)	{ 
		HashMap hmReturn = new HashMap();
		return hmReturn;
	}

	private final String MESSAGE = "message";
	//private final String MSGID = "msgid"; // Comented by Sakti as this is unused against inc#48061
	private final String RESULT = "result";
	private final Boolean TRUE = new Boolean(true);
	private final Boolean FALSE =	new Boolean(false);

    private final String RECORD_MODIFIED = "RECORD_MODIFIED";
}
