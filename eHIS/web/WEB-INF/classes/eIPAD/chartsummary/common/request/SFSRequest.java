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
package eIPAD.chartsummary.common.request;
import eIPAD.chartsummary.common.healthobject.*;
/**
 * @author GaneshkumarC
 *
 */
public abstract class SFSRequest extends GenericRequest {
	 private String searhcBy;
	 private String searchCriteria;
	 private int sfsType = 0;
	 private String locale = "en";
	 private boolean bDuplicateValues = false;
	/**
	 * @return the searhcBy
	 */
	public String getSearhcBy() {
		return searhcBy;
	}
	/**
	 * @param searhcBy the searhcBy to set
	 */
	public void setSearhcBy(String searhcBy) {
		this.searhcBy = searhcBy;
	}
	/**
	 * @return the searchCriteria
	 */
	public String getSearchCriteria() {
		return searchCriteria;
	}
	/**
	 * @param searchCriteria the searchCriteria to set
	 */
	public void setSearchCriteria(String searchCriteria) {
		this.searchCriteria = searchCriteria;
	}
	/**
	 * @return the sfsType
	 */
	public int getSfsType() {
		return sfsType;
	}
	/**
	 * @param sfsType the sfsType to set
	 */
	public void setSfsType(int sfsType) {
		this.sfsType = sfsType;
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
	
	public abstract SfsQuery getQuery();
	/**
	 * @return the bDuplicateValues
	 */
	public boolean isbDuplicateValues() {
		return bDuplicateValues;
	}
	/**
	 * @param bDuplicateValues the bDuplicateValues to set
	 */
	public void setbDuplicateValues(boolean bDuplicateValues) {
		this.bDuplicateValues = bDuplicateValues;
	}
	 
}
