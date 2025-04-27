package eBL.ChargePatientNewOrder;

import javax.ejb.* ;

import eBL.placeorder.request.PlaceNewOrderRequest;
import eBL.placeorder.response.PlaceNewOrderResponse;

import java.rmi.RemoteException;
import java.sql.* ;

public interface ChargePatientNewOrderLocal extends EJBLocalObject
{
	 public PlaceNewOrderResponse recordBLCharges(PlaceNewOrderRequest requestBean);
	 public PlaceNewOrderResponse cancelBLServ(PlaceNewOrderRequest requestBean);
	 public PlaceNewOrderResponse confirmBLServ(PlaceNewOrderRequest requestBean);
	 public PlaceNewOrderResponse amendBLServ(PlaceNewOrderRequest requestBean);
	 public PlaceNewOrderResponse discountBLServ(PlaceNewOrderRequest requestBean);
	 public PlaceNewOrderResponse cancelAll(PlaceNewOrderRequest requestBean);
	 public PlaceNewOrderResponse confirmAll(PlaceNewOrderRequest requestBean);
	 public PlaceNewOrderResponse processBLServ(PlaceNewOrderRequest requestBean);
	 public PlaceNewOrderResponse processAll(PlaceNewOrderRequest requestBean);
   
}
