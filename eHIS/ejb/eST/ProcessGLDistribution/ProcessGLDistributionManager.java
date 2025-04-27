/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST.ProcessGLDistribution;

import javax.ejb.SessionContext;
import javax.ejb.EJBException;
import eCommon.Common.*;
import eST.Common.StEJBSessionAdapter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.CallableStatement;
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
*	name="STProcessGLDistribution"
*	type="Stateless"
*	transaction-type="Bean"
*	view-type="both"
*	jndi-name="STProcessGLDistribution"
*	local-jndi-name="STProcessGLDistribution"
*	impl-class-name="eST.ProcessGLDistribution.ProcessGLDistributionManager"

*	
*
* @ejb.interface
*	extends="javax.ejb.EJBObject"
*	local-extends="javax.ejb.EJBLocalObject" 
*	local-class="eST.ProcessGLDistribution.ProcessGLDistributionLocal"
*	remote-class="eST.ProcessGLDistribution.ProcessGLDistributionRemote"
*	generate= "local,remote"
*
* @ejb.home
*	extends="javax.ejb.EJBHome" 
*	local-extends="javax.ejb.EJBLocalHome"
*	local-class="eST.ProcessGLDistribution.ProcessGLDistributionLocalHome"
*	remote-class="eST.ProcessGLDistribution.ProcessGLDistributionHome"
*	generate= "local,remote"
*
*
*/


public class  ProcessGLDistributionManager extends StEJBSessionAdapter {

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
		
		String value = "";
		boolean result = false;
		Connection	connection = null;
		HashMap hmReturn = new HashMap();
		CallableStatement callableStatement=	null;
		ArrayList alDataIn = new ArrayList();
		ArrayList alDataOut = new ArrayList();
		//ArrayList alRecords = new ArrayList();
		Properties properties = null;
		String sql =	"";
		String message_id = "";

		hmReturn.put(RESULT,FALSE);

		try {
			properties = (Properties) hmData.get("properties");
			alDataIn =	(ArrayList) hmData.get("InParameter");
			alDataOut =	(ArrayList) hmData.get("OutParameter");
			sql = (String) hmSQL.get("CallStatement");
			connection = getConnection(properties);
			connection.setAutoCommit(false);
			callableStatement	=	connection.prepareCall(sql);
			setInData(callableStatement,alDataIn);
			setOutData(callableStatement,alDataOut,alDataIn.size());
			callableStatement.execute();
			message_id = callableStatement.getString(3);
			value = callableStatement.getString(4);
			if (message_id.equals("RECORD_INSERTED")) {
				result = true;
				connection.commit();
			}
			else {
				throw new EJBException("Insert  failed");
			}
			hmReturn.put("message",RECORD_INSERTED);
			hmReturn.put("msgid",RECORD_INSERTED);
			hmReturn.put("result",new Boolean(result));
        }
		catch(SQLException sqlException) {
			try {
				connection.rollback();
				hmReturn.put(RESULT,FALSE);
				hmReturn.put(MESSAGE,"Insert Failed");
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
				hmReturn.put(MESSAGE,"Insert Failed");
				exception.printStackTrace();
			}
			catch (Exception subexception) {
				subexception.printStackTrace(); 
			}
        }
		finally{
			try{
				if(callableStatement!=null)
					callableStatement.close();
				if (connection!=null) {
					connection.close();
					//closeConnection(connection,(Properties)hmData.get(properties));	
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
		return hmReturn;
	}
	
	/**
	* @ejb.interface-method
	*	 view-type="both"
	*/
	
	public HashMap delete(HashMap hmData, HashMap hmSQL)	{
		HashMap hmReturn = new HashMap();
		return hmReturn;
	}
	
	private boolean setOutData(CallableStatement callableStatement,ArrayList alDataOut, int inSize) {
		int idx = 0;
		int size = inSize +1;
		int totalSize = size + alDataOut.size();
		boolean	returnValue	=	true;
		try {
			for (int i=size;i<totalSize;i++ ) {
				int dataType = ((Integer)alDataOut.get(idx)).intValue();
				callableStatement.registerOutParameter(i, dataType);
			}
		}
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
			returnValue	=	true;
		}
		return returnValue;
	}


	private boolean setInData(CallableStatement callableStatement, ArrayList alDataIn){
		return setInData(callableStatement,alDataIn.toArray());
	}
	
	private boolean setInData(CallableStatement callableStatement, Object objFields[]) {
        boolean	returnValue	=	true;
		try {
            for(int index = 0; index < objFields.length; index++) {
				if(objFields[index] instanceof Date) 
                    callableStatement.setDate(index + 1, (Date)objFields[index]);
			
				else if(objFields[index] instanceof Timestamp) 
                    callableStatement.setTimestamp(index + 1, (Timestamp)objFields[index]);

				else if(objFields[index] instanceof String)
                     callableStatement.setString(index + 1, (String)objFields[index]);
				
				else if(objFields[index] instanceof Integer)
					callableStatement.setInt(index + 1, ((Integer)objFields[index]).intValue());

				else if(objFields[index] instanceof Long)
                    callableStatement.setLong(index + 1, ((Long)objFields[index]).longValue());

				else if(objFields[index] instanceof Double)
                    callableStatement.setDouble(index + 1, ((Double)objFields[index]).doubleValue());

                else if(objFields[index] instanceof Float)
                    callableStatement.setFloat(index + 1, ((Float)objFields[index]).floatValue());
            }
        }
        catch(Exception exception) {
            exception.printStackTrace();
			returnValue	=	false;
        }
        return returnValue;
    }

	protected static final String INSERT_DATA = "InsertData";
	protected static final String INSERT_SQL = "InsertSQL";
	protected static final String MESSAGE = "message";
	protected static final String RESULT = "result";
	protected static final Boolean TRUE = new Boolean(true);
	protected static final Boolean FALSE =	new Boolean(false);
    private final String RECORD_INSERTED = "RECORD_INSERTED";
}
