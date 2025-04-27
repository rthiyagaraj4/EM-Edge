package HL7Engine.OutboundProcess;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

import HL7Engine.Common.Common;
import HL7Engine.Common.CommonUtil;
import HL7Engine.Common.EMConstants;

public class OBHelper 
{
	OutboundClientDBInteraction clientDB;
	OutboundClientParameters clientParameters;
	Common common;

	public OBHelper()
	{
	}

	public OBHelper(OutboundClientDBInteraction clientDB)
	{
		this.clientDB = clientDB;
		this.clientParameters = clientDB.clientParameters;
		common = Common.getInstance();
	}

	public void queryDBConnection(String database)
	{		
		int count = 0;
		
		while(true)
		{
			try
			{
				if(count == 0)	clientDB.checkExeDBConnection("SQLSERVER");
				if(clientParameters.isExternalDBDown) 
				{
					Thread.sleep(clientParameters.intRetryInterval);
				}
				else break;
			}
			catch (Exception exp)
			{
			}
		}
	}

	/**
	 * Method closes all the required resources like DB,socket connection etc.
	 */
	public void cleanupResources()
	{
		try
		{
			if(!clientParameters.boolDBDown)
			{
				clientDB.closeDBconn();
			}
			clientDB.closeExtDBConn(); // required for ODBC Communication
		}
		catch (Exception exp)
		{
//			common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:cleanupResources) Exception: " + exp + "\n" );
//			common.fileOutput(clientParameters.strExceptionLogFile,CommonUtil.getStringStackTrace(exp) + "\n");
		}
	}

	/**
	 * Method used in file communication.
	 * Used to get the filename to be passed to updateApplicationMessageStatus.
	 * If the message is the replay message, then the file name will have the suffix to indicate the replay status,
	 * for updateApplicationMessageStatus method we have to pass actual file with out suffix.
	 * In replay filename three underscores with date & time will be appended to actual filename, we can get the actual filename by truncating the date and time.
	 */
	public static String getTokenizedFileName(String fileName)
	{
		String tempFileName = null;
		int index = fileName.indexOf("___"); // checking whether it is replay filename or first time sending filename.		
		if(index != -1)
		{
			tempFileName = fileName.substring(0,index);
		}
		else
		{
			index = fileName.indexOf(".");
			if(index != -1)
			{
				tempFileName = fileName.substring(0,index);
			}
			else
				tempFileName = fileName;
		}
		return tempFileName;
	}
	
	/**
	 * Method used to stop & uninstall the gateway services for service based gateways.
	 */
	public void stopServices()
	{
		boolean retFlag = false;

		try
		{
			String serviceName = clientParameters.getServiceName();

			String monitorStopCmd = "sc stop " + serviceName + "_MONITOR";
			String serviceStopCmd = "sc stop " + serviceName;
		
			Runtime runTime = Runtime.getRuntime();
			runTime.exec(monitorStopCmd).waitFor();
			Process p = runTime.exec(serviceStopCmd);
			p.waitFor();
			
			retFlag = CommonUtil.isSubstringExists(CommonUtil.getConsoleMessage(p),"STOPPED");
			
			if(retFlag)
			{
				common.fileOutput(clientParameters.strLogFile,"(OutboundClientApplication:stopServices) Service stopped...\n");
			}
			else
			{
				common.fileOutput(clientParameters.strLogFile,"(OutboundClientApplication:stopServices) Failed to stop service...\n");
			}
		}
		catch(Exception exp)
		{
			common.fileOutput(clientParameters.strExceptionLogFile,CommonUtil.getStringStackTrace(exp)+"\n");
		}
	}
	
	public boolean checkRemoteConnStatus()
	{
		Runtime runtime = Runtime.getRuntime();
		Process process = null;
		InputStream io = null;
		BufferedReader reader = null;
		String line = null;
		boolean connDown = false;
		String netStatCmdStr = clientParameters.strIpAddress + ":" + clientParameters.intPortNumber;
		
		try
		{
			process = runtime.exec("netstat -n");
			io = process.getInputStream();
			reader = new BufferedReader(new InputStreamReader(io));
			String remoteConnStatus = null;

			while ((line = reader.readLine()) != null) 
			{ 
				boolean status = false; 			
				status = CommonUtil.isSubstringExists(line, netStatCmdStr);
				
				if(status)
				{
					StringTokenizer tokenizer = new StringTokenizer(line, " ");
					int i = 0;
					while(tokenizer.hasMoreTokens())
					{
						String temp = tokenizer.nextToken();					
						if(i == 3) remoteConnStatus = temp;
						i++;
					}
					if(clientParameters.logToFile) common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:checkRemoteConnStatus) Remote Connection Status ["+remoteConnStatus+"]\n");
					if("CLOSE_WAIT".equals(remoteConnStatus))
					{
						connDown = true;
						common.fileOutput( clientParameters.strLogFile, "(OutboundClientApplication:checkRemoteConnStatus) External Reciever Gateway is stopped\n");
					}
				}
			}
		}
		catch(Exception exp)
		{
			common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:checkRemoteConnStatus) Exception: "+exp+"\n" ) ;
			common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
		}
		return connDown;
	}

	public boolean commStartCheck() 
	{
		boolean canStartComm = true;
		try
		{
			if(EMConstants.SKR_EBL_OPIP_MDB_PROT.equals(clientParameters.strProtocolId))
			{
				String qry = "SELECT 1 FROM dba_jobs WHERE what LIKE 'XBSSINT.E11_BUILDER_OB(%'";
				List<String> retList = clientDB.exeSingleColQry(qry);
				if(retList.size() > 0 && "1".equals(retList.get(0))) 
				{					
					canStartComm = false;				
				}
			}
		}
		catch(Exception exp)
		{
			common.fileOutput(clientParameters.strLogFile, "(OutboundClientApplication:commStartCheck) Exception: "+exp+"\n" ) ;
			common.fileOutput(clientParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n");
		}
		
		return canStartComm;
	}
}