/*
	Developed by  : Balachander R.R.
	Created on    : 26/03/2003
	Modified By   : Nanda Kumar R.	
	Modified Date : 4/3/2003

*/
import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;

import HL7Engine.Common.Common;
import HL7Engine.Common.EMConstants;
import HL7Engine.Common.InterfaceUtil;
import HL7Engine.InboundProcess.InboundListener;
import HL7Engine.InboundProcess.InboundServerParameters;

public class InboundProcess
{
	public static void main(String s[])
	{
		/**************************
			Java ClientEngine 0001 process id 192.7.2.77 1000 192.7.2.70:1521:kndv userid passwd
		****************************/
		System.out.println("Calling common in Inbound Process");
		Common common = Common.getInstance();

		String strClientId = s[0];
		String strApplicationId = s[1];
		String strFacilityId = s[2];
		String strProcessId = s[3];
		String strProcessType=s[4];
		String strIdleTime = s[5];
		String strDirectory = s[6];
		String strWrite_YN = s[7];			
		String strTnsName = s[8];
		String strOrclUserId = s[9];
		String strOrclPasswd = s[10];
		String strProtocalLinkId = s[11];  // 11/6/2007
		String strService = s[12];

		String strLogInformation = "\t     CSC EM \t \t \n INBOUND COMMUNICATION LOG FILE \n";

		String strDateTime = "0";
		try
		{
			InboundServerParameters.strCommandParam = s;
			InboundServerParameters.frameExec(s);

			InboundServerParameters serverParameters = new InboundServerParameters();
			serverParameters.strClientId = strClientId;
			serverParameters.strApplicationId=strApplicationId;
			serverParameters.strFacilityId=strFacilityId;
			serverParameters.intProcessId = Integer.parseInt(strProcessId);
			serverParameters.strProcessType = strProcessType;
			serverParameters.strOrclUserId = strOrclUserId;
			serverParameters.strOrclPasswd = strOrclPasswd;
			serverParameters.strTnsName = strTnsName;
			serverParameters.intIdleTime = Integer.parseInt(strIdleTime);
			serverParameters.logDirectory = strDirectory;
			serverParameters.strProtocalLinkId = strProtocalLinkId; // 11/6/2007 (To Specify communication mode)

			if(strService != null && strService.equals("Y"))
			{
				serverParameters.isWindowsService = true;
			}
			else
			{
				serverParameters.isWindowsService = false;;
			}

			String endChar = strDirectory.substring( strDirectory.length()-1, strDirectory.length() );
			if( endChar.equals("/") ) {
				serverParameters.strLogFile = strDirectory+strProcessId+".log";
				serverParameters.strExceptionLogFile = strDirectory+strProcessId+"Exception.log";
				serverParameters.strInboundLog = strDirectory +"Inbound"+ strProcessId + ".log";
			}
			else {
				serverParameters.strLogFile = strDirectory+"/"+strProcessId+".log";
				serverParameters.strExceptionLogFile = strDirectory+"/"+strProcessId+"Exception.log";
				serverParameters.strInboundLog = strDirectory +"/Inbound"+ strProcessId + ".log";
			}
				
			if (strWrite_YN.equals("Y")) {
				serverParameters.logToFile = true ;
				serverParameters.intWrite = 1;
			}
			
			GregorianCalendar gregorianCal = new GregorianCalendar();
			strDateTime = gregorianCal.get(Calendar.DAY_OF_MONTH)+"/"+(gregorianCal.get(Calendar.MONTH)+1)+"/"+
				gregorianCal.get(Calendar.YEAR)+" "+
				gregorianCal.get(Calendar.HOUR_OF_DAY)+":"+
				gregorianCal.get(Calendar.MINUTE)+":"+
				gregorianCal.get(Calendar.SECOND);
			strLogInformation = strLogInformation + "\nUser Id :" + strOrclUserId+
						  "\nProcess Id :"+ strProcessId + "\t"+
						 "Created On : "+ strDateTime + "\n"+ 
						"Application Id : "+ strApplicationId + "\n"+
						"Client Id : "+ strClientId +" Gateway : "+ strProtocalLinkId +"\n"+
						"____________________________________\n";
	
		//	common.fileOutput( serverParameters.strLogFile, strLogInformation ) ;
			File file = new File( strDirectory );

			if(!file.isDirectory())
			{
				file.mkdirs();
			}			
			file = new File(strDirectory);
			if(file.isDirectory()) 
			{
				common.fileOutput( serverParameters.strLogFile, strLogInformation ) ;
				System.out.println( "Debuging Enabled : Logged to file "+serverParameters.strLogFile );
			} 
			else 
			{
				serverParameters.logToFile = false;
				String defaultLoc = InterfaceUtil.getDefaultLogLoc(strProcessId);
				common.fileOutput(defaultLoc, strLogInformation + serverParameters.strLogFile + ": File does not exists" ) ;
			}

			InboundListener listener = new InboundListener(serverParameters);
			listener.startProcess();
		}
		catch(Exception exception)
		{
			System.out.println(" General Exception "+exception);				
		}
	}
}