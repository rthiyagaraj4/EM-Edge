/*
	Developed by  : Balachander R.R.
	Created on    : 26/03/2003
*/
package HL7Engine.InboundProcess ;

import java.io.File;
import java.util.GregorianCalendar;

import HL7Engine.Common.Common;
import HL7Engine.Common.CommonUtil;

public class InboundServerMonitor extends Thread
{
	Common common = null;
	InboundServerDBInteraction serverDB;
	InboundServerParameters serverParameters;

	int intSleepTime = 15000;
	boolean logToFile = false;
	String strLogFile = "0";
	String strExceptionLogFile = "0";
	// Variables for auto restart purpose
	String strRenamedFile = "";
	int intIdleTime = 0;
	
	long longSleepingTimeProtocol = 0;
	long longSleepingTime = 0;
	int intSleepingIndex = 0;

	GregorianCalendar gc = new GregorianCalendar();
	private int intSleepingIndexProtocol;

	public InboundServerMonitor(InboundServerDBInteraction serv)
	{
		common = Common.getInstance();
		serverDB = serv;
		serverParameters = serverDB.serverParameters;
		this.logToFile = serverDB.serverParameters.logToFile;
		this.strLogFile = serverDB.serverParameters.strLogFile;
		this.strExceptionLogFile = serverDB.serverParameters.strExceptionLogFile;
		intIdleTime = serverParameters.intIdleTime * 1000 * 60;
		serverParameters.longStartTime = System.currentTimeMillis();
		this.start();
	}

	public void run()
	{
		try
		{
			checkRestartApplicable();
			serverDB.getSleepingTimeInterval();
			serverDB.getProtocolSleepingInterval();
			this.setCurrentTime();
			this.setStoppingTime();
		}
		catch (Exception exp)
		{			
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
		}

		while(true)
		{
			try
			{
				if (serverDB.canIStop())
				{	
					exitProcess();
				}

				if(this.restartTheInstance())
				{	
					common.fileOutput(serverParameters.strLogFile, "(InboundServerMonitor:run) Restart Time Reached["+getStoppingTimeMessage()+"]\n" ) ;
					serverParameters.isRestartTimeReached = true;

					if(!serverParameters.isConnected)
					{
						restartProcess();
					}
				}			
				
				if (intIdleTime != 0 // indicates not to check for idle time
						&& (System.currentTimeMillis() - serverParameters.longStartTime) > intIdleTime)
				{			
					common.fileOutput(serverParameters.strLogFile, "(InboundServerMonitor:run) Idle Time Reached[" + serverParameters.intIdleTime + " Min.]\n" ) ;
					serverParameters.isIdleTimeReached = true;
					
					if(!serverParameters.isConnected)
					{
						exitProcess();
					}
				}
				
			/*	if (isReachedSleeping()) // Checking for global sleeping parameter
				{
					try
					{
						common.fileOutput(serverParameters.strLogFile, "(InboundServerMonitor:run) !!! Sleeping Time Reached[From "+serverParameters.strSleepFrom[this.intSleepingIndex]+" To "+serverParameters.strSleepTo[this.intSleepingIndex]+"] !!!\n" );
						serverParameters.isSleepTimeReached = true;
					//	this.sleep(longSleepingTime);						
					}
					catch(Exception exp)
					{
						common.fileOutput(serverParameters.strExceptionLogFile, "(InboundServerMonitor:run)" + exp + "\n" );
						common.fileOutput(serverParameters.strExceptionLogFile,CommonUtil.getStringStackTrace(exp) + "\n");
					}
				}

				if (isReachedSleepingProtocol()) // Checking for protocol link level sleeping parameter
				{
					try
					{
						common.fileOutput( serverParameters.strLogFile, "(InboundServerMonitor:run) !!! Sleeping Time Reached[From "+serverParameters.strSleepFromProtocol[this.intSleepingIndexProtocol]+" To "+serverParameters.strSleepToProtocol[this.intSleepingIndexProtocol]+"] !!!\n" );
						serverParameters.isSleepTimeReached = true;
					//	cleanupResources();
					//	this.sleep(this.longSleepingTimeProtocol);
					}
					catch(Exception exp)
					{
						common.fileOutput( serverParameters.strLogFile, "(InboundServerMonitor:run) Protocol Exception(isReachedSleeping): "+ exp.toString() +"\n " ) ;					  
					}
				}			
			*/
				this.sleep(intSleepTime);
			}
			catch(Exception exceptionSleep)
			{				
				common.fileOutput(strExceptionLogFile, "(InboundServerMonitor:run) Exception: "+exceptionSleep+"\n" ) ;	
			}	
		}
	}

