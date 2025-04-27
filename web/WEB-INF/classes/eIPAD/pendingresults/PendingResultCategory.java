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
package eIPAD.pendingresults;

import java.io.Serializable;

/**
 * This class represents one category of pending results for review
 * like "Abnormal","Critical", "Normal" and "All"
 * @author GRamamoorthy
 *
 */
public class PendingResultCategory implements Serializable {

	/**
	 * Constant to denote the "All" category
	 */
	public static final String TOTAL_CATEGORY = "TOTAL";
	
	/**
	 * Constant to denote the "Abnormal" category
	 */
	public static final String ABNORMAL_CATEGORY = "ABNORMAL";
	
	/**
	 * Constant to denote the "Critical" category
	 */
	public static final String CRITICAL_CATEOGORY = "CRITICAL";
	
	/**
	 * Constant to denote the "Normal" category
	 */
	public static final String NORMAL_CATEGORY = "NORMAL";
	
	/**
	 * Stores the category name
	 */
	private String categoryName = null;
	
	/**
	 * default constructor of the class
	 */
	public PendingResultCategory() {
	}
	
	/**
	 * @param categoryName
	 */
	public PendingResultCategory(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * overridden to specify custom behavior
	 * two objects are equal if the category name is equal
	 */
	public boolean equals(Object obj) {
		boolean equals = false;
		
		if(!(obj instanceof PendingResultCategory)){
			return equals;
		}
		// equality check is done
		String tempCategoryName = ((PendingResultCategory)obj).getCategoryName();
		if(tempCategoryName != null && tempCategoryName.equals(this.categoryName)){
			equals = true;
		}
		
		return equals;
	}

}
