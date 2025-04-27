/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.login.request;

import portal.common.request.BaseRequest;

/**
 * Request object for login
 * 
 * @author skrishnared2
 *
 */
public class LoginRequest extends BaseRequest {
	
	private String dateOfBirth;
	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * over ridden for logging purpose
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString());
		sb.append("dateOfBirth : "+dateOfBirth);
		return sb.toString();
	}

}
