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
 * This is the bean class for the result category
 * used in the pending results for review
 * @author GRamamoorthy
 *
 */
public class ResultCategory implements Serializable {

	/**
	 * Stores the category
	 */
	private String category = null;
	
	
	/**
	 * Default constructor of the class
	 */
	public ResultCategory() {
	}


	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}


	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}


	/**
	 * 
	 */
	public int hashCode() {
		int hash = 100;
		if(category != null){
			hash = 20 * hash;
		}
		return hash;
	}


	/**
	 * Two ResultCategory objects are equal
	 * if the category string is equal
	 */
	public boolean equals(Object obj) {
		boolean equals = false;
		if(!(obj instanceof ResultCategory)){
			return equals;
		}
		
		String tempCategory = ((ResultCategory)obj).getCategory();
		if(tempCategory != null && tempCategory.equals(this.category)){
			equals = true;
		}
		
		return equals;
	}

}
