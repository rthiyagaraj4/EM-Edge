/*
	Developed by  : Balachander R.R.
	Created on    : 26/03/2003
	Modified By   : Nanda Kumar R.	
	Modified Date : 4/3/2003
*/

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.util.Calendar;
import java.util.GregorianCalendar;

import HL7Engine.Common.Common;
import HL7Engine.Common.EMConstants;
import HL7Engine.Common.InterfaceUtil;
import HL7Engine.OutboundProcess.OutboundClientApplication;
import HL7Engine.OutboundProcess.OutboundClientParameters;

public class OutboundProcess
{
	public static OutboundClientParameters clientParameters;
	static PrintStream out;
	public static void main(String s[])
	{
		System.out.println("Calling common in outbound process...");
		Common common = Common.getInstance();		
		
		int intPort = 1111;
		intPort =0;
		OutboundClientParameters.strCommandParam = s;
		OutboundClientParameters.frameExec(s);

		/**************************
		Java OutboundProcess 0001 process id 192.7.2.77 1000 192.7.2.70:1521:kndv userid passwd

		Java OutboundProcess 'APP1','Facility ID', 'process_id', 'O', 20, 'folder(c:/medicom/reports)', 'n', '192.7.2.213:1521:KNDV', 'USERID ', 'PASSWD'
		****************************/
		
		String strApplicationId = s[0];
		String strFacilityId=s[1];
		String strProcessId = s[2];
		String strProcessType=s[3];
		String strIdleTime = s[4];
		String strDirectory = s[5];
		String strWrite_YN=s[6];
		
		String strTnsName = s[7];
		String strOrclUserId = s[8];
		String strOrclPasswd = s[9];

		String strProtocalLinkId = s[10];
		String strService = s[11];		
				
		String strLogInformation = "\t     iSOFT \n OUTBOUND COMMUNICATION LOG FILE \n";
						
		String strDateTime = "0";
		try
	    {
			OutboundClientParameters.machineName = (InetAddress.getLocalHost().getHostName()).toUpperCase();
		}
		catch(Exception exp)
		{
		}
		try
		{
			Thread.sleep(1000);        
		}
		catch(Exception exp)
		{
		}
					
		try
		{
			clientParameters = new OutboundClientParameters();
			clientParameters.strApplicationId=strApplicationId;
			clientParameters.strFacilityId=strFacilityId;
			clientParameters.intProcessId = Integer.parseInt(strProcessId);
			clientParameters.strProcessType = strProcessType;
			clientParameters.strOrclUserId = strOrclUserId;
			clientParameters.strOrclPassword = strOrclPasswd;
			clientParameters.strTnsName = strTnsName;
			clientParameters.logDirectory = strDirectory;			
			clientParameters.strProtocalLinkId = strProtocalLinkId;
			if(strService != null && strService.equals("Y"))
			{
				clientParameters.isWindowsService = true;
			}
			else
			{
				clientParameters.isWindowsService = false;;
			}

			String endChar = strDirectory.substring( strDirectory.length()-1, strDirectory.length() );
			if( endChar.equals("/") ) {
				clientParameters.strLogFile = strDirectory+strProcessId+".log";
				clientParameters.strExceptionLogFile = strDirectory+strProcessId+"Exception.log";
				clientParameters.strOutboundLog = strDirectory+"Outbound"+strProcessId+".log";
			}
			else {
				clientParameters.strLogFile = strDirectory+"/"+strProcessId+".log";
				clientParameters.strExceptionLogFile = strDirectory+"/"+strProcessId+"Exception.log";
				clientParameters.strOutboundLog = strDirectory+"/Outbound"+strProcessId+".log";
			}			

			if (strWrite_YN.equalsIgnoreCase("Y"))
			{
				clientParameters.logToFile = true ;
				clientParameters.intWrite = 1;
			}	

			clientParameters.intIdleTime = Integer.parseInt(strIdleTime);
			GregorianCalendar gregorianCal = new GregorianCalendar();
			strDateTime =	gregorianCal.get(Calendar.DAY_OF_MONTH)+"/"+(gregorianCal.get(Calendar.MONTH)+1)+"/"+
				gregorianCal.get(Calendar.YEAR)+" "+
				gregorianCal.get(Calendar.HOUR_OF_DAY)+":"+
				gregorianCal.get(Calendar.MINUTE)+":"+
				gregorianCal.get(Calendar.SECOND);			
			strLogInformation = strLogInformation + "\nUser Id :" + clientParameters.strOrclUserId+
						  "\nProcess Id :"+strProcessId+ "\t"+
						 "Created On : "+strDateTime + "\n"+ 
						"Applicaion Id : "+strApplicationId + ", Client Id : "+OutboundClientParameters.machineName+", Gateway : "+strProtocalLinkId+"\n"+
						"_______________________________________________________________________________\n";							
			  
			File file = new File(strDirectory);
			if(!file.isDirectory())
			{
				file.mkdirs();
				file = new File(strDirectory);
			}	
			
			if( file.isDirectory() ) 
			{
				common.fileOutput( clientParameters.strLogFile, strLogInformation ) ;
				System.out.println( "Debuging Enabled : Logged to file "+clientParameters.strLogFile );
			} 
			else 
			{
				clientParameters.logToFile = false;
				String defaultLoc = InterfaceUtil.getDefaultLogLoc(strProcessId);
				common.fileOutput(defaultLoc, strLogInformation + clientParameters.strLogFile + ": File does not exists");
			}

		//	OutboundClientApplication application = 
				new OutboundClientApplication(clientParameters);
		}
		catch(Exception exception)
		{
			try
			{
				out = new PrintStream(new FileOutputStream(clientParameters.strLogFile,true));
			}
			catch (Exception exp)
			{
			}
			
			exception.printStackTrace(out);			
		}
		finally
		{
			if(out != null) out.close();
		}
	}
}
