package em.xh.remoteserver;
import java.rmi.*;
import java.util.*;

public interface CentralizedRemote extends Remote
{
   public String startHl7Gateway(HashMap hashmap) throws RemoteException;
   public HashMap chkServiceStatus(String serviceName) throws RemoteException;
   public String stopHl7Gateway(String serviceName) throws RemoteException;   
}


