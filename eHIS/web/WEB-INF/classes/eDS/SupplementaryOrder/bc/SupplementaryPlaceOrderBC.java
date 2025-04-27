package eDS.SupplementaryOrder.bc;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import eDS.SupplementaryOrder.dao.SupplementaryPlaceOrderDAO;
import eDS.SupplementaryOrder.dao.SupplementaryPlaceOrderDAOImpl;
import eDS.SupplementaryOrder.model.PlaceSupplementaryMealOrderRequest;
import eDS.SupplementaryOrder.model.PlaceSupplementaryMealOrderResponse;
import eDS.SupplementaryOrder.model.SupplementaryPlaceOrderRequest;
import eDS.SupplementaryOrder.model.SupplementaryPlaceOrderResponse;
import eDS.SupplementaryOrder.model.SupplementaryProcessRequest;
public class SupplementaryPlaceOrderBC {
	SupplementaryPlaceOrderDAO supplementryDAO=null;
public SupplementaryPlaceOrderResponse getSupplementayPlaceSearch(SupplementaryPlaceOrderRequest request,Connection con){		
		SupplementaryPlaceOrderResponse supplementaryDtls=null;
		
		supplementryDAO=new SupplementaryPlaceOrderDAOImpl();
		supplementaryDtls=supplementryDAO.getSupplementayPlaceSearch(request, con);
		return supplementaryDtls;
	}
	
public String insertSupplementaryMealOrder(PlaceSupplementaryMealOrderRequest request,Connection con){
	String result="";
		supplementryDAO=new SupplementaryPlaceOrderDAOImpl();
		result=supplementryDAO.insertSupplementaryMealOrder(request, con);
	
	return result;
}

public List<PlaceSupplementaryMealOrderResponse> getSupplementaryMealOrder(PlaceSupplementaryMealOrderRequest request,Connection connection){
	List<PlaceSupplementaryMealOrderResponse> supplementaryOrderResponseList=null;
	
	supplementaryOrderResponseList=new ArrayList<PlaceSupplementaryMealOrderResponse>();
	supplementryDAO=new SupplementaryPlaceOrderDAOImpl();
	supplementaryOrderResponseList=supplementryDAO.getSupplementaryMealOrder(request, connection);
	
	return supplementaryOrderResponseList;
}

public List<PlaceSupplementaryMealOrderResponse> getOldSupplementaryMealOrder(PlaceSupplementaryMealOrderRequest request,Connection connection){
	List<PlaceSupplementaryMealOrderResponse> supplementaryOrderResponseList=null;	
	supplementaryOrderResponseList=new ArrayList<PlaceSupplementaryMealOrderResponse>();
	supplementryDAO=new SupplementaryPlaceOrderDAOImpl();
	supplementaryOrderResponseList=supplementryDAO.getOldSupplementaryMealOrder(request, connection);	
	return supplementaryOrderResponseList;
}
public SupplementaryPlaceOrderResponse getProcessSupplementaryOrderList(SupplementaryProcessRequest request,Connection connection){
	SupplementaryPlaceOrderResponse processSupplementaryOrderResponseObj=null;
	processSupplementaryOrderResponseObj=new SupplementaryPlaceOrderResponse();
	supplementryDAO=new SupplementaryPlaceOrderDAOImpl();
	processSupplementaryOrderResponseObj=supplementryDAO.getProcessSupplementaryOrderList(request,connection);
	

	
	
	return processSupplementaryOrderResponseObj;
}
public String updateSupplementaryMealOrder(SupplementaryProcessRequest request,Connection connection){
	supplementryDAO=new SupplementaryPlaceOrderDAOImpl();
	String result=supplementryDAO.updateSupplementaryMealOrder(request, connection);
	return result;
}
}
