/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.result.viewtestresultreport.request;

import portal.common.request.BaseRequest;

/**
 * This class is used as a request for Test Report service 
 *  
 * @author vkodancha
 */
public class TestReportRequest extends BaseRequest {
	
	// instance variable
	private String orderId;
	private String resultType;
	private String order;

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the resultType
	 */
	public String getResultType() {
		return resultType;
	}

	/**
	 * @return the order
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * @param resultType the resultType to set
	 */
	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(String order) {
		this.order = order;
	}
	/**
	 * This method is used for logging purpose
	 */
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(" orderId :"+orderId);
		sb.append(" resultType :"+resultType);
		sb.append(" order :"+order);
		sb.append(" patientId :"+getPatientId());
		sb.append(" portalusername :"+getPortalUserName());
		return sb.toString();
	}
}
