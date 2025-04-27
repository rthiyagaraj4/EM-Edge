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
package eIPAD.chartsummary.orderentry.response;

import eIPAD.chartsummary.common.response.GenericResponse;

/**
 * @author saraswathir
 *
 */
public class MOrderCatalogCountResponse extends GenericResponse {
	private int panelCount = 0;
	private int orderSetCount = 0;
	private int individualCount = 0;
	/**
	 * @return the panelCount
	 */
	public int getPanelCount() {
		return panelCount;
	}
	/**
	 * @param panelCount the panelCount to set
	 */
	public void setPanelCount(int panelCount) {
		this.panelCount = panelCount;
	}
	/**
	 * @return the orderSetCount
	 */
	public int getOrderSetCount() {
		return orderSetCount;
	}
	/**
	 * @param orderSetCount the orderSetCount to set
	 */
	public void setOrderSetCount(int orderSetCount) {
		this.orderSetCount = orderSetCount;
	}
	/**
	 * @return the individualCount
	 */
	public int getIndividualCount() {
		return individualCount;
	}
	/**
	 * @param individualCount the individualCount to set
	 */
	public void setIndividualCount(int individualCount) {
		this.individualCount = individualCount;
	}
}
