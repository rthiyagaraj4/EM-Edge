package eBL.ChargePatientNewOrder;

import java.rmi.* ;

import javax.ejb.* ;

import eBL.placeorder.request.PlaceNewOrderRequest;
import eBL.placeorder.response.PlaceNewOrderResponse;


public interface ChargePatientNewOrderRemote extends EJBObject
{
	 public PlaceNewOrderResponse recordBLCharges(PlaceNewOrderRequest requestBean) throws RemoteException;
	 public PlaceNewOrderResponse cancelBLServ(PlaceNewOrderRequest requestBean) throws RemoteException;
	 public PlaceNewOrderResponse confirmBLServ(PlaceNewOrderRequest requestBean) throws RemoteException;
	 public PlaceNewOrderResponse amendBLServ(PlaceNewOrderRequest requestBean) throws RemoteException;
	 public PlaceNewOrderResponse cancelAll(PlaceNewOrderRequest requestBean) throws RemoteException;
	 public PlaceNewOrderResponse confirmAll(PlaceNewOrderRequest requestBean) throws RemoteException;
	 public PlaceNewOrderResponse processBLServ(PlaceNewOrderRequest requestBean) throws RemoteException;
	 public PlaceNewOrderResponse processAll(PlaceNewOrderRequest requestBean) throws RemoteException;
	    
}
									 