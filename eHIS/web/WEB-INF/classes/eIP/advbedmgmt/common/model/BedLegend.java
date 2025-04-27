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
package eIP.advbedmgmt.common.model;

import eIP.advbedmgmt.common.bedlegend.BedLegendConstants;
import eIP.advbedmgmt.common.resourcebundle.BundleManager;

/**
 * This is the model class for bed legend
 * @author GRamamoorthy
 *
 */
public class BedLegend {
	
	/**
	 * Data members in the class
	 */
	private BedStatusEnum legendIdentifier = null;
	
	private String legendColor = null;
	
	private String legendDescription = null;
	
	private String textColor = null; 
	
	/**
	 * default constructor
	 */
	public BedLegend(){
		// does nothing
	}
	
	/**
	 * Constructor taking legend identifier and legend color
	 * @param legendIdentifier
	 * @param legendColor
	 * @param textColor 
	 */
	public BedLegend(BedStatusEnum legendIdentifier, String legendColor,
			String textColor) {
		setLegendIdentifier(legendIdentifier);
		setLegendColor(legendColor);
		setTextColor(textColor);
	}
	
	/**
	 * 
	 * @param legendIdentifier
	 */
	public BedLegend(BedStatusEnum legendIdentifier){
		setLegendIdentifier(legendIdentifier);
	}
	

	/**
	 * @return the legendIdentifier
	 */
	public BedStatusEnum getLegendIdentifier() {
		return legendIdentifier;
	}

	/**
	 * @param legendIdentifier the legendIdentifier to set
	 */
	public void setLegendIdentifier(BedStatusEnum legendIdentifier) {
		this.legendIdentifier = legendIdentifier;
		calculateLegendDescription();
	}

	/**
	 * @return the legendColor
	 */
	public String getLegendColor() {
		return legendColor;
	}

	/**
	 * @param legendColor the legendColor to set
	 */
	public void setLegendColor(String legendColor) {
		this.legendColor = legendColor;
	}

	/**
	 * @return the legendDescription
	 */
	public String getLegendDescription() {
		return legendDescription;
	}

	/**
	 * @param legendDescription the legendDescription to set
	 */
	public void setLegendDescription(String legendDescription) {
		this.legendDescription = legendDescription;
	}
	
	/**
	 * This method calculates the legend description
	 */
	private void calculateLegendDescription(){
		if(this.legendIdentifier != null){
			String legendDesc = null;
			try {
				legendDesc = BundleManager
						.getInstance()
						.getMessageFromResourceBundle(
								this.legendIdentifier.toString(),
								BedLegendConstants.BEDLEGEND_LABELS_RESOURCE_CLASSNAME);
			} catch (Exception e) {
				// cannot do much
			}
			setLegendDescription(legendDesc);
		}
	}

	/**
	 * @return the textColor
	 */
	public String getTextColor() {
		return textColor;
	}

	/**
	 * @param textColor the textColor to set
	 */
	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}

	/**
	 * overriding hashcode()
	 */
	public int hashCode() {
		return super.hashCode();
	}

	/**
	 * overriding equals()
	 * two bedlegend objects are equal if the legend identifier
	 * is equal
	 */
	public boolean equals(Object obj) {
		boolean equals = false;
		
		if(!(obj instanceof BedLegend)){
			return equals;
		}
		
		BedLegend tempLegend = (BedLegend)obj;
		BedStatusEnum tempLegendIdentifier = tempLegend.getLegendIdentifier();
		
		if(legendIdentifier != null && legendIdentifier.equals(tempLegendIdentifier)){
			equals = true;
		}
		
		return equals;
	}
	
	
}
