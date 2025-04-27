/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eSS.SsTransaction;

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
*	name="SsTransaction"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="SsTransaction"
*	local-jndi-name="SsTransaction"
*	impl-class-name="eSS.SsTransaction.SsTransactionManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSS.SsTransaction.SsTransactionLocal"
*	remote-class="eSS.SsTransaction.SsTransactionRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSS.SsTransaction.SsTransactionLocalHome"
*	remote-class="eSS.SsTransaction.SsTransactionHome"
*	generate= "local,remote"
*
*
*/


public class  SsTransactionManager extends SsEJBSessionAdapter {

	public SessionContext context = null;
	private Connection	connection = null;

	public void setSessionContext( SessionContext sessionContext) {
		super.setSessionContext(sessionContext);
		this.context = sessionContext;
	}

	public void beginTransaction(Properties properties) {
		try {
			connection = getConnection(properties);
			connection.setAutoCommit(false);
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		return;
	}

	public void commitTransaction() {
		try {
			connection.commit();
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		return;
	}

	public void rollbackTransaction() {
		try {
			connection.rollback();
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		return;
	}

	public void closeConnection(Properties properties) {
		try {
			closeConnection(connection,properties);	
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		
	}
	
///Function for handling generic operation..

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap insert(HashMap hmData, HashMap hmSQL)	{
		HashMap hmReturn = new HashMap();
		PreparedStatement preparedStatement	=	null;
		String sql =	"";
		ArrayList alData = new ArrayList();
		//ArrayList alRecords = new ArrayList();

		int iResult = 0;
		hmReturn.put(RESULT,FALSE);

		alData =	(ArrayList) hmData.get	(DATA);
		sql = (String) hmSQL.get	(INSERT_SQL);
		try {
			//System.err.println(sql);
			preparedStatement = connection.prepareStatement(sql);
			setData(preparedStatement,alData);
			iResult = preparedStatement.executeUpdate();

			if(iResult != 0){
				hmReturn.put(RESULT,TRUE);
				hmReturn.put(MESSAGE,RECORD_INSERTED);
			}
        }
		catch(SQLException sqlException) {
			hmReturn.put(RESULT,FALSE);
			if(sqlException.getErrorCode()==1)
				hmReturn.put(MESSAGE,CODE_ALREADY_EXISTS);
			else
				hmReturn.put(MESSAGE,sqlException.toString());
			sqlException.printStackTrace();
        }
		catch(Exception exception) {
			hmReturn.put(RESULT,FALSE);
			hmReturn.put(MESSAGE,exception.toString());
			exception.printStackTrace();
        }
		finally{
			try{
				if(preparedStatement!=null)
					preparedStatement.close();
			}
			catch (Exception exception){
				exception.printStackTrace();
			}
		}
		return hmReturn;
	}
	
	public HashMap insertBatch(HashMap hmData,HashMap hmSQL)	{
		HashMap hmReturn = new HashMap();
		PreparedStatement preparedStatement = null;
		String sql =	"";
		ArrayList alDatas = new ArrayList();
		ArrayList alData =	new ArrayList();
		//ArrayList alRecords =	new ArrayList();

		int					[]iResult			;
		int					index				=	0;
		hmReturn.put(RESULT,FALSE);

		alDatas	=   (ArrayList)	hmData.get	(DATA);
		sql		=	(String)	hmSQL.get	(INSERT_SQL);
		try {
			preparedStatement = connection.prepareStatement(sql);
			for(index=0;index<alDatas.size();index++){
				alData	=	(ArrayList)alDatas.get(index);
				setData(preparedStatement,alData);
				preparedStatement.addBatch();
			}
			iResult		=	preparedStatement.executeBatch();

			hmReturn.put(RESULT,TRUE);
			hmReturn.put(MESSAGE,RECORD_INSERTED);
        }
		catch(BatchUpdateException batchUpdateException) {
			hmReturn.put(RESULT,FALSE);
			if(batchUpdateException.getErrorCode()==1)
				hmReturn.put(MESSAGE,CODE_ALREADY_EXISTS);
			else
				hmReturn.put(MESSAGE,batchUpdateException.toString());
			batchUpdateException.printStackTrace();
        }
		catch(SQLException sqlException) {
			hmReturn.put(RESULT,FALSE);
			if(sqlException.getErrorCode()==1)
				hmReturn.put(MESSAGE,CODE_ALREADY_EXISTS);
			else
				hmReturn.put(MESSAGE,sqlException.toString());
			sqlException.printStackTrace();
        }
		catch(Exception exception) {
			hmReturn.put(RESULT,FALSE);
			hmReturn.put(MESSAGE,exception.toString());

			exception.printStackTrace();
        }
		finally{
			try{
				if(preparedStatement!=null)
					preparedStatement.close();
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
		PreparedStatement preparedStatement	=	null;
		String sql =	"";
		ArrayList alData =	new ArrayList();
		//ArrayList	 alRecords =	new ArrayList();

		int iResult =	0;
		hmReturn.put(RESULT,FALSE);
		hmReturn.put(MESSAGE,"No records found to be modified..");

		alData		=	(ArrayList)	hmData.get	(DATA);
		sql			=	(String)	hmSQL.get	(UPDATE_SQL);
		try {
			preparedStatement = connection.prepareStatement(sql);
			setData(preparedStatement,alData);
			iResult		=	preparedStatement.executeUpdate();

			if(iResult!=0){
				hmReturn.put(RESULT,TRUE);
				hmReturn.put(MESSAGE,RECORD_MODIFIED);
			}
        }
		catch(Exception exception) {
			hmReturn.put(RESULT,FALSE);
			hmReturn.put(MESSAGE,exception.toString());
			exception.printStackTrace();
        }
		finally{
			try{
				if(preparedStatement!=null)
					preparedStatement.close();
			}
			catch (Exception exception){
				exception.printStackTrace();
			}
		}
		return hmReturn;
	}
	
	public HashMap modifyBatch(HashMap hmData, HashMap hmSQL) {
		HashMap hmResult = new HashMap();
		PreparedStatement preparedStatement = null;
		String sql = "";
		ArrayList alData = new ArrayList();
		ArrayList alRecord = new ArrayList();
		boolean isUpdateSuccessful = true;
		int failedRecordIndex = -1;

		int[] updateResult = null;
		hmResult.put(RESULT,FALSE);
		hmResult.put(MESSAGE,"No records found to be modified..");

		alData = (ArrayList) hmData.get (DATA);
		sql = (String) hmSQL.get (UPDATE_SQL);
		try {
			preparedStatement = connection.prepareStatement(sql);
			for (int index = 0; index < alData.size(); index++) {
				alRecord = (java.util.ArrayList) alData.get(index);
				setData(preparedStatement, alRecord);
				preparedStatement.addBatch();
			}
			updateResult = preparedStatement.executeBatch();
			preparedStatement.clearParameters();
			for (int i=0;i<updateResult.length ;i++){
				if((updateResult[i] != -2) && (updateResult[i]<0)){
					failedRecordIndex = i;
					isUpdateSuccessful = false;
					break;
				}	
			}
			
			if(isUpdateSuccessful){
				hmResult.put(RESULT,TRUE);
				hmResult.put(MESSAGE,RECORD_MODIFIED);
			}
			else {
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
			}
			catch (Exception exception){
				exception.printStackTrace();
			}
		}
		return hmResult;
	}
	
/**
	* @ejb.interface-method
	*	 view-type="both"
	*/

	public HashMap delete(HashMap hmData, HashMap hmSQL)	{
		HashMap hmReturn = new HashMap();
		PreparedStatement preparedStatement	=	null;
		String sql = "";
		ArrayList alData =	new ArrayList();
		//ArrayList alRecords =	new ArrayList();

		int iResult = 0;
		hmReturn.put(RESULT,FALSE);
		hmReturn.put(MESSAGE,"No record found to be deleted..");

		alData		=	(ArrayList)	hmData.get	(DATA);
		sql			=	(String)	hmSQL.get	(DELETE_SQL);
		try {
			preparedStatement = connection.prepareStatement(sql);
			setData(preparedStatement,alData);
			iResult		=	preparedStatement.executeUpdate();

			if(iResult!=0){
				hmReturn.put(RESULT,TRUE);
				hmReturn.put(MESSAGE,RECORD_DELETED);
			}
        }
		catch(Exception exception) {
			hmReturn.put(RESULT,FALSE);
			hmReturn.put(MESSAGE,exception.toString());
			exception.printStackTrace();
        }
		finally{
			try{
				if(preparedStatement!=null)preparedStatement.close();
			}
			catch (Exception exception){
				exception.printStackTrace();
			}
		}
		return hmReturn;
	}
	
	private boolean setData(PreparedStatement preparedStatement, ArrayList alData){
		return 	setData(preparedStatement,alData.toArray());
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
	protected static final String DATA = "InsertData";
	protected static final String DELETE_SQL = "DeleteSQL";
	protected static final String INSERT_SQL = "InsertSQL";
	protected static final String UPDATE_SQL = "UpdateSQL";
	protected static final String MESSAGE = "message";
	protected static final String RESULT = "result";
	protected static final Boolean TRUE = new Boolean(true);
	protected static final Boolean FALSE =	new Boolean(false);

	private final String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS";
    private final String RECORD_INSERTED = "RECORD_INSERTED";
    private final String RECORD_MODIFIED = "RECORD_MODIFIED";
    private final String RECORD_DELETED  =	"RECORD_DELETED";
}
