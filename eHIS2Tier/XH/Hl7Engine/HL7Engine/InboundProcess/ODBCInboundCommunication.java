package HL7Engine.InboundProcess ;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import HL7Engine.Common.Common;
import HL7Engine.Common.CommonUtil;

import java.sql.Clob;

import oracle.sql.CLOB;

public class ODBCInboundCommunication extends Thread
{
    Connection externalDBConn = null;
    Connection eHISDBConn = null;
    CallableStatement registerErrorStmt = null;
    CallableStatement validateCStmt = null;

    boolean logToFile ;
    String strLogFile ;
    String strExceptionLogFile ;

    InboundServerDBInteraction serverDB;
    InboundServerParameters serverParameters;

    int sleepTime = 3; // Time in seconds. Variable used to make the process sleep for every iteration.
    int loaderSleepParam = 6; // Time in seconds. Variable used to make the message loader process sleep for every iteration.

    Common common = null;	
    boolean updateStatusYN = false; // Flag indicates whether to update the status in the external database or not.

    public ODBCInboundCommunication(InboundServerParameters serverParameters, InboundServerDBInteraction serverDB)
    {
	common = Common.getInstance();
	this.serverDB = serverDB;
	this.serverParameters = serverParameters;
	externalDBConn = serverDB.externalDBConn;
	eHISDBConn = serverDB.connDB;
	serverDB.updateProcessComStatus("Y");
	this.start();
    }	

    public void run()
    {		
	transferMsgToEHIS();
    }

