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
package eIPAD.chartsummary.orderentry.request;

import eIPAD.chartsummary.common.request.GenericRequest;
import eOR.OrderEntryBean;

/**
 * @author SaraswathiR
 *
 */
public class MOrderCatalogsSearchRequest extends GenericRequest {

	private OrderEntryBean orderEntryBean;
	private String orderCategory;
	private String orderType;
	private String searchText;
	private String orderNature;
	/**
	 * @return the orderEntryBean
	 */
	public OrderEntryBean getOrderEntryBean() {
		return orderEntryBean;
	}

	/**
	 */
	public void setOrderEntryBean(OrderEntryBean orderEntryBean) {
		this.orderEntryBean = orderEntryBean;
	}

	/**
	 * @return the orderCategory
	 */
	public String getOrderCategory() {
		return orderCategory;
	}

	/**
	 * @param orderCategory the orderCategory to set
	 */
	public void setOrderCategory(String orderCategory) {
		this.orderCategory = orderCategory;
	}

	/**
	 * @return the orderType
	 */
	public String getOrderType() {
		return orderType;
	}

	/**
	 * @param orderType the orderType to set
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	/**
	 * @return the searchText
	 */
	public String getSearchText() {
		return searchText;
	}

	/**
	 * @param searchText the searchText to set
	 */
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	/**
	 * @return the orderNature
	 */
	public String getOrderNature() {
		return orderNature;
	}

	/**
	 * @param orderNature the orderNature to set
	 */
	public void setOrderNature(String orderNature) {
		this.orderNature = orderNature;
	}
}
