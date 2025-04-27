import java.rmi.*;
import java.util.*;

public interface CentralizedRemote extends Remote
{
   public String startHl7Gateway(HashMap hashmap) throws RemoteException;
   public HashMap chkServiceStatus(String applicationid,String facilityid,String processid) throws RemoteException;
   public String stopHl7Gateway(String applicationid,String facilityid,String processid) throws RemoteException;   
}


