package eBL.billreceipt.bc;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import com.google.gson.JsonObject;

import eBL.billreceipt.dao.BillReceiptServiceDAO;
import eBL.billreceipt.dao.BillReceiptServiceDAOImpl;
import eBL.billreceipt.model.BLBillGenInterfaceBean;
import eBL.billreceipt.model.BillReceiptCustomerDetails;
import eBL.billreceipt.model.BillReceiptExistOrderExclusion;
import eBL.billreceipt.model.BillReceiptInfoDetails;
import eBL.billreceipt.model.BillReceiptPackageInfo;
import eBL.billreceipt.model.BillReceiptUnbillOutst;
import eBL.billreceipt.model.BLBillGenInterfaceBean;
import eBL.billreceipt.model.BLBillGenInterfaceInBean;
import eBL.billreceipt.request.BillGenerationRequest;
import eBL.billreceipt.request.BillReceiptRequest;
import eBL.billreceipt.response.BillReceiptResponse;
import eBL.placeorder.dao.PlaceOrderServiceDAOImpl;
import eBL.placeorder.request.PlaceNewOrderRequest;
import eBL.placeorder.response.PlaceNewOrderResponse;

public class BillReceiptBC {
	BillReceiptServiceDAO billReceiptDAO = null;
	
	public LinkedHashMap<String,String> getServiceLocation(BillReceiptRequest request){
		billReceiptDAO = new BillReceiptServiceDAOImpl();
		return billReceiptDAO.getServiceLocation(request);
	}
	
	public HashMap<String,String> getBillOptions(BillReceiptRequest request){
		billReceiptDAO = new BillReceiptServiceDAOImpl();
		return billReceiptDAO.getBillOptions(request);
	}
	
	/**
	 * Method used to retrieve the Existing Orders for the Patient. 
	 * This Method will be called from BLChargePatientExisOrderServDetails.jsp
	 */
	public BillReceiptResponse getServiceDetailsData(PlaceNewOrderRequest bean,Connection conn){
		BillReceiptResponse response  = null;
		billReceiptDAO = new BillReceiptServiceDAOImpl();
		response = billReceiptDAO.getServiceDetailsData(bean,conn);
		return response;
	}
	
	public void insertExcludedServices(PlaceNewOrderRequest bean,BillReceiptExistOrderExclusion exclusionData,Connection conn){
		billReceiptDAO = new BillReceiptServiceDAOImpl();
		billReceiptDAO.insertExcludedServices(bean,exclusionData,conn);
	}
	
	public void print(){
		billReceiptDAO = new BillReceiptServiceDAOImpl();
		billReceiptDAO.print();
	}
	
	public void print(Connection conn){
		billReceiptDAO = new BillReceiptServiceDAOImpl();
		billReceiptDAO.print(conn);
	}
	
	public BillReceiptUnbillOutst getTotOutstUnbilled(BillReceiptRequest billRequest){
		BillReceiptUnbillOutst outstDetails = null;
		billReceiptDAO = new BillReceiptServiceDAOImpl();
		outstDetails = billReceiptDAO.getTotOutstUnbilled(billRequest);
		return outstDetails;
	}
	
	public BillReceiptInfoDetails getHeaderDetails(BillReceiptRequest billRequest){
		BillReceiptInfoDetails infoDtls = null;
		billReceiptDAO = new BillReceiptServiceDAOImpl();
		infoDtls = billReceiptDAO.getHeaderDetails(billRequest);
		return infoDtls;
	}
	
	public List<BillReceiptUnbillOutst> getOutstandingBills(BillReceiptRequest billRequest){
		List<BillReceiptUnbillOutst> billInfo = null;
		billReceiptDAO = new BillReceiptServiceDAOImpl();
		billInfo = billReceiptDAO.getOutstandingBills(billRequest);
		return billInfo;
	}
	
