/*
	Developed by  : Balachander R.R.
	Created on    : 26/03/2003
	Modified By   : Nanda Kumar R.	
	Modified Date : 4/3/2003
*/
package HL7Engine.InboundProcess;

import java.util.ArrayList;

import HL7Engine.Common.Common;
import HL7Engine.Common.EMConstants;
import HL7Engine.Common.InterfaceUtil;

public class InboundServerParameters
{
	public String strApplicationId = "0";
	public String strFacilityId="0";
	public int intProcessId = 0;
	public int intPortNo = 0;
	public String strTnsName = "0";
	public String strProcessType = "I";
	public String strOrclUserId = "0";
	public String strOrclPasswd = "0";
	public int intWrite = 0;
	public String strClientId = "0";
	public boolean boolError = false;	
	public boolean isDBDown = false;
	public boolean isExternalDBDown = false;

	public String strLogFile = "0";
	public String strInboundLog = "0";
	public String strExceptionLogFile = "0";
	public String logDirectory;
	public boolean stackTrace = true;

	public String strProtocalLinkId;	
	public String strModuleId;
	public String strCommunicationMode;
	public String strFileDirectory = "0";
	public String strProtocolId;
	public String profileID;
	public String strProtocolType;
	public String strProtocolMode;
	public String strFileNamingConvention;
	public String strDbfFileType;
	public String filePath;	
	public String currentFile;
	public boolean getNextMessage = true;
	public int intMaxRetries = 0;
	public int intRetryInterval = 0;
	public boolean isRetryParamEnabled = true;
	public String messageStart;
	public String messageEnd;
	public String messageSegmentStart;
	public String messageSegmentEnd;
	public String componentSeparator = "^";
	public String strCommStatistics;
	public String strCommdataIoApi;
	public String odbcQryNxtMsg;
	public String standardCode;
	public String fieldSeperator;
	public String restartTime = "12:34";
    public String strRestartType = "E";
	public boolean isAutoRestart = false;
	public boolean isRestartTimeReached = false;
	public boolean isIdleTimeReached = false;
	public boolean decodingEnabled = false;
	public String decodeType = "TEXT";
	public String decodeField;
	public int intIdleTime = 0; // if the value set in application is zero, that indicates not to check for idle time
	public long longStartTime = 0;
	public int totalMessages = 0;

	public int totExternalConnRetries;
	public boolean isMaxRetriesReached;

	//variables used for file communication (online / offline) purpose
	public boolean offline = false;
	public String readBeforeDateTime;
	public String solicitedYN;
	public String strAckFileDirectory;
	public String xslFileName;

	//variables for query based process
	public boolean queryProcessed;
	public boolean ackSent;
	public boolean logToFile = false;
	public boolean isWindowsService = false;
	public boolean isConnected = false; // Parameter used to check any active communication is on or not.

	public static String strExec = "";
	public static String strCommandParam[] = null;	

	public ArrayList ackMessageList;
	public ArrayList partialMsgAckList;

	public String odbcDBURL;
	public String odbcDBUserID;
	public String odbcDBPwd;
	public String odbcDBDriver;
	public String odbcDBSID;
	
	// Variables used for PABX protocol	
	public String linkProtocolID;	
	public String linkCommIOApi;	
	public String linkCommStatApi;	
	public String linkProtocolLinkID;	
	public boolean linkProtocolIDEnabled = false;	
	public boolean sendPABXLEMsg = false;	
	public boolean isLESent = false;	

	// Variables used for PABX protocol	
	public String msgLayout;

	Common common = null;
	public boolean isSleepEnabledTodayProtocol;
	public String[] strSleepFromProtocol;
	public String[] strSleepToProtocol;
	public long[] longSleepFromProtocol;
	public long[] longSleepToProtocol;
	String strSleepFrom[] = new String[10];
	String strSleepTo[] = new String[10];
	long longSleepFrom[] = new long[10];
	long longSleepTo[] = new long[10];
	long nextSleepCalculationTimeProtocol = 0;
	long nextSleepCalculationTime = 0;
	public boolean isSleepEnabledToday;
	public boolean isSleepTimeReached;

	public InboundServerParameters()
	{
		common = Common.getInstance();
	}

	public static void frameExec(String str[])
	{
		String sReturn = "";
		String space = " ";

		for(int j = 0; j < strCommandParam.length; j++)
		{
			sReturn = sReturn + space + strCommandParam[j];
		}
		strExec = "java InboundProcess" + sReturn + "";
	}

	public String getServiceName() throws Exception
	{
		String dbName = InterfaceUtil.getDBName(strTnsName);

		String serviceName = "EM" + EMConstants.SERVICENAME_SEPARATOR 
								+ strApplicationId + EMConstants.SERVICENAME_SEPARATOR 
								+ strProtocalLinkId + EMConstants.SERVICENAME_SEPARATOR 
								+ "IB" + EMConstants.SERVICENAME_SEPARATOR 
								+ dbName + EMConstants.SERVICENAME_SEPARATOR 
								+ intProcessId;

		common.fileOutput(strLogFile, "(InboundServerParameters:getServiceName) Service Name " + serviceName +"\n" ) ;
		return serviceName;
	}
}