/***************************************************************************************************************
* Author   :   Srinivasa.N
* Desc     :   Class  remote object client  
***************************************************************************************************************/

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.*;
import java.io.*;

/**
 * Class remote object client  
 */
class CentralizedRemoteOBjectClass  
{
	static CentralizedRemoteWriteLog write = new CentralizedRemoteWriteLog();

	public Object remoteObject(String client_id)
	{
		CentralizedRemote remoteObject = null;
		try
		{
			CentralizedWriteLog write = new  CentralizedWriteLog();
			String rmiPort = getRMIPort();
			String url = "//"+ client_id +":"+ rmiPort +"/InterfaceEngineRemoteObj";
			remoteObject = (CentralizedRemote)Naming.lookup(url);
			String logInfo = " (CentralizedRemoteOBjectClass:remoteObject) Obtained RemoteObj referrence @ "+url+"\n";
			write.fileOutput("C:/eHIS/reports/CentralizedMonitor.log",logInfo);
		}
		catch(Exception ex)
		{
			write.fileOutput("C:/eHIS/reports/CentralizedMonitor.log", "(CentralizedRemoteOBjectClass:remoteObject) RemoteException: "+ex.getMessage()+"\n");
		}

		return remoteObject;
	}

	/**
	 * Method retreives the rmi port from the properties config file.
	 * If the property "rmiport" is not found in the configuration file, by default it returns 1099.
	 */
	private static String getRMIPort()
	{
		String rmiPort = null;
		try
		{
			Properties properties = new Properties();
			File file = new File("C:/eHIS/config/properties.ini");

			if(!file.exists())
			{
				file = new File("C:/eHIS/reports/properties.ini");
			}
			
			properties.load(new FileInputStream(file));
			rmiPort = properties.getProperty("rmiport", "1099");

			if(rmiPort == null || rmiPort.trim().equals("")) rmiPort = "1099";
		}
		catch(Exception exp)
		{
			write.fileOutput("C:/eHIS/reports/CentralizedMonitor.log", " (CentralizedRemoteOBjectClass:getRMIPort) RemoteException: "+exp.toString()+"\n");
			exp.printStackTrace();
		}
		return rmiPort;
	}
}