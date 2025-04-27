/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.selectorder.response;

import java.util.List;
import eIPAD.selectorder.healthobject.OrderTypeHO;


public class OrderTypeResponse {
	
	private List<OrderTypeHO> lstOrderType;

	/**
	 * @return the lstOrderType
	 */
	public List<OrderTypeHO> getLstOrderType() {
		return lstOrderType;
	}

	/**
	 * @param lstOrderType the lstOrderType to set
	 */
	public void setLstOrderType(List<OrderTypeHO> lstOrderType) {
		this.lstOrderType = lstOrderType;
	}
	
	

}
