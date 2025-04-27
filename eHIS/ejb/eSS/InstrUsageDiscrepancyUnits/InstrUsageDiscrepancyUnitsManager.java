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
13/8/2021				TFS:20513			   Shazana															ML-MMOH-SCF-1843
--------------------------------------------------------------------------------------------------------------------------------------------
*/
 package eSS.InstrUsageDiscrepancyUnits;

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
*	name="InstrUsageDiscrepancyUnits"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="InstrUsageDiscrepancyUnits"
*	local-jndi-name="InstrUsageDiscrepancyUnits"
*	impl-class-name="eSS.InstrUsageDiscrepancyUnits.InstrUsageDiscrepancyUnitsManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSS.InstrUsageDiscrepancyUnits.InstrUsageDiscrepancyUnitsLocal"
*	remote-class="eSS.InstrUsageDiscrepancyUnits.InstrUsageDiscrepancyUnitsRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSS.InstrUsageDiscrepancyUnits.InstrUsageDiscrepancyUnitsLocalHome"
*	remote-class="eSS.InstrUsageDiscrepancyUnits.InstrUsageDiscrepancyUnitsHome"
*	generate= "local,remote"
*
*
*/



public class  InstrUsageDiscrepancyUnitsManager extends SsEJBSessionAdapter {

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
		Connection	connection					=		null;
		HashMap hmReturn						=		new HashMap();
		HashMap alRecord1						=		new HashMap();
		PreparedStatement preparedStatement		=		null;
		String sql								=		"";
		ArrayList alData						=		new ArrayList();
		ArrayList alCommonData					=		new ArrayList();
		ArrayList alRecord						=		new ArrayList();
		Properties properties					=		null;
		boolean isUpdateSuccessful				=		true;
		alCommonData							=		(ArrayList)hmData.get("CommonInsertData");
		//int iResult							=		0;
		int[] iaResult							=		null;
		int failedRecordIndex					=		-1;
		hmReturn.put(RESULT,FALSE);

