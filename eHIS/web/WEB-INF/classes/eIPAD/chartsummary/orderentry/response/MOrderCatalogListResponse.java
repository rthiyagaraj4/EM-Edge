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

import java.util.ArrayList;

import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.common.response.Errors;
import eIPAD.chartsummary.common.response.GenericResponse;
import eIPAD.chartsummary.orderentry.healthobject.MOrderCatalogHO;

/**
 * @author SaraswathiR
 *
 */
public class MOrderCatalogListResponse extends GenericResponse {

	ArrayList<MOrderCatalogHO> OrderCatalogList = new ArrayList<MOrderCatalogHO>();

	/**
	 * @return the orderCatalogList
	 */
	public ArrayList<MOrderCatalogHO> getOrderCatalogList() {
		return OrderCatalogList;
	}

	/**
	 * @param orderCatalogList the orderCatalogList to set
	 */
	public void setOrderCatalogList(ArrayList<MOrderCatalogHO> orderCatalogList) {
		OrderCatalogList = orderCatalogList;
	}
	

}
