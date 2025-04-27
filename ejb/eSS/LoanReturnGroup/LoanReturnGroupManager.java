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
 package eSS.LoanReturnGroup;

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
*	name="LoanReturnGroup"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="LoanReturnGroup"
*	local-jndi-name="LoanReturnGroup"
*	impl-class-name="eSS.LoanReturnGroup.LoanReturnGroupManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eSS.LoanReturnGroup.LoanReturnGroupLocal"
*	remote-class="eSS.LoanReturnGroup.LoanReturnGroupRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eSS.LoanReturnGroup.LoanReturnGroupLocalHome"
*	remote-class="eSS.LoanReturnGroup.LoanReturnGroupHome"
*	generate= "local,remote"
*
*
*/


public class  LoanReturnGroupManager extends SsEJBSessionAdapter {

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
		Connection	connection = null;
		HashMap hmReturn = new HashMap();
		PreparedStatement preparedStatement	=	null;
		String sql =	"";
		ArrayList alData = new ArrayList();
		ArrayList alRecord = new ArrayList();
		Properties properties = null;
		boolean isUpdateSuccessful = true;

		int iResult = 0;
		int failedRecordIndex = -1;
		int[] iaResult = null;
		hmReturn.put(RESULT,FALSE);

		try {
			properties =	(Properties) hmData.get("properties");
			connection = getConnection(properties);
			connection.setAutoCommit(false);

			// Insert Header Value
			alData =	(ArrayList) hmData.get("InsertHDRData");
			sql = (String) hmSQL.get	("InsertHDRSQL");
			preparedStatement = connection.prepareStatement(sql);
			setData(preparedStatement,alData);
			iResult = preparedStatement.executeUpdate();

			if(iResult != 0){
				hmReturn.put(RESULT,TRUE);
				hmReturn.put(MESSAGE,RECORD_INSERTED);
			}
			else {
				connection.rollback();
				throw new EJBException("Insert failed in header");
			}
			// Insert Detail Value
			closeStatement(preparedStatement);//COMMON-ICN-0119
			sql = null;
			alData = null;
			preparedStatement = null;

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
				throw new EJBException("Update failed while inserting detail record " + failedRecordIndex);
			}

			// Insert Discrepancy Detail Value
			closeStatement(preparedStatement);//COMMON-ICN-0119
			iaResult = null;
			sql = null;
			alData = null;
			preparedStatement = null;

