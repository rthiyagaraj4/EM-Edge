package eBL.placeorder.dao;

import java.sql.Connection;
import java.util.Properties;

import eBL.placeorder.request.PlaceNewOrderRequest;
import eBL.placeorder.response.PlaceNewOrderResponse;

@SuppressWarnings("rawtypes")
public interface PlaceOrderDAO {

	public PlaceNewOrderResponse placeNewOrder(PlaceNewOrderRequest requestBean);
	
	public PlaceNewOrderResponse cancelExistingOrder(PlaceNewOrderRequest requestBean);
	
	public PlaceNewOrderResponse confirmExistingOrder(PlaceNewOrderRequest requestBean);
	
	public PlaceNewOrderResponse amendExistingOrder(PlaceNewOrderRequest requestBean);
	
	public PlaceNewOrderResponse discountToExistingOrder(PlaceNewOrderRequest requestBean);
	
	public String replaceNull(String input);
	
	String getPanelStr(String panelCode,Connection con);
	
}