	public List<BillReceiptUnbillOutst> getUnBilledEpisode(BillReceiptRequest billRequest){
		List<BillReceiptUnbillOutst> billInfo = null;
		billReceiptDAO = new BillReceiptServiceDAOImpl();
		billInfo = billReceiptDAO.getUnBilledEpisode(billRequest);
		return billInfo;
	}
	
	
	public HashMap<String,List<BillReceiptUnbillOutst>> getUnBilledEpisodeRequest(BillReceiptRequest billRequest){
		HashMap<String,List<BillReceiptUnbillOutst>> billInfoMap = null;
		billReceiptDAO = new BillReceiptServiceDAOImpl();
		billInfoMap = billReceiptDAO.getUnBilledEpisodeRequest(billRequest);
		return billInfoMap;
	}

	public List<BillReceiptPackageInfo> getPackageClosureDtls(BillReceiptRequest billRequest){
		List<BillReceiptPackageInfo> pkgClosureList = null;
		billReceiptDAO = new BillReceiptServiceDAOImpl();
		pkgClosureList = billReceiptDAO.getPackageClosureDtls(billRequest);
		return pkgClosureList;
	}

	public List<BillReceiptPackageInfo> getPackageDtls(BillReceiptRequest billRequest){
		List<BillReceiptPackageInfo> pkgList = null;
		billReceiptDAO = new BillReceiptServiceDAOImpl();
		pkgList = billReceiptDAO.getPackageDtls(billRequest);
		return pkgList;
	}
	
	public List<BillReceiptCustomerDetails> getEncBillDetails(BillReceiptRequest billRequest){
		List<BillReceiptCustomerDetails> custList = null;
		billReceiptDAO = new BillReceiptServiceDAOImpl();
		custList = billReceiptDAO.getEncBillDetails(billRequest);
		return custList;
	}
	
	public JsonObject closePackage(BillReceiptRequest billRequest){
		JsonObject obj = new JsonObject();
		billReceiptDAO = new BillReceiptServiceDAOImpl();
		String error = "";
		List<String> errorList = billReceiptDAO.closePackage(billRequest);
		if(errorList.isEmpty()){
			obj.addProperty("success", "Y");			
		}
		else{
			obj.addProperty("success", "N");
			for (Iterator<String> iterator = errorList.iterator(); iterator.hasNext();) {
				error += (String) iterator.next();
				error += "\n";				
			}
			obj.addProperty("error", error);
		}
		return obj;
	}

	public JsonObject reopenPackage(BillReceiptRequest billRequest){
		JsonObject obj = new JsonObject();
		billReceiptDAO = new BillReceiptServiceDAOImpl();
		String error = "";
		List<String> errorList = billReceiptDAO.reopenPackage(billRequest);
		if(errorList.isEmpty()){
			obj.addProperty("success", "Y");			
		}
		else{
			obj.addProperty("success", "N");
			for (Iterator<String> iterator = errorList.iterator(); iterator.hasNext();) {
				error += (String) iterator.next();
				error += "\n";				
			}
			obj.addProperty("error", error);
		}
		return obj;
	}
	
	public String bedComputationYN(BillReceiptRequest billRequest){
		String computeYN = "";
		billReceiptDAO = new BillReceiptServiceDAOImpl();
		computeYN = billReceiptDAO.bedComputationYN(billRequest);
		return computeYN;
	}
	
	public JsonObject bedComputationAlert(BillReceiptRequest billRequest){
		JsonObject obj = null;
		billReceiptDAO = new BillReceiptServiceDAOImpl();
		obj = billReceiptDAO.bedComputationAlert(billRequest);
		return obj;
	}
	
	public String bedComputationMain(BillReceiptRequest billRequest){
		String error = "";
		billReceiptDAO = new BillReceiptServiceDAOImpl();
		List<String> errorList = billReceiptDAO.bedComputationMain(billRequest);
		for (Iterator iterator = errorList.iterator(); iterator.hasNext();) {
			String err = (String) iterator.next();
			error += err+"\n";
		}
		return error;
	}
	
