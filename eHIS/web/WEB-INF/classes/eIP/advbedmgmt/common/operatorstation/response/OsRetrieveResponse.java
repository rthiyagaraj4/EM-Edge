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
package eIP.advbedmgmt.common.operatorstation.response;

import eIP.advbedmgmt.common.response.BaseResponse;

/**
 * This class has the response for retrieve operator station 
 * operation
 * @author GRamamoorthy
 *
 */
public class OsRetrieveResponse extends BaseResponse {

	/**
	 * Data member in the class
	 */
	private String osId = null;

	/**
	 * @return the osId
	 */
	public String getOsId() {
		return osId;
	}

	/**
	 * @param osId the osId to set
	 */
	public void setOsId(String osId) {
		this.osId = osId;
	}
	
}
