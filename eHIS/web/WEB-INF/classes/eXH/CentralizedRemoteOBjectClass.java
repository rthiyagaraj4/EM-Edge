package eXH;


import java.rmi.Naming;

/**
 * Class remote object client  
 */
class CentralizedRemoteOBjectClass  
{
	public Object remoteObject(String ipAddress,String rmiPort)
	{
		em.xh.remoteserver.CentralizedRemote remoteObject = null;
		try
		{
			//String rmiPort = getRMIPort();
			String url = "//"+ ipAddress +":"+ rmiPort +"/InterfaceEngineRemoteObj";
			remoteObject = (em.xh.remoteserver.CentralizedRemote)Naming.lookup(url);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return remoteObject;
	}
	
	/**
	 * Method retreives the rmi port from the properties config file.
	 * If the property "rmiport" is not found in the configuration file, by default it returns 1099.
	 *//*
	private static String getRMIPort()
	{
		String rmiPort = null;
		try
		{
			Properties properties = new Properties();
			File file = new File("C:/eHIS/reports/properties.ini");
			
			properties.load(new FileInputStream(file));
			rmiPort = properties.getProperty("rmiport", "1099");

			if(rmiPort == null || rmiPort.trim().equals("")) rmiPort = "1099";
		}
		catch(Exception exp)
		{
			exp.printStackTrace();
		}
		return rmiPort;
	}*/
}