	private boolean isReachedSleeping()
	{
		try
		{
			long presentTime = System.currentTimeMillis();

			if (serverParameters.isSleepEnabledToday == true)
			{
				for(int j = 0; j < serverParameters.longSleepFrom.length; j++)
				{
					if ((serverParameters.longSleepFrom[j] <= presentTime) && 
							(serverParameters.longSleepTo[j] >= presentTime))
					{
						this.intSleepingIndex = j ;
						this.longSleepingTime = serverParameters.longSleepTo[j] - presentTime;

						if (this.longSleepingTime <= 0)
						{
							this.longSleepingTime = 1;
						}
						return true;
					}
				}
			}
		}
		catch(Exception exp)
		{
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n"); 
		}
		return false;
	}

	private boolean isReachedSleepingProtocol()
	{
		try
		{
			long presentTime = System.currentTimeMillis();
			
			if (serverParameters.isSleepEnabledTodayProtocol == true)
			{
				for(int j = 0; j < serverParameters.longSleepFromProtocol.length; j++)
				{
					if ((serverParameters.longSleepFromProtocol[j] <= presentTime) &&
									(serverParameters.longSleepToProtocol[j] >= presentTime))
					{
						this.intSleepingIndexProtocol = j ;
						this.longSleepingTimeProtocol = serverParameters.longSleepToProtocol[j] - presentTime;

						if (this.longSleepingTimeProtocol <= 0)
						{
							this.longSleepingTimeProtocol = 1;
						}
						return true;
					}
				}
			}
		}
		catch(Exception exp)
		{
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n"); 
		}
		return false;
	}

	// Method checks whether restart is applicable or not
	private void checkRestartApplicable()
	{
		try
		{
			if ((serverParameters.strRestartType.equalsIgnoreCase("E")) ||
					(serverParameters.strRestartType.equalsIgnoreCase("A")) ) 
			{
				serverParameters.isAutoRestart = true;    
			}
			else
			{
				serverParameters.isAutoRestart = false;
			}
		}
		catch(Exception ex)
		{
			serverParameters.isAutoRestart = false;
		}
	}

	public void setCurrentTime()
	{
		String strTim[] = null;
		try
		{
			if (serverParameters.isAutoRestart == false) return;

			try
			{
				strTim = serverParameters.restartTime.split(":");
			}
			catch(Exception exp)
			{
				return;
			}
			if (serverParameters.strRestartType.equals("A"))
			{
				gc = new GregorianCalendar();
				gc.set(gc.HOUR_OF_DAY,Integer.parseInt(strTim[0]));
				gc.set(gc.MINUTE,Integer.parseInt(strTim[1]));
			}
			else
			{
				gc = new GregorianCalendar();
			}
		}
		catch(Exception exp)
		{
			exp.printStackTrace(); 
		}
	}

	public long getTimeDifference()
	{
		long ltimeDiff =  gc.getTimeInMillis() - System.currentTimeMillis();
		return(ltimeDiff);
	}

	private void setStoppingTime()
	{
		if (serverParameters.isAutoRestart == false) return;

		if (serverParameters.strRestartType.equalsIgnoreCase("E"))
		{
			this.setNextInterval();
		}
		else
		{
			if (getTimeDifference() <= 0)
			{
				this.setNextTime();
			}
		}
	}

	public void setNextInterval()
	{
		String strTim[] = serverParameters.restartTime.split(":");
		setCurrentTime();

		int hour = Integer.parseInt(strTim[0]);
		int min = Integer.parseInt(strTim[1]);

		try
		{
			hour = gc.get(gc.HOUR_OF_DAY)+hour;
			min = gc.get(gc.MINUTE)+min;
			gc.set(gc.HOUR_OF_DAY,hour);
			gc.set(gc.MINUTE,min);
			System.out.println("RESTART TIME "+gc.getTime());
		}
		catch(Exception exp)
		{
			exp.printStackTrace(); 
		}
	}

	public void setNextTime()
	{
		int hour = 0;
	//	int min = 0;
		hour = gc.get(gc.HOUR_OF_DAY);
		gc.set(gc.HOUR_OF_DAY,hour+24);
	}

