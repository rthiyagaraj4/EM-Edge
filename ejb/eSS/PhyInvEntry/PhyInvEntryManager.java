/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------

11/3/2021              TFS:15756               Shazana                           								check Style Audit report 
--------------------------------------------------------------------------------------------------------------------------------------------
*/ 
 package eSS.PhyInvEntry;

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
import java.util.ArrayList;
import java.util.Properties;
import java.util.HashMap;

/**
*
* @ejb.bean
*	name="PhyInvEntry"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="PhyInvEntry"
*	local-jndi-name="PhyInvEntry"
*	impl-class-name="eSS.PhyInvEntry.PhyInvEntryManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSS.PhyInvEntry.PhyInvEntryLocal"
*	remote-class="eSS.PhyInvEntry.PhyInvEntryRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSS.PhyInvEntry.PhyInvEntryLocalHome"
*	remote-class="eSS.PhyInvEntry.PhyInvEntryHome"
*	generate= "local,remote"
*
*
*/

public class  PhyInvEntryManager extends SsEJBSessionAdapter {

	public SessionContext context = null;
	
	public void setSessionContext( SessionContext sessionContext) {
		super.setSessionContext(sessionContext);
		this.context = sessionContext;
	}

///Function for handling generic operation..
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap modify(HashMap hmData, HashMap hmSQL)	{
		Connection	connection = null;
		HashMap hmReturn = new HashMap();
		PreparedStatement preparedStatement	=	null;
		String sql =	"";
		ArrayList alData = new ArrayList();
		ArrayList alRecord = new ArrayList();
		Properties properties = null;
		boolean isUpdateSuccessful = true;

		//int iResult = 0;
		int[] iaResult = null;
		int failedRecordIndex = -1;
		hmReturn.put(RESULT,FALSE);

		try {
			properties =	(Properties) hmData.get("properties");
			connection = getConnection(properties);
			connection.setAutoCommit(false);

			//Delete Detail
			if (hmData.containsKey("DeleteDTLData") && hmSQL.containsKey("DeleteDTLSQL")) {
				alData = (ArrayList)	hmData.get ("DeleteDTLData");
				sql = (String)	hmSQL.get	("DeleteDTLSQL");
				preparedStatement = connection.prepareStatement(sql);
				for (int index = 0; index < alData.size(); index++) {
					alRecord = (java.util.ArrayList) alData.get(index);
					setData(preparedStatement, alRecord);
					preparedStatement.addBatch();
				}
				iaResult = preparedStatement.executeBatch();
				//preparedStatement.clearParameters();
				for (int i=0;i<iaResult.length ;i++){
					if((iaResult[i] != -2) && (iaResult[i]<0)){
						failedRecordIndex = i;
						isUpdateSuccessful = false;
						break;
					}	
				}
				if(!isUpdateSuccessful){
					connection.rollback();
					throw new EJBException("Insert failed while inserting detail record " + failedRecordIndex);
				}
				iaResult = null;
				sql = null;
				alData = null;
				alRecord = null;
				preparedStatement = null;
			}

			//Update Detail
			if (hmData.containsKey("UpdateDTLData") && hmSQL.containsKey("UpdateDTLSQL")) {
				alData = (ArrayList)	hmData.get ("UpdateDTLData");
				sql = (String)	hmSQL.get	("UpdateDTLSQL");
				preparedStatement = connection.prepareStatement(sql);
				for (int index = 0; index < alData.size(); index++) {
					alRecord = (java.util.ArrayList) alData.get(index);
					setData(preparedStatement, alRecord);
					preparedStatement.addBatch();
				}
				iaResult = preparedStatement.executeBatch();
				//preparedStatement.clearParameters();
				for (int i=0;i<iaResult.length ;i++){
					if((iaResult[i] != -2) && (iaResult[i]<0)){
						failedRecordIndex = i;
						isUpdateSuccessful = false;
						break;
					}	
				}
				if(!isUpdateSuccessful){
					connection.rollback();
					throw new EJBException("Insert failed while inserting detail record " + failedRecordIndex);
				}
				iaResult = null;
				sql = null;
				alData = null;
				alRecord = null;
				preparedStatement = null;
			}

			// Insert Detail Value
			alData = (ArrayList)	hmData.get ("InsertDTLData");
			sql = (String)	hmSQL.get	("InsertDTLSQL");
			preparedStatement = connection.prepareStatement(sql);
			for (int index = 0; index < alData.size(); index++) {
				alRecord = (java.util.ArrayList) alData.get(index);
				setData(preparedStatement, alRecord);
				preparedStatement.addBatch();
			}
			iaResult = preparedStatement.executeBatch();
			//preparedStatement.clearParameters();
			for (int i=0;i<iaResult.length ;i++){
				if((iaResult[i] != -2) && (iaResult[i]<0)){
					failedRecordIndex = i;
					isUpdateSuccessful = false;
					break;
				}	
			}
			if(!isUpdateSuccessful){
				connection.rollback();
				throw new EJBException("Insert failed while inserting detail record " + failedRecordIndex);
			}
			
			iaResult = null;
			sql = null;
			alData = null;
			alRecord = null;
			preparedStatement = null;
			// After successful insertion and updation 
			connection.commit();
			hmReturn.put(RESULT,TRUE);
			hmReturn.put(MESSAGE,RECORD_INSERTED);
        }
		catch(SQLException sqlException) {
			try {
				connection.rollback();
				hmReturn.put(RESULT,FALSE);
				if(sqlException.getErrorCode()==1)
					hmReturn.put(MESSAGE,CODE_ALREADY_EXISTS);
				else
					hmReturn.put(MESSAGE,sqlException.toString());
				sqlException.printStackTrace();
			}
			catch (Exception exception) {
				exception.printStackTrace(); 
			}
        }
		catch(Exception exception) {
			try {
				connection.rollback();
				hmReturn.put(RESULT,FALSE);
				hmReturn.put(MESSAGE,exception.toString());
				exception.printStackTrace();
			}
			catch (Exception subexception) {
				subexception.printStackTrace(); 
			}
        }
		finally{
			try{
				if(preparedStatement!=null)
					preparedStatement.close();
				if (connection!=null) {
					//closeConnection(connection,(Properties)hmData.get(properties));	//commented for 15756
					closeConnection(connection, properties);//added for 15756   
				}
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
	
	public HashMap insert(HashMap hmData, HashMap hmSQL)	 {
		//Connection	connection = null;
		HashMap hmReturn = new HashMap();
		/*
		PreparedStatement preparedStatement	=	null;
		String sql =	"";
		ArrayList alData =	new ArrayList();
		ArrayList	 alRecords =	new ArrayList();
		Properties properties = null;

		int iResult =	0;
		hmReturn.put(RESULT,FALSE);
		hmReturn.put(MESSAGE,"No records found to be modified..");
		properties =	(Properties) hmData.get("properties");
		alData =	(ArrayList)	hmData.get (UPDATE_DATA);
		sql = (String)	hmSQL.get	(UPDATE_SQL);
		try {
			connection = getConnection(properties);
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(sql);
			setData(preparedStatement,alData);
			iResult		=	preparedStatement.executeUpdate();

			if(iResult!=0){
				connection.commit();
				hmReturn.put(RESULT,TRUE);
				hmReturn.put(MESSAGE,RECORD_MODIFIED);
			}
        }
		
		catch(Exception exception) {
			try {
				connection.rollback();
				hmReturn.put(RESULT,FALSE);
				hmReturn.put(MESSAGE,exception.toString());
				exception.printStackTrace();
			}
			catch (Exception subexception) {
				subexception.printStackTrace();
			}
        }
		finally{
			try{
				if(preparedStatement!=null)
					preparedStatement.close();
				closeConnection(connection,(Properties)hmData.get(properties));	
			}
			catch (Exception subexception){
				subexception.printStackTrace();
			}
		}
		*/
		return hmReturn;
	}
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
		
	public HashMap delete(HashMap hmData, HashMap hmSQL)	{
		Connection connection = null;
		HashMap hmReturn = new HashMap();
		PreparedStatement preparedStatement	=	null;
		String sql = "";
		Properties properties = null;

		ArrayList alData =	new ArrayList();
//		ArrayList alRecords =	new ArrayList();

		int iResult = 0;
		properties =	(Properties) hmData.get("properties");
		hmReturn.put(RESULT,FALSE);
		hmReturn.put(MESSAGE,"No record found to be deleted..");

		try {
			alData		=	(ArrayList)	hmData.get("DeleteDTLData");
			sql			=	(String)	hmSQL.get	("DeleteDTLSQL");
			
			connection = getConnection(properties);
			connection.setAutoCommit(false);
			if (alData != null && alData.size() > 0) {
				preparedStatement = connection.prepareStatement(sql);
				setData(preparedStatement,alData);
				iResult		=	preparedStatement.executeUpdate();

				if(iResult<=0){
					throw new Exception ("Delete Failed in Detail!");
				}
			}

			alData		=	(ArrayList)	hmData.get("DeleteHDRData");
			sql			=	(String)	hmSQL.get	("DeleteHDRSQL");
			preparedStatement.close();//added for 15756 
			preparedStatement = connection.prepareStatement(sql);
			setData(preparedStatement,alData);
			iResult		=	preparedStatement.executeUpdate();

			if(iResult!=0){
				connection.commit();
				hmReturn.put(RESULT,TRUE);
				hmReturn.put(MESSAGE,RECORD_DELETED);
			}
			else {
				throw new Exception ("Delete Failed in Header!");
			}
        }
		catch(Exception exception) {
			try {
				connection.rollback();
				hmReturn.put(RESULT,FALSE);
				hmReturn.put(MESSAGE,exception.toString());
				exception.printStackTrace();
				}
				catch (Exception subexception) {
					subexception.printStackTrace();
				}
        }
		finally{
			try{
				if(preparedStatement!=null)
					preparedStatement.close();
				//closeConnection(connection,(Properties)hmData.get(properties));	//commented for 15756
				closeConnection(connection,properties); //added for 15756 
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
	protected static final String DELETE_DATA = "DeleteData";

	protected static final String DELETE_SQL = "DeleteSQL";
	protected static final String INSERT_SQL = "InsertSQL";
	protected static final String UPDATE_SQL = "UpdateSQL";
	protected static final String MESSAGE = "message";
	protected static final String RESULT = "result";
	protected static final Boolean TRUE = new Boolean(true);
	protected static final Boolean FALSE =	new Boolean(false);

	private final String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS";
    private final String RECORD_INSERTED = "RECORD_INSERTED";
    //private final String RECORD_MODIFIED = "RECORD_MODIFIED";
    private final String RECORD_DELETED  =	"RECORD_DELETED";
}
