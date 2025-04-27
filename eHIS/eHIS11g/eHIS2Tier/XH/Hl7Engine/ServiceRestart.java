/*
	Developed by  : Ravindranath
	Created on    : 10/05/2009
*/

import HL7Engine.Common.Common;
import HL7Engine.Common.CommonUtil;
import HL7Engine.Common.InterfaceUtil;

/**
 * Class is used to monitor the gateway process started as windows service. 
 * It checks whether the service is running or not, starts the service if it is stopped. 
 */
public class ServiceRestart extends Thread
{
    public String serviceName = "";
    public String logFileName = "";

    long previuosLogTime = System.currentTimeMillis();

    Common common = null;

    public ServiceRestart(String serviceName,String logFile)
    {    	
    	common = Common.getInstance();
    	try
    	{
    	    this.serviceName = serviceName;
    	    logFileName = logFile;
    	    logFileName = logFileName.replaceAll("\\.log", "_serviceMonitor.log");
    	    this.start();
    	}
    	catch(Exception exp)
    	{
    		String defaultLoc = InterfaceUtil.getDefaultLogLoc("ServiceRestart");
    	    common.fileOutput(defaultLoc, "(ServiceRestart)Exception: "+exp.toString()+"\n" ) ;
    	}
    }

    /**
     * Method checks and start the service if it is stopped.
     */
    public void run()
    {
    	String statusCmd = "sc query "+serviceName; // Command to check the status of the service.
    	String startCmd = "sc start "+serviceName; // Command to start the service.
    	String status = "";
    
    	Process process = null;
    
    	common.fileOutput(logFileName, "(ServiceRestart:restartService)Service Status Cmd "+statusCmd+"\n" ) ;
    	common.fileOutput(logFileName, "(ServiceRestart:restartService)Service Start Cmd "+startCmd+"\n" ) ;
    
    	while(true)
    	{
    	    try
    	    {
        		Runtime runtime = Runtime.getRuntime();
        		process = runtime.exec(statusCmd);
        		status = CommonUtil.getConsoleMessage(process);
        		boolean isStopped = CommonUtil.isSubstringExists(status,"STOPPED");
        
        		if((System.currentTimeMillis() - previuosLogTime) > 60000)
        		{
        		    if(!isStopped) common.fileOutput(logFileName, "(ServiceRestart:restartService) Service Running...\n" ) ;
        		    else common.fileOutput(logFileName, "(ServiceRestart:restartService) Service stopped...\n" ) ;
        		    previuosLogTime = System.currentTimeMillis();
        		}
        
        		if(isStopped)
        		{
        		    process = runtime.exec(startCmd);
        
        		    // Putting thread to sleep before querying the status of the service,
        		    // as it takes some time for the service to start.
        		    Thread.sleep(1000);
        
        		    process = runtime.exec(statusCmd);
        		    status = CommonUtil.getConsoleMessage(process);
        		    boolean isRunning = CommonUtil.isSubstringExists(status,"RUNNING");
        
        		    if(isRunning) 
        		    {
        		    	common.fileOutput(logFileName, "(ServiceRestart:restartService) Service restarted successfully... \n" ) ;										
        		    }
        		    else
        		    {
        		    	common.fileOutput(logFileName, "(ServiceRestart:restartService) Failed to restart the service... \n" ) ;
        		    }
        		}
        		Thread.sleep(2000);
    	    }
    	    catch(Exception exp)
    	    {
    		common.fileOutput(logFileName, "(ServiceRestart:restartService)Exception "+exp+"\n" ) ;
    	    }
    	}
    }

    public static void main(String a[])
    {
	try
	{
	    new ServiceRestart(a[0],a[1]);
	}
	catch(Exception exp)
	{
	    exp.printStackTrace();
	}
    }
}
