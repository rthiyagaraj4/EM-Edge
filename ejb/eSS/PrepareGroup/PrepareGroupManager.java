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
 package eSS.PrepareGroup;

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
*	name="PrepareGroup"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="PrepareGroup"
*	local-jndi-name="PrepareGroup"
*	impl-class-name="eSS.PrepareGroup.PrepareGroupManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSS.PrepareGroup.PrepareGroupLocal"
*	remote-class="eSS.PrepareGroup.PrepareGroupRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSS.PrepareGroup.PrepareGroupLocalHome"
*	remote-class="eSS.PrepareGroup.PrepareGroupHome"
*	generate= "local,remote"
*
*
*/

public class  PrepareGroupManager extends SsEJBSessionAdapter {

	public SessionContext context = null;
	
	public void setSessionContext( SessionContext sessionContext) {
		super.setSessionContext(sessionContext);
		this.context = sessionContext;
	}

/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	public HashMap insert(HashMap hmData, HashMap hmSQL)	{
		Connection	connection = null;
		HashMap hmReturn = new HashMap();
		PreparedStatement preparedStatement	=	null;
		String sql =	"";
		String HdrQuery = "";
		ArrayList alData = new ArrayList();
		ArrayList	alDtlRecords=	new ArrayList();
		Properties properties = null;

		int iResult = 0;
		hmReturn.put(RESULT,FALSE);

		try {
		//Comented By Sakti Sankar Against BRU-HIMS-CRF-370
			/*
			properties =	(Properties) hmData.get("properties");
			alData =	(ArrayList) hmData.get(INSERT_DATA);
			sql = (String) hmSQL.get	(INSERT_SQL);
			connection = getConnection(properties);
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(sql);
			setData(preparedStatement,alData);
			iResult = preparedStatement.executeUpdate();

			if(iResult != 0){
				hmReturn.put(RESULT,TRUE);
				hmReturn.put(MESSAGE,RECORD_INSERTED);
			}
			else {
				throw new SQLException("Insert failed");
			}
			*/
			properties =	(Properties) hmData.get("properties");
			connection = getConnection(properties);
            connection.setAutoCommit(false);
			//alData =	(ArrayList) hmData.get(INSERT_DATA);
			ArrayList arraylistHdrData = (ArrayList)hmData.get("InsertData");
			ArrayList arraylistCommonData = (ArrayList)hmData.get("InsertCommonData");
			HdrQuery = (String)hmSQL.get("InsertSQL");
	        
	        HashMap		hmArgData	=	new HashMap();
			HashMap		hmArgSQL	=	new HashMap();
			
	        //Added By Sakti Sankar Against BRU-HIMS-CRF-370
	        for (int i=0; i<arraylistHdrData.size();i++ ) {
	        	ArrayList	alDtlRecord	=	new ArrayList();
				HashMap hmRecord	=	(HashMap) arraylistHdrData.get(i);
				alDtlRecord.add(arraylistCommonData.get(0));
				alDtlRecord.add(arraylistCommonData.get(1));
				alDtlRecord.add(arraylistCommonData.get(2));
				alDtlRecord.add(arraylistCommonData.get(3));
				alDtlRecord.add(arraylistCommonData.get(4));
				alDtlRecord.add(arraylistCommonData.get(5));
				alDtlRecord.add(hmRecord.get("BIN_LOC_CODE"));
				alDtlRecord.add(hmRecord.get("GROUP_CODE"));
				alDtlRecord.add(hmRecord.get("PREPARE_QTY"));
				alDtlRecord.add(hmRecord.get("TOTAL_VALUE"));
				alDtlRecord.add(arraylistCommonData.get(6));
				alDtlRecord.add(arraylistCommonData.get(7));
				alDtlRecord.add(arraylistCommonData.get(8));
				alDtlRecord.add(arraylistCommonData.get(9));
				alDtlRecord.add(arraylistCommonData.get(10));
				alDtlRecord.add(arraylistCommonData.get(11));
				alDtlRecord.add(arraylistCommonData.get(12));
				alDtlRecord.add(arraylistCommonData.get(13));
				
				alDtlRecords.add(alDtlRecord);
	        }
	        

			

			hmArgData.put(DATA,alDtlRecords);   
			hmArgSQL.put("INSERT_SQL",HdrQuery);
			hmReturn	=	insertBatch(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);
			//Added ends
			sql = "";
			alData = null;
			preparedStatement = null;

			alData = (ArrayList)	hmData.get (UPDATE_DATA);
			sql = (String)	hmSQL.get	(UPDATE_SQL);
			
			preparedStatement = connection.prepareStatement(sql);
			setData(preparedStatement,alData);
			iResult		=	preparedStatement.executeUpdate();

			if(iResult!=0){
				connection.commit();
				hmReturn.put(RESULT,TRUE);
			}
			else {
				throw new SQLException("Update failed");
			}

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
					//closeConnection(connection,(Properties)hmData.get(properties));//commented for 15756
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
		Connection	connection = null;
		HashMap hmReturn = new HashMap();
		PreparedStatement preparedStatement	=	null;
		//String sql =	""; // Comented by Sakti as this is unused against inc#48061
		String HdrQuery = "";
		//ArrayList alData =	new ArrayList();
		//ArrayList	 alUpdateRecords =	new ArrayList();
		
		Properties properties = null;
		
		HashMap		hmArgData	=	new HashMap();
		HashMap		hmArgSQL	=	new HashMap();
		ArrayList arraylistData = (ArrayList)hmData.get("UpdateData");
		ArrayList arraylistHDRData = (ArrayList)hmData.get("UpdateHDRData");
		

		//int iResult =	0;
		hmReturn.put(RESULT,FALSE);
		hmReturn.put(MESSAGE,"No records found to be modified..");
		properties =	(Properties) hmData.get("properties");
		/*alData =	(ArrayList)	hmData.get (UPDATE_DATA);
		sql = (String)	hmSQL.get	(UPDATE_SQL);*/
		try {
			connection = getConnection(properties);
			connection.setAutoCommit(false);
			/*
			
			preparedStatement = connection.prepareStatement(sql);
			setData(preparedStatement,alData);
			iResult		=	preparedStatement.executeUpdate();

			if(iResult!=0){
				connection.commit();
				hmReturn.put(RESULT,TRUE);
				hmReturn.put(MESSAGE,RECORD_MODIFIED);
			}*/
			
			//Added By Sakti Sankar Against BRU-HIMS-CRF-370
	        for (int i=0; i<arraylistHDRData.size();i++ ) {
	        	ArrayList	alUpdateRecord	=	new ArrayList();
	        	ArrayList	 alInsertRecords =	new ArrayList();
				HashMap hmRecord	=	(HashMap) arraylistHDRData.get(i);
				int mode = Integer.parseInt((String)hmRecord.get("mode"));
				switch (mode) {
				case 2:{
								alUpdateRecord.add(arraylistData.get(0));
								alUpdateRecord.add(arraylistData.get(1));
								alUpdateRecord.add(arraylistData.get(2));
												
								alUpdateRecord.add(hmRecord.get("BIN_LOC_CODE"));
								alUpdateRecord.add(hmRecord.get("PREPARE_QTY"));
								alUpdateRecord.add(hmRecord.get("TOTAL_VALUE"));
								alUpdateRecord.add(arraylistData.get(3));
								alUpdateRecord.add(arraylistData.get(4));
								alUpdateRecord.add(arraylistData.get(5));
								alUpdateRecord.add(arraylistData.get(6));
								alUpdateRecord.add(arraylistData.get(7));
								alUpdateRecord.add(arraylistData.get(8));
								alUpdateRecord.add(arraylistData.get(9));
								alUpdateRecord.add(arraylistData.get(10));
								alUpdateRecord.add(hmRecord.get("GROUP_CODE"));

								
								HdrQuery = (String)hmSQL.get("UpdateSQL");
								hmArgData.put(DATA,alUpdateRecord);
								hmArgSQL.put("UPDATE_SQL",HdrQuery);
								hmReturn	=	update(connection, hmArgData, hmArgSQL);
								throwExceptionWhenFailed(hmReturn);
			}	
				break; 
				case 0:{
								alUpdateRecord.add(arraylistData.get(8));
								alUpdateRecord.add(arraylistData.get(9));
								alUpdateRecord.add(arraylistData.get(10));
								alUpdateRecord.add(hmRecord.get("GROUP_CODE"));
								
								
								HdrQuery				=	(String)	hmSQL.get ("DtlDeleteSQL");
								hmArgData.put(DATA,alUpdateRecord);
								hmArgSQL.put("DELETE_SQL",HdrQuery);
								hmReturn	=	delete(connection, hmArgData, hmArgSQL);
								throwExceptionWhenFailed(hmReturn);
				}break; 
				case 1:{
					
								alInsertRecords.add(arraylistData.get(8));
								alInsertRecords.add(arraylistData.get(9));
								alInsertRecords.add(arraylistData.get(10));
								alInsertRecords.add(arraylistData.get(0));
								alInsertRecords.add(arraylistData.get(1)); 
								alInsertRecords.add(arraylistData.get(2));
								alInsertRecords.add(hmRecord.get("BIN_LOC_CODE"));
								alInsertRecords.add(hmRecord.get("GROUP_CODE"));
								alInsertRecords.add(hmRecord.get("PREPARE_QTY"));
								alInsertRecords.add(hmRecord.get("TOTAL_VALUE"));
								alInsertRecords.add(arraylistData.get(3));
								alInsertRecords.add(arraylistData.get(4));
								alInsertRecords.add(arraylistData.get(5));
								alInsertRecords.add(arraylistData.get(6));
								alInsertRecords.add(arraylistData.get(8));
								alInsertRecords.add(arraylistData.get(5));
								alInsertRecords.add(arraylistData.get(6));
								alInsertRecords.add(arraylistData.get(7));
								
																					
								HdrQuery				=	(String)	hmSQL.get ("InsertSQL");
								hmArgData.put(DATA,alInsertRecords);
								hmArgSQL.put("INSERT_SQL",HdrQuery);
								hmReturn	=	insert(connection, hmArgData, hmArgSQL);
								throwExceptionWhenFailed(hmReturn);
				}default:{
					
				}
			}	
	 }
	    		

			/*hmArgData.put(DATA,alUpdateRecords);   
			hmArgSQL.put("INSERT_SQL",HdrQuery);
			hmReturn	=	insertBatch(connection, hmArgData, hmArgSQL);
			throwExceptionWhenFailed(hmReturn);*/
			
	        
	        //Added ends;
			
			
			
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
				connection.commit();
				if(preparedStatement!=null)
					preparedStatement.close();
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
		alData		=	(ArrayList)	hmData.get(DELETE_DATA);
		sql			=	(String)	hmSQL.get	(DELETE_SQL);
		try {
			connection = getConnection(properties);
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(sql);
			setData(preparedStatement,alData);
			iResult		=	preparedStatement.executeUpdate();

			if(iResult!=0){
				connection.commit();
				hmReturn.put(RESULT,TRUE);
				hmReturn.put(MESSAGE,RECORD_DELETED);
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
				//closeConnection(connection,(Properties)hmData.get(properties));//commented for 15756 
				closeConnection(connection, properties);//added for 15756 
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
	protected static final String INSERT_DATA = "InsertData";
	protected static final String UPDATE_DATA = "UpdateData";
	protected static final String DELETE_DATA = "DeleteData";

	protected static final String DELETE_SQL = "DeleteSQL";
	protected static final String INSERT_SQL = "InsertSQL";
	protected static final String UPDATE_SQL = "UpdateSQL";
	protected static final String MESSAGE = "message";
	protected static final String RESULT = "result";
	protected static final Boolean TRUE = new Boolean(true);
	protected static final Boolean FALSE =	new Boolean(false);

	private final String CODE_ALREADY_EXISTS = "CODE_ALREADY_EXISTS";
   // private final String RECORD_INSERTED = "RECORD_INSERTED";
   // private final String RECORD_MODIFIED = "RECORD_MODIFIED";
    private final String RECORD_DELETED  =	"RECORD_DELETED"; 
}