		try {
			properties							=		(Properties) hmData.get("properties");
			connection							=		getConnection(properties);
			connection.setAutoCommit(false);

			//Delete Discrepancy Detail
			if (hmData.containsKey("DeleteDTLData") && hmSQL.containsKey("DeleteDTLSQL")) {
				alData							=		(ArrayList)	hmData.get ("DeleteDTLData");
				sql								=		(String)	hmSQL.get	("DeleteDTLSQL");
				preparedStatement				=		connection.prepareStatement(sql);
				for (int index = 0; index < alData.size(); index++) {
					alRecord					=		(java.util.ArrayList) alData.get(index);

					setData(preparedStatement, alRecord);
					preparedStatement.addBatch();
				}
				iaResult						=		preparedStatement.executeBatch();
				//preparedStatement.clearParameters();
				for (int i=0;i<iaResult.length ;i++){
					if((iaResult[i] != -2) && (iaResult[i]<0)){
						failedRecordIndex		=		i;
						isUpdateSuccessful		=		false;
						break;
					}	
				}
				if(!isUpdateSuccessful){
					connection.rollback();
					throw new EJBException("Insert failed while inserting detail record " + failedRecordIndex);
				}
				closeStatement(preparedStatement);//COMMON-ICN-0119
				iaResult						=		null;
				sql								=		null;
				alData							=		null;
				alRecord						=		null;
				preparedStatement				=		null;
			}

			//Update Discrepancy Detail
			if (hmData.containsKey("UpdateDTLData") && hmSQL.containsKey("UpdateDTLSQL")) {
				alData							=		(ArrayList)	hmData.get ("UpdateDTLData");
				sql								=		(String)	hmSQL.get	("UpdateDTLSQL");
				preparedStatement = connection.prepareStatement(sql);
				for (int index = 0; index < alData.size(); index++) {
					alRecord					=		(java.util.ArrayList) alData.get(index);
					setData(preparedStatement, alRecord);
					preparedStatement.addBatch();
				}
				iaResult						=		preparedStatement.executeBatch();
				//preparedStatement.clearParameters();
				for (int i=0;i<iaResult.length ;i++){
					if((iaResult[i] != -2) && (iaResult[i]<0)){
						failedRecordIndex		=		i;
						isUpdateSuccessful		=		false;
						break;
					}	
				}
				if(!isUpdateSuccessful){
					connection.rollback();
					throw new EJBException("Insert failed while inserting detail record " + failedRecordIndex);
				}
				closeStatement(preparedStatement);//COMMON-ICN-0119

				iaResult						=		null;
				sql								=		null;
				alData							=		null;
				alRecord						=		null;
				preparedStatement				=		null;
			}

			// Insert Detail Value
			alData								=		(ArrayList)	hmData.get ("InsertDTLData"); 
			sql									=		(String)	hmSQL.get	("InsertDTLSQL");
		//	ArrayList alrecord					=		null;
			//ArrayList alrecords					=		new ArrayList(); // Comented by Sakti as this is unused against inc#48061
			preparedStatement					=		connection.prepareStatement(sql);

			
		
			for (int index = 0; index < alData.size(); index++) {
				
				ArrayList alrecord				=		new ArrayList();
		
				alRecord1						=		(HashMap) alData.get(index);
				alrecord.add(alCommonData.get(2));
				alrecord.add(alRecord1.get("group_code"));
				alrecord.add(alRecord1.get("tray_no"));
				alrecord.add(alRecord1.get("item_code"));
				alrecord.add(alRecord1.get("write_off_reason_code"));
				alrecord.add(alRecord1.get("discrepancy_qty"));
				alrecord.add(alRecord1.get("discrepancy_type"));
				alrecord.add(alRecord1.get("remarks"));
				alrecord.add(alRecord1.get("store_code"));
				alrecord.add(alRecord1.get("patient_id"));
				alrecord.add(alRecord1.get("encounter_id"));
				alrecord.add(alRecord1.get("usage_ind"));
				alrecord.add("Y");//added for ML-MMOH-SCF-1843  
				alrecord.add(alCommonData.get(0));
				alrecord.add(alCommonData.get(1));
				alrecord.add(alCommonData.get(2));
				alrecord.add(alCommonData.get(3));
				alrecord.add(alCommonData.get(4));
				alrecord.add(alCommonData.get(5));
				 
				setData(preparedStatement, alrecord);
				
				preparedStatement.addBatch();
				
			}
				//setData(preparedStatement, alrecords);
				//preparedStatement.addBatch();

			iaResult						=		preparedStatement.executeBatch();
			//preparedStatement.clearParameters();
			for (int i=0;i<iaResult.length ;i++){
				if((iaResult[i] != -2) && (iaResult[i]<0)){
					failedRecordIndex		=		i;
					isUpdateSuccessful		=		false;
					break;
				}	
			}
			if(!isUpdateSuccessful){
				connection.rollback();
				throw new EJBException("Insert failed while inserting detail record " + failedRecordIndex);
			}
			
			closeStatement(preparedStatement);//COMMON-ICN-0119
			iaResult						=		null;
			sql								=		null;
			alData							=		null;
			alRecord						=		null;
			preparedStatement				=		null;
			/*
			// Update DOC No
			//Update the document no
			sql								=		(String)	hmSQL.get	("UpdateSQL");
			alData							=		(ArrayList)	hmData.get ("UpdateData");
			preparedStatement				=		connection.prepareStatement(sql);
			setData(preparedStatement, alData);
			iResult							=		preparedStatement.executeUpdate();
			//preparedStatement.clearParameters();
			if(iResult != 0){
				hmReturn.put(RESULT,TRUE);
			}
			else {
				hmReturn.put(RESULT,FALSE);
				isUpdateSuccessful = false;
			}
			if(!isUpdateSuccessful){
				connection.rollback();
				throw new EJBException("Update failed updating doc no");
			}
			iaResult						=		null;
			sql								=		null;
			alData							=		null;
			alRecord						=		null;
			preparedStatement				=		null;
			*/
			// After successful insertion and updation 
			connection.commit();
			hmReturn.put(RESULT,TRUE);
			hmReturn.put(MSGID,RECORD_INSERTED);
			hmReturn.put(MESSAGE,RECORD_INSERTED);
        }
		catch(SQLException sqlException) {
			try {
				connection.rollback();
				hmReturn.put(RESULT,FALSE);
				if(sqlException.getErrorCode()==1){
					hmReturn.put(MSGID,CODE_ALREADY_EXISTS);
					hmReturn.put(MESSAGE,CODE_ALREADY_EXISTS);
				}
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
				closeStatement(preparedStatement);
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
	public HashMap modify(HashMap hmData, HashMap hmSQL)	 {
	//	Connection	connection					=		null;
		HashMap hmReturn						=		new HashMap();
		/*
		PreparedStatement preparedStatement		=		null;
		String sql								=		"";
		ArrayList alData						=		new ArrayList();
		ArrayList	 alRecords					=		new ArrayList();
		Properties properties					=		null;

		int iResult								=		0;
		hmReturn.put(RESULT,FALSE);
		hmReturn.put(MESSAGE,"No records found to be modified..");
		properties								=		(Properties) hmData.get("properties");
		alData									=		(ArrayList)	hmData.get (UPDATE_DATA);
		sql										=		(String)	hmSQL.get	(UPDATE_SQL);
		try {
			connection							=		getConnection(properties);
			connection.setAutoCommit(false);
			preparedStatement					=		connection.prepareStatement(sql);
			setData(preparedStatement,alData);
			iResult								=		preparedStatement.executeUpdate();

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
		//Connection connection					=			null;
		HashMap hmReturn						=			new HashMap();
		/*
		PreparedStatement preparedStatement		=			null;
		String sql								=			"";
		Properties properties					=			null;

		ArrayList alData						=			new ArrayList();
		ArrayList alRecords						=			new ArrayList();

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
				closeConnection(connection,(Properties)hmData.get(properties));	
			}
			catch (Exception exception){
				exception.printStackTrace();
			}
		}
		*/
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
    private final String RECORD_INSERTED = "RECORD_INSERTED";
   // private final String RECORD_MODIFIED = "RECORD_MODIFIED";
  //  private final String RECORD_DELETED  =	"RECORD_DELETED";
}
