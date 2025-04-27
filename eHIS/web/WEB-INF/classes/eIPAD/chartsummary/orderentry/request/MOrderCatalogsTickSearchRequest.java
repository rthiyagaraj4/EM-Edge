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
public class MOrderCatalogsTickSearchRequest extends GenericRequest {

	private OrderEntryBean orderEntryBean;
	private String orderCategory;
	private String orderType;
	private String orderNature;
	private String tickSheetId;
	private String sectionCode;
	/**
	 * @return the orderEntryBean
	 */
	public OrderEntryBean getOrderEntryBean() {
		return orderEntryBean;
	}
	/**
	 * @param orderEntryBean the orderEntryBean to set
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
	/**
	 * @return the sectionCode
	 */
	public String getSectionCode() {
		return sectionCode;
	}
	/**
	 * @param sectionCode the sectionCode to set
	 */
	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}
	/**
	 * @return the tickSheetId
	 */
	public String getTickSheetId() {
		return tickSheetId;
	}
	/**
	 * @param tickSheetId the tickSheetId to set
	 */
	public void setTickSheetId(String tickSheetId) {
		this.tickSheetId = tickSheetId;
	}
	

}
