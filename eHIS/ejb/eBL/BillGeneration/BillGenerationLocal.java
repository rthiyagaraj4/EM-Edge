package eBL.BillGeneration;

import javax.ejb.EJBLocalObject;

import eBL.billreceipt.model.BillReceiptExistOrderExclusion;
import eBL.billreceipt.request.BillGenerationRequest;
import eBL.billreceipt.response.BillGenerationResponse;
import eBL.billreceipt.model.BLBillGenInterfaceBean;

public interface BillGenerationLocal extends EJBLocalObject{
	
	public BillGenerationResponse generateBills(BillGenerationRequest billGenRequest, BillReceiptExistOrderExclusion exclusionBean);

	public java.util.List<String> processInterfaceRecords(BLBillGenInterfaceBean bean);



}
