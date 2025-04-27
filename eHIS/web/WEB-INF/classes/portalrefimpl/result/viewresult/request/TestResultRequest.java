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
package portalrefimpl.result.viewresult.request;

import portalrefimpl.common.request.BaseRequest;

/**
 * @author GRamamoorthy
 *
 */
public class TestResultRequest extends BaseRequest {

	private String orderNumber = null;
	
	private String order = null;
	
	private String resultType = null;

	/**
	 * @return the orderNumber
	 */
	public String getOrderNumber() {
		return orderNumber;
	}

	/**
	 * @param orderNumber the orderNumber to set
	 */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * @return the order
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * @return the resultType
	 */
	public String getResultType() {
		return resultType;
	}

	/**
	 * @param resultType the resultType to set
	 */
	public void setResultType(String resultType) {
		this.resultType = resultType;
	}
	
}
