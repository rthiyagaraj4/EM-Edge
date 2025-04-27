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
 * This is the request class for getting bed icon status for beds
 * in a nursing unit
 * @author GRamamoorthy
 *
 */
public class BedIconRequest extends BasicBedRequest {

	private String blOperational = null;
	

	/**
	 * @return the blOperational
	 */
	public String getBlOperational() {
		return blOperational;
	}

	/**
	 * @param blOperational the blOperational to set
	 */
	public void setBlOperational(String blOperational) {
		this.blOperational = blOperational;
	}
	
	
	
}