	public JsonObject recalcDepositSlmt(BillGenerationRequest billRequest){
		JsonObject obj = null;
		billReceiptDAO = new BillReceiptServiceDAOImpl();
		obj = billReceiptDAO.recalcDepositSlmt(billRequest);
		return obj;
	}
	
	public JsonObject validateCashCounter(BillReceiptRequest billRequest){
		JsonObject obj = null;
		billReceiptDAO = new BillReceiptServiceDAOImpl();
		obj = billReceiptDAO.validateCashCounter(billRequest);
		return obj;
	}
	
	public JsonObject specialClinicValidate(BillReceiptRequest billRequest){
		JsonObject obj = null;
		billReceiptDAO = new BillReceiptServiceDAOImpl();
		obj = billReceiptDAO.specialClinicValidate(billRequest);
		return obj;
	}
	public JsonObject validateSettlementAmt(BillGenerationRequest billRequest){
		JsonObject obj = null;
		billReceiptDAO = new BillReceiptServiceDAOImpl();
		obj = billReceiptDAO.validateSettlementAmt(billRequest);
		return obj;
	}
	public JsonObject validateExemptionAmt(BillGenerationRequest billRequest){
		JsonObject obj = null;
		billReceiptDAO = new BillReceiptServiceDAOImpl();
		obj = billReceiptDAO.validateExemptionAmt(billRequest);
		return obj;
	}
	
	public JsonObject chkExcludeServValidate(BillReceiptRequest billRequest){
		JsonObject obj = null;
		billReceiptDAO = new BillReceiptServiceDAOImpl();
		obj = billReceiptDAO.chkExcludeServValidate(billRequest);
		return obj;
	}
	public JsonObject UnprocessedCheck(BillReceiptRequest billRequest){
		JsonObject obj = null;
		billReceiptDAO = new BillReceiptServiceDAOImpl();
		obj = billReceiptDAO.UnprocessedCheck(billRequest);
		return obj;
	}
	
	public String checkForServiceDiscount(BillReceiptRequest billRequest){
		String allowedYn = "";
		billReceiptDAO = new BillReceiptServiceDAOImpl();
		allowedYn = billReceiptDAO.checkForServiceDiscount(billRequest);
		return allowedYn;
	}

	public List<BLBillGenInterfaceBean> getBillGenInterfaceRecords(BLBillGenInterfaceInBean inBean){
		List<BLBillGenInterfaceBean> searchList=null;
		billReceiptDAO=new BillReceiptServiceDAOImpl();
		searchList=billReceiptDAO.getBillGenInterfaceRecords(inBean);
		return searchList;
	}
	


	public String getDate()
	{
		String currentDate="";
		billReceiptDAO=new BillReceiptServiceDAOImpl();
		currentDate=billReceiptDAO.getDate();
		return currentDate;
	}
	
	public String getAllRecordsDate()
	{
		String allRecordsDate="";
		billReceiptDAO=new BillReceiptServiceDAOImpl();
		allRecordsDate=billReceiptDAO.getAllRecordsDate();
		return allRecordsDate;
	}

	public LinkedHashMap<String,String> getFacilityDetails(BLBillGenInterfaceInBean inBean)
	{
		LinkedHashMap<String,String> facDtls=new LinkedHashMap<String, String>();
		billReceiptDAO=new BillReceiptServiceDAOImpl();
		facDtls=billReceiptDAO.getFacilityDetails(inBean);
		return facDtls;
	}
	
	public HashMap<String,String> getOutstandingUnbilled(BillReceiptRequest billRequest){
		HashMap<String,String> map = new HashMap<String, String>();
		billReceiptDAO=new BillReceiptServiceDAOImpl();
		map = billReceiptDAO.getOutstandingUnbilled(billRequest);
		return map;
	}
	
	public String getCredentails(String userId){
		billReceiptDAO=new BillReceiptServiceDAOImpl();
		return billReceiptDAO.getCredentails(userId);
	}
	
}
