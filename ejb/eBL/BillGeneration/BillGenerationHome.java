package eBL.BillGeneration;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;



public interface BillGenerationHome extends EJBHome {
	 public BillGenerationRemote create() throws RemoteException, CreateException ;
}
