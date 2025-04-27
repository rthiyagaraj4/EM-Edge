/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 *  
 */
package eIPAD.chartsummary.pendingorders.bc;

import java.util.ArrayList;

import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.pendingorders.dao.PendingOrderDAO;
import eIPAD.chartsummary.pendingorders.daoimpl.PendingOrderDAOImpl;
import eIPAD.chartsummary.pendingorders.healthobject.PendingOrderCountHO;
import eIPAD.chartsummary.pendingorders.request.PendingOrderRequest;
import eIPAD.chartsummary.pendingorders.response.PendingOrderConstants;
import eIPAD.chartsummary.pendingorders.response.PendingOrderCountResponse;
import eIPAD.chartsummary.pendingorders.response.PendingOrderFormatResponse;
import eIPAD.chartsummary.pendingorders.response.PendingOrderResponse;

/**
 * @author SaraswathiR
 *
 */
public class PendingOrderBC {

	public PendingOrderResponse getPendingOrdersDetails(PendingOrderRequest oPendingOrderReq){
		PendingOrderResponse resp = new PendingOrderResponse();
		PendingOrderDAO dao = new PendingOrderDAOImpl();
		resp = dao.getPendingOrdersDetails(oPendingOrderReq);
		return resp;
	}
	public PendingOrderCountResponse getPendingOrderItemsCount(PatContext rPatContext){
		PendingOrderCountResponse resp = new PendingOrderCountResponse();
		PendingOrderDAO dao = new PendingOrderDAOImpl();
		resp = dao.getPendingOrderItemsCount(rPatContext);
		//Changing the order of items for the view
		if(resp.isSuccessResponse()){
			String orderArr[] = PendingOrderConstants.categoryOrder;
			ArrayList<PendingOrderCountHO> pendingOrderCountList = resp.getPendingOrderCountList();
			
			PendingOrderCountHO labPendingOrderCountHO = null;
			PendingOrderCountHO radPendingOrderCountHO = null;
			PendingOrderCountHO otPendingOrderCountHO = null;
			PendingOrderCountHO diagPendingOrderCountHO = null;
			PendingOrderCountHO dietPendingOrderCountHO = null;
			PendingOrderCountHO miscPendingOrderCountHO = null;
			PendingOrderCountHO moniPendingOrderCountHO = null;
			PendingOrderCountHO oralPendingOrderCountHO = null;
			PendingOrderCountHO ordPendingOrderCountHO = null;
			PendingOrderCountHO consPendingOrderCountHO = null;
			PendingOrderCountHO pcPendingOrderCountHO = null;
			PendingOrderCountHO pharmPendingOrderCountHO = null;
			PendingOrderCountHO treatPendingOrderCountHO = null;
			
			
			for(int i=0; i<pendingOrderCountList.size(); i++){
				PendingOrderCountHO curPendingOrder;
				curPendingOrder = pendingOrderCountList.get(i);
				if(curPendingOrder!=null){
					String curOrderCode = curPendingOrder.getOrderCategoryCode();
					if(curOrderCode!=null){
						if(curOrderCode.equals(PendingOrderConstants.ORDERCAT_LABORATORY)){
							labPendingOrderCountHO = curPendingOrder;
						}
						else if(curOrderCode.equals(PendingOrderConstants.ORDERCAT_RADIOLOGY)){
							radPendingOrderCountHO = curPendingOrder;
						}
						else if(curOrderCode.equals(PendingOrderConstants.ORDERCAT_OPERATIONTHEATRE)){
							otPendingOrderCountHO = curPendingOrder;
						}
						else if(curOrderCode.equals(PendingOrderConstants.ORDERCAT_DIAGNOSTICS)){
							diagPendingOrderCountHO = curPendingOrder;
						}
						else if(curOrderCode.equals(PendingOrderConstants.ORDERCAT_DIETARY)){
							dietPendingOrderCountHO = curPendingOrder;
						}
						else if(curOrderCode.equals(PendingOrderConstants.ORDERCAT_MISCELLANEOUS)){
							miscPendingOrderCountHO = curPendingOrder;
						}
						else if(curOrderCode.equals(PendingOrderConstants.ORDERCAT_MONITORING)){
							moniPendingOrderCountHO = curPendingOrder;
						}
						else if(curOrderCode.equals(PendingOrderConstants.ORDERCAT_ORALHEALTH)){
							oralPendingOrderCountHO = curPendingOrder;
						}
						else if(curOrderCode.equals(PendingOrderConstants.ORDERCAT_ORDERSET)){
							ordPendingOrderCountHO = curPendingOrder;
						}
						else if(curOrderCode.equals(PendingOrderConstants.ORDERCAT_CONSULTATION)){
							consPendingOrderCountHO = curPendingOrder;
						}
						else if(curOrderCode.equals(PendingOrderConstants.ORDERCAT_PATIENTCARE)){
							pcPendingOrderCountHO = curPendingOrder;
						}
						else if(curOrderCode.equals(PendingOrderConstants.ORDERCAT_PHARMACY)){
							pharmPendingOrderCountHO = curPendingOrder;
						}
						else if(curOrderCode.equals(PendingOrderConstants.ORDERCAT_TREATMENT)){
							treatPendingOrderCountHO = curPendingOrder;
						}
							
					}
				}
			}
			if(resp.isSuccessResponse()){
				ArrayList<PendingOrderCountHO> orderedPendingOrderCountList = new ArrayList<PendingOrderCountHO>();
				for(int i=0;i<orderArr.length;i++){
					String curOrderCode = orderArr[i];
					
					if(curOrderCode!=null){
						if(curOrderCode.equals(PendingOrderConstants.ORDERCAT_LABORATORY) && labPendingOrderCountHO!=null){
							orderedPendingOrderCountList.add(labPendingOrderCountHO);
						}
						else if(curOrderCode.equals(PendingOrderConstants.ORDERCAT_RADIOLOGY) && radPendingOrderCountHO!=null){
							orderedPendingOrderCountList.add(radPendingOrderCountHO);
						}
						else if(curOrderCode.equals(PendingOrderConstants.ORDERCAT_OPERATIONTHEATRE) && otPendingOrderCountHO!=null){
							orderedPendingOrderCountList.add(otPendingOrderCountHO);
						}
						else if(curOrderCode.equals(PendingOrderConstants.ORDERCAT_DIAGNOSTICS) && diagPendingOrderCountHO!=null){
							orderedPendingOrderCountList.add(diagPendingOrderCountHO);
						}
						else if(curOrderCode.equals(PendingOrderConstants.ORDERCAT_DIETARY) && dietPendingOrderCountHO!=null){
							orderedPendingOrderCountList.add(dietPendingOrderCountHO);
						}
						else if(curOrderCode.equals(PendingOrderConstants.ORDERCAT_MISCELLANEOUS) && miscPendingOrderCountHO!=null){
							orderedPendingOrderCountList.add(miscPendingOrderCountHO);
						}
						else if(curOrderCode.equals(PendingOrderConstants.ORDERCAT_MONITORING) && moniPendingOrderCountHO!=null ){
							orderedPendingOrderCountList.add(moniPendingOrderCountHO);
						}
						else if(curOrderCode.equals(PendingOrderConstants.ORDERCAT_ORALHEALTH) && oralPendingOrderCountHO!=null){
							orderedPendingOrderCountList.add(oralPendingOrderCountHO);
						}
						else if(curOrderCode.equals(PendingOrderConstants.ORDERCAT_ORDERSET) && ordPendingOrderCountHO!=null){
							orderedPendingOrderCountList.add(ordPendingOrderCountHO);
						}
						else if(curOrderCode.equals(PendingOrderConstants.ORDERCAT_CONSULTATION) && consPendingOrderCountHO!=null){
							orderedPendingOrderCountList.add(consPendingOrderCountHO);
						}
						else if(curOrderCode.equals(PendingOrderConstants.ORDERCAT_PATIENTCARE) && pcPendingOrderCountHO!=null){
							orderedPendingOrderCountList.add(pcPendingOrderCountHO);
						}
						else if(curOrderCode.equals(PendingOrderConstants.ORDERCAT_PHARMACY) && pharmPendingOrderCountHO!=null){
							orderedPendingOrderCountList.add(pharmPendingOrderCountHO);
						}
						else if(curOrderCode.equals(PendingOrderConstants.ORDERCAT_TREATMENT) && treatPendingOrderCountHO!=null){
							orderedPendingOrderCountList.add(treatPendingOrderCountHO);
						}
							
					}
				}
				
				if(!orderedPendingOrderCountList.isEmpty()){
					resp.setPendingOrderCountList(orderedPendingOrderCountList);
				}
			}
		}

		return resp;
	}
	public PendingOrderFormatResponse getOrderFormatDetail(PatContext rPatContext, String order_id){
		PendingOrderFormatResponse resp = new PendingOrderFormatResponse();
		PendingOrderDAO dao = new PendingOrderDAOImpl();
		resp = dao.getOrderFormatDetail(rPatContext, order_id);
		return resp;
	}
	public PendingOrderFormatResponse getOrderFormatLineDetail(PatContext rPatContext, String order_id, String line_id, String called_from){
		PendingOrderFormatResponse resp = new PendingOrderFormatResponse();
		PendingOrderDAO dao = new PendingOrderDAOImpl();
		resp = dao.getOrderFormatLineDetail(rPatContext, order_id, line_id, called_from);
		return resp;
	}
	
}
