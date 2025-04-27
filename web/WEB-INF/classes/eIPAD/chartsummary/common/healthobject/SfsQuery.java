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
package eIPAD.chartsummary.common.healthobject;

/**
 * @author GaneshkumarC 
 *
 */
public class SfsQuery {
	private String sfsQuery;
	private String locale = "en";

	/**
	 * @return the sfsQuery
	 */
	public String getSfsQuery() {
		return sfsQuery;
	}

	/**
	 * @param sfsQuery the sfsQuery to set
	 */
	public void setSfsQuery(String sfsQuery) {
		this.sfsQuery = sfsQuery;
	}

	/**
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * @param locale the locale to set
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}
	
}
