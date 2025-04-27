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
package eIPAD.chartsummary.pendingorders.healthobject;

/**
 * @author SaraswathiR 
 *
 */
public class PendingOrderCountHO {
	private String orderCategoryCode;
	private String orderCategoryDesc;
	private int orderCount;
	/**
	 * @return the orderCategoryCode
	 */
	public String getOrderCategoryCode() {
		return orderCategoryCode;
	}
	/**
	 * @param orderCategoryCode the orderCategoryCode to set
	 */
	public void setOrderCategoryCode(String orderCategoryCode) {
		this.orderCategoryCode = orderCategoryCode;
	}
	/**
	 * @return the orderCategoryDesc
	 */
	public String getOrderCategoryDesc() {
		return orderCategoryDesc;
	}
	/**
	 * @param orderCategoryDesc the orderCategoryDesc to set
	 */
	public void setOrderCategoryDesc(String orderCategoryDesc) {
		this.orderCategoryDesc = orderCategoryDesc;
	}
	/**
	 * @return the orderCount
	 */
	public int getOrderCount() {
		return orderCount;
	}
	/**
	 * @param orderCount the orderCount to set
	 */
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	
	
}
