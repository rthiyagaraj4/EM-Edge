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
package eIP.advbedmgmt.common.bedlegend.request;

import eIP.advbedmgmt.common.request.BaseRequest;

/**
 * This is the request class for getting bed legends
 * @author GRamamoorthy
 *
 */
public class BedLegendRequest extends BaseRequest {

	/**
	 * Stores the bed identifier like bed number
	 */
	private String bedIdentifier = null;

	/**
	 * @return the bedIdentifier
	 */
	public String getBedIdentifier() {
		return bedIdentifier;
	}

	/**
	 * @param bedIdentifier the bedIdentifier to set
	 */
	public void setBedIdentifier(String bedIdentifier) {
		this.bedIdentifier = bedIdentifier;
	}
	
}
