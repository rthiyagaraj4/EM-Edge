/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package portal.homepage.model;

import portal.common.model.Person;

/**
 * This class contains the care provider attributes.
 * @author skrishnared2
 *
 */
public class CareProvider extends Person {
	private String careProviderId; 
	private String specialityId;
	/**
	 * @return the careProviderId
	 */
	public String getCareProviderId() {
		return careProviderId;
	}
	/**
	 * @return the specialityId
	 */
	public String getSpecialityId() {
		return specialityId;
	}
	/**
	 * @param careProviderId the careProviderId to set
	 */
	public void setCareProviderId(String careProviderId) {
		this.careProviderId = careProviderId;
	}
	/**
	 * @param specialityId the specialityId to set
	 */
	public void setSpecialityId(String specialityId) {
		this.specialityId = specialityId;
	}
}
