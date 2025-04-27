/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eIPAD.chartsummary.vitals.healthobject;

public class NormalcyIndicator implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String legendType;
	private String colorCellIndicator;
	private String normalcyIndicator;
	private String symbolIndicator;
	private String highValueDescription;
	private String lowValueDescription;
	private String criticalHighDescription;
	private String criticalLowDescription;
	
	
	/**
	 * @return the legendType 
	 */
	public String getLegendType() {
		return legendType;
	}
	/**
	 * @param legendType the legendType to set
	 */
	public void setLegendType(String legendType) {
		this.legendType = legendType;
	}
	/**
	 * @return the colorCellIndicator
	 */
	public String getColorCellIndicator() {
		return colorCellIndicator;
	}
	/**
	 * @param colorCellIndicator the colorCellIndicator to set
	 */
	public void setColorCellIndicator(String colorCellIndicator) {
		this.colorCellIndicator = colorCellIndicator;
	}
	/**
	 * @return the normalcyIndicator
	 */
	public String getNormalcyIndicator() {
		return normalcyIndicator;
	}
	/**
	 * @param normalcyIndicator the normalcyIndicator to set
	 */
	public void setNormalcyIndicator(String normalcyIndicator) {
		this.normalcyIndicator = normalcyIndicator;
	}
	/**
	 * @return the symbolIndicator
	 */
	public String getSymbolIndicator() {
		return symbolIndicator;
	}
	/**
	 * @param symbolIndicator the symbolIndicator to set
	 */
	public void setSymbolIndicator(String symbolIndicator) {
		this.symbolIndicator = symbolIndicator;
	}
	/**
	 * @return the highValueDescription
	 */
	public String getHighValueDescription() {
		return highValueDescription;
	}
	/**
	 * @param highValueDescription the highValueDescription to set
	 */
	public void setHighValueDescription(String highValueDescription) {
		this.highValueDescription = highValueDescription;
	}
	/**
	 * @return the lowValueDescription
	 */
	public String getLowValueDescription() {
		return lowValueDescription;
	}
	/**
	 * @param lowValueDescription the lowValueDescription to set
	 */
	public void setLowValueDescription(String lowValueDescription) {
		this.lowValueDescription = lowValueDescription;
	}
	/**
	 * @return the criticalHighDescription
	 */
	public String getCriticalHighDescription() {
		return criticalHighDescription;
	}
	/**
	 * @param criticalHighDescription the criticalHighDescription to set
	 */
	public void setCriticalHighDescription(String criticalHighDescription) {
		this.criticalHighDescription = criticalHighDescription;
	}
	/**
	 * @return the criticalLowDescription
	 */
	public String getCriticalLowDescription() {
		return criticalLowDescription;
	}
	/**
	 * @param criticalLowDescription the criticalLowDescription to set
	 */
	public void setCriticalLowDescription(String criticalLowDescription) {
		this.criticalLowDescription = criticalLowDescription;
	}
}