			if ((hmData.containsKey("InsertDISDTLData")) && (hmSQL.containsKey("InsertDISDTLSQL"))) {
				alData = (ArrayList)	hmData.get ("InsertDISDTLData");
				sql = (String)	hmSQL.get	("InsertDISDTLSQL");
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
					throw new EJBException("Update failed while inserting discrepancy detail record " + failedRecordIndex);
				}
				closeStatement(preparedStatement);//COMMON-ICN-0119
				sql = null;
				alData = null;
				preparedStatement = null;
			}
			//Update the document no
			sql = (String)	hmSQL.get	("UpdateSQL");
			alData = (ArrayList)	hmData.get ("UpdateData");
			preparedStatement = connection.prepareStatement(sql);
			setData(preparedStatement,alData);
			iResult = preparedStatement.executeUpdate();

			if(iResult<=0){
				connection.rollback();
				throw new SQLException("Update of Document No failed");
			}

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

		Connection	connection = null;
		HashMap hmReturn = new HashMap();
		PreparedStatement preparedStatement	=	null;
		String sql =	"";
		ArrayList alData =	new ArrayList();
		ArrayList	 alRecord =	new ArrayList();
		Properties properties = null;

		int iResult =	0;
		int iaResult[] = null;
		int modify_type = Integer.parseInt((String)hmData.get("modify_type"));
		boolean isUpdateSuccessful = true;
		hmReturn.put(RESULT,FALSE);
		hmReturn.put(MESSAGE,"No records found to be modified..");
		properties =	(Properties) hmData.get("properties");

		try {
			connection = getConnection(properties);
			connection.setAutoCommit(false);
			switch (modify_type) { 
				case 1:
						alData =	(ArrayList)	hmData.get ("UpdateData");
						sql = (String)	hmSQL.get	("UpdateSQL");
						preparedStatement = connection.prepareStatement(sql);
						setData(preparedStatement,alData);
						iResult	 =	preparedStatement.executeUpdate();
						/*if(iResult!=0){
							hmReturn.put(RESULT,TRUE);
							hmReturn.put(MESSAGE,RECORD_MODIFIED);
						}*/
						if(iResult	<=0){
							isUpdateSuccessful = false;
						}
						if(!isUpdateSuccessful){
							connection.rollback();
							throw new EJBException("Update failed while inserting hdr record ");
						}
						
						alData = null;
						sql = null;

						if (hmData.containsKey("UpdateDTLData") && hmSQL.containsKey("UpdateDTLSQL")) {
							alData = (ArrayList)	hmData.get ("UpdateDTLData");
							sql = (String)	hmSQL.get	("UpdateDTLSQL");
							closeStatement(preparedStatement);//added for chekstyle 
							preparedStatement = connection.prepareStatement(sql);
							setData(preparedStatement, alData);
							iResult	 = preparedStatement.executeUpdate();
							if(iResult	<=0){
								isUpdateSuccessful = false;
							}
							if(!isUpdateSuccessful){
								connection.rollback();
								throw new EJBException("Update failed while inserting detail record ");
							}	
						}				
						//Update discrepancy detail
						alData = null;
						sql = null;
						if (hmData.containsKey ("UpdateDISDTLData") && hmSQL.containsKey("UpdateDISDTLSQL")) {
							alData = (ArrayList)	hmData.get ("UpdateDISDTLData");
							sql = (String)	hmSQL.get	("UpdateDISDTLSQL");
							closeStatement(preparedStatement);//added for 15756 
							preparedStatement = connection.prepareStatement(sql);
							setData(preparedStatement, alData);
							iResult = preparedStatement.executeUpdate();
							if(iResult	<=0){
									isUpdateSuccessful = false;
							}	
							if(!isUpdateSuccessful){
								connection.rollback();
								throw new EJBException("Update failed while inserting detail record ");
							}	
							/*if(isUpdateSuccessful){
								connection.commit();
								hmReturn.put(RESULT,TRUE);
								hmReturn.put(MESSAGE,RECORD_MODIFIED);
							}*/
							closeStatement(preparedStatement);//COMMON-ICN-0119
						}
					break;
				case 2:
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
						closeStatement(preparedStatement);//COMMON-ICN-0119
						alData = null;
						sql = null;
						// Update detail
						alData = (ArrayList)	hmData.get ("UpdateDTLData");
						sql = (String)	hmSQL.get	("UpdateDTLSQL");
						if (alData.size() >0) {
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
							closeStatement(preparedStatement);//COMMON-ICN-0119
							if(!isUpdateSuccessful){
								connection.rollback();
								throw new EJBException("Update failed while inserting detail record ");
							}	
						}
					
						//Update discrepancy detail
						alData = null;
						sql = null;
						alRecord = null;

						alData = (ArrayList)	hmData.get ("UpdateDISDTLData");
						sql = (String)	hmSQL.get	("UpdateDISDTLSQL");
						if (alData.size() >0) {
							preparedStatement.close();//added for 15756 
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
							closeStatement(preparedStatement);//COMMON-ICN-0119
						}

						//Delete Discrepancy Detail
						alData = null;
						alRecord = null;
						sql = null;
						alData = (ArrayList)	hmData.get ("DeleteDTSDTLData");
						sql = (String)	hmSQL.get	("DeleteDTSDTLSQL");
						if (alData.size() >0) {
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
						alData = null;
						sql = null;

						alData = (ArrayList)	hmData.get ("DeleteDTLData");
						sql = (String)	hmSQL.get	("DeleteDTLSQL");
						if (alData.size() >0) {
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
						if(isUpdateSuccessful){
							connection.commit();
							hmReturn.put(RESULT,TRUE);
							hmReturn.put(MESSAGE,RECORD_MODIFIED);
						}
					break;
				default :
					break;
			}
			if(isUpdateSuccessful){
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
				closeStatement(preparedStatement);//COMMON-ICN-0119
				//closeConnection(connection,(Properties)hmData.get(properties));	//commented for 15756 
				closeConnection(connection, properties); //added for 15756 
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
		//ArrayList alRecords =	new ArrayList();

		int iResult = 0;
		properties =	(Properties) hmData.get("properties");
		hmReturn.put(RESULT,FALSE);
		hmReturn.put(MESSAGE,"No record found to be deleted..");
		try {
			connection = getConnection(properties);
			connection.setAutoCommit(false);

			//Delete Discrepancy Details
			if ((hmData.containsKey("DeleteDISDTLData")) && (hmSQL.containsKey("DeleteDISDTLSQL"))) {
				alData = (ArrayList)	hmData.get("DeleteDISDTLData");
				sql = (String)	hmSQL.get	("DeleteDISDTLSQL");
				preparedStatement = connection.prepareStatement(sql);
				setData(preparedStatement,alData);
				iResult =	preparedStatement.executeUpdate();
				if(iResult<=0){
					connection.rollback();
					throw new Exception("Delete failed in Discrepancy Detail!");
				}
			}

			
			//Delete Details
			alData = (ArrayList)	hmData.get("DeleteDTLData");
			sql = (String)	hmSQL.get	("DeleteDTLSQL");
			closeStatement(preparedStatement);//added for 15756 
			preparedStatement = connection.prepareStatement(sql);
			setData(preparedStatement,alData);
			iResult		=	preparedStatement.executeUpdate();
			if(iResult<=0){
				connection.rollback();
				throw new Exception("Delete failed in header !");
			}
			closeStatement(preparedStatement);//COMMON-ICN-0119
			//Delete Header
			alData = (ArrayList)	hmData.get("DeleteHDRData");
			sql = (String)	hmSQL.get	("DeleteHDRSQL");
			preparedStatement = connection.prepareStatement(sql);
			setData(preparedStatement,alData);
			iResult		=	preparedStatement.executeUpdate();
			if(iResult<=0){
				connection.rollback();
				throw new Exception("Delete failed in header !");
			}
			closeStatement(preparedStatement);//COMMON-ICN-0119
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
				closeStatement(preparedStatement);//COMMON-ICN-0119
			//	closeConnection(connection,(Properties)hmData.get(properties));//commented for 15756  
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
