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
package eIP.advbedmgmt.common.bedcolor.request;

/**
 * This class is the request class for getting bed color from
 * the bed color lookup
 * @author GRamamoorthy
 *
 */
public class BedColorRequest {

	private String bedStatus = null;

	/**
	 * @return the bedStatus
	 */
	public String getBedStatus() {
		return bedStatus;
	}

	/**
	 * @param bedStatus the bedStatus to set
	 */
	public void setBedStatus(String bedStatus) {
		this.bedStatus = bedStatus;
	}
	
	
	
}
