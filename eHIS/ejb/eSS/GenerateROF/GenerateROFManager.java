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

 package eSS.GenerateROF;

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
*	name="GenerateROF"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="GenerateROF"
*	local-jndi-name="GenerateROF"
*	impl-class-name="eSS.GenerateROF.GenerateROFManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSS.GenerateROF.GenerateROFLocal"
*	remote-class="eSS.GenerateROF.GenerateROFRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSS.GenerateROF.GenerateROFLocalHome"
*	remote-class="eSS.GenerateROF.GenerateROFHome"
*	generate= "local,remote"
*
*
*/

public class  GenerateROFManager extends SsEJBSessionAdapter {

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
	public HashMap insert(HashMap hmData, HashMap hmSQL)	{
		Connection	connection					=		 null;
		HashMap hmReturn						=		 new HashMap();
		PreparedStatement preparedStatement		=		 null;
		String sql								=		 "";
		ArrayList alData						=		 new ArrayList();
		ArrayList alRecord						=		 new ArrayList();
		Properties properties					=		 null;
		boolean isUpdateSuccessful				=		 true;

		//int iResult							=		0;
		int[] iaResult							=		null;
		int failedRecordIndex					=		-1;
		hmReturn.put(RESULT,FALSE);

		try {
			properties					=		(Properties) hmData.get("properties");
			connection					=		getConnection(properties);
			connection.setAutoCommit(false);

			// Insert Header Value
			alData						=		(ArrayList)	hmData.get ("InsertHDRData");
			sql							=		(String)	hmSQL.get	("InsertHDRSQL");
			preparedStatement			=		 connection.prepareStatement(sql);


			for (int index = 0; index < alData.size(); index++) {
				alRecord				=		(java.util.ArrayList) alData.get(index);
				setData(preparedStatement, alRecord);
				preparedStatement.addBatch();
			}
			iaResult					=		preparedStatement.executeBatch();

			//preparedStatement.clearParameters();
			for (int i=0;i<iaResult.length ;i++){
				if((iaResult[i] != -2) && (iaResult[i]<0)){
					failedRecordIndex	=		i;
					isUpdateSuccessful	=		false;
					break;
				}	
			}
			if(!isUpdateSuccessful){
				connection.rollback();
				throw new EJBException("Insert failed while inserting master record " + failedRecordIndex);
			}

			closeStatement(preparedStatement);//COMMON-ICN-0119

			// Insert Detail Value
			iaResult					=		null;
			sql							=		null;
			alData						=		null;
			alRecord					=		null;
			preparedStatement			=		null;

			alData						=		(ArrayList)	hmData.get ("InsertDTLData");
			sql							=		(String)	hmSQL.get	("InsertDTLSQL");
			preparedStatement			=		connection.prepareStatement(sql);
			for (int index = 0; index < alData.size(); index++) {
				alRecord				=		(java.util.ArrayList) alData.get(index);
				setData(preparedStatement, alRecord);
				preparedStatement.addBatch();
			}
			iaResult					=		preparedStatement.executeBatch();

			//preparedStatement.clearParameters();

			for (int i=0;i<iaResult.length ;i++){
				if((iaResult[i] != -2) && (iaResult[i]<0)){
					failedRecordIndex	=		i;
					isUpdateSuccessful	=		false;
					break;
				}	
			}
			if(!isUpdateSuccessful){
				connection.rollback();
				throw new EJBException("Insert failed while inserting detail record " + failedRecordIndex);
			}
			closeStatement(preparedStatement);//COMMON-ICN-0119
			/*
			// Update Return Detail
			iaResult					=		null;
			sql							=		null;
			alData						=		null;
			alRecord					=		null;
			preparedStatement			=		null;
			
			alData						=		(ArrayList)	hmData.get ("UpdateDTLData");
			sql							=		(String)	hmSQL.get	("UpdateDTLSQL");
			preparedStatement = connection.prepareStatement(sql);
			for (int index = 0; index < alData.size(); index++) {
				alRecord				=		(java.util.ArrayList) alData.get(index);
				setData(preparedStatement, alRecord);
				preparedStatement.addBatch();
			}
			iaResult					=		preparedStatement.executeBatch();
			//preparedStatement.clearParameters();
			for (int i=0;i<iaResult.length ;i++){
				if((iaResult[i] != -2) && (iaResult[i]<0)){
					failedRecordIndex	=		i;
					isUpdateSuccessful	=		false;
					break;
				}	
			}
			if(!isUpdateSuccessful){
				connection.rollback();
				throw new EJBException("Update failed while updating return detail record " + failedRecordIndex);
			}
			*/
			// Update DOC No
			iaResult					=		null;
			sql							=		null;
			alData						=		null;
			alRecord					=		null;
			preparedStatement			=		null;
			
			//Update the document no
			sql							=		(String)	hmSQL.get	("UpdateSQL");
			alData						=		(ArrayList)	hmData.get ("UpdateData");
			preparedStatement			=		connection.prepareStatement(sql);

			for (int index = 0; index < alData.size(); index++) {
				alRecord				=		(java.util.ArrayList) alData.get(index);
				setData(preparedStatement, alRecord);
				preparedStatement.addBatch();
			}
			iaResult					=		preparedStatement.executeBatch();
			//preparedStatement.clearParameters();

			for (int i=0;i<iaResult.length ;i++){
				if((iaResult[i] != -2) && (iaResult[i]<0)){
					failedRecordIndex	=		i;
					isUpdateSuccessful	=		false;
					break;
				}	
			}
			if(!isUpdateSuccessful){
				connection.rollback();
				throw new EJBException("Update failed updating doc no index :" + failedRecordIndex);
			}
			closeStatement(preparedStatement);//COMMON-ICN-0119

			iaResult					=		null;
			sql							=		null;
			alData						=		null;
			alRecord					=		null;
			preparedStatement			=		null;

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
				closeStatement(preparedStatement);//COMMON-ICN-0119
				if (connection!=null) {
				//	closeConnection(connection,(Properties)hmData.get(properties));	//commented for 15756 
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

	public HashMap modify(HashMap hmData, HashMap hmSQL)	 {
		HashMap hmReturn = new HashMap();
		Connection connection = null;
		PreparedStatement preparedStatement	=	null;
		String sql =	"";
		ArrayList alData =	new ArrayList();
		ArrayList	 alRecord =	new ArrayList();
		Properties properties = null;
		int iResult =	0;
		int iaResult[] = null;
		boolean isUpdateSuccessful = true;
		
		hmReturn.put(RESULT,FALSE);
		hmReturn.put(MESSAGE,"No records found to be modified..");
		try {
			properties =	(Properties) hmData.get("properties");
			connection = getConnection(properties);
			connection.setAutoCommit(false);
			// Update Header
			alData = (ArrayList)	hmData.get ("UpdateHDRData");
			sql = (String)	hmSQL.get	("UpdateHDRSQL");
			preparedStatement = connection.prepareStatement(sql);
			setData(preparedStatement, alData);
			iResult = preparedStatement.executeUpdate();
			if(iResult != 0){
				hmReturn.put(RESULT,TRUE);
				hmReturn.put(MESSAGE,RECORD_INSERTED);
			}
			else {
				connection.rollback();
				throw new EJBException("Update failed in header");
			}
			alData = null;
			sql = null;
			// Update Detail
			alData = (ArrayList)	hmData.get ("UpdateDTLData");
			sql = (String)	hmSQL.get	("UpdateDTLSQL");
			if (alData != null && alData.size() >0) {
				closeStatement(preparedStatement);//added for 15756  
				preparedStatement = connection.prepareStatement(sql);
				for (int index = 0; index < alData.size(); index++) {
					alRecord = (java.util.ArrayList) alData.get(index);
					setData(preparedStatement, alRecord);
					preparedStatement.addBatch();
				}
				iaResult = preparedStatement.executeBatch();
				for (int i=0;i<iaResult.length ;i++){
					if((iaResult[i] != -2) && (iaResult[i]<0)){
						isUpdateSuccessful = false;
						break;
					}	
				}
				if(!isUpdateSuccessful){
					connection.rollback();
					throw new EJBException("Update failed while inserting detail record ");
				}	
			}

			//Delete Detail
			alData = (ArrayList)	hmData.get("DeleteDTLData");
			sql = (String)	hmSQL.get	("DeleteDTLSQL");
			if (alData != null && alData.size() >0) {
				closeStatement(preparedStatement);//added for 15756 
				preparedStatement = connection.prepareStatement(sql);
				for (int index = 0; index < alData.size(); index++) {
					alRecord = (java.util.ArrayList) alData.get(index);
					setData(preparedStatement, alRecord);
					preparedStatement.addBatch();
				}
				iaResult = preparedStatement.executeBatch();
				for (int i=0;i<iaResult.length ;i++){
					if((iaResult[i] != -2) && (iaResult[i]<0)){
						isUpdateSuccessful = false;
						break;
					}	
				}
				if(!isUpdateSuccessful){
					connection.rollback();
					throw new EJBException("Update failed while inserting detail record ");
				}	
			}

			//Add Detail
			alData = (ArrayList)	hmData.get("InsertDTLData");
			sql = (String)	hmSQL.get	("InsertDTLSQL");
			if (alData != null && alData.size() >0) {
				closeStatement(preparedStatement);//COMMON-ICN-0119

				preparedStatement = connection.prepareStatement(sql);
				for (int index = 0; index < alData.size(); index++) {
					alRecord = (java.util.ArrayList) alData.get(index);
					setData(preparedStatement, alRecord);
					preparedStatement.addBatch();
				}
				iaResult = preparedStatement.executeBatch();
				for (int i=0;i<iaResult.length ;i++){
					if((iaResult[i] != -2) && (iaResult[i]<0)){
						isUpdateSuccessful = false;
						break;
					}	
				}
				if(!isUpdateSuccessful){
					connection.rollback();
					throw new EJBException("Update failed while inserting detail record ");
				}	
			}

			if(isUpdateSuccessful){
				connection.commit();
				hmReturn.put(RESULT,TRUE);
				hmReturn.put(MESSAGE,RECORD_MODIFIED);
			}
		}
		catch (Exception exception) {
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
				 closeStatement(preparedStatement);//COMMON-ICN-0119
				//closeConnection(connection,(Properties)hmData.get(properties));	//commented for 15756 
				closeConnection(connection, properties);//added for 15756  
			}
			catch (Exception subexception){
				subexception.printStackTrace();
			}
		}
		return hmReturn;
	}
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap delete(HashMap hmData, HashMap hmSQL)	{
		Connection connection = null;
		PreparedStatement preparedStatement	=	null;
		HashMap hmReturn = new HashMap();
		Properties properties = null;
		ArrayList alData =	new ArrayList();
		//ArrayList alRecords =	new ArrayList();
		String sql = "";

		int iResult = 0;
		properties =	(Properties) hmData.get("properties");
		hmReturn.put(RESULT,FALSE);
		hmReturn.put(MESSAGE,"No record found to be deleted..");
		try {
			properties =	(Properties) hmData.get("properties");
			connection = getConnection(properties);
			connection.setAutoCommit(false);
			//Delete Details
			alData = (ArrayList)	hmData.get("DeleteDTLData");
			sql = (String)	hmSQL.get	("DeleteDTLSQL");
			preparedStatement = connection.prepareStatement(sql);
			setData(preparedStatement,alData);
			iResult		=	preparedStatement.executeUpdate();
			if(iResult<=0){
				connection.rollback();
				throw new Exception("Delete failed in header !");
			}

			//Delete Header
			alData = (ArrayList)	hmData.get("DeleteHDRData");
			sql = (String)	hmSQL.get	("DeleteHDRSQL");
			closeStatement(preparedStatement);//added for 15756 
			preparedStatement = connection.prepareStatement(sql);
			setData(preparedStatement,alData);
			iResult		=	preparedStatement.executeUpdate();
			if(iResult<=0){
				connection.rollback();
				throw new Exception("Delete failed in header !");
			}
			connection.commit();
			hmReturn.put(RESULT,TRUE);
			hmReturn.put(MESSAGE,RECORD_DELETED);			
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
				closeStatement(preparedStatement);
				//closeConnection(connection,(Properties)hmData.get(properties));	//commented for 15756  
				closeConnection(connection, properties);;//added for 15756  
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

	protected final String UPDATE_DATA = "UpdateData";
	protected final String UPDATE_SQL = "UpdateSQL";
	protected final String MESSAGE = "message";
	protected final String RESULT = "result";
	protected final Boolean TRUE = new Boolean(true);
	protected final Boolean FALSE =	new Boolean(false);

	private final String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS";
    private final String RECORD_INSERTED = "RECORD_INSERTED";
    private final String RECORD_MODIFIED = "RECORD_MODIFIED";
    private final String RECORD_DELETED  =	"RECORD_DELETED";
}
