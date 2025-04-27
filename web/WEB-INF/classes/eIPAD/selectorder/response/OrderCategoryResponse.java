/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.selectorder.response;

import java.util.* ;
import eIPAD.selectorder.healthobject.*;

public class OrderCategoryResponse implements java.io.Serializable{
	private List<OrderCategoryHO> lstOrderCategory;

	/**
	 * @return the lstOrderCategory
	 */
	public List<OrderCategoryHO> getLstOrderCategory() {
		return lstOrderCategory;
	}

	/**
	 * @param lstOrderCategory the lstOrderCategory to set
	 */
	public void setLstOrderCategory(List<OrderCategoryHO> lstOrderCategory) {
		this.lstOrderCategory = lstOrderCategory;
	}
}
