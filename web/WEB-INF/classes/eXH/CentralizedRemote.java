package eXH;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

public interface CentralizedRemote extends Remote
{
	public String startHl7Gateway(HashMap hashmap) throws RemoteException;
	   public HashMap chkServiceStatus(String serviceName) throws RemoteException;
	   public String stopHl7Gateway(String serviceName) throws RemoteException;  
	   public String checkServiceExists(String serviceName) throws Exception, RemoteException;
		public boolean checkServiceStatus(String serviceName) throws Exception, RemoteException;
		public boolean startService(String serviceName) throws Exception, RemoteException;   
}


