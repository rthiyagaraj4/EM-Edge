/*
	Developed by  : Balachander R.R.
	Created on    : 26/03/2003
	Modified By   : Nanda Kumar R.	
	Modified Date : 4/3/2003
 */
package HL7Engine.OutboundProcess;

import HL7Engine.Common.Common;
import HL7Engine.Common.InterfaceUtil;
import HL7Engine.Common.EMConstants;

public class OutboundClientParameters {
	public String strApplicationId = "0";
	public String strFacilityId = "0";
	public int intProcessId = 0;
	public String strProcessType = "O";

	public String strCommunicationMode = "0";
	public String strFileDirectory = "0";
	public String strIpAddress = "0";
	public int intPortNumber = 0;

	public String strTnsName = "0";
	public String strOrclUserId = "0";
	public String strOrclPassword = "0";

	public int intIdleTime = 0;
	public long longStartTime = System.currentTimeMillis();
	public int intRetryInterval = 0;
	public int intMaxRetries = 0;
	public int intConnectionCount = 0;
	public int intWrite = 0;
	public String strLogFile = "0";
	public String strOutboundLog = "0";
	public String strExceptionLogFile = "0";

	public boolean boolError = true;
	public boolean isWindowsService = false;
	public boolean isPurgeEnabled = false;

	public boolean logToFile = false;
	public boolean debugYN;
	public String restartTime = "12:34";
	public String strRestartType = "E";
	public String logDirectory;
	public boolean stackTrace = true;

	boolean boolDBDown = false;
	boolean isExternalDBDown = false;
	public boolean isExtConnDown = false;
	boolean isAutoRestart = false;
	boolean isRestartException = true;
	boolean isSleepEnabledToday = false;
	boolean isSleepEnabledTodayProtocol = false;

	public static String strExec = "";
	public static String machineName = "";
	public static String strCommandParam[] = null;
	String strSleepFrom[] = new String[10];
	String strSleepTo[] = new String[10];
	String strSleepToProtocol[] = new String[10];
	String strSleepFromProtocol[] = new String[10];

	long longSleepFrom[] = new long[10];
	long longSleepTo[] = new long[10];
	long nextSleepCalculationTime = 0;

	long longSleepFromProtocol[] = new long[10];
	long longSleepToProtocol[] = new long[10];
	long nextSleepCalculationTimeProtocol = 0;

	// if enabled, messages will be queried directly from engine instead of
	// calling procedure.
	// Used to retrieve messages in bulk from DB at a time instead of fetching
	// one message everytime from DB.
	public String isQueueEnabled = "N";
	public String maxQueueMessages = "10";

	// Code inserted by srinivasa.N
	public String strProtocalLinkId;
	public String strProtocolId;
	public String strProtocolType;
	public String strProtocolMode;
	public String strFileNamingConvention;
	public String strDbfFileType;
	public String strCreateFileInterval;
	public String strCreateDataInterval;
	public String strCommdataIoApi;
	public String strCommStatistics;
	public String strModuleId;
	public long strAckType = 0;
	public String profileID;
	//
	public String standardCode;
	public String messageStart;
	public String messageEnd;
	public String messageSegmentStart;
	public String messageSegmentEnd;
	public String fieldSeparator;

	public String odbcDBURL;
	public String odbcDBUserID;
	public String odbcDBPwd;
	public String odbcDBDriver;
	public String odbcDBSID;

	public String webserviceURL;
	public String webserviceUID;
	public String webservicePwd;

	public String url;

	public String strAckFileDirectory;
	// variables used for file communication (online / offline) purpose
	public boolean offline;
	public String readBeforeDate = "";
	public String accessionNo; // Current message accession number

	Common common = null;
	public String componentSeparator = "94";
	public String repetitionSeparator = "126";
	public String subComponentSeparator = "38";
	public String escapeChar;

	// Added by Sethu for ML-MMOH-CRF-0473
	public String httpUserAgent;
	public String httpContentType;
	public String httpTransferEncoding;
	public String httpSoapaction;
	public int httpContentLengthFlag;	
	public java.sql.Clob httpSoapResponseXSL;
	
	// Added by Sethu for ML-BRU-CRF-0560
	public String httpFileUploadType;
	
	// Added by Niveditha for AAKH-CRF-0113 on 20/02/2020
	public String mail_host;
	public String mail_port;
	public String mail_config;
	public String mail_smtp_auth_flag;
	public String mail_smtp_starttls_flag;
	public String mail_attachment_flag; //Added by Niveditha for Mail attachment
	public String mail_attachment_file_dir ; //Added by Niveditha for Mail attachment

	public OutboundClientParameters() {
		common = Common.getInstance();
	}

	public static void frameExec(String str[]) {
		String sReturn = "";
		String space = " ";

		for (int j = 0; j < strCommandParam.length; j++) {
			sReturn = sReturn + space + strCommandParam[j];
		}

		strExec = "java OutboundProcess " + sReturn + "";
	}

	public String getServiceName() throws Exception {
		String dbName = InterfaceUtil.getDBName(strTnsName);

		String serviceName = "EM" + EMConstants.SERVICENAME_SEPARATOR
				+ strApplicationId + EMConstants.SERVICENAME_SEPARATOR
				+ strProtocalLinkId + EMConstants.SERVICENAME_SEPARATOR + "OB"
				+ EMConstants.SERVICENAME_SEPARATOR + dbName
				+ EMConstants.SERVICENAME_SEPARATOR + intProcessId;

		common.fileOutput(strLogFile,
				"(OutboundClientParameters:getServiceName) Service Name "
						+ serviceName + "\n");
		return serviceName;
	}
}