	public boolean restartTheInstance()
	{
		boolean restart = false;

		try
		{
			if (serverParameters.isAutoRestart && (this.getTimeDifference() <= 0))
			{				
				restart = true;				
			}
			else
			{
				restart = false;
			}
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}

		return restart;
	}

	public String getStoppingTimeMessage()
	{
		if (serverParameters.strRestartType.equals("E"))
		{
			return("Interval "+serverParameters.restartTime);
		}
		else
		{
			return("At "+serverParameters.restartTime);
		}
	}

	public void runProcess(String prc)
	{
		try
		{		
			common.fileOutput( serverParameters.strLogFile, "(InboundServerMonitor:runProcess) Creating New Instance[Process Id:"+serverParameters.strCommandParam[3]+"]\n" ) ;
			this.rename(serverParameters.strLogFile);			

			this.sleep(1000);

			Runtime runtime = Runtime.getRuntime();
			runtime.exec(prc);

			common.fileOutput(this.strRenamedFile, "(InboundServerMonitor:runProcess) New Instance Created\n");
			common.fileOutput(this.strRenamedFile, "(InboundServerMonitor:runProcess) Closing Current Instance\n" ) ;
			common.fileOutput(this.strRenamedFile, "\n_______________________________________________________________________________\n\n************End of Log File*********\n" ) ;
		}
		catch(Exception exception)
		{
			common.fileOutput(this.strRenamedFile,"Restart Failed.. " + exception + "\n");
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exception) + "\n" ) ;
		}
	}

	public void rename(String log)
	{
		File fFrom = null,fTo = null;
		String strFileName[] = new String[2];
		try
		{			
			strFileName = log.split(".log");
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			strFileName[0] = log;
		}
		try
		{			
			fFrom = new File(log);
			strRenamedFile = strFileName[0]+"_"+(getTimeStamp())+".log";		
			fTo = new File(strRenamedFile);

			if (fFrom.exists())
			{				
				System.out.println("File renamed.. "+fFrom.renameTo(fTo));
			}
			else
			{
			//	System.out.println("fFrom does not exist");
			}
		}
		catch(Exception exp)
		{
			exp.printStackTrace(); 				
		}
	}

	public static String getTimeStamp()
	{
		GregorianCalendar gc = new GregorianCalendar();
		String str = "";
		try
		{
			str = trim(gc.get(gc.DAY_OF_MONTH))+""+
			trim((gc.get(gc.MONTH)+1))+""+
			trim(gc.get(gc.YEAR))+"_"+
			trim(gc.get(gc.HOUR_OF_DAY))+
			""+
			trim(gc.get(gc.MINUTE))+""+
			trim(gc.get(gc.SECOND))+"_"+
			trimMilli(gc.get(gc.MILLISECOND));
		}
		catch(Exception exp)
		{		
			System.out.println("Exception in InboundServerMonitor:getTimeStamp"+exp);
		}
		return str;
	}

	private static String trimMilli(int j)
	{
		String retStr = "";
		try
		{
			if(j < 10)
			{
				retStr = "00" + j;
			}
			else if (j < 100)
			{
				retStr = "0" + j;
			}
			else
			{
				retStr = "" + j;
			}
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		return retStr;
	}

	private static String trim(int j)
	{
		String retStr = "";
		try
		{
			if(j < 10)
			{
				retStr = "0" + j;
			}
			else
			{
				retStr = j + "";
			}
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		return retStr;
	}

	int getRestartTimeInMillis()
	{
		String strTim [] = null;
		int restartInterval = 0;

		try
		{
			strTim = serverParameters.restartTime.split(":");
			if (serverParameters.strRestartType.equals("E"))
			{
				int hours = Integer.parseInt(strTim[0]);
				int min = Integer.parseInt(strTim[1]);

				// Converting time in hours & min to milli seconds
				restartInterval = (hours * 60 * 60 * 1000) + (min * 60 * 1000); 
			}
			else if ((serverParameters.strRestartType.equals("A")))
			{
				GregorianCalendar currGC = new GregorianCalendar();				
				restartInterval = Integer.parseInt( String.valueOf(gc.getTimeInMillis() - currGC.getTimeInMillis()) );							
			}
		//	common.fileOutput( serverParameters.strLogFile, "(InboundListener:getRestartTimeInMillis)Restart Time in millis:"+restartInterval+"\n" ) ;
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		return restartInterval;
	}

	/**
	 * Method used to stop the gateway services for windows service based gateways.
	 */
	void stopService(boolean stopMonitor)
	{
		try
		{
			String serviceStopCmd = "sc stop " + serverParameters.getServiceName();
			String monitorStopCmd = serviceStopCmd + "_MONITOR";

			Runtime runTime = Runtime.getRuntime();
			if(stopMonitor) runTime.exec(monitorStopCmd).waitFor();
			Process p = runTime.exec(serviceStopCmd);
			boolean retFlag = CommonUtil.isSubstringExists(CommonUtil.getConsoleMessage(p),"The service was successfully uninstalled.");
			common.fileOutput(serverParameters.strLogFile,"(InboundServerApplication:stopServices)Service stopped "+retFlag+"\n");
		}
		catch(Exception exp)
		{
			common.fileOutput(serverParameters.strLogFile,"(InboundServerApplication:stopServices) Exception: Service stop failed.. "+exp+"\n");
			common.fileOutput(serverParameters.strExceptionLogFile,CommonUtil.getStringStackTrace(exp)+"\n");
		}
	}

	/**
	 * Method used to stop & uninstall the gateway services for service based gateways.
	 */
	void uninstallServices(String applicationID,String facilityID,int processID)
	{
		boolean retFlag = false;

		try
		{
			String serviceName = serverParameters.getServiceName();
			String monitorStopCmd = "sc stop " + serviceName + "_MONITOR";
		//	String serviceStopCmd = "sc stop Hl7_" + applicationID + "_" + facilityID + "_" + processID;
			String monitorUninstall = "javaservice -uninstall " + serviceName + "_MONITOR";
			String serviceUninstall = "javaservice -uninstall " + serviceName;

			Runtime runTime = Runtime.getRuntime();
			runTime.exec(monitorStopCmd);
			runTime.exec(monitorUninstall);
		//	runTime.exec(serviceStopCmd);
			Process p = runTime.exec(serviceUninstall);		
			retFlag = CommonUtil.isSubstringExists(CommonUtil.getConsoleMessage(p),"The service was successfully uninstalled.");

			if(retFlag)
			{
				common.fileOutput(serverParameters.strLogFile,"(InboundServerMonitor:uninstallServices)	Services uninstalled...\n");
			}
			else
			{
				common.fileOutput(serverParameters.strLogFile,"(InboundServerMonitor:uninstallServices) !!! Failed to uninstall service !!!\n");
			}
		}
		catch(Exception exp)
		{
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp)+"\n");
		}
	}

	public synchronized void restartProcess()
	{
		serverParameters.isRestartTimeReached = false;
		try
		{
			serverDB.updateProcessStatus("W");
			common.fileOutput(serverParameters.strLogFile, "(InboundServerMonitor:restartProcess) From restartProcess *********************** Database Connection Closed *********************** \n" );
			serverDB.closeDBconn();

			if (serverParameters.isWindowsService)
			{
				stopService(false); // No need to start the service,ServiceRestart class will take care of restarting the service.
			}
			else
			{
				runProcess(InboundServerParameters.strExec);
				System.exit(0);
			}						
		}
		catch (Exception exp)
		{
			common.fileOutput(serverParameters.strLogFile, "(InboundServerMonitor:restartProcess) Exception "+exp+"\n" ) ;
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
		}
	}

	public synchronized void exitProcess()
	{
		common.fileOutput(serverParameters.strLogFile, "(InboundServerMonitor:exitProcess) Closing Current Instance\n" ) ;
		try
		{	
			if(serverParameters.linkProtocolIDEnabled)
			{
				serverParameters.sendPABXLEMsg = true;

				while(!serverParameters.isLESent) 
				{
					Thread.sleep(100);
				}
			}			

			serverDB.updateProcessStatus("S");
			common.fileOutput(serverParameters.strLogFile, "(InboundServerMonitor:exitProcess) From exitProcess *********************** Database Connection Closed *********************** \n" );
			serverDB.closeDBconn();
			common.fileOutput(serverParameters.strLogFile, "\n_______________________________________________________________________________\n\n************End of Log File*********\n" ) ;

			if(serverParameters.isWindowsService)
			{
				stopService(true);
			}
						
			System.exit(0);
		}
		catch(Exception exp)
		{
			common.fileOutput(serverParameters.strExceptionLogFile, CommonUtil.getStringStackTrace(exp) + "\n" ) ;
		}
	}
}