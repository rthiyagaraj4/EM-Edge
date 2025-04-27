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
package portal.common.request;


/**
 * This class defines portal application username which is passed for all
 * the services as a mandarory parameter. BaseRequest class will extend 
 * this class
 * 
 * @author GRamamoorthy
 *
 */
public class ValidationRequest {

	private String portalUserName;

	/**
	 * @return the portalUserName
	 */
	public String getPortalUserName() {
		return portalUserName;
	}

	/**
	 * @param portalUserName the portalUserName to set
	 */
	public void setPortalUserName(String portalUserName) {
		this.portalUserName = portalUserName;
	}
}