    public void transferMsgToEHIS()
    {			
	PreparedStatement pstmt = null;			

	boolean recordsFound = false;
	int recCount = 0;

	String oraTabQuery = serverParameters.odbcQryNxtMsg;
	//	String comIOAPI = serverParameters.strCommdataIoApi;
	//	String comStaAPI = serverParameters.strCommStatistics;

	String applicationID = "";
	String facilityID = "";
	String srlNo = "";
	String msgText = "";
	String errMsg = "";
	String msgID = "";
	
	oracle.sql.CLOB l_msg_clob = null;

	String msgValidationProc = "{ call XHLAYERS.VALIDATION_LAYER(?,?,?,?,?,?) }";
	//	String fetchQry = "SELECT a.oracle_table_qry,a.comm_data_input_output_api,a.comm_statistics_api FROM xh_protocol a,xh_protocol_link b WHERE a.protocol_id=b.protocol_id AND b.protocol_link_id = ?";
	String insertQry = "INSERT INTO "+serverParameters.strModuleId+"_inbound_message(application_id,facility_id,message_id,srl_no,"+
	"message_received_date,process_id,client_id,inbound_message_text,message_ack_text,message_status,"+
	"rd_order_yn,err_msg,added_by_id,added_date,modified_by_id,modified_date,added_at_ws_no,added_facility_id,"+
	"modified_facility_id,modified_at_ws_no,event_type,patient_id,merged_patient_id,episode_type,episode_id,"+
	"visit_id,accession_num,action_type,last_proc_date,event_status,not_req_reason,ext_accession_num,query_id,protocol_link_id) "+
	"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	try
	{						  					
	    //	pstmt = eHISDBConn.prepareStatement(fetchQry);
	    //	pstmt.setString(1,serverParameters.strProtocalLinkId);
	    if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "(ODBCInboundCommunication:transferMsgToEHIS) Update External DB :"+updateStatusYN+" \n" );

	    validateCStmt = eHISDBConn.prepareCall(msgValidationProc);
	    String tempEventType = "";
	    String tempOraTabQry = "";
	    while(true)
	    {
		//	ResultSet rs = null;
		ResultSet oraTabRS = null;
		Statement oraTabStmt = null;

		try
		{
		    if(!eHISDBConn.isClosed() && !externalDBConn.isClosed())
		    {
			/*	**** TO BE DELETED... BACK UP CODE... ****
				rs = pstmt.executeQuery();
				if(rs.next())
				{
				oraTabQuery = rs.getString(1);
				comIOAPI = rs.getString(2);
				comStaAPI = rs.getString(3);					
				}
				else
				{
				oraTabQuery = "";
				comIOAPI = "";
				comStaAPI = "";
				if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "(ODBCInboundCommunication:transferMsgToEHIS) Table Query does not exist \n" );
				}
			 */
			recordsFound = false;
			oraTabStmt = externalDBConn.createStatement();				
			String lastProcMsgID = getLastMessageID();

			if(!updateStatusYN)
			{
			    tempOraTabQry = oraTabQuery + 
			    " WHERE TO_NUMBER(message_id) > TO_NUMBER('"+lastProcMsgID+"') ORDER BY TO_NUMBER(message_id) asc";
			}

			oraTabRS = oraTabStmt.executeQuery(tempOraTabQry);

			validateCStmt.setString(1,"I");					
			validateCStmt.registerOutParameter(5,java.sql.Types.VARCHAR);
			validateCStmt.registerOutParameter(6,java.sql.Types.VARCHAR);

			while(oraTabRS.next())
			{	
			    PreparedStatement insertPStmt = null;
			    try
			    {
				serverParameters.longStartTime = System.currentTimeMillis();
				recordsFound = true;
				msgText = CommonUtil.formatClob(oraTabRS.getClob("INBOUND_MESSAGE_TEXT"));

				applicationID = oraTabRS.getString("application_id");
				msgID = oraTabRS.getString("message_id");
				srlNo = oraTabRS.getString("srl_no");
				facilityID = oraTabRS.getString("facility_id");
				tempEventType = oraTabRS.getString("event_type");

				if(serverParameters.logToFile) common.fileOutput(serverParameters.strLogFile, "(ODBCInboundCommunication:transferMsgToEHIS) Message:"+msgText+" \n" );

				validateCStmt.setString(2,applicationID);
				validateCStmt.setString(3,tempEventType);
				validateCStmt.setString(4,msgText);

				validateCStmt.execute();
				errMsg = validateCStmt.getString(6);

				if(serverParameters.logToFile) common.fileOutput(serverParameters.strLogFile, "(ODBCInboundCommunication:transferMsgToEHIS) errMsg for "+msgID+" is :"+errMsg+" \n" );

				insertPStmt = eHISDBConn.prepareStatement(insertQry);
				//	insertPStmt.setString(1,serverParameters.strModuleId);
				insertPStmt.setString(1,applicationID);
				insertPStmt.setString(2,facilityID);
				insertPStmt.setString(3,msgID);
				insertPStmt.setString(4,srlNo);
				insertPStmt.setTimestamp(5,oraTabRS.getTimestamp("MESSAGE_RECEIVED_DATE"));
				insertPStmt.setString(6,oraTabRS.getString("process_id"));
				insertPStmt.setString(7,oraTabRS.getString("client_id"));

				//Commented by Niveditha for GHL-SCF-1536 on 14/12/2020
				//insertPStmt.setString(8,msgText);
				
				//Added by Niveditha for GHL-SCF-1536 on 14/12/2020
				l_msg_clob = stringToClob(msgText, eHISDBConn);
				insertPStmt.setClob(8, l_msg_clob);
				
				insertPStmt.setString(9,CommonUtil.formatClob(oraTabRS.getClob("message_ack_text")));// Column Name changed for the issue GHL-SCF-1389 on 30/10/2018
				insertPStmt.setString(10,"S");
				insertPStmt.setString(11,oraTabRS.getString("rd_order_yn"));
				insertPStmt.setString(12,errMsg);
				insertPStmt.setString(13,oraTabRS.getString("added_by_id"));
				insertPStmt.setTimestamp(14,oraTabRS.getTimestamp("added_date"));
				//	insertPStmt.setDate(14,new java.sql.Date(System.currentTimeMillis()));
				insertPStmt.setString(15,oraTabRS.getString("modified_by_id"));
				insertPStmt.setTimestamp(16,oraTabRS.getTimestamp("modified_date"));
				//	insertPStmt.setDate(16,new java.sql.Date(System.currentTimeMillis()));
				insertPStmt.setString(17,oraTabRS.getString("added_at_ws_no"));
				insertPStmt.setString(18,oraTabRS.getString("ADDED_FACILITY_ID"));
				insertPStmt.setString(19,oraTabRS.getString("MODIFIED_FACILITY_ID"));
				insertPStmt.setString(20,oraTabRS.getString("MODIFIED_AT_WS_NO"));
				insertPStmt.setString(21,oraTabRS.getString("event_type"));
				insertPStmt.setString(22,oraTabRS.getString("patient_id"));
				insertPStmt.setString(23,oraTabRS.getString("MERGED_PATIENT_ID"));
				insertPStmt.setString(24,oraTabRS.getString("episode_type"));
				insertPStmt.setString(25,oraTabRS.getString("episode_id"));
				insertPStmt.setString(26,oraTabRS.getString("visit_id"));
				insertPStmt.setString(27,oraTabRS.getString("accession_num"));
				insertPStmt.setString(28,oraTabRS.getString("action_type"));
				insertPStmt.setTimestamp(29,oraTabRS.getTimestamp("last_proc_date"));
				//	insertPStmt.setDate(29,new java.sql.Date(System.currentTimeMillis()));
				insertPStmt.setString(30,oraTabRS.getString("event_status"));
				insertPStmt.setString(31,oraTabRS.getString("not_req_reason"));
				insertPStmt.setString(32,oraTabRS.getString("EXT_ACCESSION_NUM"));
				insertPStmt.setString(33,oraTabRS.getString("query_id"));
				insertPStmt.setString(34,oraTabRS.getString("protocol_link_id"));

				int i = insertPStmt.executeUpdate();							

				if(i > 0)
				{
				    if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "(ODBCInboundCommunication:transferMsgToEHIS) Record inserted for message ID :"+msgID+" \n" );
				    if((errMsg == null || errMsg.equals("")) && updateStatusYN)
				    {
					updateMessageStatus("S",serverParameters.strModuleId,msgID,errMsg,applicationID,facilityID,srlNo);
				    }
				    else if(updateStatusYN)
				    {
					updateMessageStatus("E",serverParameters.strModuleId,msgID,errMsg,applicationID,facilityID,srlNo);
				    }
				    updateMsgID(msgID);
				    serverDB.commit();
				}
			    }
			    catch(Exception exp)
			    {
				common.fileOutput( serverParameters.strLogFile, "(ODBCInboundCommunication:transferMsgToEHIS)Exception in inserting record: "+exp.getMessage()+"\n" );							
				common.fileOutput( serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) +"\n" );
				//	String error = "Error in main transaction while inserting record";
				//	registerError(applicationID,msgID,facilityID,srlNo,error,exp.getMessage());
			    }
			    finally
			    {
				if(insertPStmt != null) insertPStmt.close();
			    }
			}
			if(!recordsFound && serverParameters.logToFile && recCount == 10)
			{
			    common.fileOutput( serverParameters.strLogFile, "(ODBCInboundCommunication:transferMsgToEHIS) Records not found \n" );
			    recCount = 0;
			    Thread.sleep(serverParameters.intRetryInterval);
			}
			else if(!recordsFound)
			{
			    Thread.sleep(serverParameters.intRetryInterval);
			}
			recCount++;
			applicationID = "";
			msgID = "";
			facilityID = "";
			srlNo = "";						
			Thread.sleep(sleepTime*1000); // Thread will sleep for 'sleepTime' seconds every iteration
		    }
		}
		catch(SQLException exceptionSQL)
		{
		    common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exceptionSQL) + "\n");			
		    serverDB.checkExeDBConnection(serverParameters.odbcDBSID);

		    if(serverParameters.isExternalDBDown)
		    {
			IBHelper.getInstance(serverDB).checkExeDBConnection();
		    }
		}
		catch(Exception exp)
		{
		    common.fileOutput(serverParameters.strLogFile, "(ODBCInboundCommunication:transferMsgToEHIS)Exception in main transaction: "+exp.getMessage()+"\n" );
		    common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) +"\n" );
		    Thread.sleep(sleepTime*1000); // waiting time for next trail
		}
		finally
		{
		    if(oraTabStmt != null) oraTabStmt.close();
		    if(oraTabRS != null) oraTabRS.close();
		}
	    }
	    //	}
	}
	catch(Exception exp)
	{
	    common.fileOutput(serverParameters.strLogFile, "(ODBCInboundCommunication:transferMsgToEHIS) Exception: "+exp.getMessage()+"\n" );			
	    common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) +"\n" );			
	}
	finally
	{
	    try
	    {								
		if(pstmt != null) pstmt.close();
		if(validateCStmt != null) validateCStmt.close();
		if(externalDBConn != null) externalDBConn.close();
		if(eHISDBConn != null) eHISDBConn.close();
	    }
	    catch(Exception exp)
	    {
	    }
	}
    }

    /**
     * Method to update message status in external database.
     */
    public void updateMessageStatus(String status,String module,String msgID,String errMsg,String applicationID,String facilityID,String srlNo)
    {
	String updateQry = null;
	PreparedStatement pstmt = null;

	if(module != null && !module.equals(""))
	{
	    updateQry = "UPDATE " + module + "_inbound_message SET message_status=?,err_msg=?";
	}
	else
	{
	    updateQry = "UPDATE xh_inbound_message SET message_status=?,err_msg=?";
	}
	String whrClause = " WHERE application_id=? AND facility_id=? AND message_id=? AND srl_no=?";		

	try
	{
	    updateQry = updateQry + whrClause;

	    pstmt = externalDBConn.prepareStatement(updateQry);
	    pstmt.setString(1,status);
	    pstmt.setString(2,errMsg);
	    pstmt.setString(3,applicationID);
	    pstmt.setString(4,facilityID);
	    pstmt.setString(5,msgID);
	    pstmt.setInt(6,Integer.parseInt(srlNo));

	    int i = pstmt.executeUpdate();
	    if(i > 0) 
	    {
		if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "(ODBCInboundCommunication:updateMessageStatus) Status updated for message :"+msgID+" as "+status+" \n" );				
	    }
	}
	catch(Exception exp)
	{
	    try
	    {
		common.fileOutput( serverParameters.strLogFile, "(ODBCInboundCommunication:updateMessageStatus) Exception: "+exp.getMessage()+"\n" );
		common.fileOutput( serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) +"\n" );
		String error = "Error in updating message status";
		registerError("","","","",error,exp.getMessage());
	    }
	    catch(Exception cexp)
	    {
		cexp.printStackTrace();
	    }
	}
	finally
	{
	    try
	    {
		if(pstmt != null) pstmt.close();
	    }
	    catch(Exception exp)
	    {
	    }
	}
    }

    /**
     * Method used to record in DB the exception raised during the transaction. 
     */
    public void registerError(String applicationID,String msgID,String facilityID,String srlNo,String error,String exp)
    {		
	String strProcedureName = "{ call xhgenprc.register_error(?,?,?,?,?,?) }";
	CallableStatement call = null;

	try
	{		
	    String appKey = applicationID + "|" + facilityID + "|" + msgID + "|" + srlNo;

	    call = eHISDBConn.prepareCall(strProcedureName);
	    call.setString(1,facilityID);
	    call.setString(2,"XHODBCI");
	    call.setString(3,"XHODBCI");
	    call.setString(4,error);
	    call.setString(5,exp);
	    call.setString(6,appKey);
	    call.execute();
	    eHISDBConn.commit();							
	}
	catch (Exception exception)
	{
	    common.fileOutput(serverParameters.strLogFile, "(ODBCInboundCommunication:registerError)Exception: "+exception.getMessage()+"\n" );
	    common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exception) +"\n" );
	}
	finally
	{
	    try
	    {
		if(call != null) call.close();
	    }
	    catch(Exception fexp)
	    {
	    }
	}
    }

    /**
     * Method used to update the last processed message id in xh_protocol.
     * Once the record is processed from the external DB, this method will be called.
     */
    public boolean updateMsgID(String msgID)
    {
	Statement stmt = null;
	boolean status = false;
	String qry = "UPDATE xh_protocol SET last_proc_msgid = '"+msgID+"' WHERE protocol_id='"+serverParameters.strProtocolId+"'";

	try
	{
	    stmt = eHISDBConn.createStatement();
	    int i = stmt.executeUpdate(qry);
	    if(i > 0) 
	    {
		if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "(ODBCInboundCommunication:updateMsgID) Message updated in protocol: "+msgID+" \n" );
		status = true;
	    }
	}
	catch(Exception exp)
	{
	    if(serverParameters.logToFile) common.fileOutput(serverParameters.strLogFile, "(ODBCInboundCommunication:updateMsgID) Exception in updating message ID: "+exp.getMessage()+"\n" );
	    if(serverParameters.logToFile) common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) +"\n" );			
	}
	finally
	{
	    try
	    {
		if(stmt != null) stmt.close();
	    }catch(Exception e)	{}
	}
	return status;
    }

    public String getLastMessageID()
    {
	Statement stmt = null;
	ResultSet rs = null;
	String msgID = null;
	String qry = "SELECT last_proc_msgid FROM xh_protocol WHERE protocol_id='" + serverParameters.strProtocolId + "'";

	//	System.out.println("Last Proc Query "+qry);

	try
	{
	    stmt = eHISDBConn.createStatement();
	    rs = stmt.executeQuery(qry);
	    if(rs.next()) 
	    {
		msgID = rs.getString("last_proc_msgid");
	    }
	}
	catch(Exception exp)
	{
	    if(serverParameters.logToFile) common.fileOutput( serverParameters.strLogFile, "(ODBCInboundCommunication:getLastMessageID) Exception: "+exp.getMessage()+"\n" );
	    if(serverParameters.logToFile) common.fileOutput( serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) +"\n" );
	    //	String error = "Error in retrieving last message id";
	    //	registerError("","","","",error,exp.getMessage());
	}
	finally
	{
	    try
	    {
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
	    }catch(Exception e)	{}
	}
	return msgID;
    }	
    
    //Added by Niveditha for GHL-SCF-1536 on 14/12/2020
    public CLOB stringToClob(String stringData, Connection dbConn) 
	{
        CLOB clob = null;
		//Connection dbConn = null;

        try 
		{
			//dbConn =  ConnectionManager.getConnection();
            clob = oracle.sql.CLOB.createTemporary(dbConn, false, CLOB.DURATION_SESSION);
            clob.setString(1, stringData);
        } catch (SQLException sqlException) {
            System.out.println("Exception thrown in stringtoClob function : SQL Exception : " + sqlException.getMessage());
        }
 
        return clob;
	}
}