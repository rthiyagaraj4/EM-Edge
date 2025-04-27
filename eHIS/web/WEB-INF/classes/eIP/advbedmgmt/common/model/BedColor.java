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

/**
 * This is the model class to represent bed color
 * @author GRamamoorthy
 *
 */
public class BedColor {

	private String color = null;
	
	private BedStatusEnum status = null;

	private String bedTextColor = null;
	/**
	 * Default constructor
	 */
	public BedColor(){
		// does nothing
	}
	
	/**
	 * @param status
	 */
	public BedColor(BedStatusEnum status) {
		this.status = status;
	}

	/**
	 * @param color
	 * @param bedStatus
	 *@param bedTextColor
	 */
	public BedColor(String color, BedStatusEnum bedStatus,String bedTextColor) {
		this.color = color;
		this.status = bedStatus;
		this.bedTextColor = bedTextColor;
	}
	
	public void setBedTextColor(String bedTextColor){
		this.bedTextColor = bedTextColor;
	}
	
	public String getBedTextColor() {
		return bedTextColor;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the status
	 */
	public BedStatusEnum getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(BedStatusEnum status) {
		this.status = status;
	}

	/**
	 * overriding hashcode
	 */
	public int hashCode() {
		return super.hashCode();
	}

	/**
	 * Overriding equals
	 * Two BedColor instances are equal if their bed status is same 
	 */
	public boolean equals(Object obj) {
		boolean equals = false;
		if(!(obj instanceof BedColor)){
			return equals;
		}
		
		BedColor tempInst = (BedColor)obj;
		BedStatusEnum tempStatus = tempInst.getStatus();
		if(this.status != null && this.status.equals(tempStatus)){
			equals = true;
		}
		
		return equals;
	}
	
}
