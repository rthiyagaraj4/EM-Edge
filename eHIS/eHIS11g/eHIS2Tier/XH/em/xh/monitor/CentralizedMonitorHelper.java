package em.xh.monitor;

import javax.swing.JOptionPane;
import java.util.Scanner;
import HL7Engine.Common.*;

public class CentralizedMonitorHelper
{
	public String checkServiceExists(String serviceName) throws Exception
	{
		String cmd = "cmd /c sc query state= all|findstr " 
						+ serviceName.substring(0, serviceName.lastIndexOf("_"));

		Process p = Runtime.getRuntime().exec(cmd);

		String consoleMsg = CommonUtil.getConsoleMessage(p).trim();		

		if(consoleMsg.equals("")) serviceName = null;
		else
		{
			Scanner temp = new Scanner(consoleMsg);
			serviceName = temp.nextLine();
			serviceName = serviceName.substring(serviceName.indexOf(":") + 2);

			int tempIndex = serviceName.indexOf("_monitor");
			if(tempIndex > 0) serviceName = serviceName.substring(0, tempIndex);
		}
		return serviceName;
	}

	public boolean checkServiceStatus(String serviceName) throws Exception
	{
		String cmd = "SC QUERY " + serviceName;
		Process p = Runtime.getRuntime().exec(cmd);
		String consoleMsg = CommonUtil.getConsoleMessage(p).trim();
		boolean isServiceRunning = CommonUtil.isSubstringExists(consoleMsg, "RUNNING");
		return isServiceRunning;
	}

	public boolean startService(String serviceName) throws Exception
	{
		String cmd = "NET START " + serviceName;
		Runtime runtime = Runtime.getRuntime();
		Process p = runtime.exec(cmd);
		p.waitFor();
		String consoleMsg = CommonUtil.getConsoleMessage(p).trim();
		boolean isServiceRunning = CommonUtil.isSubstringExists(consoleMsg, "RUNNING");
		return isServiceRunning;
	}	
}