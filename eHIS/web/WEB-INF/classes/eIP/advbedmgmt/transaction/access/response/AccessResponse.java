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
package eIP.advbedmgmt.transaction.access.response;

import eIP.advbedmgmt.common.response.BaseResponse;

/**
 * This is the response class for getting access rights for CRUD
 * operations in bed manager GUI
 * @author GRamamoorthy
 *
 */
public class AccessResponse extends BaseResponse{

	private String access = null;

	/**
	 * @return the access
	 */
	public String getAccess() {
		return access;
	}

	/**
	 * @param access the access to set
	 */
	public void setAccess(String access) {
		this.access = access;
	}	


}
