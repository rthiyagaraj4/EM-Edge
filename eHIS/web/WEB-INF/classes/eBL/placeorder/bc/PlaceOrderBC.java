package eBL.placeorder.bc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.google.gson.JsonObject;

import eBL.placeorder.dao.PlaceOrderServiceDAO;
import eBL.placeorder.dao.PlaceOrderServiceDAOImpl;
import eBL.placeorder.model.BLChargePatientNewOrderBean;
import eBL.placeorder.request.PlaceNewOrderRequest;
import eBL.placeorder.response.PlaceNewOrderResponse;


/**
 * @author ravaradharajan
 * Service Class which Delegates its Request to PlaceOrderServiceDAO.java
 */
public class PlaceOrderBC {
	
	PlaceOrderServiceDAO placeOrderServiceDAO = null;
	
	/**
	 * Method used to retrieve all the Service Group
	 */
	public HashMap<String,String> getBlngServGroup(String locale){
		HashMap<String, String> blngServGroup = null;
		placeOrderServiceDAO = new PlaceOrderServiceDAOImpl();
		blngServGroup = placeOrderServiceDAO.getBlngServGroup(locale);
		return blngServGroup;
	}
	
	/**
	 * Method used to retrieve the Existing Orders for the Patient. 
	 * This Method will be called from BLChargePatientExisOrderServDetails.jsp
	 */
	public PlaceNewOrderResponse getServiceDetailsData(PlaceNewOrderRequest bean){
		PlaceNewOrderResponse response  = null;
		placeOrderServiceDAO = new PlaceOrderServiceDAOImpl();
		response = placeOrderServiceDAO.getServiceDetailsData(bean);
		return response;
	}
	
	/**
	 * Method Retrieves the Service List or Panel List.
	 * Used for Placing New Order.
	 * Called from BLChargePatientNewOrderDetails.jsp
	 */
	public PlaceNewOrderResponse getServicePkgDtls(PlaceNewOrderRequest chargeBean){
		PlaceNewOrderResponse response  = null;
		placeOrderServiceDAO = new PlaceOrderServiceDAOImpl();
		response = placeOrderServiceDAO.getServicePkgDtls(chargeBean);
		return response;
	}
	
	/**
	 * Method retrieves the List of Billing Service Group
	 */
	public HashMap<String,String> getServiceGroup(String locale){
		HashMap<String, String> blngServGroup = null;
		placeOrderServiceDAO = new PlaceOrderServiceDAOImpl();
		blngServGroup = placeOrderServiceDAO.getServiceGroup(locale);
		return blngServGroup;
	}
	
	/**
	 * Method Sends the Details for a Service or Panel. 
	 * This is Executed once user clicks the Service / Panel.
	 * Calls orginates from Ajax request BLChargePatientNewOrderPersistence.jsp
	 */
	public PlaceNewOrderResponse getServiceDetails(PlaceNewOrderRequest chargeBean){
		PlaceNewOrderResponse bean = null;
		placeOrderServiceDAO = new PlaceOrderServiceDAOImpl();
		bean = placeOrderServiceDAO.getServiceDetails(chargeBean);
		return bean;
	}
	
	/**
	 * Method Sends the Updated Details for a Service or Panel by getting its quantity as input. 
	 * Calls orginates from Ajax request BLChargePatientNewOrderPersistence.jsp
	 * Updated Rate & Discount is passed as JSON
	 */
	public JsonObject updateServiceDetails(PlaceNewOrderRequest chargeBean){
		PlaceNewOrderResponse responseBean = null;
		JsonObject obj = null;
		placeOrderServiceDAO = new PlaceOrderServiceDAOImpl();
		responseBean = placeOrderServiceDAO.getServiceDetails(chargeBean);
		List<String> errorList = responseBean.getErrorList();
		BLChargePatientNewOrderBean bean = responseBean.getNewOrderBean();
		
		StringBuffer consErrorText = new StringBuffer();
		String error = "";
		if(!errorList.isEmpty()){
			for (Iterator<String> iterator = errorList.iterator(); iterator.hasNext();) {
				error = (String) iterator.next();
				consErrorText.append(error);
				consErrorText.append("\n");
			}
		}
		error = consErrorText.toString();
		
		if("".equals(error)){
				obj = new JsonObject();
				obj.addProperty("Success","Y");
				obj.addProperty("GrossAmount", bean.getGrossAmount());
				obj.addProperty("NetChargeAmount", bean.getNetChargeAmount());
				obj.addProperty("PatGrossChargeAmount", bean.getPatGrossChargeAmt());
				obj.addProperty("PatNetChargeAmount", bean.getPatNetChargeAmt());
				obj.addProperty("PatDiscAmount", bean.getServDiscount());
				obj.addProperty("PanelString", bean.getPanelString());
				obj.addProperty("PatientPaid", bean.getPatPaidAmt());
		}
		else{
			obj = new JsonObject();
			obj.addProperty("Success","N");
			obj.addProperty("Error",error);
		}
		
		return obj;
	}
	
	public String[] getPrivilege(String user, String facility){
		String[] privilege = new String[2];
		placeOrderServiceDAO = new PlaceOrderServiceDAOImpl();
		privilege = placeOrderServiceDAO.getPrivilege(user,facility);
		return privilege;
	}
	
	public String[] getPrivilegeForUser(String user, String facility){
		String[] privilege = new String[11];
		placeOrderServiceDAO = new PlaceOrderServiceDAOImpl();
		privilege = placeOrderServiceDAO.getPrivilegeForUser(user,facility);
		return privilege;
	}
}
