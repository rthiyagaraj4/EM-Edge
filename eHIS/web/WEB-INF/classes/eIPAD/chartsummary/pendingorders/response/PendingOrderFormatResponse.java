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
package eIPAD.chartsummary.pendingorders.response;

import java.util.List;

import eIPAD.chartsummary.common.response.GenericResponse;

/**
 * @author SaraswathiR 
 *
 */
public class PendingOrderFormatResponse extends GenericResponse {
	List<String[]> orderFormatDtl;

	/**
	 * @return the orderFormatDtl
	 */
	public List<String[]> getOrderFormatDtl() {
		return orderFormatDtl;
	}

	/**
	 * @param orderFormatDtl the orderFormatDtl to set
	 */
	public void setOrderFormatDtl(List<String[]> orderFormatDtl) {
		this.orderFormatDtl = orderFormatDtl;
	}
}
