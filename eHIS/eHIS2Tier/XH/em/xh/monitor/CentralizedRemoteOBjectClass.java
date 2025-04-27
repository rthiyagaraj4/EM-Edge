package em.xh.monitor;

/***************************************************************************************************************
* Author   :   Srinivasa.N
* Desc     :   Class  remote object client  
***************************************************************************************************************/

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.util.*;
import java.io.*;

import em.xh.remoteserver.CentralizedRemote;
import HL7Engine.Common.InterfaceUtil;

/**
 * Class remote object client  
 */
class CentralizedRemoteOBjectClass  
{
	static CentralizedWriteLog write = new  CentralizedWriteLog();

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
			write.fileOutput(InterfaceUtil.getDefaultLogLoc("CentralizedMonitor"),logInfo);
		}
		catch(Exception ex)
		{
			write.fileOutput(InterfaceUtil.getDefaultLogLoc("CentralizedMonitor"), "(CentralizedRemoteOBjectClass:remoteObject) RemoteException: "+ex.getMessage()+"\n");
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
			File file = new File(InterfaceUtil.getiniFilePath("CONFIG"));

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
			write.fileOutput(InterfaceUtil.getDefaultLogLoc("CentralizedMonitor"), " (CentralizedRemoteOBjectClass:getRMIPort) RemoteException: "+exp.toString()+"\n");
			exp.printStackTrace();
		}
		return rmiPort;
	}
}