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
 * This is the model class to represent a basic bed
 * contains only bed number and bed status
 * This class should be extended by a specific class
 * which will contain more info like bed dimensions etc
 * @author GRamamoorthy
 *
 */
public class BasicBed {

	/**
	 * Data members in class
	 */
	protected BedStatusEnum bedStatus = null;
	
	protected String bedNumber = null;

	/**
	 * @return the bedStatus
	 */
	public BedStatusEnum getBedStatus() {
		return bedStatus;
	}

	/**
	 * @param bedStatus the bedStatus to set
	 */
	public void setBedStatus(BedStatusEnum bedStatus) {
		this.bedStatus = bedStatus;
	}

	/**
	 * @return the bedNumber
	 */
	public String getBedNumber() {
		return bedNumber;
	}

	/**
	 * @param bedNumber the bedNumber to set
	 */
	public void setBedNumber(String bedNumber) {
		this.bedNumber = bedNumber;
	}
	
}
