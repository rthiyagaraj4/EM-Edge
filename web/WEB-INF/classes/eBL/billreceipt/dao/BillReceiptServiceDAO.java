package eBL.billreceipt.dao;

import java.sql.Connection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.google.gson.JsonObject;

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
import eBL.placeorder.request.PlaceNewOrderRequest;

public interface BillReceiptServiceDAO {
	public LinkedHashMap<String,String> getServiceLocation(BillReceiptRequest request);
	
	public HashMap<String,String> getBillOptions(BillReceiptRequest request);
	
	public BillReceiptResponse getServiceDetailsData(PlaceNewOrderRequest bean,Connection conn);
	
	public void insertExcludedServices(PlaceNewOrderRequest bean,BillReceiptExistOrderExclusion exclusionData,Connection conn);
	
	public void print();
	
	public void print(Connection conn);

	public BillReceiptUnbillOutst getTotOutstUnbilled(BillReceiptRequest billRequest);

	public BillReceiptInfoDetails getHeaderDetails(BillReceiptRequest billRequest);

	public List<BillReceiptUnbillOutst> getOutstandingBills(BillReceiptRequest billRequest);
	
	public List<BillReceiptUnbillOutst> getUnBilledEpisode(BillReceiptRequest billRequest);
	
	public HashMap<String,List<BillReceiptUnbillOutst>> getUnBilledEpisodeRequest(BillReceiptRequest billRequest);

	public List<BillReceiptPackageInfo> getPackageClosureDtls(BillReceiptRequest billRequest);

	public List<BillReceiptPackageInfo> getPackageDtls(BillReceiptRequest billRequest);

	public List<BillReceiptCustomerDetails> getEncBillDetails(BillReceiptRequest billRequest);

	public List<String> closePackage(BillReceiptRequest billRequest);
	
	public List<String> reopenPackage(BillReceiptRequest billRequest);
	
	public String bedComputationYN(BillReceiptRequest billRequest);

	public JsonObject bedComputationAlert(BillReceiptRequest billRequest);

	public List<String> bedComputationMain(BillReceiptRequest billRequest);

	public JsonObject recalcDepositSlmt(BillGenerationRequest billRequest);

	public List<BLBillGenInterfaceBean> getBillGenInterfaceRecords(BLBillGenInterfaceInBean inBean);
	

	public String getDate();
	public String getAllRecordsDate();
	
	public LinkedHashMap<String,String> getFacilityDetails(BLBillGenInterfaceInBean inBean);
	
	public JsonObject validateCashCounter(BillReceiptRequest billRequest);
	
	public JsonObject validateSettlementAmt(BillGenerationRequest billRequest);

	public JsonObject validateExemptionAmt(BillGenerationRequest billRequest);
	
	public JsonObject specialClinicValidate(BillReceiptRequest billRequest);
	
	public JsonObject chkExcludeServValidate(BillReceiptRequest billRequest);

	public String checkForServiceDiscount(BillReceiptRequest billRequest);
	public JsonObject UnprocessedCheck(BillReceiptRequest billRequest);
	
	public HashMap<String,String> getOutstandingUnbilled(BillReceiptRequest billRequest);
	
	public String getCredentails(String userId);
}
