/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eSS.Common ;

import javax.ejb.SessionContext ;
import eCommon.Common.* ;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.BatchUpdateException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class SsEJBSessionAdapter extends CommonEJBSessionAdapter {
	public SessionContext context = null ;

	public void setSessionContext( SessionContext sessionContext ) {
		super.setSessionContext(sessionContext);
		this.context = sessionContext ;
	}

		public String checkForNull(Object o) {
        return o != null ? (String)o : "";
	}
	public String checkForNull(Object o, String defaultValue) {
        return o != null ? (String)o : defaultValue;
	}

///Function for handling generic operation..
	protected HashMap insert(	Connection	connection, 
							HashMap		hmData, 
							HashMap		hmSQL )
	{
		HashMap				hmReturn			=	new HashMap();
		PreparedStatement	preparedStatement	=	null;
		String				sql					=	"";
		ArrayList			alData				=	new ArrayList();
		//ArrayList			alRecords			=	new ArrayList();

		int					iResult				=	0;
		hmReturn.put(RESULT,FALSE);

		alData		=	(ArrayList)	hmData.get	(DATA);
		sql			=	(String)	hmSQL.get	(INSERT_SQL);
		try {
			preparedStatement = connection.prepareStatement(sql);
			setData(preparedStatement,alData);
			iResult		=	preparedStatement.executeUpdate();

			if(iResult!=0){
				hmReturn.put(RESULT,TRUE);
				hmReturn.put(MSGID,RECORD_INSERTED);
				hmReturn.put(MESSAGE,RECORD_INSERTED);
//				System.err.println("SS_INSERT successfully executed on "+new java.util.Date());
//				System.err.println("SQL Received: "+sql);
//				System.err.println("DataReceived: "+alData);
			}
        }
		catch(SQLException sQLException) {
			hmReturn.put(RESULT,FALSE);
//			System.err.println("Exception occurred on "+new java.util.Date());
//			System.err.println("SQL Received: "+sql);
//			System.err.println("DataReceived: "+alData);
			if(sQLException.getErrorCode()==1){
				hmReturn.put(MSGID,CODE_ALREADY_EXISTS);
				hmReturn.put(MESSAGE,CODE_ALREADY_EXISTS);
			}
			else
				hmReturn.put(MESSAGE,sQLException.toString());

			sQLException.printStackTrace();
        }
		catch(Exception exception) {
			hmReturn.put(RESULT,FALSE);
			hmReturn.put(MESSAGE,exception.toString());
//			System.err.println("Exception occurred on "+new java.util.Date());
//			System.err.println("SQL Received: "+sql);
//			System.err.println("DataReceived: "+alData);

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
	
	protected HashMap insertBatch(		Connection	connection, 
									HashMap		hmData, 
									HashMap		hmSQL )
	{
		HashMap				hmReturn			=	new HashMap();
		PreparedStatement	preparedStatement	=	null;
		String				sql					=	"";
		ArrayList			alDataM				=	new ArrayList();
		ArrayList			alData				=	new ArrayList();
		//ArrayList			alRecords			=	new ArrayList();

		int					[]iResult			;
		int					index				=	0;
		hmReturn.put(RESULT,FALSE);

		alDataM	=   (ArrayList)	hmData.get	(DATA);
		sql		=	(String)	hmSQL.get	(INSERT_SQL);
		try {
			preparedStatement = connection.prepareStatement(sql);
			for(index=0;index<alDataM.size();index++){
				alData	=	(ArrayList)alDataM.get(index);
				setData(preparedStatement,alData);
				preparedStatement.addBatch();
			}
			iResult		=	preparedStatement.executeBatch();

			hmReturn.put(RESULT,TRUE);
			hmReturn.put(MSGID,RECORD_INSERTED);
			hmReturn.put(MESSAGE,RECORD_INSERTED);
//			System.err.println("SS_INSERT_BATCH successfully executed on "+new java.util.Date());
//			System.err.println("SQL Received: "+sql);
//			System.err.println("DataReceived: "+alDataM);
        }
		catch(BatchUpdateException batchUpdateException) {
			hmReturn.put(RESULT,FALSE);
//			System.err.println("Exception occurred on "+new java.util.Date());
//			System.err.println("SQL Received: "+sql);
//			System.err.println("DataReceived: "+alDataM);
			if(batchUpdateException.getErrorCode()==1){
				hmReturn.put(MSGID,CODE_ALREADY_EXISTS);
				hmReturn.put(MESSAGE,CODE_ALREADY_EXISTS);
			}
			else
				hmReturn.put(MESSAGE,batchUpdateException.toString());

			batchUpdateException.printStackTrace();
        }
		catch(SQLException sQLException) {
			hmReturn.put(RESULT,FALSE);
//			System.err.println("Exception occurred on "+new java.util.Date());
//			System.err.println("SQL Received: "+sql);
//			System.err.println("DataReceived: "+alDataM);
			if(sQLException.getErrorCode()==1)
				hmReturn.put(MESSAGE,CODE_ALREADY_EXISTS);
			else
				hmReturn.put(MESSAGE,sQLException.toString());

			sQLException.printStackTrace();
        }
		catch(Exception exception) {
			hmReturn.put(RESULT,FALSE);
//			System.err.println("Exception occurred on "+new java.util.Date());
//			System.err.println("SQL Received: "+sql);
//			System.err.println("DataReceived: "+alDataM);
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
	
	protected HashMap update(	Connection	connection, 
							HashMap		hmData, 
							HashMap		hmSQL )
	{
		HashMap				hmReturn			=	new HashMap();
		PreparedStatement	preparedStatement	=	null;
		String				sql					=	"";
		ArrayList			alData				=	new ArrayList();
		//ArrayList			alRecords			=	new ArrayList();

		int					iResult				=	0;
		hmReturn.put(RESULT,FALSE);
		hmReturn.put(MSGID,"NO_RECORD_UPDATED");
		hmReturn.put(MESSAGE,"No records found to be modified..");

		alData		=	(ArrayList)	hmData.get	(DATA);
		sql			=	(String)	hmSQL.get	(UPDATE_SQL);
		try {
			preparedStatement = connection.prepareStatement(sql);
			setData(preparedStatement,alData);
			iResult		=	preparedStatement.executeUpdate();

			if(iResult!=0){
				hmReturn.put(RESULT,TRUE);
				hmReturn.put(MSGID,RECORD_MODIFIED);
				hmReturn.put(MESSAGE,RECORD_MODIFIED);
//				System.err.println("SS_UPDATE successfully executed.");
//				System.err.println("SQL Received: "+sql);
//				System.err.println("DataReceived: "+alData);
			}
			else{
				throw new Exception("NO_RECORD_UPDATED");
			}
        }
		catch(Exception exception) {
			hmReturn.put(RESULT,FALSE);
//			System.err.println("Exception occurred on "+new java.util.Date());
//			System.err.println("SQL Received: "+sql);
//			System.err.println("DataReceived: "+alData);
			hmReturn.put(MSGID,exception.getMessage());
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
	
	
	protected HashMap delete(	Connection	connection, 
							HashMap		hmData, 
							HashMap		hmSQL )
	{
		HashMap				hmReturn			=	new HashMap();
		PreparedStatement	preparedStatement	=	null;
		String				sql					=	"";
		ArrayList			alData				=	new ArrayList();
		//ArrayList			alRecords			=	new ArrayList();

		int					iResult				=	0;
		hmReturn.put(RESULT,FALSE);
		hmReturn.put(MSGID,"NO_RECORD_DELETED");
		hmReturn.put(MESSAGE,"No record found to be deleted..");

		alData		=	(ArrayList)	hmData.get	(DATA);
		sql			=	(String)	hmSQL.get	(DELETE_SQL);
		try {
			preparedStatement = connection.prepareStatement(sql);
			setData(preparedStatement,alData);
			iResult		=	preparedStatement.executeUpdate();

			if(iResult!=0){
				hmReturn.put(RESULT,TRUE);
				hmReturn.put(MSGID,RECORD_DELETED);
				hmReturn.put(MESSAGE,RECORD_DELETED);
//				System.err.println("SS_DELETE successfully executed on "+new java.util.Date());
//				System.err.println("SQL Received: "+sql);
//				System.err.println("DataReceived: "+alData);
			}
        }
		catch(Exception exception) {
			hmReturn.put(RESULT,FALSE);
//			System.err.println("Exception occurred on "+new java.util.Date());
//			System.err.println("SQL Received: "+sql);
//			System.err.println("DataReceived: "+alData);
			hmReturn.put(MSGID,exception.getMessage());
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
	protected HashMap fetchRecord(Connection connection , String sql) throws Exception {
		return fetchRecord( connection , sql, (ArrayList) null);
	}

	protected HashMap fetchRecord(Connection connection , String sql, String stParameter) throws Exception {
		ArrayList alParameters	=	new ArrayList(1);
		alParameters.add(stParameter);
		return fetchRecord( connection , sql,  alParameters);
	}
	protected HashMap fetchRecord(Connection connection , String sql, String[] stParameters) throws Exception {
		ArrayList alParameters	=	new ArrayList(stParameters.length);
		for (int i=0;i< stParameters.length;i++ ) {
			alParameters.add(stParameters[i]);	
		}
		return fetchRecord(connection ,  sql,  alParameters);
	}

	protected HashMap fetchRecord(Connection connection , String sql, ArrayList alParameters) throws Exception {
		HashMap hmRecord					=	new HashMap();
		PreparedStatement preparedStatement	= null;
		ResultSet resultSet					= null;
		ResultSetMetaData resultSetMetaData	= null;

		try {
			preparedStatement = connection.prepareStatement(sql);

			if (alParameters!=null) 
				setData( preparedStatement, alParameters);

			resultSet = preparedStatement.executeQuery();
			resultSetMetaData	=	resultSet.getMetaData();

			resultSet.next();
			for (int i=1; i<=resultSetMetaData.getColumnCount(); i++ )
				hmRecord.put(resultSetMetaData.getColumnName(i),resultSet.getString(resultSetMetaData.getColumnName(i)));

		} 
		catch (Exception exception )	{
//			System.err.println("Exception @ fetch record on "+new java.util.Date());
//			System.err.println("SQL Received: "+sql);
//			System.err.println("DataReceived: "+alParameters);
			exception.printStackTrace();
			throw exception;
		} 
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(preparedStatement);
			}
			catch(Exception exception) {
				exception.printStackTrace();
			}

		}
		return hmRecord;
	}

		public ArrayList fetchRecords(Connection connection, String sql, ArrayList alParameters) throws Exception {
		ArrayList alRecords					=	new ArrayList();
		HashMap hmRecord					=	null;
		PreparedStatement preparedStatement	= null;
		ResultSet resultSet					= null;
		ResultSetMetaData resultSetMetaData	= null;

		try {
			preparedStatement = connection.prepareStatement(sql);

			if (alParameters!=null) 
				for (int index=0; index<alParameters.size() ;index++ ) {
					if(alParameters.get(index) instanceof String)
						preparedStatement.setString( index+1, ((String)alParameters.get(index)));
					else if(alParameters.get(index) instanceof Long){
						preparedStatement.setLong( index+1, ((Long)alParameters.get(index)).longValue());
					}
			}

			resultSet = preparedStatement.executeQuery();

			resultSetMetaData	=	resultSet.getMetaData();
			int i	=1	;
			while(resultSet.next())
			{
				hmRecord=new HashMap();
				for (i=1; i<=resultSetMetaData.getColumnCount(); i++ )
					hmRecord.put(resultSetMetaData.getColumnName(i),resultSet.getString(resultSetMetaData.getColumnName(i)));
				alRecords.add(hmRecord);
			}
		} 
		catch (Exception exception )	{
			exception.printStackTrace();
			throw exception;
		} 
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(preparedStatement);
			}
			catch(Exception exception) {
				exception.printStackTrace();
			}
		}
		return alRecords;
	}

	
	private boolean setData(PreparedStatement preparedStatement, ArrayList alData){
		Object []objects	=	new Object[alData.size()];
		for(int index = 0; index < alData.size(); index++)
			objects[index]=alData.get(index);
		return 	setData(preparedStatement,objects);
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

	protected HashMap getMessageHashMap(boolean bFlag){
		HashMap hmReturn	=	new HashMap();
		hmReturn.put(RESULT,bFlag?TRUE:FALSE);
		hmReturn.put(MESSAGE,"[Method body under development]Dummy Message for result: "+bFlag);
		hmReturn.put(MSGID,"BODY_NOT_DEFINED");
		return hmReturn;
	}

	protected void throwExceptionWhenFailed(HashMap hmResult) throws Exception{
		if(!((Boolean)hmResult.get(RESULT)).booleanValue()){
			throw new Exception((String)hmResult.get(MESSAGE));
		}
	}


	protected HashMap operateBatch(	Connection	connection, HashMap		hmData, HashMap		hmSQL ) {
		HashMap				hmReturn			=	new HashMap();
		PreparedStatement	preparedStatement	=	null;
		String				sql					=	"";
		ArrayList			alDataM				=	new ArrayList();
		ArrayList			alData				=	new ArrayList();
//		ArrayList			alRecords			=	new ArrayList();

		int					[]iResult			;
		int					index				=	0;
		hmReturn.put(RESULT,FALSE);

		alDataM	=   (ArrayList)	hmData.get	(DATA);
		sql		=	(String)	hmSQL.get	("BATCH_SQL");
		try {
			preparedStatement = connection.prepareStatement(sql);
			for(index=0;index<alDataM.size();index++) {
				alData	=	(ArrayList)alDataM.get(index);
				setData(preparedStatement,alData);
				preparedStatement.addBatch();
			}
			iResult		=	preparedStatement.executeBatch();

			hmReturn.put(RESULT,TRUE);

			if (sql.toUpperCase().startsWith("INSERT")) {
				hmReturn.put(MSGID,RECORD_INSERTED);
				hmReturn.put(MESSAGE,RECORD_INSERTED);

			}			
			else if (sql.toUpperCase().startsWith("UPDATE")) {
				hmReturn.put(MSGID,RECORD_MODIFIED);
				hmReturn.put(MESSAGE,RECORD_MODIFIED);

			}			
			else{
				hmReturn.put(MSGID,RECORD_DELETED);
				hmReturn.put(MESSAGE,RECORD_DELETED);
			}			
        }
		catch(BatchUpdateException batchUpdateException) {
			hmReturn.put(RESULT,FALSE);
			if(batchUpdateException.getErrorCode()==1) {
				hmReturn.put(MSGID,"RECORD_UPDATED_BY_OTH_USER"); //CODE_ALREADY_EXISTS
				hmReturn.put(MESSAGE,"RECORD_UPDATED_BY_OTH_USER"); //CODE_ALREADY_EXISTS
			}
			else {
				hmReturn.put(MESSAGE,batchUpdateException.toString());
			}
			batchUpdateException.printStackTrace();
        }
		catch(SQLException sQLException) {
			hmReturn.put(RESULT,FALSE);
			if(sQLException.getErrorCode()==1) {
				hmReturn.put(MESSAGE,"RECORD_UPDATED_BY_OTH_USER"); //CODE_ALREADY_EXISTS
			}
			else {
				hmReturn.put(MESSAGE,sQLException.toString());
			}
			sQLException.printStackTrace();
        }
		catch(Exception exception) {
			hmReturn.put(RESULT,FALSE);
			hmReturn.put(MESSAGE,exception.toString());
			exception.printStackTrace();
        }
		finally {
			try {
				if(preparedStatement!=null)preparedStatement.close();
			}
			catch (Exception exception){
				exception.printStackTrace();
			}
		}
		return hmReturn;
	}

	protected static final String DATA          =	"DATA" ;
	protected static final String DELETE_SQL    =	"DELETE_SQL" ;
	protected static final String INSERT_SQL    =	"INSERT_SQL" ;
	protected static final String UPDATE_SQL    =	"UPDATE_SQL" ;
	protected static final String MSGID			=	"msgid" ;
	protected static final String MESSAGE       =	"message" ;
	protected static final String RESULT        =	"result" ;
	protected static final Boolean TRUE         =	new Boolean(true) ;
	protected static final Boolean FALSE        =	new Boolean(false) ;

	protected final String MODE_DELETE			=	"0" ;
    protected final String MODE_INSERT			=	"1" ;
    protected final String MODE_MODIFY			=	"2" ;

	private final String CODE_ALREADY_EXISTS    =	"CODE_ALREADY_EXISTS" ;
    private final String RECORD_INSERTED        =	"RECORD_INSERTED" ;
    private final String RECORD_MODIFIED        =	"RECORD_MODIFIED" ;
    private final String RECORD_DELETED         =	"RECORD_DELETED";
}
