/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.results.request;

import java.util.ArrayList;

import eIPAD.chartsummary.common.request.GenericRequest;

/**
 * @author SaraswathiR 
 *
 */


public class ResultsRequest extends GenericRequest {

	private ArrayList<String> categories = new ArrayList<String>();
	private String resultsType = ResultsCatConstants.RESULTDATATYPE_ALL ;
	/**
	 * @return the categories
	 */
	public ArrayList<String> getCategories() {
		return categories;
	}

	/**
	 * @param categories the categories to set
	 */
	public void setCategories(ArrayList<String> categories) {
		this.categories = categories;
	}

	/**
	 * @return the resultsType
	 */
	public String getResultsType() {
		return resultsType;
	}

	/**
	 * @param resultsType the resultsType to set
	 */
	public void setResultsType(String resultsType) {
		this.resultsType = resultsType;
	}
	
}
