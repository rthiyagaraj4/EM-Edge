package eXH;
import java.io.InputStream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CentralizedCheckService 
{
	Runtime runtimeref = null;
	Process processref = null;
	String consolestr = "";
	String logFile = "";

	public CentralizedCheckService(String logFileName) 
	{
		logFile = logFileName;
	}

	public HashMap chkJavaServiceStatus(String serviceName) throws Exception 
	{
		boolean install = false;
		boolean start	= false;
		boolean stop	= false;

		HashMap hashmapref = new HashMap();
		runtimeref		= Runtime.getRuntime();
		String command	= "SC QUERY " + serviceName;
		processref = runtimeref.exec(command);
		consolestr = getConsoleMessage(processref);

		install = isSubstringExists(consolestr,"The specified service does not exist as an installed service");
		start = isSubstringExists(consolestr,"RUNNING");
		stop = isSubstringExists(consolestr,"STOPPED");

		hashmapref.put("install",new Boolean(install));
		hashmapref.put("start",new Boolean(start));
		hashmapref.put("stop",new Boolean(stop));
		return hashmapref; 
	}

	public String stopJavaService(String serviceName) throws Exception 
	{
		boolean statusflag = false;
		boolean chkserviceflag = false;
		String status = null;
		String statuscmd = "sc query " + serviceName;

		try
		{
			runtimeref = Runtime.getRuntime();
			processref = runtimeref.exec(statuscmd);
			consolestr = getConsoleMessage(processref);
			chkserviceflag = isSubstringExists(consolestr,"The specified service does not exist as an installed service");
			if(chkserviceflag == false)
			{

				String stopcmd = "sc stop " + serviceName;
				String stopMonitorCmd = "sc stop " + serviceName + "_monitor";

				runtimeref.exec(stopMonitorCmd);
				processref = runtimeref.exec(stopcmd);
				processref = runtimeref.exec(statuscmd);
				consolestr = getConsoleMessage(processref);				
				
				statusflag = isSubstringExists(consolestr,"STOPPED");
				if(statusflag)
				{
					String uninstall = "javaservice -uninstall " + serviceName;
					String uninstallMonitor = "javaservice -uninstall " + serviceName + "_monitor";

					processref = runtimeref.exec(uninstallMonitor);
					processref = runtimeref.exec(uninstall);
					processref = runtimeref.exec(statuscmd);
					consolestr = getConsoleMessage(processref);

					statusflag = isSubstringExists(consolestr,"The specified service does not exist as an installed service");
					if(statusflag)
					{
						status = serviceName + " Service Stopped Successfuly.. ";
					}
					else
					{
						status = "Uninstall Success...";
					}
				}
				else status = serviceName + " Service not Stopped .. ";
			}
			else  status = serviceName + " Service not Exists .. ";
		}
		catch(Exception exp)
		{

		}
		return status; 

	}//end of stopJavaService

	public boolean isSubstringExists(String str, String substr)
	{
		boolean status = false; 
		Pattern pattern = Pattern.compile(substr);
		Matcher matcher = pattern.matcher(str); 
		status = matcher.find();
		return status; 
	}

	public  String getConsoleMessage(Process processrefvar)
	{
		String string="";
		try
		{
			byte byteMsg[]= new byte[500];
			InputStream io=processrefvar.getInputStream();
			int intTotBytes = io.read(byteMsg);
			if (intTotBytes>0)  string = new String(byteMsg,0,intTotBytes);
		}
		catch(Exception ex){}

		return string;                      
	} 

	public  String getConsoleErrMsg(Process processrefvar)
	{
		String errMsg = "";
		InputStream io = null;
		try
		{
			byte byteMsg[] = new byte[500];
			io = processrefvar.getInputStream();
			int intTotBytes = io.read(byteMsg);
			if (intTotBytes > 0)  errMsg = new String(byteMsg, 0, intTotBytes);
		}
		catch(Exception ex){}
		finally
		{
			try
			{
				if(io != null) io.close();
			}
			catch (Exception exp)
			{
			}			
		}
		return errMsg;                      
	} 
}