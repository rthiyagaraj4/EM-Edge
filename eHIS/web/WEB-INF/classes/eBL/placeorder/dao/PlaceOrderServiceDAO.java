package eBL.placeorder.dao;

import java.util.HashMap;

import eBL.placeorder.request.PlaceNewOrderRequest;
import eBL.placeorder.response.PlaceNewOrderResponse;

public interface PlaceOrderServiceDAO {
	
	HashMap getBlngServGroup(String locale);
	
	PlaceNewOrderResponse getServiceDetailsData(PlaceNewOrderRequest bean);
	
	PlaceNewOrderResponse getServicePkgDtls(PlaceNewOrderRequest chargeBean);
	
	HashMap<String,String> getServiceGroup(String locale);
	
	PlaceNewOrderResponse getServiceDetails(PlaceNewOrderRequest chargeBean);

	String[] getPrivilege(String user, String facility);
	
	String[] getPrivilegeForUser(String user, String facility);
}
