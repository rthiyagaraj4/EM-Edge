/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.result.viewtestresultreport.response;

/**
 * This class is used in Test Report Response
 * 
 * @author vkodancha
 * 
 */
public class TestReport {

	private String order;
	private String orderNo;
	private String orderDateandTime;
	private String resultType;

	/**
	 * @return the order
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * @return the orderNo
	 */
	public String getOrderNo() {
		return orderNo;
	}

	/**
	 * @return the orderDateandTime
	 */
	public String getOrderDateandTime() {
		return orderDateandTime;
	}

	/**
	 * @return the resultType
	 */
	public String getResultType() {
		return resultType;
	}

	/**
	 * @param order
	 *            the order to set
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * @param orderNo
	 *            the orderNo to set
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * @param orderDateandTime
	 *            the orderDateandTime to set
	 */
	public void setOrderDateandTime(String orderDateandTime) {
		this.orderDateandTime = orderDateandTime;
	}

	/**
	 * @param resultType
	 *            the resultType to set
	 */
	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	/**
	 * This method is over ridden to display the actual values in logs
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("order :"+order+"  ");
		sb.append("orderNo :"+orderNo+"  ");
		sb.append("orderDateandTime :"+orderDateandTime+"  ");
		sb.append("resultType :"+resultType+" ");
		return sb.toString();
	}
}
