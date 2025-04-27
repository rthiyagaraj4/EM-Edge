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
package eIPAD.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author GRamamoorthy
 *
 */
public class IndicatorDetailResponse implements Serializable {

	/**
	 * Stores the complete indicator value as one string
	 */
	private String indicatorValue = null;
	
	/**
	 * Stores the delimiter
	 */
	private String delimiter = null;
	
	/**
	 * Stores the list of indicators
	 */
	private List<String> indicatorValueList = new ArrayList<String>();
	
	/**
	 * Default constructor of the class
	 */
	public IndicatorDetailResponse() {
	}

	
	/**
	 * @return the indicatorValueList
	 */
	public List<String> getIndicatorValueList() {
		return indicatorValueList;
	}

	/**
	 * @param indicatorValueList the indicatorValueList to set
	 */
	public void setIndicatorValueList(List<String> indicatorValueList) {
		this.indicatorValueList = indicatorValueList;
	}


	/**
	 * @return the indicatorValue
	 */
	public String getIndicatorValue() {
		return indicatorValue;
	}


	/**
	 * @param indicatorValue the indicatorValue to set
	 */
	public void setIndicatorValue(String indicatorValue) {
		this.indicatorValue = indicatorValue;
	}
	
	/**
	 * 
	 */
	public void populateIndicatorList(){
		// safe check
		if(this.indicatorValue == null || this.indicatorValue.trim().equals("")){
			return;
		}
		
		StringTokenizer tokens = new StringTokenizer(indicatorValue,delimiter);
		while(tokens.hasMoreTokens()){
			indicatorValueList.add(tokens.nextToken());
		}
		
	}


	/**
	 * @return the delimiter
	 */
	public String getDelimiter() {
		return delimiter;
	}


	/**
	 * @param delimiter the delimiter to set
	 */
	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}

}
