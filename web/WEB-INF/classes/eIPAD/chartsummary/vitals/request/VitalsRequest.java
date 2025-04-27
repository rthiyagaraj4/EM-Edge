/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.vitals.request;
import eIPAD.chartsummary.common.request.GenericRequest;

public class VitalsRequest extends GenericRequest{

	private boolean isRankRequired;
	private String chartId;
	private String fromScreen;
	private String filterByEventCode;
	/**
	 * @return the isRankRequired 
	 */
	public boolean isRankRequired() {
		return isRankRequired;
	}
	/**
	 * @param isRankRequired the isRankRequired to set
	 */
	public void setRankRequired(boolean isRankRequired) {
		this.isRankRequired = isRankRequired;
	}
	/**
	 * @return the chartId
	 */
	public String getChartId() {
		return chartId;
	}
	/**
	 * @param chartId the chartId to set
	 */
	public void setChartId(String chartId) {
		this.chartId = chartId;
	}
	/**
	 * @return the fromScreen
	 */
	public String getFromScreen() {
		return fromScreen;
	}
	/**
	 * Used in BC to call the respective daoimpl
	 */
	public void setFromScreen(String fromScreen) {
		this.fromScreen = fromScreen;
	}
	/**
	 * @return the filterByEventCode
	 */
	public String getFilterByEventCode() {
		return filterByEventCode;
	}
	/**
	 * @param filterByEventCode the filterByEventCode to set
	 */
	public void setFilterByEventCode(String filterByEventCode) {
		this.filterByEventCode = filterByEventCode;
	}
	
	
}
