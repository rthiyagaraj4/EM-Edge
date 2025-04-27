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
package eIP.advbedmgmt.transaction.floorlayout.request;


/**
 * @author gramamoorthy
 * This is the request class to get bed status
 */
public class BedStatusRequest extends BasicBedRequest {
	
	private int bedCount = 0;

	/**
	 * @return the bedCount
	 */
	public int getBedCount() {
		return bedCount;
	}

	/**
	 * @param bedCount the bedCount to set
	 */
	public void setBedCount(int bedCount) {
		this.bedCount = bedCount;
	}
	
	
}
