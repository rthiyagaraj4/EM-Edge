/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.pendingorders.dao;
import eIPAD.chartsummary.common.healthobject.PatContext;
import  eIPAD.chartsummary.pendingorders.request.*;
import  eIPAD.chartsummary.pendingorders.response.*;
public interface PendingOrderDAO { 
	public PendingOrderResponse getPendingOrdersDetails(PendingOrderRequest oPendingOrderReq);
	public PendingOrderCountResponse getPendingOrderItemsCount(PatContext rPatContext);
	public PendingOrderFormatResponse getOrderFormatDetail(PatContext rPatContext, String order_id);
	public PendingOrderFormatResponse getOrderFormatLineDetail(PatContext rPatContext, String order_id, String line_id, String called_from);
	
}
